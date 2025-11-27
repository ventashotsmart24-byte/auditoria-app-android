package com.hpplay.glide.manager;

import com.hpplay.glide.request.Request;
import com.hpplay.glide.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class RequestTracker {
    private boolean isPaused;
    private final List<Request> pendingRequests = new ArrayList();
    private final Set<Request> requests = Collections.newSetFromMap(new WeakHashMap());

    public void addRequest(Request request) {
        this.requests.add(request);
    }

    public void clearRequests() {
        for (T clear : Util.getSnapshot(this.requests)) {
            clear.clear();
        }
        this.pendingRequests.clear();
    }

    public boolean isPaused() {
        return this.isPaused;
    }

    public void pauseRequests() {
        this.isPaused = true;
        for (T t10 : Util.getSnapshot(this.requests)) {
            if (t10.isRunning()) {
                t10.pause();
                this.pendingRequests.add(t10);
            }
        }
    }

    public void removeRequest(Request request) {
        this.requests.remove(request);
        this.pendingRequests.remove(request);
    }

    public void restartRequests() {
        for (T t10 : Util.getSnapshot(this.requests)) {
            if (!t10.isComplete() && !t10.isCancelled()) {
                t10.pause();
                if (!this.isPaused) {
                    t10.begin();
                } else {
                    this.pendingRequests.add(t10);
                }
            }
        }
    }

    public void resumeRequests() {
        this.isPaused = false;
        for (T t10 : Util.getSnapshot(this.requests)) {
            if (!t10.isComplete() && !t10.isCancelled() && !t10.isRunning()) {
                t10.begin();
            }
        }
        this.pendingRequests.clear();
    }

    public void runRequest(Request request) {
        this.requests.add(request);
        if (!this.isPaused) {
            request.begin();
        } else {
            this.pendingRequests.add(request);
        }
    }
}
