package com.hpplay.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.hpplay.glide.gifdecoder.GifDecoder;
import com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool;

class GifBitmapProvider implements GifDecoder.BitmapProvider {
    private final BitmapPool bitmapPool;

    public GifBitmapProvider(BitmapPool bitmapPool2) {
        this.bitmapPool = bitmapPool2;
    }

    public Bitmap obtain(int i10, int i11, Bitmap.Config config) {
        return this.bitmapPool.getDirty(i10, i11, config);
    }

    public void release(Bitmap bitmap) {
        if (!this.bitmapPool.put(bitmap)) {
            bitmap.recycle();
        }
    }
}
