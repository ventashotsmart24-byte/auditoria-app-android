package com.zhy.autolayout.attr;

import android.view.View;
import anet.channel.entity.ConnType;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.zhy.autolayout.utils.AutoUtils;
import com.zhy.autolayout.utils.L;

public abstract class AutoAttr {
    public static final int BASE_DEFAULT = 3;
    public static final int BASE_HEIGHT = 2;
    public static final int BASE_WIDTH = 1;
    protected int baseHeight;
    protected int baseWidth;
    protected int pxVal;

    public AutoAttr(int i10, int i11, int i12) {
        this.pxVal = i10;
        this.baseWidth = i11;
        this.baseHeight = i12;
    }

    public void apply(View view) {
        boolean z10;
        int i10;
        if (view.getTag() == null || !view.getTag().toString().equals(ConnType.PK_AUTO)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            L.e(" pxVal = " + this.pxVal + " ," + getClass().getSimpleName());
        }
        if (useDefault()) {
            if (defaultBaseWidth()) {
                i10 = getPercentWidthSize();
            } else {
                i10 = getPercentHeightSize();
            }
            if (z10) {
                L.e(" useDefault val= " + i10);
            }
        } else if (baseWidth()) {
            i10 = getPercentWidthSize();
            if (z10) {
                L.e(" baseWidth val= " + i10);
            }
        } else {
            i10 = getPercentHeightSize();
            if (z10) {
                L.e(" baseHeight val= " + i10);
            }
        }
        if (i10 > 0) {
            i10 = Math.max(i10, 1);
        }
        execute(view, i10);
    }

    public abstract int attrVal();

    public boolean baseWidth() {
        return contains(this.baseWidth, attrVal());
    }

    public boolean contains(int i10, int i11) {
        return (i10 & i11) != 0;
    }

    public abstract boolean defaultBaseWidth();

    public abstract void execute(View view, int i10);

    public int getPercentHeightSize() {
        return AutoUtils.getPercentHeightSizeBigger(this.pxVal);
    }

    public int getPercentWidthSize() {
        return AutoUtils.getPercentWidthSizeBigger(this.pxVal);
    }

    public String toString() {
        return "AutoAttr{pxVal=" + this.pxVal + ", baseWidth=" + baseWidth() + ", defaultBaseWidth=" + defaultBaseWidth() + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }

    public boolean useDefault() {
        if (contains(this.baseHeight, attrVal()) || contains(this.baseWidth, attrVal())) {
            return false;
        }
        return true;
    }
}
