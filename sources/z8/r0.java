package z8;

import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import java.io.Closeable;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

public class r0 implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final u f20921a = new u();

    /* renamed from: b  reason: collision with root package name */
    public final CRC32 f20922b = new CRC32();

    /* renamed from: c  reason: collision with root package name */
    public final b f20923c = new b(this, (a) null);

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f20924d = new byte[512];

    /* renamed from: e  reason: collision with root package name */
    public int f20925e;

    /* renamed from: f  reason: collision with root package name */
    public int f20926f;

    /* renamed from: g  reason: collision with root package name */
    public Inflater f20927g;

    /* renamed from: h  reason: collision with root package name */
    public c f20928h = c.HEADER;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20929i = false;

    /* renamed from: j  reason: collision with root package name */
    public int f20930j;

    /* renamed from: k  reason: collision with root package name */
    public int f20931k;

    /* renamed from: l  reason: collision with root package name */
    public long f20932l;

    /* renamed from: m  reason: collision with root package name */
    public int f20933m = 0;

    /* renamed from: n  reason: collision with root package name */
    public int f20934n = 0;

    /* renamed from: o  reason: collision with root package name */
    public boolean f20935o = true;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f20936a;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                z8.r0$c[] r0 = z8.r0.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20936a = r0
                z8.r0$c r1 = z8.r0.c.HEADER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20936a     // Catch:{ NoSuchFieldError -> 0x001d }
                z8.r0$c r1 = z8.r0.c.HEADER_EXTRA_LEN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20936a     // Catch:{ NoSuchFieldError -> 0x0028 }
                z8.r0$c r1 = z8.r0.c.HEADER_EXTRA     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20936a     // Catch:{ NoSuchFieldError -> 0x0033 }
                z8.r0$c r1 = z8.r0.c.HEADER_NAME     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20936a     // Catch:{ NoSuchFieldError -> 0x003e }
                z8.r0$c r1 = z8.r0.c.HEADER_COMMENT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20936a     // Catch:{ NoSuchFieldError -> 0x0049 }
                z8.r0$c r1 = z8.r0.c.HEADER_CRC     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20936a     // Catch:{ NoSuchFieldError -> 0x0054 }
                z8.r0$c r1 = z8.r0.c.INITIALIZE_INFLATER     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f20936a     // Catch:{ NoSuchFieldError -> 0x0060 }
                z8.r0$c r1 = z8.r0.c.INFLATING     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f20936a     // Catch:{ NoSuchFieldError -> 0x006c }
                z8.r0$c r1 = z8.r0.c.INFLATER_NEEDS_INPUT     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f20936a     // Catch:{ NoSuchFieldError -> 0x0078 }
                z8.r0$c r1 = z8.r0.c.TRAILER     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: z8.r0.a.<clinit>():void");
        }
    }

    public class b {
        public b() {
        }

        public final boolean g() {
            while (k() > 0) {
                if (h() == 0) {
                    return true;
                }
            }
            return false;
        }

        public final int h() {
            int i10;
            if (r0.this.f20926f - r0.this.f20925e > 0) {
                i10 = r0.this.f20924d[r0.this.f20925e] & UnsignedBytes.MAX_VALUE;
                r0.c(r0.this, 1);
            } else {
                i10 = r0.this.f20921a.readUnsignedByte();
            }
            r0.this.f20922b.update(i10);
            r0.n(r0.this, 1);
            return i10;
        }

        public final long i() {
            return ((long) j()) | (((long) j()) << 16);
        }

        public final int j() {
            return h() | (h() << 8);
        }

        public final int k() {
            return (r0.this.f20926f - r0.this.f20925e) + r0.this.f20921a.h();
        }

        public final void l(int i10) {
            int i11;
            int a10 = r0.this.f20926f - r0.this.f20925e;
            if (a10 > 0) {
                int min = Math.min(a10, i10);
                r0.this.f20922b.update(r0.this.f20924d, r0.this.f20925e, min);
                r0.c(r0.this, min);
                i11 = i10 - min;
            } else {
                i11 = i10;
            }
            if (i11 > 0) {
                byte[] bArr = new byte[512];
                int i12 = 0;
                while (i12 < i11) {
                    int min2 = Math.min(i11 - i12, 512);
                    r0.this.f20921a.C(bArr, 0, min2);
                    r0.this.f20922b.update(bArr, 0, min2);
                    i12 += min2;
                }
            }
            r0.n(r0.this, i10);
        }

        public /* synthetic */ b(r0 r0Var, a aVar) {
            this();
        }
    }

    public enum c {
        HEADER,
        HEADER_EXTRA_LEN,
        HEADER_EXTRA,
        HEADER_NAME,
        HEADER_COMMENT,
        HEADER_CRC,
        INITIALIZE_INFLATER,
        INFLATING,
        INFLATER_NEEDS_INPUT,
        TRAILER
    }

    public static /* synthetic */ int c(r0 r0Var, int i10) {
        int i11 = r0Var.f20925e + i10;
        r0Var.f20925e = i11;
        return i11;
    }

    public static /* synthetic */ int n(r0 r0Var, int i10) {
        int i11 = r0Var.f20933m + i10;
        r0Var.f20933m = i11;
        return i11;
    }

    public final boolean E() {
        Inflater inflater = this.f20927g;
        if (inflater == null) {
            this.f20927g = new Inflater(true);
        } else {
            inflater.reset();
        }
        this.f20922b.reset();
        int i10 = this.f20926f;
        int i11 = this.f20925e;
        int i12 = i10 - i11;
        if (i12 > 0) {
            this.f20927g.setInput(this.f20924d, i11, i12);
            this.f20928h = c.INFLATING;
        } else {
            this.f20928h = c.INFLATER_NEEDS_INPUT;
        }
        return true;
    }

    public boolean I() {
        Preconditions.checkState(!this.f20929i, "GzipInflatingBuffer is closed");
        return this.f20935o;
    }

    public final boolean L() {
        if (this.f20923c.k() < 10) {
            return false;
        }
        if (this.f20923c.j() != 35615) {
            throw new ZipException("Not in GZIP format");
        } else if (this.f20923c.h() == 8) {
            this.f20930j = this.f20923c.h();
            this.f20923c.l(6);
            this.f20928h = c.HEADER_EXTRA_LEN;
            return true;
        } else {
            throw new ZipException("Unsupported compression method");
        }
    }

    public final boolean M() {
        if ((this.f20930j & 16) != 16) {
            this.f20928h = c.HEADER_CRC;
            return true;
        } else if (!this.f20923c.g()) {
            return false;
        } else {
            this.f20928h = c.HEADER_CRC;
            return true;
        }
    }

    public final boolean N() {
        if ((this.f20930j & 2) != 2) {
            this.f20928h = c.INITIALIZE_INFLATER;
            return true;
        } else if (this.f20923c.k() < 2) {
            return false;
        } else {
            if ((65535 & ((int) this.f20922b.getValue())) == this.f20923c.j()) {
                this.f20928h = c.INITIALIZE_INFLATER;
                return true;
            }
            throw new ZipException("Corrupt GZIP header");
        }
    }

    public final boolean O() {
        int d10 = this.f20923c.k();
        int i10 = this.f20931k;
        if (d10 < i10) {
            return false;
        }
        this.f20923c.l(i10);
        this.f20928h = c.HEADER_NAME;
        return true;
    }

    public final boolean P() {
        if ((this.f20930j & 4) != 4) {
            this.f20928h = c.HEADER_NAME;
            return true;
        } else if (this.f20923c.k() < 2) {
            return false;
        } else {
            this.f20931k = this.f20923c.j();
            this.f20928h = c.HEADER_EXTRA;
            return true;
        }
    }

    public final boolean Q() {
        if ((this.f20930j & 8) != 8) {
            this.f20928h = c.HEADER_COMMENT;
            return true;
        } else if (!this.f20923c.g()) {
            return false;
        } else {
            this.f20928h = c.HEADER_COMMENT;
            return true;
        }
    }

    public final boolean R() {
        if (this.f20927g != null && this.f20923c.k() <= 18) {
            this.f20927g.end();
            this.f20927g = null;
        }
        if (this.f20923c.k() < 8) {
            return false;
        }
        if (this.f20922b.getValue() == this.f20923c.i() && this.f20932l == this.f20923c.i()) {
            this.f20922b.reset();
            this.f20928h = c.HEADER;
            return true;
        }
        throw new ZipException("Corrupt GZIP trailer");
    }

    public void close() {
        if (!this.f20929i) {
            this.f20929i = true;
            this.f20921a.close();
            Inflater inflater = this.f20927g;
            if (inflater != null) {
                inflater.end();
                this.f20927g = null;
            }
        }
    }

    public void q(t1 t1Var) {
        Preconditions.checkState(!this.f20929i, "GzipInflatingBuffer is closed");
        this.f20921a.b(t1Var);
        this.f20935o = false;
    }

    public final boolean s() {
        boolean z10;
        boolean z11;
        if (this.f20927g != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "inflater is null");
        if (this.f20925e == this.f20926f) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "inflaterInput has unconsumed bytes");
        int min = Math.min(this.f20921a.h(), 512);
        if (min == 0) {
            return false;
        }
        this.f20925e = 0;
        this.f20926f = min;
        this.f20921a.C(this.f20924d, 0, min);
        this.f20927g.setInput(this.f20924d, this.f20925e, min);
        this.f20928h = c.INFLATING;
        return true;
    }

    public int u() {
        int i10 = this.f20933m;
        this.f20933m = 0;
        return i10;
    }

    public int v() {
        int i10 = this.f20934n;
        this.f20934n = 0;
        return i10;
    }

    public boolean x() {
        Preconditions.checkState(!this.f20929i, "GzipInflatingBuffer is closed");
        if (this.f20923c.k() == 0 && this.f20928h == c.HEADER) {
            return false;
        }
        return true;
    }

    public final int y(byte[] bArr, int i10, int i11) {
        boolean z10;
        if (this.f20927g != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "inflater is null");
        try {
            int totalIn = this.f20927g.getTotalIn();
            int inflate = this.f20927g.inflate(bArr, i10, i11);
            int totalIn2 = this.f20927g.getTotalIn() - totalIn;
            this.f20933m += totalIn2;
            this.f20934n += totalIn2;
            this.f20925e += totalIn2;
            this.f20922b.update(bArr, i10, inflate);
            if (this.f20927g.finished()) {
                this.f20932l = this.f20927g.getBytesWritten() & 4294967295L;
                this.f20928h = c.TRAILER;
            } else if (this.f20927g.needsInput()) {
                this.f20928h = c.INFLATER_NEEDS_INPUT;
            }
            return inflate;
        } catch (DataFormatException e10) {
            throw new DataFormatException("Inflater data format exception: " + e10.getMessage());
        }
    }

    public int z(byte[] bArr, int i10, int i11) {
        boolean z10 = true;
        Preconditions.checkState(!this.f20929i, "GzipInflatingBuffer is closed");
        boolean z11 = true;
        int i12 = 0;
        while (z11) {
            int i13 = i11 - i12;
            if (i13 > 0) {
                switch (a.f20936a[this.f20928h.ordinal()]) {
                    case 1:
                        z11 = L();
                        break;
                    case 2:
                        z11 = P();
                        break;
                    case 3:
                        z11 = O();
                        break;
                    case 4:
                        z11 = Q();
                        break;
                    case 5:
                        z11 = M();
                        break;
                    case 6:
                        z11 = N();
                        break;
                    case 7:
                        z11 = E();
                        break;
                    case 8:
                        i12 += y(bArr, i10 + i12, i13);
                        if (this.f20928h != c.TRAILER) {
                            z11 = true;
                            break;
                        } else {
                            z11 = R();
                            break;
                        }
                    case 9:
                        z11 = s();
                        break;
                    case 10:
                        z11 = R();
                        break;
                    default:
                        throw new AssertionError("Invalid state: " + this.f20928h);
                }
            } else {
                if (z11 && (this.f20928h != c.HEADER || this.f20923c.k() >= 10)) {
                    z10 = false;
                }
                this.f20935o = z10;
                return i12;
            }
        }
        z10 = false;
        this.f20935o = z10;
        return i12;
    }
}
