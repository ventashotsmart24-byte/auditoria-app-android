package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.ccg.ActionInfo;
import com.umeng.ccg.CcgAgent;
import com.umeng.ccg.a;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.ArrayList;
import org.json.JSONObject;

public class ab implements aj {

    /* renamed from: a  reason: collision with root package name */
    private String f13706a = null;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<ac> f13707b;

    /* renamed from: c  reason: collision with root package name */
    private String f13708c;

    /* renamed from: d  reason: collision with root package name */
    private String f13709d;

    /* renamed from: e  reason: collision with root package name */
    private String f13710e;

    /* renamed from: f  reason: collision with root package name */
    private String f13711f;

    public ab(String str, ArrayList<ac> arrayList) {
        new ArrayList();
        this.f13708c = "";
        this.f13709d = "";
        this.f13710e = "";
        this.f13711f = "";
        this.f13706a = str;
        this.f13707b = arrayList;
    }

    public String a() {
        return this.f13706a;
    }

    public void b(String str, JSONObject jSONObject) {
    }

    public String c() {
        return this.f13709d;
    }

    private String c(String str) {
        String[] split = str.split(",");
        String str2 = "";
        if (split.length <= 0) {
            return str2;
        }
        ArrayList<String> forbidSdkArray = CcgAgent.getForbidSdkArray(this.f13706a);
        if (forbidSdkArray == null || forbidSdkArray.size() <= 0) {
            for (String str3 : split) {
                ActionInfo actionInfo = CcgAgent.getActionInfo(str3);
                if (actionInfo != null) {
                    String[] supportAction = actionInfo.getSupportAction(UMGlobalContext.getAppContext());
                    if (supportAction.length > 0) {
                        int i10 = 0;
                        while (true) {
                            if (i10 >= supportAction.length) {
                                break;
                            } else if (this.f13706a.equals(supportAction[i10])) {
                                str2 = str3;
                                break;
                            } else {
                                i10++;
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            return str2;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return str2;
        }
        this.f13711f = forbidSdkArray.toString();
        for (String str4 : split) {
            if (CcgAgent.getActionInfo(str4) != null && !forbidSdkArray.contains(str4)) {
                return str4;
            }
        }
        return str2;
    }

    public void a(String str) {
        this.f13708c = str;
    }

    public String b() {
        return this.f13708c;
    }

    public JSONObject a(String str, JSONObject jSONObject) {
        try {
            int size = this.f13707b.size();
            if (size == 0) {
                return null;
            }
            for (int i10 = 0; i10 < size; i10++) {
                if (this.f13707b.get(i10).b()) {
                    return null;
                }
            }
            if (CcgAgent.hasRegistedActionInfo() && !TextUtils.isEmpty(this.f13709d)) {
                String c10 = c(this.f13709d);
                this.f13710e = c10;
                if (!TextUtils.isEmpty(c10)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "采集项：" + this.f13706a + "; 选中Module: " + this.f13710e + "; sdk: " + this.f13709d);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "采集项：" + this.f13706a + "; 未选中可用Module ; sdk: " + this.f13709d);
                }
            }
            ac acVar = this.f13707b.get(size - 1);
            if (acVar == null || !(acVar instanceof af)) {
                return null;
            }
            long c11 = acVar.c();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("actionName", this.f13706a);
                jSONObject2.put(a.f14528u, this.f13709d);
                jSONObject2.put(a.f14525r, this.f13708c);
                jSONObject2.put("delay", c11);
                jSONObject2.put(a.f14526s, this.f13710e);
                jSONObject2.put(a.f14527t, this.f13711f);
            } catch (Throwable unused) {
            }
            return jSONObject2;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public void b(String str) {
        this.f13709d = str;
    }
}
