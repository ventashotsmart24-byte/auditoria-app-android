package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.statist.StrategyStatObject;
import anet.channel.util.ALog;
import java.io.File;

class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3919a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ StrategyInfoHolder f3920b;

    public d(StrategyInfoHolder strategyInfoHolder, String str) {
        this.f3920b = strategyInfoHolder;
        this.f3919a = str;
    }

    public void run() {
        try {
            ALog.i("awcn.StrategyInfoHolder", "start loading strategy files", (String) null, new Object[0]);
            long currentTimeMillis = System.currentTimeMillis();
            if (AwcnConfig.isAsyncLoadStrategyEnable()) {
                ALog.i("awcn.StrategyInfoHolder", "load strategy async", (String) null, new Object[0]);
                if (!TextUtils.isEmpty(this.f3919a)) {
                    this.f3920b.a(this.f3919a, true);
                }
                StrategyConfig strategyConfig = (StrategyConfig) m.a("StrategyConfig", (StrategyStatObject) null);
                if (strategyConfig != null) {
                    strategyConfig.b();
                    strategyConfig.a(this.f3920b);
                    synchronized (this.f3920b) {
                        this.f3920b.f3896b = strategyConfig;
                    }
                }
            }
            File[] b10 = m.b();
            if (b10 != null) {
                int i10 = 0;
                for (int i11 = 0; i11 < b10.length && i10 < 2; i11++) {
                    File file = b10[i11];
                    if (!file.isDirectory()) {
                        String name = file.getName();
                        if (!name.equals(this.f3919a) && !name.startsWith("StrategyConfig")) {
                            this.f3920b.a(name, false);
                            i10++;
                        }
                    }
                }
                ALog.i("awcn.StrategyInfoHolder", "end loading strategy files", (String) null, "total cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        } catch (Exception unused) {
        }
    }
}
