package org.android.agoo.control;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
import com.taobao.accs.client.a;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.t;
import com.taobao.accs.utl.v;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.intent.IntentUtil;
import org.android.agoo.message.MessageService;

public abstract class BaseIntentService extends Service {
    private static final String TAG = "BaseIntentService";
    private static boolean isBinded = false;
    private static final String msgStatus = "4";
    /* access modifiers changed from: private */
    public AgooFactory agooFactory;
    private Context mContext = null;
    /* access modifiers changed from: private */
    public MessageService messageService;
    private Messenger messenger = new Messenger(new g(this));
    /* access modifiers changed from: private */
    public NotifManager notifyManager;

    private final String getTrace(Context context, long j10) {
        String str;
        String str2 = null;
        if (TextUtils.isEmpty((CharSequence) null)) {
            str = "unknow";
        } else {
            str = null;
        }
        if (TextUtils.isEmpty((CharSequence) null)) {
            str2 = "unknow";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appkey");
        stringBuffer.append("|");
        stringBuffer.append(j10);
        stringBuffer.append("|");
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append("|");
        stringBuffer.append(str);
        stringBuffer.append("|");
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:126:0x02f4 */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x029d A[Catch:{ Exception -> 0x0361, all -> 0x036e }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02d8 A[Catch:{ all -> 0x02f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02e7 A[Catch:{ all -> 0x02f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0356 A[Catch:{ Exception -> 0x0361, all -> 0x036e }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cf A[Catch:{ all -> 0x0370 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0137 A[Catch:{ all -> 0x0370 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0187 A[Catch:{ all -> 0x0370 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0206 A[Catch:{ Exception -> 0x0361, all -> 0x036e }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0239 A[Catch:{ Exception -> 0x0361, all -> 0x036e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleRemoteMessage(android.content.Context r35, android.content.Intent r36) {
        /*
            r34 = this;
            r1 = r34
            r2 = r36
            java.lang.String r3 = "1"
            java.lang.String r4 = "messageId="
            java.lang.String r5 = "fromAppkey"
            java.lang.String r6 = "source"
            java.lang.String r7 = "body"
            java.lang.String r8 = "agoo_arrive"
            java.lang.String r9 = "accs"
            java.lang.String r10 = "BaseIntentService"
            java.lang.String r0 = "id"
            java.lang.String r13 = r2.getStringExtra(r0)     // Catch:{ all -> 0x037b }
            java.lang.String r14 = r2.getStringExtra(r7)     // Catch:{ all -> 0x037b }
            java.lang.String r0 = "type"
            java.lang.String r15 = r2.getStringExtra(r0)     // Catch:{ all -> 0x037b }
            java.lang.String r0 = "message_source"
            java.lang.String r11 = r2.getStringExtra(r0)     // Catch:{ all -> 0x037b }
            java.lang.String r0 = "report"
            java.lang.String r12 = r2.getStringExtra(r0)     // Catch:{ all -> 0x037b }
            java.lang.String r0 = "encrypted"
            r16 = r15
            java.lang.String r15 = r2.getStringExtra(r0)     // Catch:{ all -> 0x037b }
            java.lang.String r0 = "extData"
            r17 = r3
            java.lang.String r3 = r2.getStringExtra(r0)     // Catch:{ all -> 0x037b }
            java.lang.String r0 = "oriData"
            r18 = r8
            java.lang.String r8 = r2.getStringExtra(r0)     // Catch:{ all -> 0x0376 }
            r19 = 0
            r20 = r9
            java.lang.String r0 = "trace"
            r21 = r10
            r9 = -1
            long r9 = r2.getLongExtra(r0, r9)     // Catch:{ all -> 0x0094 }
            java.lang.Long r0 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x0094 }
            long r9 = r0.longValue()     // Catch:{ all -> 0x0094 }
            r23 = r4
            r4 = r35
            r1.getTrace(r4, r9)     // Catch:{ all -> 0x0092 }
            java.lang.String r0 = "msg_agoo_bundle"
            android.os.Bundle r0 = r2.getBundleExtra(r0)     // Catch:{ all -> 0x0092 }
            if (r0 == 0) goto L_0x0077
            java.lang.String r9 = "accs_extra"
            java.io.Serializable r0 = r0.getSerializable(r9)     // Catch:{ all -> 0x0092 }
            com.taobao.accs.base.TaoBaseService$ExtraInfo r0 = (com.taobao.accs.base.TaoBaseService.ExtraInfo) r0     // Catch:{ all -> 0x0092 }
            r9 = r0
            goto L_0x0079
        L_0x0077:
            r9 = r19
        L_0x0079:
            java.lang.String r10 = r2.getStringExtra(r6)     // Catch:{ all -> 0x008e }
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x008c }
            if (r0 == 0) goto L_0x0085
            java.lang.String r10 = "oldsdk"
        L_0x0085:
            java.lang.String r0 = r2.getStringExtra(r5)     // Catch:{ all -> 0x008c }
            r4 = r21
            goto L_0x00c1
        L_0x008c:
            r0 = move-exception
            goto L_0x00a2
        L_0x008e:
            r0 = move-exception
            r10 = r19
            goto L_0x00a2
        L_0x0092:
            r0 = move-exception
            goto L_0x009f
        L_0x0094:
            r0 = move-exception
            r23 = r4
            goto L_0x009d
        L_0x0098:
            r0 = move-exception
            r23 = r4
            r21 = r10
        L_0x009d:
            r4 = r35
        L_0x009f:
            r9 = r19
            r10 = r9
        L_0x00a2:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0370 }
            r4.<init>()     // Catch:{ all -> 0x0370 }
            r24 = r9
            java.lang.String r9 = "_trace,t="
            r4.append(r9)     // Catch:{ all -> 0x0370 }
            r4.append(r0)     // Catch:{ all -> 0x0370 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0370 }
            r4 = 0
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x0370 }
            r4 = r21
            com.taobao.accs.utl.ALog.e(r4, r0, r9)     // Catch:{ all -> 0x0370 }
            r0 = r19
            r9 = r24
        L_0x00c1:
            com.taobao.accs.utl.ALog$Level r21 = com.taobao.accs.utl.ALog.Level.I     // Catch:{ all -> 0x0370 }
            boolean r21 = com.taobao.accs.utl.ALog.isPrintLog(r21)     // Catch:{ all -> 0x0370 }
            r24 = 4
            r25 = r8
            r26 = 1
            if (r21 == 0) goto L_0x010e
            java.lang.String r8 = "handleRemoteMessage"
            r2 = 12
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0370 }
            java.lang.String r27 = "message"
            r22 = 0
            r2[r22] = r27     // Catch:{ all -> 0x0370 }
            r2[r26] = r14     // Catch:{ all -> 0x0370 }
            r21 = 2
            r2[r21] = r6     // Catch:{ all -> 0x0370 }
            r6 = 3
            r2[r6] = r11     // Catch:{ all -> 0x0370 }
            java.lang.String r6 = "msgId"
            r2[r24] = r6     // Catch:{ all -> 0x0370 }
            r6 = 5
            r2[r6] = r13     // Catch:{ all -> 0x0370 }
            java.lang.String r6 = "utdid"
            r27 = 6
            r2[r27] = r6     // Catch:{ all -> 0x0370 }
            java.lang.String r6 = com.taobao.accs.utl.j.b(r35)     // Catch:{ all -> 0x0370 }
            r27 = 7
            r2[r27] = r6     // Catch:{ all -> 0x0370 }
            java.lang.String r6 = "fromPkg"
            r27 = 8
            r2[r27] = r6     // Catch:{ all -> 0x0370 }
            r6 = 9
            r2[r6] = r10     // Catch:{ all -> 0x0370 }
            r6 = 10
            r2[r6] = r5     // Catch:{ all -> 0x0370 }
            r5 = 11
            r2[r5] = r0     // Catch:{ all -> 0x0370 }
            com.taobao.accs.utl.ALog.i(r4, r8, r2)     // Catch:{ all -> 0x0370 }
        L_0x010e:
            org.android.agoo.common.MsgDO r2 = new org.android.agoo.common.MsgDO     // Catch:{ all -> 0x0370 }
            r2.<init>()     // Catch:{ all -> 0x0370 }
            r2.msgIds = r13     // Catch:{ all -> 0x0370 }
            r2.extData = r3     // Catch:{ all -> 0x0370 }
            r2.messageSource = r11     // Catch:{ all -> 0x0370 }
            java.lang.String r3 = "4"
            r2.msgStatus = r3     // Catch:{ all -> 0x0370 }
            r2.reportStr = r12     // Catch:{ all -> 0x0370 }
            r2.fromPkg = r10     // Catch:{ all -> 0x0370 }
            r2.fromAppkey = r0     // Catch:{ all -> 0x0370 }
            boolean r0 = com.taobao.accs.client.a.c()     // Catch:{ all -> 0x0370 }
            r2.isStartProc = r0     // Catch:{ all -> 0x0370 }
            android.content.Context r0 = r1.mContext     // Catch:{ all -> 0x0370 }
            java.lang.String r0 = com.taobao.accs.utl.j.c(r0)     // Catch:{ all -> 0x0370 }
            r2.notifyEnable = r0     // Catch:{ all -> 0x0370 }
            boolean r0 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x0370 }
            if (r0 != 0) goto L_0x016f
            java.lang.String r0 = java.lang.Integer.toString(r24)     // Catch:{ all -> 0x0370 }
            boolean r0 = r0.equals(r15)     // Catch:{ all -> 0x0370 }
            if (r0 == 0) goto L_0x015d
            java.lang.String r0 = "message is encrypted, attemp to decrypt msg"
            r3 = 0
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ all -> 0x0370 }
            com.taobao.accs.utl.ALog.i(r4, r0, r5)     // Catch:{ all -> 0x0370 }
            java.lang.String r14 = org.android.agoo.control.AgooFactory.parseEncryptedMsg(r14)     // Catch:{ all -> 0x0370 }
            boolean r0 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x0370 }
            if (r0 == 0) goto L_0x016f
            java.lang.String r0 = "22"
            r2.errorCode = r0     // Catch:{ all -> 0x0370 }
            org.android.agoo.control.NotifManager r0 = r1.notifyManager     // Catch:{ all -> 0x0370 }
            r0.handlerACKMessage(r2, r9)     // Catch:{ all -> 0x0370 }
            return
        L_0x015d:
            java.lang.String r0 = "msg encrypted flag not exist~~"
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0370 }
            com.taobao.accs.utl.ALog.e(r4, r0, r3)     // Catch:{ all -> 0x0370 }
            java.lang.String r0 = "24"
            r2.errorCode = r0     // Catch:{ all -> 0x016e }
            org.android.agoo.control.NotifManager r0 = r1.notifyManager     // Catch:{ all -> 0x016e }
            r0.report(r2, r9)     // Catch:{ all -> 0x016e }
        L_0x016e:
            return
        L_0x016f:
            boolean r0 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x0370 }
            if (r0 == 0) goto L_0x0187
            java.lang.String r0 = "21"
            r2.errorCode = r0     // Catch:{ all -> 0x017e }
            org.android.agoo.control.NotifManager r0 = r1.notifyManager     // Catch:{ all -> 0x017e }
            r0.report(r2, r9)     // Catch:{ all -> 0x017e }
        L_0x017e:
            java.lang.String r0 = "handleMessage--->[null]"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0370 }
            com.taobao.accs.utl.ALog.e(r4, r0, r2)     // Catch:{ all -> 0x0370 }
            return
        L_0x0187:
            r3 = r36
            r3.putExtra(r7, r14)     // Catch:{ all -> 0x0370 }
            org.android.agoo.control.NotifManager r0 = r1.notifyManager     // Catch:{ all -> 0x01dc }
            r0.report(r2, r9)     // Catch:{ all -> 0x01dc }
            org.android.agoo.message.MessageService r0 = r1.messageService     // Catch:{ all -> 0x01dc }
            java.lang.String r5 = "0"
            r6 = r25
            r0.a(r13, r6, r5)     // Catch:{ all -> 0x01dc }
            com.taobao.accs.utl.UTMini r27 = com.taobao.accs.utl.UTMini.getInstance()     // Catch:{ all -> 0x01dc }
            r28 = 19999(0x4e1f, float:2.8025E-41)
            java.lang.String r29 = "Page_Push"
            java.lang.String r30 = "agoo_arrive_id"
            r31 = 0
            r32 = 0
            r5 = 2
            java.lang.String[] r0 = new java.lang.String[r5]     // Catch:{ all -> 0x01dc }
            r5 = 0
            r0[r5] = r19     // Catch:{ all -> 0x01dc }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01dc }
            r5.<init>()     // Catch:{ all -> 0x01dc }
            r6 = r23
            r5.append(r6)     // Catch:{ all -> 0x01d6 }
            java.lang.String r7 = r2.msgIds     // Catch:{ all -> 0x01d6 }
            r5.append(r7)     // Catch:{ all -> 0x01d6 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01d6 }
            r0[r26] = r5     // Catch:{ all -> 0x01d6 }
            r33 = r0
            r27.commitEvent((int) r28, (java.lang.String) r29, (java.lang.Object) r30, (java.lang.Object) r31, (java.lang.Object) r32, (java.lang.String[]) r33)     // Catch:{ all -> 0x01d6 }
            java.lang.String r0 = "arrive"
            r7 = r18
            r5 = r20
            r8 = 0
            com.taobao.accs.utl.k.a(r5, r7, r0, r8)     // Catch:{ all -> 0x01d4 }
            goto L_0x01fe
        L_0x01d4:
            r0 = move-exception
            goto L_0x01e3
        L_0x01d6:
            r0 = move-exception
            r7 = r18
            r5 = r20
            goto L_0x01e3
        L_0x01dc:
            r0 = move-exception
            r7 = r18
            r5 = r20
            r6 = r23
        L_0x01e3:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x036e }
            r8.<init>()     // Catch:{ all -> 0x036e }
            java.lang.String r9 = "report message Throwable--->t="
            r8.append(r9)     // Catch:{ all -> 0x036e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x036e }
            r8.append(r0)     // Catch:{ all -> 0x036e }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x036e }
            r8 = 0
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x036e }
            com.taobao.accs.utl.ALog.e(r4, r0, r9)     // Catch:{ all -> 0x036e }
        L_0x01fe:
            org.android.agoo.message.MessageService r0 = r1.messageService     // Catch:{ all -> 0x036e }
            boolean r0 = r0.a((java.lang.String) r13)     // Catch:{ all -> 0x036e }
            if (r0 == 0) goto L_0x0239
            com.taobao.accs.utl.ALog$Level r0 = com.taobao.accs.utl.ALog.Level.I     // Catch:{ all -> 0x036e }
            boolean r0 = com.taobao.accs.utl.ALog.isPrintLog(r0)     // Catch:{ all -> 0x036e }
            if (r0 == 0) goto L_0x0231
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x036e }
            r0.<init>()     // Catch:{ all -> 0x036e }
            java.lang.String r2 = "handleRemoteMessage hasMessageDuplicate,messageId="
            r0.append(r2)     // Catch:{ all -> 0x036e }
            r0.append(r13)     // Catch:{ all -> 0x036e }
            java.lang.String r2 = ",utdid="
            r0.append(r2)     // Catch:{ all -> 0x036e }
            java.lang.String r2 = com.taobao.accs.utl.j.b(r35)     // Catch:{ all -> 0x036e }
            r0.append(r2)     // Catch:{ all -> 0x036e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x036e }
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x036e }
            com.taobao.accs.utl.ALog.i(r4, r0, r2)     // Catch:{ all -> 0x036e }
        L_0x0231:
            java.lang.String r0 = "arrive_dup"
            r2 = 0
            com.taobao.accs.utl.k.a(r5, r7, r0, r2)     // Catch:{ all -> 0x036e }
            return
        L_0x0239:
            com.taobao.accs.utl.ALog$Level r0 = com.taobao.accs.utl.ALog.Level.I     // Catch:{ all -> 0x036e }
            boolean r0 = com.taobao.accs.utl.ALog.isPrintLog(r0)     // Catch:{ all -> 0x036e }
            if (r0 == 0) goto L_0x0265
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x036e }
            r0.<init>()     // Catch:{ all -> 0x036e }
            java.lang.String r8 = "handleMessage--->["
            r0.append(r8)     // Catch:{ all -> 0x036e }
            r0.append(r14)     // Catch:{ all -> 0x036e }
            java.lang.String r8 = "],["
            r0.append(r8)     // Catch:{ all -> 0x036e }
            r0.append(r11)     // Catch:{ all -> 0x036e }
            java.lang.String r8 = "]"
            r0.append(r8)     // Catch:{ all -> 0x036e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x036e }
            r8 = 0
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x036e }
            com.taobao.accs.utl.ALog.i(r4, r0, r9)     // Catch:{ all -> 0x036e }
        L_0x0265:
            java.lang.String r0 = "duplicate"
            java.lang.String r0 = r3.getStringExtra(r0)     // Catch:{ all -> 0x0292 }
            boolean r8 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0292 }
            if (r8 != 0) goto L_0x028f
            r8 = r17
            boolean r0 = android.text.TextUtils.equals(r0, r8)     // Catch:{ all -> 0x028d }
            if (r0 == 0) goto L_0x02b8
            int r0 = r14.hashCode()     // Catch:{ all -> 0x028d }
            org.android.agoo.message.MessageService r9 = r1.messageService     // Catch:{ all -> 0x028d }
            boolean r0 = r9.a((java.lang.String) r13, (int) r0)     // Catch:{ all -> 0x028d }
            if (r0 == 0) goto L_0x02b8
            java.lang.String r0 = "arrive_dupbody"
            r9 = 0
            com.taobao.accs.utl.k.a(r5, r7, r0, r9)     // Catch:{ all -> 0x028d }
            return
        L_0x028d:
            r0 = move-exception
            goto L_0x0295
        L_0x028f:
            r8 = r17
            goto L_0x02b8
        L_0x0292:
            r0 = move-exception
            r8 = r17
        L_0x0295:
            com.taobao.accs.utl.ALog$Level r9 = com.taobao.accs.utl.ALog.Level.E     // Catch:{ all -> 0x036e }
            boolean r9 = com.taobao.accs.utl.ALog.isPrintLog(r9)     // Catch:{ all -> 0x036e }
            if (r9 == 0) goto L_0x02b8
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x036e }
            r9.<init>()     // Catch:{ all -> 0x036e }
            java.lang.String r10 = "hasMessageDuplicate message,e="
            r9.append(r10)     // Catch:{ all -> 0x036e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x036e }
            r9.append(r0)     // Catch:{ all -> 0x036e }
            java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x036e }
            r9 = 0
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ all -> 0x036e }
            com.taobao.accs.utl.ALog.e(r4, r0, r10)     // Catch:{ all -> 0x036e }
        L_0x02b8:
            java.lang.String r0 = "notify"
            java.lang.String r0 = r3.getStringExtra(r0)     // Catch:{ all -> 0x02c3 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x02c3 }
            goto L_0x02c4
        L_0x02c3:
            r0 = -1
        L_0x02c4:
            java.lang.String r9 = ""
            java.lang.String r10 = "has_test"
            java.lang.String r10 = r3.getStringExtra(r10)     // Catch:{ all -> 0x02f2 }
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x02f2 }
            if (r11 != 0) goto L_0x02e7
            boolean r8 = android.text.TextUtils.equals(r10, r8)     // Catch:{ all -> 0x02f2 }
            if (r8 == 0) goto L_0x02e7
            org.android.agoo.message.MessageService r8 = r1.messageService     // Catch:{ all -> 0x02f2 }
            r10 = r16
            r8.a(r13, r14, r10, r0)     // Catch:{ all -> 0x02f4 }
            java.lang.String r8 = "arrive_test"
            r11 = 0
            com.taobao.accs.utl.k.a(r5, r7, r8, r11)     // Catch:{ all -> 0x02f4 }
            return
        L_0x02e7:
            r10 = r16
            java.lang.Class r8 = r34.getClass()     // Catch:{ all -> 0x02f4 }
            java.lang.String r9 = r8.getName()     // Catch:{ all -> 0x02f4 }
            goto L_0x02f4
        L_0x02f2:
            r10 = r16
        L_0x02f4:
            org.android.agoo.message.MessageService r8 = r1.messageService     // Catch:{ all -> 0x036e }
            r8.a(r13, r14, r10, r0)     // Catch:{ all -> 0x036e }
            com.taobao.accs.utl.UTMini r27 = com.taobao.accs.utl.UTMini.getInstance()     // Catch:{ all -> 0x036e }
            r28 = 19999(0x4e1f, float:2.8025E-41)
            java.lang.String r29 = "Page_Push"
            java.lang.String r30 = "agoo_arrive_real_id"
            r31 = 0
            r32 = 0
            r8 = 2
            java.lang.String[] r0 = new java.lang.String[r8]     // Catch:{ all -> 0x036e }
            r8 = 0
            r0[r8] = r19     // Catch:{ all -> 0x036e }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x036e }
            r8.<init>()     // Catch:{ all -> 0x036e }
            r8.append(r6)     // Catch:{ all -> 0x036e }
            java.lang.String r2 = r2.msgIds     // Catch:{ all -> 0x036e }
            r8.append(r2)     // Catch:{ all -> 0x036e }
            java.lang.String r2 = r8.toString()     // Catch:{ all -> 0x036e }
            r0[r26] = r2     // Catch:{ all -> 0x036e }
            r33 = r0
            r27.commitEvent((int) r28, (java.lang.String) r29, (java.lang.Object) r30, (java.lang.Object) r31, (java.lang.Object) r32, (java.lang.String[]) r33)     // Catch:{ all -> 0x036e }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x036e }
            r0.<init>()     // Catch:{ all -> 0x036e }
            java.lang.String r2 = "arrive_real_"
            r0.append(r2)     // Catch:{ all -> 0x036e }
            r0.append(r9)     // Catch:{ all -> 0x036e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x036e }
            r8 = 0
            com.taobao.accs.utl.k.a(r5, r7, r0, r8)     // Catch:{ all -> 0x036e }
            android.os.Bundle r0 = r36.getExtras()     // Catch:{ Exception -> 0x0361 }
            java.lang.Class<com.taobao.accs.ut.monitor.NetPerformanceMonitor> r2 = com.taobao.accs.ut.monitor.NetPerformanceMonitor.class
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ Exception -> 0x0361 }
            r0.setClassLoader(r2)     // Catch:{ Exception -> 0x0361 }
            android.os.Bundle r0 = r36.getExtras()     // Catch:{ Exception -> 0x0361 }
            java.lang.String r2 = "monitor"
            java.io.Serializable r0 = r0.getSerializable(r2)     // Catch:{ Exception -> 0x0361 }
            com.taobao.accs.ut.monitor.NetPerformanceMonitor r0 = (com.taobao.accs.ut.monitor.NetPerformanceMonitor) r0     // Catch:{ Exception -> 0x0361 }
            if (r0 == 0) goto L_0x036a
            r0.onToAgooTime()     // Catch:{ Exception -> 0x0361 }
            anet.channel.appmonitor.IAppMonitor r2 = anet.channel.appmonitor.AppMonitor.getInstance()     // Catch:{ Exception -> 0x0361 }
            r2.commitStat(r0)     // Catch:{ Exception -> 0x0361 }
            goto L_0x036a
        L_0x0361:
            r0 = move-exception
            java.lang.String r2 = "get NetPerformanceMonitor Error:"
            r6 = 0
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x036e }
            com.taobao.accs.utl.ALog.e(r4, r2, r0, r6)     // Catch:{ all -> 0x036e }
        L_0x036a:
            r34.onMessage(r35, r36)     // Catch:{ all -> 0x036e }
            goto L_0x0398
        L_0x036e:
            r0 = move-exception
            goto L_0x037e
        L_0x0370:
            r0 = move-exception
            r7 = r18
            r5 = r20
            goto L_0x037e
        L_0x0376:
            r0 = move-exception
            r5 = r9
            r7 = r18
            goto L_0x037e
        L_0x037b:
            r0 = move-exception
            r7 = r8
            r5 = r9
        L_0x037e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "arrive_exception"
            r2.append(r3)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r2 = 0
            com.taobao.accs.utl.k.a(r5, r7, r0, r2)
        L_0x0398:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.control.BaseIntentService.handleRemoteMessage(android.content.Context, android.content.Intent):void");
    }

    private final void handleRemovePackage(Context context, Intent intent) {
        String str;
        if (intent != null && context != null) {
            Uri data = intent.getData();
            if (data != null) {
                str = data.getSchemeSpecificPart();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(TAG, "handleRemovePackage---->[replacing:" + booleanExtra + "],uninstallPack=" + str, new Object[0]);
                }
                if (!booleanExtra) {
                    this.notifyManager.doUninstall(str, booleanExtra);
                }
            }
        }
    }

    public static void runIntentInService(Context context, Intent intent, String str) {
        try {
            intent.setClassName(context, str);
            context.startService(intent);
        } catch (Throwable th) {
            ALog.w(TAG, "runIntentInService", th, new Object[0]);
        }
    }

    public IBinder onBind(Intent intent) {
        getApplication();
        if (t.b() && v.a(this) && !isBinded) {
            isBinded = true;
            getApplicationContext().bindService(new Intent(getApplication(), getClass()), new i(this), 1);
        }
        return this.messenger.getBinder();
    }

    public void onCreate() {
        super.onCreate();
        ThreadPoolExecutorFactory.execute(new j(this));
    }

    public abstract void onError(Context context, String str);

    public void onHandleIntent(Intent intent) {
        this.mContext = getApplicationContext();
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                String agooCommand = IntentUtil.getAgooCommand(this.mContext);
                String thirdPushCommand = IntentUtil.getThirdPushCommand(this.mContext);
                ALog.i(TAG, "onHandleIntent,action=" + action + ",agooCommand=" + agooCommand + ",mipushCommand=" + thirdPushCommand, new Object[0]);
                try {
                    if (TextUtils.equals(action, agooCommand)) {
                        String stringExtra = intent.getStringExtra("command");
                        ALog.d(TAG, "actionCommand --->[" + stringExtra + "]", new Object[0]);
                        if (TextUtils.equals(stringExtra, AgooConstants.AGOO_COMMAND_MESSAGE_READED) || TextUtils.equals(stringExtra, AgooConstants.AGOO_COMMAND_MESSAGE_DELETED)) {
                            onUserCommand(this.mContext, intent);
                        }
                        a.f12918f.incrementAndGet();
                    }
                    if (TextUtils.equals(action, thirdPushCommand)) {
                        String stringExtra2 = intent.getStringExtra("command");
                        String stringExtra3 = intent.getStringExtra(AgooConstants.THIRD_PUSH_ID);
                        if (TextUtils.equals(stringExtra2, AgooConstants.AGOO_COMMAND_MIPUSHID_REPORT)) {
                            this.notifyManager.reportThirdPushToken(stringExtra3, "MI_TOKEN", false);
                        } else if (TextUtils.equals(stringExtra2, AgooConstants.AGOO_COMMAND_HUAWEIPUSHID_REPORT)) {
                            ALog.d(TAG, "HW_TOKEN report begin..regid=" + stringExtra3, new Object[0]);
                            this.notifyManager.reportThirdPushToken(stringExtra3, "HW_TOKEN", false);
                        } else if (TextUtils.equals(stringExtra2, AgooConstants.AGOO_COMMAND_GCMIPUSHID_REPORT)) {
                            ALog.i(TAG, "GCM_TOKEN report begin..regid=" + stringExtra3, new Object[0]);
                            this.notifyManager.reportThirdPushToken(stringExtra3, "gcm", false);
                        }
                    } else if (action.equals(AgooConstants.INTENT_FROM_AGOO_MESSAGE)) {
                        handleRemoteMessage(this.mContext, intent);
                    } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                        handleRemovePackage(this.mContext, intent);
                    } else if (TextUtils.equals(action, AgooConstants.INTENT_FROM_AGOO_REPORT) || TextUtils.equals(action, "android.net.conn.CONNECTIVITY_CHANGE") || TextUtils.equals(action, "android.intent.action.BOOT_COMPLETED") || TextUtils.equals(action, "android.intent.action.PACKAGE_ADDED") || TextUtils.equals(action, "android.intent.action.PACKAGE_REPLACED") || TextUtils.equals(action, "android.intent.action.USER_PRESENT") || TextUtils.equals(action, "android.intent.action.ACTION_POWER_CONNECTED") || TextUtils.equals(action, "android.intent.action.ACTION_POWER_DISCONNECTED")) {
                        ALog.i(TAG, "is report cache msg,Config.isReportCacheMsg(mContext)=" + Config.d(this.mContext), new Object[0]);
                        if (Config.d(this.mContext) && UtilityImpl.i(this.mContext)) {
                            Config.e(this.mContext);
                            this.agooFactory.reportCacheMsg();
                            this.messageService.a();
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        if (ALog.isPrintLog(ALog.Level.I)) {
                            ALog.i(TAG, "is clear all msg=" + Config.b(this.mContext, currentTimeMillis), new Object[0]);
                        }
                        if (Config.b(this.mContext, currentTimeMillis)) {
                            Config.a(this.mContext, currentTimeMillis);
                            this.messageService.a();
                        }
                    }
                    a.f12918f.incrementAndGet();
                } catch (Throwable th) {
                    try {
                        if (ALog.isPrintLog(ALog.Level.E)) {
                            ALog.e(TAG, "onHandleIntent deal error", th, new Object[0]);
                        }
                    } catch (Throwable th2) {
                        a.f12918f.incrementAndGet();
                        throw th2;
                    }
                }
            }
        }
    }

    public abstract void onMessage(Context context, Intent intent);

    public abstract void onRegistered(Context context, String str);

    public int onStartCommand(Intent intent, int i10, int i11) {
        ThreadPoolExecutorFactory.execute(new k(this, intent));
        return 2;
    }

    public void onUserCommand(Context context, Intent intent) {
    }
}
