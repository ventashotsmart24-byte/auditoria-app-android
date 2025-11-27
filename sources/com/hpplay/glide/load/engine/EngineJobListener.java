package com.hpplay.glide.load.engine;

import com.hpplay.glide.load.Key;

interface EngineJobListener {
    void onEngineJobCancelled(EngineJob engineJob, Key key);

    void onEngineJobComplete(Key key, EngineResource<?> engineResource);
}
