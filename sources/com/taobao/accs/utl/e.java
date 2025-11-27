package com.taobao.accs.utl;

import android.content.Intent;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;

final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NetPerformanceMonitor f13201a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f13202b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f13203c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ AccsDataListener f13204d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ int f13205e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ byte[] f13206f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ Intent f13207g;

    public e(NetPerformanceMonitor netPerformanceMonitor, String str, String str2, AccsDataListener accsDataListener, int i10, byte[] bArr, Intent intent) {
        this.f13201a = netPerformanceMonitor;
        this.f13202b = str;
        this.f13203c = str2;
        this.f13204d = accsDataListener;
        this.f13205e = i10;
        this.f13206f = bArr;
        this.f13207g = intent;
    }

    public void run() {
        NetPerformanceMonitor netPerformanceMonitor = this.f13201a;
        if (netPerformanceMonitor != null) {
            netPerformanceMonitor.real_to_bz_date = System.currentTimeMillis();
        }
        ALog.Level level = ALog.Level.D;
        if (ALog.isPrintLog(level) || "accs-impaas".equals(this.f13202b)) {
            String str = a.TAG;
            ALog.e(str, "onResponse start dataId:" + this.f13203c + " serviceId:" + this.f13202b, new Object[0]);
        }
        this.f13204d.onResponse(this.f13202b, this.f13203c, this.f13205e, this.f13206f, a.c(this.f13207g));
        if (ALog.isPrintLog(level) || "accs-impaas".equals(this.f13202b)) {
            String str2 = a.TAG;
            ALog.e(str2, "onResponse end dataId:" + this.f13203c, new Object[0]);
        }
        AppMonitor.getInstance().commitStat(this.f13201a);
    }
}
