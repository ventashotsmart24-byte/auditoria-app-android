package com.mobile.brasiltv.view.login;

import android.view.View;

public final /* synthetic */ class m implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PasswordEditView f12832a;

    public /* synthetic */ m(PasswordEditView passwordEditView) {
        this.f12832a = passwordEditView;
    }

    public final void onFocusChange(View view, boolean z10) {
        PasswordEditView.initListeners$lambda$0(this.f12832a, view, z10);
    }
}
