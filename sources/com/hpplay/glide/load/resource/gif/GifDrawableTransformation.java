package com.hpplay.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.hpplay.glide.load.Transformation;
import com.hpplay.glide.load.engine.Resource;
import com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool;
import com.hpplay.glide.load.resource.bitmap.BitmapResource;

public class GifDrawableTransformation implements Transformation<GifDrawable> {
    private final BitmapPool bitmapPool;
    private final Transformation<Bitmap> wrapped;

    public GifDrawableTransformation(Transformation<Bitmap> transformation, BitmapPool bitmapPool2) {
        this.wrapped = transformation;
        this.bitmapPool = bitmapPool2;
    }

    public String getId() {
        return this.wrapped.getId();
    }

    public Resource<GifDrawable> transform(Resource<GifDrawable> resource, int i10, int i11) {
        GifDrawable gifDrawable = resource.get();
        Bitmap firstFrame = resource.get().getFirstFrame();
        Bitmap bitmap = this.wrapped.transform(new BitmapResource(firstFrame, this.bitmapPool), i10, i11).get();
        if (!bitmap.equals(firstFrame)) {
            return new GifDrawableResource(new GifDrawable(gifDrawable, bitmap, this.wrapped));
        }
        return resource;
    }
}
