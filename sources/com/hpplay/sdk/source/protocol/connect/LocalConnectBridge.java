package com.hpplay.sdk.source.protocol.connect;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.hpplay.a.a.a.d;
import com.hpplay.common.utils.DeviceUtil;
import com.hpplay.common.utils.FieldUtil;
import com.hpplay.common.utils.ScreenUtil;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.SourceModule;
import com.hpplay.component.common.protocol.IConnector;
import com.hpplay.component.common.utils.DeviceProperties;
import com.hpplay.component.common.utils.ModuleIds;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.sdk.source.api.IConnectListener;
import com.hpplay.sdk.source.bean.PassBean;
import com.hpplay.sdk.source.bean.PassCacheBean;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.business.BusinessEntity;
import com.hpplay.sdk.source.business.PlayController;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.localserver.LelinkServerInstance;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.Parser;
import com.hpplay.sdk.source.pass.PassSender;
import com.hpplay.sdk.source.pass.bean.DescribeBean;
import com.hpplay.sdk.source.protocol.LelinkProtocolListener;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.CreateUtil;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.BaseMonitor;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class LocalConnectBridge extends AbsConnectBridge {
    private static final int DELAY_PASS = 100;
    public static final String NEW_HAPPYCAST_AGENT = "HappyCast5,0/500.0";
    private static final String TAG = "LocalConnectBridge";
    private static final int WHAT_DELAY_PASS = 1;
    private static final int WHAT_SEND_PASS = 2;
    private boolean isCallConnect = false;
    private boolean isCallConnectFailed = false;
    private boolean isCallConnectSuccess = false;
    private boolean isCallDisconnect = false;
    private boolean isCallbackDisconnectSuccess = false;
    /* access modifiers changed from: private */
    public boolean isPassConnected = false;
    private boolean isRelease = false;
    private boolean isReportDisconnect = false;
    private boolean isSendPassReconnect = false;
    /* access modifiers changed from: private */
    public List<PassCacheBean> mCacheList = new LinkedList();
    private BrowserInfo mConnectBrowserInfo;
    private LelinkProtocolListener mConnectListener = new LelinkProtocolListener() {
        public void onResult(int i10, String... strArr) {
            SourceLog.i(LocalConnectBridge.TAG, "onResult " + i10);
            if (i10 == 11) {
                LocalConnectBridge.this.resolveConnectResult(i10, strArr);
            } else if (i10 == 18) {
                LocalConnectBridge.this.mHandler.removeMessages(1);
                LocalConnectBridge.this.mHandler.sendEmptyMessageDelayed(1, 100);
            } else if (i10 == 19) {
                if (strArr.length < 2) {
                    SourceLog.w(LocalConnectBridge.TAG, "CMD_PASSTH_RESULT ignore");
                    return;
                }
                Parser.getInstance().parseByLocalCast(DescribeBean.formJson(strArr[0]), strArr[1]);
            }
        }
    };
    private IConnector mConnector;
    private final Context mContext;
    private int mFeature;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                boolean unused = LocalConnectBridge.this.isPassConnected = true;
                PassSender.getInstance().sendConnectMsg(LocalConnectBridge.this.mServiceInfo);
                return false;
            } else if (i10 != 2) {
                return false;
            } else {
                try {
                    if (LocalConnectBridge.this.mCacheList.size() <= 0) {
                        return false;
                    }
                    Iterator it = LocalConnectBridge.this.mCacheList.iterator();
                    while (it.hasNext()) {
                        PassCacheBean passCacheBean = (PassCacheBean) it.next();
                        if (passCacheBean == null) {
                            it.remove();
                        } else {
                            it.remove();
                            LocalConnectBridge.this.sendPassData(passCacheBean);
                            return false;
                        }
                    }
                    return false;
                } catch (Exception e10) {
                    SourceLog.w(LocalConnectBridge.TAG, (Throwable) e10);
                    return false;
                }
            }
        }
    });
    private ModuleLinker mModuleLinker;
    /* access modifiers changed from: private */
    public LelinkServiceInfo mServiceInfo;

    public LocalConnectBridge(Context context) {
        this.mContext = context;
    }

    private void callbackDisconnectSuccess() {
        if (!this.isCallbackDisconnectSuccess) {
            setConnected(false);
            this.isPassConnected = false;
            this.isCallbackDisconnectSuccess = true;
            IConnectListener iConnectListener = this.mAppListener;
            if (iConnectListener == null) {
                SourceLog.w(TAG, "disconnect, invalid listener");
            } else {
                iConnectListener.onDisconnect(this.mServiceInfo, 212000, 212001);
            }
        }
    }

    /* access modifiers changed from: private */
    public void resolveConnectResult(int i10, String... strArr) {
        int i11;
        String str;
        SourceLog.i(TAG, "resolveConnectResult" + Arrays.toString(strArr));
        String str2 = strArr[0];
        if (SourceModule.RESULT_CONNECTION_DISCONNECT.equals(str2)) {
            callbackDisconnectSuccess();
        }
        if (this.isCallDisconnect) {
            SourceLog.i(TAG, "resolveConnectResult ignore," + str2);
            return;
        }
        if (strArr.length > 1) {
            int parseInt = Integer.parseInt(strArr[1]);
            if (1 != parseInt) {
                i11 = 3;
            } else if (CastUtil.isSupportLelinkV2(this.mConnectBrowserInfo)) {
                i11 = 5;
            } else {
                i11 = parseInt;
            }
        } else {
            i11 = 0;
        }
        SourceLog.i(TAG, "resolveConnectResult " + str2);
        if ("successful".equals(str2)) {
            try {
                this.mFeature = Integer.parseInt(strArr[2]);
            } catch (Exception e10) {
                SourceLog.i(TAG, "resolveConnectResult get feature error: " + e10.getMessage());
            }
            setConnected(true);
            SourceDataReport.getInstance().onLocalConnectSuccess(this.mConnectSession, i11, this.mServiceInfo);
            if (!LelinkServerInstance.getInstance().isAlive()) {
                LelinkServerInstance.getInstance().startServer();
            }
            this.isCallConnectSuccess = true;
            IConnectListener iConnectListener = this.mAppListener;
            if (iConnectListener == null) {
                SourceLog.w(TAG, "connect success, invalid listener");
            } else {
                iConnectListener.onConnect(this.mServiceInfo, i11);
            }
        } else if (!"failed".equals(str2)) {
        } else {
            if (retry()) {
                connect(this.mServiceInfo, this.mConnectBrowserInfo);
            } else if (this.isCallConnectFailed) {
                SourceLog.w(TAG, "ignore notify connect failed, is already called");
            } else {
                this.isCallConnectFailed = true;
                setConnected(false);
                this.isPassConnected = false;
                if (!this.isCallConnectSuccess) {
                    try {
                        str = strArr[2];
                    } catch (Exception e11) {
                        SourceLog.i(TAG, "resolveConnectResult get reportExtra error: " + e11.getMessage());
                        str = null;
                    }
                    SourceDataReport.getInstance().onLocalConnectFailed(this.mConnectSession, i11, this.mServiceInfo, "212010", str);
                } else {
                    SourceLog.w(TAG, "this connector already callback connect success");
                }
                IConnectListener iConnectListener2 = this.mAppListener;
                if (iConnectListener2 == null) {
                    SourceLog.w(TAG, "connect failed, invalid listener");
                } else {
                    iConnectListener2.onDisconnect(this.mServiceInfo, 212010, 212011);
                }
            }
        }
    }

    private boolean retry() {
        BrowserInfo browserInfo;
        BrowserInfo browserInfo2 = this.mConnectBrowserInfo;
        if (browserInfo2 == null || browserInfo2.getType() != 1 || (browserInfo = CastUtil.getBrowserInfo(this.mServiceInfo, 3)) == null) {
            return false;
        }
        this.mConnectBrowserInfo = browserInfo;
        SourceLog.i(TAG, "connect retry by dlna");
        return true;
    }

    public void checkPassConnect(PassCacheBean passCacheBean) {
        PlayController lastPlayController;
        if (!this.isSendPassReconnect && this.isPassConnected && this.mServiceInfo != null && this.mConnectBrowserInfo != null && (lastPlayController = BusinessEntity.getInstance().getLastPlayController()) != null && lastPlayController.isInPlaybackState()) {
            SourceLog.i(TAG, "checkPassConnect reconnect");
            this.isSendPassReconnect = true;
            connect(this.mServiceInfo, this.mConnectBrowserInfo);
            this.mCacheList.add(passCacheBean);
        }
    }

    public void connect(LelinkServiceInfo lelinkServiceInfo) {
        super.connect(lelinkServiceInfo);
        connect(lelinkServiceInfo, CastUtil.getPreConnectInfo(lelinkServiceInfo));
    }

    public void disconnect(int i10) {
        int i11;
        IConnector iConnector;
        super.disconnect(i10);
        if (!this.isCallDisconnect) {
            this.isPassConnected = false;
            this.isCallDisconnect = true;
            this.isSendPassReconnect = false;
            if (this.mServiceInfo != null) {
                SourceLog.i(TAG, "disconnect " + this.mServiceInfo.getIp() + Operator.Operation.DIVISION + this.mServiceInfo.getName() + " by " + i10);
            } else {
                SourceLog.i(TAG, "disconnect by " + i10);
            }
            try {
                if (this.isCallConnect && (iConnector = this.mConnector) != null) {
                    iConnector.disConnect();
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
            setConnected(false);
            this.mCacheList.clear();
            BrowserInfo browserInfo = this.mConnectBrowserInfo;
            if (browserInfo != null) {
                i11 = browserInfo.getType();
                if (CastUtil.isSupportLelinkV2(this.mConnectBrowserInfo)) {
                    i11 = 5;
                }
            } else {
                i11 = 0;
            }
            this.isCallConnect = false;
            if (i10 != 2) {
                callbackDisconnectSuccess();
            }
            if (!this.isReportDisconnect) {
                this.isReportDisconnect = true;
                SourceDataReport.getInstance().onLocalDisconnect(this.mConnectSession, i11, this.mServiceInfo, i10);
            }
        }
    }

    public IConnector getConnector() {
        return this.mConnector;
    }

    public boolean isSupportTrack() {
        if ((this.mFeature & 4096) != 0) {
            return true;
        }
        return false;
    }

    public boolean isSupportUrlList() {
        if ((this.mFeature & 2048) != 0) {
            return true;
        }
        return false;
    }

    public void release() {
        SourceLog.i(TAG, "release");
        if (!this.isRelease) {
            this.isRelease = true;
            disconnect(100);
            ModuleLinker moduleLinker = this.mModuleLinker;
            if (moduleLinker != null) {
                moduleLinker.removeObjOfMemory(ModuleIds.CLAZZ_ID1068_MIRRORCONTROLLERIMP);
                this.mModuleLinker = null;
            }
            this.mConnectListener = null;
        }
    }

    public synchronized void sendPassData(int i10, String str, String str2) {
        if (i10 == 4) {
            this.mCacheList.add(0, new PassCacheBean(i10, str, str2));
        } else {
            this.mCacheList.add(new PassCacheBean(i10, str, str2));
        }
        if (this.isPassConnected) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeMessages(2);
                this.mHandler.sendEmptyMessage(2);
            }
        } else {
            SourceLog.w(TAG, "sendPassData wait connect " + i10);
        }
    }

    public void setConnectListener(IConnectListener iConnectListener) {
        this.mAppListener = iConnectListener;
    }

    public void connect(LelinkServiceInfo lelinkServiceInfo, BrowserInfo browserInfo) {
        int[] iArr;
        String str;
        if (this.isCallConnect) {
            disconnect(2);
        }
        this.mServiceInfo = lelinkServiceInfo;
        this.mConnectBrowserInfo = browserInfo;
        this.mConnectSession = CreateUtil.createSessionId();
        this.isCallConnect = true;
        this.isCallDisconnect = false;
        this.isCallbackDisconnectSuccess = false;
        this.isReportDisconnect = false;
        this.isCallConnectSuccess = false;
        this.isCallConnectFailed = false;
        this.mConnectBrowserInfo = browserInfo;
        SourceLog.i(TAG, BaseMonitor.ALARM_POINT_CONNECT);
        if (browserInfo == null) {
            SourceLog.w(TAG, "connect ignore, has no used browser info");
            return;
        }
        SourceLog.i(TAG, "connect " + lelinkServiceInfo.getIp() + Operator.Operation.DIVISION + browserInfo.getExtras().get("lelinkport") + Operator.Operation.DIVISION + lelinkServiceInfo.getName());
        ParamsMap create = ParamsMap.create();
        create.putParam(ParamsMap.DeviceParams.KEY_UID, browserInfo.getUid());
        create.putParam("ip", browserInfo.getIp());
        create.putParam(ParamsMap.DeviceParams.KEY_SINK_NAME, this.mConnectBrowserInfo.getName());
        int type = browserInfo.getType();
        if (type == 1) {
            iArr = new int[]{1};
            create.putParam(ParamsMap.ConnectParams.KEY_KEEP_ALIVE_TIMEOUT, 800);
            create.putParam(ParamsMap.ConnectParams.KEY_KEEP_ALIVE_INTERVAL, 2000);
            create.putParam("connect_timeout", Integer.valueOf(d.SOCKET_READ_TIMEOUT));
            if (CastUtil.isSupportLelinkV2(browserInfo)) {
                create.putParam("port", browserInfo.getExtras().get("lelinkport"));
                create.putParam(ParamsMap.DeviceParams.KEY_LELINK_PORT, browserInfo.getExtras().get("lelinkport"));
                create.putParam("vv", "2");
                SourceDataReport.getInstance().onLocalConnect(this.mConnectSession, 5, this.mServiceInfo);
            } else {
                if (TextUtils.isEmpty(browserInfo.getExtras().get("airplay"))) {
                    create.putParam("port", browserInfo.getExtras().get("lelinkport"));
                } else {
                    create.putParam("port", browserInfo.getExtras().get("airplay"));
                }
                SourceDataReport.getInstance().onLocalConnect(this.mConnectSession, 1, this.mServiceInfo);
            }
        } else if (type != 3) {
            SourceLog.w(TAG, "connect ignore," + browserInfo.getType());
            return;
        } else {
            create.putParam("port", Integer.valueOf(browserInfo.getPort()));
            iArr = new int[]{3};
            try {
                create.putParam(ParamsMap.PushParams.KEY_LOCATION_URI, browserInfo.getExtras().get(BrowserInfo.KEY_DLNA_LOCATION));
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
            SourceDataReport.getInstance().onLocalConnect(this.mConnectSession, 3, this.mServiceInfo);
        }
        create.putParam(ParamsMap.ConnectParams.KEY_CONNECT_SUPPORT, iArr);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lelinkVer", "HappyCast5,0/500.0");
            jSONObject.put("sdkVer", "4.12.14");
            try {
                String str2 = Preference.getInstance().get(Constant.KEY_USERNAME);
                if (TextUtils.isEmpty(str2)) {
                    str = URLEncoder.encode(DeviceUtil.getBluetoothName());
                } else {
                    str = URLEncoder.encode(str2);
                }
                jSONObject.put("name", str);
            } catch (Exception e11) {
                SourceLog.w(TAG, (Throwable) e11);
            }
            jSONObject.put("cu", Session.getInstance().getUID());
            jSONObject.put(ParamsMap.DeviceParams.KEY_HID, Session.getInstance().getHID());
            jSONObject.put("appID", Session.getInstance().appKey);
            int[] relScreenSize = ScreenUtil.getRelScreenSize(this.mContext);
            jSONObject.put("sWidth", relScreenSize[0]);
            jSONObject.put("sHeight", relScreenSize[1]);
            try {
                jSONObject.put("appVer", HapplayUtils.getAppVersion(this.mContext));
                jSONObject.put("uuid", "");
                String string = FieldUtil.getString(FieldUtil.f10533m);
                Session.getInstance();
                jSONObject.put(string, Session.DEFAULT_M);
            } catch (Exception e12) {
                SourceLog.w(TAG, (Throwable) e12);
            }
            jSONObject.put("OSVer", Build.VERSION.SDK_INT);
            jSONObject.put(Constants.KEY_MODEL, DeviceProperties.getManufacturer() + " " + DeviceProperties.getModel());
            jSONObject.put(DispatchConstants.PLATFORM, "100");
            jSONObject.put("vuuid", Preference.getInstance().get(Constant.KEY_VUUID));
            jSONObject.put("vsession", Preference.getInstance().get(Constant.KEY_VSESSION));
            jSONObject.put("tid", Session.getInstance().tid);
            jSONObject.put("s_oaid", DeviceUtil.getOAID(this.mContext));
        } catch (Exception e13) {
            SourceLog.w(TAG, (Throwable) e13);
        }
        create.putParam(ParamsMap.ConnectParams.KEY_CONNECT_JSON, jSONObject);
        try {
            ModuleLinker newInstance = ModuleLinker.getNewInstance();
            this.mModuleLinker = newInstance;
            IConnector iConnector = (IConnector) newInstance.loadModule(ModuleIds.CLAZZ_ID1193_CONNECTORIMP);
            this.mConnector = iConnector;
            iConnector.connect(create, this.mConnectListener);
        } catch (Exception e14) {
            SourceLog.w(TAG, (Throwable) e14);
        }
    }

    /* access modifiers changed from: private */
    public void sendPassData(final PassCacheBean passCacheBean) {
        if (passCacheBean == null) {
            SourceLog.w(TAG, "sendPassData ignore");
            return;
        }
        SourceLog.i(TAG, "sendPassData " + passCacheBean.type);
        this.mConnector.sendPassthroughData(passCacheBean.type, passCacheBean.header, passCacheBean.body, new LelinkProtocolListener() {
            public void onResult(int i10, String... strArr) {
                if (LocalConnectBridge.this.mHandler != null) {
                    LocalConnectBridge.this.mHandler.removeMessages(2);
                    LocalConnectBridge.this.mHandler.sendEmptyMessage(2);
                }
                if (strArr != null && strArr.length > 0) {
                    PassBean passBean = new PassBean();
                    passBean.cmd = i10;
                    passBean.action = 1;
                    try {
                        JSONObject jSONObject = new JSONObject(passCacheBean.body);
                        if (jSONObject.has("regist")) {
                            passBean.action = jSONObject.getInt("regist");
                        }
                    } catch (Exception unused) {
                        SourceLog.w(LocalConnectBridge.TAG, "get regist error");
                    }
                    if ("successful".equals(strArr[0])) {
                        passBean.result = 1;
                        SourceLog.i(LocalConnectBridge.TAG, "option: " + i10 + " 透传数据发送成功 ");
                    } else {
                        passBean.result = 0;
                        SourceLog.i(LocalConnectBridge.TAG, "option: " + i10 + " 透传数据发送失败 ");
                        LocalConnectBridge.this.checkPassConnect(passCacheBean);
                    }
                    LocalConnectBridge.this.callbackPass(passBean);
                }
            }
        });
    }
}
