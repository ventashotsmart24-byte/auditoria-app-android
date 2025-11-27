package z8;

import java.util.concurrent.atomic.AtomicLong;

public final class i implements d1 {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicLong f20683a = new AtomicLong();

    public void add(long j10) {
        this.f20683a.getAndAdd(j10);
    }
}
