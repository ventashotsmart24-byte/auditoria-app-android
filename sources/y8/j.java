package y8;

import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import y8.g;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    public static final g f20027a = new a();

    public class a extends g {
        public void a(String str, Throwable th) {
        }

        public void b() {
        }

        public void c(int i10) {
        }

        public void d(Object obj) {
        }

        public void e(g.a aVar, v0 v0Var) {
        }
    }

    public static class b extends d {

        /* renamed from: a  reason: collision with root package name */
        public final d f20028a;

        /* renamed from: b  reason: collision with root package name */
        public final h f20029b;

        public /* synthetic */ b(d dVar, h hVar, i iVar) {
            this(dVar, hVar);
        }

        public String a() {
            return this.f20028a.a();
        }

        public g h(w0 w0Var, c cVar) {
            return this.f20029b.a(w0Var, cVar, this.f20028a);
        }

        public b(d dVar, h hVar) {
            this.f20028a = dVar;
            this.f20029b = (h) Preconditions.checkNotNull(hVar, "interceptor");
        }
    }

    public static d a(d dVar, List list) {
        Preconditions.checkNotNull(dVar, "channel");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            dVar = new b(dVar, (h) it.next(), (i) null);
        }
        return dVar;
    }

    public static d b(d dVar, h... hVarArr) {
        return a(dVar, Arrays.asList(hVarArr));
    }
}
