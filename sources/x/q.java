package x;

import android.os.Build;
import android.os.Trace;
import java.lang.reflect.Method;

public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    public static long f9551a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f9552b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f9553c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f9554d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f9555e;

    static {
        Class<String> cls = String.class;
        Class<Trace> cls2 = Trace.class;
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f9551a = cls2.getField("TRACE_TAG_APP").getLong((Object) null);
                Class cls3 = Long.TYPE;
                f9552b = cls2.getMethod("isTagEnabled", new Class[]{cls3});
                Class cls4 = Integer.TYPE;
                f9553c = cls2.getMethod("asyncTraceBegin", new Class[]{cls3, cls, cls4});
                f9554d = cls2.getMethod("asyncTraceEnd", new Class[]{cls3, cls, cls4});
                f9555e = cls2.getMethod("traceCounter", new Class[]{cls3, cls, cls4});
            } catch (Exception unused) {
            }
        }
    }

    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
