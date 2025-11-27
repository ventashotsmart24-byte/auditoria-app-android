package anet.channel.util;

import anet.channel.statist.NetTypeStat;
import anet.channel.thread.ThreadPoolExecutorFactory;

final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4014a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ NetTypeStat f4015b;

    public d(String str, NetTypeStat netTypeStat) {
        this.f4014a = str;
        this.f4015b = netTypeStat;
    }

    public void run() {
        ThreadPoolExecutorFactory.submitPriorityTask(new e(this), ThreadPoolExecutorFactory.Priority.LOW);
    }
}
