package com.efs.sdk.base.core.c.a;

import com.efs.sdk.base.core.model.LogDto;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public a f5172a;

    public abstract void a(LogDto logDto);

    public final void b(LogDto logDto) {
        a aVar = this.f5172a;
        if (aVar != null) {
            aVar.a(logDto);
        }
    }
}
