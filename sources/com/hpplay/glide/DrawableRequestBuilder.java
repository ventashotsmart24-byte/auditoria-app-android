package com.hpplay.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.hpplay.glide.load.Encoder;
import com.hpplay.glide.load.Key;
import com.hpplay.glide.load.ResourceDecoder;
import com.hpplay.glide.load.ResourceEncoder;
import com.hpplay.glide.load.Transformation;
import com.hpplay.glide.load.engine.DiskCacheStrategy;
import com.hpplay.glide.load.model.ImageVideoWrapper;
import com.hpplay.glide.load.resource.bitmap.BitmapTransformation;
import com.hpplay.glide.load.resource.drawable.GlideDrawable;
import com.hpplay.glide.load.resource.gifbitmap.GifBitmapWrapper;
import com.hpplay.glide.load.resource.gifbitmap.GifBitmapWrapperTransformation;
import com.hpplay.glide.load.resource.transcode.ResourceTranscoder;
import com.hpplay.glide.manager.Lifecycle;
import com.hpplay.glide.manager.RequestTracker;
import com.hpplay.glide.provider.LoadProvider;
import com.hpplay.glide.request.RequestListener;
import com.hpplay.glide.request.animation.DrawableCrossFadeFactory;
import com.hpplay.glide.request.animation.ViewPropertyAnimation;
import com.hpplay.glide.request.target.Target;
import java.io.File;

public class DrawableRequestBuilder<ModelType> extends GenericRequestBuilder<ModelType, ImageVideoWrapper, GifBitmapWrapper, GlideDrawable> implements BitmapOptions, DrawableOptions {
    public DrawableRequestBuilder(Context context, Class<ModelType> cls, LoadProvider<ModelType, ImageVideoWrapper, GifBitmapWrapper, GlideDrawable> loadProvider, Glide glide, RequestTracker requestTracker, Lifecycle lifecycle) {
        super(context, cls, loadProvider, GlideDrawable.class, glide, requestTracker, lifecycle);
        crossFade();
    }

    public void applyCenterCrop() {
        centerCrop();
    }

    public void applyFitCenter() {
        fitCenter();
    }

    public DrawableRequestBuilder<ModelType> bitmapTransform(Transformation<Bitmap>... transformationArr) {
        GifBitmapWrapperTransformation[] gifBitmapWrapperTransformationArr = new GifBitmapWrapperTransformation[transformationArr.length];
        for (int i10 = 0; i10 < transformationArr.length; i10++) {
            gifBitmapWrapperTransformationArr[i10] = new GifBitmapWrapperTransformation(this.glide.getBitmapPool(), transformationArr[i10]);
        }
        return transform((Transformation<GifBitmapWrapper>[]) gifBitmapWrapperTransformationArr);
    }

    public Target<GlideDrawable> into(ImageView imageView) {
        return super.into(imageView);
    }

    public DrawableRequestBuilder<ModelType> cacheDecoder(ResourceDecoder<File, GifBitmapWrapper> resourceDecoder) {
        super.cacheDecoder(resourceDecoder);
        return this;
    }

    public DrawableRequestBuilder<ModelType> centerCrop() {
        return transform((Transformation<GifBitmapWrapper>[]) new Transformation[]{this.glide.getDrawableCenterCrop()});
    }

    public DrawableRequestBuilder<ModelType> decoder(ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> resourceDecoder) {
        super.decoder(resourceDecoder);
        return this;
    }

