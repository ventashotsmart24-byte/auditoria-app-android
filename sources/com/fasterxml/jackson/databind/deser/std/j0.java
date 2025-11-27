package com.fasterxml.jackson.databind.deser.std;

import c3.k;
import c3.n;
import com.taobao.accs.common.Constants;
import d4.q;
import java.util.Set;
import k3.g;
import n3.c;
import n3.d;
import n3.s;
import n3.t;

public class j0 extends c {
    public j0(c cVar) {
        super(cVar);
        this.f8239h = false;
    }

    public Object s(k kVar, g gVar) {
        Object obj;
        if (this.f8237f != null) {
            return c(kVar, gVar);
        }
        k3.k kVar2 = this.f8235d;
        if (kVar2 != null) {
            return this.f8234c.y(gVar, kVar2.deserialize(kVar, gVar));
        }
        if (this.f8232a.z()) {
            return gVar.W(handledType(), getValueInstantiator(), kVar, "abstract type (need to add/enable type information?)", new Object[0]);
        }
        boolean h10 = this.f8234c.h();
        boolean j10 = this.f8234c.j();
        if (h10 || j10) {
            Object obj2 = null;
            Object[] objArr = null;
            int i10 = 0;
            while (!kVar.j0(n.END_OBJECT)) {
                String m10 = kVar.m();
                t k10 = this.f8240i.k(m10);
                kVar.s0();
                if (k10 != null) {
                    if (obj2 != null) {
                        k10.l(kVar, gVar, obj2);
                    } else {
                        if (objArr == null) {
                            int size = this.f8240i.size();
                            objArr = new Object[(size + size)];
                        }
                        int i11 = i10 + 1;
                        objArr[i10] = k10;
                        i10 = i11 + 1;
                        objArr[i11] = k10.k(kVar, gVar);
                    }
                } else if (!Constants.SHARED_MESSAGE_ID_FILE.equals(m10) || !h10) {
                    Set set = this.f8243l;
                    if (set == null || !set.contains(m10)) {
                        s sVar = this.f8242k;
                        if (sVar != null) {
                            sVar.c(kVar, gVar, obj2, m10);
                        } else {
                            handleUnknownProperty(kVar, gVar, obj2, m10);
                        }
                    } else {
                        kVar.D0();
                    }
                } else {
                    obj2 = this.f8234c.v(gVar, kVar.g0());
                    if (objArr != null) {
                        for (int i12 = 0; i12 < i10; i12 += 2) {
                            ((t) objArr[i12]).C(obj2, objArr[i12 + 1]);
                        }
                        objArr = null;
                    }
                }
                kVar.s0();
            }
            if (obj2 == null) {
                if (h10) {
                    obj = this.f8234c.v(gVar, (String) null);
                } else {
                    obj = this.f8234c.x(gVar);
                }
                obj2 = obj;
                if (objArr != null) {
                    for (int i13 = 0; i13 < i10; i13 += 2) {
                        ((t) objArr[i13]).C(obj2, objArr[i13 + 1]);
                    }
                }
            }
            return obj2;
        }
        return gVar.W(handledType(), getValueInstantiator(), kVar, "Throwable needs a default constructor, a single-String-arg constructor; or explicit @JsonCreator", new Object[0]);
    }

    public k3.k unwrappingDeserializer(q qVar) {
        if (getClass() != j0.class) {
            return this;
        }
        return new j0(this, qVar);
    }

    public j0(c cVar, q qVar) {
        super((d) cVar, qVar);
    }
}
