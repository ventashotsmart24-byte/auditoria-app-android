package com.umeng.commonsdk.utils;

import android.content.pm.PackageInfo;
import java.util.HashMap;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, PackageInfo> f15104a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static Object f15105b = new Object();

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final b f15106a = new b();

        private a() {
        }
    }

    public static b a() {
        return a.f15106a;
    }

    private b() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:6|7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0058 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.content.pm.PackageInfo a(android.content.Context r4, java.lang.String r5, int r6) {
        /*
            r3 = this;
            java.lang.Object r0 = f15105b
            monitor-enter(r0)
            java.util.HashMap<java.lang.String, android.content.pm.PackageInfo> r1 = f15104a     // Catch:{ all -> 0x007c }
            boolean r1 = r1.containsKey(r5)     // Catch:{ all -> 0x007c }
            if (r1 == 0) goto L_0x002f
            java.lang.String r4 = "MobclickRT"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            r6.<init>()     // Catch:{ all -> 0x007c }
            java.lang.String r1 = "--->>> pkg： "
            r6.append(r1)     // Catch:{ all -> 0x007c }
            r6.append(r5)     // Catch:{ all -> 0x007c }
            java.lang.String r1 = ", pkgInfo缓存命中，直接返回"
            r6.append(r1)     // Catch:{ all -> 0x007c }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x007c }
            com.umeng.commonsdk.debug.UMRTLog.e(r4, r6)     // Catch:{ all -> 0x007c }
            java.util.HashMap<java.lang.String, android.content.pm.PackageInfo> r4 = f15104a     // Catch:{ all -> 0x007c }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x007c }
            android.content.pm.PackageInfo r4 = (android.content.pm.PackageInfo) r4     // Catch:{ all -> 0x007c }
            goto L_0x007a
        L_0x002f:
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ all -> 0x007c }
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r5, r6)     // Catch:{ NameNotFoundException -> 0x0058 }
            java.lang.String r6 = "MobclickRT"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ NameNotFoundException -> 0x0058 }
            r1.<init>()     // Catch:{ NameNotFoundException -> 0x0058 }
            java.lang.String r2 = "--->>> pkg： "
            r1.append(r2)     // Catch:{ NameNotFoundException -> 0x0058 }
            r1.append(r5)     // Catch:{ NameNotFoundException -> 0x0058 }
            java.lang.String r2 = ", 获取pkgInfo并缓存"
            r1.append(r2)     // Catch:{ NameNotFoundException -> 0x0058 }
            java.lang.String r1 = r1.toString()     // Catch:{ NameNotFoundException -> 0x0058 }
            com.umeng.commonsdk.debug.UMRTLog.e(r6, r1)     // Catch:{ NameNotFoundException -> 0x0058 }
            java.util.HashMap<java.lang.String, android.content.pm.PackageInfo> r6 = f15104a     // Catch:{ NameNotFoundException -> 0x0058 }
            r6.put(r5, r4)     // Catch:{ NameNotFoundException -> 0x0058 }
            goto L_0x007a
        L_0x0058:
            java.util.HashMap<java.lang.String, android.content.pm.PackageInfo> r4 = f15104a     // Catch:{ all -> 0x007c }
            r6 = 0
            r4.put(r5, r6)     // Catch:{ all -> 0x007c }
            java.lang.String r4 = "MobclickRT"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            r1.<init>()     // Catch:{ all -> 0x007c }
            java.lang.String r2 = "--->>> pkg: "
            r1.append(r2)     // Catch:{ all -> 0x007c }
            r1.append(r5)     // Catch:{ all -> 0x007c }
            java.lang.String r5 = "，目标包未安装。"
            r1.append(r5)     // Catch:{ all -> 0x007c }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x007c }
            com.umeng.commonsdk.debug.UMRTLog.e(r4, r5)     // Catch:{ all -> 0x007c }
            r4 = r6
        L_0x007a:
            monitor-exit(r0)     // Catch:{ all -> 0x007c }
            return r4
        L_0x007c:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007c }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.b.a(android.content.Context, java.lang.String, int):android.content.pm.PackageInfo");
    }
}
