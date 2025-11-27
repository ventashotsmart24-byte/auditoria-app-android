package anet.channel.strategy.utils;

import android.content.Context;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.util.ALog;
import com.alibaba.sdk.android.httpdns.HttpDns;
import java.lang.reflect.Method;

public class c {
    /* JADX INFO: finally extract failed */
    public static String a(String str, String str2) {
        String str3;
        String str4;
        Class<String> cls = String.class;
        try {
            Context context = GlobalAppRuntimeInfo.getContext();
            Class<HttpDns> cls2 = HttpDns.class;
            int i10 = HttpDns.f4911a;
            Object invoke = cls2.getMethod("getService", new Class[]{Context.class, cls}).invoke((Object) null, new Object[]{context, str});
            Class cls3 = Boolean.TYPE;
            Method method = cls2.getMethod("setExpiredIPEnabled", new Class[]{cls3});
            Boolean bool = Boolean.TRUE;
            method.invoke(invoke, new Object[]{bool});
            cls2.getMethod("setHTTPSRequestEnabled", new Class[]{cls3}).invoke(invoke, new Object[]{bool});
            Method method2 = cls2.getMethod("getIpByHostAsync", new Class[]{cls});
            str3 = null;
            int i11 = 0;
            while (true) {
                try {
                    str4 = (String) method2.invoke(invoke, new Object[]{str2});
                    if (str4 != null) {
                        break;
                    }
                    try {
                        Thread.sleep(100);
                        i11++;
                        if (i11 >= 5) {
                            break;
                        }
                        str3 = str4;
                    } catch (Throwable th) {
                        th = th;
                        str3 = str4;
                        try {
                            ALog.i("awcn.LocalDnsStrategy", "httpDns", (String) null, str2, th.getMessage());
                            ALog.i("awcn.LocalDnsStrategy", "httpDns", (String) null, str2, str3);
                            return str3;
                        } catch (Throwable th2) {
                            ALog.i("awcn.LocalDnsStrategy", "httpDns", (String) null, str2, str3);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    ALog.i("awcn.LocalDnsStrategy", "httpDns", (String) null, str2, th.getMessage());
                    ALog.i("awcn.LocalDnsStrategy", "httpDns", (String) null, str2, str3);
                    return str3;
                }
            }
            ALog.i("awcn.LocalDnsStrategy", "httpDns", (String) null, str2, str4);
            return str4;
        } catch (Throwable th4) {
            th = th4;
            str3 = null;
            ALog.i("awcn.LocalDnsStrategy", "httpDns", (String) null, str2, th.getMessage());
            ALog.i("awcn.LocalDnsStrategy", "httpDns", (String) null, str2, str3);
            return str3;
        }
    }
}
