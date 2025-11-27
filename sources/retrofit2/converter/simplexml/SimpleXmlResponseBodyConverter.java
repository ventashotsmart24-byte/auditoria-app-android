package retrofit2.converter.simplexml;

import java.io.IOException;
import okhttp3.ResponseBody;
import org.simpleframework.xml.Serializer;
import retrofit2.Converter;

final class SimpleXmlResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Class<T> cls;
    private final Serializer serializer;
    private final boolean strict;

    public SimpleXmlResponseBodyConverter(Class<T> cls2, Serializer serializer2, boolean z10) {
        this.cls = cls2;
        this.serializer = serializer2;
        this.strict = z10;
    }

    public T convert(ResponseBody responseBody) {
        try {
            T read = this.serializer.read(this.cls, responseBody.charStream(), this.strict);
            if (read != null) {
                responseBody.close();
                return read;
            }
            throw new IllegalStateException("Could not deserialize body as " + this.cls);
        } catch (RuntimeException e10) {
            e = e10;
            throw e;
        } catch (IOException e11) {
            e = e11;
            throw e;
        } catch (Exception e12) {
            throw new RuntimeException(e12);
        } catch (Throwable th) {
            responseBody.close();
            throw th;
        }
    }
}
