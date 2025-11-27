package com.google.android.material.shape;

public class CutCornerTreatment extends CornerTreatment {
    float size;

    public CutCornerTreatment() {
        this.size = -1.0f;
    }

    public void getCornerPath(ShapePath shapePath, float f10, float f11, float f12) {
        shapePath.reset(0.0f, f12 * f11, 180.0f, 180.0f - f10);
        double sin = Math.sin(Math.toRadians((double) f10));
        double d10 = (double) f12;
        Double.isNaN(d10);
        double d11 = (double) f11;
        Double.isNaN(d11);
        double sin2 = Math.sin(Math.toRadians((double) (90.0f - f10)));
        Double.isNaN(d10);
        Double.isNaN(d11);
        shapePath.lineTo((float) (sin * d10 * d11), (float) (sin2 * d10 * d11));
    }

    @Deprecated
    public CutCornerTreatment(float f10) {
        this.size = f10;
    }
}
