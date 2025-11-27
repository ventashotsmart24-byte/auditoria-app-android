package com.uyumao.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.ccg.ActionInfo;
import com.uyumao.d;
import com.uyumao.g;
import com.uyumao.t;
import java.lang.reflect.Method;
import org.json.JSONObject;

public class UYMManager {

    /* renamed from: a  reason: collision with root package name */
    public static UYMManager f16322a;

    public class a implements ActionInfo {
        public a(UYMManager uYMManager) {
        }

        public String getModule(Context context) {
            return "anti";
        }

        public String[] getSupportAction(Context context) {
            return new String[]{com.umeng.ccg.a.f14512e, com.umeng.ccg.a.f14511d, com.umeng.ccg.a.f14510c, com.umeng.ccg.a.f14509b};
        }

        public boolean getSwitchState(Context context, String str) {
            boolean z10;
            if (com.umeng.ccg.a.f14512e.equals(str)) {
                z10 = d.f16258f;
            } else {
                z10 = false;
            }
            if (com.umeng.ccg.a.f14511d.equals(str)) {
                boolean z11 = d.f16253a;
                boolean z12 = d.f16254b;
                if (z11 || z12) {
                    z10 = true;
                }
            }
            if (com.umeng.ccg.a.f14510c.equals(str)) {
                z10 = d.f16257e;
            }
            if (com.umeng.ccg.a.f14509b.equals(str)) {
                boolean z13 = d.f16255c;
                boolean z14 = d.f16256d;
                if (z13 || z14) {
                    return true;
                }
            }
            return z10;
        }

