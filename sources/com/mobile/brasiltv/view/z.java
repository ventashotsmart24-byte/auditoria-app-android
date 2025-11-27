package com.mobile.brasiltv.view;

import io.reactivex.functions.Consumer;
import s9.l;

public final /* synthetic */ class z implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f12863a;

    public /* synthetic */ z(l lVar) {
        this.f12863a = lVar;
    }

    public final void accept(Object obj) {
        MsgNotifyDialog.requestCalendarPermission$lambda$6(this.f12863a, obj);
    }
}
