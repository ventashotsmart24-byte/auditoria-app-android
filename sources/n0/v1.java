package n0;

import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.view.Display;
import androidx.mediarouter.R$string;
import com.hpplay.component.protocol.mirror.AutoStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import n0.l1;
import n0.m1;
import n0.n0;
import n0.n1;
import n0.p0;
import n0.q0;
import n0.t0;

public abstract class v1 extends p0 {

    public static class a extends d {
        public a(Context context, e eVar) {
            super(context, eVar);
        }

        public void O(b.C0105b bVar, n0.a aVar) {
            super.O(bVar, aVar);
            aVar.i(k1.a(bVar.f8182a));
        }
    }

    public static class b extends v1 implements l1.a, l1.e {

        /* renamed from: s  reason: collision with root package name */
        public static final ArrayList f8169s;

        /* renamed from: t  reason: collision with root package name */
        public static final ArrayList f8170t;

        /* renamed from: i  reason: collision with root package name */
        public final e f8171i;

        /* renamed from: j  reason: collision with root package name */
        public final Object f8172j;

        /* renamed from: k  reason: collision with root package name */
        public final Object f8173k;

        /* renamed from: l  reason: collision with root package name */
        public final Object f8174l;

        /* renamed from: m  reason: collision with root package name */
        public final Object f8175m;

        /* renamed from: n  reason: collision with root package name */
        public int f8176n;

        /* renamed from: o  reason: collision with root package name */
        public boolean f8177o;

        /* renamed from: p  reason: collision with root package name */
        public boolean f8178p;

        /* renamed from: q  reason: collision with root package name */
        public final ArrayList f8179q = new ArrayList();

        /* renamed from: r  reason: collision with root package name */
        public final ArrayList f8180r = new ArrayList();

        public static final class a extends p0.e {

            /* renamed from: a  reason: collision with root package name */
            public final Object f8181a;

            public a(Object obj) {
                this.f8181a = obj;
            }

            public void f(int i10) {
                l1.c.i(this.f8181a, i10);
            }

            public void i(int i10) {
                l1.c.j(this.f8181a, i10);
            }
        }

        /* renamed from: n0.v1$b$b  reason: collision with other inner class name */
        public static final class C0105b {

            /* renamed from: a  reason: collision with root package name */
            public final Object f8182a;

            /* renamed from: b  reason: collision with root package name */
            public final String f8183b;

            /* renamed from: c  reason: collision with root package name */
            public n0 f8184c;

            public C0105b(Object obj, String str) {
                this.f8182a = obj;
                this.f8183b = str;
            }
        }

        public static final class c {

            /* renamed from: a  reason: collision with root package name */
            public final t0.i f8185a;

            /* renamed from: b  reason: collision with root package name */
            public final Object f8186b;

            public c(t0.i iVar, Object obj) {
                this.f8185a = iVar;
                this.f8186b = obj;
            }
        }

        static {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addCategory("android.media.intent.category.LIVE_AUDIO");
            ArrayList arrayList = new ArrayList();
            f8169s = arrayList;
            arrayList.add(intentFilter);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addCategory("android.media.intent.category.LIVE_VIDEO");
            ArrayList arrayList2 = new ArrayList();
            f8170t = arrayList2;
            arrayList2.add(intentFilter2);
        }

        public b(Context context, e eVar) {
            super(context);
            this.f8171i = eVar;
            Object e10 = l1.e(context);
            this.f8172j = e10;
            this.f8173k = G();
            this.f8174l = H();
            this.f8175m = l1.b(e10, context.getResources().getString(R$string.mr_user_route_category_name), false);
            T();
        }

        public void A(t0.i iVar) {
            if (iVar.r() != this) {
                Object c10 = l1.c(this.f8172j, this.f8175m);
                c cVar = new c(iVar, c10);
                l1.c.k(c10, cVar);
                l1.d.f(c10, this.f8174l);
                U(cVar);
                this.f8180r.add(cVar);
                l1.a(this.f8172j, c10);
                return;
            }
            int I = I(l1.g(this.f8172j, 8388611));
            if (I >= 0 && ((C0105b) this.f8179q.get(I)).f8183b.equals(iVar.e())) {
                iVar.I();
            }
        }

        public void B(t0.i iVar) {
            int K;
            if (iVar.r() != this && (K = K(iVar)) >= 0) {
                U((c) this.f8180r.get(K));
            }
        }

        public void C(t0.i iVar) {
            int K;
            if (iVar.r() != this && (K = K(iVar)) >= 0) {
                c cVar = (c) this.f8180r.remove(K);
                l1.c.k(cVar.f8186b, (Object) null);
                l1.d.f(cVar.f8186b, (Object) null);
                l1.i(this.f8172j, cVar.f8186b);
            }
        }

