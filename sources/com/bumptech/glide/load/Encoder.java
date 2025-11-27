package com.bumptech.glide.load;

import java.io.File;

public interface Encoder<T> {
    boolean encode(T t10, File file, Options options);
}
