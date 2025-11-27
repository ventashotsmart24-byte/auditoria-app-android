package y8;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public interface l extends n, u {

    public static final class a implements l {
        public String a() {
            return "gzip";
        }

        public OutputStream compress(OutputStream outputStream) {
            return new GZIPOutputStream(outputStream);
        }

        public InputStream decompress(InputStream inputStream) {
            return new GZIPInputStream(inputStream);
        }
    }

    public static final class b implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final l f20085a = new b();

        public String a() {
            return "identity";
        }

        public OutputStream compress(OutputStream outputStream) {
            return outputStream;
        }

        public InputStream decompress(InputStream inputStream) {
            return inputStream;
        }
    }
}
