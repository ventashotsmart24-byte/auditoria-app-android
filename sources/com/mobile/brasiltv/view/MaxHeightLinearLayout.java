package com.mobile.brasiltv.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.mobile.brasiltv.R$styleable;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.g;
import t9.i;

public final class MaxHeightLinearLayout extends AutoLinearLayout {
    public Map<Integer, View> _$_findViewCache;
    private int mMaxHeight;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaxHeightLinearLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
        i.g(context, f.X);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i10) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i11);
        int mode = View.MeasureSpec.getMode(i11);
        int i12 = this.mMaxHeight;
        if (i12 <= 0 || size <= i12 || mode == 1073741824) {
            super.onMeasure(i10, i11);
        } else {
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(i12, mode));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaxHeightLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
        i.g(context, f.X);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MaxHeightLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.mMaxHeight = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f11942m);
            i.f(obtainStyledAttributes, "context.obtainStyledAttr…le.MaxHeightLinearLayout)");
            int dimension = (int) obtainStyledAttributes.getDimension(0, -1.0f);
            this.mMaxHeight = dimension;
            if (dimension > 0) {
                this.mMaxHeight = AutoUtils.getPercentHeightSize(dimension);
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MaxHeightLinearLayout(Context context, AttributeSet attributeSet, int i10, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
