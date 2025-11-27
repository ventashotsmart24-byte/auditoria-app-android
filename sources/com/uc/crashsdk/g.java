package com.uc.crashsdk;

import android.os.Build;
import android.os.Bundle;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.uc.crashsdk.a.a;
import com.uc.crashsdk.a.d;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.export.CustomInfo;
import com.uc.crashsdk.export.VersionInfo;
import java.io.File;
import java.lang.reflect.Field;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public static RuntimeException f13612a = null;

    /* renamed from: b  reason: collision with root package name */
    public static RuntimeException f13613b = null;

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ boolean f13614c = true;

    /* renamed from: d  reason: collision with root package name */
    private static CustomInfo f13615d;

    /* renamed from: e  reason: collision with root package name */
    private static VersionInfo f13616e;

    /* renamed from: f  reason: collision with root package name */
    private static final Object f13617f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static String f13618g;

    /* renamed from: h  reason: collision with root package name */
    private static String f13619h;

    /* renamed from: i  reason: collision with root package name */
    private static String f13620i;

    /* renamed from: j  reason: collision with root package name */
    private static String f13621j;

    /* renamed from: k  reason: collision with root package name */
    private static final Object f13622k = new Object();

    public static String A() {
        return f13615d.mCrashRateUploadUrl;
    }

    public static int B() {
        return f13615d.mLogMaxBytesLimit;
    }

    public static int C() {
        return f13615d.mLogMaxUploadBytesLimit;
    }

    public static long D() {
        return f13615d.mMaxUploadBytesPerDay;
    }

    public static int E() {
        return f13615d.mMaxUploadBuiltinLogCountPerDay;
    }

    public static int F() {
        return f13615d.mMaxUploadCustomLogCountPerDay;
    }

    public static int G() {
        return f13615d.mMaxCustomLogCountPerTypePerDay;
    }

    public static int H() {
        return f13615d.mInfoUpdateInterval;
    }

    public static int I() {
        return f13615d.mInfoSaveFrequency;
    }

    public static int J() {
        return f13615d.mReservedJavaFileHandleCount;
    }

    public static int K() {
        return f13615d.mFdDumpMinLimit;
    }

    public static int L() {
        return f13615d.mThreadsDumpMinLimit;
    }

    public static boolean M() {
        return f13615d.mAutoDetectLifeCycle;
    }

    public static boolean N() {
        return f13615d.mMonitorBattery;
    }

    public static int O() {
        return f13615d.mAnrTraceStrategy;
    }

    public static boolean P() {
        CustomInfo customInfo = f13615d;
        if (customInfo == null || customInfo.mDebug) {
            return true;
        }
        return false;
    }

    public static boolean Q() {
        CustomInfo customInfo = f13615d;
        if (customInfo == null || customInfo.mPrintStackInfos) {
            return true;
        }
        return false;
    }

    public static boolean R() {
        return f13615d.mEnableStatReport;
    }

    public static boolean S() {
        return f13615d.mIsInternational;
    }

    public static boolean T() {
        return f13615d.mAddPvForNewDay;
    }

    public static String U() {
        if (com.uc.crashsdk.a.g.a(f13616e.mVersion)) {
            return a.a();
        }
        return a(f13616e.mVersion);
    }

    public static String V() {
        if (com.uc.crashsdk.a.g.a(f13616e.mSubVersion)) {
            return "release";
        }
        return f13616e.mSubVersion;
    }

    public static String W() {
        if (com.uc.crashsdk.a.g.a(f13616e.mBuildId)) {
            return ae();
        }
        return a(f13616e.mBuildId);
    }

    public static String X() {
        if (f13619h == null) {
            f13619h = com.uc.crashsdk.a.g.b() + File.separatorChar + f13615d.mTagFilesFolderName + File.separatorChar;
        }
        return f13619h;
    }

    public static String Y() {
        if (f13620i == null) {
            f13620i = com.uc.crashsdk.a.g.b() + File.separatorChar + f13615d.mCrashLogsFolderName + File.separatorChar;
        }
        return f13620i;
    }

    public static String Z() {
        if (f13621j == null) {
            if (!com.uc.crashsdk.a.g.a(f13615d.mLogsBackupPathName)) {
                String trim = f13615d.mLogsBackupPathName.trim();
                String str = File.separator;
                if (!trim.endsWith(str)) {
                    trim = trim + str;
                }
                f13621j = trim;
            } else {
                f13621j = (com.uc.crashsdk.a.g.b() + File.separatorChar + "msdb" + File.separatorChar) + File.separatorChar + f13615d.mCrashLogsFolderName + File.separatorChar;
            }
        }
        return f13621j;
    }

    public static void a(CustomInfo customInfo, VersionInfo versionInfo) {
        CustomInfo customInfo2 = new CustomInfo(customInfo);
        f13615d = customInfo2;
        c(customInfo2);
        if (!f13615d.mZipLog) {
            f13612a = new RuntimeException("initialize set mZipLog to false, info.mZipLog: " + customInfo.mZipLog);
        }
        if (f13615d.mEncryptLog) {
            f13613b = new RuntimeException("initialize set mEncryptLog to true, info.mEncryptLog: " + customInfo.mEncryptLog);
        }
        f13616e = new VersionInfo(versionInfo);
        if (!b.L()) {
            try {
                a();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
    }

    public static boolean aa() {
        return f13615d.mEnableCrpStat;
    }

    public static boolean ab() {
        return f13615d.mEnableStatToWPKDirect;
    }

    public static String ac() {
        return f13615d.mUserId;
    }

    public static String ad() {
        return f13615d.mChannel;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0045, code lost:
        if (r1 != null) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String ae() {
        /*
            java.lang.String r0 = f13618g
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            r0 = 0
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch:{ all -> 0x003a }
            java.lang.String r2 = com.uc.crashsdk.a.g.c()     // Catch:{ all -> 0x003a }
            r1.<init>(r2)     // Catch:{ all -> 0x003a }
            java.lang.String r0 = "classes.dex"
            java.util.zip.ZipEntry r0 = r1.getEntry(r0)     // Catch:{ all -> 0x0038 }
            long r2 = r0.getCrc()     // Catch:{ all -> 0x0038 }
            java.lang.String r0 = java.lang.Long.toHexString(r2)     // Catch:{ all -> 0x0038 }
            f13618g = r0     // Catch:{ all -> 0x0038 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0038 }
            java.lang.String r2 = "version unique build id: "
            r0.<init>(r2)     // Catch:{ all -> 0x0038 }
            java.lang.String r2 = f13618g     // Catch:{ all -> 0x0038 }
            r0.append(r2)     // Catch:{ all -> 0x0038 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0038 }
            java.lang.String r2 = "crashsdk"
            com.uc.crashsdk.a.a.a(r2, r0)     // Catch:{ all -> 0x0038 }
        L_0x0034:
            r1.close()     // Catch:{ all -> 0x0048 }
            goto L_0x0048
        L_0x0038:
            r0 = move-exception
            goto L_0x003e
        L_0x003a:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x003e:
            java.lang.String r2 = ""
            f13618g = r2     // Catch:{ all -> 0x004b }
            com.uc.crashsdk.a.g.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x0048
            goto L_0x0034
        L_0x0048:
            java.lang.String r0 = f13618g
            return r0
        L_0x004b:
            r0 = move-exception
            if (r1 == 0) goto L_0x0051
            r1.close()     // Catch:{ all -> 0x0051 }
        L_0x0051:
            goto L_0x0053
        L_0x0052:
            throw r0
        L_0x0053:
            goto L_0x0052
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.g.ae():java.lang.String");
    }

    private static void af() {
        if (b.f13531d) {
            JNIBridge.nativeSet(24, 1, a.f13447b, (Object[]) null);
        }
    }

    public static void b() {
        JNIBridge.set(103, com.uc.crashsdk.a.g.b());
        JNIBridge.set(104, f13615d.mTagFilesFolderName);
        JNIBridge.set(105, f13615d.mCrashLogsFolderName);
        JNIBridge.set(106, Z());
        JNIBridge.set(107, e.h());
        JNIBridge.set(108, b.a());
        JNIBridge.set(109, U());
        JNIBridge.set(110, V());
        JNIBridge.set(111, W());
        JNIBridge.set(112, "240515102041");
        JNIBridge.set(116, Build.MODEL);
        JNIBridge.set(117, Build.VERSION.RELEASE);
        JNIBridge.set(118, e.q());
        JNIBridge.set(5, f13615d.mCallNativeDefaultHandler);
        JNIBridge.set(6, f13615d.mDumpUserSolibBuildId);
        JNIBridge.set(7, f13615d.mReservedNativeMemoryBytes);
        JNIBridge.set(100, f13615d.mNativeCrashLogFileName);
        JNIBridge.set(101, f13615d.mUnexpCrashLogFileName);
        JNIBridge.set(35, f13615d.mEnableMemoryGroup);
        JNIBridge.set(36, f13615d.mEnableLibcMallocDetail);
        JNIBridge.set(131, f13615d.mLibcMallocDetailConfig);
        JNIBridge.set(102, f13615d.mAppId);
        JNIBridge.set(38, f13615d.mCrashRateUploadUrl);
        JNIBridge.set(39, f13615d.mCrashSDKAuthUrl);
    }

    private static void c(CustomInfo customInfo) {
        if (customInfo.mZippedLogExtension == null) {
            customInfo.mZippedLogExtension = "";
        }
        if (!customInfo.mZippedLogExtension.equals(".tmp")) {
            if (customInfo.mOmitJavaCrash) {
                customInfo.mCallJavaDefaultHandler = false;
            }
            if (customInfo.mOmitNativeCrash) {
                customInfo.mCallNativeDefaultHandler = false;
            }
            long b10 = e.b();
            if (b10 >= 1) {
                customInfo.mMaxBuiltinLogFilesCount = 200;
                customInfo.mMaxCustomLogFilesCount = 100;
                customInfo.mMaxUploadBytesPerDay = 268435456;
                customInfo.mMaxUploadBuiltinLogCountPerDay = 2000;
                customInfo.mMaxUploadCustomLogCountPerDay = 2000;
                customInfo.mMaxCustomLogCountPerTypePerDay = 100;
                customInfo.mMaxAnrLogCountPerProcess = 100;
                customInfo.mAnrTraceStrategy = 2;
                if (b10 >= 2) {
                    customInfo.mSyncUploadSetupCrashLogs = true;
                    customInfo.mSyncUploadLogs = true;
                    if (b10 >= 3) {
                        customInfo.mBackupLogs = true;
                        customInfo.mPrintStackInfos = true;
                        customInfo.mDebug = true;
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("mZippedLogExtension can not be '.tmp'!");
    }

    public static void d() {
        JNIBridge.set(23, f13615d.mIsInternational);
        if (b.H()) {
            JNIBridge.set(34, true);
        }
        if (e.i()) {
            JNIBridge.set(1, true);
        }
        JNIBridge.set(10, (long) f13615d.mFdDumpMinLimit);
        JNIBridge.nativeCmd(3, (long) f13615d.mReservedNativeFileHandleCount, (String) null, (Object[]) null);
        JNIBridge.nativeSetForeground(b.B());
        JNIBridge.set(2, b.F());
        a.e();
        a.g();
        a.i();
        a.k();
        JNIBridge.set(113, a.f13446a);
        JNIBridge.cmd(1);
        JNIBridge.set(22, (long) f13615d.mThreadsDumpMinLimit);
        JNIBridge.set(122, a.a());
        JNIBridge.set(33, (long) a.c());
        af();
        b.K();
        b.D();
        com.uc.crashsdk.a.g.k();
    }

    public static String e() {
        return f13615d.mAppId;
    }

    public static boolean f() {
        if (!com.uc.crashsdk.a.g.b(f13615d.mJavaCrashLogFileName) && !com.uc.crashsdk.a.g.b(f13615d.mNativeCrashLogFileName)) {
            return com.uc.crashsdk.a.g.b(f13615d.mUnexpCrashLogFileName);
        }
        return true;
    }

    public static String g() {
        return f13615d.mJavaCrashLogFileName;
    }

    public static int h() {
        return f13615d.mCrashRestartInterval;
    }

    public static boolean i() {
        return f13615d.mCallJavaDefaultHandler;
    }

    public static boolean j() {
        return f13615d.mEnableKillProcessAfterCrash;
    }

    public static boolean k() {
        return f13615d.mDumpHprofDataForJavaOOM;
    }

    public static boolean l() {
        return f13615d.mRenameFileToDefaultName;
    }

    public static int m() {
        return f13615d.mMaxBuiltinLogFilesCount;
    }

    public static int n() {
        return f13615d.mMaxCustomLogFilesCount;
    }

    public static int o() {
        return f13615d.mMaxJavaLogcatLineCount;
    }

    public static int p() {
        return f13615d.mUnexpDelayMillSeconds;
    }

    public static int q() {
        return f13615d.mUnexpSubTypes;
    }

    public static boolean r() {
        return f13615d.mBackupLogs;
    }

    public static boolean s() {
        return f13615d.mSyncUploadSetupCrashLogs;
    }

    public static boolean t() {
        return f13615d.mSyncUploadLogs;
    }

    public static boolean u() {
        return f13615d.mOmitJavaCrash;
    }

    public static boolean v() {
        return f13615d.mAutoDeleteOldVersionStats;
    }

    public static boolean w() {
        return f13615d.mZipLog;
    }

    public static String x() {
        return f13615d.mZippedLogExtension;
    }

    public static boolean y() {
        return f13615d.mEncryptLog;
    }

    public static String z() {
        return f13615d.mCrashLogUploadUrl;
    }

    public static void a(CustomInfo customInfo) {
        boolean z10 = f13614c;
        if (!z10 && customInfo.mTagFilesFolderName == null) {
            throw new AssertionError();
        } else if (!z10 && customInfo.mCrashLogsFolderName == null) {
            throw new AssertionError();
        } else if (customInfo.mTagFilesFolderName.equals(customInfo.mCrashLogsFolderName)) {
            throw new IllegalArgumentException("mTagFilesFolderName and mCrashLogsFolderName can not be set to the same!");
        }
    }

    public static void a(VersionInfo versionInfo) {
        synchronized (f13617f) {
            f13616e = new VersionInfo(versionInfo);
            e.c();
            if (b.f13531d) {
                JNIBridge.set(109, U());
                JNIBridge.set(110, V());
                JNIBridge.set(111, W());
                JNIBridge.set(112, "240515102041");
                JNIBridge.cmd(2);
            }
        }
    }

    public static void a() {
        b.y();
        b.x();
        if (f13615d.mBackupLogs) {
            File file = new File(Z());
            if (!file.exists()) {
                file.mkdirs();
            }
        }
    }

    public static void c() {
        JNIBridge.set(11, Q());
        JNIBridge.set(12, f13615d.mBackupLogs);
        JNIBridge.set(13, (long) f13615d.mCrashRestartInterval);
        JNIBridge.set(14, (long) f13615d.mMaxBuiltinLogFilesCount);
        JNIBridge.set(15, (long) f13615d.mMaxNativeLogcatLineCount);
        JNIBridge.set(16, (long) f13615d.mMaxUnexpLogcatLineCount);
        JNIBridge.set(31, (long) f13615d.mMaxAnrLogcatLineCount);
        JNIBridge.set(18, P());
        JNIBridge.set(20, (long) Build.VERSION.SDK_INT);
        JNIBridge.set(21, f13615d.mOmitNativeCrash);
        JNIBridge.set(32, (long) f13615d.mMaxAnrLogCountPerProcess);
        JNIBridge.set(8, f13615d.mDisableSignals);
        JNIBridge.set(9, f13615d.mDisableBackgroundSignals);
        CustomInfo customInfo = f13615d;
        JNIBridge.nativeSet(3, customInfo.mZipLog ? 1 : 0, customInfo.mZippedLogExtension, (Object[]) null);
        JNIBridge.set(4, (long) f13615d.mLogMaxBytesLimit);
        JNIBridge.set(119, Build.FINGERPRINT);
    }

    private static String a(String str) {
        return (str == null || !str.contains("_")) ? str : str.replaceAll("_", Operator.Operation.MINUS);
    }

    public static int b(CustomInfo customInfo) {
        int i10;
        boolean z10;
        int i11;
        boolean z11;
        synchronized (f13622k) {
            i10 = 0;
            if (customInfo != null) {
                c(customInfo);
                if (f13615d == null) {
                    f13615d = new CustomInfo();
                }
                CustomInfo customInfo2 = f13615d;
                boolean z12 = true;
                if (!a(customInfo.mAppId, customInfo2.mAppId)) {
                    String str = customInfo.mAppId;
                    customInfo2.mAppId = str;
                    if (b.f13531d) {
                        JNIBridge.set(102, str);
                    }
                    i11 = 1;
                    z10 = true;
                } else {
                    i11 = 0;
                    z10 = false;
                }
                if (!a(customInfo.mJavaCrashLogFileName, customInfo2.mJavaCrashLogFileName)) {
                    customInfo2.mJavaCrashLogFileName = customInfo.mJavaCrashLogFileName;
                    i11++;
                }
                if (!a(customInfo.mNativeCrashLogFileName, customInfo2.mNativeCrashLogFileName)) {
                    String str2 = customInfo.mNativeCrashLogFileName;
                    customInfo2.mNativeCrashLogFileName = str2;
                    if (b.f13531d) {
                        JNIBridge.set(100, str2);
                    }
                    i11++;
                    z10 = true;
                }
                if (!a(customInfo.mUnexpCrashLogFileName, customInfo2.mUnexpCrashLogFileName)) {
                    String str3 = customInfo.mUnexpCrashLogFileName;
                    customInfo2.mUnexpCrashLogFileName = str3;
                    if (b.f13531d) {
                        JNIBridge.set(101, str3);
                    }
                    i11++;
                    z10 = true;
                }
                if (z10) {
                    e.c();
                    if (b.f13531d) {
                        JNIBridge.cmd(2);
                    }
                }
                boolean z13 = customInfo2.mPrintStackInfos;
                boolean z14 = customInfo.mPrintStackInfos;
                if (z13 != z14) {
                    customInfo2.mPrintStackInfos = z14;
                    if (b.f13531d) {
                        JNIBridge.set(11, z14);
                    }
                    i11++;
                }
                boolean z15 = customInfo2.mDebug;
                boolean z16 = customInfo.mDebug;
                if (z15 != z16) {
                    customInfo2.mDebug = z16;
                    if (b.f13531d) {
                        JNIBridge.set(18, z16);
                    }
                    i11++;
                }
                boolean z17 = customInfo2.mBackupLogs;
                boolean z18 = customInfo.mBackupLogs;
                if (z17 != z18) {
                    customInfo2.mBackupLogs = z18;
                    if (b.f13531d) {
                        JNIBridge.set(12, z18);
                    }
                    i11++;
                }
                boolean z19 = customInfo2.mOmitNativeCrash;
                boolean z20 = customInfo.mOmitNativeCrash;
                if (z19 != z20) {
                    customInfo2.mOmitNativeCrash = z20;
                    if (b.f13531d) {
                        JNIBridge.set(21, z20);
                    }
                    i11++;
                }
                int i12 = customInfo2.mCrashRestartInterval;
                int i13 = customInfo.mCrashRestartInterval;
                if (i12 != i13) {
                    customInfo2.mCrashRestartInterval = i13;
                    if (b.f13531d) {
                        JNIBridge.set(13, (long) i13);
                    }
                    if (customInfo2.mCrashRestartInterval >= 0) {
                        b.M();
                    }
                    i11++;
                }
                int i14 = customInfo2.mMaxBuiltinLogFilesCount;
                int i15 = customInfo.mMaxBuiltinLogFilesCount;
                if (i14 != i15) {
                    customInfo2.mMaxBuiltinLogFilesCount = i15;
                    if (b.f13531d) {
                        JNIBridge.set(14, (long) i15);
                    }
                    i11++;
                }
                int i16 = customInfo2.mMaxNativeLogcatLineCount;
                int i17 = customInfo.mMaxNativeLogcatLineCount;
                if (i16 != i17) {
                    customInfo2.mMaxNativeLogcatLineCount = i17;
                    if (b.f13531d) {
                        JNIBridge.set(15, (long) i17);
                    }
                    i11++;
                }
                int i18 = customInfo2.mMaxJavaLogcatLineCount;
                int i19 = customInfo.mMaxJavaLogcatLineCount;
                if (i18 != i19) {
                    customInfo2.mMaxJavaLogcatLineCount = i19;
                    i11++;
                }
                int i20 = customInfo2.mMaxUnexpLogcatLineCount;
                int i21 = customInfo.mMaxUnexpLogcatLineCount;
                if (i20 != i21) {
                    customInfo2.mMaxUnexpLogcatLineCount = i21;
                    if (b.f13531d) {
                        JNIBridge.set(16, (long) i21);
                    }
                    i11++;
                }
                int i22 = customInfo2.mMaxAnrLogcatLineCount;
                int i23 = customInfo.mMaxAnrLogcatLineCount;
                if (i22 != i23) {
                    customInfo2.mMaxAnrLogcatLineCount = i23;
                    if (b.f13531d) {
                        JNIBridge.set(31, (long) i23);
                    }
                    i11++;
                }
                boolean z21 = customInfo2.mZipLog;
                boolean z22 = customInfo.mZipLog;
                if (z21 != z22) {
                    customInfo2.mZipLog = z22;
                    if (!z22) {
                        a.d("DEBUG", "updateCustomInfoImpl set mZipLog to false");
                        f13612a = new RuntimeException("updateCustomInfoImpl set mZipLog to false");
                    }
                    i11++;
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!a(customInfo.mZippedLogExtension, customInfo2.mZippedLogExtension)) {
                    customInfo2.mZippedLogExtension = customInfo.mZippedLogExtension;
                    i11++;
                } else {
                    z12 = z11;
                }
                if (z12 && b.f13531d) {
                    JNIBridge.nativeSet(3, customInfo2.mZipLog ? 1 : 0, customInfo2.mZippedLogExtension, (Object[]) null);
                }
                int i24 = customInfo2.mLogMaxBytesLimit;
                int i25 = customInfo.mLogMaxBytesLimit;
                if (i24 != i25) {
                    customInfo2.mLogMaxBytesLimit = i25;
                    if (b.f13531d) {
                        JNIBridge.set(4, (long) i25);
                    }
                    i11++;
                }
                boolean z23 = customInfo2.mEncryptLog;
                boolean z24 = customInfo.mEncryptLog;
                if (z23 != z24) {
                    customInfo2.mEncryptLog = z24;
                    if (z24) {
                        a.d("DEBUG", "updateCustomInfoImpl set mEncryptLog to true");
                        f13613b = new RuntimeException("updateCustomInfoImpl set mEncryptLog to true");
                    }
                    i11++;
                }
                boolean z25 = customInfo2.mSyncUploadSetupCrashLogs;
                boolean z26 = customInfo.mSyncUploadSetupCrashLogs;
                if (z25 != z26) {
                    customInfo2.mSyncUploadSetupCrashLogs = z26;
                    i11++;
                }
                boolean z27 = customInfo2.mSyncUploadLogs;
                boolean z28 = customInfo.mSyncUploadLogs;
                if (z27 != z28) {
                    customInfo2.mSyncUploadLogs = z28;
                    i11++;
                }
                int i26 = customInfo2.mMaxCustomLogFilesCount;
                int i27 = customInfo.mMaxCustomLogFilesCount;
                if (i26 != i27) {
                    customInfo2.mMaxCustomLogFilesCount = i27;
                    i11++;
                }
                boolean z29 = customInfo2.mOmitJavaCrash;
                boolean z30 = customInfo.mOmitJavaCrash;
                if (z29 != z30) {
                    customInfo2.mOmitJavaCrash = z30;
                    i11++;
                }
                int i28 = customInfo2.mLogMaxUploadBytesLimit;
                int i29 = customInfo.mLogMaxUploadBytesLimit;
                if (i28 != i29) {
                    customInfo2.mLogMaxUploadBytesLimit = i29;
                    i11++;
                }
                long j10 = customInfo2.mMaxUploadBytesPerDay;
                long j11 = customInfo.mMaxUploadBytesPerDay;
                if (j10 != j11) {
                    customInfo2.mMaxUploadBytesPerDay = j11;
                    i11++;
                }
                int i30 = customInfo2.mMaxUploadBuiltinLogCountPerDay;
                int i31 = customInfo.mMaxUploadBuiltinLogCountPerDay;
                if (i30 != i31) {
                    customInfo2.mMaxUploadBuiltinLogCountPerDay = i31;
                    i11++;
                }
                int i32 = customInfo2.mMaxUploadCustomLogCountPerDay;
                int i33 = customInfo.mMaxUploadCustomLogCountPerDay;
                if (i32 != i33) {
                    customInfo2.mMaxUploadCustomLogCountPerDay = i33;
                    i11++;
                }
                int i34 = customInfo2.mMaxCustomLogCountPerTypePerDay;
                int i35 = customInfo.mMaxCustomLogCountPerTypePerDay;
                if (i34 != i35) {
                    customInfo2.mMaxCustomLogCountPerTypePerDay = i35;
                    i11++;
                }
                int i36 = customInfo2.mMaxAnrLogCountPerProcess;
                int i37 = customInfo.mMaxAnrLogCountPerProcess;
                if (i36 != i37) {
                    customInfo2.mMaxAnrLogCountPerProcess = i37;
                    if (b.f13531d) {
                        JNIBridge.set(32, (long) f13615d.mMaxAnrLogCountPerProcess);
                    }
                    i11++;
                }
                boolean z31 = customInfo2.mCallJavaDefaultHandler;
                boolean z32 = customInfo.mCallJavaDefaultHandler;
                if (z31 != z32) {
                    customInfo2.mCallJavaDefaultHandler = z32;
                    i11++;
                }
                boolean z33 = customInfo2.mEnableKillProcessAfterCrash;
                boolean z34 = customInfo.mEnableKillProcessAfterCrash;
                if (z33 != z34) {
                    customInfo2.mEnableKillProcessAfterCrash = z34;
                    i11++;
                }
                boolean z35 = customInfo2.mCallNativeDefaultHandler;
                boolean z36 = customInfo.mCallNativeDefaultHandler;
                if (z35 != z36) {
                    customInfo2.mCallNativeDefaultHandler = z36;
                    i11++;
                    if (b.f13531d) {
                        JNIBridge.set(5, f13615d.mCallNativeDefaultHandler);
                    }
                }
                boolean z37 = customInfo2.mDumpUserSolibBuildId;
                boolean z38 = customInfo.mDumpUserSolibBuildId;
                if (z37 != z38) {
                    customInfo2.mDumpUserSolibBuildId = z38;
                    i11++;
                    if (b.f13531d) {
                        JNIBridge.set(6, f13615d.mDumpUserSolibBuildId);
                    }
                }
                boolean z39 = customInfo2.mDumpHprofDataForJavaOOM;
                boolean z40 = customInfo.mDumpHprofDataForJavaOOM;
                if (z39 != z40) {
                    customInfo2.mDumpHprofDataForJavaOOM = z40;
                    i11++;
                }
                boolean z41 = customInfo2.mRenameFileToDefaultName;
                boolean z42 = customInfo.mRenameFileToDefaultName;
                if (z41 != z42) {
                    customInfo2.mRenameFileToDefaultName = z42;
                    i11++;
                }
                boolean z43 = customInfo2.mAutoDeleteOldVersionStats;
                boolean z44 = customInfo.mAutoDeleteOldVersionStats;
                if (z43 != z44) {
                    customInfo2.mAutoDeleteOldVersionStats = z44;
                    i11++;
                }
                int i38 = customInfo2.mFdDumpMinLimit;
                int i39 = customInfo.mFdDumpMinLimit;
                if (i38 != i39) {
                    customInfo2.mFdDumpMinLimit = i39;
                    if (b.f13531d) {
                        JNIBridge.set(10, (long) i39);
                    }
                    i11++;
                }
                int i40 = customInfo2.mThreadsDumpMinLimit;
                int i41 = customInfo.mThreadsDumpMinLimit;
                if (i40 != i41) {
                    customInfo2.mThreadsDumpMinLimit = i41;
                    if (b.f13531d) {
                        JNIBridge.set(22, (long) i41);
                    }
                    i11++;
                }
                int i42 = customInfo2.mInfoUpdateInterval;
                int i43 = customInfo.mInfoUpdateInterval;
                if (i42 != i43) {
                    if (i42 <= 0 && i43 > 0) {
                        a.a(false);
                    }
                    customInfo2.mInfoUpdateInterval = customInfo.mInfoUpdateInterval;
                    i11++;
                }
                int i44 = customInfo2.mInfoSaveFrequency;
                int i45 = customInfo.mInfoSaveFrequency;
                if (i44 != i45) {
                    customInfo2.mInfoSaveFrequency = i45;
                    i11++;
                }
                long j12 = customInfo2.mDisableBackgroundSignals;
                long j13 = customInfo.mDisableBackgroundSignals;
                if (j12 != j13) {
                    customInfo2.mDisableBackgroundSignals = j13;
                    if (b.f13531d) {
                        JNIBridge.set(9, j13);
                    }
                    i11++;
                }
                boolean z45 = customInfo2.mEnableStatReport;
                boolean z46 = customInfo.mEnableStatReport;
                if (z45 != z46) {
                    customInfo2.mEnableStatReport = z46;
                    if (z46) {
                        e.B();
                    }
                    i11++;
                }
                boolean z47 = customInfo2.mEnableCrpStat;
                boolean z48 = customInfo.mEnableCrpStat;
                if (z47 != z48) {
                    customInfo2.mEnableCrpStat = z48;
                    i11++;
                }
                boolean z49 = customInfo2.mEnableStatToWPKDirect;
                boolean z50 = customInfo.mEnableStatToWPKDirect;
                if (z49 != z50) {
                    customInfo2.mEnableStatToWPKDirect = z50;
                    i11++;
                }
                boolean z51 = customInfo2.mIsInternational;
                boolean z52 = customInfo.mIsInternational;
                if (z51 != z52) {
                    customInfo2.mIsInternational = z52;
                    if (b.f13531d) {
                        JNIBridge.set(23, z52);
                    }
                    e.l();
                    d.c();
                    h.k();
                    i11++;
                }
                boolean z53 = customInfo2.mAutoDetectLifeCycle;
                boolean z54 = customInfo.mAutoDetectLifeCycle;
                if (z53 != z54) {
                    customInfo2.mAutoDetectLifeCycle = z54;
                    if (z54) {
                        b.C();
                    }
                    i11++;
                }
                boolean z55 = customInfo2.mMonitorBattery;
                boolean z56 = customInfo.mMonitorBattery;
                if (z55 != z56) {
                    customInfo2.mMonitorBattery = z56;
                    e.c(b.B());
                    i11++;
                }
                int i46 = customInfo2.mUnexpSubTypes;
                int i47 = customInfo.mUnexpSubTypes;
                if (i46 != i47) {
                    customInfo2.mUnexpSubTypes = i47;
                    i11++;
                }
                boolean z57 = customInfo2.mEnableMemoryGroup;
                boolean z58 = customInfo.mEnableMemoryGroup;
                if (z57 != z58) {
                    customInfo2.mEnableMemoryGroup = z58;
                    if (b.f13531d) {
                        JNIBridge.set(35, z58);
                    }
                    i11++;
                }
                boolean z59 = customInfo2.mEnableLibcMallocDetail;
                boolean z60 = customInfo.mEnableLibcMallocDetail;
                if (z59 != z60) {
                    customInfo2.mEnableLibcMallocDetail = z60;
                    if (b.f13531d) {
                        JNIBridge.set(36, z60);
                    }
                    i11++;
                }
                String str4 = customInfo2.mLibcMallocDetailConfig;
                String str5 = customInfo.mLibcMallocDetailConfig;
                if (str4 != str5) {
                    customInfo2.mLibcMallocDetailConfig = str5;
                    if (b.f13531d) {
                        JNIBridge.set(131, str5);
                    }
                    i11++;
                }
                if (!a(customInfo.mUserId, customInfo2.mUserId)) {
                    customInfo2.mUserId = customInfo.mUserId;
                    i11++;
                }
                if (!a(customInfo.mChannel, customInfo2.mChannel)) {
                    customInfo2.mChannel = customInfo.mChannel;
                    i11++;
                }
                if (!a(customInfo2.mCrashLogUploadUrl, customInfo.mCrashLogUploadUrl)) {
                    customInfo2.mCrashLogUploadUrl = customInfo.mCrashLogUploadUrl;
                    i11++;
                }
                if (!a(customInfo2.mCrashRateUploadUrl, customInfo.mCrashRateUploadUrl)) {
                    String str6 = customInfo.mCrashRateUploadUrl;
                    customInfo2.mCrashRateUploadUrl = str6;
                    i11++;
                    if (b.f13531d) {
                        JNIBridge.set(38, str6);
                    }
                }
                if (!a(customInfo2.mCrashSDKAuthUrl, customInfo.mCrashSDKAuthUrl)) {
                    String str7 = customInfo.mCrashSDKAuthUrl;
                    customInfo2.mCrashSDKAuthUrl = str7;
                    i11++;
                    if (b.f13531d) {
                        JNIBridge.set(39, str7);
                    }
                }
                i10 = i11;
            }
        }
        return i10;
    }

    public static CustomInfo a(CustomInfo customInfo, Bundle bundle) {
        if (customInfo == null) {
            CustomInfo customInfo2 = f13615d;
            if (customInfo2 == null) {
                customInfo = new CustomInfo();
            } else {
                customInfo = new CustomInfo(customInfo2);
            }
        }
        Field[] fields = customInfo.getClass().getFields();
        for (String str : bundle.keySet()) {
            for (Field field : fields) {
                if (field.getName().equals(str)) {
                    Object obj = bundle.get(str);
                    try {
                        field.set(customInfo, obj);
                    } catch (Exception e10) {
                        com.uc.crashsdk.a.g.a((Throwable) e10);
                        StringBuilder sb = new StringBuilder("Field ");
                        sb.append(str);
                        sb.append(" must be a ");
                        sb.append(field.getType().getName());
                        sb.append(", but give a ");
                        sb.append(obj != null ? obj.getClass().getName() : "(null)");
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            }
        }
        return customInfo;
    }

    public static VersionInfo a(Bundle bundle) {
        VersionInfo versionInfo;
        VersionInfo versionInfo2 = f13616e;
        if (versionInfo2 == null) {
            versionInfo = new VersionInfo();
        } else {
            versionInfo = new VersionInfo(versionInfo2);
        }
        String string = bundle.getString("mVersion");
        if (!com.uc.crashsdk.a.g.a(string)) {
            versionInfo.mVersion = string;
        }
        String string2 = bundle.getString("mSubVersion");
        if (!com.uc.crashsdk.a.g.a(string2)) {
            versionInfo.mSubVersion = string2;
        }
        String string3 = bundle.getString("mBuildId");
        if (!com.uc.crashsdk.a.g.a(string3)) {
            versionInfo.mBuildId = string3;
        }
        String string4 = bundle.getString("crver");
        if (!com.uc.crashsdk.a.g.a(string4)) {
            a.f13447b = string4;
            af();
        }
        return versionInfo;
    }

    private static boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }
}
