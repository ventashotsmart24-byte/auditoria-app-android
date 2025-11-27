package com.taobao.accs.utl;

import android.content.Intent;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;

final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NetPerformanceMonitor f13208a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f13209b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f13210c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ AccsDataListener f13211d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ int f13212e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Intent f13213f;

    public f(NetPerformanceMonitor netPerformanceMonitor, String str, String str2, AccsDataListener accsDataListener, int i10, Intent intent) {
        this.f13208a = netPerformanceMonitor;
        this.f13209b = str;
        this.f13210c = str2;
        this.f13211d = accsDataListener;
        this.f13212e = i10;
        this.f13213f = intent;
    }

    public void run() {
        NetPerformanceMonitor netPerformanceMonitor = this.f13208a;
        if (netPerformanceMonitor != null) {
            netPerformanceMonitor.real_to_bz_date = System.currentTimeMillis();
        }
        ALog.Level level = ALog.Level.D;
        if (ALog.isPrintLog(level) || "accs-impaas".equals(this.f13209b)) {
            String str = a.TAG;
            ALog.e(str, "onSendData start dataId:" + this.f13210c + " serviceId:" + this.f13209b, new Object[0]);
        }
        this.f13211d.onSendData(this.f13209b, this.f13210c, this.f13212e, a.c(this.f13213f));
        if (ALog.isPrintLog(level) || "accs-impaas".equals(this.f13209b)) {
            String str2 = a.TAG;
            ALog.e(str2, "onSendData end dataId:" + this.f13210c, new Object[0]);
        }
        AppMonitor.getInstance().commitStat(this.f13208a);
    }
}
