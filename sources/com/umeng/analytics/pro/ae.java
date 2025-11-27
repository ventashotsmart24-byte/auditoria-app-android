package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.umeng.ccg.a;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ae extends ab {

    /* renamed from: a  reason: collision with root package name */
    private int f13714a;

    /* renamed from: b  reason: collision with root package name */
    private int f13715b;

    /* renamed from: c  reason: collision with root package name */
    private int f13716c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<Pair<String, Integer>> f13717d;

    public ae(String str, ArrayList<ac> arrayList) {
        super(str, arrayList);
    }

    public void a(int i10) {
        this.f13714a = i10;
    }

    public void b(int i10) {
        this.f13715b = i10;
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(new String(ax.a(Base64.decode(str, 0), UMUtils.genSin())));
                int length = jSONArray.length();
                if (length > 0) {
                    this.f13717d = new ArrayList<>();
                }
                for (int i10 = 0; i10 < length; i10++) {
                    String str2 = "";
                    int i11 = 1;
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    if (jSONObject.has("type")) {
                        str2 = jSONObject.optString("type");
                    }
                    if (jSONObject.has(a.B)) {
                        i11 = Integer.valueOf(jSONObject.optInt(a.B));
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        this.f13717d.add(new Pair(str2, i11));
                    }
                }
                this.f13716c = this.f13717d.size();
            } catch (Throwable unused) {
            }
        }
    }

    public int d() {
        return this.f13716c;
    }

    public int e() {
        return this.f13714a;
    }

    public int f() {
        return this.f13715b;
    }

    public ArrayList<Pair<String, Integer>> g() {
        return this.f13717d;
    }

    public String a() {
        return super.a();
    }

    public String b() {
        return super.b();
    }

    public void a(String str) {
        super.a(str);
    }

    public void b(String str) {
        super.b(str);
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                int i10 = this.f13714a;
                int i11 = 0;
                if (i10 == 0) {
                    SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
                    if (a10 != null) {
                        int i12 = a10.getInt(au.f13787h, 0);
                        if (i12 < this.f13716c) {
                            int intValue = ((Integer) this.f13717d.get(i12).second).intValue();
                            jSONObject.put("target", (String) this.f13717d.get(i12).first);
                            jSONObject.put(a.B, intValue);
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "selPoclicy: 0, currIndex: " + i12);
                            if (i12 < this.f13716c - 1) {
                                i11 = i12 + 1;
                            }
                        } else {
                            int intValue2 = ((Integer) this.f13717d.get(0).second).intValue();
                            jSONObject.put("target", (String) this.f13717d.get(0).first);
                            jSONObject.put(a.B, intValue2);
                        }
                        a10.edit().putInt(au.f13787h, i11).commit();
                    }
                } else if (i10 == 1) {
                    int randNumber = DeviceConfig.getRandNumber(0, this.f13716c - 1);
                    int intValue3 = ((Integer) this.f13717d.get(randNumber).second).intValue();
                    jSONObject.put("target", (String) this.f13717d.get(randNumber).first);
                    jSONObject.put(a.B, intValue3);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "selPoclicy: 1, currIndex: " + randNumber);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void b(String str, JSONObject jSONObject) {
        super.b(str, jSONObject);
        if (jSONObject.has(a.f14532y)) {
            a(jSONObject.optInt(a.f14532y));
        }
        if (jSONObject.has(a.f14533z)) {
            b(jSONObject.optInt(a.f14533z));
        }
        if (jSONObject.has(a.f14531x)) {
            c(jSONObject.optString(a.f14531x));
        }
    }

    public String c() {
        return super.c();
    }

    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject a10 = super.a(str, jSONObject);
        if (this.f13716c == 0) {
            return null;
        }
        if (jSONObject != null) {
            try {
                a10.put(a.f14533z, this.f13715b);
                a10.put(a.f14532y, this.f13714a);
                int optInt = jSONObject.optInt(a.f14517j);
                if (this.f13715b == 0 && optInt == 202) {
                    a(a10);
                }
                if (this.f13715b == 1 && optInt == 304) {
                    a(a10);
                }
            } catch (Throwable unused) {
            }
        }
        return a10;
    }
}
