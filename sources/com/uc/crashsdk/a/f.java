package com.uc.crashsdk.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;

public class f {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f13489a = true;

    /* renamed from: b  reason: collision with root package name */
    private static volatile HandlerThread f13490b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile HandlerThread f13491c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile HandlerThread f13492d;

    /* renamed from: e  reason: collision with root package name */
    private static Handler f13493e;

    /* renamed from: f  reason: collision with root package name */
    private static Handler f13494f;

    /* renamed from: g  reason: collision with root package name */
    private static Handler f13495g;

    /* renamed from: h  reason: collision with root package name */
    private static Handler f13496h;

    /* renamed from: i  reason: collision with root package name */
    private static final HashMap<Object, Object[]> f13497i = new HashMap<>();

    public static Handler a(int i10) {
        if (i10 == 0) {
            if (f13490b == null) {
                a();
            }
            return f13493e;
        } else if (i10 == 1) {
            if (f13491c == null) {
                b();
            }
            return f13494f;
        } else if (i10 == 2) {
            if (f13495g == null) {
                f13495g = new Handler(Looper.getMainLooper());
            }
            return f13495g;
        } else if (i10 == 3) {
            if (f13496h == null) {
                c();
            }
            return f13496h;
        } else {
            throw new RuntimeException("unknown thread type: " + i10);
        }
    }

    public static boolean b(Runnable runnable) {
        Object[] objArr;
        if (runnable == null) {
            return false;
        }
        HashMap<Object, Object[]> hashMap = f13497i;
        synchronized (hashMap) {
            objArr = hashMap.get(runnable);
        }
        if (objArr != null) {
            return true;
        }
        return false;
    }

    private static synchronized void c() {
        synchronized (f.class) {
            if (f13492d == null) {
                HandlerThread handlerThread = new HandlerThread("CrashSDKAnrHandler", 0);
                f13492d = handlerThread;
                handlerThread.start();
                f13496h = new Handler(f13492d.getLooper());
            }
        }
    }

    private static synchronized void b() {
        synchronized (f.class) {
            if (f13491c == null) {
                HandlerThread handlerThread = new HandlerThread("CrashSDKNormalHandler", 0);
                f13491c = handlerThread;
                handlerThread.start();
                f13494f = new Handler(f13491c.getLooper());
            }
        }
    }

    public static boolean a(int i10, Runnable runnable, long j10) {
        Handler a10;
        if (runnable == null || (a10 = a(i10)) == null) {
            return false;
        }
        e eVar = new e(10, new Object[]{runnable});
        HashMap<Object, Object[]> hashMap = f13497i;
        synchronized (hashMap) {
            hashMap.put(runnable, new Object[]{eVar, Integer.valueOf(i10)});
        }
        return a10.postDelayed(eVar, j10);
    }

    public static void a(int i10, Object[] objArr) {
        if (i10 != 10) {
            if (!f13489a) {
                throw new AssertionError();
            }
        } else if (f13489a || objArr != null) {
            Runnable runnable = objArr[0];
            HashMap<Object, Object[]> hashMap = f13497i;
            synchronized (hashMap) {
                if (hashMap.get(runnable) != null) {
                    hashMap.remove(runnable);
                }
            }
            runnable.run();
        } else {
            throw new AssertionError();
        }
    }

    public static boolean a(int i10, Runnable runnable) {
        return a(i10, runnable, 0);
    }

    public static void a(Runnable runnable) {
        Object[] objArr;
        Handler handler;
        if (runnable != null) {
            HashMap<Object, Object[]> hashMap = f13497i;
            synchronized (hashMap) {
                objArr = hashMap.get(runnable);
            }
            if (objArr != null) {
                int intValue = ((Integer) objArr[1]).intValue();
                if (intValue == 0) {
                    handler = f13493e;
                } else if (intValue == 1) {
                    handler = f13494f;
                } else if (intValue != 2) {
                    handler = null;
                } else {
                    handler = f13495g;
                }
                if (handler != null) {
                    handler.removeCallbacks((Runnable) objArr[0]);
                }
                synchronized (hashMap) {
                    if (hashMap.get(runnable) != null) {
                        hashMap.remove(runnable);
                    }
                }
            }
        }
    }

    private static synchronized void a() {
        synchronized (f.class) {
            if (f13490b == null) {
                HandlerThread handlerThread = new HandlerThread("CrashSDKBkgdHandler", 10);
                f13490b = handlerThread;
                handlerThread.start();
                f13493e = new Handler(f13490b.getLooper());
            }
        }
    }
}
