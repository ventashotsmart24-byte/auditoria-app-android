package com.zhy.autolayout.attr;

import android.view.View;

public class PaddingAttr extends AutoAttr {
    public PaddingAttr(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }

    public void apply(View view) {
        if (useDefault()) {
            int percentWidthSize = getPercentWidthSize();
            int percentHeightSize = getPercentHeightSize();
            view.setPadding(percentWidthSize, percentHeightSize, percentWidthSize, percentHeightSize);
            return;
        }
        super.apply(view);
    }

    public int attrVal() {
        return 8;
    }

    public boolean defaultBaseWidth() {
        return false;
    }

    public void execute(View view, int i10) {
        view.setPadding(i10, i10, i10, i10);
    }
}
