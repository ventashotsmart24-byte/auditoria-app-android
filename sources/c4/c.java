package c4;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.Iterator;
import k3.j;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final c f4814a;

    /* renamed from: b  reason: collision with root package name */
    public final Class f4815b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f4816c;

    public c(Class cls) {
        this((c) null, cls);
    }

    public void a(k kVar) {
        if (this.f4816c == null) {
            this.f4816c = new ArrayList();
        }
        this.f4816c.add(kVar);
    }

    public c b(Class cls) {
        return new c(this, cls);
    }

    public c c(Class cls) {
        if (this.f4815b == cls) {
            return this;
        }
        for (c cVar = this.f4814a; cVar != null; cVar = cVar.f4814a) {
            if (cVar.f4815b == cls) {
                return cVar;
            }
        }
        return null;
    }

    public void d(j jVar) {
        ArrayList arrayList = this.f4816c;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((k) it.next()).c0(jVar);
            }
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("[ClassStack (self-refs: ");
        ArrayList arrayList = this.f4816c;
        if (arrayList == null) {
            str = "0";
        } else {
            str = String.valueOf(arrayList.size());
        }
        sb.append(str);
        sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
        for (c cVar = this; cVar != null; cVar = cVar.f4814a) {
            sb.append(' ');
            sb.append(cVar.f4815b.getName());
        }
        sb.append(']');
        return sb.toString();
    }

    public c(c cVar, Class cls) {
        this.f4814a = cVar;
        this.f4815b = cls;
    }
}
