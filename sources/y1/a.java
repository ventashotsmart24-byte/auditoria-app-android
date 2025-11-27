package y1;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public abstract class a {

    /* renamed from: y1.a$a  reason: collision with other inner class name */
    public class C0135a implements X509TrustManager {
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
            return new C0135a();
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
