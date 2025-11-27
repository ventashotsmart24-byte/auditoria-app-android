package ca;

import k9.d;
import k9.f;
import k9.g;
import kotlin.coroutines.Continuation;
import s9.p;
import t9.j;
import t9.w;

public abstract class x {

    public static final class a extends j implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final a f11558a = new a();

        public a() {
            super(2);
        }

        /* renamed from: b */
        public final f invoke(f fVar, f.b bVar) {
            return fVar.s(bVar);
        }
    }

    public static final class b extends j implements p {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ w f11559a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f11560b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(w wVar, boolean z10) {
            super(2);
            this.f11559a = wVar;
            this.f11560b = z10;
        }

        /* renamed from: b */
        public final f invoke(f fVar, f.b bVar) {
            return fVar.s(bVar);
        }
    }

    public static final class c extends j implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final c f11561a = new c();

        public c() {
            super(2);
        }

        public final Boolean b(boolean z10, f.b bVar) {
            boolean z11;
            if (!z10) {
                z11 = false;
            } else {
                z11 = true;
            }
            return Boolean.valueOf(z11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return b(((Boolean) obj).booleanValue(), (f.b) obj2);
        }
    }

    public static final f a(f fVar, f fVar2, boolean z10) {
        boolean c10 = c(fVar);
        boolean c11 = c(fVar2);
        if (!c10 && !c11) {
            return fVar.s(fVar2);
        }
        w wVar = new w();
        wVar.f19600a = fVar2;
        g gVar = g.f18231a;
        f fVar3 = (f) fVar.m(gVar, new b(wVar, z10));
        if (c11) {
            wVar.f19600a = ((f) wVar.f19600a).m(gVar, a.f11558a);
        }
        return fVar3.s((f) wVar.f19600a);
    }

    public static final String b(f fVar) {
        return null;
    }

    public static final boolean c(f fVar) {
        return ((Boolean) fVar.m(Boolean.FALSE, c.f11561a)).booleanValue();
    }

    public static final f d(c0 c0Var, f fVar) {
        f a10 = a(c0Var.d(), fVar, true);
        if (a10 == n0.a() || a10.a(d.f18228e0) != null) {
            return a10;
        }
        return a10.s(n0.a());
    }

    public static final y1 e(m9.d dVar) {
        do {
            dVar = dVar.getCallerFrame();
        } while (dVar != null);
        return null;
    }

    public static final y1 f(Continuation continuation, f fVar, Object obj) {
        boolean z10;
        if (!(continuation instanceof m9.d)) {
            return null;
        }
        if (fVar.a(z1.f11568a) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return null;
        }
        e((m9.d) continuation);
        return null;
    }
}
