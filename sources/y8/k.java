package y8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

public abstract class k extends n1 {

    public static abstract class a {
        public abstract k a(b bVar, v0 v0Var);
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final c f20033a;

        /* renamed from: b  reason: collision with root package name */
        public final int f20034b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f20035c;

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public c f20036a = c.f19946k;

            /* renamed from: b  reason: collision with root package name */
            public int f20037b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f20038c;

            public b a() {
                return new b(this.f20036a, this.f20037b, this.f20038c);
            }

            public a b(c cVar) {
                this.f20036a = (c) Preconditions.checkNotNull(cVar, "callOptions cannot be null");
                return this;
            }

            public a c(boolean z10) {
                this.f20038c = z10;
                return this;
            }

            public a d(int i10) {
                this.f20037b = i10;
                return this;
            }
        }

        public b(c cVar, int i10, boolean z10) {
            this.f20033a = (c) Preconditions.checkNotNull(cVar, "callOptions");
            this.f20034b = i10;
            this.f20035c = z10;
        }

        public static a a() {
            return new a();
        }

        public String toString() {
            return MoreObjects.toStringHelper((Object) this).add("callOptions", (Object) this.f20033a).add("previousAttempts", this.f20034b).add("isTransparentRetry", this.f20035c).toString();
        }
    }

    public void j() {
    }

    public void k(v0 v0Var) {
    }

    public void l() {
    }

    public void m(a aVar, v0 v0Var) {
    }
}
