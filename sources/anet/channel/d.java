package anet.channel;

import anet.channel.security.ISecurity;
import anet.channel.strategy.dispatch.IAmdcSign;

class d implements IAmdcSign {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3636a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ISecurity f3637b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ SessionCenter f3638c;

    public d(SessionCenter sessionCenter, String str, ISecurity iSecurity) {
        this.f3638c = sessionCenter;
        this.f3636a = str;
        this.f3637b = iSecurity;
    }

    public String getAppkey() {
        return this.f3636a;
    }

    public String sign(String str) {
        return this.f3637b.sign(this.f3638c.f3577b, ISecurity.SIGN_ALGORITHM_HMAC_SHA1, getAppkey(), str);
    }

    public boolean useSecurityGuard() {
        return !this.f3637b.isSecOff();
    }
}
