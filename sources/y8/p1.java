package y8;

import java.util.logging.Level;
import java.util.logging.Logger;
import y8.r;

public final class p1 extends r.c {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f20144a = Logger.getLogger(p1.class.getName());

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal f20145b = new ThreadLocal();

    public r a() {
        r rVar = (r) f20145b.get();
        if (rVar == null) {
            return r.f20158c;
        }
        return rVar;
    }

    public void b(r rVar, r rVar2) {
        if (a() != rVar) {
            f20144a.log(Level.SEVERE, "Context was not attached when detaching", new Throwable().fillInStackTrace());
        }
        if (rVar2 != r.f20158c) {
            f20145b.set(rVar2);
        } else {
            f20145b.set((Object) null);
        }
    }

    public r c(r rVar) {
        r a10 = a();
        f20145b.set(rVar);
        return a10;
    }
}
