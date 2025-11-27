package com.alibaba.sdk.android.httpdns.probe;

class c {
    private String hostName;
    private String[] ips;

    /* renamed from: k  reason: collision with root package name */
    private long f5013k;

    /* renamed from: l  reason: collision with root package name */
    private long f5014l;

    /* renamed from: r  reason: collision with root package name */
    private String f5015r;

    /* renamed from: s  reason: collision with root package name */
    private String f5016s;

    public c(String str, String[] strArr, String str2, String str3, long j10, long j11) {
        this.hostName = str;
        this.ips = strArr;
        this.f5015r = str2;
        this.f5016s = str3;
        this.f5013k = j10;
        this.f5014l = j11;
    }

    public long c() {
        return this.f5013k;
    }

    public long d() {
        return this.f5014l;
    }

    public String getHostName() {
        return this.hostName;
    }

    public String[] getIps() {
        return this.ips;
    }

    public String j() {
        return this.f5015r;
    }

    public String k() {
        return this.f5016s;
    }
}
