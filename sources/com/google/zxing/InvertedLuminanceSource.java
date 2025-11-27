package com.google.zxing;

import com.google.common.primitives.UnsignedBytes;

public final class InvertedLuminanceSource extends LuminanceSource {
    private final LuminanceSource delegate;

    public InvertedLuminanceSource(LuminanceSource luminanceSource) {
        super(luminanceSource.getWidth(), luminanceSource.getHeight());
        this.delegate = luminanceSource;
    }

    public LuminanceSource crop(int i10, int i11, int i12, int i13) {
        return new InvertedLuminanceSource(this.delegate.crop(i10, i11, i12, i13));
    }

    public byte[] getMatrix() {
        byte[] matrix = this.delegate.getMatrix();
        int width = getWidth() * getHeight();
        byte[] bArr = new byte[width];
        for (int i10 = 0; i10 < width; i10++) {
            bArr[i10] = (byte) (255 - (matrix[i10] & UnsignedBytes.MAX_VALUE));
        }
        return bArr;
    }

    public byte[] getRow(int i10, byte[] bArr) {
        byte[] row = this.delegate.getRow(i10, bArr);
        int width = getWidth();
        for (int i11 = 0; i11 < width; i11++) {
            row[i11] = (byte) (255 - (row[i11] & UnsignedBytes.MAX_VALUE));
        }
        return row;
    }

    public LuminanceSource invert() {
        return this.delegate;
    }

    public boolean isCropSupported() {
        return this.delegate.isCropSupported();
    }

    public boolean isRotateSupported() {
        return this.delegate.isRotateSupported();
    }

    public LuminanceSource rotateCounterClockwise() {
        return new InvertedLuminanceSource(this.delegate.rotateCounterClockwise());
    }

    public LuminanceSource rotateCounterClockwise45() {
        return new InvertedLuminanceSource(this.delegate.rotateCounterClockwise45());
    }
}
