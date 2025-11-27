package com.umeng.message.proguard;

import com.hpplay.a.a.a.d;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.bx;
import org.json.JSONObject;

public final class ck {

    /* renamed from: a  reason: collision with root package name */
    public final bx.c f15605a;

    /* renamed from: b  reason: collision with root package name */
    public final JSONObject f15606b;

    /* renamed from: c  reason: collision with root package name */
    public String f15607c;

    /* renamed from: d  reason: collision with root package name */
    public final int f15608d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f15609e;

    /* renamed from: f  reason: collision with root package name */
    public int f15610f;

    /* renamed from: g  reason: collision with root package name */
    public int f15611g;

    /* renamed from: h  reason: collision with root package name */
    public int f15612h;

    /* renamed from: i  reason: collision with root package name */
    public long f15613i;

    /* renamed from: j  reason: collision with root package name */
    public long f15614j;

    /* renamed from: k  reason: collision with root package name */
    public long f15615k;

    /* renamed from: l  reason: collision with root package name */
    public long f15616l;

    /* renamed from: m  reason: collision with root package name */
    public float f15617m;

    /* renamed from: n  reason: collision with root package name */
    public float f15618n;

    /* renamed from: o  reason: collision with root package name */
    public float f15619o;

    /* renamed from: p  reason: collision with root package name */
    public float f15620p;

    /* renamed from: q  reason: collision with root package name */
    public float f15621q;

    /* renamed from: r  reason: collision with root package name */
    public float f15622r;

    /* renamed from: s  reason: collision with root package name */
    public float f15623s;

    /* renamed from: t  reason: collision with root package name */
    public float f15624t;

    public ck(JSONObject jSONObject) {
        this.f15610f = -1;
        this.f15611g = -1;
        this.f15612h = -1;
        this.f15613i = -1;
        this.f15614j = -1;
        this.f15615k = -1;
        this.f15616l = -1;
        this.f15617m = -1.0f;
        this.f15618n = -1.0f;
        this.f15619o = -1.0f;
        this.f15620p = -1.0f;
        this.f15621q = -1.0f;
        this.f15622r = -1.0f;
        this.f15623s = -1.0f;
        this.f15624t = -1.0f;
        this.f15606b = jSONObject;
        this.f15608d = jSONObject.optInt(Constants.KEY_HTTP_CODE, -1);
        this.f15605a = bt.a(this);
        int a10 = bs.a(a());
        boolean z10 = false;
        if (a10 != 0) {
            if (a10 == bs.f15536e || a10 == bs.f15537f) {
                z10 = true;
            }
        }
        this.f15609e = z10;
    }

    public final int a() {
        return this.f15606b.optInt("style", -1);
    }

    public final String b() {
        return this.f15606b.optString("image");
    }

    public final String c() {
        return this.f15606b.optString("sid");
    }

    public final String d() {
        return this.f15606b.optString("title");
    }

    public final String e() {
        return this.f15606b.optString("content");
    }

    public final boolean f() {
        if (this.f15606b.optInt("ic", 0) == 1) {
            return true;
        }
        return false;
    }

    public final boolean g() {
        if (this.f15606b.optInt("h5_in_app", 1) == 1) {
            return true;
        }
        return false;
    }

    public final int h() {
        return Math.max(d.SOCKET_READ_TIMEOUT, this.f15606b.optInt("imp_jg", d.SOCKET_READ_TIMEOUT));
    }

    public final long i() {
        return this.f15606b.optLong("exposed_duration", -1);
    }

    public final String j() {
        return this.f15606b.optString("pkg_name");
    }

    public final int k() {
        return this.f15606b.optInt("after_clk");
    }

    public final String l() {
        return this.f15606b.optString("v_url");
    }

    public ck(bx.c cVar, String str) {
        this.f15610f = -1;
        this.f15611g = -1;
        this.f15612h = -1;
        this.f15613i = -1;
        this.f15614j = -1;
        this.f15615k = -1;
        this.f15616l = -1;
        this.f15617m = -1.0f;
        this.f15618n = -1.0f;
        this.f15619o = -1.0f;
        this.f15620p = -1.0f;
        this.f15621q = -1.0f;
        this.f15622r = -1.0f;
        this.f15623s = -1.0f;
        this.f15624t = -1.0f;
        this.f15606b = new JSONObject();
        this.f15605a = cVar;
        this.f15608d = -1;
        this.f15607c = str;
        this.f15609e = false;
    }
}
