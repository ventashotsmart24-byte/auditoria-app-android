package com.hpplay.glide.load.resource;

import com.hpplay.glide.load.Encoder;
import java.io.OutputStream;

public class NullEncoder<T> implements Encoder<T> {
    private static final NullEncoder<?> NULL_ENCODER = new NullEncoder<>();

    public static <T> Encoder<T> get() {
        return NULL_ENCODER;
    }

    public boolean encode(T t10, OutputStream outputStream) {
        return false;
    }

    public String getId() {
        return "";
    }
}
