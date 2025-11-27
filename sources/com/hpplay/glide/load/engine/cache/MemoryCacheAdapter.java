package com.hpplay.glide.load.engine.cache;

import com.hpplay.glide.load.Key;
import com.hpplay.glide.load.engine.Resource;
import com.hpplay.glide.load.engine.cache.MemoryCache;

public class MemoryCacheAdapter implements MemoryCache {
    private MemoryCache.ResourceRemovedListener listener;

    public void clearMemory() {
    }

    public int getCurrentSize() {
        return 0;
    }

    public int getMaxSize() {
        return 0;
    }

    public Resource<?> put(Key key, Resource<?> resource) {
        this.listener.onResourceRemoved(resource);
        return null;
    }

    public Resource<?> remove(Key key) {
        return null;
    }

    public void setResourceRemovedListener(MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.listener = resourceRemovedListener;
    }

    public void setSizeMultiplier(float f10) {
    }

    public void trimMemory(int i10) {
    }
}
