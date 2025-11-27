package n;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.R$styleable;
import m.b;

public class a extends androidx.constraintlayout.widget.a {

    /* renamed from: g  reason: collision with root package name */
    public int f7918g;

    /* renamed from: h  reason: collision with root package name */
    public int f7919h;

    /* renamed from: i  reason: collision with root package name */
    public b f7920i;

    public a(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public void b(AttributeSet attributeSet) {
        super.b(attributeSet);
        this.f7920i = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f1650a);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f7920i.K0(obtainStyledAttributes.getBoolean(index, true));
                }
            }
        }
        this.f1657d = this.f7920i;
        f();
    }

    public int getType() {
        return this.f7918g;
    }

    public void setAllowsGoneWidget(boolean z10) {
        this.f7920i.K0(z10);
    }

    public void setType(int i10) {
        boolean z10;
        this.f7918g = i10;
        this.f7919h = i10;
        if (1 == getResources().getConfiguration().getLayoutDirection()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            int i11 = this.f7918g;
            if (i11 == 5) {
                this.f7919h = 1;
            } else if (i11 == 6) {
                this.f7919h = 0;
            }
        } else {
            int i12 = this.f7918g;
            if (i12 == 5) {
                this.f7919h = 0;
            } else if (i12 == 6) {
                this.f7919h = 1;
            }
        }
        this.f7920i.L0(this.f7919h);
    }
}
