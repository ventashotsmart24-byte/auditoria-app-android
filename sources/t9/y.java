package t9;

import z9.b;
import z9.c;
import z9.d;
import z9.e;
import z9.f;

public class y {
    public b a(Class cls) {
        return new e(cls);
    }

    public c b(Class cls, String str) {
        return new n(cls, str);
    }

    public d c(k kVar) {
        return kVar;
    }

    public e d(o oVar) {
        return oVar;
    }

    public f e(q qVar) {
        return qVar;
    }

    public String f(h hVar) {
        String obj = hVar.getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            return obj.substring(21);
        }
        return obj;
    }

    public String g(j jVar) {
        return f(jVar);
    }
}
