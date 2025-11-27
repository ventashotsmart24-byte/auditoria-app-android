package o8;

import o8.k;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f19124a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f19125b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f19126c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f19127d;

    public /* synthetic */ e(int i10, int i11, String str, String str2) {
        this.f19124a = i10;
        this.f19125b = i11;
        this.f19126c = str;
        this.f19127d = str2;
    }

    public final void run() {
        k.a.x(this.f19124a, this.f19125b, this.f19126c, this.f19127d);
    }
}
