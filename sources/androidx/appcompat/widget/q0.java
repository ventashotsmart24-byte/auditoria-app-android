package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.appcompat.app.m;
import androidx.core.widget.b;
import androidx.core.widget.e0;
import b0.g0;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import r.e;
import z.o;

public class q0 extends TextView implements g0, androidx.core.widget.g0, b {
    private final f mBackgroundTintHelper;
    private Future<o> mPrecomputedTextFuture;
    private final g0 mTextClassifierHelper;
    private final p0 mTextHelper;

    public q0(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void c() {
        Future<o> future = this.mPrecomputedTextFuture;
        if (future != null) {
            try {
                this.mPrecomputedTextFuture = null;
                m.a(future.get());
                e0.n(this, (o) null);
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.b();
        }
        p0 p0Var = this.mTextHelper;
        if (p0Var != null) {
            p0Var.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (b.P) {
            return super.getAutoSizeMaxTextSize();
        }
        p0 p0Var = this.mTextHelper;
        if (p0Var != null) {
            return p0Var.e();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (b.P) {
            return super.getAutoSizeMinTextSize();
        }
        p0 p0Var = this.mTextHelper;
        if (p0Var != null) {
            return p0Var.f();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (b.P) {
            return super.getAutoSizeStepGranularity();
        }
        p0 p0Var = this.mTextHelper;
        if (p0Var != null) {
            return p0Var.g();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (b.P) {
            return super.getAutoSizeTextAvailableSizes();
        }
        p0 p0Var = this.mTextHelper;
        if (p0Var != null) {
            return p0Var.h();
        }
        return new int[0];
    }

    public int getAutoSizeTextType() {
        if (!b.P) {
            p0 p0Var = this.mTextHelper;
            if (p0Var != null) {
                return p0Var.i();
            }
            return 0;
        } else if (super.getAutoSizeTextType() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getFirstBaselineToTopHeight() {
        return e0.b(this);
    }

    public int getLastBaselineToBottomHeight() {
        return e0.c(this);
    }

    public ColorStateList getSupportBackgroundTintList() {
        f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            return fVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            return fVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.k();
    }

    public CharSequence getText() {
        c();
        return super.getText();
    }

    public TextClassifier getTextClassifier() {
        g0 g0Var;
        if (Build.VERSION.SDK_INT >= 28 || (g0Var = this.mTextClassifierHelper) == null) {
            return super.getTextClassifier();
        }
        return g0Var.a();
    }

    public o.a getTextMetricsParamsCompat() {
        return e0.g(this);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return m.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        p0 p0Var = this.mTextHelper;
        if (p0Var != null) {
            p0Var.n(z10, i10, i11, i12, i13);
        }
    }

    public void onMeasure(int i10, int i11) {
        c();
        super.onMeasure(i10, i11);
    }

    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        p0 p0Var = this.mTextHelper;
        if (p0Var != null && !b.P && p0Var.l()) {
            this.mTextHelper.c();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i10, int i11, int i12, int i13) {
        if (b.P) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
            return;
        }
        p0 p0Var = this.mTextHelper;
        if (p0Var != null) {
            p0Var.s(i10, i11, i12, i13);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i10) {
        if (b.P) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
            return;
        }
        p0 p0Var = this.mTextHelper;
        if (p0Var != null) {
            p0Var.t(iArr, i10);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i10) {
        if (b.P) {
            super.setAutoSizeTextTypeWithDefaults(i10);
            return;
        }
        p0 p0Var = this.mTextHelper;
        if (p0Var != null) {
            p0Var.u(i10);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.g(i10);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        p0 p0Var = this.mTextHelper;
        if (p0Var != null) {
            p0Var.o();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        p0 p0Var = this.mTextHelper;
        if (p0Var != null) {
            p0Var.o();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        p0 p0Var = this.mTextHelper;
        if (p0Var != null) {
            p0Var.o();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        p0 p0Var = this.mTextHelper;
        if (p0Var != null) {
            p0Var.o();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(e0.q(this, callback));
    }

    public void setFirstBaselineToTopHeight(int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i10);
        } else {
            e0.k(this, i10);
        }
    }

    public void setLastBaselineToBottomHeight(int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i10);
        } else {
            e0.l(this, i10);
        }
    }

    public void setLineHeight(int i10) {
        e0.m(this, i10);
    }

    public void setPrecomputedText(o oVar) {
        e0.n(this, oVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.mTextHelper.v(colorStateList);
        this.mTextHelper.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.mTextHelper.w(mode);
        this.mTextHelper.b();
    }

    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        p0 p0Var = this.mTextHelper;
        if (p0Var != null) {
            p0Var.p(context, i10);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        g0 g0Var;
        if (Build.VERSION.SDK_INT >= 28 || (g0Var = this.mTextClassifierHelper) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            g0Var.b(textClassifier);
        }
    }

    public void setTextFuture(Future<o> future) {
        this.mPrecomputedTextFuture = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(o.a aVar) {
        e0.p(this, aVar);
    }

    public void setTextSize(int i10, float f10) {
        if (b.P) {
            super.setTextSize(i10, f10);
            return;
        }
        p0 p0Var = this.mTextHelper;
        if (p0Var != null) {
            p0Var.z(i10, f10);
        }
    }

    public void setTypeface(Typeface typeface, int i10) {
        Typeface typeface2;
        if (typeface == null || i10 <= 0) {
            typeface2 = null;
        } else {
            typeface2 = e.a(getContext(), typeface, i10);
        }
        if (typeface2 != null) {
            typeface = typeface2;
        }
        super.setTypeface(typeface, i10);
    }

    public q0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public q0(Context context, AttributeSet attributeSet, int i10) {
        super(o2.b(context), attributeSet, i10);
        f fVar = new f(this);
        this.mBackgroundTintHelper = fVar;
        fVar.e(attributeSet, i10);
        p0 p0Var = new p0(this);
        this.mTextHelper = p0Var;
        p0Var.m(attributeSet, i10);
        p0Var.b();
        this.mTextClassifierHelper = new g0(this);
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable d10 = i10 != 0 ? d.b.d(context, i10) : null;
        Drawable d11 = i11 != 0 ? d.b.d(context, i11) : null;
        Drawable d12 = i12 != 0 ? d.b.d(context, i12) : null;
        if (i13 != 0) {
            drawable = d.b.d(context, i13);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(d10, d11, d12, drawable);
        p0 p0Var = this.mTextHelper;
        if (p0Var != null) {
            p0Var.o();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable d10 = i10 != 0 ? d.b.d(context, i10) : null;
        Drawable d11 = i11 != 0 ? d.b.d(context, i11) : null;
        Drawable d12 = i12 != 0 ? d.b.d(context, i12) : null;
        if (i13 != 0) {
            drawable = d.b.d(context, i13);
        }
        setCompoundDrawablesWithIntrinsicBounds(d10, d11, d12, drawable);
        p0 p0Var = this.mTextHelper;
        if (p0Var != null) {
            p0Var.o();
        }
    }
}
