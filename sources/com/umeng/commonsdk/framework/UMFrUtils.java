package com.umeng.commonsdk.framework;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.soap.SOAP;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;

public class UMFrUtils {
    private static final String KEY_LAST_INSTANT_SUCC_BUILD_TIME = "last_instant_build_time";
    private static final String KEY_LAST_SUCC_BUILD_TIME = "last_successful_build_time";
    private static String mDefaultEnvelopeDir = bd.b().b(bd.f13841a);
    private static String mDefaultEnvelopeDirPath = null;
    private static Object mEnvelopeBuildTimeLock = new Object();
    private static Object mEnvelopeFileLock = new Object();
    private static String sCurrentProcessName = "";

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030 A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean checkPermission(android.content.Context r7, java.lang.String r8) {
        /*
            r0 = 0
            if (r7 == 0) goto L_0x004a
            android.content.Context r1 = r7.getApplicationContext()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            r4 = 1
            if (r2 < r3) goto L_0x0037
            java.lang.String r2 = "android.content.Context"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x0032 }
            java.lang.String r3 = "checkSelfPermission"
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ all -> 0x0032 }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r5[r0] = r6     // Catch:{ all -> 0x0032 }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r5)     // Catch:{ all -> 0x0032 }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ all -> 0x0032 }
            r3[r0] = r8     // Catch:{ all -> 0x0032 }
            java.lang.Object r7 = r2.invoke(r7, r3)     // Catch:{ all -> 0x0032 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ all -> 0x0032 }
            int r7 = r7.intValue()     // Catch:{ all -> 0x0032 }
            if (r7 != 0) goto L_0x004a
        L_0x0030:
            r0 = 1
            goto L_0x004a
        L_0x0032:
            r7 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r1, r7)
            goto L_0x004a
        L_0x0037:
            android.content.pm.PackageManager r7 = r1.getPackageManager()     // Catch:{ all -> 0x0046 }
            java.lang.String r2 = r1.getPackageName()     // Catch:{ all -> 0x0046 }
            int r7 = r7.checkPermission(r8, r2)     // Catch:{ all -> 0x0046 }
            if (r7 != 0) goto L_0x004a
            goto L_0x0030
        L_0x0046:
            r7 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r1, r7)
        L_0x004a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.UMFrUtils.checkPermission(android.content.Context, java.lang.String):boolean");
    }

    public static int envelopeFileNumber(Context context) {
        String[] list;
        if (context != null) {
            try {
                File file = new File(getEnvelopeDirPath(context));
                synchronized (mEnvelopeFileLock) {
                    if (file.isDirectory() && (list = file.list()) != null) {
                        int length = list.length;
                        return length;
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        }
        return 0;
    }

    public static String getCurrentProcessName(Context context) {
        String str;
        if (TextUtils.isEmpty(sCurrentProcessName)) {
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    str = Application.getProcessName();
                } else {
                    str = "";
                }
                if (TextUtils.isEmpty(str)) {
                    String processName = getProcessName(Process.myPid());
                    if (!TextUtils.isEmpty(processName)) {
                        sCurrentProcessName = processName;
                    }
                } else {
                    sCurrentProcessName = str;
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context.getApplicationContext(), th);
            }
        }
        return sCurrentProcessName;
    }

    private static long getDistanceDays(long j10, long j11) {
        long j12;
        if (j10 < j11) {
            j12 = j11 - j10;
        } else {
            j12 = j10 - j11;
        }
        return j12 / 86400000;
    }

    public static String getEnvelopeDirPath(Context context) {
        String str;
        synchronized (mEnvelopeFileLock) {
            try {
                if (mDefaultEnvelopeDirPath == null) {
                    mDefaultEnvelopeDirPath = context.getFilesDir().getAbsolutePath() + File.separator + "." + mDefaultEnvelopeDir;
                }
                File file = new File(mDefaultEnvelopeDirPath);
                if (!file.exists() && !file.mkdir()) {
                    ULog.d("--->>> Create Envelope Directory failed!!!");
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
            str = mDefaultEnvelopeDirPath;
        }
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File getEnvelopeFile(android.content.Context r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.File r1 = new java.io.File
            java.lang.String r3 = getEnvelopeDirPath(r3)
            r1.<init>(r3)
            java.lang.Object r3 = mEnvelopeFileLock
            monitor-enter(r3)
            java.io.File[] r1 = r1.listFiles()     // Catch:{ all -> 0x0029 }
            if (r1 == 0) goto L_0x0027
            int r2 = r1.length     // Catch:{ all -> 0x0029 }
            if (r2 != 0) goto L_0x001a
            goto L_0x0027
        L_0x001a:
            com.umeng.commonsdk.framework.UMFrUtils$2 r0 = new com.umeng.commonsdk.framework.UMFrUtils$2     // Catch:{ all -> 0x0029 }
            r0.<init>()     // Catch:{ all -> 0x0029 }
            java.util.Arrays.sort(r1, r0)     // Catch:{ all -> 0x0029 }
            r0 = 0
            r0 = r1[r0]     // Catch:{ all -> 0x0029 }
            monitor-exit(r3)     // Catch:{ all -> 0x0029 }
            return r0
        L_0x0027:
            monitor-exit(r3)     // Catch:{ all -> 0x0029 }
            return r0
        L_0x0029:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0029 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.UMFrUtils.getEnvelopeFile(android.content.Context):java.io.File");
    }

    public static long getLastInstantBuildTime(Context context) {
        long j10;
        synchronized (mEnvelopeBuildTimeLock) {
            j10 = PreferenceWrapper.getDefault(context).getLong(KEY_LAST_INSTANT_SUCC_BUILD_TIME, 0);
        }
        return j10;
    }

    public static long getLastSuccessfulBuildTime(Context context) {
        long j10;
        synchronized (mEnvelopeBuildTimeLock) {
            j10 = PreferenceWrapper.getDefault(context).getLong(KEY_LAST_SUCC_BUILD_TIME, 0);
        }
        return j10;
    }

    public static String getLegacyEnvelopeDir(Context context) {
        try {
            String currentProcessName = getCurrentProcessName(context);
            if (!TextUtils.isEmpty(currentProcessName)) {
                String b10 = bd.b().b(bd.B);
                String replace = currentProcessName.replace(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER, '_');
                ULog.d("--->>> getEnvelopeDir: use current process name as envelope directory.");
                return b10 + replace;
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        return mDefaultEnvelopeDir;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036 A[SYNTHETIC, Splitter:B:15:0x0036] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getProcessName(int r5) {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0033 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ all -> 0x0033 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0033 }
            r3.<init>()     // Catch:{ all -> 0x0033 }
            java.lang.String r4 = "/proc/"
            r3.append(r4)     // Catch:{ all -> 0x0033 }
            r3.append(r5)     // Catch:{ all -> 0x0033 }
            java.lang.String r5 = "/cmdline"
            r3.append(r5)     // Catch:{ all -> 0x0033 }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x0033 }
            r2.<init>(r5)     // Catch:{ all -> 0x0033 }
            r1.<init>(r2)     // Catch:{ all -> 0x0033 }
            java.lang.String r5 = r1.readLine()     // Catch:{ all -> 0x0034 }
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0034 }
            if (r2 != 0) goto L_0x002f
            java.lang.String r5 = r5.trim()     // Catch:{ all -> 0x0034 }
        L_0x002f:
            r1.close()     // Catch:{ all -> 0x0032 }
        L_0x0032:
            return r5
        L_0x0033:
            r1 = r0
        L_0x0034:
            if (r1 == 0) goto L_0x0039
            r1.close()     // Catch:{ all -> 0x0039 }
        L_0x0039:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.UMFrUtils.getProcessName(int):java.lang.String");
    }

    public static String getSubProcessName(Context context) {
        String str = "";
        try {
            String currentProcessName = getCurrentProcessName(context);
            int indexOf = currentProcessName.indexOf(SOAP.DELIM);
            if (indexOf >= 0) {
                str = currentProcessName.substring(indexOf + 1);
            }
            if (indexOf < 0) {
                String packageName = context.getPackageName();
                if (currentProcessName.length() > packageName.length()) {
                    return currentProcessName.substring(packageName.length() + 1, currentProcessName.length());
                }
                return currentProcessName;
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context.getApplicationContext(), th);
        }
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0044, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean hasEnvelopeFile(android.content.Context r6, com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType r7) {
        /*
            java.lang.String r0 = "a"
            com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType r1 = com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_INTERNAL
            if (r7 != r1) goto L_0x0008
            java.lang.String r0 = "i"
        L_0x0008:
            com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType r1 = com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_ZeroEnv
            if (r7 != r1) goto L_0x000e
            java.lang.String r0 = "z"
        L_0x000e:
            com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType r1 = com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_Silent
            if (r7 != r1) goto L_0x0014
            java.lang.String r0 = "h"
        L_0x0014:
            java.lang.String r7 = getEnvelopeDirPath(r6)
            r1 = 0
            if (r7 == 0) goto L_0x004e
            java.io.File r2 = new java.io.File
            r2.<init>(r7)
            java.lang.Object r7 = mEnvelopeFileLock
            monitor-enter(r7)
            java.io.File[] r2 = r2.listFiles()     // Catch:{ all -> 0x0045 }
            if (r2 == 0) goto L_0x0043
            int r3 = r2.length     // Catch:{ all -> 0x0045 }
            if (r3 != 0) goto L_0x002d
            goto L_0x0043
        L_0x002d:
            int r3 = r2.length     // Catch:{ all -> 0x0045 }
            r4 = 0
        L_0x002f:
            if (r4 >= r3) goto L_0x0049
            r5 = r2[r4]     // Catch:{ all -> 0x0045 }
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x0045 }
            boolean r5 = r5.startsWith(r0)     // Catch:{ all -> 0x0045 }
            if (r5 == 0) goto L_0x0040
            monitor-exit(r7)     // Catch:{ all -> 0x004b }
            r6 = 1
            return r6
        L_0x0040:
            int r4 = r4 + 1
            goto L_0x002f
        L_0x0043:
            monitor-exit(r7)     // Catch:{ all -> 0x004b }
            return r1
        L_0x0045:
            r0 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r0)     // Catch:{ all -> 0x004b }
        L_0x0049:
            monitor-exit(r7)     // Catch:{ all -> 0x004b }
            return r1
        L_0x004b:
            r6 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x004b }
            throw r6
        L_0x004e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(android.content.Context, com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType):boolean");
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnectedOrConnecting();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context.getApplicationContext(), th);
            return false;
        }
    }

    public static boolean removeEnvelopeFile(File file) {
        Context appContext = UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        boolean delete = file.delete();
                        return delete;
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(appContext, th);
                }
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0051, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void removeRedundantEnvelopeFiles(android.content.Context r5, int r6) {
        /*
            java.io.File r0 = new java.io.File
            java.lang.String r1 = getEnvelopeDirPath(r5)
            r0.<init>(r1)
            java.lang.Object r1 = mEnvelopeFileLock
            monitor-enter(r1)
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0050
            int r2 = r0.length     // Catch:{ all -> 0x0052 }
            if (r2 > r6) goto L_0x0016
            goto L_0x0050
        L_0x0016:
            com.umeng.commonsdk.framework.UMFrUtils$1 r2 = new com.umeng.commonsdk.framework.UMFrUtils$1     // Catch:{ all -> 0x0052 }
            r2.<init>()     // Catch:{ all -> 0x0052 }
            java.util.Arrays.sort(r0, r2)     // Catch:{ all -> 0x0052 }
            int r2 = r0.length     // Catch:{ all -> 0x0052 }
            if (r2 <= r6) goto L_0x004e
            r2 = 0
        L_0x0022:
            int r3 = r0.length     // Catch:{ all -> 0x004a }
            int r3 = r3 - r6
            if (r2 >= r3) goto L_0x004e
            r3 = r0[r2]     // Catch:{ all -> 0x004a }
            boolean r3 = r3.delete()     // Catch:{ all -> 0x004a }
            if (r3 != 0) goto L_0x0047
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x004a }
            r3.<init>()     // Catch:{ all -> 0x004a }
            java.lang.String r4 = "--->>> remove ["
            r3.append(r4)     // Catch:{ all -> 0x004a }
            r3.append(r2)     // Catch:{ all -> 0x004a }
            java.lang.String r4 = "] file fail."
            r3.append(r4)     // Catch:{ all -> 0x004a }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x004a }
            com.umeng.commonsdk.statistics.common.ULog.d((java.lang.String) r3)     // Catch:{ all -> 0x004a }
        L_0x0047:
            int r2 = r2 + 1
            goto L_0x0022
        L_0x004a:
            r6 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r6)     // Catch:{ all -> 0x0052 }
        L_0x004e:
            monitor-exit(r1)     // Catch:{ all -> 0x0052 }
            return
        L_0x0050:
            monitor-exit(r1)     // Catch:{ all -> 0x0052 }
            return
        L_0x0052:
            r5 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0052 }
            goto L_0x0056
        L_0x0055:
            throw r5
        L_0x0056:
            goto L_0x0055
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.UMFrUtils.removeRedundantEnvelopeFiles(android.content.Context, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        return 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005c A[SYNTHETIC, Splitter:B:27:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068 A[SYNTHETIC, Splitter:B:35:0x0068] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int saveEnvelopeFile(android.content.Context r5, java.lang.String r6, byte[] r7) {
        /*
            r0 = 101(0x65, float:1.42E-43)
            if (r7 != 0) goto L_0x0005
            return r0
        L_0x0005:
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = getEnvelopeDirPath(r5)
            r2.append(r3)
            java.lang.String r3 = java.io.File.separator
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            java.lang.Object r2 = mEnvelopeFileLock
            monitor-enter(r2)
            r3 = 0
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0056 }
            r4.<init>(r1)     // Catch:{ IOException -> 0x0056 }
            r4.write(r7)     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            r4.close()     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            com.umeng.commonsdk.statistics.internal.a r7 = com.umeng.commonsdk.statistics.internal.a.a((android.content.Context) r5)     // Catch:{ all -> 0x0071 }
            boolean r7 = r7.a((java.lang.String) r6)     // Catch:{ all -> 0x0071 }
            com.umeng.commonsdk.statistics.internal.a r0 = com.umeng.commonsdk.statistics.internal.a.a((android.content.Context) r5)     // Catch:{ all -> 0x0071 }
            boolean r6 = r0.b(r6)     // Catch:{ all -> 0x0071 }
            if (r7 == 0) goto L_0x0046
            updateLastSuccessfulBuildTime(r5)     // Catch:{ all -> 0x0071 }
        L_0x0046:
            if (r6 == 0) goto L_0x004b
            updateLastInstantBuildTime(r5)     // Catch:{ all -> 0x0071 }
        L_0x004b:
            monitor-exit(r2)     // Catch:{ all -> 0x0071 }
            r5 = 0
            return r5
        L_0x004e:
            r6 = move-exception
            r3 = r4
            goto L_0x0066
        L_0x0051:
            r6 = move-exception
            r3 = r4
            goto L_0x0057
        L_0x0054:
            r6 = move-exception
            goto L_0x0066
        L_0x0056:
            r6 = move-exception
        L_0x0057:
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r6)     // Catch:{ all -> 0x0054 }
            if (r3 == 0) goto L_0x0064
            r3.close()     // Catch:{ all -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r6 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r6)     // Catch:{ all -> 0x0071 }
        L_0x0064:
            monitor-exit(r2)     // Catch:{ all -> 0x0071 }
            return r0
        L_0x0066:
            if (r3 == 0) goto L_0x0070
            r3.close()     // Catch:{ all -> 0x006c }
            goto L_0x0070
        L_0x006c:
            r7 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r7)     // Catch:{ all -> 0x0071 }
        L_0x0070:
            throw r6     // Catch:{ all -> 0x0071 }
        L_0x0071:
            r5 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0071 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.UMFrUtils.saveEnvelopeFile(android.content.Context, java.lang.String, byte[]):int");
    }

    public static void syncLegacyEnvelopeIfNeeded(Context context) {
        if (context != null) {
            try {
                String legacyEnvelopeDir = getLegacyEnvelopeDir(context);
                if (!TextUtils.isEmpty(legacyEnvelopeDir) && !legacyEnvelopeDir.equals(mDefaultEnvelopeDir)) {
                    File file = new File(context.getFilesDir().getAbsolutePath() + "/." + legacyEnvelopeDir);
                    if (file.exists()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles == null || listFiles.length == 0) {
                            try {
                                if (file.isDirectory()) {
                                    file.delete();
                                }
                            } catch (Throwable th) {
                                UMCrashManager.reportCrash(context, th);
                            }
                        } else {
                            String envelopeDirPath = getEnvelopeDirPath(context);
                            for (int i10 = 0; i10 < listFiles.length; i10++) {
                                File file2 = listFiles[i10];
                                file2.renameTo(new File(envelopeDirPath + File.separator + listFiles[i10].getName()));
                            }
                            if (file.isDirectory()) {
                                file.delete();
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(context, th2);
            }
        }
    }

    public static byte[] toByteArray(String str) {
        byte[] bArr;
        Context appContext = UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            AbstractInterruptibleChannel abstractInterruptibleChannel = null;
            try {
                FileChannel channel = new RandomAccessFile(str, "r").getChannel();
                MappedByteBuffer load = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size()).load();
                bArr = new byte[((int) channel.size())];
                if (load.remaining() > 0) {
                    load.get(bArr, 0, load.remaining());
                }
                channel.close();
            } catch (IOException e10) {
                UMCrashManager.reportCrash(appContext, e10);
                throw e10;
            } catch (Throwable th) {
                UMCrashManager.reportCrash(appContext, th);
            }
        }
        return bArr;
        throw th;
    }

    private static void updateLastInstantBuildTime(Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(KEY_LAST_INSTANT_SUCC_BUILD_TIME, System.currentTimeMillis()).commit();
        }
    }

    private static void updateLastSuccessfulBuildTime(Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(KEY_LAST_SUCC_BUILD_TIME, System.currentTimeMillis()).commit();
        }
    }
}
