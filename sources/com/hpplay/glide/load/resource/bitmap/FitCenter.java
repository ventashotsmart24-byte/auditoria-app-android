package com.hpplay.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool;

public class FitCenter extends BitmapTransformation {
    public FitCenter(Context context) {
        super(context);
    }

    public String getId() {
        return "FitCenter.com.bumptech.glide.load.resource.bitmap";
    }

    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i10, int i11) {
        return TransformationUtils.fitCenter(bitmap, bitmapPool, i10, i11);
    }

    public FitCenter(BitmapPool bitmapPool) {
        super(bitmapPool);
    }
}
