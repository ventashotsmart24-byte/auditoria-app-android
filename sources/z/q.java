package z;

import java.util.Locale;

public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    public static final p f9907a = new e((c) null, false);

    /* renamed from: b  reason: collision with root package name */
    public static final p f9908b = new e((c) null, true);

    /* renamed from: c  reason: collision with root package name */
    public static final p f9909c;

    /* renamed from: d  reason: collision with root package name */
    public static final p f9910d;

    /* renamed from: e  reason: collision with root package name */
    public static final p f9911e = new e(a.f9913b, false);

    /* renamed from: f  reason: collision with root package name */
    public static final p f9912f = f.f9918b;

    public static class a implements c {

        /* renamed from: b  reason: collision with root package name */
        public static final a f9913b = new a(true);

        /* renamed from: a  reason: collision with root package name */
        public final boolean f9914a;

        public a(boolean z10) {
            this.f9914a = z10;
        }

        public int a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            boolean z10 = false;
            while (i10 < i12) {
                int a10 = q.a(Character.getDirectionality(charSequence.charAt(i10)));
                if (a10 != 0) {
                    if (a10 != 1) {
                        continue;
                        i10++;
                    } else if (!this.f9914a) {
                        return 1;
                    }
                } else if (this.f9914a) {
                    return 0;
                }
                z10 = true;
                i10++;
            }
            if (z10) {
                return this.f9914a ? 1 : 0;
            }
            return 2;
        }
    }

    public static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public static final b f9915a = new b();

        public int a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            int i13 = 2;
            while (i10 < i12 && i13 == 2) {
                i13 = q.b(Character.getDirectionality(charSequence.charAt(i10)));
                i10++;
            }
            return i13;
        }
    }

    public interface c {
        int a(CharSequence charSequence, int i10, int i11);
    }

    public static abstract class d implements p {

        /* renamed from: a  reason: collision with root package name */
        public final c f9916a;

        public d(c cVar) {
            this.f9916a = cVar;
        }

        public boolean a(CharSequence charSequence, int i10, int i11) {
            if (charSequence == null || i10 < 0 || i11 < 0 || charSequence.length() - i11 < i10) {
                throw new IllegalArgumentException();
            } else if (this.f9916a == null) {
                return b();
            } else {
                return c(charSequence, i10, i11);
            }
        }

        public abstract boolean b();

        public final boolean c(CharSequence charSequence, int i10, int i11) {
            int a10 = this.f9916a.a(charSequence, i10, i11);
            if (a10 == 0) {
                return true;
            }
            if (a10 != 1) {
                return b();
            }
            return false;
        }
    }

    public static class e extends d {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f9917b;

        public e(c cVar, boolean z10) {
            super(cVar);
            this.f9917b = z10;
        }

        public boolean b() {
            return this.f9917b;
        }
    }

    public static class f extends d {

        /* renamed from: b  reason: collision with root package name */
        public static final f f9918b = new f();

        public f() {
            super((c) null);
        }

        public boolean b() {
            if (r.a(Locale.getDefault()) == 1) {
                return true;
            }
            return false;
        }
    }

    static {
        b bVar = b.f9915a;
        f9909c = new e(bVar, false);
        f9910d = new e(bVar, true);
    }

    public static int a(int i10) {
        if (i10 != 0) {
            return (i10 == 1 || i10 == 2) ? 0 : 2;
        }
        return 1;
    }

    public static int b(int i10) {
        if (i10 != 0) {
            if (i10 == 1 || i10 == 2) {
                return 0;
            }
            switch (i10) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
