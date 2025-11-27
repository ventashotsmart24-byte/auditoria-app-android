package ja;

import java.util.List;
import okhttp3.Dns;
import t9.i;

public final class c implements Dns {

    /* renamed from: a  reason: collision with root package name */
    public final String f17561a;

    /* renamed from: b  reason: collision with root package name */
    public b f17562b = b.f7201f.a();

    public c(String str) {
        i.g(str, "alias");
        this.f17561a = str;
    }

    public List lookup(String str) {
        i.g(str, "hostname");
        return this.f17562b.j(str, this.f17561a);
    }
}
