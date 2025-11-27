package com.mobile.brasiltv.view;

import io.reactivex.functions.Consumer;
import s9.l;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f12712a;

    public /* synthetic */ d(l lVar) {
        this.f12712a = lVar;
    }

    public final void accept(Object obj) {
        AutoHideRelativeLayout.delayHide$lambda$1(this.f12712a, obj);
    }
}
