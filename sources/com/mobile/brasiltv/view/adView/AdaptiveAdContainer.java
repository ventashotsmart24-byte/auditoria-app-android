package com.mobile.brasiltv.view.adView;

import a6.a;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.view.adView.AdaptiveAdView;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoFrameLayout;
import d6.b;
import g5.f3;
import java.util.LinkedHashMap;
import java.util.Map;
import s1.m;
import s1.q;
import t9.g;
import t9.i;
import w6.i;

public final class AdaptiveAdContainer extends AutoFrameLayout implements IAdView {
    public Map<Integer, View> _$_findViewCache;
    /* access modifiers changed from: private */
    public AdaptiveAdView.AdaptiveAdCallback mListener;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AdaptiveAdContainer(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
        i.g(context, f.X);
    }

    public static /* synthetic */ void hideView$default(AdaptiveAdContainer adaptiveAdContainer, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        adaptiveAdContainer.hideView(z10);
    }

    public static /* synthetic */ void loadAd$default(AdaptiveAdContainer adaptiveAdContainer, f3 f3Var, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        adaptiveAdContainer.loadAd(f3Var, z10);
    }

    /* access modifiers changed from: private */
    public final void reportEvent(boolean z10) {
        int i10 = R$id.mIvAd;
        String adType = ((AdvertImageView) _$_findCachedViewById(i10)).getAdType();
        if (adType == null) {
            adType = "";
        }
        if (!i.b(adType, a.f10646a.f())) {
            return;
        }
        if (z10) {
            i1.e(getContext(), "EVENT_AD_SELF_CLICK_MOVIE_ON_FREE");
            q qVar = q.f9311a;
            Context context = getContext();
            i.f(context, f.X);
            b bVar = b.f6366a;
            Context context2 = getContext();
            i.f(context2, f.X);
            qVar.h(context, bVar.m(context2), adType, ((AdvertImageView) _$_findCachedViewById(i10)).getAdInfo());
            return;
        }
        i1.e(getContext(), "EVENT_AD_SELF_SHOW_MOVIE_ON_FREE");
    }

    private final void showGoogleAdView(boolean z10, String str) {
        int i10 = R$id.mAavSmartAd;
        ((AdaptiveAdView) _$_findCachedViewById(i10)).destroy();
        if (z10) {
            ((AdaptiveAdView) _$_findCachedViewById(i10)).setVisibility(0);
            ((AdaptiveAdView) _$_findCachedViewById(i10)).setAdUnitId(str);
            ((AdaptiveAdView) _$_findCachedViewById(i10)).setAdaptiveAdCallback(this.mListener);
            ((AdaptiveAdView) _$_findCachedViewById(i10)).loadAdaptiveAd((AdaptiveAdView.AdaptiveAdCallback) null);
            return;
        }
        ((AdaptiveAdView) _$_findCachedViewById(i10)).setVisibility(8);
    }

    private final void showOwnAdView(boolean z10, boolean z11) {
        int i10;
        int i11 = R$id.mIvAd;
        AdvertImageView advertImageView = (AdvertImageView) _$_findCachedViewById(i11);
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        advertImageView.setVisibility(i10);
        ((TextView) _$_findCachedViewById(R$id.mTvFlag)).setVisibility(8);
        if (z10) {
            ((AdvertImageView) _$_findCachedViewById(i11)).setShowAdListener(new AdaptiveAdContainer$showOwnAdView$1(this));
            ((AdvertImageView) _$_findCachedViewById(i11)).setOnClickListener(new a(this, z11));
        }
    }

    /* access modifiers changed from: private */
    public static final void showOwnAdView$lambda$0(AdaptiveAdContainer adaptiveAdContainer, boolean z10, View view) {
        String str;
        boolean z11;
        i.g(adaptiveAdContainer, "this$0");
        AdInfo adInfo = ((AdvertImageView) adaptiveAdContainer._$_findCachedViewById(R$id.mIvAd)).getAdInfo();
        if (adInfo != null) {
            String action = adInfo.getAction();
            if (action == null || action.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11 && i.b(adInfo.getAction_type(), "1")) {
                adaptiveAdContainer.reportEvent(true);
                a aVar = a.f10646a;
                Context context = adaptiveAdContainer.getContext();
                i.f(context, f.X);
                aVar.t(context, adInfo.getAction(), z10);
                return;
            }
        }
        if (adInfo != null) {
            str = adInfo.getAction_type();
        } else {
            str = null;
        }
        if (i.b(str, CdnType.DIGITAL_TYPE_PCDN)) {
            Context context2 = adaptiveAdContainer.getContext();
            i.f(context2, f.X);
            b0.m(context2);
        }
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

    public final void hideView(boolean z10) {
        showGoogleAdView(false, "");
        showOwnAdView(false, z10);
    }

    public void hostVisibilityChange(boolean z10, boolean z11) {
        ((AdvertImageView) _$_findCachedViewById(R$id.mIvAd)).hostVisibilityChange(z10, z11);
    }

    public final void loadAd(f3 f3Var, boolean z10) {
        i.g(f3Var, "data");
        m mVar = m.f9270a;
        Context context = getContext();
        i.f(context, f.X);
        String a10 = f3Var.a();
        i.c cVar = w6.i.f9510g;
        if (b0.I(mVar.A(context, a10, cVar.I(), f3Var.c(), cVar.r()))) {
            ((AdvertImageView) _$_findCachedViewById(R$id.mIvAd)).setAdtype(f3Var.a(), f3Var.c());
            showGoogleAdView(false, "");
            showOwnAdView(true, z10);
            return;
        }
        AdvertImageView advertImageView = (AdvertImageView) _$_findCachedViewById(R$id.mIvAd);
        t9.i.f(advertImageView, "mIvAd");
        AdvertImageView.setAdtype$default(advertImageView, (String) null, false, 2, (Object) null);
        showGoogleAdView(true, f3Var.b());
        showOwnAdView(false, z10);
    }

    public final void setAdaptiveAdCallback(AdaptiveAdView.AdaptiveAdCallback adaptiveAdCallback) {
        this.mListener = adaptiveAdCallback;
    }

    public final void setKeep(boolean z10) {
        ((AdvertImageView) _$_findCachedViewById(R$id.mIvAd)).setKeep(z10);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AdaptiveAdContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
        t9.i.g(context, f.X);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdaptiveAdContainer(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        LayoutInflater.from(context).inflate(R.layout.layout_adaptive_container, this, true);
        hideView$default(this, false, 1, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdaptiveAdContainer(Context context, AttributeSet attributeSet, int i10, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
