package com.hpplay.component.protocol.srp6;

import java.math.BigInteger;
import java.util.Arrays;

public class BigIntegerUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private BigIntegerUtils() {
    }

    public static BigInteger bigIntegerFromBytes(byte[] bArr) {
        return new BigInteger(1, bArr);
    }

    public static byte[] bigIntegerToBytes(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray[0] == 0) {
            return Arrays.copyOfRange(byteArray, 1, byteArray.length);
        }
        return byteArray;
    }

    public static BigInteger fromHex(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new BigInteger(str, 16);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static String toHex(BigInteger bigInteger) {
        if (bigInteger == null) {
            return null;
        }
        return bigInteger.toString(16);
    }
}
