package com.loopj.android.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;

public abstract class AsyncHttpResponseHandler implements ResponseHandlerInterface {
    protected static final int BUFFER_SIZE = 4096;
    protected static final int CANCEL_MESSAGE = 6;
    public static final String DEFAULT_CHARSET = "UTF-8";
    protected static final int FAILURE_MESSAGE = 1;
    protected static final int FINISH_MESSAGE = 3;
    private static final String LOG_TAG = "AsyncHttpRH";
    protected static final int PROGRESS_MESSAGE = 4;
    protected static final int RETRY_MESSAGE = 5;
    protected static final int START_MESSAGE = 2;
    protected static final int SUCCESS_MESSAGE = 0;
    public static final String UTF8_BOM = "﻿";
    private WeakReference<Object> TAG;
    private Handler handler;
    private Looper looper;
    private Header[] requestHeaders;
    private URI requestURI;
    private String responseCharset;
    private boolean usePoolThread;
    private boolean useSynchronousMode;

    public static class ResponderHandler extends Handler {
        private final AsyncHttpResponseHandler mResponder;

        public ResponderHandler(AsyncHttpResponseHandler asyncHttpResponseHandler, Looper looper) {
            super(looper);
            this.mResponder = asyncHttpResponseHandler;
        }

        public void handleMessage(Message message) {
            this.mResponder.handleMessage(message);
        }
    }

    public AsyncHttpResponseHandler() {
        this((Looper) null);
    }

    public String getCharset() {
        String str = this.responseCharset;
        if (str == null) {
            return "UTF-8";
        }
        return str;
    }

    public Header[] getRequestHeaders() {
        return this.requestHeaders;
    }

