package h3;

import c3.f;
import j3.g;
import java.util.Arrays;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicReference;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final c f6907a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference f6908b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6909c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6910d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6911e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f6912f;

    /* renamed from: g  reason: collision with root package name */
    public a[] f6913g;

    /* renamed from: h  reason: collision with root package name */
    public int f6914h;

    /* renamed from: i  reason: collision with root package name */
    public int f6915i;

    /* renamed from: j  reason: collision with root package name */
    public int f6916j;

    /* renamed from: k  reason: collision with root package name */
    public int f6917k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f6918l;

    /* renamed from: m  reason: collision with root package name */
    public BitSet f6919m;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f6920a;

        /* renamed from: b  reason: collision with root package name */
        public final a f6921b;

        /* renamed from: c  reason: collision with root package name */
        public final int f6922c;

        public a(String str, a aVar) {
            this.f6920a = str;
            this.f6921b = aVar;
            this.f6922c = aVar != null ? 1 + aVar.f6922c : 1;
        }

        public String a(char[] cArr, int i10, int i11) {
            if (this.f6920a.length() != i11) {
                return null;
            }
            int i12 = 0;
            while (this.f6920a.charAt(i12) == cArr[i10 + i12]) {
                i12++;
                if (i12 >= i11) {
                    return this.f6920a;
                }
            }
            return null;
        }
    }

    public c(int i10) {
        this.f6907a = null;
        this.f6909c = i10;
        this.f6911e = true;
        this.f6910d = -1;
        this.f6918l = false;
        this.f6917k = 0;
        this.f6908b = new AtomicReference(b.a(64));
    }

    public static int e(int i10) {
        return i10 - (i10 >> 2);
    }

    public static c i() {
        long currentTimeMillis = System.currentTimeMillis();
        return j((((int) currentTimeMillis) + ((int) (currentTimeMillis >>> 32))) | 1);
    }

    public static c j(int i10) {
        return new c(i10);
    }

    public final String a(char[] cArr, int i10, int i11, int i12, int i13) {
        if (this.f6918l) {
            h();
            this.f6918l = false;
        } else if (this.f6914h >= this.f6915i) {
            p();
            i13 = d(g(cArr, i10, i11));
        }
        String str = new String(cArr, i10, i11);
        if (f.a.INTERN_FIELD_NAMES.d(this.f6910d)) {
            str = g.f7164b.a(str);
        }
        this.f6914h++;
        String[] strArr = this.f6912f;
        if (strArr[i13] == null) {
            strArr[i13] = str;
        } else {
            int i14 = i13 >> 1;
            a aVar = new a(str, this.f6913g[i14]);
            int i15 = aVar.f6922c;
            if (i15 > 100) {
                c(i14, aVar, i13);
            } else {
                this.f6913g[i14] = aVar;
                this.f6917k = Math.max(i15, this.f6917k);
            }
        }
        return str;
    }

    public final String b(char[] cArr, int i10, int i11, a aVar) {
        while (aVar != null) {
            String a10 = aVar.a(cArr, i10, i11);
            if (a10 != null) {
                return a10;
            }
            aVar = aVar.f6921b;
        }
        return null;
    }

    public final void c(int i10, a aVar, int i11) {
        BitSet bitSet = this.f6919m;
        if (bitSet == null) {
            BitSet bitSet2 = new BitSet();
            this.f6919m = bitSet2;
            bitSet2.set(i10);
        } else if (bitSet.get(i10)) {
            if (f.a.FAIL_ON_SYMBOL_HASH_OVERFLOW.d(this.f6910d)) {
                r(100);
            }
            this.f6911e = false;
        } else {
            this.f6919m.set(i10);
        }
        this.f6912f[i11] = aVar.f6920a;
        this.f6913g[i10] = null;
        this.f6914h -= aVar.f6922c;
        this.f6917k = -1;
    }

    public int d(int i10) {
        int i11 = i10 + (i10 >>> 15);
        int i12 = i11 ^ (i11 << 7);
        return (i12 + (i12 >>> 3)) & this.f6916j;
    }

    public int f(String str) {
        int length = str.length();
        int i10 = this.f6909c;
        for (int i11 = 0; i11 < length; i11++) {
            i10 = (i10 * 33) + str.charAt(i11);
        }
        if (i10 == 0) {
            return 1;
        }
        return i10;
    }

    public int g(char[] cArr, int i10, int i11) {
        int i12 = this.f6909c;
        int i13 = i11 + i10;
        while (i10 < i13) {
            i12 = (i12 * 33) + cArr[i10];
            i10++;
        }
        if (i12 == 0) {
            return 1;
        }
        return i12;
    }

    public final void h() {
        String[] strArr = this.f6912f;
        this.f6912f = (String[]) Arrays.copyOf(strArr, strArr.length);
        a[] aVarArr = this.f6913g;
        this.f6913g = (a[]) Arrays.copyOf(aVarArr, aVarArr.length);
    }

    public String k(char[] cArr, int i10, int i11, int i12) {
        if (i11 < 1) {
            return "";
        }
        if (!this.f6911e) {
            return new String(cArr, i10, i11);
        }
        int d10 = d(i12);
        String str = this.f6912f[d10];
        if (str != null) {
            if (str.length() == i11) {
                int i13 = 0;
                while (str.charAt(i13) == cArr[i10 + i13]) {
                    i13++;
                    if (i13 == i11) {
                        return str;
                    }
                }
            }
            a aVar = this.f6913g[d10 >> 1];
            if (aVar != null) {
                String a10 = aVar.a(cArr, i10, i11);
                if (a10 != null) {
                    return a10;
                }
                String b10 = b(cArr, i10, i11, aVar.f6921b);
                if (b10 != null) {
                    return b10;
                }
            }
        }
        return a(cArr, i10, i11, i12, d10);
    }

    public int l() {
        return this.f6909c;
    }

    public c m(int i10) {
        return new c(this, i10, this.f6909c, (b) this.f6908b.get());
    }

    public boolean n() {
        return !this.f6918l;
    }

    public final void o(b bVar) {
        int i10 = bVar.f6923a;
        b bVar2 = (b) this.f6908b.get();
        if (i10 != bVar2.f6923a) {
            if (i10 > 12000) {
                bVar = b.a(64);
            }
            b.a(this.f6908b, bVar2, bVar);
        }
    }

    public final void p() {
        int i10 = r1 + r1;
        if (i10 > 65536) {
            this.f6914h = 0;
            this.f6911e = false;
            this.f6912f = new String[64];
            this.f6913g = new a[32];
            this.f6916j = 63;
            this.f6918l = false;
            return;
        }
        a[] aVarArr = this.f6913g;
        this.f6912f = new String[i10];
        this.f6913g = new a[(i10 >> 1)];
        this.f6916j = i10 - 1;
        this.f6915i = e(i10);
        int i11 = 0;
        int i12 = 0;
        for (String str : this.f6912f) {
            if (str != null) {
                i11++;
                int d10 = d(f(str));
                String[] strArr = this.f6912f;
                if (strArr[d10] == null) {
                    strArr[d10] = str;
                } else {
                    int i13 = d10 >> 1;
                    a aVar = new a(str, this.f6913g[i13]);
                    this.f6913g[i13] = aVar;
                    i12 = Math.max(i12, aVar.f6922c);
                }
            }
        }
        int i14 = r1 >> 1;
        for (int i15 = 0; i15 < i14; i15++) {
            for (a aVar2 = aVarArr[i15]; aVar2 != null; aVar2 = aVar2.f6921b) {
                i11++;
                String str2 = aVar2.f6920a;
                int d11 = d(f(str2));
                String[] strArr2 = this.f6912f;
                if (strArr2[d11] == null) {
                    strArr2[d11] = str2;
                } else {
                    int i16 = d11 >> 1;
                    a aVar3 = new a(str2, this.f6913g[i16]);
                    this.f6913g[i16] = aVar3;
                    i12 = Math.max(i12, aVar3.f6922c);
                }
            }
        }
        this.f6917k = i12;
        this.f6919m = null;
        if (i11 != this.f6914h) {
            throw new IllegalStateException(String.format("Internal error on SymbolTable.rehash(): had %d entries; now have %d", new Object[]{Integer.valueOf(this.f6914h), Integer.valueOf(i11)}));
        }
    }

    public void q() {
        c cVar;
        if (n() && (cVar = this.f6907a) != null && this.f6911e) {
            cVar.o(new b(this));
            this.f6918l = true;
        }
    }

    public void r(int i10) {
        throw new IllegalStateException("Longest collision chain in symbol table (of size " + this.f6914h + ") now exceeds maximum, " + i10 + " -- suspect a DoS attack based on hash collisions");
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f6923a;

        /* renamed from: b  reason: collision with root package name */
        public final int f6924b;

        /* renamed from: c  reason: collision with root package name */
        public final String[] f6925c;

        /* renamed from: d  reason: collision with root package name */
        public final a[] f6926d;

        public b(int i10, int i11, String[] strArr, a[] aVarArr) {
            this.f6923a = i10;
            this.f6924b = i11;
            this.f6925c = strArr;
            this.f6926d = aVarArr;
        }

        public static b a(int i10) {
            return new b(0, 0, new String[i10], new a[(i10 >> 1)]);
        }

        public b(c cVar) {
            this.f6923a = cVar.f6914h;
            this.f6924b = cVar.f6917k;
            this.f6925c = cVar.f6912f;
            this.f6926d = cVar.f6913g;
        }
    }

    public c(c cVar, int i10, int i11, b bVar) {
        this.f6907a = cVar;
        this.f6909c = i11;
        this.f6908b = null;
        this.f6910d = i10;
        this.f6911e = f.a.CANONICALIZE_FIELD_NAMES.d(i10);
        String[] strArr = bVar.f6925c;
        this.f6912f = strArr;
        this.f6913g = bVar.f6926d;
        this.f6914h = bVar.f6923a;
        this.f6917k = bVar.f6924b;
        int length = strArr.length;
        this.f6915i = e(length);
        this.f6916j = length - 1;
        this.f6918l = true;
    }
}
