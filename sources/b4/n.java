package b4;

import c3.h;
import com.fasterxml.jackson.databind.ser.std.b0;
import i3.b;
import java.util.Collection;
import java.util.Iterator;
import k3.c0;
import k3.d;
import k3.m;
import k3.o;

public class n extends b0 {

    /* renamed from: b  reason: collision with root package name */
    public static final n f4373b = new n();

    public n() {
        super(Collection.class);
    }

    public o c(d dVar, Boolean bool) {
        return new n(this, bool);
    }

    public m d() {
        return createSchemaNode("string", true);
    }

    /* renamed from: f */
    public void serialize(Collection collection, h hVar, c0 c0Var) {
        int size = collection.size();
        if (size != 1 || ((this.f5737a != null || !c0Var.m0(k3.b0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && this.f5737a != Boolean.TRUE)) {
            hVar.u0(collection, size);
            g(collection, hVar, c0Var);
            hVar.V();
            return;
        }
        g(collection, hVar, c0Var);
    }

    public final void g(Collection collection, h hVar, c0 c0Var) {
        int i10 = 0;
        try {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str == null) {
                    c0Var.E(hVar);
                } else {
                    hVar.z0(str);
                }
                i10++;
            }
        } catch (Exception e10) {
            wrapAndThrow(c0Var, (Throwable) e10, (Object) collection, 0);
        }
    }

    /* renamed from: h */
    public void serializeWithType(Collection collection, h hVar, c0 c0Var, w3.h hVar2) {
        b g10 = hVar2.g(hVar, hVar2.d(collection, c3.n.START_ARRAY));
        hVar.z(collection);
        g(collection, hVar, c0Var);
        hVar2.h(hVar, g10);
    }

    public n(n nVar, Boolean bool) {
        super(nVar, bool);
    }
}
