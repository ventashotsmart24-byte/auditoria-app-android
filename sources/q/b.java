package q;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Shader;
import android.util.Log;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Shader f8819a;

    /* renamed from: b  reason: collision with root package name */
    public final ColorStateList f8820b;

    /* renamed from: c  reason: collision with root package name */
    public int f8821c;

    public b(Shader shader, ColorStateList colorStateList, int i10) {
        this.f8819a = shader;
        this.f8820b = colorStateList;
        this.f8821c = i10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static q.b a(android.content.res.Resources r4, int r5, android.content.res.Resources.Theme r6) {
        /*
            android.content.res.XmlResourceParser r5 = r4.getXml(r5)
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r5)
        L_0x0008:
            int r1 = r5.next()
            r2 = 2
            if (r1 == r2) goto L_0x0013
            r3 = 1
            if (r1 == r3) goto L_0x0013
            goto L_0x0008
        L_0x0013:
            if (r1 != r2) goto L_0x005c
            java.lang.String r1 = r5.getName()
            r1.hashCode()
            java.lang.String r2 = "gradient"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x0053
            java.lang.String r2 = "selector"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0035
            android.content.res.ColorStateList r4 = q.a.b(r4, r5, r0, r6)
            q.b r4 = c(r4)
            return r4
        L_0x0035:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r5 = r5.getPositionDescription()
            r6.append(r5)
            java.lang.String r5 = ": unsupported complex color tag "
            r6.append(r5)
            r6.append(r1)
            java.lang.String r5 = r6.toString()
            r4.<init>(r5)
            throw r4
        L_0x0053:
            android.graphics.Shader r4 = q.e.b(r4, r5, r0, r6)
            q.b r4 = d(r4)
            return r4
        L_0x005c:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r5 = "No start tag found"
            r4.<init>(r5)
            goto L_0x0065
        L_0x0064:
            throw r4
        L_0x0065:
            goto L_0x0064
        */
        throw new UnsupportedOperationException("Method not decompiled: q.b.a(android.content.res.Resources, int, android.content.res.Resources$Theme):q.b");
    }

    public static b b(int i10) {
        return new b((Shader) null, (ColorStateList) null, i10);
    }

    public static b c(ColorStateList colorStateList) {
        return new b((Shader) null, colorStateList, colorStateList.getDefaultColor());
    }

    public static b d(Shader shader) {
        return new b(shader, (ColorStateList) null, 0);
    }

    public static b g(Resources resources, int i10, Resources.Theme theme) {
        try {
            return a(resources, i10, theme);
        } catch (Exception e10) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e10);
            return null;
        }
    }

    public int e() {
        return this.f8821c;
    }

    public Shader f() {
        return this.f8819a;
    }

    public boolean h() {
        if (this.f8819a != null) {
            return true;
        }
        return false;
    }

    public boolean i() {
        ColorStateList colorStateList;
        if (this.f8819a != null || (colorStateList = this.f8820b) == null || !colorStateList.isStateful()) {
            return false;
        }
        return true;
    }

    public boolean j(int[] iArr) {
        if (i()) {
            ColorStateList colorStateList = this.f8820b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f8821c) {
                this.f8821c = colorForState;
                return true;
            }
        }
        return false;
    }

    public void k(int i10) {
        this.f8821c = i10;
    }

    public boolean l() {
        if (h() || this.f8821c != 0) {
            return true;
        }
        return false;
    }
}
