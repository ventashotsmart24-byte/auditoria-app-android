package com.mobile.brasiltv.utils;

import android.view.View;
import t9.v;

public final /* synthetic */ class a0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ v f12495a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f12496b;

    public /* synthetic */ a0(v vVar, View.OnClickListener onClickListener) {
        this.f12495a = vVar;
        this.f12496b = onClickListener;
    }

    public final void onClick(View view) {
        b0.Q(this.f12495a, this.f12496b, view);
    }
}
