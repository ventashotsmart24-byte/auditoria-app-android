package org.android.agoo.control;

import android.text.TextUtils;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.k;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.message.MessageService;
import org.json.JSONObject;

class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ byte[] f8600a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f8601b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AgooFactory f8602c;

    public d(AgooFactory agooFactory, byte[] bArr, boolean z10) {
        this.f8602c = agooFactory;
        this.f8600a = bArr;
        this.f8601b = z10;
    }

    public void run() {
        String str;
        try {
            String str2 = new String(this.f8600a, XML.CHARSET_UTF8);
            if (TextUtils.isEmpty(str2)) {
                k.a("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, "msg==null", 0.0d);
                return;
            }
            ALog.i("AgooFactory", "message = " + str2, new Object[0]);
            JSONObject jSONObject = new JSONObject(str2);
            String string = jSONObject.getString("api");
            String string2 = jSONObject.getString("id");
            if (TextUtils.equals(string, "agooReport")) {
                str = jSONObject.getString(Constant.KEY_STATUS);
            } else {
                str = null;
            }
            if (TextUtils.equals(string, AgooConstants.AGOO_SERVICE_AGOOACK)) {
                k.a("accs", BaseMonitor.COUNT_AGOO_SUCCESS_ACK, "handlerACKMessage", 0.0d);
            }
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                if (!TextUtils.isEmpty(str)) {
                    if (ALog.isPrintLog(ALog.Level.I)) {
                        ALog.i("AgooFactory", "updateMsg data begin,api=" + string + ",id=" + string2 + ",status=" + str + ",reportTimes=" + Config.f(AgooFactory.mContext), new Object[0]);
                    }
                    if (TextUtils.equals(string, "agooReport")) {
                        if (TextUtils.equals(str, "4") && this.f8601b) {
                            this.f8602c.messageService.a(string2, "1");
                        } else if ((TextUtils.equals(str, MessageService.MSG_ACCS_NOTIFY_CLICK) || TextUtils.equals(str, MessageService.MSG_ACCS_NOTIFY_DISMISS)) && this.f8601b) {
                            this.f8602c.messageService.a(string2, "100");
                        }
                        k.a("accs", BaseMonitor.COUNT_AGOO_SUCCESS_ACK, str, 0.0d);
                        return;
                    }
                    return;
                }
            }
            k.a("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, "json key null", 0.0d);
        } catch (Throwable th) {
            ALog.e("AgooFactory", "updateMsg get data error,e=" + th, new Object[0]);
            k.a("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, "json exception", 0.0d);
        }
    }
}
