package com.hpplay.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

public class MemorySizeCalculator {
    static final int BITMAP_POOL_TARGET_SCREENS = 4;
    static final int BYTES_PER_ARGB_8888_PIXEL = 4;
    static final float LOW_MEMORY_MAX_SIZE_MULTIPLIER = 0.33f;
    static final float MAX_SIZE_MULTIPLIER = 0.4f;
    static final int MEMORY_CACHE_TARGET_SCREENS = 2;
    private static final String TAG = "MemorySizeCalculator";
    private final int bitmapPoolSize;
    private final Context context;
    private final int memoryCacheSize;

    public static class DisplayMetricsScreenDimensions implements ScreenDimensions {
        private final DisplayMetrics displayMetrics;

        public DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics2) {
            this.displayMetrics = displayMetrics2;
        }

        public int getHeightPixels() {
            return this.displayMetrics.heightPixels;
        }

        public int getWidthPixels() {
            return this.displayMetrics.widthPixels;
        }
    }

    public interface ScreenDimensions {
        int getHeightPixels();

        int getWidthPixels();
    }

    public MemorySizeCalculator(Context context2) {
        this(context2, (ActivityManager) context2.getSystemService("activity"), new DisplayMetricsScreenDimensions(context2.getResources().getDisplayMetrics()));
    }

    private static int getMaxSize(ActivityManager activityManager) {
        float f10;
        boolean isLowMemoryDevice = isLowMemoryDevice(activityManager);
        float memoryClass = (float) (activityManager.getMemoryClass() * 1024 * 1024);
        if (isLowMemoryDevice) {
            f10 = LOW_MEMORY_MAX_SIZE_MULTIPLIER;
        } else {
            f10 = 0.4f;
        }
        return Math.round(memoryClass * f10);
    }

    private static boolean isLowMemoryDevice(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private String toMb(int i10) {
        return Formatter.formatFileSize(this.context, (long) i10);
    }

    public int getBitmapPoolSize() {
        return this.bitmapPoolSize;
    }

    public int getMemoryCacheSize() {
        return this.memoryCacheSize;
    }

    public MemorySizeCalculator(Context context2, ActivityManager activityManager, ScreenDimensions screenDimensions) {
        this.context = context2;
        int maxSize = getMaxSize(activityManager);
        int widthPixels = screenDimensions.getWidthPixels() * screenDimensions.getHeightPixels() * 4;
        int i10 = widthPixels * 4;
        int i11 = widthPixels * 2;
        int i12 = i11 + i10;
        if (i12 <= maxSize) {
            this.memoryCacheSize = i11;
            this.bitmapPoolSize = i10;
        } else {
            int round = Math.round(((float) maxSize) / 6.0f);
            this.memoryCacheSize = round * 2;
            this.bitmapPoolSize = round * 4;
        }
        if (Log.isLoggable(TAG, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculated memory cache size: ");
            sb.append(toMb(this.memoryCacheSize));
            sb.append(" pool size: ");
            sb.append(toMb(this.bitmapPoolSize));
            sb.append(" memory class limited? ");
            sb.append(i12 > maxSize);
            sb.append(" max size: ");
            sb.append(toMb(maxSize));
            sb.append(" memoryClass: ");
            sb.append(activityManager.getMemoryClass());
            sb.append(" isLowMemoryDevice: ");
            sb.append(isLowMemoryDevice(activityManager));
        }
    }
}
