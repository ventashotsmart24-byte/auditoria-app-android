package com.hpplay.a.a.a.d;

import java.io.IOException;
import java.net.ServerSocket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class b implements com.hpplay.a.b.b<ServerSocket, IOException> {

    /* renamed from: a  reason: collision with root package name */
    private SSLServerSocketFactory f10518a;

    /* renamed from: b  reason: collision with root package name */
    private String[] f10519b;

    public b(SSLServerSocketFactory sSLServerSocketFactory, String[] strArr) {
        this.f10518a = sSLServerSocketFactory;
        this.f10519b = strArr;
    }

    /* renamed from: a */
    public ServerSocket b() {
        SSLServerSocket sSLServerSocket = (SSLServerSocket) this.f10518a.createServerSocket();
        String[] strArr = this.f10519b;
        if (strArr != null) {
            sSLServerSocket.setEnabledProtocols(strArr);
        } else {
            sSLServerSocket.setEnabledProtocols(sSLServerSocket.getSupportedProtocols());
        }
        sSLServerSocket.setUseClientMode(false);
        sSLServerSocket.setWantClientAuth(false);
        sSLServerSocket.setNeedClientAuth(false);
        return sSLServerSocket;
    }
}
