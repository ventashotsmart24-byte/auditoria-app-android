package com.zhy.autolayout.attr;

import android.view.View;
import android.view.ViewGroup;

public class MarginRightAttr extends AutoAttr {
    public MarginRightAttr(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }

    public static MarginRightAttr generate(int i10, int i11) {
        MarginRightAttr marginRightAttr;
        if (i11 == 1) {
            marginRightAttr = new MarginRightAttr(i10, 128, 0);
        } else if (i11 == 2) {
            marginRightAttr = new MarginRightAttr(i10, 0, 128);
        } else if (i11 != 3) {
            return null;
        } else {
            marginRightAttr = new MarginRightAttr(i10, 0, 0);
        }
        return marginRightAttr;
    }

    public int attrVal() {
        return 128;
    }

    public boolean defaultBaseWidth() {
        return true;
    }

    public void execute(View view, int i10) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).rightMargin = i10;
        }
    }
}
