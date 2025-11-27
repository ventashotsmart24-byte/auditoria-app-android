package h9;

import c8.b;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import t9.g;
import t9.i;

public final class n implements g, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final a f6968d = new a((g) null);

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f6969e = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, b.f11376b);

    /* renamed from: a  reason: collision with root package name */
    public volatile s9.a f6970a;

    /* renamed from: b  reason: collision with root package name */
    public volatile Object f6971b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f6972c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public n(s9.a aVar) {
        i.g(aVar, "initializer");
        this.f6970a = aVar;
        r rVar = r.f6976a;
        this.f6971b = rVar;
        this.f6972c = rVar;
    }

    public boolean a() {
        if (this.f6971b != r.f6976a) {
            return true;
        }
        return false;
    }

    public Object getValue() {
        Object obj = this.f6971b;
        r rVar = r.f6976a;
        if (obj != rVar) {
            return obj;
        }
        s9.a aVar = this.f6970a;
        if (aVar != null) {
            Object invoke = aVar.invoke();
            if (androidx.concurrent.futures.b.a(f6969e, this, rVar, invoke)) {
                this.f6970a = null;
                return invoke;
            }
        }
        return this.f6971b;
    }

    public String toString() {
        if (a()) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }
}
