package h9;

import java.io.Serializable;
import s9.a;
import t9.g;
import t9.i;

public final class o implements g, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public a f6973a;

    /* renamed from: b  reason: collision with root package name */
    public volatile Object f6974b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f6975c;

    public o(a aVar, Object obj) {
        i.g(aVar, "initializer");
        this.f6973a = aVar;
        this.f6974b = r.f6976a;
        this.f6975c = obj == null ? this : obj;
    }

    public boolean a() {
        if (this.f6974b != r.f6976a) {
            return true;
        }
        return false;
    }

    public Object getValue() {
        Object obj;
        Object obj2 = this.f6974b;
        r rVar = r.f6976a;
        if (obj2 != rVar) {
            return obj2;
        }
        synchronized (this.f6975c) {
            obj = this.f6974b;
            if (obj == rVar) {
                a aVar = this.f6973a;
                i.d(aVar);
                obj = aVar.invoke();
                this.f6974b = obj;
                this.f6973a = null;
            }
        }
        return obj;
    }

    public String toString() {
        if (a()) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(a aVar, Object obj, int i10, g gVar) {
        this(aVar, (i10 & 2) != 0 ? null : obj);
    }
}
