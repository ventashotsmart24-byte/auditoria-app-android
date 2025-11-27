package com.hpplay.glide.load;

import com.hpplay.glide.load.engine.Resource;

public interface Transformation<T> {
    String getId();

    Resource<T> transform(Resource<T> resource, int i10, int i11);
}
