package io.jsonwebtoken.io;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.Arrays;

final class Base64 {
    private static final char[] BASE64URL_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".toCharArray();
    private static final int[] BASE64URL_IALPHABET;
    private static final char[] BASE64_ALPHABET;
    private static final int[] BASE64_IALPHABET;
    static final Base64 DEFAULT = new Base64(false);
    private static final int IALPHABET_MAX_INDEX;
    static final Base64 URL_SAFE = new Base64(true);
    private final char[] ALPHABET;
    private final int[] IALPHABET;
    private final boolean urlsafe;

    static {
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        BASE64_ALPHABET = charArray;
        int[] iArr = new int[256];
        BASE64_IALPHABET = iArr;
        int[] iArr2 = new int[256];
        BASE64URL_IALPHABET = iArr2;
        IALPHABET_MAX_INDEX = iArr.length - 1;
        Arrays.fill(iArr, -1);
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        int length = charArray.length;
        for (int i10 = 0; i10 < length; i10++) {
            BASE64_IALPHABET[BASE64_ALPHABET[i10]] = i10;
            BASE64URL_IALPHABET[BASE64URL_ALPHABET[i10]] = i10;
        }
        BASE64_IALPHABET[61] = 0;
        BASE64URL_IALPHABET[61] = 0;
    }

    private Base64(boolean z10) {
        char[] cArr;
        int[] iArr;
        this.urlsafe = z10;
        if (z10) {
            cArr = BASE64URL_ALPHABET;
        } else {
            cArr = BASE64_ALPHABET;
        }
        this.ALPHABET = cArr;
        if (z10) {
            iArr = BASE64URL_IALPHABET;
        } else {
            iArr = BASE64_IALPHABET;
        }
        this.IALPHABET = iArr;
    }

    private int ctoi(char c10) {
        int i10;
        if (c10 > IALPHABET_MAX_INDEX) {
            i10 = -1;
        } else {
            i10 = this.IALPHABET[c10];
        }
        if (i10 >= 0) {
            return i10;
        }
        throw new DecodingException("Illegal " + getName() + " character: '" + c10 + "'");
    }

