package o9;

import t9.i;

public class a extends n9.a {

    /* renamed from: o9.a$a  reason: collision with other inner class name */
    public static final class C0278a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0278a f19144a = new C0278a();

        /* renamed from: b  reason: collision with root package name */
        public static final Integer f19145b;

        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        static {
            /*
                o9.a$a r0 = new o9.a$a
                r0.<init>()
                f19144a = r0
                r0 = 0
                java.lang.String r1 = "android.os.Build$VERSION"
                java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x001f }
                java.lang.String r2 = "SDK_INT"
                java.lang.reflect.Field r1 = r1.getField(r2)     // Catch:{ all -> 0x001f }
                java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x001f }
                boolean r2 = r1 instanceof java.lang.Integer     // Catch:{ all -> 0x001f }
                if (r2 == 0) goto L_0x0020
                java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x001f }
                goto L_0x0021
            L_0x001f:
            L_0x0020:
                r1 = r0
            L_0x0021:
                if (r1 == 0) goto L_0x002f
                int r2 = r1.intValue()
                if (r2 <= 0) goto L_0x002b
                r2 = 1
                goto L_0x002c
            L_0x002b:
                r2 = 0
            L_0x002c:
                if (r2 == 0) goto L_0x002f
                r0 = r1
            L_0x002f:
                f19145b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: o9.a.C0278a.<clinit>():void");
        }
    }

    public void a(Throwable th, Throwable th2) {
        i.g(th, "cause");
        i.g(th2, "exception");
        if (c(19)) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }

    public final boolean c(int i10) {
        Integer num = C0278a.f19145b;
        if (num == null || num.intValue() >= i10) {
            return true;
        }
        return false;
    }
}
