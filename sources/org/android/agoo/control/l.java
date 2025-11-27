package org.android.agoo.control;

import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.b;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.j;
import java.net.URL;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.json.JSONObject;

class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f8614a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f8615b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f8616c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f8617d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ NotifManager f8618e;

    public l(NotifManager notifManager, String str, String str2, String str3, boolean z10) {
        this.f8618e = notifManager;
        this.f8614a = str;
        this.f8615b = str2;
        this.f8616c = str3;
        this.f8617d = z10;
    }

    public void run() {
        String str;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("thirdTokenType", this.f8614a);
            hashMap.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, this.f8615b);
            hashMap.put("appkey", Config.a(this.f8618e.mContext));
            hashMap.put("utdid", j.b(this.f8618e.mContext));
            if (!TextUtils.isEmpty(this.f8616c)) {
                hashMap.put("vendorSdkVersion", this.f8616c);
            }
            ALog.d("NotifManager", "report,utdid=" + j.b(this.f8618e.mContext) + ",regId=" + this.f8615b + ",type=" + this.f8614a, new Object[0]);
            ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest((String) null, "agooTokenReport", new JSONObject(hashMap).toString().getBytes("UTF-8"), (String) null, (String) null, (URL) null, (String) null);
            b accsInstance = ACCSManager.getAccsInstance(this.f8618e.mContext, Config.a(this.f8618e.mContext), Config.c(this.f8618e.mContext));
            if (this.f8617d) {
                str = accsInstance.a(this.f8618e.mContext, accsRequest);
            } else {
                str = accsInstance.a(this.f8618e.mContext, accsRequest, new TaoBaseService.ExtraInfo());
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.i("NotifManager", "reportThirdPushToken,dataId=" + str + ",regId=" + this.f8615b + ",type=" + this.f8614a, new Object[0]);
            }
        } catch (Throwable th) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "reportThirdPushToken", j.b(this.f8618e.mContext), th.toString());
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.e("NotifManager", "[report] is error", th, new Object[0]);
            }
        }
    }
}
