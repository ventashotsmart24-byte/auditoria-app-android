package cn.bingoogolapple.bgabanner.transformer;

import android.view.View;
import b0.c1;

public class RotatePageTransformer extends BGAPageTransformer {
    private float mMaxRotation = 15.0f;

    public RotatePageTransformer() {
    }

    public void handleInvisiblePage(View view, float f10) {
        c1.A0(view, ((float) view.getMeasuredWidth()) * 0.5f);
        c1.B0(view, (float) view.getMeasuredHeight());
        c1.D0(view, 0.0f);
    }

    public void handleLeftPage(View view, float f10) {
        float f11 = this.mMaxRotation * f10;
        c1.A0(view, ((float) view.getMeasuredWidth()) * 0.5f);
        c1.B0(view, (float) view.getMeasuredHeight());
        c1.D0(view, f11);
    }

    public void handleRightPage(View view, float f10) {
        handleLeftPage(view, f10);
    }

    public void setMaxRotation(float f10) {
        if (f10 >= 0.0f && f10 <= 40.0f) {
            this.mMaxRotation = f10;
        }
    }

    public RotatePageTransformer(float f10) {
        setMaxRotation(f10);
    }
}
