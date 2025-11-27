package com.zhy.autolayout.attr;

import android.view.View;

public class PaddingLeftAttr extends AutoAttr {
    public PaddingLeftAttr(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }

    public static PaddingLeftAttr generate(int i10, int i11) {
        PaddingLeftAttr paddingLeftAttr;
        if (i11 == 1) {
            paddingLeftAttr = new PaddingLeftAttr(i10, 512, 0);
        } else if (i11 == 2) {
            paddingLeftAttr = new PaddingLeftAttr(i10, 0, 512);
        } else if (i11 != 3) {
            return null;
        } else {
            paddingLeftAttr = new PaddingLeftAttr(i10, 0, 0);
        }
        return paddingLeftAttr;
    }

    public int attrVal() {
        return 512;
    }

    public boolean defaultBaseWidth() {
        return true;
    }

    public void execute(View view, int i10) {
        view.setPadding(i10, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }
}
