package com.hpplay.glide;

import com.hpplay.glide.RequestManager;
import com.hpplay.glide.load.model.ModelLoader;
import com.hpplay.glide.load.resource.gif.GifDrawable;
import com.hpplay.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.hpplay.glide.load.resource.transcode.ResourceTranscoder;
import java.io.InputStream;

public class GifTypeRequest<ModelType> extends GifRequestBuilder<ModelType> {
    private final RequestManager.OptionsApplier optionsApplier;
    private final ModelLoader<ModelType, InputStream> streamModelLoader;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GifTypeRequest(com.hpplay.glide.GenericRequestBuilder<ModelType, ?, ?, ?> r4, com.hpplay.glide.load.model.ModelLoader<ModelType, java.io.InputStream> r5, com.hpplay.glide.RequestManager.OptionsApplier r6) {
        /*
            r3 = this;
            com.hpplay.glide.Glide r0 = r4.glide
            r1 = 0
            java.lang.Class<com.hpplay.glide.load.resource.gif.GifDrawable> r2 = com.hpplay.glide.load.resource.gif.GifDrawable.class
            com.hpplay.glide.provider.FixedLoadProvider r0 = buildProvider(r0, r5, r2, r1)
            r3.<init>(r0, r2, r4)
            r3.streamModelLoader = r5
            r3.optionsApplier = r6
            r3.crossFade()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.glide.GifTypeRequest.<init>(com.hpplay.glide.GenericRequestBuilder, com.hpplay.glide.load.model.ModelLoader, com.hpplay.glide.RequestManager$OptionsApplier):void");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Class, java.lang.Class<R>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <A, R> com.hpplay.glide.provider.FixedLoadProvider<A, java.io.InputStream, com.hpplay.glide.load.resource.gif.GifDrawable, R> buildProvider(com.hpplay.glide.Glide r1, com.hpplay.glide.load.model.ModelLoader<A, java.io.InputStream> r2, java.lang.Class<R> r3, com.hpplay.glide.load.resource.transcode.ResourceTranscoder<com.hpplay.glide.load.resource.gif.GifDrawable, R> r4) {
        /*
            if (r2 != 0) goto L_0x0004
            r1 = 0
            return r1
        L_0x0004:
            java.lang.Class<com.hpplay.glide.load.resource.gif.GifDrawable> r0 = com.hpplay.glide.load.resource.gif.GifDrawable.class
            if (r4 != 0) goto L_0x000c
            com.hpplay.glide.load.resource.transcode.ResourceTranscoder r4 = r1.buildTranscoder(r0, r3)
        L_0x000c:
            java.lang.Class<java.io.InputStream> r3 = java.io.InputStream.class
            com.hpplay.glide.provider.DataLoadProvider r1 = r1.buildDataProvider(r3, r0)
            com.hpplay.glide.provider.FixedLoadProvider r3 = new com.hpplay.glide.provider.FixedLoadProvider
            r3.<init>(r2, r4, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.glide.GifTypeRequest.buildProvider(com.hpplay.glide.Glide, com.hpplay.glide.load.model.ModelLoader, java.lang.Class, com.hpplay.glide.load.resource.transcode.ResourceTranscoder):com.hpplay.glide.provider.FixedLoadProvider");
    }

    public GenericRequestBuilder<ModelType, InputStream, GifDrawable, byte[]> toBytes() {
        return transcode(new GifDrawableBytesTranscoder(), byte[].class);
    }

    public <R> GenericRequestBuilder<ModelType, InputStream, GifDrawable, R> transcode(ResourceTranscoder<GifDrawable, R> resourceTranscoder, Class<R> cls) {
        return this.optionsApplier.apply(new GenericRequestBuilder(buildProvider(this.glide, this.streamModelLoader, cls, resourceTranscoder), cls, this));
    }
}
