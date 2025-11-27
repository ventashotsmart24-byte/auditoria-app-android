package anet.channel.detect;

import anet.channel.AwcnConfig;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;

class f implements AppLifecycle.AppLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f3660a;

    public f(d dVar) {
        this.f3660a = dVar;
    }

    public void background() {
        ALog.i("anet.HorseRaceDetector", "background", (String) null, new Object[0]);
        if (AwcnConfig.isHorseRaceEnable()) {
            ThreadPoolExecutorFactory.submitHRTask(new g(this));
        }
    }

    public void forground() {
    }
}
