package com.umeng.ut.a.a;

import android.content.Context;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.ut.b.a.a.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class a {
    public static String a(String str) {
        String str2;
        Context a10 = com.umeng.ut.a.a.a().a();
        if (a10 == null) {
            return "";
        }
        try {
            str2 = UMUtils.getAppkey(a10);
        } catch (Throwable unused) {
            str2 = "";
        }
        return d.d(String.format("{\"type\":\"%s\",\"timestamp\":%s,\"data\":%s}", new Object[]{"audid", com.umeng.ut.a.a.a().a(), a(str, "", str2, a10.getPackageName())}));
    }

    private static String a(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("audid", str2);
        hashMap.put("utdid", str);
        hashMap.put("appkey", str3);
        hashMap.put(DispatchConstants.APP_NAME, str4);
        return new JSONObject(d.a((Map<String, String>) hashMap)).toString();
    }
}
