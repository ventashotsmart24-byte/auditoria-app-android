package com.taobao.accs.ut.monitor;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

public class TrafficsMonitor {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, List<a>> f13171a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f13172b = new HashMap<String, String>() {
        {
            put("im", "512");
            put("motu", "513");
            put("acds", "514");
            put(GlobalClientInfo.AGOO_SERVICE_ID, "515");
            put(AgooConstants.AGOO_SERVICE_AGOOACK, "515");
            put("agooTokenReport", "515");
            put("accsSelf", "1000");
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private int f13173c = 0;

    /* renamed from: d  reason: collision with root package name */
    private Context f13174d;

    /* renamed from: e  reason: collision with root package name */
    private String f13175e = "";

    @Monitor(module = "NetworkSDK", monitorPoint = "TrafficStats")
    public static class StatTrafficMonitor extends BaseMonitor {
        @Dimension
        public String bizId;
        @Dimension
        public String date;
        @Dimension
        public String host;
        @Dimension
        public boolean isBackground;
        @Dimension
        public String serviceId;
        @Measure
        public long size;
    }

    public TrafficsMonitor(Context context) {
        this.f13174d = context;
    }

    private void b() {
        boolean z10;
        String str;
        synchronized (this.f13171a) {
            String a10 = UtilityImpl.a(System.currentTimeMillis());
            if (TextUtils.isEmpty(this.f13175e) || this.f13175e.equals(a10)) {
                str = a10;
                z10 = false;
            } else {
                str = this.f13175e;
                z10 = true;
            }
            for (String str2 : this.f13171a.keySet()) {
                for (a aVar : this.f13171a.get(str2)) {
                    if (aVar != null) {
                        com.taobao.accs.b.a a11 = com.taobao.accs.b.a.a(this.f13174d);
                        String str3 = aVar.f13181e;
                        String str4 = aVar.f13179c;
                        a11.a(str3, str4, this.f13172b.get(str4), aVar.f13180d, aVar.f13182f, str);
                    }
                }
            }
            ALog.Level level = ALog.Level.D;
            if (ALog.isPrintLog(level)) {
                ALog.d("TrafficsMonitor", "savetoDay:" + str + " saveTraffics" + this.f13171a.toString(), new Object[0]);
            }
            if (z10) {
                this.f13171a.clear();
                c();
            } else if (ALog.isPrintLog(level)) {
                ALog.d("TrafficsMonitor", "no need commit lastsaveDay:" + this.f13175e + " currday:" + a10, new Object[0]);
            }
            this.f13175e = a10;
            this.f13173c = 0;
        }
    }

