package com.hpplay.glide.request.animation;

import com.hpplay.glide.request.animation.GlideAnimation;

public class NoAnimation<R> implements GlideAnimation<R> {
    /* access modifiers changed from: private */
    public static final NoAnimation<?> NO_ANIMATION = new NoAnimation<>();
    private static final GlideAnimationFactory<?> NO_ANIMATION_FACTORY = new NoAnimationFactory();

    public static class NoAnimationFactory<R> implements GlideAnimationFactory<R> {
        public GlideAnimation<R> build(boolean z10, boolean z11) {
            return NoAnimation.NO_ANIMATION;
        }
    }

    public static <R> GlideAnimation<R> get() {
        return NO_ANIMATION;
    }

    public static <R> GlideAnimationFactory<R> getFactory() {
        return NO_ANIMATION_FACTORY;
    }

    public boolean animate(Object obj, GlideAnimation.ViewAdapter viewAdapter) {
        return false;
    }
}
