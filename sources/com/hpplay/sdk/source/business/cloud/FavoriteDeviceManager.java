package com.hpplay.sdk.source.business.cloud;

import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.api.DeviceListenerConstant;
import com.hpplay.sdk.source.api.IFavoriteDeviceListener;
import com.hpplay.sdk.source.browse.api.IBrowseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.PassSender;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.protocol.connect.ConnectBridge;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class FavoriteDeviceManager extends DeviceManager {
    private static final String TAG = "FavoriteDeviceManager";
    private static FavoriteDeviceManager sInstance;
    public IFavoriteDeviceListener mFavoriteDeviceListener;

    private FavoriteDeviceManager() {
    }

    public static synchronized FavoriteDeviceManager getInstance() {
        FavoriteDeviceManager favoriteDeviceManager;
        synchronized (FavoriteDeviceManager.class) {
            if (sInstance == null) {
                sInstance = new FavoriteDeviceManager();
            }
            favoriteDeviceManager = sInstance;
        }
        return favoriteDeviceManager;
    }

    private boolean isFunctionDisable() {
        return !SDKConfig.getInstance().getFavoriteDevSwitch();
    }

    /* access modifiers changed from: private */
    public void onGetDeviceCallback(boolean z10, int i10, List<LelinkServiceInfo> list) {
        IFavoriteDeviceListener iFavoriteDeviceListener = this.mFavoriteDeviceListener;
        if (iFavoriteDeviceListener != null) {
            if (z10) {
                iFavoriteDeviceListener.onGetDeviceList(1, 200, list);
            } else {
                iFavoriteDeviceListener.onGetDeviceList(2, i10, (List<LelinkServiceInfo>) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public void onRemoveCallback(boolean z10, int i10) {
        IFavoriteDeviceListener iFavoriteDeviceListener = this.mFavoriteDeviceListener;
        if (iFavoriteDeviceListener != null) {
            if (z10) {
                iFavoriteDeviceListener.onRemoveDevice(1, 200);
            } else {
                iFavoriteDeviceListener.onRemoveDevice(2, i10);
            }
        }
    }

    /* access modifiers changed from: private */
    public void onSetDeviceAliasCallback(boolean z10, int i10) {
        IFavoriteDeviceListener iFavoriteDeviceListener = this.mFavoriteDeviceListener;
        if (iFavoriteDeviceListener != null) {
            if (z10) {
                iFavoriteDeviceListener.onSetDeviceAlias(1, 200);
            } else {
                iFavoriteDeviceListener.onSetDeviceAlias(2, i10);
            }
        }
    }

    public void addFavoriteDevice(LelinkServiceInfo lelinkServiceInfo) {
        int i10;
        if (isFunctionDisable()) {
            onAddCallback(false, DeviceListenerConstant.ERROR_FUNCTION_DISABLE);
        } else if (emptySourceID()) {
            onAddCallback(false, -100);
        } else if (lelinkServiceInfo == null) {
            onAddCallback(false, -101);
        } else if (TextUtils.isEmpty(lelinkServiceInfo.getUid())) {
            onAddCallback(false, -103);
        } else if (lelinkServiceInfo.getAppId() == 0) {
            onAddCallback(false, -102);
        } else {
            LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
            if (lastServiceInfo == null || !lelinkServiceInfo.getUid().equals(lastServiceInfo.getUid()) || lelinkServiceInfo.getAppId() != lastServiceInfo.getAppId()) {
                onAddCallback(false, DeviceListenerConstant.ERROR_ADD_FAVORITE_WITHOUT_CONNECT);
                return;
            }
            ConnectBridge connectBridge = ConnectManager.getInstance().getConnectBridge(lelinkServiceInfo.getUid());
            if (connectBridge == null) {
                onAddCallback(false, DeviceListenerConstant.ERROR_ADD_FAVORITE_WITHOUT_CONNECT);
                return;
            }
            String connectBean = connectBridge.getConnectBean();
            if (connectBean == null) {
                onAddCallback(false, DeviceListenerConstant.ERROR_ADD_FAVORITE_WITHOUT_CONNECT);
            } else if (!connectBridge.isSupportPassMsg(52)) {
                addFavoriteDeviceAfterConfirm(lelinkServiceInfo);
            } else {
                try {
                    i10 = new JSONObject(connectBean).optInt("favoriteDev", 1);
                } catch (Exception e10) {
                    SourceLog.w(TAG, "addFavoriteDevice " + e10.getMessage());
                    i10 = 1;
                }
                SourceLog.i(TAG, "addFavoriteDevice, favoriteDev: " + i10);
                if (i10 != 1) {
                    onAddCallback(false, -110);
                } else {
                    PassSender.getInstance().sendFavoriteConfirm(lelinkServiceInfo);
                }
            }
        }
    }

    public void addFavoriteDeviceAfterConfirm(LelinkServiceInfo lelinkServiceInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", Session.getInstance().getSourceID());
            jSONObject.put("appId", String.valueOf(lelinkServiceInfo.getAppId()));
            jSONObject.put(ParamsMap.DeviceParams.KEY_UID, lelinkServiceInfo.getUid());
        } catch (Exception e10) {
            SourceLog.i(TAG, e10.toString());
        }
        String jSONObject2 = jSONObject.toString();
        SourceLog.i(TAG, "addFavoriteDeviceAfterConfirm " + CloudAPI.sAddFavoriteDevice + Operator.Operation.EMPTY_PARAM + jSONObject2);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sAddFavoriteDevice, jSONObject2);
        asyncHttpParameter.in.requestHeaders = getHeaders();
        asyncHttpParameter.in.requestMethod = 1;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() {
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                boolean z10 = false;
                if (FavoriteDeviceManager.this.isResultInvalid(asyncHttpParameter)) {
                    FavoriteDeviceManager.this.onAddCallback(false, DeviceListenerConstant.ERROR_NULL_RESPONSE);
                    return;
                }
                SourceLog.i(FavoriteDeviceManager.TAG, "addFavoriteDevice result: " + asyncHttpParameter.out.result);
                int parseCode = FavoriteDeviceManager.this.parseCode(asyncHttpParameter.out.result);
                FavoriteDeviceManager favoriteDeviceManager = FavoriteDeviceManager.this;
                if (parseCode == 200) {
                    z10 = true;
                }
                favoriteDeviceManager.onAddCallback(z10, parseCode);
            }
        });
    }

    public void getFavoriteDeviceList(int i10, final int i11) {
        if (isFunctionDisable()) {
            onGetDeviceCallback(false, DeviceListenerConstant.ERROR_FUNCTION_DISABLE, (List<LelinkServiceInfo>) null);
        } else if (emptySourceID()) {
            onGetDeviceCallback(false, -100, (List<LelinkServiceInfo>) null);
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("id", Session.getInstance().getSourceID());
            if (i10 == 1) {
                hashMap.put("online", "1");
            } else if (i10 == 2) {
                hashMap.put("online", "0");
            }
            String mapParams = HapplayUtils.getMapParams(hashMap);
            SourceLog.i(TAG, "getFavoriteDeviceList " + CloudAPI.sGetFavoriteDevice + Operator.Operation.EMPTY_PARAM + mapParams);
            AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sGetFavoriteDevice, mapParams);
            asyncHttpParameter.in.requestHeaders = getHeaders();
            asyncHttpParameter.in.requestMethod = 0;
            AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() {
                public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                    if (FavoriteDeviceManager.this.isResultInvalid(asyncHttpParameter)) {
                        FavoriteDeviceManager.this.onGetDeviceCallback(false, DeviceListenerConstant.ERROR_NULL_RESPONSE, (List<LelinkServiceInfo>) null);
                        return;
                    }
                    SourceLog.i(FavoriteDeviceManager.TAG, "getFavoriteDeviceList result: " + asyncHttpParameter.out.result);
                    int parseCode = FavoriteDeviceManager.this.parseCode(asyncHttpParameter.out.result);
                    if (parseCode != 200) {
                        FavoriteDeviceManager.this.onGetDeviceCallback(false, parseCode, (List<LelinkServiceInfo>) null);
                    } else {
                        FavoriteDeviceManager.this.parseDevice(i11, asyncHttpParameter.out.result, new IBrowseListener() {
                            public void onBrowse(int i10, List<LelinkServiceInfo> list) {
                                if (i10 == 1) {
                                    FavoriteDeviceManager.this.onGetDeviceCallback(true, 200, list);
                                } else {
                                    FavoriteDeviceManager.this.onGetDeviceCallback(false, DeviceListenerConstant.ERROR_PARSE_ERROR, (List<LelinkServiceInfo>) null);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void onAddCallback(boolean z10, int i10) {
        IFavoriteDeviceListener iFavoriteDeviceListener = this.mFavoriteDeviceListener;
        if (iFavoriteDeviceListener != null) {
            if (z10) {
                iFavoriteDeviceListener.onAddDevice(1, 200);
            } else {
                iFavoriteDeviceListener.onAddDevice(2, i10);
            }
        }
    }

    public void removeFavoriteDevice(List<LelinkServiceInfo> list) {
        if (isFunctionDisable()) {
            onRemoveCallback(false, DeviceListenerConstant.ERROR_FUNCTION_DISABLE);
        } else if (emptySourceID()) {
            onRemoveCallback(false, -100);
        } else if (list == null || list.isEmpty()) {
            onRemoveCallback(false, -101);
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", Session.getInstance().getSourceID());
                JSONArray jSONArray = new JSONArray();
                for (LelinkServiceInfo next : list) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("appId", String.valueOf(next.getAppId()));
                    jSONObject2.put(ParamsMap.DeviceParams.KEY_UID, next.getUid());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("devices", jSONArray);
            } catch (Exception e10) {
                SourceLog.i(TAG, e10.toString());
            }
            String jSONObject3 = jSONObject.toString();
            SourceLog.i(TAG, "removeFavoriteDevice " + CloudAPI.sRemoveFavoriteDevice + Operator.Operation.EMPTY_PARAM + jSONObject3);
            AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sRemoveFavoriteDevice, jSONObject3);
            asyncHttpParameter.in.requestHeaders = getHeaders();
            asyncHttpParameter.in.requestMethod = 1;
            AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() {
                public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                    boolean z10 = false;
                    if (FavoriteDeviceManager.this.isResultInvalid(asyncHttpParameter)) {
                        FavoriteDeviceManager.this.onRemoveCallback(false, DeviceListenerConstant.ERROR_NULL_RESPONSE);
                        return;
                    }
                    SourceLog.i(FavoriteDeviceManager.TAG, "removeFavoriteDevice result: " + asyncHttpParameter.out.result);
                    int parseCode = FavoriteDeviceManager.this.parseCode(asyncHttpParameter.out.result);
                    FavoriteDeviceManager favoriteDeviceManager = FavoriteDeviceManager.this;
                    if (parseCode == 200) {
                        z10 = true;
                    }
                    favoriteDeviceManager.onRemoveCallback(z10, parseCode);
                }
            });
        }
    }

    public void setFavoriteDeviceAlias(LelinkServiceInfo lelinkServiceInfo, String str) {
        if (isFunctionDisable()) {
            onSetDeviceAliasCallback(false, DeviceListenerConstant.ERROR_FUNCTION_DISABLE);
        } else if (emptySourceID()) {
            onSetDeviceAliasCallback(false, -100);
        } else if (lelinkServiceInfo == null || str == null) {
            onSetDeviceAliasCallback(false, -101);
        } else if (str.length() > 10) {
            onSetDeviceAliasCallback(false, -108);
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                String trim = str.trim();
                SourceLog.i(TAG, "setFavoriteDeviceAlias devAlias:" + trim + " , length:" + trim.length());
                jSONObject.put("id", Session.getInstance().getSourceID());
                jSONObject.put("appId", String.valueOf(lelinkServiceInfo.getAppId()));
                jSONObject.put(ParamsMap.DeviceParams.KEY_UID, lelinkServiceInfo.getUid());
                if (TextUtils.isEmpty(trim)) {
                    jSONObject.put("name", "");
                } else {
                    jSONObject.put("name", trim);
                }
            } catch (Exception e10) {
                SourceLog.i(TAG, e10.toString());
            }
            String jSONObject2 = jSONObject.toString();
            SourceLog.i(TAG, "setFavoriteDeviceAlias " + CloudAPI.sSetFavoriteDeviceAlias + Operator.Operation.EMPTY_PARAM + jSONObject2);
            AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sSetFavoriteDeviceAlias, jSONObject2);
            asyncHttpParameter.in.requestHeaders = getHeaders();
            asyncHttpParameter.in.requestMethod = 1;
            AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() {
                public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                    boolean z10 = false;
                    if (FavoriteDeviceManager.this.isResultInvalid(asyncHttpParameter)) {
                        FavoriteDeviceManager.this.onSetDeviceAliasCallback(false, DeviceListenerConstant.ERROR_NULL_RESPONSE);
                        return;
                    }
                    SourceLog.i(FavoriteDeviceManager.TAG, "setFavoriteDeviceAlias result: " + asyncHttpParameter.out.result);
                    int parseCode = FavoriteDeviceManager.this.parseCode(asyncHttpParameter.out.result);
                    FavoriteDeviceManager favoriteDeviceManager = FavoriteDeviceManager.this;
                    if (parseCode == 200) {
                        z10 = true;
                    }
                    favoriteDeviceManager.onSetDeviceAliasCallback(z10, parseCode);
                }
            });
        }
    }

    public void setFavoriteDeviceListener(IFavoriteDeviceListener iFavoriteDeviceListener) {
        this.mFavoriteDeviceListener = iFavoriteDeviceListener;
    }
}
