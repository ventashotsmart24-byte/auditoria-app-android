package com.mobile.brasiltv.view.input;

import android.view.View;

public final /* synthetic */ class c implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CustomInputView f12800a;

    public /* synthetic */ c(CustomInputView customInputView) {
        this.f12800a = customInputView;
    }

    public final void onFocusChange(View view, boolean z10) {
        CustomInputView.initListeners$lambda$0(this.f12800a, view, z10);
    }
}
