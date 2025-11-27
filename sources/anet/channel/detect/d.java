package anet.channel.detect;

import anet.channel.AwcnConfig;
import anet.channel.RequestCb;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.ConnType;
import anet.channel.request.Request;
import anet.channel.session.b;
import anet.channel.statist.HorseRaceStat;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import anet.channel.util.j;
import com.hpplay.cybergarage.http.HTTP;
import java.io.IOException;
import java.net.Socket;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.netutil.PingResponse;
import org.android.netutil.PingTask;

class d {

    /* renamed from: a  reason: collision with root package name */
    TreeMap<String, l.c> f3657a = new TreeMap<>();

    /* renamed from: b  reason: collision with root package name */
    private AtomicInteger f3658b = new AtomicInteger(1);

    private void c(String str, l.e eVar) {
        String str2 = "HR" + this.f3658b.getAndIncrement();
        ALog.i("anet.HorseRaceDetector", "startTcpTask", str2, "ip", eVar.f3981a, "port", Integer.valueOf(eVar.f3982b.f3951a));
        HorseRaceStat horseRaceStat = new HorseRaceStat(str, eVar);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Socket socket = new Socket(eVar.f3981a, eVar.f3982b.f3951a);
            int i10 = eVar.f3982b.f3953c;
            if (i10 == 0) {
                i10 = 10000;
            }
            socket.setSoTimeout(i10);
            ALog.i("anet.HorseRaceDetector", "socket connect success", str2, new Object[0]);
            horseRaceStat.connRet = 1;
            horseRaceStat.connTime = System.currentTimeMillis() - currentTimeMillis;
            socket.close();
        } catch (IOException unused) {
            horseRaceStat.connTime = System.currentTimeMillis() - currentTimeMillis;
            horseRaceStat.connErrorCode = -404;
        }
        AppMonitor.getInstance().commitStat(horseRaceStat);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        if (r1 != null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        a(r1.getValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
        anet.channel.util.ALog.e("anet.HorseRaceDetector", "start hr task failed", (java.lang.String) null, r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r6 = this;
            java.lang.String r0 = "anet.HorseRaceDetector"
            java.lang.String r1 = "network detect thread start"
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            anet.channel.util.ALog.e(r0, r1, r4, r3)
        L_0x000b:
            java.util.TreeMap<java.lang.String, anet.channel.strategy.l$c> r0 = r6.f3657a
            monitor-enter(r0)
            boolean r1 = anet.channel.AwcnConfig.isHorseRaceEnable()     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x001b
            java.util.TreeMap<java.lang.String, anet.channel.strategy.l$c> r1 = r6.f3657a     // Catch:{ all -> 0x003a }
            r1.clear()     // Catch:{ all -> 0x003a }
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            goto L_0x0024
        L_0x001b:
            java.util.TreeMap<java.lang.String, anet.channel.strategy.l$c> r1 = r6.f3657a     // Catch:{ all -> 0x003a }
            java.util.Map$Entry r1 = r1.pollFirstEntry()     // Catch:{ all -> 0x003a }
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x0025
        L_0x0024:
            return
        L_0x0025:
            java.lang.Object r0 = r1.getValue()     // Catch:{ Exception -> 0x002f }
            anet.channel.strategy.l$c r0 = (anet.channel.strategy.l.c) r0     // Catch:{ Exception -> 0x002f }
            r6.a(r0)     // Catch:{ Exception -> 0x002f }
            goto L_0x000b
        L_0x002f:
            r0 = move-exception
            java.lang.String r1 = "anet.HorseRaceDetector"
            java.lang.String r3 = "start hr task failed"
            java.lang.Object[] r5 = new java.lang.Object[r2]
            anet.channel.util.ALog.e(r1, r3, r4, r0, r5)
            goto L_0x000b
        L_0x003a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            goto L_0x003e
        L_0x003d:
            throw r1
        L_0x003e:
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.detect.d.a():void");
    }

    public void b() {
        StrategyCenter.getInstance().registerListener(new e(this));
        AppLifecycle.registerLifecycleListener(new f(this));
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00d5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.lang.String r17, anet.channel.strategy.l.e r18) {
        /*
            r16 = this;
            r9 = r16
            r0 = r17
            r10 = r18
            anet.channel.strategy.l$a r1 = r10.f3982b
            anet.channel.strategy.ConnProtocol r1 = anet.channel.strategy.ConnProtocol.valueOf(r1)
            anet.channel.entity.ConnType r2 = anet.channel.entity.ConnType.valueOf(r1)
            if (r2 != 0) goto L_0x0013
            return
        L_0x0013:
            java.lang.String r3 = "anet.HorseRaceDetector"
            java.lang.String r4 = "startLongLinkTask"
            r5 = 8
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = "host"
            r11 = 0
            r5[r11] = r6
            r6 = 1
            r5[r6] = r0
            r6 = 2
            java.lang.String r7 = "ip"
            r5[r6] = r7
            r6 = 3
            java.lang.String r7 = r10.f3981a
            r5[r6] = r7
            r6 = 4
            java.lang.String r7 = "port"
            r5[r6] = r7
            anet.channel.strategy.l$a r6 = r10.f3982b
            int r6 = r6.f3951a
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7 = 5
            r5[r7] = r6
            r6 = 6
            java.lang.String r7 = "protocol"
            r5[r6] = r7
            r6 = 7
            r5[r6] = r1
            r6 = 0
            anet.channel.util.ALog.i(r3, r4, r6, r5)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "HR"
            r3.append(r4)
            java.util.concurrent.atomic.AtomicInteger r4 = r9.f3658b
            int r4 = r4.getAndIncrement()
            r3.append(r4)
            java.lang.String r6 = r3.toString()
            anet.channel.session.TnetSpdySession r12 = new anet.channel.session.TnetSpdySession
            android.content.Context r3 = anet.channel.GlobalAppRuntimeInfo.getContext()
            anet.channel.entity.a r4 = new anet.channel.entity.a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            boolean r2 = r2.isSSL()
            if (r2 == 0) goto L_0x0076
            java.lang.String r2 = "https://"
            goto L_0x0078
        L_0x0076:
            java.lang.String r2 = "http://"
        L_0x0078:
            r5.append(r2)
            r5.append(r0)
            java.lang.String r2 = r5.toString()
            anet.channel.strategy.IConnStrategy r1 = a((anet.channel.strategy.ConnProtocol) r1, (anet.channel.strategy.l.e) r10)
            r4.<init>(r2, r6, r1)
            r12.<init>(r3, r4)
            anet.channel.statist.HorseRaceStat r13 = new anet.channel.statist.HorseRaceStat
            r13.<init>(r0, r10)
            long r14 = java.lang.System.currentTimeMillis()
            anet.channel.detect.h r0 = new anet.channel.detect.h
            r1 = r0
            r2 = r16
            r3 = r13
            r4 = r14
            r7 = r18
            r8 = r12
            r1.<init>(r2, r3, r4, r6, r7, r8)
            r1 = 257(0x101, float:3.6E-43)
            r12.registerEventcb(r1, r0)
            r12.connect()
            monitor-enter(r13)
            anet.channel.strategy.l$a r0 = r10.f3982b     // Catch:{ InterruptedException -> 0x00d5 }
            int r0 = r0.f3953c     // Catch:{ InterruptedException -> 0x00d5 }
            if (r0 != 0) goto L_0x00b3
            r0 = 10000(0x2710, float:1.4013E-41)
        L_0x00b3:
            long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00d5 }
            r13.wait(r0)     // Catch:{ InterruptedException -> 0x00d5 }
            long r0 = r13.connTime     // Catch:{ InterruptedException -> 0x00d5 }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x00c6
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ InterruptedException -> 0x00d5 }
            long r0 = r0 - r14
            r13.connTime = r0     // Catch:{ InterruptedException -> 0x00d5 }
        L_0x00c6:
            java.lang.String r0 = r10.f3981a     // Catch:{ InterruptedException -> 0x00d5 }
            r9.a((java.lang.String) r0, (anet.channel.statist.HorseRaceStat) r13)     // Catch:{ InterruptedException -> 0x00d5 }
            anet.channel.appmonitor.IAppMonitor r0 = anet.channel.appmonitor.AppMonitor.getInstance()     // Catch:{ InterruptedException -> 0x00d5 }
            r0.commitStat(r13)     // Catch:{ InterruptedException -> 0x00d5 }
            goto L_0x00d5
        L_0x00d3:
            r0 = move-exception
            goto L_0x00da
        L_0x00d5:
            monitor-exit(r13)     // Catch:{ all -> 0x00d3 }
            r12.close(r11)
            return
        L_0x00da:
            monitor-exit(r13)     // Catch:{ all -> 0x00d3 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.detect.d.b(java.lang.String, anet.channel.strategy.l$e):void");
    }

    private void a(l.c cVar) {
        l.e[] eVarArr = cVar.f3972b;
        if (eVarArr != null && eVarArr.length != 0) {
            String str = cVar.f3971a;
            int i10 = 0;
            while (true) {
                l.e[] eVarArr2 = cVar.f3972b;
                if (i10 < eVarArr2.length) {
                    l.e eVar = eVarArr2[i10];
                    String str2 = eVar.f3982b.f3952b;
                    if (str2.equalsIgnoreCase(HttpConstant.HTTP) || str2.equalsIgnoreCase("https")) {
                        a(str, eVar);
                    } else if (str2.equalsIgnoreCase(ConnType.HTTP2) || str2.equalsIgnoreCase(ConnType.SPDY) || str2.equalsIgnoreCase(ConnType.QUIC)) {
                        b(str, eVar);
                    } else if (str2.equalsIgnoreCase("tcp")) {
                        c(str, eVar);
                    }
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    private void a(String str, l.e eVar) {
        HttpUrl parse = HttpUrl.parse(eVar.f3982b.f3952b + HttpConstant.SCHEME_SPLIT + str + eVar.f3983c);
        if (parse != null) {
            int i10 = 0;
            ALog.i("anet.HorseRaceDetector", "startShortLinkTask", (String) null, "url", parse);
            Request.Builder sslSocketFactory = new Request.Builder().setUrl(parse).addHeader("Connection", HTTP.CLOSE).setConnectTimeout(eVar.f3982b.f3953c).setReadTimeout(eVar.f3982b.f3954d).setRedirectEnable(false).setSslSocketFactory(new j(str));
            Request build = sslSocketFactory.setSeq("HR" + this.f3658b.getAndIncrement()).build();
            build.setDnsOptimize(eVar.f3981a, eVar.f3982b.f3951a);
            long currentTimeMillis = System.currentTimeMillis();
            b.a a10 = b.a(build, (RequestCb) null);
            HorseRaceStat horseRaceStat = new HorseRaceStat(str, eVar);
            horseRaceStat.connTime = System.currentTimeMillis() - currentTimeMillis;
            int i11 = a10.f3838a;
            if (i11 <= 0) {
                horseRaceStat.connErrorCode = i11;
            } else {
                horseRaceStat.connRet = 1;
                if (a10.f3838a == 200) {
                    i10 = 1;
                }
                horseRaceStat.reqRet = i10;
                horseRaceStat.reqErrorCode = a10.f3838a;
                horseRaceStat.reqTime = horseRaceStat.connTime;
            }
            a(eVar.f3981a, horseRaceStat);
            AppMonitor.getInstance().commitStat(horseRaceStat);
        }
    }

    private static IConnStrategy a(ConnProtocol connProtocol, l.e eVar) {
        return new j(eVar, connProtocol);
    }

    private void a(String str, HorseRaceStat horseRaceStat) {
        if (AwcnConfig.isPing6Enable() && anet.channel.strategy.utils.d.b(str)) {
            try {
                PingResponse pingResponse = (PingResponse) new PingTask(str, 1000, 3, 0, 0).launch().get();
                if (pingResponse != null) {
                    horseRaceStat.pingSuccessCount = pingResponse.getSuccessCnt();
                    horseRaceStat.pingTimeoutCount = 3 - horseRaceStat.pingSuccessCount;
                    horseRaceStat.localIP = pingResponse.getLocalIPStr();
                }
            } catch (Throwable th) {
                ALog.e("anet.HorseRaceDetector", "ping6 task fail.", (String) null, th, new Object[0]);
            }
        }
    }
}
