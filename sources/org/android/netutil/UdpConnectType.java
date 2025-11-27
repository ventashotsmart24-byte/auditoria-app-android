package org.android.netutil;

public class UdpConnectType {
    private static native int nativeTestUdpConnectIpv4();

    private static native int nativeTestUdpConnectIpv6();

    public static boolean testUdpConnectIpv4() {
        if (nativeTestUdpConnectIpv4() != 0) {
            return true;
        }
        return false;
    }

    public static boolean testUdpConnectIpv6() {
        if (nativeTestUdpConnectIpv6() != 0) {
            return true;
        }
        return false;
    }
}
