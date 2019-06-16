/*
 *  ==========================================================================================
 *  Copyright © 2013-2019 The Kamon Project <https://kamon.io/>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 *  except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the
 *  License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *  either express or implied. See the License for the specific language governing permissions
 *  and limitations under the License.
 *  ==========================================================================================
 */

package kamon.context.generated.binary.context;


// Code generated by colf(1); DO NOT EDIT.


import static java.lang.String.format;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;


/**
 * Data bean with built-in serialization support.

 * @author generated by colf(1)
 * @see <a href="https://github.com/pascaldekloe/colfer">Colfer's home</a>
 */
@javax.annotation.Generated(value="colf(1)", comments="Colfer from schema file Context.colf")
public class Tags implements Serializable {

	/** The upper limit for serial byte sizes. */
	public static int colferSizeMax = 16 * 1024 * 1024;

	/** The upper limit for the number of elements in a list. */
	public static int colferListMax = 64 * 1024;




	public StringTag[] strings;

	public LongTag[] longs;

	public BooleanTag[] booleans;


	/** Default constructor */
	public Tags() {
		init();
	}

	private static final StringTag[] _zeroStrings = new StringTag[0];
	private static final LongTag[] _zeroLongs = new LongTag[0];
	private static final BooleanTag[] _zeroBooleans = new BooleanTag[0];

	/** Colfer zero values. */
	private void init() {
		strings = _zeroStrings;
		longs = _zeroLongs;
		booleans = _zeroBooleans;
	}

	/**
	 * {@link #reset(InputStream) Reusable} deserialization of Colfer streams.
	 */
	public static class Unmarshaller {

		/** The data source. */
		protected InputStream in;

		/** The read buffer. */
		public byte[] buf;

		/** The {@link #buf buffer}'s data start index, inclusive. */
		protected int offset;

		/** The {@link #buf buffer}'s data end index, exclusive. */
		protected int i;


		/**
		 * @param in the data source or {@code null}.
		 * @param buf the initial buffer or {@code null}.
		 */
		public Unmarshaller(InputStream in, byte[] buf) {
			// TODO: better size estimation
			if (buf == null || buf.length == 0)
				buf = new byte[Math.min(Tags.colferSizeMax, 2048)];
			this.buf = buf;
			reset(in);
		}

		/**
		 * Reuses the marshaller.
		 * @param in the data source or {@code null}.
		 * @throws IllegalStateException on pending data.
		 */
		public void reset(InputStream in) {
			if (this.i != this.offset) throw new IllegalStateException("colfer: pending data");
			this.in = in;
			this.offset = 0;
			this.i = 0;
		}

		/**
		 * Deserializes the following object.
		 * @return the result or {@code null} when EOF.
		 * @throws IOException from the input stream.
		 * @throws SecurityException on an upper limit breach defined by either {@link #colferSizeMax} or {@link #colferListMax}.
		 * @throws InputMismatchException when the data does not match this object's schema.
		 */
		public Tags next() throws IOException {
			if (in == null) return null;

			while (true) {
				if (this.i > this.offset) {
					try {
						Tags o = new Tags();
						this.offset = o.unmarshal(this.buf, this.offset, this.i);
						return o;
					} catch (BufferUnderflowException e) {
					}
				}
				// not enough data

				if (this.i <= this.offset) {
					this.offset = 0;
					this.i = 0;
				} else if (i == buf.length) {
					byte[] src = this.buf;
					// TODO: better size estimation
					if (offset == 0) this.buf = new byte[Math.min(Tags.colferSizeMax, this.buf.length * 4)];
					System.arraycopy(src, this.offset, this.buf, 0, this.i - this.offset);
					this.i -= this.offset;
					this.offset = 0;
				}
				assert this.i < this.buf.length;

				int n = in.read(buf, i, buf.length - i);
				if (n < 0) {
					if (this.i > this.offset)
						throw new InputMismatchException("colfer: pending data with EOF");
					return null;
				}
				assert n > 0;
				i += n;
			}
		}

	}


