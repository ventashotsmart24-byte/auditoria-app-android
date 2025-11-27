package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.R$attr;
import b0.g0;
import d.b;

public class r extends MultiAutoCompleteTextView implements g0 {

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f1332c = {16843126};

    /* renamed from: a  reason: collision with root package name */
    public final f f1333a;

    /* renamed from: b  reason: collision with root package name */
    public final p0 f1334b;

    public r(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        f fVar = this.f1333a;
        if (fVar != null) {
            fVar.b();
        }
        p0 p0Var = this.f1334b;
        if (p0Var != null) {
            p0Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        f fVar = this.f1333a;
        if (fVar != null) {
            return fVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        f fVar = this.f1333a;
        if (fVar != null) {
            return fVar.d();
        }
        return null;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return m.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        f fVar = this.f1333a;
        if (fVar != null) {
            fVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        f fVar = this.f1333a;
        if (fVar != null) {
            fVar.g(i10);
        }
    }

    public void setDropDownBackgroundResource(int i10) {
        setDropDownBackgroundDrawable(b.d(getContext(), i10));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        f fVar = this.f1333a;
        if (fVar != null) {
            fVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        f fVar = this.f1333a;
        if (fVar != null) {
            fVar.j(mode);
        }
    }

    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        p0 p0Var = this.f1334b;
        if (p0Var != null) {
            p0Var.p(context, i10);
        }
    }

    public r(Context context, AttributeSet attributeSet, int i10) {
        super(o2.b(context), attributeSet, i10);
        r2 u10 = r2.u(getContext(), attributeSet, f1332c, i10, 0);
        if (u10.r(0)) {
            setDropDownBackgroundDrawable(u10.g(0));
        }
        u10.v();
        f fVar = new f(this);
        this.f1333a = fVar;
        fVar.e(attributeSet, i10);
        p0 p0Var = new p0(this);
        this.f1334b = p0Var;
        p0Var.m(attributeSet, i10);
        p0Var.b();
    }
}
