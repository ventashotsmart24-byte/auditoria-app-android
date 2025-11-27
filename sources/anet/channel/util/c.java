package anet.channel.util;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.NetTypeStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.android.netutil.UdpConnectType;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;

public class c {
    public static final int IPV4_ONLY = 1;
    public static final int IPV6_ONLY = 2;
    public static final int IP_DUAL_STACK = 3;
    public static final int IP_STACK_UNKNOWN = 0;

    /* renamed from: a  reason: collision with root package name */
    static final byte[][] f4009a = {new byte[]{-64, 0, 0, -86}, new byte[]{-64, 0, 0, -85}};

    /* renamed from: b  reason: collision with root package name */
    static volatile String f4010b;

    /* renamed from: c  reason: collision with root package name */
    static f f4011c;

    /* renamed from: d  reason: collision with root package name */
    static ConcurrentHashMap<String, f> f4012d = new ConcurrentHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    static ConcurrentHashMap<String, Integer> f4013e = new ConcurrentHashMap<>();

    static {
        f4010b = null;
        f4011c = null;
        try {
            f4011c = new f((Inet6Address) InetAddress.getAllByName("64:ff9b::")[0], 96);
            f4010b = b(NetworkStatusHelper.getStatus());
        } catch (Exception unused) {
        }
    }

    public static boolean a() {
        return false;
    }

    /* access modifiers changed from: private */
    public static String b(NetworkStatusHelper.NetworkStatus networkStatus) {
        if (networkStatus.isWifi()) {
            String wifiBSSID = NetworkStatusHelper.getWifiBSSID();
            if (TextUtils.isEmpty(wifiBSSID)) {
                wifiBSSID = "";
            }
            return "WIFI$" + wifiBSSID;
        } else if (!networkStatus.isMobile()) {
            return "UnknownNetwork";
        } else {
            return networkStatus.getType() + "$" + NetworkStatusHelper.getApn();
        }
    }

