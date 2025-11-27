package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.util.GlideSuppliers;
import java.util.List;
import w0.b;

final class RegistryFactory {
    private RegistryFactory() {
    }

    public static Registry createAndInitRegistry(Glide glide, List<GlideModule> list, AppGlideModule appGlideModule) {
        BitmapPool bitmapPool = glide.getBitmapPool();
        ArrayPool arrayPool = glide.getArrayPool();
        Context applicationContext = glide.getGlideContext().getApplicationContext();
        GlideExperiments experiments = glide.getGlideContext().getExperiments();
        Registry registry = new Registry();
        initializeDefaults(applicationContext, registry, bitmapPool, arrayPool, experiments);
        initializeModules(applicationContext, glide, registry, list, appGlideModule);
        return registry;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x031c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void initializeDefaults(android.content.Context r24, com.bumptech.glide.Registry r25, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r26, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r27, com.bumptech.glide.GlideExperiments r28) {
        /*
            r0 = r24
            r1 = r25
            r2 = r26
            r3 = r27
            com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser r4 = new com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser
            r4.<init>()
            r1.register((com.bumptech.glide.load.ImageHeaderParser) r4)
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 27
            if (r4 < r5) goto L_0x001e
            com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser r5 = new com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser
            r5.<init>()
            r1.register((com.bumptech.glide.load.ImageHeaderParser) r5)
        L_0x001e:
            android.content.res.Resources r5 = r24.getResources()
            java.util.List r6 = r25.getImageHeaderParsers()
            com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder r7 = new com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder
            r7.<init>(r0, r6, r2, r3)
            com.bumptech.glide.load.ResourceDecoder r8 = com.bumptech.glide.load.resource.bitmap.VideoDecoder.parcel(r26)
            com.bumptech.glide.load.resource.bitmap.Downsampler r9 = new com.bumptech.glide.load.resource.bitmap.Downsampler
            java.util.List r10 = r25.getImageHeaderParsers()
            android.util.DisplayMetrics r11 = r5.getDisplayMetrics()
            r9.<init>(r10, r11, r2, r3)
            r10 = 28
            if (r4 < r10) goto L_0x0055
            java.lang.Class<com.bumptech.glide.GlideBuilder$EnableImageDecoderForBitmaps> r11 = com.bumptech.glide.GlideBuilder.EnableImageDecoderForBitmaps.class
            r12 = r28
            boolean r11 = r12.isEnabled(r11)
            if (r11 == 0) goto L_0x0055
            com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder r11 = new com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder
            r11.<init>()
            com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder r12 = new com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder
            r12.<init>()
            goto L_0x005f
        L_0x0055:
            com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder r12 = new com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder
            r12.<init>(r9)
            com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder r11 = new com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder
            r11.<init>(r9, r3)
        L_0x005f:
            java.lang.String r13 = "Animation"
            java.lang.Class<java.nio.ByteBuffer> r14 = java.nio.ByteBuffer.class
            java.lang.Class<android.graphics.drawable.Drawable> r15 = android.graphics.drawable.Drawable.class
            r16 = r7
            java.lang.Class<java.io.InputStream> r7 = java.io.InputStream.class
            if (r4 < r10) goto L_0x0079
            com.bumptech.glide.load.ResourceDecoder r10 = com.bumptech.glide.load.resource.drawable.AnimatedImageDecoder.streamDecoder(r6, r3)
            r1.append(r13, r7, r15, r10)
            com.bumptech.glide.load.ResourceDecoder r10 = com.bumptech.glide.load.resource.drawable.AnimatedImageDecoder.byteBufferDecoder(r6, r3)
            r1.append(r13, r14, r15, r10)
        L_0x0079:
            com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder r10 = new com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder
            r10.<init>(r0)
            r17 = r4
            com.bumptech.glide.load.resource.bitmap.BitmapEncoder r4 = new com.bumptech.glide.load.resource.bitmap.BitmapEncoder
            r4.<init>(r3)
            com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder r0 = new com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder
            r0.<init>()
            r28 = r0
            com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder r0 = new com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder
            r0.<init>()
            r18 = r0
            android.content.ContentResolver r0 = r24.getContentResolver()
            r19 = r0
            com.bumptech.glide.load.model.ByteBufferEncoder r0 = new com.bumptech.glide.load.model.ByteBufferEncoder
            r0.<init>()
            com.bumptech.glide.Registry r0 = r1.append(r14, r0)
            r20 = r10
            com.bumptech.glide.load.model.StreamEncoder r10 = new com.bumptech.glide.load.model.StreamEncoder
            r10.<init>(r3)
            com.bumptech.glide.Registry r0 = r0.append(r7, r10)
            java.lang.String r10 = "Bitmap"
            r21 = r15
            java.lang.Class<android.graphics.Bitmap> r15 = android.graphics.Bitmap.class
            com.bumptech.glide.Registry r0 = r0.append(r10, r14, r15, r12)
            r0.append(r10, r7, r15, r11)
            boolean r0 = com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.isSupported()
            r22 = r13
            java.lang.Class<android.os.ParcelFileDescriptor> r13 = android.os.ParcelFileDescriptor.class
            if (r0 == 0) goto L_0x00cc
            com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder r0 = new com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder
            r0.<init>(r9)
            r1.append(r10, r13, r15, r0)
        L_0x00cc:
            com.bumptech.glide.load.ResourceDecoder r0 = com.bumptech.glide.load.resource.bitmap.VideoDecoder.asset(r26)
            java.lang.Class<android.content.res.AssetFileDescriptor> r9 = android.content.res.AssetFileDescriptor.class
            r1.append(r10, r9, r15, r0)
            com.bumptech.glide.Registry r0 = r1.append(r10, r13, r15, r8)
            r23 = r9
            com.bumptech.glide.load.model.UnitModelLoader$Factory r9 = com.bumptech.glide.load.model.UnitModelLoader.Factory.getInstance()
            com.bumptech.glide.Registry r0 = r0.append(r15, r15, r9)
            com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder r9 = new com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder
            r9.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r10, r15, r15, r9)
            com.bumptech.glide.Registry r0 = r0.append(r15, r4)
            com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder r9 = new com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder
            r9.<init>((android.content.res.Resources) r5, r12)
            java.lang.String r12 = "BitmapDrawable"
            java.lang.Class<android.graphics.drawable.BitmapDrawable> r1 = android.graphics.drawable.BitmapDrawable.class
            com.bumptech.glide.Registry r0 = r0.append(r12, r14, r1, r9)
            com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder r9 = new com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder
            r9.<init>((android.content.res.Resources) r5, r11)
            com.bumptech.glide.Registry r0 = r0.append(r12, r7, r1, r9)
            com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder r9 = new com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder
            r9.<init>((android.content.res.Resources) r5, r8)
            com.bumptech.glide.Registry r0 = r0.append(r12, r13, r1, r9)
            com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder r8 = new com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder
            r8.<init>(r2, r4)
            com.bumptech.glide.Registry r0 = r0.append(r1, r8)
            com.bumptech.glide.load.resource.gif.StreamGifDecoder r4 = new com.bumptech.glide.load.resource.gif.StreamGifDecoder
            r8 = r16
            r4.<init>(r6, r8, r3)
            java.lang.Class<com.bumptech.glide.load.resource.gif.GifDrawable> r6 = com.bumptech.glide.load.resource.gif.GifDrawable.class
            r9 = r22
            com.bumptech.glide.Registry r0 = r0.append(r9, r7, r6, r4)
            com.bumptech.glide.Registry r0 = r0.append(r9, r14, r6, r8)
            com.bumptech.glide.load.resource.gif.GifDrawableEncoder r4 = new com.bumptech.glide.load.resource.gif.GifDrawableEncoder
            r4.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r6, r4)
            com.bumptech.glide.load.model.UnitModelLoader$Factory r4 = com.bumptech.glide.load.model.UnitModelLoader.Factory.getInstance()
            java.lang.Class<com.bumptech.glide.gifdecoder.GifDecoder> r8 = com.bumptech.glide.gifdecoder.GifDecoder.class
            com.bumptech.glide.Registry r0 = r0.append(r8, r8, r4)
            com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder r4 = new com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder
            r4.<init>(r2)
            com.bumptech.glide.Registry r0 = r0.append(r10, r8, r15, r4)
            java.lang.Class<android.net.Uri> r4 = android.net.Uri.class
            r8 = r20
            r9 = r21
            com.bumptech.glide.Registry r0 = r0.append(r4, r9, r8)
            com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder r10 = new com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder
            r10.<init>(r8, r2)
            com.bumptech.glide.Registry r0 = r0.append(r4, r15, r10)
            com.bumptech.glide.load.resource.bytes.ByteBufferRewinder$Factory r8 = new com.bumptech.glide.load.resource.bytes.ByteBufferRewinder$Factory
            r8.<init>()
            com.bumptech.glide.Registry r0 = r0.register((com.bumptech.glide.load.data.DataRewinder.Factory<?>) r8)
            com.bumptech.glide.load.model.ByteBufferFileLoader$Factory r8 = new com.bumptech.glide.load.model.ByteBufferFileLoader$Factory
            r8.<init>()
            java.lang.Class<java.io.File> r10 = java.io.File.class
            com.bumptech.glide.Registry r0 = r0.append(r10, r14, r8)
            com.bumptech.glide.load.model.FileLoader$StreamFactory r8 = new com.bumptech.glide.load.model.FileLoader$StreamFactory
            r8.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r10, r7, r8)
            com.bumptech.glide.load.resource.file.FileDecoder r8 = new com.bumptech.glide.load.resource.file.FileDecoder
            r8.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r10, r10, r8)
            com.bumptech.glide.load.model.FileLoader$FileDescriptorFactory r8 = new com.bumptech.glide.load.model.FileLoader$FileDescriptorFactory
            r8.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r10, r13, r8)
            com.bumptech.glide.load.model.UnitModelLoader$Factory r8 = com.bumptech.glide.load.model.UnitModelLoader.Factory.getInstance()
            com.bumptech.glide.Registry r0 = r0.append(r10, r10, r8)
            com.bumptech.glide.load.data.InputStreamRewinder$Factory r8 = new com.bumptech.glide.load.data.InputStreamRewinder$Factory
            r8.<init>(r3)
            r0.register((com.bumptech.glide.load.data.DataRewinder.Factory<?>) r8)
            boolean r0 = com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.isSupported()
            if (r0 == 0) goto L_0x01ab
            com.bumptech.glide.load.data.ParcelFileDescriptorRewinder$Factory r0 = new com.bumptech.glide.load.data.ParcelFileDescriptorRewinder$Factory
            r0.<init>()
            r3 = r1
            r1 = r25
            r1.register((com.bumptech.glide.load.data.DataRewinder.Factory<?>) r0)
            goto L_0x01ae
        L_0x01ab:
            r3 = r1
            r1 = r25
        L_0x01ae:
            com.bumptech.glide.load.model.ModelLoaderFactory r0 = com.bumptech.glide.load.model.DirectResourceLoader.inputStreamFactory(r24)
            com.bumptech.glide.load.model.ModelLoaderFactory r8 = com.bumptech.glide.load.model.DirectResourceLoader.assetFileDescriptorFactory(r24)
            com.bumptech.glide.load.model.ModelLoaderFactory r11 = com.bumptech.glide.load.model.DirectResourceLoader.drawableFactory(r24)
            java.lang.Class r12 = java.lang.Integer.TYPE
            r16 = r6
            com.bumptech.glide.Registry r6 = r1.append(r12, r7, r0)
            java.lang.Class<java.lang.Integer> r2 = java.lang.Integer.class
            com.bumptech.glide.Registry r0 = r6.append(r2, r7, r0)
            r6 = r23
            com.bumptech.glide.Registry r0 = r0.append(r12, r6, r8)
            com.bumptech.glide.Registry r0 = r0.append(r2, r6, r8)
            com.bumptech.glide.Registry r0 = r0.append(r12, r9, r11)
            com.bumptech.glide.Registry r0 = r0.append(r2, r9, r11)
            com.bumptech.glide.load.model.ModelLoaderFactory r8 = com.bumptech.glide.load.model.ResourceUriLoader.newStreamFactory(r24)
            com.bumptech.glide.Registry r0 = r0.append(r4, r7, r8)
            com.bumptech.glide.load.model.ModelLoaderFactory r8 = com.bumptech.glide.load.model.ResourceUriLoader.newAssetFileDescriptorFactory(r24)
            r0.append(r4, r6, r8)
            com.bumptech.glide.load.model.ResourceLoader$UriFactory r0 = new com.bumptech.glide.load.model.ResourceLoader$UriFactory
            r0.<init>(r5)
            com.bumptech.glide.load.model.ResourceLoader$AssetFileDescriptorFactory r8 = new com.bumptech.glide.load.model.ResourceLoader$AssetFileDescriptorFactory
            r8.<init>(r5)
            com.bumptech.glide.load.model.ResourceLoader$StreamFactory r11 = new com.bumptech.glide.load.model.ResourceLoader$StreamFactory
            r11.<init>(r5)
            r20 = r3
            com.bumptech.glide.Registry r3 = r1.append(r2, r4, r0)
            com.bumptech.glide.Registry r0 = r3.append(r12, r4, r0)
            com.bumptech.glide.Registry r0 = r0.append(r2, r6, r8)
            com.bumptech.glide.Registry r0 = r0.append(r12, r6, r8)
            com.bumptech.glide.Registry r0 = r0.append(r2, r7, r11)
            r0.append(r12, r7, r11)
            com.bumptech.glide.load.model.DataUrlLoader$StreamFactory r0 = new com.bumptech.glide.load.model.DataUrlLoader$StreamFactory
            r0.<init>()
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            com.bumptech.glide.Registry r0 = r1.append(r2, r7, r0)
            com.bumptech.glide.load.model.DataUrlLoader$StreamFactory r3 = new com.bumptech.glide.load.model.DataUrlLoader$StreamFactory
            r3.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r4, r7, r3)
            com.bumptech.glide.load.model.StringLoader$StreamFactory r3 = new com.bumptech.glide.load.model.StringLoader$StreamFactory
            r3.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r2, r7, r3)
            com.bumptech.glide.load.model.StringLoader$FileDescriptorFactory r3 = new com.bumptech.glide.load.model.StringLoader$FileDescriptorFactory
            r3.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r2, r13, r3)
            com.bumptech.glide.load.model.StringLoader$AssetFileDescriptorFactory r3 = new com.bumptech.glide.load.model.StringLoader$AssetFileDescriptorFactory
            r3.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r2, r6, r3)
            com.bumptech.glide.load.model.AssetUriLoader$StreamFactory r2 = new com.bumptech.glide.load.model.AssetUriLoader$StreamFactory
            android.content.res.AssetManager r3 = r24.getAssets()
            r2.<init>(r3)
            com.bumptech.glide.Registry r0 = r0.append(r4, r7, r2)
            com.bumptech.glide.load.model.AssetUriLoader$FileDescriptorFactory r2 = new com.bumptech.glide.load.model.AssetUriLoader$FileDescriptorFactory
            android.content.res.AssetManager r3 = r24.getAssets()
            r2.<init>(r3)
            com.bumptech.glide.Registry r0 = r0.append(r4, r6, r2)
            com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader$Factory r2 = new com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader$Factory
            r3 = r24
            r8 = r28
            r2.<init>(r3)
            com.bumptech.glide.Registry r0 = r0.append(r4, r7, r2)
            com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader$Factory r2 = new com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader$Factory
            r2.<init>(r3)
            r0.append(r4, r7, r2)
            r0 = 29
            r2 = r17
            if (r2 < r0) goto L_0x0285
            com.bumptech.glide.load.model.stream.QMediaStoreUriLoader$InputStreamFactory r0 = new com.bumptech.glide.load.model.stream.QMediaStoreUriLoader$InputStreamFactory
            r0.<init>(r3)
            r1.append(r4, r7, r0)
            com.bumptech.glide.load.model.stream.QMediaStoreUriLoader$FileDescriptorFactory r0 = new com.bumptech.glide.load.model.stream.QMediaStoreUriLoader$FileDescriptorFactory
            r0.<init>(r3)
            r1.append(r4, r13, r0)
        L_0x0285:
            com.bumptech.glide.load.model.UriLoader$StreamFactory r0 = new com.bumptech.glide.load.model.UriLoader$StreamFactory
            r11 = r19
            r0.<init>(r11)
            com.bumptech.glide.Registry r0 = r1.append(r4, r7, r0)
            com.bumptech.glide.load.model.UriLoader$FileDescriptorFactory r12 = new com.bumptech.glide.load.model.UriLoader$FileDescriptorFactory
            r12.<init>(r11)
            com.bumptech.glide.Registry r0 = r0.append(r4, r13, r12)
            com.bumptech.glide.load.model.UriLoader$AssetFileDescriptorFactory r12 = new com.bumptech.glide.load.model.UriLoader$AssetFileDescriptorFactory
            r12.<init>(r11)
            com.bumptech.glide.Registry r0 = r0.append(r4, r6, r12)
            com.bumptech.glide.load.model.UrlUriLoader$StreamFactory r6 = new com.bumptech.glide.load.model.UrlUriLoader$StreamFactory
            r6.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r4, r7, r6)
            com.bumptech.glide.load.model.stream.UrlLoader$StreamFactory r6 = new com.bumptech.glide.load.model.stream.UrlLoader$StreamFactory
            r6.<init>()
            java.lang.Class<java.net.URL> r11 = java.net.URL.class
            com.bumptech.glide.Registry r0 = r0.append(r11, r7, r6)
            com.bumptech.glide.load.model.MediaStoreFileLoader$Factory r6 = new com.bumptech.glide.load.model.MediaStoreFileLoader$Factory
            r6.<init>(r3)
            com.bumptech.glide.Registry r0 = r0.append(r4, r10, r6)
            com.bumptech.glide.load.model.stream.HttpGlideUrlLoader$Factory r3 = new com.bumptech.glide.load.model.stream.HttpGlideUrlLoader$Factory
            r3.<init>()
            java.lang.Class<com.bumptech.glide.load.model.GlideUrl> r6 = com.bumptech.glide.load.model.GlideUrl.class
            com.bumptech.glide.Registry r0 = r0.append(r6, r7, r3)
            com.bumptech.glide.load.model.ByteArrayLoader$ByteBufferFactory r3 = new com.bumptech.glide.load.model.ByteArrayLoader$ByteBufferFactory
            r3.<init>()
            java.lang.Class<byte[]> r6 = byte[].class
            com.bumptech.glide.Registry r0 = r0.append(r6, r14, r3)
            com.bumptech.glide.load.model.ByteArrayLoader$StreamFactory r3 = new com.bumptech.glide.load.model.ByteArrayLoader$StreamFactory
            r3.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r6, r7, r3)
            com.bumptech.glide.load.model.UnitModelLoader$Factory r3 = com.bumptech.glide.load.model.UnitModelLoader.Factory.getInstance()
            com.bumptech.glide.Registry r0 = r0.append(r4, r4, r3)
            com.bumptech.glide.load.model.UnitModelLoader$Factory r3 = com.bumptech.glide.load.model.UnitModelLoader.Factory.getInstance()
            com.bumptech.glide.Registry r0 = r0.append(r9, r9, r3)
            com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder r3 = new com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder
            r3.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r9, r9, r3)
            com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder r3 = new com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder
            r3.<init>((android.content.res.Resources) r5)
            r4 = r20
            com.bumptech.glide.Registry r0 = r0.register(r15, r4, r3)
            com.bumptech.glide.Registry r0 = r0.register(r15, r6, r8)
            com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder r3 = new com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder
            r7 = r26
            r10 = r18
            r3.<init>(r7, r8, r10)
            com.bumptech.glide.Registry r0 = r0.register(r9, r6, r3)
            r3 = r16
            r0.register(r3, r6, r10)
            r0 = 23
            if (r2 < r0) goto L_0x032b
            com.bumptech.glide.load.ResourceDecoder r0 = com.bumptech.glide.load.resource.bitmap.VideoDecoder.byteBuffer(r26)
            r1.append(r14, r15, r0)
            com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder r2 = new com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder
            r2.<init>((android.content.res.Resources) r5, r0)
            r1.append(r14, r4, r2)
        L_0x032b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.RegistryFactory.initializeDefaults(android.content.Context, com.bumptech.glide.Registry, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool, com.bumptech.glide.GlideExperiments):void");
    }

    private static void initializeModules(Context context, Glide glide, Registry registry, List<GlideModule> list, AppGlideModule appGlideModule) {
        for (GlideModule next : list) {
            try {
                next.registerComponents(context, glide, registry);
            } catch (AbstractMethodError e10) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + next.getClass().getName(), e10);
            }
        }
        if (appGlideModule != null) {
            appGlideModule.registerComponents(context, glide, registry);
        }
    }

    public static GlideSuppliers.GlideSupplier<Registry> lazilyCreateAndInitializeRegistry(final Glide glide, final List<GlideModule> list, final AppGlideModule appGlideModule) {
        return new GlideSuppliers.GlideSupplier<Registry>() {
            private boolean isInitializing;

            public Registry get() {
                if (!this.isInitializing) {
                    b.a("Glide registry");
                    this.isInitializing = true;
                    try {
                        return RegistryFactory.createAndInitRegistry(Glide.this, list, appGlideModule);
                    } finally {
                        this.isInitializing = false;
                        b.b();
                    }
                } else {
                    throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
                }
            }
        };
    }
}
