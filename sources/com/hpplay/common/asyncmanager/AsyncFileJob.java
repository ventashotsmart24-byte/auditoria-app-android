package com.hpplay.common.asyncmanager;

import android.os.AsyncTask;
import com.hpplay.common.asyncmanager.AsyncFileParameter;
import com.hpplay.common.asyncmanager.FileRequest;
import com.hpplay.common.log.LeLog;

public class AsyncFileJob extends AsyncTask {
    private String TAG = "AsyncFileJob";
    private FileRequest.DownloadListener downloadListener = new FileRequest.DownloadListener() {
        public void onDownLoad(int i10, long j10, long j11, int i11) {
            if (i11 == 0) {
                AsyncFileJob.this.publishProgress(new Object[]{Long.valueOf(j10), Long.valueOf(j11)});
            }
        }
    };
    private AsyncFileParameter fileParameter;
    private FileRequest fileRequest;
    public int id;
    private AsyncFileRequestListener requestListener;

    public AsyncFileJob(AsyncFileParameter asyncFileParameter, AsyncFileRequestListener asyncFileRequestListener) {
        this.fileParameter = asyncFileParameter;
        this.requestListener = asyncFileRequestListener;
    }

    public Object doInBackground(Object[] objArr) {
        AsyncFileParameter.In in = this.fileParameter.in;
        FileRequest fileRequest2 = new FileRequest(in.fileUrl, in.savePath);
        this.fileRequest = fileRequest2;
        fileRequest2.setDownloadListener(this.downloadListener);
        return Boolean.valueOf(this.fileRequest.download());
    }

    public void onCancelled() {
        AsyncFileParameter asyncFileParameter;
        super.onCancelled();
        FileRequest fileRequest2 = this.fileRequest;
        if (fileRequest2 != null) {
            try {
                fileRequest2.shutDown();
            } catch (Exception e10) {
                LeLog.w(this.TAG, (Throwable) e10);
            }
        }
        AsyncFileRequestListener asyncFileRequestListener = this.requestListener;
        if (asyncFileRequestListener != null && (asyncFileParameter = this.fileParameter) != null) {
            asyncFileParameter.out.resultType = 6;
            asyncFileRequestListener.onDownloadFinish(asyncFileParameter);
        }
    }

    public void onPostExecute(Object obj) {
        boolean z10;
        AsyncFileParameter asyncFileParameter;
        int i10;
        super.onPostExecute(obj);
        try {
            z10 = ((Boolean) obj).booleanValue();
        } catch (Exception e10) {
            LeLog.w(this.TAG, (Throwable) e10);
            z10 = false;
        }
        AsyncFileRequestListener asyncFileRequestListener = this.requestListener;
        if (asyncFileRequestListener != null && (asyncFileParameter = this.fileParameter) != null) {
            AsyncFileParameter.Out out = asyncFileParameter.out;
            if (z10) {
                i10 = 8;
            } else {
                i10 = 7;
            }
            out.resultType = i10;
            asyncFileRequestListener.onDownloadFinish(asyncFileParameter);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onProgressUpdate(java.lang.Object[] r7) {
        /*
            r6 = this;
            super.onProgressUpdate(r7)
            r0 = 0
            r1 = 0
            r0 = r7[r0]     // Catch:{ Exception -> 0x0026 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0026 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ Exception -> 0x0026 }
            long r3 = r0.longValue()     // Catch:{ Exception -> 0x0026 }
            r0 = 1
            r7 = r7[r0]     // Catch:{ Exception -> 0x0024 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0024 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x0024 }
            long r1 = r7.longValue()     // Catch:{ Exception -> 0x0024 }
            goto L_0x002d
        L_0x0024:
            r7 = move-exception
            goto L_0x0028
        L_0x0026:
            r7 = move-exception
            r3 = r1
        L_0x0028:
            java.lang.String r0 = r6.TAG
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r7)
        L_0x002d:
            com.hpplay.common.asyncmanager.AsyncFileRequestListener r7 = r6.requestListener
            if (r7 == 0) goto L_0x0041
            com.hpplay.common.asyncmanager.AsyncFileParameter r0 = r6.fileParameter
            if (r0 == 0) goto L_0x0041
            com.hpplay.common.asyncmanager.AsyncFileParameter$Out r0 = r0.out
            r5 = 5
            r0.resultType = r5
            r0.currentSize = r3
            r0.totalSize = r1
            r7.onDownloadUpdate(r3, r1)
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.common.asyncmanager.AsyncFileJob.onProgressUpdate(java.lang.Object[]):void");
    }
}
