package anet.channel.detect;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.MtuDetectStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Future;
import org.android.netutil.PingEntry;
import org.android.netutil.PingResponse;
import org.android.netutil.PingTask;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;

class k {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, Long> f3671a = new HashMap<>();

    public void a() {
        NetworkStatusHelper.addStatusChangeListener(new l(this));
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        PingResponse pingResponse;
        String str2 = str;
        if (!AwcnConfig.isNetworkDetectEnable()) {
            ALog.i("anet.MTUDetector", "network detect closed.", (String) null, new Object[0]);
            return;
        }
        ALog.i("anet.MTUDetector", "mtuDetectTask start", (String) null, new Object[0]);
        SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        if (!TextUtils.isEmpty(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            Long l10 = f3671a.get(str2);
            if (l10 == null || currentTimeMillis >= l10.longValue()) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(GlobalAppRuntimeInfo.getContext());
                long j10 = defaultSharedPreferences.getLong("sp_mtu_" + str2, 0);
                if (currentTimeMillis < j10) {
                    f3671a.put(str2, Long.valueOf(j10));
                    ALog.i("anet.MTUDetector", "mtuDetectTask in period of validity", (String) null, new Object[0]);
                    return;
                }
                List<IConnStrategy> connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost("guide-acs.m.taobao.com");
                String ip = (connStrategyListByHost == null || connStrategyListByHost.isEmpty()) ? null : connStrategyListByHost.get(0).getIp();
                if (!TextUtils.isEmpty(ip)) {
                    String str3 = ip;
                    Future launch = new PingTask(str3, 1000, 3, 0, 0).launch();
                    Future launch2 = new PingTask(str3, 1000, 3, 1172, 0).launch();
                    Future launch3 = new PingTask(str3, 1000, 3, 1272, 0).launch();
                    Future launch4 = new PingTask(str3, 1000, 3, 1372, 0).launch();
                    Future launch5 = new PingTask(str3, 1000, 3, 1432, 0).launch();
                    try {
                        pingResponse = (PingResponse) launch.get();
                    } catch (Exception unused) {
                        pingResponse = null;
                    }
                    if (pingResponse != null) {
                        if (pingResponse.getSuccessCnt() < 2) {
                            ALog.e("anet.MTUDetector", "MTU detect preTask error", (String) null, "errCode", Integer.valueOf(pingResponse.getErrcode()), "successCount", Integer.valueOf(pingResponse.getSuccessCnt()));
                            return;
                        }
                        a(1200, (Future<PingResponse>) launch2);
                        a(1300, (Future<PingResponse>) launch3);
                        a(1400, (Future<PingResponse>) launch4);
                        a(1460, (Future<PingResponse>) launch5);
                        long j11 = currentTimeMillis + 432000000;
                        f3671a.put(str2, Long.valueOf(j11));
                        defaultSharedPreferences.edit().putLong("sp_mtu_" + str2, j11).apply();
                    }
                }
            }
        }
    }

    private void a(int i10, Future<PingResponse> future) {
        PingResponse pingResponse;
        try {
            pingResponse = future.get();
        } catch (Exception unused) {
            pingResponse = null;
        }
        if (pingResponse != null) {
            int successCnt = pingResponse.getSuccessCnt();
            int i11 = 3 - successCnt;
            StringBuilder sb = new StringBuilder();
            PingEntry[] results = pingResponse.getResults();
            int length = results.length;
            for (int i12 = 0; i12 < length; i12++) {
                sb.append(results[i12].rtt);
                if (i12 != length - 1) {
                    sb.append(",");
                }
            }
            ALog.i("anet.MTUDetector", "MTU detect result", (String) null, "mtu", Integer.valueOf(i10), "successCount", Integer.valueOf(successCnt), "timeoutCount", Integer.valueOf(i11));
            MtuDetectStat mtuDetectStat = new MtuDetectStat();
            mtuDetectStat.mtu = i10;
            mtuDetectStat.pingSuccessCount = successCnt;
            mtuDetectStat.pingTimeoutCount = i11;
            mtuDetectStat.rtt = sb.toString();
            mtuDetectStat.errCode = pingResponse.getErrcode();
            AppMonitor.getInstance().commitStat(mtuDetectStat);
        }
    }
}
