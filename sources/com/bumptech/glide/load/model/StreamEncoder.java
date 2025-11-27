package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.InputStream;

public class StreamEncoder implements Encoder<InputStream> {
    private static final String TAG = "StreamEncoder";
    private final ArrayPool byteArrayPool;

    public StreamEncoder(ArrayPool arrayPool) {
        this.byteArrayPool = arrayPool;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003b A[SYNTHETIC, Splitter:B:22:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0046 A[SYNTHETIC, Splitter:B:27:0x0046] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean encode(java.io.InputStream r4, java.io.File r5, com.bumptech.glide.load.Options r6) {
        /*
            r3 = this;
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r6 = r3.byteArrayPool
            r0 = 65536(0x10000, float:9.18355E-41)
            java.lang.Class<byte[]> r1 = byte[].class
            java.lang.Object r6 = r6.get(r0, r1)
            byte[] r6 = (byte[]) r6
            r0 = 0
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0032 }
            r2.<init>(r5)     // Catch:{ IOException -> 0x0032 }
        L_0x0013:
            int r5 = r4.read(r6)     // Catch:{ IOException -> 0x002e, all -> 0x002b }
            r1 = -1
            if (r5 == r1) goto L_0x001e
            r2.write(r6, r0, r5)     // Catch:{ IOException -> 0x002e, all -> 0x002b }
            goto L_0x0013
        L_0x001e:
            r2.close()     // Catch:{ IOException -> 0x002e, all -> 0x002b }
            r2.close()     // Catch:{ IOException -> 0x0024 }
        L_0x0024:
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r4 = r3.byteArrayPool
            r4.put(r6)
            r0 = 1
            goto L_0x0043
        L_0x002b:
            r4 = move-exception
            r1 = r2
            goto L_0x0044
        L_0x002e:
            r1 = r2
            goto L_0x0032
        L_0x0030:
            r4 = move-exception
            goto L_0x0044
        L_0x0032:
            java.lang.String r4 = "StreamEncoder"
            r5 = 3
            boolean r4 = android.util.Log.isLoggable(r4, r5)     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x003e
            r1.close()     // Catch:{ IOException -> 0x003e }
        L_0x003e:
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r4 = r3.byteArrayPool
            r4.put(r6)
        L_0x0043:
            return r0
        L_0x0044:
            if (r1 == 0) goto L_0x0049
            r1.close()     // Catch:{ IOException -> 0x0049 }
        L_0x0049:
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r5 = r3.byteArrayPool
            r5.put(r6)
            goto L_0x0050
        L_0x004f:
            throw r4
        L_0x0050:
            goto L_0x004f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.StreamEncoder.encode(java.io.InputStream, java.io.File, com.bumptech.glide.load.Options):boolean");
    }
}
