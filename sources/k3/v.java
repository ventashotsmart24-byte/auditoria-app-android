package k3;

import a4.j;
import a4.q;
import c3.c;
import c3.e;
import c3.f;
import c3.h;
import c3.p;
import com.hpplay.cybergarage.upnp.Argument;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import j3.l;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;

public class v implements Serializable {

    /* renamed from: g  reason: collision with root package name */
    public static final p f7471g = new l();

    /* renamed from: a  reason: collision with root package name */
    public final a0 f7472a;

    /* renamed from: b  reason: collision with root package name */
    public final j f7473b;

    /* renamed from: c  reason: collision with root package name */
    public final q f7474c;

    /* renamed from: d  reason: collision with root package name */
    public final f f7475d;

    /* renamed from: e  reason: collision with root package name */
    public final a f7476e;

    /* renamed from: f  reason: collision with root package name */
    public final b f7477f;

    public static final class a implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        public static final a f7478c = new a((p) null, (c) null, (f3.b) null, (c3.q) null);

        /* renamed from: a  reason: collision with root package name */
        public final p f7479a;

        /* renamed from: b  reason: collision with root package name */
        public final c3.q f7480b;

        public a(p pVar, c cVar, f3.b bVar, c3.q qVar) {
            this.f7479a = pVar;
            this.f7480b = qVar;
        }

        public void a(h hVar) {
            p pVar = this.f7479a;
            if (pVar != null) {
                if (pVar == v.f7471g) {
                    hVar.I((p) null);
                } else {
                    if (pVar instanceof j3.f) {
                        pVar = (p) ((j3.f) pVar).f();
                    }
                    hVar.I(pVar);
                }
            }
            c3.q qVar = this.f7480b;
            if (qVar != null) {
                hVar.L(qVar);
            }
        }

        public a b(p pVar) {
            if (pVar == null) {
                pVar = v.f7471g;
            }
            if (pVar == this.f7479a) {
                return this;
            }
            return new a(pVar, (c) null, (f3.b) null, this.f7480b);
        }
    }

    public static final class b implements Serializable {

        /* renamed from: d  reason: collision with root package name */
        public static final b f7481d = new b((j) null, (o) null, (w3.h) null);

        /* renamed from: a  reason: collision with root package name */
        public final j f7482a;

        /* renamed from: b  reason: collision with root package name */
        public final o f7483b;

        /* renamed from: c  reason: collision with root package name */
        public final w3.h f7484c;

        public b(j jVar, o oVar, w3.h hVar) {
            this.f7482a = jVar;
            this.f7483b = oVar;
            this.f7484c = hVar;
        }

        public void a(h hVar, Object obj, j jVar) {
            w3.h hVar2 = this.f7484c;
            if (hVar2 != null) {
                jVar.B0(hVar, obj, this.f7482a, this.f7483b, hVar2);
                return;
            }
            o oVar = this.f7483b;
            if (oVar != null) {
                jVar.E0(hVar, obj, this.f7482a, oVar);
                return;
            }
            j jVar2 = this.f7482a;
            if (jVar2 != null) {
                jVar.D0(hVar, obj, jVar2);
            } else {
                jVar.C0(hVar, obj);
            }
        }
    }

    public v(t tVar, a0 a0Var) {
        this.f7472a = a0Var;
        this.f7473b = tVar.f7455h;
        this.f7474c = tVar.f7456i;
        this.f7475d = tVar.f7448a;
        this.f7476e = a.f7478c;
        this.f7477f = b.f7481d;
    }

    public final void a(String str, Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(String.format("argument \"%s\" is null", new Object[]{str}));
        }
    }

    public final h b(h hVar) {
        this.f7472a.a0(hVar);
        this.f7476e.a(hVar);
        return hVar;
    }

    public v c(a aVar, b bVar) {
        if (this.f7476e == aVar && this.f7477f == bVar) {
            return this;
        }
        return new v(this, this.f7472a, aVar, bVar);
    }

    public v d(v vVar, a0 a0Var) {
        if (a0Var == this.f7472a) {
            return this;
        }
        return new v(vVar, a0Var);
    }

    public j e() {
        return this.f7473b.A0(this.f7472a, this.f7474c);
    }

    public final void f(h hVar, Object obj) {
        Closeable closeable = (Closeable) obj;
        try {
            this.f7477f.a(hVar, obj, e());
            try {
                closeable.close();
                hVar.close();
            } catch (Exception e10) {
                e = e10;
                closeable = null;
                d4.h.j(hVar, closeable, e);
            }
        } catch (Exception e11) {
            e = e11;
            d4.h.j(hVar, closeable, e);
        }
    }

    public final void g(h hVar, Object obj) {
        if (!this.f7472a.c0(b0.CLOSE_CLOSEABLE) || !(obj instanceof Closeable)) {
            try {
                this.f7477f.a(hVar, obj, e());
                hVar.close();
            } catch (Exception e10) {
                d4.h.k(hVar, e10);
            }
        } else {
            f(hVar, obj);
        }
    }

    public h h(OutputStream outputStream, e eVar) {
        a(Argument.OUT, outputStream);
        return b(this.f7475d.k(outputStream, eVar));
    }

    public h i(Writer writer) {
        a(BrowserInfo.KEY_WIDTH, writer);
        return b(this.f7475d.l(writer));
    }

    public v j(p pVar) {
        return c(this.f7476e.b(pVar), this.f7477f);
    }

    public v k() {
        return j(this.f7472a.Y());
    }

    public v l(h.b bVar) {
        return d(this, this.f7472a.d0(bVar));
    }

    public void m(OutputStream outputStream, Object obj) {
        g(h(outputStream, e.UTF8), obj);
    }

    public String n(Object obj) {
        f3.h hVar = new f3.h(this.f7475d.i());
        try {
            g(i(hVar), obj);
            return hVar.a();
        } catch (c3.l e10) {
            throw e10;
        } catch (IOException e11) {
            throw l.l(e11);
        }
    }

    public v(v vVar, a0 a0Var, a aVar, b bVar) {
        this.f7472a = a0Var;
        this.f7473b = vVar.f7473b;
        this.f7474c = vVar.f7474c;
        this.f7475d = vVar.f7475d;
        this.f7476e = aVar;
        this.f7477f = bVar;
    }

    public v(v vVar, a0 a0Var) {
        this.f7472a = a0Var;
        this.f7473b = vVar.f7473b;
        this.f7474c = vVar.f7474c;
        this.f7475d = vVar.f7475d;
        this.f7476e = vVar.f7476e;
        this.f7477f = vVar.f7477f;
    }
}
