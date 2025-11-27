package com.alibaba.sdk.android.httpdns.b;

public class g {

    /* renamed from: i  reason: collision with root package name */
    public long f4928i;
    public long id;

    /* renamed from: o  reason: collision with root package name */
    public String f4929o;

    /* renamed from: p  reason: collision with root package name */
    public String f4930p;

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("[IpRecord] ");
        sb.append("id:");
        sb.append(this.id);
        sb.append("|");
        sb.append("host_id:");
        sb.append(this.f4928i);
        sb.append("|");
        sb.append("ip:");
        sb.append(this.f4929o);
        sb.append("|");
        sb.append("ttl:");
        sb.append(this.f4930p);
        sb.append("|");
        return sb.toString();
    }
}
