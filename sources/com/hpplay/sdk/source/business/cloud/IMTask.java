package com.hpplay.sdk.source.business.cloud;

import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.c.a;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.Feature;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.HashMap;
import org.json.JSONObject;

public class IMTask {
    /* access modifiers changed from: private */
    public static String TAG = "IMTask";
    /* access modifiers changed from: private */
    public static int sTryCout;

    public static /* synthetic */ int access$108() {
        int i10 = sTryCout;
        sTryCout = i10 + 1;
        return i10;
    }

    public static void getIMUrl() {
        sTryCout = 0;
        updateIMRootUrl();
    }

    /* access modifiers changed from: private */
    public static void updateIMRootUrl() {
        if (!Feature.isDisableIM() && !TextUtils.isEmpty(a.a())) {
            String str = CloudAPI.sImDNSUrl + "/Author/GetImServer";
            HashMap hashMap = new HashMap();
            hashMap.put(ParamsMap.DeviceParams.KEY_UID, Session.getInstance().getUID());
            hashMap.put(ParamsMap.DeviceParams.KEY_APPID, Session.getInstance().appKey);
            hashMap.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, a.a());
            String mapParams = HapplayUtils.getMapParams(hashMap);
            SourceLog.i(TAG, "imdns url-->" + str + Operator.Operation.DIVISION + mapParams);
            AsyncManager.getInstance().exeHttpTask(new AsyncHttpParameter(str, mapParams), new AsyncHttpRequestListener() {
                public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                    JSONObject optJSONObject;
                    String access$000 = IMTask.TAG;
                    SourceLog.debug(access$000, "updateIMRoot result-->" + asyncHttpParameter.out.result);
                    AsyncHttpParameter.Out out = asyncHttpParameter.out;
                    if (out.resultType == 0) {
                        String str = out.result;
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                if (jSONObject.optInt(Constant.KEY_STATUS) == 200 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                                    int unused = IMTask.sTryCout = 0;
                                    String optString = optJSONObject.optString("server");
                                    if (optString.startsWith(HttpConstant.HTTP)) {
                                        CloudAPI.sImServer = optString;
                                        return;
                                    }
                                    CloudAPI.sImServer = "http://" + optString;
                                    return;
                                }
                            } catch (Exception e10) {
                                SourceLog.w(IMTask.TAG, (Throwable) e10);
                            }
                        }
                    }
                    if (IMTask.sTryCout < 3) {
                        IMTask.updateIMRootUrl();
                        IMTask.access$108();
                        return;
                    }
                    int unused2 = IMTask.sTryCout = 0;
                }
            });
        }
    }
}
