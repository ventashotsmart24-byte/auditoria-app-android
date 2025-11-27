package com.mobile.brasiltv.view;

import io.reactivex.functions.Consumer;
import s9.l;

public final /* synthetic */ class y implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f12862a;

    public /* synthetic */ y(l lVar) {
        this.f12862a = lVar;
    }

    public final void accept(Object obj) {
        MsgNotifyDialog.requestCalendarPermission$lambda$5(this.f12862a, obj);
    }
}
