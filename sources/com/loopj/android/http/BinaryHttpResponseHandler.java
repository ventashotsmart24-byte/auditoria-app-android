package com.loopj.android.http;

import android.os.Looper;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;

public abstract class BinaryHttpResponseHandler extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "BinaryHttpRH";
    private String[] mAllowedContentTypes = {"application/octet-stream", "image/jpeg", "image/png", "image/gif"};

    public BinaryHttpResponseHandler() {
    }

    public String[] getAllowedContentTypes() {
        return this.mAllowedContentTypes;
    }

    public abstract void onFailure(int i10, Header[] headerArr, byte[] bArr, Throwable th);

    public abstract void onSuccess(int i10, Header[] headerArr, byte[] bArr);

    public final void sendResponseMessage(HttpResponse httpResponse) {
        StatusLine statusLine = httpResponse.getStatusLine();
        Header[] headers = httpResponse.getHeaders("Content-Type");
        if (headers.length != 1) {
            sendFailureMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), (byte[]) null, new HttpResponseException(statusLine.getStatusCode(), "None, or more than one, Content-Type Header found!"));
            return;
        }
        Header header = headers[0];
        boolean z10 = false;
        for (String str : getAllowedContentTypes()) {
            try {
                if (Pattern.matches(str, header.getValue())) {
                    z10 = true;
                }
            } catch (PatternSyntaxException e10) {
                AsyncHttpClient.log.e(LOG_TAG, "Given pattern is not valid: " + str, e10);
            }
        }
        if (!z10) {
            sendFailureMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), (byte[]) null, new HttpResponseException(statusLine.getStatusCode(), "Content-Type (" + header.getValue() + ") not allowed!"));
            return;
        }
        super.sendResponseMessage(httpResponse);
    }

    public BinaryHttpResponseHandler(String[] strArr) {
        if (strArr != null) {
            this.mAllowedContentTypes = strArr;
        } else {
            AsyncHttpClient.log.e(LOG_TAG, "Constructor passed allowedContentTypes was null !");
        }
    }

    public BinaryHttpResponseHandler(String[] strArr, Looper looper) {
        super(looper);
        if (strArr != null) {
            this.mAllowedContentTypes = strArr;
        } else {
            AsyncHttpClient.log.e(LOG_TAG, "Constructor passed allowedContentTypes was null !");
        }
    }
}
