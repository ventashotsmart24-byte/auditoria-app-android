package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.HashMap;

public class az {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f13810a = null;

    /* renamed from: b  reason: collision with root package name */
    public static final int f13811b = 101;

    /* renamed from: c  reason: collision with root package name */
    private static HandlerThread f13812c = null;

    /* renamed from: d  reason: collision with root package name */
    private static HashMap<Integer, a> f13813d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final int f13814e = 256;

    public interface a {
        void a(Object obj, int i10);
    }

    private az() {
    }

    /* access modifiers changed from: private */
    public static void b(Message message) {
        a aVar;
        int i10 = message.arg1;
        Object obj = message.obj;
        Integer valueOf = Integer.valueOf(i10 / 100);
        HashMap<Integer, a> hashMap = f13813d;
        if (hashMap != null) {
            if (hashMap.containsKey(valueOf)) {
                aVar = f13813d.get(valueOf);
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
            if (f13813d == null) {
                f13813d = new HashMap<>();
            }
            Integer valueOf = Integer.valueOf(i11 / 100);
            if (!f13813d.containsKey(valueOf)) {
                f13813d.put(valueOf, aVar);
            }
            if (f13812c == null || f13810a == null) {
                a();
            }
            try {
                Handler handler = f13810a;
                if (handler != null) {
                    Message obtainMessage = handler.obtainMessage();
                    obtainMessage.what = i10;
                    obtainMessage.arg1 = i11;
                    obtainMessage.obj = obj;
                    f13810a.sendMessageDelayed(obtainMessage, j10);
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
        synchronized (az.class) {
            try {
                if (f13812c == null) {
                    HandlerThread handlerThread = new HandlerThread("ck_dispatch");
                    f13812c = handlerThread;
                    handlerThread.start();
                    if (f13810a == null) {
                        f13810a = new Handler(f13812c.getLooper()) {
                            public void handleMessage(Message message) {
                                if (message.what == 256) {
                                    az.b(message);
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
