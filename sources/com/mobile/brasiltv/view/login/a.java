package com.mobile.brasiltv.view.login;

import android.view.View;

public final /* synthetic */ class a implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccountEditView f12810a;

    public /* synthetic */ a(AccountEditView accountEditView) {
        this.f12810a = accountEditView;
    }

    public final void onFocusChange(View view, boolean z10) {
        AccountEditView.initListeners$lambda$0(this.f12810a, view, z10);
    }
}
