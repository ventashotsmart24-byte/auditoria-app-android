package a9;

import a9.b;
import c9.i;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.net.Socket;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;
import z8.b2;

public final class a implements Sink {

    /* renamed from: a  reason: collision with root package name */
    public final Object f10717a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final Buffer f10718b = new Buffer();

    /* renamed from: c  reason: collision with root package name */
    public final b2 f10719c;

    /* renamed from: d  reason: collision with root package name */
    public final b.a f10720d;

    /* renamed from: e  reason: collision with root package name */
    public final int f10721e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10722f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10723g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10724h = false;

    /* renamed from: i  reason: collision with root package name */
    public Sink f10725i;

    /* renamed from: j  reason: collision with root package name */
    public Socket f10726j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f10727k;

    /* renamed from: l  reason: collision with root package name */
    public int f10728l;

    /* renamed from: m  reason: collision with root package name */
    public int f10729m;

    /* renamed from: a9.a$a  reason: collision with other inner class name */
    public class C0142a extends e {

        /* renamed from: b  reason: collision with root package name */
        public final g9.b f10730b = g9.c.e();

        public C0142a() {
            super(a.this, (C0142a) null);
        }

        public void a() {
            int e10;
            g9.c.f("WriteRunnable.runWrite");
            g9.c.d(this.f10730b);
            Buffer buffer = new Buffer();
            try {
                synchronized (a.this.f10717a) {
                    buffer.write(a.this.f10718b, a.this.f10718b.completeSegmentByteCount());
                    boolean unused = a.this.f10722f = false;
                    e10 = a.this.f10729m;
                }
                a.this.f10725i.write(buffer, buffer.size());
                synchronized (a.this.f10717a) {
                    a.f(a.this, e10);
                }
                g9.c.h("WriteRunnable.runWrite");
            } catch (Throwable th) {
                g9.c.h("WriteRunnable.runWrite");
                throw th;
            }
        }
    }

    public class b extends e {

        /* renamed from: b  reason: collision with root package name */
        public final g9.b f10732b = g9.c.e();

        public b() {
            super(a.this, (C0142a) null);
        }

        public void a() {
            g9.c.f("WriteRunnable.runFlush");
            g9.c.d(this.f10732b);
            Buffer buffer = new Buffer();
            try {
                synchronized (a.this.f10717a) {
                    buffer.write(a.this.f10718b, a.this.f10718b.size());
                    boolean unused = a.this.f10723g = false;
                }
                a.this.f10725i.write(buffer, buffer.size());
                a.this.f10725i.flush();
                g9.c.h("WriteRunnable.runFlush");
            } catch (Throwable th) {
                g9.c.h("WriteRunnable.runFlush");
                throw th;
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            try {
                if (a.this.f10725i != null && a.this.f10718b.size() > 0) {
                    a.this.f10725i.write(a.this.f10718b, a.this.f10718b.size());
                }
            } catch (IOException e10) {
                a.this.f10720d.h(e10);
            }
            a.this.f10718b.close();
            try {
                if (a.this.f10725i != null) {
                    a.this.f10725i.close();
                }
            } catch (IOException e11) {
                a.this.f10720d.h(e11);
            }
            try {
                if (a.this.f10726j != null) {
                    a.this.f10726j.close();
                }
            } catch (IOException e12) {
                a.this.f10720d.h(e12);
            }
        }
    }

    public class d extends c {
        public d(c9.c cVar) {
            super(cVar);
        }

        public void d(int i10, c9.a aVar) {
            a.u(a.this);
            super.d(i10, aVar);
        }

        public void g(i iVar) {
            a.u(a.this);
            super.g(iVar);
        }

        public void ping(boolean z10, int i10, int i11) {
            if (z10) {
                a.u(a.this);
            }
            super.ping(z10, i10, i11);
        }
    }

    public abstract class e implements Runnable {
        public e() {
        }

        public abstract void a();

        public final void run() {
            try {
                if (a.this.f10725i != null) {
                    a();
                    return;
                }
                throw new IOException("Unable to perform write due to unavailable sink.");
            } catch (Exception e10) {
                a.this.f10720d.h(e10);
            }
        }

        public /* synthetic */ e(a aVar, C0142a aVar2) {
            this();
        }
    }

    public a(b2 b2Var, b.a aVar, int i10) {
        this.f10719c = (b2) Preconditions.checkNotNull(b2Var, "executor");
        this.f10720d = (b.a) Preconditions.checkNotNull(aVar, "exceptionHandler");
        this.f10721e = i10;
    }

    public static /* synthetic */ int f(a aVar, int i10) {
        int i11 = aVar.f10729m - i10;
        aVar.f10729m = i11;
        return i11;
    }

    public static /* synthetic */ int u(a aVar) {
        int i10 = aVar.f10728l;
        aVar.f10728l = i10 + 1;
        return i10;
    }

    public static a y(b2 b2Var, b.a aVar, int i10) {
        return new a(b2Var, aVar, i10);
    }

    public void close() {
        if (!this.f10724h) {
            this.f10724h = true;
            this.f10719c.execute(new c());
        }
    }

    public void flush() {
        if (!this.f10724h) {
            g9.c.f("AsyncSink.flush");
            try {
                synchronized (this.f10717a) {
                    if (this.f10723g) {
                        g9.c.h("AsyncSink.flush");
                        return;
                    }
                    this.f10723g = true;
                    this.f10719c.execute(new b());
                    g9.c.h("AsyncSink.flush");
                }
            } catch (Throwable th) {
                g9.c.h("AsyncSink.flush");
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public void v(Sink sink, Socket socket) {
        boolean z10;
        if (this.f10725i == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "AsyncSink's becomeConnected should only be called once.");
        this.f10725i = (Sink) Preconditions.checkNotNull(sink, "sink");
        this.f10726j = (Socket) Preconditions.checkNotNull(socket, "socket");
    }

    public void write(Buffer buffer, long j10) {
        Preconditions.checkNotNull(buffer, "source");
        if (!this.f10724h) {
            g9.c.f("AsyncSink.write");
            try {
                synchronized (this.f10717a) {
                    this.f10718b.write(buffer, j10);
                    int i10 = this.f10729m + this.f10728l;
                    this.f10729m = i10;
                    boolean z10 = false;
                    this.f10728l = 0;
                    if (!this.f10727k && i10 > this.f10721e) {
                        this.f10727k = true;
                        z10 = true;
                    } else if (!this.f10722f && !this.f10723g) {
                        if (this.f10718b.completeSegmentByteCount() > 0) {
                            this.f10722f = true;
                        }
                    }
                    if (z10) {
                        this.f10726j.close();
                    } else {
                        this.f10719c.execute(new C0142a());
                        g9.c.h("AsyncSink.write");
                        return;
                    }
                }
            } catch (IOException e10) {
                this.f10720d.h(e10);
            } catch (Throwable th) {
                g9.c.h("AsyncSink.write");
                throw th;
            }
            g9.c.h("AsyncSink.write");
            return;
        }
        throw new IOException("closed");
    }

    public c9.c x(c9.c cVar) {
        return new d(cVar);
    }
}
