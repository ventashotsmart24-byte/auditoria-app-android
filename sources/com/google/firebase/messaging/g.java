package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.hpplay.cybergarage.upnp.UPnPStatus;

public final /* synthetic */ class g implements Continuation {
    public final Object then(Task task) {
        return Integer.valueOf(UPnPStatus.OUT_OF_SYNC);
    }
}
