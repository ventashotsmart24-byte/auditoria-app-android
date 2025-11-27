package com.hpplay.common.asyncmanager;

import android.os.AsyncTask;
import com.hpplay.common.asyncmanager.AsyncUploadFileParameter;

public class AsyncUploadFileJob extends AsyncTask {
    private String TAG = "AsyncUploadFileJob";
    public int id;
    private AsyncUploadFileParameter inParameter;
    private AsyncUploadFileListener requestListener;
    private UploadFileRequest uploadFileRequest;

    public AsyncUploadFileJob(AsyncUploadFileParameter asyncUploadFileParameter, AsyncUploadFileListener asyncUploadFileListener) {
        this.inParameter = asyncUploadFileParameter;
        this.requestListener = asyncUploadFileListener;
    }

    public Object doInBackground(Object[] objArr) {
        AsyncUploadFileParameter.In in = this.inParameter.in;
        UploadFileRequest uploadFileRequest2 = new UploadFileRequest(in.url, in.localPath, in.headParameter, in.httpMethod);
        this.uploadFileRequest = uploadFileRequest2;
        return uploadFileRequest2.uploadFile();
    }

    public void onCancelled() {
        super.onCancelled();
    }

    public void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        AsyncUploadFileListener asyncUploadFileListener = this.requestListener;
        if (asyncUploadFileListener != null) {
            if (obj == null) {
                AsyncUploadFileParameter asyncUploadFileParameter = this.inParameter;
                asyncUploadFileParameter.out.resultType = 1;
                asyncUploadFileListener.onRequestResult(asyncUploadFileParameter);
            } else {
                AsyncUploadFileParameter.Out out = this.inParameter.out;
                out.resultType = 0;
                out.setResult(obj);
                this.requestListener.onRequestResult(this.inParameter);
            }
            this.requestListener = null;
        }
    }

    public void onProgressUpdate(Object[] objArr) {
        super.onProgressUpdate(objArr);
    }
}
