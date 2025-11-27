package com.bumptech.glide.manager;

import androidx.lifecycle.d;
import androidx.lifecycle.f;
import androidx.lifecycle.g;
import androidx.lifecycle.n;
import com.bumptech.glide.util.Util;
import java.util.HashSet;
import java.util.Set;

final class LifecycleLifecycle implements Lifecycle, f {
    private final d lifecycle;
    private final Set<LifecycleListener> lifecycleListeners = new HashSet();

    public LifecycleLifecycle(d dVar) {
        this.lifecycle = dVar;
        dVar.a(this);
    }

    public void addListener(LifecycleListener lifecycleListener) {
        this.lifecycleListeners.add(lifecycleListener);
        if (this.lifecycle.b() == d.c.DESTROYED) {
            lifecycleListener.onDestroy();
        } else if (this.lifecycle.b().a(d.c.STARTED)) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    @n(d.b.ON_DESTROY)
    public void onDestroy(g gVar) {
        for (T onDestroy : Util.getSnapshot(this.lifecycleListeners)) {
            onDestroy.onDestroy();
        }
        gVar.getLifecycle().c(this);
    }

    @n(d.b.ON_START)
    public void onStart(g gVar) {
        for (T onStart : Util.getSnapshot(this.lifecycleListeners)) {
            onStart.onStart();
        }
    }

    @n(d.b.ON_STOP)
    public void onStop(g gVar) {
        for (T onStop : Util.getSnapshot(this.lifecycleListeners)) {
            onStop.onStop();
        }
    }

    public void removeListener(LifecycleListener lifecycleListener) {
        this.lifecycleListeners.remove(lifecycleListener);
    }
}
