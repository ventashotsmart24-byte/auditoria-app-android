package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.util.HttpConstant;
import java.util.ArrayList;
import java.util.List;

public class HttpDnsAdapter {

    public static final class HttpDnsOrigin {
        final IConnStrategy connStrategy;

        public HttpDnsOrigin(IConnStrategy iConnStrategy) {
            this.connStrategy = iConnStrategy;
        }

        public boolean canWithSPDY() {
            String str = this.connStrategy.getProtocol().protocol;
            if (str.equalsIgnoreCase(HttpConstant.HTTP) || str.equalsIgnoreCase("https")) {
                return false;
            }
            return true;
        }

        public String getOriginIP() {
            return this.connStrategy.getIp();
        }

        public int getOriginPort() {
            return this.connStrategy.getPort();
        }

        public String getOriginProtocol() {
            return this.connStrategy.getProtocol().protocol;
        }

        public String toString() {
            return this.connStrategy.toString();
        }
    }

    public static String getIpByHttpDns(String str) {
        List<IConnStrategy> connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(str);
        if (connStrategyListByHost.isEmpty()) {
            return null;
        }
        return connStrategyListByHost.get(0).getIp();
    }

    public static HttpDnsOrigin getOriginByHttpDns(String str) {
        List<IConnStrategy> connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(str);
        if (connStrategyListByHost.isEmpty()) {
            return null;
        }
        return new HttpDnsOrigin(connStrategyListByHost.get(0));
    }

    public static ArrayList<HttpDnsOrigin> getOriginsByHttpDns(String str) {
        return getOriginsByHttpDns(str, true);
    }

    public static void notifyConnEvent(String str, HttpDnsOrigin httpDnsOrigin, boolean z10) {
        if (!TextUtils.isEmpty(str) && httpDnsOrigin != null && AwcnConfig.isAllowHttpDnsNotify(str)) {
            ConnEvent connEvent = new ConnEvent();
            connEvent.isSuccess = z10;
            StrategyCenter.getInstance().notifyConnEvent(str, httpDnsOrigin.connStrategy, connEvent);
        }
    }

    public static void setHosts(ArrayList<String> arrayList) {
        HttpDispatcher.getInstance().addHosts(arrayList);
    }

    public static ArrayList<HttpDnsOrigin> getOriginsByHttpDns(String str, boolean z10) {
        List<IConnStrategy> connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(str);
        if (connStrategyListByHost.isEmpty()) {
            return null;
        }
        ArrayList<HttpDnsOrigin> arrayList = new ArrayList<>(connStrategyListByHost.size());
        for (IConnStrategy next : connStrategyListByHost) {
            if (z10 || next.getIpSource() != 1) {
                arrayList.add(new HttpDnsOrigin(next));
            }
        }
        return arrayList;
    }
}
