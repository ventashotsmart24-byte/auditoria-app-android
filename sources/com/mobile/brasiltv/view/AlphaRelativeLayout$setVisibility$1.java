package com.mobile.brasiltv.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import t9.i;

public final class AlphaRelativeLayout$setVisibility$1 extends AnimatorListenerAdapter {
    final /* synthetic */ AlphaRelativeLayout this$0;

    public AlphaRelativeLayout$setVisibility$1(AlphaRelativeLayout alphaRelativeLayout) {
        this.this$0 = alphaRelativeLayout;
    }

    public void onAnimationEnd(Animator animator) {
        i.g(animator, "animation");
        this.this$0.hide();
    }
}
