package com.umeng.logsdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.observer.IConfigCallback;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public class ULogConfigManager {

    /* renamed from: a  reason: collision with root package name */
    private final String f15162a = "ULogConfigManager";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f15163b;

    /* renamed from: c  reason: collision with root package name */
    private EfsReporter f15164c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Vector<b> f15165d = new Vector<>();

    public ULogConfigManager(Context context, EfsReporter efsReporter) {
        this.f15163b = context.getApplicationContext();
        this.f15164c = efsReporter;
        if (efsReporter != null) {
            Log.i("ULogConfigManager", "[log register] begin.");
            this.f15164c.getAllSdkConfig(new String[]{a.f15189d, a.f15188c, a.f15192g}, new IConfigCallback() {
                public final void onChange(Map<String, Object> map) {
                    SharedPreferences.Editor edit;
                    String str;
                    String str2;
                    StringBuilder sb;
                    if (map != null) {
                        try {
                            Log.i("ULogConfigManager", "[log register] call back config.");
                            SharedPreferences sharedPreferences = ULogConfigManager.this.f15163b.getSharedPreferences("efs_ulog", 0);
                            if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
                                Object obj = map.get(a.f15189d);
                                String str3 = "";
                                if (obj != null) {
                                    str = obj.toString();
                                    edit.putString(a.f15189d, str);
                                    Log.i("ULogConfigManager", "[log register] save did is ".concat(String.valueOf(str)));
                                } else {
                                    str = str3;
                                }
                                Object obj2 = map.get(a.f15188c);
                                if (obj2 != null) {
                                    String obj3 = obj2.toString();
                                    Log.i("ULogConfigManager", "[log register] save uid before base64 is ".concat(String.valueOf(obj3)));
                                    str2 = c.a(obj3.getBytes());
                                    edit.putString(a.f15188c, str2);
                                    Log.i("ULogConfigManager", "[log register] save uid after base64 is ".concat(String.valueOf(str2)));
                                } else {
                                    str2 = str3;
                                }
                                Object obj4 = map.get(a.f15192g);
                                if (obj4 != null && str2.equals(ULogManager.getUserID()) && str.equals(ULogManager.getDeviceID())) {
                                    String obj5 = obj4.toString();
                                    if (!TextUtils.isEmpty(obj5)) {
                                        JSONArray jSONArray = new JSONArray(obj5);
                                        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                                            JSONObject jSONObject = jSONArray.getJSONObject(i10);
                                            if (jSONObject != null) {
                                                String optString = jSONObject.optString(a.f15193h, a.f15201p);
                                                if (!TextUtils.isEmpty(optString)) {
                                                    if (TextUtils.isEmpty(str3)) {
                                                        sb = new StringBuilder();
                                                        sb.append(str3);
                                                        sb.append(optString);
                                                    } else {
                                                        sb = new StringBuilder();
                                                        sb.append(str3);
                                                        sb.append("_");
                                                        sb.append(optString);
                                                    }
                                                    str3 = sb.toString();
                                                    edit.putString(optString, jSONObject.toString());
                                                    Log.i("ULogConfigManager", "[log register] save task id is " + optString + ", task is " + jSONObject.toString());
                                                    b bVar = new b();
                                                    int optInt = jSONObject.optInt(a.f15194i, -1);
                                                    int optInt2 = jSONObject.optInt(a.f15195j, -1);
                                                    if (optInt == 0) {
                                                        String str4 = optInt2 == 0 ? str2 : optInt2 == 1 ? str : null;
                                                        if (!TextUtils.isEmpty(str4)) {
                                                            bVar.f15203a = optString;
                                                            bVar.f15204b = optInt;
                                                            bVar.f15205c = optInt2;
                                                            bVar.f15206d = str4;
                                                            bVar.f15207e = jSONObject.optLong(a.f15197l, 0);
                                                            bVar.f15208f = jSONObject.optLong(a.f15198m, 0);
                                                            Log.i("ULogConfigManager", "[log register] add mem task id is ".concat(String.valueOf(optString)));
                                                            ULogConfigManager.this.f15165d.add(bVar);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (!TextUtils.isEmpty(str3)) {
                                    edit.putString(a.f15190e, str3);
                                    Log.i("ULogConfigManager", "[log register] save task id set is ".concat(String.valueOf(str3)));
                                }
                                edit.commit();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public List<b> getTaskList() {
        return this.f15165d;
    }

    public void reMoveTaskFroSP(String str) {
        String[] split;
        String str2;
        try {
            Log.i("ULogConfigManager", "[log remove] remove sp. delete task id is ".concat(String.valueOf(str)));
            if (!TextUtils.isEmpty(str)) {
                SharedPreferences sharedPreferences = this.f15163b.getSharedPreferences("efs_ulog", 0);
                if (sharedPreferences != null && sharedPreferences.edit() != null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    String string = sharedPreferences.getString(a.f15189d, "");
                    String string2 = sharedPreferences.getString(a.f15188c, "");
                    String string3 = sharedPreferences.getString(a.f15190e, "");
                    if (string2.equals(ULogManager.getUserID()) && string.equals(ULogManager.getDeviceID()) && !TextUtils.isEmpty(string3) && (split = string3.split("_")) != null) {
                        for (int i10 = 0; i10 < split.length; i10++) {
                            String str3 = split[i10];
                            if (!TextUtils.isEmpty(str3) && str3.equals(str)) {
                                Log.i("ULogConfigManager", "[log remove] taskId is ".concat(str3));
                                if (!string3.equals(str3)) {
                                    if (i10 == split.length - 1) {
                                        str2 = "_".concat(str3);
                                    } else {
                                        str2 = str3 + "_";
                                    }
                                    string3 = string3.replaceFirst(str2, "");
                                } else {
                                    string3 = "";
                                }
                                Log.i("ULogConfigManager", "[log remove] put id set is ".concat(String.valueOf(string3)));
                                edit.putString(a.f15190e, string3);
                                edit.remove(str3);
                                edit.commit();
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeTask(b bVar) {
        Vector<b> vector = this.f15165d;
        if (vector != null && vector.contains(bVar)) {
            Log.i("ULogConfigManager", "[log remove] remove mem. task id is " + bVar.f15203a);
            this.f15165d.remove(bVar);
        }
    }
}
