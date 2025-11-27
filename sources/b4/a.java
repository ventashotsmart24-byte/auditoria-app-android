package b4;

import a4.s;
import b3.r;
import c3.h;
import d4.b;
import k3.c0;
import k3.j;
import k3.o;
import m3.m;
import r3.c;

public class a extends s {

    /* renamed from: u  reason: collision with root package name */
    public final String f4321u;

    public a(String str, r3.s sVar, b bVar, j jVar) {
        this(str, sVar, bVar, jVar, sVar.g());
    }

    public static a J(String str, r3.s sVar, b bVar, j jVar) {
        return new a(str, sVar, bVar, jVar);
    }

    public Object H(Object obj, h hVar, c0 c0Var) {
        return c0Var.X(this.f4321u);
    }

    public s I(m mVar, c cVar, r3.s sVar, j jVar) {
        throw new IllegalStateException("Should not be called on this type");
    }

    public a(String str, r3.s sVar, b bVar, j jVar, r.b bVar2) {
        super(sVar, bVar, jVar, (o) null, (w3.h) null, (j) null, bVar2, (Class[]) null);
        this.f4321u = str;
    }
}
