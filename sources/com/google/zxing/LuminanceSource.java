package com.google.zxing;

import com.google.common.primitives.UnsignedBytes;

public abstract class LuminanceSource {
    private final int height;
    private final int width;

    public LuminanceSource(int i10, int i11) {
        this.width = i10;
        this.height = i11;
    }

    public LuminanceSource crop(int i10, int i11, int i12, int i13) {
        throw new UnsupportedOperationException("This luminance source does not support cropping.");
    }

    public final int getHeight() {
        return this.height;
    }

    public abstract byte[] getMatrix();

    public abstract byte[] getRow(int i10, byte[] bArr);

    public final int getWidth() {
        return this.width;
    }

    public LuminanceSource invert() {
        return new InvertedLuminanceSource(this);
    }

    public boolean isCropSupported() {
        return false;
    }

    public boolean isRotateSupported() {
        return false;
    }

    public LuminanceSource rotateCounterClockwise() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public LuminanceSource rotateCounterClockwise45() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }

    public final String toString() {
        char c10;
        int i10 = this.width;
        byte[] bArr = new byte[i10];
        StringBuilder sb = new StringBuilder(this.height * (i10 + 1));
        for (int i11 = 0; i11 < this.height; i11++) {
            bArr = getRow(i11, bArr);
            for (int i12 = 0; i12 < this.width; i12++) {
                byte b10 = bArr[i12] & UnsignedBytes.MAX_VALUE;
                if (b10 < 64) {
                    c10 = '#';
                } else if (b10 < 128) {
                    c10 = '+';
                } else if (b10 < 192) {
                    c10 = '.';
                } else {
                    c10 = ' ';
                }
                sb.append(c10);
            }
            sb.append(10);
        }
        return sb.toString();
    }
}
