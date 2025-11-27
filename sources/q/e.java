package q;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.core.R$styleable;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public abstract class e {
    public static a a(a aVar, int i10, int i11, boolean z10, int i12) {
        if (aVar != null) {
            return aVar;
        }
        if (z10) {
            return new a(i10, i12, i11);
        }
        return new a(i10, i11);
    }

    public static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            Resources.Theme theme2 = theme;
            TypedArray k10 = i.k(resources, theme2, attributeSet, R$styleable.f1750e);
            float f10 = i.f(k10, xmlPullParser2, "startX", R$styleable.GradientColor_android_startX, 0.0f);
            float f11 = i.f(k10, xmlPullParser2, "startY", R$styleable.GradientColor_android_startY, 0.0f);
            float f12 = i.f(k10, xmlPullParser2, "endX", R$styleable.GradientColor_android_endX, 0.0f);
            float f13 = i.f(k10, xmlPullParser2, "endY", R$styleable.GradientColor_android_endY, 0.0f);
            float f14 = i.f(k10, xmlPullParser2, "centerX", R$styleable.GradientColor_android_centerX, 0.0f);
            float f15 = i.f(k10, xmlPullParser2, "centerY", R$styleable.GradientColor_android_centerY, 0.0f);
            int g10 = i.g(k10, xmlPullParser2, "type", R$styleable.GradientColor_android_type, 0);
            int b10 = i.b(k10, xmlPullParser2, "startColor", R$styleable.GradientColor_android_startColor, 0);
            boolean j10 = i.j(xmlPullParser2, "centerColor");
            int b11 = i.b(k10, xmlPullParser2, "centerColor", R$styleable.GradientColor_android_centerColor, 0);
            int b12 = i.b(k10, xmlPullParser2, "endColor", R$styleable.GradientColor_android_endColor, 0);
            int g11 = i.g(k10, xmlPullParser2, "tileMode", R$styleable.GradientColor_android_tileMode, 0);
            float f16 = f14;
            float f17 = i.f(k10, xmlPullParser2, "gradientRadius", R$styleable.GradientColor_android_gradientRadius, 0.0f);
            k10.recycle();
            a a10 = a(c(resources, xmlPullParser, attributeSet, theme), b10, b12, j10, b11);
            if (g10 == 1) {
                float f18 = f16;
                if (f17 > 0.0f) {
                    int[] iArr = a10.f8833a;
                    return new RadialGradient(f18, f15, f17, iArr, a10.f8834b, d(g11));
                }
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            } else if (g10 != 2) {
                return new LinearGradient(f10, f11, f12, f13, a10.f8833a, a10.f8834b, d(g11));
            } else {
                return new SweepGradient(f16, f15, a10.f8833a, a10.f8834b);
            }
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0080, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static q.e.a c(android.content.res.Resources r9, org.xmlpull.v1.XmlPullParser r10, android.util.AttributeSet r11, android.content.res.Resources.Theme r12) {
        /*
            int r0 = r10.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L_0x0012:
            int r3 = r10.next()
            if (r3 == r1) goto L_0x0081
            int r5 = r10.getDepth()
            if (r5 >= r0) goto L_0x0021
            r6 = 3
            if (r3 == r6) goto L_0x0081
        L_0x0021:
            r6 = 2
            if (r3 == r6) goto L_0x0025
            goto L_0x0012
        L_0x0025:
            if (r5 > r0) goto L_0x0012
            java.lang.String r3 = r10.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0034
            goto L_0x0012
        L_0x0034:
            int[] r3 = androidx.core.R$styleable.f1751f
            android.content.res.TypedArray r3 = q.i.k(r9, r12, r11, r3)
            int r5 = androidx.core.R$styleable.GradientColorItem_android_color
            boolean r6 = r3.hasValue(r5)
            int r7 = androidx.core.R$styleable.GradientColorItem_android_offset
            boolean r8 = r3.hasValue(r7)
            if (r6 == 0) goto L_0x0066
            if (r8 == 0) goto L_0x0066
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            r6 = 0
            float r6 = r3.getFloat(r7, r6)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L_0x0012
        L_0x0066:
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r10 = r10.getPositionDescription()
            r11.append(r10)
            java.lang.String r10 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>(r10)
            throw r9
        L_0x0081:
            int r9 = r4.size()
            if (r9 <= 0) goto L_0x008d
            q.e$a r9 = new q.e$a
            r9.<init>((java.util.List) r4, (java.util.List) r2)
            return r9
        L_0x008d:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: q.e.c(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):q.e$a");
    }

    public static Shader.TileMode d(int i10) {
        if (i10 == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (i10 != 2) {
            return Shader.TileMode.CLAMP;
        }
        return Shader.TileMode.MIRROR;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f8833a;

        /* renamed from: b  reason: collision with root package name */
        public final float[] f8834b;

        public a(List list, List list2) {
            int size = list.size();
            this.f8833a = new int[size];
            this.f8834b = new float[size];
            for (int i10 = 0; i10 < size; i10++) {
                this.f8833a[i10] = ((Integer) list.get(i10)).intValue();
                this.f8834b[i10] = ((Float) list2.get(i10)).floatValue();
            }
        }

        public a(int i10, int i11) {
            this.f8833a = new int[]{i10, i11};
            this.f8834b = new float[]{0.0f, 1.0f};
        }

        public a(int i10, int i11, int i12) {
            this.f8833a = new int[]{i10, i11, i12};
            this.f8834b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
