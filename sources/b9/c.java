package b9;

import com.hpplay.cybergarage.soap.SOAP;
import java.io.UnsupportedEncodingException;
import okio.ByteString;

public abstract class c {
    public static String a(String str, String str2) {
        try {
            String base64 = ByteString.of((str + SOAP.DELIM + str2).getBytes("ISO-8859-1")).base64();
            return "Basic " + base64;
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }
}
