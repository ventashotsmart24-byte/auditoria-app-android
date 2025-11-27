package com.alibaba.sdk.android.utils.crashdefend;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.List;

class e {
    /* JADX WARNING: Can't wrap try/catch for region: R(17:3|4|5|(1:7)|8|9|(4:12|(2:14|47)(1:46)|44|10)|45|15|16|17|(1:19)(1:21)|20|22|23|24|39) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:25|(2:27|28)|29|30) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0070 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00ae */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007b A[Catch:{ IOException -> 0x00b4, Exception -> 0x00b1, all -> 0x00a8, all -> 0x00af }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0083 A[Catch:{ IOException -> 0x00b4, Exception -> 0x00b1, all -> 0x00a8, all -> 0x00af }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r8, com.alibaba.sdk.android.utils.crashdefend.a r9, java.util.List<com.alibaba.sdk.android.utils.crashdefend.c> r10) {
        /*
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            monitor-enter(r10)
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ IOException -> 0x00b4, Exception -> 0x00b1, all -> 0x00a8 }
            r1.<init>()     // Catch:{ IOException -> 0x00b4, Exception -> 0x00b1, all -> 0x00a8 }
            if (r9 == 0) goto L_0x0013
            java.lang.String r2 = "startSerialNumber"
            long r3 = r9.f5060a     // Catch:{ IOException -> 0x00b4, Exception -> 0x00b1, all -> 0x00a8 }
            r1.put(r2, r3)     // Catch:{ IOException -> 0x00b4, Exception -> 0x00b1, all -> 0x00a8 }
        L_0x0013:
            org.json.JSONArray r9 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0070 }
            r9.<init>()     // Catch:{ JSONException -> 0x0070 }
            java.util.Iterator r2 = r10.iterator()     // Catch:{ JSONException -> 0x0070 }
        L_0x001c:
            boolean r3 = r2.hasNext()     // Catch:{ JSONException -> 0x0070 }
            if (r3 == 0) goto L_0x006b
            java.lang.Object r3 = r2.next()     // Catch:{ JSONException -> 0x0070 }
            com.alibaba.sdk.android.utils.crashdefend.c r3 = (com.alibaba.sdk.android.utils.crashdefend.c) r3     // Catch:{ JSONException -> 0x0070 }
            if (r3 == 0) goto L_0x001c
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0070 }
            r4.<init>()     // Catch:{ JSONException -> 0x0070 }
            java.lang.String r5 = "sdkId"
            java.lang.String r6 = r3.f52a     // Catch:{ JSONException -> 0x0070 }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x0070 }
            java.lang.String r5 = "sdkVersion"
            java.lang.String r6 = r3.f54b     // Catch:{ JSONException -> 0x0070 }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x0070 }
            java.lang.String r5 = "crashLimit"
            int r6 = r3.f5066a     // Catch:{ JSONException -> 0x0070 }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x0070 }
            java.lang.String r5 = "crashCount"
            int r6 = r3.crashCount     // Catch:{ JSONException -> 0x0070 }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x0070 }
            java.lang.String r5 = "waitTime"
            int r6 = r3.f5067b     // Catch:{ JSONException -> 0x0070 }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x0070 }
            java.lang.String r5 = "registerSerialNumber"
            long r6 = r3.f53b     // Catch:{ JSONException -> 0x0070 }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x0070 }
            java.lang.String r5 = "startSerialNumber"
            long r6 = r3.f50a     // Catch:{ JSONException -> 0x0070 }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x0070 }
            java.lang.String r5 = "restoreCount"
            int r3 = r3.f5068c     // Catch:{ JSONException -> 0x0070 }
            r4.put(r5, r3)     // Catch:{ JSONException -> 0x0070 }
            r9.put(r4)     // Catch:{ JSONException -> 0x0070 }
            goto L_0x001c
        L_0x006b:
            java.lang.String r2 = "sdkList"
            r1.put(r2, r9)     // Catch:{ JSONException -> 0x0070 }
        L_0x0070:
            java.lang.String r9 = r1.toString()     // Catch:{ IOException -> 0x00b4, Exception -> 0x00b1, all -> 0x00a8 }
            boolean r1 = a((android.content.Context) r8)     // Catch:{ IOException -> 0x00b4, Exception -> 0x00b1, all -> 0x00a8 }
            r2 = 0
            if (r1 == 0) goto L_0x0083
            java.lang.String r1 = "com_alibaba_aliyun_crash_defend_sdk_info"
            java.io.FileOutputStream r8 = r8.openFileOutput(r1, r2)     // Catch:{ IOException -> 0x00b4, Exception -> 0x00b1, all -> 0x00a8 }
        L_0x0081:
            r0 = r8
            goto L_0x009d
        L_0x0083:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b4, Exception -> 0x00b1, all -> 0x00a8 }
            r1.<init>()     // Catch:{ IOException -> 0x00b4, Exception -> 0x00b1, all -> 0x00a8 }
            java.lang.String r3 = "com_alibaba_aliyun_crash_defend_sdk_info_"
            r1.append(r3)     // Catch:{ IOException -> 0x00b4, Exception -> 0x00b1, all -> 0x00a8 }
            java.lang.String r3 = a((android.content.Context) r8)     // Catch:{ IOException -> 0x00b4, Exception -> 0x00b1, all -> 0x00a8 }
            r1.append(r3)     // Catch:{ IOException -> 0x00b4, Exception -> 0x00b1, all -> 0x00a8 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x00b4, Exception -> 0x00b1, all -> 0x00a8 }
            java.io.FileOutputStream r8 = r8.openFileOutput(r1, r2)     // Catch:{ IOException -> 0x00b4, Exception -> 0x00b1, all -> 0x00a8 }
            goto L_0x0081
        L_0x009d:
            byte[] r8 = r9.getBytes()     // Catch:{ IOException -> 0x00b4, Exception -> 0x00b1, all -> 0x00a8 }
            r0.write(r8)     // Catch:{ IOException -> 0x00b4, Exception -> 0x00b1, all -> 0x00a8 }
        L_0x00a4:
            r0.close()     // Catch:{ IOException -> 0x00b7 }
            goto L_0x00b7
        L_0x00a8:
            r8 = move-exception
            if (r0 == 0) goto L_0x00ae
            r0.close()     // Catch:{ IOException -> 0x00ae }
        L_0x00ae:
            throw r8     // Catch:{ all -> 0x00af }
        L_0x00af:
            r8 = move-exception
            goto L_0x00b9
        L_0x00b1:
            if (r0 == 0) goto L_0x00b7
            goto L_0x00a4
        L_0x00b4:
            if (r0 == 0) goto L_0x00b7
            goto L_0x00a4
        L_0x00b7:
            monitor-exit(r10)     // Catch:{ all -> 0x00af }
            return
        L_0x00b9:
            monitor-exit(r10)     // Catch:{ all -> 0x00af }
            goto L_0x00bc
        L_0x00bb:
            throw r8
        L_0x00bc:
            goto L_0x00bb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.utils.crashdefend.e.a(android.content.Context, com.alibaba.sdk.android.utils.crashdefend.a, java.util.List):void");
    }

    private static String b(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return "";
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid) {
                return next.processName;
            }
        }
        return "";
    }

    private static String c(Context context) {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, context.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke((Object) null, new Object[0]);
        } catch (Exception e10) {
            StringBuilder sb = new StringBuilder();
            sb.append("getProcessNameByActivityThread error: ");
            sb.append(e10);
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:18|(2:46|47)|48|49) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:32|33|(4:36|(2:38|(2:40|53)(1:55))(1:54)|41|34)|42|43|44) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004e, code lost:
        if (r3 == null) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        if (r3 == null) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0066, code lost:
        if (r3 == null) goto L_0x0069;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0069 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x00f0 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x00f8 */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006f A[Catch:{ all -> 0x004b }, DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0071 A[SYNTHETIC, Splitter:B:32:0x0071] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:42:0x00f0=Splitter:B:42:0x00f0, B:48:0x00f8=Splitter:B:48:0x00f8, B:27:0x0069=Splitter:B:27:0x0069} */
    /* renamed from: a  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m22a(android.content.Context r9, com.alibaba.sdk.android.utils.crashdefend.a r10, java.util.List<com.alibaba.sdk.android.utils.crashdefend.c> r11) {
        /*
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            monitor-enter(r11)
            r2 = -1
            r3 = 0
            boolean r4 = a((android.content.Context) r9)     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, Exception -> 0x004e }
            if (r4 == 0) goto L_0x001a
            java.lang.String r4 = "com_alibaba_aliyun_crash_defend_sdk_info"
            java.io.FileInputStream r9 = r9.openFileInput(r4)     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, Exception -> 0x004e }
        L_0x0018:
            r3 = r9
            goto L_0x0034
        L_0x001a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, Exception -> 0x004e }
            r4.<init>()     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, Exception -> 0x004e }
            java.lang.String r5 = "com_alibaba_aliyun_crash_defend_sdk_info_"
            r4.append(r5)     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, Exception -> 0x004e }
            java.lang.String r5 = a((android.content.Context) r9)     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, Exception -> 0x004e }
            r4.append(r5)     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, Exception -> 0x004e }
            java.lang.String r4 = r4.toString()     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, Exception -> 0x004e }
            java.io.FileInputStream r9 = r9.openFileInput(r4)     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, Exception -> 0x004e }
            goto L_0x0018
        L_0x0034:
            r9 = 512(0x200, float:7.175E-43)
            byte[] r9 = new byte[r9]     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, Exception -> 0x004e }
        L_0x0038:
            int r4 = r3.read(r9)     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, Exception -> 0x004e }
            if (r4 == r2) goto L_0x0047
            java.lang.String r5 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, Exception -> 0x004e }
            r5.<init>(r9, r0, r4)     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, Exception -> 0x004e }
            r1.append(r5)     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, Exception -> 0x004e }
            goto L_0x0038
        L_0x0047:
            r3.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x0069
        L_0x004b:
            r9 = move-exception
            goto L_0x00f3
        L_0x004e:
            if (r3 == 0) goto L_0x0069
            goto L_0x0047
        L_0x0051:
            if (r3 == 0) goto L_0x0069
            goto L_0x0047
        L_0x0054:
            r9 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x004b }
            r4.<init>()     // Catch:{ all -> 0x004b }
            java.lang.String r5 = "load sdk file fail:"
            r4.append(r5)     // Catch:{ all -> 0x004b }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x004b }
            r4.append(r9)     // Catch:{ all -> 0x004b }
            if (r3 == 0) goto L_0x0069
            goto L_0x0047
        L_0x0069:
            int r9 = r1.length()     // Catch:{ all -> 0x00f9 }
            if (r9 != 0) goto L_0x0071
            monitor-exit(r11)     // Catch:{ all -> 0x00f9 }
            return r0
        L_0x0071:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception | JSONException -> 0x00f0 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception | JSONException -> 0x00f0 }
            r9.<init>(r1)     // Catch:{ Exception | JSONException -> 0x00f0 }
            java.lang.String r1 = "startSerialNumber"
            r3 = 1
            long r3 = r9.optLong(r1, r3)     // Catch:{ Exception | JSONException -> 0x00f0 }
            r10.f5060a = r3     // Catch:{ Exception | JSONException -> 0x00f0 }
            java.lang.String r10 = "sdkList"
            org.json.JSONArray r9 = r9.getJSONArray(r10)     // Catch:{ Exception | JSONException -> 0x00f0 }
            r10 = 0
        L_0x008b:
            int r1 = r9.length()     // Catch:{ Exception | JSONException -> 0x00f0 }
            if (r10 >= r1) goto L_0x00f0
            org.json.JSONObject r1 = r9.getJSONObject(r10)     // Catch:{ Exception | JSONException -> 0x00f0 }
            if (r1 == 0) goto L_0x00ed
            com.alibaba.sdk.android.utils.crashdefend.c r3 = new com.alibaba.sdk.android.utils.crashdefend.c     // Catch:{ Exception | JSONException -> 0x00f0 }
            r3.<init>()     // Catch:{ Exception | JSONException -> 0x00f0 }
            java.lang.String r4 = "sdkId"
            java.lang.String r5 = ""
            java.lang.String r4 = r1.optString(r4, r5)     // Catch:{ Exception | JSONException -> 0x00f0 }
            r3.f52a = r4     // Catch:{ Exception | JSONException -> 0x00f0 }
            java.lang.String r4 = "sdkVersion"
            java.lang.String r5 = ""
            java.lang.String r4 = r1.optString(r4, r5)     // Catch:{ Exception | JSONException -> 0x00f0 }
            r3.f54b = r4     // Catch:{ Exception | JSONException -> 0x00f0 }
            java.lang.String r4 = "crashLimit"
            int r4 = r1.optInt(r4, r2)     // Catch:{ Exception | JSONException -> 0x00f0 }
            r3.f5066a = r4     // Catch:{ Exception | JSONException -> 0x00f0 }
            java.lang.String r4 = "crashCount"
            int r4 = r1.optInt(r4, r0)     // Catch:{ Exception | JSONException -> 0x00f0 }
            r3.crashCount = r4     // Catch:{ Exception | JSONException -> 0x00f0 }
            java.lang.String r4 = "waitTime"
            int r4 = r1.optInt(r4, r0)     // Catch:{ Exception | JSONException -> 0x00f0 }
            r3.f5067b = r4     // Catch:{ Exception | JSONException -> 0x00f0 }
            java.lang.String r4 = "registerSerialNumber"
            r5 = 0
            long r7 = r1.optLong(r4, r5)     // Catch:{ Exception | JSONException -> 0x00f0 }
            r3.f53b = r7     // Catch:{ Exception | JSONException -> 0x00f0 }
            java.lang.String r4 = "startSerialNumber"
            long r4 = r1.optLong(r4, r5)     // Catch:{ Exception | JSONException -> 0x00f0 }
            r3.f50a = r4     // Catch:{ Exception | JSONException -> 0x00f0 }
            java.lang.String r4 = "restoreCount"
            int r1 = r1.optInt(r4, r0)     // Catch:{ Exception | JSONException -> 0x00f0 }
            r3.f5068c = r1     // Catch:{ Exception | JSONException -> 0x00f0 }
            java.lang.String r1 = r3.f52a     // Catch:{ Exception | JSONException -> 0x00f0 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception | JSONException -> 0x00f0 }
            if (r1 != 0) goto L_0x00ed
            r11.add(r3)     // Catch:{ Exception | JSONException -> 0x00f0 }
        L_0x00ed:
            int r10 = r10 + 1
            goto L_0x008b
        L_0x00f0:
            monitor-exit(r11)     // Catch:{ all -> 0x00f9 }
            r9 = 1
            return r9
        L_0x00f3:
            if (r3 == 0) goto L_0x00f8
            r3.close()     // Catch:{ IOException -> 0x00f8 }
        L_0x00f8:
            throw r9     // Catch:{ all -> 0x00f9 }
        L_0x00f9:
            r9 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x00f9 }
            goto L_0x00fd
        L_0x00fc:
            throw r9
        L_0x00fd:
            goto L_0x00fc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.utils.crashdefend.e.m22a(android.content.Context, com.alibaba.sdk.android.utils.crashdefend.a, java.util.List):boolean");
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m21a(Context context) {
        return context.getPackageName().equalsIgnoreCase(a(context));
    }

    private static String a(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        String c10 = c(context);
        if (!TextUtils.isEmpty(c10)) {
            return c10;
        }
        String a10 = a();
        if (!TextUtils.isEmpty(a10)) {
            return a10;
        }
        return b(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061 A[SYNTHETIC, Splitter:B:23:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006d A[SYNTHETIC, Splitter:B:29:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a() {
        /*
            int r0 = android.os.Process.myPid()
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            r3.<init>()     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            java.lang.String r4 = "/proc/"
            r3.append(r4)     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            r3.append(r0)     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            java.lang.String r0 = "/cmdline"
            r3.append(r0)     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            boolean r0 = r2.exists()     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            if (r0 == 0) goto L_0x003e
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            r0.<init>(r3)     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            java.lang.String r2 = r0.readLine()     // Catch:{ Exception -> 0x003c }
            java.lang.String r1 = r2.trim()     // Catch:{ Exception -> 0x003c }
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x003f
        L_0x003c:
            r2 = move-exception
            goto L_0x0052
        L_0x003e:
            r0 = r1
        L_0x003f:
            if (r1 == 0) goto L_0x0049
            r1.close()     // Catch:{ IOException -> 0x0045 }
            goto L_0x0049
        L_0x0045:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0049:
            r1 = r0
            goto L_0x0069
        L_0x004b:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x006b
        L_0x0050:
            r2 = move-exception
            r0 = r1
        L_0x0052:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x006a }
            r3.<init>()     // Catch:{ all -> 0x006a }
            java.lang.String r4 = "getProcessNameByPid error: "
            r3.append(r4)     // Catch:{ all -> 0x006a }
            r3.append(r2)     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x0069
            r0.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0069:
            return r1
        L_0x006a:
            r1 = move-exception
        L_0x006b:
            if (r0 == 0) goto L_0x0075
            r0.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x0075
        L_0x0071:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0075:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.utils.crashdefend.e.a():java.lang.String");
    }
}
