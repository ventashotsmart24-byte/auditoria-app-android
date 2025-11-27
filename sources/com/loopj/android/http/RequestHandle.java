package com.loopj.android.http;

import android.os.Looper;
import java.lang.ref.WeakReference;

public class RequestHandle {
    private final WeakReference<AsyncHttpRequest> request;

    public RequestHandle(AsyncHttpRequest asyncHttpRequest) {
        this.request = new WeakReference<>(asyncHttpRequest);
    }

    public boolean cancel(final boolean z10) {
        final AsyncHttpRequest asyncHttpRequest = this.request.get();
        if (asyncHttpRequest == null) {
            return false;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return asyncHttpRequest.cancel(z10);
        }
        new Thread(new Runnable() {
            public void run() {
                asyncHttpRequest.cancel(z10);
            }
        }).start();
        return true;
    }

    public Object getTag() {
        AsyncHttpRequest asyncHttpRequest = this.request.get();
        if (asyncHttpRequest == null) {
            return null;
        }
        return asyncHttpRequest.getTag();
    }

    public boolean isCancelled() {
        AsyncHttpRequest asyncHttpRequest = this.request.get();
        if (asyncHttpRequest == null || asyncHttpRequest.isCancelled()) {
            return true;
        }
        return false;
    }

    public boolean isFinished() {
        AsyncHttpRequest asyncHttpRequest = this.request.get();
        if (asyncHttpRequest == null || asyncHttpRequest.isDone()) {
            return true;
        }
        return false;
    }

    public RequestHandle setTag(Object obj) {
        AsyncHttpRequest asyncHttpRequest = this.request.get();
        if (asyncHttpRequest != null) {
            asyncHttpRequest.setRequestTag(obj);
        }
        return this;
    }

    public boolean shouldBeGarbageCollected() {
        boolean z10;
        if (isCancelled() || isFinished()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.request.clear();
        }
        return z10;
    }
}
