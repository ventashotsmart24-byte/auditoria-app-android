package r3;

import c4.n;
import c4.o;
import java.lang.reflect.Type;
import k3.j;

public interface f0 {

    public static class a implements f0 {

        /* renamed from: a  reason: collision with root package name */
        public final o f9106a;

        /* renamed from: b  reason: collision with root package name */
        public final n f9107b;

        public a(o oVar, n nVar) {
            this.f9106a = oVar;
            this.f9107b = nVar;
        }

        public j a(Type type) {
            return this.f9106a.M(type, this.f9107b);
        }
    }

    j a(Type type);
}
