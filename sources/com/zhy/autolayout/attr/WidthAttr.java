package com.zhy.autolayout.attr;

import android.view.View;

public class WidthAttr extends AutoAttr {
    public WidthAttr(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }

    public static WidthAttr generate(int i10, int i11) {
        WidthAttr widthAttr;
        if (i11 == 1) {
            widthAttr = new WidthAttr(i10, 1, 0);
        } else if (i11 == 2) {
            widthAttr = new WidthAttr(i10, 0, 1);
        } else if (i11 != 3) {
            return null;
        } else {
            widthAttr = new WidthAttr(i10, 0, 0);
        }
        return widthAttr;
    }

    public int attrVal() {
        return 1;
    }

    public boolean defaultBaseWidth() {
        return true;
    }

    public void execute(View view, int i10) {
        view.getLayoutParams().width = i10;
    }
}
