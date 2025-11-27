package com.google.firebase.inappmessaging;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.inappmessaging.internal.Logging;

public final /* synthetic */ class a implements OnSuccessListener {
    public final void onSuccess(Object obj) {
        Logging.logi("Starting InAppMessaging runtime with Installation ID " + ((String) obj));
    }
}
