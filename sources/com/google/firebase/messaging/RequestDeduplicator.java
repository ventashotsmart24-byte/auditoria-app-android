package com.google.firebase.messaging;

import androidx.collection.a;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

class RequestDeduplicator {
    private final Executor executor;
    private final Map<String, Task<String>> getTokenRequests = new a();

    public interface GetTokenRequest {
        Task<String> start();
    }

    public RequestDeduplicator(Executor executor2) {
        this.executor = executor2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$getOrStartGetTokenRequest$0(String str, Task task) {
        synchronized (this) {
            this.getTokenRequests.remove(str);
        }
        return task;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.google.android.gms.tasks.Task<java.lang.String> getOrStartGetTokenRequest(java.lang.String r3, com.google.firebase.messaging.RequestDeduplicator.GetTokenRequest r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.Map<java.lang.String, com.google.android.gms.tasks.Task<java.lang.String>> r0 = r2.getTokenRequests     // Catch:{ all -> 0x004e }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x004e }
            com.google.android.gms.tasks.Task r0 = (com.google.android.gms.tasks.Task) r0     // Catch:{ all -> 0x004e }
            r1 = 3
            if (r0 == 0) goto L_0x0023
            java.lang.String r4 = "FirebaseMessaging"
            boolean r4 = android.util.Log.isLoggable(r4, r1)     // Catch:{ all -> 0x004e }
            if (r4 == 0) goto L_0x0021
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r4.<init>()     // Catch:{ all -> 0x004e }
            java.lang.String r1 = "Joining ongoing request for: "
            r4.append(r1)     // Catch:{ all -> 0x004e }
            r4.append(r3)     // Catch:{ all -> 0x004e }
        L_0x0021:
            monitor-exit(r2)
            return r0
        L_0x0023:
            java.lang.String r0 = "FirebaseMessaging"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x004e }
            if (r0 == 0) goto L_0x0038
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r0.<init>()     // Catch:{ all -> 0x004e }
            java.lang.String r1 = "Making new request for: "
            r0.append(r1)     // Catch:{ all -> 0x004e }
            r0.append(r3)     // Catch:{ all -> 0x004e }
        L_0x0038:
            com.google.android.gms.tasks.Task r4 = r4.start()     // Catch:{ all -> 0x004e }
            java.util.concurrent.Executor r0 = r2.executor     // Catch:{ all -> 0x004e }
            com.google.firebase.messaging.c0 r1 = new com.google.firebase.messaging.c0     // Catch:{ all -> 0x004e }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x004e }
            com.google.android.gms.tasks.Task r4 = r4.continueWithTask(r0, r1)     // Catch:{ all -> 0x004e }
            java.util.Map<java.lang.String, com.google.android.gms.tasks.Task<java.lang.String>> r0 = r2.getTokenRequests     // Catch:{ all -> 0x004e }
            r0.put(r3, r4)     // Catch:{ all -> 0x004e }
            monitor-exit(r2)
            return r4
        L_0x004e:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.RequestDeduplicator.getOrStartGetTokenRequest(java.lang.String, com.google.firebase.messaging.RequestDeduplicator$GetTokenRequest):com.google.android.gms.tasks.Task");
    }
}
