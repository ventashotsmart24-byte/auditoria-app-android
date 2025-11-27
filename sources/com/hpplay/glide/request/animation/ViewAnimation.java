package com.hpplay.glide.request.animation;

import android.view.View;
import android.view.animation.Animation;
import com.hpplay.glide.request.animation.GlideAnimation;

public class ViewAnimation<R> implements GlideAnimation<R> {
    private final AnimationFactory animationFactory;

    public interface AnimationFactory {
        Animation build();
    }

    public ViewAnimation(AnimationFactory animationFactory2) {
        this.animationFactory = animationFactory2;
    }

    public boolean animate(R r10, GlideAnimation.ViewAdapter viewAdapter) {
        View view = viewAdapter.getView();
        if (view == null) {
            return false;
        }
        view.clearAnimation();
        view.startAnimation(this.animationFactory.build());
        return false;
    }
}