    private char[] encodeToChar(byte[] bArr, boolean z10) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        byte[] bArr2 = bArr;
        if (bArr2 != null) {
            i10 = bArr2.length;
        } else {
            i10 = 0;
        }
        if (i10 == 0) {
            return new char[0];
        }
        int i15 = (i10 / 3) * 3;
        int i16 = i10 - i15;
        int i17 = i10 - 1;
        int i18 = ((i17 / 3) + 1) << 2;
        if (z10) {
            i11 = ((i18 - 1) / 76) << 1;
        } else {
            i11 = 0;
        }
        int i19 = i18 + i11;
        if (i16 == 2) {
            i12 = 1;
        } else if (i16 == 1) {
            i12 = 2;
        } else {
            i12 = 0;
        }
        if (this.urlsafe) {
            i13 = i19 - i12;
        } else {
            i13 = i19;
        }
        char[] cArr = new char[i13];
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        while (i20 < i15) {
            int i23 = i20 + 1;
            int i24 = i23 + 1;
            byte b10 = ((bArr2[i20] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr2[i23] & UnsignedBytes.MAX_VALUE) << 8);
            int i25 = i24 + 1;
            byte b11 = b10 | (bArr2[i24] & UnsignedBytes.MAX_VALUE);
            int i26 = i21 + 1;
            char[] cArr2 = this.ALPHABET;
            cArr[i21] = cArr2[(b11 >>> Ascii.DC2) & 63];
            int i27 = i26 + 1;
            cArr[i26] = cArr2[(b11 >>> 12) & 63];
            int i28 = i27 + 1;
            cArr[i27] = cArr2[(b11 >>> 6) & 63];
            i21 = i28 + 1;
            cArr[i28] = cArr2[b11 & 63];
            if (z10 && (i22 = i22 + 1) == 19 && i21 < i19 - 2) {
                int i29 = i21 + 1;
                cArr[i21] = ASCIIPropertyListParser.WHITESPACE_CARRIAGE_RETURN;
                cArr[i29] = 10;
                i21 = i29 + 1;
                i22 = 0;
            }
            i20 = i25;
        }
        if (i16 > 0) {
            int i30 = (bArr2[i15] & UnsignedBytes.MAX_VALUE) << 10;
            if (i16 == 2) {
                i14 = (bArr2[i17] & UnsignedBytes.MAX_VALUE) << 2;
            } else {
                i14 = 0;
            }
            int i31 = i30 | i14;
            char[] cArr3 = this.ALPHABET;
            cArr[i19 - 4] = cArr3[i31 >> 12];
            cArr[i19 - 3] = cArr3[(i31 >>> 6) & 63];
            if (i16 == 2) {
                cArr[i19 - 2] = cArr3[i31 & 63];
            } else if (!this.urlsafe) {
                cArr[i19 - 2] = ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN;
            }
            if (!this.urlsafe) {
                cArr[i19 - 1] = ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN;
            }
        }
        return cArr;
    }

    private String getName() {
        if (this.urlsafe) {
            return "base64url";
        }
        return "base64";
    }

    public byte[] decodeFast(CharSequence charSequence) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = 0;
        if (charSequence != null) {
            i10 = charSequence.length();
        } else {
            i10 = 0;
        }
        if (i10 == 0) {
            return new byte[0];
        }
        int i16 = i10 - 1;
        int i17 = 0;
        while (i11 < i16 && this.IALPHABET[charSequence.charAt(i11)] < 0) {
            i17 = i11 + 1;
        }
        while (i16 > 0 && this.IALPHABET[charSequence.charAt(i16)] < 0) {
            i16--;
        }
        if (charSequence.charAt(i16) != '=') {
            i12 = 0;
        } else if (charSequence.charAt(i16 - 1) == '=') {
            i12 = 2;
        } else {
            i12 = 1;
        }
        int i18 = (i16 - i11) + 1;
        if (i10 > 76) {
            if (charSequence.charAt(76) == 13) {
                i14 = i18 / 78;
            } else {
                i14 = 0;
            }
            i13 = i14 << 1;
        } else {
            i13 = 0;
        }
        int i19 = (((i18 - i13) * 6) >> 3) - i12;
        byte[] bArr = new byte[i19];
        int i20 = (i19 / 3) * 3;
        int i21 = 0;
        int i22 = 0;
        while (i21 < i20) {
            int i23 = i11 + 1;
            int i24 = i23 + 1;
            int ctoi = (ctoi(charSequence.charAt(i11)) << 18) | (ctoi(charSequence.charAt(i23)) << 12);
            int i25 = i24 + 1;
            int ctoi2 = ctoi | (ctoi(charSequence.charAt(i24)) << 6);
            int i26 = i25 + 1;
            int ctoi3 = ctoi2 | ctoi(charSequence.charAt(i25));
            int i27 = i21 + 1;
            bArr[i21] = (byte) (ctoi3 >> 16);
            int i28 = i27 + 1;
            bArr[i27] = (byte) (ctoi3 >> 8);
            int i29 = i28 + 1;
            bArr[i28] = (byte) ctoi3;
            if (i13 <= 0 || (i22 = i22 + 1) != 19) {
                i11 = i26;
            } else {
                i11 = i26 + 2;
                i22 = 0;
            }
            i21 = i29;
        }
        if (i21 < i19) {
            int i30 = 0;
            while (i11 <= i16 - i12) {
                i15 |= ctoi(charSequence.charAt(i11)) << (18 - (i30 * 6));
                i30++;
                i11++;
            }
            int i31 = 16;
            while (i21 < i19) {
                bArr[i21] = (byte) (i15 >> i31);
                i31 -= 8;
                i21++;
            }
        }
        return bArr;
    }

    public String encodeToString(byte[] bArr, boolean z10) {
        return new String(encodeToChar(bArr, z10));
    }
}
