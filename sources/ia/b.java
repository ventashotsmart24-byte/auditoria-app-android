package ia;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import ma.i;
import mobile.com.requestframe.utils.bean.EncryptJsonBean;
import okhttp3.ResponseBody;
import retrofit2.Converter;

public final class b implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final String f17418a = b.class.getName();

    /* renamed from: b  reason: collision with root package name */
    public final Gson f17419b;

    /* renamed from: c  reason: collision with root package name */
    public final TypeAdapter f17420c;

    /* renamed from: d  reason: collision with root package name */
    public final Type f17421d;

    /* renamed from: e  reason: collision with root package name */
    public final String f17422e;

    public b(Gson gson, TypeAdapter typeAdapter, Type type, String str, Annotation[] annotationArr) {
        this.f17419b = gson;
        this.f17420c = typeAdapter;
        this.f17421d = type;
        this.f17422e = b(annotationArr, str);
    }

    /* renamed from: a */
    public Object convert(ResponseBody responseBody) {
        String string = responseBody.string();
        try {
            if (i.h()) {
                EncryptJsonBean encryptJsonBean = (EncryptJsonBean) this.f17419b.fromJson(string, EncryptJsonBean.class);
                String a10 = i.a(encryptJsonBean.getData(), this.f17422e);
                return this.f17419b.fromJson(string.replace("\"" + encryptJsonBean.getData() + "\"", a10), this.f17421d);
            }
            Object fromJson = this.f17419b.fromJson(string, this.f17421d);
            responseBody.close();
            return fromJson;
        } finally {
            responseBody.close();
        }
    }

    public final String b(Annotation[] annotationArr, String str) {
        if (annotationArr != null && annotationArr.length > 0) {
            for (Annotation annotation : annotationArr) {
                String annotation2 = annotation.toString();
                if (annotation2.contains("responseKey:")) {
                    return annotation2.substring(annotation2.indexOf("responseKey:") + 12).replace("])", "");
                }
            }
        }
        return str;
    }
}
