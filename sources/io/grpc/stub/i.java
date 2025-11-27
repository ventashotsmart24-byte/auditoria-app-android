package io.grpc.stub;

import com.google.common.base.Preconditions;
import y8.f1;
import y8.k1;
import y8.w0;

public abstract class i {

    public interface a extends b {
    }

    public interface b {
    }

    public static final class c implements f1 {

        /* renamed from: a  reason: collision with root package name */
        public final b f17462a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f17463b;

        public c(b bVar, boolean z10) {
            this.f17462a = bVar;
            this.f17463b = z10;
        }
    }

    public static f1 a(a aVar) {
        return new c(aVar, false);
    }

    public static void b(w0 w0Var, j jVar) {
        Preconditions.checkNotNull(w0Var, "methodDescriptor");
        Preconditions.checkNotNull(jVar, "responseObserver");
        jVar.onError(k1.f20054s.r(String.format("Method %s is unimplemented", new Object[]{w0Var.c()})).d());
    }
}