	/**
	 * Serializes the object.
	 * All {@code null} elements in {@link #strings} will be replaced with a {@code new} value.
	 * All {@code null} elements in {@link #longs} will be replaced with a {@code new} value.
	 * All {@code null} elements in {@link #booleans} will be replaced with a {@code new} value.
	 * @param out the data destination.
	 * @param buf the initial buffer or {@code null}.
	 * @return the final buffer. When the serial fits into {@code buf} then the return is {@code buf}.
	 *  Otherwise the return is a new buffer, large enough to hold the whole serial.
	 * @throws IOException from {@code out}.
	 * @throws IllegalStateException on an upper limit breach defined by either {@link #colferSizeMax} or {@link #colferListMax}.
	 */
	public byte[] marshal(OutputStream out, byte[] buf) throws IOException {
		// TODO: better size estimation
		if (buf == null || buf.length == 0)
			buf = new byte[Math.min(Tags.colferSizeMax, 2048)];

		while (true) {
			int i;
			try {
				i = marshal(buf, 0);
			} catch (BufferOverflowException e) {
				buf = new byte[Math.min(Tags.colferSizeMax, buf.length * 4)];
				continue;
			}

			out.write(buf, 0, i);
			return buf;
		}
	}

	/**
	 * Serializes the object.
	 * All {@code null} elements in {@link #strings} will be replaced with a {@code new} value.
	 * All {@code null} elements in {@link #longs} will be replaced with a {@code new} value.
	 * All {@code null} elements in {@link #booleans} will be replaced with a {@code new} value.
	 * @param buf the data destination.
	 * @param offset the initial index for {@code buf}, inclusive.
	 * @return the final index for {@code buf}, exclusive.
	 * @throws BufferOverflowException when {@code buf} is too small.
	 * @throws IllegalStateException on an upper limit breach defined by either {@link #colferSizeMax} or {@link #colferListMax}.
	 */
	public int marshal(byte[] buf, int offset) {
		int i = offset;

		try {
			if (this.strings.length != 0) {
				buf[i++] = (byte) 0;
				StringTag[] a = this.strings;

				int x = a.length;
				if (x > Tags.colferListMax)
					throw new IllegalStateException(format("colfer: kamon/context/generated/binary/context.Tags.strings length %d exceeds %d elements", x, Tags.colferListMax));
				while (x > 0x7f) {
					buf[i++] = (byte) (x | 0x80);
					x >>>= 7;
				}
				buf[i++] = (byte) x;

				for (int ai = 0; ai < a.length; ai++) {
					StringTag o = a[ai];
					if (o == null) {
						o = new StringTag();
						a[ai] = o;
					}
					i = o.marshal(buf, i);
				}
			}

			if (this.longs.length != 0) {
				buf[i++] = (byte) 1;
				LongTag[] a = this.longs;

				int x = a.length;
				if (x > Tags.colferListMax)
					throw new IllegalStateException(format("colfer: kamon/context/generated/binary/context.Tags.longs length %d exceeds %d elements", x, Tags.colferListMax));
				while (x > 0x7f) {
					buf[i++] = (byte) (x | 0x80);
					x >>>= 7;
				}
				buf[i++] = (byte) x;

				for (int ai = 0; ai < a.length; ai++) {
					LongTag o = a[ai];
					if (o == null) {
						o = new LongTag();
						a[ai] = o;
					}
					i = o.marshal(buf, i);
				}
			}

			if (this.booleans.length != 0) {
				buf[i++] = (byte) 2;
				BooleanTag[] a = this.booleans;

				int x = a.length;
				if (x > Tags.colferListMax)
					throw new IllegalStateException(format("colfer: kamon/context/generated/binary/context.Tags.booleans length %d exceeds %d elements", x, Tags.colferListMax));
				while (x > 0x7f) {
					buf[i++] = (byte) (x | 0x80);
					x >>>= 7;
				}
				buf[i++] = (byte) x;

				for (int ai = 0; ai < a.length; ai++) {
					BooleanTag o = a[ai];
					if (o == null) {
						o = new BooleanTag();
						a[ai] = o;
					}
					i = o.marshal(buf, i);
				}
			}

			buf[i++] = (byte) 0x7f;
			return i;
		} catch (ArrayIndexOutOfBoundsException e) {
			if (i - offset > Tags.colferSizeMax)
				throw new IllegalStateException(format("colfer: kamon/context/generated/binary/context.Tags exceeds %d bytes", Tags.colferSizeMax));
			if (i > buf.length) throw new BufferOverflowException();
			throw e;
		}
	}

