package j7;

import com.google.common.primitives.UnsignedBytes;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static char[] f17552a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f17553b = new byte[256];

    static {
        for (int i10 = 0; i10 < 256; i10++) {
            f17553b[i10] = -1;
        }
        for (int i11 = 65; i11 <= 90; i11++) {
            f17553b[i11] = (byte) (i11 - 65);
        }
        for (int i12 = 97; i12 <= 122; i12++) {
            f17553b[i12] = (byte) ((i12 + 26) - 97);
        }
        for (int i13 = 48; i13 <= 57; i13++) {
            f17553b[i13] = (byte) ((i13 + 52) - 48);
        }
        byte[] bArr = f17553b;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public static String a(byte[] bArr) {
        boolean z10;
        int i10;
        char[] cArr = new char[(((bArr.length + 2) / 3) * 4)];
        int i11 = 0;
        int i12 = 0;
        while (i11 < bArr.length) {
            int i13 = (bArr[i11] & UnsignedBytes.MAX_VALUE) << 8;
            int i14 = i11 + 1;
            boolean z11 = true;
            if (i14 < bArr.length) {
                i13 |= bArr[i14] & UnsignedBytes.MAX_VALUE;
                z10 = true;
            } else {
                z10 = false;
            }
            int i15 = i13 << 8;
            int i16 = i11 + 2;
            if (i16 < bArr.length) {
                i15 |= bArr[i16] & UnsignedBytes.MAX_VALUE;
            } else {
                z11 = false;
            }
            int i17 = i12 + 3;
            char[] cArr2 = f17552a;
            int i18 = 64;
            if (z11) {
                i10 = i15 & 63;
            } else {
                i10 = 64;
            }
            cArr[i17] = cArr2[i10];
            int i19 = i15 >> 6;
            int i20 = i12 + 2;
            if (z10) {
                i18 = i19 & 63;
            }
            cArr[i20] = cArr2[i18];
            int i21 = i19 >> 6;
            cArr[i12 + 1] = cArr2[i21 & 63];
            cArr[i12 + 0] = cArr2[(i21 >> 6) & 63];
            i11 += 3;
            i12 += 4;
        }
        return new String(cArr);
    }
}
