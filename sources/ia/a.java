package ia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.Converter;
import retrofit2.Retrofit;
import v7.b;

public final class a extends Converter.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final Gson f17415a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f17416b;

    /* renamed from: c  reason: collision with root package name */
    public final String f17417c;

    public a(Gson gson, boolean z10, String str) {
        if (gson != null) {
            this.f17415a = gson;
            this.f17416b = z10;
            this.f17417c = str;
            return;
        }
        throw new NullPointerException("gson == null");
    }

    public static a a(Gson gson, boolean z10, String str) {
        return new a(gson, z10, str);
    }

    public static a b(boolean z10) {
        return a(new GsonBuilder().disableHtmlEscaping().create(), z10, b.f9475a);
    }

    public Converter requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new c(this.f17415a, this.f17415a.getAdapter(TypeToken.get(type)));
    }

    public Converter responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        TypeAdapter<?> adapter = this.f17415a.getAdapter(TypeToken.get(type));
        if (this.f17416b) {
            return new d(this.f17415a, adapter, type, this.f17417c, annotationArr);
        }
        return new b(this.f17415a, adapter, type, this.f17417c, annotationArr);
    }
}
