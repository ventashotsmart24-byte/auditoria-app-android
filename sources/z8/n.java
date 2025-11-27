package z8;

import com.google.common.base.Preconditions;
import java.text.MessageFormat;
import java.util.logging.Level;
import org.android.agoo.common.AgooConstants;
import y8.d0;
import y8.f;
import y8.i0;

public final class n extends f {

    /* renamed from: a  reason: collision with root package name */
    public final o f20801a;

    /* renamed from: b  reason: collision with root package name */
    public final j2 f20802b;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f20803a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                y8.f$a[] r0 = y8.f.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20803a = r0
                y8.f$a r1 = y8.f.a.f20008d     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20803a     // Catch:{ NoSuchFieldError -> 0x001d }
                y8.f$a r1 = y8.f.a.WARNING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20803a     // Catch:{ NoSuchFieldError -> 0x0028 }
                y8.f$a r1 = y8.f.a.INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: z8.n.a.<clinit>():void");
        }
    }

    public n(o oVar, j2 j2Var) {
        this.f20801a = (o) Preconditions.checkNotNull(oVar, "tracer");
        this.f20802b = (j2) Preconditions.checkNotNull(j2Var, AgooConstants.MESSAGE_TIME);
    }

    public static void d(i0 i0Var, f.a aVar, String str) {
        Level f10 = f(aVar);
        if (o.f20806f.isLoggable(f10)) {
            o.d(i0Var, f10, str);
        }
    }

    public static void e(i0 i0Var, f.a aVar, String str, Object... objArr) {
        Level f10 = f(aVar);
        if (o.f20806f.isLoggable(f10)) {
            o.d(i0Var, f10, MessageFormat.format(str, objArr));
        }
    }

    public static Level f(f.a aVar) {
        int i10 = a.f20803a[aVar.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return Level.FINE;
        }
        if (i10 != 3) {
            return Level.FINEST;
        }
        return Level.FINER;
    }

    public static d0.b g(f.a aVar) {
        int i10 = a.f20803a[aVar.ordinal()];
        if (i10 == 1) {
            return d0.b.CT_ERROR;
        }
        if (i10 != 2) {
            return d0.b.CT_INFO;
        }
        return d0.b.CT_WARNING;
    }

    public void a(f.a aVar, String str) {
        d(this.f20801a.b(), aVar, str);
        if (c(aVar)) {
            h(aVar, str);
        }
    }

    public void b(f.a aVar, String str, Object... objArr) {
        String str2;
        Level f10 = f(aVar);
        if (c(aVar) || o.f20806f.isLoggable(f10)) {
            str2 = MessageFormat.format(str, objArr);
        } else {
            str2 = null;
        }
        a(aVar, str2);
    }

    public final boolean c(f.a aVar) {
        if (aVar == f.a.DEBUG || !this.f20801a.c()) {
            return false;
        }
        return true;
    }

    public final void h(f.a aVar, String str) {
        if (aVar != f.a.DEBUG) {
            this.f20801a.f(new d0.a().b(str).c(g(aVar)).e(this.f20802b.a()).a());
        }
    }
}
