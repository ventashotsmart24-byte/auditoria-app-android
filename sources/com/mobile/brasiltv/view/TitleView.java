package com.mobile.brasiltv.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.R$styleable;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;
import h9.g;
import h9.h;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.i;

public final class TitleView extends AutoFrameLayout {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final g barHeight$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i10;
        i.g(context, f.X);
        i.g(attributeSet, "attrs");
        this.barHeight$delegate = h.b(new TitleView$barHeight$2(context));
        LayoutInflater.from(context).inflate(R.layout.layout_title_view, this, true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.D, 0, 0);
        i.f(obtainStyledAttributes, "context.theme.obtainStyl…tyleable.TitleView, 0, 0)");
        String string = obtainStyledAttributes.getString(3);
        String string2 = obtainStyledAttributes.getString(1);
        Drawable drawable = obtainStyledAttributes.getDrawable(2);
        boolean z10 = obtainStyledAttributes.getBoolean(0, false);
        boolean z11 = obtainStyledAttributes.getBoolean(4, true);
        int i11 = R$id.title;
        ((TextView) _$_findCachedViewById(i11)).setText(string);
        int i12 = R$id.setting;
        ((TextView) _$_findCachedViewById(i12)).setText(string2);
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            ((TextView) _$_findCachedViewById(i12)).setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        DivisionLineView divisionLineView = (DivisionLineView) _$_findCachedViewById(R$id.line);
        int i13 = 8;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        divisionLineView.setVisibility(i10);
        ((TextView) _$_findCachedViewById(i11)).setVisibility(z11 ? 0 : i13);
        ViewGroup.LayoutParams layoutParams = ((AutoRelativeLayout) _$_findCachedViewById(R$id.mLayout)).getLayoutParams();
        i.e(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) layoutParams).setMargins(0, getBarHeight(), 0, 0);
        ((ImageView) _$_findCachedViewById(R$id.atyBack)).setOnClickListener(new f0(context));
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(Context context, View view) {
        i.g(context, "$context");
        ((Activity) context).finish();
    }

    private final int getBarHeight() {
        return ((Number) this.barHeight$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public static final void setIvMenuClickListener$lambda$5(View.OnClickListener onClickListener, View view) {
        i.g(onClickListener, "$listener");
        onClickListener.onClick(view);
    }

    /* access modifiers changed from: private */
    public static final void setOnBackClickListener$lambda$2(View.OnClickListener onClickListener, View view) {
        i.g(onClickListener, "$listener");
        onClickListener.onClick(view);
    }

    /* access modifiers changed from: private */
    public static final void setSettingClickListener$lambda$3(View.OnClickListener onClickListener, View view) {
        i.g(onClickListener, "$listener");
        onClickListener.onClick(view);
    }

    /* access modifiers changed from: private */
    public static final void setTvMenuClickListener$lambda$4(View.OnClickListener onClickListener, View view) {
        i.g(onClickListener, "$listener");
        onClickListener.onClick(view);
    }

    /* access modifiers changed from: private */
    public static final void setXClickListener$lambda$6(View.OnClickListener onClickListener, View view) {
        i.g(onClickListener, "$listener");
        onClickListener.onClick(view);
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

    public final ImageView getIvMenuView() {
        return (ImageView) _$_findCachedViewById(R$id.ivMenu);
    }

    public final String getSettingTitle() {
        return ((TextView) _$_findCachedViewById(R$id.setting)).getText().toString();
    }

    public final TextView getSettingView() {
        return (TextView) _$_findCachedViewById(R$id.setting);
    }

    public final int getTitleVisible() {
        return ((TextView) _$_findCachedViewById(R$id.title)).getVisibility();
    }

    public final TextView getTvMenuView() {
        return (TextView) _$_findCachedViewById(R$id.tvMenu);
    }

    public final void setAtyBackVisible(int i10) {
        ((ImageView) _$_findCachedViewById(R$id.atyBack)).setVisibility(i10);
    }

    public final void setIvMenuClickListener(View.OnClickListener onClickListener) {
        i.g(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ((ImageView) _$_findCachedViewById(R$id.ivMenu)).setOnClickListener(new g0(onClickListener));
    }

    public final void setIvMenuSrc(int i10) {
        ((ImageView) _$_findCachedViewById(R$id.ivMenu)).setImageResource(i10);
    }

    public final void setLayoutBackground(int i10) {
        ((AutoRelativeLayout) _$_findCachedViewById(R$id.mLayout)).setBackgroundResource(i10);
    }

    public final void setOnBackClickListener(View.OnClickListener onClickListener) {
        i.g(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ((ImageView) _$_findCachedViewById(R$id.atyBack)).setOnClickListener(new e0(onClickListener));
    }

    public final void setSettingClickListener(View.OnClickListener onClickListener) {
        i.g(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ((TextView) _$_findCachedViewById(R$id.setting)).setOnClickListener(new j0(onClickListener));
    }

    public final void setSettingColor(int i10) {
        ((TextView) _$_findCachedViewById(R$id.setting)).setTextColor(getResources().getColor(i10));
    }

    public final void setSettingText(String str) {
        i.g(str, "str");
        ((TextView) _$_findCachedViewById(R$id.setting)).setText(str);
    }

    public final void setSettingTextColor(int i10) {
        ((TextView) _$_findCachedViewById(R$id.setting)).setTextColor(i10);
    }

    public final void setTitle(int i10) {
        ((TextView) _$_findCachedViewById(R$id.title)).setText(i10);
    }

    public final void setTitleVisible(int i10) {
        ((TextView) _$_findCachedViewById(R$id.title)).setVisibility(i10);
    }

    public final void setTvMenuClickListener(View.OnClickListener onClickListener) {
        i.g(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ((TextView) _$_findCachedViewById(R$id.tvMenu)).setOnClickListener(new h0(onClickListener));
    }

    public final void setTvMenuText(String str) {
        i.g(str, "str");
        ((TextView) _$_findCachedViewById(R$id.tvMenu)).setText(str);
    }

    public final void setTvMenuTextColor(int i10) {
        ((TextView) _$_findCachedViewById(R$id.tvMenu)).setTextColor(i10);
    }

    public final void setTvMenuTextSize(int i10) {
        ((TextView) _$_findCachedViewById(R$id.tvMenu)).setTextSize(0, (float) AutoUtils.getPercentHeightSize(i10));
    }

    public final void setTvTitleText(String str) {
        i.g(str, "str");
        ((TextView) _$_findCachedViewById(R$id.title)).setText(str);
    }

    public final void setXClickListener(View.OnClickListener onClickListener) {
        i.g(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ((ImageView) _$_findCachedViewById(R$id.mImageX)).setOnClickListener(new i0(onClickListener));
    }

    public final void setXVisible(int i10) {
        ((ImageView) _$_findCachedViewById(R$id.mImageX)).setVisibility(i10);
    }

    public final void setTitle(String str) {
        if (str != null) {
            ((TextView) _$_findCachedViewById(R$id.title)).setText(str);
        }
    }
}
