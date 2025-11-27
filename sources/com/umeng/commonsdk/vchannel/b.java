package com.umeng.commonsdk.vchannel;

import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f15156a = "_$unknown";

    /* renamed from: b  reason: collision with root package name */
    private String f15157b;

    /* renamed from: c  reason: collision with root package name */
    private long f15158c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f15159d = 0;

    /* renamed from: e  reason: collision with root package name */
    private String f15160e = a.f15155j;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, Object> f15161f;

    public b(Context context) {
        this.f15157b = UMGlobalContext.getInstance(context).getProcessName(context);
        this.f15161f = null;
    }

    public String a() {
        return this.f15156a;
    }

    public long b() {
        return this.f15158c;
    }

    public Map<String, Object> c() {
        return this.f15161f;
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f15156a);
            jSONObject.put("pn", this.f15157b);
            jSONObject.put("ds", this.f15159d);
            jSONObject.put("ts", this.f15158c);
            Map<String, Object> map = this.f15161f;
            if (map != null && map.size() > 0) {
                for (String next : this.f15161f.keySet()) {
                    jSONObject.put(next, this.f15161f.get(next));
                }
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(this.f15160e, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ekv", jSONArray2);
            return jSONObject3;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("[");
        sb.append("id:" + this.f15156a + ",");
        sb.append("pn:" + this.f15157b + ",");
        sb.append("ts:" + this.f15158c + ",");
        Map<String, Object> map = this.f15161f;
        if (map != null && map.size() > 0) {
            for (String next : this.f15161f.keySet()) {
                Object obj = this.f15161f.get(next);
                if (obj == null) {
                    str = next + ": null,";
                } else {
                    str = next + ": " + obj.toString() + ",";
                }
                sb.append(str);
            }
        }
        sb.append("ds:" + this.f15159d + "]");
        return sb.toString();
    }

    public void a(String str) {
        this.f15156a = str;
    }

    public void a(long j10) {
        this.f15158c = j10;
    }

    public void a(Map<String, Object> map) {
        this.f15161f = map;
    }
}
