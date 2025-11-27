package ca;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

public final class p0 implements a1 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f11536a;

    public p0(boolean z10) {
        this.f11536a = z10;
    }

    public q1 c() {
        return null;
    }

    public boolean isActive() {
        return this.f11536a;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        if (isActive()) {
            str = "Active";
        } else {
            str = "New";
        }
        sb.append(str);
        sb.append(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
        return sb.toString();
    }
}
