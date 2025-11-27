package com.mobile.brasiltv.utils;

import com.google.common.primitives.UnsignedBytes;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public abstract class l {
    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb.append(String.format("%02X", new Object[]{Integer.valueOf(bArr[i10] & UnsignedBytes.MAX_VALUE)}));
        }
        return sb.toString();
    }

    public static String b(String str) {
        Cipher instance = Cipher.getInstance("DES");
        instance.init(1, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec("7A5POuI3".getBytes("UTF-8"))), new SecureRandom());
        return a(instance.doFinal(str.getBytes("UTF-8")));
    }
}
