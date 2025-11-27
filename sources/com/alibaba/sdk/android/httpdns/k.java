package com.alibaba.sdk.android.httpdns;

import android.util.Log;
import com.alibaba.sdk.android.httpdns.d.b;
import java.lang.Thread;

public class k implements Thread.UncaughtExceptionHandler {
    private void b(Throwable th) {
        b a10 = b.a();
        if (a10 != null) {
            a10.k(th.getMessage());
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        try {
            Log.e("HttpDnsSDK", "Catch an uncaught exception, " + thread.getName() + ", error message: " + th.getMessage());
            b(th);
            th.printStackTrace();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
