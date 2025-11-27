package com.hpplay.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.hpplay.glide.load.engine.Resource;

public abstract class DrawableResource<T extends Drawable> implements Resource<T> {
    protected final T drawable;

    public DrawableResource(T t10) {
        if (t10 != null) {
            this.drawable = t10;
            return;
        }
        throw new NullPointerException("Drawable must not be null!");
    }

    public final T get() {
        return this.drawable.getConstantState().newDrawable();
    }
}
