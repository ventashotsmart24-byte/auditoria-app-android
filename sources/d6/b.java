package d6;

import android.content.Context;
import ba.t;
import c2.d;
import com.google.android.gms.common.Scopes;
import com.hpplay.component.protocol.push.IPushHandler;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.mobile.brasiltv.bean.MemberInfo;
import com.mobile.brasiltv.bean.event.LoginSuccessEvent;
import com.mobile.brasiltv.bean.event.RequestAuthAndSlbEvent;
import com.mobile.brasiltv.bean.event.UpdateMineViewEvent;
import com.mobile.brasiltv.bean.event.UpdateRestrictEvent;
import com.mobile.brasiltv.bean.event.UserIdentityChangeEvent;
import com.mobile.brasiltv.utils.b0;
import com.umeng.analytics.pro.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mobile.com.requestframe.utils.response.AuthInfo;
import mobile.com.requestframe.utils.response.UserData;
import na.e;
import t9.g;
import w6.i;
import w6.l;
import xa.c;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f6366a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static AuthInfo f6367b;

    /* renamed from: c  reason: collision with root package name */
    public static AuthInfo f6368c;

    /* renamed from: d  reason: collision with root package name */
    public static AuthInfo f6369d;

    public static /* synthetic */ void G(b bVar, Context context, UserData userData, String str, String str2, String str3, String str4, String str5, boolean z10, int i10, Object obj) {
        String str6;
        String str7;
        String str8;
        boolean z11;
        int i11 = i10;
        if ((i11 & 16) != 0) {
            str6 = "";
        } else {
            str6 = str3;
        }
        if ((i11 & 32) != 0) {
            str7 = "";
        } else {
            str7 = str4;
        }
        if ((i11 & 64) != 0) {
            str8 = "";
        } else {
            str8 = str5;
        }
        if ((i11 & 128) != 0) {
            z11 = true;
        } else {
            z11 = z10;
        }
        bVar.F(context, userData, str, str2, str6, str7, str8, z11);
    }

    public final void A() {
        i.c cVar = i.f9510g;
        cVar.x0("");
        cVar.y0("");
        cVar.O("");
        cVar.t0("");
        cVar.b0("");
        cVar.j0("");
        cVar.d0("");
        cVar.q();
        cVar.T("");
        cVar.V("");
        cVar.U("");
        l.f19757a.e(0);
        e.f19079e = "";
        f6367b = null;
        f6368c = null;
        f6369d = null;
    }

    public final void B(List list) {
        boolean z10;
        f6367b = null;
        f6368c = null;
        f6369d = null;
        if (list == null || list.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AuthInfo authInfo = (AuthInfo) it.next();
                if (b0.J(authInfo.getServiceType()) || t9.i.b(authInfo.getServiceType(), "vip")) {
                    f6367b = authInfo;
                } else if (t9.i.b(authInfo.getServiceType(), "quality")) {
                    f6368c = authInfo;
                } else if (t9.i.b(authInfo.getServiceType(), DramaInfoBean.CATEGORY_SUPER)) {
                    f6369d = authInfo;
                }
            }
        }
    }

    public final void C(UserData userData) {
        String str;
        c c10 = c.c();
        if (userData != null) {
            str = userData.getHeartBeatTime();
        } else {
            str = null;
        }
        c10.j(new LoginSuccessEvent(str));
        c.c().j(new UserIdentityChangeEvent());
        c.c().m(new UpdateMineViewEvent());
        c.c().m(new RequestAuthAndSlbEvent(false, userData));
    }

    public final void D(HashMap hashMap) {
    }

    public final void E(Context context, String str) {
        t9.i.g(context, f.X);
        t9.i.g(str, "loginType");
        na.f.k(context, "accountType", str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x016d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void F(android.content.Context r6, mobile.com.requestframe.utils.response.UserData r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, boolean r13) {
        /*
            r5 = this;
            java.lang.String r0 = "context"
            t9.i.g(r6, r0)
            java.lang.String r0 = "data"
            t9.i.g(r7, r0)
            java.lang.String r0 = "userName"
            t9.i.g(r8, r0)
            java.lang.String r0 = "password"
            t9.i.g(r9, r0)
            java.lang.String r0 = "thirdPartType"
            t9.i.g(r10, r0)
            java.lang.String r0 = "authCode"
            t9.i.g(r11, r0)
            java.lang.String r0 = "qrAuthCode"
            t9.i.g(r12, r0)
            w6.i$c r0 = w6.i.f9510g
            java.lang.String r1 = r7.getUserId()
            r0.x0(r1)
            java.lang.String r1 = r7.getUserToken()
            r0.z0(r1)
            java.lang.String r1 = r7.getCustomer()
            r0.Y(r1)
            java.util.List r1 = r7.getPortalCodeList()
            t9.i.d(r1)
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            mobile.com.requestframe.utils.response.PortalCodeList r1 = (mobile.com.requestframe.utils.response.PortalCodeList) r1
            java.lang.String r1 = r1.getPortalCode()
            r0.l0(r1)
            java.lang.String r1 = r7.getAreaCode()
            java.lang.String r3 = ""
            if (r1 != 0) goto L_0x0058
            r1 = r3
        L_0x0058:
            r0.R(r1)
            java.lang.String r1 = r7.getBindMail()
            if (r1 != 0) goto L_0x0062
            r1 = r3
        L_0x0062:
            r0.T(r1)
            java.lang.String r1 = r7.getEmail()
            if (r1 != 0) goto L_0x006c
            r1 = r3
        L_0x006c:
            r0.b0(r1)
            java.lang.String r1 = r7.getHasPay()
            r0.g0(r1)
            java.lang.String r1 = r7.getRestrictedStatus()
            r0.q0(r1)
            java.lang.String r1 = r7.getHasPwd()
            r0.h0(r1)
            java.lang.String r1 = r7.getChildLockPwd()
            if (r1 != 0) goto L_0x008b
            r1 = r3
        L_0x008b:
            r0.W(r1)
            java.lang.String r1 = r7.getUserIdentity()
            r0.y0(r1)
            java.lang.String r1 = r7.getAppModel()
            r0.Q(r1)
            java.lang.String r1 = r7.getBindMobile()
            if (r1 != 0) goto L_0x00a3
            r1 = r3
        L_0x00a3:
            r0.V(r1)
            java.lang.String r1 = r7.getMobile()
            if (r1 != 0) goto L_0x00ad
            r1 = r3
        L_0x00ad:
            r0.j0(r1)
            java.lang.String r1 = r7.getVerificationToken()
            if (r1 != 0) goto L_0x00b7
            r1 = r3
        L_0x00b7:
            r0.B0(r1)
            java.lang.String r1 = r7.getAccountType()
            if (r1 != 0) goto L_0x00c1
            r1 = r3
        L_0x00c1:
            r0.O(r1)
            java.lang.String r1 = r7.getBindGoogle()
            java.lang.String r4 = "1"
            if (r1 != 0) goto L_0x00cd
            r1 = r4
        L_0x00cd:
            r0.U(r1)
            java.lang.String r1 = r7.getGoogleNickName()
            if (r1 != 0) goto L_0x00d7
            r1 = r3
        L_0x00d7:
            r0.d0(r1)
            java.lang.String r1 = r7.getGooglePhotoUrl()
            if (r1 != 0) goto L_0x00e1
            r1 = r3
        L_0x00e1:
            r0.e0(r1)
            com.mobile.brasiltv.bean.MemberInfo r1 = com.mobile.brasiltv.bean.MemberInfo.INSTANCE
            r1.putUserName(r8)
            r1.putPassword(r9, r2)
            java.lang.String r9 = r7.getVerificationToken()
            if (r9 != 0) goto L_0x00f3
            r9 = r3
        L_0x00f3:
            java.lang.String r1 = "verification_token"
            na.f.k(r6, r1, r9)
            java.lang.String r9 = r7.getAreaCode()
            if (r9 != 0) goto L_0x00ff
            r9 = r3
        L_0x00ff:
            java.lang.String r1 = "login_area_code"
            na.f.k(r6, r1, r9)
            java.lang.String r9 = "qr_auth_code"
            na.f.k(r6, r9, r12)
            java.lang.String r9 = "key_user_id"
            java.lang.String r1 = r0.H()
            na.f.k(r6, r9, r1)
            java.lang.String r9 = "key_user_identity"
            java.lang.String r1 = r0.I()
            na.f.k(r6, r9, r1)
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 != 0) goto L_0x0122
            goto L_0x0123
        L_0x0122:
            r8 = r12
        L_0x0123:
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 != 0) goto L_0x014d
            c2.l r9 = c2.l.f4666a
            java.lang.String r12 = r9.a()
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x014d
            java.lang.String r9 = r9.a()
            boolean r9 = t9.i.b(r8, r9)
            if (r9 != 0) goto L_0x014d
            c2.i$b r9 = c2.i.f4633q
            c2.i r9 = r9.a()
            java.lang.String r12 = r7.getUserId()
            r9.E(r8, r12)
            goto L_0x0156
        L_0x014d:
            c2.l r9 = c2.l.f4666a
            java.lang.String r12 = r7.getUserId()
            r9.f(r8, r12)
        L_0x0156:
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.lang.String r9 = "state"
            r8.put(r9, r4)
            r5.D(r8)
            c2.d r9 = c2.d.f4594a
            r9.j(r8)
            r5.I(r6, r10, r11)
            if (r13 == 0) goto L_0x0172
            java.lang.String r8 = "lastest_input_bind_email"
            na.f.k(r6, r8, r3)
        L_0x0172:
            java.lang.String r8 = r0.H()
            com.umeng.analytics.MobclickAgent.onProfileSignIn(r8)
            com.google.firebase.crashlytics.FirebaseCrashlytics r8 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            java.lang.String r9 = r0.H()
            r8.setUserId(r9)
            w6.l$a r8 = w6.l.f19757a
            int r9 = r8.d()
            int r10 = r8.b()
            r10 = r10 ^ -1
            r9 = r9 & r10
            r8.e(r9)
            int r9 = r8.d()
            int r10 = r8.a()
            r9 = r9 | r10
            r8.e(r9)
            java.lang.String r7 = r7.getUserIdentity()
            com.mobile.brasiltv.utils.i1.v(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.b.F(android.content.Context, mobile.com.requestframe.utils.response.UserData, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void");
    }

    public final void H(UserData userData) {
        t9.i.g(userData, "data");
        i.c cVar = i.f9510g;
        if (!t9.i.b(cVar.A(), "") && !t9.i.b(userData.getRestrictedStatus(), cVar.A())) {
            c.c().m(new UpdateRestrictEvent(userData.getRestrictedStatus(), false, 2, (g) null));
        }
    }

    public final void I(Context context, String str, String str2) {
        t9.i.g(context, f.X);
        t9.i.g(str, "thirdPartType");
        t9.i.g(str2, "authCode");
        na.f.k(context, "tp_type", str);
        na.f.k(context, "tp_google_auth_code", str2);
    }

    public final boolean a() {
        return b0.T(i.f9510g.s(), "1");
    }

    public final boolean b() {
        return b0.T(i.f9510g.h(), "1");
    }

    public final boolean c() {
        return b0.T(i.f9510g.i(), "2");
    }

    public final boolean d() {
        return b0.T(i.f9510g.j(), "1");
    }

    public final void e(Context context) {
        t9.i.g(context, f.X);
        r5.i.f19378a.u();
        i.c cVar = i.f9510g;
        cVar.x0("");
        cVar.y0("1");
        cVar.O("");
        cVar.t0("");
        cVar.b0("");
        cVar.j0("");
        cVar.d0("");
        cVar.q();
        cVar.T("");
        cVar.V("");
        cVar.U("");
        cVar.f0(false);
        cVar.X(false);
        cVar.r0(0);
        MemberInfo memberInfo = MemberInfo.INSTANCE;
        memberInfo.putUserName("");
        memberInfo.putPassword("", false);
        na.f.k(context, "accountType", "");
        na.f.k(context, "verification_token", "");
        na.f.k(context, "qr_auth_code", "");
        I(context, "", "");
        na.f.k(context, "lastest_input_bind_email", "");
        l.a aVar = l.f19757a;
        aVar.e(aVar.d() & (aVar.a() ^ -1));
        aVar.e(aVar.d() | aVar.b());
        e.f19079e = "";
        c2.i.f4633q.a().E("", cVar.l());
    }

    public final void f() {
        HashMap hashMap = new HashMap();
        hashMap.put(IPushHandler.STATE, "1");
        D(hashMap);
        d.f4594a.j(hashMap);
    }

    public final String g(String str) {
        if (!b0.J(str) && !b0.T(str, "1") && !b0.T(str, "2")) {
            return str;
        }
        String lastUserName = MemberInfo.INSTANCE.getLastUserName();
        if (!b0.K(lastUserName)) {
            return str;
        }
        if (t.o(lastUserName, "@", false, 2, (Object) null)) {
            return "2";
        }
        return "1";
    }

    public final void h(Context context) {
        t9.i.g(context, f.X);
        String e10 = na.f.e(context, "accountType");
        t9.i.f(e10, "loginType");
        String g10 = g(e10);
        if (!b0.T(g10, e10)) {
            na.f.k(context, "accountType", g10);
        }
    }

    public final String i(Context context) {
        if (context == null) {
            return null;
        }
        return na.f.g(context, "feedback_email");
    }

    public final String j(Context context) {
        t9.i.g(context, f.X);
        String e10 = na.f.e(context, "accountType");
        t9.i.f(e10, "loginType");
        String g10 = g(e10);
        t9.i.f(g10, "loginType");
        return g10;
    }

    public final String k(Context context) {
        t9.i.g(context, f.X);
        String e10 = na.f.e(context, "tp_google_auth_code");
        t9.i.f(e10, "getStrings(context, Constant.TP_G_AUTH_CODE)");
        return e10;
    }

    public final String l() {
        return i.f9510g.H();
    }

    public final String m(Context context) {
        t9.i.g(context, f.X);
        if (v(context) && b0.K(k(context))) {
            return k(context);
        }
        if (t9.i.b(na.f.e(context, "accountType"), "7")) {
            return na.f.e(context, "qr_auth_code");
        }
        return MemberInfo.INSTANCE.getLastUserName();
    }

    public final String n() {
        String expInvalidTime;
        AuthInfo authInfo = f6367b;
        if (authInfo == null || (expInvalidTime = authInfo.getExpInvalidTime()) == null) {
            return "";
        }
        return expInvalidTime;
    }

    public final String o() {
        String invalidTime;
        AuthInfo authInfo = f6367b;
        if (authInfo == null || (invalidTime = authInfo.getInvalidTime()) == null) {
            return "";
        }
        return invalidTime;
    }

    public final boolean p() {
        return t9.i.b(i.f9510g.I(), "3");
    }

    public final boolean q() {
        return t9.i.b(i.f9510g.I(), "2");
    }

    public final boolean r() {
        boolean z10;
        i.c cVar = i.f9510g;
        if (!t9.i.b(cVar.H(), cVar.l())) {
            return false;
        }
        if (cVar.H().length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return true;
        }
        return false;
    }

    public final boolean s(Context context, String str) {
        t9.i.g(context, f.X);
        t9.i.g(str, "matchLoginType");
        return b0.T(j(context), str);
    }

    public final boolean t() {
        i.c cVar = i.f9510g;
        if (!b0.T(cVar.i(), "1") || !b0.T(cVar.h(), "0") || !b0.T(cVar.j(), "0") || !b0.T(cVar.H(), cVar.l())) {
            return false;
        }
        return true;
    }

    public final boolean u(Context context) {
        t9.i.g(context, f.X);
        return t9.i.b(j(context), "7");
    }

    public final boolean v(Context context) {
        t9.i.g(context, f.X);
        String j10 = j(context);
        if (t9.i.b(j10, "google") || t9.i.b(j10, "facebook")) {
            return true;
        }
        return false;
    }

    public final boolean w() {
        return t9.i.b(i.f9510g.c(), "1");
    }

    public final boolean x() {
        return t9.i.b(i.f9510g.I(), "4");
    }

    public final boolean y() {
        return t9.i.b(i.f9510g.I(), "1");
    }

    public final void z(Context context, String str) {
        t9.i.g(str, Scopes.EMAIL);
        if (context != null) {
            na.f.l(context, "feedback_email", str);
        }
    }
}
