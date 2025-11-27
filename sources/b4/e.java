package b4;

import com.fasterxml.jackson.databind.ser.std.b;
import java.util.List;
import k3.b0;
import k3.c0;
import k3.d;
import k3.j;
import k3.o;
import w3.h;

public final class e extends b {
    public e(j jVar, boolean z10, h hVar, o oVar) {
        super(List.class, jVar, z10, hVar, oVar);
    }

    public a4.h c(h hVar) {
        return new e(this, this.f5731b, hVar, this.f5735f, this.f5733d);
    }

    /* renamed from: i */
    public boolean isEmpty(c0 c0Var, List list) {
        return list.isEmpty();
    }

    /* renamed from: j */
    public final void serialize(List list, c3.h hVar, c0 c0Var) {
        int size = list.size();
        if (size != 1 || ((this.f5733d != null || !c0Var.m0(b0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && this.f5733d != Boolean.TRUE)) {
            hVar.u0(list, size);
            g(list, hVar, c0Var);
            hVar.V();
            return;
        }
        g(list, hVar, c0Var);
    }

    /* renamed from: k */
    public void g(List list, c3.h hVar, c0 c0Var) {
        o oVar;
        o oVar2 = this.f5735f;
        if (oVar2 != null) {
            l(list, hVar, c0Var, oVar2);
        } else if (this.f5734e != null) {
            m(list, hVar, c0Var);
        } else {
            int size = list.size();
            if (size != 0) {
                try {
                    k kVar = this.f5736g;
                    for (int i10 = 0; i10 < size; i10++) {
                        Object obj = list.get(i10);
                        if (obj == null) {
                            c0Var.E(hVar);
                        } else {
                            Class<?> cls = obj.getClass();
                            o j10 = kVar.j(cls);
                            if (j10 == null) {
                                if (this.f5730a.w()) {
                                    oVar = f(kVar, c0Var.A(this.f5730a, cls), c0Var);
                                } else {
                                    oVar = e(kVar, cls, c0Var);
                                }
                                j10 = oVar;
                                kVar = this.f5736g;
                            }
                            j10.serialize(obj, hVar, c0Var);
                        }
                    }
                } catch (Exception e10) {
                    wrapAndThrow(c0Var, (Throwable) e10, (Object) list, 0);
                }
            }
        }
    }

    public void l(List list, c3.h hVar, c0 c0Var, o oVar) {
        int size = list.size();
        if (size != 0) {
            h hVar2 = this.f5734e;
            for (int i10 = 0; i10 < size; i10++) {
                Object obj = list.get(i10);
                if (obj == null) {
                    try {
                        c0Var.E(hVar);
                    } catch (Exception e10) {
                        wrapAndThrow(c0Var, (Throwable) e10, (Object) list, i10);
                    }
                } else if (hVar2 == null) {
                    oVar.serialize(obj, hVar, c0Var);
                } else {
                    oVar.serializeWithType(obj, hVar, c0Var, hVar2);
                }
            }
        }
    }

    public void m(List list, c3.h hVar, c0 c0Var) {
        o oVar;
        int size = list.size();
        if (size != 0) {
            try {
                h hVar2 = this.f5734e;
                k kVar = this.f5736g;
                for (int i10 = 0; i10 < size; i10++) {
                    Object obj = list.get(i10);
                    if (obj == null) {
                        c0Var.E(hVar);
                    } else {
                        Class<?> cls = obj.getClass();
                        o j10 = kVar.j(cls);
                        if (j10 == null) {
                            if (this.f5730a.w()) {
                                oVar = f(kVar, c0Var.A(this.f5730a, cls), c0Var);
                            } else {
                                oVar = e(kVar, cls, c0Var);
                            }
                            j10 = oVar;
                            kVar = this.f5736g;
                        }
                        j10.serializeWithType(obj, hVar, c0Var, hVar2);
                    }
                }
            } catch (Exception e10) {
                wrapAndThrow(c0Var, (Throwable) e10, (Object) list, 0);
            }
        }
    }

    /* renamed from: n */
    public e h(d dVar, h hVar, o oVar, Boolean bool) {
        return new e(this, dVar, hVar, oVar, bool);
    }

    public e(e eVar, d dVar, h hVar, o oVar, Boolean bool) {
        super((b) eVar, dVar, hVar, oVar, bool);
    }
}
