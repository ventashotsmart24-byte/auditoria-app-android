package com.hpplay.a.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;

public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private d f10520a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10521b;

    /* renamed from: c  reason: collision with root package name */
    private IOException f10522c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10523d = false;

    /* renamed from: e  reason: collision with root package name */
    private a f10524e;

    public interface a {
        void a();

        void b();
    }

    public e(d dVar, int i10) {
        this.f10520a = dVar;
        this.f10521b = i10;
    }

    public void a(a aVar) {
        this.f10524e = aVar;
    }

    public boolean b() {
        return this.f10523d;
    }

    public void run() {
        InetSocketAddress inetSocketAddress;
        try {
            ServerSocket myServerSocket = this.f10520a.getMyServerSocket();
            if (this.f10520a.hostname != null) {
                d dVar = this.f10520a;
                inetSocketAddress = new InetSocketAddress(dVar.hostname, dVar.myPort);
            } else {
                inetSocketAddress = new InetSocketAddress(this.f10520a.myPort);
            }
            myServerSocket.bind(inetSocketAddress);
            this.f10523d = true;
            a aVar = this.f10524e;
            if (aVar != null) {
                aVar.a();
            }
            do {
                try {
                    Socket accept = this.f10520a.getMyServerSocket().accept();
                    int i10 = this.f10521b;
                    if (i10 > 0) {
                        accept.setSoTimeout(i10);
                    }
                    InputStream inputStream = accept.getInputStream();
                    d dVar2 = this.f10520a;
                    dVar2.asyncRunner.b(dVar2.createClientHandler(accept, inputStream));
                } catch (IOException e10) {
                    d.LOG.log(Level.FINE, "Communication with the client broken", e10);
                }
            } while (!this.f10520a.getMyServerSocket().isClosed());
            a aVar2 = this.f10524e;
            if (aVar2 != null) {
                aVar2.b();
            }
        } catch (IOException e11) {
            this.f10522c = e11;
        }
    }

    public IOException a() {
        return this.f10522c;
    }
}
