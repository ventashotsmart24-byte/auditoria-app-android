package com.mobile.brasiltv.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.RecyclerView;

public class KoocanRecyclerView extends RecyclerView {
    /* access modifiers changed from: private */
    public boolean animatorEnd;
    private OnVisibility mOnVisibility;
    /* access modifiers changed from: private */
    public int totalScrollY;

    public interface OnVisibility {
        void onVisibility(int i10, View view);
    }

    public KoocanRecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void initParams() {
        setFocusable(false);
        setFocusableInTouchMode(false);
        setOnScrollListener(new RecyclerView.t() {
            public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
                KoocanRecyclerView koocanRecyclerView = KoocanRecyclerView.this;
                koocanRecyclerView.totalScrollY = koocanRecyclerView.totalScrollY + i11;
            }
        });
    }

    public int getTotalScrollY() {
        return this.totalScrollY;
    }

    public void setOnVisibilityListener(OnVisibility onVisibility) {
        this.mOnVisibility = onVisibility;
    }

    public void setVisibility(int i10) {
        super.setVisibility(i10);
        OnVisibility onVisibility = this.mOnVisibility;
        if (onVisibility != null) {
            onVisibility.onVisibility(i10, this);
        }
    }

    public void setVisibilityAnimate(final int i10) {
        if (this.animatorEnd) {
            OnVisibility onVisibility = this.mOnVisibility;
            if (onVisibility != null) {
                onVisibility.onVisibility(i10, this);
            }
            if (i10 == 0) {
                super.setVisibility(i10);
                ObjectAnimator duration = ObjectAnimator.ofFloat(this, "translationY", new float[]{(float) ((-getContext().getResources().getDisplayMetrics().heightPixels) / 2), 0.0f}).setDuration(400);
                duration.setInterpolator(new DecelerateInterpolator());
                duration.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        KoocanRecyclerView.this.animatorEnd = true;
                    }

                    public void onAnimationStart(Animator animator) {
                        KoocanRecyclerView.this.animatorEnd = false;
                    }
                });
                duration.start();
                return;
            }
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(this, "translationY", new float[]{0.0f, (float) ((-getContext().getResources().getDisplayMetrics().heightPixels) / 2)}).setDuration(400);
            duration2.setInterpolator(new DecelerateInterpolator());
            duration2.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    KoocanRecyclerView.this.animatorEnd = true;
                    KoocanRecyclerView.super.setVisibility(i10);
                }

                public void onAnimationStart(Animator animator) {
                    KoocanRecyclerView.this.animatorEnd = false;
                }
            });
            duration2.start();
        }
    }

    public KoocanRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KoocanRecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.animatorEnd = true;
        initParams();
    }
}
