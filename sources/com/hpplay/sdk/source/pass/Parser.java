package com.hpplay.sdk.source.pass;

import android.text.TextUtils;
import com.hpplay.sdk.source.bean.ChangeHostSetBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.bean.ReceiverProperties;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.business.BusinessEntity;
import com.hpplay.sdk.source.business.cloud.FavoriteDeviceManager;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.bean.ConnectBean;
import com.hpplay.sdk.source.pass.bean.DescribeBean;
import com.hpplay.sdk.source.pass.bean.HarassBean;
import com.hpplay.sdk.source.pass.bean.MirrorStateBean;
import com.hpplay.sdk.source.pass.bean.PassDecoderBean;
import com.hpplay.sdk.source.pass.bean.PlayerRateBean;
import com.hpplay.sdk.source.pass.bean.SinkKeyEventBean;
import com.hpplay.sdk.source.pass.bean.SinkTouchEventInfoBean;
import com.hpplay.sdk.source.pass.sinkkey.SinkKeyEventDispatcher;
import com.hpplay.sdk.source.process.CommonListenerWrapper;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.process.LelinkSdkManager;
import com.hpplay.sdk.source.protocol.connect.ConnectBridge;
import com.hpplay.sdk.source.transceiver.IHostStatusChangeListener;
import com.hpplay.sdk.source.transceiver.IRemoteServerListener;
import com.hpplay.sdk.source.transceiver.ISinkHostSettingChangeListener;
import com.hpplay.sdk.source.transceiver.ISinkNotifySourceCastListener;
import com.hpplay.sdk.source.transceiver.bean.RemoteServerBean;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class Parser {
    private static final String TAG = "Parser";
    private static Parser sInstance;
    private Map<String, SinkBean> mSinkMap = new HashMap();
    private OnSinkTouchEventInfoListener mSinkTouchEventInfoListener;

    public interface OnSinkTouchEventInfoListener {
        void onInfo(SinkTouchEventInfoBean sinkTouchEventInfoBean);
    }

    private Parser() {
    }

    public static synchronized Parser getInstance() {
        Parser parser;
        synchronized (Parser.class) {
            synchronized (Parser.class) {
                if (sInstance == null) {
                    sInstance = new Parser();
                }
            }
            parser = sInstance;
        }
        return parser;
    }

    private SinkBean getSinkBean(String str) {
        SinkBean sinkBean = this.mSinkMap.get(str);
        if (sinkBean != null) {
            return sinkBean;
        }
        SinkBean sinkBean2 = new SinkBean();
        sinkBean2.uid = str;
        return sinkBean2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleAPPMessage(int r6, com.hpplay.sdk.source.pass.bean.DescribeBean r7, java.lang.String r8) {
        /*
            r5 = this;
            java.lang.String r6 = "Parser"
            if (r7 == 0) goto L_0x011a
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L_0x000c
            goto L_0x011a
        L_0x000c:
            int r0 = r7.manifestType
            r1 = -1
            if (r0 == r1) goto L_0x010a
            r2 = 23
            if (r0 == r2) goto L_0x00ed
            r2 = 45
            if (r0 == r2) goto L_0x00d9
            r2 = 3
            r3 = 2
            r4 = 100
            if (r0 == r4) goto L_0x00a1
            r4 = 10000(0x2710, float:1.4013E-41)
            if (r0 == r4) goto L_0x003e
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "handleAPPMessage parse nonsupport msg type: "
            r8.append(r0)
            int r0 = r7.manifestType
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r6, (java.lang.String) r8)
            r1 = 1
            java.lang.String r6 = "Nonsupport message"
            goto L_0x010e
        L_0x003e:
            com.hpplay.sdk.source.pass.bean.PassThirdBean r0 = com.hpplay.sdk.source.pass.bean.PassThirdBean.formJSON(r8)
            if (r0 != 0) goto L_0x004e
            java.lang.String r8 = "handleAPPMessage parse pass failed"
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r6, (java.lang.String) r8)
            java.lang.String r6 = "parse pass failed"
        L_0x004b:
            r1 = 2
            goto L_0x010e
        L_0x004e:
            java.lang.Object r3 = r0.data
            if (r3 != 0) goto L_0x005c
            java.lang.String r8 = "handleAPPMessage parse pass invalid data"
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r6, (java.lang.String) r8)
            java.lang.String r6 = "parse pass invalid data"
        L_0x0059:
            r1 = 3
            goto L_0x010e
        L_0x005c:
            com.hpplay.sdk.source.common.store.Session r2 = com.hpplay.sdk.source.common.store.Session.getInstance()
            java.lang.String r2 = r2.appKey
            java.lang.String r0 = r0.appID
            boolean r0 = android.text.TextUtils.equals(r2, r0)
            if (r0 != 0) goto L_0x0074
            java.lang.String r8 = "handleAPPMessage parse pass unequal appID"
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r6, (java.lang.String) r8)
            r1 = 4
            java.lang.String r6 = "wrong appID"
            goto L_0x010e
        L_0x0074:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "MANIFEST_PASS_THIRD "
            r0.append(r2)
            com.hpplay.sdk.source.process.LelinkSdkManager r2 = com.hpplay.sdk.source.process.LelinkSdkManager.getInstance()
            com.hpplay.sdk.source.api.IRelevantInfoListener r2 = r2.mOuterRelevantInfoListener
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r6, (java.lang.String) r0)
            com.hpplay.sdk.source.process.LelinkSdkManager r6 = com.hpplay.sdk.source.process.LelinkSdkManager.getInstance()
            com.hpplay.sdk.source.api.IRelevantInfoListener r6 = r6.mOuterRelevantInfoListener
            if (r6 == 0) goto L_0x010d
            com.hpplay.sdk.source.process.LelinkSdkManager r6 = com.hpplay.sdk.source.process.LelinkSdkManager.getInstance()
            com.hpplay.sdk.source.api.IRelevantInfoListener r6 = r6.mOuterRelevantInfoListener
            r6.onReverseInfoResult(r4, r8)
            goto L_0x010d
        L_0x00a1:
            boolean r0 = com.hpplay.sdk.source.utils.Feature.isLeboApp()
            if (r0 != 0) goto L_0x00ad
            java.lang.String r8 = "MANIFEST_PASS_LEBO ignore,not lebo app"
            com.hpplay.sdk.source.log.SourceLog.i(r6, r8)
            goto L_0x010d
        L_0x00ad:
            com.hpplay.sdk.source.pass.bean.PassLeboBean r0 = com.hpplay.sdk.source.pass.bean.PassLeboBean.formJSON(r8)
            if (r0 != 0) goto L_0x00bb
            java.lang.String r8 = "handleAPPMessage, parse pass lebo failed"
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r6, (java.lang.String) r8)
            java.lang.String r6 = "parse pass lebo failed"
            goto L_0x004b
        L_0x00bb:
            java.lang.Object r0 = r0.data
            if (r0 != 0) goto L_0x00c7
            java.lang.String r8 = "handleAPPMessage, parse pass lebo invalid data"
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r6, (java.lang.String) r8)
            java.lang.String r6 = "parse pass lebo invalid data"
            goto L_0x0059
        L_0x00c7:
            com.hpplay.sdk.source.process.LelinkSdkManager r6 = com.hpplay.sdk.source.process.LelinkSdkManager.getInstance()
            com.hpplay.sdk.source.api.IRelevantInfoListener r6 = r6.mOuterRelevantInfoListener
            if (r6 == 0) goto L_0x010d
            com.hpplay.sdk.source.process.LelinkSdkManager r6 = com.hpplay.sdk.source.process.LelinkSdkManager.getInstance()
            com.hpplay.sdk.source.api.IRelevantInfoListener r6 = r6.mOuterRelevantInfoListener
            r6.onReverseInfoResult(r4, r8)
            goto L_0x010d
        L_0x00d9:
            com.hpplay.sdk.source.process.LelinkSdkManager r6 = com.hpplay.sdk.source.process.LelinkSdkManager.getInstance()
            com.hpplay.sdk.source.api.IRelevantInfoListener r6 = r6.mOuterRelevantInfoListener
            if (r6 == 0) goto L_0x010d
            com.hpplay.sdk.source.process.LelinkSdkManager r6 = com.hpplay.sdk.source.process.LelinkSdkManager.getInstance()
            com.hpplay.sdk.source.api.IRelevantInfoListener r6 = r6.mOuterRelevantInfoListener
            int r0 = r7.manifestType
            r6.onReverseInfoResult(r0, r8)
            goto L_0x010d
        L_0x00ed:
            com.hpplay.sdk.source.process.LelinkSdkManager r6 = com.hpplay.sdk.source.process.LelinkSdkManager.getInstance()
            com.hpplay.sdk.source.api.IRelevantInfoListener r6 = r6.mOuterRelevantInfoListener
            if (r6 == 0) goto L_0x0100
            com.hpplay.sdk.source.process.LelinkSdkManager r6 = com.hpplay.sdk.source.process.LelinkSdkManager.getInstance()
            com.hpplay.sdk.source.api.IRelevantInfoListener r6 = r6.mOuterRelevantInfoListener
            int r0 = r7.manifestType
            r6.onReverseInfoResult(r0, r8)
        L_0x0100:
            com.hpplay.sdk.source.business.cloud.RightsManager r6 = com.hpplay.sdk.source.business.cloud.RightsManager.getInstance()
            java.lang.String r0 = r7.uid
            r6.handleRightMessage(r0, r8)
            goto L_0x010d
        L_0x010a:
            r5.handleErrorMessage(r7, r8)
        L_0x010d:
            r6 = 0
        L_0x010e:
            if (r1 <= 0) goto L_0x0119
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 != 0) goto L_0x0119
            r5.sendErrorMessage(r7, r1, r6)
        L_0x0119:
            return
        L_0x011a:
            java.lang.String r7 = "handleAPPMessage invalid input"
            com.hpplay.sdk.source.log.SourceLog.i(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.pass.Parser.handleAPPMessage(int, com.hpplay.sdk.source.pass.bean.DescribeBean, java.lang.String):void");
    }

    private void handleErrorMessage(DescribeBean describeBean, String str) {
        SourceLog.w(TAG, "handleErrorMessage " + str);
    }

    private void handleSDKMessage(int i10, DescribeBean describeBean, String str) {
        ConnectBean connectBean;
        ChangeHostSetBean formJson;
        if (describeBean == null || TextUtils.isEmpty(str)) {
            SourceLog.i(TAG, "handleSDKMessage invalid input");
            return;
        }
        SinkBean sinkBean = getSinkBean(describeBean.uid);
        String str2 = null;
        int i11 = 1;
        switch (describeBean.manifestType) {
            case -1:
                handleErrorMessage(describeBean, str);
                break;
            case 4:
                sinkBean.connectBean = ConnectBean.formJson(str);
                ConnectBridge connectBridge = ConnectManager.getInstance().getConnectBridge(describeBean.uid);
                if (!(connectBridge == null || (connectBean = sinkBean.connectBean) == null)) {
                    connectBridge.setSinkSM(connectBean.sm);
                    connectBridge.saveConnectBean(str);
                }
                SourceLog.i(TAG, "handleSDKMessage parse receive connect " + str);
                if (LelinkSdkManager.getInstance().mOuterRelevantInfoListener != null) {
                    LelinkSdkManager.getInstance().mOuterRelevantInfoListener.onReverseInfoResult(describeBean.manifestType, str);
                    break;
                }
                break;
            case 11:
                SinkTouchEventInfoBean fromJson = SinkTouchEventInfoBean.fromJson(str);
                if (fromJson == null) {
                    SourceLog.w(TAG, "handleSDKMessage: sinkTouchEventInfoBean is null");
                } else {
                    ConnectBridge connectBridge2 = ConnectManager.getInstance().getConnectBridge(describeBean.uid);
                    if (!(connectBridge2 == null || connectBridge2.getServiceInfo() == null || TextUtils.isEmpty(connectBridge2.getServiceInfo().getIp()))) {
                        fromJson.ip = connectBridge2.getServiceInfo().getIp();
                    }
                    SourceLog.i(TAG, "handleSDKMessage: sinkTouchEventInfoBean : " + fromJson.toString());
                    sinkBean.sinkTouchEventInfoBean = fromJson;
                }
                OnSinkTouchEventInfoListener onSinkTouchEventInfoListener = this.mSinkTouchEventInfoListener;
                if (onSinkTouchEventInfoListener != null) {
                    onSinkTouchEventInfoListener.onInfo(fromJson);
                    break;
                }
                break;
            case 14:
                sinkBean.decoderBean = PassDecoderBean.formJson(str);
                break;
            case 16:
                PlayerRateBean formJson2 = PlayerRateBean.formJson(str);
                if (formJson2 != null) {
                    SourceLog.i(TAG, "handleSDKMessage parse MANIFEST_RATE_QUERY_REPLY " + formJson2.rate);
                    if (BusinessEntity.getInstance().getListenerDispatcher() != null) {
                        BusinessEntity.getInstance().getListenerDispatcher().onInfo((OutParameter) null, 16, String.valueOf(formJson2.rate));
                        break;
                    }
                } else {
                    SourceLog.i(TAG, "handleSDKMessage parse MANIFEST_RATE_QUERY_REPLY ignore ");
                    break;
                }
                break;
            case 26:
                SourceLog.i(TAG, "handleSDKMessage parse mirror state");
                MirrorStateBean fromJson2 = MirrorStateBean.fromJson(str);
                if (fromJson2 != null) {
                    ConnectManager.getInstance().getLastConnectBridge().notifyPassReceivedData(describeBean.manifestType, fromJson2);
                    break;
                } else {
                    SourceLog.i(TAG, "handleSDKMessage parse mirror state failed");
                    return;
                }
            case 29:
                SinkKeyEventBean fromJson3 = SinkKeyEventBean.fromJson(str);
                if (fromJson3 != null) {
                    SourceLog.i(TAG, "handleAPPMessage: sinkKeyEventBean keyCode: " + fromJson3.keyCode + " action: " + fromJson3.action);
                    SinkKeyEventDispatcher.getInstance().handleEvent(fromJson3.keyCode, fromJson3.action);
                    break;
                } else {
                    SourceLog.w(TAG, "handleSDKMessage: sinkKeyEventBean is null");
                    break;
                }
            case 34:
                if (LelinkSdkManager.getInstance().mOuterRelevantInfoListener != null) {
                    LelinkSdkManager.getInstance().mOuterRelevantInfoListener.onReverseInfoResult(describeBean.manifestType, str);
                    break;
                }
                break;
            case 37:
                PlayerRateBean formJson3 = PlayerRateBean.formJson(str);
                if (formJson3 != null) {
                    SourceLog.i(TAG, "handleSDKMessage parse MANIFEST_RATE_UPDATE " + formJson3.rate);
                    if (BusinessEntity.getInstance().getListenerDispatcher() != null) {
                        BusinessEntity.getInstance().getListenerDispatcher().onInfo((OutParameter) null, 37, String.valueOf(formJson3.rate));
                        break;
                    }
                } else {
                    SourceLog.i(TAG, "handleSDKMessage parse MANIFEST_RATE_UPDATE ignore ");
                    break;
                }
                break;
            case 40:
                IRemoteServerListener remoteServerListener = CommonListenerWrapper.getInstance().getRemoteServerListener();
                SourceLog.w(TAG, "MANIFEST_NOTIFY_REMOTE_REPLAY " + remoteServerListener);
                if (remoteServerListener != null) {
                    try {
                        int optInt = new JSONObject(str).optInt("result");
                        if (optInt != 1) {
                            remoteServerListener.onServerFailed(optInt);
                            break;
                        } else {
                            remoteServerListener.onServerStarted(RemoteServerBean.formJson(str));
                            break;
                        }
                    } catch (Exception e10) {
                        SourceLog.w(TAG, (Throwable) e10);
                        break;
                    }
                }
                break;
            case 41:
                IHostStatusChangeListener hostStatusChangeListener = CommonListenerWrapper.getInstance().getHostStatusChangeListener();
                if (hostStatusChangeListener != null) {
                    try {
                        int optInt2 = new JSONObject(str).optInt("action");
                        if (optInt2 != 1) {
                            if (optInt2 == 0) {
                                hostStatusChangeListener.onHostChange(false);
                                break;
                            }
                        } else {
                            hostStatusChangeListener.onHostChange(true);
                            break;
                        }
                    } catch (Exception e11) {
                        SourceLog.w(TAG, (Throwable) e11);
                        break;
                    }
                }
                break;
            case 42:
                ISinkHostSettingChangeListener sinkHostSettingChangeListener = CommonListenerWrapper.getInstance().getSinkHostSettingChangeListener();
                if (!(sinkHostSettingChangeListener == null || (formJson = ChangeHostSetBean.formJson(str)) == null)) {
                    SourceLog.i(TAG, "MANIFEST_SOURCE_HOST_SET " + formJson.action + " " + formJson.value);
                    int i12 = formJson.action;
                    if (i12 != 1) {
                        if (i12 == 2) {
                            sinkHostSettingChangeListener.onReverseCastSetting(formJson.value);
                            break;
                        }
                    } else {
                        sinkHostSettingChangeListener.onCastSetting(formJson.value);
                        break;
                    }
                }
                break;
            case 43:
                ISinkNotifySourceCastListener sinkNotifySourceCastListener = CommonListenerWrapper.getInstance().getSinkNotifySourceCastListener();
                if (sinkNotifySourceCastListener != null) {
                    try {
                        sinkNotifySourceCastListener.onSinkNotifySourceCast(new JSONObject(str).optInt("action"));
                        break;
                    } catch (Exception e12) {
                        SourceLog.w(TAG, (Throwable) e12);
                        break;
                    }
                }
                break;
            case 46:
                HarassBean formJson4 = HarassBean.formJson(str);
                if (formJson4 != null) {
                    SourceLog.i(TAG, "msg type: " + describeBean.manifestType + " , harass timeout = " + formJson4.timeout);
                    HarassCode.getInstance().setHarass(formJson4.code, formJson4.timeout);
                    if (BusinessEntity.getInstance().getListenerDispatcher() != null) {
                        BusinessEntity.getInstance().getListenerDispatcher().onInfo((OutParameter) null, 46, String.valueOf(formJson4.timeout));
                        break;
                    }
                }
                break;
            case 51:
                if (LelinkSdkManager.getInstance().mReceiverPropertiesCallback != null) {
                    LelinkSdkManager.getInstance().mReceiverPropertiesCallback.callback(ReceiverProperties.fromJson(str));
                    break;
                }
                break;
            case 53:
                SourceLog.i(TAG, "MANIFEST_FAVORITE_DEV_RESPONSE " + str);
                try {
                    if (new JSONObject(str).optInt("result") != 1) {
                        FavoriteDeviceManager.getInstance().onAddCallback(false, -110);
                        break;
                    } else {
                        LelinkServiceInfo lelinkServiceInfo = ConnectManager.getInstance().getLelinkServiceInfo(describeBean.uid);
                        if (lelinkServiceInfo != null) {
                            FavoriteDeviceManager.getInstance().addFavoriteDeviceAfterConfirm(lelinkServiceInfo);
                            break;
                        }
                    }
                } catch (Exception e13) {
                    SourceLog.w(TAG, (Throwable) e13);
                    break;
                }
                break;
            case 100:
                SourceLog.i(TAG, "handleSDKMessage sdk pass lebo msg ignore");
                break;
            case 10000:
                SourceLog.w(TAG, "handleSDKMessage parse pass msg ignore");
                break;
            default:
                SourceLog.w(TAG, "handleSDKMessage parse nonsupport msg type: " + describeBean.manifestType);
                str2 = "Nonsupport message";
                break;
        }
        i11 = -1;
        this.mSinkMap.put(describeBean.uid, sinkBean);
        if (i11 > 0 && !TextUtils.isEmpty(str2)) {
            sendErrorMessage(describeBean, i11, str2);
        }
    }

    private void parse(int i10, DescribeBean describeBean, String str) {
        if (TextUtils.isEmpty(str)) {
            SourceLog.i(TAG, "parse invalid input");
        } else if (describeBean == null) {
            SourceLog.w(TAG, "parse describeBean failed");
        } else if (!TextUtils.isEmpty(describeBean.uid) || !TextUtils.isEmpty(describeBean.cuid)) {
            int i11 = describeBean.handler;
            if (i11 == 1 || i11 == 2) {
                SourceLog.i(TAG, "parse " + describeBean.manifestType + " / " + str);
                SourceLog.i(TAG, "parse ");
                if (describeBean.handler == 2) {
                    handleSDKMessage(i10, describeBean, str);
                } else {
                    handleAPPMessage(i10, describeBean, str);
                }
            } else {
                SourceLog.w(TAG, "parse describeBean invalid handler");
            }
        } else {
            SourceLog.w(TAG, "parse describeBean miss uid");
        }
    }

    private void sendErrorMessage(DescribeBean describeBean, int i10, String str) {
        SourceLog.w(TAG, "sendErrorMessage " + str);
    }

    public ConnectBean getConnectBean(String str) {
        ConnectBean connectBean;
        SinkBean sinkBean = getSinkBean(str);
        if (sinkBean == null || (connectBean = sinkBean.connectBean) == null) {
            return null;
        }
        return connectBean;
    }

    public void parseByLocalCast(DescribeBean describeBean, String str) {
        if (describeBean == null || TextUtils.isEmpty(str)) {
            SourceLog.w(TAG, "parseByLocalCast invalid input");
        } else {
            parse(1, describeBean, str);
        }
    }

    public void parseByNetCast(String str) {
        String[] split = str.split(Pass.PLACEHOLDER_END);
        DescribeBean describeBean = null;
        for (int i10 = 0; i10 < split.length; i10++) {
            if (TextUtils.isEmpty(split[i10]) || !split[i10].startsWith(Pass.PLACEHOLDER_START)) {
                SourceLog.w(TAG, "parseByNetCast invalid msg at " + i10);
                return;
            }
            if (i10 == 0) {
                describeBean = DescribeBean.formJson(split[i10].substring(6));
                if (describeBean == null) {
                    SourceLog.w(TAG, "parseByNetCast describeBean failed");
                    return;
                } else if (!TextUtils.isEmpty(describeBean.uid) || !TextUtils.isEmpty(describeBean.cuid)) {
                    int i11 = describeBean.handler;
                    if (!(i11 == 1 || i11 == 2)) {
                        sendErrorMessage(describeBean, 5, "wrong handler");
                        return;
                    }
                } else {
                    SourceLog.w(TAG, "parseByNetCast describeBean miss cuid");
                    return;
                }
            } else if (i10 == 1) {
                parse(2, describeBean, split[i10].substring(6));
            }
        }
    }

    public void setOnSinkTouchEventInfoListener(OnSinkTouchEventInfoListener onSinkTouchEventInfoListener) {
        this.mSinkTouchEventInfoListener = onSinkTouchEventInfoListener;
    }
}
