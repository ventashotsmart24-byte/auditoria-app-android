package com.mobile.brasiltv.view.adView;

import android.view.View;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdaptiveAdContainer f12683a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f12684b;

    public /* synthetic */ a(AdaptiveAdContainer adaptiveAdContainer, boolean z10) {
        this.f12683a = adaptiveAdContainer;
        this.f12684b = z10;
    }

    public final void onClick(View view) {
        AdaptiveAdContainer.showOwnAdView$lambda$0(this.f12683a, this.f12684b, view);
    }
}
