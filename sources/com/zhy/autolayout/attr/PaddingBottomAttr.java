package com.zhy.autolayout.attr;

import android.view.View;

public class PaddingBottomAttr extends AutoAttr {
    public PaddingBottomAttr(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }

    public static PaddingBottomAttr generate(int i10, int i11) {
        PaddingBottomAttr paddingBottomAttr;
        if (i11 == 1) {
            paddingBottomAttr = new PaddingBottomAttr(i10, 4096, 0);
        } else if (i11 == 2) {
            paddingBottomAttr = new PaddingBottomAttr(i10, 0, 4096);
        } else if (i11 != 3) {
            return null;
        } else {
            paddingBottomAttr = new PaddingBottomAttr(i10, 0, 0);
        }
        return paddingBottomAttr;
    }

    public int attrVal() {
        return 4096;
    }

    public boolean defaultBaseWidth() {
        return false;
    }

    public void execute(View view, int i10) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i10);
    }
}
