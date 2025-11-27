package x9;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import t9.i;
import w9.a;

public final class b extends a {
    public Random d() {
        ThreadLocalRandom a10 = ThreadLocalRandom.current();
        i.f(a10, "current()");
        return a10;
    }
}
