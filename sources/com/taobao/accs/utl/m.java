package com.taobao.accs.utl;

import android.app.Application;
import com.taobao.accs.utl.l;
import java.util.Iterator;

class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f13243a;

    public m(l lVar) {
        this.f13243a = lVar;
    }

    public void run() {
        Iterator it = l.f13233d.iterator();
        while (it.hasNext()) {
            l.b bVar = (l.b) it.next();
            if (bVar != null) {
                Application unused = l.f13234e;
                bVar.a();
            }
        }
    }
}
