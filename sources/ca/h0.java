package ca;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import y9.e;

public final class h0 extends r0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: h  reason: collision with root package name */
    public static final h0 f11500h;

    /* renamed from: i  reason: collision with root package name */
    public static final long f11501i;

    static {
        Long l10;
        h0 h0Var = new h0();
        f11500h = h0Var;
        q0.T(h0Var, false, 1, (Object) null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        f11501i = timeUnit.toNanos(l10.longValue());
    }

    public Thread X() {
        Thread thread = _thread;
        if (thread == null) {
            return k0();
        }
        return thread;
    }

    public void b0(Runnable runnable) {
        if (l0()) {
            o0();
        }
        super.b0(runnable);
    }

    public final synchronized void j0() {
        if (m0()) {
            debugStatus = 3;
            h0();
            notifyAll();
        }
    }

    public final synchronized Thread k0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final boolean l0() {
        if (debugStatus == 4) {
            return true;
        }
        return false;
    }

    public final boolean m0() {
        int i10 = debugStatus;
        if (i10 == 2 || i10 == 3) {
            return true;
        }
        return false;
    }

    public final synchronized boolean n0() {
        if (m0()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    public final void o0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public void run() {
        w1.f11556a.c(this);
        c.a();
        try {
            if (n0()) {
                long j10 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long f02 = f0();
                    if (f02 == Long.MAX_VALUE) {
                        c.a();
                        long nanoTime = System.nanoTime();
                        if (j10 == Long.MAX_VALUE) {
                            j10 = f11501i + nanoTime;
                        }
                        long j11 = j10 - nanoTime;
                        if (j11 <= 0) {
                            _thread = null;
                            j0();
                            c.a();
                            if (!e0()) {
                                X();
                                return;
                            }
                            return;
                        }
                        f02 = e.c(f02, j11);
                    } else {
                        j10 = Long.MAX_VALUE;
                    }
                    if (f02 > 0) {
                        if (m0()) {
                            _thread = null;
                            j0();
                            c.a();
                            if (!e0()) {
                                X();
                                return;
                            }
                            return;
                        }
                        c.a();
                        LockSupport.parkNanos(this, f02);
                    }
                }
            }
        } finally {
            _thread = null;
            j0();
            c.a();
            if (!e0()) {
                X();
            }
        }
    }

    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
