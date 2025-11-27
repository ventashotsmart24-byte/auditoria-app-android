package com.efs.sdk.net.a.a;

public final class d {
    public static <T extends Throwable> void a(Throwable th, Class<T> cls) {
        if (cls.isInstance(th)) {
            throw th;
        }
    }
}
