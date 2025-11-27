package com.google.zxing;

import com.google.zxing.common.detector.MathUtils;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

public class ResultPoint {

    /* renamed from: x  reason: collision with root package name */
    private final float f10402x;

    /* renamed from: y  reason: collision with root package name */
    private final float f10403y;

    public ResultPoint(float f10, float f11) {
        this.f10402x = f10;
        this.f10403y = f11;
    }

    private static float crossProductZ(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        float f10 = resultPoint2.f10402x;
        float f11 = resultPoint2.f10403y;
        return ((resultPoint3.f10402x - f10) * (resultPoint.f10403y - f11)) - ((resultPoint3.f10403y - f11) * (resultPoint.f10402x - f10));
    }

    public static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.f10402x, resultPoint.f10403y, resultPoint2.f10402x, resultPoint2.f10403y);
    }

    public static void orderBestPatterns(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        float distance = distance(resultPointArr[0], resultPointArr[1]);
        float distance2 = distance(resultPointArr[1], resultPointArr[2]);
        float distance3 = distance(resultPointArr[0], resultPointArr[2]);
        if (distance2 >= distance && distance2 >= distance3) {
            resultPoint3 = resultPointArr[0];
            resultPoint2 = resultPointArr[1];
            resultPoint = resultPointArr[2];
        } else if (distance3 < distance2 || distance3 < distance) {
            resultPoint3 = resultPointArr[2];
            resultPoint2 = resultPointArr[0];
            resultPoint = resultPointArr[1];
        } else {
            resultPoint3 = resultPointArr[1];
            resultPoint2 = resultPointArr[0];
            resultPoint = resultPointArr[2];
        }
        if (crossProductZ(resultPoint2, resultPoint3, resultPoint) < 0.0f) {
            ResultPoint resultPoint4 = resultPoint;
            resultPoint = resultPoint2;
            resultPoint2 = resultPoint4;
        }
        resultPointArr[0] = resultPoint2;
        resultPointArr[1] = resultPoint3;
        resultPointArr[2] = resultPoint;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ResultPoint) {
            ResultPoint resultPoint = (ResultPoint) obj;
            if (this.f10402x == resultPoint.f10402x && this.f10403y == resultPoint.f10403y) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final float getX() {
        return this.f10402x;
    }

    public final float getY() {
        return this.f10403y;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f10402x) * 31) + Float.floatToIntBits(this.f10403y);
    }

    public final String toString() {
        return "(" + this.f10402x + ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN + this.f10403y + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
