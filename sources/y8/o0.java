package y8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.hpplay.sdk.source.common.global.Constant;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import y8.a;
import y8.k;

public abstract class o0 {

    /* renamed from: b  reason: collision with root package name */
    public static final a.c f20103b = a.c.a("internal:health-checking-config");

    /* renamed from: a  reason: collision with root package name */
    public int f20104a;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final List f20105a;

        /* renamed from: b  reason: collision with root package name */
        public final a f20106b;

        /* renamed from: c  reason: collision with root package name */
        public final Object[][] f20107c;

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public List f20108a;

            /* renamed from: b  reason: collision with root package name */
            public a f20109b = a.f19923c;

            /* renamed from: c  reason: collision with root package name */
            public Object[][] f20110c = ((Object[][]) Array.newInstance(Object.class, new int[]{0, 2}));

            public b b() {
                return new b(this.f20108a, this.f20109b, this.f20110c);
            }

            public final a c(Object[][] objArr) {
                Object[][] objArr2 = (Object[][]) Array.newInstance(Object.class, new int[]{objArr.length, 2});
                this.f20110c = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                return this;
            }

            public a d(List list) {
                Preconditions.checkArgument(!list.isEmpty(), "addrs is empty");
                this.f20108a = Collections.unmodifiableList(new ArrayList(list));
                return this;
            }

            public a e(x xVar) {
                this.f20108a = Collections.singletonList(xVar);
                return this;
            }

