package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

public final class Encoder {
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    private static final int MAX_NB_BITS = 32;
    private static final int MAX_NB_BITS_COMPACT = 4;
    private static final int[] WORD_SIZE = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private Encoder() {
    }

    private static int[] bitsToWords(BitArray bitArray, int i10, int i11) {
        int i12;
        int[] iArr = new int[i11];
        int size = bitArray.getSize() / i10;
        for (int i13 = 0; i13 < size; i13++) {
            int i14 = 0;
            for (int i15 = 0; i15 < i10; i15++) {
                if (bitArray.get((i13 * i10) + i15)) {
                    i12 = 1 << ((i10 - i15) - 1);
                } else {
                    i12 = 0;
                }
                i14 |= i12;
            }
            iArr[i13] = i14;
        }
        return iArr;
    }

    private static void drawBullsEye(BitMatrix bitMatrix, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12 += 2) {
            int i13 = i10 - i12;
            int i14 = i13;
            while (true) {
                int i15 = i10 + i12;
                if (i14 > i15) {
                    break;
                }
                bitMatrix.set(i14, i13);
                bitMatrix.set(i14, i15);
                bitMatrix.set(i13, i14);
                bitMatrix.set(i15, i14);
                i14++;
            }
        }
        int i16 = i10 - i11;
        bitMatrix.set(i16, i16);
        int i17 = i16 + 1;
        bitMatrix.set(i17, i16);
        bitMatrix.set(i16, i17);
        int i18 = i10 + i11;
        bitMatrix.set(i18, i16);
        bitMatrix.set(i18, i17);
        bitMatrix.set(i18, i18 - 1);
    }

    private static void drawModeMessage(BitMatrix bitMatrix, boolean z10, int i10, BitArray bitArray) {
        int i11 = i10 / 2;
        int i12 = 0;
        if (z10) {
            while (i12 < 7) {
                int i13 = (i11 - 3) + i12;
                if (bitArray.get(i12)) {
                    bitMatrix.set(i13, i11 - 5);
                }
                if (bitArray.get(i12 + 7)) {
                    bitMatrix.set(i11 + 5, i13);
                }
                if (bitArray.get(20 - i12)) {
                    bitMatrix.set(i13, i11 + 5);
                }
                if (bitArray.get(27 - i12)) {
                    bitMatrix.set(i11 - 5, i13);
                }
                i12++;
            }
            return;
        }
        while (i12 < 10) {
            int i14 = (i11 - 5) + i12 + (i12 / 5);
            if (bitArray.get(i12)) {
                bitMatrix.set(i14, i11 - 7);
            }
            if (bitArray.get(i12 + 10)) {
                bitMatrix.set(i11 + 7, i14);
            }
            if (bitArray.get(29 - i12)) {
                bitMatrix.set(i14, i11 + 7);
            }
            if (bitArray.get(39 - i12)) {
                bitMatrix.set(i11 - 7, i14);
            }
            i12++;
        }
    }

    public static AztecCode encode(byte[] bArr) {
        return encode(bArr, 33, 0);
    }

    private static BitArray generateCheckWords(BitArray bitArray, int i10, int i11) {
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i11));
        int i12 = i10 / i11;
        int[] bitsToWords = bitsToWords(bitArray, i11, i12);
        reedSolomonEncoder.encode(bitsToWords, i12 - (bitArray.getSize() / i11));
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, i10 % i11);
        for (int appendBits : bitsToWords) {
            bitArray2.appendBits(appendBits, i11);
        }
        return bitArray2;
    }

    public static BitArray generateModeMessage(boolean z10, int i10, int i11) {
        BitArray bitArray = new BitArray();
        if (z10) {
            bitArray.appendBits(i10 - 1, 2);
            bitArray.appendBits(i11 - 1, 6);
            return generateCheckWords(bitArray, 28, 4);
        }
        bitArray.appendBits(i10 - 1, 5);
        bitArray.appendBits(i11 - 1, 11);
        return generateCheckWords(bitArray, 40, 4);
    }

    private static GenericGF getGF(int i10) {
        if (i10 == 4) {
            return GenericGF.AZTEC_PARAM;
        }
        if (i10 == 6) {
            return GenericGF.AZTEC_DATA_6;
        }
        if (i10 == 8) {
            return GenericGF.AZTEC_DATA_8;
        }
        if (i10 == 10) {
            return GenericGF.AZTEC_DATA_10;
        }
        if (i10 == 12) {
            return GenericGF.AZTEC_DATA_12;
        }
        throw new IllegalArgumentException("Unsupported word size " + i10);
    }

    public static BitArray stuffBits(BitArray bitArray, int i10) {
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i11 = (1 << i10) - 2;
        int i12 = 0;
        while (i12 < size) {
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                int i15 = i12 + i14;
                if (i15 >= size || bitArray.get(i15)) {
                    i13 |= 1 << ((i10 - 1) - i14);
                }
            }
            int i16 = i13 & i11;
            if (i16 == i11) {
                bitArray2.appendBits(i16, i10);
            } else if (i16 == 0) {
                bitArray2.appendBits(i13 | 1, i10);
            } else {
                bitArray2.appendBits(i13, i10);
                i12 += i10;
            }
            i12--;
            i12 += i10;
        }
        return bitArray2;
    }

    private static int totalBitsInLayer(int i10, boolean z10) {
        return ((z10 ? 88 : 112) + (i10 << 4)) * i10;
    }

    public static AztecCode encode(byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        boolean z10;
        BitArray bitArray;
        int i15;
        BitArray encode = new HighLevelEncoder(bArr).encode();
        int i16 = 11;
        int size = ((encode.getSize() * i10) / 100) + 11;
        int size2 = encode.getSize() + size;
        int i17 = 32;
        int i18 = 0;
        int i19 = 1;
        if (i11 != 0) {
            z10 = i11 < 0;
            i13 = Math.abs(i11);
            if (z10) {
                i17 = 4;
            }
            if (i13 <= i17) {
                i14 = totalBitsInLayer(i13, z10);
                i12 = WORD_SIZE[i13];
                int i20 = i14 - (i14 % i12);
                bitArray = stuffBits(encode, i12);
                if (bitArray.getSize() + size > i20) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                } else if (z10 && bitArray.getSize() > (i12 << 6)) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            } else {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", new Object[]{Integer.valueOf(i11)}));
            }
        } else {
            BitArray bitArray2 = null;
            int i21 = 0;
            int i22 = 0;
            while (i21 <= 32) {
                boolean z11 = i21 <= 3;
                int i23 = z11 ? i21 + 1 : i21;
                int i24 = totalBitsInLayer(i23, z11);
                if (size2 <= i24) {
                    int i25 = WORD_SIZE[i23];
                    if (i22 != i25) {
                        bitArray2 = stuffBits(encode, i25);
                    } else {
                        i25 = i22;
                    }
                    int i26 = i24 - (i24 % i25);
                    if ((!z11 || bitArray2.getSize() <= (i25 << 6)) && bitArray2.getSize() + size <= i26) {
                        bitArray = bitArray2;
                        z10 = z11;
                        i13 = i23;
                        i14 = i24;
                        i12 = i25;
                    } else {
                        i22 = i25;
                    }
                }
                i21++;
                i18 = 0;
                i19 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        BitArray generateCheckWords = generateCheckWords(bitArray, i14, i12);
        int size3 = bitArray.getSize() / i12;
        BitArray generateModeMessage = generateModeMessage(z10, i13, size3);
        if (!z10) {
            i16 = 14;
        }
        int i27 = i16 + (i13 << 2);
        int[] iArr = new int[i27];
        int i28 = 2;
        if (z10) {
            for (int i29 = 0; i29 < i27; i29++) {
                iArr[i29] = i29;
            }
            i15 = i27;
        } else {
            int i30 = i27 / 2;
            i15 = i27 + 1 + (((i30 - 1) / 15) * 2);
            int i31 = i15 / 2;
            for (int i32 = 0; i32 < i30; i32++) {
                int i33 = (i32 / 15) + i32;
                iArr[(i30 - i32) - i19] = (i31 - i33) - 1;
                iArr[i30 + i32] = i33 + i31 + i19;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i15);
        int i34 = 0;
        int i35 = 0;
        while (i34 < i13) {
            int i36 = ((i13 - i34) << i28) + (z10 ? 9 : 12);
            int i37 = 0;
            while (i37 < i36) {
                int i38 = i37 << 1;
                while (i18 < i28) {
                    if (generateCheckWords.get(i35 + i38 + i18)) {
                        int i39 = i34 << 1;
                        bitMatrix.set(iArr[i39 + i18], iArr[i39 + i37]);
                    }
                    if (generateCheckWords.get((i36 << 1) + i35 + i38 + i18)) {
                        int i40 = i34 << 1;
                        bitMatrix.set(iArr[i40 + i37], iArr[((i27 - 1) - i40) - i18]);
                    }
                    if (generateCheckWords.get((i36 << 2) + i35 + i38 + i18)) {
                        int i41 = (i27 - 1) - (i34 << 1);
                        bitMatrix.set(iArr[i41 - i18], iArr[i41 - i37]);
                    }
                    if (generateCheckWords.get((i36 * 6) + i35 + i38 + i18)) {
                        int i42 = i34 << 1;
                        bitMatrix.set(iArr[((i27 - 1) - i42) - i37], iArr[i42 + i18]);
                    }
                    i18++;
                    i28 = 2;
                }
                i37++;
                i18 = 0;
                i28 = 2;
            }
            i35 += i36 << 3;
            i34++;
            i18 = 0;
            i28 = 2;
        }
        drawModeMessage(bitMatrix, z10, i15, generateModeMessage);
        if (z10) {
            drawBullsEye(bitMatrix, i15 / 2, 5);
        } else {
            int i43 = i15 / 2;
            drawBullsEye(bitMatrix, i43, 7);
            int i44 = 0;
            int i45 = 0;
            while (i45 < (i27 / 2) - 1) {
                for (int i46 = i43 & 1; i46 < i15; i46 += 2) {
                    int i47 = i43 - i44;
                    bitMatrix.set(i47, i46);
                    int i48 = i43 + i44;
                    bitMatrix.set(i48, i46);
                    bitMatrix.set(i46, i47);
                    bitMatrix.set(i46, i48);
                }
                i45 += 15;
                i44 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z10);
        aztecCode.setSize(i15);
        aztecCode.setLayers(i13);
        aztecCode.setCodeWords(size3);
        aztecCode.setMatrix(bitMatrix);
        return aztecCode;
    }
}
