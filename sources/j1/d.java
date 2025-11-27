package j1;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f7063a;

    /* renamed from: b  reason: collision with root package name */
    public Long f7064b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public d(String str, boolean z10) {
        this(str, z10 ? 1 : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.f7063a.equals(dVar.f7063a)) {
            return false;
        }
        Long l10 = this.f7064b;
        Long l11 = dVar.f7064b;
        if (l10 != null) {
            return l10.equals(l11);
        }
        if (l11 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = this.f7063a.hashCode() * 31;
        Long l10 = this.f7064b;
        if (l10 != null) {
            i10 = l10.hashCode();
        } else {
            i10 = 0;
        }
        return hashCode + i10;
    }

    public d(String str, long j10) {
        this.f7063a = str;
        this.f7064b = Long.valueOf(j10);
    }
}
