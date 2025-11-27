package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.impl.io.BaseNCodec;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Objects;

class BaseNCodecOutputStream extends FilterOutputStream {
    private final BaseNCodec baseNCodec;
    private final BaseNCodec.Context context = new BaseNCodec.Context();
    private final boolean doEncode;
    private final byte[] singleByte = new byte[1];

    public BaseNCodecOutputStream(OutputStream outputStream, BaseNCodec baseNCodec2, boolean z10) {
        super(outputStream);
        this.baseNCodec = baseNCodec2;
        this.doEncode = z10;
    }

    public void close() {
        eof();
        flush();
        this.out.close();
    }

    public void eof() {
        if (this.doEncode) {
            this.baseNCodec.encode(this.singleByte, 0, -1, this.context);
        } else {
            this.baseNCodec.decode(this.singleByte, 0, -1, this.context);
        }
    }

    public void flush() {
        flush(true);
    }

    public boolean isStrictDecoding() {
        return this.baseNCodec.isStrictDecoding();
    }

    public void write(byte[] bArr, int i10, int i11) {
        Objects.requireNonNull(bArr, "array");
        if (i10 < 0 || i11 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i10 > bArr.length || i10 + i11 > bArr.length) {
            throw new IndexOutOfBoundsException();
        } else if (i11 > 0) {
            if (this.doEncode) {
                this.baseNCodec.encode(bArr, i10, i11, this.context);
            } else {
                this.baseNCodec.decode(bArr, i10, i11, this.context);
            }
            flush(false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = new byte[r0];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void flush(boolean r6) {
        /*
            r5 = this;
            io.jsonwebtoken.impl.io.BaseNCodec r0 = r5.baseNCodec
            io.jsonwebtoken.impl.io.BaseNCodec$Context r1 = r5.context
            int r0 = r0.available(r1)
            if (r0 <= 0) goto L_0x001c
            byte[] r1 = new byte[r0]
            io.jsonwebtoken.impl.io.BaseNCodec r2 = r5.baseNCodec
            io.jsonwebtoken.impl.io.BaseNCodec$Context r3 = r5.context
            r4 = 0
            int r0 = r2.readResults(r1, r4, r0, r3)
            if (r0 <= 0) goto L_0x001c
            java.io.OutputStream r2 = r5.out
            r2.write(r1, r4, r0)
        L_0x001c:
            if (r6 == 0) goto L_0x0023
            java.io.OutputStream r6 = r5.out
            r6.flush()
        L_0x0023:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.io.BaseNCodecOutputStream.flush(boolean):void");
    }

    public void write(int i10) {
        byte[] bArr = this.singleByte;
        bArr[0] = (byte) i10;
        write(bArr, 0, 1);
    }
}
