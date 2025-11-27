package com.taobao.accs.utl;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.b;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import java.util.HashMap;
import java.util.Map;

public class a {
    public static final String TAG = "a";

    /* renamed from: a  reason: collision with root package name */
    private static Handler f13185a = new Handler(Looper.getMainLooper());

    /* JADX WARNING: Code restructure failed: missing block: B:90:0x02c7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02c8, code lost:
        r18 = "1";
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008b A[SYNTHETIC, Splitter:B:19:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02b7 A[Catch:{ Exception -> 0x02c1, all -> 0x02c5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(android.content.Context r28, android.content.Intent r29, com.taobao.accs.base.AccsDataListener r30) {
        /*
            r0 = r28
            r7 = r29
            r4 = r30
            java.lang.String r1 = "serviceId="
            java.lang.String r8 = "onReceiveData"
            java.lang.String r2 = "serviceId"
            java.lang.String r3 = "dataId"
            java.lang.String r9 = "1"
            java.lang.String r10 = "send_fail"
            java.lang.String r5 = "command"
            java.lang.String r11 = "accs"
            r13 = 0
            if (r4 == 0) goto L_0x02f5
            if (r0 != 0) goto L_0x001d
            goto L_0x02f5
        L_0x001d:
            if (r7 == 0) goto L_0x02f3
            r6 = -1
            int r6 = r7.getIntExtra(r5, r6)     // Catch:{ Exception -> 0x02c7, all -> 0x02c5 }
            java.lang.String r14 = "errorCode"
            int r14 = r7.getIntExtra(r14, r13)     // Catch:{ Exception -> 0x02c7, all -> 0x02c5 }
            java.lang.String r15 = "userInfo"
            java.lang.String r15 = r7.getStringExtra(r15)     // Catch:{ Exception -> 0x02c7, all -> 0x02c5 }
            java.lang.String r12 = r7.getStringExtra(r3)     // Catch:{ Exception -> 0x02c7, all -> 0x02c5 }
            java.lang.String r13 = r7.getStringExtra(r2)     // Catch:{ Exception -> 0x02c7, all -> 0x02c5 }
            com.taobao.accs.utl.ALog$Level r17 = com.taobao.accs.utl.ALog.Level.I     // Catch:{ Exception -> 0x02c7, all -> 0x02c5 }
            boolean r17 = com.taobao.accs.utl.ALog.isPrintLog(r17)     // Catch:{ Exception -> 0x02c7, all -> 0x02c5 }
            r18 = r9
            java.lang.String r9 = "accs-impaas"
            if (r17 != 0) goto L_0x0053
            boolean r17 = r9.equals(r13)     // Catch:{ Exception -> 0x0050, all -> 0x02c5 }
            if (r17 == 0) goto L_0x004b
            goto L_0x0053
        L_0x004b:
            r17 = r10
            r21 = r15
            goto L_0x0087
        L_0x0050:
            r0 = move-exception
            goto L_0x02ca
        L_0x0053:
            r17 = r10
            java.lang.String r10 = TAG     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            r21 = r15
            r15 = 8
            java.lang.Object[] r15 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            r16 = 0
            r15[r16] = r3     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            r3 = 1
            r15[r3] = r12     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            r3 = 2
            r15[r3] = r2     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            r2 = 3
            r15[r2] = r13     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            r2 = 4
            r15[r2] = r5     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            r3 = 5
            r15[r3] = r2     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            java.lang.String r2 = "className"
            r3 = 6
            r15[r3] = r2     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            java.lang.Class r2 = r30.getClass()     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            java.lang.String r2 = r2.getName()     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            r3 = 7
            r15[r3] = r2     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            com.taobao.accs.utl.ALog.e(r10, r8, r15)     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
        L_0x0087:
            java.lang.String r2 = "onReceiveData command not handled"
            if (r6 <= 0) goto L_0x02b7
            com.taobao.accs.utl.UTMini r22 = com.taobao.accs.utl.UTMini.getInstance()     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            r23 = 66001(0x101d1, float:9.2487E-41)
            java.lang.String r24 = "MsgToBuss5"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            r3.<init>()     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            java.lang.String r5 = "commandId="
            r3.append(r5)     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            r3.append(r6)     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            java.lang.String r25 = r3.toString()     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            r3.<init>()     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            r3.append(r1)     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            r3.append(r13)     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            java.lang.String r5 = " dataId="
            r3.append(r5)     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            r3.append(r12)     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            java.lang.String r26 = r3.toString()     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            r3 = 221(0xdd, float:3.1E-43)
            java.lang.Integer r27 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            r22.commitEvent(r23, r24, r25, r26, r27)     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            java.lang.String r3 = "to_buss"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            r5.<init>()     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            java.lang.String r10 = "3commandId="
            r5.append(r10)     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            r5.append(r6)     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            r5.append(r1)     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            r5.append(r13)     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            java.lang.String r1 = r5.toString()     // Catch:{ Exception -> 0x02c3, all -> 0x02c5 }
            r10 = r8
            r5 = r9
            r8 = 0
            com.taobao.accs.utl.k.a(r11, r3, r1, r8)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r1 = 5
            if (r6 == r1) goto L_0x02ae
            r1 = 6
            if (r6 == r1) goto L_0x02a5
            r1 = 100
            java.lang.String r3 = "data"
            if (r6 == r1) goto L_0x0247
            r1 = 101(0x65, float:1.42E-43)
            if (r6 == r1) goto L_0x0173
            r0 = 103(0x67, float:1.44E-43)
            if (r6 == r0) goto L_0x0131
            r0 = 104(0x68, float:1.46E-43)
            if (r6 == r0) goto L_0x0107
            java.lang.String r0 = TAG     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r1 = 0
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            com.taobao.accs.utl.ALog.w(r0, r2, r3)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            goto L_0x02f3
        L_0x0107:
            java.lang.String r0 = "anti_brush_ret"
            r1 = 0
            boolean r0 = r7.getBooleanExtra(r0, r1)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            java.lang.String r1 = TAG     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r2.<init>()     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            java.lang.String r3 = "onReceiveData anti brush result:"
            r2.append(r3)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r2.append(r0)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r3 = 0
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            com.taobao.accs.utl.ALog.e(r1, r2, r5)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            com.taobao.accs.utl.g r1 = new com.taobao.accs.utl.g     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r1.<init>(r4, r0)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            a(r13, r1)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            goto L_0x02f3
        L_0x0131:
            java.lang.String r0 = "connect_avail"
            r1 = 0
            boolean r0 = r7.getBooleanExtra(r0, r1)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            java.lang.String r1 = "host"
            java.lang.String r2 = r7.getStringExtra(r1)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            java.lang.String r1 = "errorDetail"
            java.lang.String r6 = r7.getStringExtra(r1)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            java.lang.String r1 = "type_inapp"
            r3 = 0
            boolean r5 = r7.getBooleanExtra(r1, r3)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            java.lang.String r1 = "is_center_host"
            boolean r7 = r7.getBooleanExtra(r1, r3)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            if (r1 != 0) goto L_0x02f3
            if (r0 == 0) goto L_0x0163
            com.taobao.accs.utl.h r0 = new com.taobao.accs.utl.h     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r0.<init>(r4, r2, r5, r7)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            a(r13, r0)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            goto L_0x02f3
        L_0x0163:
            com.taobao.accs.utl.i r8 = new com.taobao.accs.utl.i     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r0 = r8
            r1 = r30
            r3 = r5
            r4 = r7
            r5 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            a(r13, r8)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            goto L_0x02f3
        L_0x0173:
            byte[] r14 = r7.getByteArrayExtra(r3)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            java.lang.String r1 = "bizAck"
            r2 = 0
            boolean r1 = r7.getBooleanExtra(r1, r2)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            if (r14 == 0) goto L_0x0232
            com.taobao.accs.utl.ALog$Level r2 = com.taobao.accs.utl.ALog.Level.D     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            boolean r2 = com.taobao.accs.utl.ALog.isPrintLog(r2)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            if (r2 != 0) goto L_0x018e
            boolean r2 = r5.equals(r13)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            if (r2 == 0) goto L_0x01af
        L_0x018e:
            java.lang.String r2 = TAG     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r3.<init>()     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            java.lang.String r5 = "onReceiveData COMMAND_RECEIVE_DATA onData dataId:"
            r3.append(r5)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r3.append(r12)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            java.lang.String r5 = " serviceId:"
            r3.append(r5)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r3.append(r13)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r5 = 0
            java.lang.Object[] r15 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            com.taobao.accs.utl.ALog.e(r2, r3, r15)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
        L_0x01af:
            com.taobao.accs.base.TaoBaseService$ExtraInfo r15 = c(r29)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            if (r1 == 0) goto L_0x01d3
            java.lang.String r1 = TAG     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r2.<init>()     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            java.lang.String r3 = "onReceiveData try to send biz ack dataId "
            r2.append(r3)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r2.append(r12)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r3 = 0
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            com.taobao.accs.utl.ALog.i(r1, r2, r5)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            java.util.Map<java.lang.Integer, java.lang.String> r1 = r15.oriExtHeader     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            a(r0, r7, r12, r1)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
        L_0x01d3:
            android.os.Bundle r1 = r29.getExtras()     // Catch:{ Exception -> 0x01fd, all -> 0x02c5 }
            java.lang.Class<com.taobao.accs.ut.monitor.NetPerformanceMonitor> r2 = com.taobao.accs.ut.monitor.NetPerformanceMonitor.class
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ Exception -> 0x01fd, all -> 0x02c5 }
            r1.setClassLoader(r2)     // Catch:{ Exception -> 0x01fd, all -> 0x02c5 }
            android.os.Bundle r1 = r29.getExtras()     // Catch:{ Exception -> 0x01fd, all -> 0x02c5 }
            java.lang.String r2 = "monitor"
            java.io.Serializable r1 = r1.getSerializable(r2)     // Catch:{ Exception -> 0x01fd, all -> 0x02c5 }
            com.taobao.accs.ut.monitor.NetPerformanceMonitor r1 = (com.taobao.accs.ut.monitor.NetPerformanceMonitor) r1     // Catch:{ Exception -> 0x01fd, all -> 0x02c5 }
            if (r1 == 0) goto L_0x0208
            r1.onToAccsTime()     // Catch:{ Exception -> 0x01fd, all -> 0x02c5 }
            boolean r0 = r0 instanceof org.android.agoo.accs.AgooService     // Catch:{ Exception -> 0x01fd, all -> 0x02c5 }
            if (r0 != 0) goto L_0x0208
            anet.channel.appmonitor.IAppMonitor r0 = anet.channel.appmonitor.AppMonitor.getInstance()     // Catch:{ Exception -> 0x01fd, all -> 0x02c5 }
            r0.commitStat(r1)     // Catch:{ Exception -> 0x01fd, all -> 0x02c5 }
            goto L_0x0208
        L_0x01fd:
            r0 = move-exception
            java.lang.String r1 = TAG     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            java.lang.String r2 = "get NetPerformanceMonitor Error:"
            r3 = 0
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            com.taobao.accs.utl.ALog.e(r1, r2, r0, r5)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
        L_0x0208:
            java.lang.String r0 = "to_buss_success"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r1.<init>()     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            java.lang.String r2 = "1commandId=101serviceId="
            r1.append(r2)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r1.append(r13)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            com.taobao.accs.utl.k.a(r11, r0, r1, r8)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            com.taobao.accs.utl.d r8 = new com.taobao.accs.utl.d     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r0 = r8
            r1 = r13
            r2 = r12
            r3 = r6
            r4 = r30
            r5 = r21
            r6 = r14
            r7 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            a(r13, r8)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            goto L_0x02f3
        L_0x0232:
            java.lang.String r0 = TAG     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            java.lang.String r1 = "onReceiveData COMMAND_RECEIVE_DATA msg null"
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            com.taobao.accs.utl.ALog.e(r0, r1, r3)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            java.lang.String r0 = "COMMAND_RECEIVE_DATA msg null"
            r8 = r17
            r9 = r18
            com.taobao.accs.utl.k.a(r11, r8, r13, r9, r0)     // Catch:{ Exception -> 0x029f, all -> 0x02c5 }
            goto L_0x02f3
        L_0x0247:
            r8 = r17
            r9 = r18
            com.taobao.accs.ut.monitor.NetPerformanceMonitor r1 = a((android.content.Intent) r29)     // Catch:{ Exception -> 0x029f, all -> 0x02c5 }
            if (r1 == 0) goto L_0x0266
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x029f, all -> 0x02c5 }
            r1.service_recv = r5     // Catch:{ Exception -> 0x029f, all -> 0x02c5 }
            r17 = r8
            r18 = r9
            long r8 = r1.start_service     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r19 = 0
            int r0 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r0 != 0) goto L_0x026a
            r1.start_service = r5     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            goto L_0x026a
        L_0x0266:
            r17 = r8
            r18 = r9
        L_0x026a:
            java.lang.String r0 = "res"
            java.lang.String r2 = "send_type"
            java.lang.String r2 = r7.getStringExtra(r2)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            boolean r0 = android.text.TextUtils.equals(r0, r2)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            if (r0 == 0) goto L_0x028e
            byte[] r6 = r7.getByteArrayExtra(r3)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            com.taobao.accs.utl.e r8 = new com.taobao.accs.utl.e     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r0 = r8
            r2 = r13
            r3 = r12
            r4 = r30
            r5 = r14
            r7 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            a(r13, r8)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            goto L_0x02f3
        L_0x028e:
            com.taobao.accs.utl.f r8 = new com.taobao.accs.utl.f     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r0 = r8
            r2 = r13
            r3 = r12
            r4 = r30
            r5 = r14
            r6 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            a(r13, r8)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            goto L_0x02f3
        L_0x029f:
            r0 = move-exception
            r17 = r8
            r18 = r9
            goto L_0x02cd
        L_0x02a5:
            com.taobao.accs.utl.c r0 = new com.taobao.accs.utl.c     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r0.<init>(r4, r13, r14, r7)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            a(r13, r0)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            goto L_0x02f3
        L_0x02ae:
            com.taobao.accs.utl.b r0 = new com.taobao.accs.utl.b     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r0.<init>(r4, r13, r14, r7)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            a(r13, r0)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            goto L_0x02f3
        L_0x02b7:
            r10 = r8
            java.lang.String r0 = TAG     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            r1 = 0
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            com.taobao.accs.utl.ALog.w(r0, r2, r3)     // Catch:{ Exception -> 0x02c1, all -> 0x02c5 }
            goto L_0x02f3
        L_0x02c1:
            r0 = move-exception
            goto L_0x02cd
        L_0x02c3:
            r0 = move-exception
            goto L_0x02cc
        L_0x02c5:
            r0 = move-exception
            throw r0
        L_0x02c7:
            r0 = move-exception
            r18 = r9
        L_0x02ca:
            r17 = r10
        L_0x02cc:
            r10 = r8
        L_0x02cd:
            java.lang.String r1 = ""
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "callback error"
            r2.append(r3)
            java.lang.String r3 = r0.toString()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r3 = r17
            r4 = r18
            com.taobao.accs.utl.k.a(r11, r3, r1, r4, r2)
            java.lang.String r1 = TAG
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.taobao.accs.utl.ALog.e(r1, r10, r0, r2)
        L_0x02f3:
            r1 = 2
            return r1
        L_0x02f5:
            r1 = 2
            r2 = 0
            java.lang.String r0 = TAG
            java.lang.String r3 = "onReceiveData listener or context null"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.taobao.accs.utl.ALog.e(r0, r3, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.a.a(android.content.Context, android.content.Intent, com.taobao.accs.base.AccsDataListener):int");
    }

    /* access modifiers changed from: private */
    public static TaoBaseService.ExtraInfo c(Intent intent) {
        TaoBaseService.ExtraInfo extraInfo = new TaoBaseService.ExtraInfo();
        try {
            HashMap hashMap = (HashMap) intent.getSerializableExtra(TaoBaseService.ExtraInfo.EXT_HEADER);
            Map<TaoBaseService.ExtHeaderType, String> a10 = a((Map<Integer, String>) hashMap);
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_HOST);
            extraInfo.connType = intent.getIntExtra(Constants.KEY_CONN_TYPE, 0);
            extraInfo.extHeader = a10;
            extraInfo.oriExtHeader = hashMap;
            extraInfo.fromPackage = stringExtra;
            extraInfo.fromHost = stringExtra2;
        } catch (Throwable th) {
            ALog.e(TAG, "getExtraInfo", th, new Object[0]);
        }
        return extraInfo;
    }

    private static void a(String str, Runnable runnable) {
        if (!"accs-impaas".equals(str) || !t.e()) {
            f13185a.post(runnable);
        } else {
            ThreadPoolExecutorFactory.executeCallback(runnable);
        }
    }

    public static NetPerformanceMonitor a(Intent intent) {
        try {
            intent.getExtras().setClassLoader(NetPerformanceMonitor.class.getClassLoader());
            return (NetPerformanceMonitor) intent.getExtras().getSerializable(Constants.KEY_MONIROT);
        } catch (Exception e10) {
            ALog.e(TAG, "get NetPerformanceMonitor Error:", e10, new Object[0]);
            return null;
        }
    }

    private static Map<TaoBaseService.ExtHeaderType, String> a(Map<Integer, String> map) {
        HashMap hashMap = null;
        if (map == null) {
            return null;
        }
        try {
            HashMap hashMap2 = new HashMap();
            try {
                for (TaoBaseService.ExtHeaderType extHeaderType : TaoBaseService.ExtHeaderType.values()) {
                    String str = map.get(Integer.valueOf(extHeaderType.ordinal()));
                    if (!TextUtils.isEmpty(str)) {
                        hashMap2.put(extHeaderType, str);
                    }
                }
                return hashMap2;
            } catch (Exception e10) {
                e = e10;
                hashMap = hashMap2;
                ALog.e(TAG, "getExtHeader", e, new Object[0]);
                return hashMap;
            }
        } catch (Exception e11) {
            e = e11;
            ALog.e(TAG, "getExtHeader", e, new Object[0]);
            return hashMap;
        }
    }

    private static void a(Context context, Intent intent, String str, Map<Integer, String> map) {
        Intent intent2 = intent;
        try {
            ALog.i(TAG, "sendBusinessAck", Constants.KEY_DATA_ID, str);
            if (intent2 != null) {
                String stringExtra = intent2.getStringExtra(Constants.KEY_HOST);
                String stringExtra2 = intent2.getStringExtra("source");
                String stringExtra3 = intent2.getStringExtra("target");
                String stringExtra4 = intent2.getStringExtra(Constants.KEY_APP_KEY);
                String stringExtra5 = intent2.getStringExtra(Constants.KEY_CONFIG_TAG);
                short shortExtra = intent2.getShortExtra(Constants.KEY_FLAGS, 0);
                b accsInstance = ACCSManager.getAccsInstance(context, stringExtra4, stringExtra5);
                if (accsInstance != null) {
                    accsInstance.a(stringExtra3, stringExtra2, str, shortExtra, stringExtra, map);
                    k.a("accs", BaseMonitor.COUNT_BUSINESS_ACK_SUCC, "", 0.0d);
                    return;
                }
                k.a("accs", BaseMonitor.COUNT_BUSINESS_ACK_FAIL, "no acsmgr", 0.0d);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "sendBusinessAck", th, new Object[0]);
            k.a("accs", BaseMonitor.COUNT_BUSINESS_ACK_FAIL, th.toString(), 0.0d);
        }
    }
}
