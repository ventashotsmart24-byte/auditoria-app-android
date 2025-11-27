package com.hpplay.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;
import com.hpplay.glide.load.DecodeFormat;
import com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool;
import com.hpplay.glide.load.resource.bitmap.ImageHeaderParser;
import com.hpplay.glide.util.MarkEnforcingInputStream;
import com.hpplay.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;

public abstract class Downsampler implements BitmapDecoder<InputStream> {
    public static final Downsampler AT_LEAST = new Downsampler() {
        public /* bridge */ /* synthetic */ Bitmap decode(Object obj, BitmapPool bitmapPool, int i10, int i11, DecodeFormat decodeFormat) {
            return Downsampler.super.decode((InputStream) obj, bitmapPool, i10, i11, decodeFormat);
        }

        public String getId() {
            return "AT_LEAST.com.bumptech.glide.load.data.bitmap";
        }

        public int getSampleSize(int i10, int i11, int i12, int i13) {
            return Math.min(i11 / i13, i10 / i12);
        }
    };
    public static final Downsampler AT_MOST = new Downsampler() {
        public /* bridge */ /* synthetic */ Bitmap decode(Object obj, BitmapPool bitmapPool, int i10, int i11, DecodeFormat decodeFormat) {
            return Downsampler.super.decode((InputStream) obj, bitmapPool, i10, i11, decodeFormat);
        }

        public String getId() {
            return "AT_MOST.com.bumptech.glide.load.data.bitmap";
        }

        public int getSampleSize(int i10, int i11, int i12, int i13) {
            int ceil = (int) Math.ceil((double) Math.max(((float) i11) / ((float) i13), ((float) i10) / ((float) i12)));
            int i14 = 1;
            int max = Math.max(1, Integer.highestOneBit(ceil));
            if (max >= ceil) {
                i14 = 0;
            }
            return max << i14;
        }
    };
    private static final int MARK_POSITION = 5242880;
    public static final Downsampler NONE = new Downsampler() {
        public /* bridge */ /* synthetic */ Bitmap decode(Object obj, BitmapPool bitmapPool, int i10, int i11, DecodeFormat decodeFormat) {
            return Downsampler.super.decode((InputStream) obj, bitmapPool, i10, i11, decodeFormat);
        }

        public String getId() {
            return "NONE.com.bumptech.glide.load.data.bitmap";
        }

        public int getSampleSize(int i10, int i11, int i12, int i13) {
            return 0;
        }
    };
    private static final Queue<BitmapFactory.Options> OPTIONS_QUEUE = Util.createQueue(0);
    private static final String TAG = "Downsampler";
    private static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL = EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG);

    private static Bitmap decodeStream(MarkEnforcingInputStream markEnforcingInputStream, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options) {
        if (options.inJustDecodeBounds) {
            markEnforcingInputStream.mark(MARK_POSITION);
        } else {
            recyclableBufferedInputStream.fixMarkLimit();
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(markEnforcingInputStream, (Rect) null, options);
        try {
            if (options.inJustDecodeBounds) {
                markEnforcingInputStream.reset();
            }
        } catch (IOException e10) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "Exception loading inDecodeBounds=" + options.inJustDecodeBounds + " sample=" + options.inSampleSize, e10);
            }
        }
        return decodeStream;
    }

    private Bitmap downsampleWithSize(MarkEnforcingInputStream markEnforcingInputStream, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options, BitmapPool bitmapPool, int i10, int i11, int i12, DecodeFormat decodeFormat) {
        Bitmap.Config config = getConfig(markEnforcingInputStream, decodeFormat);
        options.inSampleSize = i12;
        options.inPreferredConfig = config;
        if (shouldUsePool(markEnforcingInputStream)) {
            double d10 = (double) i10;
            double d11 = (double) i12;
            Double.isNaN(d10);
            Double.isNaN(d11);
            double d12 = (double) i11;
            Double.isNaN(d12);
            Double.isNaN(d11);
            setInBitmap(options, bitmapPool.getDirty((int) Math.ceil(d10 / d11), (int) Math.ceil(d12 / d11), config));
        }
        return decodeStream(markEnforcingInputStream, recyclableBufferedInputStream, options);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:12|13|(1:15)|16|17|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        if (android.util.Log.isLoggable(TAG, 5) != false) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        r2 = new java.lang.StringBuilder();
        r2.append("Cannot determine whether the image has alpha or not from header for format ");
        r2.append(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003d, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r4.reset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004a, code lost:
        android.util.Log.isLoggable(TAG, 5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004d, code lost:
        throw r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0023 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap.Config getConfig(java.io.InputStream r4, com.hpplay.glide.load.DecodeFormat r5) {
        /*
            java.lang.String r0 = "Downsampler"
            com.hpplay.glide.load.DecodeFormat r1 = com.hpplay.glide.load.DecodeFormat.ALWAYS_ARGB_8888
            if (r5 == r1) goto L_0x004e
            com.hpplay.glide.load.DecodeFormat r1 = com.hpplay.glide.load.DecodeFormat.PREFER_ARGB_8888
            if (r5 == r1) goto L_0x004e
            r1 = 1024(0x400, float:1.435E-42)
            r4.mark(r1)
            r1 = 5
            com.hpplay.glide.load.resource.bitmap.ImageHeaderParser r2 = new com.hpplay.glide.load.resource.bitmap.ImageHeaderParser     // Catch:{ IOException -> 0x0023 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x0023 }
            boolean r5 = r2.hasAlpha()     // Catch:{ IOException -> 0x0023 }
            r4.reset()     // Catch:{ IOException -> 0x001d }
            goto L_0x003e
        L_0x001d:
            android.util.Log.isLoggable(r0, r1)
            goto L_0x003e
        L_0x0021:
            r5 = move-exception
            goto L_0x0046
        L_0x0023:
            boolean r2 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x0021 }
            if (r2 == 0) goto L_0x0036
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0021 }
            r2.<init>()     // Catch:{ all -> 0x0021 }
            java.lang.String r3 = "Cannot determine whether the image has alpha or not from header for format "
            r2.append(r3)     // Catch:{ all -> 0x0021 }
            r2.append(r5)     // Catch:{ all -> 0x0021 }
        L_0x0036:
            r4.reset()     // Catch:{ IOException -> 0x003a }
            goto L_0x003d
        L_0x003a:
            android.util.Log.isLoggable(r0, r1)
        L_0x003d:
            r5 = 0
        L_0x003e:
            if (r5 == 0) goto L_0x0043
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888
            goto L_0x0045
        L_0x0043:
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.RGB_565
        L_0x0045:
            return r4
        L_0x0046:
            r4.reset()     // Catch:{ IOException -> 0x004a }
            goto L_0x004d
        L_0x004a:
            android.util.Log.isLoggable(r0, r1)
        L_0x004d:
            throw r5
        L_0x004e:
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.glide.load.resource.bitmap.Downsampler.getConfig(java.io.InputStream, com.hpplay.glide.load.DecodeFormat):android.graphics.Bitmap$Config");
    }

    private static synchronized BitmapFactory.Options getDefaultOptions() {
        BitmapFactory.Options poll;
        synchronized (Downsampler.class) {
            Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                resetOptions(poll);
            }
        }
        return poll;
    }

    private int getRoundedSampleSize(int i10, int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        if (i14 == Integer.MIN_VALUE) {
            i14 = i12;
        }
        if (i13 == Integer.MIN_VALUE) {
            i13 = i11;
        }
        if (i10 == 90 || i10 == 270) {
            i15 = getSampleSize(i12, i11, i13, i14);
        } else {
            i15 = getSampleSize(i11, i12, i13, i14);
        }
        if (i15 == 0) {
            i16 = 0;
        } else {
            i16 = Integer.highestOneBit(i15);
        }
        return Math.max(1, i16);
    }

    private static void releaseOptions(BitmapFactory.Options options) {
        resetOptions(options);
        Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void resetOptions(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static void setInBitmap(BitmapFactory.Options options, Bitmap bitmap) {
        options.inBitmap = bitmap;
    }

    private static boolean shouldUsePool(InputStream inputStream) {
        return true;
    }

    public int[] getDimensions(MarkEnforcingInputStream markEnforcingInputStream, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options) {
        options.inJustDecodeBounds = true;
        decodeStream(markEnforcingInputStream, recyclableBufferedInputStream, options);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public abstract int getSampleSize(int i10, int i11, int i12, int i13);

    /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|19|(3:(2:22|(1:26))(1:27)|28|29)(3:30|31|32)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:11|33|34|35|36|37) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:12|13|14|15|16|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r6 = android.util.Log.isLoggable(TAG, 5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r14.reset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r1 = android.util.Log.isLoggable(TAG, 5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
        r15 = 0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0040 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0048 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00ab */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0038 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:8:0x0038=Splitter:B:8:0x0038, B:16:0x0048=Splitter:B:16:0x0048, B:35:0x00ab=Splitter:B:35:0x00ab} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap decode(java.io.InputStream r23, com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool r24, int r25, int r26, com.hpplay.glide.load.DecodeFormat r27) {
        /*
            r22 = this;
            r0 = r24
            java.lang.String r1 = "Downsampler"
            com.hpplay.glide.util.ByteArrayPool r10 = com.hpplay.glide.util.ByteArrayPool.get()
            byte[] r11 = r10.getBytes()
            byte[] r12 = r10.getBytes()
            android.graphics.BitmapFactory$Options r13 = getDefaultOptions()
            com.hpplay.glide.load.resource.bitmap.RecyclableBufferedInputStream r3 = new com.hpplay.glide.load.resource.bitmap.RecyclableBufferedInputStream
            r2 = r23
            r3.<init>(r2, r12)
            com.hpplay.glide.util.ExceptionCatchingInputStream r14 = com.hpplay.glide.util.ExceptionCatchingInputStream.obtain(r3)
            com.hpplay.glide.util.MarkEnforcingInputStream r2 = new com.hpplay.glide.util.MarkEnforcingInputStream
            r2.<init>(r14)
            r4 = 5242880(0x500000, float:7.34684E-39)
            r14.mark(r4)     // Catch:{ all -> 0x00b0 }
            r4 = 0
            r5 = 5
            com.hpplay.glide.load.resource.bitmap.ImageHeaderParser r6 = new com.hpplay.glide.load.resource.bitmap.ImageHeaderParser     // Catch:{ IOException -> 0x0040 }
            r6.<init>(r14)     // Catch:{ IOException -> 0x0040 }
            int r6 = r6.getOrientation()     // Catch:{ IOException -> 0x0040 }
            r14.reset()     // Catch:{ IOException -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            boolean r1 = android.util.Log.isLoggable(r1, r5)     // Catch:{ all -> 0x00b0 }
        L_0x003c:
            r15 = r6
            goto L_0x004d
        L_0x003e:
            r0 = move-exception
            goto L_0x00a7
        L_0x0040:
            boolean r6 = android.util.Log.isLoggable(r1, r5)     // Catch:{ all -> 0x003e }
            r14.reset()     // Catch:{ IOException -> 0x0048 }
            goto L_0x004c
        L_0x0048:
            boolean r1 = android.util.Log.isLoggable(r1, r5)     // Catch:{ all -> 0x00b0 }
        L_0x004c:
            r15 = 0
        L_0x004d:
            r13.inTempStorage = r11     // Catch:{ all -> 0x00b0 }
            r9 = r22
            int[] r1 = r9.getDimensions(r2, r3, r13)     // Catch:{ all -> 0x00b0 }
            r6 = r1[r4]     // Catch:{ all -> 0x00b0 }
            r4 = 1
            r7 = r1[r4]     // Catch:{ all -> 0x00b0 }
            int r17 = com.hpplay.glide.load.resource.bitmap.TransformationUtils.getExifOrientationDegrees(r15)     // Catch:{ all -> 0x00b0 }
            r16 = r22
            r18 = r6
            r19 = r7
            r20 = r25
            r21 = r26
            int r8 = r16.getRoundedSampleSize(r17, r18, r19, r20, r21)     // Catch:{ all -> 0x00b0 }
            r1 = r22
            r4 = r13
            r5 = r24
            r9 = r27
            android.graphics.Bitmap r1 = r1.downsampleWithSize(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00b0 }
            java.io.IOException r2 = r14.getException()     // Catch:{ all -> 0x00b0 }
            if (r2 != 0) goto L_0x00a1
            if (r1 == 0) goto L_0x0093
            android.graphics.Bitmap r2 = com.hpplay.glide.load.resource.bitmap.TransformationUtils.rotateImageExif(r1, r0, r15)     // Catch:{ all -> 0x00b0 }
            boolean r3 = r1.equals(r2)     // Catch:{ all -> 0x00b0 }
            if (r3 != 0) goto L_0x0094
            boolean r0 = r0.put(r1)     // Catch:{ all -> 0x00b0 }
            if (r0 != 0) goto L_0x0094
            r1.recycle()     // Catch:{ all -> 0x00b0 }
            goto L_0x0094
        L_0x0093:
            r2 = 0
        L_0x0094:
            r10.releaseBytes(r11)
            r10.releaseBytes(r12)
            r14.release()
            releaseOptions(r13)
            return r2
        L_0x00a1:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x00b0 }
            r0.<init>(r2)     // Catch:{ all -> 0x00b0 }
            throw r0     // Catch:{ all -> 0x00b0 }
        L_0x00a7:
            r14.reset()     // Catch:{ IOException -> 0x00ab }
            goto L_0x00af
        L_0x00ab:
            boolean r1 = android.util.Log.isLoggable(r1, r5)     // Catch:{ all -> 0x00b0 }
        L_0x00af:
            throw r0     // Catch:{ all -> 0x00b0 }
        L_0x00b0:
            r0 = move-exception
            r10.releaseBytes(r11)
            r10.releaseBytes(r12)
            r14.release()
            releaseOptions(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.glide.load.resource.bitmap.Downsampler.decode(java.io.InputStream, com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool, int, int, com.hpplay.glide.load.DecodeFormat):android.graphics.Bitmap");
    }
}
