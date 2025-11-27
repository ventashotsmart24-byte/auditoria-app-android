package com.umeng.commonsdk.statistics.common;

import android.app.Activity;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.uc.crashsdk.export.LogType;
import com.umeng.analytics.pro.aa;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.idtracking.c;
import com.umeng.commonsdk.statistics.idtracking.i;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.b;
import com.umeng.commonsdk.utils.d;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import javax.microedition.khronos.opengles.GL10;

public class DeviceConfig {
    public static final int DEFAULT_TIMEZONE = 8;
    private static final String KEY_EMUI_VERSION_CODE = "ro.build.hw_emui_api_level";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    protected static final String LOG_TAG = "com.umeng.commonsdk.statistics.common.DeviceConfig";
    public static final String MOBILE_NETWORK = "2G/3G";
    public static final String UNKNOW = "";
    public static final String WIFI = "Wi-Fi";
    private static DeviceTypeEnum deviceTypeEnum = DeviceTypeEnum.DEFAULT;
    private static volatile boolean hasReadAndroidID = false;
    private static volatile boolean hasReadHonorOAID = false;
    private static volatile boolean hasReadIDFA = false;
    private static volatile boolean hasReadIMEI2 = false;
    private static volatile boolean hasReadImeiOrMeid = false;
    private static volatile boolean hasReadImsi = false;
    private static volatile boolean hasReadMac = false;
    private static volatile boolean hasReadOAID = false;
    private static volatile boolean hasReadOperator = false;
    private static volatile boolean hasReadOperatorName = false;
    private static volatile boolean hasReadSerialNo = false;
    private static volatile boolean hasReadSimSerialNumber = false;
    private static volatile String sAndroidID = "";
    private static volatile String sAppName = "";
    private static volatile String sAppPkgName = "";
    private static volatile String sCustomAgt = "";
    private static volatile String sHonorOAID = "";
    private static volatile String sIDFA = "";
    private static volatile String sImei = "";
    private static volatile String sImsi = "";
    private static volatile String sMeid = "";
    private static volatile String sOAID = "";
    private static volatile String sOperator = "";
    private static volatile String sOperatorName = "";
    private static volatile String sSecondImei = "";
    private static volatile String sSerialNo = "";
    private static volatile String sSimSerialNumber = "";
    private static volatile String sWifiMac = "";

