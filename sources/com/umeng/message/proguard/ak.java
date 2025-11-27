package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.umeng.ccg.a;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.api.UPushInAppMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.proguard.ao;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ak extends al {

    /* renamed from: e  reason: collision with root package name */
    private static final ak f15369e = new ak();

    /* renamed from: a  reason: collision with root package name */
    private Future<?> f15370a;

    /* renamed from: b  reason: collision with root package name */
    private Future<?> f15371b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final am f15372c = new am();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final an f15373d = new an();

    private ak() {
    }

    public final an c() {
        return this.f15373d;
    }

    public final void b() {
        if (!this.f15373d.a() && !this.f15372c.f15383a) {
            Future<?> future = this.f15370a;
            if (future == null || future.isDone() || future.isCancelled()) {
                long e10 = u.e();
                long j10 = this.f15373d.f15391c;
                long j11 = 500;
                if (e10 < j10) {
                    long j12 = j10 - e10;
                    if (j12 >= 500) {
                        j11 = j12;
                    }
                }
                this.f15370a = b.a(new Runnable() {
                    public final void run() {
                        boolean z10;
                        boolean z11;
                        boolean z12;
                        try {
                            ap a10 = ak.this.f15372c.a();
                            if (a10 != null && u.c()) {
                                final MessageSharedPrefs instance = MessageSharedPrefs.getInstance(y.a());
                                if (instance.s() >= instance.f15211b.b("ia_count", 0)) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                if (z10) {
                                    UPLog.i("Pop", "count not allow");
                                    return;
                                }
                                long j10 = 0;
                                if (Math.abs(System.currentTimeMillis() - instance.f15211b.b("ia_last", 0)) < instance.r()) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                if (z11) {
                                    UPLog.i("Pop", "ttl not allow");
                                    long r10 = instance.r() - Math.abs(System.currentTimeMillis() - instance.f15211b.b("ia_last", 0));
                                    if (!ak.this.f15372c.f15383a) {
                                        ak.this.a(r10);
                                        return;
                                    }
                                    return;
                                }
                                Activity d10 = u.d();
                                if (d10 != null) {
                                    if (!d10.isFinishing()) {
                                        an a11 = ak.this.f15373d;
                                        String name = d10.getClass().getName();
                                        String[] strArr = a11.f15396h;
                                        if (strArr != null) {
                                            int length = strArr.length;
                                            int i10 = 0;
                                            while (true) {
                                                if (i10 >= length) {
                                                    break;
                                                } else if (TextUtils.equals(strArr[i10], name)) {
                                                    z12 = true;
                                                    break;
                                                } else {
                                                    i10++;
                                                }
                                            }
                                        }
                                        z12 = false;
                                        if (z12) {
                                            UPLog.i("Pop", "trigger activity name not match ", d10.getClass().getName());
                                            return;
                                        }
                                        UPushInAppMessageHandler inAppMessageHandler = v.a().getInAppMessageHandler();
                                        if (inAppMessageHandler == null || inAppMessageHandler.canShowMessage(y.a(), a10.f15401a)) {
                                            ao.a(d10, a10, new ao.a() {
                                                public final void a(ap apVar, boolean z10) {
                                                    if (z10) {
                                                        ak.this.f15372c.b(apVar);
                                                        MessageSharedPrefs messageSharedPrefs = instance;
                                                        messageSharedPrefs.f15211b.a("ia_latest_ts", apVar.f15401a.getMsgTime());
                                                        instance.f15211b.a("ia_last", System.currentTimeMillis());
                                                        MessageSharedPrefs messageSharedPrefs2 = instance;
                                                        Calendar instance = Calendar.getInstance();
                                                        int i10 = instance.get(1);
                                                        int i11 = instance.get(6);
                                                        messageSharedPrefs2.f15211b.a("ia_times", String.format(Locale.getDefault(), "%d.%d.%d", new Object[]{Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(instance.s() + 1)}));
                                                        if (!ak.this.f15372c.f15383a) {
                                                            ak akVar = ak.this;
                                                            akVar.a(Math.max(akVar.f15373d.f15392d, ak.this.f15373d.f15389a));
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    UPLog.i("Pop", "trigger not show msgId:", apVar.f15401a.getMsgId());
                                                    long currentTimeMillis = System.currentTimeMillis() - instance.q();
                                                    if (currentTimeMillis >= ak.this.f15373d.f15389a) {
                                                        currentTimeMillis = 0;
                                                    }
                                                    ak akVar2 = ak.this;
                                                    akVar2.a(Math.max(akVar2.f15373d.f15392d, ak.this.f15373d.f15389a) - currentTimeMillis);
                                                }
                                            });
                                            return;
                                        }
                                        ak.this.f15372c.b(a10);
                                        UPLog.i("Pop", "show allowed: false. msgId:", a10.f15401a.getMsgId());
                                        inAppMessageHandler.onMessageIgnored(y.a(), a10.f15401a);
                                        long currentTimeMillis = System.currentTimeMillis() - instance.q();
                                        if (currentTimeMillis < ak.this.f15373d.f15389a) {
                                            j10 = currentTimeMillis;
                                        }
                                        ak akVar = ak.this;
                                        akVar.a(Math.max(akVar.f15373d.f15392d, ak.this.f15373d.f15389a) - j10);
                                        return;
                                    }
                                }
                                UPLog.i("Pop", "trigger activity finish");
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }, j11, TimeUnit.MILLISECONDS);
                UPLog.i("Pop", "trigger msg task delay:", Long.valueOf(j11));
            }
        }
    }

    public static al a() {
        return f15369e;
    }

    public final void a(final Context context) {
        b.b(new Runnable() {
            public final void run() {
                try {
                    if (ak.this.f15373d.a()) {
                        String b10 = MessageSharedPrefs.getInstance(context).f15211b.b("ia_cfg", (String) null);
                        if (b10 != null && b10.length() > 0) {
                            b10 = new String(bf.a(b10));
                        }
                        if (b10 != null && b10.length() > 0) {
                            UPLog.i("Pop", "init config", b10);
                            ak.this.f15373d.a(new JSONObject(b10));
                            MessageSharedPrefs instance = MessageSharedPrefs.getInstance(y.a());
                            instance.b(ak.this.f15373d.f15390b);
                            instance.b(ak.this.f15373d.f15392d);
                        }
                    }
                    ak.this.f15372c.b();
                } catch (Throwable unused) {
                }
            }
        });
    }

    public final void a(Activity activity) {
        ao.a(activity);
    }

    public final void a(ap apVar) {
        try {
            if (this.f15373d.a()) {
                this.f15372c.a(apVar);
                UPLog.i("Pop", "config empty. cached");
                return;
            }
            this.f15372c.a(apVar);
            a(500);
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public void a(long j10) {
        if (j10 < 500) {
            j10 = 500;
        }
        Future<?> future = this.f15371b;
        if (future != null && !future.isDone() && !future.isCancelled()) {
            future.cancel(false);
        }
        AnonymousClass3 r02 = new Runnable() {
            public final void run() {
                if (u.c() && u.d() != null) {
                    ak.this.b();
                }
            }
        };
        UPLog.i("Pop", "check delay:", Long.valueOf(j10));
        this.f15371b = b.a(r02, j10, TimeUnit.MILLISECONDS);
    }

    public final void a(String str) {
        ao.a(str);
        am amVar = this.f15372c;
        ap a10 = amVar.a(str);
        boolean b10 = a10 != null ? amVar.b(a10) : false;
        Object[] objArr = new Object[3];
        objArr[0] = "recall";
        objArr[1] = str;
        objArr[2] = b10 ? "success" : "not exist";
        UPLog.i("Pop", objArr);
    }

    public final void a(final String str, final Object obj) {
        b.b(new Runnable() {
            public final void run() {
                JSONObject optJSONObject;
                JSONArray optJSONArray;
                MessageSharedPrefs instance = MessageSharedPrefs.getInstance(y.a());
                try {
                    Object obj = obj;
                    if (obj instanceof JSONObject) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (jSONObject.length() != 0 && (optJSONObject = jSONObject.optJSONObject(a.f14508a)) != null) {
                            UPLog.i("Pop", "tag:", str);
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("push_inapp");
                            if (optJSONObject2 != null && (optJSONArray = optJSONObject2.optJSONArray(a.f14519l)) != null) {
                                if (optJSONArray.length() != 0) {
                                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(0);
                                    if (optJSONObject3 != null) {
                                        UPLog.i("Pop", "config:", optJSONObject3);
                                        String jSONObject2 = optJSONObject3.toString();
                                        if (jSONObject2 != null && jSONObject2.length() > 0) {
                                            jSONObject2 = bf.a(jSONObject2.getBytes());
                                        } else if (jSONObject2 == null) {
                                            jSONObject2 = "";
                                        }
                                        instance.f15211b.a("ia_cfg", jSONObject2);
                                        ak.this.f15373d.a(optJSONObject3);
                                        instance.b(ak.this.f15373d.f15390b);
                                        instance.b(ak.this.f15373d.f15392d);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
