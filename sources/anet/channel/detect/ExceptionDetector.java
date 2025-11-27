package anet.channel.detect;

import android.text.TextUtils;
import android.util.Pair;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.common.global.Constant;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.common.Constants;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;
import org.android.netutil.NetUtils;
import org.android.netutil.PingEntry;
import org.android.netutil.PingResponse;
import org.android.netutil.PingTask;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.json.JSONArray;
import org.json.JSONObject;

class ExceptionDetector {

    /* renamed from: a  reason: collision with root package name */
    long f3639a;

    /* renamed from: b  reason: collision with root package name */
    String f3640b;

    /* renamed from: c  reason: collision with root package name */
    String f3641c;

    /* renamed from: d  reason: collision with root package name */
    String f3642d;

    /* renamed from: e  reason: collision with root package name */
    LimitedQueue<Pair<String, Integer>> f3643e = new LimitedQueue<>(10);

    public class LimitedQueue<E> extends LinkedList<E> {

        /* renamed from: b  reason: collision with root package name */
        private int f3645b;

        public LimitedQueue(int i10) {
            this.f3645b = i10;
        }

        public boolean add(E e10) {
            boolean add = super.add(e10);
            while (add && size() > this.f3645b) {
                super.remove();
            }
            return add;
        }
    }

    public class a {

        /* renamed from: a  reason: collision with root package name */
        String f3646a;

        /* renamed from: b  reason: collision with root package name */
        String f3647b;

        /* renamed from: c  reason: collision with root package name */
        String f3648c;

        /* renamed from: d  reason: collision with root package name */
        Future<PingResponse> f3649d;

        /* renamed from: e  reason: collision with root package name */
        Future<PingResponse> f3650e;

        /* renamed from: f  reason: collision with root package name */
        Future<PingResponse> f3651f;

        private a() {
        }

        public /* synthetic */ a(ExceptionDetector exceptionDetector, a aVar) {
            this();
        }
    }

    public void a() {
        NetworkStatusHelper.addStatusChangeListener(new a(this));
    }

    public void b() {
        String str;
        Future future;
        ALog.e("anet.ExceptionDetector", "network detect start.", (String) null, new Object[0]);
        SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        NetworkStatusHelper.NetworkStatus status = NetworkStatusHelper.getStatus();
        jSONObject2.put(Constant.KEY_STATUS, status.getType());
        jSONObject2.put("subType", NetworkStatusHelper.getNetworkSubType());
        if (status != NetworkStatusHelper.NetworkStatus.NO) {
            if (status.isMobile()) {
                jSONObject2.put(DynamicLink.AndroidParameters.KEY_ANDROID_PACKAGE_NAME, NetworkStatusHelper.getApn());
                jSONObject2.put("carrier", NetworkStatusHelper.getCarrier());
            } else {
                jSONObject2.put("bssid", NetworkStatusHelper.getWifiBSSID());
                jSONObject2.put(BrowserInfo.KEY_SSID, NetworkStatusHelper.getWifiSSID());
            }
            jSONObject2.put("proxy", NetworkStatusHelper.getProxyType());
        }
        jSONObject.put("NetworkInfo", jSONObject2);
        if (status.isWifi()) {
            str = NetUtils.getDefaultGateway("114.114.114.114");
        } else {
            str = NetUtils.getPreferNextHop("114.114.114.114", 2);
        }
        if (!TextUtils.isEmpty(str)) {
            future = new PingTask(str, 1000, 3, 0, 0).launch();
        } else {
            future = null;
        }
        a a10 = a("guide-acs.m.taobao.com", this.f3640b);
        a a11 = a("gw.alicdn.com", this.f3642d);
        a a12 = a("msgacs.m.taobao.com", this.f3641c);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("nextHop", str);
        jSONObject3.put("ping", a((Future<PingResponse>) future));
        jSONObject.put("LocalDetect", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(a(a10));
        jSONArray.put(a(a11));
        jSONArray.put(a(a12));
        jSONObject.put("InternetDetect", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        Iterator<Pair<String, Integer>> it = this.f3643e.iterator();
        while (it.hasNext()) {
            Pair next = it.next();
            jSONObject4.put((String) next.first, next.second);
        }
        jSONObject.put("BizDetect", jSONObject4);
        this.f3643e.clear();
        ALog.e("anet.ExceptionDetector", "network detect result: " + jSONObject.toString(), (String) null, new Object[0]);
    }

    public boolean c() {
        boolean z10 = false;
        if (this.f3643e.size() != 10) {
            return false;
        }
        if (NetworkStatusHelper.getStatus() == NetworkStatusHelper.NetworkStatus.NO) {
            ALog.e("anet.ExceptionDetector", "no network", (String) null, new Object[0]);
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.f3639a) {
            return false;
        }
        Iterator<Pair<String, Integer>> it = this.f3643e.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next().second).intValue();
            if (intValue == -202 || intValue == -400 || intValue == -401 || intValue == -405 || intValue == -406) {
                i10++;
            }
        }
        if (i10 * 2 > 10) {
            z10 = true;
        }
        if (z10) {
            this.f3639a = currentTimeMillis + 1800000;
        }
        return z10;
    }

