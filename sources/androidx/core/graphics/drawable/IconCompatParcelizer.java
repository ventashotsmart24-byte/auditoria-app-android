package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import y0.b;

public class IconCompatParcelizer {
    public static IconCompat read(b bVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f1765a = bVar.p(iconCompat.f1765a, 1);
        iconCompat.f1767c = bVar.j(iconCompat.f1767c, 2);
        iconCompat.f1768d = bVar.r(iconCompat.f1768d, 3);
        iconCompat.f1769e = bVar.p(iconCompat.f1769e, 4);
        iconCompat.f1770f = bVar.p(iconCompat.f1770f, 5);
        iconCompat.f1771g = (ColorStateList) bVar.r(iconCompat.f1771g, 6);
        iconCompat.f1773i = bVar.t(iconCompat.f1773i, 7);
        iconCompat.f1774j = bVar.t(iconCompat.f1774j, 8);
        iconCompat.s();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, b bVar) {
        bVar.x(true, true);
        iconCompat.t(bVar.f());
        int i10 = iconCompat.f1765a;
        if (-1 != i10) {
            bVar.F(i10, 1);
        }
        byte[] bArr = iconCompat.f1767c;
        if (bArr != null) {
            bVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f1768d;
        if (parcelable != null) {
            bVar.H(parcelable, 3);
        }
        int i11 = iconCompat.f1769e;
        if (i11 != 0) {
            bVar.F(i11, 4);
        }
        int i12 = iconCompat.f1770f;
        if (i12 != 0) {
            bVar.F(i12, 5);
        }
        ColorStateList colorStateList = iconCompat.f1771g;
        if (colorStateList != null) {
            bVar.H(colorStateList, 6);
        }
        String str = iconCompat.f1773i;
        if (str != null) {
            bVar.J(str, 7);
        }
        String str2 = iconCompat.f1774j;
        if (str2 != null) {
            bVar.J(str2, 8);
        }
    }
}
