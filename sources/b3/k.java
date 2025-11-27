package b3;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import java.util.TimeZone;

@Retention(RetentionPolicy.RUNTIME)
public @interface k {

    public enum a {
        ACCEPT_SINGLE_VALUE_AS_ARRAY,
        ACCEPT_CASE_INSENSITIVE_PROPERTIES,
        ACCEPT_CASE_INSENSITIVE_VALUES,
        WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS,
        WRITE_DATES_WITH_ZONE_ID,
        WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED,
        WRITE_SORTED_MAP_ENTRIES,
        ADJUST_DATES_TO_CONTEXT_TIME_ZONE
    }

    public static class b {

        /* renamed from: c  reason: collision with root package name */
        public static final b f4255c = new b(0, 0);

        /* renamed from: a  reason: collision with root package name */
        public final int f4256a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4257b;

        public b(int i10, int i11) {
            this.f4256a = i10;
            this.f4257b = i11;
        }

        public static b a(k kVar) {
            return b(kVar.with(), kVar.without());
        }

        public static b b(a[] aVarArr, a[] aVarArr2) {
            int i10 = 0;
            for (a ordinal : aVarArr) {
                i10 |= 1 << ordinal.ordinal();
            }
            int i11 = 0;
            for (a ordinal2 : aVarArr2) {
                i11 |= 1 << ordinal2.ordinal();
            }
            return new b(i10, i11);
        }

        public static b c() {
            return f4255c;
        }

        public Boolean d(a aVar) {
            int ordinal = 1 << aVar.ordinal();
            if ((this.f4257b & ordinal) != 0) {
                return Boolean.FALSE;
            }
            if ((ordinal & this.f4256a) != 0) {
                return Boolean.TRUE;
            }
            return null;
        }

        public b e(b bVar) {
            if (bVar == null) {
                return this;
            }
            int i10 = bVar.f4257b;
            int i11 = bVar.f4256a;
            if (i10 == 0 && i11 == 0) {
                return this;
            }
            int i12 = this.f4256a;
            if (i12 == 0 && this.f4257b == 0) {
                return bVar;
            }
            int i13 = ((i10 ^ -1) & i12) | i11;
            int i14 = this.f4257b;
            int i15 = i10 | ((i11 ^ -1) & i14);
            if (i13 == i12 && i15 == i14) {
                return this;
            }
            return new b(i13, i15);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (bVar.f4256a == this.f4256a && bVar.f4257b == this.f4257b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f4257b + this.f4256a;
        }

        public String toString() {
            if (this == f4255c) {
                return "EMPTY";
            }
            return String.format("(enabled=0x%x,disabled=0x%x)", new Object[]{Integer.valueOf(this.f4256a), Integer.valueOf(this.f4257b)});
        }
    }

    public enum c {
        ANY,
        NATURAL,
        SCALAR,
        ARRAY,
        OBJECT,
        NUMBER,
        NUMBER_FLOAT,
        NUMBER_INT,
        STRING,
        BOOLEAN,
        BINARY;

        public boolean a() {
            if (this == NUMBER || this == NUMBER_INT || this == NUMBER_FLOAT) {
                return true;
            }
            return false;
        }
    }

    public static class d implements Serializable {

        /* renamed from: h  reason: collision with root package name */
        public static final d f4270h = new d();

        /* renamed from: a  reason: collision with root package name */
        public final String f4271a;

        /* renamed from: b  reason: collision with root package name */
        public final c f4272b;

        /* renamed from: c  reason: collision with root package name */
        public final Locale f4273c;

        /* renamed from: d  reason: collision with root package name */
        public final String f4274d;

        /* renamed from: e  reason: collision with root package name */
        public final Boolean f4275e;

        /* renamed from: f  reason: collision with root package name */
        public final b f4276f;

        /* renamed from: g  reason: collision with root package name */
        public transient TimeZone f4277g;

        public d() {
            this("", c.ANY, "", "", b.c(), (Boolean) null);
        }

        public static boolean a(Object obj, Object obj2) {
            if (obj == null) {
                if (obj2 == null) {
                    return true;
                }
                return false;
            } else if (obj2 == null) {
                return false;
            } else {
                return obj.equals(obj2);
            }
        }

        public static final d b() {
            return f4270h;
        }

        public static d c(boolean z10) {
            return new d("", (c) null, (Locale) null, (String) null, (TimeZone) null, b.c(), Boolean.valueOf(z10));
        }

        public static final d d(k kVar) {
            if (kVar == null) {
                return f4270h;
            }
            return new d(kVar);
        }

        public static d p(d dVar, d dVar2) {
            if (dVar == null) {
                return dVar2;
            }
            return dVar.r(dVar2);
        }

        public Boolean e(a aVar) {
            return this.f4276f.d(aVar);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f4272b != dVar.f4272b || !this.f4276f.equals(dVar.f4276f) || !a(this.f4275e, dVar.f4275e) || !a(this.f4274d, dVar.f4274d) || !a(this.f4271a, dVar.f4271a) || !a(this.f4277g, dVar.f4277g) || !a(this.f4273c, dVar.f4273c)) {
                return false;
            }
            return true;
        }

        public Boolean f() {
            return this.f4275e;
        }

        public Locale g() {
            return this.f4273c;
        }

        public String h() {
            return this.f4271a;
        }

