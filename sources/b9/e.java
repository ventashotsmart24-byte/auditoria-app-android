package b9;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f11280a;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final List f11281a = new ArrayList(20);

        public b b(String str, String str2) {
            this.f11281a.add(str);
            this.f11281a.add(str2.trim());
            return this;
        }

        public e c() {
            return new e(this);
        }

        public final void d(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            } else if (!str.isEmpty()) {
                int length = str.length();
                for (int i10 = 0; i10 < length; i10++) {
                    char charAt = str.charAt(i10);
                    if (charAt <= 31 || charAt >= 127) {
                        throw new IllegalArgumentException(String.format(Locale.US, "Unexpected char %#04x at %d in header name: %s", new Object[]{Integer.valueOf(charAt), Integer.valueOf(i10), str}));
                    }
                }
                if (str2 != null) {
                    int length2 = str2.length();
                    for (int i11 = 0; i11 < length2; i11++) {
                        char charAt2 = str2.charAt(i11);
                        if (charAt2 <= 31 || charAt2 >= 127) {
                            throw new IllegalArgumentException(String.format(Locale.US, "Unexpected char %#04x at %d in header value: %s", new Object[]{Integer.valueOf(charAt2), Integer.valueOf(i11), str2}));
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("value == null");
            } else {
                throw new IllegalArgumentException("name is empty");
            }
        }

        public b e(String str) {
            int i10 = 0;
            while (i10 < this.f11281a.size()) {
                if (str.equalsIgnoreCase((String) this.f11281a.get(i10))) {
                    this.f11281a.remove(i10);
                    this.f11281a.remove(i10);
                    i10 -= 2;
                }
                i10 += 2;
            }
            return this;
        }

        public b f(String str, String str2) {
            d(str, str2);
            e(str);
            b(str, str2);
            return this;
        }
    }

    public String a(int i10) {
        int i11 = i10 * 2;
        if (i11 < 0) {
            return null;
        }
        String[] strArr = this.f11280a;
        if (i11 >= strArr.length) {
            return null;
        }
        return strArr[i11];
    }

    public int b() {
        return this.f11280a.length / 2;
    }

    public String c(int i10) {
        int i11 = (i10 * 2) + 1;
        if (i11 < 0) {
            return null;
        }
        String[] strArr = this.f11280a;
        if (i11 >= strArr.length) {
            return null;
        }
        return strArr[i11];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int b10 = b();
        for (int i10 = 0; i10 < b10; i10++) {
            sb.append(a(i10));
            sb.append(": ");
            sb.append(c(i10));
            sb.append("\n");
        }
        return sb.toString();
    }

    public e(b bVar) {
        this.f11280a = (String[]) bVar.f11281a.toArray(new String[bVar.f11281a.size()]);
    }
}