    private void c() {
        List<a> a10 = com.taobao.accs.b.a.a(this.f13174d).a(false);
        if (a10 != null) {
            try {
                for (a next : a10) {
                    if (next != null) {
                        StatTrafficMonitor statTrafficMonitor = new StatTrafficMonitor();
                        statTrafficMonitor.bizId = next.f13178b;
                        statTrafficMonitor.date = next.f13177a;
                        statTrafficMonitor.host = next.f13181e;
                        statTrafficMonitor.isBackground = next.f13180d;
                        statTrafficMonitor.size = next.f13182f;
                        AppMonitor.getInstance().commitStat(statTrafficMonitor);
                    }
                }
                com.taobao.accs.b.a.a(this.f13174d).a();
            } catch (Throwable th) {
                ALog.e("", th.toString(), new Object[0]);
                th.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008b, code lost:
        if (r11 < 10) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008d, code lost:
        b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.taobao.accs.ut.monitor.TrafficsMonitor.a r11) {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x0094
            java.lang.String r0 = r11.f13181e
            if (r0 == 0) goto L_0x0094
            long r0 = r11.f13182f
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0094
            java.lang.String r0 = r11.f13179c
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0019
            java.lang.String r0 = "accsSelf"
            goto L_0x001b
        L_0x0019:
            java.lang.String r0 = r11.f13179c
        L_0x001b:
            r11.f13179c = r0
            java.util.Map<java.lang.String, java.util.List<com.taobao.accs.ut.monitor.TrafficsMonitor$a>> r0 = r10.f13171a
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.String> r1 = r10.f13172b     // Catch:{ all -> 0x0091 }
            java.lang.String r2 = r11.f13179c     // Catch:{ all -> 0x0091 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0091 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0091 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0091 }
            if (r2 == 0) goto L_0x0032
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            return
        L_0x0032:
            r11.f13178b = r1     // Catch:{ all -> 0x0091 }
            com.taobao.accs.utl.ALog$Level r2 = com.taobao.accs.utl.ALog.Level.D     // Catch:{ all -> 0x0091 }
            com.taobao.accs.utl.ALog.isPrintLog(r2)     // Catch:{ all -> 0x0091 }
            java.util.Map<java.lang.String, java.util.List<com.taobao.accs.ut.monitor.TrafficsMonitor$a>> r2 = r10.f13171a     // Catch:{ all -> 0x0091 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0091 }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x0091 }
            r3 = 1
            if (r2 == 0) goto L_0x0076
            java.util.Iterator r4 = r2.iterator()     // Catch:{ all -> 0x0091 }
        L_0x0048:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0091 }
            if (r5 == 0) goto L_0x006f
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0091 }
            com.taobao.accs.ut.monitor.TrafficsMonitor$a r5 = (com.taobao.accs.ut.monitor.TrafficsMonitor.a) r5     // Catch:{ all -> 0x0091 }
            boolean r6 = r5.f13180d     // Catch:{ all -> 0x0091 }
            boolean r7 = r11.f13180d     // Catch:{ all -> 0x0091 }
            if (r6 != r7) goto L_0x0048
            java.lang.String r6 = r5.f13181e     // Catch:{ all -> 0x0091 }
            if (r6 == 0) goto L_0x0048
            java.lang.String r7 = r11.f13181e     // Catch:{ all -> 0x0091 }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x0091 }
            if (r6 == 0) goto L_0x0048
            long r6 = r5.f13182f     // Catch:{ all -> 0x0091 }
            long r8 = r11.f13182f     // Catch:{ all -> 0x0091 }
            long r6 = r6 + r8
            r5.f13182f = r6     // Catch:{ all -> 0x0091 }
            r4 = 0
            goto L_0x0070
        L_0x006f:
            r4 = 1
        L_0x0070:
            if (r4 == 0) goto L_0x007e
            r2.add(r11)     // Catch:{ all -> 0x0091 }
            goto L_0x007e
        L_0x0076:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0091 }
            r2.<init>()     // Catch:{ all -> 0x0091 }
            r2.add(r11)     // Catch:{ all -> 0x0091 }
        L_0x007e:
            java.util.Map<java.lang.String, java.util.List<com.taobao.accs.ut.monitor.TrafficsMonitor$a>> r11 = r10.f13171a     // Catch:{ all -> 0x0091 }
            r11.put(r1, r2)     // Catch:{ all -> 0x0091 }
            int r11 = r10.f13173c     // Catch:{ all -> 0x0091 }
            int r11 = r11 + r3
            r10.f13173c = r11     // Catch:{ all -> 0x0091 }
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            r0 = 10
            if (r11 < r0) goto L_0x0094
            r10.b()
            goto L_0x0094
        L_0x0091:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            throw r11
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.ut.monitor.TrafficsMonitor.a(com.taobao.accs.ut.monitor.TrafficsMonitor$a):void");
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        String f13177a;

        /* renamed from: b  reason: collision with root package name */
        String f13178b;

        /* renamed from: c  reason: collision with root package name */
        String f13179c;

        /* renamed from: d  reason: collision with root package name */
        boolean f13180d;

        /* renamed from: e  reason: collision with root package name */
        String f13181e;

        /* renamed from: f  reason: collision with root package name */
        long f13182f;

        public a(String str, boolean z10, String str2, long j10) {
            this.f13179c = str;
            this.f13180d = z10;
            this.f13181e = str2;
            this.f13182f = j10;
        }

        public String toString() {
            return "date:" + this.f13177a + " " + "bizId:" + this.f13178b + " " + "serviceId:" + this.f13179c + " " + "host:" + this.f13181e + " " + "isBackground:" + this.f13180d + " " + "size:" + this.f13182f;
        }

        public a(String str, String str2, String str3, boolean z10, String str4, long j10) {
            this.f13177a = str;
            this.f13178b = str2;
            this.f13179c = str3;
            this.f13180d = z10;
            this.f13181e = str4;
            this.f13182f = j10;
        }
    }

    public void a() {
        try {
            synchronized (this.f13171a) {
                this.f13171a.clear();
            }
            List<a> a10 = com.taobao.accs.b.a.a(this.f13174d).a(true);
            if (a10 != null) {
                for (a a11 : a10) {
                    a(a11);
                }
            }
        } catch (Exception e10) {
            ALog.w("TrafficsMonitor", e10.toString(), new Object[0]);
        }
    }
}
