package p3;

import c3.i;
import c3.k;
import d4.h;
import java.io.Closeable;
import k3.j;
import k3.l;

public class f extends l {

    /* renamed from: d  reason: collision with root package name */
    public Class f8812d;

    public f(k kVar, String str) {
        this(kVar, str, (j) null);
    }

    public static f s(k kVar, Class cls, String str) {
        return new f(kVar, str, cls);
    }

    public static f t(k kVar, j jVar, String str) {
        return new f(kVar, str, jVar);
    }

    public f u(j jVar) {
        this.f8812d = jVar.q();
        return this;
    }

    public f(k kVar, String str, i iVar) {
        super((Closeable) kVar, str, iVar);
    }

    public f(k kVar, String str, Class cls) {
        super(kVar, str);
        this.f8812d = cls;
    }

    public f(k kVar, String str, j jVar) {
        super(kVar, str);
        this.f8812d = h.d0(jVar);
    }
}
