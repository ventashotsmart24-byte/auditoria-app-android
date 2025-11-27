package com.hpplay.glide.request;

import com.hpplay.glide.load.engine.Resource;

public interface ResourceCallback {
    void onException(Exception exc);

    void onResourceReady(Resource<?> resource);
}