        public int hashCode() {
            int i10;
            String str = this.f4274d;
            if (str == null) {
                i10 = 1;
            } else {
                i10 = str.hashCode();
            }
            String str2 = this.f4271a;
            if (str2 != null) {
                i10 ^= str2.hashCode();
            }
            int hashCode = i10 + this.f4272b.hashCode();
            Boolean bool = this.f4275e;
            if (bool != null) {
                hashCode ^= bool.hashCode();
            }
            Locale locale = this.f4273c;
            if (locale != null) {
                hashCode += locale.hashCode();
            }
            return hashCode ^ this.f4276f.hashCode();
        }

        public c i() {
            return this.f4272b;
        }

        public TimeZone j() {
            TimeZone timeZone = this.f4277g;
            if (timeZone != null) {
                return timeZone;
            }
            String str = this.f4274d;
            if (str == null) {
                return null;
            }
            TimeZone timeZone2 = TimeZone.getTimeZone(str);
            this.f4277g = timeZone2;
            return timeZone2;
        }

        public boolean k() {
            if (this.f4275e != null) {
                return true;
            }
            return false;
        }

        public boolean l() {
            if (this.f4273c != null) {
                return true;
            }
            return false;
        }

        public boolean m() {
            String str = this.f4271a;
            if (str == null || str.length() <= 0) {
                return false;
            }
            return true;
        }

        public boolean n() {
            if (this.f4272b != c.ANY) {
                return true;
            }
            return false;
        }

        public boolean o() {
            String str;
            if (this.f4277g != null || ((str = this.f4274d) != null && !str.isEmpty())) {
                return true;
            }
            return false;
        }

        public d q(Boolean bool) {
            if (bool == this.f4275e) {
                return this;
            }
            return new d(this.f4271a, this.f4272b, this.f4273c, this.f4274d, this.f4277g, this.f4276f, bool);
        }

        public final d r(d dVar) {
            d dVar2;
            b bVar;
            TimeZone timeZone;
            String str;
            if (dVar == null || dVar == (dVar2 = f4270h) || dVar == this) {
                return this;
            }
            if (this == dVar2) {
                return dVar;
            }
            String str2 = dVar.f4271a;
            if (str2 == null || str2.isEmpty()) {
                str2 = this.f4271a;
            }
            String str3 = str2;
            c cVar = dVar.f4272b;
            if (cVar == c.ANY) {
                cVar = this.f4272b;
            }
            c cVar2 = cVar;
            Locale locale = dVar.f4273c;
            if (locale == null) {
                locale = this.f4273c;
            }
            Locale locale2 = locale;
            b bVar2 = this.f4276f;
            if (bVar2 == null) {
                bVar = dVar.f4276f;
            } else {
                bVar = bVar2.e(dVar.f4276f);
            }
            b bVar3 = bVar;
            Boolean bool = dVar.f4275e;
            if (bool == null) {
                bool = this.f4275e;
            }
            Boolean bool2 = bool;
            String str4 = dVar.f4274d;
            if (str4 == null || str4.isEmpty()) {
                str = this.f4274d;
                timeZone = this.f4277g;
            } else {
                timeZone = dVar.f4277g;
                str = str4;
            }
            return new d(str3, cVar2, locale2, str, timeZone, bVar3, bool2);
        }

        public String toString() {
            return String.format("JsonFormat.Value(pattern=%s,shape=%s,lenient=%s,locale=%s,timezone=%s,features=%s)", new Object[]{this.f4271a, this.f4272b, this.f4275e, this.f4273c, this.f4274d, this.f4276f});
        }

        public d(k kVar) {
            this(kVar.pattern(), kVar.shape(), kVar.locale(), kVar.timezone(), b.a(kVar), kVar.lenient().a());
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public d(java.lang.String r14, b3.k.c r15, java.lang.String r16, java.lang.String r17, b3.k.b r18, java.lang.Boolean r19) {
            /*
                r13 = this;
                r0 = r16
                r1 = r17
                java.lang.String r2 = "##default"
                r3 = 0
                if (r0 == 0) goto L_0x001d
                int r4 = r16.length()
                if (r4 == 0) goto L_0x001d
                boolean r4 = r2.equals(r0)
                if (r4 == 0) goto L_0x0016
                goto L_0x001d
            L_0x0016:
                java.util.Locale r4 = new java.util.Locale
                r4.<init>(r0)
                r8 = r4
                goto L_0x001e
            L_0x001d:
                r8 = r3
            L_0x001e:
                if (r1 == 0) goto L_0x002f
                int r0 = r17.length()
                if (r0 == 0) goto L_0x002f
                boolean r0 = r2.equals(r1)
                if (r0 == 0) goto L_0x002d
                goto L_0x002f
            L_0x002d:
                r9 = r1
                goto L_0x0030
            L_0x002f:
                r9 = r3
            L_0x0030:
                r10 = 0
                r5 = r13
                r6 = r14
                r7 = r15
                r11 = r18
                r12 = r19
                r5.<init>(r6, r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b3.k.d.<init>(java.lang.String, b3.k$c, java.lang.String, java.lang.String, b3.k$b, java.lang.Boolean):void");
        }

        public d(String str, c cVar, Locale locale, String str2, TimeZone timeZone, b bVar, Boolean bool) {
            this.f4271a = str == null ? "" : str;
            this.f4272b = cVar == null ? c.ANY : cVar;
            this.f4273c = locale;
            this.f4277g = timeZone;
            this.f4274d = str2;
            this.f4276f = bVar == null ? b.c() : bVar;
            this.f4275e = bool;
        }
    }

    p0 lenient() default p0.DEFAULT;

    String locale() default "##default";

    String pattern() default "";

    c shape() default c.ANY;

    String timezone() default "##default";

    a[] with() default {};

    a[] without() default {};
}
