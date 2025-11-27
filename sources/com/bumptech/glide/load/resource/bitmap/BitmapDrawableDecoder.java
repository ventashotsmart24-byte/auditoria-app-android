package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;

public class BitmapDrawableDecoder<DataType> implements ResourceDecoder<DataType, BitmapDrawable> {
    private final ResourceDecoder<DataType, Bitmap> decoder;
    private final Resources resources;

    public BitmapDrawableDecoder(Context context, ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        this(context.getResources(), resourceDecoder);
    }

    public Resource<BitmapDrawable> decode(DataType datatype, int i10, int i11, Options options) {
        return LazyBitmapDrawableResource.obtain(this.resources, this.decoder.decode(datatype, i10, i11, options));
    }

    public boolean handles(DataType datatype, Options options) {
        return this.decoder.handles(datatype, options);
    }

    @Deprecated
    public BitmapDrawableDecoder(Resources resources2, BitmapPool bitmapPool, ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        this(resources2, resourceDecoder);
    }

    public BitmapDrawableDecoder(Resources resources2, ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        this.resources = (Resources) Preconditions.checkNotNull(resources2);
        this.decoder = (ResourceDecoder) Preconditions.checkNotNull(resourceDecoder);
    }
}
