package com.hpplay.sdk.source.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.hpplay.sdk.source.log.SourceLog;
import java.lang.reflect.Constructor;
import java.nio.charset.Charset;

public class ADENSTUtils {
    private static final byte[] CA_THM = {65, 69, 83, 47, 67, 66, 67, 47, 78, 79, 80, 65, 68, 68, 73, 78, 71};
    private static final byte[] CIP_CLASSNAME = {106, 97, 118, 97, 120, 46, 99, 114, 121, 112, 116, 111, 46, 67, 105, 112, 104, 101, 114};
    private static final byte[] ECA_THM = {65, 69, 83, 47, 69, 67, 66, 47, 80, 75, 67, 83, 53, 80, 97, 100, 100, 105, 110, 103};
    private static final byte[] KA = {65, 69, 83};
    private static final byte[] SEK = {55, 74, 74, 56, 113, 97, 74, 50, 65, 52, 107, 74, 80, 69, 74, 66, 105, 77, 82, 116, 65, 78, 110, 74, 54, 79, 67, 55, 115, 80, 101, 118};
    private static final byte[] SIV = {55, 74, 74, 56, 113, 97, 74, 50, 65, 52, 107, 74, 80, 69, 74, 66};
    private static final byte[] SKS_CLASSNAME = {106, 97, 118, 97, 120, 46, 99, 114, 121, 112, 116, 111, 46, 115, 112, 101, 99, 46, 83, 101, 99, 114, 101, 116, 75, 101, 121, 83, 112, 101, 99};
    private static final String TAG = "ADENSTUtils";

    public static byte[] base64Decode(String str) {
        return Base64.decode(str, 2);
    }

    public static String base64Encode(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    private static Class createAps() {
        return Class.forName("java.security.spec.AlgorithmParameterSpec");
    }

    private static Object createCipher(String str) {
        try {
            return Class.forName(new String(CIP_CLASSNAME)).getMethod("getInstance", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return null;
        }
    }

    private static Object createIV(String str) {
        byte[] bArr;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(str);
        while (stringBuffer.length() < 16) {
            stringBuffer.append(" ");
        }
        try {
            bArr = stringBuffer.substring(0, 16).getBytes("UTF-8");
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            bArr = null;
        }
        return Class.forName("javax.crypto.spec.IvParameterSpec").getConstructor(new Class[]{byte[].class}).newInstance(new Object[]{bArr});
    }

    private static Class createKClass() {
        return Class.forName("java.security.Key");
    }

    private static Object createSks(byte[] bArr) {
        try {
            Constructor<?> constructor = Class.forName(new String(SKS_CLASSNAME)).getConstructor(new Class[]{byte[].class, String.class});
            if (bArr == null) {
                return constructor.newInstance(new Object[]{SEK, new String(KA)});
            }
            return constructor.newInstance(new Object[]{bArr, new String(KA)});
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return null;
        }
    }

    public static String decrypt(String str) {
        Object createSks = createSks((byte[]) null);
        Object createCipher = createCipher(new String(CA_THM));
        Class<?> cls = createCipher.getClass();
        try {
            Charset forName = Charset.forName("UTF-8");
            Object base64Decode = base64Decode(str);
            cls.getMethod("init", new Class[]{Integer.TYPE, createKClass(), createAps()}).invoke(createCipher, new Object[]{2, createSks, createIV(new String(SIV))});
            return new String((byte[]) cls.getMethod("doFinal", new Class[]{byte[].class}).invoke(createCipher, new Object[]{base64Decode}), forName);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return null;
        }
    }

    public static String decryptByKey(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            SourceLog.w(TAG, "decryptECB,value is invalid");
            return null;
        }
        try {
            Object createSks = createSks(str.getBytes("UTF-8"));
            Object createCipher = createCipher(new String(ECA_THM));
            Class<?> cls = createCipher.getClass();
            Charset forName = Charset.forName("UTF-8");
            cls.getMethod("init", new Class[]{Integer.TYPE, createKClass()}).invoke(createCipher, new Object[]{2, createSks});
            Object base64Decode = base64Decode(str2);
            return new String((byte[]) cls.getMethod("doFinal", new Class[]{byte[].class}).invoke(createCipher, new Object[]{base64Decode}), forName);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return null;
        }
    }

    public static String encrypt(String str) {
        Object createSks = createSks((byte[]) null);
        Object createCipher = createCipher(new String(CA_THM));
        Class<?> cls = createCipher.getClass();
        try {
            Charset forName = Charset.forName("UTF-8");
            cls.getMethod("init", new Class[]{Integer.TYPE, createKClass(), createAps()}).invoke(createCipher, new Object[]{1, createSks, createIV(new String(SIV))});
            return base64Encode((byte[]) cls.getMethod("doFinal", new Class[]{byte[].class}).invoke(createCipher, new Object[]{padding(str.getBytes(forName))}));
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return null;
        }
    }

    private static byte[] padding(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = 16 - (bArr.length % 16);
        byte[] bArr2 = new byte[(bArr.length + length)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        for (int i10 = 0; i10 < length; i10++) {
            bArr2[bArr.length + i10] = (byte) length;
        }
        return bArr2;
    }
}
