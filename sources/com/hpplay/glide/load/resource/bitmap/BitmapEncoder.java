package com.hpplay.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import com.hpplay.glide.load.ResourceEncoder;
import com.hpplay.glide.load.engine.Resource;
import com.hpplay.glide.util.LogTime;
import com.hpplay.glide.util.Util;
import java.io.OutputStream;

public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    private static final int DEFAULT_COMPRESSION_QUALITY = 90;
    private static final String TAG = "BitmapEncoder";
    private Bitmap.CompressFormat compressFormat;
    private int quality;

    public BitmapEncoder() {
        this((Bitmap.CompressFormat) null, 90);
    }

    private Bitmap.CompressFormat getFormat(Bitmap bitmap) {
        Bitmap.CompressFormat compressFormat2 = this.compressFormat;
        if (compressFormat2 != null) {
            return compressFormat2;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    public String getId() {
        return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
    }

    public BitmapEncoder(Bitmap.CompressFormat compressFormat2, int i10) {
        this.compressFormat = compressFormat2;
        this.quality = i10;
    }

    public boolean encode(Resource<Bitmap> resource, OutputStream outputStream) {
        Bitmap bitmap = resource.get();
        long logTime = LogTime.getLogTime();
        Bitmap.CompressFormat format = getFormat(bitmap);
        bitmap.compress(format, this.quality, outputStream);
        if (!Log.isLoggable(TAG, 2)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Compressed with type: ");
        sb.append(format);
        sb.append(" of size ");
        sb.append(Util.getBitmapByteSize(bitmap));
        sb.append(" in ");
        sb.append(LogTime.getElapsedMillis(logTime));
        return true;
    }
}
