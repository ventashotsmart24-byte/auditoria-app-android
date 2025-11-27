package com.umeng.ccg;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.HashMap;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f14541a = null;

    /* renamed from: b  reason: collision with root package name */
    public static final int f14542b = 101;

    /* renamed from: c  reason: collision with root package name */
    public static final int f14543c = 102;

    /* renamed from: d  reason: collision with root package name */
    public static final int f14544d = 103;

    /* renamed from: e  reason: collision with root package name */
    public static final int f14545e = 104;

    /* renamed from: f  reason: collision with root package name */
    public static final int f14546f = 105;

    /* renamed from: g  reason: collision with root package name */
    public static final int f14547g = 106;

    /* renamed from: h  reason: collision with root package name */
    public static final int f14548h = 107;

    /* renamed from: i  reason: collision with root package name */
    public static final int f14549i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static final int f14550j = 1;

    /* renamed from: k  reason: collision with root package name */
    public static final int f14551k = 2;

    /* renamed from: l  reason: collision with root package name */
    public static final int f14552l = 201;

    /* renamed from: m  reason: collision with root package name */
    public static final int f14553m = 202;

    /* renamed from: n  reason: collision with root package name */
    public static final int f14554n = 203;

    /* renamed from: o  reason: collision with root package name */
    public static final int f14555o = 301;

    /* renamed from: p  reason: collision with root package name */
    public static final int f14556p = 302;

    /* renamed from: q  reason: collision with root package name */
    public static final int f14557q = 303;

    /* renamed from: r  reason: collision with root package name */
    public static final int f14558r = 304;

    /* renamed from: s  reason: collision with root package name */
    public static final int f14559s = 305;

    /* renamed from: t  reason: collision with root package name */
    private static HandlerThread f14560t = null;

    /* renamed from: u  reason: collision with root package name */
    private static HashMap<Integer, a> f14561u = null;

    /* renamed from: v  reason: collision with root package name */
    private static final int f14562v = 256;

    public interface a {
        void a(Object obj, int i10);
    }

    private c() {
    }

    /* access modifiers changed from: private */
    public static void b(Message message) {
        a aVar;
        int i10 = message.arg1;
        Object obj = message.obj;
        Integer valueOf = Integer.valueOf(i10 / 100);
        HashMap<Integer, a> hashMap = f14561u;
        if (hashMap != null) {
            if (hashMap.containsKey(valueOf)) {
                aVar = f14561u.get(valueOf);
            } else {
                aVar = null;
            }
            if (aVar != null) {
                aVar.a(obj, i10);
            }
        }
    }

    public static void a(Context context, int i10, int i11, a aVar, Object obj, long j10) {
        if (context != null && aVar != null) {
            if (f14561u == null) {
                f14561u = new HashMap<>();
            }
            Integer valueOf = Integer.valueOf(i11 / 100);
            if (!f14561u.containsKey(valueOf)) {
                f14561u.put(valueOf, aVar);
            }
            if (f14560t == null || f14541a == null) {
                a();
            }
            try {
                Handler handler = f14541a;
                if (handler != null) {
                    Message obtainMessage = handler.obtainMessage();
                    obtainMessage.what = i10;
                    obtainMessage.arg1 = i11;
                    obtainMessage.obj = obj;
                    f14541a.sendMessageDelayed(obtainMessage, j10);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, int i10, a aVar, Object obj) {
        a(context, 256, i10, aVar, obj, 0);
    }

    public static void a(Context context, int i10, a aVar, Object obj, long j10) {
        a(context, 256, i10, aVar, obj, j10);
    }

    private static synchronized void a() {
        synchronized (c.class) {
            try {
                if (f14560t == null) {
                    HandlerThread handlerThread = new HandlerThread("ccg_dispatch");
                    f14560t = handlerThread;
                    handlerThread.start();
                    if (f14541a == null) {
                        f14541a = new Handler(f14560t.getLooper()) {
                            public void handleMessage(Message message) {
                                if (message.what == 256) {
                                    c.b(message);
                                }
                            }
                        };
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
