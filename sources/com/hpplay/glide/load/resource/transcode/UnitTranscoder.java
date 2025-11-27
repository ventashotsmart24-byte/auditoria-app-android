package com.hpplay.glide.load.resource.transcode;

import com.hpplay.glide.load.engine.Resource;

public class UnitTranscoder<Z> implements ResourceTranscoder<Z, Z> {
    private static final UnitTranscoder<?> UNIT_TRANSCODER = new UnitTranscoder<>();

    public static <Z> ResourceTranscoder<Z, Z> get() {
        return UNIT_TRANSCODER;
    }

    public String getId() {
        return "";
    }

    public Resource<Z> transcode(Resource<Z> resource) {
        return resource;
    }
}
