package com.titan.thumbnail;

import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import h9.k;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import t9.i;

public final class PreviewUtil {
    public static final PreviewUtil INSTANCE = new PreviewUtil();
    /* access modifiers changed from: private */
    public static final String TAG = PreviewUtil.class.getSimpleName();
    /* access modifiers changed from: private */
    public static InputStream mCombineIns;
    /* access modifiers changed from: private */
    public static String mCombineUrl = "";
    /* access modifiers changed from: private */
    public static BitmapRegionDecoder mDecoder;
    private static Handler mHandle;
    private static HandlerThread mHandlerThread;
    /* access modifiers changed from: private */
    public static k mSnapshotPosition;
    /* access modifiers changed from: private */
    public static ThumbnailCallback mThumbnailCallback;

    private PreviewUtil() {
    }

    private final InputStream bitmap2InputStream(Bitmap bitmap, int i10) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, i10, byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    /* access modifiers changed from: private */
    public final void loadPartialImg(File file, String str, k kVar) {
        Handler handler = mHandle;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        Handler handler2 = mHandle;
        if (handler2 != null) {
            handler2.post(new PreviewUtil$loadPartialImg$1(str, file, kVar));
        }
    }

    public final void loadPreview(ImageView imageView, long j10) {
        Looper looper;
        i.h(imageView, "imageView");
        if (mHandle == null) {
            HandlerThread handlerThread = new HandlerThread("PreviewUtil", 10);
            mHandlerThread = handlerThread;
            handlerThread.start();
            HandlerThread handlerThread2 = mHandlerThread;
            if (handlerThread2 != null) {
                looper = handlerThread2.getLooper();
            } else {
                looper = null;
            }
            mHandle = new Handler(looper);
        }
        ThumbnailUtil thumbnailUtil = ThumbnailUtil.INSTANCE;
        String combineUrl = thumbnailUtil.getCombineUrl(j10);
        mSnapshotPosition = thumbnailUtil.getSnapshotPosition(j10);
        imageView.setTag(combineUrl);
        Glide.with((View) imageView).downloadOnly().load(combineUrl).into(new PreviewUtil$loadPreview$1(imageView, combineUrl, imageView, combineUrl));
    }

    public final void recycle() {
        mCombineUrl = "";
        InputStream inputStream = mCombineIns;
        if (inputStream != null) {
            inputStream.close();
        }
        BitmapRegionDecoder bitmapRegionDecoder = mDecoder;
        if (bitmapRegionDecoder != null) {
            bitmapRegionDecoder.recycle();
        }
        Handler handler = mHandle;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        HandlerThread handlerThread = mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        mHandle = null;
        mHandlerThread = null;
    }

    public final void setPreviewCallback(ThumbnailCallback thumbnailCallback) {
        mThumbnailCallback = thumbnailCallback;
    }
}
