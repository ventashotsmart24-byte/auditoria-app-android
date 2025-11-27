package anet.channel;

import android.text.TextUtils;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.StrategyTemplate;
import anet.channel.strategy.utils.d;
import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class AwcnConfig {
    public static final String HTTP3_ENABLE = "HTTP3_ENABLE";
    public static final String NEXT_LAUNCH_FORBID = "NEXT_LAUNCH_FORBID";

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f3501a = false;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f3502b = true;

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f3503c = true;

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f3504d = true;

    /* renamed from: e  reason: collision with root package name */
    private static volatile boolean f3505e = false;

    /* renamed from: f  reason: collision with root package name */
    private static volatile boolean f3506f = true;

    /* renamed from: g  reason: collision with root package name */
    private static volatile long f3507g = 43200000;

    /* renamed from: h  reason: collision with root package name */
    private static volatile boolean f3508h = true;

    /* renamed from: i  reason: collision with root package name */
    private static volatile boolean f3509i = true;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f3510j = true;

    /* renamed from: k  reason: collision with root package name */
    private static boolean f3511k = false;

    /* renamed from: l  reason: collision with root package name */
    private static volatile boolean f3512l = false;

    /* renamed from: m  reason: collision with root package name */
    private static volatile boolean f3513m = true;

    /* renamed from: n  reason: collision with root package name */
    private static volatile boolean f3514n = false;

    /* renamed from: o  reason: collision with root package name */
    private static volatile int f3515o = 10000;

    /* renamed from: p  reason: collision with root package name */
    private static volatile boolean f3516p = false;

    /* renamed from: q  reason: collision with root package name */
    private static volatile boolean f3517q = true;

    /* renamed from: r  reason: collision with root package name */
    private static volatile int f3518r = -1;

    /* renamed from: s  reason: collision with root package name */
    private static volatile boolean f3519s = true;

    /* renamed from: t  reason: collision with root package name */
    private static volatile boolean f3520t = true;

    /* renamed from: u  reason: collision with root package name */
    private static volatile boolean f3521u = false;

    /* renamed from: v  reason: collision with root package name */
    private static volatile boolean f3522v = true;

    /* renamed from: w  reason: collision with root package name */
    private static volatile CopyOnWriteArrayList<String> f3523w = null;

    /* renamed from: x  reason: collision with root package name */
    private static volatile boolean f3524x = true;

    /* renamed from: y  reason: collision with root package name */
    private static volatile boolean f3525y = true;

    public static int getAccsReconnectionDelayPeriod() {
        return f3515o;
    }

    public static long getIpv6BlackListTtl() {
        return f3507g;
    }

    public static int getXquicCongControl() {
        return f3518r;
    }

    public static boolean isAccsSessionCreateForbiddenInBg() {
        return f3501a;
    }

    public static boolean isAllowHttpDnsNotify(String str) {
        if (f3523w == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return f3523w.contains(str);
    }

    public static boolean isAppLifeCycleListenerEnable() {
        return f3510j;
    }

    public static boolean isAsyncLoadStrategyEnable() {
        return f3511k;
    }

    public static boolean isCarrierInfoEnable() {
        return f3525y;
    }

    public static boolean isCookieHeaderRedundantFix() {
        return f3520t;
    }

    public static boolean isHorseRaceEnable() {
        return f3503c;
    }

    public static boolean isHttp3Enable() {
        return f3516p;
    }

    public static boolean isHttp3OrangeEnable() {
        return f3517q;
    }

    public static boolean isHttpsSniEnable() {
        return f3502b;
    }

    public static boolean isIdleSessionCloseEnable() {
        return f3506f;
    }

    public static boolean isIpStackDetectByUdpConnect() {
        return f3519s;
    }

    public static boolean isIpv6BlackListEnable() {
        return f3509i;
    }

    public static boolean isIpv6Enable() {
        return f3508h;
    }

    public static boolean isNetworkDetectEnable() {
        return f3514n;
    }

    public static boolean isPing6Enable() {
        return f3513m;
    }

    public static boolean isQuicEnable() {
        return f3505e;
    }

    public static boolean isSendConnectInfoByBroadcast() {
        return f3521u;
    }

    public static boolean isSendConnectInfoByService() {
        return f3522v;
    }

    public static boolean isTbNextLaunch() {
        return f3512l;
    }

    public static boolean isTnetHeaderCacheEnable() {
        return f3504d;
    }

    public static boolean isWifiInfoEnable() {
        return f3524x;
    }

    public static void registerPresetSessions(String str) {
        if (GlobalAppRuntimeInfo.isTargetProcess() && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                int i10 = 0;
                while (i10 < length) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    String string = jSONObject.getString(Constants.KEY_HOST);
                    if (d.c(string)) {
                        StrategyTemplate.getInstance().registerConnProtocol(string, ConnProtocol.valueOf(jSONObject.getString("protocol"), jSONObject.getString("rtt"), jSONObject.getString("publicKey")));
                        if (jSONObject.getBoolean("isKeepAlive")) {
                            SessionCenter.getInstance().registerSessionInfo(SessionInfo.create(string, true, false, (IAuth) null, (IHeartbeat) null, (DataFrameCb) null));
                        }
                        i10++;
                    } else {
                        return;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void setAccsReconnectionDelayPeriod(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        if (i10 > 10000) {
            i10 = 10000;
        }
        f3515o = i10;
    }

    public static void setAccsSessionCreateForbiddenInBg(boolean z10) {
        f3501a = z10;
    }

    public static void setAppLifeCycleListenerEnable(boolean z10) {
        f3510j = z10;
    }

    public static void setAsyncLoadStrategyEnable(boolean z10) {
        f3511k = z10;
    }

    public static void setCarrierInfoEnable(boolean z10) {
        f3525y = z10;
    }

    public static void setCookieHeaderRedundantFix(boolean z10) {
        f3520t = z10;
    }

    public static void setHorseRaceEnable(boolean z10) {
        f3503c = z10;
    }

    public static void setHttp3Enable(boolean z10) {
        f3516p = z10;
        ALog.e("awcn.AwcnConfig", "[setHttp3Enable]", (String) null, "enable", Boolean.valueOf(z10));
    }

    public static void setHttp3OrangeEnable(boolean z10) {
        f3517q = z10;
    }

    public static void setHttpDnsNotifyWhiteList(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                JSONArray jSONArray = new JSONArray(str);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    String string = jSONArray.getString(i10);
                    if (!TextUtils.isEmpty(string)) {
                        copyOnWriteArrayList.add(string);
                    }
                }
                f3523w = copyOnWriteArrayList;
            } catch (Exception e10) {
                ALog.e("awcn.AwcnConfig", "[setHttpDnsNotifyWhiteList] error", (String) null, e10, new Object[0]);
            }
        }
    }

    public static void setHttpsSniEnable(boolean z10) {
        f3502b = z10;
    }

    public static void setIdleSessionCloseEnable(boolean z10) {
        f3506f = z10;
    }

    public static void setIpStackDetectByUdpConnect(boolean z10) {
        f3519s = z10;
    }

    public static void setIpv6BlackListEnable(boolean z10) {
        f3509i = z10;
    }

    public static void setIpv6BlackListTtl(long j10) {
        f3507g = j10;
    }

    public static void setIpv6Enable(boolean z10) {
        f3508h = z10;
    }

    public static void setNetworkDetectEnable(boolean z10) {
        f3514n = z10;
    }

    public static void setPing6Enable(boolean z10) {
        f3513m = z10;
    }

    public static void setQuicEnable(boolean z10) {
        f3505e = z10;
    }

    public static void setSendConnectInfoByBroadcast(boolean z10) {
        f3521u = z10;
    }

    public static void setSendConnectInfoByService(boolean z10) {
        f3522v = z10;
    }

    public static void setTbNextLaunch(boolean z10) {
        f3512l = z10;
    }

    public static void setTnetHeaderCacheEnable(boolean z10) {
        f3504d = z10;
    }

    public static void setWifiInfoEnable(boolean z10) {
        f3524x = z10;
    }

    public static void setXquicCongControl(int i10) {
        if (i10 >= 0) {
            f3518r = i10;
        }
    }
}
