package h9;

import java.io.Serializable;
import s9.a;
import t9.i;

public final class u implements g, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public a f6977a;

    /* renamed from: b  reason: collision with root package name */
    public Object f6978b = r.f6976a;

    public u(a aVar) {
        i.g(aVar, "initializer");
        this.f6977a = aVar;
    }

    public boolean a() {
        if (this.f6978b != r.f6976a) {
            return true;
        }
        return false;
    }

    public Object getValue() {
        if (this.f6978b == r.f6976a) {
            a aVar = this.f6977a;
            i.d(aVar);
            this.f6978b = aVar.invoke();
            this.f6977a = null;
        }
        return this.f6978b;
    }

    public String toString() {
        if (a()) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }
}
