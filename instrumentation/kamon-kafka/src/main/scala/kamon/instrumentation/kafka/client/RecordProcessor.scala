package kamon.instrumentation.kafka.client

import java.time.Instant
import java.util.Optional

import kamon.Kamon
import kamon.context.Context
import kamon.instrumentation.kafka.client.ConsumedRecordData.ConsumerInfo
import org.apache.kafka.clients.consumer.ConsumerRecords

private[kafka] object RecordProcessor {

  import scala.collection.JavaConverters._

  /**
   * Produces poll span (`operation=poll`) per each poll invocation which is then linked to per-record spans.
   * For each polled record a new consumer span (`operation=consumed-record`) is created as a child or
   * linked to it's bundled span (if any is present). Context (either new or inbound) containing consumer
   * span is then propagated with the record via `HasContext` mixin
   */
  def process[V, K](startTime: Instant, clientId: String, groupId: AnyRef, records: ConsumerRecords[K, V]): ConsumerRecords[K, V] = {

    if (!records.isEmpty) {
      val consumerInfo = ConsumerInfo(resolve(groupId), clientId)

      records.iterator().asScala.foreach(record => {
        val header = Option(record.headers.lastHeader(KafkaInstrumentation.Keys.ContextHeader))

        val incomingContext = header.map { h =>
          ContextSerializationHelper.fromByteArray(h.value())
        }.getOrElse(Context.Empty)

        record.asInstanceOf[ConsumedRecordData].set(
          incomingContext,
          Kamon.clock().nanosSince(startTime),
          consumerInfo
        )
      })
    }

    records
  }

  /**
    * In order to be backward compatible we need check the groupId field.
    *
    * KafkaConsumer which versions < 2.5 relies on internal groupId: String and and higher versions in Optional[String].
    */
  private def resolve(groupId: AnyRef): Option[String] = groupId match {
      case opt: Optional[String] => if (opt.isPresent) Some(opt.get()) else None
      case value: String => Option(value)
    }
}
