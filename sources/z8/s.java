package z8;

import java.util.concurrent.Executor;
import y8.c;
import y8.h0;
import y8.k;
import y8.v0;
import y8.w0;

public interface s extends h0 {

    public interface a {
        void a(long j10);

        void onFailure(Throwable th);
    }

    q b(w0 w0Var, v0 v0Var, c cVar, k[] kVarArr);

    void f(a aVar, Executor executor);
}