	/**
	 * Deserializes the object.
	 * @param buf the data source.
	 * @param offset the initial index for {@code buf}, inclusive.
	 * @return the final index for {@code buf}, exclusive.
	 * @throws BufferUnderflowException when {@code buf} is incomplete. (EOF)
	 * @throws SecurityException on an upper limit breach defined by either {@link #colferSizeMax} or {@link #colferListMax}.
	 * @throws InputMismatchException when the data does not match this object's schema.
	 */
	public int unmarshal(byte[] buf, int offset) {
		return unmarshal(buf, offset, buf.length);
	}

	/**
	 * Deserializes the object.
	 * @param buf the data source.
	 * @param offset the initial index for {@code buf}, inclusive.
	 * @param end the index limit for {@code buf}, exclusive.
	 * @return the final index for {@code buf}, exclusive.
	 * @throws BufferUnderflowException when {@code buf} is incomplete. (EOF)
	 * @throws SecurityException on an upper limit breach defined by either {@link #colferSizeMax} or {@link #colferListMax}.
	 * @throws InputMismatchException when the data does not match this object's schema.
	 */
	public int unmarshal(byte[] buf, int offset, int end) {
		if (end > buf.length) end = buf.length;
		int i = offset;

		try {
			byte header = buf[i++];

			if (header == (byte) 0) {
				int length = 0;
				for (int shift = 0; true; shift += 7) {
					byte b = buf[i++];
					length |= (b & 0x7f) << shift;
					if (shift == 28 || b >= 0) break;
				}
				if (length < 0 || length > Tags.colferListMax)
					throw new SecurityException(format("colfer: kamon/context/generated/binary/context.Tags.strings length %d exceeds %d elements", length, Tags.colferListMax));

				StringTag[] a = new StringTag[length];
				for (int ai = 0; ai < length; ai++) {
					StringTag o = new StringTag();
					i = o.unmarshal(buf, i, end);
					a[ai] = o;
				}
				this.strings = a;
				header = buf[i++];
			}

			if (header == (byte) 1) {
				int length = 0;
				for (int shift = 0; true; shift += 7) {
					byte b = buf[i++];
					length |= (b & 0x7f) << shift;
					if (shift == 28 || b >= 0) break;
				}
				if (length < 0 || length > Tags.colferListMax)
					throw new SecurityException(format("colfer: kamon/context/generated/binary/context.Tags.longs length %d exceeds %d elements", length, Tags.colferListMax));

				LongTag[] a = new LongTag[length];
				for (int ai = 0; ai < length; ai++) {
					LongTag o = new LongTag();
					i = o.unmarshal(buf, i, end);
					a[ai] = o;
				}
				this.longs = a;
				header = buf[i++];
			}

			if (header == (byte) 2) {
				int length = 0;
				for (int shift = 0; true; shift += 7) {
					byte b = buf[i++];
					length |= (b & 0x7f) << shift;
					if (shift == 28 || b >= 0) break;
				}
				if (length < 0 || length > Tags.colferListMax)
					throw new SecurityException(format("colfer: kamon/context/generated/binary/context.Tags.booleans length %d exceeds %d elements", length, Tags.colferListMax));

				BooleanTag[] a = new BooleanTag[length];
				for (int ai = 0; ai < length; ai++) {
					BooleanTag o = new BooleanTag();
					i = o.unmarshal(buf, i, end);
					a[ai] = o;
				}
				this.booleans = a;
				header = buf[i++];
			}

			if (header != (byte) 0x7f)
				throw new InputMismatchException(format("colfer: unknown header at byte %d", i - 1));
		} finally {
			if (i > end && end - offset < Tags.colferSizeMax) throw new BufferUnderflowException();
			if (i < 0 || i - offset > Tags.colferSizeMax)
				throw new SecurityException(format("colfer: kamon/context/generated/binary/context.Tags exceeds %d bytes", Tags.colferSizeMax));
			if (i > end) throw new BufferUnderflowException();
		}

		return i;
	}

