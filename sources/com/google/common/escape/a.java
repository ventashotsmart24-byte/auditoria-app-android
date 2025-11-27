package com.google.common.escape;

import com.google.common.base.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Escaper f10067a;

    public /* synthetic */ a(Escaper escaper) {
        this.f10067a = escaper;
    }

    public final Object apply(Object obj) {
        return this.f10067a.escape((String) obj);
    }
}
