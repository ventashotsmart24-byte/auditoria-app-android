package s6;

import t9.i;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f9335a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static b f9336b;

    public final b a() {
        b bVar = f9336b;
        if (bVar != null) {
            i.d(bVar);
            return bVar;
        }
        throw new NullPointerException("请设置： ProductAdapter");
    }

    public final void b(b bVar) {
        i.g(bVar, "adapter");
        f9336b = bVar;
    }
}
