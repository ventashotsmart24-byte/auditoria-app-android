package com.hpplay.sdk.source.device.pincode;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.LelinkServiceInfoCreator;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.c.a;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.device.DevicePinParser;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.CreateUtil;
import com.taobao.accs.common.Constants;
import java.util.HashMap;
import org.json.JSONObject;

public class LelinkCodeParser implements CodeParser {
    private static final String TAG = "LelinkCodeParser";
    private static String sessionId;
    private static long startMarkTime;
    private Context mContext;
    /* access modifiers changed from: private */
    public IServiceInfoParseListener mListener;
    /* access modifiers changed from: private */
    public DevicePinParser mServerParser = new DevicePinParser();

    public LelinkCodeParser(Context context) {
        this.mContext = context;
    }

    /* access modifiers changed from: private */
    public void callbackToApp(int i10, LelinkServiceInfo lelinkServiceInfo) {
        IServiceInfoParseListener iServiceInfoParseListener = this.mListener;
        if (iServiceInfoParseListener != null) {
            iServiceInfoParseListener.onParseResult(i10, lelinkServiceInfo);
        }
        SourceDataReport.getInstance().onPinCodeEnd(lelinkServiceInfo, sessionId, i10, System.currentTimeMillis() - startMarkTime);
    }

    private void parsePinCodeByLocal(String str) {
        LelinkServiceInfo localPinCodeInfo = LelinkServiceInfoCreator.getLocalPinCodeInfo(this.mContext, str);
        if (localPinCodeInfo == null) {
            SourceLog.i(TAG, "parsePinCodeByLocal error: getLocalPinCodeInfo is null");
            if (this.mListener != null) {
                callbackToApp(0, (LelinkServiceInfo) null);
            }
        } else if (this.mListener != null) {
            callbackToApp(1, localPinCodeInfo);
        }
    }

    private void parsePinCodeByNet(final String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, a.a());
        hashMap.put(ParamsMap.DeviceParams.KEY_UID, Session.getInstance().getUID());
        hashMap.put(ParamsMap.DeviceParams.KEY_APPID, Session.getInstance().appKey);
        hashMap.put(Constants.KEY_HTTP_CODE, str);
        AsyncManager.getInstance().exeHttpTask(new AsyncHttpParameter(CloudAPI.sPinUrl, HapplayUtils.getMapParams(hashMap)), new AsyncHttpRequestListener() {
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                if (asyncHttpParameter.out.resultType == 2) {
                    SourceLog.w(LelinkCodeParser.TAG, "parsePinCodeByNet cancel request");
                    return;
                }
                SourceLog.debug(LelinkCodeParser.TAG, "parsePinCodeByNet onRequestResult result:" + asyncHttpParameter.out.result);
                AsyncHttpParameter.Out out = asyncHttpParameter.out;
                if (out.resultType != 0) {
                    SourceLog.i(LelinkCodeParser.TAG, "parsePinCodeByNet error: resultType not success");
                    if (LelinkCodeParser.this.mListener != null) {
                        LelinkCodeParser.this.callbackToApp(5, (LelinkServiceInfo) null);
                        return;
                    }
                    return;
                }
                String str = out.result;
                if (TextUtils.isEmpty(str)) {
                    SourceLog.i(LelinkCodeParser.TAG, "parsePinCodeByNet error: response is empty");
                    if (LelinkCodeParser.this.mListener != null) {
                        LelinkCodeParser.this.callbackToApp(5, (LelinkServiceInfo) null);
                        return;
                    }
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt(Constant.KEY_STATUS) != 200) {
                        if (LelinkCodeParser.this.mListener != null) {
                            LelinkCodeParser.this.callbackToApp(8, (LelinkServiceInfo) null);
                        }
                        SourceLog.i(LelinkCodeParser.TAG, "parsePinCodeByNet error: status not equals 200");
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        if (optJSONObject.length() > 0) {
                            LelinkServiceInfo netPinCodeInfo = LelinkServiceInfoCreator.getNetPinCodeInfo(optJSONObject, str);
                            if (netPinCodeInfo == null) {
                                SourceLog.i(LelinkCodeParser.TAG, "parsePinCodeByNet error: parse info is null");
                                if (LelinkCodeParser.this.mListener != null) {
                                    LelinkCodeParser.this.callbackToApp(5, (LelinkServiceInfo) null);
                                    return;
                                }
                                return;
                            } else if (LelinkCodeParser.this.mListener != null) {
                                LelinkCodeParser.this.callbackToApp(1, netPinCodeInfo);
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    if (LelinkCodeParser.this.mListener != null) {
                        LelinkCodeParser.this.callbackToApp(5, (LelinkServiceInfo) null);
                    }
                    SourceLog.i(LelinkCodeParser.TAG, "parsePinCodeByNet error: data is empty");
                } catch (Exception unused) {
                    SourceLog.i(LelinkCodeParser.TAG, "parsePinCodeByNet error: response not json");
                    if (LelinkCodeParser.this.mListener != null) {
                        LelinkCodeParser.this.callbackToApp(5, (LelinkServiceInfo) null);
                    }
                }
            }
        });
    }

