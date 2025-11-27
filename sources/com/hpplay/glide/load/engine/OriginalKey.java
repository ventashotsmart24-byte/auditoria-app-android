package com.hpplay.glide.load.engine;

import com.hpplay.glide.load.Key;
import java.security.MessageDigest;

class OriginalKey implements Key {
    private final String id;
    private final Key signature;

    public OriginalKey(String str, Key key) {
        this.id = str;
        this.signature = key;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OriginalKey originalKey = (OriginalKey) obj;
        if (this.id.equals(originalKey.id) && this.signature.equals(originalKey.signature)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.signature.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(this.id.getBytes("UTF-8"));
        this.signature.updateDiskCacheKey(messageDigest);
    }
}