        public void D(t0.i iVar) {
            if (iVar.C()) {
                if (iVar.r() != this) {
                    int K = K(iVar);
                    if (K >= 0) {
                        Q(((c) this.f8180r.get(K)).f8186b);
                        return;
                    }
                    return;
                }
                int J = J(iVar.e());
                if (J >= 0) {
                    Q(((C0105b) this.f8179q.get(J)).f8182a);
                }
            }
        }

        public final boolean E(Object obj) {
            if (N(obj) != null || I(obj) >= 0) {
                return false;
            }
            C0105b bVar = new C0105b(obj, F(obj));
            S(bVar);
            this.f8179q.add(bVar);
            return true;
        }

        public final String F(Object obj) {
            boolean z10;
            String str;
            if (L() == obj) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                str = "DEFAULT_ROUTE";
            } else {
                str = String.format(Locale.US, "ROUTE_%08x", new Object[]{Integer.valueOf(M(obj).hashCode())});
            }
            if (J(str) < 0) {
                return str;
            }
            int i10 = 2;
            while (true) {
                String format = String.format(Locale.US, "%s_%d", new Object[]{str, Integer.valueOf(i10)});
                if (J(format) < 0) {
                    return format;
                }
                i10++;
            }
        }

        public abstract Object G();

        public Object H() {
            return l1.d(this);
        }

