package aa;

import java.util.Iterator;
import t9.i;

public abstract class e extends d {

    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Iterator f10900a;

        public a(Iterator it) {
            this.f10900a = it;
        }

        public Iterator iterator() {
            return this.f10900a;
        }
    }

    public static final b a(Iterator it) {
        i.g(it, "<this>");
        return b(new a(it));
    }

    public static final b b(b bVar) {
        i.g(bVar, "<this>");
        if (bVar instanceof a) {
            return bVar;
        }
        return new a(bVar);
    }
}
