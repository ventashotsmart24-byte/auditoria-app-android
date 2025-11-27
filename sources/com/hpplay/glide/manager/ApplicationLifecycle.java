package com.hpplay.glide.manager;

class ApplicationLifecycle implements Lifecycle {
    public void addListener(LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }
}
