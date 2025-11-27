package com.umeng.message.proguard;

import android.app.Activity;
import anet.channel.entity.ConnType;
import com.umeng.analytics.pro.bd;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

public class dt {

    /* renamed from: b  reason: collision with root package name */
    private static volatile dt f15881b;

    /* renamed from: a  reason: collision with root package name */
    public final du f15882a = new du("union");

    /* renamed from: c  reason: collision with root package name */
    private volatile Set<String> f15883c;

    private dt() {
    }

    public static dt a() {
        if (f15881b == null) {
            synchronized (dt.class) {
                if (f15881b == null) {
                    f15881b = new dt();
                }
            }
        }
        return f15881b;
    }

    public final void a(boolean z10) {
        this.f15882a.a(ConnType.PK_AUTO, z10);
    }

    public final void a(String str) {
        this.f15882a.a("et", str);
    }

    private void a(Set<String> set) {
        du duVar = this.f15882a;
        try {
            JSONArray jSONArray = new JSONArray();
            for (String put : set) {
                jSONArray.put(put);
            }
            du.c(duVar.a(bd.f13860t), jSONArray.toString());
        } catch (Throwable unused) {
        }
    }

    public final void a(List<Class<? extends Activity>> list) {
        HashSet hashSet = new HashSet();
        if (!list.isEmpty()) {
            for (Class next : list) {
                if (next != null) {
                    hashSet.add(next.getName());
                }
            }
        }
        this.f15883c = hashSet;
        synchronized (this) {
            a((Set<String>) hashSet);
        }
    }

    public final boolean a(Class<? extends Activity> cls) {
        Set<String> set = this.f15883c;
        if (set == null) {
            synchronized (this) {
                if (this.f15883c == null) {
                    this.f15883c = a().f15882a.a(bd.f13860t, (Set<String>) new HashSet());
                }
                set = this.f15883c;
            }
        }
        return set != null && set.contains(cls.getName());
    }
}
