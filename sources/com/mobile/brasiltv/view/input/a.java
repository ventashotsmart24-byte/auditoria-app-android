package com.mobile.brasiltv.view.input;

import android.view.View;

public final /* synthetic */ class a implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccountInputView f12798a;

    public /* synthetic */ a(AccountInputView accountInputView) {
        this.f12798a = accountInputView;
    }

    public final void onFocusChange(View view, boolean z10) {
        AccountInputView.initListeners$lambda$0(this.f12798a, view, z10);
    }
}
