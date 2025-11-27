package d4;

import java.lang.reflect.Array;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public b f6247a = null;

    /* renamed from: b  reason: collision with root package name */
    public C0078c f6248b = null;

    /* renamed from: c  reason: collision with root package name */
    public h f6249c = null;

    /* renamed from: d  reason: collision with root package name */
    public f f6250d = null;

    /* renamed from: e  reason: collision with root package name */
    public g f6251e = null;

    /* renamed from: f  reason: collision with root package name */
    public e f6252f = null;

    /* renamed from: g  reason: collision with root package name */
    public d f6253g = null;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Class f6254a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f6255b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f6256c;

        public a(Class cls, int i10, Object obj) {
            this.f6254a = cls;
            this.f6255b = i10;
            this.f6256c = obj;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!h.H(obj, this.f6254a) || Array.getLength(obj) != this.f6255b) {
                return false;
            }
            for (int i10 = 0; i10 < this.f6255b; i10++) {
                Object obj2 = Array.get(this.f6256c, i10);
                Object obj3 = Array.get(obj, i10);
                if (obj2 != obj3 && obj2 != null && !obj2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static final class b extends t {
        /* renamed from: g */
        public final boolean[] a(int i10) {
            return new boolean[i10];
        }
    }

    /* renamed from: d4.c$c  reason: collision with other inner class name */
    public static final class C0078c extends t {
        /* renamed from: g */
        public final byte[] a(int i10) {
            return new byte[i10];
        }
    }

    public static final class d extends t {
        /* renamed from: g */
        public final double[] a(int i10) {
            return new double[i10];
        }
    }

    public static final class e extends t {
        /* renamed from: g */
        public final float[] a(int i10) {
            return new float[i10];
        }
    }

    public static final class f extends t {
        /* renamed from: g */
        public final int[] a(int i10) {
            return new int[i10];
        }
    }

    public static final class g extends t {
        /* renamed from: g */
        public final long[] a(int i10) {
            return new long[i10];
        }
    }

    public static final class h extends t {
        /* renamed from: g */
        public final short[] a(int i10) {
            return new short[i10];
        }
    }

    public static Object a(Object obj) {
        return new a(obj.getClass(), Array.getLength(obj), obj);
    }

    public static Object[] i(Object[] objArr, Object obj) {
        int length = objArr.length;
        int i10 = 0;
        while (i10 < length) {
            if (objArr[i10] != obj) {
                i10++;
            } else if (i10 == 0) {
                return objArr;
            } else {
                Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), length);
                System.arraycopy(objArr, 0, objArr2, 1, i10);
                objArr2[0] = obj;
                int i11 = i10 + 1;
                int i12 = length - i11;
                if (i12 > 0) {
                    System.arraycopy(objArr, i11, objArr2, i11, i12);
                }
                return objArr2;
            }
        }
        Object[] objArr3 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), length + 1);
        if (length > 0) {
            System.arraycopy(objArr, 0, objArr3, 1, length);
        }
        objArr3[0] = obj;
        return objArr3;
    }

    public b b() {
        if (this.f6247a == null) {
            this.f6247a = new b();
        }
        return this.f6247a;
    }

    public C0078c c() {
        if (this.f6248b == null) {
            this.f6248b = new C0078c();
        }
        return this.f6248b;
    }

    public d d() {
        if (this.f6253g == null) {
            this.f6253g = new d();
        }
        return this.f6253g;
    }

    public e e() {
        if (this.f6252f == null) {
            this.f6252f = new e();
        }
        return this.f6252f;
    }

    public f f() {
        if (this.f6250d == null) {
            this.f6250d = new f();
        }
        return this.f6250d;
    }

    public g g() {
        if (this.f6251e == null) {
            this.f6251e = new g();
        }
        return this.f6251e;
    }

    public h h() {
        if (this.f6249c == null) {
            this.f6249c = new h();
        }
        return this.f6249c;
    }
}