    public void parsePinCode(PinCodeInfo pinCodeInfo) {
        if (!TextUtils.isEmpty(pinCodeInfo.pinCode) && pinCodeInfo.pinCode.length() < 9) {
            startMarkTime = System.currentTimeMillis();
            sessionId = CreateUtil.createSessionId();
            SourceDataReport.getInstance().onPinCodeStart(sessionId);
            HashMap hashMap = new HashMap();
            String str = pinCodeInfo.pinCode;
            hashMap.put(Constants.KEY_HTTP_CODE, str.toUpperCase());
            hashMap.put(ParamsMap.DeviceParams.KEY_APPID, Session.getInstance().appKey);
            hashMap.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, a.a());
            hashMap.put(ParamsMap.DeviceParams.KEY_UID, Session.getInstance().getUID());
            SourceLog.i(TAG, " short pincode result " + str + "  " + CloudAPI.sMultiMirrorPinUrl);
            AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sMultiMirrorPinUrl, HapplayUtils.getMapParams(hashMap));
            System.currentTimeMillis();
            AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() {
                public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                    if (asyncHttpParameter.out.resultType == 2) {
                        SourceLog.w(LelinkCodeParser.TAG, "parsePinCodeByNet cancel request");
                        return;
                    }
                    SourceLog.debug(LelinkCodeParser.TAG, " short pincode result " + asyncHttpParameter.out.result);
                    if (LelinkCodeParser.this.mListener == null) {
                        return;
                    }
                    if (!TextUtils.isEmpty(asyncHttpParameter.out.result)) {
                        try {
                            JSONObject jSONObject = new JSONObject(asyncHttpParameter.out.result);
                            int optInt = jSONObject.optInt(Constant.KEY_STATUS);
                            if (optInt == 200) {
                                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                                LelinkCodeParser.this.mServerParser.setParseResultListener(LelinkCodeParser.this.mListener);
                                LelinkCodeParser.this.mServerParser.parseServiceInfo(jSONObject2.toString(), 5);
                            } else if (optInt == 211) {
                                LelinkCodeParser.this.callbackToApp(8, (LelinkServiceInfo) null);
                            } else if (optInt == 221) {
                                LelinkCodeParser.this.callbackToApp(7, (LelinkServiceInfo) null);
                            } else {
                                LelinkCodeParser.this.callbackToApp(5, (LelinkServiceInfo) null);
                            }
                        } catch (Exception e10) {
                            SourceLog.w(LelinkCodeParser.TAG, (Throwable) e10);
                            LelinkCodeParser.this.callbackToApp(5, (LelinkServiceInfo) null);
                        }
                    } else {
                        LelinkCodeParser.this.callbackToApp(5, (LelinkServiceInfo) null);
                    }
                }
            });
        } else if (TextUtils.isEmpty(pinCodeInfo.pinCode) || pinCodeInfo.pinCode.length() != 9) {
            SourceLog.i(TAG, "parsePinCode code is empty or length not equals 9");
            if (this.mListener != null) {
                callbackToApp(0, (LelinkServiceInfo) null);
            }
        } else {
            char charAt = pinCodeInfo.pinCode.charAt(0);
            if (charAt == '7' || charAt == '8' || charAt == '9') {
                parsePinCodeByLocal(pinCodeInfo.pinCode);
            } else {
                parsePinCodeByNet(pinCodeInfo.pinCode);
            }
        }
    }

    public void release() {
    }

    public void setCodeCallback(IServiceInfoParseListener iServiceInfoParseListener) {
        this.mListener = iServiceInfoParseListener;
    }

    public void setConferenceFuzzyMatchingPinCodeCallback(IConferenceFuzzyMatchingPinCodeListener iConferenceFuzzyMatchingPinCodeListener) {
    }
}
