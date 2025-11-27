package com.zhy.autolayout.attr;

import android.view.View;
import android.widget.TextView;

public class TextSizeAttr extends AutoAttr {
    public TextSizeAttr(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }

    public static TextSizeAttr generate(int i10, int i11) {
        TextSizeAttr textSizeAttr;
        if (i11 == 1) {
            textSizeAttr = new TextSizeAttr(i10, 4, 0);
        } else if (i11 == 2) {
            textSizeAttr = new TextSizeAttr(i10, 0, 4);
        } else if (i11 != 3) {
            return null;
        } else {
            textSizeAttr = new TextSizeAttr(i10, 0, 0);
        }
        return textSizeAttr;
    }

    public int attrVal() {
        return 4;
    }

    public boolean defaultBaseWidth() {
        return false;
    }

    public void execute(View view, int i10) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setIncludeFontPadding(false);
            textView.setTextSize(0, (float) i10);
        }
    }
}
