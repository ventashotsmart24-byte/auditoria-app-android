package com.hpplay.glide.load.engine.prefill;

import android.graphics.Bitmap;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

public final class PreFillType {
    static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.RGB_565;
    private final Bitmap.Config config;
    private final int height;
    private final int weight;
    private final int width;

    public static class Builder {
        private Bitmap.Config config;
        private final int height;
        private int weight;
        private final int width;

        public Builder(int i10) {
            this(i10, i10);
        }

        public PreFillType build() {
            return new PreFillType(this.width, this.height, this.config, this.weight);
        }

        public Bitmap.Config getConfig() {
            return this.config;
        }

        public Builder setConfig(Bitmap.Config config2) {
            this.config = config2;
            return this;
        }

        public Builder setWeight(int i10) {
            if (i10 > 0) {
                this.weight = i10;
                return this;
            }
            throw new IllegalArgumentException("Weight must be > 0");
        }

        public Builder(int i10, int i11) {
            this.weight = 1;
            if (i10 <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            } else if (i11 > 0) {
                this.width = i10;
                this.height = i11;
            } else {
                throw new IllegalArgumentException("Height must be > 0");
            }
        }
    }

    public PreFillType(int i10, int i11, Bitmap.Config config2, int i12) {
        if (config2 != null) {
            this.width = i10;
            this.height = i11;
            this.config = config2;
            this.weight = i12;
            return;
        }
        throw new NullPointerException("Config must not be null");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PreFillType)) {
            return false;
        }
        PreFillType preFillType = (PreFillType) obj;
        if (this.height == preFillType.height && this.width == preFillType.width && this.weight == preFillType.weight && this.config == preFillType.config) {
            return true;
        }
        return false;
    }

    public Bitmap.Config getConfig() {
        return this.config;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((this.width * 31) + this.height) * 31) + this.config.hashCode()) * 31) + this.weight;
    }

    public String toString() {
        return "PreFillSize{width=" + this.width + ", height=" + this.height + ", config=" + this.config + ", weight=" + this.weight + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
