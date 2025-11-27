package com.alibaba.sdk.android.httpdns.net64;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class a implements Net64Service {

    /* renamed from: a  reason: collision with root package name */
    private b f5000a;

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, List<String>> f33a;

    /* renamed from: o  reason: collision with root package name */
    private boolean f5001o;

    /* renamed from: p  reason: collision with root package name */
    private volatile boolean f5002p;

    /* renamed from: com.alibaba.sdk.android.httpdns.net64.a$a  reason: collision with other inner class name */
    public static final class C0073a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final a f5003a = new a();
    }

    private a() {
        this.f5000a = new b();
        this.f33a = new ConcurrentHashMap<>();
    }

    public static a a() {
        return C0073a.f5003a;
    }

    public void enableIPv6(boolean z10) {
        this.f5001o = z10;
    }

    public String getIPv6ByHostAsync(String str) {
        List list;
        if (this.f5001o && (list = this.f33a.get(str)) != null && list.size() > 0) {
            return (String) list.get(0);
        }
        return null;
    }

    public boolean i() {
        return this.f5002p;
    }

    public List<String> a(String str) {
        return this.f33a.get(str);
    }

    public void a(String str, List<String> list) {
        this.f33a.put(str, list);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m18a() {
        return this.f5001o;
    }
}