    public URI getRequestURI() {
        return this.requestURI;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        com.loopj.android.http.AsyncHttpClient.silentCloseInputStream(r0);
        com.loopj.android.http.AsyncHttpClient.endEntityViaReflection(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return r7.toByteArray();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getResponseData(org.apache.http.HttpEntity r13) {
        /*
            r12 = this;
            if (r13 == 0) goto L_0x0070
            java.io.InputStream r0 = r13.getContent()
            if (r0 == 0) goto L_0x0070
            long r1 = r13.getContentLength()
            r3 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0068
            r3 = 4096(0x1000, float:5.74E-42)
            r4 = 0
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x001e
            r6 = 4096(0x1000, float:5.74E-42)
            goto L_0x001f
        L_0x001e:
            int r6 = (int) r1
        L_0x001f:
            org.apache.http.util.ByteArrayBuffer r7 = new org.apache.http.util.ByteArrayBuffer     // Catch:{ OutOfMemoryError -> 0x005d }
            r7.<init>(r6)     // Catch:{ OutOfMemoryError -> 0x005d }
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0055 }
            r8 = r4
        L_0x0027:
            int r6 = r0.read(r3)     // Catch:{ all -> 0x0055 }
            r10 = -1
            if (r6 == r10) goto L_0x004a
            java.lang.Thread r10 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0055 }
            boolean r10 = r10.isInterrupted()     // Catch:{ all -> 0x0055 }
            if (r10 != 0) goto L_0x004a
            long r10 = (long) r6     // Catch:{ all -> 0x0055 }
            long r8 = r8 + r10
            r10 = 0
            r7.append(r3, r10, r6)     // Catch:{ all -> 0x0055 }
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0045
            r10 = 1
            goto L_0x0046
        L_0x0045:
            r10 = r1
        L_0x0046:
            r12.sendProgressMessage(r8, r10)     // Catch:{ all -> 0x0055 }
            goto L_0x0027
        L_0x004a:
            com.loopj.android.http.AsyncHttpClient.silentCloseInputStream(r0)     // Catch:{ OutOfMemoryError -> 0x005d }
            com.loopj.android.http.AsyncHttpClient.endEntityViaReflection(r13)     // Catch:{ OutOfMemoryError -> 0x005d }
            byte[] r13 = r7.toByteArray()     // Catch:{ OutOfMemoryError -> 0x005d }
            goto L_0x0071
        L_0x0055:
            r1 = move-exception
            com.loopj.android.http.AsyncHttpClient.silentCloseInputStream(r0)     // Catch:{ OutOfMemoryError -> 0x005d }
            com.loopj.android.http.AsyncHttpClient.endEntityViaReflection(r13)     // Catch:{ OutOfMemoryError -> 0x005d }
            throw r1     // Catch:{ OutOfMemoryError -> 0x005d }
        L_0x005d:
            java.lang.System.gc()
            java.io.IOException r13 = new java.io.IOException
            java.lang.String r0 = "File too large to fit into available memory"
            r13.<init>(r0)
            throw r13
        L_0x0068:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "HTTP entity too large to be buffered in memory"
            r13.<init>(r0)
            throw r13
        L_0x0070:
            r13 = 0
        L_0x0071:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loopj.android.http.AsyncHttpResponseHandler.getResponseData(org.apache.http.HttpEntity):byte[]");
    }

    public Object getTag() {
        return this.TAG.get();
    }

    public boolean getUsePoolThread() {
        return this.usePoolThread;
    }

    public boolean getUseSynchronousMode() {
        return this.useSynchronousMode;
    }

    public void handleMessage(Message message) {
        try {
            switch (message.what) {
                case 0:
                    Object[] objArr = (Object[]) message.obj;
                    if (objArr == null || objArr.length < 3) {
                        AsyncHttpClient.log.e(LOG_TAG, "SUCCESS_MESSAGE didn't got enough params");
                        return;
                    } else {
                        onSuccess(((Integer) objArr[0]).intValue(), (Header[]) objArr[1], (byte[]) objArr[2]);
                        return;
                    }
                case 1:
                    Object[] objArr2 = (Object[]) message.obj;
                    if (objArr2 == null || objArr2.length < 4) {
                        AsyncHttpClient.log.e(LOG_TAG, "FAILURE_MESSAGE didn't got enough params");
                        return;
                    } else {
                        onFailure(((Integer) objArr2[0]).intValue(), (Header[]) objArr2[1], (byte[]) objArr2[2], (Throwable) objArr2[3]);
                        return;
                    }
                case 2:
                    onStart();
                    return;
                case 3:
                    onFinish();
                    return;
                case 4:
                    Object[] objArr3 = (Object[]) message.obj;
                    if (objArr3 == null || objArr3.length < 2) {
                        AsyncHttpClient.log.e(LOG_TAG, "PROGRESS_MESSAGE didn't got enough params");
                        return;
                    } else {
                        onProgress(((Long) objArr3[0]).longValue(), ((Long) objArr3[1]).longValue());
                        return;
                    }
                case 5:
                    Object[] objArr4 = (Object[]) message.obj;
                    if (objArr4 == null || objArr4.length != 1) {
                        AsyncHttpClient.log.e(LOG_TAG, "RETRY_MESSAGE didn't get enough params");
                        return;
                    } else {
                        onRetry(((Integer) objArr4[0]).intValue());
                        return;
                    }
                case 6:
                    onCancel();
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            onUserException(th);
        }
        onUserException(th);
    }

    public Message obtainMessage(int i10, Object obj) {
        return Message.obtain(this.handler, i10, obj);
    }

    public void onCancel() {
        AsyncHttpClient.log.d(LOG_TAG, "Request got cancelled");
    }

    public abstract void onFailure(int i10, Header[] headerArr, byte[] bArr, Throwable th);

    public void onFinish() {
    }

    public void onPostProcessResponse(ResponseHandlerInterface responseHandlerInterface, HttpResponse httpResponse) {
    }

    public void onPreProcessResponse(ResponseHandlerInterface responseHandlerInterface, HttpResponse httpResponse) {
    }

    public void onProgress(long j10, long j11) {
        double d10;
        LogInterface logInterface = AsyncHttpClient.log;
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(j10);
        objArr[1] = Long.valueOf(j11);
        if (j11 > 0) {
            double d11 = (double) j10;
            Double.isNaN(d11);
            double d12 = (double) j11;
            Double.isNaN(d12);
            d10 = ((d11 * 1.0d) / d12) * 100.0d;
        } else {
            d10 = -1.0d;
        }
        objArr[2] = Double.valueOf(d10);
        logInterface.v(LOG_TAG, String.format("Progress %d from %d (%2.0f%%)", objArr));
    }

    public void onRetry(int i10) {
        AsyncHttpClient.log.d(LOG_TAG, String.format("Request retry no. %d", new Object[]{Integer.valueOf(i10)}));
    }

    public void onStart() {
    }

    public abstract void onSuccess(int i10, Header[] headerArr, byte[] bArr);

    public void onUserException(Throwable th) {
        AsyncHttpClient.log.e(LOG_TAG, "User-space exception detected!", th);
        throw new RuntimeException(th);
    }

    public void postRunnable(Runnable runnable) {
        Handler handler2;
        if (runnable == null) {
            return;
        }
        if (getUseSynchronousMode() || (handler2 = this.handler) == null) {
            runnable.run();
        } else {
            handler2.post(runnable);
        }
    }

    public final void sendCancelMessage() {
        sendMessage(obtainMessage(6, (Object) null));
    }

    public final void sendFailureMessage(int i10, Header[] headerArr, byte[] bArr, Throwable th) {
        sendMessage(obtainMessage(1, new Object[]{Integer.valueOf(i10), headerArr, bArr, th}));
    }

    public final void sendFinishMessage() {
        sendMessage(obtainMessage(3, (Object) null));
    }

    public void sendMessage(Message message) {
        boolean z10;
        if (getUseSynchronousMode() || this.handler == null) {
            handleMessage(message);
        } else if (!Thread.currentThread().isInterrupted()) {
            if (this.handler != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Utils.asserts(z10, "handler should not be null!");
            this.handler.sendMessage(message);
        }
    }

    public final void sendProgressMessage(long j10, long j11) {
        sendMessage(obtainMessage(4, new Object[]{Long.valueOf(j10), Long.valueOf(j11)}));
    }

    public void sendResponseMessage(HttpResponse httpResponse) {
        if (!Thread.currentThread().isInterrupted()) {
            StatusLine statusLine = httpResponse.getStatusLine();
            byte[] responseData = getResponseData(httpResponse.getEntity());
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            if (statusLine.getStatusCode() >= 300) {
                sendFailureMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), responseData, new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()));
            } else {
                sendSuccessMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), responseData);
            }
        }
    }

    public final void sendRetryMessage(int i10) {
        sendMessage(obtainMessage(5, new Object[]{Integer.valueOf(i10)}));
    }

    public final void sendStartMessage() {
        sendMessage(obtainMessage(2, (Object) null));
    }

    public final void sendSuccessMessage(int i10, Header[] headerArr, byte[] bArr) {
        sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i10), headerArr, bArr}));
    }

    public void setCharset(String str) {
        this.responseCharset = str;
    }

    public void setRequestHeaders(Header[] headerArr) {
        this.requestHeaders = headerArr;
    }

    public void setRequestURI(URI uri) {
        this.requestURI = uri;
    }

    public void setTag(Object obj) {
        this.TAG = new WeakReference<>(obj);
    }

    public void setUsePoolThread(boolean z10) {
        if (z10) {
            this.looper = null;
            this.handler = null;
        }
        this.usePoolThread = z10;
    }

    public void setUseSynchronousMode(boolean z10) {
        if (!z10 && this.looper == null) {
            AsyncHttpClient.log.w(LOG_TAG, "Current thread has not called Looper.prepare(). Forcing synchronous mode.");
            z10 = true;
        }
        if (!z10 && this.handler == null) {
            this.handler = new ResponderHandler(this, this.looper);
        } else if (z10 && this.handler != null) {
            this.handler = null;
        }
        this.useSynchronousMode = z10;
    }

    public AsyncHttpResponseHandler(Looper looper2) {
        this.responseCharset = "UTF-8";
        this.requestURI = null;
        this.requestHeaders = null;
        this.looper = null;
        this.TAG = new WeakReference<>((Object) null);
        this.looper = looper2 == null ? Looper.myLooper() : looper2;
        setUseSynchronousMode(false);
        setUsePoolThread(false);
    }

    public AsyncHttpResponseHandler(boolean z10) {
        this.responseCharset = "UTF-8";
        this.requestURI = null;
        this.requestHeaders = null;
        this.looper = null;
        this.TAG = new WeakReference<>((Object) null);
        setUsePoolThread(z10);
        if (!getUsePoolThread()) {
            this.looper = Looper.myLooper();
            setUseSynchronousMode(false);
        }
    }
}
