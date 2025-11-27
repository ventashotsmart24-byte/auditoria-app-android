package w3;

import b3.e0;
import c3.k;
import c3.n;
import k3.d;
import k3.g;
import k3.j;

public abstract class e {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9508a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                c3.n[] r0 = c3.n.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9508a = r0
                c3.n r1 = c3.n.VALUE_STRING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9508a     // Catch:{ NoSuchFieldError -> 0x001d }
                c3.n r1 = c3.n.VALUE_NUMBER_INT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9508a     // Catch:{ NoSuchFieldError -> 0x0028 }
                c3.n r1 = c3.n.VALUE_NUMBER_FLOAT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9508a     // Catch:{ NoSuchFieldError -> 0x0033 }
                c3.n r1 = c3.n.VALUE_TRUE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f9508a     // Catch:{ NoSuchFieldError -> 0x003e }
                c3.n r1 = c3.n.VALUE_FALSE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: w3.e.a.<clinit>():void");
        }
    }

    public static Object a(k kVar, g gVar, Class cls) {
        n n10 = kVar.n();
        if (n10 == null) {
            return null;
        }
        int i10 = a.f9508a[n10.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    Class<Boolean> cls2 = Boolean.class;
                    if (i10 != 4) {
                        if (i10 == 5 && cls.isAssignableFrom(cls2)) {
                            return Boolean.FALSE;
                        }
                    } else if (cls.isAssignableFrom(cls2)) {
                        return Boolean.TRUE;
                    }
                } else if (cls.isAssignableFrom(Double.class)) {
                    return Double.valueOf(kVar.M());
                }
            } else if (cls.isAssignableFrom(Integer.class)) {
                return Integer.valueOf(kVar.P());
            }
        } else if (cls.isAssignableFrom(String.class)) {
            return kVar.Y();
        }
        return null;
    }

    public static Object b(k kVar, g gVar, j jVar) {
        return a(kVar, gVar, jVar.q());
    }

    public abstract Object c(k kVar, g gVar);

    public abstract Object d(k kVar, g gVar);

    public abstract Object e(k kVar, g gVar);

    public abstract Object f(k kVar, g gVar);

    public abstract e g(d dVar);

    public abstract Class h();

    public abstract String i();

    public abstract f j();

    public abstract e0.a k();

    public abstract boolean l();
}
