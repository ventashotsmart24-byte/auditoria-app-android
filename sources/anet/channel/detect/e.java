package anet.channel.detect;

import anet.channel.AwcnConfig;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.l;
import anet.channel.util.ALog;

class e implements IStrategyListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f3659a;

    public e(d dVar) {
        this.f3659a = dVar;
    }

    public void onStrategyUpdated(l.d dVar) {
        l.c[] cVarArr;
        int i10 = 0;
        ALog.i("anet.HorseRaceDetector", "onStrategyUpdated", (String) null, new Object[0]);
        if (AwcnConfig.isHorseRaceEnable() && (cVarArr = dVar.f3975c) != null && cVarArr.length != 0) {
            synchronized (this.f3659a.f3657a) {
                while (true) {
                    l.c[] cVarArr2 = dVar.f3975c;
                    if (i10 < cVarArr2.length) {
                        l.c cVar = cVarArr2[i10];
                        this.f3659a.f3657a.put(cVar.f3971a, cVar);
                        i10++;
                    }
                }
            }
        }
    }
}
