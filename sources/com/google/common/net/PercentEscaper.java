package com.google.common.net;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.escape.UnicodeEscaper;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class PercentEscaper extends UnicodeEscaper {
    private static final char[] PLUS_SIGN = {'+'};
    private static final char[] UPPER_HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    private final boolean plusForSpace;
    private final boolean[] safeOctets;

    public PercentEscaper(String str, boolean z10) {
        Preconditions.checkNotNull(str);
        if (!str.matches(".*[0-9A-Za-z].*")) {
            String concat = str.concat("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
            if (!z10 || !concat.contains(" ")) {
                this.plusForSpace = z10;
                this.safeOctets = createSafeOctets(concat);
                return;
            }
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        }
        throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
    }

    private static boolean[] createSafeOctets(String str) {
        char[] charArray = str.toCharArray();
        int i10 = -1;
        for (char max : charArray) {
            i10 = Math.max(max, i10);
        }
        boolean[] zArr = new boolean[(i10 + 1)];
        for (char c10 : charArray) {
            zArr[c10] = true;
        }
        return zArr;
    }

    public String escape(String str) {
        Preconditions.checkNotNull(str);
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            boolean[] zArr = this.safeOctets;
            if (charAt >= zArr.length || !zArr[charAt]) {
                return escapeSlow(str, i10);
            }
        }
        return str;
    }

    public int nextEscapeIndex(CharSequence charSequence, int i10, int i11) {
        Preconditions.checkNotNull(charSequence);
        while (i10 < i11) {
            char charAt = charSequence.charAt(i10);
            boolean[] zArr = this.safeOctets;
            if (charAt >= zArr.length || !zArr[charAt]) {
                break;
            }
            i10++;
        }
        return i10;
    }

    @CheckForNull
    public char[] escape(int i10) {
        boolean[] zArr = this.safeOctets;
        if (i10 < zArr.length && zArr[i10]) {
            return null;
        }
        if (i10 == 32 && this.plusForSpace) {
            return PLUS_SIGN;
        }
        if (i10 <= 127) {
            char[] cArr = new char[3];
            cArr[0] = '%';
            char[] cArr2 = UPPER_HEX_DIGITS;
            cArr[2] = cArr2[i10 & 15];
            cArr[1] = cArr2[i10 >>> 4];
            return cArr;
        } else if (i10 <= 2047) {
            char[] cArr3 = new char[6];
            cArr3[0] = '%';
            cArr3[3] = '%';
            char[] cArr4 = UPPER_HEX_DIGITS;
            cArr3[5] = cArr4[i10 & 15];
            int i11 = i10 >>> 4;
            cArr3[4] = cArr4[(i11 & 3) | 8];
            int i12 = i11 >>> 2;
            cArr3[2] = cArr4[i12 & 15];
            cArr3[1] = cArr4[(i12 >>> 4) | 12];
            return cArr3;
        } else if (i10 <= 65535) {
            char[] cArr5 = new char[9];
            cArr5[0] = '%';
            cArr5[1] = 'E';
            cArr5[3] = '%';
            cArr5[6] = '%';
            char[] cArr6 = UPPER_HEX_DIGITS;
            cArr5[8] = cArr6[i10 & 15];
            int i13 = i10 >>> 4;
            cArr5[7] = cArr6[(i13 & 3) | 8];
            int i14 = i13 >>> 2;
            cArr5[5] = cArr6[i14 & 15];
            int i15 = i14 >>> 4;
            cArr5[4] = cArr6[(i15 & 3) | 8];
            cArr5[2] = cArr6[i15 >>> 2];
            return cArr5;
        } else if (i10 <= 1114111) {
            char[] cArr7 = new char[12];
            cArr7[0] = '%';
            cArr7[1] = 'F';
            cArr7[3] = '%';
            cArr7[6] = '%';
            cArr7[9] = '%';
            char[] cArr8 = UPPER_HEX_DIGITS;
            cArr7[11] = cArr8[i10 & 15];
            int i16 = i10 >>> 4;
            cArr7[10] = cArr8[(i16 & 3) | 8];
            int i17 = i16 >>> 2;
            cArr7[8] = cArr8[i17 & 15];
            int i18 = i17 >>> 4;
            cArr7[7] = cArr8[(i18 & 3) | 8];
            int i19 = i18 >>> 2;
            cArr7[5] = cArr8[i19 & 15];
            int i20 = i19 >>> 4;
            cArr7[4] = cArr8[(i20 & 3) | 8];
            cArr7[2] = cArr8[(i20 >>> 2) & 7];
            return cArr7;
        } else {
            StringBuilder sb = new StringBuilder(43);
            sb.append("Invalid unicode character value ");
            sb.append(i10);
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