    public static int c() {
        Integer num = f4013e.get(f4010b);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static f d() {
        f fVar = f4012d.get(f4010b);
        if (fVar == null) {
            return f4011c;
        }
        return fVar;
    }

    public static void e() {
        if (!AwcnConfig.isIpv6Enable()) {
            ALog.e("awcn.Inet64Util", "[startIpStackDetect]ipv6Enable=false", (String) null, new Object[0]);
            return;
        }
        f4010b = b(NetworkStatusHelper.getStatus());
        if (f4013e.putIfAbsent(f4010b, 0) == null) {
            int j10 = j();
            f4013e.put(f4010b, Integer.valueOf(j10));
            NetTypeStat netTypeStat = new NetTypeStat();
            netTypeStat.ipStackType = j10;
            String str = f4010b;
            if (j10 == 2 || j10 == 3) {
                ThreadPoolExecutorFactory.submitScheduledTask(new d(str, netTypeStat), 1500, TimeUnit.MILLISECONDS);
            } else if (GlobalAppRuntimeInfo.isTargetProcess()) {
                AppMonitor.getInstance().commitStat(netTypeStat);
            }
        }
    }

    private static int h() {
        String str;
        int i10;
        TreeMap treeMap = new TreeMap();
        Iterator<T> it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
        while (true) {
            str = null;
            i10 = 0;
            if (!it.hasNext()) {
                break;
            }
            NetworkInterface networkInterface = (NetworkInterface) it.next();
            if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                String displayName = networkInterface.getDisplayName();
                ALog.i("awcn.Inet64Util", "find NetworkInterface:" + displayName, (String) null, new Object[0]);
                int i11 = 0;
                for (InterfaceAddress address : networkInterface.getInterfaceAddresses()) {
                    InetAddress address2 = address.getAddress();
                    if (address2 instanceof Inet6Address) {
                        Inet6Address inet6Address = (Inet6Address) address2;
                        if (!a((InetAddress) inet6Address)) {
                            ALog.e("awcn.Inet64Util", "Found IPv6 address:" + inet6Address.toString(), (String) null, new Object[0]);
                            i11 |= 2;
                        }
                    } else if (address2 instanceof Inet4Address) {
                        Inet4Address inet4Address = (Inet4Address) address2;
                        if (!a((InetAddress) inet4Address) && !inet4Address.getHostAddress().startsWith("192.168.43.")) {
                            ALog.e("awcn.Inet64Util", "Found IPv4 address:" + inet4Address.toString(), (String) null, new Object[0]);
                            i11 |= 1;
                        }
                    }
                }
                if (i11 != 0) {
                    treeMap.put(displayName.toLowerCase(), Integer.valueOf(i11));
                }
            }
        }
        if (treeMap.isEmpty()) {
            return 0;
        }
        if (treeMap.size() == 1) {
            return ((Integer) treeMap.firstEntry().getValue()).intValue();
        }
        if (NetworkStatusHelper.getStatus().isWifi()) {
            str = "wlan";
        } else if (NetworkStatusHelper.getStatus().isMobile()) {
            str = "rmnet";
        }
        if (str != null) {
            Iterator it2 = treeMap.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it2.next();
                if (((String) entry.getKey()).startsWith(str)) {
                    i10 = ((Integer) entry.getValue()).intValue();
                    break;
                }
            }
        }
        if (i10 != 2 || !treeMap.containsKey("v4-wlan0")) {
            return i10;
        }
        return i10 | ((Integer) treeMap.remove("v4-wlan0")).intValue();
    }

    private static int i() {
        SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        boolean testUdpConnectIpv4 = UdpConnectType.testUdpConnectIpv4();
        return UdpConnectType.testUdpConnectIpv6() ? testUdpConnectIpv4 | true ? 1 : 0 : testUdpConnectIpv4 ? 1 : 0;
    }

    /* access modifiers changed from: private */
    public static int j() {
        int i10;
        String str;
        try {
            if (AwcnConfig.isIpStackDetectByUdpConnect()) {
                str = "udp_connect";
                try {
                    i10 = i();
                } catch (Throwable th) {
                    th = th;
                    ALog.e("awcn.Inet64Util", "[detectIpStack]error.", (String) null, th, new Object[0]);
                    i10 = 0;
                    ALog.e("awcn.Inet64Util", "startIpStackDetect", (String) null, "ip stack", Integer.valueOf(i10), "detectType", str);
                    return i10;
                }
                ALog.e("awcn.Inet64Util", "startIpStackDetect", (String) null, "ip stack", Integer.valueOf(i10), "detectType", str);
                return i10;
            }
            str = "interfaces";
            i10 = h();
            ALog.e("awcn.Inet64Util", "startIpStackDetect", (String) null, "ip stack", Integer.valueOf(i10), "detectType", str);
            return i10;
        } catch (Throwable th2) {
            th = th2;
            str = null;
            ALog.e("awcn.Inet64Util", "[detectIpStack]error.", (String) null, th, new Object[0]);
            i10 = 0;
            ALog.e("awcn.Inet64Util", "startIpStackDetect", (String) null, "ip stack", Integer.valueOf(i10), "detectType", str);
            return i10;
        }
    }

    /* access modifiers changed from: private */
    public static f k() {
        InetAddress inetAddress;
        boolean z10;
        try {
            inetAddress = InetAddress.getByName("ipv4only.arpa");
        } catch (Exception unused) {
            inetAddress = null;
        }
        if (inetAddress instanceof Inet6Address) {
            ALog.i("awcn.Inet64Util", "Resolved AAAA: " + inetAddress.toString(), (String) null, new Object[0]);
            byte[] address = inetAddress.getAddress();
            if (address.length != 16) {
                return null;
            }
            int i10 = 12;
            while (true) {
                if (i10 < 0) {
                    z10 = false;
                    break;
                }
                byte b10 = address[i10];
                byte[][] bArr = f4009a;
                byte[] bArr2 = bArr[0];
                if ((b10 & bArr2[0]) != 0 && address[i10 + 1] == 0 && address[i10 + 2] == 0) {
                    byte b11 = address[i10 + 3];
                    z10 = true;
                    if (b11 == bArr2[3] || b11 == bArr[1][3]) {
                        break;
                    }
                }
                i10--;
            }
            if (z10) {
                address[i10 + 3] = 0;
                address[i10 + 2] = 0;
                address[i10 + 1] = 0;
                address[i10] = 0;
                return new f(Inet6Address.getByAddress("ipv4only.arpa", address, 0), i10 * 8);
            }
        } else if (inetAddress instanceof Inet4Address) {
            ALog.i("awcn.Inet64Util", "Resolved A: " + inetAddress.toString(), (String) null, new Object[0]);
        }
        return null;
    }

    public static String a(Inet4Address inet4Address) {
        if (inet4Address != null) {
            f d10 = d();
            if (d10 != null) {
                byte[] address = inet4Address.getAddress();
                byte[] address2 = d10.f4018b.getAddress();
                int i10 = d10.f4017a / 8;
                int i11 = 0;
                int i12 = 0;
                while (true) {
                    int i13 = i11 + i10;
                    if (i13 <= 15 && i12 < 4) {
                        if (i13 != 8) {
                            address2[i13] = (byte) (address[i12] | address2[i13]);
                            i12++;
                        }
                        i11++;
                    }
                }
                return InetAddress.getByAddress(address2).getHostAddress();
            }
            throw new Exception("cannot get nat64 prefix");
        }
        throw new InvalidParameterException("address in null");
    }

    public static boolean b() {
        Integer num = f4013e.get(f4010b);
        return num != null && num.intValue() == 1;
    }

    public static String a(String str) {
        return a((Inet4Address) InetAddress.getByName(str));
    }

    private static boolean a(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }
}
