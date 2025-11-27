package da;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import h9.l;
import h9.m;
import t9.g;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public static final d f16439a;
    private static volatile Choreographer choreographer;

    static {
        Object obj;
        d dVar = null;
        try {
            l.a aVar = l.f17317a;
            obj = l.a(new c(a(Looper.getMainLooper(), true), (String) null, 2, (g) null));
        } catch (Throwable th) {
            l.a aVar2 = l.f17317a;
            obj = l.a(m.a(th));
        }
        if (!l.c(obj)) {
            dVar = obj;
        }
        f16439a = dVar;
    }

    public static final Handler a(Looper looper, boolean z10) {
        if (!z10) {
            return new Handler(looper);
        }
        Class<Looper> cls = Looper.class;
        Class<Handler> cls2 = Handler.class;
        if (Build.VERSION.SDK_INT >= 28) {
            Object invoke = cls2.getDeclaredMethod("createAsync", new Class[]{cls}).invoke((Object) null, new Object[]{looper});
            if (invoke != null) {
                return (Handler) invoke;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
        }
        try {
            return cls2.getDeclaredConstructor(new Class[]{cls, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }
}
