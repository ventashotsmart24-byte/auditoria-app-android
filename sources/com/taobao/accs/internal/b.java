package com.taobao.accs.internal;

import com.taobao.accs.c;

class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f13016a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ACCSManagerImpl f13017b;

    public b(ACCSManagerImpl aCCSManagerImpl, c cVar) {
        this.f13017b = aCCSManagerImpl;
        this.f13016a = cVar;
    }

    public void run() {
        c cVar = this.f13016a;
        if (cVar != null) {
            cVar.a(true, false);
        }
    }
}
