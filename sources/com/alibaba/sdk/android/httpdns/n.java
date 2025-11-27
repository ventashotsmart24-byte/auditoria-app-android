package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.alibaba.sdk.android.httpdns.d.b;
import com.alibaba.sdk.android.httpdns.d.c;
import com.alibaba.sdk.android.httpdns.e.a;
import com.raizlabs.android.dbflow.sql.language.Operator;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private static volatile n f4991a = null;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f4992d = false;

    /* renamed from: e  reason: collision with root package name */
    private static long f4993e = 0;

    /* renamed from: g  reason: collision with root package name */
    private static String f4994g = "https://";

    /* renamed from: h  reason: collision with root package name */
    private static String f4995h = null;

    /* renamed from: h  reason: collision with other field name */
    public static boolean f24h = false;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f25a = null;

    /* renamed from: a  reason: collision with other field name */
    private Handler f26a = null;

    /* renamed from: c  reason: collision with root package name */
    private String f4996c;

    /* renamed from: e  reason: collision with other field name */
    private int f27e = 0;

    /* renamed from: e  reason: collision with other field name */
    private boolean f28e;

    /* renamed from: f  reason: collision with root package name */
    private int f4997f = 0;

    /* renamed from: f  reason: collision with other field name */
    private long f29f = 0;

    /* renamed from: f  reason: collision with other field name */
    private boolean f30f = false;

    /* renamed from: g  reason: collision with other field name */
    private long f31g = 0;

    /* renamed from: g  reason: collision with other field name */
    private boolean f32g = true;

    /* renamed from: i  reason: collision with root package name */
    private String f4998i = null;

    private n() {
    }

    public static n a() {
        if (f4991a == null) {
            synchronized (n.class) {
                if (f4991a == null) {
                    f4991a = new n();
                }
            }
        }
        return f4991a;
    }

    private String e() {
        return (this.f28e || this.f30f) ? f.f4976b[this.f4997f] : f.f19a[this.f27e];
    }

    private void f() {
        int i10 = this.f4997f;
        this.f4997f = i10 < f.f4976b.length + -1 ? i10 + 1 : 0;
    }

    public synchronized void b(Context context, String str) {
        try {
            if (!str.equals(this.f4998i)) {
                this.f4998i = str;
                if (System.currentTimeMillis() - this.f31g >= 300000) {
                    d();
                } else {
                    long currentTimeMillis = 300000 - (System.currentTimeMillis() - this.f31g);
                    i.e("The call time should be greater than 5 minutes. SDK will initiate an update request after " + (currentTimeMillis / 60000) + " minutes.");
                    if (this.f26a == null) {
                        Handler handler = new Handler();
                        this.f26a = handler;
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                n.this.d();
                            }
                        }, currentTimeMillis);
                    }
                }
                if (this.f25a == null) {
                    if (context != null) {
                        this.f25a = context.getSharedPreferences("httpdns_config_cache", 0);
                    } else {
                        i.f("sp failed to save, does not affect the current settings");
                        return;
                    }
                }
                SharedPreferences.Editor edit = this.f25a.edit();
                edit.putString("httpdns_region", this.f4998i);
                edit.putBoolean("httpdns_first_start", true);
                edit.putLong("schedule_center_last_request_time", 0);
                edit.commit();
            } else {
                i.e("region should be different");
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public synchronized void c() {
        m a10;
        int length;
        if (System.currentTimeMillis() - this.f29f >= 300000) {
            i.d("update server ips from StartIp schedule center.");
            this.f27e = 0;
            this.f4997f = 0;
            this.f30f = false;
            this.f32g = true;
            f24h = false;
            if (this.f28e) {
                a10 = m.a();
                length = f.f4976b.length;
            } else {
                a10 = m.a();
                length = f.f19a.length;
            }
            a10.a(length - 1);
            c.a().submit(m.a());
        } else {
            i.d("update server ips from StartIp schedule center too often, give up. ");
            u.j();
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public synchronized String m17d() {
        StringBuilder sb;
        String str;
        try {
            sb = new StringBuilder();
            sb.append(f4994g);
            sb.append(e());
            sb.append(Operator.Operation.DIVISION);
            String str2 = this.f4996c;
            if (str2 == null) {
                str2 = f.f4977c;
            }
            sb.append(str2);
            sb.append("/ss?platform=android&sdk_version=");
            sb.append("1.3.2.3-no-bssid-ssid");
            sb.append("&sid=");
            sb.append(a.a().getSessionId());
            sb.append("&net=");
            sb.append(a.a().l());
            if (TextUtils.isEmpty(this.f4998i)) {
                str = "";
            } else {
                str = "&region=" + this.f4998i;
            }
            sb.append(str);
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
        return sb.toString();
    }

    public void setAccountId(String str) {
        this.f4996c = str;
    }

    /* access modifiers changed from: private */
    public void d() {
        i.d("update server ips from StartIp schedule center.");
        this.f31g = System.currentTimeMillis();
        this.f27e = 0;
        this.f4997f = 0;
        this.f30f = false;
        this.f28e = true;
        this.f32g = true;
        f24h = false;
        m.a().a(f.f4976b.length - 1);
        c.a().submit(m.a());
        this.f26a = null;
    }

    /* renamed from: e  reason: collision with other method in class */
    private void m16e() {
        int i10 = this.f27e;
        this.f27e = i10 < f.f19a.length + -1 ? i10 + 1 : 0;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized void a(android.content.Context r8, java.lang.String r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = f4992d     // Catch:{ Exception -> 0x0078 }
            if (r0 != 0) goto L_0x007c
            java.lang.Class<com.alibaba.sdk.android.httpdns.n> r0 = com.alibaba.sdk.android.httpdns.n.class
            monitor-enter(r0)     // Catch:{ Exception -> 0x0078 }
            boolean r1 = f4992d     // Catch:{ all -> 0x0073 }
            if (r1 != 0) goto L_0x0071
            r7.setAccountId(r9)     // Catch:{ all -> 0x0073 }
            r9 = 0
            if (r8 == 0) goto L_0x001a
            java.lang.String r1 = "httpdns_config_cache"
            android.content.SharedPreferences r8 = r8.getSharedPreferences(r1, r9)     // Catch:{ all -> 0x0073 }
            r7.f25a = r8     // Catch:{ all -> 0x0073 }
        L_0x001a:
            android.content.SharedPreferences r8 = r7.f25a     // Catch:{ all -> 0x0073 }
            java.lang.String r1 = "httpdns_first_start"
            r2 = 1
            boolean r8 = r8.getBoolean(r1, r2)     // Catch:{ all -> 0x0073 }
            r7.f28e = r8     // Catch:{ all -> 0x0073 }
            android.content.SharedPreferences r8 = r7.f25a     // Catch:{ all -> 0x0073 }
            java.lang.String r1 = "httpdns_server_ips"
            r3 = 0
            java.lang.String r8 = r8.getString(r1, r3)     // Catch:{ all -> 0x0073 }
            f4995h = r8     // Catch:{ all -> 0x0073 }
            android.content.SharedPreferences r8 = r7.f25a     // Catch:{ all -> 0x0073 }
            java.lang.String r1 = "httpdns_region"
            java.lang.String r8 = r8.getString(r1, r3)     // Catch:{ all -> 0x0073 }
            r7.f4998i = r8     // Catch:{ all -> 0x0073 }
            java.lang.String r8 = f4995h     // Catch:{ all -> 0x0073 }
            if (r8 == 0) goto L_0x0047
            java.lang.String r1 = ";"
            java.lang.String[] r8 = r8.split(r1)     // Catch:{ all -> 0x0073 }
            com.alibaba.sdk.android.httpdns.f.a((java.lang.String[]) r8)     // Catch:{ all -> 0x0073 }
        L_0x0047:
            android.content.SharedPreferences r8 = r7.f25a     // Catch:{ all -> 0x0073 }
            java.lang.String r1 = "schedule_center_last_request_time"
            r3 = 0
            long r5 = r8.getLong(r1, r3)     // Catch:{ all -> 0x0073 }
            f4993e = r5     // Catch:{ all -> 0x0073 }
            int r8 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r8 == 0) goto L_0x0065
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0073 }
            long r5 = f4993e     // Catch:{ all -> 0x0073 }
            long r3 = r3 - r5
            r5 = 86400000(0x5265c00, double:4.2687272E-316)
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 < 0) goto L_0x006f
        L_0x0065:
            com.alibaba.sdk.android.httpdns.t r8 = com.alibaba.sdk.android.httpdns.t.a()     // Catch:{ all -> 0x0073 }
            r8.c(r9)     // Catch:{ all -> 0x0073 }
            r7.c()     // Catch:{ all -> 0x0073 }
        L_0x006f:
            f4992d = r2     // Catch:{ all -> 0x0073 }
        L_0x0071:
            monitor-exit(r0)     // Catch:{ all -> 0x0073 }
            goto L_0x007c
        L_0x0073:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0073 }
            throw r8     // Catch:{ Exception -> 0x0078 }
        L_0x0076:
            r8 = move-exception
            goto L_0x007e
        L_0x0078:
            r8 = move-exception
            r8.printStackTrace()     // Catch:{ all -> 0x0076 }
        L_0x007c:
            monitor-exit(r7)
            return
        L_0x007e:
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.n.a(android.content.Context, java.lang.String):void");
    }

    public synchronized void c(Throwable th) {
        try {
            f24h = false;
            d(th);
            if (this.f28e) {
                f();
            } else {
                if (!this.f30f) {
                    e();
                }
                if (this.f27e == 0) {
                    this.f30f = true;
                    if (this.f32g) {
                        this.f32g = false;
                        this.f4997f = 0;
                        i.d("StartIp Scheduler center update from StartIp");
                        m.a().a(f.f4976b.length - 1);
                        c.a().submit(m.a());
                    } else {
                        f();
                        if (this.f4997f == 0) {
                            this.f29f = System.currentTimeMillis();
                            i.f("StartIp Scheduler center update failed");
                            u.j();
                        }
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return;
    }

    private void d(Throwable th) {
        try {
            b a10 = b.a();
            if (a10 != null) {
                int a11 = c.a(th);
                a10.a(d(), String.valueOf(a11), th.getMessage(), c.a());
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public synchronized void a(o oVar, long j10) {
        try {
            a(d(), j10);
            this.f27e = 0;
            this.f4997f = 0;
            this.f30f = false;
            this.f32g = true;
            HttpDns.switchDnsService(oVar.isEnabled());
            if (a(oVar.b())) {
                i.d("StartIp Scheduler center update success    StartIp isFirstStart：" + this.f28e);
                f24h = true;
                this.f29f = System.currentTimeMillis();
                u.i();
                if (this.f28e) {
                    SharedPreferences.Editor edit = this.f25a.edit();
                    edit.putBoolean("httpdns_first_start", false);
                    edit.commit();
                    this.f28e = false;
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return;
    }

    private void a(String str, long j10) {
        try {
            b a10 = b.a();
            if (a10 != null) {
                a10.a(str, j10, c.a());
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public synchronized boolean a(String[] strArr) {
        try {
            if (!f.a(strArr)) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            for (String append : strArr) {
                sb.append(append);
                sb.append(";");
            }
            sb.deleteCharAt(sb.length() - 1);
            SharedPreferences sharedPreferences = this.f25a;
            if (sharedPreferences == null) {
                return false;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("httpdns_server_ips", sb.toString());
            edit.putLong("schedule_center_last_request_time", System.currentTimeMillis());
            edit.commit();
            return true;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }
}
