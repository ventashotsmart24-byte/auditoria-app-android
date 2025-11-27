package com.mobile.brasiltv.view.adView;

import android.view.View;
import com.advertlib.bean.AdInfo;

public final /* synthetic */ class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdInfo f12699a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PauseAdView f12700b;

    public /* synthetic */ l(AdInfo adInfo, PauseAdView pauseAdView) {
        this.f12699a = adInfo;
        this.f12700b = pauseAdView;
    }

    public final void onClick(View view) {
        PauseAdView.loadSelfAd$lambda$3(this.f12699a, this.f12700b, view);
    }
}
