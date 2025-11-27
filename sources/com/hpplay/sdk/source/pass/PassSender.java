package com.hpplay.sdk.source.pass;

import android.text.TextUtils;
import com.hpplay.common.utils.DeviceUtil;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.utils.DeviceProperties;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.sdk.source.bean.MediaAssetBean;
import com.hpplay.sdk.source.bean.MicroAppInfoBean;
import com.hpplay.sdk.source.bean.PlayerInfoBean;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.business.PublicCastClient;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.c.a;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.bean.ConnectBean;
import com.hpplay.sdk.source.pass.bean.DescribeBean;
import com.hpplay.sdk.source.pass.bean.RateQueryBean;
import com.hpplay.sdk.source.pass.bean.ShortVideoListBean;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.protocol.connect.OnConnectIMListener;
import com.hpplay.sdk.source.transceiver.bean.NotifyMirrorBean;
import com.hpplay.sdk.source.utils.CreateUtil;
import com.taobao.accs.common.Constants;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class PassSender {
    private static final String TAG = "PassSender";
    private static PassSender sInstance;
    private Map<String, String> mUnconnectedMsg = new LinkedHashMap(3);

    private PassSender() {
    }

    public static synchronized PassSender getInstance() {
        PassSender passSender;
        synchronized (PassSender.class) {
            synchronized (PassSender.class) {
                if (sInstance == null) {
                    sInstance = new PassSender();
                }
            }
            passSender = sInstance;
        }
        return passSender;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void send(com.hpplay.sdk.source.browse.api.LelinkServiceInfo r7, java.lang.String r8, int r9, int r10, int r11, java.lang.String r12) {
        /*
            r6 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 != 0) goto L_0x0014
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0014 }
            r0.<init>(r12)     // Catch:{ Exception -> 0x0014 }
            java.lang.String r1 = "uid"
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x0014 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0014 }
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            java.lang.String r1 = "PassSender"
            if (r7 == 0) goto L_0x0054
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x002a
            java.lang.String r2 = r7.getUid()
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 != 0) goto L_0x002a
            goto L_0x0054
        L_0x002a:
            com.hpplay.sdk.source.pass.bean.DescribeBean r8 = com.hpplay.sdk.source.pass.Creator.getDescribeBean(r8, r9, r10, r11)
            java.lang.String r10 = com.hpplay.sdk.source.utils.CreateUtil.createPassMsgID()
            r8.id = r10
            java.lang.String r8 = r8.toJson()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "send header "
            r10.append(r11)
            r10.append(r8)
            java.lang.String r10 = r10.toString()
            com.hpplay.sdk.source.log.SourceLog.i(r1, r10)
            com.hpplay.sdk.source.process.ConnectManager r10 = com.hpplay.sdk.source.process.ConnectManager.getInstance()
            r10.sendPassData(r7, r9, r8, r12)
            return
        L_0x0054:
            java.lang.String r7 = "send unconnected msg"
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r1, (java.lang.String) r7)
            r0 = r6
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r0.sendUnconnected(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.pass.PassSender.send(com.hpplay.sdk.source.browse.api.LelinkServiceInfo, java.lang.String, int, int, int, java.lang.String):void");
    }

    private void sendUnconnected(String str, int i10, int i11, int i12, String str2) {
        try {
            String str3 = (String) new JSONObject((String) new JSONObject(str2).get("data")).get(ParamsMap.DeviceParams.KEY_UID);
            if (!TextUtils.isEmpty(str3)) {
                send(str, str3, i10, i11, i12, str2);
            } else {
                SourceLog.w(TAG, "sendUnconnected, uid is null.");
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, "sendUnconnected, cause = " + e10.getCause() + ", msg = " + e10.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public synchronized void sendUnconnectedMsgReal() {
        SourceLog.i(TAG, "sendUnconnectedMsgReal");
        for (Map.Entry next : this.mUnconnectedMsg.entrySet()) {
            PublicCastClient.getInstance().sendPass((String) next.getKey(), (String) next.getValue());
        }
        this.mUnconnectedMsg.clear();
    }

    public void playRate(String str) {
        send(ConnectManager.getInstance().getLastServiceInfo(), "", 12, 1, 2, str);
    }

    public void queryRate() {
        send(ConnectManager.getInstance().getLastServiceInfo(), "", 15, 1, 2, new RateQueryBean().toJson());
    }

    public void sendChangeSinkPaint(String str) {
        LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
        if (lastServiceInfo == null) {
            SourceLog.w(TAG, "sendSinkHostSettingMsg ignore 2");
        } else {
            send(lastServiceInfo, "", 44, 1, 2, str);
        }
    }

    public void sendConnectMsg(LelinkServiceInfo lelinkServiceInfo) {
        send(lelinkServiceInfo, "", 4, 7, 2, new ConnectBean().toJson());
    }

    public void sendDanmu(String str) {
        send(ConnectManager.getInstance().getLastServiceInfo(), "", 6, 1, 2, str);
    }

    public void sendFavoriteConfirm(LelinkServiceInfo lelinkServiceInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manifestVer", 1);
            String str = "";
            try {
                String str2 = Preference.getInstance().get(Constant.KEY_USERNAME);
                if (TextUtils.isEmpty(str2)) {
                    str2 = DeviceUtil.getBluetoothName();
                    if (TextUtils.isEmpty(str2)) {
                        str2 = DeviceProperties.getModel();
                    }
                }
                str = URLEncoder.encode(str2, XML.CHARSET_UTF8);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
            jSONObject.put("name", str);
        } catch (Exception e11) {
            SourceLog.w(TAG, (Throwable) e11);
        }
        send(lelinkServiceInfo, "", 52, 1, 2, jSONObject.toString());
    }

    public void sendHarassCode(String str) {
        LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
        if (lastServiceInfo == null) {
            SourceLog.w(TAG, "sendHarassCode ignore");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manifestVer", 1);
            jSONObject.put(Constants.KEY_HTTP_CODE, str);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
        send(lastServiceInfo, "", 47, 1, 2, jSONObject.toString());
    }

    public void sendMediaAssets(MediaAssetBean mediaAssetBean, String str) {
        SourceLog.i(TAG, "sendMediaAssets");
        try {
            LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
            mediaAssetBean.setManifestVer(String.valueOf(1));
            send(lastServiceInfo, str, 2, 1, 2, mediaAssetBean.encode().toString());
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void sendMicroAppInfo(MicroAppInfoBean microAppInfoBean, String str) {
        try {
            LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
            microAppInfoBean.setManifestVer(1);
            send(lastServiceInfo, str, 33, 1, 2, microAppInfoBean.encode().toString());
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void sendMicroPass(String str, String str2, int i10) {
        LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manifestVer", 1);
            jSONObject.put("type", i10);
            jSONObject.put(ParamsMap.DeviceParams.KEY_APPID, lastServiceInfo.getAppId());
            jSONObject.put("content", str);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
        send(lastServiceInfo, str2, 34, 1, 2, jSONObject.toString());
    }

    public void sendMirrorState(String str, String str2) {
        send(ConnectManager.getInstance().getLastServiceInfo(), str2, 26, 1, 2, str);
    }

    public void sendNotifyMirrorMsg(NotifyMirrorBean notifyMirrorBean) {
        if (notifyMirrorBean == null) {
            SourceLog.w(TAG, "sendNotifyMirrorMsg ignore 1");
            return;
        }
        LelinkServiceInfo lelinkServiceInfo = ConnectManager.getInstance().getLelinkServiceInfo(notifyMirrorBean.uid);
        if (lelinkServiceInfo == null) {
            SourceLog.w(TAG, "sendNotifyMirrorMsg ignore 2");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manifestVer", 1);
            jSONObject.put("ip", notifyMirrorBean.ip);
            jSONObject.put("port", notifyMirrorBean.port);
            jSONObject.put("name", notifyMirrorBean.name);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
        send(lelinkServiceInfo, "", 38, 1, 2, jSONObject.toString());
    }

    public void sendNotifyRemoteMsg(String str, int i10, int i11) {
        LelinkServiceInfo lelinkServiceInfo = ConnectManager.getInstance().getLelinkServiceInfo(str);
        if (lelinkServiceInfo == null) {
            SourceLog.w(TAG, "sendNotifyRemoteMsg ignore 2");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manifestVer", 1);
            jSONObject.put("type", i10);
            jSONObject.put("action", i11);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
        send(lelinkServiceInfo, "", 39, 1, 2, jSONObject.toString());
    }

    public void sendPass(int i10, String str, boolean z10) {
        int i11;
        int i12;
        LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
        if (i10 == 100) {
            if (z10) {
                i11 = 2;
            } else {
                i11 = 1;
            }
            send(lastServiceInfo, "", 100, 1, i11, str);
        } else if (i10 != 10000) {
            SourceLog.w(TAG, "sendPass ignore, never should be here");
        } else {
            if (z10) {
                i12 = 2;
            } else {
                i12 = 1;
            }
            send(lastServiceInfo, "", 10000, 1, i12, str);
        }
    }

    public void sendPlayerInfo(PlayerInfoBean playerInfoBean, String str) {
        SourceLog.i(TAG, "sendPlayerInfo");
        try {
            LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
            playerInfoBean.setManifestVer(3);
            send(lastServiceInfo, str, 1, 3, 2, playerInfoBean.encode().toString());
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void sendReceiverPropertiesSync() {
        LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
        SourceLog.i(TAG, "sendReceiverPropertiesSync info: " + lastServiceInfo);
        send(lastServiceInfo, "", 50, 1, 2, "{}");
    }

    public void sendReceiverProperty(String str) {
        if (TextUtils.isEmpty(str)) {
            SourceLog.i(TAG, "sendReceiverProperty is ignore");
        }
        SourceLog.i(TAG, "sendReceiverProperty body: " + str);
        LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
        SourceLog.i(TAG, "sendReceiverProperty info: " + lastServiceInfo);
        send(lastServiceInfo, "", 49, 1, 2, str);
    }

    public void sendShortVideoList(String str) {
        SourceLog.i(TAG, "sendShortVideoList");
        try {
            ShortVideoListBean shortVideoListBean = new ShortVideoListBean();
            shortVideoListBean.manifestVer = 1;
            shortVideoListBean.index = 0;
            shortVideoListBean.videoList = new JSONArray(str);
            send(ConnectManager.getInstance().getLastServiceInfo(), "", 30, 1, 2, ShortVideoListBean.toJSON(shortVideoListBean));
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void sendSinkHostSettingMsg(String str) {
        LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
        if (lastServiceInfo == null) {
            SourceLog.w(TAG, "sendSinkHostSettingMsg ignore 2");
        } else {
            send(lastServiceInfo, "", 42, 1, 2, str);
        }
    }

    public void sendSinkKeyRegister(String str, String str2) {
        send(ConnectManager.getInstance().getLastServiceInfo(), str2, 28, 1, 2, str);
    }

    public void sendSinkTouchEvent(String str, String str2) {
        send(ConnectManager.getInstance().getLastServiceInfo(), str2, 11, 1, 2, str);
    }

    public void sendSinkTouchRegister(String str, String str2) {
        send(ConnectManager.getInstance().getLastServiceInfo(), str2, 31, 1, 2, str);
    }

    public void sendStopMicro(String str, int i10) {
        LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manifestVer", 1);
            jSONObject.put("type", i10);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
        send(lastServiceInfo, str, 35, 1, 2, jSONObject.toString());
    }

    public void sendTempRestrict(String str, boolean z10) {
        LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manifestVer", 1);
            jSONObject.put("enable", z10);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
        send(lastServiceInfo, str, 36, 1, 2, jSONObject.toString());
    }

    public void sendVIPQuery(String str) {
        send(ConnectManager.getInstance().getLastServiceInfo(), "", 22, 1, 2, str);
    }

    public void setDanmuProperty(String str) {
        send(ConnectManager.getInstance().getLastServiceInfo(), "", 5, 1, 2, str);
    }

    public void syncLogReport(LelinkServiceInfo lelinkServiceInfo, String str) {
        send(lelinkServiceInfo, "", 21, 1, 2, str);
    }

    public void send(String str, String str2, int i10, int i11, int i12, String str3) {
        DescribeBean describeBean = Creator.getDescribeBean(str, i10, i11, i12);
        describeBean.id = CreateUtil.createPassMsgID();
        String json = describeBean.toJson();
        SourceLog.i(TAG, "send header " + json);
        try {
            String str4 = Pass.PLACEHOLDER_START + json + Pass.PLACEHOLDER_END + Pass.PLACEHOLDER_START + str3 + Pass.PLACEHOLDER_END;
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(0, str4);
            this.mUnconnectedMsg.put(str2, jSONArray.toString());
            SourceLog.i(TAG, "send put value, uid = " + str2 + ", msg = " + str4);
            if (PublicCastClient.getInstance().isConnectedServer()) {
                sendUnconnectedMsgReal();
            } else if (TextUtils.isEmpty(CloudAPI.sImServer)) {
                SourceLog.w(TAG, "connect ignore, invalid im url");
            } else {
                PublicCastClient.getInstance().connectServer(CloudAPI.sImServer, a.a(), new OnConnectIMListener() {
                    public void onConnectFailed() {
                        SourceLog.w(PassSender.TAG, "onConnectFailed.send browser msg failed.");
                    }

                    public void onConnectSuccess() {
                        SourceLog.i(PassSender.TAG, "onConnectSuccess, send browser msg.");
                        PassSender.this.sendUnconnectedMsgReal();
                    }
                });
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, "send browser failed. cause " + e10.getCause());
        }
    }
}
