package com.google.firebase.inappmessaging.internal;

import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingClickListener;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDismissListener;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayErrorListener;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingImpressionListener;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class DeveloperListenerManager {
    private final Executor backgroundExecutor;
    private Map<FirebaseInAppMessagingClickListener, ClicksExecutorAndListener> registeredClickListeners = new HashMap();
    private Map<FirebaseInAppMessagingDismissListener, DismissExecutorAndListener> registeredDismissListeners = new HashMap();
    private Map<FirebaseInAppMessagingDisplayErrorListener, ErrorsExecutorAndListener> registeredErrorListeners = new HashMap();
    private Map<FirebaseInAppMessagingImpressionListener, ImpressionExecutorAndListener> registeredImpressionListeners = new HashMap();

    public static class ClicksExecutorAndListener extends ExecutorAndListener<FirebaseInAppMessagingClickListener> {
        FirebaseInAppMessagingClickListener listener;

        public ClicksExecutorAndListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener, Executor executor) {
            super(executor);
            this.listener = firebaseInAppMessagingClickListener;
        }

        public FirebaseInAppMessagingClickListener getListener() {
            return this.listener;
        }

        public ClicksExecutorAndListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
            super((Executor) null);
            this.listener = firebaseInAppMessagingClickListener;
        }
    }

    public static class DismissExecutorAndListener extends ExecutorAndListener<FirebaseInAppMessagingDismissListener> {
        FirebaseInAppMessagingDismissListener listener;

        public DismissExecutorAndListener(FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener, Executor executor) {
            super(executor);
            this.listener = firebaseInAppMessagingDismissListener;
        }

        public FirebaseInAppMessagingDismissListener getListener() {
            return this.listener;
        }

        public DismissExecutorAndListener(FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener) {
            super((Executor) null);
            this.listener = firebaseInAppMessagingDismissListener;
        }
    }

    public static class ErrorsExecutorAndListener extends ExecutorAndListener<FirebaseInAppMessagingDisplayErrorListener> {
        FirebaseInAppMessagingDisplayErrorListener listener;

        public ErrorsExecutorAndListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener, Executor executor) {
            super(executor);
            this.listener = firebaseInAppMessagingDisplayErrorListener;
        }

        public FirebaseInAppMessagingDisplayErrorListener getListener() {
            return this.listener;
        }

        public ErrorsExecutorAndListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
            super((Executor) null);
            this.listener = firebaseInAppMessagingDisplayErrorListener;
        }
    }

    public static abstract class ExecutorAndListener<T> {
        private final Executor executor;

        public ExecutorAndListener(Executor executor2) {
            this.executor = executor2;
        }

        public abstract T getListener();

        public Executor withExecutor(Executor executor2) {
            Executor executor3 = this.executor;
            if (executor3 == null) {
                return executor2;
            }
            return executor3;
        }
    }

    public static class ImpressionExecutorAndListener extends ExecutorAndListener<FirebaseInAppMessagingImpressionListener> {
        FirebaseInAppMessagingImpressionListener listener;

        public ImpressionExecutorAndListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener, Executor executor) {
            super(executor);
            this.listener = firebaseInAppMessagingImpressionListener;
        }

        public FirebaseInAppMessagingImpressionListener getListener() {
            return this.listener;
        }

        public ImpressionExecutorAndListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
            super((Executor) null);
            this.listener = firebaseInAppMessagingImpressionListener;
        }
    }

    public DeveloperListenerManager(@Background Executor executor) {
        this.backgroundExecutor = executor;
    }

    public void addClickListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
        this.registeredClickListeners.put(firebaseInAppMessagingClickListener, new ClicksExecutorAndListener(firebaseInAppMessagingClickListener));
    }

    public void addDismissListener(FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener) {
        this.registeredDismissListeners.put(firebaseInAppMessagingDismissListener, new DismissExecutorAndListener(firebaseInAppMessagingDismissListener));
    }

    public void addDisplayErrorListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
        this.registeredErrorListeners.put(firebaseInAppMessagingDisplayErrorListener, new ErrorsExecutorAndListener(firebaseInAppMessagingDisplayErrorListener));
    }

    public void addImpressionListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
        this.registeredImpressionListeners.put(firebaseInAppMessagingImpressionListener, new ImpressionExecutorAndListener(firebaseInAppMessagingImpressionListener));
    }

    public void displayErrorEncountered(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        for (ErrorsExecutorAndListener next : this.registeredErrorListeners.values()) {
            next.withExecutor(this.backgroundExecutor).execute(new i(next, inAppMessage, inAppMessagingErrorReason));
        }
    }

    public Map getAllListeners() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.registeredClickListeners);
        hashMap.putAll(this.registeredImpressionListeners);
        hashMap.putAll(this.registeredErrorListeners);
        hashMap.putAll(this.registeredDismissListeners);
        return hashMap;
    }

    public void impressionDetected(InAppMessage inAppMessage) {
        for (ImpressionExecutorAndListener next : this.registeredImpressionListeners.values()) {
            next.withExecutor(this.backgroundExecutor).execute(new j(next, inAppMessage));
        }
    }

    public void messageClicked(InAppMessage inAppMessage, Action action) {
        for (ClicksExecutorAndListener next : this.registeredClickListeners.values()) {
            next.withExecutor(this.backgroundExecutor).execute(new l(next, inAppMessage, action));
        }
    }

    public void messageDismissed(InAppMessage inAppMessage) {
        for (DismissExecutorAndListener next : this.registeredDismissListeners.values()) {
            next.withExecutor(this.backgroundExecutor).execute(new k(next, inAppMessage));
        }
    }

    public void removeAllListeners() {
        this.registeredClickListeners.clear();
        this.registeredImpressionListeners.clear();
        this.registeredErrorListeners.clear();
        this.registeredDismissListeners.clear();
    }

    public void removeClickListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
        this.registeredClickListeners.remove(firebaseInAppMessagingClickListener);
    }

    public void removeDismissListener(FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener) {
        this.registeredDismissListeners.remove(firebaseInAppMessagingDismissListener);
    }

    public void removeDisplayErrorListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
        this.registeredErrorListeners.remove(firebaseInAppMessagingDisplayErrorListener);
    }

    public void removeImpressionListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
        this.registeredImpressionListeners.remove(firebaseInAppMessagingImpressionListener);
    }

    public void addClickListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener, Executor executor) {
        this.registeredClickListeners.put(firebaseInAppMessagingClickListener, new ClicksExecutorAndListener(firebaseInAppMessagingClickListener, executor));
    }

    public void addDismissListener(FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener, Executor executor) {
        this.registeredDismissListeners.put(firebaseInAppMessagingDismissListener, new DismissExecutorAndListener(firebaseInAppMessagingDismissListener, executor));
    }

    public void addDisplayErrorListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener, Executor executor) {
        this.registeredErrorListeners.put(firebaseInAppMessagingDisplayErrorListener, new ErrorsExecutorAndListener(firebaseInAppMessagingDisplayErrorListener, executor));
    }

    public void addImpressionListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener, Executor executor) {
        this.registeredImpressionListeners.put(firebaseInAppMessagingImpressionListener, new ImpressionExecutorAndListener(firebaseInAppMessagingImpressionListener, executor));
    }
}
