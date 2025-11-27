package com.hpplay.glide.load.data;

import com.hpplay.glide.Priority;

public interface DataFetcher<T> {
    void cancel();

    void cleanup();

    String getId();

    T loadData(Priority priority);
}
