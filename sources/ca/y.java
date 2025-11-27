package ca;

import k9.b;
import k9.d;
import k9.f;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.k;
import s9.l;
import t9.g;
import t9.j;

public abstract class y extends k9.a implements d {

    /* renamed from: b  reason: collision with root package name */
    public static final a f11564b = new a((g) null);

    public static final class a extends b {

        /* renamed from: ca.y$a$a  reason: collision with other inner class name */
        public static final class C0155a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final C0155a f11565a = new C0155a();

            public C0155a() {
                super(1);
            }

            /* renamed from: b */
            public final y invoke(f.b bVar) {
                if (bVar instanceof y) {
                    return (y) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public a() {
            super(d.f18228e0, C0155a.f11565a);
        }
    }

    public y() {
        super(d.f18228e0);
    }

    public f E(f.c cVar) {
        return d.a.b(this, cVar);
    }

    public abstract void L(f fVar, Runnable runnable);

    public boolean M(f fVar) {
        return true;
    }

    public y N(int i10) {
        k.a(i10);
        return new kotlinx.coroutines.internal.j(this, i10);
    }

    public f.b a(f.c cVar) {
        return d.a.a(this, cVar);
    }

    public final void b(Continuation continuation) {
        ((kotlinx.coroutines.internal.f) continuation).l();
    }

    public final Continuation c(Continuation continuation) {
        return new kotlinx.coroutines.internal.f(this, continuation);
    }

    public String toString() {
        return g0.a(this) + '@' + g0.b(this);
    }
}
