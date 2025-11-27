package com.taobao.accs.ut.a;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import java.util.Map;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f13132a;

    /* renamed from: b  reason: collision with root package name */
    public int f13133b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f13134c = false;

    /* renamed from: d  reason: collision with root package name */
    public int f13135d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f13136e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f13137f;

    /* renamed from: g  reason: collision with root package name */
    public String f13138g;

    /* renamed from: h  reason: collision with root package name */
    public long f13139h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13140i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f13141j;

    /* renamed from: k  reason: collision with root package name */
    private long f13142k = 0;

    public void a() {
        String str;
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        if (ALog.isPrintLog()) {
            ALog.d("MonitorStatistic", "commitUT interval:" + (currentTimeMillis - this.f13142k) + " interval1:" + (currentTimeMillis - this.f13139h), new Object[0]);
        }
        if (currentTimeMillis - this.f13142k > 1200000 && currentTimeMillis - this.f13139h > 60000) {
            HashMap hashMap = new HashMap();
            String str3 = null;
            try {
                String valueOf = String.valueOf(this.f13135d);
                try {
                    str = String.valueOf(this.f13136e);
                } catch (Throwable th) {
                    th = th;
                    str2 = null;
                    str = null;
                    str3 = valueOf;
                    ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, str3, str, str2, (Map<String, String>) hashMap) + " " + th.toString(), new Object[0]);
                }
                try {
                    str2 = String.valueOf(Constants.SDK_VERSION_CODE);
                } catch (Throwable th2) {
                    th = th2;
                    String str4 = str;
                    str2 = null;
                    str3 = valueOf;
                    ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, str3, str, str2, (Map<String, String>) hashMap) + " " + th.toString(), new Object[0]);
                }
                try {
                    hashMap.put("connStatus", String.valueOf(this.f13132a));
                    hashMap.put("connType", String.valueOf(this.f13133b));
                    hashMap.put("tcpConnected", String.valueOf(this.f13134c));
                    hashMap.put("proxy", String.valueOf(this.f13137f));
                    hashMap.put("startServiceTime", String.valueOf(this.f13139h));
                    hashMap.put("commitTime", String.valueOf(currentTimeMillis));
                    hashMap.put("networkAvailable", String.valueOf(this.f13140i));
                    hashMap.put("threadIsalive", String.valueOf(this.f13141j));
                    hashMap.put("url", this.f13138g);
                    if (ALog.isPrintLog(ALog.Level.D)) {
                        try {
                            ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, valueOf, str, str2, (Map<String, String>) hashMap), new Object[0]);
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    String str5 = str2;
                    String str6 = str;
                    try {
                        UTMini.getInstance().commitEvent(66001, "MONITOR", (Object) valueOf, (Object) str, (Object) str2, (Map<String, String>) hashMap);
                        this.f13142k = currentTimeMillis;
                    } catch (Throwable th4) {
                        th = th4;
                        str3 = valueOf;
                        str2 = str5;
                        str = str6;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    String str7 = str2;
                    String str8 = str;
                    str3 = valueOf;
                    ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, str3, str, str2, (Map<String, String>) hashMap) + " " + th.toString(), new Object[0]);
                }
            } catch (Throwable th6) {
                th = th6;
                str2 = null;
                str = null;
                ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, str3, str, str2, (Map<String, String>) hashMap) + " " + th.toString(), new Object[0]);
            }
        }
    }
}
