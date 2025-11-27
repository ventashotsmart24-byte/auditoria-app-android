package com.google.android.material.bottomappbar;

import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private float cradleVerticalOffset;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f10, float f11, float f12) {
        this.fabMargin = f10;
        this.roundedCornerRadius = f11;
        this.cradleVerticalOffset = f12;
        if (f12 >= 0.0f) {
            this.horizontalOffset = 0.0f;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    public void getEdgePath(float f10, float f11, float f12, ShapePath shapePath) {
        float f13 = f10;
        ShapePath shapePath2 = shapePath;
        float f14 = this.fabDiameter;
        if (f14 == 0.0f) {
            shapePath2.lineTo(f13, 0.0f);
            return;
        }
        float f15 = ((this.fabMargin * 2.0f) + f14) / 2.0f;
        float f16 = f12 * this.roundedCornerRadius;
        float f17 = f11 + this.horizontalOffset;
        float f18 = (this.cradleVerticalOffset * f12) + ((1.0f - f12) * f15);
        if (f18 / f15 >= 1.0f) {
            shapePath2.lineTo(f13, 0.0f);
            return;
        }
        float f19 = f15 + f16;
        float f20 = f18 + f16;
        float sqrt = (float) Math.sqrt((double) ((f19 * f19) - (f20 * f20)));
        float f21 = f17 - sqrt;
        float f22 = f17 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan((double) (sqrt / f20)));
        float f23 = 90.0f - degrees;
        shapePath2.lineTo(f21, 0.0f);
        float f24 = f16 * 2.0f;
        float f25 = degrees;
        shapePath.addArc(f21 - f16, 0.0f, f21 + f16, f24, 270.0f, degrees);
        shapePath.addArc(f17 - f15, (-f15) - f18, f17 + f15, f15 - f18, 180.0f - f23, (f23 * 2.0f) - 180.0f);
        shapePath.addArc(f22 - f16, 0.0f, f22 + f16, f24, 270.0f - f25, f25);
        shapePath2.lineTo(f13, 0.0f);
    }

    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    public float getFabDiameter() {
        return this.fabDiameter;
    }

    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    public void setCradleVerticalOffset(float f10) {
        this.cradleVerticalOffset = f10;
    }

    public void setFabCradleMargin(float f10) {
        this.fabMargin = f10;
    }

    public void setFabCradleRoundedCornerRadius(float f10) {
        this.roundedCornerRadius = f10;
    }

    public void setFabDiameter(float f10) {
        this.fabDiameter = f10;
    }

    public void setHorizontalOffset(float f10) {
        this.horizontalOffset = f10;
    }
}
