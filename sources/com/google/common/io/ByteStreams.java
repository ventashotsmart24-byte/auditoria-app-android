package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class ByteStreams {
    private static final int BUFFER_SIZE = 8192;
    private static final int MAX_ARRAY_LEN = 2147483639;
    private static final OutputStream NULL_OUTPUT_STREAM = new OutputStream() {
        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        public void write(int i10) {
        }

        public void write(byte[] bArr) {
            Preconditions.checkNotNull(bArr);
        }

        public void write(byte[] bArr, int i10, int i11) {
            Preconditions.checkNotNull(bArr);
            Preconditions.checkPositionIndexes(i10, i11 + i10, bArr.length);
        }
    };
    private static final int TO_BYTE_ARRAY_DEQUE_SIZE = 20;
    private static final int ZERO_COPY_CHUNK_SIZE = 524288;

    private ByteStreams() {
    }

    private static byte[] combineBuffers(Queue<byte[]> queue, int i10) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] remove = queue.remove();
        if (remove.length == i10) {
            return remove;
        }
        int length = i10 - remove.length;
        byte[] copyOf = Arrays.copyOf(remove, i10);
        while (length > 0) {
            byte[] remove2 = queue.remove();
            int min = Math.min(length, remove2.length);
            System.arraycopy(remove2, 0, copyOf, i10 - length, min);
            length -= min;
        }
        return copyOf;
    }

    @CanIgnoreReturnValue
    public static long copy(InputStream inputStream, OutputStream outputStream) {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(outputStream);
        byte[] createBuffer = createBuffer();
        long j10 = 0;
        while (true) {
            int read = inputStream.read(createBuffer);
            if (read == -1) {
                return j10;
            }
            outputStream.write(createBuffer, 0, read);
            j10 += (long) read;
        }
    }

    public static byte[] createBuffer() {
        return new byte[8192];
    }

    @CanIgnoreReturnValue
    @Beta
    public static long exhaust(InputStream inputStream) {
        byte[] createBuffer = createBuffer();
        long j10 = 0;
        while (true) {
            long read = (long) inputStream.read(createBuffer);
            if (read == -1) {
                return j10;
            }
            j10 += read;
        }
    }

    @Beta
    public static InputStream limit(InputStream inputStream, long j10) {
        return new LimitedInputStream(inputStream, j10);
    }

    @Beta
    public static ByteArrayDataInput newDataInput(byte[] bArr) {
        return newDataInput(new ByteArrayInputStream(bArr));
    }

    @Beta
    public static ByteArrayDataOutput newDataOutput() {
        return newDataOutput(new ByteArrayOutputStream());
    }

    @Beta
    public static OutputStream nullOutputStream() {
        return NULL_OUTPUT_STREAM;
    }

    @CanIgnoreReturnValue
    @Beta
    public static int read(InputStream inputStream, byte[] bArr, int i10, int i11) {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(bArr);
        int i12 = 0;
        if (i11 >= 0) {
            Preconditions.checkPositionIndexes(i10, i10 + i11, bArr.length);
            while (i12 < i11) {
                int read = inputStream.read(bArr, i10 + i12, i11 - i12);
                if (read == -1) {
                    break;
                }
                i12 += read;
            }
            return i12;
        }
        throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", new Object[]{Integer.valueOf(i11)}));
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    @Beta
    public static <T> T readBytes(InputStream inputStream, ByteProcessor<T> byteProcessor) {
        int read;
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(byteProcessor);
        byte[] createBuffer = createBuffer();
        do {
            read = inputStream.read(createBuffer);
            if (read == -1 || !byteProcessor.processBytes(createBuffer, 0, read)) {
            }
            read = inputStream.read(createBuffer);
            break;
        } while (!byteProcessor.processBytes(createBuffer, 0, read));
        return byteProcessor.getResult();
    }

    @Beta
    public static void readFully(InputStream inputStream, byte[] bArr) {
        readFully(inputStream, bArr, 0, bArr.length);
    }

    @Beta
    public static void skipFully(InputStream inputStream, long j10) {
        long skipUpTo = skipUpTo(inputStream, j10);
        if (skipUpTo < j10) {
            StringBuilder sb = new StringBuilder(100);
            sb.append("reached end of stream after skipping ");
            sb.append(skipUpTo);
            sb.append(" bytes; ");
            sb.append(j10);
            sb.append(" bytes expected");
            throw new EOFException(sb.toString());
        }
    }

    private static long skipSafely(InputStream inputStream, long j10) {
        int available = inputStream.available();
        if (available == 0) {
            return 0;
        }
        return inputStream.skip(Math.min((long) available, j10));
    }

    public static long skipUpTo(InputStream inputStream, long j10) {
        byte[] bArr = null;
        long j11 = 0;
        while (j11 < j10) {
            long j12 = j10 - j11;
            long skipSafely = skipSafely(inputStream, j12);
            if (skipSafely == 0) {
                int min = (int) Math.min(j12, 8192);
                if (bArr == null) {
                    bArr = new byte[min];
                }
                skipSafely = (long) inputStream.read(bArr, 0, min);
                if (skipSafely == -1) {
                    break;
                }
            }
            j11 += skipSafely;
        }
        return j11;
    }

    public static byte[] toByteArray(InputStream inputStream) {
        Preconditions.checkNotNull(inputStream);
        return toByteArrayInternal(inputStream, new ArrayDeque(20), 0);
    }

    private static byte[] toByteArrayInternal(InputStream inputStream, Queue<byte[]> queue, int i10) {
        int i11;
        int min = Math.min(8192, Math.max(128, Integer.highestOneBit(i10) * 2));
        while (i10 < MAX_ARRAY_LEN) {
            int min2 = Math.min(min, MAX_ARRAY_LEN - i10);
            byte[] bArr = new byte[min2];
            queue.add(bArr);
            int i12 = 0;
            while (i12 < min2) {
                int read = inputStream.read(bArr, i12, min2 - i12);
                if (read == -1) {
                    return combineBuffers(queue, i10);
                }
                i12 += read;
                i10 += read;
            }
            if (min < 4096) {
                i11 = 4;
            } else {
                i11 = 2;
            }
            min = IntMath.saturatedMultiply(min, i11);
        }
        if (inputStream.read() == -1) {
            return combineBuffers(queue, MAX_ARRAY_LEN);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    public static class ByteArrayDataInputStream implements ByteArrayDataInput {
        final DataInput input;

        public ByteArrayDataInputStream(ByteArrayInputStream byteArrayInputStream) {
            this.input = new DataInputStream(byteArrayInputStream);
        }

        public boolean readBoolean() {
            try {
                return this.input.readBoolean();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        public byte readByte() {
            try {
                return this.input.readByte();
            } catch (EOFException e10) {
                throw new IllegalStateException(e10);
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }

        public char readChar() {
            try {
                return this.input.readChar();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        public double readDouble() {
            try {
                return this.input.readDouble();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        public float readFloat() {
            try {
                return this.input.readFloat();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        public void readFully(byte[] bArr) {
            try {
                this.input.readFully(bArr);
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        public int readInt() {
            try {
                return this.input.readInt();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @CheckForNull
        public String readLine() {
            try {
                return this.input.readLine();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        public long readLong() {
            try {
                return this.input.readLong();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        public short readShort() {
            try {
                return this.input.readShort();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        public String readUTF() {
            try {
                return this.input.readUTF();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        public int readUnsignedByte() {
            try {
                return this.input.readUnsignedByte();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        public int readUnsignedShort() {
            try {
                return this.input.readUnsignedShort();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        public int skipBytes(int i10) {
            try {
                return this.input.skipBytes(i10);
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        public void readFully(byte[] bArr, int i10, int i11) {
            try {
                this.input.readFully(bArr, i10, i11);
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    public static class ByteArrayDataOutputStream implements ByteArrayDataOutput {
        final ByteArrayOutputStream byteArrayOutputStream;
        final DataOutput output;

        public ByteArrayDataOutputStream(ByteArrayOutputStream byteArrayOutputStream2) {
            this.byteArrayOutputStream = byteArrayOutputStream2;
            this.output = new DataOutputStream(byteArrayOutputStream2);
        }

        public byte[] toByteArray() {
            return this.byteArrayOutputStream.toByteArray();
        }

        public void write(int i10) {
            try {
                this.output.write(i10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        public void writeBoolean(boolean z10) {
            try {
                this.output.writeBoolean(z10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        public void writeByte(int i10) {
            try {
                this.output.writeByte(i10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        public void writeBytes(String str) {
            try {
                this.output.writeBytes(str);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        public void writeChar(int i10) {
            try {
                this.output.writeChar(i10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        public void writeChars(String str) {
            try {
                this.output.writeChars(str);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        public void writeDouble(double d10) {
            try {
                this.output.writeDouble(d10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        public void writeFloat(float f10) {
            try {
                this.output.writeFloat(f10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        public void writeInt(int i10) {
            try {
                this.output.writeInt(i10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        public void writeLong(long j10) {
            try {
                this.output.writeLong(j10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        public void writeShort(int i10) {
            try {
                this.output.writeShort(i10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        public void writeUTF(String str) {
            try {
                this.output.writeUTF(str);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        public void write(byte[] bArr) {
            try {
                this.output.write(bArr);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        public void write(byte[] bArr, int i10, int i11) {
            try {
                this.output.write(bArr, i10, i11);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    @Beta
    public static ByteArrayDataInput newDataInput(byte[] bArr, int i10) {
        Preconditions.checkPositionIndex(i10, bArr.length);
        return newDataInput(new ByteArrayInputStream(bArr, i10, bArr.length - i10));
    }

    @Beta
    public static ByteArrayDataOutput newDataOutput(int i10) {
        if (i10 >= 0) {
            return newDataOutput(new ByteArrayOutputStream(i10));
        }
        throw new IllegalArgumentException(String.format("Invalid size: %s", new Object[]{Integer.valueOf(i10)}));
    }

    @Beta
    public static void readFully(InputStream inputStream, byte[] bArr, int i10, int i11) {
        int read = read(inputStream, bArr, i10, i11);
        if (read != i11) {
            StringBuilder sb = new StringBuilder(81);
            sb.append("reached end of stream after reading ");
            sb.append(read);
            sb.append(" bytes; ");
            sb.append(i11);
            sb.append(" bytes expected");
            throw new EOFException(sb.toString());
        }
    }

    public static final class LimitedInputStream extends FilterInputStream {
        private long left;
        private long mark = -1;

        public LimitedInputStream(InputStream inputStream, long j10) {
            super(inputStream);
            boolean z10;
            Preconditions.checkNotNull(inputStream);
            if (j10 >= 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "limit must be non-negative");
            this.left = j10;
        }

        public int available() {
            return (int) Math.min((long) this.in.available(), this.left);
        }

        public synchronized void mark(int i10) {
            this.in.mark(i10);
            this.mark = this.left;
        }

        public int read() {
            if (this.left == 0) {
                return -1;
            }
            int read = this.in.read();
            if (read != -1) {
                this.left--;
            }
            return read;
        }

        public synchronized void reset() {
            if (!this.in.markSupported()) {
                throw new IOException("Mark not supported");
            } else if (this.mark != -1) {
                this.in.reset();
                this.left = this.mark;
            } else {
                throw new IOException("Mark not set");
            }
        }

        public long skip(long j10) {
            long skip = this.in.skip(Math.min(j10, this.left));
            this.left -= skip;
            return skip;
        }

        public int read(byte[] bArr, int i10, int i11) {
            long j10 = this.left;
            if (j10 == 0) {
                return -1;
            }
            int read = this.in.read(bArr, i10, (int) Math.min((long) i11, j10));
            if (read != -1) {
                this.left -= (long) read;
            }
            return read;
        }
    }

    public static byte[] toByteArray(InputStream inputStream, long j10) {
        Preconditions.checkArgument(j10 >= 0, "expectedSize (%s) must be non-negative", j10);
        if (j10 <= 2147483639) {
            int i10 = (int) j10;
            byte[] bArr = new byte[i10];
            int i11 = i10;
            while (i11 > 0) {
                int i12 = i10 - i11;
                int read = inputStream.read(bArr, i12, i11);
                if (read == -1) {
                    return Arrays.copyOf(bArr, i12);
                }
                i11 -= read;
            }
            int read2 = inputStream.read();
            if (read2 == -1) {
                return bArr;
            }
            ArrayDeque arrayDeque = new ArrayDeque(22);
            arrayDeque.add(bArr);
            arrayDeque.add(new byte[]{(byte) read2});
            return toByteArrayInternal(inputStream, arrayDeque, i10 + 1);
        }
        StringBuilder sb = new StringBuilder(62);
        sb.append(j10);
        sb.append(" bytes is too large to fit in a byte array");
        throw new OutOfMemoryError(sb.toString());
    }

    @Beta
    public static ByteArrayDataInput newDataInput(ByteArrayInputStream byteArrayInputStream) {
        return new ByteArrayDataInputStream((ByteArrayInputStream) Preconditions.checkNotNull(byteArrayInputStream));
    }

    @Beta
    public static ByteArrayDataOutput newDataOutput(ByteArrayOutputStream byteArrayOutputStream) {
        return new ByteArrayDataOutputStream((ByteArrayOutputStream) Preconditions.checkNotNull(byteArrayOutputStream));
    }

    @CanIgnoreReturnValue
    public static long copy(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) {
        Preconditions.checkNotNull(readableByteChannel);
        Preconditions.checkNotNull(writableByteChannel);
        long j10 = 0;
        if (readableByteChannel instanceof FileChannel) {
            FileChannel fileChannel = (FileChannel) readableByteChannel;
            long position = fileChannel.position();
            long j11 = position;
            while (true) {
                long transferTo = fileChannel.transferTo(j11, 524288, writableByteChannel);
                j11 += transferTo;
                fileChannel.position(j11);
                if (transferTo <= 0 && j11 >= fileChannel.size()) {
                    return j11 - position;
                }
            }
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(createBuffer());
            while (readableByteChannel.read(wrap) != -1) {
                Java8Compatibility.flip(wrap);
                while (wrap.hasRemaining()) {
                    j10 += (long) writableByteChannel.write(wrap);
                }
                Java8Compatibility.clear(wrap);
            }
            return j10;
        }
    }
}
