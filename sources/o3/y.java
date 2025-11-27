package o3;

import b3.k0;
import b3.o0;
import c3.k;
import java.util.BitSet;
import k3.g;
import k3.h;
import k3.l;
import n3.s;
import n3.t;
import o3.x;
import r3.i;

public class y {

    /* renamed from: a  reason: collision with root package name */
    public final k f8554a;

    /* renamed from: b  reason: collision with root package name */
    public final g f8555b;

    /* renamed from: c  reason: collision with root package name */
    public final s f8556c;

    /* renamed from: d  reason: collision with root package name */
    public final Object[] f8557d;

    /* renamed from: e  reason: collision with root package name */
    public int f8558e;

    /* renamed from: f  reason: collision with root package name */
    public int f8559f;

    /* renamed from: g  reason: collision with root package name */
    public final BitSet f8560g;

    /* renamed from: h  reason: collision with root package name */
    public x f8561h;

    /* renamed from: i  reason: collision with root package name */
    public Object f8562i;

    public y(k kVar, g gVar, int i10, s sVar) {
        this.f8554a = kVar;
        this.f8555b = gVar;
        this.f8558e = i10;
        this.f8556c = sVar;
        this.f8557d = new Object[i10];
        if (i10 < 32) {
            this.f8560g = null;
        } else {
            this.f8560g = new BitSet();
        }
    }

    public Object a(t tVar) {
        if (tVar.q() != null) {
            return this.f8555b.E(tVar.q(), tVar, (Object) null);
        }
        if (tVar.f()) {
            this.f8555b.x0(tVar, "Missing required creator property '%s' (index %d)", tVar.getName(), Integer.valueOf(tVar.p()));
        }
        if (this.f8555b.n0(h.FAIL_ON_MISSING_CREATOR_PROPERTIES)) {
            this.f8555b.x0(tVar, "Missing creator property '%s' (index %d); `DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES` enabled", tVar.getName(), Integer.valueOf(tVar.p()));
        }
        try {
            Object nullValue = tVar.s().getNullValue(this.f8555b);
            if (nullValue != null) {
                return nullValue;
            }
            return tVar.u().getNullValue(this.f8555b);
        } catch (l e10) {
            i d10 = tVar.d();
            if (d10 != null) {
                e10.n(d10.k(), tVar.getName());
            }
            throw e10;
        }
    }

    public boolean b(t tVar, Object obj) {
        int p10 = tVar.p();
        this.f8557d[p10] = obj;
        BitSet bitSet = this.f8560g;
        if (bitSet == null) {
            int i10 = this.f8559f;
            int i11 = (1 << p10) | i10;
            if (i10 != i11) {
                this.f8559f = i11;
                int i12 = this.f8558e - 1;
                this.f8558e = i12;
                if (i12 <= 0) {
                    if (this.f8556c == null || this.f8562i != null) {
                        return true;
                    }
                    return false;
                }
            }
        } else if (!bitSet.get(p10)) {
            this.f8560g.set(p10);
            this.f8558e--;
        }
        return false;
    }

    public void c(s sVar, String str, Object obj) {
        this.f8561h = new x.a(this.f8561h, obj, sVar, str);
    }

    public void d(Object obj, Object obj2) {
        this.f8561h = new x.b(this.f8561h, obj2, obj);
    }

    public void e(t tVar, Object obj) {
        this.f8561h = new x.c(this.f8561h, obj, tVar);
    }

    public x f() {
        return this.f8561h;
    }

    public Object[] g(t[] tVarArr) {
        if (this.f8558e > 0) {
            if (this.f8560g != null) {
                int length = this.f8557d.length;
                int i10 = 0;
                while (true) {
                    int nextClearBit = this.f8560g.nextClearBit(i10);
                    if (nextClearBit >= length) {
                        break;
                    }
                    this.f8557d[nextClearBit] = a(tVarArr[nextClearBit]);
                    i10 = nextClearBit + 1;
                }
            } else {
                int i11 = this.f8559f;
                int length2 = this.f8557d.length;
                int i12 = 0;
                while (i12 < length2) {
                    if ((i11 & 1) == 0) {
                        this.f8557d[i12] = a(tVarArr[i12]);
                    }
                    i12++;
                    i11 >>= 1;
                }
            }
        }
        if (this.f8555b.n0(h.FAIL_ON_NULL_CREATOR_PROPERTIES)) {
            for (int i13 = 0; i13 < tVarArr.length; i13++) {
                if (this.f8557d[i13] == null) {
                    t tVar = tVarArr[i13];
                    this.f8555b.x0(tVar, "Null value for creator property '%s' (index %d); `DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES` enabled", tVar.getName(), Integer.valueOf(tVarArr[i13].p()));
                }
            }
        }
        return this.f8557d;
    }

    public Object h(g gVar, Object obj) {
        s sVar = this.f8556c;
        if (sVar != null) {
            Object obj2 = this.f8562i;
            if (obj2 != null) {
                k0 k0Var = sVar.f8536c;
                sVar.getClass();
                gVar.H(obj2, k0Var, (o0) null).b(obj);
                t tVar = this.f8556c.f8538e;
                if (tVar != null) {
                    return tVar.D(obj, this.f8562i);
                }
            } else {
                gVar.D0(sVar, obj);
            }
        }
        return obj;
    }

    public boolean i(String str) {
        s sVar = this.f8556c;
        if (sVar == null || !str.equals(sVar.f8535b.c())) {
            return false;
        }
        this.f8562i = this.f8556c.f(this.f8554a, this.f8555b);
        return true;
    }
}
