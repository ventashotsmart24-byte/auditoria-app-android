package com.hpplay.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.hpplay.glide.load.Transformation;
import com.hpplay.glide.load.engine.Resource;
import com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool;
import com.hpplay.glide.load.resource.gif.GifDrawable;
import com.hpplay.glide.load.resource.gif.GifDrawableTransformation;

public class GifBitmapWrapperTransformation implements Transformation<GifBitmapWrapper> {
    private final Transformation<Bitmap> bitmapTransformation;
    private final Transformation<GifDrawable> gifDataTransformation;

    public GifBitmapWrapperTransformation(BitmapPool bitmapPool, Transformation<Bitmap> transformation) {
        this(transformation, (Transformation<GifDrawable>) new GifDrawableTransformation(transformation, bitmapPool));
    }

    public String getId() {
        return this.bitmapTransformation.getId();
    }

    public Resource<GifBitmapWrapper> transform(Resource<GifBitmapWrapper> resource, int i10, int i11) {
        Transformation<GifDrawable> transformation;
        Transformation<Bitmap> transformation2;
        Resource<Bitmap> bitmapResource = resource.get().getBitmapResource();
        Resource<GifDrawable> gifResource = resource.get().getGifResource();
        if (bitmapResource != null && (transformation2 = this.bitmapTransformation) != null) {
            Resource<Bitmap> transform = transformation2.transform(bitmapResource, i10, i11);
            if (!bitmapResource.equals(transform)) {
                return new GifBitmapWrapperResource(new GifBitmapWrapper(transform, resource.get().getGifResource()));
            }
            return resource;
        } else if (gifResource == null || (transformation = this.gifDataTransformation) == null) {
            return resource;
        } else {
            Resource<GifDrawable> transform2 = transformation.transform(gifResource, i10, i11);
            if (!gifResource.equals(transform2)) {
                return new GifBitmapWrapperResource(new GifBitmapWrapper(resource.get().getBitmapResource(), transform2));
            }
            return resource;
        }
    }

    public GifBitmapWrapperTransformation(Transformation<Bitmap> transformation, Transformation<GifDrawable> transformation2) {
        this.bitmapTransformation = transformation;
        this.gifDataTransformation = transformation2;
    }
}
