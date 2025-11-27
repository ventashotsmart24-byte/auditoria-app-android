package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import d.b;
import q.h;

public class r2 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1351a;

    /* renamed from: b  reason: collision with root package name */
    public final TypedArray f1352b;

    /* renamed from: c  reason: collision with root package name */
    public TypedValue f1353c;

    public r2(Context context, TypedArray typedArray) {
        this.f1351a = context;
        this.f1352b = typedArray;
    }

    public static r2 s(Context context, int i10, int[] iArr) {
        return new r2(context, context.obtainStyledAttributes(i10, iArr));
    }

    public static r2 t(Context context, AttributeSet attributeSet, int[] iArr) {
        return new r2(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static r2 u(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11) {
        return new r2(context, context.obtainStyledAttributes(attributeSet, iArr, i10, i11));
    }

    public boolean a(int i10, boolean z10) {
        return this.f1352b.getBoolean(i10, z10);
    }

    public int b(int i10, int i11) {
        return this.f1352b.getColor(i10, i11);
    }

    public ColorStateList c(int i10) {
        int resourceId;
        ColorStateList c10;
        if (!this.f1352b.hasValue(i10) || (resourceId = this.f1352b.getResourceId(i10, 0)) == 0 || (c10 = b.c(this.f1351a, resourceId)) == null) {
            return this.f1352b.getColorStateList(i10);
        }
        return c10;
    }

    public float d(int i10, float f10) {
        return this.f1352b.getDimension(i10, f10);
    }

    public int e(int i10, int i11) {
        return this.f1352b.getDimensionPixelOffset(i10, i11);
    }

    public int f(int i10, int i11) {
        return this.f1352b.getDimensionPixelSize(i10, i11);
    }

    public Drawable g(int i10) {
        int resourceId;
        if (!this.f1352b.hasValue(i10) || (resourceId = this.f1352b.getResourceId(i10, 0)) == 0) {
            return this.f1352b.getDrawable(i10);
        }
        return b.d(this.f1351a, resourceId);
    }

    public Drawable h(int i10) {
        int resourceId;
        if (!this.f1352b.hasValue(i10) || (resourceId = this.f1352b.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return k.b().d(this.f1351a, resourceId, true);
    }

    public float i(int i10, float f10) {
        return this.f1352b.getFloat(i10, f10);
    }

    public Typeface j(int i10, int i11, h.c cVar) {
        int resourceId = this.f1352b.getResourceId(i10, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1353c == null) {
            this.f1353c = new TypedValue();
        }
        return h.f(this.f1351a, resourceId, this.f1353c, i11, cVar);
    }

    public int k(int i10, int i11) {
        return this.f1352b.getInt(i10, i11);
    }

    public int l(int i10, int i11) {
        return this.f1352b.getInteger(i10, i11);
    }

    public int m(int i10, int i11) {
        return this.f1352b.getLayoutDimension(i10, i11);
    }

    public int n(int i10, int i11) {
        return this.f1352b.getResourceId(i10, i11);
    }

    public String o(int i10) {
        return this.f1352b.getString(i10);
    }

    public CharSequence p(int i10) {
        return this.f1352b.getText(i10);
    }

    public CharSequence[] q(int i10) {
        return this.f1352b.getTextArray(i10);
    }

    public boolean r(int i10) {
        return this.f1352b.hasValue(i10);
    }

    public void v() {
        this.f1352b.recycle();
    }
}
