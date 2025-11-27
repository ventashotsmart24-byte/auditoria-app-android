package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.k;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.analytics.vshelper.a;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONObject;

public class x {

    /* renamed from: c  reason: collision with root package name */
    private static final int f14456c = 5;

    /* renamed from: d  reason: collision with root package name */
    private static JSONArray f14457d = new JSONArray();

    /* renamed from: e  reason: collision with root package name */
    private static Object f14458e = new Object();

    /* renamed from: a  reason: collision with root package name */
    Stack<String> f14459a = new Stack<>();

    /* renamed from: b  reason: collision with root package name */
    a f14460b = PageNameMonitor.getInstance();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, Long> f14461f = new HashMap();

    public int a() {
        return 2;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0088 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L_0x00d4
            java.util.Map<java.lang.String, java.lang.Long> r0 = r8.f14461f
            boolean r0 = r0.containsKey(r9)
            if (r0 == 0) goto L_0x00b2
            java.util.Map<java.lang.String, java.lang.Long> r0 = r8.f14461f
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.Long> r1 = r8.f14461f     // Catch:{ all -> 0x00af }
            java.lang.Object r1 = r1.get(r9)     // Catch:{ all -> 0x00af }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x00af }
            java.util.Map<java.lang.String, java.lang.Long> r2 = r8.f14461f     // Catch:{ all -> 0x00af }
            r2.remove(r9)     // Catch:{ all -> 0x00af }
            monitor-exit(r0)     // Catch:{ all -> 0x00af }
            if (r1 != 0) goto L_0x0022
            return
        L_0x0022:
            boolean r0 = com.umeng.commonsdk.UMConfigure.isDebugLog()
            if (r0 == 0) goto L_0x0041
            java.util.Stack<java.lang.String> r0 = r8.f14459a
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0041
            java.util.Stack<java.lang.String> r0 = r8.f14459a
            java.lang.Object r0 = r0.peek()
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0041
            java.util.Stack<java.lang.String> r0 = r8.f14459a
            r0.pop()
        L_0x0041:
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r1.longValue()
            long r2 = r2 - r4
            java.lang.Object r4 = f14458e
            monitor-enter(r4)
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0088 }
            r0.<init>()     // Catch:{ all -> 0x0088 }
            java.lang.String r5 = "page_name"
            r0.put(r5, r9)     // Catch:{ all -> 0x0088 }
            java.lang.String r5 = "duration"
            r0.put(r5, r2)     // Catch:{ all -> 0x0088 }
            java.lang.String r2 = "page_start"
            r0.put(r2, r1)     // Catch:{ all -> 0x0088 }
            java.lang.String r1 = "type"
            int r2 = r8.a()     // Catch:{ all -> 0x0088 }
            r0.put(r1, r2)     // Catch:{ all -> 0x0088 }
            org.json.JSONArray r1 = f14457d     // Catch:{ all -> 0x0088 }
            r1.put(r0)     // Catch:{ all -> 0x0088 }
            org.json.JSONArray r0 = f14457d     // Catch:{ all -> 0x0088 }
            int r0 = r0.length()     // Catch:{ all -> 0x0088 }
            r1 = 5
            if (r0 < r1) goto L_0x0088
            r0 = 0
            android.content.Context r1 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext(r0)     // Catch:{ all -> 0x0088 }
            if (r1 == 0) goto L_0x0088
            com.umeng.analytics.CoreProtocol r2 = com.umeng.analytics.CoreProtocol.getInstance(r1)     // Catch:{ all -> 0x0088 }
            r3 = 4099(0x1003, float:5.744E-42)
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r1, r3, r2, r0)     // Catch:{ all -> 0x0088 }
        L_0x0088:
            monitor-exit(r4)     // Catch:{ all -> 0x00ac }
            boolean r0 = com.umeng.commonsdk.UMConfigure.isDebugLog()
            if (r0 == 0) goto L_0x00d4
            java.util.Stack<java.lang.String> r0 = r8.f14459a
            int r0 = r0.size()
            if (r0 == 0) goto L_0x00d4
            java.lang.String r0 = "@"
            java.lang.String[] r4 = new java.lang.String[]{r0}
            java.lang.String[] r5 = new java.lang.String[]{r9}
            java.lang.String r1 = com.umeng.analytics.pro.l.E
            r2 = 0
            java.lang.String r3 = "\\|"
            r6 = 0
            r7 = 0
            com.umeng.commonsdk.debug.UMLog.aq(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x00d4
        L_0x00ac:
            r9 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00ac }
            throw r9
        L_0x00af:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00af }
            throw r9
        L_0x00b2:
            boolean r0 = com.umeng.commonsdk.UMConfigure.isDebugLog()
            if (r0 == 0) goto L_0x00d4
            java.util.Stack<java.lang.String> r0 = r8.f14459a
            int r0 = r0.size()
            if (r0 != 0) goto L_0x00d4
            java.lang.String r0 = "@"
            java.lang.String[] r4 = new java.lang.String[]{r0}
            java.lang.String[] r5 = new java.lang.String[]{r9}
            java.lang.String r1 = com.umeng.analytics.pro.l.G
            r2 = 0
            java.lang.String r3 = "\\|"
            r6 = 0
            r7 = 0
            com.umeng.commonsdk.debug.UMLog.aq(r1, r2, r3, r4, r5, r6, r7)
        L_0x00d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.x.b(java.lang.String):void");
    }

    public static void a(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f14458e) {
                    jSONArray = f14457d.toString();
                    f14457d = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("__a", new JSONArray(jSONArray));
                    if (jSONObject.length() > 0) {
                        k.a(context).a(w.a().c(), jSONObject, k.a.PAGE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (UMConfigure.isDebugLog() && this.f14459a.size() != 0) {
                UMLog.aq(l.F, 0, "\\|", new String[]{"@"}, new String[]{this.f14459a.peek()}, (String[]) null, (String[]) null);
            }
            this.f14460b.customPageBegin(str);
            synchronized (this.f14461f) {
                this.f14461f.put(str, Long.valueOf(System.currentTimeMillis()));
                if (UMConfigure.isDebugLog()) {
                    this.f14459a.push(str);
                }
            }
        }
    }

    public void b() {
        String str;
        synchronized (this.f14461f) {
            str = null;
            long j10 = 0;
            for (Map.Entry next : this.f14461f.entrySet()) {
                if (((Long) next.getValue()).longValue() > j10) {
                    long longValue = ((Long) next.getValue()).longValue();
                    str = (String) next.getKey();
                    j10 = longValue;
                }
            }
        }
        if (str != null) {
            b(str);
        }
    }
}
