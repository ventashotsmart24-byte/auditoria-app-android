package anet.channel.strategy.dispatch;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import java.util.Map;
import java.util.Random;
import java.util.Set;

class a {
    public static final String TAG = "awcn.AmdcThreadPoolExecutor";

    /* renamed from: b  reason: collision with root package name */
    private static Random f3928b = new Random();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Object> f3929a;

    /* renamed from: anet.channel.strategy.dispatch.a$a  reason: collision with other inner class name */
    public class C0063a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private Map<String, Object> f3931b;

        public C0063a(Map<String, Object> map) {
            this.f3931b = map;
        }

        public void run() {
            Map<String, Object> a10;
            try {
                Map<String, Object> map = this.f3931b;
                if (map == null) {
                    synchronized (a.class) {
                        a10 = a.this.f3929a;
                        Map unused = a.this.f3929a = null;
                    }
                    map = a10;
                }
                if (NetworkStatusHelper.isConnected()) {
                    if (GlobalAppRuntimeInfo.getEnv() != map.get("Env")) {
                        ALog.w(a.TAG, "task's env changed", (String) null, new Object[0]);
                    } else {
                        b.a(d.a(map));
                    }
                }
            } catch (Exception e10) {
                ALog.e(a.TAG, "exec amdc task failed.", (String) null, e10, new Object[0]);
            }
        }

        public C0063a() {
        }
    }

    public void a(Map<String, Object> map) {
        try {
            map.put("Env", GlobalAppRuntimeInfo.getEnv());
            synchronized (this) {
                Map<String, Object> map2 = this.f3929a;
                if (map2 == null) {
                    this.f3929a = map;
                    int nextInt = f3928b.nextInt(3000) + 2000;
                    ALog.i(TAG, "merge amdc request", (String) null, "delay", Integer.valueOf(nextInt));
                    anet.channel.strategy.utils.a.a(new C0063a(), (long) nextInt);
                } else {
                    Set set = (Set) map2.get(DispatchConstants.HOSTS);
                    Set set2 = (Set) map.get(DispatchConstants.HOSTS);
                    if (map.get("Env") != this.f3929a.get("Env")) {
                        this.f3929a = map;
                    } else if (set.size() + set2.size() <= 40) {
                        set2.addAll(set);
                        this.f3929a = map;
                    } else {
                        anet.channel.strategy.utils.a.a(new C0063a(map));
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
