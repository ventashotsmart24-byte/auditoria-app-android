package j1;

import a1.k;
import a1.o;
import a1.s;
import androidx.appcompat.app.m;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class p {

    /* renamed from: s  reason: collision with root package name */
    public static final String f7087s = k.f("WorkSpec");

    /* renamed from: t  reason: collision with root package name */
    public static final j.a f7088t = new a();

    /* renamed from: a  reason: collision with root package name */
    public String f7089a;

    /* renamed from: b  reason: collision with root package name */
    public s f7090b = s.ENQUEUED;

    /* renamed from: c  reason: collision with root package name */
    public String f7091c;

    /* renamed from: d  reason: collision with root package name */
    public String f7092d;

    /* renamed from: e  reason: collision with root package name */
    public androidx.work.b f7093e;

    /* renamed from: f  reason: collision with root package name */
    public androidx.work.b f7094f;

    /* renamed from: g  reason: collision with root package name */
    public long f7095g;

    /* renamed from: h  reason: collision with root package name */
    public long f7096h;

    /* renamed from: i  reason: collision with root package name */
    public long f7097i;

    /* renamed from: j  reason: collision with root package name */
    public a1.b f7098j;

    /* renamed from: k  reason: collision with root package name */
    public int f7099k;

    /* renamed from: l  reason: collision with root package name */
    public a1.a f7100l;

    /* renamed from: m  reason: collision with root package name */
    public long f7101m;

    /* renamed from: n  reason: collision with root package name */
    public long f7102n;

    /* renamed from: o  reason: collision with root package name */
    public long f7103o;

    /* renamed from: p  reason: collision with root package name */
    public long f7104p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f7105q;

    /* renamed from: r  reason: collision with root package name */
    public o f7106r;

    public class a implements j.a {
        /* renamed from: a */
        public List apply(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            if (!it.hasNext()) {
                return arrayList;
            }
            m.a(it.next());
            throw null;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f7107a;

        /* renamed from: b  reason: collision with root package name */
        public s f7108b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f7108b != bVar.f7108b) {
                return false;
            }
            return this.f7107a.equals(bVar.f7107a);
        }

        public int hashCode() {
            return (this.f7107a.hashCode() * 31) + this.f7108b.hashCode();
        }
    }

    public p(String str, String str2) {
        androidx.work.b bVar = androidx.work.b.f3382c;
        this.f7093e = bVar;
        this.f7094f = bVar;
        this.f7098j = a1.b.f83i;
        this.f7100l = a1.a.EXPONENTIAL;
        this.f7101m = NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS;
        this.f7104p = -1;
        this.f7106r = o.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f7089a = str;
        this.f7091c = str2;
    }

    public long a() {
        long j10;
        long j11;
        boolean z10 = false;
        if (c()) {
            if (this.f7100l == a1.a.LINEAR) {
                z10 = true;
            }
            if (z10) {
                j11 = this.f7101m * ((long) this.f7099k);
            } else {
                j11 = (long) Math.scalb((float) this.f7101m, this.f7099k - 1);
            }
            return this.f7102n + Math.min(18000000, j11);
        }
        long j12 = 0;
        if (d()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j13 = this.f7102n;
            if (j13 == 0) {
                j10 = currentTimeMillis + this.f7095g;
            } else {
                j10 = j13;
            }
            long j14 = this.f7097i;
            long j15 = this.f7096h;
            if (j14 != j15) {
                z10 = true;
            }
            if (z10) {
                if (j13 == 0) {
                    j12 = j14 * -1;
                }
                return j10 + j15 + j12;
            }
            if (j13 != 0) {
                j12 = j15;
            }
            return j10 + j12;
        }
        long j16 = this.f7102n;
        if (j16 == 0) {
            j16 = System.currentTimeMillis();
        }
        return j16 + this.f7095g;
    }

    public boolean b() {
        return !a1.b.f83i.equals(this.f7098j);
    }

    public boolean c() {
        if (this.f7090b != s.ENQUEUED || this.f7099k <= 0) {
            return false;
        }
        return true;
    }

    public boolean d() {
        if (this.f7096h != 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f7095g != pVar.f7095g || this.f7096h != pVar.f7096h || this.f7097i != pVar.f7097i || this.f7099k != pVar.f7099k || this.f7101m != pVar.f7101m || this.f7102n != pVar.f7102n || this.f7103o != pVar.f7103o || this.f7104p != pVar.f7104p || this.f7105q != pVar.f7105q || !this.f7089a.equals(pVar.f7089a) || this.f7090b != pVar.f7090b || !this.f7091c.equals(pVar.f7091c)) {
            return false;
        }
        String str = this.f7092d;
        if (str == null ? pVar.f7092d != null : !str.equals(pVar.f7092d)) {
            return false;
        }
        if (this.f7093e.equals(pVar.f7093e) && this.f7094f.equals(pVar.f7094f) && this.f7098j.equals(pVar.f7098j) && this.f7100l == pVar.f7100l && this.f7106r == pVar.f7106r) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = ((((this.f7089a.hashCode() * 31) + this.f7090b.hashCode()) * 31) + this.f7091c.hashCode()) * 31;
        String str = this.f7092d;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        long j10 = this.f7095g;
        long j11 = this.f7096h;
        long j12 = this.f7097i;
        long j13 = this.f7101m;
        long j14 = this.f7102n;
        long j15 = this.f7103o;
        long j16 = this.f7104p;
        return ((((((((((((((((((((((((((((hashCode + i10) * 31) + this.f7093e.hashCode()) * 31) + this.f7094f.hashCode()) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31) + this.f7098j.hashCode()) * 31) + this.f7099k) * 31) + this.f7100l.hashCode()) * 31) + ((int) (j13 ^ (j13 >>> 32)))) * 31) + ((int) (j14 ^ (j14 >>> 32)))) * 31) + ((int) (j15 ^ (j15 >>> 32)))) * 31) + ((int) (j16 ^ (j16 >>> 32)))) * 31) + (this.f7105q ? 1 : 0)) * 31) + this.f7106r.hashCode();
    }

    public String toString() {
        return "{WorkSpec: " + this.f7089a + "}";
    }

    public p(p pVar) {
        androidx.work.b bVar = androidx.work.b.f3382c;
        this.f7093e = bVar;
        this.f7094f = bVar;
        this.f7098j = a1.b.f83i;
        this.f7100l = a1.a.EXPONENTIAL;
        this.f7101m = NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS;
        this.f7104p = -1;
        this.f7106r = o.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f7089a = pVar.f7089a;
        this.f7091c = pVar.f7091c;
        this.f7090b = pVar.f7090b;
        this.f7092d = pVar.f7092d;
        this.f7093e = new androidx.work.b(pVar.f7093e);
        this.f7094f = new androidx.work.b(pVar.f7094f);
        this.f7095g = pVar.f7095g;
        this.f7096h = pVar.f7096h;
        this.f7097i = pVar.f7097i;
        this.f7098j = new a1.b(pVar.f7098j);
        this.f7099k = pVar.f7099k;
        this.f7100l = pVar.f7100l;
        this.f7101m = pVar.f7101m;
        this.f7102n = pVar.f7102n;
        this.f7103o = pVar.f7103o;
        this.f7104p = pVar.f7104p;
        this.f7105q = pVar.f7105q;
        this.f7106r = pVar.f7106r;
    }
}
