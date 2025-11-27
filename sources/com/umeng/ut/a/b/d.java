package com.umeng.ut.a.b;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

class d implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public String f16221a;

    public d(String str) {
        this.f16221a = str;
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.f16221a) || !(obj instanceof d)) {
            return false;
        }
        String str = ((d) obj).f16221a;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f16221a.equals(str);
    }

    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f16221a, sSLSession);
    }
}
