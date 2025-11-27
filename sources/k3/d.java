package k3;

import b3.k;
import b3.r;
import d4.r;
import java.io.Serializable;
import m3.m;
import r3.i;

public interface d extends r {

    /* renamed from: c0  reason: collision with root package name */
    public static final k.d f7353c0 = new k.d();

    /* renamed from: d0  reason: collision with root package name */
    public static final r.b f7354d0 = r.b.c();

    public static class a implements d, Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final x f7355a;

        /* renamed from: b  reason: collision with root package name */
        public final j f7356b;

        /* renamed from: c  reason: collision with root package name */
        public final x f7357c;

        /* renamed from: d  reason: collision with root package name */
        public final w f7358d;

        /* renamed from: e  reason: collision with root package name */
        public final i f7359e;

        public a(x xVar, j jVar, x xVar2, i iVar, w wVar) {
            this.f7355a = xVar;
            this.f7356b = jVar;
            this.f7357c = xVar2;
            this.f7358d = wVar;
            this.f7359e = iVar;
        }

        public k.d a(m mVar, Class cls) {
            i iVar;
            k.d q10;
            k.d o10 = mVar.o(cls);
            b g10 = mVar.g();
            if (g10 == null || (iVar = this.f7359e) == null || (q10 = g10.q(iVar)) == null) {
                return o10;
            }
            return o10.r(q10);
        }

        public r.b b(m mVar, Class cls) {
            i iVar;
            r.b M;
            r.b l10 = mVar.l(cls, this.f7356b.q());
            b g10 = mVar.g();
            if (g10 == null || (iVar = this.f7359e) == null || (M = g10.M(iVar)) == null) {
                return l10;
            }
            return l10.m(M);
        }

        public x c() {
            return this.f7355a;
        }

        public i d() {
            return this.f7359e;
        }

        public x e() {
            return this.f7357c;
        }

        public w getMetadata() {
            return this.f7358d;
        }

        public String getName() {
            return this.f7355a.c();
        }

        public j getType() {
            return this.f7356b;
        }
    }

    k.d a(m mVar, Class cls);

    r.b b(m mVar, Class cls);

    x c();

    i d();

    w getMetadata();

    String getName();

    j getType();
}
