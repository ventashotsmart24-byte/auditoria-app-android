package cn.bingoogolapple.bgabanner.transformer;

import android.view.View;
import b0.c1;

public class ZoomFadePageTransformer extends BGAPageTransformer {
    public void handleInvisiblePage(View view, float f10) {
    }

    public void handleLeftPage(View view, float f10) {
        c1.K0(view, ((float) (-view.getWidth())) * f10);
        c1.A0(view, ((float) view.getWidth()) * 0.5f);
        c1.B0(view, ((float) view.getHeight()) * 0.5f);
        float f11 = f10 + 1.0f;
        c1.G0(view, f11);
        c1.H0(view, f11);
        c1.n0(view, f11);
    }

    public void handleRightPage(View view, float f10) {
        c1.K0(view, ((float) (-view.getWidth())) * f10);
        c1.A0(view, ((float) view.getWidth()) * 0.5f);
        c1.B0(view, ((float) view.getHeight()) * 0.5f);
        float f11 = 1.0f - f10;
        c1.G0(view, f11);
        c1.H0(view, f11);
        c1.n0(view, f11);
    }
}
