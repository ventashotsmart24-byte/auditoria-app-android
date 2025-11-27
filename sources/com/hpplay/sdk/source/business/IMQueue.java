package com.hpplay.sdk.source.business;

import android.os.AsyncTask;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.concurrent.ConcurrentLinkedQueue;

public class IMQueue {
    private static final String TAG = "IMQueue";
    private static IMQueue sInstance;
    /* access modifiers changed from: private */
    public AsyncTask mAsyncTask = null;
    private ConcurrentLinkedQueue<Bean> mTaskQueue = new ConcurrentLinkedQueue<>();

    public static class Bean {
        public AsyncHttpRequestListener listener;
        public AsyncHttpParameter parameter;
    }

    private IMQueue() {
    }

    public static synchronized IMQueue getInstance() {
        IMQueue iMQueue;
        synchronized (IMQueue.class) {
            if (sInstance == null) {
                sInstance = new IMQueue();
            }
            iMQueue = sInstance;
        }
        return iMQueue;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r0 = r4.mTaskQueue.poll();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trigTask() {
        /*
            r4 = this;
            android.os.AsyncTask r0 = r4.mAsyncTask
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.util.concurrent.ConcurrentLinkedQueue<com.hpplay.sdk.source.business.IMQueue$Bean> r0 = r4.mTaskQueue
            java.lang.Object r0 = r0.poll()
            com.hpplay.sdk.source.business.IMQueue$Bean r0 = (com.hpplay.sdk.source.business.IMQueue.Bean) r0
            if (r0 != 0) goto L_0x0010
            return
        L_0x0010:
            com.hpplay.common.asyncmanager.AsyncManager r1 = com.hpplay.common.asyncmanager.AsyncManager.getInstance()
            com.hpplay.common.asyncmanager.AsyncHttpParameter r2 = r0.parameter
            com.hpplay.sdk.source.business.IMQueue$1 r3 = new com.hpplay.sdk.source.business.IMQueue$1
            r3.<init>(r0)
            com.hpplay.common.asyncmanager.AsyncHttpJob r0 = r1.exeHttpTask(r2, r3)
            r4.mAsyncTask = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.business.IMQueue.trigTask():void");
    }

    public Bean addTask(AsyncHttpParameter asyncHttpParameter, AsyncHttpRequestListener asyncHttpRequestListener) {
        Bean bean = new Bean();
        bean.parameter = asyncHttpParameter;
        bean.listener = asyncHttpRequestListener;
        this.mTaskQueue.offer(bean);
        trigTask();
        return bean;
    }

    public void clearTask() {
        this.mTaskQueue.clear();
        try {
            AsyncTask asyncTask = this.mAsyncTask;
            if (asyncTask != null) {
                asyncTask.cancel(true);
                this.mAsyncTask = null;
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void removeTask(Bean bean) {
        this.mTaskQueue.remove(bean);
    }
}
