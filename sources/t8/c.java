package t8;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import s8.d;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Function f19573a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final Function f19574b = new b();

    public static class a implements Function {
        /* renamed from: a */
        public a apply(a aVar) {
            switch (C0286c.f19575a[aVar.ordinal()]) {
                case 1:
                    return a.DESTROY;
                case 2:
                    return a.STOP;
                case 3:
                    return a.PAUSE;
                case 4:
                    return a.STOP;
                case 5:
                    return a.DESTROY;
                case 6:
                    throw new s8.c("Cannot bind to Activity lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + aVar + " not yet implemented");
            }
        }
    }

    public static class b implements Function {
        /* renamed from: a */
        public b apply(b bVar) {
            switch (C0286c.f19576b[bVar.ordinal()]) {
                case 1:
                    return b.DETACH;
                case 2:
                    return b.DESTROY;
                case 3:
                    return b.DESTROY_VIEW;
                case 4:
                    return b.STOP;
                case 5:
                    return b.PAUSE;
                case 6:
                    return b.STOP;
                case 7:
                    return b.DESTROY_VIEW;
                case 8:
                    return b.DESTROY;
                case 9:
                    return b.DETACH;
                case 10:
                    throw new s8.c("Cannot bind to Fragment lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + bVar + " not yet implemented");
            }
        }
    }

    /* renamed from: t8.c$c  reason: collision with other inner class name */
    public static /* synthetic */ class C0286c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f19575a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f19576b;

        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|(3:43|44|46)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|(3:43|44|46)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|(3:43|44|46)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0089 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0093 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x009d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00a7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00b1 */
        static {
            /*
                t8.b[] r0 = t8.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19576b = r0
                r1 = 1
                t8.b r2 = t8.b.ATTACH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f19576b     // Catch:{ NoSuchFieldError -> 0x001d }
                t8.b r3 = t8.b.CREATE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f19576b     // Catch:{ NoSuchFieldError -> 0x0028 }
                t8.b r4 = t8.b.CREATE_VIEW     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f19576b     // Catch:{ NoSuchFieldError -> 0x0033 }
                t8.b r5 = t8.b.START     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f19576b     // Catch:{ NoSuchFieldError -> 0x003e }
                t8.b r6 = t8.b.RESUME     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = f19576b     // Catch:{ NoSuchFieldError -> 0x0049 }
                t8.b r7 = t8.b.PAUSE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r6 = f19576b     // Catch:{ NoSuchFieldError -> 0x0054 }
                t8.b r7 = t8.b.STOP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r8 = 7
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r6 = f19576b     // Catch:{ NoSuchFieldError -> 0x0060 }
                t8.b r7 = t8.b.DESTROY_VIEW     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r8 = 8
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r6 = f19576b     // Catch:{ NoSuchFieldError -> 0x006c }
                t8.b r7 = t8.b.DESTROY     // Catch:{ NoSuchFieldError -> 0x006c }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r8 = 9
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r6 = f19576b     // Catch:{ NoSuchFieldError -> 0x0078 }
                t8.b r7 = t8.b.DETACH     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r8 = 10
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                t8.a[] r6 = t8.a.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                f19575a = r6
                t8.a r7 = t8.a.CREATE     // Catch:{ NoSuchFieldError -> 0x0089 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0089 }
                r6[r7] = r1     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                int[] r1 = f19575a     // Catch:{ NoSuchFieldError -> 0x0093 }
                t8.a r6 = t8.a.START     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r1[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                int[] r0 = f19575a     // Catch:{ NoSuchFieldError -> 0x009d }
                t8.a r1 = t8.a.RESUME     // Catch:{ NoSuchFieldError -> 0x009d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009d }
            L_0x009d:
                int[] r0 = f19575a     // Catch:{ NoSuchFieldError -> 0x00a7 }
                t8.a r1 = t8.a.PAUSE     // Catch:{ NoSuchFieldError -> 0x00a7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a7 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00a7 }
            L_0x00a7:
                int[] r0 = f19575a     // Catch:{ NoSuchFieldError -> 0x00b1 }
                t8.a r1 = t8.a.STOP     // Catch:{ NoSuchFieldError -> 0x00b1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b1 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00b1 }
            L_0x00b1:
                int[] r0 = f19575a     // Catch:{ NoSuchFieldError -> 0x00bb }
                t8.a r1 = t8.a.DESTROY     // Catch:{ NoSuchFieldError -> 0x00bb }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bb }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00bb }
            L_0x00bb:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: t8.c.C0286c.<clinit>():void");
        }
    }

    public static s8.b a(Observable observable) {
        return d.b(observable, f19573a);
    }

    public static s8.b b(Observable observable) {
        return d.b(observable, f19574b);
    }
}
