package com.efs.sdk.base.core.c;

import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.Log;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private com.efs.sdk.base.core.c.a.a f5171a;

    public abstract com.efs.sdk.base.core.c.a.a a();

    public final void a(LogDto logDto) {
        try {
            if (this.f5171a == null) {
                synchronized (this) {
                    if (this.f5171a == null) {
                        com.efs.sdk.base.core.c.a.a a10 = a();
                        this.f5171a = a10;
                        if (a10 == null) {
                            return;
                        }
                    }
                }
            }
            this.f5171a.a(logDto);
        } catch (Throwable th) {
            Log.e("efs.processor", "log handle error", th);
        }
    }
}
