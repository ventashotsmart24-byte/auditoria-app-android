package com.umeng.commonsdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.sdk.source.mdns.xbill.dns.Type;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.analytics.c;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.a;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.i;
import com.umeng.message.PushAgent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONObject;

public class UMUtils {
    public static final int DEFAULT_TIMEZONE = 8;
    private static final String KEY_APP_KEY = "appkey";
    private static final String KEY_CHANNEL = "channel";
    private static final String KEY_LAST_APP_KEY = "last_appkey";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String KEY_SESSION_ID = "session_id";
    private static final String KEY_SHARED_PREFERENCES_NAME = bd.b().b(bd.f13849i);
    public static final String MOBILE_NETWORK = "2G/3G";
    private static final String SD_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final String SP_FILE_NAME = bd.b().b(bd.f13851k);
    private static final String TAG = "UMUtils";
    public static final String UNKNOW = "";
    public static String VALUE_ABTEST_VERSION = "";
    public static String VALUE_ANALYTICS_VERSION = "";
    public static String VALUE_ANTI_VERSION = "";
    public static String VALUE_APM_VERSION = "";
    public static String VALUE_ASMS_VERSION = "";
    public static String VALUE_GAME_VERSION = "";
    public static String VALUE_LINK_VERSION = "";
    public static String VALUE_PUSH_VERSION = "";
    public static String VALUE_REC_VERSION_NAME = "";
    public static String VALUE_SHARE_VERSION = "";
    public static String VALUE_SMS_VERSION = "";
    public static String VALUE_VERIFY_VERSION = "";
    public static String VALUE_VISUAL_VERSION = "";
    public static final String WIFI = "Wi-Fi";
    private static final Pattern pattern = Pattern.compile("UTDID\">([^<]+)");
    private static volatile String sAppVersionCode = "";
    private static volatile String sAppVersionName = "";
    private static Object spLock = new Object();

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0042, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        return r10.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004f, code lost:
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        android.util.Log.e(TAG, "MD5 e is " + r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0063, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0042 A[ExcHandler: all (r10v4 'th' java.lang.Object A[CUSTOM_DECLARE]), Splitter:B:3:0x0008] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String MD5(java.lang.String r10) {
        /*
            java.lang.String r0 = "MD5 e is "
            java.lang.String r1 = "UMUtils"
            r2 = 0
            if (r10 != 0) goto L_0x0008
            return r2
        L_0x0008:
            byte[] r3 = r10.getBytes()     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            java.lang.String r4 = "MD5"
            java.security.MessageDigest r4 = java.security.MessageDigest.getInstance(r4)     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            r4.reset()     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            r4.update(r3)     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            byte[] r3 = r4.digest()     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            r4.<init>()     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            r5 = 0
            r6 = 0
        L_0x0023:
            int r7 = r3.length     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            if (r6 >= r7) goto L_0x003d
            java.lang.String r7 = "%02X"
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            byte r9 = r3[r6]     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            java.lang.Byte r9 = java.lang.Byte.valueOf(r9)     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            r8[r5] = r9     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            java.lang.String r7 = java.lang.String.format(r7, r8)     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            r4.append(r7)     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            int r6 = r6 + 1
            goto L_0x0023
        L_0x003d:
            java.lang.String r10 = r4.toString()     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            return r10
        L_0x0042:
            r10 = move-exception
            goto L_0x004d
        L_0x0044:
            java.lang.String r3 = "[^[a-z][A-Z][0-9][.][_]]"
            java.lang.String r4 = ""
            java.lang.String r10 = r10.replaceAll(r3, r4)     // Catch:{ Exception -> 0x0064, all -> 0x0042 }
            return r10
        L_0x004d:
            boolean r3 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG
            if (r3 == 0) goto L_0x0063
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r10)
            java.lang.String r10 = r3.toString()
            android.util.Log.e(r1, r10)
        L_0x0063:
            return r2
        L_0x0064:
            r10 = move-exception
            boolean r3 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG
            if (r3 == 0) goto L_0x007b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r10)
            java.lang.String r10 = r3.toString()
            android.util.Log.e(r1, r10)
        L_0x007b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.MD5(java.lang.String):java.lang.String");
    }

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
            sb.append(hexString.toUpperCase());
            if (i10 < bArr.length - 1) {
                sb.append(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER);
            }
        }
        return sb.toString();
    }

    private static String bytes2Hex(byte[] bArr) {
        String str = "";
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & UnsignedBytes.MAX_VALUE);
            if (hexString.length() == 1) {
                str = str + "0";
            }
            str = str + hexString;
        }
        return str;
    }

    public static boolean checkAndroidManifest(Context context, String str) {
        try {
            context.getApplicationContext().getPackageManager().getActivityInfo(new ComponentName(context.getApplicationContext().getPackageName(), str), 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean checkIntentFilterData(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse("tencent" + str + SOAP.DELIM));
            List<ResolveInfo> queryIntentActivities = context.getApplicationContext().getPackageManager().queryIntentActivities(intent, 64);
            if (queryIntentActivities.size() > 0) {
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    if (activityInfo != null && activityInfo.packageName.equals(context.getApplicationContext().getPackageName())) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean checkMetaData(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationContext().getPackageManager().getApplicationInfo(context.getApplicationContext().getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData.get(str) == null) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static boolean checkPath(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0041 A[ORIG_RETURN, RETURN, SYNTHETIC] */
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
            if (r1 < r2) goto L_0x0033
            java.lang.String r1 = "android.content.Context"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x002e }
            java.lang.String r2 = "checkSelfPermission"
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x002e }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r0] = r5     // Catch:{ Exception -> 0x002e }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ Exception -> 0x002e }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x002e }
            r2[r0] = r7     // Catch:{ Exception -> 0x002e }
            java.lang.Object r7 = r1.invoke(r6, r2)     // Catch:{ Exception -> 0x002e }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ Exception -> 0x002e }
            int r6 = r7.intValue()     // Catch:{ Exception -> 0x002e }
            if (r6 != 0) goto L_0x0042
            goto L_0x0041
        L_0x002e:
            r7 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r7)
            goto L_0x0042
        L_0x0033:
            android.content.pm.PackageManager r1 = r6.getPackageManager()
            java.lang.String r6 = r6.getPackageName()
            int r6 = r1.checkPermission(r7, r6)
            if (r6 != 0) goto L_0x0042
        L_0x0041:
            r0 = 1
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.checkPermission(android.content.Context, java.lang.String):boolean");
    }

    public static boolean checkResource(Context context, String str, String str2) {
        try {
            if (context.getApplicationContext().getResources().getIdentifier(str, str2, context.getApplicationContext().getPackageName()) <= 0) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
        android.util.Log.e(TAG, "encrypt by SHA1 e is " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        android.util.Log.e(TAG, "encrypt by SHA1 e is " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001c A[ExcHandler: all (r4v3 'th' java.lang.Object A[CUSTOM_DECLARE]), Splitter:B:1:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String encryptBySHA1(java.lang.String r4) {
        /*
            java.lang.String r0 = "encrypt by SHA1 e is "
            java.lang.String r1 = "UMUtils"
            r2 = 0
            byte[] r4 = r4.getBytes()     // Catch:{ Exception -> 0x0034, all -> 0x001c }
            java.lang.String r3 = "SHA1"
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)     // Catch:{ Exception -> 0x001b, all -> 0x001c }
            r3.update(r4)     // Catch:{ Exception -> 0x001b, all -> 0x001c }
            byte[] r4 = r3.digest()     // Catch:{ Exception -> 0x001b, all -> 0x001c }
            java.lang.String r4 = bytes2Hex(r4)     // Catch:{ Exception -> 0x001b, all -> 0x001c }
            return r4
        L_0x001b:
            return r2
        L_0x001c:
            r4 = move-exception
            boolean r3 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG
            if (r3 == 0) goto L_0x0033
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r4)
            java.lang.String r4 = r3.toString()
            android.util.Log.e(r1, r4)
        L_0x0033:
            return r2
        L_0x0034:
            r4 = move-exception
            boolean r3 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG
            if (r3 == 0) goto L_0x004b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r4)
            java.lang.String r4 = r3.toString()
            android.util.Log.e(r1, r4)
        L_0x004b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.encryptBySHA1(java.lang.String):java.lang.String");
    }

    public static String genId() {
        return "1234567890";
    }

    public static byte[] genIv() {
        byte[] miniArray = getMiniArray();
        return new byte[]{10, 1, (byte) (10 + 1), 5, 4, (byte) (10 + 5), 7, 9, Ascii.ETB, 3, miniArray[0], miniArray[1], miniArray[2], miniArray[3], miniArray[4], (byte) (100 - 9)};
    }

    public static byte[] genSin() {
        byte[] miniArray = getMiniArray();
        return new byte[]{55, 69, (byte) (miniArray[4] + 54), 50, (byte) (55 + 57), 97, (byte) (69 + 43), 83, 57, 97, (byte) (97 + 2), 90, 120, (byte) (97 + miniArray[1]), (byte) (69 + miniArray[0] + 3), (byte) (90 + miniArray[2])};
    }

    public static byte[] genUmc() {
        byte[] bArr = new byte[Type.AXFR];
        // fill-array-data instruction
        bArr[0] = 31;
        bArr[1] = -117;
        bArr[2] = 8;
        bArr[3] = 0;
        bArr[4] = 0;
        bArr[5] = 0;
        bArr[6] = 0;
        bArr[7] = 0;
        bArr[8] = 0;
        bArr[9] = 0;
        bArr[10] = 1;
        bArr[11] = -27;
        bArr[12] = 0;
        bArr[13] = 26;
        bArr[14] = -1;
        bArr[15] = 76;
        bArr[16] = 102;
        bArr[17] = 34;
        bArr[18] = 19;
        bArr[19] = 78;
        bArr[20] = 70;
        bArr[21] = 23;
        bArr[22] = 58;
        bArr[23] = 85;
        bArr[24] = 26;
        bArr[25] = 6;
        bArr[26] = 56;
        bArr[27] = 16;
        bArr[28] = 68;
        bArr[29] = 36;
        bArr[30] = 2;
        bArr[31] = 73;
        bArr[32] = 32;
        bArr[33] = 52;
        bArr[34] = 79;
        bArr[35] = 16;
        bArr[36] = 90;
        bArr[37] = 37;
        bArr[38] = 43;
        bArr[39] = 79;
        bArr[40] = 12;
        bArr[41] = 28;
        bArr[42] = 57;
        bArr[43] = 16;
        bArr[44] = 88;
        bArr[45] = 123;
        bArr[46] = 95;
        bArr[47] = 100;
        bArr[48] = 70;
        bArr[49] = 91;
        bArr[50] = 51;
        bArr[51] = 51;
        bArr[52] = 33;
        bArr[53] = 34;
        bArr[54] = 39;
        bArr[55] = 104;
        bArr[56] = 59;
        bArr[57] = 61;
        bArr[58] = 20;
        bArr[59] = 57;
        bArr[60] = 25;
        bArr[61] = 2;
        bArr[62] = 63;
        bArr[63] = 113;
        bArr[64] = 29;
        bArr[65] = 18;
        bArr[66] = 100;
        bArr[67] = 102;
        bArr[68] = 120;
        bArr[69] = 100;
        bArr[70] = 5;
        bArr[71] = 35;
        bArr[72] = 98;
        bArr[73] = 123;
        bArr[74] = 0;
        bArr[75] = 39;
        bArr[76] = 57;
        bArr[77] = 24;
        bArr[78] = 40;
        bArr[79] = 25;
        bArr[80] = 112;
        bArr[81] = 35;
        bArr[82] = 93;
        bArr[83] = 22;
        bArr[84] = 73;
        bArr[85] = 20;
        bArr[86] = 46;
        bArr[87] = 83;
        bArr[88] = 73;
        bArr[89] = 71;
        bArr[90] = 117;
        bArr[91] = 70;
        bArr[92] = 69;
        bArr[93] = 110;
        bArr[94] = 73;
        bArr[95] = 73;
        bArr[96] = 117;
        bArr[97] = 114;
        bArr[98] = 2;
        bArr[99] = 75;
        bArr[100] = 65;
        bArr[101] = 72;
        bArr[102] = 112;
        bArr[103] = 18;
        bArr[104] = 22;
        bArr[105] = 120;
        bArr[106] = 98;
        bArr[107] = 71;
        bArr[108] = 85;
        bArr[109] = 98;
        bArr[110] = 83;
        bArr[111] = 35;
        bArr[112] = 105;
        bArr[113] = 64;
        bArr[114] = 63;
        bArr[115] = 117;
        bArr[116] = 99;
        bArr[117] = 115;
        bArr[118] = 70;
        bArr[119] = 115;
        bArr[120] = 36;
        bArr[121] = 43;
        bArr[122] = 73;
        bArr[123] = 54;
        bArr[124] = 48;
        bArr[125] = 5;
        bArr[126] = 108;
        bArr[127] = 35;
        bArr[128] = 80;
        bArr[129] = 112;
        bArr[130] = 34;
        bArr[131] = 103;
        bArr[132] = 123;
        bArr[133] = 115;
        bArr[134] = 74;
        bArr[135] = 53;
        bArr[136] = 58;
        bArr[137] = 53;
        bArr[138] = 3;
        bArr[139] = 98;
        bArr[140] = 56;
        bArr[141] = 13;
        bArr[142] = 63;
        bArr[143] = -42;
        bArr[144] = -86;
        bArr[145] = -91;
        bArr[146] = -61;
        bArr[147] = -101;
        bArr[148] = -115;
        bArr[149] = -110;
        bArr[150] = -6;
        bArr[151] = -48;
        bArr[152] = -117;
        bArr[153] = -118;
        bArr[154] = -66;
        bArr[155] = -127;
        bArr[156] = -124;
        bArr[157] = -77;
        bArr[158] = -98;
        bArr[159] = -119;
        bArr[160] = -107;
        bArr[161] = -78;
        bArr[162] = -62;
        bArr[163] = -117;
        bArr[164] = -127;
        bArr[165] = -120;
        bArr[166] = -80;
        bArr[167] = -20;
        bArr[168] = -103;
        bArr[169] = -105;
        bArr[170] = -96;
        bArr[171] = -125;
        bArr[172] = -97;
        bArr[173] = -91;
        bArr[174] = -69;
        bArr[175] = -30;
        bArr[176] = -112;
        bArr[177] = -108;
        bArr[178] = -29;
        bArr[179] = -79;
        bArr[180] = -26;
        bArr[181] = -6;
        bArr[182] = -42;
        bArr[183] = -29;
        bArr[184] = -22;
        bArr[185] = -13;
        bArr[186] = -45;
        bArr[187] = -77;
        bArr[188] = -81;
        bArr[189] = -109;
        bArr[190] = -97;
        bArr[191] = -30;
        bArr[192] = -121;
        bArr[193] = -124;
        bArr[194] = -19;
        bArr[195] = -80;
        bArr[196] = -10;
        bArr[197] = -22;
        bArr[198] = -58;
        bArr[199] = -5;
        bArr[200] = -6;
        bArr[201] = -29;
        bArr[202] = -61;
        bArr[203] = -91;
        bArr[204] = -76;
        bArr[205] = -109;
        bArr[206] = -81;
        bArr[207] = -104;
        bArr[208] = -19;
        bArr[209] = -27;
        bArr[210] = -33;
        bArr[211] = -43;
        bArr[212] = -57;
        bArr[213] = -43;
        bArr[214] = -5;
        bArr[215] = -124;
        bArr[216] = -58;
        bArr[217] = -35;
        bArr[218] = -30;
        bArr[219] = -102;
        bArr[220] = -21;
        bArr[221] = -28;
        bArr[222] = -50;
        bArr[223] = -120;
        bArr[224] = -31;
        bArr[225] = -1;
        bArr[226] = -107;
        bArr[227] = -23;
        bArr[228] = -43;
        bArr[229] = -56;
        bArr[230] = -27;
        bArr[231] = -122;
        bArr[232] = -35;
        bArr[233] = -53;
        bArr[234] = -62;
        bArr[235] = -59;
        bArr[236] = -42;
        bArr[237] = -5;
        bArr[238] = -33;
        bArr[239] = -74;
        bArr[240] = -57;
        bArr[241] = -54;
        bArr[242] = -13;
        bArr[243] = -23;
        bArr[244] = -88;
        bArr[245] = -43;
        bArr[246] = 111;
        bArr[247] = 53;
        bArr[248] = -27;
        bArr[249] = 0;
        bArr[250] = 0;
        bArr[251] = 0;
        return bArr;
    }

    public static String[] getActiveUser(Context context) {
        return c.a(context);
    }

    public static String getApmFlag() {
        Method declaredMethod;
        try {
            Class<?> cls = getClass("com.umeng.umcrash.UMCrash");
            if (cls == null || (declaredMethod = cls.getDeclaredMethod("getUMAPMFlag", new Class[0])) == null) {
                return "";
            }
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getAppHashKey(Context context) {
        return DeviceConfig.getAppHashKey(context);
    }

    public static String getAppMD5Signature(Context context) {
        String str = "";
        try {
            String appMD5Signature = DeviceConfig.getAppMD5Signature(context);
            try {
                if (TextUtils.isEmpty(appMD5Signature)) {
                    return appMD5Signature;
                }
                str = appMD5Signature.replace(SOAP.DELIM, str);
                return str.toLowerCase();
            } catch (Throwable unused) {
                return appMD5Signature;
            }
        } catch (Throwable unused2) {
            return str;
        }
    }

    public static String getAppName(Context context) {
        return DeviceConfig.getAppName(context);
    }

    public static String getAppSHA1Key(Context context) {
        return DeviceConfig.getAppSHA1Key(context);
    }

    public static String getAppVersinoCode(Context context, String str) {
        if (!(context == null || str == null)) {
            try {
                PackageInfo a10 = b.a().a(context, str, 64);
                if (a10 != null) {
                    return String.valueOf(a10.versionCode);
                }
            } catch (Exception e10) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e(TAG, "get app version code e is " + e10);
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e(TAG, "get app version code e is " + th);
                }
            }
        }
        return "";
    }

    public static String getAppVersionCode(Context context) {
        if (!TextUtils.isEmpty(sAppVersionCode)) {
            return sAppVersionCode;
        }
        if (context == null) {
            return "";
        }
        try {
            PackageInfo a10 = b.a().a(context, context.getPackageName(), 64);
            if (a10 == null) {
                return "";
            }
            String valueOf = String.valueOf(a10.versionCode);
            sAppVersionCode = valueOf;
            return valueOf;
        } catch (Exception e10) {
            if (!AnalyticsConstants.UM_DEBUG) {
                return "";
            }
            Log.e(TAG, "get app version code e is " + e10);
            return "";
        } catch (Throwable th) {
            if (!AnalyticsConstants.UM_DEBUG) {
                return "";
            }
            Log.e(TAG, "get app version code e is " + th);
            return "";
        }
    }

    public static String getAppVersionName(Context context) {
        if (!TextUtils.isEmpty(sAppVersionName)) {
            return sAppVersionName;
        }
        if (context == null) {
            return "";
        }
        try {
            PackageInfo a10 = b.a().a(context, context.getPackageName(), 64);
            if (a10 == null) {
                return "";
            }
            String str = a10.versionName;
            sAppVersionName = str;
            return str;
        } catch (Throwable th) {
            if (!AnalyticsConstants.UM_DEBUG) {
                return "";
            }
            Log.e(TAG, "get app version name e is " + th);
            return "";
        }
    }

    public static String getAppkey(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(UMConfigure.sAppkey)) {
                return UMConfigure.sAppkey;
            }
            return getMultiProcessSP(context, "appkey");
        } catch (Exception e10) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e(TAG, "get app key e is " + e10);
            }
            UMCrashManager.reportCrash(context, e10);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e(TAG, "get app key e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getAppkeyByXML(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            String string = applicationInfo.metaData.getString("UMENG_APPKEY");
            if (string != null) {
                return string.trim();
            }
            if (!AnalyticsConstants.UM_DEBUG) {
                return null;
            }
            MLog.i(AnalyticsConstants.LOG_TAG, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026 A[SYNTHETIC, Splitter:B:13:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002d A[SYNTHETIC, Splitter:B:19:0x002d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Properties getBuildProp() {
        /*
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x002a, all -> 0x0023 }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x002a, all -> 0x0023 }
            java.io.File r4 = android.os.Environment.getRootDirectory()     // Catch:{ IOException -> 0x002a, all -> 0x0023 }
            java.lang.String r5 = "build.prop"
            r3.<init>(r4, r5)     // Catch:{ IOException -> 0x002a, all -> 0x0023 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x002a, all -> 0x0023 }
            r0.load(r2)     // Catch:{ IOException -> 0x0020, all -> 0x001d }
            r2.close()     // Catch:{ IOException -> 0x0030 }
            goto L_0x0030
        L_0x001d:
            r0 = move-exception
            r1 = r2
            goto L_0x0024
        L_0x0020:
            r1 = r2
            goto L_0x002b
        L_0x0023:
            r0 = move-exception
        L_0x0024:
            if (r1 == 0) goto L_0x0029
            r1.close()     // Catch:{ IOException -> 0x0029 }
        L_0x0029:
            throw r0
        L_0x002a:
        L_0x002b:
            if (r1 == 0) goto L_0x0030
            r1.close()     // Catch:{ IOException -> 0x0030 }
        L_0x0030:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.getBuildProp():java.util.Properties");
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
            } catch (IOException e10) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e(TAG, "Could not read from file /proc/cpuinfo, e is " + e10);
                }
            }
        } catch (FileNotFoundException e11) {
            try {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e(TAG, "Could not read from file /proc/cpuinfo, e is " + e11);
                }
            } catch (Exception e12) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e(TAG, "get cpu e is " + e12);
                }
                return "";
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e(TAG, "get cpu e is " + th);
                }
                return "";
            }
        }
        if (str != null) {
            return str.substring(str.indexOf(58) + 1).trim();
        }
        return "";
    }

    public static String getChannel(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(UMConfigure.sChannel)) {
                return UMConfigure.sChannel;
            }
            return getMultiProcessSP(context, "channel");
        } catch (Exception e10) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e(TAG, "get channel e is " + e10);
            }
            UMCrashManager.reportCrash(context, e10);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e(TAG, "get channel e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getChannelByXML(Context context) {
        Bundle bundle;
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("UMENG_CHANNEL")) == null) {
                return null;
            }
            String obj2 = obj.toString();
            if (obj2 != null) {
                return obj2.trim();
            }
            if (!AnalyticsConstants.UM_DEBUG) {
                return null;
            }
            MLog.i(AnalyticsConstants.LOG_TAG, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getDeviceToken(Context context) {
        Object invoke;
        Method method;
        Object invoke2;
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        Class<PushAgent> cls = PushAgent.class;
        try {
            int i10 = PushAgent.f6187a;
            Method method2 = cls.getMethod("getInstance", new Class[]{Context.class});
            if (method2 == null || (invoke = method2.invoke(cls, new Object[]{applicationContext})) == null || (method = cls.getMethod("getRegistrationId", new Class[0])) == null || (invoke2 = method.invoke(invoke, new Object[0])) == null || !(invoke2 instanceof String)) {
                return null;
            }
            return (String) invoke2;
        } catch (Throwable unused) {
            return null;
        }
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
        } catch (Exception e10) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e(TAG, "get device type e is " + e10);
            }
            UMCrashManager.reportCrash(context, e10);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e(TAG, "get device type e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getDisplayResolution(Context context) {
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return "";
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i10 = displayMetrics.widthPixels;
            int i11 = displayMetrics.heightPixels;
            return String.valueOf(i11) + Operator.Operation.MULTIPLY + String.valueOf(i10);
        } catch (Exception e10) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e(TAG, "get display resolution e is " + e10);
            }
            UMCrashManager.reportCrash(context, e10);
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e(TAG, "get display resolution e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        android.util.Log.e(TAG, "get file MD5 e is " + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005d, code lost:
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005f, code lost:
        android.util.Log.e(TAG, "get file MD5 e is " + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0071, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0042 A[ExcHandler: all (r9v3 'th' java.lang.Object A[CUSTOM_DECLARE]), Splitter:B:1:0x0007] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFileMD5(java.io.File r9) {
        /*
            java.lang.String r0 = "get file MD5 e is "
            java.lang.String r1 = "UMUtils"
            r2 = 1024(0x400, float:1.435E-42)
            r3 = 0
            byte[] r4 = new byte[r2]     // Catch:{ Exception -> 0x005a, all -> 0x0042 }
            boolean r5 = r9.isFile()     // Catch:{ Exception -> 0x0041, all -> 0x0042 }
            if (r5 != 0) goto L_0x0012
            java.lang.String r9 = ""
            return r9
        L_0x0012:
            java.lang.String r5 = "MD5"
            java.security.MessageDigest r5 = java.security.MessageDigest.getInstance(r5)     // Catch:{ Exception -> 0x0041, all -> 0x0042 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0041, all -> 0x0042 }
            r6.<init>(r9)     // Catch:{ Exception -> 0x0041, all -> 0x0042 }
        L_0x001d:
            r9 = 0
            int r7 = r6.read(r4, r9, r2)     // Catch:{ Exception -> 0x0041, all -> 0x0042 }
            r8 = -1
            if (r7 == r8) goto L_0x0029
            r5.update(r4, r9, r7)     // Catch:{ Exception -> 0x0041, all -> 0x0042 }
            goto L_0x001d
        L_0x0029:
            r6.close()     // Catch:{ Exception -> 0x0041, all -> 0x0042 }
            java.math.BigInteger r2 = new java.math.BigInteger     // Catch:{ Exception -> 0x005a, all -> 0x0042 }
            byte[] r4 = r5.digest()     // Catch:{ Exception -> 0x005a, all -> 0x0042 }
            r5 = 1
            r2.<init>(r5, r4)     // Catch:{ Exception -> 0x005a, all -> 0x0042 }
            java.lang.String r4 = "%1$032x"
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x005a, all -> 0x0042 }
            r5[r9] = r2     // Catch:{ Exception -> 0x005a, all -> 0x0042 }
            java.lang.String r9 = java.lang.String.format(r4, r5)     // Catch:{ Exception -> 0x005a, all -> 0x0042 }
            return r9
        L_0x0041:
            return r3
        L_0x0042:
            r9 = move-exception
            boolean r2 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG
            if (r2 == 0) goto L_0x0059
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            android.util.Log.e(r1, r9)
        L_0x0059:
            return r3
        L_0x005a:
            r9 = move-exception
            boolean r2 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG
            if (r2 == 0) goto L_0x0071
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            android.util.Log.e(r1, r9)
        L_0x0071:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.getFileMD5(java.io.File):java.lang.String");
    }

    private static String getFlymeVersion(Properties properties) {
        try {
            String lowerCase = properties.getProperty("ro.build.display.id").toLowerCase(Locale.getDefault());
            if (lowerCase.contains("flyme os")) {
                return lowerCase.split(" ")[2];
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String[] getGPU(GL10 gl10) {
        try {
            return new String[]{gl10.glGetString(7936), gl10.glGetString(7937)};
        } catch (Exception e10) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e(TAG, "Could not read gpu infor, e is " + e10);
            }
            return new String[0];
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e(TAG, "Could not read gpu infor, e is " + th);
            }
            return new String[0];
        }
    }

    public static String getLastAppkey(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return getMultiProcessSP(context, KEY_LAST_APP_KEY);
        } catch (Exception e10) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e(TAG, "get last app key e is " + e10);
            }
            UMCrashManager.reportCrash(context, e10);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e(TAG, "get last app key e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        android.util.Log.e(TAG, "fail to read user config locale, e is " + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        android.util.Log.e(TAG, "get locale e is " + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001a, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0021;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x001a A[ExcHandler: all (r3v6 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:3:0x0008] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Locale getLocale(android.content.Context r6) {
        /*
            java.lang.String r0 = "get locale e is "
            java.lang.String r1 = "UMUtils"
            r2 = 0
            if (r6 != 0) goto L_0x0008
            return r2
        L_0x0008:
            android.content.res.Configuration r3 = new android.content.res.Configuration     // Catch:{ Exception -> 0x001c, all -> 0x001a }
            r3.<init>()     // Catch:{ Exception -> 0x001c, all -> 0x001a }
            r3.setToDefaults()     // Catch:{ Exception -> 0x001c, all -> 0x001a }
            android.content.ContentResolver r4 = r6.getContentResolver()     // Catch:{ Exception -> 0x001c, all -> 0x001a }
            android.provider.Settings.System.getConfiguration(r4, r3)     // Catch:{ Exception -> 0x001c, all -> 0x001a }
            java.util.Locale r3 = r3.locale     // Catch:{ Exception -> 0x001c, all -> 0x001a }
            goto L_0x0036
        L_0x001a:
            r3 = move-exception
            goto L_0x003d
        L_0x001c:
            r3 = move-exception
            boolean r4 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG     // Catch:{ Exception -> 0x0057, all -> 0x001a }
            if (r4 == 0) goto L_0x0035
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0057, all -> 0x001a }
            r4.<init>()     // Catch:{ Exception -> 0x0057, all -> 0x001a }
            java.lang.String r5 = "fail to read user config locale, e is "
            r4.append(r5)     // Catch:{ Exception -> 0x0057, all -> 0x001a }
            r4.append(r3)     // Catch:{ Exception -> 0x0057, all -> 0x001a }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0057, all -> 0x001a }
            android.util.Log.e(r1, r3)     // Catch:{ Exception -> 0x0057, all -> 0x001a }
        L_0x0035:
            r3 = r2
        L_0x0036:
            if (r3 != 0) goto L_0x003c
            java.util.Locale r3 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0057, all -> 0x001a }
        L_0x003c:
            return r3
        L_0x003d:
            boolean r4 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG
            if (r4 == 0) goto L_0x0053
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r3)
            java.lang.String r0 = r4.toString()
            android.util.Log.e(r1, r0)
        L_0x0053:
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r3)
            return r2
        L_0x0057:
            r3 = move-exception
            boolean r4 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG
            if (r4 == 0) goto L_0x006e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r3)
            java.lang.String r0 = r4.toString()
            android.util.Log.e(r1, r0)
        L_0x006e:
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.getLocale(android.content.Context):java.util.Locale");
    }

    public static String getMac(Context context) {
        return null;
    }

    private static byte[] getMiniArray() {
        return new byte[]{1, 6, 8, 12, 13};
    }

    public static JSONObject getModuleVer() {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(bt.bi, a.f14754e);
                if (!TextUtils.isEmpty(VALUE_ANALYTICS_VERSION)) {
                    jSONObject2.put(bt.bj, VALUE_ANALYTICS_VERSION);
                }
                if (!TextUtils.isEmpty(VALUE_GAME_VERSION)) {
                    jSONObject2.put(bt.bk, VALUE_GAME_VERSION);
                }
                if (!TextUtils.isEmpty(VALUE_PUSH_VERSION)) {
                    jSONObject2.put(bt.bl, VALUE_PUSH_VERSION);
                }
                if (!TextUtils.isEmpty(VALUE_SHARE_VERSION)) {
                    jSONObject2.put(bt.bm, VALUE_SHARE_VERSION);
                }
                if (!TextUtils.isEmpty(VALUE_APM_VERSION)) {
                    jSONObject2.put(bt.bn, VALUE_APM_VERSION);
                }
                if (!TextUtils.isEmpty(VALUE_VERIFY_VERSION)) {
                    jSONObject2.put(bt.bo, VALUE_VERIFY_VERSION);
                }
                if (!TextUtils.isEmpty(VALUE_SMS_VERSION)) {
                    jSONObject2.put(bt.bp, VALUE_SMS_VERSION);
                }
                if (!TextUtils.isEmpty(VALUE_REC_VERSION_NAME)) {
                    jSONObject2.put(bt.bq, VALUE_REC_VERSION_NAME);
                }
                if (!TextUtils.isEmpty(VALUE_VISUAL_VERSION)) {
                    jSONObject2.put(bt.br, VALUE_VISUAL_VERSION);
                }
                if (!TextUtils.isEmpty(VALUE_ASMS_VERSION)) {
                    jSONObject2.put(bt.bs, VALUE_ASMS_VERSION);
                }
                if (!TextUtils.isEmpty(VALUE_LINK_VERSION)) {
                    jSONObject2.put(bt.bt, VALUE_LINK_VERSION);
                }
                if (!TextUtils.isEmpty(VALUE_ABTEST_VERSION)) {
                    jSONObject2.put(bt.bu, VALUE_ABTEST_VERSION);
                }
                if (TextUtils.isEmpty(VALUE_ANTI_VERSION)) {
                    return jSONObject2;
                }
                jSONObject2.put(bt.bv, VALUE_ANTI_VERSION);
                return jSONObject2;
            } catch (Throwable unused) {
                jSONObject = jSONObject2;
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return jSONObject;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getMultiProcessSP(android.content.Context r5, java.lang.String r6) {
        /*
            r0 = 0
            java.lang.Object r1 = spLock     // Catch:{ Exception -> 0x0050 }
            monitor-enter(r1)     // Catch:{ Exception -> 0x0050 }
            if (r5 == 0) goto L_0x004b
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x004d }
            if (r2 == 0) goto L_0x000d
            goto L_0x004b
        L_0x000d:
            boolean r2 = isMainProgress(r5)     // Catch:{ all -> 0x004d }
            r3 = 0
            if (r2 == 0) goto L_0x001f
            android.content.Context r5 = r5.getApplicationContext()     // Catch:{ all -> 0x004d }
            java.lang.String r2 = KEY_SHARED_PREFERENCES_NAME     // Catch:{ all -> 0x004d }
            android.content.SharedPreferences r5 = r5.getSharedPreferences(r2, r3)     // Catch:{ all -> 0x004d }
            goto L_0x0041
        L_0x001f:
            java.lang.String r2 = com.umeng.commonsdk.framework.UMFrUtils.getSubProcessName(r5)     // Catch:{ all -> 0x004d }
            android.content.Context r5 = r5.getApplicationContext()     // Catch:{ all -> 0x004d }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x004d }
            r4.<init>()     // Catch:{ all -> 0x004d }
            r4.append(r2)     // Catch:{ all -> 0x004d }
            java.lang.String r2 = "_"
            r4.append(r2)     // Catch:{ all -> 0x004d }
            java.lang.String r2 = KEY_SHARED_PREFERENCES_NAME     // Catch:{ all -> 0x004d }
            r4.append(r2)     // Catch:{ all -> 0x004d }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x004d }
            android.content.SharedPreferences r5 = r5.getSharedPreferences(r2, r3)     // Catch:{ all -> 0x004d }
        L_0x0041:
            if (r5 == 0) goto L_0x0049
            java.lang.String r5 = r5.getString(r6, r0)     // Catch:{ all -> 0x004d }
            monitor-exit(r1)     // Catch:{ all -> 0x004d }
            return r5
        L_0x0049:
            monitor-exit(r1)     // Catch:{ all -> 0x004d }
            return r0
        L_0x004b:
            monitor-exit(r1)     // Catch:{ all -> 0x004d }
            return r0
        L_0x004d:
            r5 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x004d }
            throw r5     // Catch:{ Exception -> 0x0050 }
        L_0x0050:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.getMultiProcessSP(android.content.Context, java.lang.String):java.lang.String");
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
                    return strArr;
                }
                return strArr;
            }
            strArr[0] = "Wi-Fi";
            return strArr;
        } catch (Exception e10) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e(TAG, "get network access mode e is " + e10);
            }
            UMCrashManager.reportCrash(context, e10);
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e(TAG, "get network access mode e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static String getNetworkOperatorName(Context context) {
        return DeviceConfig.getNetworkOperatorName(context);
    }

    public static String getOaidRequiredTime(Context context) {
        if (!FieldManager.allow(d.G)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(i.f14965a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString(i.f14967c, "");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getOperator(Context context) {
        String registeredOperator = DeviceConfig.getRegisteredOperator(context);
        if (TextUtils.isEmpty(registeredOperator)) {
            return "Unknown";
        }
        return registeredOperator;
    }

    public static String getRegisteredOperator(Context context) {
        return DeviceConfig.getRegisteredOperator(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
        android.util.Log.e(TAG, "get sub os name e is " + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0050, code lost:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0053, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0054, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0057, code lost:
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0059, code lost:
        android.util.Log.e(TAG, "get sub os name e is " + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006b, code lost:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006e, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0039 A[ExcHandler: all (r3v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:3:0x0008] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getSubOSName(android.content.Context r6) {
        /*
            java.lang.String r0 = "get sub os name e is "
            java.lang.String r1 = "UMUtils"
            r2 = 0
            if (r6 != 0) goto L_0x0008
            return r2
        L_0x0008:
            java.util.Properties r3 = getBuildProp()     // Catch:{ Exception -> 0x0054, all -> 0x0039 }
            java.lang.String r4 = "ro.miui.ui.version.name"
            java.lang.String r4 = r3.getProperty(r4)     // Catch:{ Exception -> 0x0034, all -> 0x0039 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0034, all -> 0x0039 }
            if (r5 == 0) goto L_0x0030
            boolean r5 = isFlyMe()     // Catch:{ Exception -> 0x0034, all -> 0x0039 }
            if (r5 == 0) goto L_0x0021
            java.lang.String r6 = "Flyme"
            goto L_0x0032
        L_0x0021:
            java.lang.String r3 = getYunOSVersion(r3)     // Catch:{ Exception -> 0x0034, all -> 0x0039 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0034, all -> 0x0039 }
            if (r3 != 0) goto L_0x002e
            java.lang.String r6 = "YunOS"
            goto L_0x0032
        L_0x002e:
            r2 = r4
            goto L_0x0038
        L_0x0030:
            java.lang.String r6 = "MIUI"
        L_0x0032:
            r2 = r6
            goto L_0x0038
        L_0x0034:
            r3 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r3)     // Catch:{ Exception -> 0x0054, all -> 0x0039 }
        L_0x0038:
            return r2
        L_0x0039:
            r3 = move-exception
            boolean r4 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG
            if (r4 == 0) goto L_0x0050
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r3)
            java.lang.String r0 = r4.toString()
            android.util.Log.e(r1, r0)
        L_0x0050:
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r3)
            return r2
        L_0x0054:
            r3 = move-exception
            boolean r4 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG
            if (r4 == 0) goto L_0x006b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r3)
            java.lang.String r0 = r4.toString()
            android.util.Log.e(r1, r0)
        L_0x006b:
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.getSubOSName(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0033, code lost:
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0035, code lost:
        android.util.Log.e(TAG, "get sub os version e is " + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0047, code lost:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004e, code lost:
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0050, code lost:
        android.util.Log.e(TAG, "get sub os version e is " + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0062, code lost:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0065, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0030 A[ExcHandler: all (r3v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:3:0x0008] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getSubOSVersion(android.content.Context r6) {
        /*
            java.lang.String r0 = "get sub os version e is "
            java.lang.String r1 = "UMUtils"
            r2 = 0
            if (r6 != 0) goto L_0x0008
            return r2
        L_0x0008:
            java.util.Properties r3 = getBuildProp()     // Catch:{ Exception -> 0x004b, all -> 0x0030 }
            java.lang.String r4 = "ro.miui.ui.version.name"
            java.lang.String r4 = r3.getProperty(r4)     // Catch:{ Exception -> 0x002b, all -> 0x0030 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x002b, all -> 0x0030 }
            if (r5 == 0) goto L_0x0029
            boolean r5 = isFlyMe()     // Catch:{ Exception -> 0x002b, all -> 0x0030 }
            if (r5 == 0) goto L_0x0023
            java.lang.String r6 = getFlymeVersion(r3)     // Catch:{ Exception -> 0x0029, all -> 0x0030 }
            goto L_0x0027
        L_0x0023:
            java.lang.String r6 = getYunOSVersion(r3)     // Catch:{ Exception -> 0x0029, all -> 0x0030 }
        L_0x0027:
            r2 = r6
            goto L_0x002f
        L_0x0029:
            r2 = r4
            goto L_0x002f
        L_0x002b:
            r3 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r3)     // Catch:{ Exception -> 0x004b, all -> 0x0030 }
        L_0x002f:
            return r2
        L_0x0030:
            r3 = move-exception
            boolean r4 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG
            if (r4 == 0) goto L_0x0047
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r3)
            java.lang.String r0 = r4.toString()
            android.util.Log.e(r1, r0)
        L_0x0047:
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r3)
            return r2
        L_0x004b:
            r3 = move-exception
            boolean r4 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG
            if (r4 == 0) goto L_0x0062
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r3)
            java.lang.String r0 = r4.toString()
            android.util.Log.e(r1, r0)
        L_0x0062:
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.getSubOSVersion(android.content.Context):java.lang.String");
    }

    public static String getSystemProperty(String str, String str2) {
        Class<String> cls = String.class;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{cls, cls}).invoke((Object) null, new Object[]{str, str2});
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static int getTargetSdkVersion(Context context) {
        try {
            return context.getApplicationInfo().targetSdkVersion;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String getUMId(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return UMEnvelopeBuild.imprintProperty(context.getApplicationContext(), bt.f13913g, (String) null);
        } catch (Exception e10) {
            UMCrashManager.reportCrash(context, e10);
            return null;
        }
    }

    public static String getUUIDForZid(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_FILE_NAME, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("session_id", "");
        }
        return "";
    }

    public static String getUmengToken(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return UMEnvelopeBuild.imprintProperty(context.getApplicationContext(), "ztoken", (String) null);
        } catch (Exception e10) {
            UMCrashManager.reportCrash(context, e10);
            return null;
        }
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

    public static String getZid(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (!UMConfigure.needSendZcfgEnv(applicationContext)) {
            return b.a(applicationContext).a().a();
        }
        return null;
    }

    public static boolean isAppInstalled(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            if (b.a().a(context, str, 0) != null) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isApplication(Context context) {
        try {
            String name = context.getApplicationContext().getClass().getSuperclass().getName();
            if (TextUtils.isEmpty(name) || !name.equals("android.app.Application")) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isDebug(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception e10) {
            UMCrashManager.reportCrash(context, e10);
            return false;
        }
    }

    private static boolean isFlyMe() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isMainProgress(Context context) {
        try {
            String currentProcessName = UMFrUtils.getCurrentProcessName(context);
            String packageName = context.getApplicationContext().getPackageName();
            if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isSdCardWrittenable() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String parseId(String str) {
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static String readStreamToString(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[1024];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (-1 == read) {
                return stringWriter.toString();
            }
            stringWriter.write(cArr, 0, read);
        }
    }

    private static void safeClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void saveSDKComponent() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a");
        if (UMConfigure.isDebugLog()) {
            UMLog.mutlInfo(2, "统计SDK版本号: 9.7.9");
        }
        VALUE_ANALYTICS_VERSION = "9.7.9";
        String b10 = com.umeng.commonsdk.internal.c.b();
        if (!TextUtils.isEmpty(b10)) {
            VALUE_ASMS_VERSION = b10;
            if (UMConfigure.isDebugLog()) {
                UMLog.mutlInfo(2, "ZID SDK版本号: " + b10);
            }
        }
        Class<?> cls = getClass("com.umeng.analytics.game.GameSdkVersion");
        if (cls != null) {
            stringBuffer.append("g");
            try {
                String str = (String) cls.getDeclaredField("SDK_VERSION").get(cls);
                if (!TextUtils.isEmpty(str)) {
                    VALUE_GAME_VERSION = str;
                    if (UMConfigure.isDebugLog()) {
                        UMLog.mutlInfo(2, "游戏统计SDK版本号: " + str);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        Class<?> cls2 = getClass("com.umeng.vt.V");
        if (cls2 != null) {
            stringBuffer.append("v");
            try {
                String str2 = (String) cls2.getDeclaredField("VERSION").get(cls2);
                if (!TextUtils.isEmpty(str2)) {
                    VALUE_VISUAL_VERSION = str2;
                    if (UMConfigure.isDebugLog()) {
                        UMLog.mutlInfo(2, "可视化埋点SDK版本号: " + str2);
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        if (getClass("com.umeng.message.PushAgent") != null) {
            stringBuffer.append(bt.aD);
            Class<?> cls3 = getClass("com.umeng.message.MsgConstant");
            if (cls3 != null) {
                try {
                    String str3 = (String) cls3.getDeclaredField("SDK_VERSION").get(cls3);
                    if (!TextUtils.isEmpty(str3)) {
                        VALUE_PUSH_VERSION = str3;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "推送SDK版本号: " + str3);
                        }
                    }
                } catch (Throwable unused3) {
                }
            }
        }
        Class<?> cls4 = getClass("com.umeng.socialize.UMShareAPI");
        if (cls4 != null) {
            stringBuffer.append("s");
            Class<?> cls5 = getClass("com.umeng.a");
            if (cls5 != null) {
                try {
                    String str4 = (String) cls5.getDeclaredField("g").get(cls5);
                    if (!TextUtils.isEmpty(str4)) {
                        VALUE_SHARE_VERSION = str4;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "分享SDK版本号: " + str4);
                        }
                    }
                } catch (Throwable unused4) {
                }
            }
            if (TextUtils.isEmpty(VALUE_SHARE_VERSION)) {
                try {
                    Method declaredMethod = cls4.getDeclaredMethod("getSdkVersion", new Class[0]);
                    declaredMethod.setAccessible(true);
                    VALUE_SHARE_VERSION = (String) declaredMethod.invoke(cls4, new Object[0]);
                } catch (Throwable unused5) {
                }
            }
        }
        if (getClass("com.umeng.error.UMError") != null) {
            stringBuffer.append("e");
        }
        if (getClass("com.umeng.umzid.ZIDManager") != null) {
            stringBuffer.append(bt.aJ);
        }
        stringBuffer.append(bt.aI);
        if (!(SdkVersion.SDK_TYPE == 1 || getClass("com.umeng.commonsdk.internal.UMOplus") == null)) {
            stringBuffer.append("o");
        }
        if (getClass("com.umeng.airec.RecAgent") != null) {
            stringBuffer.append("u");
            Class<?> cls6 = getClass("com.umeng.airec.BuildConfig");
            if (cls6 != null) {
                try {
                    String str5 = (String) cls6.getDeclaredField("VERSION_NAME").get(cls6);
                    if (!TextUtils.isEmpty(str5)) {
                        VALUE_REC_VERSION_NAME = str5;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "智能推荐SDK版本号: " + str5);
                        }
                    }
                } catch (Throwable unused6) {
                }
            }
        }
        Class<?> cls7 = getClass("com.umeng.umverify.UMVerifyHelper");
        if (cls7 != null) {
            stringBuffer.append("n");
            try {
                Method declaredMethod2 = cls7.getDeclaredMethod("getUVerifyVersion", new Class[0]);
                if (declaredMethod2 != null) {
                    String str6 = (String) declaredMethod2.invoke(cls7, new Object[0]);
                    if (!TextUtils.isEmpty(str6)) {
                        VALUE_VERIFY_VERSION = str6;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "号码认证SDK版本号: " + str6);
                        }
                    }
                }
            } catch (Throwable unused7) {
            }
        }
        Class<?> cls8 = getClass("com.umeng.sms.UMSMS");
        if (cls8 != null) {
            stringBuffer.append("m");
            try {
                Method declaredMethod3 = cls8.getDeclaredMethod("getVersion", new Class[0]);
                if (declaredMethod3 != null) {
                    String str7 = (String) declaredMethod3.invoke(cls8, new Object[0]);
                    if (!TextUtils.isEmpty(str7)) {
                        VALUE_SMS_VERSION = str7;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "短信验证码SDK版本号: " + str7);
                        }
                    }
                }
            } catch (Throwable unused8) {
            }
        }
        try {
            Class<?> cls9 = getClass("com.umeng.umcrash.UMCrash");
            if (cls9 != null) {
                stringBuffer.append(bt.aL);
                Field declaredField = cls9.getDeclaredField("crashSdkVersion");
                declaredField.setAccessible(true);
                String str8 = (String) declaredField.get(cls9);
                if (!TextUtils.isEmpty(str8)) {
                    VALUE_APM_VERSION = str8;
                    if (UMConfigure.isDebugLog()) {
                        UMLog.mutlInfo(2, "APM SDK版本号: " + str8);
                    }
                }
            }
        } catch (Throwable unused9) {
        }
        Class<?> cls10 = getClass("com.umeng.umlink.MobclickLink");
        if (cls10 != null) {
            stringBuffer.append("l");
            try {
                Method declaredMethod4 = cls10.getDeclaredMethod("getVersion", new Class[0]);
                if (declaredMethod4 != null) {
                    String str9 = (String) declaredMethod4.invoke(cls10, new Object[0]);
                    if (!TextUtils.isEmpty(str9)) {
                        VALUE_LINK_VERSION = str9;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "ULink SDK版本号: " + str9);
                        }
                    }
                }
            } catch (Throwable unused10) {
            }
        }
        Class<?> cls11 = getClass("com.umeng.cconfig.UMRemoteConfig");
        if (cls11 != null) {
            try {
                Method declaredMethod5 = cls11.getDeclaredMethod("getVersion", new Class[0]);
                if (declaredMethod5 != null) {
                    stringBuffer.append("t");
                    String str10 = (String) declaredMethod5.invoke(cls11, new Object[0]);
                    if (!TextUtils.isEmpty(str10)) {
                        VALUE_ABTEST_VERSION = str10;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "UABTEST SDK版本号: " + str10);
                        }
                    }
                }
            } catch (Throwable unused11) {
            }
        }
        Class<?> cls12 = getClass("com.uyumao.sdk.UYMManager");
        if (cls12 != null) {
            try {
                Method declaredMethod6 = cls12.getDeclaredMethod("getSdkVersion", new Class[0]);
                if (declaredMethod6 != null) {
                    stringBuffer.append("r");
                    String str11 = (String) declaredMethod6.invoke(cls12, new Object[0]);
                    if (!TextUtils.isEmpty(str11)) {
                        VALUE_ANTI_VERSION = str11;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "ANTI SDK版本号: " + str11);
                        }
                    }
                }
            } catch (Throwable unused12) {
            }
        }
        if (!TextUtils.isEmpty(stringBuffer)) {
            com.umeng.commonsdk.statistics.b.f14876a = stringBuffer.toString();
            StringBuilder sb = new StringBuilder();
            sb.append("module init:");
            sb.append(com.umeng.commonsdk.statistics.b.f14876a);
        }
    }

    public static void setAppkey(Context context, String str) {
        if (context != null && str != null) {
            try {
                setMultiProcessSP(context, "appkey", str);
            } catch (Exception e10) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e(TAG, "set app key e is " + e10);
                }
                UMCrashManager.reportCrash(context, e10);
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e(TAG, "set app key e is " + th);
                }
                UMCrashManager.reportCrash(context, th);
            }
        }
    }

    public static void setChannel(Context context, String str) {
        if (context != null && str != null) {
            try {
                setMultiProcessSP(context, "channel", str);
            } catch (Exception e10) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e(TAG, "set channel e is " + e10);
                }
                UMCrashManager.reportCrash(context, e10);
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e(TAG, "set channel e is " + th);
                }
                UMCrashManager.reportCrash(context, th);
            }
        }
    }

    public static void setLastAppkey(Context context, String str) {
        if (context != null && str != null) {
            try {
                setMultiProcessSP(context, KEY_LAST_APP_KEY, str);
            } catch (Exception e10) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e(TAG, "set last app key e is " + e10);
                }
                UMCrashManager.reportCrash(context, e10);
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e(TAG, "set last app key e is " + th);
                }
                UMCrashManager.reportCrash(context, th);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0052, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setMultiProcessSP(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.Object r0 = spLock     // Catch:{ Exception -> 0x0056 }
            monitor-enter(r0)     // Catch:{ Exception -> 0x0056 }
            if (r4 == 0) goto L_0x0051
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0053 }
            if (r1 != 0) goto L_0x0051
            if (r6 != 0) goto L_0x000e
            goto L_0x0051
        L_0x000e:
            boolean r1 = isMainProgress(r4)     // Catch:{ all -> 0x0053 }
            r2 = 0
            if (r1 == 0) goto L_0x0020
            android.content.Context r4 = r4.getApplicationContext()     // Catch:{ all -> 0x0053 }
            java.lang.String r1 = KEY_SHARED_PREFERENCES_NAME     // Catch:{ all -> 0x0053 }
            android.content.SharedPreferences r4 = r4.getSharedPreferences(r1, r2)     // Catch:{ all -> 0x0053 }
            goto L_0x0042
        L_0x0020:
            java.lang.String r1 = com.umeng.commonsdk.framework.UMFrUtils.getSubProcessName(r4)     // Catch:{ all -> 0x0053 }
            android.content.Context r4 = r4.getApplicationContext()     // Catch:{ all -> 0x0053 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0053 }
            r3.<init>()     // Catch:{ all -> 0x0053 }
            r3.append(r1)     // Catch:{ all -> 0x0053 }
            java.lang.String r1 = "_"
            r3.append(r1)     // Catch:{ all -> 0x0053 }
            java.lang.String r1 = KEY_SHARED_PREFERENCES_NAME     // Catch:{ all -> 0x0053 }
            r3.append(r1)     // Catch:{ all -> 0x0053 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0053 }
            android.content.SharedPreferences r4 = r4.getSharedPreferences(r1, r2)     // Catch:{ all -> 0x0053 }
        L_0x0042:
            if (r4 == 0) goto L_0x004f
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ all -> 0x0053 }
            android.content.SharedPreferences$Editor r4 = r4.putString(r5, r6)     // Catch:{ all -> 0x0053 }
            r4.commit()     // Catch:{ all -> 0x0053 }
        L_0x004f:
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            goto L_0x0056
        L_0x0051:
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            return
        L_0x0053:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            throw r4     // Catch:{ Exception -> 0x0056 }
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.setMultiProcessSP(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static void setUUIDForZid(Context context) {
        String str;
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_FILE_NAME, 0);
        try {
            str = UUID.randomUUID().toString();
        } catch (Throwable unused) {
            str = "";
        }
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("session_id", str).commit();
        }
    }

    public static String getAppVersionName(Context context, String str) {
        if (!(context == null || str == null)) {
            try {
                PackageInfo a10 = b.a().a(context, str, 64);
                if (a10 != null) {
                    return a10.versionName;
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e(TAG, "get app version name e is " + th);
                }
                UMCrashManager.reportCrash(context, th);
            }
        }
        return "";
    }
}
