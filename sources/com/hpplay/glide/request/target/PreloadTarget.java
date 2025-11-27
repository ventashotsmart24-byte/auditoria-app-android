package com.hpplay.glide.request.target;

import com.hpplay.glide.Glide;
import com.hpplay.glide.request.animation.GlideAnimation;

public final class PreloadTarget<Z> extends SimpleTarget<Z> {
    private PreloadTarget(int i10, int i11) {
        super(i10, i11);
    }

    public static <Z> PreloadTarget<Z> obtain(int i10, int i11) {
        return new PreloadTarget<>(i10, i11);
    }

    public void onResourceReady(Z z10, GlideAnimation<? super Z> glideAnimation) {
        Glide.clear((Target<?>) this);
    }
}
