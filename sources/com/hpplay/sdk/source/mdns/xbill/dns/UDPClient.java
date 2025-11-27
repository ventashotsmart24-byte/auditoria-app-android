package com.hpplay.sdk.source.mdns.xbill.dns;

import java.io.EOFException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.security.SecureRandom;

final class UDPClient extends Client {
    private static final int EPHEMERAL_RANGE = 64511;
    private static final int EPHEMERAL_START = 1024;
    private static final int EPHEMERAL_STOP = 65535;
    private static final String TAG = "UDPClient";
    private static SecureRandom prng = new SecureRandom();
    private static volatile boolean prng_initializing = true;
    private boolean bound = false;

    public UDPClient(long j10) {
        super(DatagramChannel.open(), j10);
    }

    private void bind_random(InetSocketAddress inetSocketAddress) {
        InetSocketAddress inetSocketAddress2;
        if (prng_initializing) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException unused) {
            }
            if (prng_initializing) {
                return;
            }
        }
        DatagramChannel datagramChannel = (DatagramChannel) this.key.channel();
        int i10 = 0;
        while (i10 < 1024) {
            try {
                int nextInt = prng.nextInt(EPHEMERAL_RANGE) + 1024;
                if (inetSocketAddress != null) {
                    inetSocketAddress2 = new InetSocketAddress(inetSocketAddress.getAddress(), nextInt);
                } else {
                    inetSocketAddress2 = new InetSocketAddress(nextInt);
                }
                datagramChannel.socket().bind(inetSocketAddress2);
                this.bound = true;
                return;
            } catch (SocketException unused2) {
                i10++;
            }
        }
    }

    public static byte[] sendrecv(SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr, int i10, long j10) {
        UDPClient uDPClient = new UDPClient(j10);
        try {
            uDPClient.bind(socketAddress);
            uDPClient.connect(socketAddress2);
            uDPClient.send(bArr);
            return uDPClient.recv(i10);
        } finally {
            uDPClient.cleanup();
        }
    }

    public void bind(SocketAddress socketAddress) {
        if (socketAddress == null || ((socketAddress instanceof InetSocketAddress) && ((InetSocketAddress) socketAddress).getPort() == 0)) {
            bind_random((InetSocketAddress) socketAddress);
            if (this.bound) {
                return;
            }
        }
        if (socketAddress != null) {
            ((DatagramChannel) this.key.channel()).socket().bind(socketAddress);
            this.bound = true;
        }
    }

    public void connect(SocketAddress socketAddress) {
        if (!this.bound) {
            bind((SocketAddress) null);
        }
        ((DatagramChannel) this.key.channel()).connect(socketAddress);
    }

    public byte[] recv(int i10) {
        DatagramChannel datagramChannel = (DatagramChannel) this.key.channel();
        byte[] bArr = new byte[i10];
        this.key.interestOps(1);
        while (!this.key.isReadable()) {
            try {
                Client.blockUntil(this.key, this.endTime);
            } finally {
                if (this.key.isValid()) {
                    this.key.interestOps(0);
                }
            }
        }
        long read = (long) datagramChannel.read(ByteBuffer.wrap(bArr));
        if (read > 0) {
            int i11 = (int) read;
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, 0, bArr2, 0, i11);
            return bArr2;
        }
        throw new EOFException();
    }

    public void send(byte[] bArr) {
        try {
            ((DatagramChannel) this.key.channel()).write(ByteBuffer.wrap(bArr));
        } catch (Exception e10) {
            StringBuilder sb = new StringBuilder();
            sb.append(" udp client + ");
            sb.append(e10.toString());
        }
    }
}
