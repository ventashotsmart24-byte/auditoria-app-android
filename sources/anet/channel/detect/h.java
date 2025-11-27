package anet.channel.detect;

import anet.channel.Session;
import anet.channel.entity.EventCb;
import anet.channel.entity.b;
import anet.channel.request.Request;
import anet.channel.session.TnetSpdySession;
import anet.channel.statist.HorseRaceStat;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;

class h implements EventCb {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HorseRaceStat f3662a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f3663b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f3664c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ l.e f3665d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f3666e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ d f3667f;

    public h(d dVar, HorseRaceStat horseRaceStat, long j10, String str, l.e eVar, TnetSpdySession tnetSpdySession) {
        this.f3667f = dVar;
        this.f3662a = horseRaceStat;
        this.f3663b = j10;
        this.f3664c = str;
        this.f3665d = eVar;
        this.f3666e = tnetSpdySession;
    }

    public void onEvent(Session session, int i10, b bVar) {
        if (this.f3662a.connTime == 0) {
            this.f3662a.connTime = System.currentTimeMillis() - this.f3663b;
            if (i10 == 1) {
                ALog.i("anet.HorseRaceDetector", "tnetSpdySession connect success", this.f3664c, new Object[0]);
                this.f3662a.connRet = 1;
                HttpUrl parse = HttpUrl.parse(session.getHost() + this.f3665d.f3983c);
                if (parse != null) {
                    this.f3666e.request(new Request.Builder().setUrl(parse).setReadTimeout(this.f3665d.f3982b.f3954d).setRedirectEnable(false).setSeq(this.f3664c).build(), new i(this));
                    return;
                }
                return;
            }
            this.f3662a.connErrorCode = bVar.f3707b;
            synchronized (this.f3662a) {
                this.f3662a.notify();
            }
        }
    }
}
