package com.umeng.ut.a.b;

import android.text.TextUtils;
import com.umeng.ut.a.c.b;
import com.umeng.ut.a.c.e;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f16217a = -1;

    /* renamed from: b  reason: collision with root package name */
    public long f16218b = 0;
    public byte[] data = null;
    public String signature = "";
    public long timestamp = 0;

    public static boolean a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                e.b("", "result", str, com.umeng.ccg.a.f14531x, str2);
                if (str2.equals(com.umeng.ut.b.a.a.a.a(b.c(str).getBytes(), 2))) {
                    e.a("", "signature is ok");
                    return true;
                }
                e.a("", "signature is error");
            }
        } catch (Exception e10) {
            e.a("", e10);
        }
        return false;
    }
}
