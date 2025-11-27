package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.AlertController;

public class c extends j implements DialogInterface {
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    final AlertController mAlert = new AlertController(getContext(), this, getWindow());

    public static class a {
        private final AlertController.f P;
        private final int mTheme;

        public a(Context context) {
            this(context, c.resolveDialogTheme(context, 0));
        }

        public c create() {
            c cVar = new c(this.P.f607a, this.mTheme);
            this.P.a(cVar.mAlert);
            cVar.setCancelable(this.P.f624r);
            if (this.P.f624r) {
                cVar.setCanceledOnTouchOutside(true);
            }
            cVar.setOnCancelListener(this.P.f625s);
            cVar.setOnDismissListener(this.P.f626t);
            DialogInterface.OnKeyListener onKeyListener = this.P.f627u;
            if (onKeyListener != null) {
                cVar.setOnKeyListener(onKeyListener);
            }
            return cVar;
        }

        public Context getContext() {
            return this.P.f607a;
        }

        public a setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f629w = listAdapter;
            fVar.f630x = onClickListener;
            return this;
        }

        public a setCancelable(boolean z10) {
            this.P.f624r = z10;
            return this;
        }

        public a setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            AlertController.f fVar = this.P;
            fVar.K = cursor;
            fVar.L = str;
            fVar.f630x = onClickListener;
            return this;
        }

        public a setCustomTitle(View view) {
            this.P.f613g = view;
            return this;
        }

        public a setIcon(int i10) {
            this.P.f609c = i10;
            return this;
        }

        public a setIconAttribute(int i10) {
            TypedValue typedValue = new TypedValue();
            this.P.f607a.getTheme().resolveAttribute(i10, typedValue, true);
            this.P.f609c = typedValue.resourceId;
            return this;
        }

        @Deprecated
        public a setInverseBackgroundForced(boolean z10) {
            this.P.N = z10;
            return this;
        }

        public a setItems(int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f628v = fVar.f607a.getResources().getTextArray(i10);
            this.P.f630x = onClickListener;
            return this;
        }

        public a setMessage(int i10) {
            AlertController.f fVar = this.P;
            fVar.f614h = fVar.f607a.getText(i10);
            return this;
        }

        public a setMultiChoiceItems(int i10, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.f fVar = this.P;
            fVar.f628v = fVar.f607a.getResources().getTextArray(i10);
            AlertController.f fVar2 = this.P;
            fVar2.J = onMultiChoiceClickListener;
            fVar2.F = zArr;
            fVar2.G = true;
            return this;
        }

        public a setNegativeButton(int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f618l = fVar.f607a.getText(i10);
            this.P.f620n = onClickListener;
            return this;
        }

        public a setNegativeButtonIcon(Drawable drawable) {
            this.P.f619m = drawable;
            return this;
        }

        public a setNeutralButton(int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f621o = fVar.f607a.getText(i10);
            this.P.f623q = onClickListener;
            return this;
        }

        public a setNeutralButtonIcon(Drawable drawable) {
            this.P.f622p = drawable;
            return this;
        }

        public a setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.P.f625s = onCancelListener;
            return this;
        }

        public a setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.P.f626t = onDismissListener;
            return this;
        }

        public a setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.P.O = onItemSelectedListener;
            return this;
        }

        public a setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.P.f627u = onKeyListener;
            return this;
        }

        public a setPositiveButton(int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f615i = fVar.f607a.getText(i10);
            this.P.f617k = onClickListener;
            return this;
        }

        public a setPositiveButtonIcon(Drawable drawable) {
            this.P.f616j = drawable;
            return this;
        }

        public a setRecycleOnMeasureEnabled(boolean z10) {
            this.P.P = z10;
            return this;
        }

        public a setSingleChoiceItems(int i10, int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f628v = fVar.f607a.getResources().getTextArray(i10);
            AlertController.f fVar2 = this.P;
            fVar2.f630x = onClickListener;
            fVar2.I = i11;
            fVar2.H = true;
            return this;
        }

        public a setTitle(int i10) {
            AlertController.f fVar = this.P;
            fVar.f612f = fVar.f607a.getText(i10);
            return this;
        }

        public a setView(int i10) {
            AlertController.f fVar = this.P;
            fVar.f632z = null;
            fVar.f631y = i10;
            fVar.E = false;
            return this;
        }

        public c show() {
            c create = create();
            create.show();
            return create;
        }

        public a(Context context, int i10) {
            this.P = new AlertController.f(new ContextThemeWrapper(context, c.resolveDialogTheme(context, i10)));
            this.mTheme = i10;
        }

        public a setIcon(Drawable drawable) {
            this.P.f610d = drawable;
            return this;
        }

        public a setMessage(CharSequence charSequence) {
            this.P.f614h = charSequence;
            return this;
        }

        public a setTitle(CharSequence charSequence) {
            this.P.f612f = charSequence;
            return this;
        }

        public a setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f628v = charSequenceArr;
            fVar.f630x = onClickListener;
            return this;
        }

        public a setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f618l = charSequence;
            fVar.f620n = onClickListener;
            return this;
        }

        public a setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f621o = charSequence;
            fVar.f623q = onClickListener;
            return this;
        }

        public a setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f615i = charSequence;
            fVar.f617k = onClickListener;
            return this;
        }

        public a setView(View view) {
            AlertController.f fVar = this.P;
            fVar.f632z = view;
            fVar.f631y = 0;
            fVar.E = false;
            return this;
        }

        public a setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.f fVar = this.P;
            fVar.f628v = charSequenceArr;
            fVar.J = onMultiChoiceClickListener;
            fVar.F = zArr;
            fVar.G = true;
            return this;
        }

        public a setSingleChoiceItems(Cursor cursor, int i10, String str, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.K = cursor;
            fVar.f630x = onClickListener;
            fVar.I = i10;
            fVar.L = str;
            fVar.H = true;
            return this;
        }

        @Deprecated
        public a setView(View view, int i10, int i11, int i12, int i13) {
            AlertController.f fVar = this.P;
            fVar.f632z = view;
            fVar.f631y = 0;
            fVar.E = true;
            fVar.A = i10;
            fVar.B = i11;
            fVar.C = i12;
            fVar.D = i13;
            return this;
        }

        public a setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.f fVar = this.P;
            fVar.K = cursor;
            fVar.J = onMultiChoiceClickListener;
            fVar.M = str;
            fVar.L = str2;
            fVar.G = true;
            return this;
        }

        public a setSingleChoiceItems(CharSequence[] charSequenceArr, int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f628v = charSequenceArr;
            fVar.f630x = onClickListener;
            fVar.I = i10;
            fVar.H = true;
            return this;
        }

        public a setSingleChoiceItems(ListAdapter listAdapter, int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f629w = listAdapter;
            fVar.f630x = onClickListener;
            fVar.I = i10;
            fVar.H = true;
            return this;
        }
    }

    public c(Context context, int i10) {
        super(context, resolveDialogTheme(context, i10));
    }

    public static int resolveDialogTheme(Context context, int i10) {
        if (((i10 >>> 24) & 255) >= 1) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button getButton(int i10) {
        return this.mAlert.c(i10);
    }

    public ListView getListView() {
        return this.mAlert.e();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAlert.f();
    }

    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (this.mAlert.h(i10, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (this.mAlert.i(i10, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    public void setButton(int i10, CharSequence charSequence, Message message) {
        this.mAlert.l(i10, charSequence, (DialogInterface.OnClickListener) null, message, (Drawable) null);
    }

    public void setButtonPanelLayoutHint(int i10) {
        this.mAlert.m(i10);
    }

    public void setCustomTitle(View view) {
        this.mAlert.n(view);
    }

    public void setIcon(int i10) {
        this.mAlert.o(i10);
    }

    public void setIconAttribute(int i10) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i10, typedValue, true);
        this.mAlert.o(typedValue.resourceId);
    }

    public void setMessage(CharSequence charSequence) {
        this.mAlert.q(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.mAlert.s(charSequence);
    }

    public void setView(View view) {
        this.mAlert.u(view);
    }

    public void setButton(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.l(i10, charSequence, onClickListener, (Message) null, (Drawable) null);
    }

    public void setIcon(Drawable drawable) {
        this.mAlert.p(drawable);
    }

    public void setView(View view, int i10, int i11, int i12, int i13) {
        this.mAlert.v(view, i10, i11, i12, i13);
    }

    public void setButton(int i10, CharSequence charSequence, Drawable drawable, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.l(i10, charSequence, onClickListener, (Message) null, drawable);
    }
}
