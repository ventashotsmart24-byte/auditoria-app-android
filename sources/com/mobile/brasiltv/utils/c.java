package com.mobile.brasiltv.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.hpplay.cybergarage.xml.XML;
import com.mobile.brasiltv.bean.MemberInfo;
import com.umeng.analytics.pro.f;
import h9.h;
import t9.i;
import t9.j;
import t9.l;
import t9.x;
import z9.g;

public final class c {

    /* renamed from: s  reason: collision with root package name */
    public static final /* synthetic */ g[] f6167s;

    /* renamed from: a  reason: collision with root package name */
    public final Context f6168a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6169b = "share_data";

    /* renamed from: c  reason: collision with root package name */
    public final h9.g f6170c = h.b(new a(this));

    /* renamed from: d  reason: collision with root package name */
    public final v9.a f6171d;

    /* renamed from: e  reason: collision with root package name */
    public final v9.a f6172e;

    /* renamed from: f  reason: collision with root package name */
    public final v9.a f6173f;

    /* renamed from: g  reason: collision with root package name */
    public final v9.a f6174g;

    /* renamed from: h  reason: collision with root package name */
    public final v9.a f6175h;

    /* renamed from: i  reason: collision with root package name */
    public final v9.a f6176i;

    /* renamed from: j  reason: collision with root package name */
    public final v9.a f6177j;

    /* renamed from: k  reason: collision with root package name */
    public final v9.a f6178k;

    /* renamed from: l  reason: collision with root package name */
    public final v9.a f6179l;

    /* renamed from: m  reason: collision with root package name */
    public final v9.a f6180m;

    /* renamed from: n  reason: collision with root package name */
    public final v9.a f6181n;

    /* renamed from: o  reason: collision with root package name */
    public final v9.a f6182o;

    /* renamed from: p  reason: collision with root package name */
    public final v9.a f6183p;

    /* renamed from: q  reason: collision with root package name */
    public final v9.a f6184q;

    /* renamed from: r  reason: collision with root package name */
    public final v9.a f6185r;

    public static final class a extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f12508a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar) {
            super(0);
            this.f12508a = cVar;
        }

        /* renamed from: b */
        public final SharedPreferences invoke() {
            return this.f12508a.f6168a.getSharedPreferences(this.f12508a.f6169b, 0);
        }
    }

    static {
        Class<c> cls = c.class;
        f6167s = new g[]{x.c(new l(cls, "isFirstInstall", "isFirstInstall()Z", 0)), x.c(new l(cls, "currentVerCode", "getCurrentVerCode()Ljava/lang/String;", 0)), x.c(new l(cls, "upgradeVerCode", "getUpgradeVerCode()Ljava/lang/String;", 0)), x.c(new l(cls, "userInfoUserName", "getUserInfoUserName()Ljava/lang/String;", 0)), x.c(new l(cls, "userInfoPwd", "getUserInfoPwd()Ljava/lang/String;", 0)), x.c(new l(cls, "portalCode", "getPortalCode()Ljava/lang/String;", 0)), x.c(new l(cls, "appLang", "getAppLang()Ljava/lang/String;", 0)), x.c(new l(cls, "lastAppModel", "getLastAppModel()Ljava/lang/String;", 0)), x.c(new l(cls, "lastUserIdentity", "getLastUserIdentity()Ljava/lang/String;", 0)), x.c(new l(cls, "lastNotNeedCalendar", "getLastNotNeedCalendar()J", 0)), x.c(new l(cls, "appImportantAd", "getAppImportantAd()Ljava/lang/String;", 0)), x.c(new l(cls, "appImportantAdLastTime", "getAppImportantAdLastTime()J", 0)), x.c(new l(cls, "appScreenAdv", "getAppScreenAdv()Ljava/lang/String;", 0)), x.c(new l(cls, "protalAUrl", "getProtalAUrl()Ljava/lang/String;", 0)), x.c(new l(cls, "protalBUrl", "getProtalBUrl()Ljava/lang/String;", 0))};
    }

    public c(Context context) {
        i.g(context, f.X);
        this.f6168a = context;
        m0 m0Var = m0.f12600a;
        this.f6171d = m0Var.a("first_install", true);
        this.f6172e = m0Var.d("current_version_code", "0");
        this.f6173f = m0Var.d("upgrade_version_code", "0");
        MemberInfo.Config config = MemberInfo.Config.INSTANCE;
        this.f6174g = m0.e(m0Var, config.getSHARED_USERNAME(), (String) null, 2, (Object) null);
        this.f6175h = m0.e(m0Var, config.getSHARED_PWD(), (String) null, 2, (Object) null);
        this.f6176i = m0Var.d("portalCode", "koocanmobile2");
        this.f6177j = m0Var.d("appLang", XML.DEFAULT_CONTENT_LANGUAGE);
        this.f6178k = m0Var.d("app_model", "");
        this.f6179l = m0Var.d("userIdentity", "");
        this.f6180m = m0Var.b("not_need_calendar", System.currentTimeMillis() - ((long) 604800000));
        this.f6181n = m0.e(m0Var, "appImportantAd", (String) null, 2, (Object) null);
        this.f6182o = m0.c(m0Var, "appImportantAdLastTime", 0, 2, (Object) null);
        this.f6183p = m0.e(m0Var, "appScreenAdv", (String) null, 2, (Object) null);
        this.f6184q = m0.e(m0Var, "protalAUrl", (String) null, 2, (Object) null);
        this.f6185r = m0.e(m0Var, "protalBUrl", (String) null, 2, (Object) null);
    }

    public final String c() {
        return (String) this.f6177j.b(this, f6167s[6]);
    }

    public final String d() {
        return (String) this.f6172e.b(this, f6167s[1]);
    }

    public final SharedPreferences e() {
        Object value = this.f6170c.getValue();
        i.f(value, "<get-preferences>(...)");
        return (SharedPreferences) value;
    }

    public final String f() {
        return (String) this.f6175h.b(this, f6167s[4]);
    }

    public final String g() {
        return (String) this.f6174g.b(this, f6167s[3]);
    }

    public final boolean h() {
        return ((Boolean) this.f6171d.b(this, f6167s[0])).booleanValue();
    }

    public final void i(String str) {
        i.g(str, "<set-?>");
        this.f6181n.a(this, f6167s[10], str);
    }

    public final void j(long j10) {
        this.f6182o.a(this, f6167s[11], Long.valueOf(j10));
    }

    public final void k(String str) {
        i.g(str, "<set-?>");
        this.f6177j.a(this, f6167s[6], str);
    }

    public final void l(String str) {
        i.g(str, "<set-?>");
        this.f6183p.a(this, f6167s[12], str);
    }

    public final void m(String str) {
        i.g(str, "<set-?>");
        this.f6172e.a(this, f6167s[1], str);
    }

    public final void n(boolean z10) {
        this.f6171d.a(this, f6167s[0], Boolean.valueOf(z10));
    }

    public final void o(long j10) {
        this.f6180m.a(this, f6167s[9], Long.valueOf(j10));
    }

    public final void p(String str) {
        i.g(str, "<set-?>");
        this.f6173f.a(this, f6167s[2], str);
    }

    public final void q(String str) {
        i.g(str, "<set-?>");
        this.f6175h.a(this, f6167s[4], str);
    }

    public final void r(String str) {
        i.g(str, "<set-?>");
        this.f6174g.a(this, f6167s[3], str);
    }
}
