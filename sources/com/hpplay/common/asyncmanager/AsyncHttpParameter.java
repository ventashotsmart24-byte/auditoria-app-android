package com.hpplay.common.asyncmanager;

import android.text.TextUtils;
import com.hpplay.common.log.LeLog;
import com.umeng.analytics.pro.by;
import java.util.List;
import java.util.Map;

public class AsyncHttpParameter {
    public static final int DEFAULT_SPACE = 0;
    public static final int DEFAULT_TRY_COUNT = 3;
    private final String TAG;
    public int id;
    public In in;
    public Out out;

    public class In {
        public int connectTimeout = by.f13999b;
        public String id;
        public String params = "";
        public int readTimeout = by.f13999b;
        public Map<String, String> requestHeaders;
        public int requestMethod = 0;
        public String requestUrl;
        public int tryCount = 3;
        public int trySpace = 0;

        public In() {
        }
    }

    public class Out {
        public Map<String, List<String>> headers;
        public int requestTryCount;
        public int responseCode = -1;
        public String result;
        public int resultType;

        public Out() {
        }
    }

    public AsyncHttpParameter(String str, String str2) {
        this(str, str2, 3);
    }

    public AsyncHttpParameter(String str, String str2, int i10) {
        this.TAG = "AsyncHttpParameter";
        if (i10 <= 0) {
            LeLog.w("AsyncHttpParameter", "tryCount must bigger than 0,use default value");
            i10 = 3;
        }
        this.in = new In();
        this.out = new Out();
        In in2 = this.in;
        in2.requestUrl = str;
        in2.tryCount = i10;
        if (TextUtils.isEmpty(str2)) {
            this.in.params = "";
        } else {
            this.in.params = str2;
        }
    }
}
