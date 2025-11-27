package p1;

import android.content.SharedPreferences;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f8801a;

    public static void a(String str) {
        SharedPreferences sharedPreferences;
        if (str != null && (sharedPreferences = f8801a) != null) {
            sharedPreferences.edit().putString("networksdk_target_cookie_name", str).apply();
        }
    }
}
