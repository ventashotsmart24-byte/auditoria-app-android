package cn.bingoogolapple.bgabanner.transformer;

import android.view.View;
import b0.c1;

public class ZoomPageTransformer extends BGAPageTransformer {
    private float mMinAlpha = 0.65f;
    private float mMinScale = 0.85f;

    public ZoomPageTransformer() {
    }

    public void handleInvisiblePage(View view, float f10) {
        c1.n0(view, 0.0f);
    }

    public void handleLeftPage(View view, float f10) {
        float max = Math.max(this.mMinScale, f10 + 1.0f);
        float f11 = 1.0f - max;
        c1.K0(view, ((((float) view.getWidth()) * f11) / 2.0f) - (((((float) view.getHeight()) * f11) / 2.0f) / 2.0f));
        c1.G0(view, max);
        c1.H0(view, max);
        float f12 = this.mMinAlpha;
        float f13 = this.mMinScale;
        c1.n0(view, f12 + (((max - f13) / (1.0f - f13)) * (1.0f - f12)));
    }

    public void handleRightPage(View view, float f10) {
        float max = Math.max(this.mMinScale, 1.0f - f10);
        float f11 = 1.0f - max;
        c1.K0(view, (-((((float) view.getWidth()) * f11) / 2.0f)) + (((((float) view.getHeight()) * f11) / 2.0f) / 2.0f));
        c1.G0(view, max);
        c1.H0(view, max);
        float f12 = this.mMinAlpha;
        float f13 = this.mMinScale;
        c1.n0(view, f12 + (((max - f13) / (1.0f - f13)) * (1.0f - f12)));
    }

    public void setMinAlpha(float f10) {
        if (f10 >= 0.6f && f10 <= 1.0f) {
            this.mMinAlpha = f10;
        }
    }

    public void setMinScale(float f10) {
        if (f10 >= 0.6f && f10 <= 1.0f) {
            this.mMinScale = f10;
        }
    }

    public ZoomPageTransformer(float f10, float f11) {
        setMinAlpha(f10);
        setMinScale(f11);
    }
}
