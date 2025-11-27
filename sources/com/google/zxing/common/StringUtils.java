package com.google.zxing.common;

import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.zxing.DecodeHintType;
import java.nio.charset.Charset;
import java.util.Map;

public final class StringUtils {
    private static final boolean ASSUME_SHIFT_JIS;
    private static final String EUC_JP = "EUC_JP";
    public static final String GB2312 = "GB2312";
    private static final String ISO88591 = "ISO8859_1";
    private static final String PLATFORM_DEFAULT_ENCODING;
    public static final String SHIFT_JIS = "SJIS";
    private static final String UTF8 = "UTF8";

    static {
        boolean z10;
        String name = Charset.defaultCharset().name();
        PLATFORM_DEFAULT_ENCODING = name;
        if (SHIFT_JIS.equalsIgnoreCase(name) || EUC_JP.equalsIgnoreCase(name)) {
            z10 = true;
        } else {
            z10 = false;
        }
        ASSUME_SHIFT_JIS = z10;
    }

    private StringUtils() {
    }

    public static String guessEncoding(byte[] bArr, Map<DecodeHintType, ?> map) {
        boolean z10;
        byte[] bArr2 = bArr;
        Map<DecodeHintType, ?> map2 = map;
        if (map2 != null) {
            DecodeHintType decodeHintType = DecodeHintType.CHARACTER_SET;
            if (map2.containsKey(decodeHintType)) {
                return map2.get(decodeHintType).toString();
            }
        }
        int length = bArr2.length;
        boolean z11 = true;
        int i10 = 0;
        if (bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i11 = 0;
        boolean z12 = true;
        boolean z13 = true;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        while (i12 < length && (z11 || z12 || z13)) {
            byte b10 = bArr2[i12] & UnsignedBytes.MAX_VALUE;
            if (z13) {
                if (i13 > 0) {
                    if ((b10 & UnsignedBytes.MAX_POWER_OF_TWO) != 0) {
                        i13--;
                    }
                } else if ((b10 & UnsignedBytes.MAX_POWER_OF_TWO) != 0) {
                    if ((b10 & SignedBytes.MAX_POWER_OF_TWO) != 0) {
                        i13++;
                        if ((b10 & 32) == 0) {
                            i15++;
                        } else {
                            i13++;
                            if ((b10 & 16) == 0) {
                                i16++;
                            } else {
                                i13++;
                                if ((b10 & 8) == 0) {
                                    i17++;
                                }
                            }
                        }
                    }
                }
                z13 = false;
            }
            if (z11) {
                if (b10 > Byte.MAX_VALUE && b10 < 160) {
                    z11 = false;
                } else if (b10 > 159 && (b10 < 192 || b10 == 215 || b10 == 247)) {
                    i19++;
                }
            }
            if (z12) {
                if (i14 > 0) {
                    if (b10 >= 64 && b10 != Byte.MAX_VALUE && b10 <= 252) {
                        i14--;
                    }
                } else if (!(b10 == 128 || b10 == 160 || b10 > 239)) {
                    if (b10 <= 160 || b10 >= 224) {
                        if (b10 > Byte.MAX_VALUE) {
                            i14++;
                            int i22 = i20 + 1;
                            if (i22 > i10) {
                                i10 = i22;
                                i20 = i10;
                            } else {
                                i20 = i22;
                            }
                        } else {
                            i20 = 0;
                        }
                        i21 = 0;
                    } else {
                        i11++;
                        int i23 = i21 + 1;
                        if (i23 > i18) {
                            i18 = i23;
                            i21 = i18;
                        } else {
                            i21 = i23;
                        }
                        i20 = 0;
                    }
                }
                z12 = false;
            }
            i12++;
            bArr2 = bArr;
        }
        if (z13 && i13 > 0) {
            z13 = false;
        }
        if (z12 && i14 > 0) {
            z12 = false;
        }
        if (z13 && (z10 || i15 + i16 + i17 > 0)) {
            return UTF8;
        }
        if (z12 && (ASSUME_SHIFT_JIS || i18 >= 3 || i10 >= 3)) {
            return SHIFT_JIS;
        }
        if (!z11 || !z12) {
            if (z11) {
                return ISO88591;
            }
            if (z12) {
                return SHIFT_JIS;
            }
            if (z13) {
                return UTF8;
            }
            return PLATFORM_DEFAULT_ENCODING;
        } else if ((i18 != 2 || i11 != 2) && i19 * 10 < length) {
            return ISO88591;
        } else {
            return SHIFT_JIS;
        }
    }
}
