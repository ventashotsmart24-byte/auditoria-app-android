package com.mobile.brasiltv.view.input;

import android.view.View;

public final /* synthetic */ class e implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EmailPrefixInputView f12802a;

    public /* synthetic */ e(EmailPrefixInputView emailPrefixInputView) {
        this.f12802a = emailPrefixInputView;
    }

    public final void onFocusChange(View view, boolean z10) {
        EmailPrefixInputView.initListeners$lambda$0(this.f12802a, view, z10);
    }
}
