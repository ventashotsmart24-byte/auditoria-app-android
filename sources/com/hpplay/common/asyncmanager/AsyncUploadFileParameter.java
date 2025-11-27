package com.hpplay.common.asyncmanager;

import android.text.TextUtils;
import com.hpplay.common.log.LeLog;
import java.util.Map;

public class AsyncUploadFileParameter {
    private final String TAG = "AsyncUploadFileParameter";
    public int id;
    public In in = new In();
    public Out out = new Out();

    public class In {
        public Map<String, String> headParameter;
        public HttpMethod httpMethod;
        public String id;
        public String[] localPath;
        public Class resultClass = String.class;
        public String url;

        public In() {
        }
    }

    public class Out {
        private Object result;
        public int resultType;

        public Out() {
        }

        public <T> T getResult() {
            try {
                return AsyncUploadFileParameter.this.in.resultClass.cast(this.result);
            } catch (Exception e10) {
                LeLog.w("AsyncUploadFileParameter", (Throwable) e10);
                return null;
            }
        }

        public void setResult(Object obj) {
            this.result = obj;
        }
    }

    public AsyncUploadFileParameter(String str, String[] strArr, Map<String, String> map) {
        In in2 = this.in;
        in2.url = str;
        in2.localPath = strArr;
        in2.headParameter = map;
        if (TextUtils.isEmpty(str)) {
            LeLog.w("AsyncUploadFileParameter", "savePath can not be null");
        }
    }
}
