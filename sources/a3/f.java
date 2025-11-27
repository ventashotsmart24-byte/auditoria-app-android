package a3;

import ba.c;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.cybergarage.http.HTTP;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import t9.i;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f164a = new f();

    public final String a(String str) {
        i.g(str, "str");
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes(c.f11331b);
            i.f(bytes, "this as java.lang.String).getBytes(charset)");
            byte[] digest = instance.digest(bytes);
            String str2 = "";
            i.f(digest, HTTP.CONTENT_RANGE_BYTES);
            for (byte b10 : digest) {
                String hexString = Integer.toHexString(b10 & UnsignedBytes.MAX_VALUE);
                if (hexString.length() == 1) {
                    hexString = '0' + hexString;
                }
                str2 = str2 + hexString;
            }
            return str2;
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
            return " ";
        } catch (Exception e11) {
            e11.printStackTrace();
            return " ";
        }
    }
}
