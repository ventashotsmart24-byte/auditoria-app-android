package com.google.firebase.inappmessaging;

public class FirebaseInAppMessagingContextualTrigger {
    private final String triggerName;

    public FirebaseInAppMessagingContextualTrigger(String str) {
        this.triggerName = str;
    }

    public String getTriggerName() {
        return this.triggerName;
    }
}
