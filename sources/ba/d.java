package ba;

import aa.b;
import java.util.Iterator;
import java.util.NoSuchElementException;
import s9.p;
import t9.i;
import y9.c;
import y9.e;

public final class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f11337a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11338b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11339c;

    /* renamed from: d  reason: collision with root package name */
    public final p f11340d;

    public static final class a implements Iterator, u9.a {

        /* renamed from: a  reason: collision with root package name */
        public int f11341a = -1;

        /* renamed from: b  reason: collision with root package name */
        public int f11342b;

        /* renamed from: c  reason: collision with root package name */
        public int f11343c;

        /* renamed from: d  reason: collision with root package name */
        public c f11344d;

        /* renamed from: e  reason: collision with root package name */
        public int f11345e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f11346f;

        public a(d dVar) {
            this.f11346f = dVar;
            int d10 = e.d(dVar.f11338b, 0, dVar.f11337a.length());
            this.f11342b = d10;
            this.f11343c = d10;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
            if (r0 < ba.d.c(r6.f11346f)) goto L_0x0023;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a() {
            /*
                r6 = this;
                int r0 = r6.f11343c
                r1 = 0
                if (r0 >= 0) goto L_0x000c
                r6.f11341a = r1
                r0 = 0
                r6.f11344d = r0
                goto L_0x009e
            L_0x000c:
                ba.d r0 = r6.f11346f
                int r0 = r0.f11339c
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L_0x0023
                int r0 = r6.f11345e
                int r0 = r0 + r3
                r6.f11345e = r0
                ba.d r4 = r6.f11346f
                int r4 = r4.f11339c
                if (r0 >= r4) goto L_0x0031
            L_0x0023:
                int r0 = r6.f11343c
                ba.d r4 = r6.f11346f
                java.lang.CharSequence r4 = r4.f11337a
                int r4 = r4.length()
                if (r0 <= r4) goto L_0x0047
            L_0x0031:
                y9.c r0 = new y9.c
                int r1 = r6.f11342b
                ba.d r4 = r6.f11346f
                java.lang.CharSequence r4 = r4.f11337a
                int r4 = ba.t.s(r4)
                r0.<init>(r1, r4)
                r6.f11344d = r0
                r6.f11343c = r2
                goto L_0x009c
            L_0x0047:
                ba.d r0 = r6.f11346f
                s9.p r0 = r0.f11340d
                ba.d r4 = r6.f11346f
                java.lang.CharSequence r4 = r4.f11337a
                int r5 = r6.f11343c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                h9.k r0 = (h9.k) r0
                if (r0 != 0) goto L_0x0077
                y9.c r0 = new y9.c
                int r1 = r6.f11342b
                ba.d r4 = r6.f11346f
                java.lang.CharSequence r4 = r4.f11337a
                int r4 = ba.t.s(r4)
                r0.<init>(r1, r4)
                r6.f11344d = r0
                r6.f11343c = r2
                goto L_0x009c
            L_0x0077:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f11342b
                y9.c r4 = y9.e.f(r4, r2)
                r6.f11344d = r4
                int r2 = r2 + r0
                r6.f11342b = r2
                if (r0 != 0) goto L_0x0099
                r1 = 1
            L_0x0099:
                int r2 = r2 + r1
                r6.f11343c = r2
            L_0x009c:
                r6.f11341a = r3
            L_0x009e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ba.d.a.a():void");
        }

        /* renamed from: b */
        public c next() {
            if (this.f11341a == -1) {
                a();
            }
            if (this.f11341a != 0) {
                c cVar = this.f11344d;
                i.e(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.f11344d = null;
                this.f11341a = -1;
                return cVar;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.f11341a == -1) {
                a();
            }
            if (this.f11341a == 1) {
                return true;
            }
            return false;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public d(CharSequence charSequence, int i10, int i11, p pVar) {
        i.g(charSequence, "input");
        i.g(pVar, "getNextMatch");
        this.f11337a = charSequence;
        this.f11338b = i10;
        this.f11339c = i11;
        this.f11340d = pVar;
    }

    public Iterator iterator() {
        return new a(this);
    }
}
