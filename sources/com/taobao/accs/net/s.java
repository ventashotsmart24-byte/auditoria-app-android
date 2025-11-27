package com.taobao.accs.net;

import com.taobao.accs.data.Message;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.k;
import java.util.Iterator;

class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f13090a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f13091b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f13092c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ k f13093d;

    public s(k kVar, int i10, boolean z10, int i11) {
        this.f13093d = kVar;
        this.f13090a = i10;
        this.f13091b = z10;
        this.f13092c = i11;
    }

    public void run() {
        Message.Id id;
        Message b10;
        int i10 = this.f13090a;
        if (i10 > 0) {
            Message.Id id2 = new Message.Id(i10, "");
            Iterator<Message.Id> it = this.f13093d.f13029e.f().iterator();
            while (true) {
                if (!it.hasNext()) {
                    id = null;
                    break;
                }
                id = it.next();
                if (id.equals(id2)) {
                    break;
                }
            }
            if (!(id == null || (b10 = this.f13093d.f13029e.b(id.getDataId())) == null)) {
                if (this.f13091b) {
                    if (!this.f13093d.a(b10, 2000)) {
                        this.f13093d.f13029e.a(b10, this.f13092c);
                    }
                    if (b10.getNetPermanceMonitor() != null) {
                        k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "total_tnet", 0.0d);
                    }
                } else {
                    this.f13093d.f13029e.a(b10, this.f13092c);
                }
            }
        }
        int i11 = this.f13090a;
        if (i11 < 0 && this.f13091b) {
            this.f13093d.b(i11);
        }
    }
}
