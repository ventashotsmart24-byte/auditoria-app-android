package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Util;

public final class UnitBitmapDecoder implements ResourceDecoder<Bitmap, Bitmap> {

    public static final class NonOwnedBitmapResource implements Resource<Bitmap> {
        private final Bitmap bitmap;

        public NonOwnedBitmapResource(Bitmap bitmap2) {
            this.bitmap = bitmap2;
        }

        public Class<Bitmap> getResourceClass() {
            return Bitmap.class;
        }

        public int getSize() {
            return Util.getBitmapByteSize(this.bitmap);
        }

        public void recycle() {
        }

        public Bitmap get() {
            return this.bitmap;
        }
    }

    public boolean handles(Bitmap bitmap, Options options) {
        return true;
    }

    public Resource<Bitmap> decode(Bitmap bitmap, int i10, int i11, Options options) {
        return new NonOwnedBitmapResource(bitmap);
    }
}
