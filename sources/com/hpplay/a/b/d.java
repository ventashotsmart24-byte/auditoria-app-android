package com.hpplay.a.b;

import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f10531a = Logger.getLogger(d.class.getName());

    public static void a(com.hpplay.a.a.a.d dVar) {
        try {
            dVar.start(com.hpplay.a.a.a.d.SOCKET_READ_TIMEOUT, false);
        } catch (IOException e10) {
            PrintStream printStream = System.err;
            printStream.println("Couldn't start server:\n" + e10);
            System.exit(-1);
        }
        System.out.println("Server started, Hit Enter to stop.\n");
        try {
            System.in.read();
        } catch (Throwable unused) {
        }
        dVar.stop();
        System.out.println("Server stopped.\n");
    }

    public static <T extends com.hpplay.a.a.a.d> void a(Class<T> cls) {
        try {
            a((com.hpplay.a.a.a.d) cls.newInstance());
        } catch (Exception e10) {
            f10531a.log(Level.SEVERE, "Could not create server", e10);
        }
    }
}
