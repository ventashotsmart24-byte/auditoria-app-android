package com.hpplay.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

public class BitmapPoolAdapter implements BitmapPool {
    public void clearMemory() {
    }

    public Bitmap get(int i10, int i11, Bitmap.Config config) {
        return null;
    }

    public Bitmap getDirty(int i10, int i11, Bitmap.Config config) {
        return null;
    }

    public int getMaxSize() {
        return 0;
    }

    public boolean put(Bitmap bitmap) {
        return false;
    }

    public void setSizeMultiplier(float f10) {
    }

    public void trimMemory(int i10) {
    }
}
