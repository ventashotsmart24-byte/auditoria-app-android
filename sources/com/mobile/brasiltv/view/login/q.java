package com.mobile.brasiltv.view.login;

import android.view.View;

public final /* synthetic */ class q implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PickAreaView f12836a;

    public /* synthetic */ q(PickAreaView pickAreaView) {
        this.f12836a = pickAreaView;
    }

    public final void onFocusChange(View view, boolean z10) {
        PickAreaView.initListeners$lambda$1(this.f12836a, view, z10);
    }
}
