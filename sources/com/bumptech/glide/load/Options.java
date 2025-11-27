package com.bumptech.glide.load;

import androidx.collection.a;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.security.MessageDigest;

public final class Options implements Key {
    private final a values = new CachedHashCodeArrayMap();

    public boolean equals(Object obj) {
        if (obj instanceof Options) {
            return this.values.equals(((Options) obj).values);
        }
        return false;
    }

    public <T> T get(Option<T> option) {
        if (this.values.containsKey(option)) {
            return this.values.get(option);
        }
        return option.getDefaultValue();
    }

    public int hashCode() {
        return this.values.hashCode();
    }

    public void putAll(Options options) {
        this.values.putAll(options.values);
    }

    public Options remove(Option<?> option) {
        this.values.remove(option);
        return this;
    }

    public <T> Options set(Option<T> option, T t10) {
        this.values.put(option, t10);
        return this;
    }

    public String toString() {
        return "Options{values=" + this.values + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        for (int i10 = 0; i10 < this.values.size(); i10++) {
            updateDiskCacheKey((Option) this.values.keyAt(i10), this.values.valueAt(i10), messageDigest);
        }
    }

    private static <T> void updateDiskCacheKey(Option<T> option, Object obj, MessageDigest messageDigest) {
        option.update(obj, messageDigest);
    }
}
