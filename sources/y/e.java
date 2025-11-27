package y;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.collection.g;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import y.f;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public static final androidx.collection.e f9818a = new androidx.collection.e(16);

    /* renamed from: b  reason: collision with root package name */
    public static final ExecutorService f9819b = g.a("fonts-androidx", 10, 10000);

    /* renamed from: c  reason: collision with root package name */
    public static final Object f9820c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static final g f9821d = new g();

    public class a implements Callable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f9822a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f9823b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f9824c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f9825d;

        public a(String str, Context context, d dVar, int i10) {
            this.f9822a = str;
            this.f9823b = context;
            this.f9824c = dVar;
            this.f9825d = i10;
        }

        /* renamed from: a */
        public C0133e call() {
            return e.c(this.f9822a, this.f9823b, this.f9824c, this.f9825d);
        }
    }

    public class b implements a0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f9826a;

        public b(a aVar) {
            this.f9826a = aVar;
        }

        /* renamed from: a */
        public void accept(C0133e eVar) {
            this.f9826a.b(eVar);
        }
    }

    public class c implements Callable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f9827a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f9828b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f9829c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f9830d;

        public c(String str, Context context, d dVar, int i10) {
            this.f9827a = str;
            this.f9828b = context;
            this.f9829c = dVar;
            this.f9830d = i10;
        }

        /* renamed from: a */
        public C0133e call() {
            return e.c(this.f9827a, this.f9828b, this.f9829c, this.f9830d);
        }
    }

    public class d implements a0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f9831a;

        public d(String str) {
            this.f9831a = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
            if (r0 >= r2.size()) goto L_0x002a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
            ((a0.a) r2.get(r0)).accept(r5);
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            r0 = 0;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void accept(y.e.C0133e r5) {
            /*
                r4 = this;
                java.lang.Object r0 = y.e.f9820c
                monitor-enter(r0)
                androidx.collection.g r1 = y.e.f9821d     // Catch:{ all -> 0x002b }
                java.lang.String r2 = r4.f9831a     // Catch:{ all -> 0x002b }
                java.lang.Object r2 = r1.get(r2)     // Catch:{ all -> 0x002b }
                java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ all -> 0x002b }
                if (r2 != 0) goto L_0x0011
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                return
            L_0x0011:
                java.lang.String r3 = r4.f9831a     // Catch:{ all -> 0x002b }
                r1.remove(r3)     // Catch:{ all -> 0x002b }
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                r0 = 0
            L_0x0018:
                int r1 = r2.size()
                if (r0 >= r1) goto L_0x002a
                java.lang.Object r1 = r2.get(r0)
                a0.a r1 = (a0.a) r1
                r1.accept(r5)
                int r0 = r0 + 1
                goto L_0x0018
            L_0x002a:
                return
            L_0x002b:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                goto L_0x002f
            L_0x002e:
                throw r5
            L_0x002f:
                goto L_0x002e
            */
            throw new UnsupportedOperationException("Method not decompiled: y.e.d.accept(y.e$e):void");
        }
    }

    public static String a(d dVar, int i10) {
        return dVar.d() + Operator.Operation.MINUS + i10;
    }

    public static int b(f.a aVar) {
        int i10 = 1;
        if (aVar.c() == 0) {
            f.b[] b10 = aVar.b();
            if (!(b10 == null || b10.length == 0)) {
                int length = b10.length;
                i10 = 0;
                int i11 = 0;
                while (i11 < length) {
                    int b11 = b10[i11].b();
                    if (b11 == 0) {
                        i11++;
                    } else if (b11 < 0) {
                        return -3;
                    } else {
                        return b11;
                    }
                }
            }
            return i10;
        } else if (aVar.c() != 1) {
            return -3;
        } else {
            return -2;
        }
    }

    public static C0133e c(String str, Context context, d dVar, int i10) {
        androidx.collection.e eVar = f9818a;
        Typeface typeface = (Typeface) eVar.get(str);
        if (typeface != null) {
            return new C0133e(typeface);
        }
        try {
            f.a d10 = c.d(context, dVar, (CancellationSignal) null);
            int b10 = b(d10);
            if (b10 != 0) {
                return new C0133e(b10);
            }
            Typeface b11 = r.e.b(context, (CancellationSignal) null, d10.b(), i10);
            if (b11 == null) {
                return new C0133e(-3);
            }
            eVar.put(str, b11);
            return new C0133e(b11);
        } catch (PackageManager.NameNotFoundException unused) {
            return new C0133e(-1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        r9 = new y.e.c(r0, r5, r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (r8 != null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        r8 = f9819b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        y.g.b(r8, r9, new y.e.d(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface d(android.content.Context r5, y.d r6, int r7, java.util.concurrent.Executor r8, y.a r9) {
        /*
            java.lang.String r0 = a(r6, r7)
            androidx.collection.e r1 = f9818a
            java.lang.Object r1 = r1.get(r0)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0017
            y.e$e r5 = new y.e$e
            r5.<init>((android.graphics.Typeface) r1)
            r9.b(r5)
            return r1
        L_0x0017:
            y.e$b r1 = new y.e$b
            r1.<init>(r9)
            java.lang.Object r9 = f9820c
            monitor-enter(r9)
            androidx.collection.g r2 = f9821d     // Catch:{ all -> 0x004d }
            java.lang.Object r3 = r2.get(r0)     // Catch:{ all -> 0x004d }
            java.util.ArrayList r3 = (java.util.ArrayList) r3     // Catch:{ all -> 0x004d }
            r4 = 0
            if (r3 == 0) goto L_0x002f
            r3.add(r1)     // Catch:{ all -> 0x004d }
            monitor-exit(r9)     // Catch:{ all -> 0x004d }
            return r4
        L_0x002f:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x004d }
            r3.<init>()     // Catch:{ all -> 0x004d }
            r3.add(r1)     // Catch:{ all -> 0x004d }
            r2.put(r0, r3)     // Catch:{ all -> 0x004d }
            monitor-exit(r9)     // Catch:{ all -> 0x004d }
            y.e$c r9 = new y.e$c
            r9.<init>(r0, r5, r6, r7)
            if (r8 != 0) goto L_0x0044
            java.util.concurrent.ExecutorService r8 = f9819b
        L_0x0044:
            y.e$d r5 = new y.e$d
            r5.<init>(r0)
            y.g.b(r8, r9, r5)
            return r4
        L_0x004d:
            r5 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x004d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: y.e.d(android.content.Context, y.d, int, java.util.concurrent.Executor, y.a):android.graphics.Typeface");
    }

    public static Typeface e(Context context, d dVar, a aVar, int i10, int i11) {
        String a10 = a(dVar, i10);
        Typeface typeface = (Typeface) f9818a.get(a10);
        if (typeface != null) {
            aVar.b(new C0133e(typeface));
            return typeface;
        } else if (i11 == -1) {
            C0133e c10 = c(a10, context, dVar, i10);
            aVar.b(c10);
            return c10.f9832a;
        } else {
            try {
                C0133e eVar = (C0133e) g.c(f9819b, new a(a10, context, dVar, i10), i11);
                aVar.b(eVar);
                return eVar.f9832a;
            } catch (InterruptedException unused) {
                aVar.b(new C0133e(-3));
                return null;
            }
        }
    }

    /* renamed from: y.e$e  reason: collision with other inner class name */
    public static final class C0133e {

        /* renamed from: a  reason: collision with root package name */
        public final Typeface f9832a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9833b;

        public C0133e(int i10) {
            this.f9832a = null;
            this.f9833b = i10;
        }

        public boolean a() {
            if (this.f9833b == 0) {
                return true;
            }
            return false;
        }

        public C0133e(Typeface typeface) {
            this.f9832a = typeface;
            this.f9833b = 0;
        }
    }
}
