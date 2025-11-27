package y4;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.List;
import s4.b;

public class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public transient b f19892a;

    /* renamed from: b  reason: collision with root package name */
    public z4.a f19893b;

    /* renamed from: c  reason: collision with root package name */
    public String f19894c;

    /* renamed from: d  reason: collision with root package name */
    public long f19895d;

    /* renamed from: e  reason: collision with root package name */
    public String f19896e;

    /* renamed from: f  reason: collision with root package name */
    public String f19897f;

    /* renamed from: g  reason: collision with root package name */
    public String f19898g;

    /* renamed from: h  reason: collision with root package name */
    public long f19899h;

    /* renamed from: i  reason: collision with root package name */
    public long f19900i;

    /* renamed from: j  reason: collision with root package name */
    public int f19901j;

    /* renamed from: k  reason: collision with root package name */
    public String f19902k;

    /* renamed from: l  reason: collision with root package name */
    public int f19903l = -1;

    /* renamed from: m  reason: collision with root package name */
    public int f19904m;

    /* renamed from: n  reason: collision with root package name */
    public List f19905n;

    /* renamed from: y4.a$a  reason: collision with other inner class name */
    public static final class C0293a {

        /* renamed from: a  reason: collision with root package name */
        public String f19906a;

        /* renamed from: b  reason: collision with root package name */
        public long f19907b = -1;

        /* renamed from: c  reason: collision with root package name */
        public String f19908c;

        /* renamed from: d  reason: collision with root package name */
        public String f19909d;

        /* renamed from: e  reason: collision with root package name */
        public String f19910e;

        public a a() {
            a aVar = new a();
            if (!TextUtils.isEmpty(this.f19908c)) {
                aVar.F(this.f19908c);
                if (!TextUtils.isEmpty(this.f19910e)) {
                    aVar.z(this.f19910e);
                    if (this.f19907b == -1) {
                        aVar.t(System.currentTimeMillis());
                    }
                    aVar.r(this.f19909d);
                    if (TextUtils.isEmpty(this.f19906a)) {
                        aVar.y(this.f19908c);
                    } else {
                        aVar.y(this.f19906a);
                    }
                    return aVar;
                }
                throw new z4.a(1, "path cannot be null.");
            }
            throw new z4.a(0, "uri cannot be null.");
        }

        public C0293a b(String str) {
            this.f19909d = str;
            return this;
        }

        public C0293a c(String str) {
            this.f19906a = str;
            return this;
        }

        public C0293a d(String str) {
            this.f19910e = str;
            return this;
        }

        public C0293a e(String str) {
            this.f19908c = str;
            return this;
        }
    }

    public void A(long j10) {
        this.f19900i = j10;
    }

    public void B(long j10) {
        this.f19899h = j10;
    }

    public void C(int i10) {
        this.f19901j = i10;
    }

    public void D(int i10) {
        this.f19904m = i10;
    }

    public void E(boolean z10) {
        this.f19904m = z10 ^ true ? 1 : 0;
    }

    public void F(String str) {
        this.f19896e = str;
    }

    public String a() {
        return this.f19897f;
    }

    public int b() {
        return this.f19903l;
    }

    public long c() {
        return this.f19895d;
    }

    public b d() {
        return this.f19892a;
    }

    public List e() {
        return this.f19905n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.f19894c == ((a) obj).f19894c) {
            return true;
        }
        return false;
    }

    public z4.a f() {
        return this.f19893b;
    }

    public String g() {
        return this.f19894c;
    }

    public String h() {
        return this.f19898g;
    }

    public int hashCode() {
        return this.f19894c.hashCode();
    }

    public long i() {
        return this.f19900i;
    }

    public long j() {
        return this.f19899h;
    }

    public int k() {
        return this.f19901j;
    }

    public int l() {
        return this.f19904m;
    }

    public String m() {
        return this.f19896e;
    }

    public boolean n() {
        if (this.f19901j == 5) {
            return true;
        }
        return false;
    }

    public boolean o() {
        int i10 = this.f19901j;
        if (i10 == 2 || i10 == 1 || i10 == 3) {
            return true;
        }
        return false;
    }

    public boolean p() {
        int i10 = this.f19901j;
        if (i10 == 4 || i10 == 6 || i10 == 7) {
            return true;
        }
        return false;
    }

    public boolean q() {
        if (this.f19904m == 0) {
            return true;
        }
        return false;
    }

    public void r(String str) {
        this.f19897f = str;
    }

    public void s(int i10) {
        this.f19903l = i10;
    }

    public void t(long j10) {
        this.f19895d = j10;
    }

    public void u(b bVar) {
        this.f19892a = bVar;
    }

    public void v(List list) {
        this.f19905n = list;
    }

    public void w(String str) {
        this.f19902k = str;
    }

    public void x(z4.a aVar) {
        this.f19893b = aVar;
    }

    public void y(String str) {
        this.f19894c = str;
    }

    public void z(String str) {
        this.f19898g = str;
    }
}
