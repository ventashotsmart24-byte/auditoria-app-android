package com.mobile.brasiltv.view;

import android.animation.ValueAnimator;

public final /* synthetic */ class e implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AutoText f12785a;

    public /* synthetic */ e(AutoText autoText) {
        this.f12785a = autoText;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AutoText.launchScrollAnim$lambda$2(this.f12785a, valueAnimator);
    }
}
