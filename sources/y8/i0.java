package y8;

import com.google.common.base.Preconditions;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.concurrent.atomic.AtomicLong;

public final class i0 {

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicLong f20017d = new AtomicLong();

    /* renamed from: a  reason: collision with root package name */
    public final String f20018a;

    /* renamed from: b  reason: collision with root package name */
    public final String f20019b;

    /* renamed from: c  reason: collision with root package name */
    public final long f20020c;

    public i0(String str, String str2, long j10) {
        Preconditions.checkNotNull(str, "typeName");
        Preconditions.checkArgument(!str.isEmpty(), "empty type");
        this.f20018a = str;
        this.f20019b = str2;
        this.f20020c = j10;
    }

    public static i0 a(Class cls, String str) {
        return b(c(cls), str);
    }

    public static i0 b(String str, String str2) {
        return new i0(str, str2, e());
    }

    public static String c(Class cls) {
        String simpleName = ((Class) Preconditions.checkNotNull(cls, "type")).getSimpleName();
        if (!simpleName.isEmpty()) {
            return simpleName;
        }
        return cls.getName().substring(cls.getPackage().getName().length() + 1);
    }

    public static long e() {
        return f20017d.incrementAndGet();
    }

    public long d() {
        return this.f20020c;
    }

    public String f() {
        return this.f20018a + Operator.Operation.LESS_THAN + this.f20020c + Operator.Operation.GREATER_THAN;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(f());
        if (this.f20019b != null) {
            sb.append(": (");
            sb.append(this.f20019b);
            sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
        }
        return sb.toString();
    }
}
