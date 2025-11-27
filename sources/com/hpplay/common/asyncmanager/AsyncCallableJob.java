package com.hpplay.common.asyncmanager;

import android.os.AsyncTask;
import com.hpplay.common.log.LeLog;
import java.util.concurrent.Callable;

public class AsyncCallableJob extends AsyncTask {
    private final String TAG = "AsyncCallableJob";
    private Callable callable;
    private AsyncCallableListener callableListener;

    public AsyncCallableJob(Callable callable2, AsyncCallableListener asyncCallableListener) {
        this.callable = callable2;
        this.callableListener = asyncCallableListener;
    }

    public Object doInBackground(Object[] objArr) {
        try {
            return this.callable.call();
        } catch (Exception e10) {
            LeLog.w("AsyncCallableJob", (Throwable) e10);
            return null;
        }
    }

    public void onCancelled() {
        super.onCancelled();
        AsyncCallableListener asyncCallableListener = this.callableListener;
        if (asyncCallableListener != null) {
            asyncCallableListener.onCallResult(2, (Object) null);
        }
    }

    public void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        AsyncCallableListener asyncCallableListener = this.callableListener;
        if (asyncCallableListener == null) {
            return;
        }
        if (obj == null) {
            asyncCallableListener.onCallResult(1, (Object) null);
        } else {
            asyncCallableListener.onCallResult(0, obj);
        }
    }
}
