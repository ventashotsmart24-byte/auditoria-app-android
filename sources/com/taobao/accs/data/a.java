package com.taobao.accs.data;

import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class a {
    public static final int SPLITTED_DATA_INDEX = 17;
    public static final int SPLITTED_DATA_MD5 = 18;
    public static final int SPLITTED_DATA_NUMS = 16;
    public static final int SPLITTED_TIME_OUT = 15;

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f12961a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f12962b;

    /* renamed from: c  reason: collision with root package name */
    private int f12963c;

    /* renamed from: d  reason: collision with root package name */
    private String f12964d;

    /* renamed from: e  reason: collision with root package name */
    private long f12965e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public volatile int f12966f = 0;

    /* renamed from: g  reason: collision with root package name */
    private ScheduledFuture<?> f12967g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Map<Integer, byte[]> f12968h = new TreeMap(new b(this));

    public a(String str, int i10, String str2) {
        this.f12962b = str;
        this.f12963c = i10;
        this.f12964d = str2;
    }

    public void a(long j10) {
        if (j10 <= 0) {
            j10 = NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS;
        }
        this.f12967g = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new c(this), j10, TimeUnit.MILLISECONDS);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0142, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0159, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x013e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] a(int r13, int r14, byte[] r15) {
        /*
            r12 = this;
            com.taobao.accs.utl.ALog$Level r0 = com.taobao.accs.utl.ALog.Level.D
            boolean r0 = com.taobao.accs.utl.ALog.isPrintLog(r0)
            r1 = 4
            r2 = 3
            r3 = 1
            r4 = 2
            r5 = 0
            if (r0 == 0) goto L_0x0028
            java.lang.String r0 = "AssembleMessage"
            java.lang.String r6 = "putBurst"
            java.lang.Object[] r7 = new java.lang.Object[r1]
            java.lang.String r8 = "dataId"
            r7[r5] = r8
            java.lang.String r8 = r12.f12962b
            r7[r3] = r8
            java.lang.String r8 = "index"
            r7[r4] = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r13)
            r7[r2] = r8
            com.taobao.accs.utl.ALog.d(r0, r6, r7)
        L_0x0028:
            int r0 = r12.f12963c
            r6 = 0
            if (r14 == r0) goto L_0x0037
            java.lang.String r13 = "AssembleMessage"
            java.lang.String r14 = "putBurst fail as burstNums not match"
            java.lang.Object[] r15 = new java.lang.Object[r5]
            com.taobao.accs.utl.ALog.e(r13, r14, r15)
            return r6
        L_0x0037:
            if (r13 < 0) goto L_0x015d
            if (r13 < r14) goto L_0x003d
            goto L_0x015d
        L_0x003d:
            monitor-enter(r12)
            int r14 = r12.f12966f     // Catch:{ all -> 0x015a }
            if (r14 != 0) goto L_0x0143
            java.util.Map<java.lang.Integer, byte[]> r14 = r12.f12968h     // Catch:{ all -> 0x015a }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x015a }
            java.lang.Object r14 = r14.get(r0)     // Catch:{ all -> 0x015a }
            if (r14 == 0) goto L_0x0059
            java.lang.String r13 = "AssembleMessage"
            java.lang.String r14 = "putBurst fail as exist old"
            java.lang.Object[] r15 = new java.lang.Object[r5]     // Catch:{ all -> 0x015a }
            com.taobao.accs.utl.ALog.e(r13, r14, r15)     // Catch:{ all -> 0x015a }
            monitor-exit(r12)     // Catch:{ all -> 0x015a }
            return r6
        L_0x0059:
            java.util.Map<java.lang.Integer, byte[]> r14 = r12.f12968h     // Catch:{ all -> 0x015a }
            boolean r14 = r14.isEmpty()     // Catch:{ all -> 0x015a }
            if (r14 == 0) goto L_0x0067
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x015a }
            r12.f12965e = r7     // Catch:{ all -> 0x015a }
        L_0x0067:
            java.util.Map<java.lang.Integer, byte[]> r14 = r12.f12968h     // Catch:{ all -> 0x015a }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x015a }
            r14.put(r13, r15)     // Catch:{ all -> 0x015a }
            java.util.Map<java.lang.Integer, byte[]> r13 = r12.f12968h     // Catch:{ all -> 0x015a }
            int r13 = r13.size()     // Catch:{ all -> 0x015a }
            int r14 = r12.f12963c     // Catch:{ all -> 0x015a }
            if (r13 != r14) goto L_0x0158
            java.util.Map<java.lang.Integer, byte[]> r13 = r12.f12968h     // Catch:{ all -> 0x015a }
            java.util.Collection r13 = r13.values()     // Catch:{ all -> 0x015a }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ all -> 0x015a }
            r14 = r6
        L_0x0085:
            boolean r15 = r13.hasNext()     // Catch:{ all -> 0x015a }
            if (r15 == 0) goto L_0x00a5
            java.lang.Object r15 = r13.next()     // Catch:{ all -> 0x015a }
            byte[] r15 = (byte[]) r15     // Catch:{ all -> 0x015a }
            if (r14 != 0) goto L_0x0095
            r14 = r15
            goto L_0x0085
        L_0x0095:
            int r0 = r14.length     // Catch:{ all -> 0x015a }
            int r7 = r15.length     // Catch:{ all -> 0x015a }
            int r0 = r0 + r7
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x015a }
            int r7 = r14.length     // Catch:{ all -> 0x015a }
            java.lang.System.arraycopy(r14, r5, r0, r5, r7)     // Catch:{ all -> 0x015a }
            int r14 = r14.length     // Catch:{ all -> 0x015a }
            int r7 = r15.length     // Catch:{ all -> 0x015a }
            java.lang.System.arraycopy(r15, r5, r0, r14, r7)     // Catch:{ all -> 0x015a }
            r14 = r0
            goto L_0x0085
        L_0x00a5:
            java.lang.String r13 = r12.f12964d     // Catch:{ all -> 0x015a }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x015a }
            r15 = 5
            r0 = 6
            if (r13 != 0) goto L_0x00e6
            java.lang.String r13 = new java.lang.String     // Catch:{ all -> 0x015a }
            byte[] r7 = org.android.agoo.common.a.a(r14)     // Catch:{ all -> 0x015a }
            char[] r7 = a((byte[]) r7)     // Catch:{ all -> 0x015a }
            r13.<init>(r7)     // Catch:{ all -> 0x015a }
            java.lang.String r7 = r12.f12964d     // Catch:{ all -> 0x015a }
            boolean r7 = r7.equals(r13)     // Catch:{ all -> 0x015a }
            if (r7 != 0) goto L_0x00e6
            java.lang.String r14 = "AssembleMessage"
            java.lang.String r7 = "putBurst fail"
            java.lang.Object[] r8 = new java.lang.Object[r0]     // Catch:{ all -> 0x015a }
            java.lang.String r9 = "dataId"
            r8[r5] = r9     // Catch:{ all -> 0x015a }
            java.lang.String r9 = r12.f12962b     // Catch:{ all -> 0x015a }
            r8[r3] = r9     // Catch:{ all -> 0x015a }
            java.lang.String r9 = "dataMd5"
            r8[r4] = r9     // Catch:{ all -> 0x015a }
            java.lang.String r9 = r12.f12964d     // Catch:{ all -> 0x015a }
            r8[r2] = r9     // Catch:{ all -> 0x015a }
            java.lang.String r9 = "finalDataMd5"
            r8[r1] = r9     // Catch:{ all -> 0x015a }
            r8[r15] = r13     // Catch:{ all -> 0x015a }
            com.taobao.accs.utl.ALog.w(r14, r7, r8)     // Catch:{ all -> 0x015a }
            r12.f12966f = r2     // Catch:{ all -> 0x015a }
            goto L_0x00e7
        L_0x00e6:
            r6 = r14
        L_0x00e7:
            if (r6 == 0) goto L_0x011a
            int r13 = r6.length     // Catch:{ all -> 0x015a }
            long r13 = (long) r13     // Catch:{ all -> 0x015a }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x015a }
            long r9 = r12.f12965e     // Catch:{ all -> 0x015a }
            long r7 = r7 - r9
            r12.f12966f = r4     // Catch:{ all -> 0x015a }
            java.lang.String r9 = "AssembleMessage"
            java.lang.String r10 = "putBurst completed"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x015a }
            java.lang.String r11 = "dataId"
            r0[r5] = r11     // Catch:{ all -> 0x015a }
            java.lang.String r11 = r12.f12962b     // Catch:{ all -> 0x015a }
            r0[r3] = r11     // Catch:{ all -> 0x015a }
            java.lang.String r3 = "length"
            r0[r4] = r3     // Catch:{ all -> 0x015a }
            java.lang.Long r3 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x015a }
            r0[r2] = r3     // Catch:{ all -> 0x015a }
            java.lang.String r2 = "cost"
            r0[r1] = r2     // Catch:{ all -> 0x015a }
            java.lang.Long r1 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x015a }
            r0[r15] = r1     // Catch:{ all -> 0x015a }
            com.taobao.accs.utl.ALog.i(r9, r10, r0)     // Catch:{ all -> 0x015a }
            goto L_0x011d
        L_0x011a:
            r13 = 0
            r7 = r13
        L_0x011d:
            com.taobao.accs.ut.monitor.AssembleMonitor r15 = new com.taobao.accs.ut.monitor.AssembleMonitor     // Catch:{ all -> 0x015a }
            java.lang.String r0 = r12.f12962b     // Catch:{ all -> 0x015a }
            int r1 = r12.f12966f     // Catch:{ all -> 0x015a }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x015a }
            r15.<init>(r0, r1)     // Catch:{ all -> 0x015a }
            r15.assembleLength = r13     // Catch:{ all -> 0x015a }
            r15.assembleTimes = r7     // Catch:{ all -> 0x015a }
            anet.channel.appmonitor.IAppMonitor r13 = anet.channel.appmonitor.AppMonitor.getInstance()     // Catch:{ all -> 0x015a }
            r13.commitStat(r15)     // Catch:{ all -> 0x015a }
            java.util.Map<java.lang.Integer, byte[]> r13 = r12.f12968h     // Catch:{ all -> 0x015a }
            r13.clear()     // Catch:{ all -> 0x015a }
            java.util.concurrent.ScheduledFuture<?> r13 = r12.f12967g     // Catch:{ all -> 0x015a }
            if (r13 == 0) goto L_0x0141
            r13.cancel(r5)     // Catch:{ all -> 0x015a }
        L_0x0141:
            monitor-exit(r12)     // Catch:{ all -> 0x015a }
            return r6
        L_0x0143:
            java.lang.String r13 = "AssembleMessage"
            java.lang.String r14 = "putBurst fail"
            java.lang.Object[] r15 = new java.lang.Object[r4]     // Catch:{ all -> 0x015a }
            java.lang.String r0 = "status"
            r15[r5] = r0     // Catch:{ all -> 0x015a }
            int r0 = r12.f12966f     // Catch:{ all -> 0x015a }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x015a }
            r15[r3] = r0     // Catch:{ all -> 0x015a }
            com.taobao.accs.utl.ALog.e(r13, r14, r15)     // Catch:{ all -> 0x015a }
        L_0x0158:
            monitor-exit(r12)     // Catch:{ all -> 0x015a }
            return r6
        L_0x015a:
            r13 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x015a }
            throw r13
        L_0x015d:
            java.lang.String r13 = "AssembleMessage"
            java.lang.String r14 = "putBurst fail as burstIndex invalid"
            java.lang.Object[] r15 = new java.lang.Object[r5]
            com.taobao.accs.utl.ALog.e(r13, r14, r15)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.data.a.a(int, int, byte[]):byte[]");
    }

    private static char[] a(byte[] bArr) {
        char[] cArr = new char[(r0 << 1)];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            char[] cArr2 = f12961a;
            cArr[i10] = cArr2[(b10 & 240) >>> 4];
            i10 = i11 + 1;
            cArr[i11] = cArr2[b10 & 15];
        }
        return cArr;
    }
}
