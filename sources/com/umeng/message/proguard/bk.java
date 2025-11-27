package com.umeng.message.proguard;

import android.text.TextUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class bk {
    public static String a(String str, String str2, byte[] bArr) {
        if (TextUtils.isEmpty(str2) || bArr == null || TextUtils.isEmpty(str)) {
            return "";
        }
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, new SecretKeySpec(str2.getBytes(), "AES"), new IvParameterSpec(bArr));
        return bf.a(instance.doFinal(str.getBytes()));
    }

    public static String b(String str, String str2, byte[] bArr) {
        if (TextUtils.isEmpty(str2) || bArr == null || TextUtils.isEmpty(str)) {
            return "";
        }
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, new SecretKeySpec(str2.getBytes(), "AES"), new IvParameterSpec(bArr));
        return new String(instance.doFinal(bf.a(str)));
    }
}
