package com.loopj.android.http;

import org.apache.http.Header;

public abstract class BaseJsonHttpResponseHandler<JSON_TYPE> extends TextHttpResponseHandler {
    private static final String LOG_TAG = "BaseJsonHttpRH";

    public BaseJsonHttpResponseHandler() {
        this("UTF-8");
    }

    public final void onFailure(int i10, Header[] headerArr, String str, Throwable th) {
        if (str != null) {
            final String str2 = str;
            final int i11 = i10;
            final Header[] headerArr2 = headerArr;
            final Throwable th2 = th;
            AnonymousClass2 r02 = new Runnable() {
                public void run() {
                    try {
                        final Object parseResponse = BaseJsonHttpResponseHandler.this.parseResponse(str2, true);
                        BaseJsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                AnonymousClass2 r02 = AnonymousClass2.this;
                                BaseJsonHttpResponseHandler.this.onFailure(i11, headerArr2, th2, str2, parseResponse);
                            }
                        });
                    } catch (Throwable th) {
                        AsyncHttpClient.log.d(BaseJsonHttpResponseHandler.LOG_TAG, "parseResponse thrown an problem", th);
                        BaseJsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                AnonymousClass2 r02 = AnonymousClass2.this;
                                BaseJsonHttpResponseHandler.this.onFailure(i11, headerArr2, th2, str2, null);
                            }
                        });
                    }
                }
            };
            if (getUseSynchronousMode() || getUsePoolThread()) {
                r02.run();
            } else {
                new Thread(r02).start();
            }
        } else {
            onFailure(i10, headerArr, th, (String) null, (Object) null);
        }
    }

    public abstract void onFailure(int i10, Header[] headerArr, Throwable th, String str, JSON_TYPE json_type);

    public final void onSuccess(final int i10, final Header[] headerArr, final String str) {
        if (i10 != 204) {
            AnonymousClass1 r02 = new Runnable() {
                public void run() {
                    try {
                        final Object parseResponse = BaseJsonHttpResponseHandler.this.parseResponse(str, false);
                        BaseJsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                AnonymousClass1 r02 = AnonymousClass1.this;
                                BaseJsonHttpResponseHandler.this.onSuccess(i10, headerArr, str, parseResponse);
                            }
                        });
                    } catch (Throwable th) {
                        AsyncHttpClient.log.d(BaseJsonHttpResponseHandler.LOG_TAG, "parseResponse thrown an problem", th);
                        BaseJsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                AnonymousClass1 r02 = AnonymousClass1.this;
                                BaseJsonHttpResponseHandler.this.onFailure(i10, headerArr, th, str, null);
                            }
                        });
                    }
                }
            };
            if (getUseSynchronousMode() || getUsePoolThread()) {
                r02.run();
            } else {
                new Thread(r02).start();
            }
        } else {
            onSuccess(i10, headerArr, (String) null, (Object) null);
        }
    }

    public abstract void onSuccess(int i10, Header[] headerArr, String str, JSON_TYPE json_type);

    public abstract JSON_TYPE parseResponse(String str, boolean z10);

    public BaseJsonHttpResponseHandler(String str) {
        super(str);
    }
}
