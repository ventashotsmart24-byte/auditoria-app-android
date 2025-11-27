package com.mobile.brasiltv.view.adView;

import android.view.View;

public final /* synthetic */ class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SmallAdNativeContainer f12707a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f12708b;

    public /* synthetic */ s(SmallAdNativeContainer smallAdNativeContainer, boolean z10) {
        this.f12707a = smallAdNativeContainer;
        this.f12708b = z10;
    }

    public final void onClick(View view) {
        SmallAdNativeContainer.showOwnAdView$lambda$0(this.f12707a, this.f12708b, view);
    }
}
