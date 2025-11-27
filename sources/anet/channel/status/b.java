package anet.channel.status;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.AwcnConfig;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import anet.channel.util.c;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

class b {

    /* renamed from: a  reason: collision with root package name */
    static volatile Context f3856a = null;

    /* renamed from: b  reason: collision with root package name */
    static volatile boolean f3857b = false;

    /* renamed from: c  reason: collision with root package name */
    static volatile NetworkStatusHelper.NetworkStatus f3858c = NetworkStatusHelper.NetworkStatus.NONE;

    /* renamed from: d  reason: collision with root package name */
    static volatile String f3859d = "unknown";

    /* renamed from: e  reason: collision with root package name */
    static volatile String f3860e = "";

    /* renamed from: f  reason: collision with root package name */
    static volatile String f3861f = "";

    /* renamed from: g  reason: collision with root package name */
    static volatile String f3862g = "";

    /* renamed from: h  reason: collision with root package name */
    static volatile String f3863h = "unknown";

    /* renamed from: i  reason: collision with root package name */
    static volatile String f3864i = "";

    /* renamed from: j  reason: collision with root package name */
    static volatile Pair<String, Integer> f3865j = null;

    /* renamed from: k  reason: collision with root package name */
    static volatile boolean f3866k = false;

    /* renamed from: l  reason: collision with root package name */
    static volatile List<InetAddress> f3867l = Collections.EMPTY_LIST;