        public int I(Object obj) {
            int size = this.f8179q.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((C0105b) this.f8179q.get(i10)).f8182a == obj) {
                    return i10;
                }
            }
            return -1;
        }

        public int J(String str) {
            int size = this.f8179q.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((C0105b) this.f8179q.get(i10)).f8183b.equals(str)) {
                    return i10;
                }
            }
            return -1;
        }

        public int K(t0.i iVar) {
            int size = this.f8180r.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((c) this.f8180r.get(i10)).f8185a == iVar) {
                    return i10;
                }
            }
            return -1;
        }

        public abstract Object L();

        public String M(Object obj) {
            CharSequence a10 = l1.c.a(obj, n());
            if (a10 != null) {
                return a10.toString();
            }
            return "";
        }

        public c N(Object obj) {
            Object e10 = l1.c.e(obj);
            if (e10 instanceof c) {
                return (c) e10;
            }
            return null;
        }

        public void O(C0105b bVar, n0.a aVar) {
            int d10 = l1.c.d(bVar.f8182a);
            if ((d10 & 1) != 0) {
                aVar.b(f8169s);
            }
            if ((d10 & 2) != 0) {
                aVar.b(f8170t);
            }
            aVar.p(l1.c.c(bVar.f8182a));
            aVar.o(l1.c.b(bVar.f8182a));
            aVar.r(l1.c.f(bVar.f8182a));
            aVar.t(l1.c.h(bVar.f8182a));
            aVar.s(l1.c.g(bVar.f8182a));
        }

        public void P() {
            q0.a aVar = new q0.a();
            int size = this.f8179q.size();
            for (int i10 = 0; i10 < size; i10++) {
                aVar.a(((C0105b) this.f8179q.get(i10)).f8184c);
            }
            w(aVar.c());
        }

        public abstract void Q(Object obj);

        public abstract void R();

        public void S(C0105b bVar) {
            n0.a aVar = new n0.a(bVar.f8183b, M(bVar.f8182a));
            O(bVar, aVar);
            bVar.f8184c = aVar.e();
        }

        public final void T() {
            R();
            boolean z10 = false;
            for (Object E : l1.f(this.f8172j)) {
                z10 |= E(E);
            }
            if (z10) {
                P();
            }
        }

        public void U(c cVar) {
            l1.d.a(cVar.f8186b, cVar.f8185a.m());
            l1.d.c(cVar.f8186b, cVar.f8185a.o());
            l1.d.b(cVar.f8186b, cVar.f8185a.n());
            l1.d.e(cVar.f8186b, cVar.f8185a.s());
            l1.d.h(cVar.f8186b, cVar.f8185a.u());
            l1.d.g(cVar.f8186b, cVar.f8185a.t());
        }

        public void a(Object obj, int i10) {
            c N = N(obj);
            if (N != null) {
                N.f8185a.H(i10);
            }
        }

        public void b(Object obj, Object obj2) {
        }

        public void c(Object obj, Object obj2, int i10) {
        }

        public void d(Object obj, int i10) {
            c N = N(obj);
            if (N != null) {
                N.f8185a.G(i10);
            }
        }

        public void e(Object obj) {
            int I;
            if (N(obj) == null && (I = I(obj)) >= 0) {
                S((C0105b) this.f8179q.get(I));
                P();
            }
        }

        public void f(int i10, Object obj) {
        }

        public void g(Object obj) {
            int I;
            if (N(obj) == null && (I = I(obj)) >= 0) {
                this.f8179q.remove(I);
                P();
            }
        }

        public void h(int i10, Object obj) {
            if (obj == l1.g(this.f8172j, 8388611)) {
                c N = N(obj);
                if (N != null) {
                    N.f8185a.I();
                    return;
                }
                int I = I(obj);
                if (I >= 0) {
                    this.f8171i.c(((C0105b) this.f8179q.get(I)).f8183b);
                }
            }
        }

        public void j(Object obj) {
            if (E(obj)) {
                P();
            }
        }

        public void k(Object obj) {
            int I;
            if (N(obj) == null && (I = I(obj)) >= 0) {
                C0105b bVar = (C0105b) this.f8179q.get(I);
                int f10 = l1.c.f(obj);
                if (f10 != bVar.f8184c.t()) {
                    bVar.f8184c = new n0.a(bVar.f8184c).r(f10).e();
                    P();
                }
            }
        }

        public p0.e s(String str) {
            int J = J(str);
            if (J >= 0) {
                return new a(((C0105b) this.f8179q.get(J)).f8182a);
            }
            return null;
        }

        public void u(o0 o0Var) {
            boolean z10;
            int i10 = 0;
            if (o0Var != null) {
                List e10 = o0Var.c().e();
                int size = e10.size();
                int i11 = 0;
                while (i10 < size) {
                    String str = (String) e10.get(i10);
                    if (str.equals("android.media.intent.category.LIVE_AUDIO")) {
                        i11 |= 1;
                    } else if (str.equals("android.media.intent.category.LIVE_VIDEO")) {
                        i11 |= 2;
                    } else {
                        i11 |= AutoStrategy.BITRATE_HIGH;
                    }
                    i10++;
                }
                z10 = o0Var.d();
                i10 = i11;
            } else {
                z10 = false;
            }
            if (this.f8176n != i10 || this.f8177o != z10) {
                this.f8176n = i10;
                this.f8177o = z10;
                T();
            }
        }
    }

    public static class c extends b implements m1.a {
        public c(Context context, e eVar) {
            super(context, eVar);
        }

        public Object G() {
            return m1.a(this);
        }

        public void O(b.C0105b bVar, n0.a aVar) {
            super.O(bVar, aVar);
            if (!m1.c.b(bVar.f8182a)) {
                aVar.j(false);
            }
            if (V(bVar)) {
                aVar.g(1);
            }
            Display a10 = m1.c.a(bVar.f8182a);
            if (a10 != null) {
                aVar.q(a10.getDisplayId());
            }
        }

        public abstract boolean V(b.C0105b bVar);

        public void i(Object obj) {
            int i10;
            int I = I(obj);
            if (I >= 0) {
                b.C0105b bVar = (b.C0105b) this.f8179q.get(I);
                Display a10 = m1.c.a(obj);
                if (a10 != null) {
                    i10 = a10.getDisplayId();
                } else {
                    i10 = -1;
                }
                if (i10 != bVar.f8184c.r()) {
                    bVar.f8184c = new n0.a(bVar.f8184c).q(i10).e();
                    P();
                }
            }
        }
    }

    public static class d extends c {
        public d(Context context, e eVar) {
            super(context, eVar);
        }

        public Object L() {
            return n1.b(this.f8172j);
        }

        public void O(b.C0105b bVar, n0.a aVar) {
            super.O(bVar, aVar);
            CharSequence a10 = n1.a.a(bVar.f8182a);
            if (a10 != null) {
                aVar.h(a10.toString());
            }
        }

        public void Q(Object obj) {
            l1.j(this.f8172j, 8388611, obj);
        }

        public void R() {
            if (this.f8178p) {
                l1.h(this.f8172j, this.f8173k);
            }
            this.f8178p = true;
            n1.a(this.f8172j, this.f8176n, this.f8173k, this.f8177o | true ? 1 : 0);
        }

        public void U(b.c cVar) {
            super.U(cVar);
            n1.b.a(cVar.f8186b, cVar.f8185a.d());
        }

        public boolean V(b.C0105b bVar) {
            return n1.a.b(bVar.f8182a);
        }
    }

    public interface e {
        void c(String str);
    }

    public v1(Context context) {
        super(context, new p0.d(new ComponentName("android", v1.class.getName())));
    }

    public static v1 z(Context context, e eVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new a(context, eVar);
        }
        return new d(context, eVar);
    }

    public abstract void A(t0.i iVar);

    public abstract void B(t0.i iVar);

    public abstract void C(t0.i iVar);

    public abstract void D(t0.i iVar);
}
