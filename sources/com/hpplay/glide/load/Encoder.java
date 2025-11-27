package com.hpplay.glide.load;

import java.io.OutputStream;

public interface Encoder<T> {
    boolean encode(T t10, OutputStream outputStream);

    String getId();
}
