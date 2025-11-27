package com.umeng.analytics.pro;

import com.hpplay.a.a.a.d;

public enum bz {
    UnKnownCode(d.SOCKET_READ_TIMEOUT),
    Timeout(5001),
    NetworkUnavailable(5002),
    SSLException(5003),
    IOException(5004),
    UnKnownHostException(5005),
    HttpError(5006),
    EmptyResponse(5007),
    ErrorResponse(5008),
    ErrorMakeRequestBody(5009);
    

    /* renamed from: k  reason: collision with root package name */
    private final int f14014k;

    private bz(int i10) {
        this.f14014k = i10;
    }

    private String b() {
        return "错误码：" + this.f14014k + " 错误信息：";
    }

    public String a() {
        if (this == UnKnownCode) {
            return b() + "--未知错误--";
        } else if (this == Timeout) {
            return b() + "--连接超时--";
        } else if (this == NetworkUnavailable) {
            return b() + "--网络不可用--";
        } else if (this == SSLException) {
            return b() + "--SSL证书认证失败--";
        } else if (this == IOException) {
            return b() + "--IO异常--";
        } else if (this == HttpError) {
            return b() + "--服务端返回HTTP错误--";
        } else if (this == EmptyResponse) {
            return b() + "--服务端返回数据为空--";
        } else if (this == ErrorResponse) {
            return b() + "--服务端返回错误数据--";
        } else if (this != ErrorMakeRequestBody) {
            return "unknown";
        } else {
            return b() + "--请求报文构建错误--";
        }
    }
}
