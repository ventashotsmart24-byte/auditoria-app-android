package x3;

import b3.e0;
import java.util.Collection;
import k3.a0;
import k3.d;
import k3.j;
import k3.q;
import m3.m;
import w3.c;
import w3.e;
import w3.f;
import w3.g;
import w3.h;

public class o implements g {

    /* renamed from: a  reason: collision with root package name */
    public e0.b f9695a;

    /* renamed from: b  reason: collision with root package name */
    public e0.a f9696b;

    /* renamed from: c  reason: collision with root package name */
    public String f9697c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9698d = false;

    /* renamed from: e  reason: collision with root package name */
    public Class f9699e;

    /* renamed from: f  reason: collision with root package name */
    public f f9700f;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9701a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f9702b;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|(2:19|20)|21|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0078 */
        static {
            /*
                b3.e0$b[] r0 = b3.e0.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9702b = r0
                r1 = 1
                b3.e0$b r2 = b3.e0.b.DEDUCTION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f9702b     // Catch:{ NoSuchFieldError -> 0x001d }
                b3.e0$b r3 = b3.e0.b.CLASS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f9702b     // Catch:{ NoSuchFieldError -> 0x0028 }
                b3.e0$b r4 = b3.e0.b.MINIMAL_CLASS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f9702b     // Catch:{ NoSuchFieldError -> 0x0033 }
                b3.e0$b r5 = b3.e0.b.NAME     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f9702b     // Catch:{ NoSuchFieldError -> 0x003e }
                b3.e0$b r6 = b3.e0.b.NONE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r5 = f9702b     // Catch:{ NoSuchFieldError -> 0x0049 }
                b3.e0$b r6 = b3.e0.b.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r7 = 6
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                b3.e0$a[] r5 = b3.e0.a.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f9701a = r5
                b3.e0$a r6 = b3.e0.a.WRAPPER_ARRAY     // Catch:{ NoSuchFieldError -> 0x005a }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r1 = f9701a     // Catch:{ NoSuchFieldError -> 0x0064 }
                b3.e0$a r5 = b3.e0.a.PROPERTY     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r1[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = f9701a     // Catch:{ NoSuchFieldError -> 0x006e }
                b3.e0$a r1 = b3.e0.a.WRAPPER_OBJECT     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = f9701a     // Catch:{ NoSuchFieldError -> 0x0078 }
                b3.e0$a r1 = b3.e0.a.EXTERNAL_PROPERTY     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f9701a     // Catch:{ NoSuchFieldError -> 0x0082 }
                b3.e0$a r1 = b3.e0.a.EXISTING_PROPERTY     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: x3.o.a.<clinit>():void");
        }
    }

    public static o o() {
        return new o().h(e0.b.NONE, (f) null);
    }

    public h b(a0 a0Var, j jVar, Collection collection) {
        if (this.f9695a == e0.b.NONE) {
            return null;
        }
        if (jVar.K() && !i(a0Var, jVar)) {
            return null;
        }
        f l10 = l(a0Var, jVar, q(a0Var), collection, true, false);
        if (this.f9695a == e0.b.DEDUCTION) {
            return new d(l10, (d) null, this.f9697c);
        }
        int i10 = a.f9701a[this.f9696b.ordinal()];
        if (i10 == 1) {
            return new b(l10, (d) null);
        }
        if (i10 == 2) {
            return new h(l10, (d) null, this.f9697c);
        }
        if (i10 == 3) {
            return new j(l10, (d) null);
        }
        if (i10 == 4) {
            return new f(l10, (d) null, this.f9697c);
        }
        if (i10 == 5) {
            return new d(l10, (d) null, this.f9697c);
        }
        throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.f9696b);
    }

    public e e(k3.f fVar, j jVar, Collection collection) {
        if (this.f9695a == e0.b.NONE) {
            return null;
        }
        if (jVar.K() && !i(fVar, jVar)) {
            return null;
        }
        f l10 = l(fVar, jVar, t(fVar, jVar), collection, false, true);
        j k10 = k(fVar, jVar);
        if (this.f9695a == e0.b.DEDUCTION) {
            return new c(jVar, l10, k10, fVar, collection);
        }
        int i10 = a.f9701a[this.f9696b.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    return new i(jVar, l10, this.f9697c, this.f9698d, k10);
                } else if (i10 == 4) {
                    return new e(jVar, l10, this.f9697c, this.f9698d, k10);
                } else if (i10 != 5) {
                    throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.f9696b);
                }
            }
            return new g(jVar, l10, this.f9697c, this.f9698d, k10, this.f9696b);
        }
        return new a(jVar, l10, this.f9697c, this.f9698d, k10);
    }

    public Class g() {
        return this.f9699e;
    }

    public boolean i(m mVar, j jVar) {
        return false;
    }

    /* renamed from: j */
    public o d(Class cls) {
        this.f9699e = cls;
        return this;
    }

    public j k(k3.f fVar, j jVar) {
        Class<l3.j> cls = this.f9699e;
        if (cls == null) {
            if (fVar.D(q.USE_BASE_TYPE_AS_DEFAULT_IMPL) && !jVar.z()) {
                return jVar;
            }
        } else if (cls == Void.class || cls == l3.j.class) {
            return fVar.z().H(this.f9699e);
        } else {
            if (jVar.y(cls)) {
                return jVar;
            }
            if (jVar.O(this.f9699e)) {
                return fVar.z().F(jVar, this.f9699e);
            }
        }
        return null;
    }

    public f l(m mVar, j jVar, c cVar, Collection collection, boolean z10, boolean z11) {
        f fVar = this.f9700f;
        if (fVar != null) {
            return fVar;
        }
        e0.b bVar = this.f9695a;
        if (bVar != null) {
            int i10 = a.f9702b[bVar.ordinal()];
            if (i10 == 1 || i10 == 2) {
                return k.i(jVar, mVar, cVar);
            }
            if (i10 == 3) {
                return m.j(jVar, mVar, cVar);
            }
            if (i10 == 4) {
                return s.i(mVar, jVar, collection, z10, z11);
            }
            if (i10 == 5) {
                return null;
            }
            throw new IllegalStateException("Do not know how to construct standard type id resolver for idType: " + this.f9695a);
        }
        throw new IllegalStateException("Cannot build, 'init()' not yet called");
    }

    /* renamed from: m */
    public o f(e0.a aVar) {
        if (aVar != null) {
            this.f9696b = aVar;
            return this;
        }
        throw new IllegalArgumentException("includeAs cannot be null");
    }

    /* renamed from: n */
    public o h(e0.b bVar, f fVar) {
        if (bVar != null) {
            this.f9695a = bVar;
            this.f9700f = fVar;
            this.f9697c = bVar.a();
            return this;
        }
        throw new IllegalArgumentException("idType cannot be null");
    }

    public c p(m mVar, j jVar, c cVar) {
        throw new IllegalArgumentException(String.format("Configured `PolymorphicTypeValidator` (of type %s) denied resolution of all subtypes of base type %s", new Object[]{d4.h.h(cVar), d4.h.h(jVar.q())}));
    }

    public c q(m mVar) {
        return mVar.w();
    }

    /* renamed from: r */
    public o a(boolean z10) {
        this.f9698d = z10;
        return this;
    }

    /* renamed from: s */
    public o c(String str) {
        if (str == null || str.isEmpty()) {
            str = this.f9695a.a();
        }
        this.f9697c = str;
        return this;
    }

    public c t(m mVar, j jVar) {
        c q10 = q(mVar);
        e0.b bVar = this.f9695a;
        if (bVar == e0.b.CLASS || bVar == e0.b.MINIMAL_CLASS) {
            c.b a10 = q10.a(mVar, jVar);
            if (a10 == c.b.DENIED) {
                return p(mVar, jVar, q10);
            }
            if (a10 == c.b.ALLOWED) {
                return l.f9691a;
            }
        }
        return q10;
    }
}
