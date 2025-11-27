package com.taobao.accs.utl;

import android.app.Application;
import com.taobao.accs.utl.l;
import java.util.Iterator;

class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f13244a;

    public n(l lVar) {
        this.f13244a = lVar;
    }

    public void run() {
        Iterator it = l.f13233d.iterator();
        while (it.hasNext()) {
            l.b bVar = (l.b) it.next();
            if (bVar != null) {
                Application unused = l.f13234e;
                bVar.b();
            }
        }
    }
}
