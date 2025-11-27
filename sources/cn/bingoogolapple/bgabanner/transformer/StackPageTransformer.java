package cn.bingoogolapple.bgabanner.transformer;

import android.view.View;
import b0.c1;

public class StackPageTransformer extends BGAPageTransformer {
    public void handleInvisiblePage(View view, float f10) {
    }

    public void handleLeftPage(View view, float f10) {
    }

    public void handleRightPage(View view, float f10) {
        c1.K0(view, ((float) (-view.getWidth())) * f10);
    }
}
