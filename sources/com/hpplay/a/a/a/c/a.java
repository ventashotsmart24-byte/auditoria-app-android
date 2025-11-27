package com.hpplay.a.a.a.c;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public class a extends FilterOutputStream {
    public a(OutputStream outputStream) {
        super(outputStream);
    }

    public void a() {
        this.out.write("0\r\n\r\n".getBytes());
    }

    public void write(int i10) {
        write(new byte[]{(byte) i10}, 0, 1);
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i10, int i11) {
        if (i11 != 0) {
            this.out.write(String.format("%x\r\n", new Object[]{Integer.valueOf(i11)}).getBytes());
            this.out.write(bArr, i10, i11);
            this.out.write("\r\n".getBytes());
        }
    }
}
