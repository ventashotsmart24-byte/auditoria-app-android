package z3;

import c3.m;
import c3.n;
import java.util.Iterator;
import java.util.Map;

public abstract class o extends m {

    /* renamed from: c  reason: collision with root package name */
    public final o f9975c;

    /* renamed from: d  reason: collision with root package name */
    public String f9976d;

    /* renamed from: e  reason: collision with root package name */
    public Object f9977e;

    public static final class a extends o {

        /* renamed from: f  reason: collision with root package name */
        public Iterator f9978f;

        /* renamed from: g  reason: collision with root package name */
        public k3.m f9979g;

        public a(k3.m mVar, o oVar) {
            super(1, oVar);
            this.f9978f = mVar.l();
        }

        public /* bridge */ /* synthetic */ m e() {
            return o.super.l();
        }

        public k3.m k() {
            return this.f9979g;
        }

        public n m() {
            if (!this.f9978f.hasNext()) {
                this.f9979g = null;
                return n.END_ARRAY;
            }
            this.f4767b++;
            k3.m mVar = (k3.m) this.f9978f.next();
            this.f9979g = mVar;
            return mVar.b();
        }

        public o n() {
            return new a(this.f9979g, this);
        }

        public o o() {
            return new b(this.f9979g, this);
        }
    }

    public static final class b extends o {

        /* renamed from: f  reason: collision with root package name */
        public Iterator f9980f;

        /* renamed from: g  reason: collision with root package name */
        public Map.Entry f9981g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f9982h = true;

        public b(k3.m mVar, o oVar) {
            super(2, oVar);
            this.f9980f = ((r) mVar).m();
        }

        public /* bridge */ /* synthetic */ m e() {
            return o.super.l();
        }

        public k3.m k() {
            Map.Entry entry = this.f9981g;
            if (entry == null) {
                return null;
            }
            return (k3.m) entry.getValue();
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public c3.n m() {
            /*
                r3 = this;
                boolean r0 = r3.f9982h
                r1 = 1
                if (r0 == 0) goto L_0x0036
                java.util.Iterator r0 = r3.f9980f
                boolean r0 = r0.hasNext()
                r2 = 0
                if (r0 != 0) goto L_0x0015
                r3.f9976d = r2
                r3.f9981g = r2
                c3.n r0 = c3.n.END_OBJECT
                return r0
            L_0x0015:
                int r0 = r3.f4767b
                int r0 = r0 + r1
                r3.f4767b = r0
                r0 = 0
                r3.f9982h = r0
                java.util.Iterator r0 = r3.f9980f
                java.lang.Object r0 = r0.next()
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                r3.f9981g = r0
                if (r0 != 0) goto L_0x002a
                goto L_0x0031
            L_0x002a:
                java.lang.Object r0 = r0.getKey()
                r2 = r0
                java.lang.String r2 = (java.lang.String) r2
            L_0x0031:
                r3.f9976d = r2
                c3.n r0 = c3.n.FIELD_NAME
                return r0
            L_0x0036:
                r3.f9982h = r1
                java.util.Map$Entry r0 = r3.f9981g
                java.lang.Object r0 = r0.getValue()
                k3.m r0 = (k3.m) r0
                c3.n r0 = r0.b()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: z3.o.b.m():c3.n");
        }

        public o n() {
            return new a(k(), this);
        }

        public o o() {
            return new b(k(), this);
        }
    }

    public static final class c extends o {

        /* renamed from: f  reason: collision with root package name */
        public k3.m f9983f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f9984g = false;

        public c(k3.m mVar, o oVar) {
            super(0, oVar);
            this.f9983f = mVar;
        }

        public /* bridge */ /* synthetic */ m e() {
            return o.super.l();
        }

        public k3.m k() {
            if (this.f9984g) {
                return this.f9983f;
            }
            return null;
        }

        public n m() {
            if (!this.f9984g) {
                this.f4767b++;
                this.f9984g = true;
                return this.f9983f.b();
            }
            this.f9983f = null;
            return null;
        }

        public o n() {
            return new a(this.f9983f, this);
        }

        public o o() {
            return new b(this.f9983f, this);
        }
    }

    public o(int i10, o oVar) {
        this.f4766a = i10;
        this.f4767b = -1;
        this.f9975c = oVar;
    }

    public final String b() {
        return this.f9976d;
    }

    public Object c() {
        return this.f9977e;
    }

    public void i(Object obj) {
        this.f9977e = obj;
    }

    public abstract k3.m k();

    public final o l() {
        return this.f9975c;
    }

    public abstract n m();

    public abstract o n();

    public abstract o o();
}
