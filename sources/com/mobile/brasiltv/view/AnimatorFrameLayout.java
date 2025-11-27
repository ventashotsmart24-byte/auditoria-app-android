package com.mobile.brasiltv.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import com.mobile.brasiltv.view.KoocanRecyclerView;
import com.zhy.autolayout.AutoFrameLayout;

public class AnimatorFrameLayout extends AutoFrameLayout {
    /* access modifiers changed from: private */
    public boolean animatorEnd = true;
    private KoocanRecyclerView.OnVisibility mOnVisibility;

    public AnimatorFrameLayout(Context context) {
        super(context);
    }

    public void setOnVisibilityListener(KoocanRecyclerView.OnVisibility onVisibility) {
        this.mOnVisibility = onVisibility;
    }

    public void setVisibility(final int i10) {
        KoocanRecyclerView.OnVisibility onVisibility = this.mOnVisibility;
        if (onVisibility != null) {
            onVisibility.onVisibility(i10, this);
        }
        if (this.animatorEnd) {
            if (i10 == 0) {
                super.setVisibility(i10);
                ObjectAnimator duration = ObjectAnimator.ofFloat(this, "translationX", new float[]{(float) (-getWidth()), 0.0f}).setDuration(500);
                duration.setInterpolator(new DecelerateInterpolator());
                duration.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        AnimatorFrameLayout.this.animatorEnd = true;
                    }

                    public void onAnimationStart(Animator animator) {
                        AnimatorFrameLayout.this.animatorEnd = false;
                    }
                });
                duration.start();
                return;
            }
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(this, "translationX", new float[]{0.0f, (float) (-getWidth())}).setDuration(500);
            duration2.setInterpolator(new DecelerateInterpolator());
            duration2.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    AnimatorFrameLayout.this.animatorEnd = true;
                    AnimatorFrameLayout.super.setVisibility(i10);
                }

                public void onAnimationStart(Animator animator) {
                    AnimatorFrameLayout.this.animatorEnd = false;
                }
            });
            duration2.start();
        }
    }

    public AnimatorFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
