package com.hpplay.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LruBitmapPool implements BitmapPool {
    private static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    private static final String TAG = "LruBitmapPool";
    private final Set<Bitmap.Config> allowedConfigs;
    private int currentSize;
    private int evictions;
    private int hits;
    private final int initialMaxSize;
    private int maxSize;
    private int misses;
    private int puts;
    private final LruPoolStrategy strategy;
    private final BitmapTracker tracker;

    public interface BitmapTracker {
        void add(Bitmap bitmap);

        void remove(Bitmap bitmap);
    }

    public static class NullBitmapTracker implements BitmapTracker {
        private NullBitmapTracker() {
        }

        public void add(Bitmap bitmap) {
        }

        public void remove(Bitmap bitmap) {
        }
    }

    public static class ThrowingBitmapTracker implements BitmapTracker {
        private final Set<Bitmap> bitmaps = Collections.synchronizedSet(new HashSet());

        private ThrowingBitmapTracker() {
        }

        public void add(Bitmap bitmap) {
            if (!this.bitmaps.contains(bitmap)) {
                this.bitmaps.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }

        public void remove(Bitmap bitmap) {
            if (this.bitmaps.contains(bitmap)) {
                this.bitmaps.remove(bitmap);
                return;
            }
            throw new IllegalStateException("Cannot remove bitmap not in tracker");
        }
    }

    public LruBitmapPool(int i10, LruPoolStrategy lruPoolStrategy, Set<Bitmap.Config> set) {
        this.initialMaxSize = i10;
        this.maxSize = i10;
        this.strategy = lruPoolStrategy;
        this.allowedConfigs = set;
        this.tracker = new NullBitmapTracker();
    }

    private void dump() {
        if (Log.isLoggable(TAG, 2)) {
            dumpUnchecked();
        }
    }

    private void dumpUnchecked() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hits=");
        sb.append(this.hits);
        sb.append(", misses=");
        sb.append(this.misses);
        sb.append(", puts=");
        sb.append(this.puts);
        sb.append(", evictions=");
        sb.append(this.evictions);
        sb.append(", currentSize=");
        sb.append(this.currentSize);
        sb.append(", maxSize=");
        sb.append(this.maxSize);
        sb.append("\nStrategy=");
        sb.append(this.strategy);
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    private static Set<Bitmap.Config> getDefaultAllowedConfigs() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Bitmap.Config.values()));
        hashSet.add((Object) null);
        return Collections.unmodifiableSet(hashSet);
    }

    private static LruPoolStrategy getDefaultStrategy() {
        return new SizeConfigStrategy();
    }

    private synchronized void trimToSize(int i10) {
        while (this.currentSize > i10) {
            Bitmap removeLast = this.strategy.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable(TAG, 5)) {
                    dumpUnchecked();
                }
                this.currentSize = 0;
                return;
            }
            this.tracker.remove(removeLast);
            this.currentSize -= this.strategy.getSize(removeLast);
            removeLast.recycle();
            this.evictions++;
            if (Log.isLoggable(TAG, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Evicting bitmap=");
                sb.append(this.strategy.logBitmap(removeLast));
            }
            dump();
        }
    }

    public void clearMemory() {
        Log.isLoggable(TAG, 3);
        trimToSize(0);
    }

    public synchronized Bitmap get(int i10, int i11, Bitmap.Config config) {
        Bitmap dirty;
        dirty = getDirty(i10, i11, config);
        if (dirty != null) {
            dirty.eraseColor(0);
        }
        return dirty;
    }

    public synchronized Bitmap getDirty(int i10, int i11, Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap bitmap;
        LruPoolStrategy lruPoolStrategy = this.strategy;
        if (config != null) {
            config2 = config;
        } else {
            config2 = DEFAULT_CONFIG;
        }
        bitmap = lruPoolStrategy.get(i10, i11, config2);
        if (bitmap == null) {
            if (Log.isLoggable(TAG, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Missing bitmap=");
                sb.append(this.strategy.logBitmap(i10, i11, config));
            }
            this.misses++;
        } else {
            this.hits++;
            this.currentSize -= this.strategy.getSize(bitmap);
            this.tracker.remove(bitmap);
            bitmap.setHasAlpha(true);
        }
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Get bitmap=");
            sb2.append(this.strategy.logBitmap(i10, i11, config));
        }
        dump();
        return bitmap;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0099, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean put(android.graphics.Bitmap r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 == 0) goto L_0x009d
            boolean r0 = r5.isMutable()     // Catch:{ all -> 0x009b }
            r1 = 2
            if (r0 == 0) goto L_0x005f
            com.hpplay.glide.load.engine.bitmap_recycle.LruPoolStrategy r0 = r4.strategy     // Catch:{ all -> 0x009b }
            int r0 = r0.getSize(r5)     // Catch:{ all -> 0x009b }
            int r2 = r4.maxSize     // Catch:{ all -> 0x009b }
            if (r0 > r2) goto L_0x005f
            java.util.Set<android.graphics.Bitmap$Config> r0 = r4.allowedConfigs     // Catch:{ all -> 0x009b }
            android.graphics.Bitmap$Config r2 = r5.getConfig()     // Catch:{ all -> 0x009b }
            boolean r0 = r0.contains(r2)     // Catch:{ all -> 0x009b }
            if (r0 != 0) goto L_0x0021
            goto L_0x005f
        L_0x0021:
            com.hpplay.glide.load.engine.bitmap_recycle.LruPoolStrategy r0 = r4.strategy     // Catch:{ all -> 0x009b }
            int r0 = r0.getSize(r5)     // Catch:{ all -> 0x009b }
            com.hpplay.glide.load.engine.bitmap_recycle.LruPoolStrategy r2 = r4.strategy     // Catch:{ all -> 0x009b }
            r2.put(r5)     // Catch:{ all -> 0x009b }
            com.hpplay.glide.load.engine.bitmap_recycle.LruBitmapPool$BitmapTracker r2 = r4.tracker     // Catch:{ all -> 0x009b }
            r2.add(r5)     // Catch:{ all -> 0x009b }
            int r2 = r4.puts     // Catch:{ all -> 0x009b }
            r3 = 1
            int r2 = r2 + r3
            r4.puts = r2     // Catch:{ all -> 0x009b }
            int r2 = r4.currentSize     // Catch:{ all -> 0x009b }
            int r2 = r2 + r0
            r4.currentSize = r2     // Catch:{ all -> 0x009b }
            java.lang.String r0 = "LruBitmapPool"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x009b }
            if (r0 == 0) goto L_0x0057
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x009b }
            r0.<init>()     // Catch:{ all -> 0x009b }
            java.lang.String r1 = "Put bitmap in pool="
            r0.append(r1)     // Catch:{ all -> 0x009b }
            com.hpplay.glide.load.engine.bitmap_recycle.LruPoolStrategy r1 = r4.strategy     // Catch:{ all -> 0x009b }
            java.lang.String r5 = r1.logBitmap(r5)     // Catch:{ all -> 0x009b }
            r0.append(r5)     // Catch:{ all -> 0x009b }
        L_0x0057:
            r4.dump()     // Catch:{ all -> 0x009b }
            r4.evict()     // Catch:{ all -> 0x009b }
            monitor-exit(r4)
            return r3
        L_0x005f:
            java.lang.String r0 = "LruBitmapPool"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x009b }
            if (r0 == 0) goto L_0x0098
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x009b }
            r0.<init>()     // Catch:{ all -> 0x009b }
            java.lang.String r1 = "Reject bitmap from pool, bitmap: "
            r0.append(r1)     // Catch:{ all -> 0x009b }
            com.hpplay.glide.load.engine.bitmap_recycle.LruPoolStrategy r1 = r4.strategy     // Catch:{ all -> 0x009b }
            java.lang.String r1 = r1.logBitmap(r5)     // Catch:{ all -> 0x009b }
            r0.append(r1)     // Catch:{ all -> 0x009b }
            java.lang.String r1 = ", is mutable: "
            r0.append(r1)     // Catch:{ all -> 0x009b }
            boolean r1 = r5.isMutable()     // Catch:{ all -> 0x009b }
            r0.append(r1)     // Catch:{ all -> 0x009b }
            java.lang.String r1 = ", is allowed config: "
            r0.append(r1)     // Catch:{ all -> 0x009b }
            java.util.Set<android.graphics.Bitmap$Config> r1 = r4.allowedConfigs     // Catch:{ all -> 0x009b }
            android.graphics.Bitmap$Config r5 = r5.getConfig()     // Catch:{ all -> 0x009b }
            boolean r5 = r1.contains(r5)     // Catch:{ all -> 0x009b }
            r0.append(r5)     // Catch:{ all -> 0x009b }
        L_0x0098:
            monitor-exit(r4)
            r5 = 0
            return r5
        L_0x009b:
            r5 = move-exception
            goto L_0x00a5
        L_0x009d:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException     // Catch:{ all -> 0x009b }
            java.lang.String r0 = "Bitmap must not be null"
            r5.<init>(r0)     // Catch:{ all -> 0x009b }
            throw r5     // Catch:{ all -> 0x009b }
        L_0x00a5:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.glide.load.engine.bitmap_recycle.LruBitmapPool.put(android.graphics.Bitmap):boolean");
    }

    public synchronized void setSizeMultiplier(float f10) {
        this.maxSize = Math.round(((float) this.initialMaxSize) * f10);
        evict();
    }

    public void trimMemory(int i10) {
        if (Log.isLoggable(TAG, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("trimMemory, level=");
            sb.append(i10);
        }
        if (i10 >= 60) {
            clearMemory();
        } else if (i10 >= 40) {
            trimToSize(this.maxSize / 2);
        }
    }

    public LruBitmapPool(int i10) {
        this(i10, getDefaultStrategy(), getDefaultAllowedConfigs());
    }

    public LruBitmapPool(int i10, Set<Bitmap.Config> set) {
        this(i10, getDefaultStrategy(), set);
    }
}
