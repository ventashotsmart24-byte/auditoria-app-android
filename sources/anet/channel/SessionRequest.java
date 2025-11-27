package anet.channel;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventType;
import anet.channel.session.TnetSpdySession;
import anet.channel.statist.AlarmObject;
import anet.channel.statist.SessionConnStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.utils.d;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.j;
import com.umeng.analytics.pro.bt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

class SessionRequest {

    /* renamed from: a  reason: collision with root package name */
    SessionCenter f3587a;

    /* renamed from: b  reason: collision with root package name */
    e f3588b;

    /* renamed from: c  reason: collision with root package name */
    SessionInfo f3589c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f3590d = false;

    /* renamed from: e  reason: collision with root package name */
    volatile Session f3591e;

    /* renamed from: f  reason: collision with root package name */
    volatile boolean f3592f = false;

    /* renamed from: g  reason: collision with root package name */
    HashMap<SessionGetCallback, c> f3593g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    SessionConnStat f3594h = null;

    /* renamed from: i  reason: collision with root package name */
    private String f3595i;

    /* renamed from: j  reason: collision with root package name */
    private String f3596j;

    /* renamed from: k  reason: collision with root package name */
    private volatile Future f3597k;

    /* renamed from: l  reason: collision with root package name */
    private Object f3598l = new Object();

    public interface IConnCb {
        void onDisConnect(Session session, long j10, int i10);

        void onFailed(Session session, long j10, int i10, int i11);

        void onSuccess(Session session, long j10);
    }

    public class a implements IConnCb {

        /* renamed from: a  reason: collision with root package name */
        boolean f3599a = false;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public Context f3601c;

        /* renamed from: d  reason: collision with root package name */
        private List<anet.channel.entity.a> f3602d;

        /* renamed from: e  reason: collision with root package name */
        private anet.channel.entity.a f3603e;

        public a(Context context, List<anet.channel.entity.a> list, anet.channel.entity.a aVar) {
            this.f3601c = context;
            this.f3602d = list;
            this.f3603e = aVar;
        }

