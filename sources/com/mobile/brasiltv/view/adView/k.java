package com.mobile.brasiltv.view.adView;

import android.view.View;
import com.advertlib.bean.AdInfo;

public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdInfo f12696a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PauseAdView f12697b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12698c;

    public /* synthetic */ k(AdInfo adInfo, PauseAdView pauseAdView, String str) {
        this.f12696a = adInfo;
        this.f12697b = pauseAdView;
        this.f12698c = str;
    }

    public final void onClick(View view) {
        PauseAdView.loadSelfAdOnAdmob$lambda$4(this.f12696a, this.f12697b, this.f12698c, view);
    }
}
