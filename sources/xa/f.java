package xa;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

public final class f extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final i f9766a = new i();

    /* renamed from: b  reason: collision with root package name */
    public final int f9767b;

    /* renamed from: c  reason: collision with root package name */
    public final c f9768c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9769d;

    public f(c cVar, Looper looper, int i10) {
        super(looper);
        this.f9768c = cVar;
        this.f9767b = i10;
    }

    public void a(n nVar, Object obj) {
        h a10 = h.a(nVar, obj);
        synchronized (this) {
            this.f9766a.a(a10);
            if (!this.f9769d) {
                this.f9769d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new e("Could not send handler message");
                }
            }
        }
    }

    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                h b10 = this.f9766a.b();
                if (b10 == null) {
                    synchronized (this) {
                        b10 = this.f9766a.b();
                        if (b10 == null) {
                            this.f9769d = false;
                            return;
                        }
                    }
                }
                this.f9768c.f(b10);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.f9767b));
            if (sendMessage(obtainMessage())) {
                this.f9769d = true;
                return;
            }
            throw new e("Could not send handler message");
        } catch (Throwable th) {
            this.f9769d = false;
            throw th;
        }
    }
}
