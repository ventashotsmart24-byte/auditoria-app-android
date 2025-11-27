package com.google.zxing.common;

import com.google.common.primitives.UnsignedBytes;

public final class BitSource {
    private int bitOffset;
    private int byteOffset;
    private final byte[] bytes;

    public BitSource(byte[] bArr) {
        this.bytes = bArr;
    }

    public int available() {
        return ((this.bytes.length - this.byteOffset) * 8) - this.bitOffset;
    }

    public int getBitOffset() {
        return this.bitOffset;
    }

    public int getByteOffset() {
        return this.byteOffset;
    }

    public int readBits(int i10) {
        int i11;
        if (i10 <= 0 || i10 > 32 || i10 > available()) {
            throw new IllegalArgumentException(String.valueOf(i10));
        }
        int i12 = this.bitOffset;
        byte b10 = 0;
        if (i12 > 0) {
            int i13 = 8 - i12;
            if (i10 < i13) {
                i11 = i10;
            } else {
                i11 = i13;
            }
            int i14 = i13 - i11;
            byte[] bArr = this.bytes;
            int i15 = this.byteOffset;
            int i16 = (((255 >> (8 - i11)) << i14) & bArr[i15]) >> i14;
            i10 -= i11;
            int i17 = i12 + i11;
            this.bitOffset = i17;
            if (i17 == 8) {
                this.bitOffset = 0;
                this.byteOffset = i15 + 1;
            }
            b10 = i16;
        }
        if (i10 <= 0) {
            return b10;
        }
        while (i10 >= 8) {
            int i18 = b10 << 8;
            byte[] bArr2 = this.bytes;
            int i19 = this.byteOffset;
            b10 = (bArr2[i19] & UnsignedBytes.MAX_VALUE) | i18;
            this.byteOffset = i19 + 1;
            i10 -= 8;
        }
        if (i10 <= 0) {
            return b10;
        }
        int i20 = 8 - i10;
        int i21 = (b10 << i10) | ((((255 >> i20) << i20) & this.bytes[this.byteOffset]) >> i20);
        this.bitOffset += i10;
        return i21;
    }
}