    /* renamed from: m  reason: collision with root package name */
    private static String[] f3868m = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};

    /* renamed from: n  reason: collision with root package name */
    private static volatile boolean f3869n = false;

    /* renamed from: o  reason: collision with root package name */
    private static volatile boolean f3870o = false;

    /* renamed from: p  reason: collision with root package name */
    private static ConnectivityManager f3871p = null;

    /* renamed from: q  reason: collision with root package name */
    private static TelephonyManager f3872q = null;

    /* renamed from: r  reason: collision with root package name */
    private static WifiManager f3873r = null;

    /* renamed from: s  reason: collision with root package name */
    private static SubscriptionManager f3874s = null;

    /* renamed from: t  reason: collision with root package name */
    private static Method f3875t;

    /* renamed from: u  reason: collision with root package name */
    private static BroadcastReceiver f3876u = new NetworkStatusMonitor$2();

    public static void a() {
        if (!f3869n && f3856a != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            try {
                if (Build.VERSION.SDK_INT >= 33) {
                    Intent unused = f3856a.registerReceiver(f3876u, intentFilter, 2);
                } else {
                    f3856a.registerReceiver(f3876u, intentFilter);
                }
            } catch (Exception unused2) {
                ALog.e("awcn.NetworkStatusMonitor", "registerReceiver failed", (String) null, new Object[0]);
            }
            d();
            f3869n = true;
        }
    }

    public static void b() {
        if (f3856a != null) {
            f3856a.unregisterReceiver(f3876u);
        }
    }

    public static void c() {
        boolean z10;
        if (Build.VERSION.SDK_INT >= 24 && !f3870o) {
            NetworkInfo e10 = e();
            if (e10 == null || !e10.isConnected()) {
                z10 = false;
            } else {
                z10 = true;
            }
            f3857b = z10;
            f3871p.registerDefaultNetworkCallback(new c());
            f3870o = true;
        }
    }

    public static void d() {
        boolean z10;
        NetworkInfo networkInfo;
        WifiInfo i10;
        ALog.d("awcn.NetworkStatusMonitor", "[checkNetworkStatus]", (String) null, new Object[0]);
        NetworkStatusHelper.NetworkStatus networkStatus = f3858c;
        String str = f3860e;
        String str2 = f3861f;
        try {
            networkInfo = e();
            z10 = false;
        } catch (Exception e10) {
            try {
                ALog.e("awcn.NetworkStatusMonitor", "getNetworkInfo exception", (String) null, e10, new Object[0]);
                a(NetworkStatusHelper.NetworkStatus.NONE, "unknown");
                networkInfo = null;
                z10 = true;
            } catch (Exception e11) {
                ALog.e("awcn.NetworkStatusMonitor", "checkNetworkStatus", (String) null, e11, new Object[0]);
                return;
            }
        }
        if (!z10) {
            if (networkInfo != null) {
                if (networkInfo.isConnected()) {
                    ALog.i("awcn.NetworkStatusMonitor", "checkNetworkStatus", (String) null, "info.isConnected", Boolean.valueOf(networkInfo.isConnected()), "info.isAvailable", Boolean.valueOf(networkInfo.isAvailable()), "info.getType", Integer.valueOf(networkInfo.getType()));
                    if (networkInfo.getType() == 0) {
                        String subtypeName = networkInfo.getSubtypeName();
                        String str3 = "";
                        if (!TextUtils.isEmpty(subtypeName)) {
                            str3 = subtypeName.replace(" ", str3);
                        }
                        a(a(networkInfo.getSubtype(), str3), str3);
                        f3860e = a(networkInfo.getExtraInfo());
                        h();
                    } else if (networkInfo.getType() == 1) {
                        a(NetworkStatusHelper.NetworkStatus.WIFI, "wifi");
                        if (AwcnConfig.isWifiInfoEnable() && (i10 = i()) != null && b("android.permission.ACCESS_FINE_LOCATION")) {
                            f3862g = i10.getBSSID();
                            f3861f = i10.getSSID();
                        }
                        f3863h = "wifi";
                        f3864i = "wifi";
                        f3865j = j();
                    } else {
                        a(NetworkStatusHelper.NetworkStatus.NONE, "unknown");
                    }
                    f3866k = networkInfo.isRoaming();
                    c.e();
                }
            }
            a(NetworkStatusHelper.NetworkStatus.NO, "no network");
            ALog.i("awcn.NetworkStatusMonitor", "checkNetworkStatus", (String) null, "no network");
        }
        if (f3858c != networkStatus || !f3860e.equalsIgnoreCase(str) || !f3861f.equalsIgnoreCase(str2)) {
            if (ALog.isPrintLog(2)) {
                NetworkStatusHelper.printNetworkDetail();
            }
            NetworkStatusHelper.notifyStatusChanged(f3858c);
        }
    }

    public static NetworkInfo e() {
        if (f3871p == null) {
            f3871p = (ConnectivityManager) f3856a.getSystemService("connectivity");
        }
        return f3871p.getActiveNetworkInfo();
    }

    public static String f() {
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});
            String[] strArr = f3868m;
            int length = strArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                String str = (String) method.invoke((Object) null, new Object[]{strArr[i10]});
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static int g() {
        if (f3871p == null || Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        return f3871p.getRestrictBackgroundStatus();
    }

    private static void h() {
        try {
            if (AwcnConfig.isCarrierInfoEnable() && b("android.permission.READ_PHONE_STATE")) {
                if (f3872q == null) {
                    f3872q = (TelephonyManager) f3856a.getSystemService("phone");
                }
                f3864i = f3872q.getSimOperator();
                if (Build.VERSION.SDK_INT >= 22) {
                    if (f3874s == null) {
                        SubscriptionManager a10 = SubscriptionManager.from(f3856a);
                        f3874s = a10;
                        f3875t = a10.getClass().getDeclaredMethod("getDefaultDataSubscriptionInfo", new Class[0]);
                    }
                    Method method = f3875t;
                    if (method != null) {
                        f3863h = h.a(method.invoke(f3874s, new Object[0])).getCarrierName().toString();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private static WifiInfo i() {
        try {
            if (f3873r == null) {
                f3873r = (WifiManager) f3856a.getSystemService("wifi");
            }
            return f3873r.getConnectionInfo();
        } catch (Throwable th) {
            ALog.e("awcn.NetworkStatusMonitor", "getWifiInfo", (String) null, th, new Object[0]);
            return null;
        }
    }

    private static Pair<String, Integer> j() {
        try {
            String property = System.getProperty("http.proxyHost");
            if (!TextUtils.isEmpty(property)) {
                return Pair.create(property, Integer.valueOf(Integer.parseInt(System.getProperty("http.proxyPort"))));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static boolean b(String str) {
        if (Build.VERSION.SDK_INT < 23 || f3856a.checkSelfPermission(str) != 0) {
            return false;
        }
        return true;
    }

    private static void a(NetworkStatusHelper.NetworkStatus networkStatus, String str) {
        f3858c = networkStatus;
        f3859d = str;
        f3860e = "";
        f3861f = "";
        f3862g = "";
        f3865j = null;
        f3863h = "";
        f3864i = "";
    }

    private static NetworkStatusHelper.NetworkStatus a(int i10, String str) {
        switch (i10) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return NetworkStatusHelper.NetworkStatus.G2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return NetworkStatusHelper.NetworkStatus.G3;
            case 13:
            case 18:
            case 19:
                return NetworkStatusHelper.NetworkStatus.G4;
            case 20:
                return NetworkStatusHelper.NetworkStatus.G5;
            default:
                if (str.equalsIgnoreCase("TD-SCDMA") || str.equalsIgnoreCase("WCDMA") || str.equalsIgnoreCase("CDMA2000")) {
                    return NetworkStatusHelper.NetworkStatus.G3;
                }
                return NetworkStatusHelper.NetworkStatus.NONE;
        }
    }

    private static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.contains("cmwap")) {
                return "cmwap";
            }
            if (lowerCase.contains("uniwap")) {
                return "uniwap";
            }
            if (lowerCase.contains("3gwap")) {
                return "3gwap";
            }
            if (lowerCase.contains("ctwap")) {
                return "ctwap";
            }
            if (lowerCase.contains("cmnet")) {
                return "cmnet";
            }
            if (lowerCase.contains("uninet")) {
                return "uninet";
            }
            if (lowerCase.contains("3gnet")) {
                return "3gnet";
            }
            if (lowerCase.contains("ctnet")) {
                return "ctnet";
            }
        }
        return "unknown";
    }
}
