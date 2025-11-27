package com.zhy.autolayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.app.d;

public class AutoLayoutActivity extends d {
    private static final String LAYOUT_FRAMELAYOUT = "FrameLayout";
    private static final String LAYOUT_LINEARLAYOUT = "LinearLayout";
    private static final String LAYOUT_RELATIVELAYOUT = "RelativeLayout";

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View view;
        if (str.equals(LAYOUT_FRAMELAYOUT)) {
            view = new AutoFrameLayout(context, attributeSet);
        } else {
            view = null;
        }
        if (str.equals(LAYOUT_LINEARLAYOUT)) {
            view = new AutoLinearLayout(context, attributeSet);
        }
        if (str.equals(LAYOUT_RELATIVELAYOUT)) {
            view = new AutoRelativeLayout(context, attributeSet);
        }
        if (view != null) {
            return view;
        }
        return super.onCreateView(str, context, attributeSet);
    }
}
