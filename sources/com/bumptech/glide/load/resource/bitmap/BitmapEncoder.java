package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;

public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    public static final Option<Bitmap.CompressFormat> COMPRESSION_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    public static final Option<Integer> COMPRESSION_QUALITY = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    private static final String TAG = "BitmapEncoder";
    private final ArrayPool arrayPool;

    public BitmapEncoder(ArrayPool arrayPool2) {
        this.arrayPool = arrayPool2;
    }

    private Bitmap.CompressFormat getFormat(Bitmap bitmap, Options options) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) options.get(COMPRESSION_FORMAT);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    public EncodeStrategy getEncodeStrategy(Options options) {
        return EncodeStrategy.TRANSFORMED;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:22|(2:40|41)|42|43) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x00b1 */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005e A[SYNTHETIC, Splitter:B:28:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0069 A[Catch:{ all -> 0x00b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ae A[SYNTHETIC, Splitter:B:40:0x00ae] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean encode(com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> r8, java.io.File r9, com.bumptech.glide.load.Options r10) {
        /*
            r7 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r8 = r8.get()
            android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
            android.graphics.Bitmap$CompressFormat r1 = r7.getFormat(r8, r10)
            int r2 = r8.getWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r3 = r8.getHeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "encode: [%dx%d] %s"
            com.bumptech.glide.util.pool.GlideTrace.beginSectionFormat(r4, r2, r3, r1)
            long r2 = com.bumptech.glide.util.LogTime.getLogTime()     // Catch:{ all -> 0x00b2 }
            com.bumptech.glide.load.Option<java.lang.Integer> r4 = COMPRESSION_QUALITY     // Catch:{ all -> 0x00b2 }
            java.lang.Object r4 = r10.get(r4)     // Catch:{ all -> 0x00b2 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x00b2 }
            int r4 = r4.intValue()     // Catch:{ all -> 0x00b2 }
            r5 = 0
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0057 }
            r6.<init>(r9)     // Catch:{ IOException -> 0x0057 }
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r9 = r7.arrayPool     // Catch:{ IOException -> 0x0053, all -> 0x0050 }
            if (r9 == 0) goto L_0x0044
            com.bumptech.glide.load.data.BufferedOutputStream r9 = new com.bumptech.glide.load.data.BufferedOutputStream     // Catch:{ IOException -> 0x0053, all -> 0x0050 }
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r5 = r7.arrayPool     // Catch:{ IOException -> 0x0053, all -> 0x0050 }
            r9.<init>(r6, r5)     // Catch:{ IOException -> 0x0053, all -> 0x0050 }
            r5 = r9
            goto L_0x0045
        L_0x0044:
            r5 = r6
        L_0x0045:
            r8.compress(r1, r4, r5)     // Catch:{ IOException -> 0x0057 }
            r5.close()     // Catch:{ IOException -> 0x0057 }
            r5.close()     // Catch:{ IOException -> 0x004e }
        L_0x004e:
            r9 = 1
            goto L_0x0062
        L_0x0050:
            r8 = move-exception
            r5 = r6
            goto L_0x00ac
        L_0x0053:
            r5 = r6
            goto L_0x0057
        L_0x0055:
            r8 = move-exception
            goto L_0x00ac
        L_0x0057:
            r9 = 3
            boolean r9 = android.util.Log.isLoggable(r0, r9)     // Catch:{ all -> 0x0055 }
            if (r5 == 0) goto L_0x0061
            r5.close()     // Catch:{ IOException -> 0x0061 }
        L_0x0061:
            r9 = 0
        L_0x0062:
            r4 = 2
            boolean r0 = android.util.Log.isLoggable(r0, r4)     // Catch:{ all -> 0x00b2 }
            if (r0 == 0) goto L_0x00a8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b2 }
            r0.<init>()     // Catch:{ all -> 0x00b2 }
            java.lang.String r4 = "Compressed with type: "
            r0.append(r4)     // Catch:{ all -> 0x00b2 }
            r0.append(r1)     // Catch:{ all -> 0x00b2 }
            java.lang.String r1 = " of size "
            r0.append(r1)     // Catch:{ all -> 0x00b2 }
            int r1 = com.bumptech.glide.util.Util.getBitmapByteSize(r8)     // Catch:{ all -> 0x00b2 }
            r0.append(r1)     // Catch:{ all -> 0x00b2 }
            java.lang.String r1 = " in "
            r0.append(r1)     // Catch:{ all -> 0x00b2 }
            double r1 = com.bumptech.glide.util.LogTime.getElapsedMillis(r2)     // Catch:{ all -> 0x00b2 }
            r0.append(r1)     // Catch:{ all -> 0x00b2 }
            java.lang.String r1 = ", options format: "
            r0.append(r1)     // Catch:{ all -> 0x00b2 }
            com.bumptech.glide.load.Option<android.graphics.Bitmap$CompressFormat> r1 = COMPRESSION_FORMAT     // Catch:{ all -> 0x00b2 }
            java.lang.Object r10 = r10.get(r1)     // Catch:{ all -> 0x00b2 }
            r0.append(r10)     // Catch:{ all -> 0x00b2 }
            java.lang.String r10 = ", hasAlpha: "
            r0.append(r10)     // Catch:{ all -> 0x00b2 }
            boolean r8 = r8.hasAlpha()     // Catch:{ all -> 0x00b2 }
            r0.append(r8)     // Catch:{ all -> 0x00b2 }
        L_0x00a8:
            com.bumptech.glide.util.pool.GlideTrace.endSection()
            return r9
        L_0x00ac:
            if (r5 == 0) goto L_0x00b1
            r5.close()     // Catch:{ IOException -> 0x00b1 }
        L_0x00b1:
            throw r8     // Catch:{ all -> 0x00b2 }
        L_0x00b2:
            r8 = move-exception
            com.bumptech.glide.util.pool.GlideTrace.endSection()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.BitmapEncoder.encode(com.bumptech.glide.load.engine.Resource, java.io.File, com.bumptech.glide.load.Options):boolean");
    }

    @Deprecated
    public BitmapEncoder() {
        this.arrayPool = null;
    }
}
