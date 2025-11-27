package j3;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class p {

    /* renamed from: a  reason: collision with root package name */
    public final Object f7189a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final Map f7190b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public final ReferenceQueue f7191c = new ReferenceQueue();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final p f7192a = new p();
    }

    public static p a() {
        return a.f7192a;
    }

    public final void b() {
        while (true) {
            SoftReference softReference = (SoftReference) this.f7191c.poll();
            if (softReference != null) {
                this.f7190b.remove(softReference);
            } else {
                return;
            }
        }
    }

    public SoftReference c(a aVar) {
        SoftReference softReference = new SoftReference(aVar, this.f7191c);
        this.f7190b.put(softReference, Boolean.TRUE);
        b();
        return softReference;
    }
}
