package o3;

import b3.k0;
import b3.n0;

public class w extends n0 {
    public w(Class cls) {
        super(cls);
    }

    public k0 b(Class cls) {
        if (cls == this.f4282a) {
            return this;
        }
        return new w(cls);
    }

    public Object c(Object obj) {
        throw new UnsupportedOperationException();
    }

    public k0.a f(Object obj) {
        if (obj == null) {
            return null;
        }
        return new k0.a(getClass(), this.f4282a, obj);
    }

    public k0 h(Object obj) {
        return this;
    }
}
