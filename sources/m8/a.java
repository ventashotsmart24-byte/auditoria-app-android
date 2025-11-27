package m8;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static Gson f18977a;

    public static Gson a() {
        if (f18977a == null) {
            synchronized (a.class) {
                if (f18977a == null) {
                    f18977a = new GsonBuilder().disableHtmlEscaping().create();
                }
            }
        }
        return f18977a;
    }
}
