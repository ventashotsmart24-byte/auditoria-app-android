package com.google.firebase.inappmessaging.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import io.reactivex.BackpressureStrategy;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.subjects.BehaviorSubject;

public class ForegroundNotifier implements Application.ActivityLifecycleCallbacks {
    public static final long DELAY_MILLIS = 1000;
    private Runnable check;
    private boolean foreground = false;
    private final BehaviorSubject<String> foregroundSubject = BehaviorSubject.create();
    private final Handler handler = new Handler();
    private boolean paused = true;

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityPaused$0() {
        boolean z10;
        boolean z11 = this.foreground;
        if ((!z11 || !this.paused) && z11) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.foreground = z10;
    }

    public ConnectableFlowable<String> foregroundFlowable() {
        return this.foregroundSubject.toFlowable(BackpressureStrategy.BUFFER).publish();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        this.paused = true;
        Runnable runnable = this.check;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        Handler handler2 = this.handler;
        y yVar = new y(this);
        this.check = yVar;
        handler2.postDelayed(yVar, 1000);
    }

    public void onActivityResumed(Activity activity) {
        this.paused = false;
        boolean z10 = !this.foreground;
        this.foreground = true;
        Runnable runnable = this.check;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        if (z10) {
            Logging.logi("went foreground");
            this.foregroundSubject.onNext(InAppMessageStreamManager.ON_FOREGROUND);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
