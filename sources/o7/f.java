package o7;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final String f19104a;

    /* renamed from: b  reason: collision with root package name */
    public final int f19105b;

    /* renamed from: c  reason: collision with root package name */
    public final int f19106c;

    /* renamed from: d  reason: collision with root package name */
    public final long f19107d;

    /* renamed from: e  reason: collision with root package name */
    public final a f19108e;

    public enum a {
        Unknown,
        DnspodFree,
        DnspodEnterprise,
        System
    }

    public f(String str, int i10, int i11, long j10, a aVar) {
        this.f19104a = str;
        this.f19105b = i10;
        this.f19106c = i11 < 600 ? 600 : i11;
        this.f19107d = j10;
        this.f19108e = aVar;
    }

    public boolean a() {
        return b(System.currentTimeMillis() / 1000);
    }

    public boolean b(long j10) {
        if (this.f19107d + ((long) this.f19106c) < j10) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f19104a.equals(fVar.f19104a) && this.f19105b == fVar.f19105b && this.f19106c == fVar.f19106c && this.f19107d == fVar.f19107d) {
            return true;
        }
        return false;
    }
}
