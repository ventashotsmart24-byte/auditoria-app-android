package ma;

import v7.b;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f19001a = true;

    public static String a(String str, String str2) {
        return b(str, str2);
    }

    public static String b(String str, String str2) {
        if (!f19001a) {
            return str;
        }
        if (str == null) {
            return "";
        }
        try {
            return b.a(str, str2);
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String c(String str) {
        return b(str, b.f9476b);
    }

    public static String d(String str) {
        return f(str, b.f9475a);
    }

    public static String e(String str, String str2) {
        return f(str, str2);
    }

    public static String f(String str, String str2) {
        if (!f19001a) {
            return str;
        }
        if (str == null) {
            return "";
        }
        try {
            return b.b(str, str2);
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String g(String str) {
        return f(str, b.f9476b);
    }

    public static boolean h() {
        return f19001a;
    }
}
