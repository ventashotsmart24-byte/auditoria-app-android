package anet.channel.a;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.fulltrace.IFullTraceAnalysis;
import anet.channel.fulltrace.b;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import com.taobao.analysis.abtest.ABTestCenter;
import com.taobao.analysis.fulltrace.FullTraceAnalysis;
import com.taobao.analysis.fulltrace.RequestInfo;
import com.taobao.analysis.scene.SceneIdentifier;

public class a implements IFullTraceAnalysis {

    /* renamed from: a  reason: collision with root package name */
    private boolean f3611a;

    public a() {
        try {
            Class.forName("com.taobao.analysis.fulltrace.FullTraceAnalysis");
            SceneIdentifier.setContext(GlobalAppRuntimeInfo.getContext());
            this.f3611a = true;
        } catch (Exception unused) {
            this.f3611a = false;
            ALog.e("awcn.DefaultFullTraceAnalysis", "not supoort FullTraceAnalysis", (String) null, new Object[0]);
        }
    }

    public void commitRequest(String str, RequestStatistic requestStatistic) {
        if (this.f3611a && requestStatistic != null && !TextUtils.isEmpty(str)) {
            RequestInfo requestInfo = new RequestInfo();
            requestInfo.host = requestStatistic.host;
            requestInfo.bizId = requestStatistic.bizId;
            requestInfo.url = requestStatistic.url;
            requestInfo.retryTimes = requestStatistic.retryTimes;
            requestInfo.netType = requestStatistic.netType;
            requestInfo.protocolType = requestStatistic.protocolType;
            requestInfo.ret = requestStatistic.ret;
            requestInfo.isCbMain = false;
            requestInfo.isReqMain = requestStatistic.isReqMain;
            requestInfo.isReqSync = requestStatistic.isReqSync;
            requestInfo.netErrorCode = String.valueOf(requestStatistic.statusCode);
            requestInfo.pTraceId = requestStatistic.pTraceId;
            requestInfo.netReqStart = requestStatistic.netReqStart;
            requestInfo.netReqServiceBindEnd = requestStatistic.reqServiceTransmissionEnd;
            requestInfo.netReqProcessStart = requestStatistic.reqStart;
            requestInfo.netReqSendStart = requestStatistic.sendStart;
            requestInfo.netRspRecvEnd = requestStatistic.rspEnd;
            requestInfo.netRspCbDispatch = requestStatistic.rspCbDispatch;
            requestInfo.netRspCbStart = requestStatistic.rspCbStart;
            requestInfo.netRspCbEnd = requestStatistic.rspCbEnd;
            requestInfo.reqDeflateSize = requestStatistic.reqHeadDeflateSize + requestStatistic.reqBodyDeflateSize;
            requestInfo.reqInflateSize = requestStatistic.reqHeadInflateSize + requestStatistic.reqBodyInflateSize;
            requestInfo.rspDeflateSize = requestStatistic.rspHeadDeflateSize + requestStatistic.rspBodyDeflateSize;
            requestInfo.rspInflateSize = requestStatistic.rspHeadInflateSize + requestStatistic.rspBodyInflateSize;
            requestInfo.serverRT = requestStatistic.serverRT;
            requestInfo.sendDataTime = requestStatistic.sendDataTime;
            requestInfo.firstDataTime = requestStatistic.firstDataTime;
            requestInfo.recvDataTime = requestStatistic.recDataTime;
            FullTraceAnalysis.getInstance().commitRequest(str, "network", requestInfo);
        }
    }

    public String createRequest() {
        if (this.f3611a) {
            return FullTraceAnalysis.getInstance().createRequest("network");
        }
        return null;
    }

    public b getSceneInfo() {
        if (!this.f3611a) {
            return null;
        }
        b bVar = new b();
        bVar.f3719b = SceneIdentifier.isUrlLaunch();
        bVar.f3720c = SceneIdentifier.getAppLaunchTime();
        bVar.f3721d = SceneIdentifier.getLastLaunchTime();
        bVar.f3722e = SceneIdentifier.getDeviceLevel();
        bVar.f3718a = SceneIdentifier.getStartType();
        bVar.f3723f = SceneIdentifier.getBucketInfo();
        bVar.f3724g = ABTestCenter.getUTABTestBucketId("networksdk");
        return bVar;
    }
}
