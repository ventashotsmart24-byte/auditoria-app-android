package com.mobile.brasiltv.view;

import io.reactivex.functions.Consumer;
import s9.l;

public final /* synthetic */ class r implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f12849a;

    public /* synthetic */ r(l lVar) {
        this.f12849a = lVar;
    }

    public final void accept(Object obj) {
        MsgNotifyDialog.checkCalendarPermission$lambda$8(this.f12849a, obj);
    }
}
