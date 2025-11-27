package z8;

import com.google.common.base.Preconditions;
import com.hpplay.component.protocol.mirror.AutoStrategy;
import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.zip.DataFormatException;
import y8.l;
import y8.u;
import z8.i2;

public class k1 implements Closeable, y {

    /* renamed from: a  reason: collision with root package name */
    public b f20706a;

    /* renamed from: b  reason: collision with root package name */
    public int f20707b;

    /* renamed from: c  reason: collision with root package name */
    public final g2 f20708c;

    /* renamed from: d  reason: collision with root package name */
    public final m2 f20709d;

    /* renamed from: e  reason: collision with root package name */
    public u f20710e;

    /* renamed from: f  reason: collision with root package name */
    public r0 f20711f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f20712g;

    /* renamed from: h  reason: collision with root package name */
    public int f20713h;

    /* renamed from: i  reason: collision with root package name */
    public e f20714i = e.HEADER;

    /* renamed from: j  reason: collision with root package name */
    public int f20715j = 5;

    /* renamed from: k  reason: collision with root package name */
    public boolean f20716k;

    /* renamed from: l  reason: collision with root package name */
    public u f20717l;

    /* renamed from: m  reason: collision with root package name */
    public u f20718m = new u();

    /* renamed from: n  reason: collision with root package name */
    public long f20719n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f20720o = false;

    /* renamed from: p  reason: collision with root package name */
    public int f20721p = -1;

    /* renamed from: q  reason: collision with root package name */
    public int f20722q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f20723r = false;

