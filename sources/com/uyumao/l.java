package com.uyumao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public static l f16288a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f16289b;

    public static l a() {
        if (f16288a == null) {
            synchronized (l.class) {
                if (f16288a == null) {
                    f16288a = new l();
                }
            }
        }
        return f16288a;
    }

    public ExecutorService b() {
        if (this.f16289b == null) {
            synchronized (l.class) {
                if (this.f16289b == null) {
                    this.f16289b = Executors.newSingleThreadExecutor();
                }
            }
        }
        return this.f16289b;
    }
}
