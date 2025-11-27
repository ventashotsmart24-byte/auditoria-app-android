package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;

public class UnitDrawableDecoder implements ResourceDecoder<Drawable, Drawable> {
    public boolean handles(Drawable drawable, Options options) {
        return true;
    }

    public Resource<Drawable> decode(Drawable drawable, int i10, int i11, Options options) {
        return NonOwnedDrawableResource.newInstance(drawable);
    }
}
