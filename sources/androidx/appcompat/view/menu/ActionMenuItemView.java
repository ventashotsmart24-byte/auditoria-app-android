package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.q0;
import androidx.appcompat.widget.t1;
import androidx.appcompat.widget.u2;
import com.google.common.primitives.Ints;

public class ActionMenuItemView extends q0 implements n.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: a  reason: collision with root package name */
    public i f809a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f810b;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f811c;

    /* renamed from: d  reason: collision with root package name */
    public g.b f812d;

    /* renamed from: e  reason: collision with root package name */
    public t1 f813e;

    /* renamed from: f  reason: collision with root package name */
    public b f814f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f815g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f816h;

    /* renamed from: i  reason: collision with root package name */
    public int f817i;

    /* renamed from: j  reason: collision with root package name */
    public int f818j;

    /* renamed from: k  reason: collision with root package name */
    public int f819k;

    public class a extends t1 {
        public a() {
            super(ActionMenuItemView.this);
        }

        public p b() {
            b bVar = ActionMenuItemView.this.f814f;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        public boolean c() {
            p b10;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            g.b bVar = actionMenuItemView.f812d;
            if (bVar == null || !bVar.b(actionMenuItemView.f809a) || (b10 = b()) == null || !b10.isShowing()) {
                return false;
            }
            return true;
        }
    }

    public static abstract class b {
        public abstract p a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean a() {
        return d();
    }

    public boolean b() {
        if (!d() || this.f809a.getIcon() != null) {
            return false;
        }
        return true;
    }

    public boolean d() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i10 = configuration.screenWidthDp;
        int i11 = configuration.screenHeightDp;
        if (i10 >= 480 || ((i10 >= 640 && i11 >= 480) || configuration.orientation == 2)) {
            return true;
        }
        return false;
    }

    public final void f() {
        CharSequence charSequence;
        CharSequence charSequence2;
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f810b);
        if (this.f811c != null && (!this.f809a.B() || (!this.f815g && !this.f816h))) {
            z10 = false;
        }
        boolean z12 = z11 & z10;
        CharSequence charSequence3 = null;
        if (z12) {
            charSequence = this.f810b;
        } else {
            charSequence = null;
        }
        setText(charSequence);
        CharSequence contentDescription = this.f809a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            if (z12) {
                charSequence2 = null;
            } else {
                charSequence2 = this.f809a.getTitle();
            }
            setContentDescription(charSequence2);
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f809a.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z12) {
                charSequence3 = this.f809a.getTitle();
            }
            u2.a(this, charSequence3);
            return;
        }
        u2.a(this, tooltipText);
    }

    public i getItemData() {
        return this.f809a;
    }

    public void initialize(i iVar, int i10) {
        int i11;
        this.f809a = iVar;
        setIcon(iVar.getIcon());
        setTitle(iVar.i(this));
        setId(iVar.getItemId());
        if (iVar.isVisible()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        setVisibility(i11);
        setEnabled(iVar.isEnabled());
        if (iVar.hasSubMenu() && this.f813e == null) {
            this.f813e = new a();
        }
    }

    public void onClick(View view) {
        g.b bVar = this.f812d;
        if (bVar != null) {
            bVar.b(this.f809a);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f815g = e();
        f();
    }

    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        boolean d10 = d();
        if (d10 && (i13 = this.f818j) >= 0) {
            super.setPadding(i13, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int measuredWidth = getMeasuredWidth();
        if (mode == Integer.MIN_VALUE) {
            i12 = Math.min(size, this.f817i);
        } else {
            i12 = this.f817i;
        }
        if (mode != 1073741824 && this.f817i > 0 && measuredWidth < i12) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, Ints.MAX_POWER_OF_TWO), i11);
        }
        if (!d10 && this.f811c != null) {
            super.setPadding((getMeasuredWidth() - this.f811c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState((Parcelable) null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        t1 t1Var;
        if (!this.f809a.hasSubMenu() || (t1Var = this.f813e) == null || !t1Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z10) {
    }

    public void setChecked(boolean z10) {
    }

    public void setExpandedFormat(boolean z10) {
        if (this.f816h != z10) {
            this.f816h = z10;
            i iVar = this.f809a;
            if (iVar != null) {
                iVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f811c = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i10 = this.f819k;
            if (intrinsicWidth > i10) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i10) / ((float) intrinsicWidth)));
                intrinsicWidth = i10;
            }
            if (intrinsicHeight > i10) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i10) / ((float) intrinsicHeight)));
            } else {
                i10 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i10);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        f();
    }

    public void setItemInvoker(g.b bVar) {
        this.f812d = bVar;
    }

    public void setPadding(int i10, int i11, int i12, int i13) {
        this.f818j = i10;
        super.setPadding(i10, i11, i12, i13);
    }

    public void setPopupCallback(b bVar) {
        this.f814f = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f810b = charSequence;
        f();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Resources resources = context.getResources();
        this.f815g = e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f542c, i10, 0);
        this.f817i = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f819k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f818j = -1;
        setSaveEnabled(false);
    }
}
