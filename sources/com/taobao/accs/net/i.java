package com.taobao.accs.net;

import anet.channel.strategy.dispatch.DispatchEvent;
import anet.channel.strategy.dispatch.HttpDispatcher;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import java.util.concurrent.TimeUnit;

class i implements HttpDispatcher.IDispatchEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f13061a;

    public i(h hVar) {
        this.f13061a = hVar;
    }

    public void onEvent(DispatchEvent dispatchEvent) {
        ThreadPoolExecutorFactory.schedule(new j(this), 2000, TimeUnit.MILLISECONDS);
    }
}
