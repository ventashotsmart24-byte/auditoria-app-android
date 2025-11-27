package com.hpplay.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import com.hpplay.glide.gifdecoder.GifDecoder;
import com.hpplay.glide.gifdecoder.GifHeader;
import com.hpplay.glide.load.Transformation;
import com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool;
import com.hpplay.glide.load.resource.drawable.GlideDrawable;
import com.hpplay.glide.load.resource.gif.GifFrameLoader;

public class GifDrawable extends GlideDrawable implements GifFrameLoader.FrameCallback {
    private boolean applyGravity;
    private final GifDecoder decoder;
    private final Rect destRect;
    private final GifFrameLoader frameLoader;
    private boolean isRecycled;
    private boolean isRunning;
    private boolean isStarted;
    private boolean isVisible;
    private int loopCount;
    private int maxLoopCount;
    private final Paint paint;
    private final GifState state;

    public static class GifState extends Drawable.ConstantState {
        private static final int GRAVITY = 119;
        BitmapPool bitmapPool;
        GifDecoder.BitmapProvider bitmapProvider;
        Context context;
        byte[] data;
        Bitmap firstFrame;
        Transformation<Bitmap> frameTransformation;
        GifHeader gifHeader;
        int targetHeight;
        int targetWidth;

        public GifState(GifHeader gifHeader2, byte[] bArr, Context context2, Transformation<Bitmap> transformation, int i10, int i11, GifDecoder.BitmapProvider bitmapProvider2, BitmapPool bitmapPool2, Bitmap bitmap) {
            if (bitmap != null) {
                this.gifHeader = gifHeader2;
                this.data = bArr;
                this.bitmapPool = bitmapPool2;
                this.firstFrame = bitmap;
                this.context = context2.getApplicationContext();
                this.frameTransformation = transformation;
                this.targetWidth = i10;
                this.targetHeight = i11;
                this.bitmapProvider = bitmapProvider2;
                return;
            }
            throw new NullPointerException("The first frame of the GIF must not be null");
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        public Drawable newDrawable() {
            return new GifDrawable(this);
        }

        public GifState(GifState gifState) {
            if (gifState != null) {
                this.gifHeader = gifState.gifHeader;
                this.data = gifState.data;
                this.context = gifState.context;
                this.frameTransformation = gifState.frameTransformation;
                this.targetWidth = gifState.targetWidth;
                this.targetHeight = gifState.targetHeight;
                this.bitmapProvider = gifState.bitmapProvider;
                this.bitmapPool = gifState.bitmapPool;
                this.firstFrame = gifState.firstFrame;
            }
        }
    }

    public GifDrawable(Context context, GifDecoder.BitmapProvider bitmapProvider, BitmapPool bitmapPool, Transformation<Bitmap> transformation, int i10, int i11, GifHeader gifHeader, byte[] bArr, Bitmap bitmap) {
        this(new GifState(gifHeader, bArr, context, transformation, i10, i11, bitmapProvider, bitmapPool, bitmap));
    }

    private void reset() {
        this.frameLoader.clear();
        invalidateSelf();
    }

    private void resetLoopCount() {
        this.loopCount = 0;
    }

    private void startRunning() {
        if (this.decoder.getFrameCount() == 1) {
            invalidateSelf();
        } else if (!this.isRunning) {
            this.isRunning = true;
            this.frameLoader.start();
            invalidateSelf();
        }
    }

    private void stopRunning() {
        this.isRunning = false;
        this.frameLoader.stop();
    }

