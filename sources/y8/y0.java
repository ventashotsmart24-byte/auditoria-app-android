package y8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.hpplay.sdk.source.common.global.Constant;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public abstract class y0 {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f20223a;

        /* renamed from: b  reason: collision with root package name */
        public final d1 f20224b;

        /* renamed from: c  reason: collision with root package name */
        public final o1 f20225c;

        /* renamed from: d  reason: collision with root package name */
        public final f f20226d;

        /* renamed from: e  reason: collision with root package name */
        public final ScheduledExecutorService f20227e;

        /* renamed from: f  reason: collision with root package name */
        public final f f20228f;

        /* renamed from: g  reason: collision with root package name */
        public final Executor f20229g;

        /* renamed from: h  reason: collision with root package name */
        public final String f20230h;

        /* renamed from: y8.y0$a$a  reason: collision with other inner class name */
        public static final class C0297a {

            /* renamed from: a  reason: collision with root package name */
            public Integer f20231a;

            /* renamed from: b  reason: collision with root package name */
            public d1 f20232b;

            /* renamed from: c  reason: collision with root package name */
            public o1 f20233c;

            /* renamed from: d  reason: collision with root package name */
            public f f20234d;

            /* renamed from: e  reason: collision with root package name */
            public ScheduledExecutorService f20235e;

            /* renamed from: f  reason: collision with root package name */
            public f f20236f;

            /* renamed from: g  reason: collision with root package name */
            public Executor f20237g;

            /* renamed from: h  reason: collision with root package name */
            public String f20238h;

            public a a() {
                return new a(this.f20231a, this.f20232b, this.f20233c, this.f20234d, this.f20235e, this.f20236f, this.f20237g, this.f20238h, (x0) null);
            }

            public C0297a b(f fVar) {
                this.f20236f = (f) Preconditions.checkNotNull(fVar);
                return this;
            }

            public C0297a c(int i10) {
                this.f20231a = Integer.valueOf(i10);
                return this;
            }

            public C0297a d(Executor executor) {
                this.f20237g = executor;
                return this;
            }

            public C0297a e(String str) {
                this.f20238h = str;
                return this;
            }

            public C0297a f(d1 d1Var) {
                this.f20232b = (d1) Preconditions.checkNotNull(d1Var);
                return this;
            }

            public C0297a g(ScheduledExecutorService scheduledExecutorService) {
                this.f20235e = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
                return this;
            }

            public C0297a h(f fVar) {
                this.f20234d = (f) Preconditions.checkNotNull(fVar);
                return this;
            }

            public C0297a i(o1 o1Var) {
                this.f20233c = (o1) Preconditions.checkNotNull(o1Var);
                return this;
            }
        }

        public /* synthetic */ a(Integer num, d1 d1Var, o1 o1Var, f fVar, ScheduledExecutorService scheduledExecutorService, f fVar2, Executor executor, String str, x0 x0Var) {
            this(num, d1Var, o1Var, fVar, scheduledExecutorService, fVar2, executor, str);
        }

        public static C0297a f() {
            return new C0297a();
        }

        public int a() {
            return this.f20223a;
        }

        public Executor b() {
            return this.f20229g;
        }

        public d1 c() {
            return this.f20224b;
        }

        public f d() {
            return this.f20226d;
        }

        public o1 e() {
            return this.f20225c;
        }

        public String toString() {
            return MoreObjects.toStringHelper((Object) this).add("defaultPort", this.f20223a).add("proxyDetector", (Object) this.f20224b).add("syncContext", (Object) this.f20225c).add("serviceConfigParser", (Object) this.f20226d).add("scheduledExecutorService", (Object) this.f20227e).add("channelLogger", (Object) this.f20228f).add("executor", (Object) this.f20229g).add("overrideAuthority", (Object) this.f20230h).toString();
        }

        public a(Integer num, d1 d1Var, o1 o1Var, f fVar, ScheduledExecutorService scheduledExecutorService, f fVar2, Executor executor, String str) {
            this.f20223a = ((Integer) Preconditions.checkNotNull(num, "defaultPort not set")).intValue();
            this.f20224b = (d1) Preconditions.checkNotNull(d1Var, "proxyDetector not set");
            this.f20225c = (o1) Preconditions.checkNotNull(o1Var, "syncContext not set");
            this.f20226d = (f) Preconditions.checkNotNull(fVar, "serviceConfigParser not set");
            this.f20227e = scheduledExecutorService;
            this.f20228f = fVar2;
            this.f20229g = executor;
            this.f20230h = str;
        }
    }

    public static abstract class c {
        public abstract String a();

        public abstract y0 b(URI uri, a aVar);
    }

    public static abstract class d {
        public abstract void a(k1 k1Var);

        public abstract void b(e eVar);
    }

    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public final List f20241a;

        /* renamed from: b  reason: collision with root package name */
        public final a f20242b;

        /* renamed from: c  reason: collision with root package name */
        public final b f20243c;

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public List f20244a = Collections.emptyList();

            /* renamed from: b  reason: collision with root package name */
            public a f20245b = a.f19923c;

            /* renamed from: c  reason: collision with root package name */
            public b f20246c;

            public e a() {
                return new e(this.f20244a, this.f20245b, this.f20246c);
            }

            public a b(List list) {
                this.f20244a = list;
                return this;
            }

            public a c(a aVar) {
                this.f20245b = aVar;
                return this;
            }

            public a d(b bVar) {
                this.f20246c = bVar;
                return this;
            }
        }

        public e(List list, a aVar, b bVar) {
            this.f20241a = Collections.unmodifiableList(new ArrayList(list));
            this.f20242b = (a) Preconditions.checkNotNull(aVar, "attributes");
            this.f20243c = bVar;
        }

        public static a d() {
            return new a();
        }

        public List a() {
            return this.f20241a;
        }

        public a b() {
            return this.f20242b;
        }

        public b c() {
            return this.f20243c;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (!Objects.equal(this.f20241a, eVar.f20241a) || !Objects.equal(this.f20242b, eVar.f20242b) || !Objects.equal(this.f20243c, eVar.f20243c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(this.f20241a, this.f20242b, this.f20243c);
        }

        public String toString() {
            return MoreObjects.toStringHelper((Object) this).add("addresses", (Object) this.f20241a).add("attributes", (Object) this.f20242b).add("serviceConfig", (Object) this.f20243c).toString();
        }
    }

    public static abstract class f {
        public abstract b a(Map map);
    }

    public abstract String a();

    public abstract void b();

    public abstract void c();

    public abstract void d(d dVar);

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final k1 f20239a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f20240b;

        public b(Object obj) {
            this.f20240b = Preconditions.checkNotNull(obj, "config");
            this.f20239a = null;
        }

        public static b a(Object obj) {
            return new b(obj);
        }

        public static b b(k1 k1Var) {
            return new b(k1Var);
        }

        public Object c() {
            return this.f20240b;
        }

        public k1 d() {
            return this.f20239a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (!Objects.equal(this.f20239a, bVar.f20239a) || !Objects.equal(this.f20240b, bVar.f20240b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(this.f20239a, this.f20240b);
        }

        public String toString() {
            if (this.f20240b != null) {
                return MoreObjects.toStringHelper((Object) this).add("config", this.f20240b).toString();
            }
            return MoreObjects.toStringHelper((Object) this).add("error", (Object) this.f20239a).toString();
        }

        public b(k1 k1Var) {
            this.f20240b = null;
            this.f20239a = (k1) Preconditions.checkNotNull(k1Var, Constant.KEY_STATUS);
            Preconditions.checkArgument(!k1Var.p(), "cannot use OK status: %s", (Object) k1Var);
        }
    }
}
