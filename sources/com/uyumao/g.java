package com.uyumao;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.HashMap;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public static HandlerThread f16274a;

    /* renamed from: b  reason: collision with root package name */
    public static Handler f16275b;

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<Integer, a> f16276c;

    public interface a {
        void a(Object obj, int i10);
    }

    public static void a(Context context, int i10, int i11, a aVar, Object obj, long j10) {
        if (context != null && aVar != null) {
            if (f16276c == null) {
                f16276c = new HashMap<>();
            }
            Integer valueOf = Integer.valueOf(i11 / 100);
            if (!f16276c.containsKey(valueOf)) {
                f16276c.put(valueOf, aVar);
            }
            if (f16274a == null || f16275b == null) {
                synchronized (g.class) {
                    try {
                        if (f16274a == null) {
                            HandlerThread handlerThread = new HandlerThread("yumao_ccg");
                            f16274a = handlerThread;
                            handlerThread.start();
                            if (f16275b == null) {
                                f16275b = new f(f16274a.getLooper());
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            try {
                Handler handler = f16275b;
                if (handler != null) {
                    Message obtainMessage = handler.obtainMessage();
                    obtainMessage.what = i10;
                    obtainMessage.arg1 = i11;
                    obtainMessage.obj = obj;
                    f16275b.sendMessageDelayed(obtainMessage, j10);
                }
            } catch (Throwable unused2) {
            }
        }
    }

    public static void a(Context context, int i10, a aVar, Object obj) {
        a(context, 256, i10, aVar, obj, 0);
    }
}
