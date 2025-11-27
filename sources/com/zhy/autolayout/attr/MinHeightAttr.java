package com.zhy.autolayout.attr;

import android.view.View;

public class MinHeightAttr extends AutoAttr {
    public MinHeightAttr(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }

    public static MinHeightAttr generate(int i10, int i11) {
        MinHeightAttr minHeightAttr;
        if (i11 == 1) {
            minHeightAttr = new MinHeightAttr(i10, 32768, 0);
        } else if (i11 == 2) {
            minHeightAttr = new MinHeightAttr(i10, 0, 32768);
        } else if (i11 != 3) {
            return null;
        } else {
            minHeightAttr = new MinHeightAttr(i10, 0, 0);
        }
        return minHeightAttr;
    }

    public static int getMinHeight(View view) {
        return view.getMinimumHeight();
    }

    public int attrVal() {
        return 32768;
    }

    public boolean defaultBaseWidth() {
        return false;
    }

    public void execute(View view, int i10) {
        try {
            view.setMinimumHeight(i10);
        } catch (Exception unused) {
        }
    }
}
