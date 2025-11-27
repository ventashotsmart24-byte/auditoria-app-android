package com.mobile.brasiltv.view.adView;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.utils.r0;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.umeng.analytics.pro.f;
import d6.b;
import h9.g;
import h9.h;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import s1.m;
import s1.q;
import s9.a;
import s9.p;
import t9.i;
import w6.i;

public final class PauseAdView extends LinearLayout {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private boolean isCr;
    private final g mAdLandUnitId$delegate;
    private final g mAdPortUnitId$delegate;
    private a mDetachAdCallback;
    private p mLayoutAdCallback;
    /* access modifiers changed from: private */
    public Disposable reportDelayedSubp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PauseAdView(Context context, boolean z10) {
        super(context);
        i.g(context, f.X);
        this.isCr = z10;
        this.mAdPortUnitId$delegate = h.b(new PauseAdView$mAdPortUnitId$2(context));
        this.mAdLandUnitId$delegate = h.b(new PauseAdView$mAdLandUnitId$2(context));
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.layout_pause_ad_view, this, true);
        addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this) {
            final /* synthetic */ PauseAdView this$0;

            {
                this.this$0 = r1;
            }

            public void onViewAttachedToWindow(View view) {
                i.g(view, "v");
                this.this$0.showAdvert();
            }

            public void onViewDetachedFromWindow(View view) {
                i.g(view, "v");
                this.this$0.removeAdvert();
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mIvOwnerAdClose)).setOnClickListener(new m(this));
        ((ImageView) _$_findCachedViewById(R$id.mIvLandClose)).setOnClickListener(new n(this));
        ((ImageView) _$_findCachedViewById(R$id.mIvPortClose)).setOnClickListener(new o(this));
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(PauseAdView pauseAdView, View view) {
        i.g(pauseAdView, "this$0");
        pauseAdView.closeSelfAd();
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$1(PauseAdView pauseAdView, View view) {
        i.g(pauseAdView, "this$0");
        pauseAdView.closeAdmobAd();
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$2(PauseAdView pauseAdView, View view) {
        i.g(pauseAdView, "this$0");
        pauseAdView.closeAdmobAd();
    }

    /* access modifiers changed from: private */
    public final void adjustSelfAdOnAdmob() {
        int i10 = R$id.mIvOwnerAd2;
        ViewGroup.LayoutParams layoutParams = ((ImageView) _$_findCachedViewById(i10)).getLayoutParams();
        if (getResources().getConfiguration().orientation == 1) {
            controlAdmobRefWidget(false, true);
            layoutParams.width = j1.a(getContext(), 120);
            layoutParams.height = j1.a(getContext(), 100);
            i1.e(getContext(), "EVENT_AD_SELF_SHOW_PAUSE_ON_PORT");
        } else {
            controlAdmobRefWidget(true, false);
            layoutParams.width = j1.a(getContext(), 228);
            layoutParams.height = j1.a(getContext(), 190);
            i1.e(getContext(), "EVENT_AD_SELF_SHOW_PAUSE_ON_LAND");
        }
        ((ImageView) _$_findCachedViewById(i10)).setLayoutParams(layoutParams);
    }

    private final void closeAdmobAd() {
        int i10 = R$id.mFlAdmob;
        if (((FrameLayout) _$_findCachedViewById(i10)).getVisibility() == 8 && ((FrameLayout) _$_findCachedViewById(R$id.mFlOwner)).getVisibility() == 8) {
            ViewParent parent = getParent();
            i.e(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this);
            return;
        }
        ((FrameLayout) _$_findCachedViewById(i10)).setVisibility(8);
        controlAdmobRefWidget(true, true);
    }

    private final void closeSelfAd() {
        if (((FrameLayout) _$_findCachedViewById(R$id.mFlAdmob)).getVisibility() == 8 && ((FrameLayout) _$_findCachedViewById(R$id.mFlOwner)).getVisibility() == 8) {
            ViewParent parent = getParent();
            i.e(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this);
        } else {
            ((FrameLayout) _$_findCachedViewById(R$id.mFlOwner)).setVisibility(8);
        }
        stopDelayedReport();
    }

    private final void controlAdmobRefWidget(boolean z10, boolean z11) {
        if (z10) {
            ((TextView) _$_findCachedViewById(R$id.mTvPortFlag)).setVisibility(8);
            ((ImageView) _$_findCachedViewById(R$id.mIvPortClose)).setVisibility(8);
        } else {
            ((TextView) _$_findCachedViewById(R$id.mTvPortFlag)).setVisibility(0);
            ((ImageView) _$_findCachedViewById(R$id.mIvPortClose)).setVisibility(0);
        }
        if (z11) {
            ((TextView) _$_findCachedViewById(R$id.mTvLandFlag)).setVisibility(8);
            ((ImageView) _$_findCachedViewById(R$id.mIvLandClose)).setVisibility(8);
            return;
        }
        ((TextView) _$_findCachedViewById(R$id.mTvLandFlag)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(R$id.mIvLandClose)).setVisibility(0);
    }

    private final String getMAdLandUnitId() {
        return (String) this.mAdLandUnitId$delegate.getValue();
    }

    private final String getMAdPortUnitId() {
        return (String) this.mAdPortUnitId$delegate.getValue();
    }

    private final void loadAdMob() {
        b0.U(this, "第一个暂停广告位，加载谷歌广告...");
    }

    private final void loadFirstAd() {
        String str;
        if (getResources().getConfiguration().orientation == 1) {
            str = a6.a.f10646a.m();
        } else {
            str = a6.a.f10646a.l();
        }
        m mVar = m.f9270a;
        Context context = getContext();
        i.f(context, f.X);
        i.c cVar = w6.i.f9510g;
        AdInfo H = mVar.H(context, str, "picture", cVar.I(), true, cVar.r());
        if (H == null) {
            loadAdMob();
        } else {
            loadSelfAdOnAdmob(str, H);
        }
    }

    private final void loadSelfAd() {
        m mVar = m.f9270a;
        Context context = getContext();
        t9.i.f(context, f.X);
        a6.a aVar = a6.a.f10646a;
        String k10 = aVar.k();
        i.c cVar = w6.i.f9510g;
        AdInfo H = mVar.H(context, k10, "picture", cVar.I(), true, cVar.r());
        if (H != null) {
            Context context2 = getContext();
            ImageView imageView = (ImageView) _$_findCachedViewById(R$id.mIvOwnerAd);
            String k11 = aVar.k();
            t9.i.f(context2, f.X);
            t9.i.f(imageView, "mIvOwnerAd");
            m.h0(mVar, context2, imageView, k11, H, (Integer) null, new PauseAdView$loadSelfAd$1(H, this), -2147483648, false, 0, 400, (Object) null);
            ((FrameLayout) _$_findCachedViewById(R$id.mFlOwner)).setOnClickListener(new l(H, this));
        }
    }

    /* access modifiers changed from: private */
    public static final void loadSelfAd$lambda$3(AdInfo adInfo, PauseAdView pauseAdView, View view) {
        t9.i.g(pauseAdView, "this$0");
        if (t9.i.b(adInfo.getAction_type(), "1") && !TextUtils.isEmpty(adInfo.getAction())) {
            String b10 = r0.f12611a.b(adInfo.getAction(), pauseAdView.isCr);
            Context context = pauseAdView.getContext();
            t9.i.f(context, f.X);
            b0.j0(context, b10, false, true, false, false, 24, (Object) null);
            i1.e(pauseAdView.getContext(), "EVENT_AD_CLICK_PAUSE");
            q qVar = q.f9311a;
            Context context2 = pauseAdView.getContext();
            t9.i.f(context2, f.X);
            b bVar = b.f6366a;
            Context context3 = pauseAdView.getContext();
            t9.i.f(context3, f.X);
            qVar.h(context2, bVar.m(context3), a6.a.f10646a.k(), adInfo);
        } else if (t9.i.b(adInfo.getAction_type(), CdnType.DIGITAL_TYPE_PCDN)) {
            Context context4 = pauseAdView.getContext();
            t9.i.f(context4, f.X);
            b0.m(context4);
        }
    }

    private final void loadSelfAdOnAdmob(String str, AdInfo adInfo) {
        b0.U(this, "第一个暂停广告位，加载自有广告...");
        m mVar = m.f9270a;
        Context context = getContext();
        ImageView imageView = (ImageView) _$_findCachedViewById(R$id.mIvOwnerAd2);
        t9.i.f(context, f.X);
        t9.i.f(imageView, "mIvOwnerAd2");
        m.h0(mVar, context, imageView, str, adInfo, (Integer) null, new PauseAdView$loadSelfAdOnAdmob$1(this, adInfo, str), Integer.MIN_VALUE, false, 0, 400, (Object) null);
        ((FrameLayout) _$_findCachedViewById(R$id.mFlAdmob)).setOnClickListener(new k(adInfo, this, str));
    }

    /* access modifiers changed from: private */
    public static final void loadSelfAdOnAdmob$lambda$4(AdInfo adInfo, PauseAdView pauseAdView, String str, View view) {
        t9.i.g(adInfo, "$adInfo");
        t9.i.g(pauseAdView, "this$0");
        t9.i.g(str, "$adtype");
        if (t9.i.b(adInfo.getAction_type(), "1") && !TextUtils.isEmpty(adInfo.getAction())) {
            String b10 = r0.f12611a.b(adInfo.getAction(), pauseAdView.isCr);
            Context context = pauseAdView.getContext();
            t9.i.f(context, f.X);
            b0.j0(context, b10, false, true, false, false, 24, (Object) null);
            q qVar = q.f9311a;
            Context context2 = pauseAdView.getContext();
            t9.i.f(context2, f.X);
            b bVar = b.f6366a;
            Context context3 = pauseAdView.getContext();
            t9.i.f(context3, f.X);
            qVar.h(context2, bVar.m(context3), str, adInfo);
            if (pauseAdView.getResources().getConfiguration().orientation == 1) {
                i1.e(pauseAdView.getContext(), "EVENT_AD_SELF_CLICK_PAUSE_ON_PORT");
            } else {
                i1.e(pauseAdView.getContext(), "EVENT_AD_SELF_CLICK_PAUSE_ON_LAND");
            }
        } else if (t9.i.b(adInfo.getAction_type(), CdnType.DIGITAL_TYPE_PCDN)) {
            Context context4 = pauseAdView.getContext();
            t9.i.f(context4, f.X);
            b0.m(context4);
        }
    }

    /* access modifiers changed from: private */
    public final void removeAdvert() {
        ((FrameLayout) _$_findCachedViewById(R$id.mFlAdmob)).setVisibility(8);
        ((ImageView) _$_findCachedViewById(R$id.mIvOwnerAd2)).setVisibility(8);
        controlAdmobRefWidget(true, true);
        ((FrameLayout) _$_findCachedViewById(R$id.mFlOwner)).setVisibility(8);
        stopDelayedReport();
    }

    /* access modifiers changed from: private */
    public final void showAdvert() {
        removeAdvert();
        loadFirstAd();
        if (getResources().getConfiguration().orientation != 1) {
            loadSelfAd();
        }
    }

    private final void stopDelayedReport() {
        boolean z10;
        Disposable disposable;
        Disposable disposable2 = this.reportDelayedSubp;
        if (disposable2 != null) {
            z10 = disposable2.isDisposed();
        } else {
            z10 = true;
        }
        if (!z10 && (disposable = this.reportDelayedSubp) != null) {
            disposable.dispose();
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

    public final boolean isCr() {
        return this.isCr;
    }

    public void onConfigurationChanged(Configuration configuration) {
        t9.i.g(configuration, "newConfig");
        showAdvert();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.mDetachAdCallback;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        p pVar = this.mLayoutAdCallback;
        if (pVar != null) {
            pVar.invoke(Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
        }
    }

    public final void setCr(boolean z10) {
        this.isCr = z10;
    }

    public final void setDetachAdCallback(a aVar) {
        t9.i.g(aVar, "callback");
        this.mDetachAdCallback = aVar;
    }

    public final void setLayoutAdCallback(p pVar) {
        t9.i.g(pVar, "callback");
        this.mLayoutAdCallback = pVar;
    }
}
