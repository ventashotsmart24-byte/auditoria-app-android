package com.hpplay.glide.load.engine.cache;

import com.hpplay.glide.load.Key;
import com.hpplay.glide.load.engine.cache.DiskCache;
import java.io.File;

public class DiskCacheAdapter implements DiskCache {
    public void clear() {
    }

    public void delete(Key key) {
    }

    public File get(Key key) {
        return null;
    }

    public void put(Key key, DiskCache.Writer writer) {
    }
}
