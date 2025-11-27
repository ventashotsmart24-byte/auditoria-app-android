package com.titan.thumbnail;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import h9.k;
import java.io.File;
import t9.i;

public final class PreviewUtil$loadPreview$1 extends ThumbTarget {
    final /* synthetic */ String $combineUrl;
    final /* synthetic */ ImageView $imageView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreviewUtil$loadPreview$1(ImageView imageView, String str, View view, String str2) {
        super(view, str2);
        this.$imageView = imageView;
        this.$combineUrl = str;
    }

    public void onLoadFailed(Drawable drawable) {
        ThumbnailCallback access$getMThumbnailCallback$p = PreviewUtil.mThumbnailCallback;
        if (access$getMThumbnailCallback$p != null) {
            access$getMThumbnailCallback$p.onBitmapPrepared(false, (Bitmap) null);
        }
    }

    public void onResourceReadyUrl(File file, String str) {
        i.h(file, "resource");
        i.h(str, "url");
        if (i.b(this.$imageView.getTag(), str)) {
            PreviewUtil previewUtil = PreviewUtil.INSTANCE;
            if (PreviewUtil.mSnapshotPosition != null) {
                String str2 = this.$combineUrl;
                k access$getMSnapshotPosition$p = PreviewUtil.mSnapshotPosition;
                if (access$getMSnapshotPosition$p == null) {
                    i.q();
                }
                previewUtil.loadPartialImg(file, str2, access$getMSnapshotPosition$p);
            }
        }
    }
}
