package com.hpplay.sdk.source.pass.sinktouch;

import android.os.ParcelFileDescriptor;
import com.hpplay.component.protocol.ProtocolCore;
import com.hpplay.sdk.source.bean.SinkTouchEvent;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.ByteUtils;
import java.io.FileOutputStream;
import java.net.Socket;

public class SinkTouchEventTcpChannel extends ProtocolCore implements Runnable {
    private static final String TAG = "SinkTouchEventTcpChanne";
    private volatile boolean isStop = false;
    private ISinkTouchEventCallback mCallback;
    private Thread mReceiveThread;

    public SinkTouchEventTcpChannel(String str, int i10) {
        this.mIP = str;
        this.mPort = i10;
        SourceLog.i(TAG, "SinkTouchEventTcpChannel create");
    }

    private void checkOneEvent(EventBytes eventBytes) {
        if (eventBytes.isFillUp()) {
            SourceLog.i(TAG, "checkOneEvent event bytes: " + ByteUtils.bytesToHex(eventBytes.getData()));
            ISinkTouchEventCallback iSinkTouchEventCallback = this.mCallback;
            if (iSinkTouchEventCallback != null) {
                iSinkTouchEventCallback.onEventReceived(SinkTouchEvent.parseProtocolData(eventBytes.getData()));
            }
            eventBytes.reset();
        }
    }

    private void closeSocket() {
        SourceLog.i(TAG, "closeSocket: ");
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = this.mLocalAutoCloseInputStream;
        if (autoCloseInputStream != null) {
            try {
                autoCloseInputStream.close();
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        }
        FileOutputStream fileOutputStream = this.mLocalFileOutputStream;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e11) {
                SourceLog.w(TAG, (Throwable) e11);
            }
        }
        Socket socket = this.mSocket;
        if (socket != null) {
            try {
                socket.close();
            } catch (Exception e12) {
                SourceLog.w(TAG, (Throwable) e12);
            }
        }
        this.mSocket = null;
        this.mLocalFileOutputStream = null;
        this.mLocalAutoCloseInputStream = null;
    }

    private void readOnePacket(EventBytes eventBytes, byte[] bArr) {
        int read;
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = this.mLocalAutoCloseInputStream;
        if (autoCloseInputStream != null && (read = autoCloseInputStream.read(bArr)) > 0) {
            int i10 = 0;
            int i11 = read;
            while (true) {
                i11 = eventBytes.append(bArr, i10, i11);
                if (i11 > 0) {
                    i10 = read - i11;
                    checkOneEvent(eventBytes);
                } else {
                    checkOneEvent(eventBytes);
                    return;
                }
            }
        }
    }

    public void run() {
        if (this.mSocket == null) {
            try {
                connectServer();
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                return;
            }
        }
        EventBytes eventBytes = new EventBytes();
        SourceLog.w(TAG, "run: start monitor sink touch event");
        byte[] bArr = new byte[128];
        while (!this.isStop) {
            try {
                if (!this.mSocket.isClosed()) {
                    readOnePacket(eventBytes, bArr);
                } else {
                    this.isStop = true;
                }
            } catch (Exception e11) {
                SourceLog.w(TAG, (Throwable) e11);
            }
        }
        closeSocket();
    }

    public void setCallback(ISinkTouchEventCallback iSinkTouchEventCallback) {
        SourceLog.i(TAG, "setCallback callback：" + iSinkTouchEventCallback);
        this.mCallback = iSinkTouchEventCallback;
    }

    public void startReceive() {
        if (this.mReceiveThread == null) {
            SourceLog.i(TAG, "startReceive: ");
            Thread thread = new Thread(this);
            this.mReceiveThread = thread;
            thread.start();
        }
    }

    public void stopReceive() {
        this.isStop = true;
        closeSocket();
        Thread thread = this.mReceiveThread;
        if (thread != null) {
            thread.interrupt();
            this.mReceiveThread = null;
        }
    }
}
