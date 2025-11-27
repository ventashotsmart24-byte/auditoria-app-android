package com.umeng.message.proguard;

import android.os.SystemClock;
import com.alibaba.sdk.android.httpdns.HttpDns;
import com.alibaba.sdk.android.httpdns.HttpDnsService;
import com.umeng.message.common.UPLog;

public final class bh {
    public static String a(String str, String str2) {
        String str3;
        String str4 = str2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            HttpDnsService service = HttpDns.getService(y.a(), str);
            service.setExpiredIPEnabled(true);
            service.setHTTPSRequestEnabled(true);
            str3 = null;
            int i10 = 0;
            while (true) {
                try {
                    str3 = service.getIpByHostAsync(str4);
                    if (str3 != null) {
                        break;
                    }
                    Thread.sleep(500);
                    int i11 = i10 + 1;
                    if (i11 >= 5) {
                        break;
                    }
                    i10 = i11;
                } catch (Throwable th) {
                    th = th;
                    try {
                        UPLog.i("HttpDns", "host parse error:", th.getMessage());
                        return str3;
                    } finally {
                        UPLog.i("HttpDns", "host:", str4, "ip:", str3, "consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                    }
                }
            }
            UPLog.i("HttpDns", "host:", str4, "ip:", str3, "consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        } catch (Throwable th2) {
            th = th2;
            str3 = null;
            UPLog.i("HttpDns", "host parse error:", th.getMessage());
            return str3;
        }
        return str3;
    }
}
