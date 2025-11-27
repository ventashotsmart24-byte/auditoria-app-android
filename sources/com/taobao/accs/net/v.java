package com.taobao.accs.net;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.strategy.IConnStrategy;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.cybergarage.http.HTTPServer;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.cybergarage.upnp.Service;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.ut.a.c;
import com.taobao.accs.ut.a.d;
import com.taobao.accs.ut.monitor.SessionMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.k;
import com.taobao.accs.utl.q;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.android.spdy.RequestPriority;
import org.android.spdy.SessionCb;
import org.android.spdy.SessionInfo;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyByteArray;
import org.android.spdy.SpdyDataProvider;
import org.android.spdy.SpdyRequest;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.Spdycb;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;

public class v extends a implements SessionCb, Spdycb {
    /* access modifiers changed from: private */
    public SpdySession A = null;
    private Object B = new Object();
    /* access modifiers changed from: private */
    public long C;
    /* access modifiers changed from: private */
    public long D;
    private long E;
    private long F;
    private int G = -1;
    private String H = null;
    /* access modifiers changed from: private */
    public SessionMonitor I;
    private c J;
    /* access modifiers changed from: private */
    public boolean K = false;
    /* access modifiers changed from: private */
    public String L = "";
    /* access modifiers changed from: private */
    public boolean M = false;
    /* access modifiers changed from: private */
    public h N = new h(p());
    /* access modifiers changed from: private */
    public String O;

    /* renamed from: o  reason: collision with root package name */
    protected ScheduledFuture<?> f13097o;

    /* renamed from: p  reason: collision with root package name */
    protected String f13098p;

    /* renamed from: q  reason: collision with root package name */
    protected int f13099q;

    /* renamed from: r  reason: collision with root package name */
    protected String f13100r;

    /* renamed from: s  reason: collision with root package name */
    protected int f13101s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public int f13102t = 3;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public LinkedList<Message> f13103u = new LinkedList<>();

    /* renamed from: v  reason: collision with root package name */
    private a f13104v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public boolean f13105w = true;

    /* renamed from: x  reason: collision with root package name */
    private String f13106x;

    /* renamed from: y  reason: collision with root package name */
    private String f13107y;

    /* renamed from: z  reason: collision with root package name */
    private SpdyAgent f13108z = null;

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public int f13109a = 0;

        /* renamed from: b  reason: collision with root package name */
        long f13110b;

        /* renamed from: d  reason: collision with root package name */
        private final String f13112d = getName();

        public a(String str) {
            super(str);
        }

