package kotlinx.coroutines.internal;

public abstract /* synthetic */ class a0 {

    /* renamed from: a  reason: collision with root package name */
    public static final int f18247a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f18247a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
