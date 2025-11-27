package s5;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.mobile.brasiltv.db.SwitchAccountBean;
import t9.i;
import x7.a;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f19454a;

    /* renamed from: b  reason: collision with root package name */
    public c f19455b;

    /* renamed from: c  reason: collision with root package name */
    public String f19456c;

    /* renamed from: d  reason: collision with root package name */
    public SwitchAccountBean f19457d;

    /* renamed from: e  reason: collision with root package name */
    public String f19458e;

    /* renamed from: f  reason: collision with root package name */
    public String f19459f;

    /* renamed from: g  reason: collision with root package name */
    public a f19460g;

    /* renamed from: h  reason: collision with root package name */
    public String f19461h;

    /* renamed from: i  reason: collision with root package name */
    public String f19462i;

    /* renamed from: j  reason: collision with root package name */
    public String f19463j;

    public d(boolean z10, c cVar, String str, SwitchAccountBean switchAccountBean, String str2, String str3, a aVar, String str4, String str5, String str6) {
        i.g(str, "sQrToken");
        i.g(str3, "sThirdPartType");
        i.g(str4, "sCreateType");
        i.g(str5, "sTpSource");
        this.f19454a = z10;
        this.f19455b = cVar;
        this.f19456c = str;
        this.f19457d = switchAccountBean;
        this.f19458e = str2;
        this.f19459f = str3;
        this.f19460g = aVar;
        this.f19461h = str4;
        this.f19462i = str5;
        this.f19463j = str6;
    }

    public final String a() {
        return this.f19461h;
    }

    public final c b() {
        return this.f19455b;
    }

    public final boolean c() {
        return this.f19454a;
    }

    public final String d() {
        return this.f19456c;
    }

    public final a e() {
        return this.f19460g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f19454a == dVar.f19454a && this.f19455b == dVar.f19455b && i.b(this.f19456c, dVar.f19456c) && i.b(this.f19457d, dVar.f19457d) && i.b(this.f19458e, dVar.f19458e) && i.b(this.f19459f, dVar.f19459f) && i.b(this.f19460g, dVar.f19460g) && i.b(this.f19461h, dVar.f19461h) && i.b(this.f19462i, dVar.f19462i) && i.b(this.f19463j, dVar.f19463j);
    }

    public final SwitchAccountBean f() {
        return this.f19457d;
    }

    public final String g() {
        return this.f19459f;
    }

    public final String h() {
        return this.f19463j;
    }

    public int hashCode() {
        boolean z10 = this.f19454a;
        if (z10) {
            z10 = true;
        }
        int i10 = (z10 ? 1 : 0) * true;
        c cVar = this.f19455b;
        int i11 = 0;
        int hashCode = (((i10 + (cVar == null ? 0 : cVar.hashCode())) * 31) + this.f19456c.hashCode()) * 31;
        SwitchAccountBean switchAccountBean = this.f19457d;
        int hashCode2 = (hashCode + (switchAccountBean == null ? 0 : switchAccountBean.hashCode())) * 31;
        String str = this.f19458e;
        int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.f19459f.hashCode()) * 31;
        a aVar = this.f19460g;
        int hashCode4 = (((((hashCode3 + (aVar == null ? 0 : aVar.hashCode())) * 31) + this.f19461h.hashCode()) * 31) + this.f19462i.hashCode()) * 31;
        String str2 = this.f19463j;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode4 + i11;
    }

    public final String i() {
        return this.f19462i;
    }

    public final String j() {
        return this.f19458e;
    }

    public final void k(boolean z10) {
        this.f19454a = z10;
    }

    public final void l(String str) {
        this.f19463j = str;
    }

    public String toString() {
        return "TmpLoginBean(sNeedLogOut=" + this.f19454a + ", sLoginType=" + this.f19455b + ", sQrToken=" + this.f19456c + ", sSwitchAccountBean=" + this.f19457d + ", sVerificationCode=" + this.f19458e + ", sThirdPartType=" + this.f19459f + ", sSocialInfo=" + this.f19460g + ", sCreateType=" + this.f19461h + ", sTpSource=" + this.f19462i + ", sTpPassword=" + this.f19463j + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
