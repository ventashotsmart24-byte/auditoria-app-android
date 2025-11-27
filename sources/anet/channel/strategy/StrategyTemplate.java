package anet.channel.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StrategyTemplate {
    Map<String, ConnProtocol> templateMap = new ConcurrentHashMap();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static StrategyTemplate f3912a = new StrategyTemplate();
    }

    public static StrategyTemplate getInstance() {
        return a.f3912a;
    }

    public ConnProtocol getConnProtocol(String str) {
        return this.templateMap.get(str);
    }

    public void registerConnProtocol(String str, ConnProtocol connProtocol) {
        if (connProtocol != null) {
            this.templateMap.put(str, connProtocol);
            try {
                IStrategyInstance instance = StrategyCenter.getInstance();
                if (instance instanceof g) {
                    ((g) instance).f3940b.f3897c.a(str, connProtocol);
                }
            } catch (Exception unused) {
            }
        }
    }
}
