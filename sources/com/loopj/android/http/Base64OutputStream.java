package com.loopj.android.http;

import com.loopj.android.http.Base64;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Base64OutputStream extends FilterOutputStream {
    private static byte[] EMPTY = new byte[0];
    private int bpos;
    private byte[] buffer;
    private final Base64.Coder coder;
    private final int flags;

    public Base64OutputStream(OutputStream outputStream, int i10) {
        this(outputStream, i10, true);
    }

    private byte[] embiggen(byte[] bArr, int i10) {
        if (bArr == null || bArr.length < i10) {
            return new byte[i10];
        }
        return bArr;
    }

    private void flushBuffer() {
        int i10 = this.bpos;
        if (i10 > 0) {
            internalWrite(this.buffer, 0, i10, false);
            this.bpos = 0;
        }
    }

    private void internalWrite(byte[] bArr, int i10, int i11, boolean z10) {
        Base64.Coder coder2 = this.coder;
        coder2.output = embiggen(coder2.output, coder2.maxOutputSize(i11));
        if (this.coder.process(bArr, i10, i11, z10)) {
            OutputStream outputStream = this.out;
            Base64.Coder coder3 = this.coder;
            outputStream.write(coder3.output, 0, coder3.op);
            return;
        }
        throw new Base64DataException("bad base-64");
    }

    public void close() {
        try {
            flushBuffer();
            internalWrite(EMPTY, 0, 0, true);
            e = null;
        } catch (IOException e10) {
            e = e10;
        }
        try {
            if ((this.flags & 16) == 0) {
                this.out.close();
            } else {
                this.out.flush();
            }
        } catch (IOException e11) {
            if (e != null) {
                e = e11;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    public void write(int i10) {
        if (this.buffer == null) {
            this.buffer = new byte[1024];
        }
        int i11 = this.bpos;
        byte[] bArr = this.buffer;
        if (i11 >= bArr.length) {
            internalWrite(bArr, 0, i11, false);
            this.bpos = 0;
        }
        byte[] bArr2 = this.buffer;
        int i12 = this.bpos;
        this.bpos = i12 + 1;
        bArr2[i12] = (byte) i10;
    }

    public Base64OutputStream(OutputStream outputStream, int i10, boolean z10) {
        super(outputStream);
        this.buffer = null;
        this.bpos = 0;
        this.flags = i10;
        if (z10) {
            this.coder = new Base64.Encoder(i10, (byte[]) null);
        } else {
            this.coder = new Base64.Decoder(i10, (byte[]) null);
        }
    }

    public void write(byte[] bArr, int i10, int i11) {
        if (i11 > 0) {
            flushBuffer();
            internalWrite(bArr, i10, i11, false);
        }
    }
}
