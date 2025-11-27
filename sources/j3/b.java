package j3;

import java.lang.ref.SoftReference;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final p f7141a;

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal f7142b = new ThreadLocal();

    static {
        boolean z10;
        p pVar;
        try {
            z10 = "true".equals(System.getProperty("com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers"));
        } catch (SecurityException unused) {
            z10 = false;
        }
        if (z10) {
            pVar = p.a();
        } else {
            pVar = null;
        }
        f7141a = pVar;
    }

    public static a a() {
        a aVar;
        SoftReference softReference;
        ThreadLocal threadLocal = f7142b;
        SoftReference softReference2 = (SoftReference) threadLocal.get();
        if (softReference2 == null) {
            aVar = null;
        } else {
            aVar = (a) softReference2.get();
        }
        if (aVar == null) {
            aVar = new a();
            p pVar = f7141a;
            if (pVar != null) {
                softReference = pVar.c(aVar);
            } else {
                softReference = new SoftReference(aVar);
            }
            threadLocal.set(softReference);
        }
        return aVar;
    }
}
