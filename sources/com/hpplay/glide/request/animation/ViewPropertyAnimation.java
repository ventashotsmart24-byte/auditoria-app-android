package com.hpplay.glide.request.animation;

import android.view.View;
import com.hpplay.glide.request.animation.GlideAnimation;

public class ViewPropertyAnimation<R> implements GlideAnimation<R> {
    private final Animator animator;

    public interface Animator {
        void animate(View view);
    }

    public ViewPropertyAnimation(Animator animator2) {
        this.animator = animator2;
    }

    public boolean animate(R r10, GlideAnimation.ViewAdapter viewAdapter) {
        if (viewAdapter.getView() == null) {
            return false;
        }
        this.animator.animate(viewAdapter.getView());
        return false;
    }
}
