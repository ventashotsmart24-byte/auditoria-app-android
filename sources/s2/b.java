package s2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static Gson f9315a;

    public static Gson a() {
        if (f9315a == null) {
            synchronized (b.class) {
                if (f9315a == null) {
                    f9315a = new GsonBuilder().disableHtmlEscaping().create();
                }
            }
        }
        return f9315a;
    }
}
