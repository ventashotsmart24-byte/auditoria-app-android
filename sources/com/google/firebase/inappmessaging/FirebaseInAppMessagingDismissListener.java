package com.google.firebase.inappmessaging;

import com.google.firebase.inappmessaging.model.InAppMessage;

public interface FirebaseInAppMessagingDismissListener {
    void messageDismissed(InAppMessage inAppMessage);
}
