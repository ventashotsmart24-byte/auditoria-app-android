package com.mobile.brasiltv.view.adView;

import a6.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.R$styleable;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.view.AutoCardView;
import com.mobile.brasiltv.view.adView.SmallAdNativeView;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoFrameLayout;
import d6.b;
import g5.e1;
import java.util.LinkedHashMap;
import java.util.Map;
import s1.m;
import s1.q;
import t9.g;
import t9.i;
import w6.i;

public final class SmallAdNativeContainer extends AutoFrameLayout implements IAdView {
    public Map<Integer, View> _$_findViewCache;
    private boolean isShowIdenti;
    /* access modifiers changed from: private */
    public SmallAdNativeView.NativeAdCallback mCallback;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SmallAdNativeContainer(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
        i.g(context, f.X);
    }

    public static /* synthetic */ void hideView$default(SmallAdNativeContainer smallAdNativeContainer, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        smallAdNativeContainer.hideView(z10);
    }

    public static /* synthetic */ void loadAd$default(SmallAdNativeContainer smallAdNativeContainer, e1 e1Var, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        smallAdNativeContainer.loadAd(e1Var, z10);
    }

    public static /* synthetic */ void loadOwn$default(SmallAdNativeContainer smallAdNativeContainer, e1 e1Var, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        smallAdNativeContainer.loadOwn(e1Var, z10);
    }

    /* access modifiers changed from: private */
    public final void reportEvent(boolean z10) {
        int i10 = R$id.mIvAd;
        String adType = ((AdvertImageView) _$_findCachedViewById(i10)).getAdType();
        if (adType == null) {
            adType = "";
        }
        if (z10) {
            q qVar = q.f9311a;
            Context context = getContext();
            i.f(context, f.X);
            b bVar = b.f6366a;
            Context context2 = getContext();
            i.f(context2, f.X);
            qVar.h(context, bVar.m(context2), adType, ((AdvertImageView) _$_findCachedViewById(i10)).getAdInfo());
        }
        a aVar = a.f10646a;
        if (i.b(adType, aVar.c())) {
            if (z10) {
                i1.e(getContext(), "EVENT_AD_SELF_CLICK_MOVIE");
            } else {
                i1.e(getContext(), "EVENT_AD_SELF_SHOW_MOVIE");
            }
        } else if (i.b(adType, aVar.g())) {
            if (z10) {
                i1.e(getContext(), "EVENT_AD_SELF_CLICK_BL");
            } else {
                i1.e(getContext(), "EVENT_AD_SELF_SHOW_BL");
            }
        } else if (!i.b(adType, aVar.r())) {
        } else {
            if (z10) {
                i1.e(getContext(), "EVENT_AD_SELF_CLICK_VOD_DETAIL");
            } else {
                i1.e(getContext(), "EVENT_AD_SELF_SHOW_VOD_DETAIL");
            }
        }
    }

    private final void showGoogleAdView(boolean z10, String str) {
        int i10 = R$id.mSanvNativeAd;
        ((SmallAdNativeView) _$_findCachedViewById(i10)).destroy();
        if (z10) {
            ((SmallAdNativeView) _$_findCachedViewById(i10)).setVisibility(0);
            ((SmallAdNativeView) _$_findCachedViewById(i10)).setAdUnitId(str);
            ((SmallAdNativeView) _$_findCachedViewById(i10)).isShowIdenti(this.isShowIdenti);
            if (this.mCallback != null) {
                SmallAdNativeView.NativeAdCallback nativeAdCallback = this.mCallback;
                i.d(nativeAdCallback);
                ((SmallAdNativeView) _$_findCachedViewById(i10)).setNativeAdCallback(nativeAdCallback);
            }
            ((SmallAdNativeView) _$_findCachedViewById(i10)).loadNativeAd();
            return;
        }
        ((SmallAdNativeView) _$_findCachedViewById(i10)).setVisibility(8);
    }

