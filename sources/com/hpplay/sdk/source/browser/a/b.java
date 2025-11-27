package com.hpplay.sdk.source.browser.a;

import com.hpplay.common.log.LeLog;
import com.hpplay.sdk.source.common.global.Constant;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class b {

    /* renamed from: c  reason: collision with root package name */
    private static final String f11596c = "ResPositionBean";

    /* renamed from: a  reason: collision with root package name */
    public int f11597a;

    /* renamed from: b  reason: collision with root package name */
    public List<a> f11598b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f11599a;

        /* renamed from: b  reason: collision with root package name */
        public String f11600b;

        /* renamed from: c  reason: collision with root package name */
        public String f11601c;

        /* renamed from: d  reason: collision with root package name */
        public int f11602d;

        /* renamed from: e  reason: collision with root package name */
        public int f11603e;

        /* renamed from: f  reason: collision with root package name */
        public int f11604f;

        /* renamed from: g  reason: collision with root package name */
        public int f11605g;

        /* renamed from: h  reason: collision with root package name */
        public String f11606h;

        /* renamed from: i  reason: collision with root package name */
        public String f11607i;

        /* renamed from: j  reason: collision with root package name */
        public String f11608j;
    }

    public static b a(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f11597a = jSONObject.optInt(Constant.KEY_STATUS);
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null) {
                if (optJSONArray.length() > 0) {
                    bVar.f11598b = new ArrayList();
                    int length = optJSONArray.length();
                    for (int i10 = 0; i10 < length; i10++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                        if (optJSONObject != null) {
                            a aVar = new a();
                            aVar.f11599a = optJSONObject.optString("sourceId");
                            aVar.f11600b = optJSONObject.optString("button");
                            aVar.f11601c = optJSONObject.optString("imageUrl");
                            aVar.f11602d = optJSONObject.optInt("noadTime");
                            aVar.f11603e = optJSONObject.optInt("adStasecond");
                            aVar.f11604f = optJSONObject.optInt("adEndsecond");
                            aVar.f11605g = optJSONObject.optInt("id");
                            aVar.f11606h = optJSONObject.optString(f.X);
                            aVar.f11607i = optJSONObject.optString("sourceName");
                            aVar.f11608j = optJSONObject.optString("url");
                            bVar.f11598b.add(aVar);
                        }
                    }
                    return bVar;
                }
            }
            return bVar;
        } catch (Exception unused) {
            LeLog.w(f11596c, "formJson failed: " + str);
        }
    }
}