        public void onDisConnect(Session session, long j10, int i10) {
            int i11;
            SessionInfo sessionInfo;
            boolean isAppBackground = GlobalAppRuntimeInfo.isAppBackground();
            ALog.d("awcn.SessionRequest", "Connect Disconnect", this.f3603e.h(), "session", session, Constants.KEY_HOST, SessionRequest.this.a(), "appIsBg", Boolean.valueOf(isAppBackground), "isHandleFinish", Boolean.valueOf(this.f3599a));
            SessionRequest sessionRequest = SessionRequest.this;
            sessionRequest.f3588b.b(sessionRequest, session);
            if (!this.f3599a) {
                this.f3599a = true;
                if (session.f3568t) {
                    if (isAppBackground && ((sessionInfo = SessionRequest.this.f3589c) == null || !sessionInfo.isAccs || AwcnConfig.isAccsSessionCreateForbiddenInBg())) {
                        ALog.e("awcn.SessionRequest", "[onDisConnect]app background, don't Recreate", this.f3603e.h(), "session", session);
                    } else if (!NetworkStatusHelper.isConnected()) {
                        ALog.e("awcn.SessionRequest", "[onDisConnect]no network, don't Recreate", this.f3603e.h(), "session", session);
                    } else {
                        try {
                            ALog.d("awcn.SessionRequest", "session disconnected, try to recreate session", this.f3603e.h(), new Object[0]);
                            SessionInfo sessionInfo2 = SessionRequest.this.f3589c;
                            if (sessionInfo2 == null || !sessionInfo2.isAccs) {
                                i11 = 10000;
                            } else {
                                i11 = AwcnConfig.getAccsReconnectionDelayPeriod();
                            }
                            i iVar = new i(this, session);
                            double random = Math.random();
                            double d10 = (double) i11;
                            Double.isNaN(d10);
                            ThreadPoolExecutorFactory.submitScheduledTask(iVar, (long) (random * d10), TimeUnit.MILLISECONDS);
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }

        public void onFailed(Session session, long j10, int i10, int i11) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.SessionRequest", "Connect failed", this.f3603e.h(), "session", session, Constants.KEY_HOST, SessionRequest.this.a(), "isHandleFinish", Boolean.valueOf(this.f3599a));
            }
            if (SessionRequest.this.f3592f) {
                SessionRequest.this.f3592f = false;
            } else if (!this.f3599a) {
                this.f3599a = true;
                SessionRequest sessionRequest = SessionRequest.this;
                sessionRequest.f3588b.b(sessionRequest, session);
                if (!session.f3569u || !NetworkStatusHelper.isConnected() || this.f3602d.isEmpty()) {
                    SessionRequest.this.c();
                    SessionRequest.this.a(session, i10, i11);
                    synchronized (SessionRequest.this.f3593g) {
                        for (Map.Entry next : SessionRequest.this.f3593g.entrySet()) {
                            c cVar = (c) next.getValue();
                            if (cVar.f3607b.compareAndSet(false, true)) {
                                ThreadPoolExecutorFactory.removeScheduleTask(cVar);
                                ((SessionGetCallback) next.getKey()).onSessionGetFail();
                            }
                        }
                        SessionRequest.this.f3593g.clear();
                    }
                    return;
                }
                if (ALog.isPrintLog(1)) {
                    ALog.d("awcn.SessionRequest", "use next connInfo to create session", this.f3603e.h(), Constants.KEY_HOST, SessionRequest.this.a());
                }
                anet.channel.entity.a aVar = this.f3603e;
                if (aVar.f3702b == aVar.f3703c && (i11 == -2003 || i11 == -2410)) {
                    ListIterator<anet.channel.entity.a> listIterator = this.f3602d.listIterator();
                    while (listIterator.hasNext()) {
                        if (session.getIp().equals(listIterator.next().f3701a.getIp())) {
                            listIterator.remove();
                        }
                    }
                }
                if (d.b(session.getIp())) {
                    ListIterator<anet.channel.entity.a> listIterator2 = this.f3602d.listIterator();
                    while (listIterator2.hasNext()) {
                        if (d.b(listIterator2.next().f3701a.getIp())) {
                            listIterator2.remove();
                        }
                    }
                }
                if (this.f3602d.isEmpty()) {
                    SessionRequest.this.c();
                    SessionRequest.this.a(session, i10, i11);
                    synchronized (SessionRequest.this.f3593g) {
                        for (Map.Entry next2 : SessionRequest.this.f3593g.entrySet()) {
                            c cVar2 = (c) next2.getValue();
                            if (cVar2.f3607b.compareAndSet(false, true)) {
                                ThreadPoolExecutorFactory.removeScheduleTask(cVar2);
                                ((SessionGetCallback) next2.getKey()).onSessionGetFail();
                            }
                        }
                        SessionRequest.this.f3593g.clear();
                    }
                    return;
                }
                anet.channel.entity.a remove = this.f3602d.remove(0);
                SessionRequest sessionRequest2 = SessionRequest.this;
                Context context = this.f3601c;
                sessionRequest2.a(context, remove, new a(context, this.f3602d, remove), remove.h());
            }
        }

        public void onSuccess(Session session, long j10) {
            ALog.d("awcn.SessionRequest", "Connect Success", this.f3603e.h(), "session", session, Constants.KEY_HOST, SessionRequest.this.a());
            try {
                if (SessionRequest.this.f3592f) {
                    SessionRequest.this.f3592f = false;
                    session.close(false);
                    SessionRequest.this.c();
                    return;
                }
                SessionRequest sessionRequest = SessionRequest.this;
                sessionRequest.f3588b.a(sessionRequest, session);
                SessionRequest.this.a(session);
                synchronized (SessionRequest.this.f3593g) {
                    for (Map.Entry next : SessionRequest.this.f3593g.entrySet()) {
                        c cVar = (c) next.getValue();
                        if (cVar.f3607b.compareAndSet(false, true)) {
                            ThreadPoolExecutorFactory.removeScheduleTask(cVar);
                            ((SessionGetCallback) next.getKey()).onSessionGetSuccess(session);
                        }
                    }
                    SessionRequest.this.f3593g.clear();
                }
                SessionRequest.this.c();
            } catch (Exception e10) {
                try {
                    ALog.e("awcn.SessionRequest", "[onSuccess]:", this.f3603e.h(), e10, new Object[0]);
                } finally {
                    SessionRequest.this.c();
                }
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        String f3604a;

        public b(String str) {
            this.f3604a = str;
        }

        public void run() {
            if (SessionRequest.this.f3590d) {
                ALog.e("awcn.SessionRequest", "Connecting timeout!!! reset status!", this.f3604a, new Object[0]);
                SessionConnStat sessionConnStat = SessionRequest.this.f3594h;
                sessionConnStat.ret = 2;
                sessionConnStat.totalTime = System.currentTimeMillis() - SessionRequest.this.f3594h.start;
                if (SessionRequest.this.f3591e != null) {
                    SessionRequest.this.f3591e.f3569u = false;
                    SessionRequest.this.f3591e.close();
                    SessionRequest sessionRequest = SessionRequest.this;
                    sessionRequest.f3594h.syncValueFromSession(sessionRequest.f3591e);
                }
                AppMonitor.getInstance().commitStat(SessionRequest.this.f3594h);
                SessionRequest.this.a(false);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        SessionGetCallback f3606a = null;

        /* renamed from: b  reason: collision with root package name */
        AtomicBoolean f3607b = new AtomicBoolean(false);

        public c(SessionGetCallback sessionGetCallback) {
            this.f3606a = sessionGetCallback;
        }

        public void run() {
            if (this.f3607b.compareAndSet(false, true)) {
                ALog.e("awcn.SessionRequest", "get session timeout", (String) null, new Object[0]);
                synchronized (SessionRequest.this.f3593g) {
                    SessionRequest.this.f3593g.remove(this.f3606a);
                }
                this.f3606a.onSessionGetFail();
            }
        }
    }

    public SessionRequest(String str, SessionCenter sessionCenter) {
        this.f3595i = str;
        String substring = str.substring(str.indexOf(HttpConstant.SCHEME_SPLIT) + 3);
        this.f3596j = substring;
        this.f3587a = sessionCenter;
        this.f3589c = sessionCenter.f3582g.b(substring);
        this.f3588b = sessionCenter.f3580e;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized void b(android.content.Context r10, int r11, java.lang.String r12, anet.channel.SessionGetCallback r13, long r14) {
        /*
            r9 = this;
            monitor-enter(r9)
            anet.channel.e r0 = r9.f3588b     // Catch:{ all -> 0x012a }
            anet.channel.Session r0 = r0.a((anet.channel.SessionRequest) r9, (int) r11)     // Catch:{ all -> 0x012a }
            r1 = 0
            if (r0 == 0) goto L_0x0018
            java.lang.String r10 = "awcn.SessionRequest"
            java.lang.String r11 = "Available Session exist!!!"
            java.lang.Object[] r14 = new java.lang.Object[r1]     // Catch:{ all -> 0x012a }
            anet.channel.util.ALog.d(r10, r11, r12, r14)     // Catch:{ all -> 0x012a }
            r13.onSessionGetSuccess(r0)     // Catch:{ all -> 0x012a }
            monitor-exit(r9)
            return
        L_0x0018:
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x012a }
            if (r0 == 0) goto L_0x0023
            r12 = 0
            java.lang.String r12 = anet.channel.util.i.a(r12)     // Catch:{ all -> 0x012a }
        L_0x0023:
            java.lang.String r0 = "awcn.SessionRequest"
            java.lang.String r2 = "SessionRequest start"
            r3 = 4
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x012a }
            java.lang.String r5 = "host"
            r4[r1] = r5     // Catch:{ all -> 0x012a }
            java.lang.String r5 = r9.f3595i     // Catch:{ all -> 0x012a }
            r6 = 1
            r4[r6] = r5     // Catch:{ all -> 0x012a }
            java.lang.String r5 = "type"
            r7 = 2
            r4[r7] = r5     // Catch:{ all -> 0x012a }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x012a }
            r8 = 3
            r4[r8] = r5     // Catch:{ all -> 0x012a }
            anet.channel.util.ALog.d(r0, r2, r12, r4)     // Catch:{ all -> 0x012a }
            boolean r0 = r9.f3590d     // Catch:{ all -> 0x012a }
            if (r0 == 0) goto L_0x007b
            java.lang.String r10 = "awcn.SessionRequest"
            java.lang.String r0 = "session connecting"
            java.lang.Object[] r2 = new java.lang.Object[r7]     // Catch:{ all -> 0x012a }
            java.lang.String r3 = "host"
            r2[r1] = r3     // Catch:{ all -> 0x012a }
            java.lang.String r1 = r9.a()     // Catch:{ all -> 0x012a }
            r2[r6] = r1     // Catch:{ all -> 0x012a }
            anet.channel.util.ALog.d(r10, r0, r12, r2)     // Catch:{ all -> 0x012a }
            int r10 = r9.b()     // Catch:{ all -> 0x012a }
            if (r10 != r11) goto L_0x0076
            anet.channel.SessionRequest$c r10 = new anet.channel.SessionRequest$c     // Catch:{ all -> 0x012a }
            r10.<init>(r13)     // Catch:{ all -> 0x012a }
            java.util.HashMap<anet.channel.SessionGetCallback, anet.channel.SessionRequest$c> r11 = r9.f3593g     // Catch:{ all -> 0x012a }
            monitor-enter(r11)     // Catch:{ all -> 0x012a }
            java.util.HashMap<anet.channel.SessionGetCallback, anet.channel.SessionRequest$c> r12 = r9.f3593g     // Catch:{ all -> 0x0073 }
            r12.put(r13, r10)     // Catch:{ all -> 0x0073 }
            monitor-exit(r11)     // Catch:{ all -> 0x0073 }
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x012a }
            anet.channel.thread.ThreadPoolExecutorFactory.submitScheduledTask(r10, r14, r11)     // Catch:{ all -> 0x012a }
            goto L_0x0079
        L_0x0073:
            r10 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x0073 }
            throw r10     // Catch:{ all -> 0x012a }
        L_0x0076:
            r13.onSessionGetFail()     // Catch:{ all -> 0x012a }
        L_0x0079:
            monitor-exit(r9)
            return
        L_0x007b:
            r9.a((boolean) r6)     // Catch:{ all -> 0x012a }
            anet.channel.SessionRequest$b r0 = new anet.channel.SessionRequest$b     // Catch:{ all -> 0x012a }
            r0.<init>(r12)     // Catch:{ all -> 0x012a }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x012a }
            r4 = 45
            java.util.concurrent.Future r0 = anet.channel.thread.ThreadPoolExecutorFactory.submitScheduledTask(r0, r4, r2)     // Catch:{ all -> 0x012a }
            r9.f3597k = r0     // Catch:{ all -> 0x012a }
            anet.channel.statist.SessionConnStat r0 = new anet.channel.statist.SessionConnStat     // Catch:{ all -> 0x012a }
            r0.<init>()     // Catch:{ all -> 0x012a }
            r9.f3594h = r0     // Catch:{ all -> 0x012a }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x012a }
            r0.start = r4     // Catch:{ all -> 0x012a }
            boolean r0 = anet.channel.status.NetworkStatusHelper.isConnected()     // Catch:{ all -> 0x012a }
            if (r0 != 0) goto L_0x00c8
            boolean r10 = anet.channel.util.ALog.isPrintLog(r6)     // Catch:{ all -> 0x012a }
            if (r10 == 0) goto L_0x00bd
            java.lang.String r10 = "awcn.SessionRequest"
            java.lang.String r11 = "network is not available, can't create session"
            java.lang.Object[] r13 = new java.lang.Object[r7]     // Catch:{ all -> 0x012a }
            java.lang.String r14 = "isConnected"
            r13[r1] = r14     // Catch:{ all -> 0x012a }
            boolean r14 = anet.channel.status.NetworkStatusHelper.isConnected()     // Catch:{ all -> 0x012a }
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r14)     // Catch:{ all -> 0x012a }
            r13[r6] = r14     // Catch:{ all -> 0x012a }
            anet.channel.util.ALog.d(r10, r11, r12, r13)     // Catch:{ all -> 0x012a }
        L_0x00bd:
            r9.c()     // Catch:{ all -> 0x012a }
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ all -> 0x012a }
            java.lang.String r11 = "no network"
            r10.<init>(r11)     // Catch:{ all -> 0x012a }
            throw r10     // Catch:{ all -> 0x012a }
        L_0x00c8:
            java.util.List r0 = r9.a((int) r11, (java.lang.String) r12)     // Catch:{ all -> 0x012a }
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x012a }
            if (r2 != 0) goto L_0x0104
            java.util.List r11 = r9.a((java.util.List<anet.channel.strategy.IConnStrategy>) r0, (java.lang.String) r12)     // Catch:{ all -> 0x012a }
            java.lang.Object r12 = r11.remove(r1)     // Catch:{ all -> 0x00ff }
            anet.channel.entity.a r12 = (anet.channel.entity.a) r12     // Catch:{ all -> 0x00ff }
            anet.channel.SessionRequest$a r0 = new anet.channel.SessionRequest$a     // Catch:{ all -> 0x00ff }
            r0.<init>(r10, r11, r12)     // Catch:{ all -> 0x00ff }
            java.lang.String r11 = r12.h()     // Catch:{ all -> 0x00ff }
            r9.a(r10, r12, r0, r11)     // Catch:{ all -> 0x00ff }
            anet.channel.SessionRequest$c r10 = new anet.channel.SessionRequest$c     // Catch:{ all -> 0x00ff }
            r10.<init>(r13)     // Catch:{ all -> 0x00ff }
            java.util.HashMap<anet.channel.SessionGetCallback, anet.channel.SessionRequest$c> r11 = r9.f3593g     // Catch:{ all -> 0x00ff }
            monitor-enter(r11)     // Catch:{ all -> 0x00ff }
            java.util.HashMap<anet.channel.SessionGetCallback, anet.channel.SessionRequest$c> r12 = r9.f3593g     // Catch:{ all -> 0x00fc }
            r12.put(r13, r10)     // Catch:{ all -> 0x00fc }
            monitor-exit(r11)     // Catch:{ all -> 0x00fc }
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00ff }
            anet.channel.thread.ThreadPoolExecutorFactory.submitScheduledTask(r10, r14, r11)     // Catch:{ all -> 0x00ff }
            goto L_0x0102
        L_0x00fc:
            r10 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x00fc }
            throw r10     // Catch:{ all -> 0x00ff }
        L_0x00ff:
            r9.c()     // Catch:{ all -> 0x012a }
        L_0x0102:
            monitor-exit(r9)
            return
        L_0x0104:
            java.lang.String r10 = "awcn.SessionRequest"
            java.lang.String r13 = "no avalible strategy, can't create session"
            java.lang.Object[] r14 = new java.lang.Object[r3]     // Catch:{ all -> 0x012a }
            java.lang.String r15 = "host"
            r14[r1] = r15     // Catch:{ all -> 0x012a }
            java.lang.String r15 = r9.f3595i     // Catch:{ all -> 0x012a }
            r14[r6] = r15     // Catch:{ all -> 0x012a }
            java.lang.String r15 = "type"
            r14[r7] = r15     // Catch:{ all -> 0x012a }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x012a }
            r14[r8] = r11     // Catch:{ all -> 0x012a }
            anet.channel.util.ALog.i(r10, r13, r12, r14)     // Catch:{ all -> 0x012a }
            r9.c()     // Catch:{ all -> 0x012a }
            anet.channel.NoAvailStrategyException r10 = new anet.channel.NoAvailStrategyException     // Catch:{ all -> 0x012a }
            java.lang.String r11 = "no avalible strategy"
            r10.<init>(r11)     // Catch:{ all -> 0x012a }
            throw r10     // Catch:{ all -> 0x012a }
        L_0x012a:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.SessionRequest.b(android.content.Context, int, java.lang.String, anet.channel.SessionGetCallback, long):void");
    }

    public void c() {
        a(false);
        synchronized (this.f3598l) {
            this.f3598l.notifyAll();
        }
    }

    public String a() {
        return this.f3595i;
    }

    public void a(boolean z10) {
        this.f3590d = z10;
        if (!z10) {
            if (this.f3597k != null) {
                this.f3597k.cancel(true);
                this.f3597k = null;
            }
            this.f3591e = null;
        }
    }

    private void c(Session session, int i10, String str) {
        SessionInfo sessionInfo = this.f3589c;
        if (sessionInfo != null && sessionInfo.isAccs) {
            ALog.e("awcn.SessionRequest", "sendConnectInfoToAccsByCallBack", (String) null, new Object[0]);
            Intent intent = new Intent(Constants.ACTION_ACCS_CONNECT_INFO);
            intent.putExtra("command", 103);
            intent.putExtra(Constants.KEY_HOST, session.getHost());
            intent.putExtra(Constants.KEY_CENTER_HOST, true);
            boolean isAvailable = session.isAvailable();
            if (!isAvailable) {
                intent.putExtra("errorCode", i10);
                intent.putExtra(Constants.KEY_ERROR_DETAIL, str);
            }
            intent.putExtra(Constants.KEY_CONNECT_AVAILABLE, isAvailable);
            intent.putExtra(Constants.KEY_TYPE_INAPP, true);
            this.f3587a.f3583h.notifyListener(intent);
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized void a(android.content.Context r10, int r11, java.lang.String r12, anet.channel.SessionGetCallback r13, long r14) {
        /*
            r9 = this;
            monitor-enter(r9)
            anet.channel.e r0 = r9.f3588b     // Catch:{ all -> 0x0130 }
            anet.channel.Session r0 = r0.a((anet.channel.SessionRequest) r9, (int) r11)     // Catch:{ all -> 0x0130 }
            r1 = 0
            if (r0 == 0) goto L_0x001a
            java.lang.String r10 = "awcn.SessionRequest"
            java.lang.String r11 = "Available Session exist!!!"
            java.lang.Object[] r14 = new java.lang.Object[r1]     // Catch:{ all -> 0x0130 }
            anet.channel.util.ALog.d(r10, r11, r12, r14)     // Catch:{ all -> 0x0130 }
            if (r13 == 0) goto L_0x0018
            r13.onSessionGetSuccess(r0)     // Catch:{ all -> 0x0130 }
        L_0x0018:
            monitor-exit(r9)
            return
        L_0x001a:
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0130 }
            if (r0 == 0) goto L_0x0025
            r12 = 0
            java.lang.String r12 = anet.channel.util.i.a(r12)     // Catch:{ all -> 0x0130 }
        L_0x0025:
            java.lang.String r0 = "awcn.SessionRequest"
            java.lang.String r2 = "SessionRequest start"
            r3 = 4
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x0130 }
            java.lang.String r5 = "host"
            r4[r1] = r5     // Catch:{ all -> 0x0130 }
            java.lang.String r5 = r9.f3595i     // Catch:{ all -> 0x0130 }
            r6 = 1
            r4[r6] = r5     // Catch:{ all -> 0x0130 }
            java.lang.String r5 = "type"
            r7 = 2
            r4[r7] = r5     // Catch:{ all -> 0x0130 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0130 }
            r8 = 3
            r4[r8] = r5     // Catch:{ all -> 0x0130 }
            anet.channel.util.ALog.d(r0, r2, r12, r4)     // Catch:{ all -> 0x0130 }
            boolean r0 = r9.f3590d     // Catch:{ all -> 0x0130 }
            if (r0 == 0) goto L_0x007f
            java.lang.String r10 = "awcn.SessionRequest"
            java.lang.String r0 = "session connecting"
            java.lang.Object[] r2 = new java.lang.Object[r7]     // Catch:{ all -> 0x0130 }
            java.lang.String r3 = "host"
            r2[r1] = r3     // Catch:{ all -> 0x0130 }
            java.lang.String r1 = r9.a()     // Catch:{ all -> 0x0130 }
            r2[r6] = r1     // Catch:{ all -> 0x0130 }
            anet.channel.util.ALog.d(r10, r0, r12, r2)     // Catch:{ all -> 0x0130 }
            if (r13 == 0) goto L_0x007d
            int r10 = r9.b()     // Catch:{ all -> 0x0130 }
            if (r10 != r11) goto L_0x007a
            anet.channel.SessionRequest$c r10 = new anet.channel.SessionRequest$c     // Catch:{ all -> 0x0130 }
            r10.<init>(r13)     // Catch:{ all -> 0x0130 }
            java.util.HashMap<anet.channel.SessionGetCallback, anet.channel.SessionRequest$c> r11 = r9.f3593g     // Catch:{ all -> 0x0130 }
            monitor-enter(r11)     // Catch:{ all -> 0x0130 }
            java.util.HashMap<anet.channel.SessionGetCallback, anet.channel.SessionRequest$c> r12 = r9.f3593g     // Catch:{ all -> 0x0077 }
            r12.put(r13, r10)     // Catch:{ all -> 0x0077 }
            monitor-exit(r11)     // Catch:{ all -> 0x0077 }
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0130 }
            anet.channel.thread.ThreadPoolExecutorFactory.submitScheduledTask(r10, r14, r11)     // Catch:{ all -> 0x0130 }
            goto L_0x007d
        L_0x0077:
            r10 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x0077 }
            throw r10     // Catch:{ all -> 0x0130 }
        L_0x007a:
            r13.onSessionGetFail()     // Catch:{ all -> 0x0130 }
        L_0x007d:
            monitor-exit(r9)
            return
        L_0x007f:
            r9.a((boolean) r6)     // Catch:{ all -> 0x0130 }
            anet.channel.SessionRequest$b r0 = new anet.channel.SessionRequest$b     // Catch:{ all -> 0x0130 }
            r0.<init>(r12)     // Catch:{ all -> 0x0130 }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0130 }
            r4 = 45
            java.util.concurrent.Future r0 = anet.channel.thread.ThreadPoolExecutorFactory.submitScheduledTask(r0, r4, r2)     // Catch:{ all -> 0x0130 }
            r9.f3597k = r0     // Catch:{ all -> 0x0130 }
            anet.channel.statist.SessionConnStat r0 = new anet.channel.statist.SessionConnStat     // Catch:{ all -> 0x0130 }
            r0.<init>()     // Catch:{ all -> 0x0130 }
            r9.f3594h = r0     // Catch:{ all -> 0x0130 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0130 }
            r0.start = r4     // Catch:{ all -> 0x0130 }
            boolean r0 = anet.channel.status.NetworkStatusHelper.isConnected()     // Catch:{ all -> 0x0130 }
            if (r0 != 0) goto L_0x00cc
            boolean r10 = anet.channel.util.ALog.isPrintLog(r6)     // Catch:{ all -> 0x0130 }
            if (r10 == 0) goto L_0x00c1
            java.lang.String r10 = "awcn.SessionRequest"
            java.lang.String r11 = "network is not available, can't create session"
            java.lang.Object[] r13 = new java.lang.Object[r7]     // Catch:{ all -> 0x0130 }
            java.lang.String r14 = "isConnected"
            r13[r1] = r14     // Catch:{ all -> 0x0130 }
            boolean r14 = anet.channel.status.NetworkStatusHelper.isConnected()     // Catch:{ all -> 0x0130 }
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r14)     // Catch:{ all -> 0x0130 }
            r13[r6] = r14     // Catch:{ all -> 0x0130 }
            anet.channel.util.ALog.d(r10, r11, r12, r13)     // Catch:{ all -> 0x0130 }
        L_0x00c1:
            r9.c()     // Catch:{ all -> 0x0130 }
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ all -> 0x0130 }
            java.lang.String r11 = "no network"
            r10.<init>(r11)     // Catch:{ all -> 0x0130 }
            throw r10     // Catch:{ all -> 0x0130 }
        L_0x00cc:
            java.util.List r0 = r9.a((int) r11, (java.lang.String) r12)     // Catch:{ all -> 0x0130 }
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x0130 }
            if (r2 != 0) goto L_0x010a
            java.util.List r11 = r9.a((java.util.List<anet.channel.strategy.IConnStrategy>) r0, (java.lang.String) r12)     // Catch:{ all -> 0x0130 }
            java.lang.Object r12 = r11.remove(r1)     // Catch:{ all -> 0x0105 }
            anet.channel.entity.a r12 = (anet.channel.entity.a) r12     // Catch:{ all -> 0x0105 }
            anet.channel.SessionRequest$a r0 = new anet.channel.SessionRequest$a     // Catch:{ all -> 0x0105 }
            r0.<init>(r10, r11, r12)     // Catch:{ all -> 0x0105 }
            java.lang.String r11 = r12.h()     // Catch:{ all -> 0x0105 }
            r9.a(r10, r12, r0, r11)     // Catch:{ all -> 0x0105 }
            if (r13 == 0) goto L_0x0108
            anet.channel.SessionRequest$c r10 = new anet.channel.SessionRequest$c     // Catch:{ all -> 0x0105 }
            r10.<init>(r13)     // Catch:{ all -> 0x0105 }
            java.util.HashMap<anet.channel.SessionGetCallback, anet.channel.SessionRequest$c> r11 = r9.f3593g     // Catch:{ all -> 0x0105 }
            monitor-enter(r11)     // Catch:{ all -> 0x0105 }
            java.util.HashMap<anet.channel.SessionGetCallback, anet.channel.SessionRequest$c> r12 = r9.f3593g     // Catch:{ all -> 0x0102 }
            r12.put(r13, r10)     // Catch:{ all -> 0x0102 }
            monitor-exit(r11)     // Catch:{ all -> 0x0102 }
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0105 }
            anet.channel.thread.ThreadPoolExecutorFactory.submitScheduledTask(r10, r14, r11)     // Catch:{ all -> 0x0105 }
            goto L_0x0108
        L_0x0102:
            r10 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x0102 }
            throw r10     // Catch:{ all -> 0x0105 }
        L_0x0105:
            r9.c()     // Catch:{ all -> 0x0130 }
        L_0x0108:
            monitor-exit(r9)
            return
        L_0x010a:
            java.lang.String r10 = "awcn.SessionRequest"
            java.lang.String r13 = "no avalible strategy, can't create session"
            java.lang.Object[] r14 = new java.lang.Object[r3]     // Catch:{ all -> 0x0130 }
            java.lang.String r15 = "host"
            r14[r1] = r15     // Catch:{ all -> 0x0130 }
            java.lang.String r15 = r9.f3595i     // Catch:{ all -> 0x0130 }
            r14[r6] = r15     // Catch:{ all -> 0x0130 }
            java.lang.String r15 = "type"
            r14[r7] = r15     // Catch:{ all -> 0x0130 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0130 }
            r14[r8] = r11     // Catch:{ all -> 0x0130 }
            anet.channel.util.ALog.i(r10, r13, r12, r14)     // Catch:{ all -> 0x0130 }
            r9.c()     // Catch:{ all -> 0x0130 }
            anet.channel.NoAvailStrategyException r10 = new anet.channel.NoAvailStrategyException     // Catch:{ all -> 0x0130 }
            java.lang.String r11 = "no avalible strategy"
            r10.<init>(r11)     // Catch:{ all -> 0x0130 }
            throw r10     // Catch:{ all -> 0x0130 }
        L_0x0130:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.SessionRequest.a(android.content.Context, int, java.lang.String, anet.channel.SessionGetCallback, long):void");
    }

    public void b(boolean z10) {
        ALog.d("awcn.SessionRequest", "closeSessions", this.f3587a.f3578c, Constants.KEY_HOST, this.f3595i, "autoCreate", Boolean.valueOf(z10));
        if (!z10 && this.f3591e != null) {
            this.f3591e.f3569u = false;
            this.f3591e.close(false);
        }
        List<Session> a10 = this.f3588b.a(this);
        if (a10 != null) {
            for (Session next : a10) {
                if (next != null) {
                    next.close(z10);
                }
            }
        }
    }

    public void a(Session session) {
        AlarmObject alarmObject = new AlarmObject();
        alarmObject.module = "networkPrefer";
        alarmObject.modulePoint = bt.by;
        alarmObject.arg = this.f3595i;
        alarmObject.isSuccess = true;
        AppMonitor.getInstance().commitAlarm(alarmObject);
        this.f3594h.syncValueFromSession(session);
        SessionConnStat sessionConnStat = this.f3594h;
        sessionConnStat.ret = 1;
        sessionConnStat.totalTime = System.currentTimeMillis() - this.f3594h.start;
        AppMonitor.getInstance().commitStat(this.f3594h);
    }

    public int b() {
        Session session = this.f3591e;
        if (session != null) {
            return session.f3558j.getType();
        }
        return -1;
    }

    private void b(Session session, int i10, String str) {
        SessionInfo sessionInfo;
        Context context = GlobalAppRuntimeInfo.getContext();
        if (context != null && (sessionInfo = this.f3589c) != null && sessionInfo.isAccs) {
            ALog.e("awcn.SessionRequest", "sendConnectInfoToAccsByService", (String) null, new Object[0]);
            try {
                Intent intent = new Intent(Constants.ACTION_RECEIVE);
                intent.setPackage(context.getPackageName());
                intent.setClassName(context, j.msgService);
                intent.putExtra("command", 103);
                intent.putExtra(Constants.KEY_HOST, session.getHost());
                intent.putExtra(Constants.KEY_CENTER_HOST, true);
                boolean isAvailable = session.isAvailable();
                if (!isAvailable) {
                    intent.putExtra("errorCode", i10);
                    intent.putExtra(Constants.KEY_ERROR_DETAIL, str);
                }
                intent.putExtra(Constants.KEY_CONNECT_AVAILABLE, isAvailable);
                intent.putExtra(Constants.KEY_TYPE_INAPP, true);
                if (Build.VERSION.SDK_INT >= 26) {
                    context.bindService(intent, new h(this, intent, context), 1);
                } else {
                    context.startService(intent);
                }
            } catch (Throwable th) {
                ALog.e("awcn.SessionRequest", "sendConnectInfoToAccsByService", (String) null, th, new Object[0]);
            }
        }
    }

    public void a(Session session, int i10, int i11) {
        if (256 == i10 && i11 != -2613 && i11 != -2601) {
            AlarmObject alarmObject = new AlarmObject();
            alarmObject.module = "networkPrefer";
            alarmObject.modulePoint = bt.by;
            alarmObject.arg = this.f3595i;
            alarmObject.errorCode = String.valueOf(i11);
            alarmObject.isSuccess = false;
            AppMonitor.getInstance().commitAlarm(alarmObject);
            SessionConnStat sessionConnStat = this.f3594h;
            sessionConnStat.ret = 0;
            sessionConnStat.appendErrorTrace(i11);
            this.f3594h.errorCode = String.valueOf(i11);
            this.f3594h.totalTime = System.currentTimeMillis() - this.f3594h.start;
            this.f3594h.syncValueFromSession(session);
            AppMonitor.getInstance().commitStat(this.f3594h);
        }
    }

    private List<IConnStrategy> a(int i10, String str) {
        List<IConnStrategy> list = Collections.EMPTY_LIST;
        try {
            HttpUrl parse = HttpUrl.parse(a());
            if (parse == null) {
                return list;
            }
            list = StrategyCenter.getInstance().getConnStrategyListByHost(parse.host());
            if (!list.isEmpty()) {
                boolean equalsIgnoreCase = "https".equalsIgnoreCase(parse.scheme());
                boolean b10 = anet.channel.util.c.b();
                ListIterator<IConnStrategy> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    IConnStrategy next = listIterator.next();
                    ConnType valueOf = ConnType.valueOf(next.getProtocol());
                    if (valueOf != null) {
                        if (valueOf.isSSL() == equalsIgnoreCase) {
                            if (i10 == anet.channel.entity.c.f3711c || valueOf.getType() == i10) {
                                if (b10 && d.b(next.getIp())) {
                                    listIterator.remove();
                                }
                            }
                        }
                        listIterator.remove();
                    }
                }
            }
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.SessionRequest", "[getAvailStrategy]", str, "strategies", list);
            }
            return list;
        } catch (Throwable th) {
            ALog.e("awcn.SessionRequest", "", str, th, new Object[0]);
        }
    }

    private List<anet.channel.entity.a> a(List<IConnStrategy> list, String str) {
        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            IConnStrategy iConnStrategy = list.get(i11);
            int retryTimes = iConnStrategy.getRetryTimes();
            for (int i12 = 0; i12 <= retryTimes; i12++) {
                i10++;
                String a10 = a();
                anet.channel.entity.a aVar = new anet.channel.entity.a(a10, str + "_" + i10, iConnStrategy);
                aVar.f3702b = i12;
                aVar.f3703c = retryTimes;
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void a(Context context, anet.channel.entity.a aVar, IConnCb iConnCb, String str) {
        ConnType c10 = aVar.c();
        if (context == null || c10.isHttpType()) {
            this.f3591e = new anet.channel.session.d(context, aVar);
        } else {
            TnetSpdySession tnetSpdySession = new TnetSpdySession(context, aVar);
            tnetSpdySession.initConfig(this.f3587a.f3579d);
            tnetSpdySession.initSessionInfo(this.f3589c);
            tnetSpdySession.setTnetPublicKey(this.f3587a.f3582g.c(this.f3596j));
            this.f3591e = tnetSpdySession;
        }
        ALog.i("awcn.SessionRequest", "create connection...", str, "Host", a(), "Type", aVar.c(), "IP", aVar.a(), "Port", Integer.valueOf(aVar.b()), "heartbeat", Integer.valueOf(aVar.g()), "session", this.f3591e);
        a(this.f3591e, iConnCb, System.currentTimeMillis());
        this.f3591e.connect();
        SessionConnStat sessionConnStat = this.f3594h;
        sessionConnStat.retryTimes++;
        sessionConnStat.startConnect = System.currentTimeMillis();
        SessionConnStat sessionConnStat2 = this.f3594h;
        if (sessionConnStat2.retryTimes == 0) {
            sessionConnStat2.putExtra("firstIp", aVar.a());
        }
    }

    private void a(Session session, IConnCb iConnCb, long j10) {
        if (iConnCb != null) {
            session.registerEventcb(EventType.ALL, new f(this, iConnCb, j10));
            session.registerEventcb(1792, new g(this, session));
        }
    }

    public void a(String str) {
        ALog.d("awcn.SessionRequest", "reCreateSession", str, Constants.KEY_HOST, this.f3595i);
        b(true);
    }

    public void a(long j10) {
        ALog.d("awcn.SessionRequest", "[await]", (String) null, "timeoutMs", Long.valueOf(j10));
        if (j10 > 0) {
            synchronized (this.f3598l) {
                long currentTimeMillis = System.currentTimeMillis() + j10;
                while (true) {
                    if (!this.f3590d) {
                        break;
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (currentTimeMillis2 >= currentTimeMillis) {
                        break;
                    }
                    this.f3598l.wait(currentTimeMillis - currentTimeMillis2);
                }
                if (this.f3590d) {
                    throw new TimeoutException();
                }
            }
        }
    }

    public void a(Session session, int i10, String str) {
        if (AwcnConfig.isSendConnectInfoByService()) {
            b(session, i10, str);
        }
        c(session, i10, str);
    }
}
