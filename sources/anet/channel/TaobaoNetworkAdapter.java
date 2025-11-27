package anet.channel;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import anet.channel.Config;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.d.a;
import anet.channel.entity.ConnType;
import anet.channel.entity.ENV;
import anet.channel.entity.c;
import anet.channel.flow.NetworkAnalysis;
import anet.channel.fulltrace.IFullTraceAnalysis;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.StrategyTemplate;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import anet.channel.util.StringUtils;
import anet.channel.util.Utils;
import com.taobao.accs.common.Constants;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import o1.b;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;

public class TaobaoNetworkAdapter implements Serializable {
    public static AtomicBoolean isInited = new AtomicBoolean();

    private static void a(String str, String str2, ConnProtocol connProtocol, boolean z10, boolean z11) {
        StrategyTemplate.getInstance().registerConnProtocol(str, connProtocol);
        if (!z10) {
            return;
        }
        if (!z11) {
            SessionCenter.getInstance(new Config.Builder().setAppkey(str2).setEnv(ENV.ONLINE).build()).registerSessionInfo(SessionInfo.create(str, z10, false, (IAuth) null, (IHeartbeat) null, (DataFrameCb) null));
            return;
        }
        SessionCenter.getInstance(new Config.Builder().setAppkey(str2).setEnv(ENV.ONLINE).build()).get(HttpUrl.parse(StringUtils.concatString("https", HttpConstant.SCHEME_SPLIT, str)), c.f3709a, 0);
    }

    public static void init(Context context, HashMap<String, Object> hashMap) {
        boolean z10;
        if (isInited.compareAndSet(false, true)) {
            if (hashMap != null && AgooConstants.TAOBAO_PACKAGE.equals(hashMap.get(UMModuleRegister.PROCESS))) {
                AwcnConfig.setAccsSessionCreateForbiddenInBg(true);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put("liveng-bfrtc.alibabausercontent.com");
                jSONArray.put("livecb-bfrtc.alibabausercontent.com");
                jSONArray.put("liveca-bfrtc.alibabausercontent.com");
                AwcnConfig.setHttpDnsNotifyWhiteList(jSONArray.toString());
            }
            if (hashMap != null && Constants.CHANNEL_PROCESS_NAME.equals(hashMap.get(UMModuleRegister.PROCESS)) && b.b()) {
                ALog.e("awcn.TaobaoNetworkAdapter", "channelLocalInstanceEnable", (String) null, new Object[0]);
                b.n(false);
            }
            ALog.setLog(new a());
            b.m(new anet.channel.c.a());
            AppMonitor.setInstance(new anet.channel.appmonitor.a());
            NetworkAnalysis.setInstance(new anet.channel.a.b());
            anet.channel.fulltrace.a.a((IFullTraceAnalysis) new anet.channel.a.a());
            ThreadPoolExecutorFactory.submitPriorityTask(new j(), ThreadPoolExecutorFactory.Priority.NORMAL);
            if (hashMap != null) {
                try {
                    if (AgooConstants.TAOBAO_PACKAGE.equals(hashMap.get(UMModuleRegister.PROCESS)) && ((Boolean) hashMap.get("isDebuggable")).booleanValue()) {
                        Utils.invokeStaticMethodThrowException("com.taobao.android.request.analysis.RequestRecorder", "init", new Class[]{Context.class}, context);
                    }
                } catch (Exception e10) {
                    ALog.e("awcn.TaobaoNetworkAdapter", "RequestRecorder error.", (String) null, e10, new Object[0]);
                }
            }
            if (hashMap != null) {
                try {
                    if (!hashMap.containsKey("isNextLaunch") || PreferenceManager.getDefaultSharedPreferences(context).getBoolean(AwcnConfig.NEXT_LAUNCH_FORBID, false)) {
                        z10 = false;
                    } else {
                        GlobalAppRuntimeInfo.addBucketInfo("isNextLaunch", "true");
                        z10 = true;
                    }
                    AwcnConfig.setTbNextLaunch(z10);
                } catch (Exception unused) {
                }
            }
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            boolean z11 = defaultSharedPreferences.getBoolean(AwcnConfig.HTTP3_ENABLE, true);
            AwcnConfig.setHttp3OrangeEnable(z11);
            if (z11 && hashMap != null && AgooConstants.TAOBAO_PACKAGE.equals(hashMap.get(UMModuleRegister.PROCESS))) {
                AwcnConfig.setHttp3Enable(true);
                ALog.e("awcn.TaobaoNetworkAdapter", "http3 enabled.", (String) null, new Object[0]);
            }
            if (hashMap != null) {
                try {
                    boolean containsKey = hashMap.containsKey("ngLaunch");
                    if (AgooConstants.TAOBAO_PACKAGE.equals((String) hashMap.get(UMModuleRegister.PROCESS))) {
                        if (defaultSharedPreferences.getBoolean("SERVICE_OPTIMIZE", true)) {
                            b.g(true);
                            ALog.e("awcn.TaobaoNetworkAdapter", "bindservice optimize enabled.", (String) null, new Object[0]);
                        }
                        String str = (String) hashMap.get("onlineAppKey");
                        a("guide-acs.m.taobao.com", str, ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, ConnType.PK_ACS), true, containsKey);
                        ConnProtocol valueOf = ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, ConnType.PK_CDN);
                        a("gw.alicdn.com", str, valueOf, false, containsKey);
                        a("dorangesource.alicdn.com", str, valueOf, false, containsKey);
                        a("ossgw.alicdn.com", str, valueOf, false, containsKey);
                    }
                } catch (Exception unused2) {
                }
            }
        }
    }
}
