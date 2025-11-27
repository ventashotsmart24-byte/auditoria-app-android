package com.taobao.accs.client;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.umeng.analytics.pro.bt;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f12922a;

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentMap<String, Integer> f12923b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private ConcurrentMap<String, Set<String>> f12924c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    private long f12925d;

    /* renamed from: e  reason: collision with root package name */
    private String f12926e = "ClientManager_";

    /* renamed from: f  reason: collision with root package name */
    private String f12927f = "ACCS_BIND";

    public b(Context context, String str) {
        if (context != null) {
            this.f12926e += str;
            this.f12922a = context.getApplicationContext();
            this.f12927f = "ACCS_BIND" + str;
            a();
            return;
        }
        throw new RuntimeException("Context is null!!");
    }

    public void a(String str) {
        Integer num = this.f12923b.get(str);
        if (num == null || num.intValue() != 2) {
            this.f12923b.put(str, 2);
            a(this.f12922a, this.f12927f, this.f12925d, this.f12923b);
        }
    }

    public void b(String str) {
        Integer num = this.f12923b.get(str);
        if (num == null || num.intValue() != 4) {
            this.f12923b.put(str, 4);
            a(this.f12922a, this.f12927f, this.f12925d, this.f12923b);
        }
    }

    public boolean c(String str) {
        if (this.f12923b.isEmpty()) {
            a();
        }
        Integer num = this.f12923b.get(str);
        ALog.i(this.f12926e, "isAppBinded", "appStatus", num, "mBindStatus", this.f12923b);
        if (num == null || num.intValue() != 2) {
            return false;
        }
        return true;
    }

    public boolean d(String str) {
        Integer num = this.f12923b.get(str);
        if (num == null || num.intValue() != 4) {
            return false;
        }
        return true;
    }

    public void e(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f12924c.remove(str);
            }
        } catch (Exception e10) {
            String str2 = this.f12926e;
            ALog.e(str2, this.f12926e + e10.toString(), new Object[0]);
            e10.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                Set set = this.f12924c.get(str);
                if (set == null) {
                    set = new HashSet();
                }
                set.add(str2);
                this.f12924c.put(str, set);
            }
        } catch (Exception e10) {
            String str3 = this.f12926e;
            ALog.e(str3, this.f12926e + e10.toString(), new Object[0]);
            e10.printStackTrace();
        }
    }

    public boolean b(String str, String str2) {
        Set set;
        try {
            if (!TextUtils.isEmpty(str) && (set = this.f12924c.get(str)) != null && set.contains(str2)) {
                return true;
            }
            return false;
        } catch (Exception e10) {
            String str3 = this.f12926e;
            ALog.e(str3, this.f12926e + e10.toString(), new Object[0]);
            e10.printStackTrace();
        }
    }

    private void a() {
        try {
            String string = this.f12922a.getSharedPreferences(this.f12927f, 0).getString("bind_status", (String) null);
            if (TextUtils.isEmpty(string)) {
                ALog.w(this.f12926e, "restoreClients break as packages null", new Object[0]);
                return;
            }
            JSONArray jSONArray = new JSONArray(string);
            this.f12925d = jSONArray.getLong(0);
            long currentTimeMillis = System.currentTimeMillis();
            long j10 = this.f12925d;
            if (currentTimeMillis < 86400000 + j10) {
                for (int i10 = 1; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    this.f12923b.put(jSONObject.getString(bt.aD), Integer.valueOf(jSONObject.getInt("s")));
                }
                ALog.i(this.f12926e, "restoreClients success", "mBindStatus", this.f12923b);
                return;
            }
            ALog.i(this.f12926e, "restoreClients expired", "lastFlushTime", Long.valueOf(j10));
            this.f12925d = 0;
        } catch (Exception e10) {
            ALog.w(this.f12926e, "restoreClients", e10, new Object[0]);
        }
    }

    public static void a(Context context, String str, long j10, Map<String, Integer> map) {
        try {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            JSONArray jSONArray = new JSONArray();
            if (j10 <= 0 || j10 >= System.currentTimeMillis()) {
                double currentTimeMillis = (double) System.currentTimeMillis();
                double random = Math.random() * 8.64E7d;
                Double.isNaN(currentTimeMillis);
                jSONArray.put(currentTimeMillis - random);
            } else {
                jSONArray.put(j10);
            }
            for (String str2 : strArr) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(bt.aD, str2);
                jSONObject.put("s", map.get(str2).intValue());
                jSONArray.put(jSONObject);
            }
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString("bind_status", jSONArray.toString());
            edit.apply();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
