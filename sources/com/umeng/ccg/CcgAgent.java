package com.umeng.ccg;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.av;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.MLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

public class CcgAgent {
    private static volatile int actUpFlag = 0;
    private static volatile long actUpTs = 0;
    private static Object actionInfoLock = new Object();
    private static Map<String, ActionInfo> actionInfoTable = new HashMap();
    private static ArrayList<ConfigListener> callbacks = new ArrayList<>();
    private static Object configUpdateLock = new Object();
    private static Map<String, ArrayList<String>> forbidSdkTable = new HashMap();
    private static Object lock = new Object();
    private static ArrayList<ConfigUpdateListener> updateCallbacks = new ArrayList<>();

    static {
        forbidSdkTable.put(a.f14512e, new ArrayList());
        forbidSdkTable.put(a.f14511d, new ArrayList());
        forbidSdkTable.put(a.f14509b, new ArrayList());
        forbidSdkTable.put(a.f14510c, new ArrayList());
    }

    public static int getActUpFlag() {
        return actUpFlag;
    }

    public static Map<String, String> getActUpInfo() {
        HashMap hashMap = new HashMap();
        hashMap.put(AgooConstants.MESSAGE_FLAG, String.valueOf(actUpFlag));
        hashMap.put("ts", String.valueOf(actUpTs));
        return hashMap;
    }

    public static ActionInfo getActionInfo(String str) {
        ActionInfo actionInfo = null;
        if (!TextUtils.isEmpty(str)) {
            synchronized (actionInfoLock) {
                if (actionInfoTable.containsKey(str)) {
                    actionInfo = actionInfoTable.get(str);
                }
            }
        }
        return actionInfo;
    }

    public static String[] getCollectItemList() {
        return new String[]{a.f14512e, a.f14511d, a.f14509b, a.f14510c};
    }

    public static void getConfigInfo(ConfigResult configResult) {
        if (configResult != null) {
            configResult.onConfigInfo(d.a().b(UMGlobalContext.getAppContext()));
        }
    }

    public static ArrayList<String> getForbidSdkArray(String str) {
        if (forbidSdkTable.containsKey(str)) {
            return forbidSdkTable.get(str);
        }
        return null;
    }

    public static ArrayList<String> getRegistedModuleList() {
        ArrayList<String> arrayList;
        synchronized (actionInfoLock) {
            arrayList = new ArrayList<>(actionInfoTable.keySet());
        }
        return arrayList;
    }

    public static boolean hasRegistedActionInfo() {
        boolean z10;
        synchronized (actionInfoLock) {
            if (actionInfoTable.size() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public static void init(Context context) {
        d.a().a(context);
    }

    public static void notifyConfigChanged(JSONObject jSONObject) {
        synchronized (configUpdateLock) {
            int size = updateCallbacks.size();
            if (size > 0) {
                for (int i10 = 0; i10 < size; i10++) {
                    updateCallbacks.get(i10).onConfigUpdate(jSONObject);
                }
            }
        }
    }

    public static void notifyConfigReady(JSONObject jSONObject) {
        synchronized (lock) {
            int size = callbacks.size();
            if (size > 0) {
                for (int i10 = 0; i10 < size; i10++) {
                    callbacks.get(i10).onConfigReady(jSONObject);
                }
            }
        }
    }

    public static void onActUpEvent(String str, String str2, Bundle bundle) {
        boolean z10;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "onActUpEvent: type or token agument is empty string, pls check!");
            MLog.e("onActUpEvent: type、token参数不能为null或者空字符串！");
            return;
        }
        String str3 = "";
        if (bundle != null) {
            try {
                str3 = bundle.getString("ss");
            } catch (Throwable unused) {
                return;
            }
        }
        String str4 = str3;
        actUpFlag = 1;
        actUpTs = System.currentTimeMillis();
        UMRTLog.i(UMRTLog.RTLOG_TAG, " set act up flag.");
        if (System.currentTimeMillis() - UMConfigure.getInitCompleteTs() <= 3000) {
            z10 = true;
        } else {
            z10 = false;
        }
        JSONObject a10 = d.a().a(str, str2, str4, actUpTs, z10);
        if (a10 != null) {
            av.a(new aq(aq.f13760b, a10), 0, TimeUnit.SECONDS);
            Thread.sleep(2000);
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void registerActionInfo(com.umeng.ccg.ActionInfo r8) {
        /*
            android.content.Context r0 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()
            if (r8 == 0) goto L_0x0051
            java.lang.Object r1 = actionInfoLock
            monitor-enter(r1)
            android.content.Context r2 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x004c }
            java.lang.String r2 = r8.getModule(r2)     // Catch:{ all -> 0x004c }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x004c }
            if (r3 != 0) goto L_0x004c
            java.util.Map<java.lang.String, com.umeng.ccg.ActionInfo> r3 = actionInfoTable     // Catch:{ all -> 0x004c }
            boolean r3 = r3.containsKey(r2)     // Catch:{ all -> 0x004c }
            if (r3 != 0) goto L_0x004c
            java.lang.String[] r3 = r8.getSupportAction(r0)     // Catch:{ all -> 0x004c }
            if (r3 == 0) goto L_0x0047
            r4 = 0
        L_0x0026:
            int r5 = r3.length     // Catch:{ all -> 0x004c }
            if (r4 >= r5) goto L_0x0047
            r5 = r3[r4]     // Catch:{ all -> 0x004c }
            boolean r6 = r8.getSwitchState(r0, r5)     // Catch:{ all -> 0x004c }
            java.util.Map<java.lang.String, java.util.ArrayList<java.lang.String>> r7 = forbidSdkTable     // Catch:{ all -> 0x004c }
            boolean r7 = r7.containsKey(r5)     // Catch:{ all -> 0x004c }
            if (r7 == 0) goto L_0x0044
            java.util.Map<java.lang.String, java.util.ArrayList<java.lang.String>> r7 = forbidSdkTable     // Catch:{ all -> 0x004c }
            java.lang.Object r5 = r7.get(r5)     // Catch:{ all -> 0x004c }
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x004c }
            if (r6 != 0) goto L_0x0044
            r5.add(r2)     // Catch:{ all -> 0x004c }
        L_0x0044:
            int r4 = r4 + 1
            goto L_0x0026
        L_0x0047:
            java.util.Map<java.lang.String, com.umeng.ccg.ActionInfo> r0 = actionInfoTable     // Catch:{ all -> 0x004c }
            r0.put(r2, r8)     // Catch:{ all -> 0x004c }
        L_0x004c:
            monitor-exit(r1)     // Catch:{ all -> 0x004e }
            goto L_0x0051
        L_0x004e:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x004e }
            throw r8
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.ccg.CcgAgent.registerActionInfo(com.umeng.ccg.ActionInfo):void");
    }

    public static void registerConfigListener(ConfigListener configListener) {
        if (configListener != null) {
            synchronized (lock) {
                callbacks.add(configListener);
            }
        }
    }

    public static void registerConfigUpdateListener(ConfigUpdateListener configUpdateListener) {
        if (configUpdateListener != null) {
            synchronized (configUpdateLock) {
                updateCallbacks.add(configUpdateListener);
            }
        }
    }
}