    private static String byte2HexFormatted(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i10 = 0; i10 < bArr.length; i10++) {
            String hexString = Integer.toHexString(bArr[i10]);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0" + hexString;
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase(Locale.getDefault()));
            if (i10 < bArr.length - 1) {
                sb.append(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER);
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003c A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean checkPermission(android.content.Context r6, java.lang.String r7) {
        /*
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            r3 = 1
            if (r1 < r2) goto L_0x002e
            java.lang.String r1 = "android.content.Context"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x003d }
            java.lang.String r2 = "checkSelfPermission"
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x003d }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r0] = r5     // Catch:{ all -> 0x003d }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ all -> 0x003d }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ all -> 0x003d }
            r2[r0] = r7     // Catch:{ all -> 0x003d }
            java.lang.Object r6 = r1.invoke(r6, r2)     // Catch:{ all -> 0x003d }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x003d }
            int r6 = r6.intValue()     // Catch:{ all -> 0x003d }
            if (r6 != 0) goto L_0x003d
            goto L_0x003c
        L_0x002e:
            android.content.pm.PackageManager r1 = r6.getPackageManager()
            java.lang.String r6 = r6.getPackageName()
            int r6 = r1.checkPermission(r7, r6)
            if (r6 != 0) goto L_0x003d
        L_0x003c:
            r0 = 1
        L_0x003d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.checkPermission(android.content.Context, java.lang.String):boolean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:14|15|16|17|18|(1:20)|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        hasReadAndroidID = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
        throw r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0037 */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003b A[Catch:{ all -> 0x0043 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getAndroidId(android.content.Context r2) {
        /*
            boolean r0 = com.umeng.commonsdk.UMConfigure.shouldCollectAid()
            r1 = 0
            if (r0 != 0) goto L_0x000f
            java.lang.String r2 = "MobclickRT"
            java.lang.String r0 = "disallow read aid."
            com.umeng.commonsdk.debug.UMRTLog.i(r2, r0)
            return r1
        L_0x000f:
            java.lang.String r0 = sAndroidID
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x001a
            java.lang.String r2 = sAndroidID
            return r2
        L_0x001a:
            boolean r0 = hasReadAndroidID
            if (r0 == 0) goto L_0x001f
            return r1
        L_0x001f:
            java.lang.String r0 = "header_device_id_android_id"
            boolean r0 = com.umeng.commonsdk.config.FieldManager.allow(r0)
            if (r0 == 0) goto L_0x0047
            if (r2 == 0) goto L_0x0047
            r0 = 1
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x0037 }
            java.lang.String r1 = "android_id"
            java.lang.String r2 = android.provider.Settings.Secure.getString(r2, r1)     // Catch:{ all -> 0x0037 }
            sAndroidID = r2     // Catch:{ all -> 0x0037 }
            goto L_0x0040
        L_0x0037:
            boolean r2 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x0040
            java.lang.String r2 = "can't read android id"
            com.umeng.commonsdk.statistics.common.MLog.w((java.lang.String) r2)     // Catch:{ all -> 0x0043 }
        L_0x0040:
            hasReadAndroidID = r0
            goto L_0x0047
        L_0x0043:
            r2 = move-exception
            hasReadAndroidID = r0
            throw r2
        L_0x0047:
            java.lang.String r2 = sAndroidID
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.getAndroidId(android.content.Context):java.lang.String");
    }

    public static String getAppHashKey(Context context) {
        try {
            PackageInfo a10 = b.a().a(context, getPackageName(context), 64);
            if (a10 == null) {
                return null;
            }
            Signature[] signatureArr = a10.signatures;
            if (signatureArr.length <= 0) {
                return null;
            }
            Signature signature = signatureArr[0];
            MessageDigest instance = MessageDigest.getInstance("SHA");
            instance.update(signature.toByteArray());
            return Base64.encodeToString(instance.digest(), 0).trim();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getAppMD5Signature(Context context) {
        if (context == null) {
            return null;
        }
        try {
            PackageInfo a10 = b.a().a(context, getPackageName(context), 64);
            if (a10 == null) {
                return null;
            }
            return byte2HexFormatted(MessageDigest.getInstance("MD5").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(a10.signatures[0].toByteArray()))).getEncoded()));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getAppName(Context context) {
        if (!TextUtils.isEmpty(sAppName)) {
            return sAppName;
        }
        if (context == null) {
            return null;
        }
        try {
            PackageInfo a10 = b.a().a(context, context.getPackageName(), 64);
            if (a10 != null) {
                sAppName = a10.applicationInfo.loadLabel(context.getPackageManager()).toString();
            }
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.i(LOG_TAG, th);
            }
        }
        return sAppName;
    }

    public static String getAppSHA1Key(Context context) {
        try {
            PackageInfo a10 = b.a().a(context, getPackageName(context), 64);
            if (a10 == null) {
                return null;
            }
            return byte2HexFormatted(MessageDigest.getInstance("SHA1").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(a10.signatures[0].toByteArray()))).getEncoded()));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getAppVersionCode(Context context) {
        return UMUtils.getAppVersionCode(context);
    }

    public static String getAppVersionName(Context context) {
        return UMUtils.getAppVersionName(context);
    }

    public static String getApplicationLable(Context context) {
        if (context == null) {
            return "";
        }
        return context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0023 A[Catch:{ all -> 0x001d, all -> 0x0026 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Properties getBuildProp() {
        /*
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0020 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0020 }
            java.io.File r4 = android.os.Environment.getRootDirectory()     // Catch:{ all -> 0x0020 }
            java.lang.String r5 = "build.prop"
            r3.<init>(r4, r5)     // Catch:{ all -> 0x0020 }
            r2.<init>(r3)     // Catch:{ all -> 0x0020 }
            r0.load(r2)     // Catch:{ all -> 0x001d }
            r2.close()     // Catch:{ all -> 0x0026 }
            goto L_0x0026
        L_0x001d:
            r1 = r2
            goto L_0x0021
        L_0x0020:
        L_0x0021:
            if (r1 == 0) goto L_0x0026
            r1.close()     // Catch:{ all -> 0x0026 }
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.getBuildProp():java.util.Properties");
    }

    public static String getCPU() {
        String str = null;
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
                str = bufferedReader.readLine();
                bufferedReader.close();
                fileReader.close();
            } catch (Throwable th) {
                MLog.e(LOG_TAG, "Could not read from file /proc/cpuinfo", th);
            }
        } catch (FileNotFoundException e10) {
            MLog.e(LOG_TAG, "Could not open file /proc/cpuinfo", (Throwable) e10);
        }
        if (str != null) {
            return str.substring(str.indexOf(58) + 1).trim();
        }
        return "";
    }

    public static String getCustomAgt() {
        if (!TextUtils.isEmpty(sCustomAgt)) {
            return sCustomAgt;
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append("Dalvik/");
        sb.append(System.getProperty("java.vm.version"));
        sb.append(" (Linux; U; Android ");
        sb.append(")");
        sCustomAgt = sb.toString();
        return sCustomAgt;
    }

    public static String getDBencryptID(Context context) {
        return UMUtils.genId();
    }

    public static String getDeviceId(Context context) {
        if (AnalyticsConstants.getDeviceType() == 2) {
            return getDeviceIdForBox(context);
        }
        return getDeviceIdForGeneral(context);
    }

    public static String getDeviceIdForBox(Context context) {
        String str = "";
        if (context == null) {
            return str;
        }
        try {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 < 23) {
                if (FieldManager.allow(d.f15128i)) {
                    str = getAndroidId(context);
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str2 = LOG_TAG;
                        MLog.i(str2, "getDeviceId, ANDROID_ID: " + str);
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
                String macBySystemInterface = getMacBySystemInterface(context);
                deviceTypeEnum = DeviceTypeEnum.MAC;
                if (AnalyticsConstants.UM_DEBUG) {
                    String str3 = LOG_TAG;
                    MLog.i(str3, "getDeviceId, MAC: " + macBySystemInterface);
                }
                if (!TextUtils.isEmpty(macBySystemInterface)) {
                    return macBySystemInterface;
                }
                String serialNo = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                if (!TextUtils.isEmpty(serialNo)) {
                    return serialNo;
                }
                String imei = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                return imei;
            } else if (i10 == 23) {
                if (FieldManager.allow(d.f15128i)) {
                    str = getAndroidId(context);
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str4 = LOG_TAG;
                        MLog.i(str4, "getDeviceId, ANDROID_ID: " + str);
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
                String macByJavaAPI = getMacByJavaAPI();
                DeviceTypeEnum deviceTypeEnum2 = DeviceTypeEnum.MAC;
                deviceTypeEnum = deviceTypeEnum2;
                if (TextUtils.isEmpty(macByJavaAPI)) {
                    if (AnalyticsConstants.CHECK_DEVICE) {
                        macByJavaAPI = getMacShell();
                        deviceTypeEnum = deviceTypeEnum2;
                    } else {
                        macByJavaAPI = getMacBySystemInterface(context);
                        deviceTypeEnum = deviceTypeEnum2;
                    }
                }
                if (AnalyticsConstants.UM_DEBUG) {
                    String str5 = LOG_TAG;
                    MLog.i(str5, "getDeviceId, MAC: " + macByJavaAPI);
                }
                if (!TextUtils.isEmpty(macByJavaAPI)) {
                    return macByJavaAPI;
                }
                String serialNo2 = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                if (!TextUtils.isEmpty(serialNo2)) {
                    return serialNo2;
                }
                String imei2 = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                return imei2;
            } else if (i10 >= 29) {
                String oaid = getOaid(context);
                deviceTypeEnum = DeviceTypeEnum.OAID;
                if (!TextUtils.isEmpty(oaid)) {
                    return oaid;
                }
                String idfa = getIdfa(context);
                deviceTypeEnum = DeviceTypeEnum.IDFA;
                if (!TextUtils.isEmpty(idfa)) {
                    return idfa;
                }
                String androidId = getAndroidId(context);
                deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                if (!TextUtils.isEmpty(androidId)) {
                    return androidId;
                }
                String serialNo3 = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                if (!TextUtils.isEmpty(serialNo3)) {
                    return serialNo3;
                }
                String macByJavaAPI2 = getMacByJavaAPI();
                DeviceTypeEnum deviceTypeEnum3 = DeviceTypeEnum.MAC;
                deviceTypeEnum = deviceTypeEnum3;
                if (!TextUtils.isEmpty(macByJavaAPI2)) {
                    return macByJavaAPI2;
                }
                String macBySystemInterface2 = getMacBySystemInterface(context);
                deviceTypeEnum = deviceTypeEnum3;
                return macBySystemInterface2;
            } else {
                if (FieldManager.allow(d.f15128i)) {
                    str = getAndroidId(context);
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str6 = LOG_TAG;
                        MLog.i(str6, "getDeviceId: ANDROID_ID: " + str);
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
                String serialNo4 = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                if (!TextUtils.isEmpty(serialNo4)) {
                    return serialNo4;
                }
                String imei3 = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                if (!TextUtils.isEmpty(imei3)) {
                    return imei3;
                }
                String macByJavaAPI3 = getMacByJavaAPI();
                DeviceTypeEnum deviceTypeEnum4 = DeviceTypeEnum.MAC;
                deviceTypeEnum = deviceTypeEnum4;
                if (!TextUtils.isEmpty(macByJavaAPI3)) {
                    return macByJavaAPI3;
                }
                String macBySystemInterface3 = getMacBySystemInterface(context);
                deviceTypeEnum = deviceTypeEnum4;
                if (!AnalyticsConstants.UM_DEBUG) {
                    return macBySystemInterface3;
                }
                String str7 = LOG_TAG;
                MLog.i(str7, "getDeviceId, MAC: " + macBySystemInterface3);
                return macBySystemInterface3;
            }
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String getDeviceIdForGeneral(Context context) {
        if (context == null) {
            return "";
        }
        try {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 < 23) {
                String imei = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                if (!TextUtils.isEmpty(imei)) {
                    return imei;
                }
                boolean z10 = AnalyticsConstants.UM_DEBUG;
                if (z10) {
                    MLog.w(LOG_TAG, "No IMEI.");
                }
                String macBySystemInterface = getMacBySystemInterface(context);
                deviceTypeEnum = DeviceTypeEnum.MAC;
                if (!TextUtils.isEmpty(macBySystemInterface)) {
                    return macBySystemInterface;
                }
                if (FieldManager.allow(d.f15128i)) {
                    macBySystemInterface = getAndroidId(context);
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    if (z10) {
                        String str = LOG_TAG;
                        MLog.i(str, "getDeviceId, ANDROID_ID: " + macBySystemInterface);
                    }
                }
                if (!TextUtils.isEmpty(macBySystemInterface)) {
                    return macBySystemInterface;
                }
                String serialNo = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                return serialNo;
            } else if (i10 == 23) {
                String imei2 = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                if (!TextUtils.isEmpty(imei2)) {
                    return imei2;
                }
                String macByJavaAPI = getMacByJavaAPI();
                DeviceTypeEnum deviceTypeEnum2 = DeviceTypeEnum.MAC;
                deviceTypeEnum = deviceTypeEnum2;
                if (TextUtils.isEmpty(macByJavaAPI)) {
                    if (AnalyticsConstants.CHECK_DEVICE) {
                        macByJavaAPI = getMacShell();
                        deviceTypeEnum = deviceTypeEnum2;
                    } else {
                        macByJavaAPI = getMacBySystemInterface(context);
                        deviceTypeEnum = deviceTypeEnum2;
                    }
                }
                boolean z11 = AnalyticsConstants.UM_DEBUG;
                if (z11) {
                    String str2 = LOG_TAG;
                    MLog.i(str2, "getDeviceId, MAC: " + macByJavaAPI);
                }
                if (!TextUtils.isEmpty(macByJavaAPI)) {
                    return macByJavaAPI;
                }
                if (FieldManager.allow(d.f15128i)) {
                    macByJavaAPI = getAndroidId(context);
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    if (z11) {
                        String str3 = LOG_TAG;
                        MLog.i(str3, "getDeviceId, ANDROID_ID: " + macByJavaAPI);
                    }
                }
                if (!TextUtils.isEmpty(macByJavaAPI)) {
                    return macByJavaAPI;
                }
                String serialNo2 = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                return serialNo2;
            } else if (i10 >= 29) {
                String oaid = getOaid(context);
                deviceTypeEnum = DeviceTypeEnum.OAID;
                if (!TextUtils.isEmpty(oaid)) {
                    return oaid;
                }
                String idfa = getIdfa(context);
                deviceTypeEnum = DeviceTypeEnum.IDFA;
                if (!TextUtils.isEmpty(idfa)) {
                    return idfa;
                }
                String androidId = getAndroidId(context);
                deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                if (!TextUtils.isEmpty(androidId)) {
                    return androidId;
                }
                String serialNo3 = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                if (!TextUtils.isEmpty(serialNo3)) {
                    return serialNo3;
                }
                String macByJavaAPI2 = getMacByJavaAPI();
                DeviceTypeEnum deviceTypeEnum3 = DeviceTypeEnum.MAC;
                deviceTypeEnum = deviceTypeEnum3;
                if (!TextUtils.isEmpty(macByJavaAPI2)) {
                    return macByJavaAPI2;
                }
                String macBySystemInterface2 = getMacBySystemInterface(context);
                deviceTypeEnum = deviceTypeEnum3;
                return macBySystemInterface2;
            } else {
                String imei3 = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                if (!TextUtils.isEmpty(imei3)) {
                    return imei3;
                }
                String serialNo4 = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                if (!TextUtils.isEmpty(serialNo4)) {
                    return serialNo4;
                }
                if (FieldManager.allow(d.f15128i)) {
                    serialNo4 = getAndroidId(context);
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str4 = LOG_TAG;
                        MLog.i(str4, "getDeviceId, ANDROID_ID: " + serialNo4);
                    }
                }
                if (!TextUtils.isEmpty(serialNo4)) {
                    return serialNo4;
                }
                String macByJavaAPI3 = getMacByJavaAPI();
                DeviceTypeEnum deviceTypeEnum4 = DeviceTypeEnum.MAC;
                deviceTypeEnum = deviceTypeEnum4;
                if (!TextUtils.isEmpty(macByJavaAPI3)) {
                    return macByJavaAPI3;
                }
                String macBySystemInterface3 = getMacBySystemInterface(context);
                deviceTypeEnum = deviceTypeEnum4;
                if (!AnalyticsConstants.UM_DEBUG) {
                    return macBySystemInterface3;
                }
                String str5 = LOG_TAG;
                MLog.i(str5, "getDeviceId, MAC: " + macBySystemInterface3);
                return macBySystemInterface3;
            }
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getDeviceIdType() {
        return deviceTypeEnum.getDeviceIdType();
    }

    public static String getDeviceIdUmengMD5(Context context) {
        return HelperUtils.getUmengMD5(getDeviceId(context));
    }

    public static String getDeviceType(Context context) {
        boolean z10;
        if (context == null) {
            return "Phone";
        }
        try {
            if ((context.getResources().getConfiguration().screenLayout & 15) >= 3) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                return "Tablet";
            }
            return "Phone";
        } catch (Throwable unused) {
            return "Phone";
        }
    }

    public static String getDisplayResolution(Context context) {
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                int i10 = displayMetrics.widthPixels;
                int i11 = displayMetrics.heightPixels;
                return String.valueOf(i11) + Operator.Operation.MULTIPLY + String.valueOf(i10);
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    private static String getEmuiVersion(Properties properties) {
        try {
            return properties.getProperty(KEY_EMUI_VERSION_CODE, (String) null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String getFlymeVersion(Properties properties) {
        try {
            String lowerCase = properties.getProperty("ro.build.display.id").toLowerCase(Locale.getDefault());
            if (lowerCase.contains("flyme os")) {
                return lowerCase.split(" ")[2];
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String[] getGPU(GL10 gl10) {
        try {
            return new String[]{gl10.glGetString(7936), gl10.glGetString(7937)};
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.e(LOG_TAG, "Could not read gpu infor:", th);
            }
            return new String[0];
        }
    }

    public static Activity getGlobleActivity(Context context) {
        Activity activity = null;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object next : ((Map) declaredField.get(invoke)).values()) {
                Class<?> cls2 = next.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(next)) {
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    activity = (Activity) declaredField3.get(next);
                }
            }
        } catch (Throwable unused) {
        }
        return activity;
    }

    public static String getHonorOaid(Context context) {
        if (!UMConfigure.shouldCollectOaid()) {
            return "";
        }
        if (!TextUtils.isEmpty(sHonorOAID)) {
            return sHonorOAID;
        }
        if (hasReadHonorOAID) {
            return "";
        }
        if (FieldManager.allow(d.G)) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(c.f14941a, 0);
                if (sharedPreferences != null) {
                    sHonorOAID = sharedPreferences.getString(c.f14942b, "");
                }
            } catch (Throwable unused) {
            }
            hasReadHonorOAID = true;
        }
        return sHonorOAID;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e A[Catch:{ all -> 0x0076 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getIMEI(android.content.Context r5) {
        /*
            boolean r0 = com.umeng.commonsdk.UMConfigure.shouldCollectImei()
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0010
            java.lang.String r5 = "MobclickRT"
            java.lang.String r0 = "disallow read IMEI."
            com.umeng.commonsdk.debug.UMRTLog.i(r5, r0)
            return r1
        L_0x0010:
            java.lang.String r0 = sImei
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x001b
            java.lang.String r5 = sImei
            return r5
        L_0x001b:
            boolean r0 = hasReadImeiOrMeid
            if (r0 == 0) goto L_0x0020
            return r1
        L_0x0020:
            java.lang.String r0 = "header_device_id_imei"
            boolean r0 = com.umeng.commonsdk.config.FieldManager.allow(r0)
            if (r0 == 0) goto L_0x007a
            if (r5 != 0) goto L_0x002b
            return r1
        L_0x002b:
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r5.getSystemService(r0)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            if (r0 == 0) goto L_0x007a
            r2 = 1
            java.lang.String r3 = "android.permission.READ_PHONE_STATE"
            boolean r5 = checkPermission(r5, r3)     // Catch:{ all -> 0x0069 }
            if (r5 == 0) goto L_0x0066
            java.lang.String r5 = r0.getDeviceId()     // Catch:{ all -> 0x0069 }
            boolean r0 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG     // Catch:{ all -> 0x0063 }
            if (r0 == 0) goto L_0x0061
            java.lang.String r0 = LOG_TAG     // Catch:{ all -> 0x0063 }
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0063 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0063 }
            r3.<init>()     // Catch:{ all -> 0x0063 }
            java.lang.String r4 = "getDeviceId, IMEI: "
            r3.append(r4)     // Catch:{ all -> 0x0063 }
            r3.append(r5)     // Catch:{ all -> 0x0063 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0063 }
            r4 = 0
            r1[r4] = r3     // Catch:{ all -> 0x0063 }
            com.umeng.commonsdk.statistics.common.MLog.i((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ all -> 0x0063 }
        L_0x0061:
            r1 = r5
            goto L_0x0066
        L_0x0063:
            r0 = move-exception
            r1 = r5
            goto L_0x006a
        L_0x0066:
            hasReadImeiOrMeid = r2
            goto L_0x007a
        L_0x0069:
            r0 = move-exception
        L_0x006a:
            boolean r5 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG     // Catch:{ all -> 0x0076 }
            if (r5 == 0) goto L_0x0066
            java.lang.String r5 = LOG_TAG     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = "No IMEI."
            com.umeng.commonsdk.statistics.common.MLog.w((java.lang.String) r5, (java.lang.String) r3, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0076 }
            goto L_0x0066
        L_0x0076:
            r5 = move-exception
            hasReadImeiOrMeid = r2
            throw r5
        L_0x007a:
            sImei = r1
            java.lang.String r5 = sImei
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.getIMEI(android.content.Context):java.lang.String");
    }

    public static String getIdfa(Context context) {
        if (!TextUtils.isEmpty(sIDFA)) {
            return sIDFA;
        }
        if (hasReadIDFA) {
            return "";
        }
        try {
            if (FieldManager.allow(d.f15142w)) {
                sIDFA = a.a(context);
            }
        } catch (Throwable unused) {
        }
        hasReadIDFA = true;
        return sIDFA;
    }

    public static String getImei(Context context) {
        TelephonyManager telephonyManager;
        String str = null;
        if (!UMConfigure.shouldCollectImei()) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "disallow read IMEI.");
            return null;
        } else if (!TextUtils.isEmpty(sImei)) {
            return sImei;
        } else {
            if (hasReadImeiOrMeid) {
                return null;
            }
            try {
                if (FieldManager.allow(d.f15126g) && context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null && checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                    str = telephonyManager.getDeviceId();
                }
            } catch (Throwable th) {
                hasReadImeiOrMeid = true;
                throw th;
            }
            hasReadImeiOrMeid = true;
            sImei = str;
            return str;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:23|24|25|26|27|(1:29)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x005b */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0061 A[Catch:{ all -> 0x006d, all -> 0x007b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getImeiNew(android.content.Context r6) {
        /*
            boolean r0 = com.umeng.commonsdk.UMConfigure.shouldCollectImei()
            r1 = 0
            if (r0 != 0) goto L_0x000f
            java.lang.String r6 = "MobclickRT"
            java.lang.String r0 = "disallow read IMEI."
            com.umeng.commonsdk.debug.UMRTLog.i(r6, r0)
            return r1
        L_0x000f:
            java.lang.String r0 = sImei
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x001a
            java.lang.String r6 = sImei
            return r6
        L_0x001a:
            boolean r0 = hasReadImeiOrMeid
            if (r0 == 0) goto L_0x001f
            return r1
        L_0x001f:
            r0 = 1
            java.lang.String r2 = "header_device_id_imei"
            boolean r2 = com.umeng.commonsdk.config.FieldManager.allow(r2)     // Catch:{ all -> 0x006d }
            if (r2 == 0) goto L_0x006a
            if (r6 == 0) goto L_0x006a
            java.lang.String r2 = "phone"
            java.lang.Object r2 = r6.getSystemService(r2)     // Catch:{ all -> 0x006d }
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2     // Catch:{ all -> 0x006d }
            if (r2 == 0) goto L_0x006a
            java.lang.String r3 = "android.permission.READ_PHONE_STATE"
            boolean r6 = checkPermission(r6, r3)     // Catch:{ all -> 0x006d }
            if (r6 == 0) goto L_0x006a
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x006d }
            r3 = 26
            if (r6 < r3) goto L_0x0066
            java.lang.Class r6 = r2.getClass()     // Catch:{ all -> 0x005b }
            java.lang.String r3 = "getImei"
            r4 = 0
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ all -> 0x005b }
            java.lang.reflect.Method r6 = r6.getMethod(r3, r5)     // Catch:{ all -> 0x005b }
            r6.setAccessible(r0)     // Catch:{ all -> 0x005b }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ all -> 0x005b }
            java.lang.Object r6 = r6.invoke(r2, r3)     // Catch:{ all -> 0x005b }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x005b }
            r1 = r6
        L_0x005b:
            boolean r6 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x006d }
            if (r6 == 0) goto L_0x006a
            java.lang.String r1 = r2.getDeviceId()     // Catch:{ all -> 0x006d }
            goto L_0x006a
        L_0x0066:
            java.lang.String r1 = r2.getDeviceId()     // Catch:{ all -> 0x006d }
        L_0x006a:
            hasReadImeiOrMeid = r0
            goto L_0x0078
        L_0x006d:
            r6 = move-exception
            boolean r2 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG     // Catch:{ all -> 0x007b }
            if (r2 == 0) goto L_0x006a
            java.lang.String r2 = "No IMEI."
            com.umeng.commonsdk.statistics.common.MLog.w((java.lang.String) r2, (java.lang.Throwable) r6)     // Catch:{ all -> 0x007b }
            goto L_0x006a
        L_0x0078:
            sImei = r1
            return r1
        L_0x007b:
            r6 = move-exception
            hasReadImeiOrMeid = r0
            goto L_0x0080
        L_0x007f:
            throw r6
        L_0x0080:
            goto L_0x007f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.getImeiNew(android.content.Context):java.lang.String");
    }

    public static String getImsi(Context context) {
        String str = null;
        if (!UMConfigure.shouldCollectImsi()) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "disallow read IMSI.");
            return null;
        } else if (!TextUtils.isEmpty(sImsi)) {
            return sImsi;
        } else {
            if (hasReadImsi || context == null) {
                return null;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (FieldManager.allow(d.al)) {
                try {
                    if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                        str = telephonyManager.getSubscriberId();
                    }
                } catch (Throwable unused) {
                }
                hasReadImsi = true;
            }
            sImsi = str;
            return sImsi;
        }
    }

    private static Locale getLocale(Context context) {
        Locale locale;
        if (context == null) {
            return Locale.getDefault();
        }
        try {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            Settings.System.getConfiguration(context.getContentResolver(), configuration);
            locale = configuration.locale;
        } catch (Throwable unused) {
            MLog.e(LOG_TAG, "fail to read user config locale");
            locale = null;
        }
        if (locale == null) {
            return Locale.getDefault();
        }
        return locale;
    }

    public static String[] getLocaleInfo(Context context) {
        String[] strArr = {"Unknown", "Unknown"};
        if (context == null) {
            return strArr;
        }
        try {
            Locale locale = getLocale(context);
            if (locale != null) {
                strArr[0] = locale.getCountry();
                strArr[1] = locale.getLanguage();
            }
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = "Unknown";
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = "Unknown";
            }
            return strArr;
        } catch (Throwable th) {
            MLog.e(LOG_TAG, "error in getLocaleInfo", th);
            return strArr;
        }
    }

    public static String getMCCMNC(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (getImsi(context) == null) {
                return null;
            }
            int i10 = context.getResources().getConfiguration().mcc;
            int i11 = context.getResources().getConfiguration().mnc;
            if (i10 != 0) {
                String valueOf = String.valueOf(i11);
                if (i11 < 10) {
                    valueOf = String.format("%02d", new Object[]{Integer.valueOf(i11)});
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(String.valueOf(i10));
                stringBuffer.append(valueOf);
                return stringBuffer.toString();
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    public static String getMac(Context context) {
        return "";
    }

    private static String getMacByJavaAPI() {
        return "";
    }

    private static String getMacBySystemInterface(Context context) {
        return "";
    }

    private static String getMacShell() {
        return "";
    }

    public static String getMeid(Context context) {
        if (context == null || ((TelephonyManager) context.getSystemService("phone")) == null || !FieldManager.allow(d.am)) {
            return null;
        }
        try {
            if (!checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                return null;
            }
            if (Build.VERSION.SDK_INT < 26) {
                return getIMEI(context);
            }
            String meid = meid(context);
            if (TextUtils.isEmpty(meid)) {
                return getIMEI(context);
            }
            return meid;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String[] getNetworkAccessMode(Context context) {
        String[] strArr = {"", ""};
        if (context == null) {
            return strArr;
        }
        try {
            if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                strArr[0] = "";
                return strArr;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                strArr[0] = "";
                return strArr;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo == null || networkInfo.getState() != NetworkInfo.State.CONNECTED) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                if (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
                    strArr[0] = "2G/3G";
                    strArr[1] = networkInfo2.getSubtypeName();
                }
                return strArr;
            }
            strArr[0] = "Wi-Fi";
            return strArr;
        } catch (Throwable unused) {
        }
    }

    public static String getNetworkOperatorName(Context context) {
        if (!TextUtils.isEmpty(sOperatorName)) {
            return sOperatorName;
        }
        if (hasReadOperatorName || context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                sOperatorName = telephonyManager.getNetworkOperatorName();
            }
        } catch (Throwable unused) {
        }
        hasReadOperatorName = true;
        return sOperatorName;
    }

    public static int getNetworkType(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                return telephonyManager.getNetworkType();
            }
            return 0;
        } catch (Exception unused) {
            return -100;
        }
    }

    public static String getNotificationStatus(Context context) {
        if (!FieldManager.allow(d.J)) {
            return "unknown";
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return Boolean.toString(((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled());
            } catch (Throwable unused) {
                return "unknown";
            }
        } else {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i10 = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class cls2 = Integer.TYPE;
                boolean z10 = false;
                if (((Integer) cls.getMethod("checkOpNoThrow", new Class[]{cls2, cls2, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(appOpsManager)).intValue()), Integer.valueOf(i10), packageName})).intValue() == 0) {
                    z10 = true;
                }
                return Boolean.toString(z10);
            } catch (Throwable unused2) {
                return "unknown";
            }
        }
    }

    public static String getOaid(Context context) {
        if (!UMConfigure.shouldCollectOaid()) {
            return "";
        }
        if (!TextUtils.isEmpty(sOAID)) {
            return sOAID;
        }
        if (hasReadOAID) {
            return "";
        }
        if (FieldManager.allow(d.G)) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(i.f14965a, 0);
                if (sharedPreferences != null) {
                    sOAID = sharedPreferences.getString(i.f14966b, "");
                }
            } catch (Throwable unused) {
            }
            hasReadOAID = true;
        }
        return sOAID;
    }

    public static String getPackageName(Context context) {
        if (!TextUtils.isEmpty(sAppPkgName)) {
            return sAppPkgName;
        }
        if (context == null) {
            return null;
        }
        sAppPkgName = context.getPackageName();
        return sAppPkgName;
    }

    public static int getRandNumber(int i10, int i11) {
        return new Random().nextInt((i11 - i10) + 1) + i10;
    }

    public static String getRegisteredOperator(Context context) {
        if (!TextUtils.isEmpty(sOperator)) {
            return sOperator;
        }
        if (hasReadOperator || context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                sOperator = telephonyManager.getNetworkOperator();
            }
        } catch (Throwable unused) {
        }
        hasReadOperator = true;
        return sOperator;
    }

    public static int[] getResolutionArray(Context context) {
        if (context == null) {
            return null;
        }
        int[] iArr = new int[2];
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            try {
                Method method = Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class});
                if (method != null) {
                    method.invoke(defaultDisplay, new Object[]{displayMetrics});
                    int i10 = displayMetrics.widthPixels;
                    int i11 = displayMetrics.heightPixels;
                    if (i10 > i11) {
                        iArr[0] = i11;
                        iArr[1] = i10;
                    } else {
                        iArr[0] = i10;
                        iArr[1] = i11;
                    }
                    iArr[0] = i10;
                    iArr[1] = i11;
                    return iArr;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static int getRingerMode(Context context) {
        if (!FieldManager.allow(d.K)) {
            return -1;
        }
        try {
            return ((AudioManager) context.getSystemService("audio")).getRingerMode();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String getSecondSimIMEi(Context context) {
        return null;
    }

    public static String getSerial() {
        return getSerialNo();
    }

    private static String getSerialNo() {
        return "";
    }

    public static String getSid(Context context) {
        return aa.a().d(context);
    }

    public static String getSimICCID(Context context) {
        if (!UMConfigure.shouldCollectIccid()) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "disallow read ICCID.");
            return null;
        } else if (!TextUtils.isEmpty(sSimSerialNumber)) {
            return sSimSerialNumber;
        } else {
            if (hasReadSimSerialNumber) {
                return null;
            }
            if (FieldManager.allow(d.ap)) {
                if (context != null) {
                    try {
                        if (UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                            if (telephonyManager == null) {
                                hasReadSimSerialNumber = true;
                                return null;
                            }
                            sSimSerialNumber = telephonyManager.getSimSerialNumber();
                        }
                    } catch (Throwable unused) {
                    }
                }
                hasReadSimSerialNumber = true;
            }
            return sSimSerialNumber;
        }
    }

    public static String getSubOSName(Context context) {
        Properties buildProp = getBuildProp();
        try {
            String property = buildProp.getProperty(KEY_MIUI_VERSION_NAME);
            if (!TextUtils.isEmpty(property)) {
                return "MIUI";
            }
            if (isFlyMe()) {
                return "Flyme";
            }
            if (isEmui(buildProp)) {
                return "Emui";
            }
            if (!TextUtils.isEmpty(getYunOSVersion(buildProp))) {
                return "YunOS";
            }
            return property;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getSubOSVersion(Context context) {
        Properties buildProp = getBuildProp();
        try {
            String property = buildProp.getProperty(KEY_MIUI_VERSION_NAME);
            if (!TextUtils.isEmpty(property)) {
                return property;
            }
            if (isFlyMe()) {
                try {
                    return getFlymeVersion(buildProp);
                } catch (Throwable unused) {
                    return property;
                }
            } else if (isEmui(buildProp)) {
                return getEmuiVersion(buildProp);
            } else {
                return getYunOSVersion(buildProp);
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static int getTimeZone(Context context) {
        if (context == null) {
            return 8;
        }
        try {
            Calendar instance = Calendar.getInstance(getLocale(context));
            if (instance != null) {
                return instance.getTimeZone().getRawOffset() / 3600000;
            }
        } catch (Throwable th) {
            MLog.i(LOG_TAG, "error in getTimeZone", th);
        }
        return 8;
    }

    private static String getYunOSVersion(Properties properties) {
        try {
            String property = properties.getProperty("ro.yunos.version");
            if (!TextUtils.isEmpty(property)) {
                return property;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean hasOpsPermission(Context context) {
        if (!FieldManager.allow(d.av)) {
            return false;
        }
        try {
            if (((AppOpsManager) context.getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), getPackageName(context)) == 0) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean hasRequestPermission(Context context, String str) {
        if (!FieldManager.allow(d.av)) {
            return false;
        }
        try {
            for (String equalsIgnoreCase : context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions) {
                if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x005e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isChineseAera(android.content.Context r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "country"
            java.lang.String r2 = ""
            java.lang.String r1 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(r5, r1, r2)     // Catch:{ all -> 0x005e }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x005e }
            java.lang.String r3 = "cn"
            r4 = 1
            if (r2 != 0) goto L_0x001d
            boolean r5 = r1.equals(r3)     // Catch:{ all -> 0x005e }
            if (r5 == 0) goto L_0x001c
            return r4
        L_0x001c:
            return r0
        L_0x001d:
            java.lang.String r1 = getImsi(r5)     // Catch:{ all -> 0x005e }
            if (r1 != 0) goto L_0x0036
            java.lang.String[] r5 = getLocaleInfo(r5)     // Catch:{ all -> 0x005e }
            r5 = r5[r0]     // Catch:{ all -> 0x005e }
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x005e }
            if (r1 != 0) goto L_0x005e
            boolean r5 = r5.equalsIgnoreCase(r3)     // Catch:{ all -> 0x005e }
            if (r5 == 0) goto L_0x005e
            return r4
        L_0x0036:
            android.content.res.Resources r1 = r5.getResources()     // Catch:{ all -> 0x005e }
            android.content.res.Configuration r1 = r1.getConfiguration()     // Catch:{ all -> 0x005e }
            int r1 = r1.mcc     // Catch:{ all -> 0x005e }
            r2 = 460(0x1cc, float:6.45E-43)
            if (r1 == r2) goto L_0x005d
            r2 = 461(0x1cd, float:6.46E-43)
            if (r1 != r2) goto L_0x0049
            goto L_0x005d
        L_0x0049:
            if (r1 != 0) goto L_0x005e
            java.lang.String[] r5 = getLocaleInfo(r5)     // Catch:{ all -> 0x005e }
            r5 = r5[r0]     // Catch:{ all -> 0x005e }
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x005e }
            if (r1 != 0) goto L_0x005e
            boolean r5 = r5.equalsIgnoreCase(r3)     // Catch:{ all -> 0x005e }
            if (r5 == 0) goto L_0x005e
        L_0x005d:
            return r4
        L_0x005e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.isChineseAera(android.content.Context):boolean");
    }

    private static boolean isEmui(Properties properties) {
        try {
            if (properties.getProperty(KEY_EMUI_VERSION_CODE, (String) null) != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }

    private static boolean isFlyMe() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isHarmony(Context context) {
        try {
            return context.getString(Resources.getSystem().getIdentifier("config_os_brand", "string", "android")).equals("harmony");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isHonorDevice() {
        return Build.MANUFACTURER.equalsIgnoreCase("HONOR");
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        try {
            if (!(!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null)) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean isSystemApp(Context context) {
        if (!FieldManager.allow(d.au)) {
            return false;
        }
        try {
            PackageInfo a10 = b.a().a(context, getPackageName(context), LogType.ANR);
            if (a10 == null || (a10.applicationInfo.flags & 1) == 0) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isWiFiAvailable(Context context) {
        if (context == null) {
            return false;
        }
        return "Wi-Fi".equals(getNetworkAccessMode(context)[0]);
    }

    private static String meid(Context context) {
        if (!TextUtils.isEmpty(sMeid)) {
            return sMeid;
        }
        String str = null;
        if (hasReadImeiOrMeid || context == null) {
            return null;
        }
        try {
            Object invoke = Class.forName("android.telephony.TelephonyManager").getMethod("getMeid", new Class[0]).invoke((Object) null, new Object[0]);
            if (invoke != null && (invoke instanceof String)) {
                str = (String) invoke;
            }
        } catch (Throwable th) {
            hasReadImeiOrMeid = true;
            throw th;
        }
        hasReadImeiOrMeid = true;
        sMeid = str;
        return sMeid;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:1|2|3|4|5|6|7|8|9|10) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:11|(2:14|15)|(2:18|19)|20|21) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0026 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0014 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0023 A[SYNTHETIC, Splitter:B:18:0x0023] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:9:0x0014=Splitter:B:9:0x0014, B:20:0x0026=Splitter:B:20:0x0026} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String reaMac(java.lang.String r3) {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ all -> 0x0027 }
            r1.<init>(r3)     // Catch:{ all -> 0x0027 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x001a }
            r2 = 1024(0x400, float:1.435E-42)
            r3.<init>(r1, r2)     // Catch:{ all -> 0x001a }
            java.lang.String r0 = r3.readLine()     // Catch:{ all -> 0x0018 }
            r1.close()     // Catch:{ all -> 0x0014 }
        L_0x0014:
            r3.close()     // Catch:{ all -> 0x0027 }
            goto L_0x0027
        L_0x0018:
            r2 = move-exception
            goto L_0x001c
        L_0x001a:
            r2 = move-exception
            r3 = r0
        L_0x001c:
            r1.close()     // Catch:{ all -> 0x0020 }
            goto L_0x0021
        L_0x0020:
        L_0x0021:
            if (r3 == 0) goto L_0x0026
            r3.close()     // Catch:{ all -> 0x0026 }
        L_0x0026:
            throw r2     // Catch:{ all -> 0x0027 }
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.reaMac(java.lang.String):java.lang.String");
    }

    private static int reflectMetrics(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Throwable unused) {
            return -1;
        }
    }
}
