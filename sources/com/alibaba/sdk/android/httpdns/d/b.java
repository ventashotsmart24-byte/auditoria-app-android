package com.alibaba.sdk.android.httpdns.d;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.utils.AlicloudTracker;
import com.alibaba.sdk.android.utils.AlicloudTrackerManager;
import com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.taobao.accs.common.Constants;
import java.util.HashMap;
import java.util.Map;

public class b {

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f4939b;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public AlicloudTracker f4940a = null;

    /* renamed from: a  reason: collision with other field name */
    private AlicloudTrackerManager f15a = null;

    /* renamed from: b  reason: collision with other field name */
    private a f16b = new a();

    /* renamed from: q  reason: collision with root package name */
    private boolean f4941q = true;

    /* renamed from: r  reason: collision with root package name */
    private boolean f4942r = false;

    private b(Context context) {
        if (context != null && (context.getApplicationContext() instanceof Application)) {
            AlicloudTrackerManager instance = AlicloudTrackerManager.getInstance((Application) context.getApplicationContext());
            this.f15a = instance;
            if (instance != null) {
                this.f4940a = instance.getTracker("httpdns", "1.3.2.3-no-bssid-ssid");
            }
        }
    }

    public static b a() {
        return f4939b;
    }

    public void b(String str, int i10, int i11, int i12) {
        String str2;
        if (!this.f4941q) {
            str2 = "report is disabled";
        } else if (this.f4940a == null) {
            Log.e("HttpDns:ReportManager", "report http dns succes failed due to tacker is null");
            return;
        } else if (TextUtils.isEmpty(str) || !((i10 == 0 || i10 == 1) && ((i11 == 0 || i11 == 1) && (i12 == 0 || i12 == 1)))) {
            str2 = "report http dns success failed due to invalid params";
        } else {
            final HashMap hashMap = new HashMap();
            hashMap.put(Constants.KEY_HOST, str);
            hashMap.put("success", String.valueOf(i10));
            hashMap.put("ipv6", String.valueOf(i11));
            hashMap.put("cacheOpen", String.valueOf(i12));
            this.f16b.b().submit(new Runnable() {
                public void run() {
                    try {
                        b.this.f4940a.sendCustomHit("perf_user_getip", hashMap);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            });
            return;
        }
        Log.e("HttpDns:ReportManager", str2);
    }

    public void c(int i10) {
        String str;
        if (!this.f4941q) {
            str = "report is disabled";
        } else if (this.f4940a == null) {
            Log.e("HttpDns:ReportManager", "report cache failed due to tracker is null");
            return;
        } else if (i10 == 0 || i10 == 1) {
            final HashMap hashMap = new HashMap();
            hashMap.put("enable", String.valueOf(i10));
            this.f16b.b().submit(new Runnable() {
                public void run() {
                    try {
                        b.this.f4940a.sendCustomHit("biz_cache", hashMap);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            });
            return;
        } else {
            str = "report cache failed, due to invalid param enable, enable can only be 0 or 1";
        }
        Log.e("HttpDns:ReportManager", str);
    }

    public void d(int i10) {
        String str;
        if (!this.f4941q) {
            str = "report is disabled";
        } else if (this.f4940a == null) {
            Log.e("HttpDns:ReportManager", "report set expired ip enabled failed due to tracker is null");
            return;
        } else if (i10 == 0 || i10 == 1) {
            final HashMap hashMap = new HashMap();
            hashMap.put("enable", String.valueOf(i10));
            this.f16b.b().submit(new Runnable() {
                public void run() {
                    try {
                        b.this.f4940a.sendCustomHit("biz_expired_ip", hashMap);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            });
            return;
        } else {
            str = "report set expired ip enabled failed, due to invalid param enable, enable can only be 0 or 1";
        }
        Log.e("HttpDns:ReportManager", str);
    }

    public void e(int i10) {
        try {
            if (!this.f4941q) {
                Log.e("HttpDns:ReportManager", "report is disabled");
            } else if (this.f4940a == null) {
                Log.e("HttpDns:ReportManager", "report ipv6 failed due to tracker is null");
            } else if (i10 == 0 || i10 == 1) {
                final HashMap hashMap = new HashMap();
                hashMap.put("enable", String.valueOf(i10));
                this.f16b.b().submit(new Runnable() {
                    public void run() {
                        try {
                            b.this.f4940a.sendCustomHit("biz_ipv6_enable", hashMap);
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }
                });
            } else {
                Log.e("HttpDns:ReportManager", "report ipv6 failed, due to invalid param enable, enable can only be 0 or 1");
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void k() {
        synchronized (b.class) {
            this.f4942r = true;
            this.f4941q = false;
        }
    }

    public void l() {
        if (!this.f4941q) {
            Log.e("HttpDns:ReportManager", "report is disabled");
        } else if (this.f4940a != null) {
            this.f16b.b().submit(new Runnable() {
                public void run() {
                    try {
                        b.this.f4940a.sendCustomHit("biz_active", (Map<String, String>) null);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            });
        } else {
            Log.e("HttpDns:ReportManager", "report sdk start failed due to tracker is null");
        }
    }

    public void setAccountId(String str) {
        AlicloudTracker alicloudTracker = this.f4940a;
        if (alicloudTracker != null) {
            alicloudTracker.setGlobalProperty("accountId", str);
        } else {
            Log.e("HttpDns:ReportManager", "tracker null, set global properties failed");
        }
    }

    public static b a(Context context) {
        if (f4939b == null) {
            synchronized (b.class) {
                if (f4939b == null) {
                    f4939b = new b(context);
                }
            }
        }
        return f4939b;
    }

    public void b(String str, long j10, int i10) {
        String str2;
        if (!this.f4941q) {
            str2 = "report is disabled";
        } else if (this.f4940a == null) {
            Log.e("HttpDns:ReportManager", "report http dns request time cost failed due to tacker is null");
            return;
        } else if (TextUtils.isEmpty(str) || j10 <= 0 || !(i10 == 0 || i10 == 1)) {
            str2 = "report http dns request time cost failed due to invalid param";
        } else {
            if (j10 > NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) {
                j10 = 30000;
            }
            final HashMap hashMap = new HashMap();
            hashMap.put("srvAddr", str);
            hashMap.put("cost", String.valueOf(j10));
            hashMap.put("ipv6", String.valueOf(i10));
            this.f16b.b().submit(new Runnable() {
                public void run() {
                    try {
                        b.this.f4940a.sendCustomHit("perf_srv", hashMap);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            });
            return;
        }
        Log.e("HttpDns:ReportManager", str2);
    }

    public void e(boolean z10) {
        synchronized (b.class) {
            if (!this.f4942r) {
                this.f4941q = z10;
            }
        }
    }

    public void k(String str) {
        String str2;
        if (!this.f4941q) {
            str2 = "report is disabled";
        } else if (this.f4940a == null) {
            Log.e("HttpDns:ReportManager", "report uncaught exception failed due to tacker is null");
            return;
        } else if (TextUtils.isEmpty(str)) {
            str2 = "report uncaught exception failed due to exception msg is null";
        } else {
            final HashMap hashMap = new HashMap();
            hashMap.put("exception", str);
            this.f16b.b().submit(new Runnable() {
                public void run() {
                    try {
                        b.this.f4940a.sendCustomHit("err_uncaught_exception", hashMap);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            });
            return;
        }
        Log.e("HttpDns:ReportManager", str2);
    }

    public void b(String str, String str2, String str3) {
        String str4;
        if (!this.f4941q) {
            str4 = "report is disabled";
        } else if (this.f4940a == null) {
            Log.e("HttpDns:ReportManager", "report local disable failed due to tracker is null");
            return;
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            str4 = "report local disable failed due to missing params";
        } else {
            final HashMap hashMap = new HashMap();
            hashMap.put(Constants.KEY_HOST, str);
            hashMap.put("scAddr", str2);
            hashMap.put("srvAddr", str3);
            this.f16b.b().submit(new Runnable() {
                public void run() {
                    try {
                        b.this.f4940a.sendCustomHit("biz_local_disable", hashMap);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            });
            return;
        }
        Log.e("HttpDns:ReportManager", str4);
    }

    public void a(String str, int i10, int i11, int i12) {
        String str2;
        if (!this.f4941q) {
            str2 = "report is disabled";
        } else if (this.f4940a == null) {
            Log.e("HttpDns:ReportManager", "report http dns succes failed due to tacker is null");
            return;
        } else if (TextUtils.isEmpty(str) || !((i10 == 0 || i10 == 1) && ((i11 == 0 || i11 == 1) && (i12 == 0 || i12 == 1)))) {
            str2 = "report http dns success failed due to invalid params";
        } else {
            final HashMap hashMap = new HashMap();
            hashMap.put(Constants.KEY_HOST, str);
            hashMap.put("success", String.valueOf(i10));
            hashMap.put("ipv6", String.valueOf(i11));
            hashMap.put("cacheOpen", String.valueOf(i12));
            this.f16b.b().submit(new Runnable() {
                public void run() {
                    try {
                        b.this.f4940a.sendCustomHit("perf_getip", hashMap);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            });
            return;
        }
        Log.e("HttpDns:ReportManager", str2);
    }

    public void a(String str, long j10, int i10) {
        String str2;
        if (!this.f4941q) {
            str2 = "report is disabled";
        } else if (this.f4940a == null) {
            Log.e("HttpDns:ReportManager", "report sc request time cost failed due to tacker is null");
            return;
        } else if (TextUtils.isEmpty(str) || j10 <= 0 || !(i10 == 0 || i10 == 1)) {
            str2 = "report sc request time cost failed due to invalid params";
        } else {
            if (j10 > NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) {
                j10 = 30000;
            }
            final HashMap hashMap = new HashMap();
            hashMap.put("scAddr", str);
            hashMap.put("cost", String.valueOf(j10));
            hashMap.put("ipv6", String.valueOf(i10));
            this.f16b.b().submit(new Runnable() {
                public void run() {
                    try {
                        b.this.f4940a.sendCustomHit("perf_sc", hashMap);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            });
            return;
        }
        Log.e("HttpDns:ReportManager", str2);
    }

    public void a(String str, String str2, String str3) {
        String str4;
        if (!this.f4941q) {
            str4 = "report is disabled";
        } else if (this.f4940a == null) {
            Log.e("HttpDns:ReportManager", "report sniffer failed due to tracker is null");
            return;
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            str4 = "report sniffer failed due to missing params";
        } else {
            final HashMap hashMap = new HashMap();
            hashMap.put(Constants.KEY_HOST, str);
            hashMap.put("scAddr", str2);
            hashMap.put("srvAddr", str3);
            this.f16b.b().submit(new Runnable() {
                public void run() {
                    try {
                        b.this.f4940a.sendCustomHit("biz_sniffer", hashMap);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            });
            return;
        }
        Log.e("HttpDns:ReportManager", str4);
    }

    public void a(String str, String str2, String str3, int i10) {
        String str4;
        if (!this.f4941q) {
            str4 = "report is disabled";
        } else if (this.f4940a == null) {
            Log.e("HttpDns:ReportManager", "report error sc failed due to tacker is null");
            return;
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || !(i10 == 0 || i10 == 1)) {
            str4 = "report error sc failed, due to invalid params";
        } else {
            final HashMap hashMap = new HashMap();
            hashMap.put("scAddr", str);
            hashMap.put("errCode", str2);
            hashMap.put("errMsg", str3);
            hashMap.put("ipv6", String.valueOf(i10));
            this.f16b.b().submit(new Runnable() {
                public void run() {
                    try {
                        b.this.f4940a.sendCustomHit("err_sc", hashMap);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            });
            return;
        }
        Log.e("HttpDns:ReportManager", str4);
    }

    public void a(String str, String str2, String str3, int i10, int i11) {
        try {
            if (!this.f4941q) {
                Log.e("HttpDns:ReportManager", "report is disabled");
            } else if (this.f4940a != null) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && (i10 == 0 || i10 == 1)) {
                    if (i11 == 0 || i11 == 1) {
                        final HashMap hashMap = new HashMap();
                        hashMap.put("srvAddr", str);
                        hashMap.put("errCode", str2);
                        hashMap.put("errMsg", str3);
                        hashMap.put("ipv6", String.valueOf(i10));
                        hashMap.put("ipv6_srv", String.valueOf(i11));
                        this.f16b.b().submit(new Runnable() {
                            public void run() {
                                try {
                                    b.this.f4940a.sendCustomHit("err_srv", hashMap);
                                } catch (Exception e10) {
                                    e10.printStackTrace();
                                }
                            }
                        });
                        return;
                    }
                }
                Log.e("HttpDns:ReportManager", "report error http dns request failed, due to invalid params");
            } else {
                Log.e("HttpDns:ReportManager", "report error http dns request failed due to tacker is null");
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void a(String str, String str2, String str3, long j10, long j11, int i10) {
        String str4;
        if (!this.f4941q) {
            str4 = "report is disabled";
        } else if (this.f4940a == null) {
            Log.e("HttpDns:ReportManager", "report ip selection failed due to tacker is null");
            return;
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || i10 <= 0) {
            str4 = "report ip selection failed due to invalid params";
        } else {
            if (j10 > 5000) {
                j10 = 5000;
            }
            if (j11 > 5000) {
                j11 = 5000;
            }
            final HashMap hashMap = new HashMap();
            hashMap.put(Constants.KEY_HOST, str);
            hashMap.put("defaultIp", str2);
            hashMap.put("selectedIp", str3);
            hashMap.put("defaultIpCost", String.valueOf(j10));
            hashMap.put("selectedIpCost", String.valueOf(j11));
            hashMap.put("ipCount", String.valueOf(i10));
            this.f16b.b().submit(new Runnable() {
                public void run() {
                    try {
                        b.this.f4940a.sendCustomHit("perf_ipselection", hashMap);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            });
            return;
        }
        Log.e("HttpDns:ReportManager", str4);
    }

    public boolean a(SDKMessageCallback sDKMessageCallback) {
        try {
            AlicloudTrackerManager alicloudTrackerManager = this.f15a;
            if (alicloudTrackerManager != null) {
                return alicloudTrackerManager.registerCrashDefend("httpdns", "1.3.2.3-no-bssid-ssid", 2, 7, sDKMessageCallback);
            }
            return false;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }
}
