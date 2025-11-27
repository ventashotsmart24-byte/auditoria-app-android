package com.mobile.brasiltv.view.login;

import android.animation.ValueAnimator;

public final /* synthetic */ class u implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f12840a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScrollableImageView f12841b;

    public /* synthetic */ u(int i10, ScrollableImageView scrollableImageView) {
        this.f12840a = i10;
        this.f12841b = scrollableImageView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ScrollableImageView.scheduleScroll$lambda$0(this.f12840a, this.f12841b, valueAnimator);
    }
}
