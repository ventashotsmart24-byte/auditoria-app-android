package com.hpplay.glide.load.resource;

import com.hpplay.glide.load.ResourceDecoder;
import com.hpplay.glide.load.engine.Resource;

public class NullDecoder<T, Z> implements ResourceDecoder<T, Z> {
    private static final NullDecoder<?, ?> NULL_DECODER = new NullDecoder<>();

    public static <T, Z> NullDecoder<T, Z> get() {
        return NULL_DECODER;
    }

    public Resource<Z> decode(T t10, int i10, int i11) {
        return null;
    }

    public String getId() {
        return "";
    }
}
