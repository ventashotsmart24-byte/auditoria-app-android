package com.hpplay.sdk.source.device;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.browse.data.LelinkServiceInfoCreator;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.CreateUtil;
import com.hpplay.sdk.source.utils.Feature;
import com.taobao.accs.common.Constants;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class DevicePinParser {
    private static final int DELAY_CALLBACK_IM = 500;
    private static final String TAG = "DevicePinParser";
    private static final int WHAT_CALLBACK_IM = 1;
    private Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            Object obj;
            if (message.what != 1 || (obj = message.obj) == null) {
                return false;
            }
            DevicePinParser.this.callbackIMFirst((LelinkServiceInfo) obj);
            return false;
        }
    });
    /* access modifiers changed from: private */
    public IServiceInfoParseListener mServiceInfoParseListener;

    /* access modifiers changed from: private */
    public void callbackIMFirst(LelinkServiceInfo lelinkServiceInfo) {
        if (lelinkServiceInfo != null) {
            SourceLog.w(TAG, "callbackIMFirst " + lelinkServiceInfo);
            try {
                if (lelinkServiceInfo.getBrowserInfos().size() > 1 && lelinkServiceInfo.getBrowserInfos().containsKey(4)) {
                    lelinkServiceInfo.getBrowserInfos().remove(1);
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
            if (CastUtil.isSupportIM(lelinkServiceInfo)) {
                BrowserInfo browserInfo = CastUtil.getBrowserInfo(lelinkServiceInfo, 4);
                if (browserInfo != null) {
                    browserInfo.setOnLine(true);
                }
                notifyParseResult(1, lelinkServiceInfo);
            }
        }
    }

    private void delayCallbackIM(LelinkServiceInfo lelinkServiceInfo) {
        if (!Feature.isDisableIM()) {
            this.mHandler.removeMessages(1);
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(1, lelinkServiceInfo), 500);
        }
    }

    /* access modifiers changed from: private */
    public void notifyParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
        this.mHandler.removeMessages(1);
        IServiceInfoParseListener iServiceInfoParseListener = this.mServiceInfoParseListener;
        if (iServiceInfoParseListener != null) {
            iServiceInfoParseListener.onParseResult(i10, lelinkServiceInfo);
        }
    }

    private void requestLelinkTxtInfo(String str, final String str2, final String str3, final LelinkServiceInfo lelinkServiceInfo) {
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.getHttpServerUrl(str, str2), (String) null);
        asyncHttpParameter.in.readTimeout = (int) TimeUnit.SECONDS.toMillis(5);
        asyncHttpParameter.in.tryCount = 1;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() {
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                String str;
                AsyncHttpParameter.Out out = asyncHttpParameter.out;
                int i10 = out.resultType;
                if (i10 == 2) {
                    SourceLog.i(DevicePinParser.TAG, "requestLelinkTxtInfo: cancel");
                } else if (i10 == 0) {
                    String str2 = out.result;
                    BrowserInfo browserInfo = lelinkServiceInfo.getBrowserInfos().get(1);
                    if (browserInfo == null) {
                        browserInfo = lelinkServiceInfo.getBrowserInfos().get(4);
                    }
                    String uid = browserInfo.getUid();
                    String name = lelinkServiceInfo.getName();
                    String ip = browserInfo.getIp();
                    String str3 = str2;
                    if (TextUtils.isEmpty(str3)) {
                        str = "tv";
                    } else {
                        str = str3;
                    }
                    LelinkServiceInfo lelinkTxtInfo = LelinkServiceInfoCreator.getLelinkTxtInfo(uid, name, ip, str3, str, str2, 9);
                    if (lelinkTxtInfo != null) {
                        DevicePinParser.this.notifyParseResult(1, lelinkTxtInfo);
                    } else if (Feature.isDisableIM()) {
                        SourceLog.i(DevicePinParser.TAG, "resolveLelinkTxtInfo: failed ");
                        DevicePinParser.this.notifyParseResult(5, (LelinkServiceInfo) null);
                    } else {
                        DevicePinParser.this.notifyParseResult(1, lelinkServiceInfo);
                    }
                } else if (Feature.isDisableIM()) {
                    SourceLog.i(DevicePinParser.TAG, "requestLelinkTxtInfo: failed ");
                    DevicePinParser.this.notifyParseResult(5, (LelinkServiceInfo) null);
                } else {
                    try {
                        if (lelinkServiceInfo.getBrowserInfos().size() > 1 && lelinkServiceInfo.getBrowserInfos().containsKey(4)) {
                            lelinkServiceInfo.getBrowserInfos().remove(1);
                        }
                    } catch (Exception e10) {
                        SourceLog.w(DevicePinParser.TAG, (Throwable) e10);
                    }
                    BrowserInfo browserInfo2 = CastUtil.getBrowserInfo(lelinkServiceInfo, 4);
                    if (browserInfo2 != null) {
                        browserInfo2.setOnLine(true);
                    }
                    SourceLog.i(DevicePinParser.TAG, "requestLelinkTxtInfo: failed " + lelinkServiceInfo);
                }
            }
        });
    }

    public void parse(String str, final int i10) {
        if (TextUtils.isEmpty(str)) {
            SourceLog.i(TAG, "parse: deviceCode is empty");
            notifyParseResult(0, (LelinkServiceInfo) null);
            return;
        }
        SourceDataReport.getInstance().onPinCodeStart(CreateUtil.createSessionId());
        SourceLog.i(TAG, "parse: deviceCode: " + str);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(str);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sREAL_TIME_SERVICE_INFO_QUERY_RUL, (String) null);
        asyncHttpParameter.in.params = jSONArray.toString();
        asyncHttpParameter.in.requestMethod = 1;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() {
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                if (asyncHttpParameter.out.resultType == 2) {
                    SourceLog.i(DevicePinParser.TAG, "onRequestResult: request cancel");
                } else if (DevicePinParser.this.mServiceInfoParseListener == null || TextUtils.isEmpty(asyncHttpParameter.out.result)) {
                    DevicePinParser.this.notifyParseResult(5, (LelinkServiceInfo) null);
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(asyncHttpParameter.out.result);
                        int optInt = jSONObject.optInt(Constants.KEY_HTTP_CODE);
                        if (optInt == 200) {
                            JSONArray optJSONArray = jSONObject.optJSONArray("data");
                            if (optJSONArray != null) {
                                if (optJSONArray.length() > 0) {
                                    DevicePinParser.this.parseServiceInfo(new JSONObject(optJSONArray.optJSONObject(0).optString("serviceBody")).toString(), i10);
                                    return;
                                }
                            }
                            DevicePinParser.this.notifyParseResult(5, (LelinkServiceInfo) null);
                        } else if (optInt == 211) {
                            DevicePinParser.this.notifyParseResult(8, (LelinkServiceInfo) null);
                        } else if (optInt == 221) {
                            DevicePinParser.this.notifyParseResult(7, (LelinkServiceInfo) null);
                        } else {
                            DevicePinParser.this.notifyParseResult(5, (LelinkServiceInfo) null);
                        }
                    } catch (Exception e10) {
                        SourceLog.w(DevicePinParser.TAG, (Throwable) e10);
                        DevicePinParser.this.notifyParseResult(5, (LelinkServiceInfo) null);
                    }
                }
            }
        });
    }

    public LelinkServiceInfo parseServiceInfo(String str, int i10) {
        if (this.mServiceInfoParseListener == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            LelinkServiceInfo createByServiceTxtInfo = LelinkServiceInfoCreator.createByServiceTxtInfo(jSONObject, i10);
            if (TextUtils.isEmpty(jSONObject.optString("ip"))) {
                createByServiceTxtInfo.getBrowserInfos().get(4).getExtras().put("phone", "1");
                notifyParseResult(1, createByServiceTxtInfo);
                SourceLog.i(TAG, "onParseResult name:" + createByServiceTxtInfo.getName());
                return createByServiceTxtInfo;
            }
            SourceLog.i(TAG, "parseServiceInfo ");
            delayCallbackIM(LelinkServiceInfoCreator.createByServiceTxtInfo(jSONObject, i10));
            requestLelinkTxtInfo(jSONObject.optString("ip"), jSONObject.optString("remote_port"), jSONObject.optString("pt"), createByServiceTxtInfo);
            return createByServiceTxtInfo;
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return null;
        }
    }

    public void setParseResultListener(IServiceInfoParseListener iServiceInfoParseListener) {
        this.mServiceInfoParseListener = iServiceInfoParseListener;
    }
}
