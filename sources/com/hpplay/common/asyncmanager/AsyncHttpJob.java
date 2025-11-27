package com.hpplay.common.asyncmanager;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.log.LeLog;

public abstract class AsyncHttpJob extends AsyncTask {
    private final String TAG = "AsyncHttpJob";
    private HttpRequest httpRequest;
    public int id;
    private AsyncHttpParameter inParameter;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable mTimeOutRunnable = new Runnable() {
        public void run() {
            LeLog.w("AsyncHttpJob", "http request timeout");
            AsyncHttpJob.this.onPostExecute((Object) null);
        }
    };
    private int method;
    private AsyncHttpRequestListener requestListener;

    public AsyncHttpJob(int i10, AsyncHttpParameter asyncHttpParameter, AsyncHttpRequestListener asyncHttpRequestListener) {
        this.method = i10;
        this.inParameter = asyncHttpParameter;
        this.requestListener = asyncHttpRequestListener;
    }

    public void cancelTimeOut() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mTimeOutRunnable);
            this.mHandler = null;
        }
    }

    public Object doInBackground(Object[] objArr) {
        this.httpRequest = new HttpRequest(this.inParameter.in, this);
        Handler handler = this.mHandler;
        Runnable runnable = this.mTimeOutRunnable;
        int i10 = this.inParameter.in.readTimeout;
        handler.postDelayed(runnable, (long) (i10 + i10));
        if (this.method == 1) {
            return this.httpRequest.doPost();
        }
        return this.httpRequest.doGet();
    }

    public void onCancelled() {
        super.onCancelled();
        LeLog.i("AsyncHttpJob", "onCancelled");
        AsyncHttpRequestListener asyncHttpRequestListener = this.requestListener;
        if (asyncHttpRequestListener != null) {
            AsyncHttpParameter asyncHttpParameter = this.inParameter;
            asyncHttpParameter.out.resultType = 2;
            asyncHttpRequestListener.onRequestResult(asyncHttpParameter);
            this.requestListener = null;
        }
        cancelTimeOut();
    }

    public void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        AsyncHttpRequestListener asyncHttpRequestListener = this.requestListener;
        if (asyncHttpRequestListener != null) {
            if (obj == null || !(obj instanceof HttpResult)) {
                AsyncHttpParameter asyncHttpParameter = this.inParameter;
                asyncHttpParameter.out.resultType = 1;
                asyncHttpRequestListener.onRequestResult(asyncHttpParameter);
            } else {
                HttpResult httpResult = (HttpResult) obj;
                AsyncHttpParameter.Out out = this.inParameter.out;
                out.resultType = httpResult.resultType;
                out.result = httpResult.result;
                out.responseCode = httpResult.responseCode;
                out.requestTryCount = this.httpRequest.getCount();
                AsyncHttpParameter asyncHttpParameter2 = this.inParameter;
                asyncHttpParameter2.out.headers = httpResult.headers;
                this.requestListener.onRequestResult(asyncHttpParameter2);
            }
            this.requestListener = null;
        }
        cancelTimeOut();
    }
}
