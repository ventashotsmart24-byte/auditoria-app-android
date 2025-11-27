package anet.channel.detect;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.HorseRaceStat;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import com.hpplay.sdk.source.common.global.Constant;
import java.util.List;
import java.util.Map;

class i implements RequestCb {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f3668a;

    public i(h hVar) {
        this.f3668a = hVar;
    }

    public void onDataReceive(ByteArray byteArray, boolean z10) {
    }

    public void onFinish(int i10, String str, RequestStatistic requestStatistic) {
        int i11 = 0;
        ALog.i("anet.HorseRaceDetector", "LongLinkTask request finish", this.f3668a.f3664c, "statusCode", Integer.valueOf(i10), Constant.KEY_MSG, str);
        if (this.f3668a.f3662a.reqErrorCode == 0) {
            this.f3668a.f3662a.reqErrorCode = i10;
        } else {
            HorseRaceStat horseRaceStat = this.f3668a.f3662a;
            if (horseRaceStat.reqErrorCode == 200) {
                i11 = 1;
            }
            horseRaceStat.reqRet = i11;
        }
        HorseRaceStat horseRaceStat2 = this.f3668a.f3662a;
        long currentTimeMillis = System.currentTimeMillis();
        h hVar = this.f3668a;
        horseRaceStat2.reqTime = (currentTimeMillis - hVar.f3663b) + hVar.f3662a.connTime;
        synchronized (this.f3668a.f3662a) {
            this.f3668a.f3662a.notify();
        }
    }

    public void onResponseCode(int i10, Map<String, List<String>> map) {
        this.f3668a.f3662a.reqErrorCode = i10;
    }
}
