package b6;

import b6.r1;

public final /* synthetic */ class t1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r1 f11152a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f11153b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f11154c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f11155d;

    public /* synthetic */ t1(r1 r1Var, int i10, String str, String str2) {
        this.f11152a = r1Var;
        this.f11153b = i10;
        this.f11154c = str;
        this.f11155d = str2;
    }

    public final void run() {
        r1.c.i(this.f11152a, this.f11153b, this.f11154c, this.f11155d);
    }
}
