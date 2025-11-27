package com.zhy.autolayout.attr;

import android.view.View;
import android.view.ViewGroup;

public class MarginAttr extends AutoAttr {
    public MarginAttr(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }

    public void apply(View view) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            if (useDefault()) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int percentWidthSize = getPercentWidthSize();
                marginLayoutParams.rightMargin = percentWidthSize;
                marginLayoutParams.leftMargin = percentWidthSize;
                int percentHeightSize = getPercentHeightSize();
                marginLayoutParams.bottomMargin = percentHeightSize;
                marginLayoutParams.topMargin = percentHeightSize;
                return;
            }
            super.apply(view);
        }
    }

    public int attrVal() {
        return 16;
    }

    public boolean defaultBaseWidth() {
        return false;
    }

    public void execute(View view, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.bottomMargin = i10;
        marginLayoutParams.topMargin = i10;
        marginLayoutParams.rightMargin = i10;
        marginLayoutParams.leftMargin = i10;
    }
}
