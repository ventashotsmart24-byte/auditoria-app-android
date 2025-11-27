package z8;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;
import y8.b0;
import y8.f;

public interface t extends Closeable {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f20961a = "unknown-authority";

        /* renamed from: b  reason: collision with root package name */
        public y8.a f20962b = y8.a.f19923c;

        /* renamed from: c  reason: collision with root package name */
        public String f20963c;

        /* renamed from: d  reason: collision with root package name */
        public b0 f20964d;

        public String a() {
            return this.f20961a;
        }

        public y8.a b() {
            return this.f20962b;
        }

        public b0 c() {
            return this.f20964d;
        }

        public String d() {
            return this.f20963c;
        }

        public a e(String str) {
            this.f20961a = (String) Preconditions.checkNotNull(str, "authority");
            return this;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.f20961a.equals(aVar.f20961a) || !this.f20962b.equals(aVar.f20962b) || !Objects.equal(this.f20963c, aVar.f20963c) || !Objects.equal(this.f20964d, aVar.f20964d)) {
                return false;
            }
            return true;
        }

        public a f(y8.a aVar) {
            Preconditions.checkNotNull(aVar, "eagAttributes");
            this.f20962b = aVar;
            return this;
        }

        public a g(b0 b0Var) {
            this.f20964d = b0Var;
            return this;
        }

        public a h(String str) {
            this.f20963c = str;
            return this;
        }

        public int hashCode() {
            return Objects.hashCode(this.f20961a, this.f20962b, this.f20963c, this.f20964d);
        }
    }

    v J(SocketAddress socketAddress, a aVar, f fVar);

    void close();

    ScheduledExecutorService p();
}
