package n1;

import anet.channel.util.ALog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static List f8188a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public static final ReentrantReadWriteLock f8189b;

    /* renamed from: c  reason: collision with root package name */
    public static final ReentrantReadWriteLock.ReadLock f8190c;

    /* renamed from: d  reason: collision with root package name */
    public static final ReentrantReadWriteLock.WriteLock f8191d;

    public static class a implements Comparable {

        /* renamed from: a  reason: collision with root package name */
        public final a f8192a;

        /* renamed from: b  reason: collision with root package name */
        public final c f8193b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8194c;

        public a(a aVar, c cVar, int i10) {
            this.f8192a = aVar;
            this.f8193b = cVar;
            this.f8194c = i10;
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            return this.f8194c - aVar.f8194c;
        }
    }

    static {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        f8189b = reentrantReadWriteLock;
        f8190c = reentrantReadWriteLock.readLock();
        f8191d = reentrantReadWriteLock.writeLock();
    }

    public static void a(a aVar, c cVar, int i10) {
        if (aVar == null) {
            throw new IllegalArgumentException("cache is null");
        } else if (cVar != null) {
            try {
                ReentrantReadWriteLock.WriteLock writeLock = f8191d;
                writeLock.lock();
                f8188a.add(new a(aVar, cVar, i10));
                Collections.sort(f8188a);
                writeLock.unlock();
            } catch (Throwable th) {
                f8191d.unlock();
                throw th;
            }
        } else {
            throw new IllegalArgumentException("prediction is null");
        }
    }

    public static void b() {
        ALog.w("anet.CacheManager", "clearAllCache", (String) null, new Object[0]);
        for (a aVar : f8188a) {
            try {
                aVar.f8192a.clear();
            } catch (Exception unused) {
            }
        }
    }
}
