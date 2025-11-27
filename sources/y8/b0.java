package y8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public final class b0 extends c1 {

    /* renamed from: a  reason: collision with root package name */
    public final SocketAddress f19938a;

    /* renamed from: b  reason: collision with root package name */
    public final InetSocketAddress f19939b;

    /* renamed from: c  reason: collision with root package name */
    public final String f19940c;

    /* renamed from: d  reason: collision with root package name */
    public final String f19941d;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public SocketAddress f19942a;

        /* renamed from: b  reason: collision with root package name */
        public InetSocketAddress f19943b;

        /* renamed from: c  reason: collision with root package name */
        public String f19944c;

        /* renamed from: d  reason: collision with root package name */
        public String f19945d;

        public b0 a() {
            return new b0(this.f19942a, this.f19943b, this.f19944c, this.f19945d);
        }

        public b b(String str) {
            this.f19945d = str;
            return this;
        }

        public b c(SocketAddress socketAddress) {
            this.f19942a = (SocketAddress) Preconditions.checkNotNull(socketAddress, "proxyAddress");
            return this;
        }

        public b d(InetSocketAddress inetSocketAddress) {
            this.f19943b = (InetSocketAddress) Preconditions.checkNotNull(inetSocketAddress, "targetAddress");
            return this;
        }

        public b e(String str) {
            this.f19944c = str;
            return this;
        }

        public b() {
        }
    }

    public static b e() {
        return new b();
    }

    public String a() {
        return this.f19941d;
    }

    public SocketAddress b() {
        return this.f19938a;
    }

    public InetSocketAddress c() {
        return this.f19939b;
    }

    public String d() {
        return this.f19940c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        if (!Objects.equal(this.f19938a, b0Var.f19938a) || !Objects.equal(this.f19939b, b0Var.f19939b) || !Objects.equal(this.f19940c, b0Var.f19940c) || !Objects.equal(this.f19941d, b0Var.f19941d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.f19938a, this.f19939b, this.f19940c, this.f19941d);
    }

    public String toString() {
        boolean z10;
        MoreObjects.ToStringHelper add = MoreObjects.toStringHelper((Object) this).add("proxyAddr", (Object) this.f19938a).add("targetAddr", (Object) this.f19939b).add("username", (Object) this.f19940c);
        if (this.f19941d != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return add.add("hasPassword", z10).toString();
    }

    public b0(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, String str, String str2) {
        Preconditions.checkNotNull(socketAddress, "proxyAddress");
        Preconditions.checkNotNull(inetSocketAddress, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            Preconditions.checkState(!((InetSocketAddress) socketAddress).isUnresolved(), "The proxy address %s is not resolved", (Object) socketAddress);
        }
        this.f19938a = socketAddress;
        this.f19939b = inetSocketAddress;
        this.f19940c = str;
        this.f19941d = str2;
    }
}
