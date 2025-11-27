package z8;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import y8.k1;
import y8.l;
import y8.n;
import y8.n0;
import y8.w;

public class l1 implements o0 {

    /* renamed from: a  reason: collision with root package name */
    public final d f20753a;

    /* renamed from: b  reason: collision with root package name */
    public int f20754b = -1;

    /* renamed from: c  reason: collision with root package name */
    public n2 f20755c;

    /* renamed from: d  reason: collision with root package name */
    public n f20756d = l.b.f20085a;

    /* renamed from: e  reason: collision with root package name */
    public boolean f20757e = true;

    /* renamed from: f  reason: collision with root package name */
    public final c f20758f = new c();

    /* renamed from: g  reason: collision with root package name */
    public final ByteBuffer f20759g = ByteBuffer.allocate(5);

    /* renamed from: h  reason: collision with root package name */
    public final o2 f20760h;

    /* renamed from: i  reason: collision with root package name */
    public final g2 f20761i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f20762j;

    /* renamed from: k  reason: collision with root package name */
    public int f20763k;

    /* renamed from: l  reason: collision with root package name */
    public int f20764l = -1;

    /* renamed from: m  reason: collision with root package name */
    public long f20765m;

    public class c extends OutputStream {
        public c() {
        }

        public void write(int i10) {
            write(new byte[]{(byte) i10}, 0, 1);
        }

        public void write(byte[] bArr, int i10, int i11) {
            l1.this.n(bArr, i10, i11);
        }
    }

    public interface d {
        void f(n2 n2Var, boolean z10, boolean z11, int i10);
    }

    public l1(d dVar, o2 o2Var, g2 g2Var) {
        this.f20753a = (d) Preconditions.checkNotNull(dVar, "sink");
        this.f20760h = (o2) Preconditions.checkNotNull(o2Var, "bufferAllocator");
        this.f20761i = (g2) Preconditions.checkNotNull(g2Var, "statsTraceCtx");
    }

