package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import r.a;

public abstract class n2 {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal f1286a = new ThreadLocal();

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f1287b = {-16842910};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f1288c = {16842908};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f1289d = {16843518};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f1290e = {16842919};

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f1291f = {16842912};

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f1292g = {16842913};

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f1293h = {-16842919, -16842908};

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f1294i = new int[0];

    /* renamed from: j  reason: collision with root package name */
    public static final int[] f1295j = new int[1];

    public static int a(Context context, int i10) {
        ColorStateList d10 = d(context, i10);
        if (d10 != null && d10.isStateful()) {
            return d10.getColorForState(f1287b, d10.getDefaultColor());
        }
        TypedValue e10 = e();
        context.getTheme().resolveAttribute(16842803, e10, true);
        return c(context, i10, e10.getFloat());
    }

    public static int b(Context context, int i10) {
        int[] iArr = f1295j;
        iArr[0] = i10;
        r2 t10 = r2.t(context, (AttributeSet) null, iArr);
        try {
            return t10.b(0, 0);
        } finally {
            t10.v();
        }
    }

    public static int c(Context context, int i10, float f10) {
        int b10 = b(context, i10);
        return a.m(b10, Math.round(((float) Color.alpha(b10)) * f10));
    }

    public static ColorStateList d(Context context, int i10) {
        int[] iArr = f1295j;
        iArr[0] = i10;
        r2 t10 = r2.t(context, (AttributeSet) null, iArr);
        try {
            return t10.c(0);
        } finally {
            t10.v();
        }
    }

    public static TypedValue e() {
        ThreadLocal threadLocal = f1286a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
