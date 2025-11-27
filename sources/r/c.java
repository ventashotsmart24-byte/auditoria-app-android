package r;

import android.graphics.Insets;
import android.graphics.Rect;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

public final class c {

    /* renamed from: e  reason: collision with root package name */
    public static final c f8942e = new c(0, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f8943a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8944b;

    /* renamed from: c  reason: collision with root package name */
    public final int f8945c;

    /* renamed from: d  reason: collision with root package name */
    public final int f8946d;

    public c(int i10, int i11, int i12, int i13) {
        this.f8943a = i10;
        this.f8944b = i11;
        this.f8945c = i12;
        this.f8946d = i13;
    }

    public static c a(c cVar, c cVar2) {
        return b(Math.max(cVar.f8943a, cVar2.f8943a), Math.max(cVar.f8944b, cVar2.f8944b), Math.max(cVar.f8945c, cVar2.f8945c), Math.max(cVar.f8946d, cVar2.f8946d));
    }

    public static c b(int i10, int i11, int i12, int i13) {
        if (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) {
            return f8942e;
        }
        return new c(i10, i11, i12, i13);
    }

    public static c c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static c d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return Insets.of(this.f8943a, this.f8944b, this.f8945c, this.f8946d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f8946d == cVar.f8946d && this.f8943a == cVar.f8943a && this.f8945c == cVar.f8945c && this.f8944b == cVar.f8944b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f8943a * 31) + this.f8944b) * 31) + this.f8945c) * 31) + this.f8946d;
    }

    public String toString() {
        return "Insets{left=" + this.f8943a + ", top=" + this.f8944b + ", right=" + this.f8945c + ", bottom=" + this.f8946d + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
