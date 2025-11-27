package anet.channel.status;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import anet.channel.util.g;
import com.taobao.accs.utl.BaseMonitor;
import java.util.concurrent.CopyOnWriteArraySet;

public class NetworkStatusHelper {
    private static final String TAG = "awcn.NetworkStatusHelper";
    static CopyOnWriteArraySet<INetworkStatusChangeListener> listeners = new CopyOnWriteArraySet<>();

    public interface INetworkStatusChangeListener {
        void onNetworkStatusChanged(NetworkStatus networkStatus);
    }

    public enum NetworkStatus {
        NONE,
        NO,
        G2,
        G3,
        G4,
        WIFI,
        G5;

        public String getType() {
            if (this == G2) {
                return "2G";
            }
            if (this == G3) {
                return "3G";
            }
            if (this == G4) {
                return "4G";
            }
            if (this == G5) {
                return "5G";
            }
            return toString();
        }

        public boolean isMobile() {
            if (this == G2 || this == G3 || this == G4 || this == G5) {
                return true;
            }
            return false;
        }

        public boolean isWifi() {
            if (this == WIFI) {
                return true;
            }
            return false;
        }
    }

    public static void addStatusChangeListener(INetworkStatusChangeListener iNetworkStatusChangeListener) {
        listeners.add(iNetworkStatusChangeListener);
    }

    public static String getApn() {
        return b.f3860e;
    }

    public static String getCarrier() {
        return b.f3863h;
    }

    public static String getDnsServerAddress() {
        if (!b.f3867l.isEmpty()) {
            return b.f3867l.get(0).getHostAddress();
        }
        return b.f();
    }

    public static String getNetworkSubType() {
        return b.f3859d;
    }

    public static String getProxyType() {
        NetworkStatus networkStatus = b.f3858c;
        if (networkStatus == NetworkStatus.WIFI && getWifiProxy() != null) {
            return "proxy";
        }
        if (networkStatus.isMobile() && b.f3860e.contains("wap")) {
            return "wap";
        }
        if (!networkStatus.isMobile() || g.a() == null) {
            return "";
        }
        return BaseMonitor.ALARM_POINT_AUTH;
    }

    public static int getRestrictBackgroundStatus() {
        return b.g();
    }

    public static String getSimOp() {
        return b.f3864i;
    }

    public static NetworkStatus getStatus() {
        return b.f3858c;
    }

    public static String getUniqueId(NetworkStatus networkStatus) {
        String str = "";
        if (networkStatus.isWifi()) {
            String md5ToHex = StringUtils.md5ToHex(getWifiBSSID());
            if (!TextUtils.isEmpty(md5ToHex)) {
                str = md5ToHex;
            }
            return "WIFI$" + str;
        } else if (!networkStatus.isMobile()) {
            return str;
        } else {
            return networkStatus.getType() + "$" + getApn();
        }
    }

    public static String getWifiBSSID() {
        return b.f3862g;
    }

    public static Pair<String, Integer> getWifiProxy() {
        if (b.f3858c != NetworkStatus.WIFI) {
            return null;
        }
        return b.f3865j;
    }

    public static String getWifiSSID() {
        return b.f3861f;
    }

    public static boolean isConnected() {
        if (Build.VERSION.SDK_INT >= 24) {
            if (b.f3857b) {
                return true;
            }
        } else if (b.f3858c != NetworkStatus.NO) {
            return true;
        }
        try {
            NetworkInfo e10 = b.e();
            if (e10 == null || !e10.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean isProxy() {
        NetworkStatus networkStatus = b.f3858c;
        String str = b.f3860e;
        if (networkStatus == NetworkStatus.WIFI && getWifiProxy() != null) {
            return true;
        }
        if (!networkStatus.isMobile()) {
            return false;
        }
        if (str.contains("wap") || g.a() != null) {
            return true;
        }
        return false;
    }

    public static boolean isRoaming() {
        return b.f3866k;
    }

    public static void notifyStatusChanged(NetworkStatus networkStatus) {
        ThreadPoolExecutorFactory.submitScheduledTask(new a(networkStatus));
    }

    public static void printNetworkDetail() {
        try {
            NetworkStatus status = getStatus();
            StringBuilder sb = new StringBuilder(128);
            sb.append("\nNetwork detail*******************************\n");
            sb.append("Status: ");
            sb.append(status.getType());
            sb.append(10);
            sb.append("Subtype: ");
            sb.append(getNetworkSubType());
            sb.append(10);
            if (status != NetworkStatus.NO) {
                if (status.isMobile()) {
                    sb.append("Apn: ");
                    sb.append(getApn());
                    sb.append(10);
                    sb.append("Carrier: ");
                    sb.append(getCarrier());
                    sb.append(10);
                } else {
                    sb.append("BSSID: ");
                    sb.append(getWifiBSSID());
                    sb.append(10);
                    sb.append("SSID: ");
                    sb.append(getWifiSSID());
                    sb.append(10);
                }
            }
            if (isProxy()) {
                sb.append("Proxy: ");
                sb.append(getProxyType());
                sb.append(10);
                Pair<String, Integer> wifiProxy = getWifiProxy();
                if (wifiProxy != null) {
                    sb.append("ProxyHost: ");
                    sb.append((String) wifiProxy.first);
                    sb.append(10);
                    sb.append("ProxyPort: ");
                    sb.append(wifiProxy.second);
                    sb.append(10);
                }
            }
            sb.append("*********************************************");
            ALog.i(TAG, sb.toString(), (String) null, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public static void removeStatusChangeListener(INetworkStatusChangeListener iNetworkStatusChangeListener) {
        listeners.remove(iNetworkStatusChangeListener);
    }

    public static synchronized void startListener(Context context) {
        synchronized (NetworkStatusHelper.class) {
            if (context != null) {
                b.f3856a = context;
                b.a();
                b.c();
            } else {
                throw new NullPointerException("context is null");
            }
        }
    }

    public void stopListener(Context context) {
        b.b();
    }
}
