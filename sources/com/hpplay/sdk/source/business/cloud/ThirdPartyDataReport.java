package com.hpplay.sdk.source.business.cloud;

import android.util.SparseArray;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.api.LelinkPlayerInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.c.a;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.log.SourceLog;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
public class ThirdPartyDataReport {
    private static final String TAG = "ThirdPartyDataReport";

    public void requestMonitor(LelinkPlayerInfo lelinkPlayerInfo, String str, int i10, String str2) {
        if (lelinkPlayerInfo == null) {
            SourceLog.i(TAG, "requestMonitor info is null");
        } else if (lelinkPlayerInfo.getMonitors() == null || lelinkPlayerInfo.getMonitors().size() <= 0) {
            SourceLog.i(TAG, "requestMonitor monitors is empty");
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ParamsMap.DeviceParams.KEY_APPID, Session.getInstance().appKey);
                jSONObject.put(ParamsMap.DeviceParams.KEY_UID, Session.getInstance().getUID());
                jSONObject.put("u", str);
                jSONObject.put(ParamsMap.DeviceParams.KEY_HID, Session.getInstance().getHID());
                jSONObject.put("tid", Session.getInstance().tid);
                jSONObject.put("port", String.valueOf(i10));
                jSONObject.put("url", URLEncoder.encode(lelinkPlayerInfo.getUrl(), "UTF-8"));
                jSONObject.put("s", str2);
                jSONObject.put(BrowserInfo.KEY_VER, "1.0");
                jSONObject.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, a.a());
                SparseArray<Object> monitors = lelinkPlayerInfo.getMonitors();
                JSONArray jSONArray = new JSONArray();
                int size = monitors.size();
                for (int i11 = 0; i11 < size; i11++) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("sn", monitors.keyAt(i11));
                    jSONObject2.put("url", monitors.valueAt(i11));
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("monitors", jSONArray.toString());
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
            AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.s3rdPartyReport, jSONObject.toString());
            asyncHttpParameter.in.requestMethod = 1;
            AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() {
                public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                    AsyncHttpParameter.Out out = asyncHttpParameter.out;
                    if (out.resultType == 0) {
                        String str = out.result;
                        JSONObject jSONObject = null;
                        try {
                            JSONObject jSONObject2 = new JSONObject(str);
                            try {
                                if (jSONObject2.optInt(Constant.KEY_STATUS) == 200) {
                                    SourceLog.i(ThirdPartyDataReport.TAG, "requestMonitor sucess");
                                    return;
                                }
                                SourceLog.i(ThirdPartyDataReport.TAG, "requestMonitor json parce error:" + jSONObject2);
                            } catch (Exception unused) {
                                jSONObject = jSONObject2;
                                SourceLog.i(ThirdPartyDataReport.TAG, "requestMonitor json parce error:" + jSONObject);
                            }
                        } catch (Exception unused2) {
                            SourceLog.i(ThirdPartyDataReport.TAG, "requestMonitor json parce error:" + jSONObject);
                        }
                    } else {
                        SourceLog.i(ThirdPartyDataReport.TAG, "requestMonitor request error:" + asyncHttpParameter.out.result);
                    }
                }
            });
        }
    }
}
