package com.hpplay.glide.load.engine;

public interface Resource<Z> {
    Z get();

    int getSize();

    void recycle();
}
