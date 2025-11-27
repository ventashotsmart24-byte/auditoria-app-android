package com.hpplay.glide.load.resource;

import com.hpplay.glide.load.Transformation;
import com.hpplay.glide.load.engine.Resource;

public class UnitTransformation<T> implements Transformation<T> {
    private static final Transformation<?> TRANSFORMATION = new UnitTransformation();

    public static <T> UnitTransformation<T> get() {
        return (UnitTransformation) TRANSFORMATION;
    }

    public String getId() {
        return "";
    }

    public Resource<T> transform(Resource<T> resource, int i10, int i11) {
        return resource;
    }
}
