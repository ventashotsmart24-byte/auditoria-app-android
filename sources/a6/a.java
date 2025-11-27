package a6;

import android.content.Context;
import ba.t;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.r0;
import com.umeng.analytics.pro.f;
import w6.i;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f10646a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final String f10647b = "pause_popup";

    /* renamed from: c  reason: collision with root package name */
    public static final String f10648c = "pause_popup_on_admob";

    /* renamed from: d  reason: collision with root package name */
    public static final String f10649d = "pause_popup_on_admob_portrait";

    /* renamed from: e  reason: collision with root package name */
    public static final String f10650e = "apk_booting";

    /* renamed from: f  reason: collision with root package name */
    public static final String f10651f = "app_screen";

    /* renamed from: g  reason: collision with root package name */
    public static final String f10652g = "movie_first_banner";

    /* renamed from: h  reason: collision with root package name */
    public static final String f10653h = "home_bl_on_admob_1";

    /* renamed from: i  reason: collision with root package name */
    public static final String f10654i = "vod_detail_on_admob";

    /* renamed from: j  reason: collision with root package name */
    public static final String f10655j = "home_page_ad";

    /* renamed from: k  reason: collision with root package name */
    public static final String f10656k = "home_page_ad_1";

    /* renamed from: l  reason: collision with root package name */
    public static final String f10657l = "tv_series_ad";

    /* renamed from: m  reason: collision with root package name */
    public static final String f10658m = "tv_kids_ad_1";

    /* renamed from: n  reason: collision with root package name */
    public static final String f10659n = "tv_anime_ad_1";

    /* renamed from: o  reason: collision with root package name */
    public static final String f10660o = "free_movie_list_on_admob";

    /* renamed from: p  reason: collision with root package name */
    public static final String f10661p = "ad_cast_mode";

    /* renamed from: q  reason: collision with root package name */
    public static final String f10662q = "home_ad_carousel";

    /* renamed from: r  reason: collision with root package name */
    public static final String f10663r = "movie_ad_carousel";

    /* renamed from: s  reason: collision with root package name */
    public static final String f10664s = "free_game_ad";

    /* renamed from: t  reason: collision with root package name */
    public static final String f10665t = "player_loading";

    public static /* synthetic */ void u(a aVar, Context context, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        aVar.t(context, str, z10);
    }

    public final String a() {
        return f10661p;
    }

    public final String b() {
        return f10650e;
    }

    public final String c() {
        return f10652g;
    }

    public final String d() {
        return f10651f;
    }

    public final String e() {
        return f10664s;
    }

    public final String f() {
        return f10660o;
    }

    public final String g() {
        return f10653h;
    }

    public final String h() {
        return f10662q;
    }

    public final String i() {
        return f10655j;
    }

    public final String j() {
        return f10656k;
    }

    public final String k() {
        return f10647b;
    }

    public final String l() {
        return f10648c;
    }

    public final String m() {
        return f10649d;
    }

    public final String n() {
        return f10665t;
    }

    public final String o() {
        return f10659n;
    }

    public final String p() {
        return f10658m;
    }

    public final String q() {
        return f10657l;
    }

    public final String r() {
        return f10654i;
    }

    public final boolean s() {
        i.c cVar = i.f9510g;
        if (t9.i.b(cVar.e(), "0") || !t9.i.b(cVar.I(), "4")) {
            return true;
        }
        return false;
    }

    public final void t(Context context, String str, boolean z10) {
        boolean z11;
        t9.i.g(context, f.X);
        String b10 = r0.f12611a.b(str, z10);
        if (b10 == null || b10.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return;
        }
        if (t.o(b10, "play.google.com", false, 2, (Object) null)) {
            b0.g0(context, b10);
        } else {
            b0.j0(context, b10, false, true, false, false, 24, (Object) null);
        }
    }
}
