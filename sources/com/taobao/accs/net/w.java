package com.taobao.accs.net;

import com.taobao.accs.data.Message;

class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Message f13113a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f13114b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ v f13115c;

    public w(v vVar, Message message, boolean z10) {
        this.f13115c = vVar;
        this.f13113a = message;
        this.f13114b = z10;
    }

    public void run() {
        synchronized (this.f13115c.f13103u) {
            this.f13115c.a(this.f13113a);
            if (this.f13115c.f13103u.size() == 0) {
                this.f13115c.f13103u.add(this.f13113a);
            } else {
                Message message = (Message) this.f13115c.f13103u.getFirst();
                if (this.f13113a.getType() != 1) {
                    if (this.f13113a.getType() != 0) {
                        if (this.f13113a.getType() != 2 || message.getType() != 2) {
                            this.f13115c.f13103u.addLast(this.f13113a);
                        } else if (!message.force && this.f13113a.force) {
                            this.f13115c.f13103u.removeFirst();
                            this.f13115c.f13103u.addFirst(this.f13113a);
                        }
                    }
                }
                this.f13115c.f13103u.addLast(this.f13113a);
                if (message.getType() == 2) {
                    this.f13115c.f13103u.removeFirst();
                }
            }
            if (this.f13114b || this.f13115c.f13102t == 3) {
                try {
                    this.f13115c.f13103u.notifyAll();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
    }
}
