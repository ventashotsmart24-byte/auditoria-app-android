package z8;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;
import y8.i0;
import y8.k;
import y8.k1;
import y8.o0;
import y8.o1;
import y8.r;
import y8.v0;
import y8.w0;
import z8.j1;
import z8.r;

public final class a0 implements j1 {

    /* renamed from: a  reason: collision with root package name */
    public final i0 f20306a = i0.a(a0.class, (String) null);

    /* renamed from: b  reason: collision with root package name */
    public final Object f20307b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public final Executor f20308c;

    /* renamed from: d  reason: collision with root package name */
    public final o1 f20309d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f20310e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f20311f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f20312g;

    /* renamed from: h  reason: collision with root package name */
    public j1.a f20313h;

    /* renamed from: i  reason: collision with root package name */
    public Collection f20314i = new LinkedHashSet();

    /* renamed from: j  reason: collision with root package name */
    public k1 f20315j;

    /* renamed from: k  reason: collision with root package name */
    public o0.i f20316k;

    /* renamed from: l  reason: collision with root package name */
    public long f20317l;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j1.a f20318a;

        public a(j1.a aVar) {
            this.f20318a = aVar;
        }

        public void run() {
            this.f20318a.b(true);
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j1.a f20320a;

        public b(j1.a aVar) {
            this.f20320a = aVar;
        }

        public void run() {
            this.f20320a.b(false);
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j1.a f20322a;

        public c(j1.a aVar) {
            this.f20322a = aVar;
        }

        public void run() {
            this.f20322a.d();
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k1 f20324a;

        public d(k1 k1Var) {
            this.f20324a = k1Var;
        }

        public void run() {
            a0.this.f20313h.c(this.f20324a);
        }
    }

    public class e extends b0 {

        /* renamed from: j  reason: collision with root package name */
        public final o0.f f20326j;

        /* renamed from: k  reason: collision with root package name */
        public final r f20327k;

        /* renamed from: l  reason: collision with root package name */
        public final k[] f20328l;

        public /* synthetic */ e(a0 a0Var, o0.f fVar, k[] kVarArr, a aVar) {
            this(fVar, kVarArr);
        }

        /* JADX INFO: finally extract failed */
        public final Runnable A(s sVar) {
            r b10 = this.f20327k.b();
            try {
                q b11 = sVar.b(this.f20326j.c(), this.f20326j.b(), this.f20326j.a(), this.f20328l);
                this.f20327k.f(b10);
                return w(b11);
            } catch (Throwable th) {
                this.f20327k.f(b10);
                throw th;
            }
        }

        public void e(k1 k1Var) {
            super.e(k1Var);
            synchronized (a0.this.f20307b) {
                if (a0.this.f20312g != null) {
                    boolean remove = a0.this.f20314i.remove(this);
                    if (!a0.this.q() && remove) {
                        a0.this.f20309d.b(a0.this.f20311f);
                        if (a0.this.f20315j != null) {
                            a0.this.f20309d.b(a0.this.f20312g);
                            Runnable unused = a0.this.f20312g = null;
                        }
                    }
                }
            }
            a0.this.f20309d.a();
        }

        public void p(w0 w0Var) {
            if (this.f20326j.a().j()) {
                w0Var.a("wait_for_ready");
            }
            super.p(w0Var);
        }

        public void u(k1 k1Var) {
            for (k i10 : this.f20328l) {
                i10.i(k1Var);
            }
        }

        public e(o0.f fVar, k[] kVarArr) {
            this.f20327k = r.e();
            this.f20326j = fVar;
            this.f20328l = kVarArr;
        }
    }

    public a0(Executor executor, o1 o1Var) {
        this.f20308c = executor;
        this.f20309d = o1Var;
    }

    public final q b(w0 w0Var, v0 v0Var, y8.c cVar, k[] kVarArr) {
        q f0Var;
        try {
            r1 r1Var = new r1(w0Var, v0Var, cVar);
            o0.i iVar = null;
            long j10 = -1;
            while (true) {
                synchronized (this.f20307b) {
                    if (this.f20315j == null) {
                        o0.i iVar2 = this.f20316k;
                        if (iVar2 != null) {
                            if (iVar != null && j10 == this.f20317l) {
                                f0Var = o(r1Var, kVarArr);
                                break;
                            }
                            j10 = this.f20317l;
                            s j11 = q0.j(iVar2.a(r1Var), cVar.j());
                            if (j11 != null) {
                                f0Var = j11.b(r1Var.c(), r1Var.b(), r1Var.a(), kVarArr);
                                break;
                            }
                            iVar = iVar2;
                        } else {
                            f0Var = o(r1Var, kVarArr);
                            break;
                        }
                    } else {
                        f0Var = new f0(this.f20315j, kVarArr);
                        break;
                    }
                }
            }
            this.f20309d.a();
            return f0Var;
        } catch (Throwable th) {
            this.f20309d.a();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        r3.f20309d.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(y8.k1 r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f20307b
            monitor-enter(r0)
            y8.k1 r1 = r3.f20315j     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            return
        L_0x0009:
            r3.f20315j = r4     // Catch:{ all -> 0x002e }
            y8.o1 r1 = r3.f20309d     // Catch:{ all -> 0x002e }
            z8.a0$d r2 = new z8.a0$d     // Catch:{ all -> 0x002e }
            r2.<init>(r4)     // Catch:{ all -> 0x002e }
            r1.b(r2)     // Catch:{ all -> 0x002e }
            boolean r4 = r3.q()     // Catch:{ all -> 0x002e }
            if (r4 != 0) goto L_0x0027
            java.lang.Runnable r4 = r3.f20312g     // Catch:{ all -> 0x002e }
            if (r4 == 0) goto L_0x0027
            y8.o1 r1 = r3.f20309d     // Catch:{ all -> 0x002e }
            r1.b(r4)     // Catch:{ all -> 0x002e }
            r4 = 0
            r3.f20312g = r4     // Catch:{ all -> 0x002e }
        L_0x0027:
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            y8.o1 r4 = r3.f20309d
            r4.a()
            return
        L_0x002e:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.a0.c(y8.k1):void");
    }

    public i0 d() {
        return this.f20306a;
    }

    public final Runnable e(j1.a aVar) {
        this.f20313h = aVar;
        this.f20310e = new a(aVar);
        this.f20311f = new b(aVar);
        this.f20312g = new c(aVar);
        return null;
    }

    public final void g(k1 k1Var) {
        Collection<e> collection;
        Runnable runnable;
        c(k1Var);
        synchronized (this.f20307b) {
            collection = this.f20314i;
            runnable = this.f20312g;
            this.f20312g = null;
            if (!collection.isEmpty()) {
                this.f20314i = Collections.emptyList();
            }
        }
        if (runnable != null) {
            for (e eVar : collection) {
                Runnable w10 = eVar.w(new f0(k1Var, r.a.REFUSED, eVar.f20328l));
                if (w10 != null) {
                    w10.run();
                }
            }
            this.f20309d.execute(runnable);
        }
    }

    public final e o(o0.f fVar, k[] kVarArr) {
        e eVar = new e(this, fVar, kVarArr, (a) null);
        this.f20314i.add(eVar);
        if (p() == 1) {
            this.f20309d.b(this.f20310e);
        }
        return eVar;
    }

    public final int p() {
        int size;
        synchronized (this.f20307b) {
            size = this.f20314i.size();
        }
        return size;
    }

    public final boolean q() {
        boolean z10;
        synchronized (this.f20307b) {
            if (!this.f20314i.isEmpty()) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        r0 = new java.util.ArrayList();
        r1 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        if (r1.hasNext() == false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r2 = (z8.a0.e) r1.next();
        r3 = r8.a(z8.a0.e.y(r2));
        r4 = z8.a0.e.y(r2).a();
        r3 = z8.q0.j(r3, r4.j());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004b, code lost:
        if (r3 == null) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        r5 = r7.f20308c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
        if (r4.e() == null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0055, code lost:
        r5 = r4.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0059, code lost:
        r3 = z8.a0.e.z(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005d, code lost:
        if (r3 == null) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005f, code lost:
        r5.execute(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0062, code lost:
        r0.add(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0066, code lost:
        r8 = r7.f20307b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        monitor-enter(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006d, code lost:
        if (q() != false) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006f, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0070, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0071, code lost:
        r7.f20314i.removeAll(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007c, code lost:
        if (r7.f20314i.isEmpty() == false) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007e, code lost:
        r7.f20314i = new java.util.LinkedHashSet();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0089, code lost:
        if (q() != false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008b, code lost:
        r7.f20309d.b(r7.f20311f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0094, code lost:
        if (r7.f20315j == null) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0096, code lost:
        r0 = r7.f20312g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0098, code lost:
        if (r0 == null) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009a, code lost:
        r7.f20309d.b(r0);
        r7.f20312g = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a2, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a3, code lost:
        r7.f20309d.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a8, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void r(y8.o0.i r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f20307b
            monitor-enter(r0)
            r7.f20316k = r8     // Catch:{ all -> 0x00ae }
            long r1 = r7.f20317l     // Catch:{ all -> 0x00ae }
            r3 = 1
            long r1 = r1 + r3
            r7.f20317l = r1     // Catch:{ all -> 0x00ae }
            if (r8 == 0) goto L_0x00ac
            boolean r1 = r7.q()     // Catch:{ all -> 0x00ae }
            if (r1 != 0) goto L_0x0016
            goto L_0x00ac
        L_0x0016:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00ae }
            java.util.Collection r2 = r7.f20314i     // Catch:{ all -> 0x00ae }
            r1.<init>(r2)     // Catch:{ all -> 0x00ae }
            monitor-exit(r0)     // Catch:{ all -> 0x00ae }
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x0027:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0066
            java.lang.Object r2 = r1.next()
            z8.a0$e r2 = (z8.a0.e) r2
            y8.o0$f r3 = r2.f20326j
            y8.o0$e r3 = r8.a(r3)
            y8.o0$f r4 = r2.f20326j
            y8.c r4 = r4.a()
            boolean r5 = r4.j()
            z8.s r3 = z8.q0.j(r3, r5)
            if (r3 == 0) goto L_0x0027
            java.util.concurrent.Executor r5 = r7.f20308c
            java.util.concurrent.Executor r6 = r4.e()
            if (r6 == 0) goto L_0x0059
            java.util.concurrent.Executor r5 = r4.e()
        L_0x0059:
            java.lang.Runnable r3 = r2.A(r3)
            if (r3 == 0) goto L_0x0062
            r5.execute(r3)
        L_0x0062:
            r0.add(r2)
            goto L_0x0027
        L_0x0066:
            java.lang.Object r8 = r7.f20307b
            monitor-enter(r8)
            boolean r1 = r7.q()     // Catch:{ all -> 0x00a9 }
            if (r1 != 0) goto L_0x0071
            monitor-exit(r8)     // Catch:{ all -> 0x00a9 }
            return
        L_0x0071:
            java.util.Collection r1 = r7.f20314i     // Catch:{ all -> 0x00a9 }
            r1.removeAll(r0)     // Catch:{ all -> 0x00a9 }
            java.util.Collection r0 = r7.f20314i     // Catch:{ all -> 0x00a9 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x0085
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet     // Catch:{ all -> 0x00a9 }
            r0.<init>()     // Catch:{ all -> 0x00a9 }
            r7.f20314i = r0     // Catch:{ all -> 0x00a9 }
        L_0x0085:
            boolean r0 = r7.q()     // Catch:{ all -> 0x00a9 }
            if (r0 != 0) goto L_0x00a2
            y8.o1 r0 = r7.f20309d     // Catch:{ all -> 0x00a9 }
            java.lang.Runnable r1 = r7.f20311f     // Catch:{ all -> 0x00a9 }
            r0.b(r1)     // Catch:{ all -> 0x00a9 }
            y8.k1 r0 = r7.f20315j     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x00a2
            java.lang.Runnable r0 = r7.f20312g     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x00a2
            y8.o1 r1 = r7.f20309d     // Catch:{ all -> 0x00a9 }
            r1.b(r0)     // Catch:{ all -> 0x00a9 }
            r0 = 0
            r7.f20312g = r0     // Catch:{ all -> 0x00a9 }
        L_0x00a2:
            monitor-exit(r8)     // Catch:{ all -> 0x00a9 }
            y8.o1 r8 = r7.f20309d
            r8.a()
            return
        L_0x00a9:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x00a9 }
            throw r0
        L_0x00ac:
            monitor-exit(r0)     // Catch:{ all -> 0x00ae }
            return
        L_0x00ae:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00ae }
            goto L_0x00b2
        L_0x00b1:
            throw r8
        L_0x00b2:
            goto L_0x00b1
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.a0.r(y8.o0$i):void");
    }
}
