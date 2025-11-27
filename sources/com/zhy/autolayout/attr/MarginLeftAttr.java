package com.zhy.autolayout.attr;

import android.view.View;
import android.view.ViewGroup;

public class MarginLeftAttr extends AutoAttr {
    public MarginLeftAttr(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }

    public static MarginLeftAttr generate(int i10, int i11) {
        MarginLeftAttr marginLeftAttr;
        if (i11 == 1) {
            marginLeftAttr = new MarginLeftAttr(i10, 32, 0);
        } else if (i11 == 2) {
            marginLeftAttr = new MarginLeftAttr(i10, 0, 32);
        } else if (i11 != 3) {
            return null;
        } else {
            marginLeftAttr = new MarginLeftAttr(i10, 0, 0);
        }
        return marginLeftAttr;
    }

    public int attrVal() {
        return 32;
    }

    public boolean defaultBaseWidth() {
        return true;
    }

    public void execute(View view, int i10) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin = i10;
        }
    }
}
