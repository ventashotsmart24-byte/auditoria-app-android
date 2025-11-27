package com.google.zxing.oned.rss;

import com.google.zxing.ResultPoint;

public final class FinderPattern {
    private final ResultPoint[] resultPoints;
    private final int[] startEnd;
    private final int value;

    public FinderPattern(int i10, int[] iArr, int i11, int i12, int i13) {
        this.value = i10;
        this.startEnd = iArr;
        float f10 = (float) i13;
        this.resultPoints = new ResultPoint[]{new ResultPoint((float) i11, f10), new ResultPoint((float) i12, f10)};
    }

    public boolean equals(Object obj) {
        if ((obj instanceof FinderPattern) && this.value == ((FinderPattern) obj).value) {
            return true;
        }
        return false;
    }

    public ResultPoint[] getResultPoints() {
        return this.resultPoints;
    }

    public int[] getStartEnd() {
        return this.startEnd;
    }

    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }
}
