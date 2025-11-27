package com.hpplay.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool;

public class CenterCrop extends BitmapTransformation {
    public CenterCrop(Context context) {
        super(context);
    }

    public String getId() {
        return "CenterCrop.com.bumptech.glide.load.resource.bitmap";
    }

    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i10, int i11) {
        Bitmap.Config config;
        if (bitmap.getConfig() != null) {
            config = bitmap.getConfig();
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmap2 = bitmapPool.get(i10, i11, config);
        Bitmap centerCrop = TransformationUtils.centerCrop(bitmap2, bitmap, i10, i11);
        if (!(bitmap2 == null || bitmap2 == centerCrop || bitmapPool.put(bitmap2))) {
            bitmap2.recycle();
        }
        return centerCrop;
    }

    public CenterCrop(BitmapPool bitmapPool) {
        super(bitmapPool);
    }
}
