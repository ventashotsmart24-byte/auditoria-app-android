package c3;

import c3.h;
import c3.k;
import f3.j;
import g3.g;
import h3.c;
import j3.b;
import j3.e;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class f extends t {

    /* renamed from: j  reason: collision with root package name */
    public static final int f4694j = a.c();

    /* renamed from: k  reason: collision with root package name */
    public static final int f4695k = k.a.a();

    /* renamed from: l  reason: collision with root package name */
    public static final int f4696l = h.b.a();

    /* renamed from: m  reason: collision with root package name */
    public static final q f4697m = e.f7154h;

    /* renamed from: a  reason: collision with root package name */
    public final transient c f4698a;

    /* renamed from: b  reason: collision with root package name */
    public final transient h3.a f4699b;

    /* renamed from: c  reason: collision with root package name */
    public int f4700c;

    /* renamed from: d  reason: collision with root package name */
    public int f4701d;

    /* renamed from: e  reason: collision with root package name */
    public int f4702e;

    /* renamed from: f  reason: collision with root package name */
    public o f4703f;

    /* renamed from: g  reason: collision with root package name */
    public q f4704g;

    /* renamed from: h  reason: collision with root package name */
    public int f4705h;

    /* renamed from: i  reason: collision with root package name */
    public final char f4706i;

    public enum a implements j3.h {
        INTERN_FIELD_NAMES(true),
        CANONICALIZE_FIELD_NAMES(true),
        FAIL_ON_SYMBOL_HASH_OVERFLOW(true),
        USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING(true);
        

        /* renamed from: a  reason: collision with root package name */
        public final boolean f4712a;

        /* access modifiers changed from: public */
        a(boolean z10) {
            this.f4712a = z10;
        }

        public static int c() {
            int i10 = 0;
            for (a aVar : values()) {
                if (aVar.a()) {
                    i10 |= aVar.b();
                }
            }
            return i10;
        }

        public boolean a() {
            return this.f4712a;
        }

        public int b() {
            return 1 << ordinal();
        }

        public boolean d(int i10) {
            if ((i10 & b()) != 0) {
                return true;
            }
            return false;
        }
    }

    public f() {
        this((o) null);
    }

    public f3.c a(Object obj, boolean z10) {
        return new f3.c(i(), obj, z10);
    }

    public h b(Writer writer, f3.c cVar) {
        g3.h hVar = new g3.h(cVar, this.f4702e, this.f4703f, writer, this.f4706i);
        int i10 = this.f4705h;
        if (i10 > 0) {
            hVar.E(i10);
        }
        q qVar = this.f4704g;
        if (qVar != f4697m) {
            hVar.L(qVar);
        }
        return hVar;
    }

    public k c(Reader reader, f3.c cVar) {
        return new g3.f(cVar, this.f4701d, reader, this.f4703f, this.f4698a.m(this.f4700c));
    }

    public h d(OutputStream outputStream, f3.c cVar) {
        g gVar = new g(cVar, this.f4702e, this.f4703f, outputStream, this.f4706i);
        int i10 = this.f4705h;
        if (i10 > 0) {
            gVar.E(i10);
        }
        q qVar = this.f4704g;
        if (qVar != f4697m) {
            gVar.L(qVar);
        }
        return gVar;
    }

    public Writer e(OutputStream outputStream, e eVar, f3.c cVar) {
        if (eVar == e.UTF8) {
            return new j(cVar, outputStream);
        }
        return new OutputStreamWriter(outputStream, eVar.a());
    }

    public final OutputStream f(OutputStream outputStream, f3.c cVar) {
        return outputStream;
    }

    public final Reader g(Reader reader, f3.c cVar) {
        return reader;
    }

    public final Writer h(Writer writer, f3.c cVar) {
        return writer;
    }

    public j3.a i() {
        if (a.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING.d(this.f4700c)) {
            return b.a();
        }
        return new j3.a();
    }

    public final f j(k.a aVar, boolean z10) {
        if (z10) {
            return o(aVar);
        }
        return n(aVar);
    }

    public h k(OutputStream outputStream, e eVar) {
        f3.c a10 = a(outputStream, false);
        a10.q(eVar);
        if (eVar == e.UTF8) {
            return d(f(outputStream, a10), a10);
        }
        return b(h(e(outputStream, eVar, a10), a10), a10);
    }

    public h l(Writer writer) {
        f3.c a10 = a(writer, false);
        return b(h(writer, a10), a10);
    }

    public k m(Reader reader) {
        f3.c a10 = a(reader, false);
        return c(g(reader, a10), a10);
    }

    public f n(k.a aVar) {
        this.f4701d = (aVar.d() ^ -1) & this.f4701d;
        return this;
    }

    public f o(k.a aVar) {
        this.f4701d = aVar.d() | this.f4701d;
        return this;
    }

    public o p() {
        return this.f4703f;
    }

    public boolean q() {
        return false;
    }

    public f r(o oVar) {
        this.f4703f = oVar;
        return this;
    }

    public f(o oVar) {
        this.f4698a = c.i();
        this.f4699b = h3.a.c();
        this.f4700c = f4694j;
        this.f4701d = f4695k;
        this.f4702e = f4696l;
        this.f4704g = f4697m;
        this.f4703f = oVar;
        this.f4706i = '\"';
    }
}