            public a f(a aVar) {
                this.f20109b = (a) Preconditions.checkNotNull(aVar, "attrs");
                return this;
            }
        }

        public static a c() {
            return new a();
        }

        public List a() {
            return this.f20105a;
        }

        public a b() {
            return this.f20106b;
        }

        public a d() {
            return c().d(this.f20105a).f(this.f20106b).c(this.f20107c);
        }

        public String toString() {
            return MoreObjects.toStringHelper((Object) this).add("addrs", (Object) this.f20105a).add("attrs", (Object) this.f20106b).add("customOptions", (Object) Arrays.deepToString(this.f20107c)).toString();
        }

        public b(List list, a aVar, Object[][] objArr) {
            this.f20105a = (List) Preconditions.checkNotNull(list, "addresses are not set");
            this.f20106b = (a) Preconditions.checkNotNull(aVar, "attrs");
            this.f20107c = (Object[][]) Preconditions.checkNotNull(objArr, "customOptions");
        }
    }

    public static abstract class c {
        public abstract o0 a(d dVar);
    }

    public static abstract class d {
        public abstract h a(b bVar);

        public abstract f b();

        public abstract ScheduledExecutorService c();

        public abstract o1 d();

        public abstract void e();

        public abstract void f(p pVar, i iVar);
    }

    public static final class e {

        /* renamed from: e  reason: collision with root package name */
        public static final e f20111e = new e((h) null, (k.a) null, k1.f20041f, false);

        /* renamed from: a  reason: collision with root package name */
        public final h f20112a;

        /* renamed from: b  reason: collision with root package name */
        public final k.a f20113b;

        /* renamed from: c  reason: collision with root package name */
        public final k1 f20114c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f20115d;

        public e(h hVar, k.a aVar, k1 k1Var, boolean z10) {
            this.f20112a = hVar;
            this.f20113b = aVar;
            this.f20114c = (k1) Preconditions.checkNotNull(k1Var, Constant.KEY_STATUS);
            this.f20115d = z10;
        }

        public static e e(k1 k1Var) {
            Preconditions.checkArgument(!k1Var.p(), "drop status shouldn't be OK");
            return new e((h) null, (k.a) null, k1Var, true);
        }

        public static e f(k1 k1Var) {
            Preconditions.checkArgument(!k1Var.p(), "error status shouldn't be OK");
            return new e((h) null, (k.a) null, k1Var, false);
        }

        public static e g() {
            return f20111e;
        }

        public static e h(h hVar) {
            return i(hVar, (k.a) null);
        }

        public static e i(h hVar, k.a aVar) {
            return new e((h) Preconditions.checkNotNull(hVar, "subchannel"), aVar, k1.f20041f, false);
        }

        public k1 a() {
            return this.f20114c;
        }

        public k.a b() {
            return this.f20113b;
        }

        public h c() {
            return this.f20112a;
        }

        public boolean d() {
            return this.f20115d;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (!Objects.equal(this.f20112a, eVar.f20112a) || !Objects.equal(this.f20114c, eVar.f20114c) || !Objects.equal(this.f20113b, eVar.f20113b) || this.f20115d != eVar.f20115d) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(this.f20112a, this.f20114c, this.f20113b, Boolean.valueOf(this.f20115d));
        }

        public String toString() {
            return MoreObjects.toStringHelper((Object) this).add("subchannel", (Object) this.f20112a).add("streamTracerFactory", (Object) this.f20113b).add(Constant.KEY_STATUS, (Object) this.f20114c).add("drop", this.f20115d).toString();
        }
    }

    public static abstract class f {
        public abstract c a();

        public abstract v0 b();

        public abstract w0 c();
    }

    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public final List f20116a;

        /* renamed from: b  reason: collision with root package name */
        public final a f20117b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f20118c;

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public List f20119a;

            /* renamed from: b  reason: collision with root package name */
            public a f20120b = a.f19923c;

            /* renamed from: c  reason: collision with root package name */
            public Object f20121c;

            public g a() {
                return new g(this.f20119a, this.f20120b, this.f20121c);
            }

            public a b(List list) {
                this.f20119a = list;
                return this;
            }

            public a c(a aVar) {
                this.f20120b = aVar;
                return this;
            }

            public a d(Object obj) {
                this.f20121c = obj;
                return this;
            }
        }

        public static a d() {
            return new a();
        }

        public List a() {
            return this.f20116a;
        }

        public a b() {
            return this.f20117b;
        }

        public Object c() {
            return this.f20118c;
        }

        public a e() {
            return d().b(this.f20116a).c(this.f20117b).d(this.f20118c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            if (!Objects.equal(this.f20116a, gVar.f20116a) || !Objects.equal(this.f20117b, gVar.f20117b) || !Objects.equal(this.f20118c, gVar.f20118c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(this.f20116a, this.f20117b, this.f20118c);
        }

        public String toString() {
            return MoreObjects.toStringHelper((Object) this).add("addresses", (Object) this.f20116a).add("attributes", (Object) this.f20117b).add("loadBalancingPolicyConfig", this.f20118c).toString();
        }

        public g(List list, a aVar, Object obj) {
            this.f20116a = Collections.unmodifiableList(new ArrayList((Collection) Preconditions.checkNotNull(list, "addresses")));
            this.f20117b = (a) Preconditions.checkNotNull(aVar, "attributes");
            this.f20118c = obj;
        }
    }

    public static abstract class h {
        public final x a() {
            List b10 = b();
            boolean z10 = true;
            if (b10.size() != 1) {
                z10 = false;
            }
            Preconditions.checkState(z10, "%s does not have exactly one group", (Object) b10);
            return (x) b10.get(0);
        }

        public abstract List b();

        public abstract a c();

        public abstract Object d();

        public abstract void e();

        public abstract void f();

        public abstract void g(j jVar);

        public abstract void h(List list);
    }

    public static abstract class i {
        public abstract e a(f fVar);
    }

    public interface j {
        void a(q qVar);
    }

    public boolean a(g gVar) {
        if (!gVar.a().isEmpty() || b()) {
            int i10 = this.f20104a;
            this.f20104a = i10 + 1;
            if (i10 == 0) {
                d(gVar);
            }
            this.f20104a = 0;
            return true;
        }
        k1 k1Var = k1.f20056u;
        c(k1Var.r("NameResolver returned no usable address. addrs=" + gVar.a() + ", attrs=" + gVar.b()));
        return false;
    }

    public boolean b() {
        return false;
    }

    public abstract void c(k1 k1Var);

    public void d(g gVar) {
        int i10 = this.f20104a;
        this.f20104a = i10 + 1;
        if (i10 == 0) {
            a(gVar);
        }
        this.f20104a = 0;
    }

    public abstract void e();
}
