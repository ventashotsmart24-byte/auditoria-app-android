package com.umeng.umzid;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public final class b implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f16211a;

    public b(String str) {
        this.f16211a = str;
    }

    public boolean verify(String str, SSLSession sSLSession) {
        if (!TextUtils.isEmpty(str)) {
            return this.f16211a.equalsIgnoreCase(str) || "pre-aaid.umeng.com".equalsIgnoreCase(str);
        }
        return false;
    }
}
