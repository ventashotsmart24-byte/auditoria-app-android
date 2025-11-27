package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public final class Code128Writer extends OneDimensionalCodeWriter {
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_B = 100;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final char ESCAPE_FNC_1 = 'ñ';
    private static final char ESCAPE_FNC_2 = 'ò';
    private static final char ESCAPE_FNC_3 = 'ó';
    private static final char ESCAPE_FNC_4 = 'ô';

    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    private static int chooseCode(CharSequence charSequence, int i10, int i11) {
        CType cType;
        CType findCType;
        CType findCType2;
        CType findCType3 = findCType(charSequence, i10);
        CType cType2 = CType.UNCODABLE;
        if (!(findCType3 == cType2 || findCType3 == (cType = CType.ONE_DIGIT))) {
            if (i11 == 99) {
                return i11;
            }
            if (i11 == 100) {
                CType cType3 = CType.FNC_1;
                if (findCType3 == cType3 || (findCType = findCType(charSequence, i10 + 2)) == cType2 || findCType == cType) {
                    return i11;
                }
                if (findCType != cType3) {
                    int i12 = i10 + 4;
                    while (true) {
                        findCType2 = findCType(charSequence, i12);
                        if (findCType2 != CType.TWO_DIGITS) {
                            break;
                        }
                        i12 += 2;
                    }
                    if (findCType2 == CType.ONE_DIGIT) {
                        return 100;
                    }
                    return 99;
                } else if (findCType(charSequence, i10 + 3) == CType.TWO_DIGITS) {
                    return 99;
                } else {
                    return 100;
                }
            } else {
                if (findCType3 == CType.FNC_1) {
                    findCType3 = findCType(charSequence, i10 + 1);
                }
                if (findCType3 == CType.TWO_DIGITS) {
                    return 99;
                }
            }
        }
        return 100;
    }

    private static CType findCType(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        if (i10 >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i10);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        int i11 = i10 + 1;
        if (i11 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i11);
        if (charAt2 < '0' || charAt2 > '9') {
            return CType.ONE_DIGIT;
        }
        return CType.TWO_DIGITS;
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.encode(str, barcodeFormat, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    public boolean[] encode(String str) {
        int i10;
        int length = str.length();
        if (length <= 0 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = str.charAt(i12);
            if (charAt < ' ' || charAt > '~') {
                switch (charAt) {
                    case 241:
                    case 242:
                    case 243:
                    case IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE /*244*/:
                        break;
                    default:
                        throw new IllegalArgumentException("Bad character in input: " + charAt);
                }
            }
        }
        ArrayList<int[]> arrayList = new ArrayList<>();
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 1;
        while (i13 < length) {
            int chooseCode = chooseCode(str, i13, i15);
            int i17 = 100;
            if (chooseCode == i15) {
                switch (str.charAt(i13)) {
                    case 241:
                        i17 = 102;
                        break;
                    case 242:
                        i17 = 97;
                        break;
                    case 243:
                        i17 = 96;
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE /*244*/:
                        break;
                    default:
                        if (i15 != 100) {
                            i17 = Integer.parseInt(str.substring(i13, i13 + 2));
                            i13++;
                            break;
                        } else {
                            i17 = str.charAt(i13) - ' ';
                            break;
                        }
                }
                i13++;
            } else {
                i10 = i15 == 0 ? chooseCode == 100 ? 104 : 105 : chooseCode;
                i15 = chooseCode;
            }
            arrayList.add(Code128Reader.CODE_PATTERNS[i10]);
            i14 += i10 * i16;
            if (i13 != 0) {
                i16++;
            }
        }
        int[][] iArr = Code128Reader.CODE_PATTERNS;
        arrayList.add(iArr[i14 % 103]);
        arrayList.add(iArr[106]);
        int i18 = 0;
        for (int[] iArr2 : arrayList) {
            for (int i19 : (int[]) r12.next()) {
                i18 += i19;
            }
        }
        boolean[] zArr = new boolean[i18];
        for (int[] appendPattern : arrayList) {
            i11 += OneDimensionalCodeWriter.appendPattern(zArr, i11, appendPattern, true);
        }
        return zArr;
    }
}
