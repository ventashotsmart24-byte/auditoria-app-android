package a9;

import c9.d;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import y8.j0;
import y8.v0;
import z8.k2;

public abstract class r {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f10898a = Logger.getLogger(r.class.getName());

    public static v0 a(List list) {
        return j0.c(b(list));
    }

    public static byte[][] b(List list) {
        byte[][] bArr = new byte[(list.size() * 2)][];
        Iterator it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            d dVar = (d) it.next();
            int i11 = i10 + 1;
            bArr[i10] = dVar.f11420a.toByteArray();
            i10 = i11 + 1;
            bArr[i11] = dVar.f11421b.toByteArray();
        }
        return k2.e(bArr);
    }

    public static v0 c(List list) {
        return j0.c(b(list));
    }
}
