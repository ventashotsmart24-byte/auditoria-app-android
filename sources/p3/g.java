package p3;

import c3.i;
import c3.k;
import java.util.Collection;
import java.util.Iterator;

public abstract class g extends f {

    /* renamed from: e  reason: collision with root package name */
    public final Class f8813e;

    /* renamed from: f  reason: collision with root package name */
    public final String f8814f;

    /* renamed from: g  reason: collision with root package name */
    public final Collection f8815g;

    /* renamed from: h  reason: collision with root package name */
    public transient String f8816h;

    public g(k kVar, String str, i iVar, Class cls, String str2, Collection collection) {
        super(kVar, str, iVar);
        this.f8813e = cls;
        this.f8814f = str2;
        this.f8815g = collection;
    }

    public String b() {
        String str = this.f8816h;
        if (str != null || this.f8815g == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.f8815g.size();
        if (size != 1) {
            sb.append(" (");
            sb.append(size);
            sb.append(" known properties: ");
            Iterator it = this.f8815g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                sb.append('\"');
                sb.append(String.valueOf(it.next()));
                sb.append('\"');
                if (sb.length() > 1000) {
                    sb.append(" [truncated]");
                    break;
                } else if (it.hasNext()) {
                    sb.append(", ");
                }
            }
        } else {
            sb.append(" (one known property: \"");
            sb.append(String.valueOf(this.f8815g.iterator().next()));
            sb.append('\"');
        }
        sb.append("])");
        String sb2 = sb.toString();
        this.f8816h = sb2;
        return sb2;
    }
}
