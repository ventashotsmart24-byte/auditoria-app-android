package com.fasterxml.jackson.databind.deser.std;

import c3.k;
import c3.n;
import d4.u;
import k3.g;
import k3.h;
import k3.m;
import w3.e;
import z3.a;
import z3.l;
import z3.r;

public abstract class f extends b0 {

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f5586a;

    public f(Class cls, Boolean bool) {
        super(cls);
        this.f5586a = bool;
    }

    public final m a(k kVar, g gVar, l lVar) {
        Object N = kVar.N();
        if (N == null) {
            return lVar.d();
        }
        if (N.getClass() == byte[].class) {
            return lVar.b((byte[]) N);
        }
        if (N instanceof u) {
            return lVar.m((u) N);
        }
        if (N instanceof m) {
            return (m) N;
        }
        return lVar.l(N);
    }

    public final m b(k kVar, g gVar, l lVar) {
        k.b R = kVar.R();
        if (R == k.b.BIG_DECIMAL) {
            return lVar.i(kVar.L());
        }
        if (gVar.n0(h.USE_BIG_DECIMAL_FOR_FLOATS)) {
            if (kVar.p0()) {
                return lVar.e(kVar.M());
            }
            return lVar.i(kVar.L());
        } else if (R == k.b.FLOAT) {
            return lVar.f(kVar.O());
        } else {
            return lVar.e(kVar.M());
        }
    }

    public final m c(k kVar, g gVar, l lVar) {
        k.b bVar;
        int P = gVar.P();
        if ((b0.F_MASK_INT_COERCIONS & P) == 0) {
            bVar = kVar.R();
        } else if (h.USE_BIG_INTEGER_FOR_INTS.c(P)) {
            bVar = k.b.BIG_INTEGER;
        } else if (h.USE_LONG_FOR_INTS.c(P)) {
            bVar = k.b.LONG;
        } else {
            bVar = kVar.R();
        }
        if (bVar == k.b.INT) {
            return lVar.g(kVar.P());
        }
        if (bVar == k.b.LONG) {
            return lVar.h(kVar.Q());
        }
        return lVar.j(kVar.s());
    }

    public void d(k kVar, g gVar, l lVar, String str, r rVar, m mVar, m mVar2) {
        if (gVar.n0(h.FAIL_ON_READING_DUP_TREE_KEY)) {
            gVar.w0(m.class, "Duplicate field '%s' for `ObjectNode`: not allowed when `DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY` enabled", str);
        }
        if (!gVar.m0(c3.r.DUPLICATE_PROPERTIES)) {
            return;
        }
        if (mVar.p()) {
            ((a) mVar).C(mVar2);
            rVar.F(str, mVar);
            return;
        }
        a a10 = lVar.a();
        a10.C(mVar);
        a10.C(mVar2);
        rVar.F(str, a10);
    }

    public Object deserializeWithType(k kVar, g gVar, e eVar) {
        return eVar.c(kVar, gVar);
    }

    public final m e(k kVar, g gVar, l lVar) {
        int q10 = kVar.q();
        if (q10 == 2) {
            return lVar.k();
        }
        switch (q10) {
            case 5:
                return h(kVar, gVar, lVar);
            case 6:
                return lVar.n(kVar.Y());
            case 7:
                return c(kVar, gVar, lVar);
            case 8:
                return b(kVar, gVar, lVar);
            case 9:
                return lVar.c(true);
            case 10:
                return lVar.c(false);
            case 11:
                return lVar.d();
            case 12:
                return a(kVar, gVar, lVar);
            default:
                return (m) gVar.a0(handledType(), kVar);
        }
    }

    public final a f(k kVar, g gVar, l lVar) {
        a a10 = lVar.a();
        while (true) {
            n s02 = kVar.s0();
            if (s02 != null) {
                switch (s02.c()) {
                    case 1:
                        a10.C(g(kVar, gVar, lVar));
                        break;
                    case 3:
                        a10.C(f(kVar, gVar, lVar));
                        break;
                    case 4:
                        return a10;
                    case 6:
                        a10.C(lVar.n(kVar.Y()));
                        break;
                    case 7:
                        a10.C(c(kVar, gVar, lVar));
                        break;
                    case 9:
                        a10.C(lVar.c(true));
                        break;
                    case 10:
                        a10.C(lVar.c(false));
                        break;
                    case 11:
                        a10.C(lVar.d());
                        break;
                    case 12:
                        a10.C(a(kVar, gVar, lVar));
                        break;
                    default:
                        a10.C(e(kVar, gVar, lVar));
                        break;
                }
            } else {
                return a10;
            }
        }
    }

