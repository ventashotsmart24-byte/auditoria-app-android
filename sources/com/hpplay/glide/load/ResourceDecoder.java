package com.hpplay.glide.load;

import com.hpplay.glide.load.engine.Resource;

public interface ResourceDecoder<T, Z> {
    Resource<Z> decode(T t10, int i10, int i11);

    String getId();
}