        private void a(boolean z10) {
            if (v.this.f13102t != 1) {
                ALog.d(v.this.d(), "tryConnect", "force", Boolean.valueOf(z10));
                if (!UtilityImpl.i(v.this.f13028d)) {
                    ALog.e(this.f13112d, "Network not available", new Object[0]);
                    return;
                }
                if (z10) {
                    this.f13109a = 0;
                }
                ALog.i(this.f13112d, "tryConnect", "force", Boolean.valueOf(z10), "failTimes", Integer.valueOf(this.f13109a));
                if (v.this.f13102t != 1 && this.f13109a >= 4) {
                    boolean unused = v.this.K = true;
                    ALog.e(this.f13112d, "tryConnect fail", "maxTimes", 4);
                } else if (v.this.f13102t != 1) {
                    if (v.this.f13027c == 1 && this.f13109a == 0) {
                        ALog.i(this.f13112d, "tryConnect in app, no sleep", new Object[0]);
                    } else {
                        ALog.i(this.f13112d, "tryConnect, need sleep", new Object[0]);
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e10) {
                            e10.printStackTrace();
                        }
                    }
                    String unused2 = v.this.L = "";
                    if (this.f13109a == 3) {
                        v.this.N.b(v.this.p());
                    }
                    v.this.d((String) null);
                    v.this.I.setRetryTimes(this.f13109a);
                    if (v.this.f13102t != 1) {
                        this.f13109a++;
                        ALog.e(this.f13112d, "try connect fail, ready for reconnect", new Object[0]);
                        a(false);
                        return;
                    }
                    this.f13110b = System.currentTimeMillis();
                }
            } else if (v.this.f13102t == 1 && System.currentTimeMillis() - this.f13110b > 5000) {
                this.f13109a = 0;
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
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
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
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
            */
        public void run() {
            /*
                r21 = this;
                r1 = r21
                java.lang.String r0 = r1.f13112d
                java.lang.String r2 = "NetworkThread run"
                r3 = 0
                java.lang.Object[] r4 = new java.lang.Object[r3]
                com.taobao.accs.utl.ALog.i(r0, r2, r4)
                r1.f13109a = r3
                r0 = 0
            L_0x000f:
                com.taobao.accs.net.v r2 = com.taobao.accs.net.v.this
                boolean r2 = r2.f13105w
                if (r2 == 0) goto L_0x04f9
                java.lang.String r2 = r1.f13112d
                java.lang.String r4 = "ready to get message"
                java.lang.Object[] r5 = new java.lang.Object[r3]
                com.taobao.accs.utl.ALog.d(r2, r4, r5)
                com.taobao.accs.net.v r2 = com.taobao.accs.net.v.this
                java.util.LinkedList r2 = r2.f13103u
                monitor-enter(r2)
                com.taobao.accs.net.v r4 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x04f6 }
                java.util.LinkedList r4 = r4.f13103u     // Catch:{ all -> 0x04f6 }
                int r4 = r4.size()     // Catch:{ all -> 0x04f6 }
                if (r4 != 0) goto L_0x004d
                java.lang.String r4 = r1.f13112d     // Catch:{ InterruptedException -> 0x0046 }
                java.lang.String r5 = "no message, wait"
                java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ InterruptedException -> 0x0046 }
                com.taobao.accs.utl.ALog.d(r4, r5, r6)     // Catch:{ InterruptedException -> 0x0046 }
                com.taobao.accs.net.v r4 = com.taobao.accs.net.v.this     // Catch:{ InterruptedException -> 0x0046 }
                java.util.LinkedList r4 = r4.f13103u     // Catch:{ InterruptedException -> 0x0046 }
                r4.wait()     // Catch:{ InterruptedException -> 0x0046 }
                goto L_0x004d
            L_0x0046:
                r0 = move-exception
                r0.printStackTrace()     // Catch:{ all -> 0x04f6 }
                monitor-exit(r2)     // Catch:{ all -> 0x04f6 }
                goto L_0x04f9
            L_0x004d:
                java.lang.String r4 = r1.f13112d     // Catch:{ all -> 0x04f6 }
                java.lang.String r5 = "try get message"
                java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ all -> 0x04f6 }
                com.taobao.accs.utl.ALog.d(r4, r5, r6)     // Catch:{ all -> 0x04f6 }
                com.taobao.accs.net.v r4 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x04f6 }
                java.util.LinkedList r4 = r4.f13103u     // Catch:{ all -> 0x04f6 }
                int r4 = r4.size()     // Catch:{ all -> 0x04f6 }
                if (r4 == 0) goto L_0x007b
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x04f6 }
                java.util.LinkedList r0 = r0.f13103u     // Catch:{ all -> 0x04f6 }
                java.lang.Object r0 = r0.getFirst()     // Catch:{ all -> 0x04f6 }
                com.taobao.accs.data.Message r0 = (com.taobao.accs.data.Message) r0     // Catch:{ all -> 0x04f6 }
                com.taobao.accs.ut.monitor.NetPerformanceMonitor r4 = r0.getNetPermanceMonitor()     // Catch:{ all -> 0x04f6 }
                if (r4 == 0) goto L_0x007b
                com.taobao.accs.ut.monitor.NetPerformanceMonitor r4 = r0.getNetPermanceMonitor()     // Catch:{ all -> 0x04f6 }
                r4.onTakeFromQueue()     // Catch:{ all -> 0x04f6 }
            L_0x007b:
                r4 = r0
                monitor-exit(r2)     // Catch:{ all -> 0x04f6 }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this
                boolean r0 = r0.f13105w
                if (r0 != 0) goto L_0x0087
                goto L_0x04f9
            L_0x0087:
                if (r4 == 0) goto L_0x04f3
                java.lang.String r0 = r1.f13112d
                java.lang.String r2 = "sendMessage not null"
                java.lang.Object[] r5 = new java.lang.Object[r3]
                com.taobao.accs.utl.ALog.d(r0, r2, r5)
                r2 = 201(0xc9, float:2.82E-43)
                r5 = 100
                r6 = -1
                r7 = 1
                int r0 = r4.getType()     // Catch:{ all -> 0x037c }
                java.lang.String r8 = r1.f13112d     // Catch:{ all -> 0x037c }
                java.lang.String r9 = "sendMessage"
                r10 = 4
                java.lang.Object[] r11 = new java.lang.Object[r10]     // Catch:{ all -> 0x037c }
                java.lang.String r12 = "type"
                r11[r3] = r12     // Catch:{ all -> 0x037c }
                java.lang.String r12 = com.taobao.accs.data.Message.MsgType.name(r0)     // Catch:{ all -> 0x037c }
                r11[r7] = r12     // Catch:{ all -> 0x037c }
                java.lang.String r12 = "status"
                r13 = 2
                r11[r13] = r12     // Catch:{ all -> 0x037c }
                com.taobao.accs.net.v r12 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                int r12 = r12.f13102t     // Catch:{ all -> 0x037c }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x037c }
                r14 = 3
                r11[r14] = r12     // Catch:{ all -> 0x037c }
                com.taobao.accs.utl.ALog.i(r8, r9, r11)     // Catch:{ all -> 0x037c }
                if (r0 != r13) goto L_0x01be
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                int r0 = r0.f13027c     // Catch:{ all -> 0x037c }
                if (r0 != r7) goto L_0x00fe
                java.lang.String r0 = r1.f13112d     // Catch:{ all -> 0x037c }
                java.lang.String r8 = "sendMessage INAPP ping, skip"
                java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ all -> 0x037c }
                com.taobao.accs.utl.ALog.d(r0, r8, r9)     // Catch:{ all -> 0x037c }
                java.lang.String r0 = r1.f13112d     // Catch:{ all -> 0x00f2 }
                java.lang.String r2 = "send succ, remove it"
                java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ all -> 0x00f2 }
                com.taobao.accs.utl.ALog.d(r0, r2, r5)     // Catch:{ all -> 0x00f2 }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x00f2 }
                java.util.LinkedList r2 = r0.f13103u     // Catch:{ all -> 0x00f2 }
                monitor-enter(r2)     // Catch:{ all -> 0x00f2 }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x00ef }
                java.util.LinkedList r0 = r0.f13103u     // Catch:{ all -> 0x00ef }
                r0.remove(r4)     // Catch:{ all -> 0x00ef }
                monitor-exit(r2)     // Catch:{ all -> 0x00ef }
                goto L_0x04f3
            L_0x00ef:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x00ef }
                throw r0     // Catch:{ all -> 0x00f2 }
            L_0x00f2:
                r0 = move-exception
                java.lang.String r2 = r1.f13112d
                java.lang.String r5 = " run finally error"
                java.lang.Object[] r6 = new java.lang.Object[r3]
                com.taobao.accs.utl.ALog.e(r2, r5, r0, r6)
                goto L_0x04f3
            L_0x00fe:
                long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x037c }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                long r11 = r0.C     // Catch:{ all -> 0x037c }
                long r8 = r8 - r11
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                android.content.Context r0 = r0.f13028d     // Catch:{ all -> 0x037c }
                com.taobao.accs.net.g r0 = com.taobao.accs.net.g.a((android.content.Context) r0)     // Catch:{ all -> 0x037c }
                int r0 = r0.b()     // Catch:{ all -> 0x037c }
                int r0 = r0 - r7
                int r0 = r0 * 1000
                long r11 = (long) r0     // Catch:{ all -> 0x037c }
                int r0 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
                if (r0 >= 0) goto L_0x0127
                boolean r0 = r4.force     // Catch:{ all -> 0x037c }
                if (r0 == 0) goto L_0x0122
                goto L_0x0127
            L_0x0122:
                r1.a(r3)     // Catch:{ all -> 0x037c }
                goto L_0x02d0
            L_0x0127:
                java.lang.String r0 = r1.f13112d     // Catch:{ all -> 0x037c }
                java.lang.String r8 = "sendMessage"
                java.lang.Object[] r9 = new java.lang.Object[r10]     // Catch:{ all -> 0x037c }
                java.lang.String r10 = "force"
                r9[r3] = r10     // Catch:{ all -> 0x037c }
                boolean r10 = r4.force     // Catch:{ all -> 0x037c }
                java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)     // Catch:{ all -> 0x037c }
                r9[r7] = r10     // Catch:{ all -> 0x037c }
                java.lang.String r10 = "last ping"
                r9[r13] = r10     // Catch:{ all -> 0x037c }
                long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x037c }
                com.taobao.accs.net.v r12 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                long r12 = r12.C     // Catch:{ all -> 0x037c }
                long r10 = r10 - r12
                java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x037c }
                r9[r14] = r10     // Catch:{ all -> 0x037c }
                com.taobao.accs.utl.ALog.d(r0, r8, r9)     // Catch:{ all -> 0x037c }
                r1.a(r7)     // Catch:{ all -> 0x037c }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                org.android.spdy.SpdySession r0 = r0.A     // Catch:{ all -> 0x037c }
                if (r0 == 0) goto L_0x02b8
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                int r0 = r0.f13102t     // Catch:{ all -> 0x037c }
                if (r0 != r7) goto L_0x02b8
                long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x037c }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                long r10 = r0.C     // Catch:{ all -> 0x037c }
                long r8 = r8 - r10
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                android.content.Context r0 = r0.f13028d     // Catch:{ all -> 0x037c }
                com.taobao.accs.net.g r0 = com.taobao.accs.net.g.a((android.content.Context) r0)     // Catch:{ all -> 0x037c }
                int r0 = r0.b()     // Catch:{ all -> 0x037c }
                int r0 = r0 - r7
                int r0 = r0 * 1000
                long r10 = (long) r0     // Catch:{ all -> 0x037c }
                int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r0 < 0) goto L_0x02d0
                java.lang.String r0 = r1.f13112d     // Catch:{ all -> 0x037c }
                java.lang.String r8 = "sendMessage onSendPing"
                java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ all -> 0x037c }
                com.taobao.accs.utl.ALog.i(r0, r8, r9)     // Catch:{ all -> 0x037c }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                com.taobao.accs.data.d r0 = r0.f13029e     // Catch:{ all -> 0x037c }
                r0.a()     // Catch:{ all -> 0x037c }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                org.android.spdy.SpdySession r0 = r0.A     // Catch:{ all -> 0x037c }
                r0.submitPing()     // Catch:{ all -> 0x037c }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                com.taobao.accs.ut.monitor.SessionMonitor r0 = r0.I     // Catch:{ all -> 0x037c }
                r0.onSendPing()     // Catch:{ all -> 0x037c }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x037c }
                long unused = r0.C = r8     // Catch:{ all -> 0x037c }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                long r8 = java.lang.System.nanoTime()     // Catch:{ all -> 0x037c }
                long unused = r0.D = r8     // Catch:{ all -> 0x037c }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                r0.f()     // Catch:{ all -> 0x037c }
                goto L_0x02d0
            L_0x01be:
                if (r0 != r7) goto L_0x02ba
                r1.a(r7)     // Catch:{ all -> 0x037c }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                int r0 = r0.f13102t     // Catch:{ all -> 0x037c }
                if (r0 != r7) goto L_0x02b8
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                org.android.spdy.SpdySession r0 = r0.A     // Catch:{ all -> 0x037c }
                if (r0 == 0) goto L_0x02b8
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                android.content.Context r8 = r0.f13028d     // Catch:{ all -> 0x037c }
                int r0 = r0.f13027c     // Catch:{ all -> 0x037c }
                byte[] r0 = r4.build(r8, r0)     // Catch:{ all -> 0x037c }
                long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x037c }
                r4.setSendTime(r8)     // Catch:{ all -> 0x037c }
                int r8 = r0.length     // Catch:{ all -> 0x037c }
                r9 = 49152(0xc000, float:6.8877E-41)
                if (r8 <= r9) goto L_0x01fe
                java.lang.Integer r8 = r4.command     // Catch:{ all -> 0x037c }
                int r8 = r8.intValue()     // Catch:{ all -> 0x037c }
                r9 = 102(0x66, float:1.43E-43)
                if (r8 == r9) goto L_0x01fe
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                com.taobao.accs.data.d r0 = r0.f13029e     // Catch:{ all -> 0x037c }
                r8 = -4
                r0.a((com.taobao.accs.data.Message) r4, (int) r8)     // Catch:{ all -> 0x037c }
                goto L_0x02d0
            L_0x01fe:
                boolean r8 = r4.isAck     // Catch:{ all -> 0x037c }
                if (r8 == 0) goto L_0x020c
                com.taobao.accs.data.Message$Id r8 = r4.getMsgId()     // Catch:{ all -> 0x037c }
                int r8 = r8.getId()     // Catch:{ all -> 0x037c }
                int r8 = -r8
                goto L_0x0214
            L_0x020c:
                com.taobao.accs.data.Message$Id r8 = r4.getMsgId()     // Catch:{ all -> 0x037c }
                int r8 = r8.getId()     // Catch:{ all -> 0x037c }
            L_0x0214:
                com.taobao.accs.net.v r9 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                org.android.spdy.SpdySession r15 = r9.A     // Catch:{ all -> 0x037c }
                r17 = 200(0xc8, float:2.8E-43)
                r18 = 0
                int r9 = r0.length     // Catch:{ all -> 0x037c }
                r16 = r8
                r19 = r9
                r20 = r0
                r15.sendCustomControlFrame(r16, r17, r18, r19, r20)     // Catch:{ all -> 0x037c }
                java.lang.String r9 = r1.f13112d     // Catch:{ all -> 0x037c }
                java.lang.String r11 = "send data"
                r12 = 6
                java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ all -> 0x037c }
                java.lang.String r15 = "length"
                r12[r3] = r15     // Catch:{ all -> 0x037c }
                int r15 = r0.length     // Catch:{ all -> 0x037c }
                java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x037c }
                r12[r7] = r15     // Catch:{ all -> 0x037c }
                java.lang.String r15 = "dataId"
                r12[r13] = r15     // Catch:{ all -> 0x037c }
                java.lang.String r15 = r4.getDataId()     // Catch:{ all -> 0x037c }
                r12[r14] = r15     // Catch:{ all -> 0x037c }
                java.lang.String r14 = "utdid"
                r12[r10] = r14     // Catch:{ all -> 0x037c }
                com.taobao.accs.net.v r10 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                java.lang.String r10 = r10.f13034j     // Catch:{ all -> 0x037c }
                r14 = 5
                r12[r14] = r10     // Catch:{ all -> 0x037c }
                com.taobao.accs.utl.ALog.e(r9, r11, r12)     // Catch:{ all -> 0x037c }
                com.taobao.accs.net.v r9 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                com.taobao.accs.data.d r9 = r9.f13029e     // Catch:{ all -> 0x037c }
                r9.a((com.taobao.accs.data.Message) r4)     // Catch:{ all -> 0x037c }
                boolean r9 = r4.isAck     // Catch:{ all -> 0x037c }
                if (r9 == 0) goto L_0x027b
                java.lang.String r9 = r1.f13112d     // Catch:{ all -> 0x037c }
                java.lang.String r10 = "sendCFrame end ack"
                java.lang.Object[] r11 = new java.lang.Object[r13]     // Catch:{ all -> 0x037c }
                java.lang.String r12 = "dataId"
                r11[r3] = r12     // Catch:{ all -> 0x037c }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x037c }
                r11[r7] = r12     // Catch:{ all -> 0x037c }
                com.taobao.accs.utl.ALog.e(r9, r10, r11)     // Catch:{ all -> 0x037c }
                com.taobao.accs.net.v r9 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                java.util.LinkedHashMap<java.lang.Integer, com.taobao.accs.data.Message> r9 = r9.f13036l     // Catch:{ all -> 0x037c }
                java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x037c }
                r9.put(r8, r4)     // Catch:{ all -> 0x037c }
            L_0x027b:
                com.taobao.accs.ut.monitor.NetPerformanceMonitor r8 = r4.getNetPermanceMonitor()     // Catch:{ all -> 0x037c }
                if (r8 == 0) goto L_0x0288
                com.taobao.accs.ut.monitor.NetPerformanceMonitor r8 = r4.getNetPermanceMonitor()     // Catch:{ all -> 0x037c }
                r8.onSendData()     // Catch:{ all -> 0x037c }
            L_0x0288:
                com.taobao.accs.net.v r8 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                java.lang.String r9 = r4.getDataId()     // Catch:{ all -> 0x037c }
                com.taobao.accs.net.v r10 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                com.taobao.accs.AccsClientConfig r10 = r10.f13033i     // Catch:{ all -> 0x037c }
                boolean r10 = r10.isQuickReconnect()     // Catch:{ all -> 0x037c }
                int r11 = r4.timeout     // Catch:{ all -> 0x037c }
                long r11 = (long) r11     // Catch:{ all -> 0x037c }
                r8.a((java.lang.String) r9, (boolean) r10, (long) r11)     // Catch:{ all -> 0x037c }
                com.taobao.accs.net.v r8 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                com.taobao.accs.data.d r8 = r8.f13029e     // Catch:{ all -> 0x037c }
                com.taobao.accs.ut.monitor.TrafficsMonitor$a r15 = new com.taobao.accs.ut.monitor.TrafficsMonitor$a     // Catch:{ all -> 0x037c }
                java.lang.String r10 = r4.serviceId     // Catch:{ all -> 0x037c }
                boolean r11 = anet.channel.GlobalAppRuntimeInfo.isAppBackground()     // Catch:{ all -> 0x037c }
                com.taobao.accs.net.v r9 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037c }
                java.lang.String r12 = r9.p()     // Catch:{ all -> 0x037c }
                int r0 = r0.length     // Catch:{ all -> 0x037c }
                long r13 = (long) r0     // Catch:{ all -> 0x037c }
                r9 = r15
                r9.<init>(r10, r11, r12, r13)     // Catch:{ all -> 0x037c }
                r8.a((com.taobao.accs.ut.monitor.TrafficsMonitor.a) r15)     // Catch:{ all -> 0x037c }
                goto L_0x02d0
            L_0x02b8:
                r8 = 0
                goto L_0x02d1
            L_0x02ba:
                r1.a(r3)     // Catch:{ all -> 0x037c }
                java.lang.String r8 = r1.f13112d     // Catch:{ all -> 0x037c }
                java.lang.String r9 = "skip msg"
                java.lang.Object[] r10 = new java.lang.Object[r13]     // Catch:{ all -> 0x037c }
                java.lang.String r11 = "type"
                r10[r3] = r11     // Catch:{ all -> 0x037c }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x037c }
                r10[r7] = r0     // Catch:{ all -> 0x037c }
                com.taobao.accs.utl.ALog.e(r8, r9, r10)     // Catch:{ all -> 0x037c }
            L_0x02d0:
                r8 = 1
            L_0x02d1:
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x037a }
                r0.t()     // Catch:{ all -> 0x037a }
                if (r8 != 0) goto L_0x034f
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x036e }
                r0.o()     // Catch:{ all -> 0x036e }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x036e }
                com.taobao.accs.ut.monitor.SessionMonitor r0 = r0.I     // Catch:{ all -> 0x036e }
                if (r0 == 0) goto L_0x02f0
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x036e }
                com.taobao.accs.ut.monitor.SessionMonitor r0 = r0.I     // Catch:{ all -> 0x036e }
                java.lang.String r8 = "send fail"
                r0.setCloseReason(r8)     // Catch:{ all -> 0x036e }
            L_0x02f0:
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x036e }
                java.util.LinkedList r8 = r0.f13103u     // Catch:{ all -> 0x036e }
                monitor-enter(r8)     // Catch:{ all -> 0x036e }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x034c }
                java.util.LinkedList r0 = r0.f13103u     // Catch:{ all -> 0x034c }
                int r0 = r0.size()     // Catch:{ all -> 0x034c }
                int r0 = r0 - r7
            L_0x0302:
                if (r0 < 0) goto L_0x0337
                com.taobao.accs.net.v r7 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x034c }
                java.util.LinkedList r7 = r7.f13103u     // Catch:{ all -> 0x034c }
                java.lang.Object r7 = r7.get(r0)     // Catch:{ all -> 0x034c }
                com.taobao.accs.data.Message r7 = (com.taobao.accs.data.Message) r7     // Catch:{ all -> 0x034c }
                if (r7 == 0) goto L_0x0334
                java.lang.Integer r9 = r7.command     // Catch:{ all -> 0x034c }
                if (r9 == 0) goto L_0x0334
                int r9 = r9.intValue()     // Catch:{ all -> 0x034c }
                if (r9 == r5) goto L_0x0324
                java.lang.Integer r9 = r7.command     // Catch:{ all -> 0x034c }
                int r9 = r9.intValue()     // Catch:{ all -> 0x034c }
                if (r9 != r2) goto L_0x0334
            L_0x0324:
                com.taobao.accs.net.v r9 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x034c }
                com.taobao.accs.data.d r9 = r9.f13029e     // Catch:{ all -> 0x034c }
                r9.a((com.taobao.accs.data.Message) r7, (int) r6)     // Catch:{ all -> 0x034c }
                com.taobao.accs.net.v r7 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x034c }
                java.util.LinkedList r7 = r7.f13103u     // Catch:{ all -> 0x034c }
                r7.remove(r0)     // Catch:{ all -> 0x034c }
            L_0x0334:
                int r0 = r0 + -1
                goto L_0x0302
            L_0x0337:
                java.lang.String r0 = r1.f13112d     // Catch:{ all -> 0x034c }
                java.lang.String r2 = "network disconnected, wait"
                java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ all -> 0x034c }
                com.taobao.accs.utl.ALog.e(r0, r2, r5)     // Catch:{ all -> 0x034c }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x034c }
                java.util.LinkedList r0 = r0.f13103u     // Catch:{ all -> 0x034c }
                r0.wait()     // Catch:{ all -> 0x034c }
                monitor-exit(r8)     // Catch:{ all -> 0x034c }
                goto L_0x04f3
            L_0x034c:
                r0 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x034c }
                throw r0     // Catch:{ all -> 0x036e }
            L_0x034f:
                java.lang.String r0 = r1.f13112d     // Catch:{ all -> 0x036e }
                java.lang.String r2 = "send succ, remove it"
                java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ all -> 0x036e }
                com.taobao.accs.utl.ALog.d(r0, r2, r5)     // Catch:{ all -> 0x036e }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x036e }
                java.util.LinkedList r2 = r0.f13103u     // Catch:{ all -> 0x036e }
                monitor-enter(r2)     // Catch:{ all -> 0x036e }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x036b }
                java.util.LinkedList r0 = r0.f13103u     // Catch:{ all -> 0x036b }
                r0.remove(r4)     // Catch:{ all -> 0x036b }
                monitor-exit(r2)     // Catch:{ all -> 0x036b }
                goto L_0x04f3
            L_0x036b:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x036b }
                throw r0     // Catch:{ all -> 0x036e }
            L_0x036e:
                r0 = move-exception
                java.lang.String r2 = r1.f13112d
                java.lang.String r5 = " run finally error"
                java.lang.Object[] r6 = new java.lang.Object[r3]
                com.taobao.accs.utl.ALog.e(r2, r5, r0, r6)
                goto L_0x04f3
            L_0x037a:
                r0 = move-exception
                goto L_0x037e
            L_0x037c:
                r0 = move-exception
                r8 = 1
            L_0x037e:
                java.lang.String r9 = "accs"
                java.lang.String r10 = "send_fail"
                java.lang.String r11 = r4.serviceId     // Catch:{ all -> 0x0450 }
                java.lang.String r12 = "1"
                java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0450 }
                r13.<init>()     // Catch:{ all -> 0x0450 }
                com.taobao.accs.net.v r14 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x0450 }
                int r14 = r14.f13027c     // Catch:{ all -> 0x0450 }
                r13.append(r14)     // Catch:{ all -> 0x0450 }
                java.lang.String r14 = r0.toString()     // Catch:{ all -> 0x0450 }
                r13.append(r14)     // Catch:{ all -> 0x0450 }
                java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0450 }
                com.taobao.accs.utl.k.a(r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0450 }
                r0.printStackTrace()     // Catch:{ all -> 0x0450 }
                java.lang.String r9 = r1.f13112d     // Catch:{ all -> 0x0450 }
                java.lang.String r10 = "service connection run"
                java.lang.Object[] r11 = new java.lang.Object[r3]     // Catch:{ all -> 0x0450 }
                com.taobao.accs.utl.ALog.e(r9, r10, r0, r11)     // Catch:{ all -> 0x0450 }
                if (r8 != 0) goto L_0x0425
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x0444 }
                r0.o()     // Catch:{ all -> 0x0444 }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x0444 }
                com.taobao.accs.ut.monitor.SessionMonitor r0 = r0.I     // Catch:{ all -> 0x0444 }
                if (r0 == 0) goto L_0x03c6
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x0444 }
                com.taobao.accs.ut.monitor.SessionMonitor r0 = r0.I     // Catch:{ all -> 0x0444 }
                java.lang.String r8 = "send fail"
                r0.setCloseReason(r8)     // Catch:{ all -> 0x0444 }
            L_0x03c6:
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x0444 }
                java.util.LinkedList r8 = r0.f13103u     // Catch:{ all -> 0x0444 }
                monitor-enter(r8)     // Catch:{ all -> 0x0444 }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x0422 }
                java.util.LinkedList r0 = r0.f13103u     // Catch:{ all -> 0x0422 }
                int r0 = r0.size()     // Catch:{ all -> 0x0422 }
                int r0 = r0 - r7
            L_0x03d8:
                if (r0 < 0) goto L_0x040d
                com.taobao.accs.net.v r7 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x0422 }
                java.util.LinkedList r7 = r7.f13103u     // Catch:{ all -> 0x0422 }
                java.lang.Object r7 = r7.get(r0)     // Catch:{ all -> 0x0422 }
                com.taobao.accs.data.Message r7 = (com.taobao.accs.data.Message) r7     // Catch:{ all -> 0x0422 }
                if (r7 == 0) goto L_0x040a
                java.lang.Integer r9 = r7.command     // Catch:{ all -> 0x0422 }
                if (r9 == 0) goto L_0x040a
                int r9 = r9.intValue()     // Catch:{ all -> 0x0422 }
                if (r9 == r5) goto L_0x03fa
                java.lang.Integer r9 = r7.command     // Catch:{ all -> 0x0422 }
                int r9 = r9.intValue()     // Catch:{ all -> 0x0422 }
                if (r9 != r2) goto L_0x040a
            L_0x03fa:
                com.taobao.accs.net.v r9 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x0422 }
                com.taobao.accs.data.d r9 = r9.f13029e     // Catch:{ all -> 0x0422 }
                r9.a((com.taobao.accs.data.Message) r7, (int) r6)     // Catch:{ all -> 0x0422 }
                com.taobao.accs.net.v r7 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x0422 }
                java.util.LinkedList r7 = r7.f13103u     // Catch:{ all -> 0x0422 }
                r7.remove(r0)     // Catch:{ all -> 0x0422 }
            L_0x040a:
                int r0 = r0 + -1
                goto L_0x03d8
            L_0x040d:
                java.lang.String r0 = r1.f13112d     // Catch:{ all -> 0x0422 }
                java.lang.String r2 = "network disconnected, wait"
                java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ all -> 0x0422 }
                com.taobao.accs.utl.ALog.e(r0, r2, r5)     // Catch:{ all -> 0x0422 }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x0422 }
                java.util.LinkedList r0 = r0.f13103u     // Catch:{ all -> 0x0422 }
                r0.wait()     // Catch:{ all -> 0x0422 }
                monitor-exit(r8)     // Catch:{ all -> 0x0422 }
                goto L_0x04f3
            L_0x0422:
                r0 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x0422 }
                throw r0     // Catch:{ all -> 0x0444 }
            L_0x0425:
                java.lang.String r0 = r1.f13112d     // Catch:{ all -> 0x0444 }
                java.lang.String r2 = "send succ, remove it"
                java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ all -> 0x0444 }
                com.taobao.accs.utl.ALog.d(r0, r2, r5)     // Catch:{ all -> 0x0444 }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x0444 }
                java.util.LinkedList r2 = r0.f13103u     // Catch:{ all -> 0x0444 }
                monitor-enter(r2)     // Catch:{ all -> 0x0444 }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x0441 }
                java.util.LinkedList r0 = r0.f13103u     // Catch:{ all -> 0x0441 }
                r0.remove(r4)     // Catch:{ all -> 0x0441 }
                monitor-exit(r2)     // Catch:{ all -> 0x0441 }
                goto L_0x04f3
            L_0x0441:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0441 }
                throw r0     // Catch:{ all -> 0x0444 }
            L_0x0444:
                r0 = move-exception
                java.lang.String r2 = r1.f13112d
                java.lang.String r5 = " run finally error"
                java.lang.Object[] r6 = new java.lang.Object[r3]
                com.taobao.accs.utl.ALog.e(r2, r5, r0, r6)
                goto L_0x04f3
            L_0x0450:
                r0 = move-exception
                r9 = r0
                if (r8 != 0) goto L_0x04ca
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x04e8 }
                r0.o()     // Catch:{ all -> 0x04e8 }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x04e8 }
                com.taobao.accs.ut.monitor.SessionMonitor r0 = r0.I     // Catch:{ all -> 0x04e8 }
                if (r0 == 0) goto L_0x046c
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x04e8 }
                com.taobao.accs.ut.monitor.SessionMonitor r0 = r0.I     // Catch:{ all -> 0x04e8 }
                java.lang.String r4 = "send fail"
                r0.setCloseReason(r4)     // Catch:{ all -> 0x04e8 }
            L_0x046c:
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x04e8 }
                java.util.LinkedList r4 = r0.f13103u     // Catch:{ all -> 0x04e8 }
                monitor-enter(r4)     // Catch:{ all -> 0x04e8 }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x04c7 }
                java.util.LinkedList r0 = r0.f13103u     // Catch:{ all -> 0x04c7 }
                int r0 = r0.size()     // Catch:{ all -> 0x04c7 }
                int r0 = r0 - r7
            L_0x047e:
                if (r0 < 0) goto L_0x04b3
                com.taobao.accs.net.v r7 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x04c7 }
                java.util.LinkedList r7 = r7.f13103u     // Catch:{ all -> 0x04c7 }
                java.lang.Object r7 = r7.get(r0)     // Catch:{ all -> 0x04c7 }
                com.taobao.accs.data.Message r7 = (com.taobao.accs.data.Message) r7     // Catch:{ all -> 0x04c7 }
                if (r7 == 0) goto L_0x04b0
                java.lang.Integer r8 = r7.command     // Catch:{ all -> 0x04c7 }
                if (r8 == 0) goto L_0x04b0
                int r8 = r8.intValue()     // Catch:{ all -> 0x04c7 }
                if (r8 == r5) goto L_0x04a0
                java.lang.Integer r8 = r7.command     // Catch:{ all -> 0x04c7 }
                int r8 = r8.intValue()     // Catch:{ all -> 0x04c7 }
                if (r8 != r2) goto L_0x04b0
            L_0x04a0:
                com.taobao.accs.net.v r8 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x04c7 }
                com.taobao.accs.data.d r8 = r8.f13029e     // Catch:{ all -> 0x04c7 }
                r8.a((com.taobao.accs.data.Message) r7, (int) r6)     // Catch:{ all -> 0x04c7 }
                com.taobao.accs.net.v r7 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x04c7 }
                java.util.LinkedList r7 = r7.f13103u     // Catch:{ all -> 0x04c7 }
                r7.remove(r0)     // Catch:{ all -> 0x04c7 }
            L_0x04b0:
                int r0 = r0 + -1
                goto L_0x047e
            L_0x04b3:
                java.lang.String r0 = r1.f13112d     // Catch:{ all -> 0x04c7 }
                java.lang.String r2 = "network disconnected, wait"
                java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ all -> 0x04c7 }
                com.taobao.accs.utl.ALog.e(r0, r2, r5)     // Catch:{ all -> 0x04c7 }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x04c7 }
                java.util.LinkedList r0 = r0.f13103u     // Catch:{ all -> 0x04c7 }
                r0.wait()     // Catch:{ all -> 0x04c7 }
                monitor-exit(r4)     // Catch:{ all -> 0x04c7 }
                goto L_0x04f2
            L_0x04c7:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x04c7 }
                throw r0     // Catch:{ all -> 0x04e8 }
            L_0x04ca:
                java.lang.String r0 = r1.f13112d     // Catch:{ all -> 0x04e8 }
                java.lang.String r2 = "send succ, remove it"
                java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ all -> 0x04e8 }
                com.taobao.accs.utl.ALog.d(r0, r2, r5)     // Catch:{ all -> 0x04e8 }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x04e8 }
                java.util.LinkedList r2 = r0.f13103u     // Catch:{ all -> 0x04e8 }
                monitor-enter(r2)     // Catch:{ all -> 0x04e8 }
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this     // Catch:{ all -> 0x04e5 }
                java.util.LinkedList r0 = r0.f13103u     // Catch:{ all -> 0x04e5 }
                r0.remove(r4)     // Catch:{ all -> 0x04e5 }
                monitor-exit(r2)     // Catch:{ all -> 0x04e5 }
                goto L_0x04f2
            L_0x04e5:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x04e5 }
                throw r0     // Catch:{ all -> 0x04e8 }
            L_0x04e8:
                r0 = move-exception
                java.lang.String r2 = r1.f13112d
                java.lang.String r4 = " run finally error"
                java.lang.Object[] r3 = new java.lang.Object[r3]
                com.taobao.accs.utl.ALog.e(r2, r4, r0, r3)
            L_0x04f2:
                throw r9
            L_0x04f3:
                r0 = r4
                goto L_0x000f
            L_0x04f6:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x04f6 }
                throw r0
            L_0x04f9:
                com.taobao.accs.net.v r0 = com.taobao.accs.net.v.this
                r0.o()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.v.a.run():void");
        }
    }

    public v(Context context, int i10, String str) {
        super(context, i10, str);
        u();
    }

    private int r() {
        boolean l10 = l();
        if (AccsClientConfig.mEnv == 2) {
            return 0;
        }
        int channelPubKey = this.f13033i.getChannelPubKey();
        if (channelPubKey > 0) {
            ALog.i(d(), "getPublicKeyType use custom pub key", "pubKey", Integer.valueOf(channelPubKey));
            return channelPubKey;
        } else if (l10) {
            return 4;
        } else {
            return 3;
        }
    }

    private void s() {
        if (this.A == null) {
            d(3);
            return;
        }
        try {
            String encode = URLEncoder.encode(UtilityImpl.j(this.f13028d));
            String a10 = UtilityImpl.a(i(), this.f13033i.getAppSecret(), UtilityImpl.j(this.f13028d));
            String c10 = c(this.f13106x);
            ALog.e(d(), BaseMonitor.ALARM_POINT_AUTH, "url", c10);
            this.f13107y = c10;
            if (!a(encode, i(), a10)) {
                ALog.e(d(), "auth param error!", new Object[0]);
                e(-6);
                return;
            }
            SpdyRequest spdyRequest = new SpdyRequest(new URL(c10), "GET", RequestPriority.DEFAULT_PRIORITY, (int) HTTPServer.DEFAULT_TIMEOUT, (int) a.ACCS_RECEIVE_TIMEOUT);
            spdyRequest.setDomain(p());
            this.A.submitRequest(spdyRequest, new SpdyDataProvider((byte[]) null), p(), this);
        } catch (Throwable th) {
            ALog.e(d(), "auth exception ", th, new Object[0]);
            e(-7);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void t() {
        if (this.f13027c != 1) {
            this.C = System.currentTimeMillis();
            this.D = System.nanoTime();
            g.a(this.f13028d).a();
        }
    }

    private void u() {
        try {
            SpdyAgent.enableDebug = ALog.isPrintLog();
            this.f13108z = SpdyAgent.getInstance(this.f13028d, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
            if (SpdyAgent.checkLoadSucc()) {
                q.a();
                return;
            }
            ALog.e(d(), "initClient", new Object[0]);
            this.f13108z = null;
            q.b();
        } catch (Throwable th) {
            ALog.e(d(), "initClient", th, new Object[0]);
        }
    }

    public void bioPingRecvCallback(SpdySession spdySession, int i10) {
        String d10 = d();
        ALog.w(d10, "bioPingRecvCallback uniId:" + i10, new Object[0]);
    }

    public byte[] getSSLMeta(SpdySession spdySession) {
        spdySession.getDomain();
        return UtilityImpl.c();
    }

    public boolean h() {
        return false;
    }

    public void o() {
        ALog.e(d(), " force close!", new Object[0]);
        try {
            this.A.closeSession();
            this.I.setCloseType(1);
        } catch (Exception unused) {
        }
        d(3);
    }

    public String p() {
        String channelHost = this.f13033i.getChannelHost();
        ALog.i(d(), "getChannelHost", Constants.KEY_HOST, channelHost);
        if (channelHost == null) {
            return "";
        }
        return channelHost;
    }

    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        spdySession.getDomain();
        return UtilityImpl.b();
    }

    public boolean q() {
        return this.f13105w;
    }

    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i10, int i11) {
        b(i10);
    }

    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i10, int i11, int i12, int i13, byte[] bArr) {
        String str;
        t();
        ALog.e(d(), "onFrame", "type", Integer.valueOf(i11), "len", Integer.valueOf(bArr.length));
        StringBuilder sb = new StringBuilder();
        if (ALog.isPrintLog(ALog.Level.D) && bArr.length < 512) {
            long currentTimeMillis = System.currentTimeMillis();
            for (byte b10 : bArr) {
                sb.append(Integer.toHexString(b10 & UnsignedBytes.MAX_VALUE));
                sb.append(" ");
            }
            ALog.d(d(), sb + " log time:" + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
        }
        if (i11 == 200) {
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                this.f13029e.a(bArr);
                d g10 = this.f13029e.g();
                if (g10 != null) {
                    g10.f13145c = String.valueOf(currentTimeMillis2);
                    if (this.f13027c == 0) {
                        str = Service.ELEM_NAME;
                    } else {
                        str = "inapp";
                    }
                    g10.f13149g = str;
                    g10.a();
                }
            } catch (Throwable th) {
                ALog.e(d(), "onDataReceive ", th, new Object[0]);
                UTMini.getInstance().commitEvent(66001, "SERVICE_DATA_RECEIVE", UtilityImpl.a(th));
            }
            ALog.d(d(), "try handle msg", new Object[0]);
            g();
        } else {
            ALog.e(d(), "drop frame", "len", Integer.valueOf(bArr.length));
        }
        ALog.d(d(), "spdyCustomControlFrameRecvCallback", new Object[0]);
    }

    public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z10, long j10, SpdyByteArray spdyByteArray, Object obj) {
        ALog.d(d(), "spdyDataChunkRecvCB", new Object[0]);
    }

    public void spdyDataRecvCallback(SpdySession spdySession, boolean z10, long j10, int i10, Object obj) {
        ALog.d(d(), "spdyDataRecvCallback", new Object[0]);
    }

    public void spdyDataSendCallback(SpdySession spdySession, boolean z10, long j10, int i10, Object obj) {
        ALog.d(d(), "spdyDataSendCallback", new Object[0]);
    }

    public void spdyOnStreamResponse(SpdySession spdySession, long j10, Map<String, List<String>> map, Object obj) {
        String str;
        this.C = System.currentTimeMillis();
        this.D = System.nanoTime();
        try {
            Map<String, String> a10 = UtilityImpl.a(map);
            ALog.d("SilenceConn_", "spdyOnStreamResponse", "header", map);
            int parseInt = Integer.parseInt(a10.get(":status"));
            ALog.e(d(), "spdyOnStreamResponse", "httpStatusCode", Integer.valueOf(parseInt));
            if (parseInt == 200) {
                d(1);
                String str2 = a10.get("x-at");
                if (!TextUtils.isEmpty(str2)) {
                    this.f13035k = str2;
                }
                SessionMonitor sessionMonitor = this.I;
                long j11 = 0;
                if (sessionMonitor.connection_stop_date > 0) {
                    j11 = System.currentTimeMillis() - this.I.connection_stop_date;
                }
                sessionMonitor.auth_time = j11;
                if (this.f13027c == 0) {
                    str = Service.ELEM_NAME;
                } else {
                    str = "inapp";
                }
                UTMini instance = UTMini.getInstance();
                instance.commitEvent(66001, "CONNECTED 200 " + str, (Object) this.f13107y, (Object) this.L, (Object) Integer.valueOf(Constants.SDK_VERSION_CODE), "0");
                k.a("accs", BaseMonitor.ALARM_POINT_AUTH, "");
            } else {
                e(parseInt);
            }
        } catch (Exception e10) {
            ALog.e(d(), e10.toString(), new Object[0]);
            o();
            this.I.setCloseReason("exception");
        }
        ALog.d(d(), "spdyOnStreamResponse", new Object[0]);
    }

    public void spdyPingRecvCallback(SpdySession spdySession, long j10, Object obj) {
        String d10 = d();
        ALog.d(d10, "spdyPingRecvCallback uniId:" + j10, new Object[0]);
        if (j10 >= 0) {
            this.f13029e.b();
            g.a(this.f13028d).e();
            g.a(this.f13028d).a();
            this.I.onPingCBReceive();
            if (this.I.ping_rec_times % 2 == 0) {
                UtilityImpl.a(this.f13028d, Constants.SP_KEY_SERVICE_END, System.currentTimeMillis());
            }
        }
    }

    public void spdyRequestRecvCallback(SpdySession spdySession, long j10, Object obj) {
        ALog.d(d(), "spdyRequestRecvCallback", new Object[0]);
    }

    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i10) {
        String str;
        ALog.e(d(), "spdySessionCloseCallback", "errorCode", Integer.valueOf(i10));
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e10) {
                String d10 = d();
                ALog.e(d10, "session cleanUp has exception: " + e10, new Object[0]);
            }
        }
        d(3);
        this.I.onCloseConnect();
        if (this.I.getConCloseDate() > 0 && this.I.getConStopDate() > 0) {
            this.I.getConCloseDate();
            this.I.getConStopDate();
        }
        this.I.setCloseReason(this.I.getCloseReason() + "tnet error:" + i10);
        if (superviseConnectInfo != null) {
            this.I.live_time = (long) superviseConnectInfo.keepalive_period_second;
        }
        AppMonitor.getInstance().commitStat(this.I);
        for (Message next : this.f13029e.e()) {
            if (next.getNetPermanceMonitor() != null) {
                next.getNetPermanceMonitor().setRet(false);
                next.getNetPermanceMonitor().setFailReason("session close");
                AppMonitor.getInstance().commitStat(next.getNetPermanceMonitor());
            }
        }
        if (this.f13027c == 0) {
            str = Service.ELEM_NAME;
        } else {
            str = "inapp";
        }
        String d11 = d();
        ALog.d(d11, "spdySessionCloseCallback, conKeepTime:" + this.I.live_time + " connectType:" + str, new Object[0]);
        UTMini instance = UTMini.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("DISCONNECT CLOSE ");
        sb.append(str);
        instance.commitEvent(66001, sb.toString(), (Object) Integer.valueOf(i10), (Object) Long.valueOf(this.I.live_time), (Object) Integer.valueOf(Constants.SDK_VERSION_CODE), this.f13107y, this.L);
    }

    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        String str;
        this.G = superviseConnectInfo.connectTime;
        int i10 = superviseConnectInfo.handshakeTime;
        ALog.e(d(), "spdySessionConnectCB", "sessionConnectInterval", Integer.valueOf(this.G), "sslTime", Integer.valueOf(i10), "reuse", Integer.valueOf(superviseConnectInfo.sessionTicketReused));
        s();
        this.I.setRet(true);
        this.I.onConnectStop();
        SessionMonitor sessionMonitor = this.I;
        sessionMonitor.tcp_time = (long) this.G;
        sessionMonitor.ssl_time = (long) i10;
        if (this.f13027c == 0) {
            str = Service.ELEM_NAME;
        } else {
            str = "inapp";
        }
        UTMini instance = UTMini.getInstance();
        instance.commitEvent(66001, "CONNECTED " + str + " " + superviseConnectInfo.sessionTicketReused, (Object) String.valueOf(this.G), (Object) String.valueOf(i10), (Object) Integer.valueOf(Constants.SDK_VERSION_CODE), String.valueOf(superviseConnectInfo.sessionTicketReused), this.f13107y, this.L);
        k.a("accs", BaseMonitor.ALARM_POINT_CONNECT, "");
    }

    public void spdySessionFailedError(SpdySession spdySession, int i10, Object obj) {
        int i11;
        String str;
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e10) {
                ALog.e(d(), "session cleanUp has exception: " + e10, new Object[0]);
            }
        }
        a aVar = this.f13104v;
        if (aVar != null) {
            i11 = aVar.f13109a;
        } else {
            i11 = 0;
        }
        ALog.e(d(), "spdySessionFailedError", "retryTimes", Integer.valueOf(i11), "errorId", Integer.valueOf(i10));
        this.K = false;
        this.M = true;
        d(3);
        this.I.setFailReason(i10);
        this.I.onConnectStop();
        if (this.f13027c == 0) {
            str = Service.ELEM_NAME;
        } else {
            str = "inapp";
        }
        UTMini.getInstance().commitEvent(66001, "DISCONNECT " + str, (Object) Integer.valueOf(i10), (Object) Integer.valueOf(i11), (Object) Integer.valueOf(Constants.SDK_VERSION_CODE), this.f13107y, this.L);
        k.a("accs", BaseMonitor.ALARM_POINT_CONNECT, "retrytimes:" + i11, i10 + "", "");
    }

    public void spdyStreamCloseCallback(SpdySession spdySession, long j10, int i10, Object obj, SuperviseData superviseData) {
        ALog.d(d(), "spdyStreamCloseCallback", new Object[0]);
        if (i10 != 0) {
            ALog.e(d(), "spdyStreamCloseCallback", "statusCode", Integer.valueOf(i10));
            e(i10);
        }
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        SessionInfo sessionInfo;
        String str2 = str;
        int i10 = this.f13102t;
        if (i10 != 2 && i10 != 1) {
            if (this.N == null) {
                this.N = new h(p());
            }
            List<IConnStrategy> a10 = this.N.a(p());
            int i11 = Constants.PORT;
            if (a10 == null || a10.size() <= 0) {
                if (str2 != null) {
                    this.f13098p = str2;
                } else {
                    this.f13098p = p();
                }
                if (System.currentTimeMillis() % 2 == 0) {
                    i11 = 80;
                }
                this.f13099q = i11;
                k.a("accs", BaseMonitor.COUNT_POINT_DNS, "localdns", 0.0d);
                ALog.i(d(), "connect get ip from amdc fail!!", new Object[0]);
            } else {
                for (IConnStrategy next : a10) {
                    if (next != null) {
                        ALog.e(d(), BaseMonitor.ALARM_POINT_CONNECT, "ip", next.getIp(), "port", Integer.valueOf(next.getPort()));
                    }
                }
                if (this.M) {
                    this.N.b();
                    this.M = false;
                }
                IConnStrategy a11 = this.N.a();
                this.f13098p = a11 == null ? p() : a11.getIp();
                if (a11 != null) {
                    i11 = a11.getPort();
                }
                this.f13099q = i11;
                k.a("accs", BaseMonitor.COUNT_POINT_DNS, "httpdns", 0.0d);
                ALog.e(d(), "connect from amdc succ", "ip", this.f13098p, "port", Integer.valueOf(this.f13099q), "originPos", Integer.valueOf(this.N.c()));
            }
            this.f13106x = "https://" + this.f13098p + SOAP.DELIM + this.f13099q + "/accs/";
            ALog.e(d(), BaseMonitor.ALARM_POINT_CONNECT, "URL", this.f13106x);
            this.O = String.valueOf(System.currentTimeMillis());
            if (this.I != null) {
                AppMonitor.getInstance().commitStat(this.I);
            }
            SessionMonitor sessionMonitor = new SessionMonitor();
            this.I = sessionMonitor;
            sessionMonitor.setConnectType(this.f13027c == 0 ? Service.ELEM_NAME : "inapp");
            if (this.f13108z != null) {
                try {
                    this.E = System.currentTimeMillis();
                    this.F = System.nanoTime();
                    this.f13100r = UtilityImpl.a(this.f13028d);
                    this.f13101s = UtilityImpl.b(this.f13028d);
                    this.C = System.currentTimeMillis();
                    this.I.onStartConnect();
                    d(2);
                    synchronized (this.B) {
                        try {
                            if (TextUtils.isEmpty(this.f13100r) || this.f13101s < 0 || !this.K) {
                                ALog.e(d(), "connect normal", new Object[0]);
                                String str3 = this.f13098p;
                                int i12 = this.f13099q;
                                sessionInfo = new SessionInfo(str3, i12, p() + "_" + this.f13026b, (String) null, 0, this.O, this, 4226);
                                this.L = "";
                            } else {
                                ALog.e(d(), BaseMonitor.ALARM_POINT_CONNECT, "proxy", this.f13100r, "port", Integer.valueOf(this.f13101s));
                                String str4 = this.f13098p;
                                int i13 = this.f13099q;
                                sessionInfo = new SessionInfo(str4, i13, p() + "_" + this.f13026b, this.f13100r, this.f13101s, this.O, this, 4226);
                                this.L = this.f13100r + SOAP.DELIM + this.f13101s;
                            }
                            sessionInfo.setPubKeySeqNum(r());
                            sessionInfo.setConnectionTimeoutMs(a.ACCS_RECEIVE_TIMEOUT);
                            this.A = this.f13108z.createSession(sessionInfo);
                            this.I.connection_stop_date = 0;
                            this.B.wait();
                        } catch (InterruptedException e10) {
                            e10.printStackTrace();
                        } catch (Exception e11) {
                            e11.printStackTrace();
                            this.K = false;
                        }
                    }
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            }
        }
    }

    public c c() {
        if (this.J == null) {
            this.J = new c();
        }
        c cVar = this.J;
        cVar.f13133b = this.f13027c;
        cVar.f13135d = this.f13103u.size();
        this.J.f13140i = UtilityImpl.i(this.f13028d);
        c cVar2 = this.J;
        cVar2.f13137f = this.L;
        cVar2.f13132a = this.f13102t;
        SessionMonitor sessionMonitor = this.I;
        int i10 = 0;
        cVar2.f13134c = sessionMonitor != null && sessionMonitor.getRet();
        this.J.f13141j = q();
        c cVar3 = this.J;
        com.taobao.accs.data.d dVar = this.f13029e;
        if (dVar != null) {
            i10 = dVar.d();
        }
        cVar3.f13136e = i10;
        c cVar4 = this.J;
        cVar4.f13138g = this.f13107y;
        return cVar4;
    }

    public void e() {
        super.e();
        this.f13105w = false;
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new x(this));
        ALog.e(d(), "shut down", new Object[0]);
    }

    public void b() {
        this.K = false;
        this.f13030f = 0;
    }

    private void e(int i10) {
        this.f13035k = null;
        o();
        a aVar = this.f13104v;
        int i11 = aVar != null ? aVar.f13109a : 0;
        SessionMonitor sessionMonitor = this.I;
        sessionMonitor.setCloseReason("code not 200 is" + i10);
        this.M = true;
        String str = this.f13027c == 0 ? Service.ELEM_NAME : "inapp";
        UTMini instance = UTMini.getInstance();
        instance.commitEvent(66001, "CONNECTED NO 200 " + str, (Object) Integer.valueOf(i10), (Object) Integer.valueOf(i11), (Object) Integer.valueOf(Constants.SDK_VERSION_CODE), this.f13107y, this.L);
        k.a("accs", BaseMonitor.ALARM_POINT_AUTH, "", i10 + "", "");
    }

    public void a() {
        this.f13105w = true;
        ALog.d(d(), "start", new Object[0]);
        a(this.f13028d);
        if (this.f13104v == null) {
            ALog.i(d(), "start thread", new Object[0]);
            a aVar = new a("NetworkThread_" + this.f13037m);
            this.f13104v = aVar;
            aVar.setPriority(2);
            this.f13104v.start();
        }
        a(false, false);
    }

    public String b(String str) {
        return "https://" + this.f13033i.getChannelHost();
    }

    public void a(Message message, boolean z10) {
        if (!this.f13105w || message == null) {
            String d10 = d();
            ALog.e(d10, "not running or msg null! " + this.f13105w, new Object[0]);
            return;
        }
        try {
            if (ThreadPoolExecutorFactory.getScheduledExecutor().getQueue().size() <= 1000) {
                ScheduledFuture<?> schedule = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new w(this, message, z10), message.delyTime, TimeUnit.MILLISECONDS);
                if (message.getType() == 1 && message.cunstomDataId != null) {
                    if (message.isControlFrame()) {
                        a(message.cunstomDataId);
                    }
                    this.f13029e.f12971a.put(message.cunstomDataId, schedule);
                }
                if (message.getNetPermanceMonitor() != null) {
                    message.getNetPermanceMonitor().setDeviceId(UtilityImpl.j(this.f13028d));
                    message.getNetPermanceMonitor().setConnType(this.f13027c);
                    message.getNetPermanceMonitor().onEnterQueueData();
                    return;
                }
                return;
            }
            throw new RejectedExecutionException("accs");
        } catch (RejectedExecutionException unused) {
            this.f13029e.a(message, (int) ErrorCode.MESSAGE_QUEUE_FULL);
            String d11 = d();
            ALog.e(d11, "send queue full count:" + ThreadPoolExecutorFactory.getScheduledExecutor().getQueue().size(), new Object[0]);
        } catch (Throwable th) {
            this.f13029e.a(message, -8);
            ALog.e(d(), "send error", th, new Object[0]);
        }
    }

    public void a(boolean z10, boolean z11) {
        String d10 = d();
        ALog.d(d10, "try ping, force:" + z10, new Object[0]);
        if (this.f13027c == 1) {
            ALog.d(d(), "INAPP, skip", new Object[0]);
            return;
        }
        Message BuildPing = Message.BuildPing(z10, (int) (z11 ? Math.random() * 10.0d * 1000.0d : 0.0d));
        int pingTimeout = this.f13033i.getPingTimeout();
        if (pingTimeout > 0) {
            BuildPing.timeout = pingTimeout;
        }
        b(BuildPing, z10);
    }

    /* access modifiers changed from: private */
    public void a(Message message) {
        if (message.command != null && this.f13103u.size() != 0) {
            for (int size = this.f13103u.size() - 1; size >= 0; size--) {
                Message message2 = this.f13103u.get(size);
                if (!(message2 == null || message2.command == null || !message2.getPackageName().equals(message.getPackageName()))) {
                    switch (message.command.intValue()) {
                        case 1:
                        case 2:
                            if (message2.command.intValue() == 1 || message2.command.intValue() == 2) {
                                this.f13103u.remove(size);
                                break;
                            }
                        case 3:
                        case 4:
                            if (message2.command.intValue() == 3 || message2.command.intValue() == 4) {
                                this.f13103u.remove(size);
                                break;
                            }
                        case 5:
                        case 6:
                            if (message2.command.intValue() == 5 || message2.command.intValue() == 6) {
                                this.f13103u.remove(size);
                                break;
                            }
                    }
                    ALog.d(d(), "clearRepeatControlCommand message:" + message2.command + Operator.Operation.DIVISION + message2.getPackageName(), new Object[0]);
                }
            }
            com.taobao.accs.data.d dVar = this.f13029e;
            if (dVar != null) {
                dVar.b(message);
            }
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x009f */
    private synchronized void d(int r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r0 = r9.d()     // Catch:{ all -> 0x00bb }
            java.lang.String r1 = "notifyStatus start"
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x00bb }
            java.lang.String r4 = "status"
            r5 = 0
            r3[r5] = r4     // Catch:{ all -> 0x00bb }
            java.lang.String r4 = r9.a((int) r10)     // Catch:{ all -> 0x00bb }
            r6 = 1
            r3[r6] = r4     // Catch:{ all -> 0x00bb }
            com.taobao.accs.utl.ALog.e(r0, r1, r3)     // Catch:{ all -> 0x00bb }
            int r0 = r9.f13102t     // Catch:{ all -> 0x00bb }
            if (r10 != r0) goto L_0x002a
            java.lang.String r10 = r9.d()     // Catch:{ all -> 0x00bb }
            java.lang.String r0 = "ignore notifyStatus"
            java.lang.Object[] r1 = new java.lang.Object[r5]     // Catch:{ all -> 0x00bb }
            com.taobao.accs.utl.ALog.i(r10, r0, r1)     // Catch:{ all -> 0x00bb }
            monitor-exit(r9)
            return
        L_0x002a:
            r9.f13102t = r10     // Catch:{ all -> 0x00bb }
            if (r10 == r6) goto L_0x0075
            if (r10 == r2) goto L_0x005a
            r0 = 3
            if (r10 == r0) goto L_0x0035
            goto L_0x00a0
        L_0x0035:
            r9.t()     // Catch:{ all -> 0x00bb }
            android.content.Context r0 = r9.f13028d     // Catch:{ all -> 0x00bb }
            com.taobao.accs.net.g r0 = com.taobao.accs.net.g.a((android.content.Context) r0)     // Catch:{ all -> 0x00bb }
            r0.d()     // Catch:{ all -> 0x00bb }
            java.lang.Object r0 = r9.B     // Catch:{ all -> 0x00bb }
            monitor-enter(r0)     // Catch:{ all -> 0x00bb }
            java.lang.Object r1 = r9.B     // Catch:{ Exception -> 0x004c }
            r1.notifyAll()     // Catch:{ Exception -> 0x004c }
            goto L_0x004c
        L_0x004a:
            r10 = move-exception
            goto L_0x0058
        L_0x004c:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            com.taobao.accs.data.d r0 = r9.f13029e     // Catch:{ all -> 0x00bb }
            r1 = -10
            r0.a((int) r1)     // Catch:{ all -> 0x00bb }
            r9.a((boolean) r5, (boolean) r6)     // Catch:{ all -> 0x00bb }
            goto L_0x00a0
        L_0x0058:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            throw r10     // Catch:{ all -> 0x00bb }
        L_0x005a:
            java.util.concurrent.ScheduledFuture<?> r0 = r9.f13097o     // Catch:{ all -> 0x00bb }
            if (r0 == 0) goto L_0x0061
            r0.cancel(r6)     // Catch:{ all -> 0x00bb }
        L_0x0061:
            java.lang.String r0 = r9.O     // Catch:{ all -> 0x00bb }
            java.util.concurrent.ScheduledThreadPoolExecutor r1 = com.taobao.accs.common.ThreadPoolExecutorFactory.getScheduledExecutor()     // Catch:{ all -> 0x00bb }
            com.taobao.accs.net.y r3 = new com.taobao.accs.net.y     // Catch:{ all -> 0x00bb }
            r3.<init>(r9, r0)     // Catch:{ all -> 0x00bb }
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00bb }
            r7 = 120000(0x1d4c0, double:5.9288E-319)
            r1.schedule(r3, r7, r0)     // Catch:{ all -> 0x00bb }
            goto L_0x00a0
        L_0x0075:
            android.content.Context r0 = r9.f13028d     // Catch:{ all -> 0x00bb }
            com.taobao.accs.net.g r0 = com.taobao.accs.net.g.a((android.content.Context) r0)     // Catch:{ all -> 0x00bb }
            r0.f()     // Catch:{ all -> 0x00bb }
            r9.t()     // Catch:{ all -> 0x00bb }
            java.util.concurrent.ScheduledFuture<?> r0 = r9.f13097o     // Catch:{ all -> 0x00bb }
            if (r0 == 0) goto L_0x0088
            r0.cancel(r6)     // Catch:{ all -> 0x00bb }
        L_0x0088:
            java.lang.Object r0 = r9.B     // Catch:{ all -> 0x00bb }
            monitor-enter(r0)     // Catch:{ all -> 0x00bb }
            java.lang.Object r1 = r9.B     // Catch:{ Exception -> 0x0093 }
            r1.notifyAll()     // Catch:{ Exception -> 0x0093 }
            goto L_0x0093
        L_0x0091:
            r10 = move-exception
            goto L_0x00b9
        L_0x0093:
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            java.util.LinkedList<com.taobao.accs.data.Message> r0 = r9.f13103u     // Catch:{ all -> 0x00bb }
            monitor-enter(r0)     // Catch:{ all -> 0x00bb }
            java.util.LinkedList<com.taobao.accs.data.Message> r1 = r9.f13103u     // Catch:{ Exception -> 0x009f }
            r1.notifyAll()     // Catch:{ Exception -> 0x009f }
            goto L_0x009f
        L_0x009d:
            r10 = move-exception
            goto L_0x00b7
        L_0x009f:
            monitor-exit(r0)     // Catch:{ all -> 0x009d }
        L_0x00a0:
            java.lang.String r0 = r9.d()     // Catch:{ all -> 0x00bb }
            java.lang.String r1 = "notifyStatus end"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "status"
            r2[r5] = r3     // Catch:{ all -> 0x00bb }
            java.lang.String r10 = r9.a((int) r10)     // Catch:{ all -> 0x00bb }
            r2[r6] = r10     // Catch:{ all -> 0x00bb }
            com.taobao.accs.utl.ALog.i(r0, r1, r2)     // Catch:{ all -> 0x00bb }
            monitor-exit(r9)
            return
        L_0x00b7:
            monitor-exit(r0)     // Catch:{ all -> 0x009d }
            throw r10     // Catch:{ all -> 0x00bb }
        L_0x00b9:
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            throw r10     // Catch:{ all -> 0x00bb }
        L_0x00bb:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.v.d(int):void");
    }

    private boolean a(String str, String str2, String str3) {
        int i10 = 1;
        if (com.taobao.accs.utl.v.b(this.f13028d) == 2) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            return true;
        }
        d(3);
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                i10 = 2;
            } else if (TextUtils.isEmpty(str3)) {
                i10 = 3;
            }
        }
        this.I.setFailReason(i10);
        this.I.onConnectStop();
        String str4 = this.f13027c == 0 ? Service.ELEM_NAME : "inapp";
        a aVar = this.f13104v;
        int i11 = aVar != null ? aVar.f13109a : 0;
        UTMini.getInstance().commitEvent(66001, "DISCONNECT " + str4, (Object) Integer.valueOf(i10), (Object) Integer.valueOf(i11), (Object) Integer.valueOf(Constants.SDK_VERSION_CODE), this.f13107y, this.L);
        k.a("accs", BaseMonitor.ALARM_POINT_CONNECT, "retrytimes:" + i11, i10 + "", "");
        return false;
    }

    public void a(String str, boolean z10, String str2) {
        try {
            d(4);
            o();
            this.I.setCloseReason(str2);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public boolean a(String str) {
        boolean z10;
        String str2;
        synchronized (this.f13103u) {
            z10 = true;
            int size = this.f13103u.size() - 1;
            while (true) {
                if (size >= 0) {
                    Message message = this.f13103u.get(size);
                    if (message != null && message.getType() == 1 && (str2 = message.cunstomDataId) != null && str2.equals(str)) {
                        this.f13103u.remove(size);
                        break;
                    }
                    size--;
                } else {
                    z10 = false;
                    break;
                }
            }
        }
        return z10;
    }

    public String d() {
        return "SilenceConn_" + this.f13037m;
    }

    public void a(Context context) {
        if (!this.f13031g) {
            super.a(context);
            GlobalAppRuntimeInfo.setBackground(false);
            this.f13031g = true;
            ALog.i(d(), "init awcn success!", new Object[0]);
        }
    }
}
