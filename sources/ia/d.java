package ia;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import ma.i;
import mobile.com.requestframe.utils.bean.BaseResponse;
import mobile.com.requestframe.utils.bean.EncryptJsonBean;
import mobile.com.requestframe.utils.bean.ResultException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

public final class d implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final String f17427a = "response";

    /* renamed from: b  reason: collision with root package name */
    public final Gson f17428b;

    /* renamed from: c  reason: collision with root package name */
    public final TypeAdapter f17429c;

    /* renamed from: d  reason: collision with root package name */
    public final Type f17430d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f17431e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f17432f;

    /* renamed from: g  reason: collision with root package name */
    public final String f17433g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17434h;

    public d(Gson gson, TypeAdapter typeAdapter, Type type, String str, Annotation[] annotationArr) {
        this.f17428b = gson;
        this.f17429c = typeAdapter;
        this.f17430d = type;
        this.f17431e = d(annotationArr);
        this.f17432f = f(annotationArr);
        this.f17433g = c(annotationArr, str);
        this.f17434h = e(annotationArr);
    }

    /* renamed from: a */
    public Object convert(ResponseBody responseBody) {
        String str;
        String string = responseBody.string();
        try {
            if (this.f17431e) {
                return this.f17428b.fromJson(string, this.f17430d);
            }
            BaseResponse baseResponse = (BaseResponse) this.f17428b.fromJson(string, BaseResponse.class);
            if (!this.f17432f) {
                Object b10 = b(string);
                responseBody.close();
                return b10;
            } else if ("0".equals(baseResponse.getReturnCode())) {
                Object b11 = b(string);
                responseBody.close();
                return b11;
            } else {
                EncryptJsonBean encryptJsonBean = (EncryptJsonBean) this.f17428b.fromJson(string, EncryptJsonBean.class);
                if (!TextUtils.isEmpty(encryptJsonBean.getData())) {
                    str = i.a(encryptJsonBean.getData(), this.f17433g);
                } else {
                    str = null;
                }
                throw new ResultException(baseResponse.getReturnCode(), baseResponse.getErrorMessage(), str);
            }
        } finally {
            responseBody.close();
        }
    }

    public final Object b(String str) {
        if (!i.h() || !this.f17434h) {
            return this.f17428b.fromJson(str, this.f17430d);
        }
        EncryptJsonBean encryptJsonBean = (EncryptJsonBean) this.f17428b.fromJson(str, EncryptJsonBean.class);
        String a10 = i.a(encryptJsonBean.getData(), this.f17433g);
        return this.f17428b.fromJson(str.replace("\"" + encryptJsonBean.getData() + "\"", a10), this.f17430d);
    }

    public final String c(Annotation[] annotationArr, String str) {
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

    public final boolean d(Annotation[] annotationArr) {
        boolean z10 = false;
        for (Annotation annotation : annotationArr) {
            z10 = annotation.toString().contains("@retrofit2.http.GET");
            if (z10) {
                break;
            }
        }
        return z10;
    }

    public final boolean e(Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            if (annotation.toString().contains("needEncrypt:false")) {
                return false;
            }
        }
        return true;
    }

    public final boolean f(Annotation[] annotationArr) {
        if (annotationArr == null || annotationArr.length <= 0) {
            return true;
        }
        for (Annotation annotation : annotationArr) {
            if (annotation.toString().contains("ProcessResult:false")) {
                return false;
            }
        }
        return true;
    }
}
