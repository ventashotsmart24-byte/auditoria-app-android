package com.hpplay.sdk.source.business.cloud;

import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.bean.PassSinkAuthBean;
import com.hpplay.sdk.source.bean.VipAuthResultBean;
import com.hpplay.sdk.source.bean.VipAuthSetting;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.PassSender;
import com.hpplay.sdk.source.utils.AppContextUtils;
import com.hpplay.sdk.source.utils.HpplayUtil;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class RightsManager {
    private static final String TAG = "RightsManager";
    public static final String VIP_KEY_LEBO_CLOUDMIRROR = "LEBO_CLOUDMIRROR_QY";
    private static Session mSession;
    private static RightsManager singleInstance;
    private Map<String, PassSinkAuthBean> mPassSinkAuthMap = new HashMap();
    /* access modifiers changed from: private */
    public Map<String, List<VipAuthResultBean.VipAuthDataEntity.AuthInfo>> mSinkAuthInfoMap = new HashMap();
    /* access modifiers changed from: private */
    public List<VipAuthResultBean.VipAuthDataEntity.AuthInfo> mSourceAuthInfo;

    private RightsManager() {
        mSession = Session.getInstance();
    }

    public static synchronized RightsManager getInstance() {
        RightsManager rightsManager;
        synchronized (RightsManager.class) {
            if (singleInstance == null) {
                synchronized (RightsManager.class) {
                    if (singleInstance == null) {
                        singleInstance = new RightsManager();
                    }
                }
            }
            rightsManager = singleInstance;
        }
        return rightsManager;
    }

    private boolean hasVipFeatureInAuthInfo(String str, List<VipAuthResultBean.VipAuthDataEntity.AuthInfo> list) {
        if (!(list == null || str == null)) {
            for (VipAuthResultBean.VipAuthDataEntity.AuthInfo authInfo : list) {
                if (str.equalsIgnoreCase(authInfo.key)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void requestSinkTempVipInfo(final String str, String str2) {
        HashMap hashMap = new HashMap();
        Session instance = Session.getInstance();
        hashMap.put(ParamsMap.DeviceParams.KEY_APPID, instance.appKey);
        hashMap.put(ParamsMap.DeviceParams.KEY_UID, instance.getUID());
        hashMap.put(ParamsMap.DeviceParams.KEY_RECEIVER_UID, str);
        hashMap.put("rappid", str2);
        hashMap.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, instance.getToken());
        hashMap.put("sdkVer", String.valueOf(41214));
        SourceLog.i(TAG, "requestSinkVipInfo " + CloudAPI.sTemporaryAuth + Operator.Operation.EMPTY_PARAM + HapplayUtils.getJsonParams(hashMap));
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sTemporaryAuth, HapplayUtils.getJsonParams(hashMap));
        asyncHttpParameter.in.requestMethod = 1;
        AsyncManager.getInstance().exeHttpTaskWithoutParallel(asyncHttpParameter, new AsyncHttpRequestListener() {
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                SourceLog.debug(RightsManager.TAG, "requestSinkVipInfo result: " + asyncHttpParameter.out.result);
                if (asyncHttpParameter.out.resultType == 2) {
                    SourceLog.i(RightsManager.TAG, "requestSinkVipInfo onRequestResult,cancel request");
                    return;
                }
                try {
                    VipAuthResultBean vipAuthResultBean = new VipAuthResultBean(new JSONObject(asyncHttpParameter.out.result));
                    if (vipAuthResultBean.status == 200) {
                        VipAuthResultBean.VipAuthDataEntity vipAuthDataEntity = vipAuthResultBean.data;
                        if (vipAuthDataEntity != null) {
                            if (TextUtils.isEmpty(vipAuthDataEntity.sign) || vipAuthResultBean.data.sign.equalsIgnoreCase(HpplayUtil.getVipAuthInfoSign(AppContextUtils.getInstance().getAppContext(), vipAuthResultBean.data.stime, asyncHttpParameter.out.result)) || vipAuthResultBean.data.sign.equalsIgnoreCase(HpplayUtil.getVipAuthInfoLeBoSign(AppContextUtils.getInstance().getAppContext(), vipAuthResultBean.data.stime, asyncHttpParameter.out.result))) {
                                RightsManager.this.mSinkAuthInfoMap.put(str, vipAuthResultBean.data.authinfo);
                                return;
                            } else {
                                SourceLog.i(RightsManager.TAG, "requestSinkVipInfo sign not pass ");
                                return;
                            }
                        }
                    }
                    SourceLog.i(RightsManager.TAG, "requestSinkVipInfo data is illegal argument");
                } catch (Exception e10) {
                    SourceLog.w(RightsManager.TAG, (Throwable) e10);
                }
            }
        });
    }

    public void getSinkTempRights(String str, int i10, int i11) {
        if (i11 == 4) {
            requestSinkTempVipInfo(str, String.valueOf(i10));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ParamsMap.DeviceParams.KEY_UID, str);
        } catch (JSONException e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
        PassSender.getInstance().sendVIPQuery(jSONObject.toString());
    }

    public void handleNetConnectMessage(String str, String str2) {
        try {
            SourceLog.i(TAG, "handleNetConnectMessage: " + str + " / " + str2);
            this.mPassSinkAuthMap.put(str, new PassSinkAuthBean(new JSONObject(str2)));
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void handleRightMessage(String str, String str2) {
        try {
            SourceLog.i(TAG, "handleRightMessage: " + str + " / " + str2);
            this.mPassSinkAuthMap.put(str, new PassSinkAuthBean(new JSONObject(str2)));
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasVipFeature(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            boolean r0 = com.hpplay.sdk.source.utils.Feature.isLeboApp()
            r1 = 1
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.util.Map<java.lang.String, com.hpplay.sdk.source.bean.PassSinkAuthBean> r0 = r5.mPassSinkAuthMap
            java.lang.Object r0 = r0.get(r6)
            com.hpplay.sdk.source.bean.PassSinkAuthBean r0 = (com.hpplay.sdk.source.bean.PassSinkAuthBean) r0
            r2 = 0
            if (r0 == 0) goto L_0x0025
            boolean r3 = r0.enterprise
            java.lang.String r4 = "LEBO_CLOUDMIRROR_QY"
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x0026
            if (r3 != 0) goto L_0x0023
            boolean r0 = r0.cm
            if (r0 == 0) goto L_0x0025
        L_0x0023:
            r3 = 1
            goto L_0x0026
        L_0x0025:
            r3 = 0
        L_0x0026:
            if (r3 != 0) goto L_0x0040
            java.util.List<com.hpplay.sdk.source.bean.VipAuthResultBean$VipAuthDataEntity$AuthInfo> r0 = r5.mSourceAuthInfo
            boolean r0 = r5.hasVipFeatureInAuthInfo(r7, r0)
            if (r0 != 0) goto L_0x0040
            java.util.Map<java.lang.String, java.util.List<com.hpplay.sdk.source.bean.VipAuthResultBean$VipAuthDataEntity$AuthInfo>> r0 = r5.mSinkAuthInfoMap
            java.lang.Object r6 = r0.get(r6)
            java.util.List r6 = (java.util.List) r6
            boolean r6 = r5.hasVipFeatureInAuthInfo(r7, r6)
            if (r6 == 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r1 = 0
        L_0x0040:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.business.cloud.RightsManager.hasVipFeature(java.lang.String, java.lang.String):boolean");
    }

    public void loginVipAuth(VipAuthSetting vipAuthSetting) {
        loginVipAuth(vipAuthSetting, 2);
    }

    public void logout() {
        SourceLog.i(TAG, "logout");
        this.mSourceAuthInfo = null;
        Preference.getInstance().put(Constant.KEY_VUUID, "");
        Preference.getInstance().put(Constant.KEY_VSESSION, "");
    }

    public void removeSinkRights(String str) {
        SourceLog.i(TAG, "removeSinkRights:" + str);
        this.mSinkAuthInfoMap.remove(str);
        this.mPassSinkAuthMap.remove(str);
    }

    public void vipAuth() {
        SourceLog.i(TAG, "vipAuth");
        vipAuth(2);
    }

    private void loginVipAuth(VipAuthSetting vipAuthSetting, int i10) {
        String str;
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put(ParamsMap.DeviceParams.KEY_UID, mSession.getUID());
        hashMap.put(ParamsMap.DeviceParams.KEY_APPID, mSession.appKey);
        hashMap.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, mSession.getToken());
        hashMap.put("tid", mSession.tid);
        if (vipAuthSetting == null) {
            str = "";
        } else {
            str = vipAuthSetting.uuid;
        }
        hashMap.put("uuid", str);
        if (vipAuthSetting == null) {
            str2 = "";
        } else {
            str2 = vipAuthSetting.ssid;
        }
        hashMap.put(BrowserInfo.KEY_SSID, str2);
        hashMap.put(ParamsMap.DeviceParams.KEY_HID, mSession.getHID());
        hashMap.put("sdk_ver", String.valueOf(41214));
        hashMap.put("ehid", Preference.getInstance().get(Constant.KEY_SUPER_DEVICE_ID, ""));
        hashMap.put("prot_ver", "1.0");
        SourceLog.i(TAG, "loginVipAuth " + CloudAPI.sVipAuth + "," + HapplayUtils.getJsonParams(hashMap));
        final AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sVipAuth, HapplayUtils.getJsonParams(hashMap), i10);
        AsyncHttpParameter.In in = asyncHttpParameter.in;
        in.requestMethod = 1;
        in.connectTimeout = 10000;
        in.readTimeout = 10000;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() {
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                SourceLog.debug(RightsManager.TAG, "loginVipAuth onRequestResult = " + asyncHttpParameter.out.result);
                int i10 = asyncHttpParameter.out.resultType;
                if (i10 == 2) {
                    SourceLog.w(RightsManager.TAG, "loginVipAuth cancel request");
                } else if (i10 == 0) {
                    try {
                        VipAuthResultBean vipAuthResultBean = new VipAuthResultBean(new JSONObject(asyncHttpParameter.out.result));
                        int i11 = vipAuthResultBean.status;
                        if (i11 != 200 && asyncHttpParameter.out.requestTryCount < asyncHttpParameter.in.tryCount) {
                            SourceLog.i(RightsManager.TAG, "loginVipAuth status illgeal,request again: " + asyncHttpParameter.out.requestTryCount);
                            RightsManager.this.vipAuth(asyncHttpParameter.in.tryCount - asyncHttpParameter.out.requestTryCount);
                        } else if (i11 == 404) {
                            RightsManager.this.logout();
                        } else {
                            if (i11 == 200) {
                                VipAuthResultBean.VipAuthDataEntity vipAuthDataEntity = vipAuthResultBean.data;
                                if (vipAuthDataEntity != null) {
                                    if (TextUtils.isEmpty(vipAuthDataEntity.sign) || vipAuthResultBean.data.sign.equalsIgnoreCase(HpplayUtil.getVipAuthInfoSign(AppContextUtils.getInstance().getAppContext(), vipAuthResultBean.data.stime, asyncHttpParameter.out.result)) || vipAuthResultBean.data.sign.equalsIgnoreCase(HpplayUtil.getVipAuthInfoLeBoSign(AppContextUtils.getInstance().getAppContext(), vipAuthResultBean.data.stime, asyncHttpParameter.out.result))) {
                                        List unused = RightsManager.this.mSourceAuthInfo = vipAuthResultBean.data.authinfo;
                                        return;
                                    } else {
                                        SourceLog.i(RightsManager.TAG, "loginVipAuth sign not pass ");
                                        return;
                                    }
                                }
                            }
                            SourceLog.i(RightsManager.TAG, "loginVipAuth data is illegal argument");
                        }
                    } catch (Exception e10) {
                        SourceLog.w(RightsManager.TAG, (Throwable) e10);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void vipAuth(int i10) {
        String str = Preference.getInstance().get(Constant.KEY_VUUID, "");
        String str2 = Preference.getInstance().get(Constant.KEY_VSESSION, "");
        VipAuthSetting vipAuthSetting = new VipAuthSetting();
        vipAuthSetting.uuid = str;
        vipAuthSetting.ssid = str2;
        loginVipAuth(vipAuthSetting, i10);
    }
}
