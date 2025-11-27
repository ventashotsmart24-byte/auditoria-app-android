package com.umeng.message.proguard;

import java.util.concurrent.Future;

public abstract class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected Future<?> f15561a;

    public final c a() {
        this.f15561a = b();
        return this;
    }

    public abstract Future<?> b();

    public final void c() {
        Future<?> future = this.f15561a;
        if (future != null) {
            try {
                if (!future.isCancelled() && !future.isDone()) {
                    future.cancel(false);
                }
            } catch (Throwable unused) {
            }
        }
        this.f15561a = null;
    }

    public final boolean d() {
        Future<?> future = this.f15561a;
        if (future == null || future.isDone()) {
            return false;
        }
        return true;
    }
}
