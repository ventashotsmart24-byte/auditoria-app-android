package j3;

import c3.h;
import c3.p;
import c3.q;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import f3.i;
import java.io.Serializable;

public class e implements p, f, Serializable {

    /* renamed from: h  reason: collision with root package name */
    public static final i f7154h = new i(" ");

    /* renamed from: a  reason: collision with root package name */
    public b f7155a;

    /* renamed from: b  reason: collision with root package name */
    public b f7156b;

    /* renamed from: c  reason: collision with root package name */
    public final q f7157c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7158d;

    /* renamed from: e  reason: collision with root package name */
    public transient int f7159e;

    /* renamed from: f  reason: collision with root package name */
    public n f7160f;

    /* renamed from: g  reason: collision with root package name */
    public String f7161g;

    public static class a extends c {

        /* renamed from: b  reason: collision with root package name */
        public static final a f7162b = new a();

        public void a(h hVar, int i10) {
            hVar.m0(' ');
        }

        public boolean isInline() {
            return true;
        }
    }

    public interface b {
        void a(h hVar, int i10);

        boolean isInline();
    }

    public static class c implements b, Serializable {

        /* renamed from: a  reason: collision with root package name */
        public static final c f7163a = new c();

        public void a(h hVar, int i10) {
        }

        public boolean isInline() {
            return true;
        }
    }

    public e() {
        this((q) f7154h);
    }

    public void a(h hVar) {
        hVar.m0(this.f7160f.c());
        this.f7156b.a(hVar, this.f7159e);
    }

    public void b(h hVar) {
        if (!this.f7155a.isInline()) {
            this.f7159e++;
        }
        hVar.m0('[');
    }

    public void c(h hVar) {
        this.f7155a.a(hVar, this.f7159e);
    }

    public void d(h hVar, int i10) {
        if (!this.f7155a.isInline()) {
            this.f7159e--;
        }
        if (i10 > 0) {
            this.f7155a.a(hVar, this.f7159e);
        } else {
            hVar.m0(' ');
        }
        hVar.m0(']');
    }

    public void e(h hVar) {
        hVar.m0(ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN);
        if (!this.f7156b.isInline()) {
            this.f7159e++;
        }
    }

    public void g(h hVar) {
        hVar.m0(this.f7160f.b());
        this.f7155a.a(hVar, this.f7159e);
    }

    public void h(h hVar) {
        if (this.f7158d) {
            hVar.o0(this.f7161g);
        } else {
            hVar.m0(this.f7160f.d());
        }
    }

    public void i(h hVar, int i10) {
        if (!this.f7156b.isInline()) {
            this.f7159e--;
        }
        if (i10 > 0) {
            this.f7156b.a(hVar, this.f7159e);
        } else {
            hVar.m0(' ');
        }
        hVar.m0(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
    }

    public void j(h hVar) {
        q qVar = this.f7157c;
        if (qVar != null) {
            hVar.n0(qVar);
        }
    }

    public void k(h hVar) {
        this.f7156b.a(hVar, this.f7159e);
    }

    /* renamed from: l */
    public e f() {
        if (getClass() == e.class) {
            return new e(this);
        }
        throw new IllegalStateException("Failed `createInstance()`: " + getClass().getName() + " does not override method; it has to");
    }

    public e m(n nVar) {
        this.f7160f = nVar;
        this.f7161g = " " + nVar.d() + " ";
        return this;
    }

    public e(q qVar) {
        this.f7155a = a.f7162b;
        this.f7156b = d.f7150f;
        this.f7158d = true;
        this.f7157c = qVar;
        m(p.R);
    }

    public e(e eVar) {
        this(eVar, eVar.f7157c);
    }

    public e(e eVar, q qVar) {
        this.f7155a = a.f7162b;
        this.f7156b = d.f7150f;
        this.f7158d = true;
        this.f7155a = eVar.f7155a;
        this.f7156b = eVar.f7156b;
        this.f7158d = eVar.f7158d;
        this.f7159e = eVar.f7159e;
        this.f7160f = eVar.f7160f;
        this.f7161g = eVar.f7161g;
        this.f7157c = qVar;
    }
}
