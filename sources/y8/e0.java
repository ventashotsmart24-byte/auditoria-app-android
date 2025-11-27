package y8;

import com.google.common.base.Preconditions;
import com.hpplay.sdk.source.common.global.Constant;
import y8.a;
import y8.o0;

public abstract class e0 {

    /* renamed from: a  reason: collision with root package name */
    public static final a.c f19995a = a.c.a("internal:io.grpc.config-selector");

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final k1 f19996a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f19997b;

        /* renamed from: c  reason: collision with root package name */
        public h f19998c;

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public Object f19999a;

            /* renamed from: b  reason: collision with root package name */
            public h f20000b;

            public a() {
            }

            public b a() {
                boolean z10;
                if (this.f19999a != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                Preconditions.checkState(z10, "config is not set");
                return new b(k1.f20041f, this.f19999a, this.f20000b);
            }

            public a b(Object obj) {
                this.f19999a = Preconditions.checkNotNull(obj, "config");
                return this;
            }
        }

        public static a d() {
            return new a();
        }

        public Object a() {
            return this.f19997b;
        }

        public h b() {
            return this.f19998c;
        }

        public k1 c() {
            return this.f19996a;
        }

        public b(k1 k1Var, Object obj, h hVar) {
            this.f19996a = (k1) Preconditions.checkNotNull(k1Var, Constant.KEY_STATUS);
            this.f19997b = obj;
            this.f19998c = hVar;
        }
    }

    public abstract b a(o0.f fVar);
}
