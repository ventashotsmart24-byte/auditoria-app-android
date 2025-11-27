package com.taobao.accs.ut.a;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import java.util.Map;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f13154a;

    /* renamed from: b  reason: collision with root package name */
    public String f13155b;

    /* renamed from: c  reason: collision with root package name */
    public String f13156c;

    /* renamed from: d  reason: collision with root package name */
    public String f13157d;

    /* renamed from: e  reason: collision with root package name */
    public String f13158e;

    /* renamed from: f  reason: collision with root package name */
    public String f13159f;

    /* renamed from: g  reason: collision with root package name */
    private final String f13160g = "sendAck";

    /* renamed from: h  reason: collision with root package name */
    private boolean f13161h = false;

    public void a() {
        String str;
        String str2;
        if (!this.f13161h) {
            this.f13161h = true;
            HashMap hashMap = new HashMap();
            try {
                str2 = this.f13154a;
                try {
                    str = String.valueOf(Constants.SDK_VERSION_CODE);
                    try {
                        hashMap.put("device_id", this.f13154a);
                        hashMap.put("session_id", this.f13155b);
                        hashMap.put("data_id", this.f13156c);
                        hashMap.put("ack_date", this.f13157d);
                        hashMap.put("service_id", this.f13158e);
                        hashMap.put("fail_reasons", this.f13159f);
                        UTMini.getInstance().commitEvent(66001, "sendAck", (Object) str2, (Object) null, (Object) str, (Map<String, String>) hashMap);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str = null;
                    ALog.d("accs.SendAckStatistic", UTMini.getCommitInfo(66001, str2, (String) null, str, (Map<String, String>) hashMap) + " " + th.toString(), new Object[0]);
                }
            } catch (Throwable th3) {
                th = th3;
                str2 = null;
                str = null;
                ALog.d("accs.SendAckStatistic", UTMini.getCommitInfo(66001, str2, (String) null, str, (Map<String, String>) hashMap) + " " + th.toString(), new Object[0]);
            }
        }
    }
}
