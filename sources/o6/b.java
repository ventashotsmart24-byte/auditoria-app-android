package o6;

import t9.i;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f19083a;

    /* renamed from: b  reason: collision with root package name */
    public final String f19084b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f19085c;

    public b(String str, String str2, boolean z10) {
        i.g(str, "displayQuality");
        i.g(str2, "qualityValue");
        this.f19083a = str;
        this.f19084b = str2;
        this.f19085c = z10;
    }

    public final String a() {
        return this.f19083a;
    }

    public final int b() {
        String str = this.f19083a;
        int hashCode = str.hashCode();
        if (hashCode == 1604516) {
            boolean equals = str.equals("480P");
            return 1;
        } else if (hashCode != 1688123) {
            if (hashCode == 46737881 && str.equals("1080P")) {
                return 3;
            }
            return 1;
        } else if (!str.equals("720P")) {
            return 1;
        } else {
            return 2;
        }
    }

    public final String c() {
        return this.f19084b;
    }

    public final boolean d() {
        return this.f19085c;
    }
}
