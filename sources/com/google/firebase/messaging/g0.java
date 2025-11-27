package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.WithinAppServiceConnection;

public final /* synthetic */ class g0 implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WithinAppServiceConnection.BindRequest f10373a;

    public /* synthetic */ g0(WithinAppServiceConnection.BindRequest bindRequest) {
        this.f10373a = bindRequest;
    }

    public final void onComplete(Task task) {
        this.f10373a.finish();
    }
}
