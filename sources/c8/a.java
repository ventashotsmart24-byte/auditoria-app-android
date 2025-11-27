package c8;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f11373a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f11374b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f11375c;

    public a(String str, boolean z10, boolean z11) {
        this.f11373a = str;
        this.f11374b = z10;
        this.f11375c = z11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f11374b == aVar.f11374b && this.f11375c == aVar.f11375c) {
            return this.f11373a.equals(aVar.f11373a);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f11373a.hashCode() * 31) + (this.f11374b ? 1 : 0)) * 31) + (this.f11375c ? 1 : 0);
    }

    public String toString() {
        return "Permission{name='" + this.f11373a + '\'' + ", granted=" + this.f11374b + ", shouldShowRequestPermissionRationale=" + this.f11375c + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
