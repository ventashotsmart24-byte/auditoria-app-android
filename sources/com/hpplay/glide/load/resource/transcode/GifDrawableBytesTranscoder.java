package com.hpplay.glide.load.resource.transcode;

import com.hpplay.glide.load.engine.Resource;
import com.hpplay.glide.load.resource.bytes.BytesResource;
import com.hpplay.glide.load.resource.gif.GifDrawable;

public class GifDrawableBytesTranscoder implements ResourceTranscoder<GifDrawable, byte[]> {
    public String getId() {
        return "GifDrawableBytesTranscoder.com.bumptech.glide.load.resource.transcode";
    }

    public Resource<byte[]> transcode(Resource<GifDrawable> resource) {
        return new BytesResource(resource.get().getData());
    }
}
