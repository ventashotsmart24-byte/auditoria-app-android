package z;

import android.text.SpannableStringBuilder;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.Locale;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final p f9881d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f9882e = Character.toString(8206);

    /* renamed from: f  reason: collision with root package name */
    public static final String f9883f = Character.toString(8207);

    /* renamed from: g  reason: collision with root package name */
    public static final a f9884g;

    /* renamed from: h  reason: collision with root package name */
    public static final a f9885h;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f9886a;

    /* renamed from: b  reason: collision with root package name */
    public final int f9887b;

    /* renamed from: c  reason: collision with root package name */
    public final p f9888c;

    /* renamed from: z.a$a  reason: collision with other inner class name */
    public static final class C0136a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f9889a;

        /* renamed from: b  reason: collision with root package name */
        public int f9890b;

        /* renamed from: c  reason: collision with root package name */
        public p f9891c;

        public C0136a() {
            c(a.e(Locale.getDefault()));
        }

        public static a b(boolean z10) {
            if (z10) {
                return a.f9885h;
            }
            return a.f9884g;
        }

        public a a() {
            if (this.f9890b == 2 && this.f9891c == a.f9881d) {
                return b(this.f9889a);
            }
            return new a(this.f9889a, this.f9890b, this.f9891c);
        }

        public final void c(boolean z10) {
            this.f9889a = z10;
            this.f9891c = a.f9881d;
            this.f9890b = 2;
        }
    }

    public static class b {

        /* renamed from: f  reason: collision with root package name */
        public static final byte[] f9892f = new byte[1792];

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f9893a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f9894b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9895c;

        /* renamed from: d  reason: collision with root package name */
        public int f9896d;

        /* renamed from: e  reason: collision with root package name */
        public char f9897e;

        static {
            for (int i10 = 0; i10 < 1792; i10++) {
                f9892f[i10] = Character.getDirectionality(i10);
            }
        }

        public b(CharSequence charSequence, boolean z10) {
            this.f9893a = charSequence;
            this.f9894b = z10;
            this.f9895c = charSequence.length();
        }

        public static byte c(char c10) {
            if (c10 < 1792) {
                return f9892f[c10];
            }
            return Character.getDirectionality(c10);
        }

        public byte a() {
            char charAt = this.f9893a.charAt(this.f9896d - 1);
            this.f9897e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f9893a, this.f9896d);
                this.f9896d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f9896d--;
            byte c10 = c(this.f9897e);
            if (!this.f9894b) {
                return c10;
            }
            char c11 = this.f9897e;
            if (c11 == '>') {
                return h();
            }
            if (c11 == ';') {
                return f();
            }
            return c10;
        }

        public byte b() {
            char charAt = this.f9893a.charAt(this.f9896d);
            this.f9897e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f9893a, this.f9896d);
                this.f9896d += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f9896d++;
            byte c10 = c(this.f9897e);
            if (!this.f9894b) {
                return c10;
            }
            char c11 = this.f9897e;
            if (c11 == '<') {
                return i();
            }
            if (c11 == '&') {
                return g();
            }
            return c10;
        }

        public int d() {
            this.f9896d = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (this.f9896d < this.f9895c && i10 == 0) {
                byte b10 = b();
                if (b10 != 0) {
                    if (b10 == 1 || b10 == 2) {
                        if (i12 == 0) {
                            return 1;
                        }
                    } else if (b10 != 9) {
                        switch (b10) {
                            case 14:
                            case 15:
                                i12++;
                                i11 = -1;
                                continue;
                            case 16:
                            case 17:
                                i12++;
                                i11 = 1;
                                continue;
                            case 18:
                                i12--;
                                i11 = 0;
                                continue;
                        }
                    }
                } else if (i12 == 0) {
                    return -1;
                }
                i10 = i12;
            }
            if (i10 == 0) {
                return 0;
            }
            if (i11 != 0) {
                return i11;
            }
            while (this.f9896d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i10 == i12) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i10 == i12) {
                            return 1;
                        }
                        break;
                    case 18:
                        i12++;
                        continue;
                }
                i12--;
            }
            return 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
            r1 = r1 - 1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int e() {
            /*
                r7 = this;
                int r0 = r7.f9895c
                r7.f9896d = r0
                r0 = 0
                r1 = 0
                r2 = 0
            L_0x0007:
                int r3 = r7.f9896d
                if (r3 <= 0) goto L_0x003b
                byte r3 = r7.a()
                r4 = -1
                if (r3 == 0) goto L_0x0034
                r5 = 1
                if (r3 == r5) goto L_0x002e
                r6 = 2
                if (r3 == r6) goto L_0x002e
                r6 = 9
                if (r3 == r6) goto L_0x0007
                switch(r3) {
                    case 14: goto L_0x0028;
                    case 15: goto L_0x0028;
                    case 16: goto L_0x0025;
                    case 17: goto L_0x0025;
                    case 18: goto L_0x0022;
                    default: goto L_0x001f;
                }
            L_0x001f:
                if (r2 != 0) goto L_0x0007
                goto L_0x0039
            L_0x0022:
                int r1 = r1 + 1
                goto L_0x0007
            L_0x0025:
                if (r2 != r1) goto L_0x002b
                return r5
            L_0x0028:
                if (r2 != r1) goto L_0x002b
                return r4
            L_0x002b:
                int r1 = r1 + -1
                goto L_0x0007
            L_0x002e:
                if (r1 != 0) goto L_0x0031
                return r5
            L_0x0031:
                if (r2 != 0) goto L_0x0007
                goto L_0x0039
            L_0x0034:
                if (r1 != 0) goto L_0x0037
                return r4
            L_0x0037:
                if (r2 != 0) goto L_0x0007
            L_0x0039:
                r2 = r1
                goto L_0x0007
            L_0x003b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: z.a.b.e():int");
        }

        public final byte f() {
            char charAt;
            int i10 = this.f9896d;
            do {
                int i11 = this.f9896d;
                if (i11 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f9893a;
                int i12 = i11 - 1;
                this.f9896d = i12;
                charAt = charSequence.charAt(i12);
                this.f9897e = charAt;
                if (charAt == '&') {
                    return 12;
                }
            } while (charAt != ';');
            this.f9896d = i10;
            this.f9897e = ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN;
            return 13;
        }

        public final byte g() {
            char charAt;
            do {
                int i10 = this.f9896d;
                if (i10 >= this.f9895c) {
                    return 12;
                }
                CharSequence charSequence = this.f9893a;
                this.f9896d = i10 + 1;
                charAt = charSequence.charAt(i10);
                this.f9897e = charAt;
            } while (charAt != ';');
            return 12;
        }

        public final byte h() {
            char charAt;
            int i10 = this.f9896d;
            while (true) {
                int i11 = this.f9896d;
                if (i11 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f9893a;
                int i12 = i11 - 1;
                this.f9896d = i12;
                char charAt2 = charSequence.charAt(i12);
                this.f9897e = charAt2;
                if (charAt2 == '<') {
                    return 12;
                }
                if (charAt2 == '>') {
                    break;
                } else if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i13 = this.f9896d;
                        if (i13 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.f9893a;
                        int i14 = i13 - 1;
                        this.f9896d = i14;
                        charAt = charSequence2.charAt(i14);
                        this.f9897e = charAt;
                    } while (charAt != charAt2);
                }
            }
            this.f9896d = i10;
            this.f9897e = ASCIIPropertyListParser.DATA_END_TOKEN;
            return 13;
        }

        public final byte i() {
            char charAt;
            int i10 = this.f9896d;
            while (true) {
                int i11 = this.f9896d;
                if (i11 < this.f9895c) {
                    CharSequence charSequence = this.f9893a;
                    this.f9896d = i11 + 1;
                    char charAt2 = charSequence.charAt(i11);
                    this.f9897e = charAt2;
                    if (charAt2 == '>') {
                        return 12;
                    }
                    if (charAt2 == '\"' || charAt2 == '\'') {
                        do {
                            int i12 = this.f9896d;
                            if (i12 >= this.f9895c) {
                                break;
                            }
                            CharSequence charSequence2 = this.f9893a;
                            this.f9896d = i12 + 1;
                            charAt = charSequence2.charAt(i12);
                            this.f9897e = charAt;
                        } while (charAt != charAt2);
                    }
                } else {
                    this.f9896d = i10;
                    this.f9897e = ASCIIPropertyListParser.DATA_BEGIN_TOKEN;
                    return 13;
                }
            }
        }
    }

    static {
        p pVar = q.f9909c;
        f9881d = pVar;
        f9884g = new a(false, 2, pVar);
        f9885h = new a(true, 2, pVar);
    }

    public a(boolean z10, int i10, p pVar) {
        this.f9886a = z10;
        this.f9887b = i10;
        this.f9888c = pVar;
    }

    public static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    public static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0136a().a();
    }

    public static boolean e(Locale locale) {
        if (r.a(locale) == 1) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if ((this.f9887b & 2) != 0) {
            return true;
        }
        return false;
    }

    public final String f(CharSequence charSequence, p pVar) {
        boolean a10 = pVar.a(charSequence, 0, charSequence.length());
        if (!this.f9886a && (a10 || b(charSequence) == 1)) {
            return f9882e;
        }
        if (!this.f9886a) {
            return "";
        }
        if (!a10 || b(charSequence) == -1) {
            return f9883f;
        }
        return "";
    }

    public final String g(CharSequence charSequence, p pVar) {
        boolean a10 = pVar.a(charSequence, 0, charSequence.length());
        if (!this.f9886a && (a10 || a(charSequence) == 1)) {
            return f9882e;
        }
        if (!this.f9886a) {
            return "";
        }
        if (!a10 || a(charSequence) == -1) {
            return f9883f;
        }
        return "";
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f9888c, true);
    }

    public CharSequence i(CharSequence charSequence, p pVar, boolean z10) {
        p pVar2;
        char c10;
        p pVar3;
        if (charSequence == null) {
            return null;
        }
        boolean a10 = pVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z10) {
            if (a10) {
                pVar3 = q.f9908b;
            } else {
                pVar3 = q.f9907a;
            }
            spannableStringBuilder.append(g(charSequence, pVar3));
        }
        if (a10 != this.f9886a) {
            if (a10) {
                c10 = 8235;
            } else {
                c10 = 8234;
            }
            spannableStringBuilder.append(c10);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z10) {
            if (a10) {
                pVar2 = q.f9908b;
            } else {
                pVar2 = q.f9907a;
            }
            spannableStringBuilder.append(f(charSequence, pVar2));
        }
        return spannableStringBuilder;
    }
}
