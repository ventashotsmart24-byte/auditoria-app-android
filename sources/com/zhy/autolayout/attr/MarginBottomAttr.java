package com.zhy.autolayout.attr;

import android.view.View;
import android.view.ViewGroup;

public class MarginBottomAttr extends AutoAttr {
    public MarginBottomAttr(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }

    public static MarginBottomAttr generate(int i10, int i11) {
        MarginBottomAttr marginBottomAttr;
        if (i11 == 1) {
            marginBottomAttr = new MarginBottomAttr(i10, 256, 0);
        } else if (i11 == 2) {
            marginBottomAttr = new MarginBottomAttr(i10, 0, 256);
        } else if (i11 != 3) {
            return null;
        } else {
            marginBottomAttr = new MarginBottomAttr(i10, 0, 0);
        }
        return marginBottomAttr;
    }

    public int attrVal() {
        return 256;
    }

    public boolean defaultBaseWidth() {
        return false;
    }

    public void execute(View view, int i10) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin = i10;
        }
    }
}
