package retrofit2.converter.simplexml;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class SimpleXmlConverterFactory extends Converter.Factory {
    private final Serializer serializer;
    private final boolean strict;

    private SimpleXmlConverterFactory(Serializer serializer2, boolean z10) {
        if (serializer2 != null) {
            this.serializer = serializer2;
            this.strict = z10;
            return;
        }
        throw new NullPointerException("serializer == null");
    }

    public static SimpleXmlConverterFactory create() {
        return create(new Persister());
    }

    public static SimpleXmlConverterFactory createNonStrict() {
        return createNonStrict(new Persister());
    }

    public boolean isStrict() {
        return this.strict;
    }

    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        if (!(type instanceof Class)) {
            return null;
        }
        return new SimpleXmlRequestBodyConverter(this.serializer);
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (!(type instanceof Class)) {
            return null;
        }
        return new SimpleXmlResponseBodyConverter((Class) type, this.serializer, this.strict);
    }

    public static SimpleXmlConverterFactory create(Serializer serializer2) {
        return new SimpleXmlConverterFactory(serializer2, true);
    }

    public static SimpleXmlConverterFactory createNonStrict(Serializer serializer2) {
        return new SimpleXmlConverterFactory(serializer2, false);
    }
}
