package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.core.widget.e0;
import d.b;

public class i extends CheckedTextView {

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f1241b = {16843016};

    /* renamed from: a  reason: collision with root package name */
    public final p0 f1242a;

    public i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        p0 p0Var = this.f1242a;
        if (p0Var != null) {
            p0Var.b();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return m.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setCheckMarkDrawable(int i10) {
        setCheckMarkDrawable(b.d(getContext(), i10));
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(e0.q(this, callback));
    }

    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        p0 p0Var = this.f1242a;
        if (p0Var != null) {
            p0Var.p(context, i10);
        }
    }

    public i(Context context, AttributeSet attributeSet, int i10) {
        super(o2.b(context), attributeSet, i10);
        p0 p0Var = new p0(this);
        this.f1242a = p0Var;
        p0Var.m(attributeSet, i10);
        p0Var.b();
        r2 u10 = r2.u(getContext(), attributeSet, f1241b, i10, 0);
        setCheckMarkDrawable(u10.g(0));
        u10.v();
    }
}
