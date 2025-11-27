package ca;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import s9.l;
import t9.i;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public final Object f11550a;

    /* renamed from: b  reason: collision with root package name */
    public final l f11551b;

    public t(Object obj, l lVar) {
        this.f11550a = obj;
        this.f11551b = lVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return i.b(this.f11550a, tVar.f11550a) && i.b(this.f11551b, tVar.f11551b);
    }

    public int hashCode() {
        Object obj = this.f11550a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f11551b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f11550a + ", onCancellation=" + this.f11551b + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
