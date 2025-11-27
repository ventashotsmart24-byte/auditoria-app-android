package com.fasterxml.jackson.databind.ser.std;

import a4.i;
import b3.r;
import b4.k;
import d4.c;
import d4.e;
import d4.q;
import k3.b;
import k3.c0;
import k3.d;
import k3.j;
import k3.l;
import k3.o;
import l3.f;
import r3.s;
import u3.f;
import w3.h;

public abstract class z extends i0 implements i {

    /* renamed from: i  reason: collision with root package name */
    public static final Object f5821i = r.a.NON_EMPTY;

    /* renamed from: a  reason: collision with root package name */
    public final j f5822a;

    /* renamed from: b  reason: collision with root package name */
    public final d f5823b;

    /* renamed from: c  reason: collision with root package name */
    public final h f5824c;

    /* renamed from: d  reason: collision with root package name */
    public final o f5825d;

    /* renamed from: e  reason: collision with root package name */
    public final q f5826e;

    /* renamed from: f  reason: collision with root package name */
    public transient k f5827f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f5828g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f5829h;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5830a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                b3.r$a[] r0 = b3.r.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5830a = r0
                b3.r$a r1 = b3.r.a.NON_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5830a     // Catch:{ NoSuchFieldError -> 0x001d }
                b3.r$a r1 = b3.r.a.NON_ABSENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5830a     // Catch:{ NoSuchFieldError -> 0x0028 }
                b3.r$a r1 = b3.r.a.NON_EMPTY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5830a     // Catch:{ NoSuchFieldError -> 0x0033 }
                b3.r$a r1 = b3.r.a.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f5830a     // Catch:{ NoSuchFieldError -> 0x003e }
                b3.r$a r1 = b3.r.a.NON_NULL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f5830a     // Catch:{ NoSuchFieldError -> 0x0049 }
                b3.r$a r1 = b3.r.a.ALWAYS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.z.a.<clinit>():void");
        }
    }

    public z(c4.j jVar, boolean z10, h hVar, o oVar) {
        super((j) jVar);
        this.f5822a = jVar.a();
        this.f5823b = null;
        this.f5824c = hVar;
        this.f5825d = oVar;
        this.f5826e = null;
        this.f5828g = null;
        this.f5829h = false;
        this.f5827f = k.c();
    }

    public void acceptJsonFormatVisitor(f fVar, j jVar) {
        o oVar = this.f5825d;
        if (oVar == null) {
            oVar = d(fVar.getProvider(), this.f5822a, this.f5823b);
            q qVar = this.f5826e;
            if (qVar != null) {
                oVar = oVar.unwrappingSerializer(qVar);
            }
        }
        oVar.acceptJsonFormatVisitor(fVar, this.f5822a);
    }

    public o b(c0 c0Var, d dVar) {
        z zVar;
        r.b b10;
        r.a f10;
        Object obj;
        h hVar = this.f5824c;
        if (hVar != null) {
            hVar = hVar.a(dVar);
        }
        o findAnnotatedContentSerializer = findAnnotatedContentSerializer(c0Var, dVar);
        if (findAnnotatedContentSerializer == null) {
            findAnnotatedContentSerializer = this.f5825d;
            if (findAnnotatedContentSerializer != null) {
                findAnnotatedContentSerializer = c0Var.h0(findAnnotatedContentSerializer, dVar);
            } else if (h(c0Var, dVar, this.f5822a)) {
                findAnnotatedContentSerializer = d(c0Var, this.f5822a, dVar);
            }
        }
        if (this.f5823b == dVar && this.f5824c == hVar && this.f5825d == findAnnotatedContentSerializer) {
            zVar = this;
        } else {
            zVar = j(dVar, hVar, findAnnotatedContentSerializer, this.f5826e);
        }
        if (dVar == null || (b10 = dVar.b(c0Var.k(), handledType())) == null || (f10 = b10.f()) == r.a.USE_DEFAULTS) {
            return zVar;
        }
        int i10 = a.f5830a[f10.ordinal()];
        boolean z10 = true;
        if (i10 != 1) {
            obj = null;
            if (i10 != 2) {
                if (i10 == 3) {
                    obj = f5821i;
                } else if (i10 == 4) {
                    obj = c0Var.j0((s) null, b10.e());
                    if (obj != null) {
                        z10 = c0Var.k0(obj);
                    }
                } else if (i10 != 5) {
                    z10 = false;
                }
            } else if (this.f5822a.b()) {
                obj = f5821i;
            }
        } else {
            obj = e.b(this.f5822a);
            if (obj != null && obj.getClass().isArray()) {
                obj = c.a(obj);
            }
        }
        if (this.f5828g == obj && this.f5829h == z10) {
            return zVar;
        }
        return zVar.i(obj, z10);
    }

    public final o c(c0 c0Var, Class cls) {
        o oVar;
        o j10 = this.f5827f.j(cls);
        if (j10 != null) {
            return j10;
        }
        if (this.f5822a.w()) {
            oVar = c0Var.O(c0Var.A(this.f5822a, cls), this.f5823b);
        } else {
            oVar = c0Var.N(cls, this.f5823b);
        }
        q qVar = this.f5826e;
        if (qVar != null) {
            oVar = oVar.unwrappingSerializer(qVar);
        }
        o oVar2 = oVar;
        this.f5827f = this.f5827f.i(cls, oVar2);
        return oVar2;
    }

    public final o d(c0 c0Var, j jVar, d dVar) {
        return c0Var.O(jVar, dVar);
    }

    public abstract Object e(Object obj);

    public abstract Object f(Object obj);

    public abstract boolean g(Object obj);

    public boolean h(c0 c0Var, d dVar, j jVar) {
        if (jVar.I()) {
            return false;
        }
        if (jVar.G() || jVar.Q()) {
            return true;
        }
        b W = c0Var.W();
        if (!(W == null || dVar == null || dVar.d() == null)) {
            f.b X = W.X(dVar.d());
            if (X == f.b.STATIC) {
                return true;
            }
            if (X == f.b.DYNAMIC) {
                return false;
            }
        }
        return c0Var.l0(k3.q.USE_STATIC_TYPING);
    }

    public abstract z i(Object obj, boolean z10);

    public boolean isEmpty(c0 c0Var, Object obj) {
        if (!g(obj)) {
            return true;
        }
        Object e10 = e(obj);
        if (e10 == null) {
            return this.f5829h;
        }
        if (this.f5828g == null) {
            return false;
        }
        o oVar = this.f5825d;
        if (oVar == null) {
            try {
                oVar = c(c0Var, e10.getClass());
            } catch (l e11) {
                throw new k3.z(e11);
            }
        }
        Object obj2 = this.f5828g;
        if (obj2 == f5821i) {
            return oVar.isEmpty(c0Var, e10);
        }
        return obj2.equals(e10);
    }

    public boolean isUnwrappingSerializer() {
        if (this.f5826e != null) {
            return true;
        }
        return false;
    }

    public abstract z j(d dVar, h hVar, o oVar, q qVar);

    public void serialize(Object obj, c3.h hVar, c0 c0Var) {
        Object f10 = f(obj);
        if (f10 != null) {
            o oVar = this.f5825d;
            if (oVar == null) {
                oVar = c(c0Var, f10.getClass());
            }
            h hVar2 = this.f5824c;
            if (hVar2 != null) {
                oVar.serializeWithType(f10, hVar, c0Var, hVar2);
            } else {
                oVar.serialize(f10, hVar, c0Var);
            }
        } else if (this.f5826e == null) {
            c0Var.E(hVar);
        }
    }

    public void serializeWithType(Object obj, c3.h hVar, c0 c0Var, h hVar2) {
        Object f10 = f(obj);
        if (f10 != null) {
            o oVar = this.f5825d;
            if (oVar == null) {
                oVar = c(c0Var, f10.getClass());
            }
            oVar.serializeWithType(f10, hVar, c0Var, hVar2);
        } else if (this.f5826e == null) {
            c0Var.E(hVar);
        }
    }

    public o unwrappingSerializer(q qVar) {
        o oVar = this.f5825d;
        if (oVar != null && (oVar = oVar.unwrappingSerializer(qVar)) == this.f5825d) {
            return this;
        }
        q qVar2 = this.f5826e;
        if (qVar2 != null) {
            qVar = q.a(qVar, qVar2);
        }
        if (this.f5825d == oVar && this.f5826e == qVar) {
            return this;
        }
        return j(this.f5823b, this.f5824c, oVar, qVar);
    }

    public z(z zVar, d dVar, h hVar, o oVar, q qVar, Object obj, boolean z10) {
        super((i0) zVar);
        this.f5822a = zVar.f5822a;
        this.f5827f = k.c();
        this.f5823b = dVar;
        this.f5824c = hVar;
        this.f5825d = oVar;
        this.f5826e = qVar;
        this.f5828g = obj;
        this.f5829h = z10;
    }
}
