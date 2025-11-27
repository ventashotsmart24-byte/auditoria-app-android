package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageDownload f10398a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f10399b;

    public /* synthetic */ x(ImageDownload imageDownload, TaskCompletionSource taskCompletionSource) {
        this.f10398a = imageDownload;
        this.f10399b = taskCompletionSource;
    }

    public final void run() {
        this.f10398a.lambda$start$0(this.f10399b);
    }
}
