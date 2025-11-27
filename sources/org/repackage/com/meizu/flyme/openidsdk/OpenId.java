package org.repackage.com.meizu.flyme.openidsdk;

class OpenId {

    /* renamed from: a  reason: collision with root package name */
    long f8638a;

    /* renamed from: b  reason: collision with root package name */
    String f8639b;

    /* renamed from: c  reason: collision with root package name */
    String f8640c;

    /* renamed from: d  reason: collision with root package name */
    int f8641d;

    public OpenId(String str) {
        this.f8640c = str;
    }

    public void a(int i10) {
        this.f8641d = i10;
    }

    public void b() {
        this.f8638a = 0;
    }

    public void a(long j10) {
        this.f8638a = j10;
    }

    public void a(String str) {
        this.f8639b = str;
    }

    public boolean a() {
        return this.f8638a > System.currentTimeMillis();
    }
}
