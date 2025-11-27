package y3;

import c3.w;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import k3.k;
import k3.o;
import k3.s;

public class b extends s implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final String f9871a;

    /* renamed from: b  reason: collision with root package name */
    public final w f9872b;

    /* renamed from: c  reason: collision with root package name */
    public c f9873c;

    /* renamed from: d  reason: collision with root package name */
    public a f9874d;

    /* renamed from: e  reason: collision with root package name */
    public c f9875e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap f9876f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedHashSet f9877g;

    public b() {
        String str;
        this.f9873c = null;
        this.f9874d = null;
        this.f9875e = null;
        this.f9876f = null;
        this.f9877g = null;
        if (getClass() == b.class) {
            str = "SimpleModule-" + System.identityHashCode(this);
        } else {
            str = getClass().getName();
        }
        this.f9871a = str;
        this.f9872b = w.c();
    }

    public String b() {
        return this.f9871a;
    }

    public Object c() {
        if (getClass() == b.class) {
            return null;
        }
        return super.c();
    }

    public void d(s.a aVar) {
        c cVar = this.f9873c;
        if (cVar != null) {
            aVar.d(cVar);
        }
        a aVar2 = this.f9874d;
        if (aVar2 != null) {
            aVar.b(aVar2);
        }
        c cVar2 = this.f9875e;
        if (cVar2 != null) {
            aVar.e(cVar2);
        }
        LinkedHashSet linkedHashSet = this.f9877g;
        if (linkedHashSet != null && linkedHashSet.size() > 0) {
            LinkedHashSet linkedHashSet2 = this.f9877g;
            aVar.a((w3.b[]) linkedHashSet2.toArray(new w3.b[linkedHashSet2.size()]));
        }
        HashMap hashMap = this.f9876f;
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                aVar.c((Class) entry.getKey(), (Class) entry.getValue());
            }
        }
    }

    public w e() {
        return this.f9872b;
    }

    public void f(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(String.format("Cannot pass `null` as %s", new Object[]{str}));
        }
    }

    public b g(Class cls, k kVar) {
        f(cls, "type to register deserializer for");
        f(kVar, "deserializer");
        if (this.f9874d == null) {
            this.f9874d = new a();
        }
        this.f9874d.k(cls, kVar);
        return this;
    }

    public b h(o oVar) {
        f(oVar, "serializer");
        if (this.f9873c == null) {
            this.f9873c = new c();
        }
        this.f9873c.j(oVar);
        return this;
    }

    public b(String str) {
        this(str, w.c());
    }

    public b(String str, w wVar) {
        this.f9873c = null;
        this.f9874d = null;
        this.f9875e = null;
        this.f9876f = null;
        this.f9877g = null;
        this.f9871a = str;
        this.f9872b = wVar;
    }
}
