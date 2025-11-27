package com.hpplay.common.asyncmanager;

import android.os.AsyncTask;
import com.hpplay.common.log.LeLog;

public class AsyncRunnableJob extends AsyncTask {
    private final String TAG = "AsyncRunnableJob";
    private Runnable runnable;
    private AsyncRunnableListener runnableListener;

    public AsyncRunnableJob(Runnable runnable2, AsyncRunnableListener asyncRunnableListener) {
        this.runnable = runnable2;
        this.runnableListener = asyncRunnableListener;
    }

    public Object doInBackground(Object[] objArr) {
        try {
            this.runnable.run();
            return null;
        } catch (Exception e10) {
            LeLog.w("AsyncRunnableJob", (Throwable) e10);
            return null;
        }
    }

    public void onCancelled() {
        super.onCancelled();
        AsyncRunnableListener asyncRunnableListener = this.runnableListener;
        if (asyncRunnableListener != null) {
            asyncRunnableListener.onRunResult(2);
        }
    }

    public void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        AsyncRunnableListener asyncRunnableListener = this.runnableListener;
        if (asyncRunnableListener != null) {
            asyncRunnableListener.onRunResult(0);
        }
    }
}
