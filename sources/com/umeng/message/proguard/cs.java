package com.umeng.message.proguard;

import org.json.JSONArray;
import org.json.JSONObject;

final class cs extends cp {

    /* renamed from: a  reason: collision with root package name */
    private static final cp f15676a = new cs();

    private cs() {
    }

    public static cp a() {
        return f15676a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c3, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.umeng.message.proguard.ck r12, boolean r13, com.umeng.message.proguard.cq.a r14) {
        /*
            r11 = this;
            monitor-enter(r11)
            r0 = 1
            r1 = 0
            if (r13 != 0) goto L_0x0019
            java.lang.String r12 = "click invalid. start app fail!"
            if (r14 == 0) goto L_0x000e
            r14.a(r12)     // Catch:{ all -> 0x00d1 }
            monitor-exit(r11)
            return
        L_0x000e:
            java.lang.String r13 = "Track"
            java.lang.Object[] r14 = new java.lang.Object[r0]     // Catch:{ all -> 0x00d1 }
            r14[r1] = r12     // Catch:{ all -> 0x00d1 }
            com.umeng.message.proguard.ce.a(r13, r14)     // Catch:{ all -> 0x00d1 }
            monitor-exit(r11)
            return
        L_0x0019:
            org.json.JSONObject r13 = r12.f15606b     // Catch:{ all -> 0x00d1 }
            java.lang.String r2 = "exposed_timeout"
            boolean r13 = r13.optBoolean(r2, r1)     // Catch:{ all -> 0x00d1 }
            if (r13 == 0) goto L_0x0035
            r13 = 3000(0xbb8, float:4.204E-42)
            r11.b(r12, r13)     // Catch:{ all -> 0x00d1 }
            java.lang.String r12 = "Track"
            java.lang.Object[] r13 = new java.lang.Object[r0]     // Catch:{ all -> 0x00d1 }
            java.lang.String r14 = "click invalid. exposed timeout!"
            r13[r1] = r14     // Catch:{ all -> 0x00d1 }
            com.umeng.message.proguard.ce.a(r12, r13)     // Catch:{ all -> 0x00d1 }
            monitor-exit(r11)
            return
        L_0x0035:
            org.json.JSONObject r13 = r12.f15606b     // Catch:{ all -> 0x00d1 }
            java.lang.String r2 = "clk_tp"
            int r13 = r13.optInt(r2, r1)     // Catch:{ all -> 0x00d1 }
            if (r13 == r0) goto L_0x0044
            r2 = 2
            if (r13 == r2) goto L_0x0044
            monitor-exit(r11)
            return
        L_0x0044:
            org.json.JSONObject r2 = r12.f15606b     // Catch:{ all -> 0x00d1 }
            java.lang.String r3 = "click_upload"
            boolean r2 = r2.optBoolean(r3, r1)     // Catch:{ all -> 0x00d1 }
            if (r2 == 0) goto L_0x005b
            java.lang.String r12 = "Track"
            java.lang.Object[] r13 = new java.lang.Object[r0]     // Catch:{ all -> 0x00d1 }
            java.lang.String r14 = "click has report."
            r13[r1] = r14     // Catch:{ all -> 0x00d1 }
            com.umeng.message.proguard.ce.a(r12, r13)     // Catch:{ all -> 0x00d1 }
            monitor-exit(r11)
            return
        L_0x005b:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00d1 }
            r12.f15616l = r2     // Catch:{ all -> 0x00d1 }
            org.json.JSONObject r2 = r12.f15606b     // Catch:{ all -> 0x00d1 }
            java.lang.String r3 = "clk"
            org.json.JSONArray r2 = r2.optJSONArray(r3)     // Catch:{ all -> 0x00d1 }
            long r3 = r12.i()     // Catch:{ all -> 0x00d1 }
            if (r2 == 0) goto L_0x00c4
            int r5 = r2.length()     // Catch:{ all -> 0x00d1 }
            if (r5 <= 0) goto L_0x00c4
            int r5 = r2.length()     // Catch:{ all -> 0x00d1 }
            r6 = 0
            r7 = 1
        L_0x007b:
            if (r6 >= r5) goto L_0x009e
            java.lang.String r8 = r2.optString(r6)     // Catch:{ all -> 0x00d1 }
            java.lang.String r9 = "__TP__"
            java.lang.String r10 = java.lang.String.valueOf(r13)     // Catch:{ all -> 0x00d1 }
            java.lang.String r8 = r8.replaceAll(r9, r10)     // Catch:{ all -> 0x00d1 }
            java.lang.String r9 = "__CD__"
            java.lang.String r10 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x00d1 }
            java.lang.String r8 = r8.replaceAll(r9, r10)     // Catch:{ all -> 0x00d1 }
            r9 = 5
            boolean r8 = com.umeng.message.proguard.cc.a((int) r9, (com.umeng.message.proguard.ck) r12, (java.lang.String) r8)     // Catch:{ all -> 0x00d1 }
            r7 = r7 & r8
            int r6 = r6 + 1
            goto L_0x007b
        L_0x009e:
            org.json.JSONObject r12 = r12.f15606b     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r13 = "click_upload"
            r12.put(r13, r7)     // Catch:{ Exception -> 0x00a6 }
            goto L_0x00a7
        L_0x00a6:
        L_0x00a7:
            if (r7 == 0) goto L_0x00b0
            if (r14 == 0) goto L_0x00c2
            r14.a()     // Catch:{ all -> 0x00d1 }
            monitor-exit(r11)
            return
        L_0x00b0:
            java.lang.String r12 = "click invalid. report fail, please check network!"
            if (r14 == 0) goto L_0x00b9
            r14.a(r12)     // Catch:{ all -> 0x00d1 }
            monitor-exit(r11)
            return
        L_0x00b9:
            java.lang.String r13 = "Track"
            java.lang.Object[] r14 = new java.lang.Object[r0]     // Catch:{ all -> 0x00d1 }
            r14[r1] = r12     // Catch:{ all -> 0x00d1 }
            com.umeng.message.proguard.ce.b(r13, r14)     // Catch:{ all -> 0x00d1 }
        L_0x00c2:
            monitor-exit(r11)
            return
        L_0x00c4:
            java.lang.String r12 = "Track"
            java.lang.Object[] r13 = new java.lang.Object[r0]     // Catch:{ all -> 0x00d1 }
            java.lang.String r14 = "click invalid. clk value empty!"
            r13[r1] = r14     // Catch:{ all -> 0x00d1 }
            com.umeng.message.proguard.ce.b(r12, r13)     // Catch:{ all -> 0x00d1 }
            monitor-exit(r11)
            return
        L_0x00d1:
            r12 = move-exception
            monitor-exit(r11)
            goto L_0x00d5
        L_0x00d4:
            throw r12
        L_0x00d5:
            goto L_0x00d4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.cs.a(com.umeng.message.proguard.ck, boolean, com.umeng.message.proguard.cq$a):void");
    }

    public final void a(ck ckVar, int i10, int i11, String str, JSONObject jSONObject) {
        final ck ckVar2 = ckVar;
        final int i12 = i10;
        final int i13 = i11;
        final String str2 = str;
        final JSONObject jSONObject2 = jSONObject;
        cb.b(new Runnable() {
            /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|(1:9)|10|11) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x007a */
            /* JADX WARNING: Removed duplicated region for block: B:9:0x007e A[Catch:{ all -> 0x00cd }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r7 = this;
                    java.lang.String r0 = "slot_id"
                    r1 = 2
                    android.content.Context r2 = com.umeng.message.proguard.de.a()     // Catch:{ all -> 0x00cd }
                    java.lang.String r3 = com.umeng.commonsdk.utils.UMUtils.getAppkey(r2)     // Catch:{ all -> 0x00cd }
                    org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x00cd }
                    r4.<init>()     // Catch:{ all -> 0x00cd }
                    java.lang.String r5 = "sid"
                    com.umeng.message.proguard.ck r6 = r2     // Catch:{ all -> 0x00cd }
                    java.lang.String r6 = r6.c()     // Catch:{ all -> 0x00cd }
                    r4.put(r5, r6)     // Catch:{ all -> 0x00cd }
                    java.lang.String r5 = "zid"
                    java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getZid(r2)     // Catch:{ all -> 0x00cd }
                    r4.put(r5, r6)     // Catch:{ all -> 0x00cd }
                    java.lang.String r5 = "app_key"
                    r4.put(r5, r3)     // Catch:{ all -> 0x00cd }
                    java.lang.String r5 = "slot_type"
                    com.umeng.message.proguard.ck r6 = r2     // Catch:{ all -> 0x00cd }
                    com.umeng.message.proguard.bx$c r6 = r6.f15605a     // Catch:{ all -> 0x00cd }
                    int r6 = com.umeng.message.proguard.bt.a((com.umeng.message.proguard.bx.c) r6)     // Catch:{ all -> 0x00cd }
                    r4.put(r5, r6)     // Catch:{ all -> 0x00cd }
                    com.umeng.message.proguard.ck r5 = r2     // Catch:{ all -> 0x00cd }
                    org.json.JSONObject r5 = r5.f15606b     // Catch:{ all -> 0x00cd }
                    java.lang.String r5 = r5.optString(r0)     // Catch:{ all -> 0x00cd }
                    r4.put(r0, r5)     // Catch:{ all -> 0x00cd }
                    java.lang.String r0 = "ts"
                    long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00cd }
                    r4.put(r0, r5)     // Catch:{ all -> 0x00cd }
                    java.lang.String r0 = "e"
                    int r5 = r3     // Catch:{ all -> 0x00cd }
                    r4.put(r0, r5)     // Catch:{ all -> 0x00cd }
                    java.lang.String r0 = "code"
                    int r5 = r4     // Catch:{ all -> 0x00cd }
                    r4.put(r0, r5)     // Catch:{ all -> 0x00cd }
                    java.lang.String r0 = "msg"
                    java.lang.String r5 = r5     // Catch:{ all -> 0x00cd }
                    r4.put(r0, r5)     // Catch:{ all -> 0x00cd }
                    java.lang.String r0 = "imei_md5"
                    java.lang.String r5 = com.umeng.message.proguard.ca.f(r2)     // Catch:{ all -> 0x00cd }
                    r4.put(r0, r5)     // Catch:{ all -> 0x00cd }
                    java.lang.String r0 = "oaid"
                    java.lang.String r5 = com.umeng.message.proguard.ca.c(r2)     // Catch:{ all -> 0x007a }
                    r4.put(r0, r5)     // Catch:{ all -> 0x007a }
                    java.lang.String r0 = "idfa"
                    java.lang.String r5 = com.umeng.message.proguard.ca.a((android.content.Context) r2)     // Catch:{ all -> 0x007a }
                    r4.put(r0, r5)     // Catch:{ all -> 0x007a }
                L_0x007a:
                    int r0 = r3     // Catch:{ all -> 0x00cd }
                    if (r0 != r1) goto L_0x0089
                    java.lang.String r0 = "imp_dura"
                    com.umeng.message.proguard.ck r5 = r2     // Catch:{ all -> 0x00cd }
                    long r5 = r5.i()     // Catch:{ all -> 0x00cd }
                    r4.put(r0, r5)     // Catch:{ all -> 0x00cd }
                L_0x0089:
                    java.lang.String r0 = "android_id"
                    java.lang.String r2 = com.umeng.message.proguard.ca.b(r2)     // Catch:{ all -> 0x00cd }
                    r4.put(r0, r2)     // Catch:{ all -> 0x00cd }
                    java.lang.String r0 = "v"
                    java.lang.String r2 = "2.0"
                    r4.put(r0, r2)     // Catch:{ all -> 0x00cd }
                    java.lang.String r0 = "sdk_version"
                    java.lang.String r2 = "2.0.0"
                    r4.put(r0, r2)     // Catch:{ all -> 0x00cd }
                    java.lang.String r0 = "os"
                    java.lang.String r2 = "android"
                    r4.put(r0, r2)     // Catch:{ all -> 0x00cd }
                    java.lang.String r0 = "os_version"
                    java.lang.String r2 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x00cd }
                    r4.put(r0, r2)     // Catch:{ all -> 0x00cd }
                    java.lang.String r0 = "brand"
                    java.lang.String r2 = com.umeng.message.proguard.ca.c()     // Catch:{ all -> 0x00cd }
                    r4.put(r0, r2)     // Catch:{ all -> 0x00cd }
                    java.lang.String r0 = "model"
                    java.lang.String r2 = com.umeng.message.proguard.ca.b()     // Catch:{ all -> 0x00cd }
                    r4.put(r0, r2)     // Catch:{ all -> 0x00cd }
                    java.lang.String r0 = "data"
                    org.json.JSONObject r2 = r6     // Catch:{ all -> 0x00cd }
                    r4.put(r0, r2)     // Catch:{ all -> 0x00cd }
                    java.lang.String r0 = com.umeng.message.proguard.bu.f15542b     // Catch:{ all -> 0x00cd }
                    com.umeng.message.proguard.cc.a((org.json.JSONObject) r4, (java.lang.String) r0, (java.lang.String) r3)     // Catch:{ all -> 0x00cd }
                    return
                L_0x00cd:
                    r0 = move-exception
                    r2 = 4
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r4 = "report event:"
                    r2[r3] = r4
                    int r3 = r3
                    java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                    r4 = 1
                    r2[r4] = r3
                    java.lang.String r3 = " error:"
                    r2[r1] = r3
                    r1 = 3
                    java.lang.String r0 = r0.getMessage()
                    r2[r1] = r0
                    java.lang.String r0 = "Track"
                    com.umeng.message.proguard.ce.a(r0, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.cs.AnonymousClass1.run():void");
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00b0, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.umeng.message.proguard.ck r9, com.umeng.message.proguard.cq.a r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            org.json.JSONObject r0 = r9.f15606b     // Catch:{ all -> 0x00be }
            java.lang.String r1 = "expose_upload"
            r2 = 0
            boolean r0 = r0.optBoolean(r1, r2)     // Catch:{ all -> 0x00be }
            if (r0 == 0) goto L_0x000e
            monitor-exit(r8)
            return
        L_0x000e:
            org.json.JSONObject r0 = r9.f15606b     // Catch:{ all -> 0x00be }
            java.lang.String r1 = "exposed_timeout"
            boolean r0 = r0.optBoolean(r1, r2)     // Catch:{ all -> 0x00be }
            r1 = 1
            if (r0 == 0) goto L_0x003d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00be }
            java.lang.String r3 = "expose invalid. load -> show timeout, interval:"
            r0.<init>(r3)     // Catch:{ all -> 0x00be }
            int r9 = r9.h()     // Catch:{ all -> 0x00be }
            r0.append(r9)     // Catch:{ all -> 0x00be }
            java.lang.String r9 = r0.toString()     // Catch:{ all -> 0x00be }
            if (r10 == 0) goto L_0x0032
            r10.a(r9)     // Catch:{ all -> 0x00be }
            monitor-exit(r8)
            return
        L_0x0032:
            java.lang.String r10 = "Track"
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ all -> 0x00be }
            r0[r2] = r9     // Catch:{ all -> 0x00be }
            com.umeng.message.proguard.ce.a(r10, r0)     // Catch:{ all -> 0x00be }
            monitor-exit(r8)
            return
        L_0x003d:
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00be }
            r9.f15615k = r3     // Catch:{ all -> 0x00be }
            org.json.JSONObject r0 = r9.f15606b     // Catch:{ all -> 0x00be }
            java.lang.String r3 = "win"
            org.json.JSONArray r0 = r0.optJSONArray(r3)     // Catch:{ all -> 0x00be }
            if (r0 == 0) goto L_0x0066
            int r3 = r0.length()     // Catch:{ all -> 0x00be }
            if (r3 <= 0) goto L_0x0066
            int r3 = r0.length()     // Catch:{ all -> 0x00be }
            r4 = 0
        L_0x0058:
            if (r4 >= r3) goto L_0x0066
            java.lang.String r5 = r0.optString(r4)     // Catch:{ all -> 0x00be }
            r6 = 10
            com.umeng.message.proguard.cc.a((int) r6, (com.umeng.message.proguard.ck) r9, (java.lang.String) r5)     // Catch:{ all -> 0x00be }
            int r4 = r4 + 1
            goto L_0x0058
        L_0x0066:
            org.json.JSONObject r0 = r9.f15606b     // Catch:{ all -> 0x00be }
            java.lang.String r3 = "imp"
            org.json.JSONArray r0 = r0.optJSONArray(r3)     // Catch:{ all -> 0x00be }
            if (r0 == 0) goto L_0x00b1
            int r3 = r0.length()     // Catch:{ all -> 0x00be }
            if (r3 <= 0) goto L_0x00b1
            int r3 = r0.length()     // Catch:{ all -> 0x00be }
            r4 = 0
            r5 = 1
        L_0x007c:
            if (r4 >= r3) goto L_0x008b
            java.lang.String r6 = r0.optString(r4)     // Catch:{ all -> 0x00be }
            r7 = 4
            boolean r6 = com.umeng.message.proguard.cc.a((int) r7, (com.umeng.message.proguard.ck) r9, (java.lang.String) r6)     // Catch:{ all -> 0x00be }
            r5 = r5 & r6
            int r4 = r4 + 1
            goto L_0x007c
        L_0x008b:
            org.json.JSONObject r9 = r9.f15606b     // Catch:{ Exception -> 0x0093 }
            java.lang.String r0 = "expose_upload"
            r9.put(r0, r5)     // Catch:{ Exception -> 0x0093 }
            goto L_0x0094
        L_0x0093:
        L_0x0094:
            if (r5 == 0) goto L_0x009d
            if (r10 == 0) goto L_0x00af
            r10.a()     // Catch:{ all -> 0x00be }
            monitor-exit(r8)
            return
        L_0x009d:
            java.lang.String r9 = "expose invalid. report fail, please check network!"
            if (r10 == 0) goto L_0x00a6
            r10.a(r9)     // Catch:{ all -> 0x00be }
            monitor-exit(r8)
            return
        L_0x00a6:
            java.lang.String r10 = "Track"
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ all -> 0x00be }
            r0[r2] = r9     // Catch:{ all -> 0x00be }
            com.umeng.message.proguard.ce.b(r10, r0)     // Catch:{ all -> 0x00be }
        L_0x00af:
            monitor-exit(r8)
            return
        L_0x00b1:
            java.lang.String r9 = "Track"
            java.lang.Object[] r10 = new java.lang.Object[r1]     // Catch:{ all -> 0x00be }
            java.lang.String r0 = "expose invalid. imp value empty."
            r10[r2] = r0     // Catch:{ all -> 0x00be }
            com.umeng.message.proguard.ce.a(r9, r10)     // Catch:{ all -> 0x00be }
            monitor-exit(r8)
            return
        L_0x00be:
            r9 = move-exception
            monitor-exit(r8)
            goto L_0x00c2
        L_0x00c1:
            throw r9
        L_0x00c2:
            goto L_0x00c1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.cs.a(com.umeng.message.proguard.ck, com.umeng.message.proguard.cq$a):void");
    }

    public final void a(String str, ck ckVar) {
        JSONArray optJSONArray = ckVar.f15606b.optJSONArray(str);
        if (optJSONArray != null && optJSONArray.length() != 0) {
            int length = optJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                String optString = optJSONArray.optString(i10);
                if (optString != null && optString.length() > 0) {
                    cc.a(8, ckVar, optString);
                }
            }
        }
    }

    public final boolean a(ck ckVar) {
        JSONArray optJSONArray = ckVar.f15606b.optJSONArray("pck");
        boolean z10 = true;
        if (optJSONArray != null && optJSONArray.length() != 0) {
            int length = optJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                String optString = optJSONArray.optString(i10);
                if (optString != null && optString.length() > 0) {
                    z10 = cc.a(optString);
                }
                if (!z10) {
                    break;
                }
            }
        }
        return z10;
    }
}
