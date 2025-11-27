package a3;

import android.content.SharedPreferences;
import t2.a;
import t9.i;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f165a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f166b;

    /* renamed from: c  reason: collision with root package name */
    public static SharedPreferences f167c;

    static {
        g gVar = new g();
        f165a = gVar;
        f166b = gVar.getClass().getSimpleName();
    }

    public final String a(String str) {
        String str2;
        i.g(str, "key");
        if (f167c == null) {
            f167c = a.f9350a.a().getSharedPreferences("log", 0);
        }
        SharedPreferences sharedPreferences = f167c;
        if (sharedPreferences != null) {
            str2 = sharedPreferences.getString(str, "");
        } else {
            str2 = null;
        }
        String a10 = a.a(str2);
        i.f(a10, "decrypt(sp?.getString(key, \"\"))");
        return a10;
    }

    public final void b(String str, String str2) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        i.g(str, "key");
        i.g(str2, "value");
        if (f167c == null) {
            f167c = a.f9350a.a().getSharedPreferences("log", 0);
        }
        SharedPreferences sharedPreferences = f167c;
        if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null && (putString = edit.putString(str, str2)) != null) {
            putString.apply();
        }
    }

    public final void c(String str, String str2) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        i.g(str, "key");
        i.g(str2, "value");
        if (f167c == null) {
            f167c = a.f9350a.a().getSharedPreferences("log", 0);
        }
        SharedPreferences sharedPreferences = f167c;
        if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null && (putString = edit.putString(str, a.c(str2))) != null) {
            putString.apply();
        }
    }
}
