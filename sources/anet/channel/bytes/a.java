package anet.channel.bytes;

import java.util.Random;
import java.util.TreeSet;

public class a {
    public static final int MAX_POOL_SIZE = 524288;
    public static final String TAG = "awcn.ByteArrayPool";

    /* renamed from: a  reason: collision with root package name */
    private final TreeSet<ByteArray> f3627a = new TreeSet<>();

    /* renamed from: b  reason: collision with root package name */
    private final ByteArray f3628b = ByteArray.create(0);

    /* renamed from: c  reason: collision with root package name */
    private final Random f3629c = new Random();

    /* renamed from: d  reason: collision with root package name */
    private long f3630d = 0;

    /* renamed from: anet.channel.bytes.a$a  reason: collision with other inner class name */
    public static class C0060a {

        /* renamed from: a  reason: collision with root package name */
        public static a f3631a = new a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0046, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(anet.channel.bytes.ByteArray r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            if (r6 == 0) goto L_0x0045
            int r0 = r6.bufferLength     // Catch:{ all -> 0x0042 }
            r1 = 524288(0x80000, float:7.34684E-40)
            if (r0 < r1) goto L_0x000a
            goto L_0x0045
        L_0x000a:
            long r1 = r5.f3630d     // Catch:{ all -> 0x0042 }
            long r3 = (long) r0     // Catch:{ all -> 0x0042 }
            long r1 = r1 + r3
            r5.f3630d = r1     // Catch:{ all -> 0x0042 }
            java.util.TreeSet<anet.channel.bytes.ByteArray> r0 = r5.f3627a     // Catch:{ all -> 0x0042 }
            r0.add(r6)     // Catch:{ all -> 0x0042 }
        L_0x0015:
            long r0 = r5.f3630d     // Catch:{ all -> 0x0042 }
            r2 = 524288(0x80000, double:2.590327E-318)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x0040
            java.util.Random r6 = r5.f3629c     // Catch:{ all -> 0x0042 }
            boolean r6 = r6.nextBoolean()     // Catch:{ all -> 0x0042 }
            if (r6 == 0) goto L_0x002f
            java.util.TreeSet<anet.channel.bytes.ByteArray> r6 = r5.f3627a     // Catch:{ all -> 0x0042 }
            java.lang.Object r6 = r6.pollFirst()     // Catch:{ all -> 0x0042 }
            anet.channel.bytes.ByteArray r6 = (anet.channel.bytes.ByteArray) r6     // Catch:{ all -> 0x0042 }
            goto L_0x0037
        L_0x002f:
            java.util.TreeSet<anet.channel.bytes.ByteArray> r6 = r5.f3627a     // Catch:{ all -> 0x0042 }
            java.lang.Object r6 = r6.pollLast()     // Catch:{ all -> 0x0042 }
            anet.channel.bytes.ByteArray r6 = (anet.channel.bytes.ByteArray) r6     // Catch:{ all -> 0x0042 }
        L_0x0037:
            long r0 = r5.f3630d     // Catch:{ all -> 0x0042 }
            int r6 = r6.bufferLength     // Catch:{ all -> 0x0042 }
            long r2 = (long) r6     // Catch:{ all -> 0x0042 }
            long r0 = r0 - r2
            r5.f3630d = r0     // Catch:{ all -> 0x0042 }
            goto L_0x0015
        L_0x0040:
            monitor-exit(r5)
            return
        L_0x0042:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        L_0x0045:
            monitor-exit(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.bytes.a.a(anet.channel.bytes.ByteArray):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized anet.channel.bytes.ByteArray a(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 524288(0x80000, float:7.34684E-40)
            if (r6 < r0) goto L_0x000b
            anet.channel.bytes.ByteArray r6 = anet.channel.bytes.ByteArray.create(r6)     // Catch:{ all -> 0x0035 }
            monitor-exit(r5)
            return r6
        L_0x000b:
            anet.channel.bytes.ByteArray r0 = r5.f3628b     // Catch:{ all -> 0x0035 }
            r0.bufferLength = r6     // Catch:{ all -> 0x0035 }
            java.util.TreeSet<anet.channel.bytes.ByteArray> r1 = r5.f3627a     // Catch:{ all -> 0x0035 }
            java.lang.Object r0 = r1.ceiling(r0)     // Catch:{ all -> 0x0035 }
            anet.channel.bytes.ByteArray r0 = (anet.channel.bytes.ByteArray) r0     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x001e
            anet.channel.bytes.ByteArray r0 = anet.channel.bytes.ByteArray.create(r6)     // Catch:{ all -> 0x0035 }
            goto L_0x0033
        L_0x001e:
            byte[] r6 = r0.buffer     // Catch:{ all -> 0x0035 }
            r1 = 0
            java.util.Arrays.fill(r6, r1)     // Catch:{ all -> 0x0035 }
            r0.dataLength = r1     // Catch:{ all -> 0x0035 }
            java.util.TreeSet<anet.channel.bytes.ByteArray> r6 = r5.f3627a     // Catch:{ all -> 0x0035 }
            r6.remove(r0)     // Catch:{ all -> 0x0035 }
            long r1 = r5.f3630d     // Catch:{ all -> 0x0035 }
            int r6 = r0.bufferLength     // Catch:{ all -> 0x0035 }
            long r3 = (long) r6     // Catch:{ all -> 0x0035 }
            long r1 = r1 - r3
            r5.f3630d = r1     // Catch:{ all -> 0x0035 }
        L_0x0033:
            monitor-exit(r5)
            return r0
        L_0x0035:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.bytes.a.a(int):anet.channel.bytes.ByteArray");
    }

    public ByteArray a(byte[] bArr, int i10) {
        ByteArray a10 = a(i10);
        System.arraycopy(bArr, 0, a10.buffer, 0, i10);
        a10.dataLength = i10;
        return a10;
    }
}
