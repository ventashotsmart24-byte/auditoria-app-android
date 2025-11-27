package c3;

public enum n {
    NOT_AVAILABLE((String) null, -1),
    START_OBJECT("{", 1),
    END_OBJECT("}", 2),
    START_ARRAY("[", 3),
    END_ARRAY("]", 4),
    FIELD_NAME((String) null, 5),
    VALUE_EMBEDDED_OBJECT((String) null, 12),
    VALUE_STRING((String) null, 6),
    VALUE_NUMBER_INT((String) null, 7),
    VALUE_NUMBER_FLOAT((String) null, 8),
    VALUE_TRUE("true", 9),
    VALUE_FALSE("false", 10),
    VALUE_NULL("null", 11);
    

    /* renamed from: a  reason: collision with root package name */
    public final String f4782a;

    /* renamed from: b  reason: collision with root package name */
    public final char[] f4783b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f4784c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4785d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f4786e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f4787f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f4788g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f4789h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f4790i;

    /* access modifiers changed from: public */
    n(String str, int i10) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14 = false;
        if (str == null) {
            this.f4782a = null;
            this.f4783b = null;
            this.f4784c = null;
        } else {
            this.f4782a = str;
            char[] charArray = str.toCharArray();
            this.f4783b = charArray;
            int length = charArray.length;
            this.f4784c = new byte[length];
            for (int i11 = 0; i11 < length; i11++) {
                this.f4784c[i11] = (byte) this.f4783b[i11];
            }
        }
        this.f4785d = i10;
        if (i10 == 10 || i10 == 9) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f4789h = z10;
        if (i10 == 7 || i10 == 8) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f4788g = z11;
        if (i10 == 1 || i10 == 3) {
            z12 = true;
        } else {
            z12 = false;
        }
        this.f4786e = z12;
        if (i10 == 2 || i10 == 4) {
            z13 = true;
        } else {
            z13 = false;
        }
        this.f4787f = z13;
        if (!z12 && !z13 && i10 != 5 && i10 != -1) {
            z14 = true;
        }
        this.f4790i = z14;
    }

    public final char[] a() {
        return this.f4783b;
    }

    public final String b() {
        return this.f4782a;
    }

    public final int c() {
        return this.f4785d;
    }

    public final boolean d() {
        return this.f4788g;
    }

    public final boolean e() {
        return this.f4790i;
    }

    public final boolean f() {
        return this.f4787f;
    }

    public final boolean g() {
        return this.f4786e;
    }
}
