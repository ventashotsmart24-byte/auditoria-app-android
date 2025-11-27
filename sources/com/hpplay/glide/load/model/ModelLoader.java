package com.hpplay.glide.load.model;

import com.hpplay.glide.load.data.DataFetcher;

public interface ModelLoader<T, Y> {
    DataFetcher<Y> getResourceFetcher(T t10, int i10, int i11);
}
