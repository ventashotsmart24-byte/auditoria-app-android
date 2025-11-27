package w6;

import android.text.TextUtils;
import ba.t;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.i1;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import t9.g;
import t9.i;

public final class l implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public static final a f19757a = new a((g) null);

    /* renamed from: b  reason: collision with root package name */
    public static final int f19758b = 4;

    /* renamed from: c  reason: collision with root package name */
    public static final int f19759c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f19760d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static int f19761e;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final int a() {
            return l.f19760d;
        }

        public final int b() {
            return l.f19759c;
        }

        public final int c() {
            return l.f19758b;
        }

        public final int d() {
            return l.f19761e;
        }

        public final void e(int i10) {
            l.f19761e = i10;
        }
    }

    public final String f(Request request) {
        i.g(request, "request");
        RequestBody body = request.body();
        Charset forName = Charset.forName("UTF-8");
        StringBuilder sb = new StringBuilder();
        i.d(body);
        MediaType contentType = body.contentType();
        if (contentType != null) {
            forName = contentType.charset(Charset.forName("UTF-8"));
        }
        Buffer buffer = new Buffer();
        try {
            body.writeTo(buffer);
        } catch (IOException e10) {
            e10.printStackTrace();
        }
        sb.append(buffer.readString(forName));
        buffer.close();
        String sb2 = sb.toString();
        i.f(sb2, "sb.toString()");
        return sb2;
    }

    public Response intercept(Interceptor.Chain chain) {
        JsonObject jsonObject;
        String str;
        MediaType contentType;
        String mediaType;
        i.g(chain, "chain");
        Request request = chain.request();
        if (TextUtils.equals(request.method(), "POST")) {
            RequestBody body = request.body();
            boolean z10 = false;
            String str2 = null;
            if (!(body == null || (contentType = body.contentType()) == null || (mediaType = contentType.toString()) == null)) {
                z10 = t.o(mediaType, "application/json;", false, 2, (Object) null);
            }
            if (z10) {
                RequestBody body2 = request.body();
                i.d(body2);
                if (body2.contentLength() <= 0) {
                    jsonObject = new JsonObject();
                } else {
                    JsonParser jsonParser = new JsonParser();
                    i.f(request, "request");
                    jsonObject = jsonParser.parse(f(request)).getAsJsonObject();
                    i.f(jsonObject, "JsonParser().parse(key(request)).getAsJsonObject()");
                }
                try {
                    JsonElement jsonElement = jsonObject.get("userToken");
                    if (jsonElement != null) {
                        str = jsonElement.getAsString();
                    } else {
                        str = null;
                    }
                    String str3 = "";
                    if (str == null) {
                        str = str3;
                    }
                    JsonElement jsonElement2 = jsonObject.get("userId");
                    if (jsonElement2 != null) {
                        str2 = jsonElement2.getAsString();
                    }
                    if (str2 != null) {
                        str3 = str2;
                    }
                    if (b0.J(str) || b0.J(str3)) {
                        i1.r(App.f6050e.a().getApplicationContext(), request.url().url().getPath(), f19761e, b0.J(str), b0.J(str3));
                    }
                } catch (Exception unused) {
                }
                Response proceed = chain.proceed(request);
                i.f(proceed, "chain.proceed(request)");
                return proceed;
            }
        }
        Response proceed2 = chain.proceed(request);
        i.f(proceed2, "chain.proceed(request)");
        return proceed2;
    }
}
