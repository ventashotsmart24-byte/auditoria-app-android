package com.hpplay.a.a.a;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final d f10413a;

    /* renamed from: b  reason: collision with root package name */
    private final InputStream f10414b;

    /* renamed from: c  reason: collision with root package name */
    private final Socket f10415c;

    public a(d dVar, InputStream inputStream, Socket socket) {
        this.f10413a = dVar;
        this.f10414b = inputStream;
        this.f10415c = socket;
    }

    public void a() {
        d.safeClose(this.f10414b);
        d.safeClose(this.f10415c);
    }

    public void run() {
        OutputStream outputStream = null;
        try {
            outputStream = this.f10415c.getOutputStream();
            b bVar = new b(this.f10413a, this.f10413a.getTempFileManagerFactory().b(), this.f10414b, outputStream, this.f10415c.getInetAddress());
            while (!this.f10415c.isClosed()) {
                bVar.a();
            }
        } catch (Exception e10) {
            if ((!(e10 instanceof SocketException) || !"NanoHttpd Shutdown".equals(e10.getMessage())) && !(e10 instanceof SocketTimeoutException)) {
                d.LOG.log(Level.SEVERE, "Communication with the client broken, or an bug in the handler code", e10);
            }
        } catch (Throwable th) {
            d.safeClose((Object) null);
            d.safeClose(this.f10414b);
            d.safeClose(this.f10415c);
            this.f10413a.asyncRunner.a(this);
            throw th;
        }
        d.safeClose(outputStream);
        d.safeClose(this.f10414b);
        d.safeClose(this.f10415c);
        this.f10413a.asyncRunner.a(this);
    }
}
