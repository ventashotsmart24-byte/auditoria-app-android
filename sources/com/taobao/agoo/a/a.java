package com.taobao.agoo.a;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.client.b;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.analytics.pro.bt;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.android.agoo.common.Config;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {
    public static final String SP_AGOO_BIND_FILE_NAME = "AGOO_BIND";

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentMap<String, Integer> f13254a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private String f13255b;

    /* renamed from: c  reason: collision with root package name */
    private long f13256c;

    /* renamed from: d  reason: collision with root package name */
    private Context f13257d;

    public a(Context context) {
        if (context != null) {
            this.f13257d = context.getApplicationContext();
            return;
        }
        throw new RuntimeException("Context is null!!");
    }

    public void a(String str) {
        Integer num = this.f13254a.get(str);
        if (num == null || num.intValue() != 2) {
            this.f13254a.put(str, 2);
            b.a(this.f13257d, "AGOO_BIND", this.f13256c, this.f13254a);
        }
    }

    public boolean b(String str) {
        if (this.f13254a.isEmpty()) {
            b();
        }
        Integer num = this.f13254a.get(str);
        ALog.i("AgooBindCache", "isAgooRegistered", Constants.KEY_PACKAGE_NAME, str, "appStatus", num, "agooBindStatus", this.f13254a);
        if (!UtilityImpl.a(Config.PREFERENCES, this.f13257d) && num != null && num.intValue() == 2) {
            return true;
        }
        return false;
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f13255b = str;
        }
    }

    public boolean d(String str) {
        String str2 = this.f13255b;
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        return true;
    }

    public void a() {
        this.f13255b = null;
    }

    private void b() {
        try {
            String string = this.f13257d.getSharedPreferences("AGOO_BIND", 0).getString("bind_status", (String) null);
            if (TextUtils.isEmpty(string)) {
                ALog.w("AgooBindCache", "restoreAgooClients packs null return", new Object[0]);
                return;
            }
            JSONArray jSONArray = new JSONArray(string);
            this.f13256c = jSONArray.getLong(0);
            long currentTimeMillis = System.currentTimeMillis();
            long j10 = this.f13256c;
            if (currentTimeMillis < 86400000 + j10) {
                for (int i10 = 1; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    this.f13254a.put(jSONObject.getString(bt.aD), Integer.valueOf(jSONObject.getInt("s")));
                }
                ALog.i("AgooBindCache", "restoreAgooClients", "mAgooBindStatus", this.f13254a);
                return;
            }
            ALog.i("AgooBindCache", "restoreAgooClients expired", "agooLastFlushTime", Long.valueOf(j10));
            this.f13256c = 0;
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
