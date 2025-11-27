package y8;

import com.google.common.base.Preconditions;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import y8.a;

public final class x {

    /* renamed from: d  reason: collision with root package name */
    public static final a.c f20218d = a.c.a("io.grpc.EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE");

    /* renamed from: a  reason: collision with root package name */
    public final List f20219a;

    /* renamed from: b  reason: collision with root package name */
    public final a f20220b;

    /* renamed from: c  reason: collision with root package name */
    public final int f20221c;

    public x(List list) {
        this(list, a.f19923c);
    }

    public List a() {
        return this.f20219a;
    }

    public a b() {
        return this.f20220b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        if (this.f20219a.size() != xVar.f20219a.size()) {
            return false;
        }
        for (int i10 = 0; i10 < this.f20219a.size(); i10++) {
            if (!((SocketAddress) this.f20219a.get(i10)).equals(xVar.f20219a.get(i10))) {
                return false;
            }
        }
        if (!this.f20220b.equals(xVar.f20220b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f20221c;
    }

    public String toString() {
        return "[" + this.f20219a + Operator.Operation.DIVISION + this.f20220b + "]";
    }

    public x(List list, a aVar) {
        Preconditions.checkArgument(!list.isEmpty(), "addrs is empty");
        List unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.f20219a = unmodifiableList;
        this.f20220b = (a) Preconditions.checkNotNull(aVar, "attrs");
        this.f20221c = unmodifiableList.hashCode();
    }

    public x(SocketAddress socketAddress) {
        this(socketAddress, a.f19923c);
    }

    public x(SocketAddress socketAddress, a aVar) {
        this(Collections.singletonList(socketAddress), aVar);
    }
}
