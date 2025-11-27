package com.umeng.message.proguard;

import android.app.Application;
import android.content.ContentProviderOperation;
import android.content.Context;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.message.common.UPLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class w implements UMLogDataProtocol {

    /* renamed from: b  reason: collision with root package name */
    private static final UMLogDataProtocol f16081b = new w();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f16082a = false;

    private w() {
    }

    public static UMLogDataProtocol a() {
        return f16081b;
    }

    public final void removeCacheData(Object obj) {
        if (obj != null) {
            try {
                JSONObject optJSONObject = new JSONObject(obj.toString()).optJSONObject("content");
                if (optJSONObject != null) {
                    Application a10 = y.a();
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray = optJSONObject.optJSONArray("push");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                            JSONObject jSONObject = (JSONObject) optJSONArray.get(i10);
                            arrayList.add(ContentProviderOperation.newDelete(h.d(a10)).withSelection("MsgId=? And ActionType=?", new String[]{jSONObject.optString("msg_id"), String.valueOf(jSONObject.optInt("action_type"))}).build());
                        }
                    }
                    a10.getContentResolver().applyBatch(h.f(a10), arrayList);
                }
            } catch (Throwable th) {
                UPLog.e("Event", th);
            }
        }
    }

    public final JSONObject setupReportData(long j10) {
        return null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:127:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0125, code lost:
        r1 = (org.json.JSONObject) r1.get(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0024, code lost:
        r2 = r22;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void workEvent(java.lang.Object r23, int r24) {
        /*
            r22 = this;
            java.lang.String r0 = "Event"
            java.lang.String r1 = "-1"
            java.lang.String r2 = ""
            if (r23 != 0) goto L_0x0009
            return
        L_0x0009:
            java.lang.String r3 = "ts"
            java.lang.String r4 = "msg_id"
            java.lang.String r5 = "action_type"
            java.lang.String r6 = "push_switch"
            java.lang.String r7 = "din"
            java.lang.String r8 = "6.7.0"
            java.lang.String r9 = "p_sdk_v"
            r10 = 1
            java.lang.String r11 = "exception"
            r12 = 0
            java.lang.String r13 = "push"
            java.lang.String r14 = "header"
            java.lang.String r15 = "content"
            switch(r24) {
                case 16385: goto L_0x0217;
                case 16386: goto L_0x0196;
                case 16387: goto L_0x015e;
                case 16388: goto L_0x00dd;
                case 16389: goto L_0x00a6;
                case 16390: goto L_0x004b;
                case 16391: goto L_0x0028;
                case 16392: goto L_0x0028;
                default: goto L_0x0024;
            }
        L_0x0024:
            r2 = r22
            goto L_0x029b
        L_0x0028:
            android.app.Application r16 = com.umeng.message.proguard.y.a()     // Catch:{ all -> 0x0295 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0295 }
            java.lang.String r1 = r23.toString()     // Catch:{ all -> 0x0295 }
            r0.<init>(r1)     // Catch:{ all -> 0x0295 }
            org.json.JSONObject r18 = r0.optJSONObject(r15)     // Catch:{ all -> 0x0295 }
            org.json.JSONObject r17 = r0.optJSONObject(r14)     // Catch:{ all -> 0x0295 }
            if (r17 == 0) goto L_0x0024
            if (r18 == 0) goto L_0x0024
            java.lang.String r19 = "umpx_push_logs"
            java.lang.String r20 = "p"
            java.lang.String r21 = "6.7.0"
            com.umeng.commonsdk.framework.UMEnvelopeBuild.buildEnvelopeWithExtHeader(r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0295 }
            goto L_0x0024
        L_0x004b:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0295 }
            java.lang.String r1 = r23.toString()     // Catch:{ all -> 0x0295 }
            r0.<init>(r1)     // Catch:{ all -> 0x0295 }
            android.app.Application r14 = com.umeng.message.proguard.y.a()     // Catch:{ all -> 0x0295 }
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ all -> 0x0295 }
            r15.<init>()     // Catch:{ all -> 0x0295 }
            r15.put(r9, r8)     // Catch:{ all -> 0x0295 }
            java.lang.String r1 = com.umeng.message.proguard.d.c(r14)     // Catch:{ all -> 0x0295 }
            r15.put(r7, r1)     // Catch:{ all -> 0x0295 }
            java.lang.String r1 = com.umeng.message.proguard.d.p(r14)     // Catch:{ all -> 0x0295 }
            r15.put(r6, r1)     // Catch:{ all -> 0x0295 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0295 }
            r1.<init>()     // Catch:{ all -> 0x0295 }
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ all -> 0x0295 }
            r5.<init>()     // Catch:{ all -> 0x0295 }
            java.lang.String r6 = "pa"
            r0.put(r6, r2)     // Catch:{ all -> 0x0295 }
            java.lang.String r6 = "device_token"
            com.umeng.message.PushAgent r7 = com.umeng.message.PushAgent.getInstance(r14)     // Catch:{ all -> 0x0295 }
            java.lang.String r7 = r7.getRegistrationId()     // Catch:{ all -> 0x0295 }
            r0.put(r6, r7)     // Catch:{ all -> 0x0295 }
            r0.put(r4, r2)     // Catch:{ all -> 0x0295 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0295 }
            r0.put(r3, r6)     // Catch:{ all -> 0x0295 }
            r5.put(r0)     // Catch:{ all -> 0x0295 }
            r1.put(r13, r5)     // Catch:{ all -> 0x0295 }
            java.lang.String r17 = "umpx_push_logs"
            java.lang.String r18 = "p"
            java.lang.String r19 = "6.7.0"
            r16 = r1
            com.umeng.commonsdk.framework.UMEnvelopeBuild.buildEnvelopeWithExtHeader(r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x0295 }
            return
        L_0x00a6:
            android.app.Application r2 = com.umeng.message.proguard.y.a()     // Catch:{ all -> 0x0295 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0295 }
            java.lang.String r1 = r23.toString()     // Catch:{ all -> 0x0295 }
            r0.<init>(r1)     // Catch:{ all -> 0x0295 }
            org.json.JSONObject r3 = r0.optJSONObject(r14)     // Catch:{ all -> 0x0295 }
            org.json.JSONObject r0 = r0.optJSONObject(r15)     // Catch:{ all -> 0x0295 }
            if (r3 == 0) goto L_0x00dc
            if (r0 == 0) goto L_0x00dc
            java.lang.String r5 = "umpx_push_logs"
            java.lang.String r6 = "p"
            java.lang.String r7 = "6.7.0"
            r4 = r0
            org.json.JSONObject r1 = com.umeng.commonsdk.framework.UMEnvelopeBuild.buildEnvelopeWithExtHeader(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0295 }
            if (r1 == 0) goto L_0x00dc
            boolean r1 = r1.has(r11)     // Catch:{ all -> 0x0295 }
            if (r1 != 0) goto L_0x00dc
            com.umeng.message.proguard.z.a()     // Catch:{ all -> 0x0295 }
            org.json.JSONArray r0 = r0.getJSONArray(r13)     // Catch:{ all -> 0x0295 }
            com.umeng.message.proguard.z.a((org.json.JSONArray) r0)     // Catch:{ all -> 0x0295 }
        L_0x00dc:
            return
        L_0x00dd:
            android.app.Application r0 = com.umeng.message.proguard.y.a()     // Catch:{ all -> 0x0295 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0295 }
            java.lang.String r2 = r23.toString()     // Catch:{ all -> 0x0295 }
            r1.<init>(r2)     // Catch:{ all -> 0x0295 }
            java.lang.String r2 = "jsonHeader"
            org.json.JSONObject r2 = r1.optJSONObject(r2)     // Catch:{ all -> 0x0295 }
            java.lang.String r3 = "jsonBody"
            org.json.JSONObject r10 = r1.optJSONObject(r3)     // Catch:{ all -> 0x0295 }
            java.lang.String r3 = "um_px_path"
            java.lang.String r4 = r1.optString(r3)     // Catch:{ all -> 0x0295 }
            if (r2 == 0) goto L_0x015d
            if (r10 == 0) goto L_0x015d
            r2.put(r9, r8)     // Catch:{ all -> 0x0295 }
            android.app.Application r1 = com.umeng.message.proguard.y.a()     // Catch:{ all -> 0x0295 }
            java.lang.String r1 = com.umeng.message.proguard.d.c(r1)     // Catch:{ all -> 0x0295 }
            r2.put(r7, r1)     // Catch:{ all -> 0x0295 }
            android.app.Application r1 = com.umeng.message.proguard.y.a()     // Catch:{ all -> 0x0295 }
            java.lang.String r1 = com.umeng.message.proguard.d.p(r1)     // Catch:{ all -> 0x0295 }
            r2.put(r6, r1)     // Catch:{ all -> 0x0295 }
            org.json.JSONArray r1 = r10.optJSONArray(r13)     // Catch:{ all -> 0x0295 }
            if (r1 == 0) goto L_0x013e
            int r3 = r1.length()     // Catch:{ all -> 0x0295 }
            if (r3 <= 0) goto L_0x013e
            java.lang.Object r1 = r1.get(r12)     // Catch:{ all -> 0x0295 }
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ all -> 0x0295 }
            int r12 = r1.optInt(r5)     // Catch:{ all -> 0x0295 }
            if (r12 != 0) goto L_0x013e
            com.umeng.message.PushAgent r3 = com.umeng.message.PushAgent.getInstance(r0)     // Catch:{ all -> 0x0295 }
            com.umeng.message.api.UPushMessageNotifyApi r3 = r3.getMessageNotifyApi()     // Catch:{ all -> 0x0295 }
            com.umeng.message.proguard.aw r3 = (com.umeng.message.proguard.aw) r3     // Catch:{ all -> 0x0295 }
            r3.a(r1)     // Catch:{ all -> 0x0295 }
        L_0x013e:
            java.lang.String r5 = "p"
            java.lang.String r6 = "6.7.0"
            r1 = r0
            r3 = r10
            org.json.JSONObject r1 = com.umeng.commonsdk.framework.UMEnvelopeBuild.buildEnvelopeWithExtHeader(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0295 }
            if (r1 == 0) goto L_0x015d
            boolean r1 = r1.has(r11)     // Catch:{ all -> 0x0295 }
            if (r1 != 0) goto L_0x015d
            r1 = 6
            if (r12 == r1) goto L_0x015d
            r1 = 7
            if (r12 == r1) goto L_0x015d
            org.json.JSONArray r1 = r10.getJSONArray(r13)     // Catch:{ all -> 0x0295 }
            a(r0, r1)     // Catch:{ all -> 0x0295 }
        L_0x015d:
            return
        L_0x015e:
            android.app.Application r0 = com.umeng.message.proguard.y.a()     // Catch:{ all -> 0x0295 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0295 }
            java.lang.String r2 = r23.toString()     // Catch:{ all -> 0x0295 }
            r1.<init>(r2)     // Catch:{ all -> 0x0295 }
            org.json.JSONObject r3 = r1.optJSONObject(r14)     // Catch:{ all -> 0x0295 }
            org.json.JSONObject r4 = r1.optJSONObject(r15)     // Catch:{ all -> 0x0295 }
            if (r3 == 0) goto L_0x0195
            if (r4 == 0) goto L_0x0195
            java.lang.String r5 = "umpx_push_register"
            java.lang.String r6 = "p"
            java.lang.String r7 = "6.7.0"
            r2 = r0
            org.json.JSONObject r1 = com.umeng.commonsdk.framework.UMEnvelopeBuild.buildEnvelopeWithExtHeader(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0295 }
            if (r1 == 0) goto L_0x0195
            boolean r1 = r1.has(r11)     // Catch:{ all -> 0x0295 }
            if (r1 != 0) goto L_0x0195
            com.umeng.message.MessageSharedPrefs r0 = com.umeng.message.MessageSharedPrefs.getInstance(r0)     // Catch:{ all -> 0x0295 }
            com.umeng.message.proguard.bd r0 = r0.f15211b     // Catch:{ all -> 0x0295 }
            java.lang.String r1 = "has_register"
            r0.a((java.lang.String) r1, (boolean) r10)     // Catch:{ all -> 0x0295 }
        L_0x0195:
            return
        L_0x0196:
            android.app.Application r8 = com.umeng.message.proguard.y.a()     // Catch:{ all -> 0x0295 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0295 }
            java.lang.String r3 = r23.toString()     // Catch:{ all -> 0x0295 }
            r2.<init>(r3)     // Catch:{ all -> 0x0295 }
            org.json.JSONObject r3 = r2.optJSONObject(r14)     // Catch:{ all -> 0x0295 }
            org.json.JSONObject r4 = r2.optJSONObject(r15)     // Catch:{ all -> 0x0295 }
            if (r3 == 0) goto L_0x0216
            if (r4 == 0) goto L_0x0216
            java.lang.String r5 = "umpx_push_launch"
            java.lang.String r6 = "p"
            java.lang.String r7 = "6.7.0"
            r2 = r8
            org.json.JSONObject r2 = com.umeng.commonsdk.framework.UMEnvelopeBuild.buildEnvelopeWithExtHeader(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0295 }
            if (r2 == 0) goto L_0x0216
            boolean r2 = r2.has(r11)     // Catch:{ all -> 0x0295 }
            if (r2 != 0) goto L_0x0216
            com.umeng.message.MessageSharedPrefs r2 = com.umeng.message.MessageSharedPrefs.getInstance(r8)     // Catch:{ all -> 0x0295 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0295 }
            com.umeng.message.proguard.bd r5 = r2.f15211b     // Catch:{ all -> 0x0295 }
            java.lang.String r6 = "start_time"
            r5.a((java.lang.String) r6, (long) r3)     // Catch:{ all -> 0x0295 }
            r3 = 2
            java.lang.String r4 = "launch_policy"
            java.lang.String r4 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(r8, r4, r1)     // Catch:{ all -> 0x01f4 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ all -> 0x01f4 }
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ all -> 0x01f4 }
            java.lang.String r6 = "launch policy:"
            r5[r12] = r6     // Catch:{ all -> 0x01f4 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x01f4 }
            r5[r10] = r6     // Catch:{ all -> 0x01f4 }
            com.umeng.message.common.UPLog.i(r0, r5)     // Catch:{ all -> 0x01f4 }
            if (r4 <= 0) goto L_0x01f4
            com.umeng.message.proguard.bd r5 = r2.f15211b     // Catch:{ all -> 0x01f4 }
            java.lang.String r6 = "launch_send_policy"
            r5.a((java.lang.String) r6, (int) r4)     // Catch:{ all -> 0x01f4 }
        L_0x01f4:
            java.lang.String r4 = "tag_policy"
            java.lang.String r1 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(r8, r4, r1)     // Catch:{ all -> 0x0216 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x0216 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0216 }
            java.lang.String r4 = "tag policy:"
            r3[r12] = r4     // Catch:{ all -> 0x0216 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0216 }
            r3[r10] = r4     // Catch:{ all -> 0x0216 }
            com.umeng.message.common.UPLog.i(r0, r3)     // Catch:{ all -> 0x0216 }
            if (r1 <= 0) goto L_0x0216
            com.umeng.message.proguard.bd r0 = r2.f15211b     // Catch:{ all -> 0x0216 }
            java.lang.String r2 = "tag_send_policy"
            r0.a((java.lang.String) r2, (int) r1)     // Catch:{ all -> 0x0216 }
        L_0x0216:
            return
        L_0x0217:
            android.app.Application r0 = com.umeng.message.proguard.y.a()     // Catch:{ all -> 0x0295 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0295 }
            java.lang.String r2 = r23.toString()     // Catch:{ all -> 0x0295 }
            r1.<init>(r2)     // Catch:{ all -> 0x0295 }
            org.json.JSONObject r2 = r1.optJSONObject(r15)     // Catch:{ all -> 0x0295 }
            r9 = 71
            r10 = 70
            if (r2 == 0) goto L_0x0268
            org.json.JSONArray r6 = r2.optJSONArray(r13)     // Catch:{ all -> 0x0295 }
            if (r6 == 0) goto L_0x0268
            int r7 = r6.length()     // Catch:{ all -> 0x0295 }
            if (r7 <= 0) goto L_0x0268
            java.lang.Object r6 = r6.get(r12)     // Catch:{ all -> 0x0295 }
            org.json.JSONObject r6 = (org.json.JSONObject) r6     // Catch:{ all -> 0x0295 }
            int r5 = r6.optInt(r5)     // Catch:{ all -> 0x0295 }
            if (r5 == r10) goto L_0x0266
            if (r5 == r9) goto L_0x0266
            if (r5 != 0) goto L_0x0257
            com.umeng.message.PushAgent r7 = com.umeng.message.PushAgent.getInstance(r0)     // Catch:{ all -> 0x0295 }
            com.umeng.message.api.UPushMessageNotifyApi r7 = r7.getMessageNotifyApi()     // Catch:{ all -> 0x0295 }
            com.umeng.message.proguard.aw r7 = (com.umeng.message.proguard.aw) r7     // Catch:{ all -> 0x0295 }
            r7.a(r6)     // Catch:{ all -> 0x0295 }
        L_0x0257:
            com.umeng.message.proguard.bb r7 = com.umeng.message.proguard.bb.a(r0)     // Catch:{ all -> 0x0295 }
            java.lang.String r4 = r6.optString(r4)     // Catch:{ all -> 0x0295 }
            long r12 = r6.optLong(r3)     // Catch:{ all -> 0x0295 }
            r7.a(r4, r5, r12)     // Catch:{ all -> 0x0295 }
        L_0x0266:
            r12 = r5
            goto L_0x026a
        L_0x0268:
            r5 = -1
            r12 = -1
        L_0x026a:
            org.json.JSONObject r4 = r1.optJSONObject(r14)     // Catch:{ all -> 0x0295 }
            if (r4 == 0) goto L_0x0292
            if (r2 == 0) goto L_0x0292
            java.lang.String r6 = "umpx_push_logs"
            java.lang.String r7 = "p"
            java.lang.String r8 = "6.7.0"
            r3 = r0
            r5 = r2
            org.json.JSONObject r0 = com.umeng.commonsdk.framework.UMEnvelopeBuild.buildEnvelopeWithExtHeader(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0295 }
            if (r0 == 0) goto L_0x0292
            boolean r0 = r0.has(r11)     // Catch:{ all -> 0x0295 }
            if (r0 != 0) goto L_0x0292
            if (r12 == r10) goto L_0x0292
            if (r12 == r9) goto L_0x0292
            r2 = r22
            r2.removeCacheData(r1)     // Catch:{ all -> 0x0290 }
            goto L_0x0294
        L_0x0290:
            r0 = move-exception
            goto L_0x0298
        L_0x0292:
            r2 = r22
        L_0x0294:
            return
        L_0x0295:
            r0 = move-exception
            r2 = r22
        L_0x0298:
            r0.printStackTrace()
        L_0x029b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.w.workEvent(java.lang.Object, int):void");
    }

    private static void a(Context context, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() != 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(i10);
                        arrayList.add(ContentProviderOperation.newDelete(h.d(context)).withSelection("MsgId=? And ActionType=?", new String[]{jSONObject.optString("msg_id"), String.valueOf(jSONObject.optInt("action_type"))}).build());
                    }
                    context.getContentResolver().applyBatch(h.f(context), arrayList);
                }
            } catch (Throwable th) {
                UPLog.e("Event", "remove cache error:" + th.getMessage());
            }
        }
    }
}
