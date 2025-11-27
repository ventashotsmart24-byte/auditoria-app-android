package com.hpplay.sdk.source.mdns.net;

import com.hpplay.sdk.source.mdns.xbill.dns.Options;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetAddress;

public abstract class NetworkProcessor implements Closeable, Runnable {
    public static final int AVERAGE_QUEUE_THRESHOLD = 2;
    public static final int DEFAULT_MTU = 1500;
    public static final int MAX_QUEUE_THRESHOLD = 10;
    public static final int PACKET_MONITOR_NO_PACKET_RECEIVED_TIMEOUT = 100000;
    public static final String TAG = "NetworkProcessor";
    protected InetAddress address;
    protected transient boolean exit;
    protected InetAddress ifaceAddress;
    protected boolean ipv6;
    protected boolean isClose;
    protected PacketListener listener;
    protected int mtu = 1500;
    protected NetworkReadThread networkReadThread;
    protected int port;
    protected boolean threadMonitoring;

    public NetworkProcessor(InetAddress inetAddress, InetAddress inetAddress2, int i10, PacketListener packetListener) {
        boolean z10 = false;
        this.exit = false;
        this.networkReadThread = null;
        this.isClose = false;
        this.threadMonitoring = Options.check("mdns_network_thread_monitor");
        setInterfaceAddress(inetAddress);
        this.address = inetAddress2;
        setPort(i10);
        if (inetAddress.getAddress().length == inetAddress2.getAddress().length) {
            this.ipv6 = inetAddress2.getAddress().length > 4 ? true : z10;
            this.listener = packetListener;
            return;
        }
        throw new IOException("Interface Address and bind address bust be the same IP specifciation!");
    }

    public synchronized void close() {
        this.exit = true;
        this.isClose = true;
        NetworkReadThread networkReadThread2 = this.networkReadThread;
        if (networkReadThread2 != null) {
            networkReadThread2.interrupt();
        }
    }

    public InetAddress getAddress() {
        return this.address;
    }

    public InetAddress getInterfaceAddress() {
        return this.ifaceAddress;
    }

    public int getMTU() {
        return this.mtu;
    }

    public int getPort() {
        return this.port;
    }

    public boolean isIPv4() {
        return !this.ipv6;
    }

    public boolean isIPv6() {
        return this.ipv6;
    }

    public boolean isOperational() {
        return !this.exit;
    }

    public abstract void send(byte[] bArr);

    public void setInterfaceAddress(InetAddress inetAddress) {
        this.ifaceAddress = inetAddress;
    }

    public void setPort(int i10) {
        this.port = i10;
    }

    public synchronized void start() {
        this.exit = false;
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------ > >>> >>> NetworkProcessor   run");
        sb.append(this.threadMonitoring);
        NetworkReadThread networkReadThread2 = new NetworkReadThread(this);
        this.networkReadThread = networkReadThread2;
        networkReadThread2.start();
    }
}
