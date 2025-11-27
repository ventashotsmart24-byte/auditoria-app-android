package y8;

import java.util.List;

public abstract class z {

    /* renamed from: a  reason: collision with root package name */
    public static List f20247a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f20248b;

    public static synchronized List a() {
        List list;
        synchronized (z.class) {
            f20248b = true;
            list = f20247a;
        }
        return list;
    }
}
