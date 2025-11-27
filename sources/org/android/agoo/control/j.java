package org.android.agoo.control;

import com.taobao.accs.client.a;
import org.android.agoo.message.MessageService;

class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaseIntentService f8611a;

    public j(BaseIntentService baseIntentService) {
        this.f8611a = baseIntentService;
    }

    public void run() {
        a.f12918f.incrementAndGet();
        NotifManager unused = this.f8611a.notifyManager = new NotifManager();
        this.f8611a.notifyManager.init(this.f8611a.getApplicationContext());
        MessageService unused2 = this.f8611a.messageService = new MessageService();
        this.f8611a.messageService.a(this.f8611a.getApplicationContext());
        AgooFactory unused3 = this.f8611a.agooFactory = new AgooFactory();
        this.f8611a.agooFactory.init(this.f8611a.getApplicationContext(), this.f8611a.notifyManager, this.f8611a.messageService);
    }
}
