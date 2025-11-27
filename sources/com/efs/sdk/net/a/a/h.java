package com.efs.sdk.net.a.a;

import java.io.ByteArrayOutputStream;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final f f5460a;

    /* renamed from: b  reason: collision with root package name */
    public ByteArrayOutputStream f5461b;

    /* renamed from: c  reason: collision with root package name */
    public a f5462c;

    /* renamed from: d  reason: collision with root package name */
    private final String f5463d;

    public h(f fVar, String str) {
        this.f5460a = fVar;
        this.f5463d = str;
    }

    public final boolean a() {
        if (this.f5461b != null) {
            return true;
        }
        return false;
    }

    public final void b() {
        if (!a()) {
            throw new IllegalStateException("No body found; has createBodySink been called?");
        }
    }
}
