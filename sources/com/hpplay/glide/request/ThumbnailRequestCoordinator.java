package com.hpplay.glide.request;

public class ThumbnailRequestCoordinator implements Request, RequestCoordinator {
    private RequestCoordinator coordinator;
    private Request full;
    private Request thumb;

    public ThumbnailRequestCoordinator() {
        this((RequestCoordinator) null);
    }

    private boolean parentCanNotifyStatusChanged() {
        RequestCoordinator requestCoordinator = this.coordinator;
        if (requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this)) {
            return true;
        }
        return false;
    }

    private boolean parentCanSetImage() {
        RequestCoordinator requestCoordinator = this.coordinator;
        if (requestCoordinator == null || requestCoordinator.canSetImage(this)) {
            return true;
        }
        return false;
    }

    private boolean parentIsAnyResourceSet() {
        RequestCoordinator requestCoordinator = this.coordinator;
        if (requestCoordinator == null || !requestCoordinator.isAnyResourceSet()) {
            return false;
        }
        return true;
    }

    public void begin() {
        if (!this.thumb.isRunning()) {
            this.thumb.begin();
        }
        if (!this.full.isRunning()) {
            this.full.begin();
        }
    }

    public boolean canNotifyStatusChanged(Request request) {
        if (!parentCanNotifyStatusChanged() || !request.equals(this.full) || isAnyResourceSet()) {
            return false;
        }
        return true;
    }

    public boolean canSetImage(Request request) {
        if (!parentCanSetImage() || (!request.equals(this.full) && this.full.isResourceSet())) {
            return false;
        }
        return true;
    }

    public void clear() {
        this.thumb.clear();
        this.full.clear();
    }

    public boolean isAnyResourceSet() {
        if (parentIsAnyResourceSet() || isResourceSet()) {
            return true;
        }
        return false;
    }

    public boolean isCancelled() {
        return this.full.isCancelled();
    }

    public boolean isComplete() {
        if (this.full.isComplete() || this.thumb.isComplete()) {
            return true;
        }
        return false;
    }

    public boolean isFailed() {
        return this.full.isFailed();
    }

    public boolean isPaused() {
        return this.full.isPaused();
    }

    public boolean isResourceSet() {
        if (this.full.isResourceSet() || this.thumb.isResourceSet()) {
            return true;
        }
        return false;
    }

    public boolean isRunning() {
        return this.full.isRunning();
    }

    public void onRequestSuccess(Request request) {
        if (!request.equals(this.thumb)) {
            RequestCoordinator requestCoordinator = this.coordinator;
            if (requestCoordinator != null) {
                requestCoordinator.onRequestSuccess(this);
            }
            if (!this.thumb.isComplete()) {
                this.thumb.clear();
            }
        }
    }

    public void pause() {
        this.full.pause();
        this.thumb.pause();
    }

    public void recycle() {
        this.full.recycle();
        this.thumb.recycle();
    }

    public void setRequests(Request request, Request request2) {
        this.full = request;
        this.thumb = request2;
    }

    public ThumbnailRequestCoordinator(RequestCoordinator requestCoordinator) {
        this.coordinator = requestCoordinator;
    }
}
