package anet.channel;

import anet.channel.util.HttpConstant;
import java.util.Map;
import n1.c;

class k implements c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f3741a;

    public k(j jVar) {
        this.f3741a = jVar;
    }

    public boolean handleCache(String str, Map<String, String> map) {
        return "weex".equals(map.get(HttpConstant.F_REFER));
    }
}
