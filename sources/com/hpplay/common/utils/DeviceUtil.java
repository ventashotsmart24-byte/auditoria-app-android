package com.hpplay.common.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.hpplay.common.log.LeLog;

public class DeviceUtil {
    private static final String TAG = "DeviceUtil";
    private static String sAID = "";
    private static String sOAID = "";

    public static String getAID(Context context) {
        if (!TextUtils.isEmpty(sAID)) {
            return sAID;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), FieldUtil.getString(FieldUtil.f10532a));
            sAID = string;
            return string;
        } catch (Exception unused) {
            LeLog.w(TAG, "getAID Settings.Secure can not get aID");
            try {
                String string2 = Settings.System.getString(context.getContentResolver(), FieldUtil.getString(FieldUtil.f10532a));
                sAID = string2;
                return string2;
            } catch (Exception unused2) {
                LeLog.w(TAG, "getAID Settings.System can not get aID");
                return "";
            } catch (Error unused3) {
                LeLog.w(TAG, "getAID Settings.System can not get aID");
                return "";
            }
        } catch (Error unused4) {
            LeLog.w(TAG, "getAID Settings.Secure can not get aID");
            String string22 = Settings.System.getString(context.getContentResolver(), FieldUtil.getString(FieldUtil.f10532a));
            sAID = string22;
            return string22;
        }
    }

    public static String getBluetoothName() {
        try {
            return BluetoothAdapter.getDefaultAdapter().getName();
        } catch (Exception unused) {
            return Build.MANUFACTURER + " " + Build.MODEL;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c A[Catch:{ Exception -> 0x0098 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004d A[Catch:{ Exception -> 0x0098 }, LOOP:0: B:23:0x004d->B:46:0x004d, LOOP_START, PHI: r0 
      PHI: (r0v2 java.lang.String) = (r0v0 java.lang.String), (r0v3 java.lang.String) binds: [B:21:0x004a, B:46:0x004d] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getIPAddress(android.content.Context r8) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "connectivity"
            java.lang.Object r8 = r8.getSystemService(r1)     // Catch:{ Exception -> 0x0098 }
            android.net.ConnectivityManager r8 = (android.net.ConnectivityManager) r8     // Catch:{ Exception -> 0x0098 }
            android.net.NetworkInfo r8 = r8.getActiveNetworkInfo()     // Catch:{ Exception -> 0x0098 }
            r1 = 0
            if (r8 == 0) goto L_0x0044
            boolean r2 = r8.isConnected()     // Catch:{ Exception -> 0x0098 }
            if (r2 == 0) goto L_0x0044
            java.lang.String r8 = r8.getTypeName()     // Catch:{ Exception -> 0x0098 }
            java.lang.String r2 = "Ethernet"
            boolean r2 = r8.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0098 }
            r3 = 1
            if (r2 != 0) goto L_0x0041
            java.lang.String r2 = "ETH"
            boolean r2 = r8.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0098 }
            if (r2 == 0) goto L_0x002d
            goto L_0x0041
        L_0x002d:
            java.lang.String r2 = "WIFI"
            boolean r2 = r8.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0098 }
            if (r2 == 0) goto L_0x0037
            r8 = 0
            goto L_0x0046
        L_0x0037:
            java.lang.String r2 = "MOBILE"
            boolean r8 = r8.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0098 }
            if (r8 == 0) goto L_0x0044
            r8 = 1
            goto L_0x0045
        L_0x0041:
            r8 = 0
            r1 = 1
            goto L_0x0045
        L_0x0044:
            r8 = 0
        L_0x0045:
            r3 = 0
        L_0x0046:
            java.util.Enumeration r2 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch:{ Exception -> 0x0098 }
            if (r2 != 0) goto L_0x004d
            return r0
        L_0x004d:
            boolean r4 = r2.hasMoreElements()     // Catch:{ Exception -> 0x0098 }
            if (r4 == 0) goto L_0x009e
            java.lang.Object r4 = r2.nextElement()     // Catch:{ Exception -> 0x0098 }
            java.net.NetworkInterface r4 = (java.net.NetworkInterface) r4     // Catch:{ Exception -> 0x0098 }
            java.util.Enumeration r5 = r4.getInetAddresses()     // Catch:{ Exception -> 0x0098 }
        L_0x005d:
            boolean r6 = r5.hasMoreElements()     // Catch:{ Exception -> 0x0098 }
            if (r6 == 0) goto L_0x004d
            java.lang.Object r6 = r5.nextElement()     // Catch:{ Exception -> 0x0098 }
            java.net.InetAddress r6 = (java.net.InetAddress) r6     // Catch:{ Exception -> 0x0098 }
            boolean r7 = r6.isLoopbackAddress()     // Catch:{ Exception -> 0x0098 }
            if (r7 != 0) goto L_0x005d
            boolean r7 = r6 instanceof java.net.Inet4Address     // Catch:{ Exception -> 0x0098 }
            if (r7 == 0) goto L_0x005d
            java.lang.String r0 = r6.getHostAddress()     // Catch:{ Exception -> 0x0098 }
            if (r1 == 0) goto L_0x0086
            java.lang.String r4 = r4.getDisplayName()     // Catch:{ Exception -> 0x0098 }
            java.lang.String r5 = "eth0"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0098 }
            if (r4 == 0) goto L_0x004d
            return r0
        L_0x0086:
            if (r3 == 0) goto L_0x0095
            java.lang.String r4 = r4.getDisplayName()     // Catch:{ Exception -> 0x0098 }
            java.lang.String r5 = "wlan0"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0098 }
            if (r4 == 0) goto L_0x004d
            return r0
        L_0x0095:
            if (r8 == 0) goto L_0x004d
            return r0
        L_0x0098:
            r8 = move-exception
            java.lang.String r1 = "DeviceUtil"
            com.hpplay.common.log.LeLog.w((java.lang.String) r1, (java.lang.Throwable) r8)
        L_0x009e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.common.utils.DeviceUtil.getIPAddress(android.content.Context):java.lang.String");
    }

    public static String getOAID(Context context) {
        return sOAID;
    }

    public static void setOAID(String str) {
        sOAID = str;
    }
}
