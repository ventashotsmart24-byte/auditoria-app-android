package n3;

import c3.i;
import c3.k;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k3.l;
import o3.z;

public class u extends l {

    /* renamed from: d  reason: collision with root package name */
    public z f8304d;

    /* renamed from: e  reason: collision with root package name */
    public List f8305e;

    public u(k kVar, String str, i iVar, z zVar) {
        super((Closeable) kVar, str, iVar);
        this.f8304d = zVar;
    }

    public String getMessage() {
        String message = super.getMessage();
        if (this.f8305e == null) {
            return message;
        }
        StringBuilder sb = new StringBuilder(message);
        Iterator it = this.f8305e.iterator();
        while (it.hasNext()) {
            sb.append(((v) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append('.');
        return sb.toString();
    }

    public void s(Object obj, Class cls, i iVar) {
        this.f8305e.add(new v(obj, cls, iVar));
    }

    public z t() {
        return this.f8304d;
    }

    public u(k kVar, String str) {
        super(kVar, str);
        this.f8305e = new ArrayList();
    }
}
