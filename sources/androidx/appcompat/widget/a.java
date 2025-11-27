package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import b0.a2;
import b0.b2;
import b0.c1;

public abstract class a extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public final C0015a f1162a = new C0015a();

    /* renamed from: b  reason: collision with root package name */
    public final Context f1163b;

    /* renamed from: c  reason: collision with root package name */
    public ActionMenuView f1164c;

    /* renamed from: d  reason: collision with root package name */
    public d f1165d;

    /* renamed from: e  reason: collision with root package name */
    public int f1166e;

    /* renamed from: f  reason: collision with root package name */
    public a2 f1167f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1168g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1169h;

    /* renamed from: androidx.appcompat.widget.a$a  reason: collision with other inner class name */
    public class C0015a implements b2 {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1170a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f1171b;

        public C0015a() {
        }

        public void a(View view) {
            this.f1170a = true;
        }

        public void b(View view) {
            if (!this.f1170a) {
                a aVar = a.this;
                aVar.f1167f = null;
                a.super.setVisibility(this.f1171b);
            }
        }

        public void c(View view) {
            a.super.setVisibility(0);
            this.f1170a = false;
        }

        public C0015a d(a2 a2Var, int i10) {
            a.this.f1167f = a2Var;
            this.f1171b = i10;
            return this;
        }
    }

    public a(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1163b = context;
        } else {
            this.f1163b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    public static int d(int i10, int i11, boolean z10) {
        return z10 ? i10 - i11 : i10 + i11;
    }

    public int c(View view, int i10, int i11, int i12) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE), i11);
        return Math.max(0, (i10 - view.getMeasuredWidth()) - i12);
    }

    public int e(View view, int i10, int i11, int i12, boolean z10) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i13 = i11 + ((i12 - measuredHeight) / 2);
        if (z10) {
            view.layout(i10 - measuredWidth, i13, i10, measuredHeight + i13);
        } else {
            view.layout(i10, i13, i10 + measuredWidth, measuredHeight + i13);
        }
        if (z10) {
            return -measuredWidth;
        }
        return measuredWidth;
    }

    public a2 f(int i10, long j10) {
        a2 a2Var = this.f1167f;
        if (a2Var != null) {
            a2Var.b();
        }
        if (i10 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            a2 a10 = c1.c(this).a(1.0f);
            a10.d(j10);
            a10.f(this.f1162a.d(a10, i10));
            return a10;
        }
        a2 a11 = c1.c(this).a(0.0f);
        a11.d(j10);
        a11.f(this.f1162a.d(a11, i10));
        return a11;
    }

    public int getAnimatedVisibility() {
        if (this.f1167f != null) {
            return this.f1162a.f1171b;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f1166e;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, R$styleable.f540a, R$attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        d dVar = this.f1165d;
        if (dVar != null) {
            dVar.w(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1169h = false;
        }
        if (!this.f1169h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1169h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1169h = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1168g = false;
        }
        if (!this.f1168g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1168g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1168g = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i10);

    public void setVisibility(int i10) {
        if (i10 != getVisibility()) {
            a2 a2Var = this.f1167f;
            if (a2Var != null) {
                a2Var.b();
            }
            super.setVisibility(i10);
        }
    }
}
