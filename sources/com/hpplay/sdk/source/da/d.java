package com.hpplay.sdk.source.da;

import android.text.TextUtils;
import com.hpplay.sdk.source.common.store.Preference;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f11780a = "key_se_app_sw";

    /* renamed from: b  reason: collision with root package name */
    public static final String f11781b = "key_re_app_list";

    /* renamed from: c  reason: collision with root package name */
    public static final String f11782c = "key_dlna_sw";

    /* renamed from: d  reason: collision with root package name */
    private static final String f11783d = "DaProcessor";

    public static void a(int i10) {
        Preference.getInstance().put(f11780a, i10);
    }

    public static void b(int i10) {
        Preference.getInstance().put(f11782c, i10);
    }

    public static int c() {
        return Preference.getInstance().get(f11782c, 0);
    }

    public static void a(String str) {
        Preference.getInstance().put(f11781b, str);
    }

    public static String[] b() {
        String str = Preference.getInstance().get(f11781b, (String) null);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(",");
    }

    public static int a() {
        return Preference.getInstance().get(f11780a, 0);
    }
}
