package anet.channel.strategy;

class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3935a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ StrategyInfoHolder f3936b;

    public e(StrategyInfoHolder strategyInfoHolder, String str) {
        this.f3936b = strategyInfoHolder;
        this.f3935a = str;
    }

    public void run() {
        this.f3936b.a(this.f3935a, true);
    }
}
