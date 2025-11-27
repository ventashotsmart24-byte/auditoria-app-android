package ma;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final String f19002a;

    /* renamed from: b  reason: collision with root package name */
    public final String f19003b;

    public k(String str, String str2) {
        this.f19002a = str;
        this.f19003b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return i.b(this.f19002a, kVar.f19002a) && i.b(this.f19003b, kVar.f19003b);
    }

    public int hashCode() {
        String str = this.f19002a;
        int i10 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f19003b;
        if (str2 != null) {
            i10 = str2.hashCode();
        }
        return hashCode + i10;
    }

    public String toString() {
        return "LoginNumberLimitEvent(token=" + this.f19002a + ", userId=" + this.f19003b + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
