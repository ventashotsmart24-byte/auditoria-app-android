package com.taobao.accs;

import android.app.Notification;
import com.taobao.accs.ChannelService;
import com.taobao.accs.utl.ALog;

class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChannelService.KernelService f12883a;

    public a(ChannelService.KernelService kernelService) {
        this.f12883a = kernelService;
    }

    public void run() {
        try {
            ChannelService instance = ChannelService.getInstance();
            int i10 = this.f12883a.f12882b.getPackageManager().getPackageInfo(this.f12883a.getPackageName(), 0).applicationInfo.icon;
            if (i10 != 0) {
                Notification.Builder builder = new Notification.Builder(this.f12883a.f12882b);
                builder.setSmallIcon(i10);
                builder.setContentText("正在运行…");
                instance.startForeground(9371, builder.build());
                Notification.Builder builder2 = new Notification.Builder(this.f12883a.f12882b);
                builder2.setSmallIcon(i10);
                builder2.setContentText("正在运行…");
                ChannelService.KernelService.f12881a.startForeground(9371, builder2.build());
                ChannelService.KernelService.f12881a.stopForeground(true);
            }
            ChannelService.KernelService.f12881a.stopSelf();
        } catch (Throwable th) {
            ALog.e("ChannelService", " onStartCommand run", th, new Object[0]);
        }
    }
}
