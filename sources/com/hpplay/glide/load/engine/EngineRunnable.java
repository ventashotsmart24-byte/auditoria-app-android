package com.hpplay.glide.load.engine;

import android.util.Log;
import com.hpplay.glide.Priority;
import com.hpplay.glide.load.engine.executor.Prioritized;
import com.hpplay.glide.request.ResourceCallback;

class EngineRunnable implements Prioritized, Runnable {
    private static final String TAG = "EngineRunnable";
    private final DecodeJob<?, ?, ?> decodeJob;
    private volatile boolean isCancelled;
    private final EngineRunnableManager manager;
    private final Priority priority;
    private Stage stage = Stage.CACHE;

    public interface EngineRunnableManager extends ResourceCallback {
        void submitForSource(EngineRunnable engineRunnable);
    }

    public enum Stage {
        CACHE,
        SOURCE
    }

    public EngineRunnable(EngineRunnableManager engineRunnableManager, DecodeJob<?, ?, ?> decodeJob2, Priority priority2) {
        this.manager = engineRunnableManager;
        this.decodeJob = decodeJob2;
        this.priority = priority2;
    }

    private Resource<?> decode() {
        if (isDecodingFromCache()) {
            return decodeFromCache();
        }
        return decodeFromSource();
    }

    private Resource<?> decodeFromCache() {
        Resource<?> resource;
        try {
            resource = this.decodeJob.decodeResultFromCache();
        } catch (Exception e10) {
            if (Log.isLoggable(TAG, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Exception decoding result from cache: ");
                sb.append(e10);
            }
            resource = null;
        }
        if (resource == null) {
            return this.decodeJob.decodeSourceFromCache();
        }
        return resource;
    }

    private Resource<?> decodeFromSource() {
        return this.decodeJob.decodeFromSource();
    }

    private boolean isDecodingFromCache() {
        if (this.stage == Stage.CACHE) {
            return true;
        }
        return false;
    }

    private void onLoadComplete(Resource resource) {
        this.manager.onResourceReady(resource);
    }

    private void onLoadFailed(Exception exc) {
        if (isDecodingFromCache()) {
            this.stage = Stage.SOURCE;
            this.manager.submitForSource(this);
            return;
        }
        this.manager.onException(exc);
    }

    public void cancel() {
        this.isCancelled = true;
        this.decodeJob.cancel();
    }

    public int getPriority() {
        return this.priority.ordinal();
    }

    public void run() {
        if (!this.isCancelled) {
            Resource<?> resource = null;
            try {
                e = null;
                resource = decode();
            } catch (Exception e10) {
                e = e10;
                Log.isLoggable(TAG, 2);
            }
            if (this.isCancelled) {
                if (resource != null) {
                    resource.recycle();
                }
            } else if (resource == null) {
                onLoadFailed(e);
            } else {
                onLoadComplete(resource);
            }
        }
    }
}
