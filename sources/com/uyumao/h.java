package com.uyumao;

import android.content.BroadcastReceiver;
import android.content.Context;
import java.io.File;
import org.json.JSONObject;

public class h extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public long f16277a = 0;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f16278a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f16279b;

        public a(h hVar, Context context, JSONObject jSONObject) {
            this.f16278a = context;
            this.f16279b = jSONObject;
        }

        public void run() {
            File file = new File(this.f16278a.getCacheDir().getPath() + File.separator + "net_change");
            StringBuilder sb = new StringBuilder();
            sb.append(this.f16279b.toString());
            sb.append("\n");
            e.a(file, sb.toString().getBytes(), true);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x010e A[Catch:{ all -> 0x0122, all -> 0x0126 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r12, android.content.Intent r13) {
        /*
            r11 = this;
            java.lang.String r0 = "android.net.conn.CONNECTIVITY_CHANGE"
            java.lang.String r13 = r13.getAction()     // Catch:{ all -> 0x0126 }
            boolean r13 = r0.equals(r13)     // Catch:{ all -> 0x0126 }
            if (r13 == 0) goto L_0x0126
            java.lang.String r13 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r13 = com.uyumao.e.a((android.content.Context) r12, (java.lang.String) r13)     // Catch:{ all -> 0x0126 }
            if (r13 != 0) goto L_0x0015
            return
        L_0x0015:
            java.lang.String r13 = "connectivity"
            java.lang.Object r13 = r12.getSystemService(r13)     // Catch:{ all -> 0x0126 }
            android.net.ConnectivityManager r13 = (android.net.ConnectivityManager) r13     // Catch:{ all -> 0x0126 }
            r0 = 1
            android.net.NetworkInfo r1 = r13.getNetworkInfo(r0)     // Catch:{ all -> 0x0126 }
            r2 = 0
            android.net.NetworkInfo r13 = r13.getNetworkInfo(r2)     // Catch:{ all -> 0x0126 }
            boolean r3 = r1.isConnected()     // Catch:{ all -> 0x0126 }
            r4 = 500(0x1f4, double:2.47E-321)
            r6 = 0
            r8 = 0
            if (r3 == 0) goto L_0x006e
            boolean r3 = r13.isConnected()     // Catch:{ all -> 0x0126 }
            if (r3 == 0) goto L_0x006e
            long r9 = r11.f16277a     // Catch:{ all -> 0x0126 }
            int r1 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r1 < 0) goto L_0x004a
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0126 }
            long r9 = r11.f16277a     // Catch:{ all -> 0x0126 }
            long r6 = r6 - r9
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 > 0) goto L_0x004a
            return
        L_0x004a:
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0126 }
            r11.f16277a = r3     // Catch:{ all -> 0x0126 }
            boolean r1 = com.uyumao.d.f16255c     // Catch:{ all -> 0x0126 }
            if (r1 == 0) goto L_0x005d
            java.lang.String[] r1 = com.uyumao.e.g(r12)     // Catch:{ all -> 0x0126 }
            r2 = r1[r2]     // Catch:{ all -> 0x0126 }
            r0 = r1[r0]     // Catch:{ all -> 0x0126 }
            goto L_0x005f
        L_0x005d:
            r0 = r8
            r2 = r0
        L_0x005f:
            java.lang.String r13 = com.uyumao.e.a((android.net.NetworkInfo) r13)     // Catch:{ all -> 0x0126 }
            java.lang.String r1 = com.uyumao.e.d(r12)     // Catch:{ all -> 0x0126 }
            r3 = 3
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = 3
            goto L_0x00c4
        L_0x006e:
            boolean r3 = r1.isConnected()     // Catch:{ all -> 0x0126 }
            if (r3 != 0) goto L_0x0087
            boolean r3 = r13.isConnected()     // Catch:{ all -> 0x0126 }
            if (r3 == 0) goto L_0x0087
            java.lang.String r13 = com.uyumao.e.a((android.net.NetworkInfo) r13)     // Catch:{ all -> 0x0126 }
            java.lang.String r1 = com.uyumao.e.d(r12)     // Catch:{ all -> 0x0126 }
            r0 = 2
            r2 = r1
            r1 = r8
            r3 = r1
            goto L_0x00c4
        L_0x0087:
            boolean r1 = r1.isConnected()     // Catch:{ all -> 0x0126 }
            if (r1 == 0) goto L_0x00bf
            boolean r13 = r13.isConnected()     // Catch:{ all -> 0x0126 }
            if (r13 != 0) goto L_0x00bf
            long r9 = r11.f16277a     // Catch:{ all -> 0x0126 }
            int r13 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r13 < 0) goto L_0x00a5
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0126 }
            long r9 = r11.f16277a     // Catch:{ all -> 0x0126 }
            long r6 = r6 - r9
            int r13 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r13 > 0) goto L_0x00a5
            return
        L_0x00a5:
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0126 }
            r11.f16277a = r3     // Catch:{ all -> 0x0126 }
            boolean r13 = com.uyumao.d.f16255c     // Catch:{ all -> 0x0126 }
            if (r13 == 0) goto L_0x00ba
            java.lang.String[] r13 = com.uyumao.e.g(r12)     // Catch:{ all -> 0x0126 }
            r3 = r13[r2]     // Catch:{ all -> 0x0126 }
            r1 = r13[r0]     // Catch:{ all -> 0x0126 }
            r13 = r8
            r2 = r13
            goto L_0x00c4
        L_0x00ba:
            r13 = r8
            r1 = r13
            r2 = r1
            r3 = r2
            goto L_0x00c4
        L_0x00bf:
            r13 = r8
            r1 = r13
            r2 = r1
            r3 = r2
            r0 = 0
        L_0x00c4:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x0107 }
            r4.<init>()     // Catch:{ all -> 0x0107 }
            java.lang.String r5 = "type"
            r4.put(r5, r0)     // Catch:{ all -> 0x0104 }
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0104 }
            if (r0 != 0) goto L_0x00e4
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0104 }
            if (r0 != 0) goto L_0x00e4
            java.lang.String r0 = "wifi_ssid"
            r4.put(r0, r3)     // Catch:{ all -> 0x0104 }
            java.lang.String r0 = "wifi_bssid"
            r4.put(r0, r1)     // Catch:{ all -> 0x0104 }
        L_0x00e4:
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0104 }
            if (r0 != 0) goto L_0x00fa
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0104 }
            if (r0 != 0) goto L_0x00fa
            java.lang.String r0 = "mobile_type"
            r4.put(r0, r13)     // Catch:{ all -> 0x0104 }
            java.lang.String r13 = "mobile_carrier"
            r4.put(r13, r2)     // Catch:{ all -> 0x0104 }
        L_0x00fa:
            java.lang.String r13 = "systemtime"
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0104 }
            r4.put(r13, r0)     // Catch:{ all -> 0x0104 }
            goto L_0x010c
        L_0x0104:
            r13 = move-exception
            r8 = r4
            goto L_0x0108
        L_0x0107:
            r13 = move-exception
        L_0x0108:
            r13.printStackTrace()     // Catch:{ all -> 0x0126 }
            r4 = r8
        L_0x010c:
            if (r4 == 0) goto L_0x0126
            r4.toString()     // Catch:{ all -> 0x0126 }
            com.uyumao.l r13 = com.uyumao.l.a()     // Catch:{ all -> 0x0122 }
            java.util.concurrent.ExecutorService r13 = r13.b()     // Catch:{ all -> 0x0122 }
            com.uyumao.h$a r0 = new com.uyumao.h$a     // Catch:{ all -> 0x0122 }
            r0.<init>(r11, r12, r4)     // Catch:{ all -> 0x0122 }
            r13.execute(r0)     // Catch:{ all -> 0x0122 }
            goto L_0x0126
        L_0x0122:
            r12 = move-exception
            r12.printStackTrace()     // Catch:{ all -> 0x0126 }
        L_0x0126:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uyumao.h.onReceive(android.content.Context, android.content.Intent):void");
    }
}
