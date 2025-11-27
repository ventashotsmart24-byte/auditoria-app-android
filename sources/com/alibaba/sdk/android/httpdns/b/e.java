package com.alibaba.sdk.android.httpdns.b;

import java.util.ArrayList;
import java.util.Iterator;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f4924a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<g> f7a;

    /* renamed from: b  reason: collision with root package name */
    public String f4925b;

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<g> f8b;
    public String host;
    public long id;

    /* renamed from: m  reason: collision with root package name */
    public String f4926m;

    /* renamed from: n  reason: collision with root package name */
    public String f4927n;

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("[HostRecord] ");
        sb.append("id:");
        sb.append(this.id);
        sb.append("|");
        sb.append("host:");
        sb.append(this.host);
        sb.append("|");
        sb.append("sp:");
        sb.append(this.f4926m);
        sb.append("|");
        sb.append("time:");
        sb.append(this.f4927n);
        sb.append("|");
        sb.append("ips:");
        ArrayList<g> arrayList = this.f7a;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<g> it = this.f7a.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
        }
        sb.append("|");
        sb.append("ipsv6:");
        ArrayList<g> arrayList2 = this.f8b;
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<g> it2 = this.f8b.iterator();
            while (it2.hasNext()) {
                sb.append(it2.next());
            }
        }
        sb.append("|");
        sb.append("extra:");
        sb.append(this.f4924a);
        sb.append("|");
        sb.append("cacheKey:");
        sb.append(this.f4925b);
        sb.append("|");
        return sb.toString();
    }
}
