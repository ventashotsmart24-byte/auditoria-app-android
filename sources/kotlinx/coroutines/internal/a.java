package kotlinx.coroutines.internal;

import i9.f;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public Object[] f18244a = new Object[16];

    /* renamed from: b  reason: collision with root package name */
    public int f18245b;

    /* renamed from: c  reason: collision with root package name */
    public int f18246c;

    public final void a(Object obj) {
        Object[] objArr = this.f18244a;
        int i10 = this.f18246c;
        objArr[i10] = obj;
        int length = (objArr.length - 1) & (i10 + 1);
        this.f18246c = length;
        if (length == this.f18245b) {
            b();
        }
    }

    public final void b() {
        Object[] objArr = this.f18244a;
        int length = objArr.length;
        Object[] objArr2 = new Object[(length << 1)];
        Object[] objArr3 = objArr2;
        f.c(objArr, objArr3, 0, this.f18245b, 0, 10, (Object) null);
        Object[] objArr4 = this.f18244a;
        int length2 = objArr4.length;
        int i10 = this.f18245b;
        f.c(objArr4, objArr2, length2 - i10, 0, i10, 4, (Object) null);
        this.f18244a = objArr3;
        this.f18245b = 0;
        this.f18246c = length;
    }

    public final boolean c() {
        if (this.f18245b == this.f18246c) {
            return true;
        }
        return false;
    }

    public final Object d() {
        int i10 = this.f18245b;
        if (i10 == this.f18246c) {
            return null;
        }
        Object[] objArr = this.f18244a;
        Object obj = objArr[i10];
        objArr[i10] = null;
        this.f18245b = (i10 + 1) & (objArr.length - 1);
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
    }
}
