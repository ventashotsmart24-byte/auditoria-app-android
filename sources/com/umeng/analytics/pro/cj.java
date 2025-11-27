package com.umeng.analytics.pro;

import java.io.ByteArrayOutputStream;

public class cj extends ByteArrayOutputStream {
    public cj(int i10) {
        super(i10);
    }

    public byte[] a() {
        return this.buf;
    }

    public int b() {
        return this.count;
    }

    public cj() {
    }
}
