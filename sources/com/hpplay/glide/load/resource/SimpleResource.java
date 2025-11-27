package com.hpplay.glide.load.resource;

import com.hpplay.glide.load.engine.Resource;

public class SimpleResource<T> implements Resource<T> {
    protected final T data;

    public SimpleResource(T t10) {
        if (t10 != null) {
            this.data = t10;
            return;
        }
        throw new NullPointerException("Data must not be null");
    }

    public final T get() {
        return this.data;
    }

    public final int getSize() {
        return 1;
    }

    public void recycle() {
    }
}
