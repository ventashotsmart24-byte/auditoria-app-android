package b9;

import java.io.IOException;

public enum i {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    

    /* renamed from: a  reason: collision with root package name */
    public final String f11317a;

    /* access modifiers changed from: public */
    i(String str) {
        this.f11317a = str;
    }

    public static i a(String str) {
        i iVar = HTTP_1_0;
        if (str.equals(iVar.f11317a)) {
            return iVar;
        }
        i iVar2 = HTTP_1_1;
        if (str.equals(iVar2.f11317a)) {
            return iVar2;
        }
        i iVar3 = HTTP_2;
        if (str.equals(iVar3.f11317a)) {
            return iVar3;
        }
        i iVar4 = SPDY_3;
        if (str.equals(iVar4.f11317a)) {
            return iVar4;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    public String toString() {
        return this.f11317a;
    }
}
