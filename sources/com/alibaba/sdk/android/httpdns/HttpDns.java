package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.httpdns.a.a;
import com.alibaba.sdk.android.httpdns.d.b;
import com.alibaba.sdk.android.httpdns.d.c;
import com.alibaba.sdk.android.httpdns.probe.IPProbeItem;
import com.alibaba.sdk.android.utils.AMSConfigUtils;
import com.alibaba.sdk.android.utils.AMSDevReporter;
import com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpDns implements HttpDnsService {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f4911a = 0;
    private static DegradationFilter degradationFilter = null;
    private static d hostManager = d.a();
    /* access modifiers changed from: private */
    public static boolean inited = false;
    static HttpDns instance = null;
    private static String sAccountId = null;
    private static Context sContext = null;
    private static String sSecretKey = null;
    private boolean isExpiredIPEnabled = false;

    private HttpDns(Context context, String str) {
        f.c(str);
        a.a().c(context, str);
        a.a().a(b.a(context));
    }

    private static void disableReport() {
        b.a().k();
    }

    private static String getAccountId() {
        if (!TextUtils.isEmpty(sAccountId)) {
            return sAccountId;
        }
        String accountId = AMSConfigUtils.getAccountId(sContext);
        sAccountId = accountId;
        return accountId;
    }

    private String getIpByHost(String str) {
        if (!b.a()) {
            i.f("HttpDns service turned off");
            return null;
        }
        String[] ipsByHost = getIpsByHost(str);
        if (ipsByHost != null && ipsByHost.length > 0) {
            return ipsByHost[0];
        }
        return null;
    }

    private String[] getIpsByHost(String str) {
        if (!b.a()) {
            i.f("HttpDns service turned off");
        } else if (!l.b(str)) {
            return f.f20c;
        } else {
            if (l.c(str)) {
                return new String[]{str};
            }
            DegradationFilter degradationFilter2 = degradationFilter;
            if (degradationFilter2 != null && degradationFilter2.shouldDegradeHttpDNS(str)) {
                return f.f20c;
            }
            if (u.e()) {
                return getIpsByHostAsync(str);
            }
            e a10 = hostManager.a(str);
            if (a10 != null && a10.b() && this.isExpiredIPEnabled) {
                if (!hostManager.a(str)) {
                    i.d("refresh host async: " + str);
                    c.a().submit(new q(str, s.QUERY_HOST));
                }
                return a10.getIps();
            } else if (a10 != null && !a10.b()) {
                return a10.getIps();
            } else {
                i.d("refresh host sync: " + str);
                try {
                    return (String[]) c.a().submit(new q(str, s.QUERY_HOST)).get();
                } catch (Exception e10) {
                    i.a(e10);
                }
            }
        }
        return f.f20c;
    }

    private static String getSecretKey() {
        if (!TextUtils.isEmpty(sSecretKey)) {
            return sSecretKey;
        }
        String httpdnsSecretKey = AMSConfigUtils.getHttpdnsSecretKey(sContext);
        sSecretKey = httpdnsSecretKey;
        return httpdnsSecretKey;
    }

    public static synchronized HttpDnsService getService(Context context) {
        HttpDns httpDns;
        synchronized (HttpDns.class) {
            if (instance == null && context != null) {
                Context applicationContext = context.getApplicationContext();
                sContext = applicationContext;
                b.a(applicationContext);
                b.a(sContext).a((SDKMessageCallback) new SDKMessageCallback() {
                    public void crashDefendMessage(int i10, int i11) {
                        boolean unused = HttpDns.inited = true;
                        if (i10 > i11) {
                            b.b(true);
                            return;
                        }
                        i.f("crash limit exceeds, httpdns disabled");
                        b.b(false);
                    }
                });
                if (!inited) {
                    i.f("sdk crash defend not returned");
                }
                if (b.a()) {
                    initHttpDns(sContext, getAccountId(), getSecretKey());
                } else {
                    instance = new HttpDns(sContext, getAccountId());
                }
            }
            httpDns = instance;
        }
        return httpDns;
    }

    private static void initHttpDns(Context context, String str, String str2) {
        if (instance == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(AMSDevReporter.AMSSdkExtInfoKeyEnum.AMS_EXTINFO_KEY_VERSION.toString(), "1.3.2.3-no-bssid-ssid");
            AMSDevReporter.asyncReport(context, AMSDevReporter.AMSSdkTypeEnum.AMS_HTTPDNS, hashMap);
            p.setContext(context);
            q.setContext(context);
            com.alibaba.sdk.android.httpdns.b.b.a(context);
            com.alibaba.sdk.android.httpdns.b.b.b(context);
            u.a(context);
            n.a().a(context, str);
            if (!TextUtils.isEmpty(str2)) {
                a.setSecretKey(str2);
            }
            reportActive(context, str);
            instance = new HttpDns(context, str);
        }
    }

    private static void reportActive(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            i.f("report active failed due to missing context or accountid");
            return;
        }
        b.a(context).setAccountId(str);
        b.a(context).l();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [boolean, int] */
    private static void reportHttpDnsSuccess(String str, int i10) {
        b a10 = b.a();
        if (a10 != null) {
            a10.a(str, i10, c.a(), (int) com.alibaba.sdk.android.httpdns.b.b.a());
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [boolean, int] */
    private static void reportUserGetIP(String str, int i10) {
        b a10 = b.a();
        if (a10 != null) {
            a10.b(str, i10, c.a(), com.alibaba.sdk.android.httpdns.b.b.a());
        }
    }

    private static void setAccountId(String str) {
        sAccountId = str;
    }

    private static void setSecretKey(String str) {
        sSecretKey = str;
    }

    public static synchronized void switchDnsService(boolean z10) {
        synchronized (HttpDns.class) {
            b.a(z10);
            if (!b.a()) {
                i.f("httpdns service disabled");
            }
        }
    }

    public void clearSdnsGlobalParams() {
        f.clearSdnsGlobalParams();
    }

    public void enableIPv6(boolean z10) {
        com.alibaba.sdk.android.httpdns.net64.a.a().enableIPv6(z10);
        try {
            b a10 = b.a();
            if (a10 != null) {
                a10.e(z10 ? 1 : 0);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public String getIPv6ByHostAsync(String str) {
        try {
            if (!b.a()) {
                i.f("HttpDns service turned off");
                return null;
            }
            if (com.alibaba.sdk.android.httpdns.net64.a.a().a()) {
                getIpsByHostAsync(str);
                e a10 = hostManager.a(str);
                if (a10 != null) {
                    String iPv6ByHostAsync = com.alibaba.sdk.android.httpdns.net64.a.a().getIPv6ByHostAsync(str);
                    if (this.isExpiredIPEnabled) {
                        i.d("ipv6 is expired enable, hostName: " + str + " ipv6: " + iPv6ByHostAsync);
                        return iPv6ByHostAsync;
                    } else if (!a10.b()) {
                        i.d("ipv6 is not expired, hostName: " + str + " ipv6: " + iPv6ByHostAsync);
                        return iPv6ByHostAsync;
                    } else if (a10.c()) {
                        i.d("ipv6 is from cache, hostName: " + str + " ipv6: " + iPv6ByHostAsync);
                        return iPv6ByHostAsync;
                    } else {
                        i.d("ipv6 is expired.");
                        return null;
                    }
                }
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public String getIpByHostAsync(String str) {
        try {
            if (!b.a()) {
                i.f("HttpDns service turned off");
                return null;
            }
            String[] ipsByHostAsync = getIpsByHostAsync(str);
            if (ipsByHostAsync != null && ipsByHostAsync.length > 0) {
                return ipsByHostAsync[0];
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0057, code lost:
        if (r3 != false) goto L_0x005b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alibaba.sdk.android.httpdns.HTTPDNSResult getIpsByHostAsync(java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7, java.lang.String r8) {
        /*
            r5 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = com.alibaba.sdk.android.httpdns.f.extra
            r0.putAll(r7)
            boolean r7 = com.alibaba.sdk.android.httpdns.b.a()
            if (r7 != 0) goto L_0x0018
            java.lang.String r7 = "HttpDns service turned off"
            com.alibaba.sdk.android.httpdns.i.f(r7)
            com.alibaba.sdk.android.httpdns.HTTPDNSResult r7 = new com.alibaba.sdk.android.httpdns.HTTPDNSResult
            java.lang.String[] r8 = com.alibaba.sdk.android.httpdns.f.f20c
            r7.<init>(r6, r8, r0)
            return r7
        L_0x0018:
            boolean r7 = com.alibaba.sdk.android.httpdns.l.b(r6)
            if (r7 != 0) goto L_0x0026
            com.alibaba.sdk.android.httpdns.HTTPDNSResult r7 = new com.alibaba.sdk.android.httpdns.HTTPDNSResult
            java.lang.String[] r8 = com.alibaba.sdk.android.httpdns.f.f20c
            r7.<init>(r6, r8, r0)
            return r7
        L_0x0026:
            boolean r7 = com.alibaba.sdk.android.httpdns.l.c(r6)
            if (r7 == 0) goto L_0x0036
            com.alibaba.sdk.android.httpdns.HTTPDNSResult r7 = new com.alibaba.sdk.android.httpdns.HTTPDNSResult
            java.lang.String[] r8 = new java.lang.String[]{r6}
            r7.<init>(r6, r8, r0)
            return r7
        L_0x0036:
            com.alibaba.sdk.android.httpdns.DegradationFilter r7 = degradationFilter
            if (r7 == 0) goto L_0x0048
            boolean r7 = r7.shouldDegradeHttpDNS(r6)
            if (r7 == 0) goto L_0x0048
            com.alibaba.sdk.android.httpdns.HTTPDNSResult r7 = new com.alibaba.sdk.android.httpdns.HTTPDNSResult
            java.lang.String[] r8 = com.alibaba.sdk.android.httpdns.f.f20c
            r7.<init>(r6, r8, r0)
            return r7
        L_0x0048:
            com.alibaba.sdk.android.httpdns.d r7 = hostManager
            com.alibaba.sdk.android.httpdns.e r7 = r7.a((java.lang.String) r6)
            java.lang.String r1 = "refresh host async: "
            r2 = 0
            if (r7 == 0) goto L_0x005a
            boolean r3 = r7.b()
            if (r3 == 0) goto L_0x0092
            goto L_0x005b
        L_0x005a:
            r3 = 0
        L_0x005b:
            com.alibaba.sdk.android.httpdns.d r4 = hostManager
            boolean r4 = r4.a((java.lang.String) r6)
            if (r4 != 0) goto L_0x0092
            boolean r4 = com.alibaba.sdk.android.httpdns.u.e()
            if (r4 == 0) goto L_0x0071
        L_0x0069:
            com.alibaba.sdk.android.httpdns.t r1 = com.alibaba.sdk.android.httpdns.t.a()
            r1.g(r6)
            goto L_0x00bf
        L_0x0071:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            r4.append(r6)
            java.lang.String r1 = r4.toString()
            com.alibaba.sdk.android.httpdns.i.d(r1)
            com.alibaba.sdk.android.httpdns.q r1 = new com.alibaba.sdk.android.httpdns.q
            com.alibaba.sdk.android.httpdns.s r4 = com.alibaba.sdk.android.httpdns.s.QUERY_HOST
            r1.<init>(r6, r4, r0, r8)
        L_0x008a:
            java.util.concurrent.ExecutorService r4 = com.alibaba.sdk.android.httpdns.c.a()
            r4.submit(r1)
            goto L_0x00bf
        L_0x0092:
            if (r7 == 0) goto L_0x00bf
            java.lang.String r4 = r7.getCacheKey()
            boolean r4 = r8.equals(r4)
            if (r4 != 0) goto L_0x00bf
            boolean r4 = com.alibaba.sdk.android.httpdns.u.e()
            if (r4 == 0) goto L_0x00a5
            goto L_0x0069
        L_0x00a5:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            r4.append(r6)
            java.lang.String r1 = r4.toString()
            com.alibaba.sdk.android.httpdns.i.d(r1)
            com.alibaba.sdk.android.httpdns.q r1 = new com.alibaba.sdk.android.httpdns.q
            com.alibaba.sdk.android.httpdns.s r4 = com.alibaba.sdk.android.httpdns.s.QUERY_HOST
            r1.<init>(r6, r4, r0, r8)
            goto L_0x008a
        L_0x00bf:
            if (r7 != 0) goto L_0x00cc
            reportUserGetIP(r6, r2)
            com.alibaba.sdk.android.httpdns.HTTPDNSResult r7 = new com.alibaba.sdk.android.httpdns.HTTPDNSResult
            java.lang.String[] r8 = com.alibaba.sdk.android.httpdns.f.f20c
            r7.<init>(r6, r8, r0)
            return r7
        L_0x00cc:
            boolean r1 = com.alibaba.sdk.android.httpdns.u.e()
            if (r1 == 0) goto L_0x00e2
            java.lang.String r7 = "[HttpDns] disabled return Nil."
            com.alibaba.sdk.android.httpdns.i.d(r7)
            reportUserGetIP(r6, r2)
            com.alibaba.sdk.android.httpdns.HTTPDNSResult r7 = new com.alibaba.sdk.android.httpdns.HTTPDNSResult
            java.lang.String[] r8 = com.alibaba.sdk.android.httpdns.f.f20c
            r7.<init>(r6, r8, r0)
            return r7
        L_0x00e2:
            java.lang.String r1 = r7.getCacheKey()
            boolean r8 = r8.equals(r1)
            if (r8 != 0) goto L_0x00f4
            com.alibaba.sdk.android.httpdns.HTTPDNSResult r7 = new com.alibaba.sdk.android.httpdns.HTTPDNSResult
            java.lang.String[] r8 = com.alibaba.sdk.android.httpdns.f.f20c
            r7.<init>(r6, r8, r0)
            return r7
        L_0x00f4:
            boolean r8 = r5.isExpiredIPEnabled
            r1 = 1
            if (r8 == 0) goto L_0x010d
            reportHttpDnsSuccess(r6, r1)
            reportUserGetIP(r6, r1)
            com.alibaba.sdk.android.httpdns.HTTPDNSResult r8 = new com.alibaba.sdk.android.httpdns.HTTPDNSResult
            java.lang.String[] r0 = r7.getIps()
            java.util.Map r7 = r7.a()
            r8.<init>(r6, r0, r7)
            return r8
        L_0x010d:
            boolean r8 = r7.c()
            if (r8 == 0) goto L_0x013d
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "[HttpDns] ips from cache:"
            r8.append(r0)
            java.lang.String[] r0 = r7.getIps()
            java.lang.String r0 = java.util.Arrays.toString(r0)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            com.alibaba.sdk.android.httpdns.i.d(r8)
            com.alibaba.sdk.android.httpdns.HTTPDNSResult r8 = new com.alibaba.sdk.android.httpdns.HTTPDNSResult
            java.lang.String[] r0 = r7.getIps()
            java.util.Map r7 = r7.a()
            r8.<init>(r6, r0, r7)
            return r8
        L_0x013d:
            if (r3 != 0) goto L_0x016f
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "[HttpDns] not expired return "
            r8.append(r0)
            java.lang.String[] r0 = r7.getIps()
            java.lang.String r0 = java.util.Arrays.toString(r0)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            com.alibaba.sdk.android.httpdns.i.d(r8)
            reportHttpDnsSuccess(r6, r1)
            reportUserGetIP(r6, r1)
            com.alibaba.sdk.android.httpdns.HTTPDNSResult r8 = new com.alibaba.sdk.android.httpdns.HTTPDNSResult
            java.lang.String[] r0 = r7.getIps()
            java.util.Map r7 = r7.a()
            r8.<init>(r6, r0, r7)
            return r8
        L_0x016f:
            java.lang.String r7 = "[HttpDns] return Nil."
            com.alibaba.sdk.android.httpdns.i.f(r7)
            reportUserGetIP(r6, r2)
            com.alibaba.sdk.android.httpdns.HTTPDNSResult r7 = new com.alibaba.sdk.android.httpdns.HTTPDNSResult
            java.lang.String[] r8 = com.alibaba.sdk.android.httpdns.f.f20c
            r7.<init>(r6, r8, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.HttpDns.getIpsByHostAsync(java.lang.String, java.util.Map, java.lang.String):com.alibaba.sdk.android.httpdns.HTTPDNSResult");
    }

    public String getSessionId() {
        return com.alibaba.sdk.android.httpdns.e.a.a().getSessionId();
    }

    public void setAuthCurrentTime(long j10) {
        if (!b.a()) {
            i.f("HttpDns service turned off");
        } else {
            a.setAuthCurrentTime(j10);
        }
    }

    public void setCachedIPEnabled(boolean z10) {
        setCachedIPEnabled(z10, true);
    }

    public void setDegradationFilter(DegradationFilter degradationFilter2) {
        if (!b.a()) {
            i.f("HttpDns service turned off");
        } else {
            degradationFilter = degradationFilter2;
        }
    }

    public void setExpiredIPEnabled(boolean z10) {
        if (!b.a()) {
            i.f("HttpDns service turned off");
            return;
        }
        this.isExpiredIPEnabled = z10;
        b a10 = b.a();
        if (a10 != null) {
            a10.d(z10 ? 1 : 0);
        }
    }

    public void setHTTPSRequestEnabled(boolean z10) {
        if (!b.a()) {
            i.f("HttpDns service turned off");
        } else {
            f.setHTTPSRequestEnabled(z10);
        }
    }

    public void setIPProbeList(List<IPProbeItem> list) {
        if (!b.a()) {
            i.f("HttpDns service turned off");
        } else {
            f.a(list);
        }
    }

    public void setLogEnabled(boolean z10) {
        i.setLogEnabled(z10);
    }

    public void setLogger(ILogger iLogger) {
        i.setLogger(iLogger);
    }

    public void setPreResolveAfterNetworkChanged(boolean z10) {
        if (!b.a()) {
            i.f("HttpDns service turned off");
        } else {
            p.f5006i = z10;
        }
    }

    public void setPreResolveHosts(ArrayList<String> arrayList) {
        if (!b.a()) {
            i.f("HttpDns service turned off");
            return;
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            String str = arrayList.get(i10);
            if (l.b(str) && !hostManager.a(str)) {
                c.a().submit(new q(str, s.QUERY_HOST));
            }
        }
    }

    public void setRegion(String str) {
        if (!b.a()) {
            i.f("HttpDns service turned off");
        } else if (TextUtils.isEmpty(str)) {
            i.f("region cannot be empty");
        } else {
            n.a().b(sContext, str);
        }
    }

    public void setSdnsGlobalParams(Map<String, String> map) {
        f.setSdnsGlobalParams(map);
    }

    public void setTimeoutInterval(int i10) {
        if (!b.a()) {
            i.f("HttpDns service turned off");
        } else {
            f.setTimeoutInterval(i10);
        }
    }

    public static synchronized HttpDnsService getService(Context context, String str) {
        HttpDns httpDns;
        synchronized (HttpDns.class) {
            if (instance == null && context != null) {
                sContext = context.getApplicationContext();
                setAccountId(str);
                b.a(sContext);
                b.a(sContext).a((SDKMessageCallback) new SDKMessageCallback() {
                    public void crashDefendMessage(int i10, int i11) {
                        boolean unused = HttpDns.inited = true;
                        if (i10 > i11) {
                            b.b(true);
                            return;
                        }
                        i.f("crash limit exceeds, httpdns disabled");
                        b.b(false);
                    }
                });
                if (!inited) {
                    i.f("sdk crash defend not returned");
                }
                if (b.a()) {
                    initHttpDns(sContext, getAccountId(), getSecretKey());
                } else {
                    instance = new HttpDns(sContext, getAccountId());
                }
            }
            httpDns = instance;
        }
        return httpDns;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
        if (r3 != false) goto L_0x0042;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String[] getIpsByHostAsync(java.lang.String r6) {
        /*
            r5 = this;
            boolean r0 = com.alibaba.sdk.android.httpdns.b.a()
            if (r0 != 0) goto L_0x000e
            java.lang.String r6 = "HttpDns service turned off"
            com.alibaba.sdk.android.httpdns.i.f(r6)
            java.lang.String[] r6 = com.alibaba.sdk.android.httpdns.f.f20c
            return r6
        L_0x000e:
            boolean r0 = com.alibaba.sdk.android.httpdns.l.b(r6)
            if (r0 != 0) goto L_0x0017
            java.lang.String[] r6 = com.alibaba.sdk.android.httpdns.f.f20c
            return r6
        L_0x0017:
            boolean r0 = com.alibaba.sdk.android.httpdns.l.c(r6)
            if (r0 == 0) goto L_0x0022
            java.lang.String[] r6 = new java.lang.String[]{r6}
            return r6
        L_0x0022:
            com.alibaba.sdk.android.httpdns.DegradationFilter r0 = degradationFilter
            if (r0 == 0) goto L_0x002f
            boolean r0 = r0.shouldDegradeHttpDNS(r6)
            if (r0 == 0) goto L_0x002f
            java.lang.String[] r6 = com.alibaba.sdk.android.httpdns.f.f20c
            return r6
        L_0x002f:
            com.alibaba.sdk.android.httpdns.d r0 = hostManager
            com.alibaba.sdk.android.httpdns.e r0 = r0.a((java.lang.String) r6)
            java.lang.String r1 = "refresh host async: "
            r2 = 0
            if (r0 == 0) goto L_0x0041
            boolean r3 = r0.b()
            if (r3 == 0) goto L_0x0079
            goto L_0x0042
        L_0x0041:
            r3 = 0
        L_0x0042:
            com.alibaba.sdk.android.httpdns.d r4 = hostManager
            boolean r4 = r4.a((java.lang.String) r6)
            if (r4 != 0) goto L_0x0079
            boolean r4 = com.alibaba.sdk.android.httpdns.u.e()
            if (r4 == 0) goto L_0x0058
        L_0x0050:
            com.alibaba.sdk.android.httpdns.t r1 = com.alibaba.sdk.android.httpdns.t.a()
            r1.g(r6)
            goto L_0x00a2
        L_0x0058:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            r4.append(r6)
            java.lang.String r1 = r4.toString()
            com.alibaba.sdk.android.httpdns.i.d(r1)
            com.alibaba.sdk.android.httpdns.q r1 = new com.alibaba.sdk.android.httpdns.q
            com.alibaba.sdk.android.httpdns.s r4 = com.alibaba.sdk.android.httpdns.s.QUERY_HOST
            r1.<init>(r6, r4)
        L_0x0071:
            java.util.concurrent.ExecutorService r4 = com.alibaba.sdk.android.httpdns.c.a()
            r4.submit(r1)
            goto L_0x00a2
        L_0x0079:
            if (r0 == 0) goto L_0x00a2
            java.lang.String r4 = r0.getCacheKey()
            if (r4 == 0) goto L_0x00a2
            boolean r4 = com.alibaba.sdk.android.httpdns.u.e()
            if (r4 == 0) goto L_0x0088
            goto L_0x0050
        L_0x0088:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            r4.append(r6)
            java.lang.String r1 = r4.toString()
            com.alibaba.sdk.android.httpdns.i.d(r1)
            com.alibaba.sdk.android.httpdns.q r1 = new com.alibaba.sdk.android.httpdns.q
            com.alibaba.sdk.android.httpdns.s r4 = com.alibaba.sdk.android.httpdns.s.QUERY_HOST
            r1.<init>(r6, r4)
            goto L_0x0071
        L_0x00a2:
            if (r0 != 0) goto L_0x00aa
            reportUserGetIP(r6, r2)
            java.lang.String[] r6 = com.alibaba.sdk.android.httpdns.f.f20c
            return r6
        L_0x00aa:
            boolean r1 = com.alibaba.sdk.android.httpdns.u.e()
            if (r1 == 0) goto L_0x00bb
            java.lang.String r0 = "[HttpDns] disabled return Nil."
            com.alibaba.sdk.android.httpdns.i.d(r0)
            reportUserGetIP(r6, r2)
            java.lang.String[] r6 = com.alibaba.sdk.android.httpdns.f.f20c
            return r6
        L_0x00bb:
            java.lang.String r1 = r0.getCacheKey()
            if (r1 == 0) goto L_0x00c4
            java.lang.String[] r6 = com.alibaba.sdk.android.httpdns.f.f20c
            return r6
        L_0x00c4:
            boolean r1 = r5.isExpiredIPEnabled
            r4 = 1
            if (r1 == 0) goto L_0x00d4
            reportHttpDnsSuccess(r6, r4)
            reportUserGetIP(r6, r4)
            java.lang.String[] r6 = r0.getIps()
            return r6
        L_0x00d4:
            boolean r1 = r0.c()
            if (r1 == 0) goto L_0x00fb
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = "[HttpDns] ips from cache:"
            r6.append(r1)
            java.lang.String[] r1 = r0.getIps()
            java.lang.String r1 = java.util.Arrays.toString(r1)
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            com.alibaba.sdk.android.httpdns.i.d(r6)
            java.lang.String[] r6 = r0.getIps()
            return r6
        L_0x00fb:
            if (r3 != 0) goto L_0x0124
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "[HttpDns] not expired return "
            r1.append(r2)
            java.lang.String[] r2 = r0.getIps()
            java.lang.String r2 = java.util.Arrays.toString(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.alibaba.sdk.android.httpdns.i.d(r1)
            reportHttpDnsSuccess(r6, r4)
            reportUserGetIP(r6, r4)
            java.lang.String[] r6 = r0.getIps()
            return r6
        L_0x0124:
            java.lang.String r0 = "[HttpDns] return Nil."
            com.alibaba.sdk.android.httpdns.i.f(r0)
            reportUserGetIP(r6, r2)
            java.lang.String[] r6 = com.alibaba.sdk.android.httpdns.f.f20c
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.HttpDns.getIpsByHostAsync(java.lang.String):java.lang.String[]");
    }

    public void setCachedIPEnabled(boolean z10, boolean z11) {
        try {
            if (!b.a()) {
                i.f("HttpDns service turned off");
                return;
            }
            i.f("Httpdns DB cache enable = " + z10 + ". autoCleanCacheAfterLoad = " + z11);
            com.alibaba.sdk.android.httpdns.b.b.a(z10, z11);
            d.a().a();
            b a10 = b.a();
            if (a10 != null) {
                a10.c(z10 ? 1 : 0);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static synchronized HttpDnsService getService(Context context, String str, String str2) {
        HttpDns httpDns;
        synchronized (HttpDns.class) {
            if (instance == null && context != null) {
                sContext = context.getApplicationContext();
                setAccountId(str);
                setSecretKey(str2);
                b.a(sContext);
                b.a(sContext).a((SDKMessageCallback) new SDKMessageCallback() {
                    public void crashDefendMessage(int i10, int i11) {
                        boolean unused = HttpDns.inited = true;
                        if (i10 > i11) {
                            b.b(true);
                            return;
                        }
                        i.f("crash limit exceeds, httpdns disabled");
                        b.b(false);
                    }
                });
                if (!inited) {
                    i.f("sdk crash defend not returned");
                }
                if (b.a()) {
                    initHttpDns(sContext, getAccountId(), getSecretKey());
                } else {
                    instance = new HttpDns(sContext, getAccountId());
                }
            }
            httpDns = instance;
        }
        return httpDns;
    }
}
