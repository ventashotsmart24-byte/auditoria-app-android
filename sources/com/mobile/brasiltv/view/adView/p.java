package com.mobile.brasiltv.view.adView;

import io.reactivex.functions.Consumer;
import s9.l;

public final /* synthetic */ class p implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f12704a;

    public /* synthetic */ p(l lVar) {
        this.f12704a = lVar;
    }

    public final void accept(Object obj) {
        PlayingAdView.innerScheduleLoadPlayingAd$lambda$1(this.f12704a, obj);
    }
}
