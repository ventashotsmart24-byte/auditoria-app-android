package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;

final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f13194a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f13195b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f13196c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ AccsDataListener f13197d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f13198e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ byte[] f13199f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ TaoBaseService.ExtraInfo f13200g;

    public d(String str, String str2, int i10, AccsDataListener accsDataListener, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        this.f13194a = str;
        this.f13195b = str2;
        this.f13196c = i10;
        this.f13197d = accsDataListener;
        this.f13198e = str3;
        this.f13199f = bArr;
        this.f13200g = extraInfo;
    }

    public void run() {
        ALog.Level level = ALog.Level.D;
        if (ALog.isPrintLog(level) || "accs-impaas".equals(this.f13194a)) {
            ALog.e(a.TAG, "onData start", Constants.KEY_DATA_ID, this.f13195b, Constants.KEY_SERVICE_ID, this.f13194a, "command", Integer.valueOf(this.f13196c), "className", this.f13197d.getClass().getName());
        }
        this.f13197d.onData(this.f13194a, this.f13198e, this.f13195b, this.f13199f, this.f13200g);
        if (ALog.isPrintLog(level) || "accs-impaas".equals(this.f13194a)) {
            ALog.e(a.TAG, "onData end", Constants.KEY_DATA_ID, this.f13195b);
        }
    }
}
