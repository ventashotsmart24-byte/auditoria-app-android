package com.umeng.message.proguard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.taobao.accs.EventReceiver;
import com.taobao.agoo.AgooCommondReceiver;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.message.common.UPLog;
import org.json.JSONObject;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f15958a = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f15959b = true;

    public static class a extends BroadcastReceiver {
        private a() {
        }

        public final void onReceive(final Context context, final Intent intent) {
            if (i.f15959b && intent != null && intent.getData() != null) {
                b.c(new Runnable() {
                    public final void run() {
                        try {
                            i.a(context, intent);
                        } catch (Throwable th) {
                            UPLog.e("ReceiverHelper", th);
                        }
                    }
                });
            }
        }

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    public static class b extends BroadcastReceiver {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final BroadcastReceiver f15963a = new EventReceiver();

        public final void onReceive(final Context context, final Intent intent) {
            if (intent != null) {
                b.c(new Runnable() {
                    public final void run() {
                        try {
                            b.this.f15963a.onReceive(context, intent);
                        } catch (Throwable th) {
                            UPLog.e("ReceiverHelper", th);
                        }
                    }
                });
            }
        }
    }

    public static void a(boolean z10) {
        f15959b = z10;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:12|13|14|(1:16)(1:17)|18|19|(2:21|22)(8:23|24|(1:26)(1:27)|28|30|31|32|33)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x003d */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0043 A[SYNTHETIC, Splitter:B:23:0x0043] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a() {
        /*
            java.lang.Class<com.umeng.message.proguard.i> r0 = com.umeng.message.proguard.i.class
            monitor-enter(r0)
            boolean r1 = f15958a     // Catch:{ all -> 0x0072 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            android.app.Application r1 = com.umeng.message.proguard.y.a()     // Catch:{ all -> 0x0072 }
            if (r1 != 0) goto L_0x0011
            monitor-exit(r0)
            return
        L_0x0011:
            r2 = 2
            r3 = 33
            android.content.IntentFilter r4 = new android.content.IntentFilter     // Catch:{ all -> 0x003d }
            r4.<init>()     // Catch:{ all -> 0x003d }
            java.lang.String r5 = "android.intent.action.SCREEN_ON"
            r4.addAction(r5)     // Catch:{ all -> 0x003d }
            java.lang.String r5 = "android.intent.action.SCREEN_OFF"
            r4.addAction(r5)     // Catch:{ all -> 0x003d }
            java.lang.String r5 = "android.intent.action.USER_PRESENT"
            r4.addAction(r5)     // Catch:{ all -> 0x003d }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x003d }
            if (r5 < r3) goto L_0x0035
            com.umeng.message.proguard.i$b r5 = new com.umeng.message.proguard.i$b     // Catch:{ all -> 0x003d }
            r5.<init>()     // Catch:{ all -> 0x003d }
            android.content.Intent unused = r1.registerReceiver(r5, r4, r2)     // Catch:{ all -> 0x003d }
            goto L_0x003d
        L_0x0035:
            com.umeng.message.proguard.i$b r5 = new com.umeng.message.proguard.i$b     // Catch:{ all -> 0x003d }
            r5.<init>()     // Catch:{ all -> 0x003d }
            r1.registerReceiver(r5, r4)     // Catch:{ all -> 0x003d }
        L_0x003d:
            boolean r4 = f15959b     // Catch:{ all -> 0x0072 }
            if (r4 != 0) goto L_0x0043
            monitor-exit(r0)
            return
        L_0x0043:
            android.content.IntentFilter r4 = new android.content.IntentFilter     // Catch:{ all -> 0x006d }
            r4.<init>()     // Catch:{ all -> 0x006d }
            java.lang.String r5 = "android.intent.action.PACKAGE_ADDED"
            r4.addAction(r5)     // Catch:{ all -> 0x006d }
            java.lang.String r5 = "android.intent.action.PACKAGE_REMOVED"
            r4.addAction(r5)     // Catch:{ all -> 0x006d }
            java.lang.String r5 = "package"
            r4.addDataScheme(r5)     // Catch:{ all -> 0x006d }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x006d }
            r6 = 0
            if (r5 < r3) goto L_0x0065
            com.umeng.message.proguard.i$a r3 = new com.umeng.message.proguard.i$a     // Catch:{ all -> 0x006d }
            r3.<init>(r6)     // Catch:{ all -> 0x006d }
            android.content.Intent unused = r1.registerReceiver(r3, r4, r2)     // Catch:{ all -> 0x006d }
            goto L_0x006d
        L_0x0065:
            com.umeng.message.proguard.i$a r2 = new com.umeng.message.proguard.i$a     // Catch:{ all -> 0x006d }
            r2.<init>(r6)     // Catch:{ all -> 0x006d }
            r1.registerReceiver(r2, r4)     // Catch:{ all -> 0x006d }
        L_0x006d:
            r1 = 1
            f15958a = r1     // Catch:{ all -> 0x0072 }
            monitor-exit(r0)
            return
        L_0x0072:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.i.a():void");
    }

    private static void a(String str, int i10) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pkg", str);
            jSONObject.put("action_type", i10);
            UMWorkDispatch.sendEvent(y.a(), 16390, w.a(), jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ void a(Context context, Intent intent) {
        Uri data;
        if (intent != null && (data = intent.getData()) != null) {
            boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
            String action = intent.getAction();
            String schemeSpecificPart = data.getSchemeSpecificPart();
            if (schemeSpecificPart != null && schemeSpecificPart.length() != 0) {
                if ("android.intent.action.PACKAGE_REMOVED".equals(action) && !booleanExtra) {
                    a(schemeSpecificPart, 80);
                    new AgooCommondReceiver().onReceive(context, intent);
                } else if (!"android.intent.action.PACKAGE_ADDED".equals(action)) {
                } else {
                    if (booleanExtra) {
                        a(schemeSpecificPart, 81);
                    } else {
                        a(schemeSpecificPart, 82);
                    }
                }
            }
        }
    }
}
