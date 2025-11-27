package com.hpplay.sdk.source.mdns.xbill.dns.utils;

import c8.b;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

public class hexdump {
    private static final char[] hex = "0123456789ABCDEF".toCharArray();

    public static String dump(String str, byte[] bArr, int i10, int i11) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i11 + b.f11376b);
        if (str != null) {
            stringBuffer.append(" (" + str + ")");
        }
        stringBuffer.append(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER);
        int length = (stringBuffer.toString().length() + 8) & -8;
        stringBuffer.append(9);
        int i12 = (80 - length) / 3;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 != 0 && i13 % i12 == 0) {
                stringBuffer.append(10);
                for (int i14 = 0; i14 < length / 8; i14++) {
                    stringBuffer.append(9);
                }
            }
            byte b10 = bArr[i13 + i10] & UnsignedBytes.MAX_VALUE;
            char[] cArr = hex;
            stringBuffer.append(cArr[b10 >> 4]);
            stringBuffer.append(cArr[b10 & 15]);
            stringBuffer.append(' ');
        }
        stringBuffer.append(10);
        return stringBuffer.toString();
    }

    public static String dump(String str, byte[] bArr) {
        return dump(str, bArr, 0, bArr.length);
    }
}
