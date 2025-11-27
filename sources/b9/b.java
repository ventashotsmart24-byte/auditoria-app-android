package b9;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final a[] f11261e;

    /* renamed from: f  reason: collision with root package name */
    public static final b f11262f;

    /* renamed from: g  reason: collision with root package name */
    public static final b f11263g;

    /* renamed from: h  reason: collision with root package name */
    public static final b f11264h = new C0149b(false).e();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f11265a;

    /* renamed from: b  reason: collision with root package name */
    public final String[] f11266b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f11267c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f11268d;

    static {
        a[] aVarArr = {a.TLS_AES_128_GCM_SHA256, a.TLS_AES_256_GCM_SHA384, a.TLS_CHACHA20_POLY1305_SHA256, a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, a.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, a.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, a.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, a.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, a.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, a.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, a.TLS_RSA_WITH_AES_128_GCM_SHA256, a.TLS_RSA_WITH_AES_256_GCM_SHA384, a.TLS_RSA_WITH_AES_128_CBC_SHA, a.TLS_RSA_WITH_AES_256_CBC_SHA, a.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        f11261e = aVarArr;
        C0149b f10 = new C0149b(true).f(aVarArr);
        k kVar = k.TLS_1_3;
        k kVar2 = k.TLS_1_2;
        b e10 = f10.i(kVar, kVar2).h(true).e();
        f11262f = e10;
        f11263g = new C0149b(e10).i(kVar, kVar2, k.TLS_1_1, k.TLS_1_0).h(true).e();
    }

    public void c(SSLSocket sSLSocket, boolean z10) {
        b e10 = e(sSLSocket, z10);
        sSLSocket.setEnabledProtocols(e10.f11267c);
        String[] strArr = e10.f11266b;
        if (strArr != null) {
            sSLSocket.setEnabledCipherSuites(strArr);
        }
    }

    public List d() {
        String[] strArr = this.f11266b;
        if (strArr == null) {
            return null;
        }
        a[] aVarArr = new a[strArr.length];
        int i10 = 0;
        while (true) {
            String[] strArr2 = this.f11266b;
            if (i10 >= strArr2.length) {
                return l.a(aVarArr);
            }
            aVarArr[i10] = a.a(strArr2[i10]);
            i10++;
        }
    }

    public final b e(SSLSocket sSLSocket, boolean z10) {
        String[] strArr;
        Class<String> cls = String.class;
        if (this.f11266b != null) {
            strArr = (String[]) l.c(cls, this.f11266b, sSLSocket.getEnabledCipherSuites());
        } else {
            strArr = null;
        }
        if (z10 && Arrays.asList(sSLSocket.getSupportedCipherSuites()).contains("TLS_FALLBACK_SCSV")) {
            if (strArr == null) {
                strArr = sSLSocket.getEnabledCipherSuites();
            }
            int length = strArr.length + 1;
            String[] strArr2 = new String[length];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            strArr2[length - 1] = "TLS_FALLBACK_SCSV";
            strArr = strArr2;
        }
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        return new C0149b(this).g(strArr).j((String[]) l.c(cls, this.f11267c, enabledProtocols)).e();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        b bVar = (b) obj;
        boolean z10 = this.f11265a;
        if (z10 != bVar.f11265a) {
            return false;
        }
        if (!z10 || (Arrays.equals(this.f11266b, bVar.f11266b) && Arrays.equals(this.f11267c, bVar.f11267c) && this.f11268d == bVar.f11268d)) {
            return true;
        }
        return false;
    }

    public boolean f() {
        return this.f11268d;
    }

    public List g() {
        k[] kVarArr = new k[this.f11267c.length];
        int i10 = 0;
        while (true) {
            String[] strArr = this.f11267c;
            if (i10 >= strArr.length) {
                return l.a(kVarArr);
            }
            kVarArr[i10] = k.a(strArr[i10]);
            i10++;
        }
    }

    public int hashCode() {
        if (this.f11265a) {
            return ((((527 + Arrays.hashCode(this.f11266b)) * 31) + Arrays.hashCode(this.f11267c)) * 31) + (this.f11268d ^ true ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        String str;
        if (!this.f11265a) {
            return "ConnectionSpec()";
        }
        List d10 = d();
        if (d10 == null) {
            str = "[use default]";
        } else {
            str = d10.toString();
        }
        return "ConnectionSpec(cipherSuites=" + str + ", tlsVersions=" + g() + ", supportsTlsExtensions=" + this.f11268d + ")";
    }

    /* renamed from: b9.b$b  reason: collision with other inner class name */
    public static final class C0149b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f11269a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f11270b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f11271c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f11272d;

        public C0149b(boolean z10) {
            this.f11269a = z10;
        }

        public b e() {
            return new b(this);
        }

        public C0149b f(a... aVarArr) {
            if (this.f11269a) {
                String[] strArr = new String[aVarArr.length];
                for (int i10 = 0; i10 < aVarArr.length; i10++) {
                    strArr[i10] = aVarArr[i10].f11260a;
                }
                this.f11270b = strArr;
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public C0149b g(String... strArr) {
            if (this.f11269a) {
                if (strArr == null) {
                    this.f11270b = null;
                } else {
                    this.f11270b = (String[]) strArr.clone();
                }
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public C0149b h(boolean z10) {
            if (this.f11269a) {
                this.f11272d = z10;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public C0149b i(k... kVarArr) {
            if (!this.f11269a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (kVarArr.length != 0) {
                String[] strArr = new String[kVarArr.length];
                for (int i10 = 0; i10 < kVarArr.length; i10++) {
                    strArr[i10] = kVarArr[i10].f11327a;
                }
                this.f11271c = strArr;
                return this;
            } else {
                throw new IllegalArgumentException("At least one TlsVersion is required");
            }
        }

        public C0149b j(String... strArr) {
            if (this.f11269a) {
                if (strArr == null) {
                    this.f11271c = null;
                } else {
                    this.f11271c = (String[]) strArr.clone();
                }
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public C0149b(b bVar) {
            this.f11269a = bVar.f11265a;
            this.f11270b = bVar.f11266b;
            this.f11271c = bVar.f11267c;
            this.f11272d = bVar.f11268d;
        }
    }

    public b(C0149b bVar) {
        this.f11265a = bVar.f11269a;
        this.f11266b = bVar.f11270b;
        this.f11267c = bVar.f11271c;
        this.f11268d = bVar.f11272d;
    }
}
