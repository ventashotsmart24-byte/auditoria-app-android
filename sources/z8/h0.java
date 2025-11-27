package z8;

import com.google.common.base.MoreObjects;
import java.io.InputStream;
import y8.k1;
import y8.n;
import y8.t;
import y8.v;

public abstract class h0 implements q {
    public void a(n nVar) {
        f().a(nVar);
    }

    public void b(int i10) {
        f().b(i10);
    }

    public void c(int i10) {
        f().c(i10);
    }

    public void d(int i10) {
        f().d(i10);
    }

    public void e(k1 k1Var) {
        f().e(k1Var);
    }

    public abstract q f();

    public void flush() {
        f().flush();
    }

    public void g(r rVar) {
        f().g(rVar);
    }

    public void h(InputStream inputStream) {
        f().h(inputStream);
    }

    public void i() {
        f().i();
    }

    public void j(boolean z10) {
        f().j(z10);
    }

    public void k(t tVar) {
        f().k(tVar);
    }

    public void l(v vVar) {
        f().l(vVar);
    }

    public boolean m() {
        return f().m();
    }

    public void n(String str) {
        f().n(str);
    }

    public void o() {
        f().o();
    }

    public void p(w0 w0Var) {
        f().p(w0Var);
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("delegate", (Object) f()).toString();
    }
}
