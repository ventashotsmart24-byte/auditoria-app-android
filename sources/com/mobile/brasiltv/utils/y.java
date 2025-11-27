package com.mobile.brasiltv.utils;

import android.content.Context;
import android.text.TextUtils;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import na.d;
import na.e;
import t9.i;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public static final y f12639a = new y();

    /* renamed from: b  reason: collision with root package name */
    public static final String f12640b = "TIME_OUT";

    /* renamed from: c  reason: collision with root package name */
    public static final String f12641c = "NET_ERROR";

    /* renamed from: d  reason: collision with root package name */
    public static final String f12642d = "live";

    /* renamed from: e  reason: collision with root package name */
    public static final String f12643e = "vod";

    /* renamed from: f  reason: collision with root package name */
    public static final String f12644f = "record";

    /* renamed from: g  reason: collision with root package name */
    public static final String f12645g = "/api/portalCore/v3/snToken";

    /* renamed from: h  reason: collision with root package name */
    public static final String f12646h = "/api/portalCore/v6/active";

    /* renamed from: i  reason: collision with root package name */
    public static final String f12647i = "/api/portalCore/v6/login";

    /* renamed from: j  reason: collision with root package name */
    public static final String f12648j = "/api/portalCore/v5/login/thirdpart";

    /* renamed from: k  reason: collision with root package name */
    public static final String f12649k = "/api/portalCore/v3/getColumnContents";

    /* renamed from: l  reason: collision with root package name */
    public static final String f12650l = "/api/v2/dcs/getAddr";

    /* renamed from: m  reason: collision with root package name */
    public static final String f12651m = "/api/portalCore/v9/startPlayVOD";

    /* renamed from: n  reason: collision with root package name */
    public static final String f12652n = "/api/portalCore/v13_1/getSlbInfo";

    /* renamed from: o  reason: collision with root package name */
    public static final String f12653o = "/api/portalCore/v5/getLiveData";

    /* renamed from: p  reason: collision with root package name */
    public static final String f12654p = "/api/portalCore/getHome";

    /* renamed from: q  reason: collision with root package name */
    public static final String f12655q = "/api/portalCore/v3/getShelveData";

    /* renamed from: r  reason: collision with root package name */
    public static final String f12656r = "/api/portalCore/v3/getRecommends";

    public static /* synthetic */ String p(y yVar, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        if ((i10 & 4) != 0) {
            str3 = "";
        }
        return yVar.o(str, str2, str3);
    }

    public final String a() {
        return f12646h;
    }

    public final String b() {
        return f12649k;
    }

    public final String c(String str) {
        i.g(str, "returnCode");
        String b10 = d.b(str);
        if (i.b(b10, "no_report_type")) {
            b10 = d.c(str);
        }
        if (i.b(b10, "no_report_type")) {
            b10 = d.d(str);
        }
        if (i.b(b10, "no_report_type")) {
            b10 = d.e(str);
        }
        if (i.b(b10, "no_report_type")) {
            b10 = d.f(str);
        }
        if (i.b(b10, "no_report_type")) {
            b10 = d.g(str);
        }
        i.f(b10, "errCode");
        return b10;
    }

    public final String d(String str) {
        i.g(str, "errorCode");
        Context a10 = a.a();
        int hashCode = str.hashCode();
        switch (hashCode) {
            case -396103086:
                if (str.equals("portal100029")) {
                    return "portal100029-" + a10.getResources().getString(R.string.not_associated);
                }
                break;
            case 68467:
                if (str.equals("ED2")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ED2-");
                    x xVar = x.f12622a;
                    i.f(a10, f.X);
                    sb.append(xVar.y(a10, R.string.ed2));
                    return sb.toString();
                }
                break;
            case 68498:
                if (str.equals("EE2")) {
                    return "EE2-" + a10.getResources().getString(R.string.ee2);
                }
                break;
            case 2119612:
                if (str.equals("EA11")) {
                    return "EA11-" + a10.getResources().getString(R.string.ea11);
                }
                break;
            case 2119618:
                if (str.equals("EA17")) {
                    return "EA17-" + a10.getResources().getString(R.string.ea17);
                }
                break;
            default:
                switch (hashCode) {
                    case 68373:
                        if (str.equals("EA1")) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("EA1-");
                            x xVar2 = x.f12622a;
                            i.f(a10, f.X);
                            sb2.append(xVar2.y(a10, R.string.login_failed));
                            return sb2.toString();
                        }
                        break;
                    case 68374:
                        if (str.equals("EA2")) {
                            return "EA2-" + a10.getResources().getString(R.string.ea2);
                        }
                        break;
                    case 68375:
                        if (str.equals("EA3")) {
                            return "EA3-" + a10.getResources().getString(R.string.not_use_area);
                        }
                        break;
                    case 68376:
                        if (str.equals("EA4")) {
                            return "EA4-" + a10.getResources().getString(R.string.not_use_area);
                        }
                        break;
                    case 68377:
                        if (str.equals("EA5")) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("EA5-");
                            x xVar3 = x.f12622a;
                            i.f(a10, f.X);
                            sb3.append(xVar3.y(a10, R.string.login_failed));
                            return sb3.toString();
                        }
                        break;
                    case 68378:
                        if (str.equals("EA6")) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("EA6-");
                            x xVar4 = x.f12622a;
                            i.f(a10, f.X);
                            sb4.append(xVar4.y(a10, R.string.system_error));
                            return sb4.toString();
                        }
                        break;
                    case 68379:
                        if (str.equals("EA7")) {
                            return "EA7-" + a10.getResources().getString(R.string.bad_network);
                        }
                        break;
                    case 68380:
                        if (str.equals("EA8")) {
                            return "EA8-" + a10.getResources().getString(R.string.no_mac);
                        }
                        break;
                    case 68381:
                        if (str.equals("EA9")) {
                            return "EA9-" + a10.getResources().getString(R.string.bad_network);
                        }
                        break;
                    default:
                        switch (hashCode) {
                            case 68404:
                                if (str.equals("EB1")) {
                                    return "EB1-" + a10.getResources().getString(R.string.eb1);
                                }
                                break;
                            case 68405:
                                if (str.equals("EB2")) {
                                    return "EB2-" + a10.getResources().getString(R.string.no_program_list);
                                }
                                break;
                            case 68406:
                                if (str.equals("EB3")) {
                                    return "EB3-" + a10.getResources().getString(R.string.no_program_list);
                                }
                                break;
                            default:
                                switch (hashCode) {
                                    case 68435:
                                        if (str.equals("EC1")) {
                                            return "EC1-" + a10.getResources().getString(R.string.failed_play_exit_retry);
                                        }
                                        break;
                                    case 68436:
                                        if (str.equals("EC2")) {
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append("EC2-");
                                            x xVar5 = x.f12622a;
                                            i.f(a10, f.X);
                                            sb5.append(xVar5.y(a10, R.string.failed_ec5));
                                            return sb5.toString();
                                        }
                                        break;
                                    case 68437:
                                        if (str.equals("EC3")) {
                                            return "EC3-" + a10.getResources().getString(R.string.failed_play_exit_retry);
                                        }
                                        break;
                                    case 68438:
                                        if (str.equals("EC4")) {
                                            x xVar6 = x.f12622a;
                                            i.f(a10, f.X);
                                            xVar6.y(a10, R.string.failed_ec5);
                                            break;
                                        }
                                        break;
                                    case 68439:
                                        if (str.equals("EC5")) {
                                            StringBuilder sb6 = new StringBuilder();
                                            sb6.append("EC5-");
                                            x xVar7 = x.f12622a;
                                            i.f(a10, f.X);
                                            sb6.append(xVar7.y(a10, R.string.failed_ec5));
                                            return sb6.toString();
                                        }
                                        break;
                                    default:
                                        switch (hashCode) {
                                            case 68528:
                                                if (str.equals("EF1")) {
                                                    String string = a10.getResources().getString(R.string.ef1);
                                                    i.f(string, "context.resources.getString(R.string.ef1)");
                                                    return string;
                                                }
                                                break;
                                            case 68529:
                                                if (str.equals("EF2")) {
                                                    String string2 = a10.getResources().getString(R.string.ef2);
                                                    i.f(string2, "context.resources.getString(R.string.ef2)");
                                                    return string2;
                                                }
                                                break;
                                            case 68530:
                                                if (str.equals("EF3")) {
                                                    String string3 = a10.getResources().getString(R.string.ef3);
                                                    i.f(string3, "context.resources.getString(R.string.ef3)");
                                                    return string3;
                                                }
                                                break;
                                            case 68531:
                                                if (str.equals("EF4")) {
                                                    String string4 = a10.getResources().getString(R.string.ef4);
                                                    i.f(string4, "context.resources.getString(R.string.ef4)");
                                                    return string4;
                                                }
                                                break;
                                            case 68532:
                                                if (str.equals("EF5")) {
                                                    String string5 = a10.getResources().getString(R.string.ef5);
                                                    i.f(string5, "context.resources.getString(R.string.ef5)");
                                                    return string5;
                                                }
                                                break;
                                            case 68533:
                                                if (str.equals("EF6")) {
                                                    String string6 = a10.getResources().getString(R.string.ef6);
                                                    i.f(string6, "context.resources.getString(R.string.ef6)");
                                                    return string6;
                                                }
                                                break;
                                            case 68534:
                                                if (str.equals("EF7")) {
                                                    String string7 = a10.getResources().getString(R.string.ef7);
                                                    i.f(string7, "context.resources.getString(R.string.ef7)");
                                                    return string7;
                                                }
                                                break;
                                            case 68535:
                                                if (str.equals("EF8")) {
                                                    String string8 = a10.getResources().getString(R.string.ef8);
                                                    i.f(string8, "context.resources.getString(R.string.ef8)");
                                                    return string8;
                                                }
                                                break;
                                            case 68536:
                                                if (str.equals("EF9")) {
                                                    String string9 = a10.getResources().getString(R.string.ef9);
                                                    i.f(string9, "context.resources.getString(R.string.ef9)");
                                                    return string9;
                                                }
                                                break;
                                            default:
                                                switch (hashCode) {
                                                    case 2124416:
                                                        if (str.equals("EF10")) {
                                                            String string10 = a10.getResources().getString(R.string.ef10);
                                                            i.f(string10, "context.resources.getString(R.string.ef10)");
                                                            return string10;
                                                        }
                                                        break;
                                                    case 2124417:
                                                        if (str.equals("EF11")) {
                                                            String string11 = a10.getResources().getString(R.string.pwd_wrong);
                                                            i.f(string11, "context.resources.getString(R.string.pwd_wrong)");
                                                            return string11;
                                                        }
                                                        break;
                                                    case 2124418:
                                                        if (str.equals("EF12")) {
                                                            String string12 = a10.getResources().getString(R.string.ef1);
                                                            i.f(string12, "context.resources.getString(R.string.ef1)");
                                                            return string12;
                                                        }
                                                        break;
                                                    case 2124419:
                                                        if (str.equals("EF13")) {
                                                            String string13 = a10.getResources().getString(R.string.ef13);
                                                            i.f(string13, "context.resources.getString(R.string.ef13)");
                                                            return string13;
                                                        }
                                                        break;
                                                    default:
                                                        switch (hashCode) {
                                                            case 2124422:
                                                                if (str.equals("EF16")) {
                                                                    String string14 = a10.getResources().getString(R.string.ef16);
                                                                    i.f(string14, "context.resources.getString(R.string.ef16)");
                                                                    return string14;
                                                                }
                                                                break;
                                                            case 2124423:
                                                                if (str.equals("EF17")) {
                                                                    String string15 = a10.getResources().getString(R.string.sms_limit);
                                                                    i.f(string15, "context.resources.getString(R.string.sms_limit)");
                                                                    return string15;
                                                                }
                                                                break;
                                                            case 2124424:
                                                                if (str.equals("EF18")) {
                                                                    String string16 = a10.getResources().getString(R.string.phone_been_bound);
                                                                    i.f(string16, "context.resources.getStr….string.phone_been_bound)");
                                                                    return string16;
                                                                }
                                                                break;
                                                            case 2124425:
                                                                if (str.equals("EF19")) {
                                                                    String string17 = a10.getResources().getString(R.string.verification_invalid);
                                                                    i.f(string17, "context.resources.getStr…ing.verification_invalid)");
                                                                    return string17;
                                                                }
                                                                break;
                                                            default:
                                                                switch (hashCode) {
                                                                    case 2124447:
                                                                        if (str.equals("EF20")) {
                                                                            String string18 = a10.getResources().getString(R.string.sms_send_and_retry);
                                                                            i.f(string18, "context.resources.getStr…tring.sms_send_and_retry)");
                                                                            return string18;
                                                                        }
                                                                        break;
                                                                    case 2124448:
                                                                        if (str.equals("EF21")) {
                                                                            String string19 = a10.getResources().getString(R.string.scan_qr_expired);
                                                                            i.f(string19, "context.resources.getStr…R.string.scan_qr_expired)");
                                                                            return string19;
                                                                        }
                                                                        break;
                                                                    default:
                                                                        switch (hashCode) {
                                                                            case 3103679:
                                                                                if (str.equals("ea14")) {
                                                                                    return "ea14-" + a10.getResources().getString(R.string.ea14);
                                                                                }
                                                                                break;
                                                                            case 3103680:
                                                                                if (str.equals("ea15")) {
                                                                                    return "ea15-" + a10.getResources().getString(R.string.ea15);
                                                                                }
                                                                                break;
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
        return "";
    }

    public final String e() {
        return f12654p;
    }

    public final String f() {
        return f12653o;
    }

    public final String g() {
        return f12656r;
    }

    public final String h() {
        return f12642d;
    }

    public final String i() {
        return f12647i;
    }

    public final String j() {
        return f12648j;
    }

    public final String k() {
        return f12655q;
    }

    public final String l() {
        return f12645g;
    }

    public final String m() {
        return f12651m;
    }

    public final String n() {
        return f12643e;
    }

    public final String o(String str, String str2, String str3) {
        i.g(str, "errorCode");
        i.g(str2, "uri");
        i.g(str3, "ecCode");
        String c10 = c(str);
        if (TextUtils.isEmpty(str3) || i.b(str3, "no_report_type")) {
            str3 = c10;
        }
        if (!TextUtils.isEmpty(str2)) {
            c2.d dVar = c2.d.f4594a;
            String str4 = e.f19076b;
            i.f(str4, "dcsMark");
            dVar.g("", "", str4, "", "", str3, str, str2);
        }
        return d(str3);
    }
}
