package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.entity.b;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpHelper;
import java.util.List;
import java.util.Map;

class g implements RequestCb {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f3851a;

    public g(f fVar) {
        this.f3851a = fVar;
    }

    public void onDataReceive(ByteArray byteArray, boolean z10) {
        this.f3851a.f3848b.onDataReceive(byteArray, z10);
    }

    public void onFinish(int i10, String str, RequestStatistic requestStatistic) {
        if (i10 <= 0 && i10 != -204) {
            this.f3851a.f3850d.handleCallbacks(2, new b(2, 0, "Http connect fail"));
        }
        this.f3851a.f3848b.onFinish(i10, str, requestStatistic);
    }

    public void onResponseCode(int i10, Map<String, List<String>> map) {
        ALog.i("awcn.HttpSession", "", this.f3851a.f3847a.getSeq(), "httpStatusCode", Integer.valueOf(i10));
        ALog.i("awcn.HttpSession", "", this.f3851a.f3847a.getSeq(), "response headers", map);
        this.f3851a.f3848b.onResponseCode(i10, map);
        this.f3851a.f3849c.serverRT = HttpHelper.parseServerRT(map);
        f fVar = this.f3851a;
        fVar.f3850d.handleResponseCode(fVar.f3847a, i10);
        f fVar2 = this.f3851a;
        fVar2.f3850d.handleResponseHeaders(fVar2.f3847a, map);
    }
}
