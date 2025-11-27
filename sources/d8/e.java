package d8;

import t9.g;
import t9.i;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public int f16413a;

    /* renamed from: b  reason: collision with root package name */
    public String f16414b;

    /* renamed from: c  reason: collision with root package name */
    public String f16415c;

    /* renamed from: d  reason: collision with root package name */
    public float f16416d;

    public e(int i10, String str, String str2, float f10) {
        i.h(str, "codec");
        i.h(str2, "lang");
        this.f16413a = i10;
        this.f16414b = str;
        this.f16415c = str2;
        this.f16416d = f10;
    }

    public final void a(String str) {
        i.h(str, "<set-?>");
        this.f16414b = str;
    }

    public final void b(int i10) {
        this.f16413a = i10;
    }

    public final void c(String str) {
        i.h(str, "<set-?>");
        this.f16415c = str;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                if (!(this.f16413a == eVar.f16413a) || !i.b(this.f16414b, eVar.f16414b) || !i.b(this.f16415c, eVar.f16415c) || Float.compare(this.f16416d, eVar.f16416d) != 0) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i10 = this.f16413a * 31;
        String str = this.f16414b;
        int i11 = 0;
        int hashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f16415c;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return ((hashCode + i11) * 31) + Float.floatToIntBits(this.f16416d);
    }

    public String toString() {
        return "SubTitleTrackInfo(id=" + this.f16413a + ", codec=" + this.f16414b + ", lang=" + this.f16415c + ", delay=" + this.f16416d + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i10, String str, String str2, float f10, int i11, g gVar) {
        this((i11 & 1) != 0 ? -1 : i10, (i11 & 2) != 0 ? "" : str, (i11 & 4) != 0 ? "" : str2, (i11 & 8) != 0 ? 0.0f : f10);
    }
}