    /* renamed from: s  reason: collision with root package name */
    public volatile boolean f20724s = false;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f20725a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                z8.k1$e[] r0 = z8.k1.e.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20725a = r0
                z8.k1$e r1 = z8.k1.e.HEADER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20725a     // Catch:{ NoSuchFieldError -> 0x001d }
                z8.k1$e r1 = z8.k1.e.BODY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: z8.k1.a.<clinit>():void");
        }
    }

    public interface b {
        void a(i2.a aVar);

        void c(int i10);

        void d(Throwable th);

        void e(boolean z10);
    }

    public static class c implements i2.a {

        /* renamed from: a  reason: collision with root package name */
        public InputStream f20726a;

        public /* synthetic */ c(InputStream inputStream, a aVar) {
            this(inputStream);
        }

        public InputStream next() {
            InputStream inputStream = this.f20726a;
            this.f20726a = null;
            return inputStream;
        }

        public c(InputStream inputStream) {
            this.f20726a = inputStream;
        }
    }

    public enum e {
        HEADER,
        BODY
    }

    public k1(b bVar, u uVar, int i10, g2 g2Var, m2 m2Var) {
        this.f20706a = (b) Preconditions.checkNotNull(bVar, "sink");
        this.f20710e = (u) Preconditions.checkNotNull(uVar, "decompressor");
        this.f20707b = i10;
        this.f20708c = (g2) Preconditions.checkNotNull(g2Var, "statsTraceCtx");
        this.f20709d = (m2) Preconditions.checkNotNull(m2Var, "transportTracer");
    }

    public void E(b bVar) {
        this.f20706a = bVar;
    }

    public void I() {
        this.f20724s = true;
    }

    public final void a() {
        if (!this.f20720o) {
            this.f20720o = true;
            while (!this.f20724s && this.f20719n > 0 && y()) {
                try {
                    int i10 = a.f20725a[this.f20714i.ordinal()];
                    if (i10 == 1) {
                        x();
                    } else if (i10 == 2) {
                        v();
                        this.f20719n--;
                    } else {
                        throw new AssertionError("Invalid state: " + this.f20714i);
                    }
                } finally {
                    this.f20720o = false;
                }
            }
            if (this.f20724s) {
                close();
                return;
            }
            if (this.f20723r && u()) {
                close();
            }
            this.f20720o = false;
        }
    }

    public void b(int i10) {
        boolean z10;
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "numMessages must be > 0");
        if (!isClosed()) {
            this.f20719n += (long) i10;
            a();
        }
    }

    public void c(int i10) {
        this.f20707b = i10;
    }

    /* JADX INFO: finally extract failed */
    public void close() {
        boolean z10;
        if (!isClosed()) {
            u uVar = this.f20717l;
            boolean z11 = true;
            if (uVar == null || uVar.h() <= 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            try {
                r0 r0Var = this.f20711f;
                if (r0Var != null) {
                    if (!z10) {
                        if (!r0Var.x()) {
                            z11 = false;
                        }
                    }
                    this.f20711f.close();
                    z10 = z11;
                }
                u uVar2 = this.f20718m;
                if (uVar2 != null) {
                    uVar2.close();
                }
                u uVar3 = this.f20717l;
                if (uVar3 != null) {
                    uVar3.close();
                }
                this.f20711f = null;
                this.f20718m = null;
                this.f20717l = null;
                this.f20706a.e(z10);
            } catch (Throwable th) {
                this.f20711f = null;
                this.f20718m = null;
                this.f20717l = null;
                throw th;
            }
        }
    }

    public void e(u uVar) {
        boolean z10;
        if (this.f20711f == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "Already set full stream decompressor");
        this.f20710e = (u) Preconditions.checkNotNull(uVar, "Can't pass an empty decompressor");
    }

    public void f(t1 t1Var) {
        Preconditions.checkNotNull(t1Var, "data");
        boolean z10 = true;
        try {
            if (!s()) {
                r0 r0Var = this.f20711f;
                if (r0Var != null) {
                    r0Var.q(t1Var);
                } else {
                    this.f20718m.b(t1Var);
                }
                z10 = false;
                a();
            }
        } finally {
            if (z10) {
                t1Var.close();
            }
        }
    }

    public boolean isClosed() {
        if (this.f20718m == null && this.f20711f == null) {
            return true;
        }
        return false;
    }

    public void m() {
        if (!isClosed()) {
            if (u()) {
                close();
            } else {
                this.f20723r = true;
            }
        }
    }

    public final InputStream n() {
        u uVar = this.f20710e;
        if (uVar != l.b.f20085a) {
            try {
                return new d(uVar.decompress(u1.c(this.f20717l, true)), this.f20707b, this.f20708c);
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        } else {
            throw y8.k1.f20055t.r("Can't decode compressed gRPC message as compression not configured").d();
        }
    }

    public final InputStream q() {
        this.f20708c.f((long) this.f20717l.h());
        return u1.c(this.f20717l, true);
    }

    public final boolean s() {
        if (isClosed() || this.f20723r) {
            return true;
        }
        return false;
    }

    public final boolean u() {
        r0 r0Var = this.f20711f;
        if (r0Var != null) {
            return r0Var.I();
        }
        if (this.f20718m.h() == 0) {
            return true;
        }
        return false;
    }

    public final void v() {
        InputStream inputStream;
        this.f20708c.e(this.f20721p, (long) this.f20722q, -1);
        this.f20722q = 0;
        if (this.f20716k) {
            inputStream = n();
        } else {
            inputStream = q();
        }
        this.f20717l = null;
        this.f20706a.a(new c(inputStream, (a) null));
        this.f20714i = e.HEADER;
        this.f20715j = 5;
    }

    public final void x() {
        boolean z10;
        int readUnsignedByte = this.f20717l.readUnsignedByte();
        if ((readUnsignedByte & 254) == 0) {
            if ((readUnsignedByte & 1) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f20716k = z10;
            int readInt = this.f20717l.readInt();
            this.f20715j = readInt;
            if (readInt < 0 || readInt > this.f20707b) {
                throw y8.k1.f20050o.r(String.format(Locale.US, "gRPC message exceeds maximum size %d: %d", new Object[]{Integer.valueOf(this.f20707b), Integer.valueOf(this.f20715j)})).d();
            }
            int i10 = this.f20721p + 1;
            this.f20721p = i10;
            this.f20708c.d(i10);
            this.f20709d.d();
            this.f20714i = e.BODY;
            return;
        }
        throw y8.k1.f20055t.r("gRPC frame header malformed: reserved bits not zero").d();
    }

    public final boolean y() {
        int i10;
        int i11 = 0;
        try {
            if (this.f20717l == null) {
                this.f20717l = new u();
            }
            int i12 = 0;
            i10 = 0;
            while (true) {
                try {
                    int h10 = this.f20715j - this.f20717l.h();
                    if (h10 > 0) {
                        if (this.f20711f != null) {
                            byte[] bArr = this.f20712g;
                            if (bArr == null || this.f20713h == bArr.length) {
                                this.f20712g = new byte[Math.min(h10, AutoStrategy.BITRATE_LOW4)];
                                this.f20713h = 0;
                            }
                            int z10 = this.f20711f.z(this.f20712g, this.f20713h, Math.min(h10, this.f20712g.length - this.f20713h));
                            i12 += this.f20711f.u();
                            i10 += this.f20711f.v();
                            if (z10 == 0) {
                                if (i12 > 0) {
                                    this.f20706a.c(i12);
                                    if (this.f20714i == e.BODY) {
                                        if (this.f20711f != null) {
                                            this.f20708c.g((long) i10);
                                            this.f20722q += i10;
                                        } else {
                                            this.f20708c.g((long) i12);
                                            this.f20722q += i12;
                                        }
                                    }
                                }
                                return false;
                            }
                            this.f20717l.b(u1.f(this.f20712g, this.f20713h, z10));
                            this.f20713h += z10;
                        } else if (this.f20718m.h() == 0) {
                            if (i12 > 0) {
                                this.f20706a.c(i12);
                                if (this.f20714i == e.BODY) {
                                    if (this.f20711f != null) {
                                        this.f20708c.g((long) i10);
                                        this.f20722q += i10;
                                    } else {
                                        this.f20708c.g((long) i12);
                                        this.f20722q += i12;
                                    }
                                }
                            }
                            return false;
                        } else {
                            int min = Math.min(h10, this.f20718m.h());
                            i12 += min;
                            this.f20717l.b(this.f20718m.j(min));
                        }
                    } else if (i12 <= 0) {
                        return true;
                    } else {
                        this.f20706a.c(i12);
                        if (this.f20714i != e.BODY) {
                            return true;
                        }
                        if (this.f20711f != null) {
                            this.f20708c.g((long) i10);
                            this.f20722q += i10;
                            return true;
                        }
                        this.f20708c.g((long) i12);
                        this.f20722q += i12;
                        return true;
                    }
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                } catch (DataFormatException e11) {
                    throw new RuntimeException(e11);
                } catch (Throwable th) {
                    int i13 = i12;
                    th = th;
                    i11 = i13;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            i10 = 0;
            if (i11 > 0) {
                this.f20706a.c(i11);
                if (this.f20714i == e.BODY) {
                    if (this.f20711f != null) {
                        this.f20708c.g((long) i10);
                        this.f20722q += i10;
                    } else {
                        this.f20708c.g((long) i11);
                        this.f20722q += i11;
                    }
                }
            }
            throw th;
        }
    }

    public void z(r0 r0Var) {
        boolean z10;
        boolean z11 = true;
        if (this.f20710e == l.b.f20085a) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "per-message decompressor already set");
        if (this.f20711f != null) {
            z11 = false;
        }
        Preconditions.checkState(z11, "full stream decompressor already set");
        this.f20711f = (r0) Preconditions.checkNotNull(r0Var, "Can't pass a null full stream decompressor");
        this.f20718m = null;
    }

    public static final class d extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        public final int f20727a;

        /* renamed from: b  reason: collision with root package name */
        public final g2 f20728b;

        /* renamed from: c  reason: collision with root package name */
        public long f20729c;

        /* renamed from: d  reason: collision with root package name */
        public long f20730d;

        /* renamed from: e  reason: collision with root package name */
        public long f20731e = -1;

        public d(InputStream inputStream, int i10, g2 g2Var) {
            super(inputStream);
            this.f20727a = i10;
            this.f20728b = g2Var;
        }

        public final void a() {
            long j10 = this.f20730d;
            long j11 = this.f20729c;
            if (j10 > j11) {
                this.f20728b.f(j10 - j11);
                this.f20729c = this.f20730d;
            }
        }

        public final void b() {
            if (this.f20730d > ((long) this.f20727a)) {
                y8.k1 k1Var = y8.k1.f20050o;
                throw k1Var.r("Decompressed gRPC message exceeds maximum size " + this.f20727a).d();
            }
        }

        public synchronized void mark(int i10) {
            this.in.mark(i10);
            this.f20731e = this.f20730d;
        }

        public int read() {
            int read = this.in.read();
            if (read != -1) {
                this.f20730d++;
            }
            b();
            a();
            return read;
        }

        public synchronized void reset() {
            if (!this.in.markSupported()) {
                throw new IOException("Mark not supported");
            } else if (this.f20731e != -1) {
                this.in.reset();
                this.f20730d = this.f20731e;
            } else {
                throw new IOException("Mark not set");
            }
        }

        public long skip(long j10) {
            long skip = this.in.skip(j10);
            this.f20730d += skip;
            b();
            a();
            return skip;
        }

        public int read(byte[] bArr, int i10, int i11) {
            int read = this.in.read(bArr, i10, i11);
            if (read != -1) {
                this.f20730d += (long) read;
            }
            b();
            a();
            return read;
        }
    }
}
