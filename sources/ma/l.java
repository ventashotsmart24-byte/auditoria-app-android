package ma;

import android.util.SparseArray;

public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public static final StringBuilder f7913a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    public static final SparseArray f7914b = new SparseArray();

    /* renamed from: c  reason: collision with root package name */
    public static final StringBuilder f7915c = new StringBuilder();

    public static void a(String str) {
        StringBuilder sb = f7915c;
        if (sb.length() > 0) {
            sb.append("_");
        }
        sb.append(str);
    }

    public static String b() {
        return f7915c.toString();
    }

    public static void c() {
        StringBuilder sb = f7915c;
        if (sb.length() > 0) {
            sb.delete(0, sb.length());
        }
    }
}
