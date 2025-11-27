package com.qiniu.android.dns;

public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f12873c = new a(C0191a.NO_NETWORK, 0);

    /* renamed from: d  reason: collision with root package name */
    public static final a f12874d = new a(C0191a.WIFI, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f12875a;

    /* renamed from: b  reason: collision with root package name */
    public final C0191a f12876b;

    /* renamed from: com.qiniu.android.dns.a$a  reason: collision with other inner class name */
    public enum C0191a {
        NO_NETWORK,
        WIFI,
        MOBILE
    }

    public a(C0191a aVar, int i10) {
        this.f12876b = aVar;
        this.f12875a = i10;
    }
}
