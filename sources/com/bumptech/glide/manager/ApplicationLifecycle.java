package com.bumptech.glide.manager;

class ApplicationLifecycle implements Lifecycle {
    public void addListener(LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }

    public void removeListener(LifecycleListener lifecycleListener) {
    }
}
