package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

final class BitMatrixParser {
    private final BitMatrix bitMatrix;
    private boolean mirror;
    private FormatInformation parsedFormatInfo;
    private Version parsedVersion;

    public BitMatrixParser(BitMatrix bitMatrix2) {
        int height = bitMatrix2.getHeight();
        if (height < 21 || (height & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.bitMatrix = bitMatrix2;
    }

    private int copyBit(int i10, int i11, int i12) {
        boolean z10;
        if (this.mirror) {
            z10 = this.bitMatrix.get(i11, i10);
        } else {
            z10 = this.bitMatrix.get(i10, i11);
        }
        if (z10) {
            return (i12 << 1) | 1;
        }
        return i12 << 1;
    }

    public void mirror() {
        int i10 = 0;
        while (i10 < this.bitMatrix.getWidth()) {
            int i11 = i10 + 1;
            for (int i12 = i11; i12 < this.bitMatrix.getHeight(); i12++) {
                if (this.bitMatrix.get(i10, i12) != this.bitMatrix.get(i12, i10)) {
                    this.bitMatrix.flip(i12, i10);
                    this.bitMatrix.flip(i10, i12);
                }
            }
            i10 = i11;
        }
    }

    public byte[] readCodewords() {
        int i10;
        FormatInformation readFormatInformation = readFormatInformation();
        Version readVersion = readVersion();
        DataMask dataMask = DataMask.values()[readFormatInformation.getDataMask()];
        int height = this.bitMatrix.getHeight();
        dataMask.unmaskBitMatrix(this.bitMatrix, height);
        BitMatrix buildFunctionPattern = readVersion.buildFunctionPattern();
        byte[] bArr = new byte[readVersion.getTotalCodewords()];
        int i11 = height - 1;
        boolean z10 = true;
        int i12 = i11;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i12 > 0) {
            if (i12 == 6) {
                i12--;
            }
            for (int i16 = 0; i16 < height; i16++) {
                if (z10) {
                    i10 = i11 - i16;
                } else {
                    i10 = i16;
                }
                for (int i17 = 0; i17 < 2; i17++) {
                    int i18 = i12 - i17;
                    if (!buildFunctionPattern.get(i18, i10)) {
                        i14++;
                        i15 <<= 1;
                        if (this.bitMatrix.get(i18, i10)) {
                            i15 |= 1;
                        }
                        if (i14 == 8) {
                            bArr[i13] = (byte) i15;
                            i13++;
                            i14 = 0;
                            i15 = 0;
                        }
                    }
                }
            }
            z10 = !z10;
            i12 -= 2;
        }
        if (i13 == readVersion.getTotalCodewords()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    public FormatInformation readFormatInformation() {
        FormatInformation formatInformation = this.parsedFormatInfo;
        if (formatInformation != null) {
            return formatInformation;
        }
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < 6; i12++) {
            i11 = copyBit(i12, 8, i11);
        }
        int copyBit = copyBit(8, 7, copyBit(8, 8, copyBit(7, 8, i11)));
        for (int i13 = 5; i13 >= 0; i13--) {
            copyBit = copyBit(8, i13, copyBit);
        }
        int height = this.bitMatrix.getHeight();
        int i14 = height - 7;
        for (int i15 = height - 1; i15 >= i14; i15--) {
            i10 = copyBit(8, i15, i10);
        }
        for (int i16 = height - 8; i16 < height; i16++) {
            i10 = copyBit(i16, 8, i10);
        }
        FormatInformation decodeFormatInformation = FormatInformation.decodeFormatInformation(copyBit, i10);
        this.parsedFormatInfo = decodeFormatInformation;
        if (decodeFormatInformation != null) {
            return decodeFormatInformation;
        }
        throw FormatException.getFormatInstance();
    }

    public Version readVersion() {
        Version version = this.parsedVersion;
        if (version != null) {
            return version;
        }
        int height = this.bitMatrix.getHeight();
        int i10 = (height - 17) / 4;
        if (i10 <= 6) {
            return Version.getVersionForNumber(i10);
        }
        int i11 = height - 11;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 5; i14 >= 0; i14--) {
            for (int i15 = height - 9; i15 >= i11; i15--) {
                i13 = copyBit(i15, i14, i13);
            }
        }
        Version decodeVersionInformation = Version.decodeVersionInformation(i13);
        if (decodeVersionInformation == null || decodeVersionInformation.getDimensionForVersion() != height) {
            for (int i16 = 5; i16 >= 0; i16--) {
                for (int i17 = height - 9; i17 >= i11; i17--) {
                    i12 = copyBit(i16, i17, i12);
                }
            }
            Version decodeVersionInformation2 = Version.decodeVersionInformation(i12);
            if (decodeVersionInformation2 == null || decodeVersionInformation2.getDimensionForVersion() != height) {
                throw FormatException.getFormatInstance();
            }
            this.parsedVersion = decodeVersionInformation2;
            return decodeVersionInformation2;
        }
        this.parsedVersion = decodeVersionInformation;
        return decodeVersionInformation;
    }

    public void remask() {
        if (this.parsedFormatInfo != null) {
            DataMask.values()[this.parsedFormatInfo.getDataMask()].unmaskBitMatrix(this.bitMatrix, this.bitMatrix.getHeight());
        }
    }

    public void setMirror(boolean z10) {
        this.parsedVersion = null;
        this.parsedFormatInfo = null;
        this.mirror = z10;
    }
}
