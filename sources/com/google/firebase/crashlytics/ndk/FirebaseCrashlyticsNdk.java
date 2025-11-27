package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.crashlytics.internal.persistence.FileStore;

class FirebaseCrashlyticsNdk implements CrashlyticsNativeComponent {
    private static FirebaseCrashlyticsNdk instance;
    private final CrashpadController controller;
    private String currentSessionId;
    private boolean installHandlerDuringPrepareSession;
    private SignalHandlerInstaller signalHandlerInstaller;

    public interface SignalHandlerInstaller {
        void installHandler();
    }

    public FirebaseCrashlyticsNdk(CrashpadController crashpadController, boolean z10) {
        this.controller = crashpadController;
        this.installHandlerDuringPrepareSession = z10;
    }

    public static FirebaseCrashlyticsNdk create(Context context, boolean z10) {
        FirebaseCrashlyticsNdk firebaseCrashlyticsNdk = new FirebaseCrashlyticsNdk(new CrashpadController(context, new JniNativeApi(context), new FileStore(context)), z10);
        instance = firebaseCrashlyticsNdk;
        return firebaseCrashlyticsNdk;
    }

    public static FirebaseCrashlyticsNdk getInstance() {
        FirebaseCrashlyticsNdk firebaseCrashlyticsNdk = instance;
        if (firebaseCrashlyticsNdk != null) {
            return firebaseCrashlyticsNdk;
        }
        throw new NullPointerException("FirebaseCrashlyticsNdk component is not present.");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareNativeSession$0(String str, String str2, long j10, StaticSessionData staticSessionData) {
        Logger logger = Logger.getLogger();
        logger.d("Initializing native session: " + str);
        if (!this.controller.initialize(str, str2, j10, staticSessionData)) {
            Logger logger2 = Logger.getLogger();
            logger2.w("Failed to initialize Crashlytics NDK for session " + str);
        }
    }

    public NativeSessionFileProvider getSessionFileProvider(String str) {
        return new SessionFilesProvider(this.controller.getFilesForSession(str));
    }

    public boolean hasCrashDataForCurrentSession() {
        String str = this.currentSessionId;
        if (str == null || !hasCrashDataForSession(str)) {
            return false;
        }
        return true;
    }

    public boolean hasCrashDataForSession(String str) {
        return this.controller.hasCrashDataForSession(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void installSignalHandler() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.firebase.crashlytics.ndk.FirebaseCrashlyticsNdk$SignalHandlerInstaller r0 = r2.signalHandlerInstaller     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x000a
            r0.installHandler()     // Catch:{ all -> 0x0026 }
            monitor-exit(r2)
            return
        L_0x000a:
            boolean r0 = r2.installHandlerDuringPrepareSession     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0018
            com.google.firebase.crashlytics.internal.Logger r0 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ all -> 0x0026 }
            java.lang.String r1 = "Native signal handler already installed; skipping re-install."
            r0.w(r1)     // Catch:{ all -> 0x0026 }
            goto L_0x0024
        L_0x0018:
            com.google.firebase.crashlytics.internal.Logger r0 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ all -> 0x0026 }
            java.lang.String r1 = "Deferring signal handler installation until the FirebaseCrashlyticsNdk session has been prepared"
            r0.d(r1)     // Catch:{ all -> 0x0026 }
            r0 = 1
            r2.installHandlerDuringPrepareSession = r0     // Catch:{ all -> 0x0026 }
        L_0x0024:
            monitor-exit(r2)
            return
        L_0x0026:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.ndk.FirebaseCrashlyticsNdk.installSignalHandler():void");
    }

    public synchronized void prepareNativeSession(String str, String str2, long j10, StaticSessionData staticSessionData) {
        this.currentSessionId = str;
        b bVar = new b(this, str, str2, j10, staticSessionData);
        this.signalHandlerInstaller = bVar;
        if (this.installHandlerDuringPrepareSession) {
            bVar.installHandler();
        }
    }
}
