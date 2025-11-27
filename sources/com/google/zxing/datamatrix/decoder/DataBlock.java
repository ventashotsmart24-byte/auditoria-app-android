package com.google.zxing.datamatrix.decoder;

import com.google.zxing.datamatrix.decoder.Version;

final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i10, byte[] bArr) {
        this.numDataCodewords = i10;
        this.codewords = bArr;
    }

    public static DataBlock[] getDataBlocks(byte[] bArr, Version version) {
        boolean z10;
        int i10;
        int i11;
        int i12;
        Version.ECBlocks eCBlocks = version.getECBlocks();
        Version.ECB[] eCBlocks2 = eCBlocks.getECBlocks();
        int i13 = 0;
        for (Version.ECB count : eCBlocks2) {
            i13 += count.getCount();
        }
        DataBlock[] dataBlockArr = new DataBlock[i13];
        int i14 = 0;
        for (Version.ECB ecb : eCBlocks2) {
            int i15 = 0;
            while (i15 < ecb.getCount()) {
                int dataCodewords = ecb.getDataCodewords();
                dataBlockArr[i14] = new DataBlock(dataCodewords, new byte[(eCBlocks.getECCodewords() + dataCodewords)]);
                i15++;
                i14++;
            }
        }
        int length = dataBlockArr[0].codewords.length - eCBlocks.getECCodewords();
        int i16 = length - 1;
        int i17 = 0;
        for (int i18 = 0; i18 < i16; i18++) {
            int i19 = 0;
            while (i19 < i14) {
                dataBlockArr[i19].codewords[i18] = bArr[i17];
                i19++;
                i17++;
            }
        }
        if (version.getVersionNumber() == 24) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i10 = 8;
        } else {
            i10 = i14;
        }
        int i20 = 0;
        while (i20 < i10) {
            dataBlockArr[i20].codewords[i16] = bArr[i17];
            i20++;
            i17++;
        }
        int length2 = dataBlockArr[0].codewords.length;
        while (length < length2) {
            int i21 = 0;
            while (i21 < i14) {
                if (z10) {
                    i11 = (i21 + 8) % i14;
                } else {
                    i11 = i21;
                }
                if (!z10 || i11 <= 7) {
                    i12 = length;
                } else {
                    i12 = length - 1;
                }
                dataBlockArr[i11].codewords[i12] = bArr[i17];
                i21++;
                i17++;
            }
            length++;
        }
        if (i17 == bArr.length) {
            return dataBlockArr;
        }
        throw new IllegalArgumentException();
    }

    public byte[] getCodewords() {
        return this.codewords;
    }

    public int getNumDataCodewords() {
        return this.numDataCodewords;
    }
}