	// {@link Serializable} version number.
	private static final long serialVersionUID = 3L;

	// {@link Serializable} Colfer extension.
	private void writeObject(ObjectOutputStream out) throws IOException {
		// TODO: better size estimation
		byte[] buf = new byte[1024];
		int n;
		while (true) try {
			n = marshal(buf, 0);
			break;
		} catch (BufferUnderflowException e) {
			buf = new byte[4 * buf.length];
		}

		out.writeInt(n);
		out.write(buf, 0, n);
	}

	// {@link Serializable} Colfer extension.
	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
		init();

		int n = in.readInt();
		byte[] buf = new byte[n];
		in.readFully(buf);
		unmarshal(buf, 0);
	}

	// {@link Serializable} Colfer extension.
	private void readObjectNoData() throws ObjectStreamException {
		init();
	}

	/**
	 * Gets kamon/context/generated/binary/context.Tags.strings.
	 * @return the value.
	 */
	public StringTag[] getStrings() {
		return this.strings;
	}

	/**
	 * Sets kamon/context/generated/binary/context.Tags.strings.
	 * @param value the replacement.
	 */
	public void setStrings(StringTag[] value) {
		this.strings = value;
	}

	/**
	 * Sets kamon/context/generated/binary/context.Tags.strings.
	 * @param value the replacement.
	 * @return {link this}.
	 */
	public Tags withStrings(StringTag[] value) {
		this.strings = value;
		return this;
	}

	/**
	 * Gets kamon/context/generated/binary/context.Tags.longs.
	 * @return the value.
	 */
	public LongTag[] getLongs() {
		return this.longs;
	}

	/**
	 * Sets kamon/context/generated/binary/context.Tags.longs.
	 * @param value the replacement.
	 */
	public void setLongs(LongTag[] value) {
		this.longs = value;
	}

	/**
	 * Sets kamon/context/generated/binary/context.Tags.longs.
	 * @param value the replacement.
	 * @return {link this}.
	 */
	public Tags withLongs(LongTag[] value) {
		this.longs = value;
		return this;
	}

	/**
	 * Gets kamon/context/generated/binary/context.Tags.booleans.
	 * @return the value.
	 */
	public BooleanTag[] getBooleans() {
		return this.booleans;
	}

	/**
	 * Sets kamon/context/generated/binary/context.Tags.booleans.
	 * @param value the replacement.
	 */
	public void setBooleans(BooleanTag[] value) {
		this.booleans = value;
	}

	/**
	 * Sets kamon/context/generated/binary/context.Tags.booleans.
	 * @param value the replacement.
	 * @return {link this}.
	 */
	public Tags withBooleans(BooleanTag[] value) {
		this.booleans = value;
		return this;
	}

	@Override
	public final int hashCode() {
		int h = 1;
		for (StringTag o : this.strings) h = 31 * h + (o == null ? 0 : o.hashCode());
		for (LongTag o : this.longs) h = 31 * h + (o == null ? 0 : o.hashCode());
		for (BooleanTag o : this.booleans) h = 31 * h + (o == null ? 0 : o.hashCode());
		return h;
	}

	@Override
	public final boolean equals(Object o) {
		return o instanceof Tags && equals((Tags) o);
	}

	public final boolean equals(Tags o) {
		if (o == null) return false;
		if (o == this) return true;
		return o.getClass() == Tags.class
			&& java.util.Arrays.equals(this.strings, o.strings)
			&& java.util.Arrays.equals(this.longs, o.longs)
			&& java.util.Arrays.equals(this.booleans, o.booleans);
	}

}
