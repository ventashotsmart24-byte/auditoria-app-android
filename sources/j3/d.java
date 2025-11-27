package j3;

import c3.h;
import j3.e;

public class d extends e.c {

    /* renamed from: e  reason: collision with root package name */
    public static final String f7149e;

    /* renamed from: f  reason: collision with root package name */
    public static final d f7150f;

    /* renamed from: b  reason: collision with root package name */
    public final char[] f7151b;

    /* renamed from: c  reason: collision with root package name */
    public final int f7152c;

    /* renamed from: d  reason: collision with root package name */
    public final String f7153d;

    static {
        String str;
        try {
            str = System.getProperty("line.separator");
        } catch (Throwable unused) {
            str = "\n";
        }
        f7149e = str;
        f7150f = new d("  ", str);
    }

    public d(String str, String str2) {
        this.f7152c = str.length();
        this.f7151b = new char[(str.length() * 16)];
        int i10 = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            str.getChars(0, str.length(), this.f7151b, i10);
            i10 += str.length();
        }
        this.f7153d = str2;
    }

    public void a(h hVar, int i10) {
        hVar.o0(this.f7153d);
        if (i10 > 0) {
            int i11 = i10 * this.f7152c;
            while (true) {
                char[] cArr = this.f7151b;
                if (i11 > cArr.length) {
                    hVar.p0(cArr, 0, cArr.length);
                    i11 -= this.f7151b.length;
                } else {
                    hVar.p0(cArr, 0, i11);
                    return;
                }
            }
        }
    }

    public boolean isInline() {
        return false;
    }
}
