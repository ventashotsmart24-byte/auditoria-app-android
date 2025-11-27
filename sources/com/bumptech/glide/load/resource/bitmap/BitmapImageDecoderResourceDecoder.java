package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.resource.DefaultOnHeaderDecodedListener;

public final class BitmapImageDecoderResourceDecoder implements ResourceDecoder<ImageDecoder.Source, Bitmap> {
    private static final String TAG = "BitmapImageDecoder";
    private final BitmapPool bitmapPool = new BitmapPoolAdapter();

    public /* bridge */ /* synthetic */ Resource decode(Object obj, int i10, int i11, Options options) {
        return decode(b.a(obj), i10, i11, options);
    }

    public boolean handles(ImageDecoder.Source source, Options options) {
        return true;
    }

    public Resource<Bitmap> decode(ImageDecoder.Source source, int i10, int i11, Options options) {
        Bitmap a10 = ImageDecoder.decodeBitmap(source, new DefaultOnHeaderDecodedListener(i10, i11, options));
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Decoded [");
            sb.append(a10.getWidth());
            sb.append("x");
            sb.append(a10.getHeight());
            sb.append("] for [");
            sb.append(i10);
            sb.append("x");
            sb.append(i11);
            sb.append("]");
        }
        return new BitmapResource(a10, this.bitmapPool);
    }

    public /* bridge */ /* synthetic */ boolean handles(Object obj, Options options) {
        return handles(b.a(obj), options);
    }
}
