package b4;

import c3.h;
import c3.n;
import com.fasterxml.jackson.databind.ser.std.b0;
import i3.b;
import java.util.List;
import k3.c0;
import k3.d;
import k3.m;
import k3.o;

public final class f extends b0 {

    /* renamed from: b  reason: collision with root package name */
    public static final f f4328b = new f();

    public f() {
        super(List.class);
    }

    public o c(d dVar, Boolean bool) {
        return new f(this, bool);
    }

    public m d() {
        return createSchemaNode("string", true);
    }

    /* renamed from: f */
    public void serialize(List list, h hVar, c0 c0Var) {
        int size = list.size();
        if (size != 1 || ((this.f5737a != null || !c0Var.m0(k3.b0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && this.f5737a != Boolean.TRUE)) {
            hVar.u0(list, size);
            g(list, hVar, c0Var, size);
            hVar.V();
            return;
        }
        g(list, hVar, c0Var, 1);
    }

    public final void g(List list, h hVar, c0 c0Var, int i10) {
        int i11 = 0;
        while (i11 < i10) {
            try {
                String str = (String) list.get(i11);
                if (str == null) {
                    c0Var.E(hVar);
                } else {
                    hVar.z0(str);
                }
                i11++;
            } catch (Exception e10) {
                wrapAndThrow(c0Var, (Throwable) e10, (Object) list, i11);
                return;
            }
        }
    }

    /* renamed from: h */
    public void serializeWithType(List list, h hVar, c0 c0Var, w3.h hVar2) {
        b g10 = hVar2.g(hVar, hVar2.d(list, n.START_ARRAY));
        hVar.z(list);
        g(list, hVar, c0Var, list.size());
        hVar2.h(hVar, g10);
    }

    public f(f fVar, Boolean bool) {
        super(fVar, bool);
    }
}
