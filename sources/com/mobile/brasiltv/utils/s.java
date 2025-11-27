package com.mobile.brasiltv.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import s9.l;
import t9.i;
import t9.j;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    public static final s f12613a = new s();

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Button f12614a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Button button) {
            super(1);
            this.f12614a = button;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return t.f17319a;
        }

        public final void invoke(Boolean bool) {
            s sVar = s.f12613a;
            i.f(bool, "it");
            sVar.e(bool.booleanValue(), this.f12614a);
        }
    }

    public static final class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f12615a;

        public b(ObservableEmitter observableEmitter) {
            this.f12615a = observableEmitter;
        }

        public void afterTextChanged(Editable editable) {
            i.g(editable, "s");
            this.f12615a.onNext(editable);
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        if (r2 != false) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Boolean g(android.text.Editable r2, android.text.Editable r3) {
        /*
            java.lang.String r0 = "t1"
            t9.i.g(r2, r0)
            java.lang.String r0 = "t2"
            t9.i.g(r3, r0)
            int r2 = r2.length()
            r0 = 1
            r1 = 0
            if (r2 <= 0) goto L_0x0014
            r2 = 1
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            if (r2 == 0) goto L_0x0023
            int r2 = r3.length()
            if (r2 <= 0) goto L_0x001f
            r2 = 1
            goto L_0x0020
        L_0x001f:
            r2 = 0
        L_0x0020:
            if (r2 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r0 = 0
        L_0x0024:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.s.g(android.text.Editable, android.text.Editable):java.lang.Boolean");
    }

    public static final void i(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void k(EditText editText, ObservableEmitter observableEmitter) {
        i.g(editText, "$editText");
        i.g(observableEmitter, "subscriber");
        editText.addTextChangedListener(new b(observableEmitter));
    }

    public final void e(boolean z10, Button button) {
        if (z10) {
            button.setEnabled(true);
            button.setAlpha(1.0f);
            return;
        }
        button.setEnabled(false);
        button.setAlpha(0.6f);
    }

    public final Observable f(EditText editText, EditText editText2) {
        i.g(editText, "edit1");
        i.g(editText2, "edit2");
        Observable combineLatest = Observable.combineLatest(j(editText), j(editText2), new q());
        i.f(combineLatest, "combineLatest(create(edi…2.isNotEmpty()\n        })");
        return combineLatest;
    }

    public final void h(EditText editText, EditText editText2, Button button) {
        i.g(editText, "edit1");
        i.g(editText2, "edit2");
        i.g(button, "button");
        f(editText, editText2).subscribe(new p(new a(button)));
    }

    public final Observable j(EditText editText) {
        i.g(editText, "editText");
        Observable create = Observable.create(new r(editText));
        i.f(create, "create({ subscriber ->\n …            })\n        })");
        return create;
    }
}
