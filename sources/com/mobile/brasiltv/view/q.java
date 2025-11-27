package com.mobile.brasiltv.view;

import io.reactivex.functions.Consumer;
import s9.l;

public final /* synthetic */ class q implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f12848a;

    public /* synthetic */ q(l lVar) {
        this.f12848a = lVar;
    }

    public final void accept(Object obj) {
        MsgNotifyDialog.checkCalendarPermission$lambda$7(this.f12848a, obj);
    }
}
