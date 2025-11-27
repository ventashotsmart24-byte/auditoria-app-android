package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f14596a;

    /* renamed from: b  reason: collision with root package name */
    private static Context f14597b;

    /* renamed from: c  reason: collision with root package name */
    private static String f14598c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f14599d = bd.b().b(bd.f13853m);

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final b f14600a = new b();

        private a() {
        }
    }

    public static synchronized b a(Context context) {
        b a10;
        synchronized (b.class) {
            if (f14597b == null && context != null) {
                f14597b = context.getApplicationContext();
            }
            if (f14597b != null) {
                f14598c = context.getPackageName();
            }
            a10 = a.f14600a;
        }
        return a10;
    }

    private SharedPreferences e() {
        Context context = f14597b;
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(f14599d + f14598c, 0);
    }

    public void b() {
        SharedPreferences e10 = e();
        if (e10 != null) {
            e10.edit().remove("au_p").remove("au_u").commit();
        }
    }

    public String c() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f14597b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", (String) null);
        }
        return null;
    }

    public int d() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f14597b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            SharedPreferences.Editor edit = e().edit();
            edit.putString("au_p", str);
            edit.putString("au_u", str2);
            edit.commit();
        }
    }

    public String[] a() {
        SharedPreferences e10 = e();
        if (e10 != null) {
            String string = e10.getString("au_p", (String) null);
            String string2 = e10.getString("au_u", (String) null);
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                return new String[]{string, string2};
            }
        }
        return null;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f14597b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void a(int i10) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f14597b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i10).commit();
        }
    }

    public static String a(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(str, 0)) == null) {
            return "";
        }
        return sharedPreferences.getString(str2, "");
    }

    public static void a(Context context, String str, String str2, String str3) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context != null && (sharedPreferences = context.getApplicationContext().getSharedPreferences(str, 0)) != null && (edit = sharedPreferences.edit()) != null) {
            edit.putString(str2, str3);
            edit.commit();
        }
    }

    public static void a(Context context, String str) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences(str, 0).edit();
        edit.remove("debugkey");
        edit.remove("period");
        edit.remove(AnalyticsConfig.RTD_START_TIME);
        edit.clear();
        edit.commit();
    }
}
