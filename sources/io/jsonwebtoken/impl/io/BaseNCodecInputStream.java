package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.impl.io.BaseNCodec;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

class BaseNCodecInputStream extends FilterInputStream {
    private final BaseNCodec baseNCodec;
    private final byte[] buf;
    private final BaseNCodec.Context context = new BaseNCodec.Context();
    private final boolean doEncode;
    private final byte[] singleByte = new byte[1];

    public BaseNCodecInputStream(InputStream inputStream, BaseNCodec baseNCodec2, boolean z10) {
        super(inputStream);
        int i10;
        this.doEncode = z10;
        this.baseNCodec = baseNCodec2;
        if (z10) {
            i10 = 4096;
        } else {
            i10 = 8192;
        }
        this.buf = new byte[i10];
    }

    public int available() {
        return this.context.eof ^ true ? 1 : 0;
    }

    public boolean isStrictDecoding() {
        return this.baseNCodec.isStrictDecoding();
    }

    public synchronized void mark(int i10) {
    }

    public boolean markSupported() {
        return false;
    }

    public int read() {
        int read = read(this.singleByte, 0, 1);
        while (read == 0) {
            read = read(this.singleByte, 0, 1);
        }
        if (read <= 0) {
            return -1;
        }
        byte b10 = this.singleByte[0];
        return b10 < 0 ? b10 + 256 : b10;
    }

    public synchronized void reset() {
        throw new IOException("mark/reset not supported");
    }

    public long skip(long j10) {
        int read;
        if (j10 >= 0) {
            byte[] bArr = new byte[512];
            long j11 = j10;
            while (j11 > 0 && (read = read(bArr, 0, (int) Math.min((long) 512, j11))) != -1) {
                j11 -= (long) read;
            }
            return j10 - j11;
        }
        throw new IllegalArgumentException("Negative skip length: " + j10);
    }

    public int read(byte[] bArr, int i10, int i11) {
        Objects.requireNonNull(bArr, "array");
        if (i10 < 0 || i11 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i10 > bArr.length || i10 + i11 > bArr.length) {
            throw new IndexOutOfBoundsException();
        } else if (i11 == 0) {
            return 0;
        } else {
            int i12 = 0;
            while (i12 < i11) {
                if (!this.baseNCodec.hasData(this.context)) {
                    int read = this.in.read(this.buf);
                    if (this.doEncode) {
                        this.baseNCodec.encode(this.buf, 0, read, this.context);
                    } else {
                        this.baseNCodec.decode(this.buf, 0, read, this.context);
                    }
                }
                int readResults = this.baseNCodec.readResults(bArr, i10 + i12, i11 - i12, this.context);
                if (readResults >= 0) {
                    i12 += readResults;
                } else if (i12 != 0) {
                    return i12;
                } else {
                    return -1;
                }
            }
            return i12;
        }
    }
}
