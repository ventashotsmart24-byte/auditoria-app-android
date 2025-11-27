package kotlinx.coroutines.scheduling;

import androidx.concurrent.futures.b;
import com.google.common.util.concurrent.r;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class n {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18351b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f18352c;

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f18353d;

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f18354e;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReferenceArray f18355a = new AtomicReferenceArray(128);
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;

    static {
        Class<n> cls = n.class;
        f18351b = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "lastScheduledTask");
        f18352c = AtomicIntegerFieldUpdater.newUpdater(cls, "producerIndex");
        f18353d = AtomicIntegerFieldUpdater.newUpdater(cls, "consumerIndex");
        f18354e = AtomicIntegerFieldUpdater.newUpdater(cls, "blockingTasksInBuffer");
    }

    public static /* synthetic */ h b(n nVar, h hVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return nVar.a(hVar, z10);
    }

    public final h a(h hVar, boolean z10) {
        if (z10) {
            return c(hVar);
        }
        h hVar2 = (h) f18351b.getAndSet(this, hVar);
        if (hVar2 == null) {
            return null;
        }
        return c(hVar2);
    }

    public final h c(h hVar) {
        boolean z10 = true;
        if (hVar.f18340b.b() != 1) {
            z10 = false;
        }
        if (z10) {
            f18354e.incrementAndGet(this);
        }
        if (e() == 127) {
            return hVar;
        }
        int i10 = this.producerIndex & 127;
        while (this.f18355a.get(i10) != null) {
            Thread.yield();
        }
        this.f18355a.lazySet(i10, hVar);
        f18352c.incrementAndGet(this);
        return null;
    }

    public final void d(h hVar) {
        if (hVar != null) {
            boolean z10 = true;
            if (hVar.f18340b.b() != 1) {
                z10 = false;
            }
            if (z10) {
                f18354e.decrementAndGet(this);
            }
        }
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        if (this.lastScheduledTask != null) {
            return e() + 1;
        }
        return e();
    }

    public final void g(d dVar) {
        h hVar = (h) f18351b.getAndSet(this, (Object) null);
        if (hVar != null) {
            dVar.a(hVar);
        }
        do {
        } while (j(dVar));
    }

    public final h h() {
        h hVar = (h) f18351b.getAndSet(this, (Object) null);
        if (hVar == null) {
            return i();
        }
        return hVar;
    }

    public final h i() {
        h hVar;
        while (true) {
            int i10 = this.consumerIndex;
            if (i10 - this.producerIndex == 0) {
                return null;
            }
            int i11 = i10 & 127;
            if (f18353d.compareAndSet(this, i10, i10 + 1) && (hVar = (h) this.f18355a.getAndSet(i11, (Object) null)) != null) {
                d(hVar);
                return hVar;
            }
        }
    }

    public final boolean j(d dVar) {
        h i10 = i();
        if (i10 == null) {
            return false;
        }
        dVar.a(i10);
        return true;
    }

    public final long k(n nVar) {
        int i10 = nVar.consumerIndex;
        int i11 = nVar.producerIndex;
        AtomicReferenceArray atomicReferenceArray = nVar.f18355a;
        while (true) {
            boolean z10 = true;
            if (i10 == i11) {
                break;
            }
            int i12 = i10 & 127;
            if (nVar.blockingTasksInBuffer == 0) {
                break;
            }
            h hVar = (h) atomicReferenceArray.get(i12);
            if (hVar != null) {
                if (hVar.f18340b.b() != 1) {
                    z10 = false;
                }
                if (z10 && r.a(atomicReferenceArray, i12, hVar, (Object) null)) {
                    f18354e.decrementAndGet(nVar);
                    b(this, hVar, false, 2, (Object) null);
                    return -1;
                }
            }
            i10++;
        }
        return m(nVar, true);
    }

    public final long l(n nVar) {
        h i10 = nVar.i();
        if (i10 == null) {
            return m(nVar, false);
        }
        b(this, i10, false, 2, (Object) null);
        return -1;
    }

    public final long m(n nVar, boolean z10) {
        h hVar;
        do {
            hVar = (h) nVar.lastScheduledTask;
            if (hVar == null) {
                return -2;
            }
            if (z10) {
                boolean z11 = true;
                if (hVar.f18340b.b() != 1) {
                    z11 = false;
                }
                if (!z11) {
                    return -2;
                }
            }
            long a10 = l.f18347e.a() - hVar.f18339a;
            long j10 = l.f18343a;
            if (a10 < j10) {
                return j10 - a10;
            }
        } while (!b.a(f18351b, nVar, hVar, (Object) null));
        b(this, hVar, false, 2, (Object) null);
        return -1;
    }
}
