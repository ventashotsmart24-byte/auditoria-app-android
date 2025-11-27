package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import b0.k;
import g.b;

public class j extends Dialog implements e {
    private f mDelegate;
    private final k.a mKeyDispatcher = new a();

    public class a implements k.a {
        public a() {
        }

        public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
            return j.this.superDispatchKeyEvent(keyEvent);
        }
    }

    public j(Context context, int i10) {
        super(context, getThemeResId(context, i10));
        f delegate = getDelegate();
        delegate.C(getThemeResId(context, i10));
        delegate.p((Bundle) null);
    }

    public static int getThemeResId(Context context, int i10) {
        if (i10 != 0) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().a(view, layoutParams);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return k.e(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }

    public <T extends View> T findViewById(int i10) {
        return getDelegate().e(i10);
    }

    public f getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = f.d(this, this);
        }
        return this.mDelegate;
    }

    public a getSupportActionBar() {
        return getDelegate().j();
    }

    public void invalidateOptionsMenu() {
        getDelegate().l();
    }

    public void onCreate(Bundle bundle) {
        getDelegate().k();
        super.onCreate(bundle);
        getDelegate().p(bundle);
    }

    public void onStop() {
        super.onStop();
        getDelegate().v();
    }

    public void onSupportActionModeFinished(b bVar) {
    }

    public void onSupportActionModeStarted(b bVar) {
    }

    public b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    public void setContentView(int i10) {
        getDelegate().y(i10);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().D(charSequence);
    }

    /* access modifiers changed from: package-private */
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean supportRequestWindowFeature(int i10) {
        return getDelegate().x(i10);
    }

    public void setContentView(View view) {
        getDelegate().z(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().A(view, layoutParams);
    }

    public void setTitle(int i10) {
        super.setTitle(i10);
        getDelegate().D(getContext().getString(i10));
    }

    public j(Context context, boolean z10, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z10, onCancelListener);
    }
}
