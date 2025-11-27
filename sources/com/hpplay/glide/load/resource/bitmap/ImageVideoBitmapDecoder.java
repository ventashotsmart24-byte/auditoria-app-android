package com.hpplay.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.hpplay.glide.load.ResourceDecoder;
import com.hpplay.glide.load.model.ImageVideoWrapper;
import java.io.InputStream;

public class ImageVideoBitmapDecoder implements ResourceDecoder<ImageVideoWrapper, Bitmap> {
    private static final String TAG = "ImageVideoDecoder";
    private final ResourceDecoder<ParcelFileDescriptor, Bitmap> fileDescriptorDecoder;
    private final ResourceDecoder<InputStream, Bitmap> streamDecoder;

    public ImageVideoBitmapDecoder(ResourceDecoder<InputStream, Bitmap> resourceDecoder, ResourceDecoder<ParcelFileDescriptor, Bitmap> resourceDecoder2) {
        this.streamDecoder = resourceDecoder;
        this.fileDescriptorDecoder = resourceDecoder2;
    }

    public String getId() {
        return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        r3 = r3.getFileDescriptor();
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001c  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.hpplay.glide.load.engine.Resource<android.graphics.Bitmap> decode(com.hpplay.glide.load.model.ImageVideoWrapper r3, int r4, int r5) {
        /*
            r2 = this;
            java.io.InputStream r0 = r3.getStream()
            if (r0 == 0) goto L_0x0013
            com.hpplay.glide.load.ResourceDecoder<java.io.InputStream, android.graphics.Bitmap> r1 = r2.streamDecoder     // Catch:{ IOException -> 0x000d }
            com.hpplay.glide.load.engine.Resource r0 = r1.decode(r0, r4, r5)     // Catch:{ IOException -> 0x000d }
            goto L_0x0014
        L_0x000d:
            java.lang.String r0 = "ImageVideoDecoder"
            r1 = 2
            android.util.Log.isLoggable(r0, r1)
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 != 0) goto L_0x0022
            android.os.ParcelFileDescriptor r3 = r3.getFileDescriptor()
            if (r3 == 0) goto L_0x0022
            com.hpplay.glide.load.ResourceDecoder<android.os.ParcelFileDescriptor, android.graphics.Bitmap> r0 = r2.fileDescriptorDecoder
            com.hpplay.glide.load.engine.Resource r0 = r0.decode(r3, r4, r5)
        L_0x0022:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.glide.load.resource.bitmap.ImageVideoBitmapDecoder.decode(com.hpplay.glide.load.model.ImageVideoWrapper, int, int):com.hpplay.glide.load.engine.Resource");
    }
}
