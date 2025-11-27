package com.loopj.android.http;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonHttpResponseHandler extends TextHttpResponseHandler {
    private static final String LOG_TAG = "JsonHttpRH";
    /* access modifiers changed from: private */
    public boolean useRFC5179CompatibilityMode;

    public JsonHttpResponseHandler() {
        super("UTF-8");
        this.useRFC5179CompatibilityMode = true;
    }

    public boolean isUseRFC5179CompatibilityMode() {
        return this.useRFC5179CompatibilityMode;
    }

    public void onFailure(int i10, Header[] headerArr, Throwable th, JSONObject jSONObject) {
        AsyncHttpClient.log.w(LOG_TAG, "onFailure(int, Header[], Throwable, JSONObject) was not overriden, but callback was received", th);
    }

    public void onSuccess(int i10, Header[] headerArr, JSONObject jSONObject) {
        AsyncHttpClient.log.w(LOG_TAG, "onSuccess(int, Header[], JSONObject) was not overriden, but callback was received");
    }

    public Object parseResponse(byte[] bArr) {
        Object obj = null;
        if (bArr == null) {
            return null;
        }
        String responseString = TextHttpResponseHandler.getResponseString(bArr, getCharset());
        if (responseString != null) {
            responseString = responseString.trim();
            if (this.useRFC5179CompatibilityMode) {
                if (responseString.startsWith("{") || responseString.startsWith("[")) {
                    obj = new JSONTokener(responseString).nextValue();
                }
            } else if ((responseString.startsWith("{") && responseString.endsWith("}")) || (responseString.startsWith("[") && responseString.endsWith("]"))) {
                obj = new JSONTokener(responseString).nextValue();
            } else if (responseString.startsWith("\"") && responseString.endsWith("\"")) {
                obj = responseString.substring(1, responseString.length() - 1);
            }
        }
        if (obj == null) {
            return responseString;
        }
        return obj;
    }

    public void setUseRFC5179CompatibilityMode(boolean z10) {
        this.useRFC5179CompatibilityMode = z10;
    }

    public void onFailure(int i10, Header[] headerArr, Throwable th, JSONArray jSONArray) {
        AsyncHttpClient.log.w(LOG_TAG, "onFailure(int, Header[], Throwable, JSONArray) was not overriden, but callback was received", th);
    }

    public void onSuccess(int i10, Header[] headerArr, JSONArray jSONArray) {
        AsyncHttpClient.log.w(LOG_TAG, "onSuccess(int, Header[], JSONArray) was not overriden, but callback was received");
    }

    public JsonHttpResponseHandler(String str) {
        super(str);
        this.useRFC5179CompatibilityMode = true;
    }

    public void onFailure(int i10, Header[] headerArr, String str, Throwable th) {
        AsyncHttpClient.log.w(LOG_TAG, "onFailure(int, Header[], String, Throwable) was not overriden, but callback was received", th);
    }

    public void onSuccess(int i10, Header[] headerArr, String str) {
        AsyncHttpClient.log.w(LOG_TAG, "onSuccess(int, Header[], String) was not overriden, but callback was received");
    }

    public final void onFailure(int i10, Header[] headerArr, byte[] bArr, Throwable th) {
        if (bArr != null) {
            final byte[] bArr2 = bArr;
            final int i11 = i10;
            final Header[] headerArr2 = headerArr;
            final Throwable th2 = th;
            AnonymousClass2 r02 = new Runnable() {
                public void run() {
                    try {
                        final Object parseResponse = JsonHttpResponseHandler.this.parseResponse(bArr2);
                        JsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                if (JsonHttpResponseHandler.this.useRFC5179CompatibilityMode || parseResponse != null) {
                                    Object obj = parseResponse;
                                    if (obj instanceof JSONObject) {
                                        AnonymousClass2 r12 = AnonymousClass2.this;
                                        JsonHttpResponseHandler.this.onFailure(i11, headerArr2, th2, (JSONObject) obj);
                                    } else if (obj instanceof JSONArray) {
                                        AnonymousClass2 r13 = AnonymousClass2.this;
                                        JsonHttpResponseHandler.this.onFailure(i11, headerArr2, th2, (JSONArray) obj);
                                    } else if (obj instanceof String) {
                                        AnonymousClass2 r14 = AnonymousClass2.this;
                                        JsonHttpResponseHandler.this.onFailure(i11, headerArr2, (String) obj, th2);
                                    } else {
                                        AnonymousClass2 r02 = AnonymousClass2.this;
                                        JsonHttpResponseHandler jsonHttpResponseHandler = JsonHttpResponseHandler.this;
                                        int i10 = i11;
                                        Header[] headerArr = headerArr2;
                                        jsonHttpResponseHandler.onFailure(i10, headerArr, (Throwable) new JSONException("Unexpected response type " + parseResponse.getClass().getName()), (JSONObject) null);
                                    }
                                } else {
                                    AnonymousClass2 r03 = AnonymousClass2.this;
                                    JsonHttpResponseHandler.this.onFailure(i11, headerArr2, (String) null, th2);
                                }
                            }
                        });
                    } catch (JSONException e10) {
                        JsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                AnonymousClass2 r02 = AnonymousClass2.this;
                                JsonHttpResponseHandler.this.onFailure(i11, headerArr2, (Throwable) e10, (JSONObject) null);
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
            AsyncHttpClient.log.v(LOG_TAG, "response body is null, calling onFailure(Throwable, JSONObject)");
            onFailure(i10, headerArr, th, (JSONObject) null);
        }
    }

    public final void onSuccess(final int i10, final Header[] headerArr, final byte[] bArr) {
        if (i10 != 204) {
            AnonymousClass1 r02 = new Runnable() {
                public void run() {
                    try {
                        final Object parseResponse = JsonHttpResponseHandler.this.parseResponse(bArr);
                        JsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                if (JsonHttpResponseHandler.this.useRFC5179CompatibilityMode || parseResponse != null) {
                                    Object obj = parseResponse;
                                    if (obj instanceof JSONObject) {
                                        AnonymousClass1 r12 = AnonymousClass1.this;
                                        JsonHttpResponseHandler.this.onSuccess(i10, headerArr, (JSONObject) obj);
                                    } else if (obj instanceof JSONArray) {
                                        AnonymousClass1 r13 = AnonymousClass1.this;
                                        JsonHttpResponseHandler.this.onSuccess(i10, headerArr, (JSONArray) obj);
                                    } else if (!(obj instanceof String)) {
                                        AnonymousClass1 r02 = AnonymousClass1.this;
                                        JsonHttpResponseHandler jsonHttpResponseHandler = JsonHttpResponseHandler.this;
                                        int i10 = i10;
                                        Header[] headerArr = headerArr;
                                        jsonHttpResponseHandler.onFailure(i10, headerArr, (Throwable) new JSONException("Unexpected response type " + parseResponse.getClass().getName()), (JSONObject) null);
                                    } else if (JsonHttpResponseHandler.this.useRFC5179CompatibilityMode) {
                                        AnonymousClass1 r03 = AnonymousClass1.this;
                                        JsonHttpResponseHandler.this.onFailure(i10, headerArr, (String) parseResponse, (Throwable) new JSONException("Response cannot be parsed as JSON data"));
                                    } else {
                                        AnonymousClass1 r04 = AnonymousClass1.this;
                                        JsonHttpResponseHandler.this.onSuccess(i10, headerArr, (String) parseResponse);
                                    }
                                } else {
                                    AnonymousClass1 r05 = AnonymousClass1.this;
                                    JsonHttpResponseHandler.this.onSuccess(i10, headerArr, (String) null);
                                }
                            }
                        });
                    } catch (JSONException e10) {
                        JsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                AnonymousClass1 r02 = AnonymousClass1.this;
                                JsonHttpResponseHandler.this.onFailure(i10, headerArr, (Throwable) e10, (JSONObject) null);
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
            onSuccess(i10, headerArr, new JSONObject());
        }
    }

    public JsonHttpResponseHandler(boolean z10) {
        super("UTF-8");
        this.useRFC5179CompatibilityMode = z10;
    }

    public JsonHttpResponseHandler(String str, boolean z10) {
        super(str);
        this.useRFC5179CompatibilityMode = z10;
    }
}
