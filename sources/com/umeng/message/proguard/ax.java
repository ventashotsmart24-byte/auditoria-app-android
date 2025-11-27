package com.umeng.message.proguard;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.PushAgent;
import com.umeng.message.api.UPushMessageNotifyApi;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONArray;
import org.json.JSONObject;

final class ax {

    /* renamed from: a  reason: collision with root package name */
    UPushMessageNotifyApi.Callback f15467a;

    /* renamed from: b  reason: collision with root package name */
    final ay f15468b = new ay();

    /* renamed from: c  reason: collision with root package name */
    boolean f15469c;

    public final void a() {
        b.b(new Runnable() {
            public final void run() {
                boolean z10 = false;
                if (ax.this.f15468b.f15479a.b("sync", false)) {
                    boolean a10 = ax.this.f15468b.a();
                    try {
                        if (d.h(y.a())) {
                            z10 = ax.a(a10);
                        }
                    } catch (Throwable th) {
                        UPLog.e("Notify", th);
                    }
                    ax.this.f15468b.b(!z10);
                }
            }
        });
    }

    public final void a(Activity activity, final Intent intent) {
        this.f15469c = true;
        if (activity != null && intent != null) {
            final Context applicationContext = activity.getApplicationContext();
            final String name = activity.getClass().getName();
            b.b(new Runnable() {
                /* JADX WARNING: Can't wrap try/catch for region: R(8:12|13|(2:15|16)|17|18|19|20|(2:22|32)(1:34)) */
                /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0089 */
                /* JADX WARNING: Removed duplicated region for block: B:22:0x0107 A[Catch:{ all -> 0x010d }] */
                /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
                /* JADX WARNING: Unknown top exception splitter block from list: {B:17:0x0089=Splitter:B:17:0x0089, B:24:0x010e=Splitter:B:24:0x010e} */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                        r12 = this;
                        java.lang.String r0 = ""
                        java.lang.String r1 = "pkg"
                        java.lang.String r2 = "data"
                        com.umeng.message.proguard.ax r3 = com.umeng.message.proguard.ax.this     // Catch:{ all -> 0x011a }
                        android.content.Context r4 = r0     // Catch:{ all -> 0x011a }
                        android.content.Intent r5 = r4     // Catch:{ all -> 0x011a }
                        java.lang.String r6 = r3     // Catch:{ all -> 0x011a }
                        com.umeng.message.proguard.ay r7 = r3.f15468b     // Catch:{ all -> 0x011a }
                        long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x011a }
                        r7.a((long) r8)     // Catch:{ all -> 0x011a }
                        java.lang.String r7 = r5.getStringExtra(r2)     // Catch:{ all -> 0x011a }
                        java.lang.String r8 = r5.getStringExtra(r1)     // Catch:{ all -> 0x011a }
                        r5.removeExtra(r2)     // Catch:{ all -> 0x011a }
                        r5.removeExtra(r1)     // Catch:{ all -> 0x011a }
                        boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x011a }
                        r9 = 0
                        if (r1 != 0) goto L_0x0114
                        boolean r1 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x011a }
                        if (r1 == 0) goto L_0x0035
                        goto L_0x0114
                    L_0x0035:
                        r1 = 24
                        byte[] r2 = new byte[r1]     // Catch:{ all -> 0x011a }
                        r2 = {100, 85, 120, 112, 78, 67, 57, 109, 78, 67, 116, 81, 89, 106, 77, 53, 76, 108, 81, 120, 79, 81, 61, 61} // fill-array     // Catch:{ all -> 0x011a }
                        java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x011a }
                        java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x011a }
                        r11.<init>(r2)     // Catch:{ all -> 0x011a }
                        byte[] r2 = com.umeng.message.proguard.bf.a((java.lang.String) r11)     // Catch:{ all -> 0x011a }
                        r5.<init>(r2)     // Catch:{ all -> 0x011a }
                        byte[] r1 = new byte[r1]     // Catch:{ all -> 0x011a }
                        r1 = {98, 109, 49, 108, 100, 87, 99, 117, 90, 106, 107, 118, 84, 50, 48, 114, 84, 68, 103, 121, 77, 119, 61, 61} // fill-array     // Catch:{ all -> 0x011a }
                        java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x011a }
                        r2.<init>(r1)     // Catch:{ all -> 0x011a }
                        byte[] r1 = com.umeng.message.proguard.bf.a((java.lang.String) r2)     // Catch:{ all -> 0x011a }
                        java.lang.String r2 = com.umeng.message.proguard.bk.b(r8, r5, r1)     // Catch:{ all -> 0x011a }
                        java.lang.String r1 = com.umeng.message.proguard.bk.b(r7, r5, r1)     // Catch:{ all -> 0x011a }
                        boolean r5 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x011a }
                        if (r5 != 0) goto L_0x010e
                        boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x011a }
                        if (r2 == 0) goto L_0x006e
                        goto L_0x010e
                    L_0x006e:
                        org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x011a }
                        r2.<init>(r1)     // Catch:{ all -> 0x011a }
                        java.lang.String r1 = "activity"
                        r2.put(r1, r6)     // Catch:{ all -> 0x011a }
                        com.umeng.message.proguard.ay r1 = r3.f15468b     // Catch:{ all -> 0x011a }
                        java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x011a }
                        r6 = 0
                        if (r5 == 0) goto L_0x0089
                        byte[] r5 = r5.getBytes()     // Catch:{ Exception -> 0x0089 }
                        java.lang.String r6 = com.umeng.message.proguard.bf.a((byte[]) r5)     // Catch:{ Exception -> 0x0089 }
                    L_0x0089:
                        com.umeng.message.proguard.bd r1 = r1.f15479a     // Catch:{ all -> 0x011a }
                        java.lang.String r5 = "info"
                        r1.a((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ all -> 0x011a }
                        java.lang.String r1 = "action_type"
                        r5 = 71
                        r2.put(r1, r5)     // Catch:{ all -> 0x011a }
                        java.lang.String r1 = "device_token"
                        com.umeng.message.PushAgent r5 = com.umeng.message.PushAgent.getInstance(r4)     // Catch:{ all -> 0x011a }
                        java.lang.String r5 = r5.getRegistrationId()     // Catch:{ all -> 0x011a }
                        r2.put(r1, r5)     // Catch:{ all -> 0x011a }
                        java.lang.String r1 = "msg_id"
                        r2.put(r1, r0)     // Catch:{ all -> 0x011a }
                        java.lang.String r1 = "pa"
                        r2.put(r1, r0)     // Catch:{ all -> 0x011a }
                        java.lang.String r0 = "ts"
                        long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x011a }
                        r2.put(r0, r5)     // Catch:{ all -> 0x011a }
                        org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x011a }
                        r0.<init>()     // Catch:{ all -> 0x011a }
                        org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x011a }
                        r1.<init>()     // Catch:{ all -> 0x011a }
                        java.lang.String r5 = "din"
                        java.lang.String r6 = com.umeng.message.proguard.d.c(r4)     // Catch:{ all -> 0x011a }
                        r1.put(r5, r6)     // Catch:{ all -> 0x011a }
                        java.lang.String r5 = "p_sdk_v"
                        java.lang.String r6 = "6.7.0"
                        r1.put(r5, r6)     // Catch:{ all -> 0x011a }
                        java.lang.String r5 = "push_switch"
                        java.lang.String r6 = com.umeng.message.proguard.d.p(r4)     // Catch:{ all -> 0x011a }
                        r1.put(r5, r6)     // Catch:{ all -> 0x011a }
                        java.lang.String r5 = "header"
                        r0.put(r5, r1)     // Catch:{ all -> 0x011a }
                        org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ all -> 0x011a }
                        r1.<init>()     // Catch:{ all -> 0x011a }
                        r1.put(r2)     // Catch:{ all -> 0x011a }
                        org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x011a }
                        r2.<init>()     // Catch:{ all -> 0x011a }
                        java.lang.String r5 = "push"
                        r2.put(r5, r1)     // Catch:{ all -> 0x011a }
                        java.lang.String r1 = "content"
                        r0.put(r1, r2)     // Catch:{ all -> 0x011a }
                        com.umeng.commonsdk.framework.UMLogDataProtocol r1 = com.umeng.message.proguard.w.a()     // Catch:{ all -> 0x011a }
                        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x011a }
                        r2 = 16385(0x4001, float:2.296E-41)
                        com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r4, r2, r1, r0)     // Catch:{ all -> 0x011a }
                        com.umeng.message.api.UPushMessageNotifyApi$Callback r0 = r3.f15467a     // Catch:{ all -> 0x010d }
                        if (r0 == 0) goto L_0x010d
                        r0.onNotified()     // Catch:{ all -> 0x010d }
                        r0 = 0
                        r3.f15469c = r0     // Catch:{ all -> 0x010d }
                    L_0x010d:
                        return
                    L_0x010e:
                        com.umeng.message.proguard.ay r0 = r3.f15468b     // Catch:{ all -> 0x011a }
                        r0.a((long) r9)     // Catch:{ all -> 0x011a }
                        return
                    L_0x0114:
                        com.umeng.message.proguard.ay r0 = r3.f15468b     // Catch:{ all -> 0x011a }
                        r0.a((long) r9)     // Catch:{ all -> 0x011a }
                        return
                    L_0x011a:
                        r0 = move-exception
                        java.lang.String r1 = "Notify"
                        com.umeng.message.common.UPLog.e((java.lang.String) r1, (java.lang.Throwable) r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.ax.AnonymousClass3.run():void");
                }
            });
        }
    }

    public static boolean a(boolean z10) {
        JSONObject jSONObject;
        Application a10 = y.a();
        String zid = UMUtils.getZid(a10);
        if (TextUtils.isEmpty(zid)) {
            UPLog.i("Notify", "zid skip.");
            return false;
        }
        String messageAppkey = PushAgent.getInstance(a10).getMessageAppkey();
        if (TextUtils.isEmpty(messageAppkey)) {
            UPLog.i("Notify", "appkey skip.");
            return false;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(bt.al, zid);
        jSONObject2.put("ts", System.currentTimeMillis());
        jSONObject2.put("appkey", messageAppkey);
        jSONObject2.put("dps", z10 ? 1 : 0);
        try {
            jSONObject = g.a(jSONObject2, "https://offmsg.umeng.com/v2/offmsg/switch", messageAppkey, false);
        } catch (Exception e10) {
            UPLog.i("Notify", "uploadEnableState error:", e10.getMessage());
            jSONObject = null;
        }
        return jSONObject != null;
    }

    public static boolean a(Context context, String str, String str2, String str3, String str4) {
        try {
            String messageAppkey = PushAgent.getInstance(context).getMessageAppkey();
            ComponentName componentName = new ComponentName(str3, str4);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("trace_id", str2);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appkey", messageAppkey);
            jSONObject2.put("pkg", context.getPackageName());
            jSONObject2.put("activity", str);
            jSONObject2.put(ITagManager.SUCCESS, 1);
            jSONArray.put(jSONObject2);
            jSONObject.put("pusor", jSONArray);
            String jSONObject3 = jSONObject.toString();
            String str5 = new String(bf.a("dUxpNC9mNCtQYjM5LlQxOQ=="));
            byte[] a10 = bf.a("bm1ldWcuZjkvT20rTDgyMw==");
            String a11 = bk.a(context.getPackageName(), str5, a10);
            String a12 = bk.a(jSONObject3, str5, a10);
            Intent intent = new Intent();
            intent.putExtra("data", a12);
            intent.putExtra("pkg", a11);
            intent.setPackage(str3);
            intent.setComponent(componentName);
            intent.setFlags(268468224);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void a(JSONObject jSONObject) {
        try {
            if (this.f15468b.c()) {
                String d10 = this.f15468b.d();
                if (!TextUtils.isEmpty(d10)) {
                    JSONObject jSONObject2 = new JSONObject(d10);
                    jSONObject.put("activity", jSONObject2.optString("activity"));
                    jSONObject.put("pusor", jSONObject2.optJSONArray("pusor"));
                    jSONObject.put("trace_id", jSONObject2.optString("trace_id"));
                }
            }
        } catch (Throwable th) {
            UPLog.e("Notify", "handle msg arrived error:", th);
        }
    }
}