    public final r g(k kVar, g gVar, l lVar) {
        m mVar;
        r k10 = lVar.k();
        String q02 = kVar.q0();
        while (q02 != null) {
            n s02 = kVar.s0();
            if (s02 == null) {
                s02 = n.NOT_AVAILABLE;
            }
            int c10 = s02.c();
            if (c10 == 1) {
                mVar = g(kVar, gVar, lVar);
            } else if (c10 == 3) {
                mVar = f(kVar, gVar, lVar);
            } else if (c10 == 6) {
                mVar = lVar.n(kVar.Y());
            } else if (c10 != 7) {
                switch (c10) {
                    case 9:
                        mVar = lVar.c(true);
                        break;
                    case 10:
                        mVar = lVar.c(false);
                        break;
                    case 11:
                        mVar = lVar.d();
                        break;
                    case 12:
                        mVar = a(kVar, gVar, lVar);
                        break;
                    default:
                        mVar = e(kVar, gVar, lVar);
                        break;
                }
            } else {
                mVar = c(kVar, gVar, lVar);
            }
            m mVar2 = mVar;
            m F = k10.F(q02, mVar2);
            if (F != null) {
                d(kVar, gVar, lVar, q02, k10, F, mVar2);
            }
            q02 = kVar.q0();
        }
        return k10;
    }

    public final r h(k kVar, g gVar, l lVar) {
        m mVar;
        r k10 = lVar.k();
        String m10 = kVar.m();
        while (m10 != null) {
            n s02 = kVar.s0();
            if (s02 == null) {
                s02 = n.NOT_AVAILABLE;
            }
            int c10 = s02.c();
            if (c10 == 1) {
                mVar = g(kVar, gVar, lVar);
            } else if (c10 == 3) {
                mVar = f(kVar, gVar, lVar);
            } else if (c10 == 6) {
                mVar = lVar.n(kVar.Y());
            } else if (c10 != 7) {
                switch (c10) {
                    case 9:
                        mVar = lVar.c(true);
                        break;
                    case 10:
                        mVar = lVar.c(false);
                        break;
                    case 11:
                        mVar = lVar.d();
                        break;
                    case 12:
                        mVar = a(kVar, gVar, lVar);
                        break;
                    default:
                        mVar = e(kVar, gVar, lVar);
                        break;
                }
            } else {
                mVar = c(kVar, gVar, lVar);
            }
            m mVar2 = mVar;
            m F = k10.F(m10, mVar2);
            if (F != null) {
                d(kVar, gVar, lVar, m10, k10, F, mVar2);
            }
            m10 = kVar.q0();
        }
        return k10;
    }

    public final m i(k kVar, g gVar, a aVar) {
        l R = gVar.R();
        while (true) {
            switch (kVar.s0().c()) {
                case 1:
                    aVar.C(g(kVar, gVar, R));
                    break;
                case 3:
                    aVar.C(f(kVar, gVar, R));
                    break;
                case 4:
                    return aVar;
                case 6:
                    aVar.C(R.n(kVar.Y()));
                    break;
                case 7:
                    aVar.C(c(kVar, gVar, R));
                    break;
                case 9:
                    aVar.C(R.c(true));
                    break;
                case 10:
                    aVar.C(R.c(false));
                    break;
                case 11:
                    aVar.C(R.d());
                    break;
                case 12:
                    aVar.C(a(kVar, gVar, R));
                    break;
                default:
                    aVar.C(e(kVar, gVar, R));
                    break;
            }
        }
    }

    public boolean isCachable() {
        return true;
    }

    public final m j(k kVar, g gVar, r rVar) {
        String str;
        m mVar;
        if (kVar.o0()) {
            str = kVar.q0();
        } else if (!kVar.j0(n.FIELD_NAME)) {
            return (m) deserialize(kVar, gVar);
        } else {
            str = kVar.m();
        }
        while (str != null) {
            n s02 = kVar.s0();
            m n10 = rVar.n(str);
            if (n10 != null) {
                if (n10 instanceof r) {
                    if (s02 == n.START_OBJECT) {
                        m j10 = j(kVar, gVar, (r) n10);
                        if (j10 != n10) {
                            rVar.G(str, j10);
                        }
                        str = kVar.q0();
                    }
                } else if ((n10 instanceof a) && s02 == n.START_ARRAY) {
                    m i10 = i(kVar, gVar, (a) n10);
                    if (i10 != n10) {
                        rVar.G(str, i10);
                    }
                    str = kVar.q0();
                }
            }
            if (s02 == null) {
                s02 = n.NOT_AVAILABLE;
            }
            l R = gVar.R();
            int c10 = s02.c();
            if (c10 == 1) {
                mVar = g(kVar, gVar, R);
            } else if (c10 == 3) {
                mVar = f(kVar, gVar, R);
            } else if (c10 == 6) {
                mVar = R.n(kVar.Y());
            } else if (c10 != 7) {
                switch (c10) {
                    case 9:
                        mVar = R.c(true);
                        break;
                    case 10:
                        mVar = R.c(false);
                        break;
                    case 11:
                        mVar = R.d();
                        break;
                    case 12:
                        mVar = a(kVar, gVar, R);
                        break;
                    default:
                        mVar = e(kVar, gVar, R);
                        break;
                }
            } else {
                mVar = c(kVar, gVar, R);
            }
            rVar.G(str, mVar);
            str = kVar.q0();
        }
        return rVar;
    }

    public c4.f logicalType() {
        return c4.f.Untyped;
    }

    public Boolean supportsUpdate(k3.f fVar) {
        return this.f5586a;
    }
}
