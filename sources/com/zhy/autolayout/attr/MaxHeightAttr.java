package com.zhy.autolayout.attr;

import android.view.View;

public class MaxHeightAttr extends AutoAttr {
    public MaxHeightAttr(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }

    public static MaxHeightAttr generate(int i10, int i11) {
        MaxHeightAttr maxHeightAttr;
        if (i11 == 1) {
            maxHeightAttr = new MaxHeightAttr(i10, 65536, 0);
        } else if (i11 == 2) {
            maxHeightAttr = new MaxHeightAttr(i10, 0, 65536);
        } else if (i11 != 3) {
            return null;
        } else {
            maxHeightAttr = new MaxHeightAttr(i10, 0, 0);
        }
        return maxHeightAttr;
    }

    public static int getMaxHeight(View view) {
        try {
            return ((Integer) view.getClass().getMethod("getMaxHeight", new Class[0]).invoke(view, new Object[0])).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public int attrVal() {
        return 65536;
    }

    public boolean defaultBaseWidth() {
        return false;
    }

    public void execute(View view, int i10) {
        try {
            view.getClass().getMethod("setMaxHeight", new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(i10)});
        } catch (Exception unused) {
        }
    }
}
