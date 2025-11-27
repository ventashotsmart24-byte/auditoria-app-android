package com.mobile.brasiltv.utils;

import com.hpplay.sdk.source.api.LelinkPlayerInfo;
import com.hpplay.sdk.source.api.LelinkSourceSDK;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import t9.i;

public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    public static final g0 f12538a = new g0();

    /* renamed from: b  reason: collision with root package name */
    public static ArrayList f12539b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static LelinkServiceInfo f12540c;

    /* renamed from: d  reason: collision with root package name */
    public static Disposable f12541d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f12542e = 1001;

    /* renamed from: f  reason: collision with root package name */
    public static a f12543f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f12544g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f12545h;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f12546i;

    /* renamed from: j  reason: collision with root package name */
    public static long f12547j = -1;

    /* renamed from: k  reason: collision with root package name */
    public static String f12548k = "";

    /* renamed from: l  reason: collision with root package name */
    public static String f12549l = "";

    /* renamed from: m  reason: collision with root package name */
    public static final String f12550m = "http://www.oi1lgew.com/dl/1";

    /* renamed from: n  reason: collision with root package name */
    public static final String f12551n = "http://www.oi1lgew.com/dl/2";

    /* renamed from: o  reason: collision with root package name */
    public static final String f12552o = "http://www.oi1lgew.com/dl/1080p_short.ts";

    /* renamed from: p  reason: collision with root package name */
    public static boolean f12553p;

    /* renamed from: q  reason: collision with root package name */
    public static String f12554q = "";

    /* renamed from: r  reason: collision with root package name */
    public static String f12555r = "";

    /* renamed from: s  reason: collision with root package name */
    public static String f12556s = "";

    /* renamed from: t  reason: collision with root package name */
    public static String f12557t = "";

    /* renamed from: u  reason: collision with root package name */
    public static String f12558u = "";

    /* renamed from: v  reason: collision with root package name */
    public static String f12559v = "";

    /* renamed from: w  reason: collision with root package name */
    public static String f12560w = "";

    public interface a {
    }

    public final void a() {
        LelinkSourceSDK.getInstance().addVolume();
    }

    public final void b() {
        n();
        j((a) null);
        Disposable disposable = f12541d;
        if (disposable != null) {
            disposable.dispose();
        }
        p();
    }

    public final LelinkServiceInfo c() {
        return f12540c;
    }

    public final boolean d() {
        return f12546i;
    }

    public final boolean e() {
        return f12545h;
    }

    public final boolean f() {
        return f12544g;
    }

    public final void g() {
        f12544g = false;
        LelinkSourceSDK.getInstance().pause();
    }

    public final void h() {
        f12545h = false;
        LelinkSourceSDK.getInstance().resume();
    }

    public final void i(int i10) {
        LelinkSourceSDK.getInstance().seekTo(i10);
    }

    public final void j(a aVar) {
        f12543f = aVar;
    }

    public final void k(String str) {
        i.g(str, "<set-?>");
        f12549l = str;
    }

    public final void l(boolean z10) {
        f12553p = z10;
    }

    public final void m(int i10) {
        String str;
        if (f12540c != null) {
            if (i10 == 0) {
                str = f12552o;
            } else if (i10 == 1) {
                str = f12551n;
            } else if (i10 != 2) {
                str = f12550m;
            } else {
                str = f12550m;
            }
            f12554q = "Experience";
            f12546i = false;
            LelinkPlayerInfo lelinkPlayerInfo = new LelinkPlayerInfo();
            lelinkPlayerInfo.setLelinkServiceInfo(f12540c);
            lelinkPlayerInfo.setType(102);
            lelinkPlayerInfo.setUrl(str);
            LelinkSourceSDK.getInstance().startPlayMedia(lelinkPlayerInfo);
        }
    }

    public final void n() {
        LelinkSourceSDK.getInstance().stopPlay();
        f12548k = "";
    }

    public final void o() {
        LelinkSourceSDK.getInstance().subVolume();
    }

    public final void p() {
        LelinkSourceSDK.getInstance().unBindSdk();
    }
}
