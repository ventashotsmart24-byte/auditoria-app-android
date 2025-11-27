package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledFuture;

public final /* synthetic */ class i0 implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScheduledFuture f10378a;

    public /* synthetic */ i0(ScheduledFuture scheduledFuture) {
        this.f10378a = scheduledFuture;
    }

    public final void onComplete(Task task) {
        this.f10378a.cancel(false);
    }
}
