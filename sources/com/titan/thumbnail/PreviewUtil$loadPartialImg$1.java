package com.titan.thumbnail;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import h9.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import t9.i;

public final class PreviewUtil$loadPartialImg$1 implements Runnable {
    final /* synthetic */ k $position;
    final /* synthetic */ File $resource;
    final /* synthetic */ String $url;

    public PreviewUtil$loadPartialImg$1(String str, File file, k kVar) {
        this.$url = str;
        this.$resource = file;
        this.$position = kVar;
    }

    public final void run() {
        int i10;
        int i11;
        Bitmap bitmap;
        ThumbnailCallback access$getMThumbnailCallback$p;
        try {
            PreviewUtil previewUtil = PreviewUtil.INSTANCE;
            if (!i.b(PreviewUtil.mCombineUrl, this.$url)) {
                InputStream access$getMCombineIns$p = PreviewUtil.mCombineIns;
                if (access$getMCombineIns$p != null) {
                    access$getMCombineIns$p.close();
                }
                BitmapRegionDecoder access$getMDecoder$p = PreviewUtil.mDecoder;
                if (access$getMDecoder$p != null) {
                    access$getMDecoder$p.recycle();
                }
                PreviewUtil.mCombineIns = new FileInputStream(this.$resource);
                PreviewUtil.mDecoder = BitmapRegionDecoder.newInstance(PreviewUtil.mCombineIns, false);
                PreviewUtil.mCombineUrl = this.$url;
            }
            BitmapRegionDecoder access$getMDecoder$p2 = PreviewUtil.mDecoder;
            if (access$getMDecoder$p2 != null) {
                i10 = access$getMDecoder$p2.getWidth();
            } else {
                i10 = 0;
            }
            BitmapRegionDecoder access$getMDecoder$p3 = PreviewUtil.mDecoder;
            if (access$getMDecoder$p3 != null) {
                i11 = access$getMDecoder$p3.getHeight();
            } else {
                i11 = 0;
            }
            Rect rect = new Rect();
            int intValue = ((Number) this.$position.a()).intValue();
            int intValue2 = ((Number) this.$position.b()).intValue();
            ThumbnailUtil thumbnailUtil = ThumbnailUtil.INSTANCE;
            int mHorizontalCount = i10 / thumbnailUtil.getMHorizontalCount();
            int mVerticalCount = i11 / thumbnailUtil.getMVerticalCount();
            rect.set(intValue * mHorizontalCount, intValue2 * mVerticalCount, (intValue + 1) * mHorizontalCount, (intValue2 + 1) * mVerticalCount);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            BitmapRegionDecoder access$getMDecoder$p4 = PreviewUtil.mDecoder;
            if (access$getMDecoder$p4 != null) {
                bitmap = access$getMDecoder$p4.decodeRegion(rect, options);
            } else {
                bitmap = null;
            }
            if (bitmap != null && (access$getMThumbnailCallback$p = PreviewUtil.mThumbnailCallback) != null) {
                access$getMThumbnailCallback$p.onBitmapPrepared(true, bitmap);
            }
        } catch (Exception e10) {
            ThumbnailCallback access$getMThumbnailCallback$p2 = PreviewUtil.mThumbnailCallback;
            if (access$getMThumbnailCallback$p2 != null) {
                access$getMThumbnailCallback$p2.onBitmapPrepared(false, (Bitmap) null);
            }
            e10.printStackTrace();
        }
    }
}
