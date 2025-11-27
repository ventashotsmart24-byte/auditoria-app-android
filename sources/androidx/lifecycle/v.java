package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class v {

    /* renamed from: a  reason: collision with root package name */
    public final Map f2339a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f2340b = false;

    public static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    public final void a() {
        this.f2340b = true;
        Map map = this.f2339a;
        if (map != null) {
            synchronized (map) {
                for (Object b10 : this.f2339a.values()) {
                    b(b10);
                }
            }
        }
        d();
    }

    public Object c(String str) {
        Object obj;
        Map map = this.f2339a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            obj = this.f2339a.get(str);
        }
        return obj;
    }

    public void d() {
    }

    public Object e(String str, Object obj) {
        Object obj2;
        synchronized (this.f2339a) {
            obj2 = this.f2339a.get(str);
            if (obj2 == null) {
                this.f2339a.put(str, obj);
            }
        }
        if (obj2 != null) {
            obj = obj2;
        }
        if (this.f2340b) {
            b(obj);
        }
        return obj;
    }
}
