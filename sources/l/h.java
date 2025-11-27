package l;

public class h implements g {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f7567a;

    /* renamed from: b  reason: collision with root package name */
    public int f7568b;

    public h(int i10) {
        if (i10 > 0) {
            this.f7567a = new Object[i10];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public void a(Object[] objArr, int i10) {
        if (i10 > objArr.length) {
            i10 = objArr.length;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            Object obj = objArr[i11];
            int i12 = this.f7568b;
            Object[] objArr2 = this.f7567a;
            if (i12 < objArr2.length) {
                objArr2[i12] = obj;
                this.f7568b = i12 + 1;
            }
        }
    }

    public Object acquire() {
        int i10 = this.f7568b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        Object[] objArr = this.f7567a;
        Object obj = objArr[i11];
        objArr[i11] = null;
        this.f7568b = i10 - 1;
        return obj;
    }

    public boolean release(Object obj) {
        int i10 = this.f7568b;
        Object[] objArr = this.f7567a;
        if (i10 >= objArr.length) {
            return false;
        }
        objArr[i10] = obj;
        this.f7568b = i10 + 1;
        return true;
    }
}
