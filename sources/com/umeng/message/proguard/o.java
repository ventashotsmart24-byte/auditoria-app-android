package com.umeng.message.proguard;

import java.lang.ref.WeakReference;
import java.util.concurrent.Future;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static WeakReference<Future<?>> f15991a;

    /* renamed from: b  reason: collision with root package name */
    private static WeakReference<Future<?>> f15992b;

    public static synchronized void a() {
        Future future;
        synchronized (o.class) {
            WeakReference<Future<?>> weakReference = f15992b;
            if (weakReference == null || (future = weakReference.get()) == null || future.isDone() || future.isCancelled()) {
                f15992b = new WeakReference<>(b.b(new m()));
            }
        }
    }
}