    public DrawableRequestBuilder<ModelType> diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        super.diskCacheStrategy(diskCacheStrategy);
        return this;
    }

    public DrawableRequestBuilder<ModelType> dontAnimate() {
        super.dontAnimate();
        return this;
    }

    public DrawableRequestBuilder<ModelType> dontTransform() {
        super.dontTransform();
        return this;
    }

    public DrawableRequestBuilder<ModelType> encoder(ResourceEncoder<GifBitmapWrapper> resourceEncoder) {
        super.encoder(resourceEncoder);
        return this;
    }

    public DrawableRequestBuilder<ModelType> fitCenter() {
        return transform((Transformation<GifBitmapWrapper>[]) new Transformation[]{this.glide.getDrawableFitCenter()});
    }

    public DrawableRequestBuilder<ModelType> listener(RequestListener<? super ModelType, GlideDrawable> requestListener) {
        super.listener(requestListener);
        return this;
    }

    public DrawableRequestBuilder<ModelType> load(ModelType modeltype) {
        super.load(modeltype);
        return this;
    }

    public DrawableRequestBuilder<ModelType> override(int i10, int i11) {
        super.override(i10, i11);
        return this;
    }

    public DrawableRequestBuilder<ModelType> priority(Priority priority) {
        super.priority(priority);
        return this;
    }

    public DrawableRequestBuilder<ModelType> signature(Key key) {
        super.signature(key);
        return this;
    }

    public DrawableRequestBuilder<ModelType> sizeMultiplier(float f10) {
        super.sizeMultiplier(f10);
        return this;
    }

    public DrawableRequestBuilder<ModelType> skipMemoryCache(boolean z10) {
        super.skipMemoryCache(z10);
        return this;
    }

    public DrawableRequestBuilder<ModelType> sourceEncoder(Encoder<ImageVideoWrapper> encoder) {
        super.sourceEncoder(encoder);
        return this;
    }

    public DrawableRequestBuilder<ModelType> transcoder(ResourceTranscoder<GifBitmapWrapper, GlideDrawable> resourceTranscoder) {
        super.transcoder(resourceTranscoder);
        return this;
    }

    public DrawableRequestBuilder<ModelType> transform(BitmapTransformation... bitmapTransformationArr) {
        return bitmapTransform(bitmapTransformationArr);
    }

    public DrawableRequestBuilder<ModelType> clone() {
        return (DrawableRequestBuilder) super.clone();
    }

    public DrawableRequestBuilder<ModelType> error(int i10) {
        super.error(i10);
        return this;
    }

    public DrawableRequestBuilder<ModelType> fallback(Drawable drawable) {
        super.fallback(drawable);
        return this;
    }

    public DrawableRequestBuilder<ModelType> placeholder(int i10) {
        super.placeholder(i10);
        return this;
    }

    public DrawableRequestBuilder<ModelType> thumbnail(DrawableRequestBuilder<?> drawableRequestBuilder) {
        super.thumbnail(drawableRequestBuilder);
        return this;
    }

    public DrawableRequestBuilder<ModelType> transform(Transformation<GifBitmapWrapper>... transformationArr) {
        super.transform(transformationArr);
        return this;
    }

    public DrawableRequestBuilder<ModelType> animate(ViewPropertyAnimation.Animator animator) {
        super.animate(animator);
        return this;
    }

    public DrawableRequestBuilder<ModelType> error(Drawable drawable) {
        super.error(drawable);
        return this;
    }

    public DrawableRequestBuilder<ModelType> fallback(int i10) {
        super.fallback(i10);
        return this;
    }

    public DrawableRequestBuilder<ModelType> placeholder(Drawable drawable) {
        super.placeholder(drawable);
        return this;
    }

    public DrawableRequestBuilder<ModelType> thumbnail(GenericRequestBuilder<?, ?, ?, GlideDrawable> genericRequestBuilder) {
        super.thumbnail(genericRequestBuilder);
        return this;
    }

    public DrawableRequestBuilder<ModelType> animate(int i10) {
        super.animate(i10);
        return this;
    }

    public final DrawableRequestBuilder<ModelType> crossFade() {
        super.animate(new DrawableCrossFadeFactory());
        return this;
    }

    public DrawableRequestBuilder<ModelType> thumbnail(float f10) {
        super.thumbnail(f10);
        return this;
    }

    @Deprecated
    public DrawableRequestBuilder<ModelType> animate(Animation animation) {
        super.animate(animation);
        return this;
    }

    public DrawableRequestBuilder<ModelType> crossFade(int i10) {
        super.animate(new DrawableCrossFadeFactory(i10));
        return this;
    }

    @Deprecated
    public DrawableRequestBuilder<ModelType> crossFade(Animation animation, int i10) {
        super.animate(new DrawableCrossFadeFactory(animation, i10));
        return this;
    }

    public DrawableRequestBuilder<ModelType> crossFade(int i10, int i11) {
        super.animate(new DrawableCrossFadeFactory(this.context, i10, i11));
        return this;
    }
}
