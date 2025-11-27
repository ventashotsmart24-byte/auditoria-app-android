package com.hpplay.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.hpplay.glide.load.Key;
import com.hpplay.glide.load.engine.EngineRunnable;
import com.hpplay.glide.request.ResourceCallback;
import com.hpplay.glide.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

class EngineJob implements EngineRunnable.EngineRunnableManager {
    private static final EngineResourceFactory DEFAULT_FACTORY = new EngineResourceFactory();
    private static final Handler MAIN_THREAD_HANDLER = new Handler(Looper.getMainLooper(), new MainThreadCallback());
    private static final int MSG_COMPLETE = 1;
    private static final int MSG_EXCEPTION = 2;
    private final List<ResourceCallback> cbs;
    private final ExecutorService diskCacheService;
    private EngineResource<?> engineResource;
    private final EngineResourceFactory engineResourceFactory;
    private EngineRunnable engineRunnable;
    private Exception exception;
    private volatile Future<?> future;
    private boolean hasException;
    private boolean hasResource;
    private Set<ResourceCallback> ignoredCallbacks;
    private final boolean isCacheable;
    private boolean isCancelled;
    private final Key key;
    private final EngineJobListener listener;
    private Resource<?> resource;
    private final ExecutorService sourceService;

    public static class EngineResourceFactory {
        public <R> EngineResource<R> build(Resource<R> resource, boolean z10) {
            return new EngineResource<>(resource, z10);
        }
    }

    public static class MainThreadCallback implements Handler.Callback {
        private MainThreadCallback() {
        }

        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (1 != i10 && 2 != i10) {
                return false;
            }
            EngineJob engineJob = (EngineJob) message.obj;
            if (1 == i10) {
                engineJob.handleResultOnMainThread();
            } else {
                engineJob.handleExceptionOnMainThread();
            }
            return true;
        }
    }

    public EngineJob(Key key2, ExecutorService executorService, ExecutorService executorService2, boolean z10, EngineJobListener engineJobListener) {
        this(key2, executorService, executorService2, z10, engineJobListener, DEFAULT_FACTORY);
    }

    private void addIgnoredCallback(ResourceCallback resourceCallback) {
        if (this.ignoredCallbacks == null) {
            this.ignoredCallbacks = new HashSet();
        }
        this.ignoredCallbacks.add(resourceCallback);
    }

    /* access modifiers changed from: private */
    public void handleExceptionOnMainThread() {
        if (!this.isCancelled) {
            if (!this.cbs.isEmpty()) {
                this.hasException = true;
                this.listener.onEngineJobComplete(this.key, (EngineResource<?>) null);
                for (ResourceCallback next : this.cbs) {
                    if (!isInIgnoredCallbacks(next)) {
                        next.onException(this.exception);
                    }
                }
                return;
            }
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        }
    }

    /* access modifiers changed from: private */
    public void handleResultOnMainThread() {
        if (this.isCancelled) {
            this.resource.recycle();
        } else if (!this.cbs.isEmpty()) {
            EngineResource<?> build = this.engineResourceFactory.build(this.resource, this.isCacheable);
            this.engineResource = build;
            this.hasResource = true;
            build.acquire();
            this.listener.onEngineJobComplete(this.key, this.engineResource);
            for (ResourceCallback next : this.cbs) {
                if (!isInIgnoredCallbacks(next)) {
                    this.engineResource.acquire();
                    next.onResourceReady(this.engineResource);
                }
            }
            this.engineResource.release();
        } else {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        }
    }

    private boolean isInIgnoredCallbacks(ResourceCallback resourceCallback) {
        Set<ResourceCallback> set = this.ignoredCallbacks;
        if (set == null || !set.contains(resourceCallback)) {
            return false;
        }
        return true;
    }

    public void addCallback(ResourceCallback resourceCallback) {
        Util.assertMainThread();
        if (this.hasResource) {
            resourceCallback.onResourceReady(this.engineResource);
        } else if (this.hasException) {
            resourceCallback.onException(this.exception);
        } else {
            this.cbs.add(resourceCallback);
        }
    }

    public void cancel() {
        if (!this.hasException && !this.hasResource && !this.isCancelled) {
            this.engineRunnable.cancel();
            Future<?> future2 = this.future;
            if (future2 != null) {
                future2.cancel(true);
            }
            this.isCancelled = true;
            this.listener.onEngineJobCancelled(this, this.key);
        }
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void onException(Exception exc) {
        this.exception = exc;
        MAIN_THREAD_HANDLER.obtainMessage(2, this).sendToTarget();
    }

    public void onResourceReady(Resource<?> resource2) {
        this.resource = resource2;
        MAIN_THREAD_HANDLER.obtainMessage(1, this).sendToTarget();
    }

    public void removeCallback(ResourceCallback resourceCallback) {
        Util.assertMainThread();
        if (this.hasResource || this.hasException) {
            addIgnoredCallback(resourceCallback);
            return;
        }
        this.cbs.remove(resourceCallback);
        if (this.cbs.isEmpty()) {
            cancel();
        }
    }

    public void start(EngineRunnable engineRunnable2) {
        this.engineRunnable = engineRunnable2;
        this.future = this.diskCacheService.submit(engineRunnable2);
    }

    public void submitForSource(EngineRunnable engineRunnable2) {
        this.future = this.sourceService.submit(engineRunnable2);
    }

    public EngineJob(Key key2, ExecutorService executorService, ExecutorService executorService2, boolean z10, EngineJobListener engineJobListener, EngineResourceFactory engineResourceFactory2) {
        this.cbs = new ArrayList();
        this.key = key2;
        this.diskCacheService = executorService;
        this.sourceService = executorService2;
        this.isCacheable = z10;
        this.listener = engineJobListener;
        this.engineResourceFactory = engineResourceFactory2;
    }
}
