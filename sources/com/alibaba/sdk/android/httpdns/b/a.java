package com.alibaba.sdk.android.httpdns.b;

import android.content.Context;
import java.util.List;

class a implements f {

    /* renamed from: a  reason: collision with root package name */
    private final d f4919a;

    public a(Context context) {
        this.f4919a = new d(context);
    }

    public List<e> a() {
        return this.f4919a.b();
    }

    public void b(e eVar) {
        this.f4919a.b(eVar.f4926m, eVar.host);
    }

    public void a(e eVar) {
        this.f4919a.a(eVar);
    }
}
