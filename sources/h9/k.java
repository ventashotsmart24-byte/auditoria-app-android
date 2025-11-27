package h9;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

public final class k implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final Object f17315a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f17316b;

    public k(Object obj, Object obj2) {
        this.f17315a = obj;
        this.f17316b = obj2;
    }

    public final Object a() {
        return this.f17315a;
    }

    public final Object b() {
        return this.f17316b;
    }

    public final Object c() {
        return this.f17315a;
    }

    public final Object d() {
        return this.f17316b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return i.b(this.f17315a, kVar.f17315a) && i.b(this.f17316b, kVar.f17316b);
    }

    public int hashCode() {
        Object obj = this.f17315a;
        int i10 = 0;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f17316b;
        if (obj2 != null) {
            i10 = obj2.hashCode();
        }
        return hashCode + i10;
    }

    public String toString() {
        return ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN + this.f17315a + ", " + this.f17316b + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
