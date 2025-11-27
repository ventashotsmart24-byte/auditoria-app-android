package com.taobao.accs.net;

import anet.channel.strategy.StrategyCenter;

class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f13062a;

    public j(i iVar) {
        this.f13062a = iVar;
    }

    public void run() {
        StrategyCenter.getInstance().saveData();
    }
}
