package com.google.protobuf;

import com.google.common.primitives.UnsignedBytes;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

final class NioByteString extends ByteString.LeafByteString {
    /* access modifiers changed from: private */
    public final ByteBuffer buffer;

    public NioByteString(ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, "buffer");
        this.buffer = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    private ByteBuffer slice(int i10, int i11) {
        if (i10 < this.buffer.position() || i11 > this.buffer.limit() || i10 > i11) {
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", new Object[]{Integer.valueOf(i10), Integer.valueOf(i11)}));
        }
        ByteBuffer slice = this.buffer.slice();
        slice.position(i10 - this.buffer.position());
        slice.limit(i11 - this.buffer.position());
        return slice;
    }

    private Object writeReplace() {
        return ByteString.copyFrom(this.buffer.slice());
    }

    public ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    public List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(asReadOnlyByteBuffer());
    }

    public byte byteAt(int i10) {
        try {
            return this.buffer.get(i10);
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw e10;
        } catch (IndexOutOfBoundsException e11) {
            throw new ArrayIndexOutOfBoundsException(e11.getMessage());
        }
    }

    public void copyTo(ByteBuffer byteBuffer) {
        byteBuffer.put(this.buffer.slice());
    }

    public void copyToInternal(byte[] bArr, int i10, int i11, int i12) {
        ByteBuffer slice = this.buffer.slice();
        slice.position(i10);
        slice.get(bArr, i11, i12);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (size() != byteString.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof NioByteString) {
            return this.buffer.equals(((NioByteString) obj).buffer);
        }
        if (obj instanceof RopeByteString) {
            return obj.equals(this);
        }
        return this.buffer.equals(byteString.asReadOnlyByteBuffer());
    }

    public boolean equalsRange(ByteString byteString, int i10, int i11) {
        return substring(0, i11).equals(byteString.substring(i10, i11 + i10));
    }

    public byte internalByteAt(int i10) {
        return byteAt(i10);
    }

    public boolean isValidUtf8() {
        return Utf8.isValidUtf8(this.buffer);
    }

    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this.buffer, true);
    }

    public InputStream newInput() {
        return new InputStream() {
            private final ByteBuffer buf;

            {
                this.buf = NioByteString.this.buffer.slice();
            }

            public int available() {
                return this.buf.remaining();
            }

            public void mark(int i10) {
                this.buf.mark();
            }

            public boolean markSupported() {
                return true;
            }

            public int read() {
                if (!this.buf.hasRemaining()) {
                    return -1;
                }
                return this.buf.get() & UnsignedBytes.MAX_VALUE;
            }

            public void reset() {
                try {
                    this.buf.reset();
                } catch (InvalidMarkException e10) {
                    throw new IOException(e10);
                }
            }

            public int read(byte[] bArr, int i10, int i11) {
                if (!this.buf.hasRemaining()) {
                    return -1;
                }
                int min = Math.min(i11, this.buf.remaining());
                this.buf.get(bArr, i10, min);
                return min;
            }
        };
    }

    public int partialHash(int i10, int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            i10 = (i10 * 31) + this.buffer.get(i13);
        }
        return i10;
    }

    public int partialIsValidUtf8(int i10, int i11, int i12) {
        return Utf8.partialIsValidUtf8(i10, this.buffer, i11, i12 + i11);
    }

    public int size() {
        return this.buffer.remaining();
    }

    public ByteString substring(int i10, int i11) {
        try {
            return new NioByteString(slice(i10, i11));
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw e10;
        } catch (IndexOutOfBoundsException e11) {
            throw new ArrayIndexOutOfBoundsException(e11.getMessage());
        }
    }

    public String toStringInternal(Charset charset) {
        int i10;
        int i11;
        byte[] bArr;
        if (this.buffer.hasArray()) {
            bArr = this.buffer.array();
            i11 = this.buffer.arrayOffset() + this.buffer.position();
            i10 = this.buffer.remaining();
        } else {
            bArr = toByteArray();
            i10 = bArr.length;
            i11 = 0;
        }
        return new String(bArr, i11, i10, charset);
    }

    public void writeTo(OutputStream outputStream) {
        outputStream.write(toByteArray());
    }

    public void writeToInternal(OutputStream outputStream, int i10, int i11) {
        if (this.buffer.hasArray()) {
            outputStream.write(this.buffer.array(), this.buffer.arrayOffset() + this.buffer.position() + i10, i11);
            return;
        }
        ByteBufferWriter.write(slice(i10, i11 + i10), outputStream);
    }

    public void writeTo(ByteOutput byteOutput) {
        byteOutput.writeLazy(this.buffer.slice());
    }
}
