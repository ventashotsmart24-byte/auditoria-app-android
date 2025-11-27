package j3;

import c3.h;
import c3.p;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;

public class l implements p, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f7172a;

    /* renamed from: b  reason: collision with root package name */
    public n f7173b;

    public l() {
        this(p.T.toString());
    }

    public void a(h hVar) {
        hVar.m0(this.f7173b.c());
    }

    public void b(h hVar) {
        hVar.m0('[');
    }

    public void c(h hVar) {
    }

    public void d(h hVar, int i10) {
        hVar.m0(']');
    }

    public void e(h hVar) {
        hVar.m0(ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN);
    }

    public void g(h hVar) {
        hVar.m0(this.f7173b.b());
    }

    public void h(h hVar) {
        hVar.m0(this.f7173b.d());
    }

    public void i(h hVar, int i10) {
        hVar.m0(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
    }

    public void j(h hVar) {
        String str = this.f7172a;
        if (str != null) {
            hVar.o0(str);
        }
    }

    public void k(h hVar) {
    }

    public l(String str) {
        this.f7172a = str;
        this.f7173b = p.R;
    }
}
