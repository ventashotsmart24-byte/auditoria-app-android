package com.efs.sdk.net.a.a;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public final class a extends FilterOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private long f5447a;

    public a(OutputStream outputStream) {
        super(outputStream);
    }

    public final void write(int i10) {
        this.out.write(i10);
        this.f5447a++;
    }

    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public final void write(byte[] bArr, int i10, int i11) {
        this.out.write(bArr, i10, i11);
        this.f5447a += (long) i11;
    }
}
