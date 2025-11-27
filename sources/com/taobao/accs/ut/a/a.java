package com.taobao.accs.ut.a;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f13119a;

    /* renamed from: b  reason: collision with root package name */
    public String f13120b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f13121c;

    /* renamed from: d  reason: collision with root package name */
    public String f13122d;

    /* renamed from: e  reason: collision with root package name */
    private final String f13123e = "BindApp";

    /* renamed from: f  reason: collision with root package name */
    private boolean f13124f = false;

    private void b(String str) {
        String str2;
        String str3;
        String str4;
        if (!this.f13124f) {
            this.f13124f = true;
            HashMap hashMap = new HashMap();
            try {
                str3 = this.f13119a;
                try {
                    str2 = String.valueOf(Constants.SDK_VERSION_CODE);
                } catch (Throwable th) {
                    th = th;
                    str2 = null;
                    ALog.d("BindAppStatistic", UTMini.getCommitInfo(66001, str3, (String) null, str2, (Map<String, String>) hashMap) + " " + th.toString(), new Object[0]);
                }
                try {
                    hashMap.put("device_id", this.f13119a);
                    hashMap.put("bind_date", this.f13120b);
                    if (this.f13121c) {
                        str4 = "y";
                    } else {
                        str4 = "n";
                    }
                    hashMap.put("ret", str4);
                    hashMap.put("fail_reasons", this.f13122d);
                    hashMap.put("push_token", "");
                    UTMini.getInstance().commitEvent(66001, str, (Object) str3, (Object) null, (Object) str2, (Map<String, String>) hashMap);
                } catch (Throwable th2) {
                    th = th2;
                    ALog.d("BindAppStatistic", UTMini.getCommitInfo(66001, str3, (String) null, str2, (Map<String, String>) hashMap) + " " + th.toString(), new Object[0]);
                }
            } catch (Throwable th3) {
                th = th3;
                str3 = null;
                str2 = null;
                ALog.d("BindAppStatistic", UTMini.getCommitInfo(66001, str3, (String) null, str2, (Map<String, String>) hashMap) + " " + th.toString(), new Object[0]);
            }
        }
    }

    public void a(String str) {
        this.f13122d = str;
    }

    public void a(int i10) {
        if (i10 == -4) {
            a("msg too large");
        } else if (i10 == -3) {
            a("service not available");
        } else if (i10 == -2) {
            a("param error");
        } else if (i10 == -1) {
            a("network fail");
        } else if (i10 == 200) {
        } else {
            if (i10 != 300) {
                a(String.valueOf(i10));
            } else {
                a("app not bind");
            }
        }
    }

    public void a() {
        b("BindApp");
    }
}
