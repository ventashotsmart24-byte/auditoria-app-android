package s5;

import com.mobile.brasiltv.db.SwitchAccountBean;
import t9.i;
import x7.a;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f19464a = new e();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f19465b;

    /* renamed from: c  reason: collision with root package name */
    public static c f19466c;

    /* renamed from: d  reason: collision with root package name */
    public static String f19467d = "";

    /* renamed from: e  reason: collision with root package name */
    public static SwitchAccountBean f19468e;

    /* renamed from: f  reason: collision with root package name */
    public static String f19469f;

    /* renamed from: g  reason: collision with root package name */
    public static String f19470g = "";

    /* renamed from: h  reason: collision with root package name */
    public static a f19471h;

    /* renamed from: i  reason: collision with root package name */
    public static String f19472i = "";

    /* renamed from: j  reason: collision with root package name */
    public static String f19473j = "";

    /* renamed from: k  reason: collision with root package name */
    public static String f19474k;

    public final void a() {
        f19465b = false;
        f19466c = null;
        f19467d = "";
        f19468e = null;
        f19469f = null;
        f19470g = "";
        f19471h = null;
        f19472i = "";
        f19473j = "";
        f19474k = null;
    }

    public final String b() {
        return f19472i;
    }

    public final c c() {
        return f19466c;
    }

    public final boolean d() {
        return f19465b;
    }

    public final String e() {
        return f19467d;
    }

    public final a f() {
        return f19471h;
    }

    public final SwitchAccountBean g() {
        return f19468e;
    }

    public final String h() {
        return f19470g;
    }

    public final String i() {
        return f19474k;
    }

    public final String j() {
        return f19473j;
    }

    public final String k() {
        return f19469f;
    }

    public final d l() {
        return new d(f19465b, f19466c, f19467d, f19468e, f19469f, f19470g, f19471h, f19472i, f19473j, f19474k);
    }

    public final void m(d dVar) {
        i.g(dVar, "tmpLoginBean");
        f19465b = dVar.c();
        f19466c = dVar.b();
        f19467d = dVar.d();
        f19468e = dVar.f();
        f19469f = dVar.j();
        f19470g = dVar.g();
        f19471h = dVar.e();
        f19472i = dVar.a();
        f19473j = dVar.i();
        f19474k = dVar.h();
    }

    public final void n(c cVar, SwitchAccountBean switchAccountBean, String str) {
        i.g(cVar, "loginType");
        i.g(switchAccountBean, "switchAccountBean");
        f19466c = cVar;
        f19468e = switchAccountBean;
        f19469f = str;
    }

    public final void o(c cVar, String str, a aVar, String str2, String str3, String str4) {
        i.g(cVar, "loginType");
        i.g(str, "thirdPartType");
        i.g(aVar, "socialInfo");
        i.g(str2, "createType");
        i.g(str3, "tpSource");
        f19466c = cVar;
        f19470g = str;
        f19471h = aVar;
        f19472i = str2;
        f19473j = str3;
        f19474k = str4;
    }
}