    private final void showOwnAdView(boolean z10, boolean z11) {
        int i10;
        int i11 = R$id.mIvAd;
        AdvertImageView advertImageView = (AdvertImageView) _$_findCachedViewById(i11);
        int i12 = 0;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        advertImageView.setVisibility(i10);
        AutoCardView autoCardView = (AutoCardView) _$_findCachedViewById(R$id.autoCardView);
        if (!z10) {
            i12 = 8;
        }
        autoCardView.setVisibility(i12);
        ((TextView) _$_findCachedViewById(R$id.mTvFlag)).setVisibility(8);
        if (z10) {
            ((AdvertImageView) _$_findCachedViewById(i11)).setShowAdListener(new SmallAdNativeContainer$showOwnAdView$1(this));
            ((AdvertImageView) _$_findCachedViewById(i11)).setOnClickListener(new s(this, z11));
        }
    }

    /* access modifiers changed from: private */
    public static final void showOwnAdView$lambda$0(SmallAdNativeContainer smallAdNativeContainer, boolean z10, View view) {
        String str;
        boolean z11;
        i.g(smallAdNativeContainer, "this$0");
        AdInfo adInfo = ((AdvertImageView) smallAdNativeContainer._$_findCachedViewById(R$id.mIvAd)).getAdInfo();
        if (adInfo != null) {
            String action = adInfo.getAction();
            if (action == null || action.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11 && i.b(adInfo.getAction_type(), "1")) {
                a aVar = a.f10646a;
                Context context = smallAdNativeContainer.getContext();
                i.f(context, f.X);
                aVar.t(context, adInfo.getAction(), z10);
                smallAdNativeContainer.reportEvent(true);
                return;
            }
        }
        if (adInfo != null) {
            str = adInfo.getAction_type();
        } else {
            str = null;
        }
        if (i.b(str, CdnType.DIGITAL_TYPE_PCDN)) {
            Context context2 = smallAdNativeContainer.getContext();
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

    public final void loadAd(e1 e1Var, boolean z10) {
        String str;
        i.g(e1Var, "data");
        m mVar = m.f9270a;
        Context context = getContext();
        i.f(context, f.X);
        String b10 = e1Var.b();
        if (b10 == null) {
            str = "";
        } else {
            str = b10;
        }
        i.c cVar = w6.i.f9510g;
        if (b0.I(mVar.A(context, str, cVar.I(), e1Var.d(), cVar.r()))) {
            ((AdvertImageView) _$_findCachedViewById(R$id.mIvAd)).setAdtype(e1Var.b(), e1Var.d());
            showGoogleAdView(false, "");
            showOwnAdView(true, z10);
            return;
        }
        AdvertImageView advertImageView = (AdvertImageView) _$_findCachedViewById(R$id.mIvAd);
        t9.i.f(advertImageView, "mIvAd");
        AdvertImageView.setAdtype$default(advertImageView, (String) null, false, 2, (Object) null);
        showGoogleAdView(true, e1Var.c());
        showOwnAdView(false, z10);
    }

    public final void loadOwn(e1 e1Var, boolean z10) {
        t9.i.g(e1Var, "data");
        ((AdvertImageView) _$_findCachedViewById(R$id.mIvAd)).setAdtype(e1Var.b(), e1Var.d());
        showGoogleAdView(false, "");
        m mVar = m.f9270a;
        Context context = getContext();
        t9.i.f(context, f.X);
        String b10 = e1Var.b();
        if (b10 == null) {
            b10 = "";
        }
        i.c cVar = w6.i.f9510g;
        if (b0.I(mVar.A(context, b10, cVar.I(), e1Var.d(), cVar.r()))) {
            showOwnAdView(true, z10);
        } else {
            showOwnAdView(false, z10);
        }
    }

    public final void setKeep(boolean z10) {
        ((AdvertImageView) _$_findCachedViewById(R$id.mIvAd)).setKeep(z10);
    }

    public final void setNativeAdCallback(SmallAdNativeView.NativeAdCallback nativeAdCallback) {
        t9.i.g(nativeAdCallback, "callback");
        this.mCallback = nativeAdCallback;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SmallAdNativeContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
        t9.i.g(context, f.X);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmallAdNativeContainer(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f11953x);
            t9.i.f(obtainStyledAttributes, "context.obtainStyledAttr…e.SmallAdNativeContainer)");
            this.isShowIdenti = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        LayoutInflater.from(context).inflate(R.layout.layout_small_native_container, this, true);
        hideView$default(this, false, 1, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SmallAdNativeContainer(Context context, AttributeSet attributeSet, int i10, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
