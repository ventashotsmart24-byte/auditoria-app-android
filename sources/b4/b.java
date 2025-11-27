package b4;

import a4.c;
import c3.h;
import c3.n;
import com.fasterxml.jackson.databind.ser.std.d;
import d4.q;
import java.util.Set;
import k3.b0;
import k3.c0;
import k3.l;
import k3.o;

public class b extends d {

    /* renamed from: k  reason: collision with root package name */
    public final d f4322k;

    public b(d dVar) {
        super(dVar, (i) null);
        this.f4322k = dVar;
    }

    public d g() {
        return this;
    }

    public boolean isUnwrappingSerializer() {
        return false;
    }

    /* renamed from: m */
    public d withFilterId(Object obj) {
        return new b((d) this, this.f5753g, obj);
    }

    public d n(i iVar) {
        return this.f4322k.n(iVar);
    }

    public d o(c[] cVarArr, c[] cVarArr2) {
        return this;
    }

    public final boolean p(c0 c0Var) {
        c[] cVarArr;
        if (this.f5749c == null || c0Var.V() == null) {
            cVarArr = this.f5748b;
        } else {
            cVarArr = this.f5749c;
        }
        if (cVarArr.length == 1) {
            return true;
        }
        return false;
    }

    public final void q(Object obj, h hVar, c0 c0Var) {
        c[] cVarArr;
        String str = "[anySetter]";
        if (this.f5749c == null || c0Var.V() == null) {
            cVarArr = this.f5748b;
        } else {
            cVarArr = this.f5749c;
        }
        try {
            for (c cVar : cVarArr) {
                if (cVar == null) {
                    hVar.a0();
                } else {
                    cVar.x(obj, hVar, c0Var);
                }
            }
        } catch (Exception e10) {
            if (0 != cVarArr.length) {
                str = cVarArr[0].getName();
            }
            wrapAndThrow(c0Var, (Throwable) e10, obj, str);
        } catch (StackOverflowError e11) {
            l h10 = l.h(hVar, "Infinite recursion (StackOverflowError)", e11);
            if (0 != cVarArr.length) {
                str = cVarArr[0].getName();
            }
            h10.o(new l.a(obj, str));
            throw h10;
        }
    }

    /* renamed from: r */
    public b l(Set set, Set set2) {
        return new b((d) this, set, set2);
    }

    public final void serialize(Object obj, h hVar, c0 c0Var) {
        if (!c0Var.m0(b0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) || !p(c0Var)) {
            hVar.t0(obj);
            q(obj, hVar, c0Var);
            hVar.V();
            return;
        }
        q(obj, hVar, c0Var);
    }

    public void serializeWithType(Object obj, h hVar, c0 c0Var, w3.h hVar2) {
        if (this.f5753g != null) {
            d(obj, hVar, c0Var, hVar2);
            return;
        }
        i3.b f10 = f(hVar2, obj, n.START_ARRAY);
        hVar2.g(hVar, f10);
        hVar.z(obj);
        q(obj, hVar, c0Var);
        hVar2.h(hVar, f10);
    }

    public String toString() {
        return "BeanAsArraySerializer for " + handledType().getName();
    }

    public o unwrappingSerializer(q qVar) {
        return this.f4322k.unwrappingSerializer(qVar);
    }

    public b(d dVar, Set set, Set set2) {
        super(dVar, set, set2);
        this.f4322k = dVar;
    }

    public b(d dVar, i iVar, Object obj) {
        super(dVar, iVar, obj);
        this.f4322k = dVar;
    }
}
