package a9;

import com.google.common.base.Preconditions;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import okio.Buffer;

public class q {

    /* renamed from: a  reason: collision with root package name */
    public final d f10885a;

    /* renamed from: b  reason: collision with root package name */
    public final c9.c f10886b;

    /* renamed from: c  reason: collision with root package name */
    public int f10887c = Message.MAXLENGTH;

    /* renamed from: d  reason: collision with root package name */
    public final c f10888d = new c(0, Message.MAXLENGTH, (b) null);

    public interface b {
        void b(int i10);
    }

    public final class c {

        /* renamed from: a  reason: collision with root package name */
        public final Buffer f10889a = new Buffer();

        /* renamed from: b  reason: collision with root package name */
        public Runnable f10890b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10891c;

        /* renamed from: d  reason: collision with root package name */
        public int f10892d;

        /* renamed from: e  reason: collision with root package name */
        public int f10893e;

        /* renamed from: f  reason: collision with root package name */
        public final b f10894f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f10895g = false;

        public c(int i10, int i11, b bVar) {
            this.f10891c = i10;
            this.f10892d = i11;
            this.f10894f = bVar;
        }

        public void a(int i10) {
            this.f10893e += i10;
        }

        public int b() {
            return this.f10893e;
        }

        public void c() {
            this.f10893e = 0;
        }

        public void d(Buffer buffer, int i10, boolean z10) {
            this.f10889a.write(buffer, (long) i10);
            this.f10895g |= z10;
        }

        public boolean e() {
            if (this.f10889a.size() > 0) {
                return true;
            }
            return false;
        }

        public int f(int i10) {
            if (i10 <= 0 || Integer.MAX_VALUE - i10 >= this.f10892d) {
                int i11 = this.f10892d + i10;
                this.f10892d = i11;
                return i11;
            }
            throw new IllegalArgumentException("Window size overflow for stream: " + this.f10891c);
        }

        public int g() {
            return Math.max(0, Math.min(this.f10892d, (int) this.f10889a.size()));
        }

        public int h() {
            return g() - this.f10893e;
        }

        public int i() {
            return this.f10892d;
        }

        public int j() {
            return Math.min(this.f10892d, q.this.f10888d.i());
        }

        public void k(Buffer buffer, int i10, boolean z10) {
            boolean z11;
            do {
                int min = Math.min(i10, q.this.f10886b.maxDataLength());
                int i11 = -min;
                q.this.f10888d.f(i11);
                f(i11);
                try {
                    if (buffer.size() != ((long) min) || !z10) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    q.this.f10886b.data(z11, this.f10891c, buffer, min);
                    this.f10894f.b(min);
                    i10 -= min;
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            } while (i10 > 0);
        }

        public int l(int i10, e eVar) {
            Runnable runnable;
            int min = Math.min(i10, j());
            int i11 = 0;
            while (e() && min > 0) {
                if (((long) min) >= this.f10889a.size()) {
                    i11 += (int) this.f10889a.size();
                    Buffer buffer = this.f10889a;
                    k(buffer, (int) buffer.size(), this.f10895g);
                } else {
                    i11 += min;
                    k(this.f10889a, min, false);
                }
                eVar.b();
                min = Math.min(i10 - i11, j());
            }
            if (!e() && (runnable = this.f10890b) != null) {
                runnable.run();
                this.f10890b = null;
            }
            return i11;
        }
    }

    public interface d {
        c[] a();
    }

    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public int f10897a;

        public e() {
        }

        public boolean a() {
            if (this.f10897a > 0) {
                return true;
            }
            return false;
        }

        public void b() {
            this.f10897a++;
        }
    }

    public q(d dVar, c9.c cVar) {
        this.f10885a = (d) Preconditions.checkNotNull(dVar, "transport");
        this.f10886b = (c9.c) Preconditions.checkNotNull(cVar, "frameWriter");
    }

    public c c(b bVar, int i10) {
        return new c(i10, this.f10887c, (b) Preconditions.checkNotNull(bVar, "stream"));
    }

    public void d(boolean z10, c cVar, Buffer buffer, boolean z11) {
        Preconditions.checkNotNull(buffer, "source");
        int j10 = cVar.j();
        boolean e10 = cVar.e();
        int size = (int) buffer.size();
        if (e10 || j10 < size) {
            if (!e10 && j10 > 0) {
                cVar.k(buffer, j10, false);
            }
            cVar.d(buffer, (int) buffer.size(), z10);
        } else {
            cVar.k(buffer, size, z10);
        }
        if (z11) {
            e();
        }
    }

    public void e() {
        try {
            this.f10886b.flush();
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    public boolean f(int i10) {
        if (i10 >= 0) {
            int i11 = i10 - this.f10887c;
            this.f10887c = i10;
            for (c f10 : this.f10885a.a()) {
                f10.f(i11);
            }
            if (i11 > 0) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Invalid initial window size: " + i10);
    }

    public int g(c cVar, int i10) {
        if (cVar == null) {
            int f10 = this.f10888d.f(i10);
            h();
            return f10;
        }
        int f11 = cVar.f(i10);
        e eVar = new e();
        cVar.l(cVar.j(), eVar);
        if (eVar.a()) {
            e();
        }
        return f11;
    }

    public void h() {
        int i10;
        c[] a10 = this.f10885a.a();
        Collections.shuffle(Arrays.asList(a10));
        int i11 = this.f10888d.i();
        int length = a10.length;
        while (true) {
            i10 = 0;
            if (length <= 0 || i11 <= 0) {
                e eVar = new e();
                c[] a11 = this.f10885a.a();
                int length2 = a11.length;
            } else {
                int ceil = (int) Math.ceil((double) (((float) i11) / ((float) length)));
                for (int i12 = 0; i12 < length && i11 > 0; i12++) {
                    c cVar = a10[i12];
                    int min = Math.min(i11, Math.min(cVar.h(), ceil));
                    if (min > 0) {
                        cVar.a(min);
                        i11 -= min;
                    }
                    if (cVar.h() > 0) {
                        a10[i10] = cVar;
                        i10++;
                    }
                }
                length = i10;
            }
        }
        e eVar2 = new e();
        c[] a112 = this.f10885a.a();
        int length22 = a112.length;
        while (i10 < length22) {
            c cVar2 = a112[i10];
            cVar2.l(cVar2.b(), eVar2);
            cVar2.c();
            i10++;
        }
        if (eVar2.a()) {
            e();
        }
    }
}
