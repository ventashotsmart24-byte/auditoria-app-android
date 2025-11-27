package n0;

import android.content.Context;
import java.lang.ref.WeakReference;
import n0.l1;

public abstract class u1 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f8154a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f8155b;

    /* renamed from: c  reason: collision with root package name */
    public c f8156c;

    public static class a extends u1 {

        /* renamed from: d  reason: collision with root package name */
        public final Object f8157d;

        /* renamed from: e  reason: collision with root package name */
        public final Object f8158e;

        /* renamed from: f  reason: collision with root package name */
        public final Object f8159f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f8160g;

        /* renamed from: n0.u1$a$a  reason: collision with other inner class name */
        public static final class C0104a implements l1.e {

            /* renamed from: a  reason: collision with root package name */
            public final WeakReference f8161a;

            public C0104a(a aVar) {
                this.f8161a = new WeakReference(aVar);
            }

            public void a(Object obj, int i10) {
                c cVar;
                a aVar = (a) this.f8161a.get();
                if (aVar != null && (cVar = aVar.f8156c) != null) {
                    cVar.b(i10);
                }
            }

            public void d(Object obj, int i10) {
                c cVar;
                a aVar = (a) this.f8161a.get();
                if (aVar != null && (cVar = aVar.f8156c) != null) {
                    cVar.a(i10);
                }
            }
        }

        public a(Context context, Object obj) {
            super(context, obj);
            Object e10 = l1.e(context);
            this.f8157d = e10;
            Object b10 = l1.b(e10, "", false);
            this.f8158e = b10;
            this.f8159f = l1.c(e10, b10);
        }

        public void c(b bVar) {
            l1.d.e(this.f8159f, bVar.f8162a);
            l1.d.h(this.f8159f, bVar.f8163b);
            l1.d.g(this.f8159f, bVar.f8164c);
            l1.d.b(this.f8159f, bVar.f8165d);
            l1.d.c(this.f8159f, bVar.f8166e);
            if (!this.f8160g) {
                this.f8160g = true;
                l1.d.f(this.f8159f, l1.d(new C0104a(this)));
                l1.d.d(this.f8159f, this.f8155b);
            }
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public int f8162a;

        /* renamed from: b  reason: collision with root package name */
        public int f8163b;

        /* renamed from: c  reason: collision with root package name */
        public int f8164c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f8165d = 3;

        /* renamed from: e  reason: collision with root package name */
        public int f8166e = 1;

        /* renamed from: f  reason: collision with root package name */
        public String f8167f;
    }

    public interface c {
        void a(int i10);

        void b(int i10);
    }

    public u1(Context context, Object obj) {
        this.f8154a = context;
        this.f8155b = obj;
    }

    public static u1 b(Context context, Object obj) {
        return new a(context, obj);
    }

    public Object a() {
        return this.f8155b;
    }

    public abstract void c(b bVar);

    public void d(c cVar) {
        this.f8156c = cVar;
    }
}
