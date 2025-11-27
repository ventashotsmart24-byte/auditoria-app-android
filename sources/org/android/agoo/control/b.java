package org.android.agoo.control;

import com.taobao.accs.base.TaoBaseService;

class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ byte[] f8595a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f8596b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ TaoBaseService.ExtraInfo f8597c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ AgooFactory f8598d;

    public b(AgooFactory agooFactory, byte[] bArr, String str, TaoBaseService.ExtraInfo extraInfo) {
        this.f8598d = agooFactory;
        this.f8595a = bArr;
        this.f8596b = str;
        this.f8597c = extraInfo;
    }

    public void run() {
        this.f8598d.msgReceiverPreHandler(this.f8595a, this.f8596b, this.f8597c, true);
    }
}
