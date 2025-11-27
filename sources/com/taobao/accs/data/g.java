package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.hpplay.logwriter.b;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.IAppReceiverV1;
import com.taobao.accs.a.a;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.j;
import com.taobao.accs.utl.k;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.Config;

public class g {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static Set<String> f12990a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile g f12991b;

    public static g a() {
        if (f12991b == null) {
            synchronized (g.class) {
                if (f12991b == null) {
                    f12991b = new g();
                }
            }
        }
        return f12991b;
    }

    public String b() {
        return j.msgService;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: com.taobao.accs.IAppReceiver} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: com.taobao.accs.IAppReceiver} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: com.taobao.accs.IAppReceiver} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: com.taobao.accs.IAppReceiver} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: com.taobao.accs.IAppReceiver} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: com.taobao.accs.IAppReceiver} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v20, resolved type: com.taobao.accs.IAppReceiver} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v21, resolved type: com.taobao.accs.IAppReceiver} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v22, resolved type: com.taobao.accs.IAppReceiver} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0110 A[Catch:{ all -> 0x02c3 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0111 A[Catch:{ all -> 0x02c3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.content.Context r45, android.content.Intent r46) {
        /*
            r44 = this;
            r12 = r44
            r0 = r46
            java.lang.String r13 = "command"
            java.lang.String r14 = "accs"
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.String r15 = "dataId"
            java.lang.String r11 = r0.getStringExtra(r15)
            java.lang.String r10 = "serviceId"
            java.lang.String r9 = r0.getStringExtra(r10)
            java.lang.String r3 = r46.getAction()
            com.taobao.accs.utl.ALog$Level r16 = com.taobao.accs.utl.ALog.Level.D
            boolean r4 = com.taobao.accs.utl.ALog.isPrintLog(r16)
            r17 = 5
            r8 = 6
            java.lang.String r7 = "accs-impaas"
            r18 = 3
            r19 = 1
            java.lang.String r6 = "MsgDistribute"
            r5 = 0
            r22 = 0
            if (r4 != 0) goto L_0x0042
            boolean r4 = r7.equals(r9)
            if (r4 == 0) goto L_0x003f
            boolean r4 = com.taobao.accs.utl.t.e()
            if (r4 == 0) goto L_0x003f
            goto L_0x0042
        L_0x003f:
            r4 = r22
            goto L_0x005f
        L_0x0042:
            java.lang.Object[] r4 = new java.lang.Object[r8]
            java.lang.String r23 = "action"
            r4[r5] = r23
            r4[r19] = r3
            r21 = 2
            r4[r21] = r15
            r4[r18] = r11
            r20 = 4
            r4[r20] = r10
            r4[r17] = r9
            java.lang.String r8 = "distribute ready"
            com.taobao.accs.utl.ALog.e(r6, r8, r4)
            com.taobao.accs.ut.monitor.NetPerformanceMonitor r4 = com.taobao.accs.utl.a.a((android.content.Intent) r46)
        L_0x005f:
            if (r4 == 0) goto L_0x0069
            long r24 = java.lang.System.currentTimeMillis()
            long r1 = r24 - r1
            r4.thread_schedule_time = r1
        L_0x0069:
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            r2 = 221(0xdd, float:3.1E-43)
            r4 = 66001(0x101d1, float:9.2487E-41)
            if (r1 == 0) goto L_0x0089
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r1 = "action null"
            com.taobao.accs.utl.ALog.e(r6, r1, r0)
            com.taobao.accs.utl.UTMini r0 = com.taobao.accs.utl.UTMini.getInstance()
            java.lang.String r3 = "MsgToBuss9"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.commitEvent(r4, r3, r1, r2)
            return
        L_0x0089:
            java.lang.String r1 = "com.taobao.accs.intent.action.RECEIVE"
            boolean r1 = android.text.TextUtils.equals(r3, r1)     // Catch:{ all -> 0x02f5 }
            if (r1 == 0) goto L_0x02d3
            r1 = -1
            int r8 = r0.getIntExtra(r13, r1)     // Catch:{ all -> 0x02f5 }
            java.lang.String r1 = "userInfo"
            java.lang.String r24 = r0.getStringExtra(r1)     // Catch:{ all -> 0x02c3 }
            java.lang.String r1 = "errorCode"
            int r25 = r0.getIntExtra(r1, r5)     // Catch:{ all -> 0x02c3 }
            java.lang.String r1 = "appKey"
            java.lang.String r26 = r0.getStringExtra(r1)     // Catch:{ all -> 0x02c3 }
            java.lang.String r1 = "configTag"
            java.lang.String r4 = r0.getStringExtra(r1)     // Catch:{ all -> 0x02c3 }
            java.lang.String r1 = r46.getPackage()     // Catch:{ all -> 0x02c3 }
            if (r1 != 0) goto L_0x00ca
            java.lang.String r1 = r45.getPackageName()     // Catch:{ all -> 0x00bc }
            r0.setPackage(r1)     // Catch:{ all -> 0x00bc }
            goto L_0x00ca
        L_0x00bc:
            r0 = move-exception
            r5 = r8
            r42 = r10
            r43 = r11
            r26 = r14
            r14 = 4
            r20 = 2
            r10 = r6
            goto L_0x0301
        L_0x00ca:
            boolean r1 = r14.equals(r9)     // Catch:{ all -> 0x02c3 }
            java.lang.String r2 = "config"
            java.lang.String r3 = "appkey"
            java.lang.String r5 = "distribute start"
            if (r1 != 0) goto L_0x00f1
            boolean r1 = r7.equals(r9)     // Catch:{ all -> 0x00bc }
            if (r1 == 0) goto L_0x00dd
            goto L_0x00f1
        L_0x00dd:
            r28 = r7
            r1 = 4
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ all -> 0x00bc }
            r1 = 0
            r7[r1] = r3     // Catch:{ all -> 0x00bc }
            r7[r19] = r26     // Catch:{ all -> 0x00bc }
            r1 = 2
            r7[r1] = r2     // Catch:{ all -> 0x00bc }
            r7[r18] = r4     // Catch:{ all -> 0x00bc }
            com.taobao.accs.utl.ALog.d(r6, r5, r7)     // Catch:{ all -> 0x00bc }
            r7 = 4
            goto L_0x0104
        L_0x00f1:
            r28 = r7
            r7 = 4
            java.lang.Object[] r1 = new java.lang.Object[r7]     // Catch:{ all -> 0x02c3 }
            r20 = 0
            r1[r20] = r3     // Catch:{ all -> 0x02c3 }
            r1[r19] = r26     // Catch:{ all -> 0x02c3 }
            r3 = 2
            r1[r3] = r2     // Catch:{ all -> 0x02c3 }
            r1[r18] = r4     // Catch:{ all -> 0x02c3 }
            com.taobao.accs.utl.ALog.e(r6, r5, r1)     // Catch:{ all -> 0x02c3 }
        L_0x0104:
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02c3 }
            r5 = r45
            boolean r3 = r12.a(r5, r0, r11, r9)     // Catch:{ all -> 0x02c3 }
            if (r3 == 0) goto L_0x0111
            return
        L_0x0111:
            long r29 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02c3 }
            long r29 = r29 - r1
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02c3 }
            if (r8 >= 0) goto L_0x013b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bc }
            r0.<init>()     // Catch:{ all -> 0x00bc }
            java.lang.String r1 = "command error:"
            r0.append(r1)     // Catch:{ all -> 0x00bc }
            r0.append(r8)     // Catch:{ all -> 0x00bc }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00bc }
            r3 = 2
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ all -> 0x00bc }
            r20 = 0
            r1[r20] = r10     // Catch:{ all -> 0x00bc }
            r1[r19] = r9     // Catch:{ all -> 0x00bc }
            com.taobao.accs.utl.ALog.e(r6, r0, r1)     // Catch:{ all -> 0x00bc }
            return
        L_0x013b:
            r3 = 2
            r20 = 0
            long r31 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02c3 }
            long r31 = r31 - r1
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02c3 }
            boolean r21 = r12.a((int) r8, (java.lang.String) r9)     // Catch:{ all -> 0x02c3 }
            if (r21 == 0) goto L_0x014f
            return
        L_0x014f:
            long r33 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02c3 }
            long r33 = r33 - r1
            long r35 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02c3 }
            r1 = r44
            r2 = r45
            r21 = 2
            r3 = r46
            r27 = r4
            r4 = r11
            r12 = 0
            r20 = 2
            r5 = r9
            r37 = r6
            r6 = r27
            boolean r1 = r1.a((android.content.Context) r2, (android.content.Intent) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ all -> 0x02b6 }
            if (r1 == 0) goto L_0x0173
            return
        L_0x0173:
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02b6 }
            long r35 = r1 - r35
            long r38 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02b6 }
            com.taobao.accs.client.GlobalClientInfo r1 = com.taobao.accs.client.GlobalClientInfo.getInstance(r45)     // Catch:{ all -> 0x02b6 }
            java.util.Map r6 = r1.getAppReceiver()     // Catch:{ all -> 0x02b6 }
            boolean r1 = android.text.TextUtils.isEmpty(r27)     // Catch:{ all -> 0x02b6 }
            if (r1 != 0) goto L_0x01a5
            if (r6 == 0) goto L_0x01a5
            r5 = r27
            java.lang.Object r1 = r6.get(r5)     // Catch:{ all -> 0x0198 }
            r22 = r1
            com.taobao.accs.IAppReceiver r22 = (com.taobao.accs.IAppReceiver) r22     // Catch:{ all -> 0x0198 }
            goto L_0x01a7
        L_0x0198:
            r0 = move-exception
            r5 = r8
            r42 = r10
            r43 = r11
            r26 = r14
            r10 = r37
            r14 = 4
            goto L_0x0301
        L_0x01a5:
            r5 = r27
        L_0x01a7:
            r1 = r44
            r2 = r45
            r3 = r9
            r4 = r11
            r21 = r5
            r5 = r46
            r27 = r6
            r6 = r22
            boolean r1 = r1.a((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r4, (android.content.Intent) r5, (com.taobao.accs.IAppReceiver) r6)     // Catch:{ all -> 0x02b6 }
            if (r1 == 0) goto L_0x01bc
            return
        L_0x01bc:
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02b6 }
            long r38 = r1 - r38
            long r40 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02b6 }
            r1 = r44
            r2 = r45
            r3 = r46
            r4 = r21
            r5 = r26
            r6 = r8
            r26 = r14
            r12 = r28
            r14 = 4
            r7 = r24
            r23 = r8
            r24 = 6
            r8 = r9
            r28 = r9
            r9 = r11
            r42 = r10
            r10 = r22
            r43 = r11
            r11 = r25
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x02b0 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02b0 }
            long r1 = r1 - r40
            boolean r3 = android.text.TextUtils.isEmpty(r28)     // Catch:{ all -> 0x02b0 }
            if (r3 != 0) goto L_0x0299
            boolean r3 = com.taobao.accs.utl.ALog.isPrintLog(r16)     // Catch:{ all -> 0x02b0 }
            r9 = r28
            if (r3 != 0) goto L_0x0216
            boolean r3 = r12.equals(r9)     // Catch:{ all -> 0x020f }
            if (r3 == 0) goto L_0x020c
            boolean r3 = com.taobao.accs.utl.t.e()     // Catch:{ all -> 0x020f }
            if (r3 == 0) goto L_0x020c
            goto L_0x0216
        L_0x020c:
            r10 = r37
            goto L_0x0283
        L_0x020f:
            r0 = move-exception
            r5 = r23
            r10 = r37
            goto L_0x0301
        L_0x0216:
            java.lang.String r3 = "handleBusinessMsg start"
            r4 = 18
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0297 }
            r5 = 0
            r4[r5] = r15     // Catch:{ all -> 0x0297 }
            r4[r19] = r43     // Catch:{ all -> 0x0297 }
            r4[r20] = r42     // Catch:{ all -> 0x0297 }
            r4[r18] = r9     // Catch:{ all -> 0x0297 }
            r4[r14] = r13     // Catch:{ all -> 0x0297 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r23)     // Catch:{ all -> 0x0297 }
            r4[r17] = r5     // Catch:{ all -> 0x0297 }
            java.lang.String r5 = "t1"
            r4[r24] = r5     // Catch:{ all -> 0x0297 }
            java.lang.Long r5 = java.lang.Long.valueOf(r29)     // Catch:{ all -> 0x0297 }
            r6 = 7
            r4[r6] = r5     // Catch:{ all -> 0x0297 }
            java.lang.String r5 = "t2"
            r6 = 8
            r4[r6] = r5     // Catch:{ all -> 0x0297 }
            java.lang.Long r5 = java.lang.Long.valueOf(r31)     // Catch:{ all -> 0x0297 }
            r6 = 9
            r4[r6] = r5     // Catch:{ all -> 0x0297 }
            java.lang.String r5 = "t3"
            r6 = 10
            r4[r6] = r5     // Catch:{ all -> 0x0297 }
            java.lang.Long r5 = java.lang.Long.valueOf(r33)     // Catch:{ all -> 0x0297 }
            r6 = 11
            r4[r6] = r5     // Catch:{ all -> 0x0297 }
            java.lang.String r5 = "t4"
            r6 = 12
            r4[r6] = r5     // Catch:{ all -> 0x0297 }
            java.lang.Long r5 = java.lang.Long.valueOf(r35)     // Catch:{ all -> 0x0297 }
            r6 = 13
            r4[r6] = r5     // Catch:{ all -> 0x0297 }
            java.lang.String r5 = "t5"
            r6 = 14
            r4[r6] = r5     // Catch:{ all -> 0x0297 }
            java.lang.Long r5 = java.lang.Long.valueOf(r38)     // Catch:{ all -> 0x0297 }
            r6 = 15
            r4[r6] = r5     // Catch:{ all -> 0x0297 }
            java.lang.String r5 = "t6"
            r6 = 16
            r4[r6] = r5     // Catch:{ all -> 0x0297 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0297 }
            r2 = 17
            r4[r2] = r1     // Catch:{ all -> 0x0297 }
            r10 = r37
            com.taobao.accs.utl.ALog.e(r10, r3, r4)     // Catch:{ all -> 0x02ae }
        L_0x0283:
            r1 = r44
            r2 = r45
            r3 = r22
            r4 = r46
            r5 = r9
            r6 = r43
            r7 = r23
            r8 = r25
            r1.a(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x02ae }
            goto L_0x0332
        L_0x0297:
            r0 = move-exception
            goto L_0x02b3
        L_0x0299:
            r9 = r28
            r10 = r37
            r1 = r44
            r2 = r45
            r3 = r27
            r4 = r46
            r5 = r23
            r6 = r25
            r1.a((android.content.Context) r2, (java.util.Map<java.lang.String, com.taobao.accs.IAppReceiver>) r3, (android.content.Intent) r4, (int) r5, (int) r6)     // Catch:{ all -> 0x02ae }
            goto L_0x0332
        L_0x02ae:
            r0 = move-exception
            goto L_0x02d0
        L_0x02b0:
            r0 = move-exception
            r9 = r28
        L_0x02b3:
            r10 = r37
            goto L_0x02d0
        L_0x02b6:
            r0 = move-exception
            r23 = r8
            r42 = r10
            r43 = r11
            r26 = r14
            r10 = r37
            r14 = 4
            goto L_0x02d0
        L_0x02c3:
            r0 = move-exception
            r23 = r8
            r42 = r10
            r43 = r11
            r26 = r14
            r14 = 4
            r20 = 2
            r10 = r6
        L_0x02d0:
            r5 = r23
            goto L_0x0301
        L_0x02d3:
            r42 = r10
            r43 = r11
            r26 = r14
            r14 = 4
            r20 = 2
            r10 = r6
            java.lang.String r0 = "distribMessage action error"
            r1 = 0
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x02f3 }
            com.taobao.accs.utl.ALog.e(r10, r0, r5)     // Catch:{ all -> 0x02f3 }
            com.taobao.accs.utl.UTMini r0 = com.taobao.accs.utl.UTMini.getInstance()     // Catch:{ all -> 0x02f3 }
            java.lang.String r1 = "MsgToBuss10"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x02f3 }
            r0.commitEvent(r4, r1, r3, r2)     // Catch:{ all -> 0x02f3 }
            goto L_0x0332
        L_0x02f3:
            r0 = move-exception
            goto L_0x0300
        L_0x02f5:
            r0 = move-exception
            r42 = r10
            r43 = r11
            r26 = r14
            r14 = 4
            r20 = 2
            r10 = r6
        L_0x0300:
            r5 = 0
        L_0x0301:
            java.lang.Object[] r1 = new java.lang.Object[r14]
            r2 = 0
            r1[r2] = r15
            r1[r19] = r43
            r1[r20] = r42
            r1[r18] = r9
            java.lang.String r2 = "distribMessage"
            com.taobao.accs.utl.ALog.e(r10, r2, r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "distribute error "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r0 = com.taobao.accs.utl.UtilityImpl.a((java.lang.Throwable) r0)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "send_fail"
            java.lang.String r2 = "1"
            r3 = r26
            com.taobao.accs.utl.k.a(r3, r1, r9, r2, r0)
        L_0x0332:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.data.g.b(android.content.Context, android.content.Intent):void");
    }

    public static void a(Context context, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_DATA_ID);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
            if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(stringExtra2)) {
                ALog.e("MsgDistribute", "distribMessage", Constants.KEY_DATA_ID, stringExtra);
            }
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new h(context, intent));
        } catch (Throwable th) {
            ALog.e("MsgDistribute", "distribMessage", th, new Object[0]);
            UTMini instance = UTMini.getInstance();
            instance.commitEvent(66001, "MsgToBuss8", "distribMessage" + th.toString(), Integer.valueOf(Constants.SDK_VERSION_CODE));
        }
    }

    public boolean a(int i10, String str) {
        if (i10 == 100 || GlobalClientInfo.AGOO_SERVICE_ID.equals(str)) {
            return false;
        }
        long e10 = UtilityImpl.e();
        if (e10 == -1 || e10 > b.f10579a) {
            return false;
        }
        k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, "1", "space low");
        ALog.e("MsgDistribute", "user space low, don't distribute", "size", Long.valueOf(e10), Constants.KEY_SERVICE_ID, str);
        return true;
    }

    public boolean a(Context context, String str, String str2, Intent intent, IAppReceiver iAppReceiver) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String service = GlobalClientInfo.getInstance(context).getService(intent.getStringExtra(Constants.KEY_CONFIG_TAG), str);
            if (TextUtils.isEmpty(service) && iAppReceiver != null) {
                service = iAppReceiver.getService(str);
            }
            if (TextUtils.isEmpty(service)) {
                service = GlobalClientInfo.getInstance(context).getService(str);
            }
            if (!TextUtils.isEmpty(service) || UtilityImpl.isMainProcess(context)) {
                return false;
            }
            if ("accs".equals(str)) {
                ALog.e("MsgDistribute", "start MsgDistributeService", Constants.KEY_DATA_ID, str2);
            } else {
                ALog.i("MsgDistribute", "start MsgDistributeService", Constants.KEY_DATA_ID, str2);
            }
            intent.setClassName(intent.getPackage(), b());
            a.a(context, intent);
            return true;
        } catch (Throwable th) {
            ALog.e("MsgDistribute", "handleMsgInChannelProcess", th, new Object[0]);
            return false;
        }
    }

    private void a(Context context, Intent intent, String str, String str2, int i10, String str3, String str4, String str5, IAppReceiver iAppReceiver, int i11) {
        String str6 = str2;
        int i12 = i10;
        String str7 = str3;
        String str8 = str4;
        String str9 = str5;
        IAppReceiver iAppReceiver2 = iAppReceiver;
        int i13 = i11;
        if (ALog.isPrintLog(ALog.Level.D)) {
            Object[] objArr = new Object[12];
            objArr[0] = Constants.KEY_CONFIG_TAG;
            objArr[1] = str;
            objArr[2] = Constants.KEY_DATA_ID;
            objArr[3] = str9;
            objArr[4] = Constants.KEY_SERVICE_ID;
            objArr[5] = str8;
            objArr[6] = "command";
            objArr[7] = Integer.valueOf(i10);
            objArr[8] = "errorCode";
            objArr[9] = Integer.valueOf(i11);
            objArr[10] = "appReceiver";
            objArr[11] = iAppReceiver2 == null ? null : iAppReceiver.getClass().getName();
            ALog.d("MsgDistribute", "handleControlMsg", objArr);
        }
        if (iAppReceiver2 != null) {
            if (i12 != 1) {
                if (i12 == 2) {
                    if (i13 == 200) {
                        UtilityImpl.disableService(context);
                    }
                    iAppReceiver.onUnbindApp(i11);
                } else if (i12 == 3) {
                    iAppReceiver2.onBindUser(str7, i13);
                } else if (i12 == 4) {
                    iAppReceiver.onUnbindUser(i11);
                } else if (i12 != 100) {
                    if (i12 == 101 && TextUtils.isEmpty(str4)) {
                        ALog.d("MsgDistribute", "handleControlMsg serviceId isEmpty", new Object[0]);
                        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
                        if (byteArrayExtra != null) {
                            iAppReceiver2.onData(str7, str9, byteArrayExtra);
                        }
                    }
                } else if (TextUtils.isEmpty(str4)) {
                    iAppReceiver2.onSendData(str9, i13);
                }
            } else if (iAppReceiver2 instanceof IAppReceiverV1) {
                ((IAppReceiverV1) iAppReceiver2).onBindApp(i13, (String) null);
            } else {
                iAppReceiver.onBindApp(i11);
            }
        }
        if (i12 == 1 && GlobalClientInfo.f12900b != null && str6 != null && str6.equals(Config.a(context))) {
            ALog.d("MsgDistribute", "handleControlMsg agoo receiver onBindApp", new Object[0]);
            GlobalClientInfo.f12900b.onBindApp(i13, (String) null);
        } else if (iAppReceiver2 == null && i12 != 100 && i12 != 104 && i12 != 103) {
            k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str8, "1", "appReceiver null return");
            UTMini.getInstance().commitEvent(66001, "MsgToBuss7", "commandId=" + i12, "serviceId=" + str8 + " errorCode=" + i13 + " dataId=" + str9, Integer.valueOf(Constants.SDK_VERSION_CODE));
        }
    }

    public void a(Context context, IAppReceiver iAppReceiver, Intent intent, String str, String str2, int i10, int i11) {
        Context context2 = context;
        IAppReceiver iAppReceiver2 = iAppReceiver;
        Intent intent2 = intent;
        String str3 = str;
        String str4 = str2;
        int i12 = i10;
        ALog.Level level = ALog.Level.D;
        if (ALog.isPrintLog(level) || "accs-impaas".equals(str3)) {
            ALog.e("MsgDistribute", "handleBusinessMsg start", Constants.KEY_DATA_ID, str4, Constants.KEY_SERVICE_ID, str3, "command", Integer.valueOf(i10));
        }
        String service = GlobalClientInfo.getInstance(context).getService(intent2.getStringExtra(Constants.KEY_CONFIG_TAG), str3);
        if (TextUtils.isEmpty(service) && iAppReceiver2 != null) {
            service = iAppReceiver2.getService(str3);
        }
        if (TextUtils.isEmpty(service)) {
            service = GlobalClientInfo.getInstance(context).getService(str3);
        }
        if (!TextUtils.isEmpty(service)) {
            if (ALog.isPrintLog(level) || "accs-impaas".equals(str3)) {
                ALog.e("MsgDistribute", "handleBusinessMsg to start service", "className", service);
            }
            NetPerformanceMonitor a10 = com.taobao.accs.utl.a.a(intent);
            if (a10 != null) {
                a10.start_service = System.currentTimeMillis();
            }
            intent2.setClassName(context2, service);
            a.a(context2, intent2);
        } else {
            AccsDataListener listener = GlobalClientInfo.getInstance(context).getListener(str3);
            if (listener != null) {
                if (ALog.isPrintLog(level) || "accs-impaas".equals(str3)) {
                    ALog.e("MsgDistribute", "handleBusinessMsg getListener not null", new Object[0]);
                }
                com.taobao.accs.utl.a.a(context2, intent2, listener);
            } else {
                ALog.e("MsgDistribute", "handleBusinessMsg getListener also null", new Object[0]);
                k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str3, "1", "service is null");
            }
        }
        UTMini.getInstance().commitEvent(66001, "MsgToBuss", "commandId=" + i12, "serviceId=" + str3 + " errorCode=" + i11 + " dataId=" + str4, Integer.valueOf(Constants.SDK_VERSION_CODE));
        StringBuilder sb = new StringBuilder();
        sb.append("2commandId=");
        sb.append(i12);
        sb.append("serviceId=");
        sb.append(str3);
        k.a("accs", BaseMonitor.COUNT_POINT_TO_BUSS, sb.toString(), 0.0d);
    }

    public void a(Context context, Map<String, IAppReceiver> map, Intent intent, int i10, int i11) {
        TaoBaseService.ConnectInfo connectInfo;
        ALog.e("MsgDistribute", "handBroadCastMsg", "command", Integer.valueOf(i10));
        HashMap hashMap = new HashMap();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                Map<String, String> allService = GlobalClientInfo.getInstance(context).getAllService((String) next.getKey());
                if (allService == null) {
                    allService = ((IAppReceiver) next.getValue()).getAllServices();
                }
                if (allService != null) {
                    hashMap.putAll(allService);
                }
            }
        }
        if (i10 == 103) {
            for (String str : hashMap.keySet()) {
                if ("accs".equals(str) || "windvane".equals(str) || "motu-remote".equals(str)) {
                    String str2 = (String) hashMap.get(str);
                    if (TextUtils.isEmpty(str2)) {
                        str2 = GlobalClientInfo.getInstance(context).getService(str);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        intent.setClassName(context, str2);
                        a.a(context, intent);
                    }
                }
            }
            boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
            String stringExtra = intent.getStringExtra(Constants.KEY_HOST);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_ERROR_DETAIL);
            boolean booleanExtra2 = intent.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
            boolean booleanExtra3 = intent.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
            if (!TextUtils.isEmpty(stringExtra)) {
                if (booleanExtra) {
                    connectInfo = new TaoBaseService.ConnectInfo(stringExtra, booleanExtra2, booleanExtra3);
                } else {
                    connectInfo = new TaoBaseService.ConnectInfo(stringExtra, booleanExtra2, booleanExtra3, i11, stringExtra2);
                }
                connectInfo.connected = booleanExtra;
            } else {
                connectInfo = null;
            }
            if (connectInfo != null) {
                ALog.d("MsgDistribute", "handBroadCastMsg ACTION_CONNECT_INFO", connectInfo);
                Intent intent2 = new Intent(Constants.ACTION_CONNECT_INFO);
                intent2.setPackage(context.getPackageName());
                intent2.putExtra(Constants.KEY_CONNECT_INFO, connectInfo);
                context.sendBroadcast(intent2);
                return;
            }
            ALog.e("MsgDistribute", "handBroadCastMsg connect info null, host empty", new Object[0]);
        } else if (i10 == 104) {
            for (String str3 : hashMap.keySet()) {
                String str4 = (String) hashMap.get(str3);
                if (TextUtils.isEmpty(str4)) {
                    str4 = GlobalClientInfo.getInstance(context).getService(str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    intent.setClassName(context, str4);
                    a.a(context, intent);
                }
            }
        } else {
            ALog.w("MsgDistribute", "handBroadCastMsg not handled command", new Object[0]);
        }
    }

    private boolean a(Context context, Intent intent, String str, String str2) {
        boolean z10;
        Intent intent2 = intent;
        String str3 = str;
        boolean booleanExtra = intent2.getBooleanExtra("routingAck", false);
        boolean booleanExtra2 = intent2.getBooleanExtra("routingMsg", false);
        if (booleanExtra) {
            ALog.e("MsgDistribute", "recieve routiong ack", Constants.KEY_DATA_ID, str3, Constants.KEY_SERVICE_ID, str2);
            Set<String> set = f12990a;
            if (set != null) {
                set.remove(str3);
            }
            k.a("accs", BaseMonitor.ALARM_MSG_ROUTING_RATE, "");
            z10 = true;
        } else {
            z10 = false;
        }
        if (booleanExtra2) {
            try {
                String stringExtra = intent2.getStringExtra(Constants.KEY_PACKAGE_NAME);
                ALog.e("MsgDistribute", "send routiong ack", Constants.KEY_DATA_ID, str3, "to pkg", stringExtra, Constants.KEY_SERVICE_ID, str2);
                Intent intent3 = new Intent(Constants.ACTION_COMMAND);
                intent3.putExtra("command", 106);
                intent3.setClassName(stringExtra, j.channelService);
                intent3.putExtra("routingAck", true);
                intent3.putExtra(Constants.KEY_PACKAGE_NAME, stringExtra);
                intent3.putExtra(Constants.KEY_DATA_ID, str3);
                a.a(context, intent3);
            } catch (Throwable th) {
                ALog.e("MsgDistribute", "send routing ack", th, Constants.KEY_SERVICE_ID, str2);
            }
        }
        return z10;
    }

    private boolean a(Context context, Intent intent, String str, String str2, String str3) {
        AccsClientConfig configByTag = !TextUtils.isEmpty(str3) ? AccsClientConfig.getConfigByTag(str3) : null;
        if (context.getPackageName().equals(intent.getPackage())) {
            return false;
        }
        if (configByTag != null && !configByTag.isPullUpEnable()) {
            return false;
        }
        try {
            ALog.e("MsgDistribute", "start MsgDistributeService", "receive pkg", context.getPackageName(), "target pkg", intent.getPackage(), Constants.KEY_SERVICE_ID, str2);
            intent.setClassName(intent.getPackage(), j.msgService);
            intent.putExtra("routingMsg", true);
            intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
            a.a(context, intent);
            if (f12990a == null) {
                f12990a = new HashSet();
            }
            f12990a.add(str);
            ThreadPoolExecutorFactory.schedule(new i(this, str, str2, intent), 10, TimeUnit.SECONDS);
        } catch (Throwable th) {
            k.a("accs", BaseMonitor.ALARM_MSG_ROUTING_RATE, "", "exception", th.toString());
            ALog.e("MsgDistribute", "routing msg error, try election", th, Constants.KEY_SERVICE_ID, str2, Constants.KEY_DATA_ID, str);
        }
        return true;
    }
}
