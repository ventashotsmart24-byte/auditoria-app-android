package ma;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public abstract class f {

    public class a implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public static X509TrustManager a() {
        try {
            return new a();
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
