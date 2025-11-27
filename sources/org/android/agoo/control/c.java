package org.android.agoo.control;

import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.utl.ALog;
import java.util.ArrayList;
import java.util.Iterator;
import org.android.agoo.common.MsgDO;

class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AgooFactory f8599a;

    public c(AgooFactory agooFactory) {
        this.f8599a = agooFactory;
    }

    public void run() {
        ArrayList<MsgDO> b10 = this.f8599a.messageService.b();
        if (b10 != null && b10.size() > 0) {
            ALog.e("AgooFactory", "reportCacheMsg", "size", Integer.valueOf(b10.size()));
            Iterator<MsgDO> it = b10.iterator();
            while (it.hasNext()) {
                MsgDO next = it.next();
                if (next != null) {
                    next.isFromCache = true;
                    this.f8599a.notifyManager.report(next, (TaoBaseService.ExtraInfo) null);
                }
            }
        }
    }
}
