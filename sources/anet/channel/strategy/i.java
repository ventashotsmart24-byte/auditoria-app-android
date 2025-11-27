package anet.channel.strategy;

class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f3945a;

    public i(g gVar) {
        this.f3945a = gVar;
    }

    public void run() {
        if (!this.f3945a.a()) {
            this.f3945a.f3940b.c();
        }
    }
}
