package com.hpplay.cybergarage.http;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.util.ListenerList;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer implements Runnable {
    public static final int DEFAULT_PORT = 80;
    public static final int DEFAULT_TIMEOUT = 80000;
    public static final String NAME = "CyberHTTP";
    private static final String TAG = "Cyber-HTTPServer";
    public static final String VERSION = "1.0";
    private InetAddress bindAddr;
    private int bindPort;
    private ListenerList httpRequestListenerList;
    private Thread httpServerThread;
    private boolean isRunning;
    private ServerSocket serverSock;
    protected int timeout;

    public HTTPServer() {
        this.serverSock = null;
        this.bindAddr = null;
        this.bindPort = 0;
        this.timeout = DEFAULT_TIMEOUT;
        this.httpRequestListenerList = new ListenerList();
        this.httpServerThread = null;
        this.serverSock = null;
    }

    public static String getName() {
        String property = System.getProperty("os.name");
        String property2 = System.getProperty("os.version");
        return property + Operator.Operation.DIVISION + property2 + " " + NAME + Operator.Operation.DIVISION + "1.0";
    }

    public Socket accept() {
        ServerSocket serverSocket = this.serverSock;
        if (serverSocket == null) {
            return null;
        }
        try {
            Socket accept = serverSocket.accept();
            accept.setSoTimeout(getTimeout());
            return accept;
        } catch (Exception unused) {
            return null;
        }
    }

    public void addRequestListener(HTTPRequestListener hTTPRequestListener) {
        this.httpRequestListenerList.add(hTTPRequestListener);
    }

    public boolean close() {
        ServerSocket serverSocket = this.serverSock;
        if (serverSocket == null) {
            return true;
        }
        try {
            serverSocket.close();
            this.serverSock = null;
            this.bindAddr = null;
            this.bindPort = 0;
            return true;
        } catch (Exception e10) {
            CLog.d(TAG, (String) null, e10);
            return false;
        }
    }

    public String getBindAddress() {
        InetAddress inetAddress = this.bindAddr;
        if (inetAddress == null) {
            return "";
        }
        return inetAddress.toString();
    }

    public int getBindPort() {
        return this.bindPort;
    }

    public ServerSocket getServerSock() {
        return this.serverSock;
    }

    public synchronized int getTimeout() {
        return this.timeout;
    }

    public boolean isOpened() {
        if (this.serverSock != null) {
            return true;
        }
        return false;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public boolean open(InetAddress inetAddress, int i10) {
        if (this.serverSock != null) {
            return true;
        }
        try {
            this.serverSock = new ServerSocket(this.bindPort, 0, this.bindAddr);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public void performRequestListener(HTTPRequest hTTPRequest) {
        int size = this.httpRequestListenerList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((HTTPRequestListener) this.httpRequestListenerList.get(i10)).httpRequestRecieved(hTTPRequest);
        }
    }

    public void removeRequestListener(HTTPRequestListener hTTPRequestListener) {
        this.httpRequestListenerList.remove(hTTPRequestListener);
    }

    public void run() {
        if (isOpened()) {
            Thread currentThread = Thread.currentThread();
            while (this.httpServerThread == currentThread) {
                this.isRunning = true;
                Thread.yield();
                try {
                    CLog.d(TAG, "accept ...");
                    Socket accept = accept();
                    if (accept == null) {
                        break;
                    }
                    CLog.d(TAG, "new http connection");
                    new HTTPServerThread(this, accept).start();
                    CLog.d(TAG, "httpServThread ...");
                } catch (Exception e10) {
                    CLog.d(TAG, (String) null, e10);
                }
            }
            this.isRunning = false;
        }
    }

    public synchronized void setTimeout(int i10) {
        this.timeout = i10;
    }

    public boolean start() {
        StringBuffer stringBuffer = new StringBuffer("Cyber.HTTPServer/");
        stringBuffer.append(this.serverSock.getLocalSocketAddress());
        Thread thread = new Thread(this, stringBuffer.toString());
        this.httpServerThread = thread;
        thread.start();
        return true;
    }

    public boolean stop() {
        this.isRunning = false;
        this.httpServerThread = null;
        return true;
    }

    public boolean open(String str, int i10) {
        if (this.serverSock != null) {
            return true;
        }
        try {
            this.bindAddr = InetAddress.getByName(str);
            this.bindPort = i10;
            this.serverSock = new ServerSocket(this.bindPort, 0, this.bindAddr);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
