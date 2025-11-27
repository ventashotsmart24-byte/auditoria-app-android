package kotlinx.coroutines.internal;

import ca.v1;
import k9.f;
import s9.p;
import t9.i;
import t9.j;

public abstract class c0 {

    /* renamed from: a  reason: collision with root package name */
    public static final y f18251a = new y("NO_THREAD_ELEMENTS");

    /* renamed from: b  reason: collision with root package name */
    public static final p f18252b = a.f18255a;

    /* renamed from: c  reason: collision with root package name */
    public static final p f18253c = b.f18256a;

    /* renamed from: d  reason: collision with root package name */
    public static final p f18254d = c.f18257a;

    public static final class a extends j implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final a f18255a = new a();

        public a() {
            super(2);
        }

        /* renamed from: b */
        public final Object invoke(Object obj, f.b bVar) {
            Integer num;
            int i10;
            if (!(bVar instanceof v1)) {
                return obj;
            }
            if (obj instanceof Integer) {
                num = (Integer) obj;
            } else {
                num = null;
            }
            if (num != null) {
                i10 = num.intValue();
            } else {
                i10 = 1;
            }
            if (i10 == 0) {
                return bVar;
            }
            return Integer.valueOf(i10 + 1);
        }
    }

    public static final class b extends j implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final b f18256a = new b();

        public b() {
            super(2);
        }

        /* renamed from: b */
        public final v1 invoke(v1 v1Var, f.b bVar) {
            if (v1Var != null) {
                return v1Var;
            }
            if (bVar instanceof v1) {
                return (v1) bVar;
            }
            return null;
        }
    }

    public static final class c extends j implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final c f18257a = new c();

        public c() {
            super(2);
        }

        /* renamed from: b */
        public final f0 invoke(f0 f0Var, f.b bVar) {
            if (bVar instanceof v1) {
                v1 v1Var = (v1) bVar;
                f0Var.a(v1Var, v1Var.z(f0Var.f18265a));
            }
            return f0Var;
        }
    }

    public static final void a(f fVar, Object obj) {
        if (obj != f18251a) {
            if (obj instanceof f0) {
                ((f0) obj).b(fVar);
                return;
            }
            Object m10 = fVar.m((Object) null, f18253c);
            if (m10 != null) {
                ((v1) m10).I(fVar, obj);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
    }

    public static final Object b(f fVar) {
        Object m10 = fVar.m(0, f18252b);
        i.d(m10);
        return m10;
    }

    public static final Object c(f fVar, Object obj) {
        if (obj == null) {
            obj = b(fVar);
        }
        if (obj == 0) {
            return f18251a;
        }
        if (obj instanceof Integer) {
            return fVar.m(new f0(fVar, ((Number) obj).intValue()), f18254d);
        }
        return ((v1) obj).z(fVar);
    }
}
