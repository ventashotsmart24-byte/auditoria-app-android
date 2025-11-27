package ba;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;
import y9.c;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f11347a;

    /* renamed from: b  reason: collision with root package name */
    public final c f11348b;

    public e(String str, c cVar) {
        i.g(str, "value");
        i.g(cVar, "range");
        this.f11347a = str;
        this.f11348b = cVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return i.b(this.f11347a, eVar.f11347a) && i.b(this.f11348b, eVar.f11348b);
    }

    public int hashCode() {
        return (this.f11347a.hashCode() * 31) + this.f11348b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.f11347a + ", range=" + this.f11348b + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
