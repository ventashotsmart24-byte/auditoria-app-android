package anet.channel.util;

import com.raizlabs.android.dbflow.sql.language.Operator;
import java.net.Inet6Address;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public int f4017a;

    /* renamed from: b  reason: collision with root package name */
    public Inet6Address f4018b;

    public f(Inet6Address inet6Address, int i10) {
        this.f4017a = i10;
        this.f4018b = inet6Address;
    }

    public String toString() {
        return this.f4018b.getHostAddress() + Operator.Operation.DIVISION + this.f4017a;
    }
}
