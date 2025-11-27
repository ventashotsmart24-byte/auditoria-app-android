package j7;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public abstract class c {
    public static String a(String str, String str2) {
        try {
            Cipher instance = Cipher.getInstance("DES");
            instance.init(1, new SecretKeySpec(str2.getBytes(), "DES"));
            try {
                return b.a(instance.doFinal(str.getBytes()));
            } catch (IllegalBlockSizeException e10) {
                e10.printStackTrace();
                throw new Exception("IllegalBlockSizeException", e10);
            } catch (BadPaddingException e11) {
                e11.printStackTrace();
                throw new Exception("BadPaddingException", e11);
            }
        } catch (NoSuchAlgorithmException e12) {
            e12.printStackTrace();
            throw new Exception("NoSuchAlgorithmException", e12);
        } catch (NoSuchPaddingException e13) {
            e13.printStackTrace();
            throw new Exception("NoSuchPaddingException", e13);
        } catch (InvalidKeyException e14) {
            e14.printStackTrace();
            throw new Exception("InvalidKeyException", e14);
        }
    }
}
