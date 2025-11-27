package h1;

import android.content.Context;
import m1.a;

public class l {

    /* renamed from: e  reason: collision with root package name */
    public static l f6875e;

    /* renamed from: a  reason: collision with root package name */
    public a f6876a;

    /* renamed from: b  reason: collision with root package name */
    public b f6877b;

    /* renamed from: c  reason: collision with root package name */
    public j f6878c;

    /* renamed from: d  reason: collision with root package name */
    public k f6879d;

    public l(Context context, a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.f6876a = new a(applicationContext, aVar);
        this.f6877b = new b(applicationContext, aVar);
        this.f6878c = new j(applicationContext, aVar);
        this.f6879d = new k(applicationContext, aVar);
    }

    public static synchronized l c(Context context, a aVar) {
        l lVar;
        synchronized (l.class) {
            if (f6875e == null) {
                f6875e = new l(context, aVar);
            }
            lVar = f6875e;
        }
        return lVar;
    }

    public a a() {
        return this.f6876a;
    }

    public b b() {
        return this.f6877b;
    }

    public j d() {
        return this.f6878c;
    }

    public k e() {
        return this.f6879d;
    }
}