    public static int o(InputStream inputStream, OutputStream outputStream) {
        boolean z10;
        if (inputStream instanceof w) {
            return ((w) inputStream).a(outputStream);
        }
        long copy = ByteStreams.copy(inputStream, outputStream);
        if (copy <= TTL.MAX_VALUE) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "Message size overflow: %s", copy);
        return (int) copy;
    }

    public void b(InputStream inputStream) {
        boolean z10;
        int i10;
        j();
        this.f20763k++;
        int i11 = this.f20764l + 1;
        this.f20764l = i11;
        this.f20765m = 0;
        this.f20761i.i(i11);
        if (!this.f20757e || this.f20756d == l.b.f20085a) {
            z10 = false;
        } else {
            z10 = true;
        }
        try {
            int g10 = g(inputStream);
            if (g10 == 0 || !z10) {
                i10 = p(inputStream, g10);
            } else {
                i10 = l(inputStream, g10);
            }
            if (g10 == -1 || i10 == g10) {
                long j10 = (long) i10;
                this.f20761i.k(j10);
                this.f20761i.l(this.f20765m);
                this.f20761i.j(this.f20764l, this.f20765m, j10);
                return;
            }
            throw k1.f20055t.r(String.format("Message length inaccurate %s != %s", new Object[]{Integer.valueOf(i10), Integer.valueOf(g10)})).d();
        } catch (IOException e10) {
            throw k1.f20055t.r("Failed to frame message").q(e10).d();
        } catch (RuntimeException e11) {
            throw k1.f20055t.r("Failed to frame message").q(e11).d();
        }
    }

    public void close() {
        if (!isClosed()) {
            this.f20762j = true;
            n2 n2Var = this.f20755c;
            if (n2Var != null && n2Var.h() == 0) {
                h();
            }
            f(true, true);
        }
    }

    public void d(int i10) {
        boolean z10;
        if (this.f20754b == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "max size already set");
        this.f20754b = i10;
    }

    public final void f(boolean z10, boolean z11) {
        n2 n2Var = this.f20755c;
        this.f20755c = null;
        this.f20753a.f(n2Var, z10, z11, this.f20763k);
        this.f20763k = 0;
    }

    public void flush() {
        n2 n2Var = this.f20755c;
        if (n2Var != null && n2Var.h() > 0) {
            f(false, true);
        }
    }

    public final int g(InputStream inputStream) {
        if ((inputStream instanceof n0) || (inputStream instanceof ByteArrayInputStream)) {
            return inputStream.available();
        }
        return -1;
    }

    public final void h() {
        n2 n2Var = this.f20755c;
        if (n2Var != null) {
            n2Var.release();
            this.f20755c = null;
        }
    }

    /* renamed from: i */
    public l1 a(n nVar) {
        this.f20756d = (n) Preconditions.checkNotNull(nVar, "Can't pass an empty compressor");
        return this;
    }

    public boolean isClosed() {
        return this.f20762j;
    }

    public final void j() {
        if (isClosed()) {
            throw new IllegalStateException("Framer already closed");
        }
    }

    public final void k(b bVar, boolean z10) {
        int a10 = bVar.h();
        this.f20759g.clear();
        this.f20759g.put(z10 ? (byte) 1 : 0).putInt(a10);
        n2 a11 = this.f20760h.a(5);
        a11.write(this.f20759g.array(), 0, this.f20759g.position());
        if (a10 == 0) {
            this.f20755c = a11;
            return;
        }
        this.f20753a.f(a11, false, false, this.f20763k - 1);
        this.f20763k = 1;
        List b10 = bVar.f20766a;
        for (int i10 = 0; i10 < b10.size() - 1; i10++) {
            this.f20753a.f((n2) b10.get(i10), false, false, 0);
        }
        this.f20755c = (n2) b10.get(b10.size() - 1);
        this.f20765m = (long) a10;
    }

    /* JADX INFO: finally extract failed */
    public final int l(InputStream inputStream, int i10) {
        b bVar = new b();
        OutputStream compress = this.f20756d.compress(bVar);
        try {
            int o10 = o(inputStream, compress);
            compress.close();
            int i11 = this.f20754b;
            if (i11 < 0 || o10 <= i11) {
                k(bVar, true);
                return o10;
            }
            throw k1.f20050o.r(String.format(Locale.US, "message too large %d > %d", new Object[]{Integer.valueOf(o10), Integer.valueOf(this.f20754b)})).d();
        } catch (Throwable th) {
            compress.close();
            throw th;
        }
    }

    public final int m(InputStream inputStream, int i10) {
        int i11 = this.f20754b;
        if (i11 < 0 || i10 <= i11) {
            this.f20759g.clear();
            this.f20759g.put((byte) 0).putInt(i10);
            if (this.f20755c == null) {
                this.f20755c = this.f20760h.a(this.f20759g.position() + i10);
            }
            n(this.f20759g.array(), 0, this.f20759g.position());
            return o(inputStream, this.f20758f);
        }
        throw k1.f20050o.r(String.format(Locale.US, "message too large %d > %d", new Object[]{Integer.valueOf(i10), Integer.valueOf(this.f20754b)})).d();
    }

    public final void n(byte[] bArr, int i10, int i11) {
        while (i11 > 0) {
            n2 n2Var = this.f20755c;
            if (n2Var != null && n2Var.a() == 0) {
                f(false, false);
            }
            if (this.f20755c == null) {
                this.f20755c = this.f20760h.a(i11);
            }
            int min = Math.min(i11, this.f20755c.a());
            this.f20755c.write(bArr, i10, min);
            i10 += min;
            i11 -= min;
        }
    }

    public final int p(InputStream inputStream, int i10) {
        if (i10 != -1) {
            this.f20765m = (long) i10;
            return m(inputStream, i10);
        }
        b bVar = new b();
        int o10 = o(inputStream, bVar);
        int i11 = this.f20754b;
        if (i11 < 0 || o10 <= i11) {
            k(bVar, false);
            return o10;
        }
        throw k1.f20050o.r(String.format(Locale.US, "message too large %d > %d", new Object[]{Integer.valueOf(o10), Integer.valueOf(this.f20754b)})).d();
    }

    public final class b extends OutputStream {

        /* renamed from: a  reason: collision with root package name */
        public final List f20766a;

        /* renamed from: b  reason: collision with root package name */
        public n2 f20767b;

        public b() {
            this.f20766a = new ArrayList();
        }

        public final int h() {
            int i10 = 0;
            for (n2 h10 : this.f20766a) {
                i10 += h10.h();
            }
            return i10;
        }

        public void write(int i10) {
            n2 n2Var = this.f20767b;
            if (n2Var == null || n2Var.a() <= 0) {
                write(new byte[]{(byte) i10}, 0, 1);
                return;
            }
            this.f20767b.b((byte) i10);
        }

        public void write(byte[] bArr, int i10, int i11) {
            if (this.f20767b == null) {
                n2 a10 = l1.this.f20760h.a(i11);
                this.f20767b = a10;
                this.f20766a.add(a10);
            }
            while (i11 > 0) {
                int min = Math.min(i11, this.f20767b.a());
                if (min == 0) {
                    n2 a11 = l1.this.f20760h.a(Math.max(i11, this.f20767b.h() * 2));
                    this.f20767b = a11;
                    this.f20766a.add(a11);
                } else {
                    this.f20767b.write(bArr, i10, min);
                    i10 += min;
                    i11 -= min;
                }
            }
        }
    }
}
