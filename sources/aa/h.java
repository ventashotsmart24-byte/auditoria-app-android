package aa;

import java.util.Iterator;
import s9.l;
import t9.i;

public final class h implements b {

    /* renamed from: a  reason: collision with root package name */
    public final b f10902a;

    /* renamed from: b  reason: collision with root package name */
    public final l f10903b;

    public static final class a implements Iterator, u9.a {

        /* renamed from: a  reason: collision with root package name */
        public final Iterator f10904a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f10905b;

        public a(h hVar) {
            this.f10905b = hVar;
            this.f10904a = hVar.f10902a.iterator();
        }

        public boolean hasNext() {
            return this.f10904a.hasNext();
        }

        public Object next() {
            return this.f10905b.f10903b.invoke(this.f10904a.next());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public h(b bVar, l lVar) {
        i.g(bVar, "sequence");
        i.g(lVar, "transformer");
        this.f10902a = bVar;
        this.f10903b = lVar;
    }

    public Iterator iterator() {
        return new a(this);
    }
}
