package anet.channel.strategy;

import anet.channel.AwcnConfig;
import anet.channel.e.a;
import anet.channel.entity.ConnType;
import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;

class h implements IStrategyFilter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f3944a;

    public h(g gVar) {
        this.f3944a = gVar;
    }

    public boolean accept(IConnStrategy iConnStrategy) {
        String str = iConnStrategy.getProtocol().protocol;
        if (ConnType.QUIC.equals(str) || ConnType.QUIC_PLAIN.equals(str)) {
            ALog.i("awcn.StrategyCenter", "gquic strategy disabled", (String) null, Constants.KEY_STRATEGY, iConnStrategy);
            return false;
        }
        boolean isHttp3Enable = AwcnConfig.isHttp3Enable();
        boolean b10 = a.b();
        if ((isHttp3Enable && b10) || (!ConnType.HTTP3.equals(str) && !ConnType.HTTP3_PLAIN.equals(str))) {
            return true;
        }
        ALog.i("awcn.StrategyCenter", "http3 strategy disabled", (String) null, Constants.KEY_STRATEGY, iConnStrategy);
        return false;
    }
}
