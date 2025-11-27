package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.c;
import anet.channel.strategy.dispatch.DispatchEvent;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.strategy.l;
import anet.channel.strategy.utils.a;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import anet.channel.util.StringUtils;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hpplay.cybergarage.soap.SOAP;
import com.taobao.accs.common.Constants;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

class g implements IStrategyInstance, HttpDispatcher.IDispatchEventListener {

    /* renamed from: a  reason: collision with root package name */
    boolean f3939a = false;

    /* renamed from: b  reason: collision with root package name */
    StrategyInfoHolder f3940b = null;

    /* renamed from: c  reason: collision with root package name */
    long f3941c = 0;

    /* renamed from: d  reason: collision with root package name */
    CopyOnWriteArraySet<IStrategyListener> f3942d = new CopyOnWriteArraySet<>();

    /* renamed from: e  reason: collision with root package name */
    private IStrategyFilter f3943e = new h(this);

    public void forceRefreshStrategy(String str) {
        if (!a() && !TextUtils.isEmpty(str)) {
            ALog.i("awcn.StrategyCenter", "force refresh strategy", (String) null, Constants.KEY_HOST, str);
            this.f3940b.d().a(str, true);
        }
    }

    public String getCNameByHost(String str) {
        if (a() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f3940b.d().getCnameByHost(str);
    }

    public String getClientIp() {
        if (a()) {
            return "";
        }
        return this.f3940b.d().f3907b;
    }

    public List<IConnStrategy> getConnStrategyListByHost(String str) {
        return getConnStrategyListByHost(str, this.f3943e);
    }

    public String getFormalizeUrl(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (parse == null) {
            ALog.e("awcn.StrategyCenter", "url is invalid.", (String) null, "URL", str);
            return null;
        }
        String urlString = parse.urlString();
        try {
            String schemeByHost = getSchemeByHost(parse.host(), parse.scheme());
            if (!schemeByHost.equalsIgnoreCase(parse.scheme())) {
                urlString = StringUtils.concatString(schemeByHost, SOAP.DELIM, str.substring(str.indexOf("//")));
            }
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.StrategyCenter", "", (String) null, "raw", StringUtils.simplifyString(str, 128), "ret", StringUtils.simplifyString(urlString, 128));
            }
        } catch (Exception e10) {
            ALog.e("awcn.StrategyCenter", "getFormalizeUrl failed", (String) null, e10, "raw", str);
        }
        return urlString;
    }

    @Deprecated
    public String getSchemeByHost(String str) {
        return getSchemeByHost(str, (String) null);
    }

