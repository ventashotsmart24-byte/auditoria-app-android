package com.hpplay.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import com.hpplay.glide.load.Encoder;
import com.hpplay.glide.load.Key;
import com.hpplay.glide.load.ResourceDecoder;
import com.hpplay.glide.load.ResourceEncoder;
import com.hpplay.glide.load.Transformation;
import com.hpplay.glide.load.engine.DiskCacheStrategy;
import com.hpplay.glide.load.resource.bitmap.BitmapTransformation;
import com.hpplay.glide.load.resource.gif.GifDrawable;
import com.hpplay.glide.load.resource.gif.GifDrawableTransformation;
import com.hpplay.glide.load.resource.transcode.ResourceTranscoder;
import com.hpplay.glide.provider.LoadProvider;
import com.hpplay.glide.request.RequestListener;
import com.hpplay.glide.request.animation.DrawableCrossFadeFactory;
import com.hpplay.glide.request.animation.ViewPropertyAnimation;
import java.io.File;
import java.io.InputStream;

public class GifRequestBuilder<ModelType> extends GenericRequestBuilder<ModelType, InputStream, GifDrawable, GifDrawable> implements BitmapOptions, DrawableOptions {
    public GifRequestBuilder(LoadProvider<ModelType, InputStream, GifDrawable, GifDrawable> loadProvider, Class<GifDrawable> cls, GenericRequestBuilder<ModelType, ?, ?, ?> genericRequestBuilder) {
        super(loadProvider, cls, genericRequestBuilder);
    }

    private GifDrawableTransformation[] toGifTransformations(Transformation<Bitmap>[] transformationArr) {
        GifDrawableTransformation[] gifDrawableTransformationArr = new GifDrawableTransformation[transformationArr.length];
        for (int i10 = 0; i10 < transformationArr.length; i10++) {
            gifDrawableTransformationArr[i10] = new GifDrawableTransformation(transformationArr[i10], this.glide.getBitmapPool());
        }
        return gifDrawableTransformationArr;
    }

    public void applyCenterCrop() {
        centerCrop();
    }

    public void applyFitCenter() {
        fitCenter();
    }

    public GifRequestBuilder<ModelType> transformFrame(BitmapTransformation... bitmapTransformationArr) {
        return transform((Transformation[]) toGifTransformations(bitmapTransformationArr));
    }

    public GifRequestBuilder<ModelType> cacheDecoder(ResourceDecoder<File, GifDrawable> resourceDecoder) {
        super.cacheDecoder(resourceDecoder);
        return this;
    }

    public GifRequestBuilder<ModelType> centerCrop() {
        return transformFrame(this.glide.getBitmapCenterCrop());
    }

    public GifRequestBuilder<ModelType> decoder(ResourceDecoder<InputStream, GifDrawable> resourceDecoder) {
        super.decoder(resourceDecoder);
        return this;
    }

    public GifRequestBuilder<ModelType> diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        super.diskCacheStrategy(diskCacheStrategy);
        return this;
    }

    public GifRequestBuilder<ModelType> dontAnimate() {
        super.dontAnimate();
        return this;
    }

    public GifRequestBuilder<ModelType> dontTransform() {
        super.dontTransform();
        return this;
    }

    public GifRequestBuilder<ModelType> encoder(ResourceEncoder<GifDrawable> resourceEncoder) {
        super.encoder(resourceEncoder);
        return this;
    }

    public GifRequestBuilder<ModelType> fitCenter() {
        return transformFrame(this.glide.getBitmapFitCenter());
    }

    public GifRequestBuilder<ModelType> listener(RequestListener<? super ModelType, GifDrawable> requestListener) {
        super.listener(requestListener);
        return this;
    }

    public GifRequestBuilder<ModelType> load(ModelType modeltype) {
        super.load(modeltype);
        return this;
    }

    public GifRequestBuilder<ModelType> override(int i10, int i11) {
        super.override(i10, i11);
        return this;
    }

    public GifRequestBuilder<ModelType> priority(Priority priority) {
        super.priority(priority);
        return this;
    }

    public GifRequestBuilder<ModelType> signature(Key key) {
        super.signature(key);
        return this;
    }

    public GifRequestBuilder<ModelType> sizeMultiplier(float f10) {
        super.sizeMultiplier(f10);
        return this;
    }

    public GifRequestBuilder<ModelType> skipMemoryCache(boolean z10) {
        super.skipMemoryCache(z10);
        return this;
    }

    public GifRequestBuilder<ModelType> sourceEncoder(Encoder<InputStream> encoder) {
        super.sourceEncoder(encoder);
        return this;
    }

    public GifRequestBuilder<ModelType> transcoder(ResourceTranscoder<GifDrawable, GifDrawable> resourceTranscoder) {
        super.transcoder(resourceTranscoder);
        return this;
    }

    public GifRequestBuilder<ModelType> transform(Transformation<GifDrawable>... transformationArr) {
        super.transform(transformationArr);
        return this;
    }

    public GifRequestBuilder<ModelType> transformFrame(Transformation<Bitmap>... transformationArr) {
        return transform((Transformation[]) toGifTransformations(transformationArr));
    }

    public GifRequestBuilder<ModelType> clone() {
        return (GifRequestBuilder) super.clone();
    }

    public GifRequestBuilder<ModelType> error(int i10) {
        super.error(i10);
        return this;
    }

    public GifRequestBuilder<ModelType> fallback(Drawable drawable) {
        super.fallback(drawable);
        return this;
    }

    public GifRequestBuilder<ModelType> placeholder(int i10) {
        super.placeholder(i10);
        return this;
    }

    public GifRequestBuilder<ModelType> thumbnail(GenericRequestBuilder<?, ?, ?, GifDrawable> genericRequestBuilder) {
        super.thumbnail(genericRequestBuilder);
        return this;
    }

    public GifRequestBuilder<ModelType> animate(int i10) {
        super.animate(i10);
        return this;
    }

    public GifRequestBuilder<ModelType> error(Drawable drawable) {
        super.error(drawable);
        return this;
    }

    public GifRequestBuilder<ModelType> fallback(int i10) {
        super.fallback(i10);
        return this;
    }

    public GifRequestBuilder<ModelType> placeholder(Drawable drawable) {
        super.placeholder(drawable);
        return this;
    }

    public GifRequestBuilder<ModelType> thumbnail(GifRequestBuilder<?> gifRequestBuilder) {
        super.thumbnail(gifRequestBuilder);
        return this;
    }

    @Deprecated
    public GifRequestBuilder<ModelType> animate(Animation animation) {
        super.animate(animation);
        return this;
    }

    public GifRequestBuilder<ModelType> crossFade() {
        super.animate(new DrawableCrossFadeFactory());
        return this;
    }

    public GifRequestBuilder<ModelType> thumbnail(float f10) {
        super.thumbnail(f10);
        return this;
    }

    public GifRequestBuilder<ModelType> animate(ViewPropertyAnimation.Animator animator) {
        super.animate(animator);
        return this;
    }

    public GifRequestBuilder<ModelType> crossFade(int i10) {
        super.animate(new DrawableCrossFadeFactory(i10));
        return this;
    }

    @Deprecated
    public GifRequestBuilder<ModelType> crossFade(Animation animation, int i10) {
        super.animate(new DrawableCrossFadeFactory(animation, i10));
        return this;
    }

    public GifRequestBuilder<ModelType> crossFade(int i10, int i11) {
        super.animate(new DrawableCrossFadeFactory(this.context, i10, i11));
        return this;
    }
}
