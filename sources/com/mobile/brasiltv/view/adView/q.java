package com.mobile.brasiltv.view.adView;

import io.reactivex.functions.Consumer;
import s9.l;

public final /* synthetic */ class q implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f12705a;

    public /* synthetic */ q(l lVar) {
        this.f12705a = lVar;
    }

    public final void accept(Object obj) {
        PlayingAdView.innerScheduleLoadPlayingAd$lambda$2(this.f12705a, obj);
    }
}
