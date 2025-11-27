package com.alibaba.sdk.android.httpdns.d;

import android.text.TextUtils;
import com.alibaba.sdk.android.httpdns.h;
import java.net.SocketTimeoutException;

public class c {
    public static int a() {
        return 0;
    }

    public static int a(Throwable th) {
        if (th instanceof h) {
            return ((h) th).getErrorCode();
        }
        return th instanceof SocketTimeoutException ? 10001 : 10000;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m10a(Throwable th) {
        if (th == null || TextUtils.isEmpty(th.getMessage())) {
            return th instanceof SocketTimeoutException ? "time out exception" : "default error";
        }
        return th.getMessage();
    }
}
