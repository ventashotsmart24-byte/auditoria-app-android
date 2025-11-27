package com.mobile.brasiltv.view.adView;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.mobile.brasiltv.R$styleable;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoFrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.i;

public final class AdaptiveAdView extends AutoFrameLayout {
    public Map<Integer, View> _$_findViewCache;
    private String mAdUnitId;
    private AdaptiveAdCallback mListener;

    public interface AdaptiveAdCallback {
        void onAdFailedToLoad();

        void onAdLoaded();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AdaptiveAdView(Context context) {
        this(context, (AttributeSet) null);
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

    public final void destroy() {
        removeAllViews();
    }

    public final void loadAdaptiveAd(AdaptiveAdCallback adaptiveAdCallback) {
        this.mListener = adaptiveAdCallback;
    }

    public final void setAdUnitId(String str) {
        i.g(str, "adUnitId");
        this.mAdUnitId = str;
    }

    public final void setAdaptiveAdCallback(AdaptiveAdCallback adaptiveAdCallback) {
        this.mListener = adaptiveAdCallback;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AdaptiveAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        i.g(context, f.X);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdaptiveAdView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f11932c, i10, i10);
        i.f(obtainStyledAttributes, "context.obtainStyledAttr…View, defStyle, defStyle)");
        this.mAdUnitId = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
    }
}
