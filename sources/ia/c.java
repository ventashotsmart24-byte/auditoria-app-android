package ia;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

public final class c implements Converter {

    /* renamed from: c  reason: collision with root package name */
    public static final MediaType f17423c = MediaType.parse("application/json; charset=UTF-8");

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f17424d = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    public final Gson f17425a;

    /* renamed from: b  reason: collision with root package name */
    public final TypeAdapter f17426b;

    public c(Gson gson, TypeAdapter typeAdapter) {
        this.f17425a = gson;
        this.f17426b = typeAdapter;
    }

    /* renamed from: a */
    public RequestBody convert(Object obj) {
        return RequestBody.create(f17423c, String.valueOf(obj));
    }
}
