package g;

import android.view.View;
import android.view.animation.Interpolator;
import b0.a2;
import b0.b2;
import b0.c2;
import java.util.ArrayList;
import java.util.Iterator;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f6679a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public long f6680b = -1;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f6681c;

    /* renamed from: d  reason: collision with root package name */
    public b2 f6682d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6683e;

    /* renamed from: f  reason: collision with root package name */
    public final c2 f6684f = new a();

    public class a extends c2 {

        /* renamed from: a  reason: collision with root package name */
        public boolean f6685a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f6686b = 0;

        public a() {
        }

        public void b(View view) {
            int i10 = this.f6686b + 1;
            this.f6686b = i10;
            if (i10 == h.this.f6679a.size()) {
                b2 b2Var = h.this.f6682d;
                if (b2Var != null) {
                    b2Var.b((View) null);
                }
                d();
            }
        }

        public void c(View view) {
            if (!this.f6685a) {
                this.f6685a = true;
                b2 b2Var = h.this.f6682d;
                if (b2Var != null) {
                    b2Var.c((View) null);
                }
            }
        }

        public void d() {
            this.f6686b = 0;
            this.f6685a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.f6683e) {
            Iterator it = this.f6679a.iterator();
            while (it.hasNext()) {
                ((a2) it.next()).b();
            }
            this.f6683e = false;
        }
    }

    public void b() {
        this.f6683e = false;
    }

    public h c(a2 a2Var) {
        if (!this.f6683e) {
            this.f6679a.add(a2Var);
        }
        return this;
    }

    public h d(a2 a2Var, a2 a2Var2) {
        this.f6679a.add(a2Var);
        a2Var2.h(a2Var.c());
        this.f6679a.add(a2Var2);
        return this;
    }

    public h e(long j10) {
        if (!this.f6683e) {
            this.f6680b = j10;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f6683e) {
            this.f6681c = interpolator;
        }
        return this;
    }

    public h g(b2 b2Var) {
        if (!this.f6683e) {
            this.f6682d = b2Var;
        }
        return this;
    }

    public void h() {
        if (!this.f6683e) {
            Iterator it = this.f6679a.iterator();
            while (it.hasNext()) {
                a2 a2Var = (a2) it.next();
                long j10 = this.f6680b;
                if (j10 >= 0) {
                    a2Var.d(j10);
                }
                Interpolator interpolator = this.f6681c;
                if (interpolator != null) {
                    a2Var.e(interpolator);
                }
                if (this.f6682d != null) {
                    a2Var.f(this.f6684f);
                }
                a2Var.j();
            }
            this.f6683e = true;
        }
    }
}
