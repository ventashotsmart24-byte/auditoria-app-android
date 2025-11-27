package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.strategy.utils.d;
import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class a {

    /* renamed from: a  reason: collision with root package name */
    final ConcurrentHashMap<String, List<IPConnStrategy>> f3913a = new ConcurrentHashMap<>();

    private void b(String str) {
        new b(this, str).run();
    }

    public List a(String str) {
        if (TextUtils.isEmpty(str) || !d.c(str) || DispatchConstants.getAmdcServerDomain().equalsIgnoreCase(str)) {
            return Collections.EMPTY_LIST;
        }
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.LocalDnsStrategy", "try resolve ip with local dns", (String) null, Constants.KEY_HOST, str);
        }
        List list = Collections.EMPTY_LIST;
        List list2 = this.f3913a.get(str);
        if (list2 == null || list2.isEmpty()) {
            b(str);
        }
        List list3 = this.f3913a.get(str);
        if (!(list3 == null || list3 == list)) {
            list = new ArrayList(list3);
        }
        ALog.i("awcn.LocalDnsStrategy", "get local strategy", (String) null, "strategyList", list3);
        return list;
    }

    public void a(String str, ConnProtocol connProtocol) {
        List<IPConnStrategy> list = this.f3913a.get(str);
        if (list != null && !list.isEmpty()) {
            for (IPConnStrategy protocol : list) {
                if (protocol.getProtocol().equals(connProtocol)) {
                    return;
                }
            }
            list.add(IPConnStrategy.a(((IPConnStrategy) list.get(0)).getIp(), !a(connProtocol) ? 80 : Constants.PORT, connProtocol, 0, 0, 1, 45000));
            ALog.i("awcn.LocalDnsStrategy", "setProtocolForHost", (String) null, "strategyList", list);
        }
    }

    public void a() {
        this.f3913a.clear();
    }

    public void a(String str, ConnEvent connEvent) {
        if (!connEvent.isSuccess && !TextUtils.isEmpty(str) && !connEvent.isAccs) {
            this.f3913a.remove(str);
        }
    }

    public boolean a(ConnProtocol connProtocol) {
        return connProtocol.protocol.equalsIgnoreCase("https") || connProtocol.protocol.equalsIgnoreCase(ConnType.H2S) || !TextUtils.isEmpty(connProtocol.publicKey);
    }
}
