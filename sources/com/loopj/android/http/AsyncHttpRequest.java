package com.loopj.android.http;

import com.umeng.analytics.pro.f;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class AsyncHttpRequest implements Runnable {
    private boolean cancelIsNotified;
    private final AbstractHttpClient client;
    private final HttpContext context;
    private int executionCount;
    private final AtomicBoolean isCancelled = new AtomicBoolean();
    private volatile boolean isFinished;
    private boolean isRequestPreProcessed;
    private final HttpUriRequest request;
    private final ResponseHandlerInterface responseHandler;

    public AsyncHttpRequest(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, ResponseHandlerInterface responseHandlerInterface) {
        this.client = (AbstractHttpClient) Utils.notNull(abstractHttpClient, "client");
        this.context = (HttpContext) Utils.notNull(httpContext, f.X);
        this.request = (HttpUriRequest) Utils.notNull(httpUriRequest, "request");
        this.responseHandler = (ResponseHandlerInterface) Utils.notNull(responseHandlerInterface, "responseHandler");
    }

    private void makeRequest() {
        if (!isCancelled()) {
            if (this.request.getURI().getScheme() != null) {
                ResponseHandlerInterface responseHandlerInterface = this.responseHandler;
                if (responseHandlerInterface instanceof RangeFileAsyncHttpResponseHandler) {
                    ((RangeFileAsyncHttpResponseHandler) responseHandlerInterface).updateRequestHeaders(this.request);
                }
                HttpResponse execute = this.client.execute(this.request, this.context);
                if (!isCancelled()) {
                    ResponseHandlerInterface responseHandlerInterface2 = this.responseHandler;
                    responseHandlerInterface2.onPreProcessResponse(responseHandlerInterface2, execute);
                    if (!isCancelled()) {
                        this.responseHandler.sendResponseMessage(execute);
                        if (!isCancelled()) {
                            ResponseHandlerInterface responseHandlerInterface3 = this.responseHandler;
                            responseHandlerInterface3.onPostProcessResponse(responseHandlerInterface3, execute);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            throw new MalformedURLException("No valid URI scheme was provided");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081 A[Catch:{ Exception -> 0x000f }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0009 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void makeRequestWithRetries() {
        /*
            r7 = this;
            org.apache.http.impl.client.AbstractHttpClient r0 = r7.client
            org.apache.http.client.HttpRequestRetryHandler r0 = r0.getHttpRequestRetryHandler()
            r1 = 1
            r2 = 0
            r3 = 1
        L_0x0009:
            if (r3 == 0) goto L_0x00ac
            r7.makeRequest()     // Catch:{ UnknownHostException -> 0x004d, NullPointerException -> 0x0026, IOException -> 0x0012 }
            return
        L_0x000f:
            r0 = move-exception
            goto L_0x0089
        L_0x0012:
            r2 = move-exception
            boolean r3 = r7.isCancelled()     // Catch:{ Exception -> 0x000f }
            if (r3 == 0) goto L_0x001a
            return
        L_0x001a:
            int r3 = r7.executionCount     // Catch:{ Exception -> 0x000f }
            int r3 = r3 + r1
            r7.executionCount = r3     // Catch:{ Exception -> 0x000f }
            org.apache.http.protocol.HttpContext r4 = r7.context     // Catch:{ Exception -> 0x000f }
            boolean r3 = r0.retryRequest(r2, r3, r4)     // Catch:{ Exception -> 0x000f }
            goto L_0x007f
        L_0x0026:
            r2 = move-exception
            java.io.IOException r3 = new java.io.IOException     // Catch:{ Exception -> 0x000f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x000f }
            r4.<init>()     // Catch:{ Exception -> 0x000f }
            java.lang.String r5 = "NPE in HttpClient: "
            r4.append(r5)     // Catch:{ Exception -> 0x000f }
            java.lang.String r2 = r2.getMessage()     // Catch:{ Exception -> 0x000f }
            r4.append(r2)     // Catch:{ Exception -> 0x000f }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x000f }
            r3.<init>(r2)     // Catch:{ Exception -> 0x000f }
            int r2 = r7.executionCount     // Catch:{ Exception -> 0x000f }
            int r2 = r2 + r1
            r7.executionCount = r2     // Catch:{ Exception -> 0x000f }
            org.apache.http.protocol.HttpContext r4 = r7.context     // Catch:{ Exception -> 0x000f }
            boolean r2 = r0.retryRequest(r3, r2, r4)     // Catch:{ Exception -> 0x000f }
            goto L_0x007c
        L_0x004d:
            r2 = move-exception
            java.io.IOException r3 = new java.io.IOException     // Catch:{ Exception -> 0x000f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x000f }
            r4.<init>()     // Catch:{ Exception -> 0x000f }
            java.lang.String r5 = "UnknownHostException exception: "
            r4.append(r5)     // Catch:{ Exception -> 0x000f }
            java.lang.String r5 = r2.getMessage()     // Catch:{ Exception -> 0x000f }
            r4.append(r5)     // Catch:{ Exception -> 0x000f }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x000f }
            r3.<init>(r4)     // Catch:{ Exception -> 0x000f }
            int r4 = r7.executionCount     // Catch:{ Exception -> 0x000f }
            if (r4 <= 0) goto L_0x007b
            int r4 = r7.executionCount     // Catch:{ Exception -> 0x000f }
            int r4 = r4 + r1
            r7.executionCount = r4     // Catch:{ Exception -> 0x000f }
            org.apache.http.protocol.HttpContext r5 = r7.context     // Catch:{ Exception -> 0x000f }
            boolean r2 = r0.retryRequest(r2, r4, r5)     // Catch:{ Exception -> 0x000f }
            if (r2 == 0) goto L_0x007b
            r2 = 1
            goto L_0x007c
        L_0x007b:
            r2 = 0
        L_0x007c:
            r6 = r3
            r3 = r2
            r2 = r6
        L_0x007f:
            if (r3 == 0) goto L_0x0009
            com.loopj.android.http.ResponseHandlerInterface r4 = r7.responseHandler     // Catch:{ Exception -> 0x000f }
            int r5 = r7.executionCount     // Catch:{ Exception -> 0x000f }
            r4.sendRetryMessage(r5)     // Catch:{ Exception -> 0x000f }
            goto L_0x0009
        L_0x0089:
            com.loopj.android.http.LogInterface r1 = com.loopj.android.http.AsyncHttpClient.log
            java.lang.String r2 = "AsyncHttpRequest"
            java.lang.String r3 = "Unhandled exception origin cause"
            r1.e(r2, r3, r0)
            java.io.IOException r2 = new java.io.IOException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Unhandled exception: "
            r1.append(r3)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r2.<init>(r0)
        L_0x00ac:
            goto L_0x00ae
        L_0x00ad:
            throw r2
        L_0x00ae:
            goto L_0x00ad
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loopj.android.http.AsyncHttpRequest.makeRequestWithRetries():void");
    }

    private synchronized void sendCancelNotification() {
        if (!this.isFinished && this.isCancelled.get() && !this.cancelIsNotified) {
            this.cancelIsNotified = true;
            this.responseHandler.sendCancelMessage();
        }
    }

    public boolean cancel(boolean z10) {
        this.isCancelled.set(true);
        this.request.abort();
        return isCancelled();
    }

    public Object getTag() {
        return this.responseHandler.getTag();
    }

    public boolean isCancelled() {
        boolean z10 = this.isCancelled.get();
        if (z10) {
            sendCancelNotification();
        }
        return z10;
    }

    public boolean isDone() {
        if (isCancelled() || this.isFinished) {
            return true;
        }
        return false;
    }

    public void onPostProcessRequest(AsyncHttpRequest asyncHttpRequest) {
    }

    public void onPreProcessRequest(AsyncHttpRequest asyncHttpRequest) {
    }

    public void run() {
        if (!isCancelled()) {
            if (!this.isRequestPreProcessed) {
                this.isRequestPreProcessed = true;
                onPreProcessRequest(this);
            }
            if (!isCancelled()) {
                this.responseHandler.sendStartMessage();
                if (!isCancelled()) {
                    try {
                        makeRequestWithRetries();
                    } catch (IOException e10) {
                        if (!isCancelled()) {
                            this.responseHandler.sendFailureMessage(0, (Header[]) null, (byte[]) null, e10);
                        } else {
                            AsyncHttpClient.log.e("AsyncHttpRequest", "makeRequestWithRetries returned error", e10);
                        }
                    }
                    if (!isCancelled()) {
                        this.responseHandler.sendFinishMessage();
                        if (!isCancelled()) {
                            onPostProcessRequest(this);
                            this.isFinished = true;
                        }
                    }
                }
            }
        }
    }

    public AsyncHttpRequest setRequestTag(Object obj) {
        this.responseHandler.setTag(obj);
        return this;
    }
}
