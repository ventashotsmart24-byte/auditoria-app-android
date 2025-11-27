package z8;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.utl.BaseMonitor;
import java.net.URI;
import y8.k0;
import y8.y0;
import y8.z0;

public final class d0 extends z0 {
    public String a() {
        return BaseMonitor.COUNT_POINT_DNS;
    }

    public boolean d() {
        return true;
    }

    public int e() {
        return 5;
    }

    /* renamed from: f */
    public c0 b(URI uri, y0.a aVar) {
        if (!BaseMonitor.COUNT_POINT_DNS.equals(uri.getScheme())) {
            return null;
        }
        String str = (String) Preconditions.checkNotNull(uri.getPath(), "targetPath");
        Preconditions.checkArgument(str.startsWith(Operator.Operation.DIVISION), "the path component (%s) of the target (%s) must start with '/'", (Object) str, (Object) uri);
        return new c0(uri.getAuthority(), str.substring(1), aVar, q0.f20892u, Stopwatch.createUnstarted(), k0.a(d0.class.getClassLoader()));
    }
}
