package com.hpplay.sdk.source.mdns.xbill.dns;

import com.google.common.primitives.UnsignedBytes;
import java.io.EOFException;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

final class TCPClient extends Client {
    public TCPClient(long j10) {
        super(SocketChannel.open(), j10);
    }

    private byte[] _recv(int i10) {
        SocketChannel socketChannel = (SocketChannel) this.key.channel();
        byte[] bArr = new byte[i10];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.key.interestOps(1);
        int i11 = 0;
        while (i11 < i10) {
            try {
                if (this.key.isReadable()) {
                    long read = (long) socketChannel.read(wrap);
                    if (read >= 0) {
                        i11 += (int) read;
                        if (i11 >= i10) {
                            continue;
                        } else if (System.currentTimeMillis() > this.endTime) {
                            throw new SocketTimeoutException();
                        }
                    } else {
                        throw new EOFException();
                    }
                } else {
                    Client.blockUntil(this.key, this.endTime);
                }
            } catch (Throwable th) {
                if (this.key.isValid()) {
                    this.key.interestOps(0);
                }
                throw th;
            }
        }
        if (this.key.isValid()) {
            this.key.interestOps(0);
        }
        return bArr;
    }

    public static byte[] sendrecv(SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr, long j10) {
        TCPClient tCPClient = new TCPClient(j10);
        if (socketAddress != null) {
            try {
                tCPClient.bind(socketAddress);
            } catch (Throwable th) {
                tCPClient.cleanup();
                throw th;
            }
        }
        tCPClient.connect(socketAddress2);
        tCPClient.send(bArr);
        byte[] recv = tCPClient.recv();
        tCPClient.cleanup();
        return recv;
    }

    public void bind(SocketAddress socketAddress) {
        ((SocketChannel) this.key.channel()).socket().bind(socketAddress);
    }

    public void connect(SocketAddress socketAddress) {
        SocketChannel socketChannel = (SocketChannel) this.key.channel();
        if (!socketChannel.connect(socketAddress)) {
            this.key.interestOps(8);
            while (!socketChannel.finishConnect()) {
                try {
                    if (!this.key.isConnectable()) {
                        Client.blockUntil(this.key, this.endTime);
                    }
                } finally {
                    if (this.key.isValid()) {
                        this.key.interestOps(0);
                    }
                }
            }
        }
    }

    public byte[] recv() {
        byte[] _recv = _recv(2);
        return _recv(((_recv[0] & UnsignedBytes.MAX_VALUE) << 8) + (_recv[1] & UnsignedBytes.MAX_VALUE));
    }

    public void send(byte[] bArr) {
        SocketChannel socketChannel = (SocketChannel) this.key.channel();
        ByteBuffer[] byteBufferArr = {ByteBuffer.wrap(new byte[]{(byte) (bArr.length >>> 8), (byte) (bArr.length & 255)}), ByteBuffer.wrap(bArr)};
        this.key.interestOps(4);
        int i10 = 0;
        while (i10 < bArr.length + 2) {
            try {
                if (this.key.isWritable()) {
                    long write = socketChannel.write(byteBufferArr);
                    if (write >= 0) {
                        i10 += (int) write;
                        if (i10 >= bArr.length + 2) {
                            continue;
                        } else if (System.currentTimeMillis() > this.endTime) {
                            throw new SocketTimeoutException();
                        }
                    } else {
                        throw new EOFException();
                    }
                } else {
                    Client.blockUntil(this.key, this.endTime);
                }
            } finally {
                if (this.key.isValid()) {
                    this.key.interestOps(0);
                }
            }
        }
    }

    public static byte[] sendrecv(SocketAddress socketAddress, byte[] bArr, long j10) {
        return sendrecv((SocketAddress) null, socketAddress, bArr, j10);
    }
}
