package com.hpplay.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.hpplay.glide.GenericRequestBuilder;
import com.hpplay.glide.Glide;
import com.hpplay.glide.gifdecoder.GifDecoder;
import com.hpplay.glide.load.Key;
import com.hpplay.glide.load.Transformation;
import com.hpplay.glide.load.engine.DiskCacheStrategy;
import com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool;
import com.hpplay.glide.load.resource.NullEncoder;
import com.hpplay.glide.request.animation.GlideAnimation;
import com.hpplay.glide.request.target.SimpleTarget;
import com.hpplay.glide.request.target.Target;
import java.security.MessageDigest;
import java.util.UUID;

class GifFrameLoader {
    private final FrameCallback callback;
    private DelayTarget current;
    private final GifDecoder gifDecoder;
    private final Handler handler;
    private boolean isCleared;
    private boolean isLoadPending;
    private boolean isRunning;
    private GenericRequestBuilder<GifDecoder, GifDecoder, Bitmap, Bitmap> requestBuilder;

    public static class DelayTarget extends SimpleTarget<Bitmap> {
        private final Handler handler;
        /* access modifiers changed from: private */
        public final int index;
        private Bitmap resource;
        private final long targetTime;

        public DelayTarget(Handler handler2, int i10, long j10) {
            this.handler = handler2;
            this.index = i10;
            this.targetTime = j10;
        }

        public Bitmap getResource() {
            return this.resource;
        }

        public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
            this.resource = bitmap;
            this.handler.sendMessageAtTime(this.handler.obtainMessage(1, this), this.targetTime);
        }
    }

    public interface FrameCallback {
        void onFrameReady(int i10);
    }

    public class FrameLoaderCallback implements Handler.Callback {
        public static final int MSG_CLEAR = 2;
        public static final int MSG_DELAY = 1;

        private FrameLoaderCallback() {
        }

        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                GifFrameLoader.this.onFrameReady((DelayTarget) message.obj);
                return true;
            } else if (i10 != 2) {
                return false;
            } else {
                Glide.clear((Target<?>) (DelayTarget) message.obj);
                return false;
            }
        }
    }

    public static class FrameSignature implements Key {
        private final UUID uuid;

        public FrameSignature() {
            this(UUID.randomUUID());
        }

        public boolean equals(Object obj) {
            if (obj instanceof FrameSignature) {
                return ((FrameSignature) obj).uuid.equals(this.uuid);
            }
            return false;
        }

        public int hashCode() {
            return this.uuid.hashCode();
        }

        public void updateDiskCacheKey(MessageDigest messageDigest) {
            throw new UnsupportedOperationException("Not implemented");
        }

        public FrameSignature(UUID uuid2) {
            this.uuid = uuid2;
        }
    }

    public GifFrameLoader(Context context, FrameCallback frameCallback, GifDecoder gifDecoder2, int i10, int i11) {
        this(frameCallback, gifDecoder2, (Handler) null, getRequestBuilder(context, gifDecoder2, i10, i11, Glide.get(context).getBitmapPool()));
    }

    private static GenericRequestBuilder<GifDecoder, GifDecoder, Bitmap, Bitmap> getRequestBuilder(Context context, GifDecoder gifDecoder2, int i10, int i11, BitmapPool bitmapPool) {
        GifFrameResourceDecoder gifFrameResourceDecoder = new GifFrameResourceDecoder(bitmapPool);
        GifFrameModelLoader gifFrameModelLoader = new GifFrameModelLoader();
        return Glide.with(context).using(gifFrameModelLoader, GifDecoder.class).load(gifDecoder2).as(Bitmap.class).sourceEncoder(NullEncoder.get()).decoder(gifFrameResourceDecoder).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).override(i10, i11);
    }

    private void loadNextFrame() {
        if (this.isRunning && !this.isLoadPending) {
            this.isLoadPending = true;
            this.gifDecoder.advance();
            this.requestBuilder.signature(new FrameSignature()).into(new DelayTarget(this.handler, this.gifDecoder.getCurrentFrameIndex(), SystemClock.uptimeMillis() + ((long) this.gifDecoder.getNextDelay())));
        }
    }

    public void clear() {
        stop();
        DelayTarget delayTarget = this.current;
        if (delayTarget != null) {
            Glide.clear((Target<?>) delayTarget);
            this.current = null;
        }
        this.isCleared = true;
    }

    public Bitmap getCurrentFrame() {
        DelayTarget delayTarget = this.current;
        if (delayTarget != null) {
            return delayTarget.getResource();
        }
        return null;
    }

    public void onFrameReady(DelayTarget delayTarget) {
        if (this.isCleared) {
            this.handler.obtainMessage(2, delayTarget).sendToTarget();
            return;
        }
        DelayTarget delayTarget2 = this.current;
        this.current = delayTarget;
        this.callback.onFrameReady(delayTarget.index);
        if (delayTarget2 != null) {
            this.handler.obtainMessage(2, delayTarget2).sendToTarget();
        }
        this.isLoadPending = false;
        loadNextFrame();
    }

    public void setFrameTransformation(Transformation<Bitmap> transformation) {
        if (transformation != null) {
            this.requestBuilder = this.requestBuilder.transform(transformation);
            return;
        }
        throw new NullPointerException("Transformation must not be null");
    }

    public void start() {
        if (!this.isRunning) {
            this.isRunning = true;
            this.isCleared = false;
            loadNextFrame();
        }
    }

    public void stop() {
        this.isRunning = false;
    }

    public GifFrameLoader(FrameCallback frameCallback, GifDecoder gifDecoder2, Handler handler2, GenericRequestBuilder<GifDecoder, GifDecoder, Bitmap, Bitmap> genericRequestBuilder) {
        this.isRunning = false;
        this.isLoadPending = false;
        handler2 = handler2 == null ? new Handler(Looper.getMainLooper(), new FrameLoaderCallback()) : handler2;
        this.callback = frameCallback;
        this.gifDecoder = gifDecoder2;
        this.handler = handler2;
        this.requestBuilder = genericRequestBuilder;
    }
}