    public void a(RequestStatistic requestStatistic) {
        if (!AwcnConfig.isNetworkDetectEnable()) {
            ALog.i("anet.ExceptionDetector", "network detect closed.", (String) null, new Object[0]);
        } else {
            ThreadPoolExecutorFactory.submitDetectTask(new c(this, requestStatistic));
        }
    }

    private ArrayList<String> a(String str, int i10) {
        PingResponse pingResponse;
        ArrayList<String> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        int i11 = 0;
        while (i11 < i10) {
            i11++;
            try {
                pingResponse = (PingResponse) new PingTask(str, 0, 1, 0, i11).launch().get();
            } catch (Exception unused) {
                pingResponse = null;
            }
            StringBuilder sb = new StringBuilder();
            if (pingResponse != null) {
                String lastHopIPStr = pingResponse.getLastHopIPStr();
                double d10 = pingResponse.getResults()[0].rtt;
                int errcode = pingResponse.getErrcode();
                if (TextUtils.isEmpty(lastHopIPStr)) {
                    lastHopIPStr = Operator.Operation.MULTIPLY;
                }
                sb.append("hop=");
                sb.append(lastHopIPStr);
                sb.append(",rtt=");
                sb.append(d10);
                sb.append(",errCode=");
                sb.append(errcode);
            }
            arrayList.add(sb.toString());
        }
        return arrayList;
    }

    private a a(String str, String str2) {
        a aVar = new a(this, (a) null);
        aVar.f3646a = str;
        try {
            aVar.f3647b = InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException unused) {
        }
        if (!TextUtils.isEmpty(str2)) {
            aVar.f3648c = str2;
        } else {
            List<IConnStrategy> connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(str);
            if (connStrategyListByHost != null && !connStrategyListByHost.isEmpty()) {
                aVar.f3648c = connStrategyListByHost.get(0).getIp();
            }
        }
        String str3 = !TextUtils.isEmpty(aVar.f3648c) ? aVar.f3648c : aVar.f3647b;
        if (!TextUtils.isEmpty(str3)) {
            String str4 = str3;
            aVar.f3649d = new PingTask(str4, 1000, 3, 0, 0).launch();
            aVar.f3650e = new PingTask(str4, 1000, 3, 1172, 0).launch();
            aVar.f3651f = new PingTask(str4, 1000, 3, 1432, 0).launch();
        }
        return aVar;
    }

    private JSONObject a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        if (!(aVar == null || aVar.f3649d == null)) {
            jSONObject.put(Constants.KEY_HOST, aVar.f3646a);
            jSONObject.put("currentIp", aVar.f3648c);
            jSONObject.put("localIp", aVar.f3647b);
            jSONObject.put("ping", a(aVar.f3649d));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("1200", a(aVar.f3650e));
            jSONObject2.put("1460", a(aVar.f3651f));
            jSONObject.put("MTU", jSONObject2);
            if ("guide-acs.m.taobao.com".equals(aVar.f3646a)) {
                ArrayList<String> a10 = a(!TextUtils.isEmpty(aVar.f3648c) ? aVar.f3648c : aVar.f3647b, 5);
                JSONObject jSONObject3 = new JSONObject();
                int i10 = 0;
                while (i10 < a10.size()) {
                    int i11 = i10 + 1;
                    jSONObject3.put(String.valueOf(i11), a10.get(i10));
                    i10 = i11;
                }
                jSONObject.put("traceRoute", jSONObject3);
            }
        }
        return jSONObject;
    }

    private JSONObject a(Future<PingResponse> future) {
        PingResponse pingResponse;
        JSONObject jSONObject = new JSONObject();
        if (future == null) {
            return jSONObject;
        }
        try {
            pingResponse = future.get();
        } catch (Exception unused) {
            pingResponse = null;
        }
        if (pingResponse == null) {
            return jSONObject;
        }
        jSONObject.put("errCode", pingResponse.getErrcode());
        JSONArray jSONArray = new JSONArray();
        for (PingEntry pingEntry : pingResponse.getResults()) {
            jSONArray.put("seq=" + pingEntry.seq + ",hop=" + pingEntry.hop + ",rtt=" + pingEntry.rtt);
        }
        jSONObject.put("response", jSONArray);
        return jSONObject;
    }
}
