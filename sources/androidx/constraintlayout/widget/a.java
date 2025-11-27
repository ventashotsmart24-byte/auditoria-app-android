package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import m.j;

public abstract class a extends View {

    /* renamed from: a  reason: collision with root package name */
    public int[] f1654a = new int[32];

    /* renamed from: b  reason: collision with root package name */
    public int f1655b;

    /* renamed from: c  reason: collision with root package name */
    public Context f1656c;

    /* renamed from: d  reason: collision with root package name */
    public j f1657d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1658e = false;

    /* renamed from: f  reason: collision with root package name */
    public String f1659f;

    public a(Context context) {
        super(context);
        this.f1656c = context;
        b((AttributeSet) null);
    }

    private void setIds(String str) {
        if (str != null) {
            int i10 = 0;
            while (true) {
                int indexOf = str.indexOf(44, i10);
                if (indexOf == -1) {
                    a(str.substring(i10));
                    return;
                } else {
                    a(str.substring(i10, indexOf));
                    i10 = indexOf + 1;
                }
            }
        }
    }

    public final void a(String str) {
        int i10;
        Object c10;
        if (str != null && this.f1656c != null) {
            String trim = str.trim();
            try {
                i10 = R$id.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i10 = 0;
            }
            if (i10 == 0) {
                i10 = this.f1656c.getResources().getIdentifier(trim, "id", this.f1656c.getPackageName());
            }
            if (i10 == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout) && (c10 = ((ConstraintLayout) getParent()).c(0, trim)) != null && (c10 instanceof Integer)) {
                i10 = ((Integer) c10).intValue();
            }
            if (i10 != 0) {
                setTag(i10, (Object) null);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Could not find id of \"");
            sb.append(trim);
            sb.append("\"");
        }
    }

    public void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f1650a);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f1659f = string;
                    setIds(string);
                }
            }
        }
    }

    public void c(ConstraintLayout constraintLayout) {
    }

    public void d(ConstraintLayout constraintLayout) {
    }

    public void e(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.f1659f);
        }
        j jVar = this.f1657d;
        if (jVar != null) {
            jVar.J0();
            for (int i10 = 0; i10 < this.f1655b; i10++) {
                View e10 = constraintLayout.e(this.f1654a[i10]);
                if (e10 != null) {
                    this.f1657d.I0(constraintLayout.f(e10));
                }
            }
        }
    }

    public void f() {
        if (this.f1657d != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.a) {
                ((ConstraintLayout.a) layoutParams).f1633l0 = this.f1657d;
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f1654a, this.f1655b);
    }

    public void onDraw(Canvas canvas) {
    }

    public void onMeasure(int i10, int i11) {
        if (this.f1658e) {
            super.onMeasure(i10, i11);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f1655b = 0;
        for (int tag : iArr) {
            setTag(tag, (Object) null);
        }
    }

    public void setTag(int i10, Object obj) {
        int i11 = this.f1655b + 1;
        int[] iArr = this.f1654a;
        if (i11 > iArr.length) {
            this.f1654a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f1654a;
        int i12 = this.f1655b;
        iArr2[i12] = i10;
        this.f1655b = i12 + 1;
    }
}
