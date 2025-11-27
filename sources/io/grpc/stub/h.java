package io.grpc.stub;

import com.google.common.base.Preconditions;
import y8.c;
import y8.d;
import y8.g;
import y8.v0;
import y8.w0;
import y8.y;

public abstract class h {

    public static final class a implements y8.h {

        /* renamed from: a  reason: collision with root package name */
        public final v0 f17460a;

        /* renamed from: io.grpc.stub.h$a$a  reason: collision with other inner class name */
        public final class C0231a extends y.a {
            public C0231a(g gVar) {
                super(gVar);
            }

            public void e(g.a aVar, v0 v0Var) {
                v0Var.l(a.this.f17460a);
                super.e(aVar, v0Var);
            }
        }

        public a(v0 v0Var) {
            this.f17460a = (v0) Preconditions.checkNotNull(v0Var, "extraHeaders");
        }

        public g a(w0 w0Var, c cVar, d dVar) {
            return new C0231a(dVar.h(w0Var, cVar));
        }
    }

    public static y8.h a(v0 v0Var) {
        return new a(v0Var);
    }
}
