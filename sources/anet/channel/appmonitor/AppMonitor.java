package anet.channel.appmonitor;

import anet.channel.statist.AlarmObject;
import anet.channel.statist.CountObject;
import anet.channel.statist.StatObject;

public class AppMonitor {
    /* access modifiers changed from: private */
    public static volatile IAppMonitor apmMonitor = null;
    private static volatile IAppMonitor appMonitor = new a((IAppMonitor) null);

    public static class a implements IAppMonitor {

        /* renamed from: a  reason: collision with root package name */
        IAppMonitor f3613a;

        public a(IAppMonitor iAppMonitor) {
            this.f3613a = iAppMonitor;
        }

        public void commitAlarm(AlarmObject alarmObject) {
            IAppMonitor iAppMonitor = this.f3613a;
            if (iAppMonitor != null) {
                iAppMonitor.commitAlarm(alarmObject);
            }
        }

        public void commitCount(CountObject countObject) {
            IAppMonitor iAppMonitor = this.f3613a;
            if (iAppMonitor != null) {
                iAppMonitor.commitCount(countObject);
            }
        }

        public void commitStat(StatObject statObject) {
            if (AppMonitor.apmMonitor != null) {
                AppMonitor.apmMonitor.commitStat(statObject);
            }
            IAppMonitor iAppMonitor = this.f3613a;
            if (iAppMonitor != null) {
                iAppMonitor.commitStat(statObject);
            }
        }

        @Deprecated
        public void register() {
        }

        @Deprecated
        public void register(Class<?> cls) {
        }
    }

    public static IAppMonitor getInstance() {
        return appMonitor;
    }

    public static void setApmMonitor(IAppMonitor iAppMonitor) {
        apmMonitor = iAppMonitor;
    }

    public static void setInstance(IAppMonitor iAppMonitor) {
        appMonitor = new a(iAppMonitor);
    }
}
