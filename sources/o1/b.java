package o1;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.strategy.utils.d;
import anet.channel.util.ALog;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q1.a;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f8427a = true;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f8428b = true;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f8429c = true;

    /* renamed from: d  reason: collision with root package name */
    public static volatile long f8430d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f8431e = false;

    /* renamed from: f  reason: collision with root package name */
    public static volatile ConcurrentHashMap f8432f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile CopyOnWriteArrayList f8433g;

    /* renamed from: h  reason: collision with root package name */
    public static final List f8434h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public static volatile int f8435i = 10000;

    /* renamed from: j  reason: collision with root package name */
    public static volatile boolean f8436j = true;

    /* renamed from: k  reason: collision with root package name */
    public static volatile boolean f8437k = false;

    /* renamed from: l  reason: collision with root package name */
    public static volatile int f8438l = 60000;

    /* renamed from: m  reason: collision with root package name */
    public static volatile CopyOnWriteArrayList f8439m = null;

    /* renamed from: n  reason: collision with root package name */
    public static volatile ConcurrentHashMap f8440n = null;

    /* renamed from: o  reason: collision with root package name */
    public static volatile boolean f8441o = true;

    /* renamed from: p  reason: collision with root package name */
    public static volatile boolean f8442p = false;

    /* renamed from: q  reason: collision with root package name */
    public static volatile boolean f8443q = false;

    /* renamed from: r  reason: collision with root package name */
    public static volatile boolean f8444r = true;

    /* renamed from: s  reason: collision with root package name */
    public static volatile boolean f8445s = true;

    /* renamed from: t  reason: collision with root package name */
    public static volatile a f8446t;

    public static int a() {
        return f8435i;
    }

    public static boolean b() {
        return f8443q;
    }

    public static void c(boolean z10) {
        f8444r = z10;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(a.a()).edit();
        edit.putBoolean("ALLOW_SPDY_WHEN_BIND_SERVICE_FAILED", f8444r);
        edit.apply();
    }

    public static void d(String str) {
        if (GlobalAppRuntimeInfo.isTargetProcess()) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                ArrayList arrayList = new ArrayList(length);
                for (int i10 = 0; i10 < length; i10++) {
                    String string = jSONArray.getString(i10);
                    if (d.c(string)) {
                        arrayList.add(string);
                    }
                }
                HttpDispatcher.getInstance().addHosts(arrayList);
            } catch (JSONException e10) {
                ALog.e("anet.NetworkConfigCenter", "parse hosts failed", (String) null, e10, new Object[0]);
            }
        }
    }

    public static void e(int i10) {
        f8438l = i10;
    }

    public static void f(boolean z10) {
        f8431e = z10;
    }

    public static void g(boolean z10) {
        f8442p = z10;
    }

    public static void h(long j10) {
        if (j10 != f8430d) {
            ALog.i("anet.NetworkConfigCenter", "set cache flag", (String) null, "old", Long.valueOf(f8430d), "new", Long.valueOf(j10));
            f8430d = j10;
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(a.a()).edit();
            edit.putLong("Cache.Flag", f8430d);
            edit.apply();
            n1.b.b();
        }
    }

    public static void i(boolean z10) {
        f8443q = z10;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(a.a()).edit();
        edit.putBoolean("CHANNEL_LOCAL_INSTANCE_ENABLE", f8443q);
        edit.apply();
    }

    public static void j(String str) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkConfigCenter", "setDegradeRequestList", (String) null, "Degrade List", str);
        }
        if (TextUtils.isEmpty(str)) {
            f8440n = null;
            return;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                try {
                    if (Operator.Operation.MULTIPLY.equals(obj)) {
                        concurrentHashMap.put(next, f8434h);
                    } else if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        int length = jSONArray.length();
                        ArrayList arrayList = new ArrayList(length);
                        for (int i10 = 0; i10 < length; i10++) {
                            Object obj2 = jSONArray.get(i10);
                            if (obj2 instanceof String) {
                                arrayList.add((String) obj2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            concurrentHashMap.put(next, arrayList);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException e10) {
            ALog.e("anet.NetworkConfigCenter", "parse jsonObject failed", (String) null, e10, new Object[0]);
        }
        f8440n = concurrentHashMap;
    }

    public static void k(boolean z10) {
        f8429c = z10;
    }

    public static void l(String str) {
        if (TextUtils.isEmpty(str)) {
            f8439m = null;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(Constants.KEY_HOST);
            int length = jSONArray.length();
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            for (int i10 = 0; i10 < length; i10++) {
                String string = jSONArray.getString(i10);
                if (d.c(string)) {
                    copyOnWriteArrayList.add(string);
                }
            }
            f8439m = copyOnWriteArrayList;
        } catch (JSONException e10) {
            ALog.e("anet.NetworkConfigCenter", "parse hosts failed", (String) null, e10, new Object[0]);
        }
    }

    public static void m(a aVar) {
        if (f8446t != null) {
            f8446t.unRegister();
        }
        if (aVar != null) {
            aVar.register();
        }
        f8446t = aVar;
    }

    public static void n(boolean z10) {
        f8428b = z10;
    }

    public static void o(boolean z10) {
        f8441o = z10;
    }

    public static void p(int i10) {
        f8435i = i10;
    }

    public static void q(boolean z10) {
        f8436j = z10;
    }

    public static void r(boolean z10) {
        ALog.i("anet.NetworkConfigCenter", "[setSpdyEnabled]", (String) null, "enable", Boolean.valueOf(z10));
        f8427a = z10;
    }

    public static void s(String str) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkConfigCenter", "updateRequestWhiteList", (String) null, "White List", str);
        }
        if (TextUtils.isEmpty(str)) {
            f8433g = null;
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            for (int i10 = 0; i10 < length; i10++) {
                String string = jSONArray.getString(i10);
                if (!string.isEmpty()) {
                    copyOnWriteArrayList.add(string);
                }
            }
            f8433g = copyOnWriteArrayList;
        } catch (JSONException e10) {
            ALog.e("anet.NetworkConfigCenter", "parse bizId failed", (String) null, e10, new Object[0]);
        }
    }

    public static void t(String str) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkConfigCenter", "updateWhiteUrlList", (String) null, "White List", str);
        }
        if (TextUtils.isEmpty(str)) {
            f8432f = null;
            return;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                try {
                    if (Operator.Operation.MULTIPLY.equals(obj)) {
                        concurrentHashMap.put(next, f8434h);
                    } else if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        int length = jSONArray.length();
                        ArrayList arrayList = new ArrayList(length);
                        for (int i10 = 0; i10 < length; i10++) {
                            Object obj2 = jSONArray.get(i10);
                            if (obj2 instanceof String) {
                                arrayList.add((String) obj2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            concurrentHashMap.put(next, arrayList);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException e10) {
            ALog.e("anet.NetworkConfigCenter", "parse jsonObject failed", (String) null, e10, new Object[0]);
        }
        f8432f = concurrentHashMap;
    }
}
