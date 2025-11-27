package com.umeng.message.proguard;

import com.hpplay.cybergarage.http.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

public final class an {

    /* renamed from: a  reason: collision with root package name */
    long f15389a;

    /* renamed from: b  reason: collision with root package name */
    int f15390b;

    /* renamed from: c  reason: collision with root package name */
    long f15391c;

    /* renamed from: d  reason: collision with root package name */
    long f15392d;

    /* renamed from: e  reason: collision with root package name */
    long f15393e;

    /* renamed from: f  reason: collision with root package name */
    boolean f15394f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15395g;

    /* renamed from: h  reason: collision with root package name */
    String[] f15396h;

    /* renamed from: i  reason: collision with root package name */
    private volatile boolean f15397i;

    public final boolean a() {
        return !this.f15397i;
    }

    public final synchronized void a(JSONObject jSONObject) {
        this.f15389a = jSONObject.optLong("duration") * 1000;
        this.f15390b = jSONObject.optInt("count");
        this.f15391c = jSONObject.optLong("delay") * 1000;
        this.f15392d = jSONObject.optLong("ttl") * 60 * 1000;
        this.f15393e = jSONObject.optLong("valid") * 60 * 1000;
        this.f15394f = jSONObject.optInt(HTTP.CLOSE, 0) == 1;
        this.f15395g = jSONObject.optInt("swipe", 1) == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray("activity");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.f15396h = new String[optJSONArray.length()];
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                this.f15396h[i10] = optJSONArray.optString(i10);
            }
        }
        this.f15397i = true;
    }
}
