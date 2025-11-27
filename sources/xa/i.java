package xa;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public h f9776a;

    /* renamed from: b  reason: collision with root package name */
    public h f9777b;

    public synchronized void a(h hVar) {
        if (hVar != null) {
            try {
                h hVar2 = this.f9777b;
                if (hVar2 != null) {
                    hVar2.f9775c = hVar;
                    this.f9777b = hVar;
                } else if (this.f9776a == null) {
                    this.f9777b = hVar;
                    this.f9776a = hVar;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("null cannot be enqueued");
        }
    }

    public synchronized h b() {
        h hVar;
        hVar = this.f9776a;
        if (hVar != null) {
            h hVar2 = hVar.f9775c;
            this.f9776a = hVar2;
            if (hVar2 == null) {
                this.f9777b = null;
            }
        }
        return hVar;
    }

    public synchronized h c(int i10) {
        if (this.f9776a == null) {
            wait((long) i10);
        }
        return b();
    }
}
