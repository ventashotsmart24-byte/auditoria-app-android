package com.hpplay.glide.request.animation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.hpplay.glide.request.animation.ViewAnimation;

public class DrawableCrossFadeFactory<T extends Drawable> implements GlideAnimationFactory<T> {
    private static final int DEFAULT_DURATION_MS = 300;
    private final ViewAnimationFactory<T> animationFactory;
    private final int duration;
    private DrawableCrossFadeViewAnimation<T> firstResourceAnimation;
    private DrawableCrossFadeViewAnimation<T> secondResourceAnimation;

    public static class DefaultAnimationFactory implements ViewAnimation.AnimationFactory {
        private final int duration;

        public DefaultAnimationFactory(int i10) {
            this.duration = i10;
        }

        public Animation build() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration((long) this.duration);
            return alphaAnimation;
        }
    }

    public DrawableCrossFadeFactory() {
        this(300);
    }

    private GlideAnimation<T> getFirstResourceAnimation() {
        if (this.firstResourceAnimation == null) {
            this.firstResourceAnimation = new DrawableCrossFadeViewAnimation<>(this.animationFactory.build(false, true), this.duration);
        }
        return this.firstResourceAnimation;
    }

    private GlideAnimation<T> getSecondResourceAnimation() {
        if (this.secondResourceAnimation == null) {
            this.secondResourceAnimation = new DrawableCrossFadeViewAnimation<>(this.animationFactory.build(false, false), this.duration);
        }
        return this.secondResourceAnimation;
    }

    public GlideAnimation<T> build(boolean z10, boolean z11) {
        if (z10) {
            return NoAnimation.get();
        }
        if (z11) {
            return getFirstResourceAnimation();
        }
        return getSecondResourceAnimation();
    }

    public DrawableCrossFadeFactory(int i10) {
        this(new ViewAnimationFactory((ViewAnimation.AnimationFactory) new DefaultAnimationFactory(i10)), i10);
    }

    public DrawableCrossFadeFactory(Context context, int i10, int i11) {
        this(new ViewAnimationFactory(context, i10), i11);
    }

    public DrawableCrossFadeFactory(Animation animation, int i10) {
        this(new ViewAnimationFactory(animation), i10);
    }

    public DrawableCrossFadeFactory(ViewAnimationFactory<T> viewAnimationFactory, int i10) {
        this.animationFactory = viewAnimationFactory;
        this.duration = i10;
    }
}
