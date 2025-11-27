package org.android.agoo.control;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalConfig;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.j;
import com.taobao.accs.utl.k;
import com.umeng.message.component.UmengMessageHandlerService;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.common.MsgDO;
import org.json.JSONObject;

public class NotifManager {
    private static final String ACK_MESSAGE = "accs.ackMessage";
    private static final int EVENT_ID = 66001;
    private static final String TAG = "NotifManager";
    /* access modifiers changed from: private */
    public Context mContext = null;

    private byte[] convertMsgToBytes(MsgDO msgDO) {
        HashMap hashMap = new HashMap();
        hashMap.put("api", "agooReport");
        hashMap.put("id", msgDO.msgIds + "@" + msgDO.messageSource);
        hashMap.put("ext", msgDO.extData);
        hashMap.put(Constant.KEY_STATUS, msgDO.msgStatus);
        if (!TextUtils.isEmpty(msgDO.errorCode)) {
            hashMap.put("ec", msgDO.errorCode);
        }
        if (!TextUtils.isEmpty(msgDO.type)) {
            hashMap.put("type", msgDO.type);
        }
        if (!TextUtils.isEmpty(msgDO.fromPkg)) {
            hashMap.put("fromPkg", msgDO.fromPkg);
        }
        if (!TextUtils.isEmpty(msgDO.fromAppkey)) {
            hashMap.put(AgooConstants.MESSAGE_FROM_APPKEY, msgDO.fromAppkey);
        }
        if (!TextUtils.isEmpty(msgDO.notifyEnable)) {
            hashMap.put("notifyEnable", msgDO.notifyEnable);
        }
        if (!TextUtils.isEmpty(msgDO.extData)) {
            hashMap.put("ext", msgDO.extData);
        }
        hashMap.put("isStartProc", Boolean.toString(msgDO.isStartProc));
        hashMap.put("appkey", Config.a(this.mContext));
        hashMap.put("utdid", j.b(this.mContext));
        hashMap.put("evokeAppStatus", String.valueOf(msgDO.evokeAppStatus));
        hashMap.put("lastActiveTime", String.valueOf(msgDO.lastActiveTime));
        hashMap.put("isGlobalClick", String.valueOf(msgDO.isGlobalClick));
        return new JSONObject(hashMap).toString().getBytes("UTF-8");
    }

