package com.hpplay.sdk.source.common.utils;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.hpplay.sdk.source.log.SourceLog;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class HapplayUtils {
    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] NUMBERS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final String TAG = "HapplayUtils";
    private static final boolean USE_LOOPBACK_ADDR = false;
    private static final boolean USE_ONLY_IPV4_ADDR = true;
    private static final boolean USE_ONLY_IPV6_ADDR = false;
    public static Application mApplication = null;
    private static HashMap<String, String> mfMap = new HashMap<>();

    public static boolean checkLoaclPort(int i10) {
        try {
            return isPortUsing("127.0.0.1", i10);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return true;
        }
    }

    public static String getAppName(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return null;
        }
    }

    public static int getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return 0;
        }
    }

    public static Application getApplication() {
        Application application = mApplication;
        if (application != null) {
            return application;
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            mApplication = (Application) cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke((Object) null, (Object[]) null), (Object[]) null);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
        return mApplication;
    }

    public static HashMap<String, String> getConfigMaps() {
        return mfMap;
    }

    public static final int getHostCount() {
        int i10 = 0;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    if (isUsableAddress(inetAddresses.nextElement())) {
                        i10++;
                    }
                }
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
        return i10;
    }

    public static final String getIpStr(int i10) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            int i11 = 0;
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (isUsableAddress(nextElement)) {
                            if (i11 >= i10) {
                                return nextElement.getHostAddress();
                            }
                            i11++;
                        }
                    }
                }
            }
            return "";
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return "";
        }
    }

    public static String getJsonParams(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (String next : map.keySet()) {
                try {
                    jSONObject.put(next, map.get(next));
                } catch (Exception e10) {
                    SourceLog.w(TAG, (Throwable) e10);
                }
            }
        }
        return jSONObject.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0073 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x000e A[Catch:{ Exception -> 0x0065 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getLoaclIp() {
        /*
            java.lang.String r0 = "HapplayUtils"
            r1 = 0
            java.util.Enumeration r2 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch:{ Exception -> 0x0067 }
            r3 = r1
        L_0x0008:
            boolean r4 = r2.hasMoreElements()     // Catch:{ Exception -> 0x0065 }
            if (r4 == 0) goto L_0x006c
            java.lang.Object r4 = r2.nextElement()     // Catch:{ Exception -> 0x0065 }
            java.net.NetworkInterface r4 = (java.net.NetworkInterface) r4     // Catch:{ Exception -> 0x0065 }
            java.util.Enumeration r5 = r4.getInetAddresses()     // Catch:{ Exception -> 0x0065 }
            java.lang.String r4 = r4.getDisplayName()     // Catch:{ Exception -> 0x0065 }
        L_0x001c:
            boolean r6 = r5.hasMoreElements()     // Catch:{ Exception -> 0x0065 }
            if (r6 == 0) goto L_0x0008
            java.lang.Object r6 = r5.nextElement()     // Catch:{ Exception -> 0x0065 }
            java.net.InetAddress r6 = (java.net.InetAddress) r6     // Catch:{ Exception -> 0x0065 }
            boolean r7 = r6 instanceof java.net.Inet6Address     // Catch:{ Exception -> 0x0065 }
            if (r7 == 0) goto L_0x002d
            goto L_0x001c
        L_0x002d:
            java.lang.String r7 = r6.getHostAddress()     // Catch:{ Exception -> 0x0065 }
            java.lang.String r8 = "127.0.0.1"
            boolean r7 = r8.equals(r7)     // Catch:{ Exception -> 0x0065 }
            if (r7 != 0) goto L_0x001c
            java.lang.String r6 = r6.getHostAddress()     // Catch:{ Exception -> 0x0065 }
            java.lang.String r7 = "wlan0"
            boolean r7 = r7.equals(r4)     // Catch:{ Exception -> 0x0065 }
            if (r7 == 0) goto L_0x0047
            r1 = r6
            goto L_0x0048
        L_0x0047:
            r3 = r6
        L_0x0048:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0065 }
            r7.<init>()     // Catch:{ Exception -> 0x0065 }
            java.lang.String r8 = "getLoaclIp "
            r7.append(r8)     // Catch:{ Exception -> 0x0065 }
            r7.append(r6)     // Catch:{ Exception -> 0x0065 }
            java.lang.String r6 = "/"
            r7.append(r6)     // Catch:{ Exception -> 0x0065 }
            r7.append(r4)     // Catch:{ Exception -> 0x0065 }
            java.lang.String r6 = r7.toString()     // Catch:{ Exception -> 0x0065 }
            com.hpplay.sdk.source.log.SourceLog.debug(r0, r6)     // Catch:{ Exception -> 0x0065 }
            goto L_0x001c
        L_0x0065:
            r2 = move-exception
            goto L_0x0069
        L_0x0067:
            r2 = move-exception
            r3 = r1
        L_0x0069:
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r0, (java.lang.Throwable) r2)
        L_0x006c:
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L_0x0073
            return r1
        L_0x0073:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.common.utils.HapplayUtils.getLoaclIp():java.lang.String");
    }

    public static String getMapParams(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            for (String next : map.keySet()) {
                sb.append(next);
                sb.append(Operator.Operation.EQUALS);
                sb.append(map.get(next));
                sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            }
        }
        if (!TextUtils.isEmpty(sb.toString()) && sb.length() > 1) {
            sb = new StringBuilder(sb.substring(0, sb.length() - 1));
        }
        return sb.toString();
    }

    public static String getMapParamsWithoutEmpty(Map<String, String> map) {
        String str = "";
        if (map != null) {
            for (String next : map.keySet()) {
                String str2 = map.get(next);
                if (!TextUtils.isEmpty(str2)) {
                    str = str + next + Operator.Operation.EQUALS + str2 + DispatchConstants.SIGN_SPLIT_SYMBOL;
                }
            }
        }
        if (TextUtils.isEmpty(str) || str.length() <= 1) {
            return str;
        }
        return str.substring(0, str.length() - 1);
    }

    public static boolean getSystemPropertiesBoolean(String str, boolean z10) {
        try {
            boolean booleanValue = ((Boolean) Class.forName("android.os.SystemProperties").getMethod("getBoolean", new Class[]{String.class, Boolean.TYPE}).invoke((Object) null, new Object[]{str, Boolean.valueOf(z10)})).booleanValue();
            SourceLog.i(TAG, " get boolean SystemProperties ----> " + booleanValue);
            return booleanValue;
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return z10;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027 A[Catch:{ SocketException -> 0x0036 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getWifiIp() {
        /*
            r0 = 0
            java.util.Enumeration r1 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch:{ SocketException -> 0x0036 }
        L_0x0005:
            boolean r2 = r1.hasMoreElements()     // Catch:{ SocketException -> 0x0036 }
            if (r2 == 0) goto L_0x003c
            java.lang.Object r2 = r1.nextElement()     // Catch:{ SocketException -> 0x0036 }
            java.net.NetworkInterface r2 = (java.net.NetworkInterface) r2     // Catch:{ SocketException -> 0x0036 }
            java.util.Enumeration r3 = r2.getInetAddresses()     // Catch:{ SocketException -> 0x0036 }
            java.lang.String r2 = r2.getDisplayName()     // Catch:{ SocketException -> 0x0036 }
            java.lang.String r4 = "wlan0"
            boolean r2 = r2.contains(r4)     // Catch:{ SocketException -> 0x0036 }
            if (r2 == 0) goto L_0x0005
        L_0x0021:
            boolean r1 = r3.hasMoreElements()     // Catch:{ SocketException -> 0x0036 }
            if (r1 == 0) goto L_0x003c
            java.lang.Object r1 = r3.nextElement()     // Catch:{ SocketException -> 0x0036 }
            java.net.InetAddress r1 = (java.net.InetAddress) r1     // Catch:{ SocketException -> 0x0036 }
            boolean r2 = r1 instanceof java.net.Inet4Address     // Catch:{ SocketException -> 0x0036 }
            if (r2 == 0) goto L_0x0021
            java.lang.String r0 = r1.getHostAddress()     // Catch:{ SocketException -> 0x0036 }
            goto L_0x003c
        L_0x0036:
            r1 = move-exception
            java.lang.String r2 = "HapplayUtils"
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r2, (java.lang.Throwable) r1)
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.common.utils.HapplayUtils.getWifiIp():java.lang.String");
    }

    public static void initManufacture(Context context) {
        try {
            if (mfMap.size() == 0) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open("mfConfig")));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append(",");
                }
                String[] split = sb.toString().split(",");
                int i10 = 0;
                while (i10 < split.length) {
                    int i11 = i10 + 1;
                    if (i11 % 2 == 0 && i11 < split.length) {
                        int i12 = i10 - 1;
                        mfMap.put(split[i10], split[i12]);
                        SourceLog.debug(TAG, "key " + split[i10] + "  value " + split[i12]);
                    }
                    i10 = i11;
                }
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public static boolean isNetworkConnected(Context context) {
        try {
            if (((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().getType() == 1) {
                return true;
            }
            return false;
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        com.hpplay.sdk.source.log.SourceLog.w(TAG, "isPortUsing IOException " + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isPortUsing(java.lang.String r2, int r3) {
        /*
            java.lang.String r0 = "HapplayUtils"
            java.net.InetAddress r2 = java.net.InetAddress.getByName(r2)
            java.net.Socket r1 = new java.net.Socket     // Catch:{ IOException -> 0x0017, all -> 0x0015 }
            r1.<init>(r2, r3)     // Catch:{ IOException -> 0x0017, all -> 0x0015 }
            r1.close()     // Catch:{ IOException -> 0x000f }
            goto L_0x0013
        L_0x000f:
            r2 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r0, (java.lang.Throwable) r2)
        L_0x0013:
            r2 = 1
            goto L_0x002c
        L_0x0015:
            r2 = move-exception
            throw r2
        L_0x0017:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r1 = "isPortUsing IOException "
            r2.append(r1)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r0, (java.lang.String) r2)
            r2 = 0
        L_0x002c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.common.utils.HapplayUtils.isPortUsing(java.lang.String, int):boolean");
    }

    private static final boolean isUsableAddress(InetAddress inetAddress) {
        if (!inetAddress.isLoopbackAddress() && !(inetAddress instanceof Inet6Address)) {
            return true;
        }
        return false;
    }

    public static int parsePort(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return 0;
        }
    }

    public static void setApplication(Application application) {
        mApplication = application;
    }
}
