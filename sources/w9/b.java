package w9;

import java.util.Random;
import t9.i;

public final class b extends a {

    /* renamed from: c  reason: collision with root package name */
    public final a f19763c = new a();

    public static final class a extends ThreadLocal {
        /* renamed from: a */
        public Random initialValue() {
            return new Random();
        }
    }

    public Random d() {
        Object obj = this.f19763c.get();
        i.f(obj, "implStorage.get()");
        return (Random) obj;
    }
}
