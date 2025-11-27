package d4;

public abstract class t {

    /* renamed from: a  reason: collision with root package name */
    public Object f6301a;

    /* renamed from: b  reason: collision with root package name */
    public a f6302b;

    /* renamed from: c  reason: collision with root package name */
    public a f6303c;

    /* renamed from: d  reason: collision with root package name */
    public int f6304d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f6305a;

        /* renamed from: b  reason: collision with root package name */
        public final int f6306b;

        /* renamed from: c  reason: collision with root package name */
        public a f6307c;

        public a(Object obj, int i10) {
            this.f6305a = obj;
            this.f6306b = i10;
        }

        public int a(Object obj, int i10) {
            System.arraycopy(this.f6305a, 0, obj, i10, this.f6306b);
            return i10 + this.f6306b;
        }

        public Object b() {
            return this.f6305a;
        }

        public void c(a aVar) {
            if (this.f6307c == null) {
                this.f6307c = aVar;
                return;
            }
            throw new IllegalStateException();
        }

        public a d() {
            return this.f6307c;
        }
    }

    public abstract Object a(int i10);

    public void b() {
        a aVar = this.f6303c;
        if (aVar != null) {
            this.f6301a = aVar.b();
        }
        this.f6303c = null;
        this.f6302b = null;
        this.f6304d = 0;
    }

    public final Object c(Object obj, int i10) {
        int i11;
        a aVar = new a(obj, i10);
        if (this.f6302b == null) {
            this.f6303c = aVar;
            this.f6302b = aVar;
        } else {
            this.f6303c.c(aVar);
            this.f6303c = aVar;
        }
        this.f6304d += i10;
        if (i10 < 16384) {
            i11 = i10 + i10;
        } else {
            i11 = i10 + (i10 >> 2);
        }
        return a(i11);
    }

    public int d() {
        return this.f6304d;
    }

    public Object e(Object obj, int i10) {
        int i11 = this.f6304d + i10;
        Object a10 = a(i11);
        int i12 = 0;
        for (a aVar = this.f6302b; aVar != null; aVar = aVar.d()) {
            i12 = aVar.a(a10, i12);
        }
        System.arraycopy(obj, 0, a10, i12, i10);
        int i13 = i12 + i10;
        if (i13 == i11) {
            return a10;
        }
        throw new IllegalStateException("Should have gotten " + i11 + " entries, got " + i13);
    }

    public Object f() {
        b();
        Object obj = this.f6301a;
        if (obj == null) {
            return a(12);
        }
        return obj;
    }
}
