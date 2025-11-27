package com.hpplay.glide;

import android.widget.AbsListView;
import com.hpplay.glide.request.animation.GlideAnimation;
import com.hpplay.glide.request.target.BaseTarget;
import com.hpplay.glide.request.target.SizeReadyCallback;
import com.hpplay.glide.request.target.Target;
import com.hpplay.glide.util.Util;
import java.util.List;
import java.util.Queue;

public class ListPreloader<T> implements AbsListView.OnScrollListener {
    private boolean isIncreasing;
    private int lastEnd;
    private int lastFirstVisible;
    private int lastStart;
    private final int maxPreload;
    private final PreloadSizeProvider<T> preloadDimensionProvider;
    private final PreloadModelProvider<T> preloadModelProvider;
    private final PreloadTargetQueue preloadTargetQueue;
    private int totalItemCount;

    public interface PreloadModelProvider<U> {
        List<U> getPreloadItems(int i10);

        GenericRequestBuilder getPreloadRequestBuilder(U u10);
    }

    public interface PreloadSizeProvider<T> {
        int[] getPreloadSize(T t10, int i10, int i11);
    }

    public static class PreloadTarget extends BaseTarget<Object> {
        /* access modifiers changed from: private */
        public int photoHeight;
        /* access modifiers changed from: private */
        public int photoWidth;

        private PreloadTarget() {
        }

        public void getSize(SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.onSizeReady(this.photoWidth, this.photoHeight);
        }

        public void onResourceReady(Object obj, GlideAnimation<? super Object> glideAnimation) {
        }
    }

    public static final class PreloadTargetQueue {
        private final Queue<PreloadTarget> queue;

        public PreloadTargetQueue(int i10) {
            this.queue = Util.createQueue(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                this.queue.offer(new PreloadTarget());
            }
        }

        public PreloadTarget next(int i10, int i11) {
            PreloadTarget poll = this.queue.poll();
            this.queue.offer(poll);
            int unused = poll.photoWidth = i10;
            int unused2 = poll.photoHeight = i11;
            return poll;
        }
    }

    @Deprecated
    public ListPreloader(int i10) {
        this.isIncreasing = true;
        this.preloadModelProvider = new PreloadModelProvider<T>() {
            public List<T> getPreloadItems(int i10) {
                return ListPreloader.this.getItems(i10, i10 + 1);
            }

            public GenericRequestBuilder getPreloadRequestBuilder(T t10) {
                return ListPreloader.this.getRequestBuilder(t10);
            }
        };
        this.preloadDimensionProvider = new PreloadSizeProvider<T>() {
            public int[] getPreloadSize(T t10, int i10, int i11) {
                return ListPreloader.this.getDimensions(t10);
            }
        };
        this.maxPreload = i10;
        this.preloadTargetQueue = new PreloadTargetQueue(i10 + 1);
    }

    private void cancelAll() {
        for (int i10 = 0; i10 < this.maxPreload; i10++) {
            Glide.clear((Target<?>) this.preloadTargetQueue.next(0, 0));
        }
    }

    private void preload(int i10, boolean z10) {
        if (this.isIncreasing != z10) {
            this.isIncreasing = z10;
            cancelAll();
        }
        preload(i10, (z10 ? this.maxPreload : -this.maxPreload) + i10);
    }

    private void preloadAdapterPosition(List<T> list, int i10, boolean z10) {
        int size = list.size();
        if (z10) {
            for (int i11 = 0; i11 < size; i11++) {
                preloadItem(list.get(i11), i10, i11);
            }
            return;
        }
        for (int i12 = size - 1; i12 >= 0; i12--) {
            preloadItem(list.get(i12), i10, i12);
        }
    }

    private void preloadItem(T t10, int i10, int i11) {
        int[] preloadSize = this.preloadDimensionProvider.getPreloadSize(t10, i10, i11);
        if (preloadSize != null) {
            this.preloadModelProvider.getPreloadRequestBuilder(t10).into(this.preloadTargetQueue.next(preloadSize[0], preloadSize[1]));
        }
    }

    @Deprecated
    public int[] getDimensions(T t10) {
        throw new IllegalStateException("You must either provide a PreloadDimensionProvider or override getDimensions()");
    }

    @Deprecated
    public List<T> getItems(int i10, int i11) {
        throw new IllegalStateException("You must either provide a PreloadModelProvider or override getItems()");
    }

    @Deprecated
    public GenericRequestBuilder getRequestBuilder(T t10) {
        throw new IllegalStateException("You must either provide a PreloadModelProvider, or override getRequestBuilder()");
    }

    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        this.totalItemCount = i12;
        int i13 = this.lastFirstVisible;
        if (i10 > i13) {
            preload(i11 + i10, true);
        } else if (i10 < i13) {
            preload(i10, false);
        }
        this.lastFirstVisible = i10;
    }

    public void onScrollStateChanged(AbsListView absListView, int i10) {
    }

    private void preload(int i10, int i11) {
        int i12;
        int i13;
        if (i10 < i11) {
            i12 = Math.max(this.lastEnd, i10);
            i13 = i11;
        } else {
            i13 = Math.min(this.lastStart, i10);
            i12 = i11;
        }
        int min = Math.min(this.totalItemCount, i13);
        int min2 = Math.min(this.totalItemCount, Math.max(0, i12));
        if (i10 < i11) {
            for (int i14 = min2; i14 < min; i14++) {
                preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i14), i14, true);
            }
        } else {
            for (int i15 = min - 1; i15 >= min2; i15--) {
                preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i15), i15, false);
            }
        }
        this.lastStart = min2;
        this.lastEnd = min;
    }

    public ListPreloader(PreloadModelProvider<T> preloadModelProvider2, PreloadSizeProvider<T> preloadSizeProvider, int i10) {
        this.isIncreasing = true;
        this.preloadModelProvider = preloadModelProvider2;
        this.preloadDimensionProvider = preloadSizeProvider;
        this.maxPreload = i10;
        this.preloadTargetQueue = new PreloadTargetQueue(i10 + 1);
    }
}
