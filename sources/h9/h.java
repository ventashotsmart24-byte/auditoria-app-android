package h9;

import com.taobao.accs.common.Constants;
import t9.g;
import t9.i;

public abstract class h {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6963a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                h9.i[] r0 = h9.i.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                h9.i r1 = h9.i.SYNCHRONIZED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                h9.i r1 = h9.i.PUBLICATION     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                h9.i r1 = h9.i.NONE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f6963a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: h9.h.a.<clinit>():void");
        }
    }

    public static final g a(i iVar, s9.a aVar) {
        i.g(iVar, Constants.KEY_MODE);
        i.g(aVar, "initializer");
        int i10 = a.f6963a[iVar.ordinal()];
        if (i10 == 1) {
            return new o(aVar, (Object) null, 2, (g) null);
        }
        if (i10 == 2) {
            return new n(aVar);
        }
        if (i10 == 3) {
            return new u(aVar);
        }
        throw new j();
    }

    public static final g b(s9.a aVar) {
        i.g(aVar, "initializer");
        return new o(aVar, (Object) null, 2, (g) null);
    }
}
