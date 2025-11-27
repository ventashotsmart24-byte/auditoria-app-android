package com.google.firebase.inappmessaging.model;

import android.graphics.Bitmap;
import android.text.TextUtils;

public class ImageData {
    private final Bitmap bitmapData;
    private final String imageUrl;

    public static class Builder {
        private Bitmap bitmapData;
        private String imageUrl;

        public ImageData build() {
            if (!TextUtils.isEmpty(this.imageUrl)) {
                return new ImageData(this.imageUrl, this.bitmapData);
            }
            throw new IllegalArgumentException("ImageData model must have an imageUrl");
        }

        public Builder setBitmapData(Bitmap bitmap) {
            this.bitmapData = bitmap;
            return this;
        }

        public Builder setImageUrl(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.imageUrl = str;
            }
            return this;
        }
    }

    public ImageData(String str, Bitmap bitmap) {
        this.imageUrl = str;
        this.bitmapData = bitmap;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageData)) {
            return false;
        }
        ImageData imageData = (ImageData) obj;
        if (hashCode() == imageData.hashCode() && this.imageUrl.equals(imageData.imageUrl)) {
            return true;
        }
        return false;
    }

    public Bitmap getBitmapData() {
        return this.bitmapData;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public int hashCode() {
        int i10;
        Bitmap bitmap = this.bitmapData;
        if (bitmap != null) {
            i10 = bitmap.hashCode();
        } else {
            i10 = 0;
        }
        return this.imageUrl.hashCode() + i10;
    }
}
