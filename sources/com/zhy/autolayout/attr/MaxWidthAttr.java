package com.zhy.autolayout.attr;

import android.view.View;

public class MaxWidthAttr extends AutoAttr {
    public MaxWidthAttr(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }

    public static MaxWidthAttr generate(int i10, int i11) {
        MaxWidthAttr maxWidthAttr;
        if (i11 == 1) {
            maxWidthAttr = new MaxWidthAttr(i10, 16384, 0);
        } else if (i11 == 2) {
            maxWidthAttr = new MaxWidthAttr(i10, 0, 16384);
        } else if (i11 != 3) {
            return null;
        } else {
            maxWidthAttr = new MaxWidthAttr(i10, 0, 0);
        }
        return maxWidthAttr;
    }

    public static int getMaxWidth(View view) {
        try {
            return ((Integer) view.getClass().getMethod("getMaxWidth", new Class[0]).invoke(view, new Object[0])).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public int attrVal() {
        return 16384;
    }

    public boolean defaultBaseWidth() {
        return true;
    }

    public void execute(View view, int i10) {
        try {
            view.getClass().getMethod("setMaxWidth", new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(i10)});
        } catch (Exception unused) {
        }
    }
}
