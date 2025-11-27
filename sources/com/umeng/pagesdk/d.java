package com.umeng.pagesdk;

import android.text.TextUtils;
import android.util.Log;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.pagesdk.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, Map> f16160a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static c f16161b;

    private static void a(String str) {
        Map map;
        if (!TextUtils.isEmpty(str) && (map = f16160a.get(str)) != null && (r0 = map.entrySet().iterator()) != null) {
            JSONArray jSONArray = null;
            for (Map.Entry entry : map.entrySet()) {
                if (entry != null) {
                    String str2 = (String) entry.getKey();
                    Long[] lArr = (Long[]) entry.getValue();
                    if (!TextUtils.isEmpty(str2) && lArr != null && lArr.length >= 2) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("mN", str2);
                            jSONObject.put("mBT", lArr[0]);
                            jSONObject.put("mET", lArr[1]);
                            if (jSONArray == null) {
                                jSONArray = new JSONArray();
                            }
                            jSONArray.put(jSONObject);
                        } catch (JSONException e10) {
                            e10.printStackTrace();
                        }
                    }
                }
            }
            if (jSONArray != null) {
                final JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("pN", str);
                    jSONObject2.put("pL", jSONArray);
                    b.a(PageManger.getApplicationContext()).a((b.C0211b) new b.C0211b() {
                        public final void a(a aVar) {
                            try {
                                jSONObject2.put("te", aVar.f16137c);
                                jSONObject2.put("le", aVar.f16135a);
                                EfsJSONLog efsJSONLog = new EfsJSONLog("pageperf");
                                efsJSONLog.put("page", jSONObject2);
                                EfsReporter reporter = PageManger.getReporter();
                                if (reporter != null) {
                                    reporter.send(efsJSONLog);
                                }
                            } catch (Exception e10) {
                                e10.printStackTrace();
                            }
                        }
                    });
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public static void b(String str, String str2, boolean z10) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (PageManger.isDebug) {
                Log.e("PageManger-PageTrace", "tracePageEnd. parameter null!");
            }
        } else if (PageManger.isInit()) {
            PageConfigManger pageConfigManger = PageManger.getPageConfigManger();
            if (pageConfigManger != null && pageConfigManger.enableTracer()) {
                if (z10) {
                    str2 = "UM_".concat(String.valueOf(str2));
                }
                if (f16160a.containsKey(str)) {
                    Map map = f16160a.get(str);
                    if (map != null) {
                        if (map.containsKey(str2)) {
                            Long[] lArr = (Long[]) map.get(str2);
                            if (lArr.length >= 2) {
                                lArr[1] = Long.valueOf(System.currentTimeMillis());
                            }
                            if (str2.equals("UM_onResume")) {
                                if (PageManger.isDebug) {
                                    "tracePageEnd. onResume save data. ".concat(String.valueOf(str));
                                }
                                a(str);
                                if (!TextUtils.isEmpty(str) && f16160a.containsKey(str)) {
                                    f16160a.remove(str);
                                }
                            } else if (str2.equals("UM_onPause")) {
                                if (PageManger.isDebug) {
                                    "tracePageEnd. onPause stop fps. ".concat(String.valueOf(str));
                                }
                                c cVar = f16161b;
                                if (cVar != null) {
                                    cVar.b();
                                    f16161b = null;
                                }
                            }
                        } else if (PageManger.isDebug) {
                            Log.e("PageManger-PageTrace", "tracePageEnd. " + str2 + " non-exist in " + str + " map!");
                        }
                    } else if (PageManger.isDebug) {
                        Log.e("PageManger-PageTrace", "tracePageEnd. " + str + " is null in pageMap!");
                    }
                } else if (str2.equals("UM_onPause")) {
                    if (PageManger.isDebug) {
                        "tracePageEnd. onPause stop fps. ".concat(String.valueOf(str));
                    }
                    c cVar2 = f16161b;
                    if (cVar2 != null) {
                        cVar2.b();
                    }
                }
            } else if (PageManger.isDebug) {
                Log.e("PageManger-PageTrace", "tracePageEnd. not rate!");
            }
        } else if (PageManger.isDebug) {
            Log.e("PageManger-PageTrace", "tracePageEnd. not init!");
        }
    }

    public static void a(String str, String str2, boolean z10) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (PageManger.isDebug) {
                Log.e("PageManger-PageTrace", "tracePageBegin. parameter null!");
            }
        } else if (PageManger.isInit()) {
            PageConfigManger pageConfigManger = PageManger.getPageConfigManger();
            if (pageConfigManger != null && pageConfigManger.enableTracer()) {
                if (z10) {
                    str2 = "UM_".concat(String.valueOf(str2));
                }
                if (f16160a.containsKey(str)) {
                    Map map = f16160a.get(str);
                    if (map != null) {
                        if (!map.containsKey(str2)) {
                            if (PageManger.isDebug) {
                                StringBuilder sb = new StringBuilder("tracePageBegin. begin add method. ");
                                sb.append(str2);
                                sb.append(" - ");
                                sb.append(str);
                            }
                            if (z10 || map.size() <= 6) {
                                Long[] lArr = new Long[2];
                                lArr[0] = Long.valueOf(System.currentTimeMillis());
                                map.put(str2, lArr);
                            } else if (PageManger.isDebug) {
                                Log.e("PageManger-PageTrace", "tracePageBegin. user trace number of transfinite. " + str2 + Operator.Operation.MINUS + str);
                            }
                        }
                    } else if (PageManger.isDebug) {
                        Log.e("PageManger-PageTrace", "tracePageBegin. methodMap null!");
                    }
                } else if (str2.equals("UM_onCreate")) {
                    if (PageManger.isDebug) {
                        StringBuilder sb2 = new StringBuilder("tracePageBegin. begin add onCreate. ");
                        sb2.append(str2);
                        sb2.append(" - ");
                        sb2.append(str);
                    }
                    Long[] lArr2 = new Long[2];
                    lArr2[0] = Long.valueOf(System.currentTimeMillis());
                    HashMap hashMap = new HashMap();
                    hashMap.put(str2, lArr2);
                    f16160a.put(str, hashMap);
                    c cVar = f16161b;
                    if (cVar != null) {
                        cVar.b();
                        c cVar2 = f16161b;
                        cVar2.f16156j = str;
                        cVar2.a();
                        return;
                    }
                    c cVar3 = new c(PageManger.getApplicationContext());
                    f16161b = cVar3;
                    cVar3.f16156j = str;
                    cVar3.a();
                }
            } else if (PageManger.isDebug) {
                Log.e("PageManger-PageTrace", "tracePageBegin. not rate!");
            }
        } else if (PageManger.isDebug) {
            Log.e("PageManger-PageTrace", "tracePageBegin. not init!");
        }
    }
}
