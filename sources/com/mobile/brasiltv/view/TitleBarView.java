package com.mobile.brasiltv.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.R$styleable;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoFrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import n5.a;
import t9.g;
import t9.i;

public final class TitleBarView extends AutoFrameLayout {
    public Map<Integer, View> _$_findViewCache;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TitleBarView(Context context) {
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

    public final void isShowClose(boolean z10) {
        int i10;
        ImageView imageView = (ImageView) _$_findCachedViewById(R$id.mIvClose);
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        imageView.setVisibility(i10);
    }

    public final void setBackVisibility(int i10) {
        ((ImageView) _$_findCachedViewById(R$id.mIvBack)).setVisibility(i10);
    }

    public final void setMenuVisibility(int i10) {
        ((ImageView) _$_findCachedViewById(R$id.mIvMenu)).setVisibility(i10);
    }

    public final void setOnBackClickListener(View.OnClickListener onClickListener) {
        ((ImageView) _$_findCachedViewById(R$id.mIvBack)).setOnClickListener(onClickListener);
    }

    public final void setOnCloseClickListener(View.OnClickListener onClickListener) {
        ((ImageView) _$_findCachedViewById(R$id.mIvClose)).setOnClickListener(onClickListener);
    }

    public final void setOnMenuClickListener(View.OnClickListener onClickListener) {
        ((ImageView) _$_findCachedViewById(R$id.mIvMenu)).setOnClickListener(onClickListener);
    }

    public final void setTitleBarBgColor(int i10) {
        setBackgroundColor(i10);
    }

    public final void setTitleText(String str) {
        i.g(str, "title");
        ((TextView) _$_findCachedViewById(R$id.mTvTitle)).setText(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TitleBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
        i.g(context, f.X);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TitleBarView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        LayoutInflater.from(context).inflate(R.layout.layout_title_bar_view, this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.C, i10, 0);
        i.f(obtainStyledAttributes, "context.obtainStyledAttr…BarView, defStyleAttr, 0)");
        int color = obtainStyledAttributes.getColor(2, 0);
        if (color != 0) {
            setTitleBarBgColor(color);
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId != 0) {
            ((ImageView) _$_findCachedViewById(R$id.mIvBack)).setImageResource(resourceId);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(3, 0);
        if (resourceId2 != 0) {
            int i11 = R$id.mIvClose;
            ((ImageView) _$_findCachedViewById(i11)).setVisibility(0);
            ((ImageView) _$_findCachedViewById(i11)).setImageResource(resourceId2);
        }
        String string = obtainStyledAttributes.getString(5);
        string = string == null ? "" : string;
        int i12 = R$id.mTvTitle;
        ((TextView) _$_findCachedViewById(i12)).setText(string);
        ((TextView) _$_findCachedViewById(i12)).setTextColor(obtainStyledAttributes.getColor(6, 0));
        int resourceId3 = obtainStyledAttributes.getResourceId(4, 0);
        if (resourceId3 != 0) {
            ((ImageView) _$_findCachedViewById(R$id.mIvMenu)).setImageResource(resourceId3);
        }
        if (obtainStyledAttributes.getBoolean(0, true)) {
            ViewGroup.LayoutParams layoutParams = ((AutoFrameLayout) _$_findCachedViewById(R$id.mAflTitleWrapper)).getLayoutParams();
            i.e(layoutParams, "null cannot be cast to non-null type com.zhy.autolayout.AutoFrameLayout.LayoutParams");
            ((AutoFrameLayout.LayoutParams) layoutParams).setMargins(0, a.f8310a.a(context), 0, 0);
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TitleBarView(Context context, AttributeSet attributeSet, int i10, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
