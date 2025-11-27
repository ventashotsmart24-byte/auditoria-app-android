package com.umeng.logsdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.efs.sdk.base.EfsReporter;
import com.taobao.accs.common.Constants;
import org.json.JSONArray;

public class ULogManager {
    public static final String TAG = "CodeLogManager";

    /* renamed from: a  reason: collision with root package name */
    private static Context f15167a = null;

    /* renamed from: b  reason: collision with root package name */
    private static ULogConfigManager f15168b = null;

    /* renamed from: c  reason: collision with root package name */
    private static EfsReporter f15169c = null;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f15170d = false;

    /* renamed from: e  reason: collision with root package name */
    private static String f15171e = "";

    /* renamed from: f  reason: collision with root package name */
    private static String f15172f = "";

    /* renamed from: g  reason: collision with root package name */
    private static JSONArray f15173g = new JSONArray();

    /* renamed from: h  reason: collision with root package name */
    private static long f15174h = 0;

    /* renamed from: i  reason: collision with root package name */
    private static long f15175i = 0;
    public static boolean isDebug = true;

    /* renamed from: j  reason: collision with root package name */
    private static Handler f15176j = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i10 = message.what;
            if (i10 == 0) {
                ULogManager.a(message);
            } else if (i10 == 1) {
                ULogManager.e();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static int f15177k = 0;

    public static /* synthetic */ int b() {
        int i10 = f15177k;
        f15177k = i10 + 1;
        return i10;
    }

    public static /* synthetic */ int d() {
        int i10 = f15177k;
        f15177k = i10 - 1;
        return i10;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void e() {
        /*
            org.json.JSONArray r0 = f15173g
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0082
            long r0 = java.lang.System.currentTimeMillis()
            f15175i = r0
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0053 }
            r1.<init>()     // Catch:{ all -> 0x0053 }
            java.lang.String r0 = "taskid"
            java.lang.String r2 = ""
            r1.put(r0, r2)     // Catch:{ all -> 0x0051 }
            java.lang.String r0 = "status"
            r2 = 0
            r1.put(r0, r2)     // Catch:{ all -> 0x0051 }
            java.lang.String r0 = "time_start"
            long r2 = f15174h     // Catch:{ all -> 0x0051 }
            r1.put(r0, r2)     // Catch:{ all -> 0x0051 }
            java.lang.String r0 = "time_end"
            long r2 = f15175i     // Catch:{ all -> 0x0051 }
            r1.put(r0, r2)     // Catch:{ all -> 0x0051 }
            java.lang.String r0 = "uid"
            java.lang.String r2 = getUserID()     // Catch:{ all -> 0x0051 }
            byte[] r2 = r2.getBytes()     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = com.umeng.logsdk.c.b(r2)     // Catch:{ all -> 0x0051 }
            r1.put(r0, r2)     // Catch:{ all -> 0x0051 }
            java.lang.String r0 = "did"
            java.lang.String r2 = getDeviceID()     // Catch:{ all -> 0x0051 }
            r1.put(r0, r2)     // Catch:{ all -> 0x0051 }
            java.lang.String r0 = "body"
            org.json.JSONArray r2 = f15173g     // Catch:{ all -> 0x0051 }
            r1.put(r0, r2)     // Catch:{ all -> 0x0051 }
            goto L_0x005a
        L_0x0051:
            r0 = move-exception
            goto L_0x0057
        L_0x0053:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0057:
            r0.printStackTrace()
        L_0x005a:
            if (r1 == 0) goto L_0x0082
            com.efs.sdk.base.protocol.record.EfsJSONLog r0 = new com.efs.sdk.base.protocol.record.EfsJSONLog
            java.lang.String r2 = "codelogperf"
            r0.<init>(r2)
            long r2 = f15174h
            r0.setLogBeginTime(r2)
            long r2 = f15175i
            r0.setLogEndTime(r2)
            java.lang.String r2 = "codelog"
            r0.put(r2, r1)
            com.efs.sdk.base.EfsReporter r1 = getReporter()
            if (r1 == 0) goto L_0x0082
            r1.send(r0)
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            f15173g = r0
        L_0x0082:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.logsdk.ULogManager.e():void");
    }

    public static String getDeviceID() {
        return f15171e;
    }

    public static EfsReporter getReporter() {
        return f15169c;
    }

    public static ULogConfigManager getULogConfigManager() {
        return f15168b;
    }

    public static String getUserID() {
        return f15172f;
    }

    public static void i(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 2;
        Bundle bundle = new Bundle();
        bundle.putString("tag", str);
        bundle.putString(Constants.SHARED_MESSAGE_ID_FILE, str2);
        message.setData(bundle);
        f15176j.sendMessage(message);
    }

    public static void init(Context context, EfsReporter efsReporter) {
        if (context != null && efsReporter != null) {
            try {
                if (!isInit()) {
                    Context applicationContext = context.getApplicationContext();
                    f15167a = applicationContext;
                    f15169c = efsReporter;
                    f15168b = new ULogConfigManager(applicationContext, efsReporter);
                    registerActivityCallback(context);
                    f15170d = true;
                } else if (isDebug) {
                    Log.e(TAG, "invalid init ！");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else if (isDebug) {
            Log.e(TAG, "init code log manager error! parameter is null!");
        }
    }

    public static boolean isInit() {
        return f15170d;
    }

    public static void registerActivityCallback(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                public final void onActivityCreated(Activity activity, Bundle bundle) {
                }

                public final void onActivityDestroyed(Activity activity) {
                }

                public final void onActivityPaused(Activity activity) {
                }

                public final void onActivityResumed(Activity activity) {
                }

                public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public final void onActivityStarted(Activity activity) {
                    ULogManager.b();
                    int unused = ULogManager.f15177k;
                }

                public final void onActivityStopped(Activity activity) {
                    ULogManager.d();
                    if (ULogManager.f15177k == 0) {
                        ULogManager.e();
                    }
                }
            });
        }
    }

    public static void setDeviceID(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 128) {
            f15171e = str;
        } else if (isDebug) {
            Log.e(TAG, "device id over length!");
        }
    }

    public static void setUserID(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 128) {
            f15172f = c.a(str.getBytes());
        } else if (isDebug) {
            Log.e(TAG, "user id over length!");
        }
    }

    public static void v(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 0;
        Bundle bundle = new Bundle();
        bundle.putString("tag", str);
        bundle.putString(Constants.SHARED_MESSAGE_ID_FILE, str2);
        message.setData(bundle);
        f15176j.sendMessage(message);
    }

    public static void w(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 3;
        Bundle bundle = new Bundle();
        bundle.putString("tag", str);
        bundle.putString(Constants.SHARED_MESSAGE_ID_FILE, str2);
        message.setData(bundle);
        f15176j.sendMessage(message);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void a(android.os.Message r7) {
        /*
            java.lang.String r0 = "CodeLogManager"
            if (r7 == 0) goto L_0x0108
            android.os.Bundle r1 = r7.getData()
            if (r1 != 0) goto L_0x000c
            goto L_0x0108
        L_0x000c:
            android.os.Bundle r1 = r7.getData()
            if (r1 != 0) goto L_0x0018
            java.lang.String r7 = "writeMemory bundle is null!"
        L_0x0014:
            android.util.Log.e(r0, r7)
            return
        L_0x0018:
            java.lang.String r2 = "tag"
            java.lang.String r3 = r1.getString(r2)
            java.lang.String r4 = "message"
            java.lang.String r1 = r1.getString(r4)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            r5 = 0
            if (r4 != 0) goto L_0x0077
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 == 0) goto L_0x0032
            goto L_0x0077
        L_0x0032:
            int r4 = r3.length()
            int r6 = com.umeng.logsdk.a.f15186a
            if (r4 > r6) goto L_0x0070
            int r4 = r1.length()
            int r6 = com.umeng.logsdk.a.f15187b
            if (r4 <= r6) goto L_0x0043
            goto L_0x0070
        L_0x0043:
            boolean r4 = isInit()
            if (r4 != 0) goto L_0x0053
            boolean r4 = isDebug
            if (r4 == 0) goto L_0x007e
            java.lang.String r4 = "ULog not init!"
        L_0x004f:
            android.util.Log.e(r0, r4)
            goto L_0x007e
        L_0x0053:
            java.lang.String r4 = getDeviceID()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x006e
            java.lang.String r4 = getUserID()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x006e
            boolean r4 = isDebug
            if (r4 == 0) goto L_0x007e
            java.lang.String r4 = "ULog not set device id or user id!"
            goto L_0x004f
        L_0x006e:
            r5 = 1
            goto L_0x007e
        L_0x0070:
            boolean r4 = isDebug
            if (r4 == 0) goto L_0x007e
            java.lang.String r4 = "ULog tag or message over length!"
            goto L_0x004f
        L_0x0077:
            boolean r4 = isDebug
            if (r4 == 0) goto L_0x007e
            java.lang.String r4 = "ULog parameter null!"
            goto L_0x004f
        L_0x007e:
            if (r5 == 0) goto L_0x0107
            r0 = 0
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x00b8 }
            r4.<init>()     // Catch:{ all -> 0x00b8 }
            r4.put(r2, r3)     // Catch:{ all -> 0x00b5 }
            java.lang.String r0 = "msg"
            r4.put(r0, r1)     // Catch:{ all -> 0x00b5 }
            java.lang.String r0 = "level"
            int r7 = r7.arg1     // Catch:{ all -> 0x00b5 }
            r4.put(r0, r7)     // Catch:{ all -> 0x00b5 }
            java.lang.String r7 = "time"
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00b5 }
            r4.put(r7, r0)     // Catch:{ all -> 0x00b5 }
            java.lang.String r7 = "process"
            java.lang.String r0 = com.efs.sdk.base.core.util.ProcessUtil.getCurrentProcessName()     // Catch:{ all -> 0x00b5 }
            r4.put(r7, r0)     // Catch:{ all -> 0x00b5 }
            java.lang.String r7 = "thread"
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00b5 }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x00b5 }
            r4.put(r7, r0)     // Catch:{ all -> 0x00b5 }
            goto L_0x00bd
        L_0x00b5:
            r7 = move-exception
            r0 = r4
            goto L_0x00b9
        L_0x00b8:
            r7 = move-exception
        L_0x00b9:
            r7.printStackTrace()
            r4 = r0
        L_0x00bd:
            if (r4 == 0) goto L_0x00e0
            org.json.JSONArray r7 = f15173g
            int r7 = r7.length()
            if (r7 != 0) goto L_0x00cd
            long r0 = java.lang.System.currentTimeMillis()
            f15174h = r0
        L_0x00cd:
            org.json.JSONArray r7 = f15173g
            r7.put(r4)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "add mem is "
            r7.<init>(r0)
            java.lang.String r0 = r4.toString()
            r7.append(r0)
        L_0x00e0:
            org.json.JSONArray r7 = f15173g
            java.lang.String r7 = r7.toString()
            byte[] r7 = r7.getBytes()
            int r7 = r7.length
            r0 = 18432(0x4800, float:2.5829E-41)
            if (r7 < r0) goto L_0x0107
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "over max size upload. size is "
            r7.<init>(r0)
            org.json.JSONArray r0 = f15173g
            java.lang.String r0 = r0.toString()
            byte[] r0 = r0.getBytes()
            int r0 = r0.length
            r7.append(r0)
            e()
        L_0x0107:
            return
        L_0x0108:
            java.lang.String r7 = "writeMemory msg or msg data is null!"
            goto L_0x0014
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.logsdk.ULogManager.a(android.os.Message):void");
    }

    public static void d(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 1;
        Bundle bundle = new Bundle();
        bundle.putString("tag", str);
        bundle.putString(Constants.SHARED_MESSAGE_ID_FILE, str2);
        message.setData(bundle);
        f15176j.sendMessage(message);
    }

    public static void e(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 4;
        Bundle bundle = new Bundle();
        bundle.putString("tag", str);
        bundle.putString(Constants.SHARED_MESSAGE_ID_FILE, str2);
        message.setData(bundle);
        f15176j.sendMessage(message);
    }
}
