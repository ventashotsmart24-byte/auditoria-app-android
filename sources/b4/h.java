package b4;

import a4.i;
import b3.r;
import b4.k;
import c3.n;
import d4.c;
import d4.e;
import java.util.Map;
import k3.b;
import k3.c0;
import k3.d;
import k3.j;
import k3.l;
import k3.o;
import r3.s;

public class h extends a4.h implements i {

    /* renamed from: l  reason: collision with root package name */
    public static final Object f4329l = r.a.NON_EMPTY;

    /* renamed from: a  reason: collision with root package name */
    public final d f4330a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f4331b;

    /* renamed from: c  reason: collision with root package name */
    public final j f4332c;

    /* renamed from: d  reason: collision with root package name */
    public final j f4333d;

    /* renamed from: e  reason: collision with root package name */
    public final j f4334e;

    /* renamed from: f  reason: collision with root package name */
    public o f4335f;

    /* renamed from: g  reason: collision with root package name */
    public o f4336g;

    /* renamed from: h  reason: collision with root package name */
    public final w3.h f4337h;

    /* renamed from: i  reason: collision with root package name */
    public k f4338i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f4339j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f4340k;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f4341a;

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
                f4341a = r0
                b3.r$a r1 = b3.r.a.NON_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4341a     // Catch:{ NoSuchFieldError -> 0x001d }
                b3.r$a r1 = b3.r.a.NON_ABSENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4341a     // Catch:{ NoSuchFieldError -> 0x0028 }
                b3.r$a r1 = b3.r.a.NON_EMPTY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4341a     // Catch:{ NoSuchFieldError -> 0x0033 }
                b3.r$a r1 = b3.r.a.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f4341a     // Catch:{ NoSuchFieldError -> 0x003e }
                b3.r$a r1 = b3.r.a.NON_NULL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f4341a     // Catch:{ NoSuchFieldError -> 0x0049 }
                b3.r$a r1 = b3.r.a.ALWAYS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b4.h.a.<clinit>():void");
        }
    }

    public h(j jVar, j jVar2, j jVar3, boolean z10, w3.h hVar, d dVar) {
        super(jVar);
        this.f4332c = jVar;
        this.f4333d = jVar2;
        this.f4334e = jVar3;
        this.f4331b = z10;
        this.f4337h = hVar;
        this.f4330a = dVar;
        this.f4338i = k.c();
        this.f4339j = null;
        this.f4340k = false;
    }

    public o b(c0 c0Var, d dVar) {
        r3.i iVar;
        o oVar;
        o oVar2;
        o oVar3;
        boolean z10;
        Object obj;
        r.b b10;
        r.a f10;
        b W = c0Var.W();
        Object obj2 = null;
        if (dVar == null) {
            iVar = null;
        } else {
            iVar = dVar.d();
        }
        if (iVar == null || W == null) {
            oVar2 = null;
            oVar = null;
        } else {
            Object v10 = W.v(iVar);
            if (v10 != null) {
                oVar = c0Var.t0(iVar, v10);
            } else {
                oVar = null;
            }
            Object g10 = W.g(iVar);
            if (g10 != null) {
                oVar2 = c0Var.t0(iVar, g10);
            } else {
                oVar2 = null;
            }
        }
        if (oVar2 == null) {
            oVar2 = this.f4336g;
        }
        o findContextualConvertingSerializer = findContextualConvertingSerializer(c0Var, dVar, oVar2);
        if (findContextualConvertingSerializer == null && this.f4331b && !this.f4334e.I()) {
            findContextualConvertingSerializer = c0Var.H(this.f4334e, dVar);
        }
        o oVar4 = findContextualConvertingSerializer;
        if (oVar == null) {
            oVar = this.f4335f;
        }
        if (oVar == null) {
            oVar3 = c0Var.J(this.f4333d, dVar);
        } else {
            oVar3 = c0Var.i0(oVar, dVar);
        }
        o oVar5 = oVar3;
        Object obj3 = this.f4339j;
        boolean z11 = this.f4340k;
        if (dVar == null || (b10 = dVar.b(c0Var.k(), (Class) null)) == null || (f10 = b10.f()) == r.a.USE_DEFAULTS) {
            obj = obj3;
            z10 = z11;
        } else {
            int i10 = a.f4341a[f10.ordinal()];
            if (i10 == 1) {
                obj2 = e.b(this.f4334e);
                if (obj2 != null && obj2.getClass().isArray()) {
                    obj2 = c.a(obj2);
                }
            } else if (i10 != 2) {
                if (i10 == 3) {
                    obj2 = f4329l;
                } else if (i10 == 4) {
                    obj2 = c0Var.j0((s) null, b10.e());
                    if (obj2 != null) {
                        z10 = c0Var.k0(obj2);
                        obj = obj2;
                    }
                } else if (i10 != 5) {
                    obj = null;
                    z10 = false;
                }
            } else if (this.f4334e.b()) {
                obj2 = f4329l;
            }
            obj = obj2;
            z10 = true;
        }
        return m(dVar, oVar5, oVar4, obj, z10);
    }

    public a4.h c(w3.h hVar) {
        return new h(this, this.f4330a, hVar, this.f4335f, this.f4336g, this.f4339j, this.f4340k);
    }

    public final o e(k kVar, Class cls, c0 c0Var) {
        k.d g10 = kVar.g(cls, c0Var, this.f4330a);
        k kVar2 = g10.f4357b;
        if (kVar != kVar2) {
            this.f4338i = kVar2;
        }
        return g10.f4356a;
    }

    public final o f(k kVar, j jVar, c0 c0Var) {
        k.d h10 = kVar.h(jVar, c0Var, this.f4330a);
        k kVar2 = h10.f4357b;
        if (kVar != kVar2) {
            this.f4338i = kVar2;
        }
        return h10.f4356a;
    }

    public j g() {
        return this.f4334e;
    }

    /* renamed from: h */
    public boolean isEmpty(c0 c0Var, Map.Entry entry) {
        Object value = entry.getValue();
        if (value == null) {
            return this.f4340k;
        }
        if (this.f4339j == null) {
            return false;
        }
        o oVar = this.f4336g;
        if (oVar == null) {
            Class<?> cls = value.getClass();
            o j10 = this.f4338i.j(cls);
            if (j10 == null) {
                try {
                    oVar = e(this.f4338i, cls, c0Var);
                } catch (l unused) {
                    return false;
                }
            } else {
                oVar = j10;
            }
        }
        Object obj = this.f4339j;
        if (obj == f4329l) {
            return oVar.isEmpty(c0Var, value);
        }
        return obj.equals(value);
    }

    /* renamed from: i */
    public void serialize(Map.Entry entry, c3.h hVar, c0 c0Var) {
        hVar.w0(entry);
        j(entry, hVar, c0Var);
        hVar.W();
    }

    public void j(Map.Entry entry, c3.h hVar, c0 c0Var) {
        o oVar;
        o oVar2;
        w3.h hVar2 = this.f4337h;
        Object key = entry.getKey();
        if (key == null) {
            oVar = c0Var.K(this.f4333d, this.f4330a);
        } else {
            oVar = this.f4335f;
        }
        Object value = entry.getValue();
        if (value != null) {
            oVar2 = this.f4336g;
            if (oVar2 == null) {
                Class<?> cls = value.getClass();
                o j10 = this.f4338i.j(cls);
                if (j10 != null) {
                    oVar2 = j10;
                } else if (this.f4334e.w()) {
                    oVar2 = f(this.f4338i, c0Var.A(this.f4334e, cls), c0Var);
                } else {
                    oVar2 = e(this.f4338i, cls, c0Var);
                }
            }
            Object obj = this.f4339j;
            if (obj != null && ((obj == f4329l && oVar2.isEmpty(c0Var, value)) || this.f4339j.equals(value))) {
                return;
            }
        } else if (!this.f4340k) {
            oVar2 = c0Var.Z();
        } else {
            return;
        }
        oVar.serialize(key, hVar, c0Var);
        if (hVar2 == null) {
            try {
                oVar2.serialize(value, hVar, c0Var);
            } catch (Exception e10) {
                wrapAndThrow(c0Var, (Throwable) e10, (Object) entry, "" + key);
            }
        } else {
            oVar2.serializeWithType(value, hVar, c0Var, hVar2);
        }
    }

    /* renamed from: k */
    public void serializeWithType(Map.Entry entry, c3.h hVar, c0 c0Var, w3.h hVar2) {
        hVar.z(entry);
        i3.b g10 = hVar2.g(hVar, hVar2.d(entry, n.START_OBJECT));
        j(entry, hVar, c0Var);
        hVar2.h(hVar, g10);
    }

    public h l(Object obj, boolean z10) {
        if (this.f4339j == obj && this.f4340k == z10) {
            return this;
        }
        return new h(this, this.f4330a, this.f4337h, this.f4335f, this.f4336g, obj, z10);
    }

    public h m(d dVar, o oVar, o oVar2, Object obj, boolean z10) {
        return new h(this, dVar, this.f4337h, oVar, oVar2, obj, z10);
    }

    public h(h hVar, d dVar, w3.h hVar2, o oVar, o oVar2, Object obj, boolean z10) {
        super(Map.class, false);
        this.f4332c = hVar.f4332c;
        this.f4333d = hVar.f4333d;
        this.f4334e = hVar.f4334e;
        this.f4331b = hVar.f4331b;
        this.f4337h = hVar.f4337h;
        this.f4335f = oVar;
        this.f4336g = oVar2;
        this.f4338i = k.c();
        this.f4330a = hVar.f4330a;
        this.f4339j = obj;
        this.f4340k = z10;
    }
}
