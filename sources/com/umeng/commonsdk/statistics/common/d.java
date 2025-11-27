package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f14913a;

    /* renamed from: b  reason: collision with root package name */
    private static Context f14914b;

    /* renamed from: c  reason: collision with root package name */
    private static String f14915c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f14916d = bd.b().b(bd.f13853m);

    public d(Context context) {
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            f14914b = context.getApplicationContext();
            f14915c = context.getPackageName();
            if (f14913a == null) {
                f14913a = new d(context);
            }
            dVar = f14913a;
        }
        return dVar;
    }

    private SharedPreferences f() {
        Context context = f14914b;
        return context.getSharedPreferences(f14916d + f14915c, 0);
    }

    public String b() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f14914b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", (String) null);
        }
        return null;
    }

    public boolean c() {
        if (UMFrUtils.envelopeFileNumber(f14914b) > 0) {
            return true;
        }
        return false;
    }

    public String[] d() {
        try {
            SharedPreferences f10 = f();
            String string = f10.getString("au_p", (String) null);
            String string2 = f10.getString("au_u", (String) null);
            if (string == null || string2 == null) {
                return null;
            }
            return new String[]{string, string2};
        } catch (Exception unused) {
            return null;
        }
    }

    public void e() {
        f().edit().remove("au_p").remove("au_u").commit();
    }

    public void a(int i10) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f14914b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i10).commit();
        }
    }

    public int a() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f14914b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f14914b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            SharedPreferences.Editor edit = f().edit();
            edit.putString("au_p", str);
            edit.putString("au_u", str2);
            edit.commit();
        }
    }
}
