package com.loopj.android.http;

import org.apache.http.Header;
import org.apache.http.HttpResponse;

public class BlackholeHttpResponseHandler extends AsyncHttpResponseHandler {
    public void onCancel() {
    }

    public void onFailure(int i10, Header[] headerArr, byte[] bArr, Throwable th) {
    }

    public void onFinish() {
    }

    public void onPostProcessResponse(ResponseHandlerInterface responseHandlerInterface, HttpResponse httpResponse) {
    }

    public void onPreProcessResponse(ResponseHandlerInterface responseHandlerInterface, HttpResponse httpResponse) {
    }

    public void onProgress(long j10, long j11) {
    }

    public void onRetry(int i10) {
    }

    public void onStart() {
    }

    public void onSuccess(int i10, Header[] headerArr, byte[] bArr) {
    }

    public void onUserException(Throwable th) {
    }
}
