package com.umeng.pagesdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Choreographer;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    float f16147a = 1000.0f;

    /* renamed from: b  reason: collision with root package name */
    long f16148b;

    /* renamed from: c  reason: collision with root package name */
    int f16149c;

    /* renamed from: d  reason: collision with root package name */
    int f16150d;

    /* renamed from: e  reason: collision with root package name */
    int f16151e = 6;

    /* renamed from: f  reason: collision with root package name */
    Map<String, Double> f16152f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    boolean f16153g;

    /* renamed from: h  reason: collision with root package name */
    long f16154h;

    /* renamed from: i  reason: collision with root package name */
    long f16155i = 300000;

    /* renamed from: j  reason: collision with root package name */
    String f16156j;

    /* renamed from: k  reason: collision with root package name */
    private Context f16157k;

    /* renamed from: l  reason: collision with root package name */
    private Choreographer.FrameCallback f16158l = new Choreographer.FrameCallback() {
        public final void doFrame(long j10) {
            String str = PageManger.TAG;
            c cVar = c.this;
            if (cVar.f16153g) {
                if (cVar.f16154h == 0) {
                    cVar.f16154h = System.currentTimeMillis();
                }
                long currentTimeMillis = System.currentTimeMillis();
                c cVar2 = c.this;
                if (currentTimeMillis - cVar2.f16154h > cVar2.f16155i) {
                    cVar2.b();
                    return;
                }
                if (cVar2.f16148b == 0) {
                    cVar2.f16148b = j10;
                }
                float f10 = ((float) (j10 - cVar2.f16148b)) / 1000000.0f;
                if (f10 > cVar2.f16147a) {
                    double d10 = (double) (((long) cVar2.f16149c) * 1000);
                    double d11 = (double) f10;
                    Double.isNaN(d10);
                    Double.isNaN(d11);
                    double d12 = d10 / d11;
                    cVar2.f16149c = 0;
                    cVar2.f16148b = 0;
                    if (PageManger.isDebug) {
                        StringBuilder sb = new StringBuilder("doFrame: ");
                        sb.append(d12);
                        sb.append(", map size is ");
                        sb.append(c.this.f16152f.size());
                        sb.append(", page is ");
                        sb.append(c.this.f16156j);
                    }
                    Map<String, Double> map = c.this.f16152f;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(System.currentTimeMillis());
                    map.put(sb2.toString(), Double.valueOf(d12));
                    c cVar3 = c.this;
                    int i10 = cVar3.f16150d + 1;
                    cVar3.f16150d = i10;
                    if (i10 >= cVar3.f16151e) {
                        cVar3.c();
                        c cVar4 = c.this;
                        cVar4.f16150d = 0;
                        Map<String, Double> map2 = cVar4.f16152f;
                        if (map2 != null) {
                            map2.clear();
                        }
                    }
                } else {
                    cVar2.f16149c++;
                }
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    };

    public c(Context context) {
        SharedPreferences sharedPreferences;
        this.f16157k = context;
        if (context != null && (sharedPreferences = context.getSharedPreferences("efs_page", 0)) != null) {
            this.f16147a = sharedPreferences.getFloat(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL, 1000.0f);
            this.f16151e = sharedPreferences.getInt(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL_TOGETHER, 6);
            this.f16155i = sharedPreferences.getLong(PageConfigManger.APM_FPSPERF_COLLECT_MAX_PERIOD_SEC, 300000);
            if (PageManger.isDebug) {
                StringBuilder sb = new StringBuilder("init fps. diff is ");
                sb.append(this.f16147a);
                sb.append(", count diff is ");
                sb.append(this.f16151e);
                sb.append(", dlealt time is ");
                sb.append(this.f16155i);
            }
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        a a10;
        Iterator<Map.Entry<String, Double>> it = this.f16152f.entrySet().iterator();
        if (it != null) {
            JSONArray jSONArray = null;
            boolean z10 = false;
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (next != null) {
                    if (jSONArray == null) {
                        jSONArray = new JSONArray();
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (PageManger.getRefreshRate() > 0.0f) {
                            double doubleValue = ((Double) next.getValue()).doubleValue();
                            double refreshRate = (double) PageManger.getRefreshRate();
                            Double.isNaN(refreshRate);
                            if (doubleValue < refreshRate * 1.1d) {
                                jSONObject.put(((String) next.getKey()), next.getValue());
                                if (((Double) next.getValue()).doubleValue() < 40.0d) {
                                    z10 = true;
                                }
                            }
                        }
                    } catch (JSONException e10) {
                        e10.printStackTrace();
                    }
                    jSONArray.put(jSONObject);
                }
            }
            if (jSONArray != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("pN", this.f16156j);
                    jSONObject2.put("pF", jSONArray);
                    if (z10 && (a10 = b.a(this.f16157k).a()) != null) {
                        jSONObject2.put("te", a10.f16137c);
                        jSONObject2.put("le", a10.f16135a);
                    }
                    EfsJSONLog efsJSONLog = new EfsJSONLog("fpsperf");
                    efsJSONLog.put("fps", jSONObject2);
                    EfsReporter reporter = PageManger.getReporter();
                    if (reporter != null) {
                        reporter.send(efsJSONLog);
                    }
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public final void a() {
        if (this.f16153g) {
            String str = PageManger.TAG;
            return;
        }
        this.f16153g = true;
        if (PageManger.isDebug) {
            new StringBuilder("start, page is ").append(this.f16156j);
        }
        Choreographer.getInstance().removeFrameCallback(this.f16158l);
        Choreographer.getInstance().postFrameCallback(this.f16158l);
    }

    public final void b() {
        if (PageManger.isDebug) {
            new StringBuilder("stop, page is ").append(this.f16156j);
        }
        c();
        this.f16153g = false;
        this.f16154h = 0;
        this.f16148b = 0;
        this.f16149c = 0;
        Map<String, Double> map = this.f16152f;
        if (map != null) {
            map.clear();
        }
        this.f16150d = 0;
    }
}