    private void reportMethod(MsgDO msgDO, TaoBaseService.ExtraInfo extraInfo) {
        if (msgDO == null) {
            try {
                ALog.e(TAG, "reportMethod msg null", new Object[0]);
            } catch (Throwable th) {
                k.a("accs", "error", th.toString(), 0.0d);
            }
        } else {
            ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest((String) null, AgooConstants.AGOO_SERVICE_AGOOACK, convertMsgToBytes(msgDO), (String) null, (String) null, (URL) null, (String) null);
            accsRequest.setTag(msgDO.msgIds);
            Context context = this.mContext;
            String a10 = ACCSManager.getAccsInstance(context, Config.a(context), Config.c(this.mContext)).a(this.mContext, accsRequest, extraInfo);
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.e(TAG, AgooConstants.MESSAGE_REPORT, Constants.KEY_DATA_ID, a10, Constant.KEY_STATUS, msgDO.msgStatus, "errorcode", msgDO.errorCode);
            }
        }
    }

    public void doUninstall(String str, boolean z10) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("pack", str);
            hashMap.put("appkey", Config.a(this.mContext));
            hashMap.put("utdid", j.b(this.mContext));
            ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest((String) null, "agooKick", new JSONObject(hashMap).toString().getBytes("UTF-8"), (String) null, (String) null, (URL) null, (String) null);
            Context context = this.mContext;
            ACCSManager.getAccsInstance(context, Config.a(context), Config.c(this.mContext)).a(this.mContext, accsRequest, new TaoBaseService.ExtraInfo());
        } catch (Throwable th) {
            ALog.e(TAG, "[doUninstall] is error", th, new Object[0]);
        }
    }

    public void handlerACKMessage(MsgDO msgDO, TaoBaseService.ExtraInfo extraInfo) {
        MsgDO msgDO2 = msgDO;
        if (msgDO2 != null) {
            if (!TextUtils.isEmpty(msgDO2.msgIds) || !TextUtils.isEmpty(msgDO2.removePacks) || !TextUtils.isEmpty(msgDO2.errorCode)) {
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("api", AgooConstants.AGOO_SERVICE_AGOOACK);
                    hashMap.put("id", msgDO2.msgIds + "@" + msgDO2.messageSource);
                    if (!TextUtils.isEmpty(msgDO2.removePacks)) {
                        hashMap.put("del_pack", msgDO2.removePacks);
                    }
                    if (!TextUtils.isEmpty(msgDO2.errorCode)) {
                        hashMap.put("ec", msgDO2.errorCode);
                    }
                    if (!TextUtils.isEmpty(msgDO2.type)) {
                        hashMap.put("type", msgDO2.type);
                    }
                    if (!TextUtils.isEmpty(msgDO2.extData)) {
                        hashMap.put("ext", msgDO2.extData);
                    }
                    hashMap.put("appkey", Config.a(this.mContext));
                    hashMap.put("utdid", j.b(this.mContext));
                    byte[] bytes = new JSONObject(hashMap).toString().getBytes("UTF-8");
                    UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ACK_MESSAGE, j.b(this.mContext), "handlerACKMessageSendData", msgDO2.msgIds);
                    k.a("accs", BaseMonitor.COUNT_AGOO_ACK, "handlerACKMessage", 0.0d);
                    ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest((String) null, AgooConstants.AGOO_SERVICE_AGOOACK, bytes, (String) null, (String) null, (URL) null, (String) null);
                    accsRequest.setTag(msgDO2.msgIds);
                    Context context = this.mContext;
                    String a10 = ACCSManager.getAccsInstance(context, Config.a(context), Config.c(this.mContext)).a(this.mContext, accsRequest, extraInfo);
                    ALog.i(TAG, "handlerACKMessage,endRequest,dataId=" + a10, new Object[0]);
                } catch (Throwable th) {
                    if (ALog.isPrintLog(ALog.Level.E)) {
                        ALog.e(TAG, "handlerACKMessage Throwable,msgIds=" + msgDO2.msgIds + ",type=" + msgDO2.type + ",e=" + th.toString(), new Object[0]);
                    }
                    UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ACK_MESSAGE, j.b(this.mContext), "handlerACKMessageExceptionFailed", th.toString());
                }
            } else {
                UTMini instance = UTMini.getInstance();
                String b10 = j.b(this.mContext);
                instance.commitEvent(AgooConstants.AGOO_EVENT_ID, ACK_MESSAGE, b10, "handlerACKMessageRetuen", "msgids=" + msgDO2.msgIds + ",removePacks=" + msgDO2.removePacks + ",errorCode=" + msgDO2.errorCode);
            }
        }
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void pingApp(String str, String str2, String str3, int i10) {
    }

    public void report(MsgDO msgDO, TaoBaseService.ExtraInfo extraInfo) {
        if (!TextUtils.isEmpty(msgDO.reportStr)) {
            try {
                if (Integer.parseInt(msgDO.reportStr) >= -1) {
                    reportMethod(msgDO, extraInfo);
                    if (!msgDO.isFromCache) {
                        k.a("accs", BaseMonitor.COUNT_AGOO_ACK, msgDO.msgStatus, 0.0d);
                    }
                }
            } catch (Throwable th) {
                ALog.e(TAG, "[report] is error", th, new Object[0]);
            }
        }
    }

    public void reportNotifyMessage(MsgDO msgDO) {
        MsgDO msgDO2 = msgDO;
        if (msgDO2 != null) {
            try {
                k.a("accs", BaseMonitor.COUNT_AGOO_REPORT_ID, msgDO2.msgIds, 0.0d);
                ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest((String) null, AgooConstants.AGOO_SERVICE_AGOOACK, convertMsgToBytes(msgDO), (String) null, (String) null, (URL) null, (String) null);
                Context context = this.mContext;
                ACCSManager.getAccsInstance(context, Config.a(context), Config.c(this.mContext)).a(this.mContext, accsRequest, (TaoBaseService.ExtraInfo) null);
                if (ALog.isPrintLog(ALog.Level.E)) {
                    ALog.e(TAG, "reportNotifyMessage", Constants.KEY_DATA_ID, accsRequest.dataId, Constant.KEY_STATUS, msgDO2.msgStatus);
                }
                k.a("accs", BaseMonitor.COUNT_AGOO_CLICK, msgDO2.msgStatus, 0.0d);
                k.a("accs", BaseMonitor.COUNT_AGOO_ACK, msgDO2.msgStatus, 0.0d);
            } catch (Throwable th) {
                ALog.e(TAG, "[reportNotifyMessage] is error", th, new Object[0]);
                k.a("accs", "error", th.toString(), 0.0d);
            }
        }
    }

    public void reportThirdPushToken(String str, String str2, boolean z10) {
        reportThirdPushToken(str, str2, (String) null, z10);
    }

    public void reportThirdPushToken(String str, String str2, String str3, boolean z10) {
        ThreadPoolExecutorFactory.schedule(new l(this, str2, str, str3, z10), (long) GlobalConfig.getReportThirdTokenDelay(), TimeUnit.SECONDS);
        Class<UmengMessageHandlerService> cls = UmengMessageHandlerService.class;
        try {
            int i10 = UmengMessageHandlerService.f15221b;
            Intent intent = new Intent("com.umeng.message.action");
            intent.setPackage(this.mContext.getPackageName());
            intent.setClass(this.mContext, cls);
            intent.putExtra("um_command", "third_token");
            intent.putExtra("third_token", str);
            intent.putExtra("type", str2);
            cls.getMethod("enqueueWork", new Class[]{Context.class, Class.class, Intent.class}).invoke((Object) null, new Object[]{this.mContext, cls, intent});
        } catch (Throwable th) {
            ALog.e(TAG, "report push token error", th, new Object[0]);
        }
    }

    public void reportThirdPushToken(String str, String str2) {
        reportThirdPushToken(str, str2, true);
    }
}
