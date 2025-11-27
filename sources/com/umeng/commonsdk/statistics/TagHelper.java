package com.umeng.commonsdk.statistics;

import java.util.HashMap;
import java.util.Map;

public class TagHelper {
    private static Object lock = new Object();
    private static Map<String, String> moduleTags = new HashMap();

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0010 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void deleteModuleTag(java.lang.String r2) {
        /*
            java.lang.Object r0 = lock
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.String> r1 = moduleTags     // Catch:{ all -> 0x0010 }
            boolean r1 = r1.containsKey(r2)     // Catch:{ all -> 0x0010 }
            if (r1 == 0) goto L_0x0010
            java.util.Map<java.lang.String, java.lang.String> r1 = moduleTags     // Catch:{ all -> 0x0010 }
            r1.remove(r2)     // Catch:{ all -> 0x0010 }
        L_0x0010:
            monitor-exit(r0)     // Catch:{ all -> 0x0012 }
            return
        L_0x0012:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0012 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.TagHelper.deleteModuleTag(java.lang.String):void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0036 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> getModuleTags() {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.Object r1 = lock
            monitor-enter(r1)
            java.util.Map<java.lang.String, java.lang.String> r2 = moduleTags     // Catch:{ all -> 0x0036 }
            int r2 = r2.size()     // Catch:{ all -> 0x0036 }
            if (r2 <= 0) goto L_0x0036
            java.util.Map<java.lang.String, java.lang.String> r2 = moduleTags     // Catch:{ all -> 0x0036 }
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x0036 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0036 }
        L_0x001a:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0036 }
            if (r3 == 0) goto L_0x0036
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0036 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0036 }
            java.lang.Object r4 = r3.getKey()     // Catch:{ all -> 0x0036 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0036 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0036 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0036 }
            r0.put(r4, r3)     // Catch:{ all -> 0x0036 }
            goto L_0x001a
        L_0x0036:
            monitor-exit(r1)     // Catch:{ all -> 0x0038 }
            return r0
        L_0x0038:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0038 }
            goto L_0x003c
        L_0x003b:
            throw r0
        L_0x003c:
            goto L_0x003b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.TagHelper.getModuleTags():java.util.Map");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:9|10|(1:12)|13|14|15) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0023 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setModuleTag(java.lang.String r3, java.lang.String r4) {
        /*
            java.lang.Object r0 = lock
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.String> r1 = moduleTags     // Catch:{ all -> 0x0023 }
            int r1 = r1.size()     // Catch:{ all -> 0x0023 }
            r2 = 30
            if (r1 < r2) goto L_0x0016
            java.lang.String r3 = "UMLog"
            java.lang.String r4 = "传入key-value键值对个数已达30个，setModuleTag调用无效。"
            android.util.Log.e(r3, r4)     // Catch:{ all -> 0x0023 }
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return
        L_0x0016:
            java.util.Map<java.lang.String, java.lang.String> r1 = moduleTags     // Catch:{ all -> 0x0023 }
            boolean r1 = r1.containsKey(r3)     // Catch:{ all -> 0x0023 }
            if (r1 != 0) goto L_0x0023
            java.util.Map<java.lang.String, java.lang.String> r1 = moduleTags     // Catch:{ all -> 0x0023 }
            r1.put(r3, r4)     // Catch:{ all -> 0x0023 }
        L_0x0023:
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return
        L_0x0025:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.TagHelper.setModuleTag(java.lang.String, java.lang.String):void");
    }
}
