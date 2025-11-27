package org.android.agoo.control;

class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f8603a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f8604b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AgooFactory f8605c;

    public e(AgooFactory agooFactory, String str, String str2) {
        this.f8605c = agooFactory;
        this.f8603a = str;
        this.f8604b = str2;
    }

    public void run() {
        this.f8605c.updateMsgStatus(this.f8603a, this.f8604b);
    }
}
