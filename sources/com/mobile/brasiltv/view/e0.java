package com.mobile.brasiltv.view;

import android.view.View;

public final /* synthetic */ class e0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f12786a;

    public /* synthetic */ e0(View.OnClickListener onClickListener) {
        this.f12786a = onClickListener;
    }

    public final void onClick(View view) {
        TitleView.setOnBackClickListener$lambda$2(this.f12786a, view);
    }
}