    public String getUnitByHost(String str) {
        if (a()) {
            return null;
        }
        return this.f3940b.f3896b.b(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void initialize(android.content.Context r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.f3939a     // Catch:{ all -> 0x0041 }
            if (r0 != 0) goto L_0x003f
            if (r6 != 0) goto L_0x0008
            goto L_0x003f
        L_0x0008:
            r0 = 0
            r1 = 0
            java.lang.String r2 = "awcn.StrategyCenter"
            java.lang.String r3 = "StrategyCenter initialize started."
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0033 }
            anet.channel.util.ALog.i(r2, r3, r1, r4)     // Catch:{ Exception -> 0x0033 }
            anet.channel.strategy.dispatch.AmdcRuntimeInfo.setContext(r6)     // Catch:{ Exception -> 0x0033 }
            anet.channel.strategy.m.a((android.content.Context) r6)     // Catch:{ Exception -> 0x0033 }
            anet.channel.strategy.dispatch.HttpDispatcher r6 = anet.channel.strategy.dispatch.HttpDispatcher.getInstance()     // Catch:{ Exception -> 0x0033 }
            r6.addListener(r5)     // Catch:{ Exception -> 0x0033 }
            anet.channel.strategy.StrategyInfoHolder r6 = anet.channel.strategy.StrategyInfoHolder.a()     // Catch:{ Exception -> 0x0033 }
            r5.f3940b = r6     // Catch:{ Exception -> 0x0033 }
            r6 = 1
            r5.f3939a = r6     // Catch:{ Exception -> 0x0033 }
            java.lang.String r6 = "awcn.StrategyCenter"
            java.lang.String r2 = "StrategyCenter initialize finished."
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0033 }
            anet.channel.util.ALog.i(r6, r2, r1, r3)     // Catch:{ Exception -> 0x0033 }
            goto L_0x003d
        L_0x0033:
            r6 = move-exception
            java.lang.String r2 = "awcn.StrategyCenter"
            java.lang.String r3 = "StrategyCenter initialize failed."
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x0041 }
            anet.channel.util.ALog.e(r2, r3, r1, r6, r0)     // Catch:{ all -> 0x0041 }
        L_0x003d:
            monitor-exit(r5)
            return
        L_0x003f:
            monitor-exit(r5)
            return
        L_0x0041:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.g.initialize(android.content.Context):void");
    }

    public void notifyConnEvent(String str, IConnStrategy iConnStrategy, ConnEvent connEvent) {
        if (!a() && iConnStrategy != null && (iConnStrategy instanceof IPConnStrategy)) {
            IPConnStrategy iPConnStrategy = (IPConnStrategy) iConnStrategy;
            if (iPConnStrategy.f3882b == 1) {
                this.f3940b.f3897c.a(str, connEvent);
            } else if (iPConnStrategy.f3882b == 0) {
                this.f3940b.d().a(str, iConnStrategy, connEvent);
            }
        }
    }

    public void onEvent(DispatchEvent dispatchEvent) {
        if (dispatchEvent.eventType == 1 && this.f3940b != null) {
            ALog.d("awcn.StrategyCenter", "receive amdc event", (String) null, new Object[0]);
            l.d a10 = l.a((JSONObject) dispatchEvent.extraObject);
            if (a10 != null) {
                this.f3940b.a(a10);
                saveData();
                Iterator<IStrategyListener> it = this.f3942d.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onStrategyUpdated(a10);
                    } catch (Exception e10) {
                        ALog.e("awcn.StrategyCenter", "onStrategyUpdated failed", (String) null, e10, new Object[0]);
                    }
                }
            }
        }
    }

    public void registerListener(IStrategyListener iStrategyListener) {
        ALog.e("awcn.StrategyCenter", "registerListener", (String) null, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, this.f3942d);
        if (iStrategyListener != null) {
            this.f3942d.add(iStrategyListener);
        }
    }

    public synchronized void saveData() {
        ALog.i("awcn.StrategyCenter", "saveData", (String) null, new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f3941c > NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) {
            this.f3941c = currentTimeMillis;
            a.a(new i(this), 500);
        }
    }

    public synchronized void switchEnv() {
        m.a();
        HttpDispatcher.getInstance().switchENV();
        StrategyInfoHolder strategyInfoHolder = this.f3940b;
        if (strategyInfoHolder != null) {
            strategyInfoHolder.b();
            this.f3940b = StrategyInfoHolder.a();
        }
    }

    public void unregisterListener(IStrategyListener iStrategyListener) {
        ALog.e("awcn.StrategyCenter", "unregisterListener", (String) null, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, this.f3942d);
        this.f3942d.remove(iStrategyListener);
    }

    /* access modifiers changed from: private */
    public boolean a() {
        if (this.f3940b != null) {
            return false;
        }
        ALog.w("awcn.StrategyCenter", "StrategyCenter not initialized", (String) null, "isInitialized", Boolean.valueOf(this.f3939a));
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006f, code lost:
        if (r0.f3940b.d().a(r2, anet.channel.AwcnConfig.getIpv6BlackListTtl()) != false) goto L_0x0076;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<anet.channel.strategy.IConnStrategy> getConnStrategyListByHost(java.lang.String r18, anet.channel.strategy.IStrategyFilter r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            boolean r2 = android.text.TextUtils.isEmpty(r18)
            if (r2 != 0) goto L_0x00c7
            boolean r2 = r17.a()
            if (r2 == 0) goto L_0x0012
            goto L_0x00c7
        L_0x0012:
            anet.channel.strategy.StrategyInfoHolder r2 = r0.f3940b
            anet.channel.strategy.StrategyTable r2 = r2.d()
            r3 = r18
            java.lang.String r2 = r2.getCnameByHost(r3)
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = r3
        L_0x0026:
            anet.channel.strategy.StrategyInfoHolder r3 = r0.f3940b
            anet.channel.strategy.StrategyTable r3 = r3.d()
            java.util.List r3 = r3.queryByHost(r2)
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x003e
            anet.channel.strategy.StrategyInfoHolder r3 = r0.f3940b
            anet.channel.strategy.a r3 = r3.f3897c
            java.util.List r3 = r3.a((java.lang.String) r2)
        L_0x003e:
            boolean r4 = r3.isEmpty()
            r5 = 3
            java.lang.String r6 = "result"
            r7 = 2
            java.lang.String r8 = "host"
            r9 = 4
            java.lang.String r11 = "getConnStrategyListByHost"
            java.lang.String r12 = "awcn.StrategyCenter"
            r13 = 0
            r14 = 1
            if (r4 != 0) goto L_0x00b7
            if (r1 != 0) goto L_0x0054
            goto L_0x00b7
        L_0x0054:
            boolean r4 = anet.channel.AwcnConfig.isIpv6Enable()
            if (r4 == 0) goto L_0x0075
            boolean r4 = anet.channel.AwcnConfig.isIpv6BlackListEnable()
            if (r4 == 0) goto L_0x0072
            anet.channel.strategy.StrategyInfoHolder r4 = r0.f3940b
            anet.channel.strategy.StrategyTable r4 = r4.d()
            r15 = r11
            long r10 = anet.channel.AwcnConfig.getIpv6BlackListTtl()
            boolean r4 = r4.a((java.lang.String) r2, (long) r10)
            if (r4 == 0) goto L_0x0073
            goto L_0x0076
        L_0x0072:
            r15 = r11
        L_0x0073:
            r4 = 0
            goto L_0x0077
        L_0x0075:
            r15 = r11
        L_0x0076:
            r4 = 1
        L_0x0077:
            java.util.ListIterator r10 = r3.listIterator()
        L_0x007b:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x00a1
            java.lang.Object r11 = r10.next()
            anet.channel.strategy.IConnStrategy r11 = (anet.channel.strategy.IConnStrategy) r11
            boolean r16 = r1.accept(r11)
            if (r16 != 0) goto L_0x0091
            r10.remove()
            goto L_0x007b
        L_0x0091:
            if (r4 == 0) goto L_0x007b
            java.lang.String r11 = r11.getIp()
            boolean r11 = anet.channel.strategy.utils.d.b(r11)
            if (r11 == 0) goto L_0x007b
            r10.remove()
            goto L_0x007b
        L_0x00a1:
            boolean r1 = anet.channel.util.ALog.isPrintLog(r14)
            if (r1 == 0) goto L_0x00b6
            java.lang.Object[] r1 = new java.lang.Object[r9]
            r1[r13] = r8
            r1[r14] = r2
            r1[r7] = r6
            r1[r5] = r3
            r10 = r15
            r4 = 0
            anet.channel.util.ALog.d(r12, r10, r4, r1)
        L_0x00b6:
            return r3
        L_0x00b7:
            r10 = r11
            r4 = 0
            java.lang.Object[] r1 = new java.lang.Object[r9]
            r1[r13] = r8
            r1[r14] = r2
            r1[r7] = r6
            r1[r5] = r3
            anet.channel.util.ALog.d(r12, r10, r4, r1)
            return r3
        L_0x00c7:
            java.util.List r1 = java.util.Collections.EMPTY_LIST
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.g.getConnStrategyListByHost(java.lang.String, anet.channel.strategy.IStrategyFilter):java.util.List");
    }

    public String getSchemeByHost(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (a()) {
            return str2;
        }
        String a10 = this.f3940b.f3896b.a(str);
        if (a10 != null || TextUtils.isEmpty(str2)) {
            str2 = a10;
        }
        if (str2 == null && (str2 = c.a.f3918a.a(str)) == null) {
            str2 = HttpConstant.HTTP;
        }
        ALog.d("awcn.StrategyCenter", "getSchemeByHost", (String) null, Constants.KEY_HOST, str, "scheme", str2);
        return str2;
    }
}
