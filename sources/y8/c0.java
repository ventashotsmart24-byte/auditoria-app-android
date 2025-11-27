package y8;

import com.google.common.base.Preconditions;
import java.security.cert.Certificate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class c0 {

    /* renamed from: f  reason: collision with root package name */
    public static final Logger f19969f = Logger.getLogger(c0.class.getName());

    /* renamed from: g  reason: collision with root package name */
    public static final c0 f19970g = new c0();

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentNavigableMap f19971a = new ConcurrentSkipListMap();

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentNavigableMap f19972b = new ConcurrentSkipListMap();

    /* renamed from: c  reason: collision with root package name */
    public final ConcurrentMap f19973c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public final ConcurrentMap f19974d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    public final ConcurrentMap f19975e = new ConcurrentHashMap();

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final c f19976a;

        public b(c cVar) {
            this.f19976a = (c) Preconditions.checkNotNull(cVar);
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f19977a;

        /* renamed from: b  reason: collision with root package name */
        public final Certificate f19978b;

        /* renamed from: c  reason: collision with root package name */
        public final Certificate f19979c;

        public c(SSLSession sSLSession) {
            Certificate certificate;
            String cipherSuite = sSLSession.getCipherSuite();
            Certificate[] localCertificates = sSLSession.getLocalCertificates();
            Certificate certificate2 = null;
            if (localCertificates != null) {
                certificate = localCertificates[0];
            } else {
                certificate = null;
            }
            try {
                Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                if (peerCertificates != null) {
                    certificate2 = peerCertificates[0];
                }
            } catch (SSLPeerUnverifiedException e10) {
                c0.f19969f.log(Level.FINE, String.format("Peer cert not available for peerHost=%s", new Object[]{sSLSession.getPeerHost()}), e10);
            }
            this.f19977a = cipherSuite;
            this.f19978b = certificate;
            this.f19979c = certificate2;
        }
    }

    public static void b(Map map, h0 h0Var) {
        h0 h0Var2 = (h0) map.put(Long.valueOf(h0Var.d().d()), h0Var);
    }

    public static long f(m0 m0Var) {
        return m0Var.d().d();
    }

    public static c0 g() {
        return f19970g;
    }

    public static void h(Map map, h0 h0Var) {
        h0 h0Var2 = (h0) map.remove(Long.valueOf(f(h0Var)));
    }

    public void c(h0 h0Var) {
        b(this.f19974d, h0Var);
    }

    public void d(h0 h0Var) {
        b(this.f19972b, h0Var);
    }

    public void e(h0 h0Var) {
        b(this.f19973c, h0Var);
    }

    public void i(h0 h0Var) {
        h(this.f19974d, h0Var);
    }

    public void j(h0 h0Var) {
        h(this.f19972b, h0Var);
    }

    public void k(h0 h0Var) {
        h(this.f19973c, h0Var);
    }
}