    public void draw(Canvas canvas) {
        if (!this.isRecycled) {
            if (this.applyGravity) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.destRect);
                this.applyGravity = false;
            }
            Bitmap currentFrame = this.frameLoader.getCurrentFrame();
            if (currentFrame == null) {
                currentFrame = this.state.firstFrame;
            }
            canvas.drawBitmap(currentFrame, (Rect) null, this.destRect, this.paint);
        }
    }

    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    public byte[] getData() {
        return this.state.data;
    }

    public GifDecoder getDecoder() {
        return this.decoder;
    }

    public Bitmap getFirstFrame() {
        return this.state.firstFrame;
    }

    public int getFrameCount() {
        return this.decoder.getFrameCount();
    }

    public Transformation<Bitmap> getFrameTransformation() {
        return this.state.frameTransformation;
    }

    public int getIntrinsicHeight() {
        return this.state.firstFrame.getHeight();
    }

    public int getIntrinsicWidth() {
        return this.state.firstFrame.getWidth();
    }

    public int getOpacity() {
        return -2;
    }

    public boolean isAnimated() {
        return true;
    }

    public boolean isRecycled() {
        return this.isRecycled;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.applyGravity = true;
    }

    public void onFrameReady(int i10) {
        if (getCallback() == null) {
            stop();
            reset();
            return;
        }
        invalidateSelf();
        if (i10 == this.decoder.getFrameCount() - 1) {
            this.loopCount++;
        }
        int i11 = this.maxLoopCount;
        if (i11 != -1 && this.loopCount >= i11) {
            stop();
        }
    }

    public void recycle() {
        this.isRecycled = true;
        GifState gifState = this.state;
        gifState.bitmapPool.put(gifState.firstFrame);
        this.frameLoader.clear();
        this.frameLoader.stop();
    }

    public void setAlpha(int i10) {
        this.paint.setAlpha(i10);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    public void setFrameTransformation(Transformation<Bitmap> transformation, Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("The first frame of the GIF must not be null");
        } else if (transformation != null) {
            GifState gifState = this.state;
            gifState.frameTransformation = transformation;
            gifState.firstFrame = bitmap;
            this.frameLoader.setFrameTransformation(transformation);
        } else {
            throw new NullPointerException("The frame transformation must not be null");
        }
    }

    public void setIsRunning(boolean z10) {
        this.isRunning = z10;
    }

    public void setLoopCount(int i10) {
        if (i10 <= 0 && i10 != -1 && i10 != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        } else if (i10 == 0) {
            this.maxLoopCount = this.decoder.getLoopCount();
        } else {
            this.maxLoopCount = i10;
        }
    }

    public boolean setVisible(boolean z10, boolean z11) {
        this.isVisible = z10;
        if (!z10) {
            stopRunning();
        } else if (this.isStarted) {
            startRunning();
        }
        return super.setVisible(z10, z11);
    }

    public void start() {
        this.isStarted = true;
        resetLoopCount();
        if (this.isVisible) {
            startRunning();
        }
    }

    public void stop() {
        this.isStarted = false;
        stopRunning();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GifDrawable(com.hpplay.glide.load.resource.gif.GifDrawable r12, android.graphics.Bitmap r13, com.hpplay.glide.load.Transformation<android.graphics.Bitmap> r14) {
        /*
            r11 = this;
            com.hpplay.glide.load.resource.gif.GifDrawable$GifState r10 = new com.hpplay.glide.load.resource.gif.GifDrawable$GifState
            com.hpplay.glide.load.resource.gif.GifDrawable$GifState r12 = r12.state
            com.hpplay.glide.gifdecoder.GifHeader r1 = r12.gifHeader
            byte[] r2 = r12.data
            android.content.Context r3 = r12.context
            int r5 = r12.targetWidth
            int r6 = r12.targetHeight
            com.hpplay.glide.gifdecoder.GifDecoder$BitmapProvider r7 = r12.bitmapProvider
            com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool r8 = r12.bitmapPool
            r0 = r10
            r4 = r14
            r9 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r11.<init>(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.glide.load.resource.gif.GifDrawable.<init>(com.hpplay.glide.load.resource.gif.GifDrawable, android.graphics.Bitmap, com.hpplay.glide.load.Transformation):void");
    }

    public GifDrawable(GifState gifState) {
        this.destRect = new Rect();
        this.isVisible = true;
        this.maxLoopCount = -1;
        if (gifState != null) {
            this.state = gifState;
            GifDecoder gifDecoder = new GifDecoder(gifState.bitmapProvider);
            this.decoder = gifDecoder;
            this.paint = new Paint();
            gifDecoder.setData(gifState.gifHeader, gifState.data);
            GifFrameLoader gifFrameLoader = new GifFrameLoader(gifState.context, this, gifDecoder, gifState.targetWidth, gifState.targetHeight);
            this.frameLoader = gifFrameLoader;
            gifFrameLoader.setFrameTransformation(gifState.frameTransformation);
            return;
        }
        throw new NullPointerException("GifState must not be null");
    }

    public GifDrawable(GifDecoder gifDecoder, GifFrameLoader gifFrameLoader, Bitmap bitmap, BitmapPool bitmapPool, Paint paint2) {
        this.destRect = new Rect();
        this.isVisible = true;
        this.maxLoopCount = -1;
        this.decoder = gifDecoder;
        this.frameLoader = gifFrameLoader;
        GifState gifState = new GifState((GifState) null);
        this.state = gifState;
        this.paint = paint2;
        gifState.bitmapPool = bitmapPool;
        gifState.firstFrame = bitmap;
    }
}
