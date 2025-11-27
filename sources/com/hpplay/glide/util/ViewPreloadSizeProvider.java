package com.hpplay.glide.util;

import android.view.View;
import com.hpplay.glide.ListPreloader;
import com.hpplay.glide.request.animation.GlideAnimation;
import com.hpplay.glide.request.target.SizeReadyCallback;
import com.hpplay.glide.request.target.ViewTarget;
import java.util.Arrays;

public class ViewPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T>, SizeReadyCallback {
    private int[] size;
    private SizeViewTarget viewTarget;

    public static final class SizeViewTarget extends ViewTarget<View, Object> {
        public SizeViewTarget(View view, SizeReadyCallback sizeReadyCallback) {
            super(view);
            getSize(sizeReadyCallback);
        }

        public void onResourceReady(Object obj, GlideAnimation glideAnimation) {
        }
    }

    public ViewPreloadSizeProvider() {
    }

    public int[] getPreloadSize(T t10, int i10, int i11) {
        int[] iArr = this.size;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public void onSizeReady(int i10, int i11) {
        this.size = new int[]{i10, i11};
        this.viewTarget = null;
    }

    public void setView(View view) {
        if (this.size == null && this.viewTarget == null) {
            this.viewTarget = new SizeViewTarget(view, this);
        }
    }

    public ViewPreloadSizeProvider(View view) {
        setView(view);
    }
}
