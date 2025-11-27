package com.hpplay.sdk.source.business.cloud;

import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.cybergarage.upnp.UPnPStatus;
import com.hpplay.sdk.source.api.DeviceListenerConstant;
import com.hpplay.sdk.source.browse.api.IBrowseListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.CastUtil;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public class DeviceManager {
    private static final String TAG = "DeviceManager";
    private AtomicInteger parsedCount = new AtomicInteger(0);

    /* access modifiers changed from: private */
    public void callbackParse(IBrowseListener iBrowseListener, List<LelinkServiceInfo> list) {
        this.parsedCount.decrementAndGet();
        SourceLog.i(TAG, "callbackParse : " + this.parsedCount.get());
        if (this.parsedCount.get() <= 0 && iBrowseListener != null) {
            iBrowseListener.onBrowse(1, new ArrayList(list));
        }
    }

    private void callbackParseError(IBrowseListener iBrowseListener) {
        if (iBrowseListener != null) {
            iBrowseListener.onBrowse(-1, (List<LelinkServiceInfo>) null);
        }
    }

    private int transformErrorCode(int i10) {
        if (i10 == 200) {
            return 200;
        }
        if (i10 == 500) {
            return -205;
        }
        switch (i10) {
            case 400:
                return -200;
            case 401:
                return -201;
            case 402:
                return -202;
            case UPnPStatus.OUT_OF_SYNC:
                return -203;
            case 404:
                return -204;
            default:
                switch (i10) {
                    case 1000:
                        return -206;
                    case 1001:
                        return DeviceListenerConstant.ERROR_SERVICE_GET_MESSAGE_FAIL;
                    case 1002:
                        return DeviceListenerConstant.ERROR_NOT_SUPPORT_REQUEST_METHOD;
                    case Constant.STOP_FROM_SINK /*1003*/:
                        return DeviceListenerConstant.ERROR_NOT_SUPPORT_MIME_TYPE;
                    case Constant.STOP_FROM_DISCONNECT /*1004*/:
                        return DeviceListenerConstant.ERROR_LACK_OF_PARAMS;
                    case Constant.STOP_USER_DISCONNECT /*1005*/:
                        return DeviceListenerConstant.ERROR_PARAMS_WRONG_TYPE;
                    case 1006:
                        return DeviceListenerConstant.ERROR_PARAMS_BIND_FAIL;
                    case 1007:
                        return DeviceListenerConstant.ERROR_PARAMS_PARSE_FAIL;
                    case 1008:
                        return DeviceListenerConstant.ERROR_ALIAS_EXIST;
                    case 1009:
                        return DeviceListenerConstant.ERROR_ALIAS_LENGTH_OVER_LIMIT;
                    case 1010:
                        return DeviceListenerConstant.ERROR_SENSITIVE_ALIAS;
                    case 1011:
                        return DeviceListenerConstant.ERROR_DEVICE_NOT_EXIST;
                    case 1012:
                        return DeviceListenerConstant.ERROR_FAVORITE_OVER_LIMIT;
                    case 1013:
                        return DeviceListenerConstant.ERROR_FAVORITE_INFO_NOT_EXIST;
                    case 1014:
                        return DeviceListenerConstant.ERROR_FAVORITE_DEVICE_EXIST;
                    case 1015:
                        return DeviceListenerConstant.ERROR_HISTORY_DEVICE_NOT_EXIST;
                    case 1016:
                        return DeviceListenerConstant.ERROR_FAVORITE_DEVICE_NOT_EXIST;
                    default:
                        return i10;
                }
        }
    }

    public boolean emptySourceID() {
        return TextUtils.isEmpty(Session.getInstance().getSourceID());
    }

    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        Session instance = Session.getInstance();
        hashMap.put(DispatchConstants.CONFIG_VERSION, "41214");
        hashMap.put("app-id", instance.appKey);
        hashMap.put(ParamsMap.DeviceParams.KEY_UID, instance.getUID());
        String token = instance.getToken();
        if (!TextUtils.isEmpty(token)) {
            hashMap.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, token);
        }
        SourceLog.i(TAG, "getHeaders：" + hashMap);
        return hashMap;
    }

    public boolean isResultInvalid(AsyncHttpParameter asyncHttpParameter) {
        AsyncHttpParameter.Out out;
        if (asyncHttpParameter == null || (out = asyncHttpParameter.out) == null) {
            SourceLog.i(TAG, "isResultInvalid, result is null");
            return true;
        } else if (out.resultType == 0) {
            return false;
        } else {
            SourceLog.i(TAG, "isResultInvalid result ignore, " + asyncHttpParameter.out.resultType);
            return true;
        }
    }

    public int parseCode(String str) {
        if (TextUtils.isEmpty(str)) {
            SourceLog.w(TAG, "parseCode,json is null");
            return -105;
        }
        try {
            return transformErrorCode(new JSONObject(str).optInt(Constants.KEY_HTTP_CODE, -105));
        } catch (Exception e10) {
            SourceLog.w(TAG, "parseCode,error :" + e10);
            return -105;
        }
    }

    public void parseDevice(final int i10, String str, final IBrowseListener iBrowseListener) {
        if (TextUtils.isEmpty(str)) {
            SourceLog.w(TAG, "parseDevice,json is null");
            callbackParseError(iBrowseListener);
            return;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("data");
            if (optJSONArray == null) {
                SourceLog.w(TAG, "parseDevice,data is null");
                callbackParseError(iBrowseListener);
                return;
            }
            this.parsedCount.set(optJSONArray.length());
            final ArrayList arrayList = new ArrayList();
            if (optJSONArray.length() == 0) {
                callbackParse(iBrowseListener, arrayList);
                return;
            }
            for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i11);
                if (optJSONObject == null) {
                    callbackParse(iBrowseListener, arrayList);
                } else {
                    ConnectRelationManager connectRelationManager = new ConnectRelationManager();
                    connectRelationManager.setParseResultListener(new IServiceInfoParseListener() {
                        public void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
                            SourceLog.w(DeviceManager.TAG, "onParseResult, resultCode: " + i10 + " / " + i10 + " / " + lelinkServiceInfo);
                            if (lelinkServiceInfo != null && i10 == 1) {
                                if (i10 == 3 && !CastUtil.isSupportLelink(lelinkServiceInfo)) {
                                    SourceLog.w(DeviceManager.TAG, "onParseResult, ignore im only");
                                    DeviceManager.this.callbackParse(iBrowseListener, arrayList);
                                    return;
                                } else if (!arrayList.contains(lelinkServiceInfo)) {
                                    arrayList.add(lelinkServiceInfo);
                                } else {
                                    int i11 = 0;
                                    while (true) {
                                        if (i11 >= arrayList.size()) {
                                            break;
                                        } else if (lelinkServiceInfo.getUid().equals(((LelinkServiceInfo) arrayList.get(i11)).getUid())) {
                                            SourceLog.w(DeviceManager.TAG, "onParseResult, remove repeat: " + i11);
                                            arrayList.remove(lelinkServiceInfo);
                                            arrayList.add(i11, lelinkServiceInfo);
                                            break;
                                        } else {
                                            i11++;
                                        }
                                    }
                                }
                            }
                            DeviceManager.this.callbackParse(iBrowseListener, arrayList);
                        }
                    });
                    connectRelationManager.parseServiceInfo(optJSONObject, 11);
                }
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            callbackParseError(iBrowseListener);
        }
    }
}
