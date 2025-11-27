package anet.channel.statist;

import anet.channel.AwcnConfig;
import anet.channel.entity.a;
import anet.channel.fulltrace.b;
import anet.channel.strategy.IConnStrategy;
import org.json.JSONObject;

@Monitor(module = "networkPrefer", monitorPoint = "session")
public class SessionStatistic extends StatObject {
    public static int maxRetryTime;
    @Measure
    public long ackTime;
    @Measure(max = 15000.0d)
    public long authTime;
    @Measure
    public long cfRCount;
    @Dimension
    public String closeReason;
    @Dimension
    public int congControlKind;
    @Measure(max = 15000.0d, name = "connTime")
    public long connectionTime;
    @Dimension(name = "protocolType")
    public String conntype;
    @Dimension
    public String dcid;
    @Dimension
    public long errorCode;
    @Dimension
    public JSONObject extra;
    @Dimension
    public String host;
    @Measure
    public long inceptCount;
    @Dimension
    public String ip;
    @Dimension
    public int ipRefer = 0;
    @Dimension
    public int ipType = 1;
    @Dimension
    public boolean isBackground;
    public boolean isCommitted;
    @Dimension
    public long isKL;
    @Dimension
    public int isProxy = 0;
    @Dimension
    public String isTunnel;
    @Measure
    public int lastPingInterval;
    @Measure(max = 86400.0d)
    public long liveTime;
    @Measure
    public double lossRate;
    @Dimension
    public String netType;
    @Measure
    public long pRate;
    @Dimension
    public int port;
    @Measure
    public long ppkgCount;
    @Measure
    public long recvSizeCount;
    @Measure(constantValue = 1.0d)
    public long requestCount;
    @Dimension
    public int ret;
    @Measure
    public double retransmissionRate;
    @Dimension
    public long retryTimes;
    @Measure
    public int rtoCount;
    @Dimension
    public String scid;
    @Dimension
    public int sdkv;
    @Measure
    public long sendSizeCount;
    @Measure
    public long srtt;
    @Measure(max = 15000.0d)
    public long sslCalTime;
    @Measure(max = 15000.0d)
    public long sslTime;
    @Measure(constantValue = 0.0d)
    public long stdRCount;
    @Measure
    public int tlpCount;
    @Dimension
    public int xqc0RttStatus;
    @Dimension
    public String xqcConnEnv;

    public SessionStatistic(a aVar) {
        String str = null;
        this.extra = null;
        this.liveTime = 0;
        this.requestCount = 1;
        this.stdRCount = 1;
        this.isCommitted = false;
        if (aVar != null) {
            this.ip = aVar.a();
            this.port = aVar.b();
            IConnStrategy iConnStrategy = aVar.f3701a;
            if (iConnStrategy != null) {
                this.ipRefer = iConnStrategy.getIpSource();
                this.ipType = aVar.f3701a.getIpType();
            }
            this.pRate = (long) aVar.g();
            this.conntype = aVar.c().toString();
            this.retryTimes = (long) aVar.f3702b;
            maxRetryTime = aVar.f3703c;
            b sceneInfo = anet.channel.fulltrace.a.a().getSceneInfo();
            str = sceneInfo != null ? sceneInfo.f3723f : str;
            boolean b10 = anet.channel.e.a.b();
            boolean isHttp3OrangeEnable = AwcnConfig.isHttp3OrangeEnable();
            this.xqcConnEnv = isHttp3OrangeEnable + "_" + b10 + "_" + str;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001b, code lost:
        if (r3 != -2601) goto L_0x0052;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean beforeCommit() {
        /*
            r7 = this;
            int r0 = r7.ret
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0052
            long r3 = r7.retryTimes
            int r0 = maxRetryTime
            long r5 = (long) r0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x001d
            long r3 = r7.errorCode
            r5 = -2613(0xfffffffffffff5cb, double:NaN)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x001d
            r5 = -2601(0xfffffffffffff5d7, double:NaN)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x0052
        L_0x001d:
            boolean r0 = anet.channel.util.ALog.isPrintLog(r2)
            if (r0 == 0) goto L_0x0051
            r0 = 5
            java.lang.Object[] r0 = new java.lang.Object[r0]
            long r3 = r7.retryTimes
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r0[r1] = r3
            java.lang.String r3 = "maxRetryTime"
            r0[r2] = r3
            int r2 = maxRetryTime
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3 = 2
            r0[r3] = r2
            r2 = 3
            java.lang.String r3 = "errorCode"
            r0[r2] = r3
            long r2 = r7.errorCode
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r3 = 4
            r0[r3] = r2
            java.lang.String r2 = "SessionStat no need commit"
            r3 = 0
            java.lang.String r4 = "retry:"
            anet.channel.util.ALog.d(r2, r3, r4, r0)
        L_0x0051:
            return r1
        L_0x0052:
            boolean r0 = r7.isCommitted
            if (r0 == 0) goto L_0x0057
            return r1
        L_0x0057:
            r7.isCommitted = r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.statist.SessionStatistic.beforeCommit():boolean");
    }

    public AlarmObject getAlarmObject() {
        boolean z10;
        AlarmObject alarmObject = new AlarmObject();
        alarmObject.module = "networkPrefer";
        alarmObject.modulePoint = "connect_succ_rate";
        if (this.ret != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        alarmObject.isSuccess = z10;
        if (z10) {
            alarmObject.arg = this.closeReason;
        } else {
            alarmObject.errorCode = String.valueOf(this.errorCode);
        }
        return alarmObject;
    }
}
