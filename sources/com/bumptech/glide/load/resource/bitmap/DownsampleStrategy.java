package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Option;

public abstract class DownsampleStrategy {
    public static final DownsampleStrategy AT_LEAST = new AtLeast();
    public static final DownsampleStrategy AT_MOST = new AtMost();
    public static final DownsampleStrategy CENTER_INSIDE = new CenterInside();
    public static final DownsampleStrategy CENTER_OUTSIDE;
    public static final DownsampleStrategy DEFAULT;
    public static final DownsampleStrategy FIT_CENTER = new FitCenter();
    static final boolean IS_BITMAP_FACTORY_SCALING_SUPPORTED = true;
    public static final DownsampleStrategy NONE = new None();
    public static final Option<DownsampleStrategy> OPTION;

    public static class AtLeast extends DownsampleStrategy {
        public SampleSizeRounding getSampleSizeRounding(int i10, int i11, int i12, int i13) {
            return SampleSizeRounding.QUALITY;
        }

        public float getScaleFactor(int i10, int i11, int i12, int i13) {
            int min = Math.min(i11 / i13, i10 / i12);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(min));
        }
    }

    public static class AtMost extends DownsampleStrategy {
        public SampleSizeRounding getSampleSizeRounding(int i10, int i11, int i12, int i13) {
            return SampleSizeRounding.MEMORY;
        }

        public float getScaleFactor(int i10, int i11, int i12, int i13) {
            int ceil = (int) Math.ceil((double) Math.max(((float) i11) / ((float) i13), ((float) i10) / ((float) i12)));
            int i14 = 1;
            int max = Math.max(1, Integer.highestOneBit(ceil));
            if (max >= ceil) {
                i14 = 0;
            }
            return 1.0f / ((float) (max << i14));
        }
    }

    public static class CenterInside extends DownsampleStrategy {
        public SampleSizeRounding getSampleSizeRounding(int i10, int i11, int i12, int i13) {
            if (getScaleFactor(i10, i11, i12, i13) == 1.0f) {
                return SampleSizeRounding.QUALITY;
            }
            return DownsampleStrategy.FIT_CENTER.getSampleSizeRounding(i10, i11, i12, i13);
        }

        public float getScaleFactor(int i10, int i11, int i12, int i13) {
            return Math.min(1.0f, DownsampleStrategy.FIT_CENTER.getScaleFactor(i10, i11, i12, i13));
        }
    }

    public static class CenterOutside extends DownsampleStrategy {
        public SampleSizeRounding getSampleSizeRounding(int i10, int i11, int i12, int i13) {
            return SampleSizeRounding.QUALITY;
        }

        public float getScaleFactor(int i10, int i11, int i12, int i13) {
            return Math.max(((float) i12) / ((float) i10), ((float) i13) / ((float) i11));
        }
    }

    public static class FitCenter extends DownsampleStrategy {
        public SampleSizeRounding getSampleSizeRounding(int i10, int i11, int i12, int i13) {
            if (DownsampleStrategy.IS_BITMAP_FACTORY_SCALING_SUPPORTED) {
                return SampleSizeRounding.QUALITY;
            }
            return SampleSizeRounding.MEMORY;
        }

        public float getScaleFactor(int i10, int i11, int i12, int i13) {
            if (DownsampleStrategy.IS_BITMAP_FACTORY_SCALING_SUPPORTED) {
                return Math.min(((float) i12) / ((float) i10), ((float) i13) / ((float) i11));
            }
            int max = Math.max(i11 / i13, i10 / i12);
            if (max == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(max));
        }
    }

    public static class None extends DownsampleStrategy {
        public SampleSizeRounding getSampleSizeRounding(int i10, int i11, int i12, int i13) {
            return SampleSizeRounding.QUALITY;
        }

        public float getScaleFactor(int i10, int i11, int i12, int i13) {
            return 1.0f;
        }
    }

    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    static {
        CenterOutside centerOutside = new CenterOutside();
        CENTER_OUTSIDE = centerOutside;
        DEFAULT = centerOutside;
        OPTION = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", centerOutside);
    }

    public abstract SampleSizeRounding getSampleSizeRounding(int i10, int i11, int i12, int i13);

    public abstract float getScaleFactor(int i10, int i11, int i12, int i13);
}
