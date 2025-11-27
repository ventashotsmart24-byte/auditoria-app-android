package l9;

import h9.m;
import k9.f;
import kotlin.coroutines.Continuation;
import m9.c;
import m9.g;
import m9.i;
import s9.p;
import t9.a0;

public abstract class b {

    public static final class a extends i {

        /* renamed from: a  reason: collision with root package name */
        public int f18834a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ p f18835b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f18836c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Continuation continuation, p pVar, Object obj) {
            super(continuation);
            this.f18835b = pVar;
            this.f18836c = obj;
            t9.i.e(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        public Object invokeSuspend(Object obj) {
            int i10 = this.f18834a;
            if (i10 == 0) {
                this.f18834a = 1;
                m.b(obj);
                t9.i.e(this.f18835b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((p) a0.c(this.f18835b, 2)).invoke(this.f18836c, this);
            } else if (i10 == 1) {
                this.f18834a = 2;
                m.b(obj);
                return obj;
            } else {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
        }
    }

    /* renamed from: l9.b$b  reason: collision with other inner class name */
    public static final class C0272b extends c {

        /* renamed from: a  reason: collision with root package name */
        public int f18837a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ p f18838b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f18839c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0272b(Continuation continuation, f fVar, p pVar, Object obj) {
            super(continuation, fVar);
            this.f18838b = pVar;
            this.f18839c = obj;
            t9.i.e(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        public Object invokeSuspend(Object obj) {
            int i10 = this.f18837a;
            if (i10 == 0) {
                this.f18837a = 1;
                m.b(obj);
                t9.i.e(this.f18838b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((p) a0.c(this.f18838b, 2)).invoke(this.f18839c, this);
            } else if (i10 == 1) {
                this.f18837a = 2;
                m.b(obj);
                return obj;
            } else {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
        }
    }

    public static final Continuation a(p pVar, Object obj, Continuation continuation) {
        t9.i.g(pVar, "<this>");
        t9.i.g(continuation, "completion");
        Continuation a10 = g.a(continuation);
        if (pVar instanceof m9.a) {
            return ((m9.a) pVar).create(obj, a10);
        }
        f context = a10.getContext();
        if (context == k9.g.f18231a) {
            return new a(a10, pVar, obj);
        }
        return new C0272b(a10, context, pVar, obj);
    }

    public static final Continuation b(Continuation continuation) {
        c cVar;
        Continuation<Object> intercepted;
        t9.i.g(continuation, "<this>");
        if (continuation instanceof c) {
            cVar = (c) continuation;
        } else {
            cVar = null;
        }
        if (cVar == null || (intercepted = cVar.intercepted()) == null) {
            return continuation;
        }
        return intercepted;
    }
}
