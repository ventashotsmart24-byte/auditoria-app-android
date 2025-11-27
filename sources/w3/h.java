package w3;

import b3.e0;
import c3.n;
import i3.b;
import j3.q;
import k3.d;

public abstract class h {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9509a;

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
                b3.e0$a[] r0 = b3.e0.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9509a = r0
                b3.e0$a r1 = b3.e0.a.EXISTING_PROPERTY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9509a     // Catch:{ NoSuchFieldError -> 0x001d }
                b3.e0$a r1 = b3.e0.a.EXTERNAL_PROPERTY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9509a     // Catch:{ NoSuchFieldError -> 0x0028 }
                b3.e0$a r1 = b3.e0.a.PROPERTY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9509a     // Catch:{ NoSuchFieldError -> 0x0033 }
                b3.e0$a r1 = b3.e0.a.WRAPPER_ARRAY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f9509a     // Catch:{ NoSuchFieldError -> 0x003e }
                b3.e0$a r1 = b3.e0.a.WRAPPER_OBJECT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: w3.h.a.<clinit>():void");
        }
    }

    public abstract h a(d dVar);

    public abstract String b();

    public abstract e0.a c();

    public b d(Object obj, n nVar) {
        b bVar = new b(obj, nVar);
        int i10 = a.f9509a[c().ordinal()];
        if (i10 == 1) {
            bVar.f7034e = b.a.PAYLOAD_PROPERTY;
            bVar.f7033d = b();
        } else if (i10 == 2) {
            bVar.f7034e = b.a.PARENT_PROPERTY;
            bVar.f7033d = b();
        } else if (i10 == 3) {
            bVar.f7034e = b.a.METADATA_PROPERTY;
            bVar.f7033d = b();
        } else if (i10 == 4) {
            bVar.f7034e = b.a.WRAPPER_ARRAY;
        } else if (i10 != 5) {
            q.a();
        } else {
            bVar.f7034e = b.a.WRAPPER_OBJECT;
        }
        return bVar;
    }

    public b e(Object obj, n nVar, Object obj2) {
        b d10 = d(obj, nVar);
        d10.f7032c = obj2;
        return d10;
    }

    public b f(Object obj, Class cls, n nVar) {
        b d10 = d(obj, nVar);
        d10.f7031b = cls;
        return d10;
    }

    public abstract b g(c3.h hVar, b bVar);

    public abstract b h(c3.h hVar, b bVar);
}
