package ca;

import aa.e;
import aa.g;
import h9.a;
import h9.l;
import h9.m;
import h9.t;
import java.util.List;
import java.util.ServiceLoader;
import k9.f;

public abstract class a0 {

    /* renamed from: a  reason: collision with root package name */
    public static final List f11482a;

    static {
        Class<z> cls = z.class;
        f11482a = g.f(e.a(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
    }

    public static final void a(f fVar, Throwable th) {
        for (z y10 : f11482a) {
            try {
                y10.y(fVar, th);
            } catch (Throwable th2) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, b0.b(th, th2));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        try {
            l.a aVar = l.f17317a;
            a.a(th, new k0(fVar));
            l.a(t.f17319a);
        } catch (Throwable th3) {
            l.a aVar2 = l.f17317a;
            l.a(m.a(th3));
        }
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}
