package x;

import android.os.Build;

public abstract class a {
    public static boolean a(String str, String str2) {
        if (!"REL".equals(str2) && str2.compareTo(str) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean b() {
        if (Build.VERSION.SDK_INT >= 30) {
            return true;
        }
        return false;
    }

    public static boolean c() {
        if (Build.VERSION.SDK_INT >= 31 || a("S", Build.VERSION.CODENAME)) {
            return true;
        }
        return false;
    }
}
