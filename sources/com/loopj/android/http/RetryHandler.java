package com.loopj.android.http;

import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;

class RetryHandler implements HttpRequestRetryHandler {
    private static final HashSet<Class<?>> exceptionBlacklist;
    private static final HashSet<Class<?>> exceptionWhitelist;
    private final int maxRetries;
    private final int retrySleepTimeMS;

    static {
        HashSet<Class<?>> hashSet = new HashSet<>();
        exceptionWhitelist = hashSet;
        HashSet<Class<?>> hashSet2 = new HashSet<>();
        exceptionBlacklist = hashSet2;
        hashSet.add(NoHttpResponseException.class);
        hashSet.add(UnknownHostException.class);
        hashSet.add(SocketException.class);
        hashSet2.add(InterruptedIOException.class);
        hashSet2.add(SSLException.class);
    }

    public RetryHandler(int i10, int i11) {
        this.maxRetries = i10;
        this.retrySleepTimeMS = i11;
    }

    public static void addClassToBlacklist(Class<?> cls) {
        exceptionBlacklist.add(cls);
    }

    public static void addClassToWhitelist(Class<?> cls) {
        exceptionWhitelist.add(cls);
    }

    public boolean isInList(HashSet<Class<?>> hashSet, Throwable th) {
        Iterator<Class<?>> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(th)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        if (isInList(exceptionBlacklist, r3) == false) goto L_0x0028;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean retryRequest(java.io.IOException r3, int r4, org.apache.http.protocol.HttpContext r5) {
        /*
            r2 = this;
            java.lang.String r0 = "http.request_sent"
            java.lang.Object r0 = r5.getAttribute(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.booleanValue()
        L_0x000e:
            int r0 = r2.maxRetries
            r1 = 0
            if (r4 <= r0) goto L_0x0015
        L_0x0013:
            r0 = 0
            goto L_0x0028
        L_0x0015:
            java.util.HashSet<java.lang.Class<?>> r4 = exceptionWhitelist
            boolean r4 = r2.isInList(r4, r3)
            r0 = 1
            if (r4 == 0) goto L_0x001f
            goto L_0x0028
        L_0x001f:
            java.util.HashSet<java.lang.Class<?>> r4 = exceptionBlacklist
            boolean r4 = r2.isInList(r4, r3)
            if (r4 == 0) goto L_0x0028
            goto L_0x0013
        L_0x0028:
            if (r0 == 0) goto L_0x0035
            java.lang.String r4 = "http.request"
            java.lang.Object r4 = r5.getAttribute(r4)
            org.apache.http.client.methods.HttpUriRequest r4 = (org.apache.http.client.methods.HttpUriRequest) r4
            if (r4 != 0) goto L_0x0035
            return r1
        L_0x0035:
            if (r0 == 0) goto L_0x003e
            int r3 = r2.retrySleepTimeMS
            long r3 = (long) r3
            android.os.SystemClock.sleep(r3)
            goto L_0x0041
        L_0x003e:
            r3.printStackTrace()
        L_0x0041:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loopj.android.http.RetryHandler.retryRequest(java.io.IOException, int, org.apache.http.protocol.HttpContext):boolean");
    }
}
