package g8;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import t9.i;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f17282a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static Gson f17283b;

    public final Object a(String str, Class cls) {
        i.g(str, "json");
        i.g(cls, "classOfT");
        try {
            return b().fromJson(str, cls);
        } catch (JsonSyntaxException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public final Gson b() {
        if (f17283b == null) {
            f17283b = new GsonBuilder().disableHtmlEscaping().create();
        }
        Gson gson = f17283b;
        i.d(gson);
        return gson;
    }

    public final String c(Object obj) {
        i.g(obj, "jsonObject");
        try {
            String json = b().toJson(obj);
            i.f(json, "getGson().toJson(jsonObject)");
            return json;
        } catch (JsonIOException e10) {
            e10.printStackTrace();
            return "";
        }
    }
}
