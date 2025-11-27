package com.bumptech.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.util.Preconditions;

public final class MemorySizeCalculator {
    static final int BYTES_PER_ARGB_8888_PIXEL = 4;
    private static final int LOW_MEMORY_BYTE_ARRAY_POOL_DIVISOR = 2;
    private static final String TAG = "MemorySizeCalculator";
    private final int arrayPoolSize;
    private final int bitmapPoolSize;
    private final Context context;
    private final int memoryCacheSize;

    public static final class Builder {
        static final int ARRAY_POOL_SIZE_BYTES = 4194304;
        static final int BITMAP_POOL_TARGET_SCREENS;
        static final float LOW_MEMORY_MAX_SIZE_MULTIPLIER = 0.33f;
        static final float MAX_SIZE_MULTIPLIER = 0.4f;
        static final int MEMORY_CACHE_TARGET_SCREENS = 2;
        ActivityManager activityManager;
        int arrayPoolSizeBytes = 4194304;
        float bitmapPoolScreens = ((float) BITMAP_POOL_TARGET_SCREENS);
        final Context context;
        float lowMemoryMaxSizeMultiplier = LOW_MEMORY_MAX_SIZE_MULTIPLIER;
        float maxSizeMultiplier = 0.4f;
        float memoryCacheScreens = 2.0f;
        ScreenDimensions screenDimensions;

        static {
            int i10;
            if (Build.VERSION.SDK_INT < 26) {
                i10 = 4;
            } else {
                i10 = 1;
            }
            BITMAP_POOL_TARGET_SCREENS = i10;
        }

        public Builder(Context context2) {
            this.context = context2;
            this.activityManager = (ActivityManager) context2.getSystemService("activity");
            this.screenDimensions = new DisplayMetricsScreenDimensions(context2.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && MemorySizeCalculator.isLowMemoryDevice(this.activityManager)) {
                this.bitmapPoolScreens = 0.0f;
            }
        }

        public MemorySizeCalculator build() {
            return new MemorySizeCalculator(this);
        }

        public Builder setActivityManager(ActivityManager activityManager2) {
            this.activityManager = activityManager2;
            return this;
        }

        public Builder setArrayPoolSize(int i10) {
            this.arrayPoolSizeBytes = i10;
            return this;
        }

        public Builder setBitmapPoolScreens(float f10) {
            boolean z10;
            if (f10 >= 0.0f) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "Bitmap pool screens must be greater than or equal to 0");
            this.bitmapPoolScreens = f10;
            return this;
        }

        public Builder setLowMemoryMaxSizeMultiplier(float f10) {
            boolean z10;
            if (f10 < 0.0f || f10 > 1.0f) {
                z10 = false;
            } else {
                z10 = true;
            }
            Preconditions.checkArgument(z10, "Low memory max size multiplier must be between 0 and 1");
            this.lowMemoryMaxSizeMultiplier = f10;
            return this;
        }

        public Builder setMaxSizeMultiplier(float f10) {
            boolean z10;
            if (f10 < 0.0f || f10 > 1.0f) {
                z10 = false;
            } else {
                z10 = true;
            }
            Preconditions.checkArgument(z10, "Size multiplier must be between 0 and 1");
            this.maxSizeMultiplier = f10;
            return this;
        }

        public Builder setMemoryCacheScreens(float f10) {
            boolean z10;
            if (f10 >= 0.0f) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "Memory cache screens must be greater than or equal to 0");
            this.memoryCacheScreens = f10;
            return this;
        }

        public Builder setScreenDimensions(ScreenDimensions screenDimensions2) {
            this.screenDimensions = screenDimensions2;
            return this;
        }
    }

    public static final class DisplayMetricsScreenDimensions implements ScreenDimensions {
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

    public MemorySizeCalculator(Builder builder) {
        int i10;
        boolean z10;
        this.context = builder.context;
        if (isLowMemoryDevice(builder.activityManager)) {
            i10 = builder.arrayPoolSizeBytes / 2;
        } else {
            i10 = builder.arrayPoolSizeBytes;
        }
        this.arrayPoolSize = i10;
        int maxSize = getMaxSize(builder.activityManager, builder.maxSizeMultiplier, builder.lowMemoryMaxSizeMultiplier);
        float widthPixels = (float) (builder.screenDimensions.getWidthPixels() * builder.screenDimensions.getHeightPixels() * 4);
        int round = Math.round(builder.bitmapPoolScreens * widthPixels);
        int round2 = Math.round(widthPixels * builder.memoryCacheScreens);
        int i11 = maxSize - i10;
        int i12 = round2 + round;
        if (i12 <= i11) {
            this.memoryCacheSize = round2;
            this.bitmapPoolSize = round;
        } else {
            float f10 = (float) i11;
            float f11 = builder.bitmapPoolScreens;
            float f12 = builder.memoryCacheScreens;
            float f13 = f10 / (f11 + f12);
            this.memoryCacheSize = Math.round(f12 * f13);
            this.bitmapPoolSize = Math.round(f13 * builder.bitmapPoolScreens);
        }
        if (Log.isLoggable(TAG, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(toMb(this.memoryCacheSize));
            sb.append(", pool size: ");
            sb.append(toMb(this.bitmapPoolSize));
            sb.append(", byte array size: ");
            sb.append(toMb(i10));
            sb.append(", memory class limited? ");
            if (i12 > maxSize) {
                z10 = true;
            } else {
                z10 = false;
            }
            sb.append(z10);
            sb.append(", max size: ");
            sb.append(toMb(maxSize));
            sb.append(", memoryClass: ");
            sb.append(builder.activityManager.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(isLowMemoryDevice(builder.activityManager));
        }
    }

    private static int getMaxSize(ActivityManager activityManager, float f10, float f11) {
        boolean isLowMemoryDevice = isLowMemoryDevice(activityManager);
        float memoryClass = (float) (activityManager.getMemoryClass() * 1024 * 1024);
        if (isLowMemoryDevice) {
            f10 = f11;
        }
        return Math.round(memoryClass * f10);
    }

    public static boolean isLowMemoryDevice(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private String toMb(int i10) {
        return Formatter.formatFileSize(this.context, (long) i10);
    }

    public int getArrayPoolSizeInBytes() {
        return this.arrayPoolSize;
    }

    public int getBitmapPoolSize() {
        return this.bitmapPoolSize;
    }

    public int getMemoryCacheSize() {
        return this.memoryCacheSize;
    }
}
