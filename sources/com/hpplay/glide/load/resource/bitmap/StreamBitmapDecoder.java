package com.hpplay.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.hpplay.glide.Glide;
import com.hpplay.glide.load.DecodeFormat;
import com.hpplay.glide.load.ResourceDecoder;
import com.hpplay.glide.load.engine.Resource;
import com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.InputStream;

public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {
    private static final String ID = "StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    private BitmapPool bitmapPool;
    private DecodeFormat decodeFormat;
    private final Downsampler downsampler;
    private String id;

    public StreamBitmapDecoder(Context context) {
        this(Glide.get(context).getBitmapPool());
    }

    public String getId() {
        if (this.id == null) {
            this.id = ID + this.downsampler.getId() + this.decodeFormat.name();
        }
        return this.id;
    }

    public StreamBitmapDecoder(BitmapPool bitmapPool2) {
        this(bitmapPool2, DecodeFormat.DEFAULT);
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i10, int i11) {
        return BitmapResource.obtain(this.downsampler.decode(inputStream, this.bitmapPool, i10, i11, this.decodeFormat), this.bitmapPool);
    }

    public StreamBitmapDecoder(Context context, DecodeFormat decodeFormat2) {
        this(Glide.get(context).getBitmapPool(), decodeFormat2);
    }

    public StreamBitmapDecoder(BitmapPool bitmapPool2, DecodeFormat decodeFormat2) {
        this(Downsampler.AT_LEAST, bitmapPool2, decodeFormat2);
    }

    public StreamBitmapDecoder(Downsampler downsampler2, BitmapPool bitmapPool2, DecodeFormat decodeFormat2) {
        this.downsampler = downsampler2;
        this.bitmapPool = bitmapPool2;
        this.decodeFormat = decodeFormat2;
    }
}
