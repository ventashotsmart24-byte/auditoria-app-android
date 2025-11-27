package retrofit2.converter.simplexml;

import java.io.OutputStreamWriter;
import java.io.Writer;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import org.simpleframework.xml.Serializer;
import retrofit2.Converter;

final class SimpleXmlRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final String CHARSET = "UTF-8";
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/xml; charset=UTF-8");
    private final Serializer serializer;

    public SimpleXmlRequestBodyConverter(Serializer serializer2) {
        this.serializer = serializer2;
    }

    public RequestBody convert(T t10) {
        Buffer buffer = new Buffer();
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(buffer.outputStream(), "UTF-8");
            this.serializer.write((Object) t10, (Writer) outputStreamWriter);
            outputStreamWriter.flush();
            return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }
}
