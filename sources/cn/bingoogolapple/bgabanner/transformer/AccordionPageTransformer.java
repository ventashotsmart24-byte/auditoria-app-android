package cn.bingoogolapple.bgabanner.transformer;

import android.view.View;
import b0.c1;

public class AccordionPageTransformer extends BGAPageTransformer {
    public void handleInvisiblePage(View view, float f10) {
    }

    public void handleLeftPage(View view, float f10) {
        c1.A0(view, (float) view.getWidth());
        c1.G0(view, f10 + 1.0f);
    }

    public void handleRightPage(View view, float f10) {
        c1.A0(view, 0.0f);
        c1.G0(view, 1.0f - f10);
        c1.n0(view, 1.0f);
    }
}
