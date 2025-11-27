package anet.channel.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class a extends ThreadPoolExecutor {
    public a(int i10, int i11, long j10, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i10, i11, j10, timeUnit, blockingQueue, threadFactory);
    }

    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t10) {
        return new C0064a(runnable, t10);
    }

    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C0064a(callable);
    }

    /* renamed from: anet.channel.thread.a$a  reason: collision with other inner class name */
    public class C0064a<V> extends FutureTask<V> implements Comparable<C0064a<V>> {

        /* renamed from: b  reason: collision with root package name */
        private Object f4004b;

        public C0064a(Callable<V> callable) {
            super(callable);
            this.f4004b = callable;
        }

        /* renamed from: a */
        public int compareTo(C0064a<V> aVar) {
            if (this == aVar) {
                return 0;
            }
            if (aVar == null) {
                return -1;
            }
            Object obj = this.f4004b;
            if (!(obj == null || aVar.f4004b == null || !obj.getClass().equals(aVar.f4004b.getClass()))) {
                Object obj2 = this.f4004b;
                if (obj2 instanceof Comparable) {
                    return ((Comparable) obj2).compareTo(aVar.f4004b);
                }
            }
            return 0;
        }

        public C0064a(Runnable runnable, V v10) {
            super(runnable, v10);
            this.f4004b = runnable;
        }
    }
}
