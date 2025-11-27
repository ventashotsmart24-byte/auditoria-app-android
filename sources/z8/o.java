package z8;

import com.google.android.gms.cast.MediaTrack;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import y8.d0;
import y8.f;
import y8.i0;

public final class o {

    /* renamed from: f  reason: collision with root package name */
    public static final Logger f20806f = Logger.getLogger(f.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public final Object f20807a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final i0 f20808b;

    /* renamed from: c  reason: collision with root package name */
    public final Collection f20809c;

    /* renamed from: d  reason: collision with root package name */
    public final long f20810d;

    /* renamed from: e  reason: collision with root package name */
    public int f20811e;

    public class a extends ArrayDeque {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f20812a;

        public a(int i10) {
            this.f20812a = i10;
        }

        /* renamed from: a */
        public boolean add(d0 d0Var) {
            if (size() == this.f20812a) {
                removeFirst();
            }
            o.a(o.this);
            return super.add(d0Var);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f20814a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                y8.d0$b[] r0 = y8.d0.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20814a = r0
                y8.d0$b r1 = y8.d0.b.CT_ERROR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20814a     // Catch:{ NoSuchFieldError -> 0x001d }
                y8.d0$b r1 = y8.d0.b.CT_WARNING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: z8.o.b.<clinit>():void");
        }
    }

    public o(i0 i0Var, int i10, long j10, String str) {
        Preconditions.checkNotNull(str, MediaTrack.ROLE_DESCRIPTION);
        this.f20808b = (i0) Preconditions.checkNotNull(i0Var, "logId");
        if (i10 > 0) {
            this.f20809c = new a(i10);
        } else {
            this.f20809c = null;
        }
        this.f20810d = j10;
        d0.a aVar = new d0.a();
        e(aVar.b(str + " created").c(d0.b.CT_INFO).e(j10).a());
    }

    public static /* synthetic */ int a(o oVar) {
        int i10 = oVar.f20811e;
        oVar.f20811e = i10 + 1;
        return i10;
    }

    public static void d(i0 i0Var, Level level, String str) {
        Logger logger = f20806f;
        if (logger.isLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, "[" + i0Var + "] " + str);
            logRecord.setLoggerName(logger.getName());
            logRecord.setSourceClassName(logger.getName());
            logRecord.setSourceMethodName("log");
            logger.log(logRecord);
        }
    }

    public i0 b() {
        return this.f20808b;
    }

    public boolean c() {
        boolean z10;
        synchronized (this.f20807a) {
            if (this.f20809c != null) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public void e(d0 d0Var) {
        Level level;
        int i10 = b.f20814a[d0Var.f19981b.ordinal()];
        if (i10 == 1) {
            level = Level.FINE;
        } else if (i10 != 2) {
            level = Level.FINEST;
        } else {
            level = Level.FINER;
        }
        f(d0Var);
        d(this.f20808b, level, d0Var.f19980a);
    }

    public void f(d0 d0Var) {
        synchronized (this.f20807a) {
            Collection collection = this.f20809c;
            if (collection != null) {
                collection.add(d0Var);
            }
        }
    }
}
