package z8;

import z8.c0;

public abstract class y0 implements c0.g {

    /* renamed from: a  reason: collision with root package name */
    public static final Throwable f21179a = a();

    public static Throwable a() {
        try {
            Class.forName("javax.naming.directory.InitialDirContext");
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
            return null;
        } catch (ClassNotFoundException e10) {
            return e10;
        } catch (RuntimeException e11) {
            return e11;
        } catch (Error e12) {
            return e12;
        }
    }
}
