package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.strategy.utils.d;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

class StrategyConfig implements Serializable {
    public static final String NO_RESULT = "No_Result";

    /* renamed from: a  reason: collision with root package name */
    private SerialLruCache<String, String> f3892a = null;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f3893b = null;

    /* renamed from: c  reason: collision with root package name */
    private transient StrategyInfoHolder f3894c = null;

    public StrategyConfig a() {
        StrategyConfig strategyConfig = new StrategyConfig();
        synchronized (this) {
            strategyConfig.f3892a = new SerialLruCache<>(this.f3892a, 256);
            strategyConfig.f3893b = new ConcurrentHashMap(this.f3893b);
            strategyConfig.f3894c = this.f3894c;
        }
        return strategyConfig;
    }

    public void b() {
        if (this.f3892a == null) {
            this.f3892a = new SerialLruCache<>(256);
        }
        if (this.f3893b == null) {
            this.f3893b = new ConcurrentHashMap();
        }
    }

    public String b(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this) {
            str2 = this.f3893b.get(str);
        }
        return str2;
    }

    public void a(StrategyInfoHolder strategyInfoHolder) {
        this.f3894c = strategyInfoHolder;
    }

    public void a(l.d dVar) {
        if (dVar.f3974b != null) {
            synchronized (this) {
                TreeMap treeMap = null;
                int i10 = 0;
                while (true) {
                    l.b[] bVarArr = dVar.f3974b;
                    if (i10 < bVarArr.length) {
                        l.b bVar = bVarArr[i10];
                        if (bVar.f3968j) {
                            this.f3892a.remove(bVar.f3959a);
                        } else if (bVar.f3962d != null) {
                            if (treeMap == null) {
                                treeMap = new TreeMap();
                            }
                            treeMap.put(bVar.f3959a, bVar.f3962d);
                        } else {
                            if (HttpConstant.HTTP.equalsIgnoreCase(bVar.f3961c) || "https".equalsIgnoreCase(bVar.f3961c)) {
                                this.f3892a.put(bVar.f3959a, bVar.f3961c);
                            } else {
                                this.f3892a.put(bVar.f3959a, NO_RESULT);
                            }
                            if (!TextUtils.isEmpty(bVar.f3963e)) {
                                this.f3893b.put(bVar.f3959a, bVar.f3963e);
                            } else {
                                this.f3893b.remove(bVar.f3959a);
                            }
                        }
                        i10++;
                    } else if (treeMap != null) {
                        for (Map.Entry entry : treeMap.entrySet()) {
                            String str = (String) entry.getValue();
                            if (this.f3892a.containsKey(str)) {
                                this.f3892a.put(entry.getKey(), this.f3892a.get(str));
                            } else {
                                this.f3892a.put(entry.getKey(), NO_RESULT);
                            }
                        }
                    }
                }
                while (true) {
                }
            }
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.StrategyConfig", "", (String) null, "SchemeMap", this.f3892a.toString());
                ALog.d("awcn.StrategyConfig", "", (String) null, "UnitMap", this.f3893b.toString());
            }
        }
    }

    public String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str) || !d.c(str)) {
            return null;
        }
        synchronized (this) {
            str2 = this.f3892a.get(str);
            if (str2 == null) {
                this.f3892a.put(str, NO_RESULT);
            }
        }
        if (str2 == null) {
            this.f3894c.d().a(str, false);
        } else if (NO_RESULT.equals(str2)) {
            return null;
        }
        return str2;
    }
}
