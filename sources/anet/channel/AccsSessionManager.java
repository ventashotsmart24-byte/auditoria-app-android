package anet.channel;

import android.content.Intent;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IStrategyInstance;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;
import com.taobao.accs.common.Constants;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;

class AccsSessionManager {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static CopyOnWriteArraySet<ISessionListener> f3498c = new CopyOnWriteArraySet<>();

    /* renamed from: a  reason: collision with root package name */
    SessionCenter f3499a = null;

    /* renamed from: b  reason: collision with root package name */
    Set<String> f3500b = Collections.EMPTY_SET;

    public AccsSessionManager(SessionCenter sessionCenter) {
        this.f3499a = sessionCenter;
    }

    private boolean b() {
        if ((!GlobalAppRuntimeInfo.isAppBackground() || !AwcnConfig.isAccsSessionCreateForbiddenInBg()) && NetworkStatusHelper.isConnected()) {
            return true;
        }
        return false;
    }

    public synchronized void checkAndStartSession() {
        String str;
        Collection<SessionInfo> a10 = this.f3499a.f3582g.a();
        Set<String> set = Collections.EMPTY_SET;
        if (!a10.isEmpty()) {
            set = new TreeSet<>();
        }
        for (SessionInfo next : a10) {
            if (next.isKeepAlive) {
                IStrategyInstance instance = StrategyCenter.getInstance();
                String str2 = next.host;
                if (next.isAccs) {
                    str = "https";
                } else {
                    str = HttpConstant.HTTP;
                }
                set.add(StringUtils.concatString(instance.getSchemeByHost(str2, str), HttpConstant.SCHEME_SPLIT, next.host));
            }
        }
        for (String next2 : this.f3500b) {
            if (!set.contains(next2)) {
                a(next2);
            }
        }
        if (b()) {
            for (String next3 : set) {
                try {
                    this.f3499a.get(next3, ConnType.TypeLevel.SPDY, 0);
                } catch (Exception unused) {
                    ALog.e("start session failed", (String) null, Constants.KEY_HOST, next3);
                }
            }
            this.f3500b = set;
        }
    }

    public synchronized void forceCloseSession(boolean z10) {
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.AccsSessionManager", "forceCloseSession", this.f3499a.f3578c, "reCreate", Boolean.valueOf(z10));
        }
        for (String a10 : this.f3500b) {
            a(a10);
        }
        if (z10) {
            checkAndStartSession();
        }
    }

    public void notifyListener(Intent intent) {
        ThreadPoolExecutorFactory.submitScheduledTask(new a(this, intent));
    }

    public void registerListener(ISessionListener iSessionListener) {
        if (iSessionListener != null) {
            f3498c.add(iSessionListener);
        }
    }

    public void unregisterListener(ISessionListener iSessionListener) {
        f3498c.remove(iSessionListener);
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            ALog.d("awcn.AccsSessionManager", "closeSessions", this.f3499a.f3578c, Constants.KEY_HOST, str);
            this.f3499a.a(str).b(false);
        }
    }
}
