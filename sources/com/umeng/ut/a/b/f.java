package com.umeng.ut.a.b;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

class f implements X509TrustManager {

    /* renamed from: a  reason: collision with root package name */
    private static TrustManager[] f16224a;

    public static synchronized TrustManager[] getTrustManagers() {
        TrustManager[] trustManagerArr;
        synchronized (f.class) {
            if (f16224a == null) {
                f16224a = new TrustManager[]{new f()};
            }
            trustManagerArr = f16224a;
        }
        return trustManagerArr;
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (x509CertificateArr == null || x509CertificateArr.length <= 0) {
            throw new IllegalArgumentException("checkServerTrusted: X509Certificate array is null");
        }
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            instance.init((KeyStore) null);
            if (instance.getTrustManagers() != null) {
                TrustManager[] trustManagers = instance.getTrustManagers();
                int length = trustManagers.length;
                int i10 = 0;
                while (i10 < length) {
                    try {
                        ((X509TrustManager) trustManagers[i10]).checkServerTrusted(x509CertificateArr, str);
                        i10++;
                    } catch (CertificateException e10) {
                        Throwable th = e10;
                        while (th != null) {
                            if (!(th instanceof CertificateExpiredException) && !(th instanceof CertificateNotYetValidException)) {
                                th = th.getCause();
                            } else {
                                return;
                            }
                        }
                        throw e10;
                    }
                }
            }
        } catch (NoSuchAlgorithmException e11) {
            throw new CertificateException(e11);
        } catch (KeyStoreException e12) {
            throw new CertificateException(e12);
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
