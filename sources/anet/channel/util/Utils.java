package anet.channel.util;

import android.content.Context;
import android.content.pm.PackageManager;
import anet.channel.monitor.NetworkSpeed;
import anet.channel.monitor.b;
import anet.channel.status.NetworkStatusHelper;
import com.ta.utdid2.device.UTDevice;
import java.lang.reflect.Method;

public class Utils {
    private static final String TAG = "awcn.Utils";
    public static Context context;

    public static Context getAppContext() {
        Context context2 = context;
        if (context2 != null) {
            return context2;
        }
        synchronized (Utils.class) {
            Context context3 = context;
            if (context3 != null) {
                return context3;
            }
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(cls, new Object[0]);
                context = (Context) invoke.getClass().getMethod("getApplication", new Class[0]).invoke(invoke, new Object[0]);
            } catch (Exception e10) {
                ALog.w(TAG, "getAppContext", (String) null, e10, new Object[0]);
            }
            Context context4 = context;
            return context4;
        }
    }

    public static String getDeviceId(Context context2) {
        return UTDevice.getUtdid(context2);
    }

    public static String getMainProcessName(Context context2) {
        if (context2 == null) {
            return "";
        }
        try {
            return context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).applicationInfo.processName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static float getNetworkTimeFactor() {
        float f10;
        NetworkStatusHelper.NetworkStatus status = NetworkStatusHelper.getStatus();
        if (status == NetworkStatusHelper.NetworkStatus.G4 || status == NetworkStatusHelper.NetworkStatus.WIFI) {
            f10 = 0.8f;
        } else {
            f10 = 1.0f;
        }
        if (b.a().b() == NetworkSpeed.Fast.getCode()) {
            return f10 * 0.75f;
        }
        return f10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getProcessName(android.content.Context r5, int r6) {
        /*
            java.lang.String r0 = "rt"
            java.lang.String r1 = ""
            r2 = -108(0xffffffffffffff94, float:NaN)
            java.lang.String r3 = "activity"
            java.lang.Object r5 = r5.getSystemService(r3)     // Catch:{ Exception -> 0x0059 }
            android.app.ActivityManager r5 = (android.app.ActivityManager) r5     // Catch:{ Exception -> 0x0059 }
            java.util.List r5 = r5.getRunningAppProcesses()     // Catch:{ Exception -> 0x0059 }
            if (r5 == 0) goto L_0x0031
            int r3 = r5.size()     // Catch:{ Exception -> 0x0059 }
            if (r3 <= 0) goto L_0x0031
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x0059 }
        L_0x001e:
            boolean r3 = r5.hasNext()     // Catch:{ Exception -> 0x0059 }
            if (r3 == 0) goto L_0x006a
            java.lang.Object r3 = r5.next()     // Catch:{ Exception -> 0x0059 }
            android.app.ActivityManager$RunningAppProcessInfo r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3     // Catch:{ Exception -> 0x0059 }
            int r4 = r3.pid     // Catch:{ Exception -> 0x0059 }
            if (r4 != r6) goto L_0x001e
            java.lang.String r1 = r3.processName     // Catch:{ Exception -> 0x0059 }
            goto L_0x006a
        L_0x0031:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0059 }
            r5.<init>()     // Catch:{ Exception -> 0x0059 }
            java.lang.String r3 = "BuildVersion="
            r5.append(r3)     // Catch:{ Exception -> 0x0059 }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0059 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0059 }
            r5.append(r3)     // Catch:{ Exception -> 0x0059 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0059 }
            java.lang.String r5 = anet.channel.util.ErrorConstant.formatMsg(r2, r5)     // Catch:{ Exception -> 0x0059 }
            anet.channel.appmonitor.IAppMonitor r3 = anet.channel.appmonitor.AppMonitor.getInstance()     // Catch:{ Exception -> 0x0059 }
            anet.channel.statist.ExceptionStatistic r4 = new anet.channel.statist.ExceptionStatistic     // Catch:{ Exception -> 0x0059 }
            r4.<init>(r2, r5, r0)     // Catch:{ Exception -> 0x0059 }
            r3.commitStat(r4)     // Catch:{ Exception -> 0x0059 }
            goto L_0x006a
        L_0x0059:
            r5 = move-exception
            anet.channel.appmonitor.IAppMonitor r3 = anet.channel.appmonitor.AppMonitor.getInstance()
            anet.channel.statist.ExceptionStatistic r4 = new anet.channel.statist.ExceptionStatistic
            java.lang.String r5 = r5.toString()
            r4.<init>(r2, r5, r0)
            r3.commitStat(r4)
        L_0x006a:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 == 0) goto L_0x0074
            java.lang.String r1 = getProcessNameNew(r6)
        L_0x0074:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.Utils.getProcessName(android.content.Context, int):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bd A[SYNTHETIC, Splitter:B:37:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c5 A[Catch:{ IOException -> 0x00c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d4 A[SYNTHETIC, Splitter:B:46:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00dc A[Catch:{ IOException -> 0x00d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getProcessNameNew(int r10) {
        /*
            java.lang.String r0 = "  "
            java.lang.String r1 = "getProcessNameNew "
            java.lang.String r2 = "awcn.Utils"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "ps  |  grep  "
            r3.append(r4)
            r3.append(r10)
            java.lang.String r3 = r3.toString()
            r4 = 0
            r5 = 0
            java.lang.Runtime r6 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x00b3, all -> 0x00af }
            java.lang.String r7 = "sh"
            java.lang.Process r6 = r6.exec(r7)     // Catch:{ Exception -> 0x00b3, all -> 0x00af }
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00b3, all -> 0x00af }
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00b3, all -> 0x00af }
            java.io.InputStream r9 = r6.getInputStream()     // Catch:{ Exception -> 0x00b3, all -> 0x00af }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00b3, all -> 0x00af }
            r7.<init>(r8)     // Catch:{ Exception -> 0x00b3, all -> 0x00af }
            java.io.DataOutputStream r8 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.io.OutputStream r9 = r6.getOutputStream()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a7 }
            r9.<init>()     // Catch:{ Exception -> 0x00a7 }
            r9.append(r3)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r3 = "  &\n"
            r9.append(r3)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r3 = r9.toString()     // Catch:{ Exception -> 0x00a7 }
            r8.writeBytes(r3)     // Catch:{ Exception -> 0x00a7 }
            r8.flush()     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r3 = "exit\n"
            r8.writeBytes(r3)     // Catch:{ Exception -> 0x00a7 }
            r6.waitFor()     // Catch:{ Exception -> 0x00a7 }
        L_0x0059:
            java.lang.String r3 = r7.readLine()     // Catch:{ Exception -> 0x00a7 }
            if (r3 == 0) goto L_0x0099
            java.lang.String r6 = "\\s+"
            java.lang.String r3 = r3.replaceAll(r6, r0)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String[] r3 = r3.split(r0)     // Catch:{ Exception -> 0x00a7 }
            int r6 = r3.length     // Catch:{ Exception -> 0x00a7 }
            r9 = 9
            if (r6 < r9) goto L_0x0059
            r6 = 1
            r9 = r3[r6]     // Catch:{ Exception -> 0x00a7 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x00a7 }
            if (r9 != 0) goto L_0x0059
            r6 = r3[r6]     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r6 = r6.trim()     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r9 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x00a7 }
            boolean r6 = r6.equals(r9)     // Catch:{ Exception -> 0x00a7 }
            if (r6 == 0) goto L_0x0059
            r10 = 8
            r10 = r3[r10]     // Catch:{ Exception -> 0x00a7 }
            r7.close()     // Catch:{ IOException -> 0x0092 }
            r8.close()     // Catch:{ IOException -> 0x0092 }
            goto L_0x0098
        L_0x0092:
            r0 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r4]
            anet.channel.util.ALog.e(r2, r1, r5, r0, r3)
        L_0x0098:
            return r10
        L_0x0099:
            r7.close()     // Catch:{ IOException -> 0x00a0 }
            r8.close()     // Catch:{ IOException -> 0x00a0 }
            goto L_0x00ce
        L_0x00a0:
            r10 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r4]
            anet.channel.util.ALog.e(r2, r1, r5, r10, r0)
            goto L_0x00ce
        L_0x00a7:
            r10 = move-exception
            goto L_0x00b6
        L_0x00a9:
            r10 = move-exception
            r8 = r5
            goto L_0x00d2
        L_0x00ac:
            r10 = move-exception
            r8 = r5
            goto L_0x00b6
        L_0x00af:
            r10 = move-exception
            r7 = r5
            r8 = r7
            goto L_0x00d2
        L_0x00b3:
            r10 = move-exception
            r7 = r5
            r8 = r7
        L_0x00b6:
            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch:{ all -> 0x00d1 }
            anet.channel.util.ALog.e(r2, r1, r5, r10, r0)     // Catch:{ all -> 0x00d1 }
            if (r7 == 0) goto L_0x00c3
            r7.close()     // Catch:{ IOException -> 0x00c1 }
            goto L_0x00c3
        L_0x00c1:
            r10 = move-exception
            goto L_0x00c9
        L_0x00c3:
            if (r8 == 0) goto L_0x00ce
            r8.close()     // Catch:{ IOException -> 0x00c1 }
            goto L_0x00ce
        L_0x00c9:
            java.lang.Object[] r0 = new java.lang.Object[r4]
            anet.channel.util.ALog.e(r2, r1, r5, r10, r0)
        L_0x00ce:
            java.lang.String r10 = ""
            return r10
        L_0x00d1:
            r10 = move-exception
        L_0x00d2:
            if (r7 == 0) goto L_0x00da
            r7.close()     // Catch:{ IOException -> 0x00d8 }
            goto L_0x00da
        L_0x00d8:
            r0 = move-exception
            goto L_0x00e0
        L_0x00da:
            if (r8 == 0) goto L_0x00e5
            r8.close()     // Catch:{ IOException -> 0x00d8 }
            goto L_0x00e5
        L_0x00e0:
            java.lang.Object[] r3 = new java.lang.Object[r4]
            anet.channel.util.ALog.e(r2, r1, r5, r0, r3)
        L_0x00e5:
            goto L_0x00e7
        L_0x00e6:
            throw r10
        L_0x00e7:
            goto L_0x00e6
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.Utils.getProcessNameNew(int):java.lang.String");
    }

    public static String getStackMsg(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString() + "\n");
                }
            }
        } catch (Exception e10) {
            ALog.e(TAG, "getStackMsg", (String) null, e10, new Object[0]);
        }
        return stringBuffer.toString();
    }

    public static Object invokeStaticMethodThrowException(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        Method method;
        if (str == null || str2 == null) {
            return null;
        }
        Class<?> cls = Class.forName(str);
        if (clsArr != null) {
            method = cls.getDeclaredMethod(str2, clsArr);
        } else {
            method = cls.getDeclaredMethod(str2, new Class[0]);
        }
        if (method == null) {
            return null;
        }
        method.setAccessible(true);
        if (objArr != null) {
            return method.invoke(cls, objArr);
        }
        return method.invoke(cls, new Object[0]);
    }
}
