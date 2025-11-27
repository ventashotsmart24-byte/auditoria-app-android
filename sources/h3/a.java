package h3;

import java.util.concurrent.atomic.AtomicReference;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final a f6889a = null;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference f6890b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6891c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6892d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f6893e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f6894f;

    /* renamed from: g  reason: collision with root package name */
    public int f6895g;

    /* renamed from: h  reason: collision with root package name */
    public int f6896h;

    /* renamed from: i  reason: collision with root package name */
    public int f6897i;

    /* renamed from: j  reason: collision with root package name */
    public int f6898j;

    /* renamed from: k  reason: collision with root package name */
    public int f6899k;

    /* renamed from: h3.a$a  reason: collision with other inner class name */
    public static final class C0087a {

        /* renamed from: a  reason: collision with root package name */
        public final int f6900a;

        /* renamed from: b  reason: collision with root package name */
        public final int f6901b;

        /* renamed from: c  reason: collision with root package name */
        public final int f6902c;

        /* renamed from: d  reason: collision with root package name */
        public final int[] f6903d;

        /* renamed from: e  reason: collision with root package name */
        public final String[] f6904e;

        /* renamed from: f  reason: collision with root package name */
        public final int f6905f;

        /* renamed from: g  reason: collision with root package name */
        public final int f6906g;

        public C0087a(int i10, int i11, int i12, int[] iArr, String[] strArr, int i13, int i14) {
            this.f6900a = i10;
            this.f6901b = i11;
            this.f6902c = i12;
            this.f6903d = iArr;
            this.f6904e = strArr;
            this.f6905f = i13;
            this.f6906g = i14;
        }

        public static C0087a a(int i10) {
            int i11 = i10 << 3;
            return new C0087a(i10, 0, a.a(i10), new int[i11], new String[(i10 << 1)], i11 - i10, i11);
        }
    }

    public a(int i10, boolean z10, int i11, boolean z11) {
        this.f6891c = i11;
        this.f6892d = z10;
        this.f6893e = z11;
        int i12 = 16;
        if (i10 < 16) {
            i10 = 16;
        } else if (((i10 - 1) & i10) != 0) {
            while (i12 < i10) {
                i12 += i12;
            }
            i10 = i12;
        }
        this.f6890b = new AtomicReference(C0087a.a(i10));
    }

    public static int a(int i10) {
        int i11 = i10 >> 2;
        if (i11 < 64) {
            return 4;
        }
        if (i11 <= 256) {
            return 5;
        }
        return i11 <= 1024 ? 6 : 7;
    }

    public static a c() {
        long currentTimeMillis = System.currentTimeMillis();
        return d((((int) currentTimeMillis) + ((int) (currentTimeMillis >>> 32))) | 1);
    }

    public static a d(int i10) {
        return new a(64, true, i10, true);
    }

    public final int b() {
        int i10 = this.f6895g;
        return (i10 << 3) - i10;
    }

    public int e() {
        int i10 = this.f6896h;
        int i11 = 0;
        for (int i12 = 3; i12 < i10; i12 += 4) {
            if (this.f6894f[i12] != 0) {
                i11++;
            }
        }
        return i11;
    }

    public int f() {
        int i10 = this.f6897i;
        int i11 = 0;
        for (int i12 = this.f6896h + 3; i12 < i10; i12 += 4) {
            if (this.f6894f[i12] != 0) {
                i11++;
            }
        }
        return i11;
    }

    public int g() {
        return (this.f6899k - b()) >> 2;
    }

    public int h() {
        int i10 = this.f6897i + 3;
        int i11 = this.f6895g + i10;
        int i12 = 0;
        while (i10 < i11) {
            if (this.f6894f[i10] != 0) {
                i12++;
            }
            i10 += 4;
        }
        return i12;
    }

    public int i() {
        int i10 = this.f6895g << 3;
        int i11 = 0;
        for (int i12 = 3; i12 < i10; i12 += 4) {
            if (this.f6894f[i12] != 0) {
                i11++;
            }
        }
        return i11;
    }

    public String toString() {
        int e10 = e();
        int f10 = f();
        int h10 = h();
        int g10 = g();
        return String.format("[%s: size=%d, hashSize=%d, %d/%d/%d/%d pri/sec/ter/spill (=%s), total:%d]", new Object[]{a.class.getName(), Integer.valueOf(this.f6898j), Integer.valueOf(this.f6895g), Integer.valueOf(e10), Integer.valueOf(f10), Integer.valueOf(h10), Integer.valueOf(g10), Integer.valueOf(e10 + f10 + h10 + g10), Integer.valueOf(i())});
    }
}
