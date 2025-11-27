package j3;

import java.util.concurrent.ConcurrentHashMap;

public final class g extends ConcurrentHashMap {

    /* renamed from: b  reason: collision with root package name */
    public static final g f7164b = new g();

    /* renamed from: a  reason: collision with root package name */
    public final Object f7165a = new Object();

    public g() {
        super(180, 0.8f, 4);
    }

    public String a(String str) {
        String str2 = (String) get(str);
        if (str2 != null) {
            return str2;
        }
        if (size() >= 180) {
            synchronized (this.f7165a) {
                if (size() >= 180) {
                    clear();
                }
            }
        }
        String intern = str.intern();
        put(intern, intern);
        return intern;
    }
}
