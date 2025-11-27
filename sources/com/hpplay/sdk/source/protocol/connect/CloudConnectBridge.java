package com.hpplay.sdk.source.protocol.connect;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.hpplay.common.utils.DeviceUtil;
import com.hpplay.sdk.source.api.IConnectListener;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.bean.PassBean;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.business.BusinessEntity;
import com.hpplay.sdk.source.business.PlayController;
import com.hpplay.sdk.source.business.PublicCastClient;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.business.cloud.RightsManager;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.c.a;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.Pass;
import com.hpplay.sdk.source.player.GroupPlayer;
import com.hpplay.sdk.source.process.LelinkSdkManager;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.CreateUtil;
import com.taobao.accs.utl.BaseMonitor;
import java.net.URLEncoder;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public class CloudConnectBridge extends AbsConnectBridge {
    public static final int CONNECT_ALLOW = 2;
    public static final int CONNECT_DEFAULT = 0;
    public static final int CONNECT_DETAIL_IN_LIST = 3;
    public static final int CONNECT_DETAIL_MANUAL = 2;
    public static final int CONNECT_DETAIL_TIMEOUT = 1;
    public static final int CONNECT_REJECT = 3;
    public static final int CONNECT_WAITING = 1;
    private static final int DELAY_CONNECT_TIME = 30000;
    /* access modifiers changed from: private */
    public static String TAG = "CloudConnectBridge";
    private static final int WHAT_CONNECT_TIMEOUT_CHECK = 1;
    private static final int WHAT_IM_CONNECT_TIME_OUT = 100;
    private boolean isCallDisconnect = false;
    private boolean isCallbackDisconnectSuccess = false;
    /* access modifiers changed from: private */
    public boolean isNeedConnectSink = true;
    private boolean isRelease = false;
    private boolean isReportDisconnect = false;
    private Context mContext;
    private String mFeature;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                SourceLog.w(CloudConnectBridge.TAG, "WHAT_CONNECT_TIMEOUT_CHECK");
                if (CloudConnectBridge.this.mSinkConnectListener == null) {
                    return false;
                }
                CloudConnectBridge.this.mSinkConnectListener.onDisconnect(212014);
                return false;
            } else if (i10 != 100) {
                return false;
            } else {
                CloudConnectBridge cloudConnectBridge = CloudConnectBridge.this;
                IConnectListener iConnectListener = cloudConnectBridge.mAppListener;
                if (iConnectListener != null) {
                    iConnectListener.onDisconnect(cloudConnectBridge.mServiceInfo, 212000, 212010);
                }
                SourceLog.i(CloudConnectBridge.TAG, "WHAT_IM_CONNECT_TIME_OUT");
                return false;
            }
        }
    });
    private BrowserInfo mIMInfo;
    private OnConnectIMListener mServerListener = new OnConnectIMListener() {
        public void onConnectFailed() {
            String access$100 = CloudConnectBridge.TAG;
            SourceLog.i(access$100, "onConnectFailed im server " + CloudConnectBridge.this.isNeedConnectSink);
            if (CloudConnectBridge.this.isNeedConnectSink) {
                SourceLog.w(CloudConnectBridge.TAG, " server onConnectFailed");
                CloudConnectBridge.this.setConnected(false);
                SourceDataReport instance = SourceDataReport.getInstance();
                CloudConnectBridge cloudConnectBridge = CloudConnectBridge.this;
                instance.onCloudConnectFailed(cloudConnectBridge.mConnectSession, 4, cloudConnectBridge.mServiceInfo, "212010");
                boolean unused = CloudConnectBridge.this.isNeedConnectSink = false;
                CloudConnectBridge cloudConnectBridge2 = CloudConnectBridge.this;
                IConnectListener iConnectListener = cloudConnectBridge2.mAppListener;
                if (iConnectListener != null) {
                    iConnectListener.onDisconnect(cloudConnectBridge2.mServiceInfo, 212010, 212011);
                }
            }
        }

        public void onConnectSuccess() {
            String access$100 = CloudConnectBridge.TAG;
            SourceLog.i(access$100, "onConnectSuccess im server " + CloudConnectBridge.this.isNeedConnectSink);
            if (CloudConnectBridge.this.isNeedConnectSink) {
                CloudConnectBridge.this.connect();
            }
        }
    };
    /* access modifiers changed from: private */
    public LelinkServiceInfo mServiceInfo;
    /* access modifiers changed from: private */
    public OnConnectSinkListener mSinkConnectListener = new OnConnectSinkListener() {
        public void onConnect(int i10, String str) {
            boolean z10;
            String access$100 = CloudConnectBridge.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onConnect ");
            sb.append(i10);
            sb.append("=========");
            if (CloudConnectBridge.this.mAppListener == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            sb.append(z10);
            SourceLog.i(access$100, sb.toString());
            CloudConnectBridge.this.mHandler.removeMessages(100);
            boolean unused = CloudConnectBridge.this.isNeedConnectSink = false;
            SourceDataReport instance = SourceDataReport.getInstance();
            CloudConnectBridge cloudConnectBridge = CloudConnectBridge.this;
            instance.onCloudConnectSuccess(cloudConnectBridge.mConnectSession, 4, cloudConnectBridge.mServiceInfo);
            CloudConnectBridge.this.setConnected(true);
            CloudConnectBridge cloudConnectBridge2 = CloudConnectBridge.this;
            IConnectListener iConnectListener = cloudConnectBridge2.mAppListener;
            if (iConnectListener != null) {
                iConnectListener.onConnect(cloudConnectBridge2.mServiceInfo, 4);
            }
            if (LelinkSdkManager.getInstance().mOuterRelevantInfoListener != null) {
                LelinkSdkManager.getInstance().mOuterRelevantInfoListener.onReverseInfoResult(101, str);
            }
        }

        public void onDisconnect(int i10) {
            String access$100 = CloudConnectBridge.TAG;
            SourceLog.i(access$100, "onDisconnect " + i10);
            boolean unused = CloudConnectBridge.this.isNeedConnectSink = false;
            CloudConnectBridge.this.setConnected(false);
            CloudConnectBridge cloudConnectBridge = CloudConnectBridge.this;
            IConnectListener iConnectListener = cloudConnectBridge.mAppListener;
            if (iConnectListener == null) {
                return;
            }
            if (i10 == 212012) {
                iConnectListener.onDisconnect(cloudConnectBridge.mServiceInfo, 212012, i10);
            } else {
                iConnectListener.onDisconnect(cloudConnectBridge.mServiceInfo, 212000, i10);
            }
        }
    };

    public CloudConnectBridge(Context context) {
        this.mContext = context;
    }

    private void callbackDisconnectSuccess() {
        if (!this.isCallbackDisconnectSuccess) {
            setConnected(false);
            this.isCallbackDisconnectSuccess = true;
            IConnectListener iConnectListener = this.mAppListener;
            if (iConnectListener == null) {
                SourceLog.w(TAG, "disconnect, invalid listener");
            } else {
                iConnectListener.onDisconnect(this.mServiceInfo, 212000, 212001);
            }
        }
    }

    private boolean isGroupMirrorNow() {
        try {
            PlayController lastPlayController = BusinessEntity.getInstance().getLastPlayController();
            OutParameter lastPlayInfo = BusinessEntity.getInstance().getLastPlayInfo();
            if (lastPlayController == null || lastPlayController.getMediaPlayer() == null || !(lastPlayController.getMediaPlayer() instanceof GroupPlayer) || lastPlayInfo == null || !TextUtils.equals(lastPlayInfo.serviceInfo.getUid(), this.mServiceInfo.getUid())) {
                return false;
            }
            return true;
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return false;
        }
    }

    public void connect(LelinkServiceInfo lelinkServiceInfo) {
        super.connect(lelinkServiceInfo);
        if (lelinkServiceInfo == null) {
            this.mIMInfo = null;
        } else {
            this.mIMInfo = CastUtil.getBrowserInfo(lelinkServiceInfo, 4);
        }
        this.mServiceInfo = lelinkServiceInfo;
        BrowserInfo browserInfo = this.mIMInfo;
        if (browserInfo == null) {
            String str = TAG;
            SourceLog.w(str, "connect ignore, there has no im info " + lelinkServiceInfo);
            return;
        }
        connect(lelinkServiceInfo, browserInfo);
    }

    public void disconnect(int i10) {
        String str;
        super.disconnect(i10);
        if (!this.isCallDisconnect) {
            this.mHandler.removeMessages(100);
            String str2 = TAG;
            SourceLog.i(str2, "disconnect " + i10);
            if (i10 != 3 || !isGroupMirrorNow()) {
                this.isCallDisconnect = true;
                if (isConnected()) {
                    PublicCastClient instance = PublicCastClient.getInstance();
                    String str3 = this.mConnectSession;
                    BrowserInfo browserInfo = this.mIMInfo;
                    if (browserInfo != null) {
                        str = browserInfo.getUid();
                    } else {
                        str = "";
                    }
                    instance.disconnectTV(str3, str);
                    setConnected(false);
                }
                this.isNeedConnectSink = false;
                callbackDisconnectSuccess();
                if (!this.isReportDisconnect) {
                    this.isReportDisconnect = true;
                    SourceDataReport.getInstance().onCloudDisconnect(this.mConnectSession, 4, this.mServiceInfo, i10);
                    return;
                }
                return;
            }
            SourceLog.i(TAG, "group mirror ignore wifi disconnected");
        }
    }

    public boolean isSupportTrack() {
        String str = this.mFeature;
        if (str == null || str.length() < 7 || this.mFeature.charAt(6) != '1') {
            return false;
        }
        return true;
    }

    public boolean isSupportUrlList() {
        String str = this.mFeature;
        if (str == null || str.length() < 6 || this.mFeature.charAt(5) != '1') {
            return false;
        }
        return true;
    }

    public void reconnectServer() {
        if (TextUtils.isEmpty(CloudAPI.sImServer)) {
            SourceLog.w(TAG, "connect ignore, invalid im url");
            SourceDataReport.getInstance().onCloudConnectFailed(this.mConnectSession, 4, this.mServiceInfo, "212010");
            IConnectListener iConnectListener = this.mAppListener;
            if (iConnectListener != null) {
                iConnectListener.onDisconnect(this.mServiceInfo, 212010, 212011);
                return;
            }
            return;
        }
        PublicCastClient.getInstance().connectServer(CloudAPI.sImServer, a.a(), this.mServerListener);
    }

    public void release() {
        SourceLog.i(TAG, "release");
        if (!this.isRelease) {
            this.isRelease = true;
            disconnect(100);
            PublicCastClient.getInstance().removeConnectIMListener(this.mServerListener);
            this.mServerListener = null;
        }
    }

    public void resolveConnectMsg(String str) {
        SourceLog.i(TAG, "resolveConnectMsg");
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("st");
            int optInt2 = jSONObject.optInt(DramaInfoBean.CATEGORY_STD);
            int optInt3 = jSONObject.optInt("plat");
            String optString = jSONObject.optString("sm");
            int optInt4 = jSONObject.optInt(AgooConstants.MESSAGE_TIME);
            this.mFeature = jSONObject.optString(BrowserInfo.KEY_FE);
            setSinkSM(optString);
            saveConnectBean(str);
            if (this.mIMInfo != null) {
                RightsManager.getInstance().handleNetConnectMessage(this.mIMInfo.getUid(), str);
            }
            if (optInt == 1) {
                OnConnectSinkListener onConnectSinkListener = this.mSinkConnectListener;
                if (onConnectSinkListener != null) {
                    onConnectSinkListener.onDisconnect(212012);
                }
                if (optInt4 <= 0) {
                    optInt4 = 15;
                }
                this.mHandler.removeMessages(1);
                this.mHandler.sendEmptyMessageDelayed(1, (long) (optInt4 * 1000));
            } else if (optInt != 2) {
                this.mHandler.removeMessages(1);
                if (optInt2 == 1) {
                    OnConnectSinkListener onConnectSinkListener2 = this.mSinkConnectListener;
                    if (onConnectSinkListener2 != null) {
                        onConnectSinkListener2.onDisconnect(212014);
                    }
                } else if (optInt2 == 3) {
                    OnConnectSinkListener onConnectSinkListener3 = this.mSinkConnectListener;
                    if (onConnectSinkListener3 != null) {
                        onConnectSinkListener3.onDisconnect(212015);
                    }
                } else {
                    OnConnectSinkListener onConnectSinkListener4 = this.mSinkConnectListener;
                    if (onConnectSinkListener4 != null) {
                        onConnectSinkListener4.onDisconnect(212013);
                    }
                }
            } else {
                this.mHandler.removeMessages(1);
                OnConnectSinkListener onConnectSinkListener5 = this.mSinkConnectListener;
                if (onConnectSinkListener5 != null) {
                    onConnectSinkListener5.onConnect(optInt3, str);
                }
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public synchronized void sendPassData(int i10, String str, String str2) {
        boolean z10;
        int i11 = 0;
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(0, Pass.PLACEHOLDER_START + str + Pass.PLACEHOLDER_END + Pass.PLACEHOLDER_START + str2 + Pass.PLACEHOLDER_END);
            z10 = PublicCastClient.getInstance().sendPass(this.mServiceInfo.getUid(), jSONArray.toString());
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            z10 = false;
        }
        PassBean passBean = new PassBean();
        passBean.action = 1;
        try {
            passBean.action = new JSONObject(str2).optInt("regist", passBean.action);
        } catch (Exception e11) {
            SourceLog.w(TAG, (Throwable) e11);
        }
        if (z10) {
            i11 = 1;
        }
        passBean.result = i11;
        passBean.cmd = i10;
        callbackPass(passBean);
    }

    private void connect(LelinkServiceInfo lelinkServiceInfo, BrowserInfo browserInfo) {
        SourceLog.i(TAG, BaseMonitor.ALARM_POINT_CONNECT);
        this.mConnectSession = CreateUtil.createSessionId();
        this.isReportDisconnect = false;
        this.isCallDisconnect = false;
        this.isCallbackDisconnectSuccess = false;
        this.isNeedConnectSink = true;
        if (browserInfo == null) {
            this.isNeedConnectSink = false;
        } else {
            this.mConnectBrowserInfo = browserInfo;
            SourceDataReport.getInstance().onCloudConnect(this.mConnectSession, 4, this.mServiceInfo);
        }
        if (PublicCastClient.getInstance().isConnectedServer()) {
            connect();
        } else {
            reconnectServer();
        }
    }

    /* access modifiers changed from: private */
    public void connect() {
        this.isNeedConnectSink = true;
        SourceLog.i(TAG, "connect 2");
        this.mFeature = null;
        String str = this.mIMInfo.getExtras().get("phone");
        if (TextUtils.isEmpty(str) || !str.equals("1")) {
            String str2 = "";
            try {
                String str3 = Preference.getInstance().get(Constant.KEY_USERNAME);
                if (TextUtils.isEmpty(str3)) {
                    str2 = URLEncoder.encode(DeviceUtil.getBluetoothName());
                } else {
                    str2 = URLEncoder.encode(str3);
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
            PublicCastClient.getInstance().connectTV(this.mIMInfo, str2, "", this.mConnectSession, this.mSinkConnectListener, this);
            this.mHandler.removeMessages(100);
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(100), NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS);
            return;
        }
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                CloudConnectBridge cloudConnectBridge = CloudConnectBridge.this;
                IConnectListener iConnectListener = cloudConnectBridge.mAppListener;
                if (iConnectListener != null) {
                    iConnectListener.onConnect(cloudConnectBridge.mServiceInfo, 4);
                }
                if (LelinkSdkManager.getInstance().mOuterRelevantInfoListener != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("plat", 107);
                        LelinkSdkManager.getInstance().mOuterRelevantInfoListener.onReverseInfoResult(101, jSONObject.toString());
                    } catch (Exception e10) {
                        SourceLog.w(CloudConnectBridge.TAG, (Throwable) e10);
                    }
                }
            }
        }, 300);
    }
}
