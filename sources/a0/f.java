package a0;

public class f implements e {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f75a;

    /* renamed from: b  reason: collision with root package name */
    public int f76b;

    public f(int i10) {
        if (i10 > 0) {
            this.f75a = new Object[i10];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public final boolean a(Object obj) {
        for (int i10 = 0; i10 < this.f76b; i10++) {
            if (this.f75a[i10] == obj) {
                return true;
            }
        }
        return false;
    }

    public Object acquire() {
        int i10 = this.f76b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        Object[] objArr = this.f75a;
        Object obj = objArr[i11];
        objArr[i11] = null;
        this.f76b = i10 - 1;
        return obj;
    }

    public boolean release(Object obj) {
        if (!a(obj)) {
            int i10 = this.f76b;
            Object[] objArr = this.f75a;
            if (i10 >= objArr.length) {
                return false;
            }
            objArr[i10] = obj;
            this.f76b = i10 + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }
}
