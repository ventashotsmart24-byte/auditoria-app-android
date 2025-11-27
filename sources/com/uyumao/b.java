package com.uyumao;

import android.content.Context;

public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f16250a;

    public b(Context context) {
        this.f16250a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x006a A[Catch:{ all -> 0x006f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r7 = this;
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x006f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x006f }
            r1.<init>()     // Catch:{ all -> 0x006f }
            android.content.Context r2 = r7.f16250a     // Catch:{ all -> 0x006f }
            java.io.File r2 = r2.getCacheDir()     // Catch:{ all -> 0x006f }
            r1.append(r2)     // Catch:{ all -> 0x006f }
            java.lang.String r2 = java.io.File.separator     // Catch:{ all -> 0x006f }
            r1.append(r2)     // Catch:{ all -> 0x006f }
            java.lang.String r2 = "net_change"
            r1.append(r2)     // Catch:{ all -> 0x006f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x006f }
            r0.<init>(r1)     // Catch:{ all -> 0x006f }
            java.lang.String r0 = com.uyumao.e.b((java.io.File) r0)     // Catch:{ all -> 0x006f }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x006f }
            r2 = 0
            if (r1 != 0) goto L_0x004b
            java.lang.String r1 = "\n"
            java.lang.String[] r0 = r0.split(r1)     // Catch:{ all -> 0x006f }
            int r1 = r0.length     // Catch:{ all -> 0x006f }
            if (r1 <= 0) goto L_0x004b
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ all -> 0x006f }
            r1.<init>()     // Catch:{ all -> 0x006f }
            int r3 = r0.length     // Catch:{ all -> 0x006f }
            r4 = 0
        L_0x003c:
            if (r4 >= r3) goto L_0x004c
            r5 = r0[r4]     // Catch:{ all -> 0x006f }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x006f }
            r6.<init>(r5)     // Catch:{ all -> 0x006f }
            r1.put(r6)     // Catch:{ all -> 0x006f }
            int r4 = r4 + 1
            goto L_0x003c
        L_0x004b:
            r1 = 0
        L_0x004c:
            android.content.Context r0 = r7.f16250a     // Catch:{ all -> 0x006f }
            android.content.Context r3 = com.uyumao.j.f16286a     // Catch:{ all -> 0x006f }
            if (r3 != 0) goto L_0x005a
            if (r0 == 0) goto L_0x005a
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x006f }
            com.uyumao.j.f16286a = r0     // Catch:{ all -> 0x006f }
        L_0x005a:
            com.uyumao.j r0 = com.uyumao.j.a.f16287a     // Catch:{ all -> 0x006f }
            com.uyumao.i r0 = r0.a()     // Catch:{ all -> 0x006f }
            android.content.Context r3 = r7.f16250a     // Catch:{ all -> 0x006f }
            org.json.JSONObject r0 = com.uyumao.c.a((android.content.Context) r3, (com.uyumao.i) r0, (org.json.JSONArray) r1)     // Catch:{ all -> 0x006f }
            android.content.Context r3 = r7.f16250a     // Catch:{ all -> 0x006f }
            if (r1 == 0) goto L_0x006b
            r2 = 1
        L_0x006b:
            com.uyumao.c.a((android.content.Context) r3, (org.json.JSONObject) r0, (boolean) r2)     // Catch:{ all -> 0x006f }
            goto L_0x0073
        L_0x006f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uyumao.b.run():void");
    }
}
