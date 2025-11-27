package com.taobao.accs.ut.a;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import java.util.Map;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f13143a;

    /* renamed from: b  reason: collision with root package name */
    public String f13144b;

    /* renamed from: c  reason: collision with root package name */
    public String f13145c;

    /* renamed from: d  reason: collision with root package name */
    public String f13146d;

    /* renamed from: e  reason: collision with root package name */
    public String f13147e;

    /* renamed from: f  reason: collision with root package name */
    public String f13148f;

    /* renamed from: g  reason: collision with root package name */
    public String f13149g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13150h = false;

    /* renamed from: i  reason: collision with root package name */
    public String f13151i;

    /* renamed from: j  reason: collision with root package name */
    private final String f13152j = "receiveMessage";

    /* renamed from: k  reason: collision with root package name */
    private boolean f13153k = false;

    public void a() {
        String str;
        String str2;
        String str3;
        if (!this.f13153k) {
            this.f13153k = true;
            HashMap hashMap = new HashMap();
            try {
                str2 = this.f13143a;
                try {
                    str = String.valueOf(Constants.SDK_VERSION_CODE);
                } catch (Throwable th) {
                    th = th;
                    str = null;
                    ALog.d("ReceiveMessage", UTMini.getCommitInfo(66001, str2, (String) null, str, (Map<String, String>) hashMap) + " " + th.toString(), new Object[0]);
                }
                try {
                    hashMap.put("device_id", this.f13143a);
                    hashMap.put("data_id", this.f13144b);
                    hashMap.put("receive_date", this.f13145c);
                    hashMap.put("to_bz_date", this.f13146d);
                    hashMap.put("service_id", this.f13147e);
                    hashMap.put("data_length", this.f13148f);
                    hashMap.put("msg_type", this.f13149g);
                    if (this.f13150h) {
                        str3 = "y";
                    } else {
                        str3 = "n";
                    }
                    hashMap.put("repeat", str3);
                    hashMap.put("user_id", this.f13151i);
                    UTMini.getInstance().commitEvent(66001, "receiveMessage", (Object) str2, (Object) null, (Object) str, (Map<String, String>) hashMap);
                } catch (Throwable th2) {
                    th = th2;
                    ALog.d("ReceiveMessage", UTMini.getCommitInfo(66001, str2, (String) null, str, (Map<String, String>) hashMap) + " " + th.toString(), new Object[0]);
                }
            } catch (Throwable th3) {
                th = th3;
                str2 = null;
                str = null;
                ALog.d("ReceiveMessage", UTMini.getCommitInfo(66001, str2, (String) null, str, (Map<String, String>) hashMap) + " " + th.toString(), new Object[0]);
            }
        }
    }
}
