package com.taobao.accs.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.taobao.accs.base.IBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.net.a;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.v;
import java.util.concurrent.ConcurrentHashMap;

public abstract class d implements IBaseService {

    /* renamed from: a  reason: collision with root package name */
    protected static ConcurrentHashMap<String, a> f13019a = new ConcurrentHashMap<>(2);

    /* renamed from: b  reason: collision with root package name */
    private Context f13020b;

    /* renamed from: c  reason: collision with root package name */
    private Service f13021c;

    public d(Service service) {
        this.f13021c = service;
        this.f13020b = service.getApplicationContext();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a7, code lost:
        if (r11 == false) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r1.a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.taobao.accs.net.a a(android.content.Context r9, java.lang.String r10, boolean r11) {
        /*
            r0 = 0
            r1 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x00b0 }
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L_0x0039
            java.lang.String r9 = "ElectionServiceImpl"
            java.lang.String r10 = "getConnection configTag null or env invalid"
            java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch:{ all -> 0x00b0 }
            java.lang.String r2 = "conns.size"
            r11[r0] = r2     // Catch:{ all -> 0x00b0 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.taobao.accs.net.a> r2 = f13019a     // Catch:{ all -> 0x00b0 }
            int r2 = r2.size()     // Catch:{ all -> 0x00b0 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00b0 }
            r11[r3] = r2     // Catch:{ all -> 0x00b0 }
            com.taobao.accs.utl.ALog.w(r9, r10, r11)     // Catch:{ all -> 0x00b0 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.taobao.accs.net.a> r9 = f13019a     // Catch:{ all -> 0x00b0 }
            int r9 = r9.size()     // Catch:{ all -> 0x00b0 }
            if (r9 <= 0) goto L_0x0038
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.taobao.accs.net.a> r9 = f13019a     // Catch:{ all -> 0x00b0 }
            java.util.Enumeration r9 = r9.elements()     // Catch:{ all -> 0x00b0 }
            java.lang.Object r9 = r9.nextElement()     // Catch:{ all -> 0x00b0 }
            com.taobao.accs.net.a r9 = (com.taobao.accs.net.a) r9     // Catch:{ all -> 0x00b0 }
            r1 = r9
        L_0x0038:
            return r1
        L_0x0039:
            java.lang.String r2 = "ElectionServiceImpl"
            java.lang.String r5 = "getConnection"
            r6 = 4
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x00b0 }
            java.lang.String r7 = "configTag"
            r6[r0] = r7     // Catch:{ all -> 0x00b0 }
            r6[r3] = r10     // Catch:{ all -> 0x00b0 }
            java.lang.String r7 = "start"
            r6[r4] = r7     // Catch:{ all -> 0x00b0 }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r11)     // Catch:{ all -> 0x00b0 }
            r8 = 3
            r6[r8] = r7     // Catch:{ all -> 0x00b0 }
            com.taobao.accs.utl.ALog.i(r2, r5, r6)     // Catch:{ all -> 0x00b0 }
            com.taobao.accs.AccsClientConfig r2 = com.taobao.accs.AccsClientConfig.getConfigByTag(r10)     // Catch:{ all -> 0x00b0 }
            if (r2 == 0) goto L_0x0070
            boolean r2 = r2.getDisableChannel()     // Catch:{ all -> 0x00b0 }
            if (r2 == 0) goto L_0x0070
            java.lang.String r9 = "ElectionServiceImpl"
            java.lang.String r11 = "getConnection channel disabled!"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ all -> 0x00b0 }
            java.lang.String r4 = "configTag"
            r2[r0] = r4     // Catch:{ all -> 0x00b0 }
            r2[r3] = r10     // Catch:{ all -> 0x00b0 }
            com.taobao.accs.utl.ALog.e(r9, r11, r2)     // Catch:{ all -> 0x00b0 }
            return r1
        L_0x0070:
            int r2 = com.taobao.accs.utl.v.b(r9)     // Catch:{ all -> 0x00b0 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
            r3.<init>()     // Catch:{ all -> 0x00b0 }
            r3.append(r10)     // Catch:{ all -> 0x00b0 }
            java.lang.String r4 = "|"
            r3.append(r4)     // Catch:{ all -> 0x00b0 }
            r3.append(r2)     // Catch:{ all -> 0x00b0 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00b0 }
            java.lang.Class<com.taobao.accs.internal.d> r4 = com.taobao.accs.internal.d.class
            monitor-enter(r4)     // Catch:{ all -> 0x00b0 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.taobao.accs.net.a> r5 = f13019a     // Catch:{ all -> 0x00ad }
            java.lang.Object r5 = r5.get(r3)     // Catch:{ all -> 0x00ad }
            com.taobao.accs.net.a r5 = (com.taobao.accs.net.a) r5     // Catch:{ all -> 0x00ad }
            if (r5 != 0) goto L_0x00a5
            com.taobao.accs.AccsClientConfig.mEnv = r2     // Catch:{ all -> 0x00a2 }
            com.taobao.accs.net.v r1 = new com.taobao.accs.net.v     // Catch:{ all -> 0x00a2 }
            r1.<init>(r9, r0, r10)     // Catch:{ all -> 0x00a2 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.taobao.accs.net.a> r9 = f13019a     // Catch:{ all -> 0x00ad }
            r9.put(r3, r1)     // Catch:{ all -> 0x00ad }
            goto L_0x00a6
        L_0x00a2:
            r9 = move-exception
            r1 = r5
            goto L_0x00ae
        L_0x00a5:
            r1 = r5
        L_0x00a6:
            monitor-exit(r4)     // Catch:{ all -> 0x00ad }
            if (r11 == 0) goto L_0x00ba
            r1.a()     // Catch:{ all -> 0x00b0 }
            goto L_0x00ba
        L_0x00ad:
            r9 = move-exception
        L_0x00ae:
            monitor-exit(r4)     // Catch:{ all -> 0x00ad }
            throw r9     // Catch:{ all -> 0x00b0 }
        L_0x00b0:
            r9 = move-exception
            java.lang.String r10 = "ElectionServiceImpl"
            java.lang.String r11 = "getConnection"
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.taobao.accs.utl.ALog.e(r10, r11, r9, r0)
        L_0x00ba:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.internal.d.a(android.content.Context, java.lang.String, boolean):com.taobao.accs.net.a");
    }

    private void b(Intent intent) {
        Intent intent2 = intent;
        try {
            String stringExtra = intent2.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent2.getStringExtra(Constants.KEY_APP_KEY);
            String stringExtra3 = intent2.getStringExtra(Constants.KEY_TTID);
            String stringExtra4 = intent2.getStringExtra("app_sercet");
            String stringExtra5 = intent2.getStringExtra(Constants.KEY_CONFIG_TAG);
            int intExtra = intent2.getIntExtra(Constants.KEY_MODE, 0);
            ALog.i("ElectionServiceImpl", "handleStartCommand", Constants.KEY_CONFIG_TAG, stringExtra5, "appkey", stringExtra2, "appSecret", stringExtra4, Constants.KEY_TTID, stringExtra3, "pkg", stringExtra);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2) && stringExtra.equals(this.f13020b.getPackageName())) {
                v.a(this.f13020b, intExtra);
                a a10 = a(this.f13020b, stringExtra5, false);
                if (a10 != null) {
                    a10.f13025a = stringExtra3;
                    return;
                }
                ALog.e("ElectionServiceImpl", "handleStartCommand start action, no connection", Constants.KEY_CONFIG_TAG, stringExtra5);
            }
        } catch (Throwable th) {
            ALog.e("ElectionServiceImpl", "handleStartCommand", th, new Object[0]);
        }
    }

    public abstract int a(Intent intent);

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        ALog.i("ElectionServiceImpl", "onCreate,", Constants.KEY_SDK_VERSION, Integer.valueOf(Constants.SDK_VERSION_CODE));
    }

    public void onDestroy() {
        ALog.e("ElectionServiceImpl", "Service onDestroy", new Object[0]);
        this.f13020b = null;
        this.f13021c = null;
    }

    public int onStartCommand(Intent intent, int i10, int i11) {
        if (intent == null) {
            return 2;
        }
        String action = intent.getAction();
        ALog.i("ElectionServiceImpl", "onStartCommand begin", "action", action);
        if (TextUtils.equals(action, Constants.ACTION_START_SERVICE)) {
            b(intent);
        }
        return a(intent);
    }

    public boolean onUnbind(Intent intent) {
        return false;
    }

    public static a b(Context context, String str, boolean z10) {
        return a(context, str, z10);
    }
}