        public void onCommand(Context context, String str, Object obj) {
            Integer num;
            JSONObject jSONObject = (JSONObject) obj;
            boolean z10 = d.f16253a;
            d.f16259g = context.getApplicationContext();
            if (jSONObject != null) {
                try {
                    if (jSONObject.has("actionName") && (num = d.f16265m.get(jSONObject.optString("actionName"))) != null) {
                        g.a(context, num.intValue(), d.e.f16270a, jSONObject);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void enableYm1(Context context, boolean z10) {
        d.f16253a = z10;
    }

    public static void enableYm2(Context context, boolean z10) {
        d.f16254b = z10;
    }

    public static void enableYm3(Context context, boolean z10) {
        d.f16255c = z10;
    }

    public static void enableYm4(Context context, boolean z10) {
        d.f16256d = z10;
    }

    public static void enableYm5(Context context, boolean z10) {
        d.f16257e = z10;
    }

    public static void enableYm6(Context context, boolean z10) {
        d.f16258f = z10;
        try {
            Method a10 = t.a("com.umeng.commonsdk.UMConfigure", "enableAplCollection", (Class<?>[]) new Class[]{Boolean.TYPE});
            if (a10 != null) {
                t.a(a10, (Object) null, new Object[]{Boolean.valueOf(z10)});
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized UYMManager getInstance() {
        UYMManager uYMManager;
        synchronized (UYMManager.class) {
            if (f16322a == null) {
                f16322a = new UYMManager();
            }
            uYMManager = f16322a;
        }
        return uYMManager;
    }

    public static String getSdkVersion() {
        return "1.1.4";
    }

    public static void processEvent(Context context, String str) {
        Integer num;
        boolean z10 = d.f16253a;
        d.f16259g = context.getApplicationContext();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("actionName") && (num = d.f16265m.get(jSONObject.optString("actionName"))) != null) {
                    g.a(context, num.intValue(), d.e.f16270a, jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x006d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x008d */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0081 A[Catch:{ all -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0082 A[Catch:{ all -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0085 A[Catch:{ all -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0091 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0093 A[SYNTHETIC, Splitter:B:35:0x0093] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void init(android.content.Context r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            if (r8 != 0) goto L_0x0005
            monitor-exit(r7)
            return
        L_0x0005:
            android.content.Context r0 = r8.getApplicationContext()     // Catch:{ all -> 0x00c3 }
            boolean r1 = com.uyumao.c.f16251a     // Catch:{ all -> 0x00c3 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0010
            goto L_0x006d
        L_0x0010:
            com.uyumao.c.f16251a = r2     // Catch:{ all -> 0x00c3 }
            java.lang.String r1 = "uyumao_info"
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r1, r3)     // Catch:{ all -> 0x00c3 }
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x00c3 }
            java.util.Locale r5 = java.util.Locale.getDefault()     // Catch:{ all -> 0x00c3 }
            java.lang.String r6 = "yyyyMMdd"
            r4.<init>(r6, r5)     // Catch:{ all -> 0x00c3 }
            java.util.Date r5 = new java.util.Date     // Catch:{ all -> 0x00c3 }
            r5.<init>()     // Catch:{ all -> 0x00c3 }
            java.lang.String r4 = r4.format(r5)     // Catch:{ all -> 0x00c3 }
            boolean r1 = r1.getBoolean(r4, r3)     // Catch:{ all -> 0x00c3 }
            if (r1 == 0) goto L_0x0040
            java.lang.Thread r1 = new java.lang.Thread     // Catch:{ all -> 0x00c3 }
            com.uyumao.a r4 = new com.uyumao.a     // Catch:{ all -> 0x00c3 }
            r4.<init>(r0)     // Catch:{ all -> 0x00c3 }
            r1.<init>(r4)     // Catch:{ all -> 0x00c3 }
            r1.start()     // Catch:{ all -> 0x00c3 }
            goto L_0x0050
        L_0x0040:
            com.uyumao.b r1 = new com.uyumao.b     // Catch:{ all -> 0x00c3 }
            r1.<init>(r0)     // Catch:{ all -> 0x00c3 }
            com.uyumao.l r4 = com.uyumao.l.a()     // Catch:{ all -> 0x00c3 }
            java.util.concurrent.ExecutorService r4 = r4.b()     // Catch:{ all -> 0x00c3 }
            r4.execute(r1)     // Catch:{ all -> 0x00c3 }
        L_0x0050:
            com.uyumao.h r1 = com.uyumao.c.f16252b     // Catch:{ all -> 0x006d }
            if (r1 == 0) goto L_0x0057
            r0.unregisterReceiver(r1)     // Catch:{ all -> 0x006d }
        L_0x0057:
            com.uyumao.h r1 = new com.uyumao.h     // Catch:{ all -> 0x006d }
            r1.<init>()     // Catch:{ all -> 0x006d }
            com.uyumao.c.f16252b = r1     // Catch:{ all -> 0x006d }
            android.content.IntentFilter r1 = new android.content.IntentFilter     // Catch:{ all -> 0x006d }
            r1.<init>()     // Catch:{ all -> 0x006d }
            java.lang.String r4 = "android.net.conn.CONNECTIVITY_CHANGE"
            r1.addAction(r4)     // Catch:{ all -> 0x006d }
            com.uyumao.h r4 = com.uyumao.c.f16252b     // Catch:{ all -> 0x006d }
            r0.registerReceiver(r4, r1)     // Catch:{ all -> 0x006d }
        L_0x006d:
            com.uyumao.e.f16271a = r8     // Catch:{ all -> 0x00c3 }
            java.lang.Class<com.umeng.commonsdk.UMConfigure> r8 = com.umeng.commonsdk.UMConfigure.class
            com.umeng.commonsdk.debug.UMLog r0 = com.umeng.commonsdk.UMConfigure.umDebugLog     // Catch:{ all -> 0x008d }
            java.lang.Class<com.umeng.ccg.ActionInfo> r0 = com.umeng.ccg.ActionInfo.class
            java.lang.String r1 = "registerActionInfo"
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch:{ all -> 0x008d }
            r4[r3] = r0     // Catch:{ all -> 0x008d }
            java.lang.reflect.Method r8 = r8.getDeclaredMethod(r1, r4)     // Catch:{ all -> 0x008d }
            if (r8 == 0) goto L_0x0082
            goto L_0x0083
        L_0x0082:
            r2 = 0
        L_0x0083:
            if (r2 == 0) goto L_0x008d
            com.uyumao.sdk.UYMManager$a r8 = new com.uyumao.sdk.UYMManager$a     // Catch:{ all -> 0x008d }
            r8.<init>(r7)     // Catch:{ all -> 0x008d }
            com.umeng.commonsdk.UMConfigure.registerActionInfo(r8)     // Catch:{ all -> 0x008d }
        L_0x008d:
            boolean r8 = com.uyumao.d.f16258f     // Catch:{ all -> 0x00c3 }
            if (r8 != 0) goto L_0x0093
            monitor-exit(r7)
            return
        L_0x0093:
            java.lang.ref.WeakReference<java.util.concurrent.Future<?>> r8 = com.uyumao.e.f16272b     // Catch:{ all -> 0x00bd }
            if (r8 == 0) goto L_0x00ac
            java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x00bd }
            java.util.concurrent.Future r8 = (java.util.concurrent.Future) r8     // Catch:{ all -> 0x00bd }
            if (r8 == 0) goto L_0x00ac
            boolean r0 = r8.isDone()     // Catch:{ all -> 0x00bd }
            if (r0 != 0) goto L_0x00ac
            boolean r8 = r8.isCancelled()     // Catch:{ all -> 0x00bd }
            if (r8 != 0) goto L_0x00ac
            goto L_0x00c1
        L_0x00ac:
            com.uyumao.q r8 = new com.uyumao.q     // Catch:{ all -> 0x00bd }
            r8.<init>()     // Catch:{ all -> 0x00bd }
            java.util.concurrent.Future r8 = com.uyumao.s.a(r8)     // Catch:{ all -> 0x00bd }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x00bd }
            r0.<init>(r8)     // Catch:{ all -> 0x00bd }
            com.uyumao.e.f16272b = r0     // Catch:{ all -> 0x00bd }
            goto L_0x00c1
        L_0x00bd:
            r8 = move-exception
            r8.printStackTrace()     // Catch:{ all -> 0x00c3 }
        L_0x00c1:
            monitor-exit(r7)
            return
        L_0x00c3:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uyumao.sdk.UYMManager.init(android.content.Context):void");
    }
}
