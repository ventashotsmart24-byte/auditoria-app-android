package y;

import android.graphics.Typeface;
import android.os.Handler;
import y.e;
import y.f;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final f.c f9803a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f9804b;

    /* renamed from: y.a$a  reason: collision with other inner class name */
    public class C0132a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f.c f9805a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Typeface f9806b;

        public C0132a(f.c cVar, Typeface typeface) {
            this.f9805a = cVar;
            this.f9806b = typeface;
        }

        public void run() {
            this.f9805a.b(this.f9806b);
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f.c f9808a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f9809b;

        public b(f.c cVar, int i10) {
            this.f9808a = cVar;
            this.f9809b = i10;
        }

        public void run() {
            this.f9808a.a(this.f9809b);
        }
    }

    public a(f.c cVar, Handler handler) {
        this.f9803a = cVar;
        this.f9804b = handler;
    }

    public final void a(int i10) {
        this.f9804b.post(new b(this.f9803a, i10));
    }

    public void b(e.C0133e eVar) {
        if (eVar.a()) {
            c(eVar.f9832a);
        } else {
            a(eVar.f9833b);
        }
    }

    public final void c(Typeface typeface) {
        this.f9804b.post(new C0132a(this.f9803a, typeface));
    }
}
