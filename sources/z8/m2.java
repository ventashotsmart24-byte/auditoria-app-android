package z8;

import com.google.common.base.Preconditions;

public final class m2 {

    /* renamed from: l  reason: collision with root package name */
    public static final b f20788l = new b(j2.f20705a);

    /* renamed from: a  reason: collision with root package name */
    public final j2 f20789a;

    /* renamed from: b  reason: collision with root package name */
    public long f20790b;

    /* renamed from: c  reason: collision with root package name */
    public long f20791c;

    /* renamed from: d  reason: collision with root package name */
    public long f20792d;

    /* renamed from: e  reason: collision with root package name */
    public long f20793e;

    /* renamed from: f  reason: collision with root package name */
    public long f20794f;

    /* renamed from: g  reason: collision with root package name */
    public c f20795g;

    /* renamed from: h  reason: collision with root package name */
    public long f20796h;

    /* renamed from: i  reason: collision with root package name */
    public long f20797i;

    /* renamed from: j  reason: collision with root package name */
    public final d1 f20798j;

    /* renamed from: k  reason: collision with root package name */
    public volatile long f20799k;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final j2 f20800a;

        public b(j2 j2Var) {
            this.f20800a = j2Var;
        }

        public m2 a() {
            return new m2(this.f20800a);
        }
    }

    public interface c {
    }

    public static b a() {
        return f20788l;
    }

    public void b() {
        this.f20794f++;
    }

    public void c() {
        this.f20790b++;
        this.f20791c = this.f20789a.a();
    }

    public void d() {
        this.f20798j.add(1);
        this.f20799k = this.f20789a.a();
    }

    public void e(int i10) {
        if (i10 != 0) {
            this.f20796h += (long) i10;
            this.f20797i = this.f20789a.a();
        }
    }

    public void f(boolean z10) {
        if (z10) {
            this.f20792d++;
        } else {
            this.f20793e++;
        }
    }

    public void g(c cVar) {
        this.f20795g = (c) Preconditions.checkNotNull(cVar);
    }

    public m2(j2 j2Var) {
        this.f20798j = e1.a();
        this.f20789a = j2Var;
    }
}
