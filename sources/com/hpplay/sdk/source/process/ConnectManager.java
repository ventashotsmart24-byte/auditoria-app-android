package com.hpplay.sdk.source.process;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.sdk.source.api.IConnectListener;
import com.hpplay.sdk.source.bean.HistoryConfigBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.business.cloud.ConnectRelationManager;
import com.hpplay.sdk.source.business.cloud.RightsManager;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.process.OnlineManager;
import com.hpplay.sdk.source.protocol.connect.CloudConnectBridge;
import com.hpplay.sdk.source.protocol.connect.ConnectBridge;
import com.hpplay.sdk.source.protocol.connect.GroupConnectBridge;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.Feature;
import com.hpplay.sdk.source.utils.LeboUtil;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConnectManager {
    public static final int DISCONNECT_BY_NET_DISCONNECT = 3;
    public static final int DISCONNECT_BY_OTHER = 100;
    public static final int DISCONNECT_BY_RECONNECT = 2;
    public static final int DISCONNECT_BY_USER = 1;
    private static final String TAG = "ConnectManager";
    private static ConnectManager sInstance;
    /* access modifiers changed from: private */
    public ConcurrentLinkedQueue<IConnectListener> mConnectCheckListeners = new ConcurrentLinkedQueue<>();
    private final IConnectListener mConnectListener = new IConnectListener() {
        public void onConnect(LelinkServiceInfo lelinkServiceInfo, int i10) {
            SourceLog.i(ConnectManager.TAG, "onConnect " + lelinkServiceInfo + Operator.Operation.DIVISION + i10);
            if (ConnectManager.this.mOuterListener != null) {
                if (i10 == 5) {
                    ConnectManager.this.mOuterListener.onConnect(lelinkServiceInfo, 1);
                } else {
                    ConnectManager.this.mOuterListener.onConnect(lelinkServiceInfo, i10);
                }
            }
            if (ConnectManager.this.mConnectCheckListeners != null && !ConnectManager.this.mConnectCheckListeners.isEmpty()) {
                Iterator it = ConnectManager.this.mConnectCheckListeners.iterator();
                while (it.hasNext()) {
                    IConnectListener iConnectListener = (IConnectListener) it.next();
                    if (iConnectListener != null) {
                        iConnectListener.onConnect(lelinkServiceInfo, i10);
                    }
                }
            }
            ConnectManager.this.reportLiveConnect(lelinkServiceInfo);
            if (lelinkServiceInfo != null) {
                RightsManager.getInstance().getSinkTempRights(CastUtil.getKey(lelinkServiceInfo), lelinkServiceInfo.getAppId(), i10);
                if (ConnectManager.this.mHistoryConfigBean != null && ConnectManager.this.mHistoryConfigBean.isReport) {
                    new ConnectRelationManager().uploadConnectDeivce(ConnectManager.this.mHistoryConfigBean, lelinkServiceInfo.getAppId(), lelinkServiceInfo.getUid(), 0);
                }
            }
            if (ConnectManager.this.mOnlineManager != null) {
                ConnectManager.this.mOnlineManager.updateOnlineTime(lelinkServiceInfo);
            }
        }

        public void onDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
            if (lelinkServiceInfo != null) {
                SourceLog.i(ConnectManager.TAG, "onDisconnect " + lelinkServiceInfo + " " + i10 + Operator.Operation.DIVISION + i11);
                if (ConnectManager.this.mOuterListener != null) {
                    ConnectManager.this.mOuterListener.onDisconnect(lelinkServiceInfo, i10, i11);
                }
                if (i10 != 212012) {
                    if (ConnectManager.this.mOnlineManager != null) {
                        ConnectManager.this.mOnlineManager.remove(lelinkServiceInfo);
                    }
                    ConnectManager.this.removeBridge(lelinkServiceInfo);
                    String key = CastUtil.getKey(lelinkServiceInfo);
                    if (!TextUtils.isEmpty(key)) {
                        RightsManager.getInstance().removeSinkRights(key);
                    }
                }
            }
        }
    };
    private final Map<String, ConnectBridge> mConnectMap = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public HistoryConfigBean mHistoryConfigBean;
    private ConnectBridge mLastConnectBridge;
    /* access modifiers changed from: private */
    public OnlineManager mOnlineManager;
    /* access modifiers changed from: private */
    public IConnectListener mOuterListener;
    private String mReportDll;

    private ConnectManager() {
        if (enableOnlineCheck()) {
            this.mOnlineManager = new OnlineManager();
        }
    }

    private boolean enableOnlineCheck() {
        if (Feature.isLeboApp()) {
            return true;
        }
        return false;
    }

    public static synchronized ConnectManager getInstance() {
        ConnectManager connectManager;
        synchronized (ConnectManager.class) {
            if (sInstance == null) {
                synchronized (ConnectManager.class) {
                    if (sInstance == null) {
                        SourceLog.i(TAG, "getInstance: new ConnectManager");
                        sInstance = new ConnectManager();
                    }
                }
            }
            connectManager = sInstance;
        }
        return connectManager;
    }

    public boolean checkOnline(LelinkServiceInfo lelinkServiceInfo, OnlineManager.OnlineListener onlineListener) {
        OnlineManager onlineManager;
        if (lelinkServiceInfo == null || (onlineManager = this.mOnlineManager) == null) {
            return false;
        }
        return onlineManager.checkOnline(lelinkServiceInfo, onlineListener);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.hpplay.sdk.source.protocol.connect.ConnectBridge} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.hpplay.sdk.source.protocol.connect.ConnectBridge} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.hpplay.sdk.source.protocol.connect.ConnectBridge} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.hpplay.sdk.source.protocol.connect.ConnectBridge} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.hpplay.sdk.source.protocol.connect.ConnectBridge} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.hpplay.sdk.source.protocol.connect.GroupConnectBridge} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: com.hpplay.sdk.source.protocol.connect.GroupConnectBridge} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.hpplay.sdk.source.protocol.connect.GroupConnectBridge} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: com.hpplay.sdk.source.protocol.connect.GroupConnectBridge} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(android.content.Context r5, com.hpplay.sdk.source.browse.api.LelinkServiceInfo r6, boolean r7) {
        /*
            r4 = this;
            java.lang.String r0 = com.hpplay.sdk.source.utils.CastUtil.getKey(r6)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "+++++++++++++++++++++++++++++++++= connect "
            r1.append(r2)
            java.lang.String r2 = r6.getIp()
            r1.append(r2)
            java.lang.String r2 = "/"
            r1.append(r2)
            java.lang.String r3 = r6.getName()
            r1.append(r3)
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "ConnectManager"
            com.hpplay.sdk.source.log.SourceLog.i(r2, r1)
            r1 = 0
            if (r7 == 0) goto L_0x0065
            java.util.Map<java.lang.String, com.hpplay.sdk.source.protocol.connect.ConnectBridge> r5 = r4.mConnectMap
            boolean r5 = r5.containsKey(r0)
            if (r5 == 0) goto L_0x004e
            java.util.Map<java.lang.String, com.hpplay.sdk.source.protocol.connect.ConnectBridge> r5 = r4.mConnectMap
            java.lang.Object r5 = r5.get(r0)
            boolean r5 = r5 instanceof com.hpplay.sdk.source.protocol.connect.GroupConnectBridge
            if (r5 == 0) goto L_0x004e
            java.util.Map<java.lang.String, com.hpplay.sdk.source.protocol.connect.ConnectBridge> r5 = r4.mConnectMap
            java.lang.Object r5 = r5.get(r0)
            r1 = r5
            com.hpplay.sdk.source.protocol.connect.GroupConnectBridge r1 = (com.hpplay.sdk.source.protocol.connect.GroupConnectBridge) r1
        L_0x004e:
            if (r1 != 0) goto L_0x005a
            com.hpplay.sdk.source.protocol.connect.GroupConnectBridge r1 = new com.hpplay.sdk.source.protocol.connect.GroupConnectBridge
            r1.<init>()
            java.util.Map<java.lang.String, com.hpplay.sdk.source.protocol.connect.ConnectBridge> r5 = r4.mConnectMap
            r5.put(r0, r1)
        L_0x005a:
            r4.mLastConnectBridge = r1
            com.hpplay.sdk.source.api.IConnectListener r5 = r4.mConnectListener
            r1.setConnectListener(r5)
            r1.connect(r6)
            goto L_0x009a
        L_0x0065:
            java.util.Map<java.lang.String, com.hpplay.sdk.source.protocol.connect.ConnectBridge> r7 = r4.mConnectMap
            boolean r7 = r7.containsKey(r0)
            if (r7 == 0) goto L_0x007e
            java.util.Map<java.lang.String, com.hpplay.sdk.source.protocol.connect.ConnectBridge> r7 = r4.mConnectMap
            java.lang.Object r7 = r7.get(r0)
            com.hpplay.sdk.source.protocol.connect.ConnectBridge r7 = (com.hpplay.sdk.source.protocol.connect.ConnectBridge) r7
            boolean r2 = r7 instanceof com.hpplay.sdk.source.protocol.connect.GroupConnectBridge
            if (r2 == 0) goto L_0x007d
            r7.release()
            goto L_0x007e
        L_0x007d:
            r1 = r7
        L_0x007e:
            if (r1 == 0) goto L_0x0086
            boolean r7 = r1.checkBridge(r6)
            if (r7 != 0) goto L_0x0090
        L_0x0086:
            com.hpplay.sdk.source.protocol.connect.ConnectBridge r1 = new com.hpplay.sdk.source.protocol.connect.ConnectBridge
            r1.<init>((android.content.Context) r5, (com.hpplay.sdk.source.browse.api.LelinkServiceInfo) r6)
            java.util.Map<java.lang.String, com.hpplay.sdk.source.protocol.connect.ConnectBridge> r5 = r4.mConnectMap
            r5.put(r0, r1)
        L_0x0090:
            r4.mLastConnectBridge = r1
            com.hpplay.sdk.source.api.IConnectListener r5 = r4.mConnectListener
            r1.setConnectListener(r5)
            r1.connect(r6)
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.process.ConnectManager.connect(android.content.Context, com.hpplay.sdk.source.browse.api.LelinkServiceInfo, boolean):void");
    }

    public void connectServer(Context context, LelinkServiceInfo lelinkServiceInfo) {
        SourceLog.i(TAG, "connectServer");
        CloudConnectBridge cloudConnectBridge = new CloudConnectBridge(context);
        cloudConnectBridge.setConnectListener(this.mConnectListener);
        cloudConnectBridge.connect(lelinkServiceInfo);
    }

    public void disconnect(LelinkServiceInfo lelinkServiceInfo) {
        String key = CastUtil.getKey(lelinkServiceInfo);
        if (!this.mConnectMap.containsKey(key)) {
            SourceLog.w(TAG, "disconnect ignore");
            return;
        }
        ConnectBridge connectBridge = this.mConnectMap.get(key);
        if (connectBridge == null) {
            SourceLog.w(TAG, "disconnect ignore 2");
            return;
        }
        if (connectBridge instanceof GroupConnectBridge) {
            connectBridge.setConnectListener((IConnectListener) null);
        }
        connectBridge.disconnect(1);
        SourceLog.i(TAG, "disconnect");
        removeBridge(lelinkServiceInfo);
        RightsManager.getInstance().removeSinkRights(key);
    }

    public ConnectBridge getConnectBridge(String str) {
        if (TextUtils.isEmpty(str) || this.mConnectMap.isEmpty()) {
            SourceLog.i(TAG, " getConnectBridge uid:" + str);
            return null;
        }
        for (ConnectBridge next : this.mConnectMap.values()) {
            if (next != null && next.getServiceInfo() != null && str.equals(next.getServiceInfo().getUid())) {
                return next;
            }
        }
        SourceLog.w(TAG, " getConnectBridge has no uid bridge " + this.mConnectMap.size() + Operator.Operation.DIVISION + str);
        return null;
    }

    public int getConnectProtocol(LelinkServiceInfo lelinkServiceInfo) {
        String key = CastUtil.getKey(lelinkServiceInfo);
        if (!this.mConnectMap.containsKey(key)) {
            SourceLog.w(TAG, "getConnectProtocol ignore, service not connect yet " + key);
            return -1;
        }
        ConnectBridge connectBridge = this.mConnectMap.get(key);
        if (connectBridge != null) {
            return connectBridge.getConnectProtocol();
        }
        SourceLog.w(TAG, "getConnectProtocol ignore, service not connect yet 2," + key);
        return -1;
    }

    public String getConnectSession(LelinkServiceInfo lelinkServiceInfo) {
        String key = CastUtil.getKey(lelinkServiceInfo);
        if (!this.mConnectMap.containsKey(key)) {
            SourceLog.w(TAG, "getConnectSession ignore, service not connect yet " + key);
            return null;
        }
        ConnectBridge connectBridge = this.mConnectMap.get(key);
        if (connectBridge == null) {
            SourceLog.w(TAG, "getConnectSession ignore, service not connect yet 2," + key);
            return null;
        }
        SourceLog.i(TAG, " ++++++++  getConnectSession ++++++++" + connectBridge.getConnectProtocol());
        if (connectBridge.getConnectProtocol() != -1) {
            return connectBridge.getConnectSession();
        }
        SourceLog.i(TAG, "disconnect ......... ");
        disconnect(lelinkServiceInfo);
        return null;
    }

    public List<LelinkServiceInfo> getConnections() {
        ArrayList arrayList = new ArrayList();
        for (ConnectBridge next : this.mConnectMap.values()) {
            if (next.isConnected()) {
                arrayList.add(next.getServiceInfo());
            }
        }
        return arrayList;
    }

    public String getDeviceReportId() {
        HistoryConfigBean historyConfigBean = this.mHistoryConfigBean;
        if (historyConfigBean == null) {
            return null;
        }
        if (!TextUtils.isEmpty(historyConfigBean.encryptNumberId)) {
            return this.mHistoryConfigBean.encryptNumberId;
        }
        if (!TextUtils.isEmpty(this.mHistoryConfigBean.numberId)) {
            return LeboUtil.anonymizeBySHA256For60Bits(this.mHistoryConfigBean.encryptNumberId);
        }
        return null;
    }

    public ConnectBridge getLastConnectBridge() {
        return this.mLastConnectBridge;
    }

    public LelinkServiceInfo getLastServiceInfo() {
        ConnectBridge connectBridge = this.mLastConnectBridge;
        if (connectBridge != null) {
            return connectBridge.getServiceInfo();
        }
        SourceLog.w(TAG, "getLastServiceInfo has no valid connect bridge");
        return null;
    }

    public LelinkServiceInfo getLelinkServiceInfo(String str) {
        for (ConnectBridge next : this.mConnectMap.values()) {
            if (str.equals(next.getServiceInfo().getUid())) {
                return next.getServiceInfo();
            }
        }
        return null;
    }

    public void groupReconnect(int i10, LelinkServiceInfo lelinkServiceInfo, IConnectListener iConnectListener) {
        ConnectBridge connectBridge = this.mLastConnectBridge;
        if (connectBridge != null && (connectBridge instanceof GroupConnectBridge)) {
            ((GroupConnectBridge) connectBridge).groupReconnect(i10, lelinkServiceInfo, iConnectListener);
        }
    }

    public boolean isConnected(OutParameter outParameter) {
        LelinkServiceInfo lelinkServiceInfo;
        if (outParameter == null || (lelinkServiceInfo = outParameter.serviceInfo) == null) {
            return false;
        }
        return this.mConnectMap.containsKey(CastUtil.getKey(lelinkServiceInfo));
    }

    public void notifyBrowseResult(LelinkServiceInfo lelinkServiceInfo) {
        OnlineManager onlineManager;
        if (lelinkServiceInfo != null && (onlineManager = this.mOnlineManager) != null) {
            onlineManager.updateOnlineTime(lelinkServiceInfo);
        }
    }

    public void notifyCastError(LelinkServiceInfo lelinkServiceInfo) {
        OnlineManager onlineManager;
        if (lelinkServiceInfo != null && (onlineManager = this.mOnlineManager) != null) {
            onlineManager.remove(lelinkServiceInfo);
        }
    }

    public void notifyCastStatusValid(LelinkServiceInfo lelinkServiceInfo) {
        OnlineManager onlineManager;
        if (lelinkServiceInfo != null && (onlineManager = this.mOnlineManager) != null) {
            onlineManager.updateOnlineTime(lelinkServiceInfo);
        }
    }

    public void notifyCastSuccess(LelinkServiceInfo lelinkServiceInfo) {
        OnlineManager onlineManager;
        if (lelinkServiceInfo != null && (onlineManager = this.mOnlineManager) != null) {
            onlineManager.updateOnlineTime(lelinkServiceInfo);
        }
    }

    public void notifyDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
        SourceLog.w(TAG, "notifyDisconnect " + lelinkServiceInfo + " " + i10 + " / " + i11);
        this.mConnectListener.onDisconnect(lelinkServiceInfo, i10, i11);
    }

    public void notifyInvalid(LelinkServiceInfo lelinkServiceInfo) {
        SourceLog.w(TAG, "notifyInvalid " + lelinkServiceInfo);
        notifyOffline(lelinkServiceInfo, 212010, IConnectListener.EXTRA_CONNECT_INVALID_DEVICE);
    }

    public void notifyOffline(LelinkServiceInfo lelinkServiceInfo) {
        SourceLog.w(TAG, "notifyOffline " + lelinkServiceInfo);
        notifyOffline(lelinkServiceInfo, 212010, 212018);
    }

    public void onNetDisconnect() {
        Iterator<ConnectBridge> it = this.mConnectMap.values().iterator();
        while (it.hasNext()) {
            try {
                ConnectBridge next = it.next();
                if (!(next instanceof GroupConnectBridge)) {
                    if (next.mConnectBridge instanceof CloudConnectBridge) {
                        it.remove();
                    } else {
                        next.disconnect(3);
                        it.remove();
                    }
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        }
    }

    public void removeBridge(LelinkServiceInfo lelinkServiceInfo) {
        ConnectBridge connectBridge;
        String key = CastUtil.getKey(lelinkServiceInfo);
        if (!TextUtils.isEmpty(key) && (connectBridge = this.mConnectMap.get(key)) != null) {
            connectBridge.release();
            this.mConnectMap.remove(key);
        }
    }

    public void removeConnectCheckListener(IConnectListener iConnectListener) {
        this.mConnectCheckListeners.remove(iConnectListener);
    }

    public void reportLiveConnect(LelinkServiceInfo lelinkServiceInfo) {
        String str;
        List<LelinkServiceInfo> browserList = LelinkSdkManager.getInstance().getBrowserList();
        if (browserList != null && browserList.size() != 0 && lelinkServiceInfo != null) {
            SourceLog.i(TAG, "reportLiveConnect lelinkServiceInfos = " + browserList.size());
            try {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i10 = 0; i10 < browserList.size(); i10++) {
                    LelinkServiceInfo lelinkServiceInfo2 = browserList.get(i10);
                    Map<Integer, BrowserInfo> browserInfos = lelinkServiceInfo2.getBrowserInfos();
                    if (browserInfos != null && browserInfos.size() > 0) {
                        String str2 = "0";
                        if (!TextUtils.isEmpty(lelinkServiceInfo2.getUid())) {
                            str2 = "1";
                            str = lelinkServiceInfo2.getUid();
                        } else {
                            str = "";
                        }
                        String str3 = "";
                        String str4 = str3;
                        String str5 = str4;
                        String str6 = str5;
                        for (Map.Entry<Integer, BrowserInfo> value : browserInfos.entrySet()) {
                            BrowserInfo browserInfo = (BrowserInfo) value.getValue();
                            if (browserInfo != null) {
                                String str7 = browserInfo.getExtras().get(BrowserInfo.KEY_M);
                                if (TextUtils.isEmpty(str7)) {
                                    str4 = "";
                                } else {
                                    str4 = str7;
                                }
                                str3 = browserInfo.getIp();
                                if (browserInfo.getType() == 3) {
                                    str5 = browserInfo.getExtras().get(BrowserInfo.KEY_MANUFACTURER);
                                    if (TextUtils.isEmpty(str5)) {
                                        str5 = "";
                                    }
                                    str6 = browserInfo.getName();
                                    if (str6.contains("#")) {
                                        str6 = str6.replace("#", "");
                                    }
                                } else {
                                    str6 = browserInfo.getExtras().get("u");
                                }
                            }
                        }
                        stringBuffer.append(str2);
                        stringBuffer.append("#");
                        stringBuffer.append(str3);
                        stringBuffer.append("#");
                        stringBuffer.append(str4);
                        stringBuffer.append("#");
                        stringBuffer.append(str5);
                        stringBuffer.append("#");
                        stringBuffer.append(str6);
                        stringBuffer.append("#");
                        stringBuffer.append(str);
                    }
                    if (i10 < browserList.size() - 1) {
                        stringBuffer.append(",");
                    }
                }
                if (TextUtils.isEmpty(this.mReportDll) || !TextUtils.equals(this.mReportDll, stringBuffer.toString().trim())) {
                    this.mReportDll = stringBuffer.toString().trim();
                    SourceLog.debug(TAG, "reportLiveConnect dll = " + this.mReportDll);
                    SourceDataReport.getInstance().onReceiverLive(getConnectSession(lelinkServiceInfo), this.mReportDll);
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        }
    }

    public void resetLastConnectBridge(LelinkServiceInfo lelinkServiceInfo) {
        for (ConnectBridge next : this.mConnectMap.values()) {
            LelinkServiceInfo serviceInfo = next.getServiceInfo();
            if (TextUtils.equals(lelinkServiceInfo.getName(), serviceInfo.getName()) && TextUtils.equals(lelinkServiceInfo.getIp(), serviceInfo.getIp())) {
                this.mLastConnectBridge = next;
                return;
            }
        }
    }

    public void sendPassData(LelinkServiceInfo lelinkServiceInfo, int i10, String str, String str2) {
        boolean z10;
        ConnectBridge connectBridge = this.mConnectMap.get(CastUtil.getKey(lelinkServiceInfo));
        StringBuilder sb = new StringBuilder();
        sb.append("=======sendPassData====== ");
        if (connectBridge == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        sb.append(z10);
        SourceLog.i(TAG, sb.toString());
        if (connectBridge == null) {
            SourceLog.i(TAG, "sendPassData ignore 1");
        } else if (!connectBridge.isSupportPassthrough()) {
            SourceLog.i(TAG, "sendPassData ignore, nonsupport passthrough");
        } else {
            connectBridge.sendPassData(i10, str, str2);
        }
    }

    public void setConnectCheckListener(IConnectListener iConnectListener) {
        this.mConnectCheckListeners.add(iConnectListener);
    }

    public void setConnectDeviceReport(HistoryConfigBean historyConfigBean) {
        this.mHistoryConfigBean = historyConfigBean;
    }

    public void setConnectListener(IConnectListener iConnectListener) {
        this.mOuterListener = iConnectListener;
    }

    public void switchGroupConnection(int i10) {
        ConnectBridge connectBridge = this.mLastConnectBridge;
        if (connectBridge != null && (connectBridge instanceof GroupConnectBridge)) {
            ((GroupConnectBridge) connectBridge).switchGroupConnection(i10);
        }
    }

    private void notifyOffline(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
        try {
            this.mConnectListener.onDisconnect(lelinkServiceInfo, i10, i11);
            OnlineManager onlineManager = this.mOnlineManager;
            if (onlineManager != null) {
                onlineManager.remove(lelinkServiceInfo);
            }
            removeBridge(lelinkServiceInfo);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void groupReconnect() {
        ConnectBridge connectBridge = this.mLastConnectBridge;
        if (connectBridge != null && (connectBridge instanceof GroupConnectBridge)) {
            ((GroupConnectBridge) connectBridge).groupReconnect();
        }
    }

    public String getConnectSession(LelinkServiceInfo lelinkServiceInfo, boolean z10) {
        try {
            String connectSession = getConnectSession(lelinkServiceInfo);
            if (TextUtils.isEmpty(connectSession)) {
                return null;
            }
            ConnectBridge connectBridge = this.mConnectMap.get(CastUtil.getKey(lelinkServiceInfo));
            SourceLog.i(TAG, " ++++++++  getConnectSession ++++++++" + z10);
            if (connectBridge != null && connectBridge.isGroup == z10) {
                return connectSession;
            }
            SourceLog.i(TAG, " ++++++++ getConnectSession disconnect ++++++++");
            disconnect(lelinkServiceInfo);
            return null;
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return null;
        }
    }
}
