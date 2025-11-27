package cn.bingoogolapple.bgabanner.transformer;

import android.view.View;
import b0.c1;

public class FlipPageTransformer extends BGAPageTransformer {
    private static final float ROTATION = 180.0f;

    public void handleInvisiblePage(View view, float f10) {
    }

    public void handleLeftPage(View view, float f10) {
        c1.K0(view, ((float) (-view.getWidth())) * f10);
        c1.F0(view, ROTATION * f10);
        if (((double) f10) > -0.5d) {
            view.setVisibility(0);
        } else {
            view.setVisibility(4);
        }
    }

    public void handleRightPage(View view, float f10) {
        c1.K0(view, ((float) (-view.getWidth())) * f10);
        c1.F0(view, ROTATION * f10);
        if (((double) f10) < 0.5d) {
            view.setVisibility(0);
        } else {
            view.setVisibility(4);
        }
    }
}
