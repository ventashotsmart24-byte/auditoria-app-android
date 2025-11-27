package com.mobile.brasiltv.utils;

import android.os.SystemClock;
import c2.e;
import java.util.HashMap;
import t9.i;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f12516a = new f();

    public final void a(String str, String str2, int i10) {
        i.g(str, "searchWords");
        i.g(str2, "title");
        HashMap hashMap = new HashMap();
        hashMap.put("title", str2);
        hashMap.put("searchWords", str);
        hashMap.put("position", Integer.valueOf(i10));
        e.f4622a.a("app_search_result_click", hashMap, SystemClock.elapsedRealtime(), 0, false, true);
    }

    public final void b() {
        e.b(e.f4622a, "app_coupon_click", new HashMap(), SystemClock.elapsedRealtime(), 0, false, false, 48, (Object) null);
    }

    public final void c() {
        e.b(e.f4622a, "app_game_ad", new HashMap(), SystemClock.elapsedRealtime(), 0, false, false, 48, (Object) null);
    }
}
