package io.reactivex.internal.operators.flowable;

import fb.c;
import fb.d;
import h3.b;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableCache<T> extends AbstractFlowableWithUpstream<T, T> implements FlowableSubscriber<T> {
    static final CacheSubscription[] EMPTY = new CacheSubscription[0];
    static final CacheSubscription[] TERMINATED = new CacheSubscription[0];
    final int capacityHint;
    volatile boolean done;
    Throwable error;
    final Node<T> head;
    final AtomicBoolean once = new AtomicBoolean();
    volatile long size;
    final AtomicReference<CacheSubscription<T>[]> subscribers;
    Node<T> tail;
    int tailOffset;

    public static final class CacheSubscription<T> extends AtomicInteger implements d {
        private static final long serialVersionUID = 6770240836423125754L;
        final c downstream;
        long index;
        Node<T> node;
        int offset;
        final FlowableCache<T> parent;
        final AtomicLong requested = new AtomicLong();

        public CacheSubscription(c cVar, FlowableCache<T> flowableCache) {
            this.downstream = cVar;
            this.parent = flowableCache;
            this.node = flowableCache.head;
        }

        public void cancel() {
            if (this.requested.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
            }
        }

        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                BackpressureHelper.addCancel(this.requested, j10);
                this.parent.replay(this);
            }
        }
    }

    public static final class Node<T> {
        volatile Node<T> next;
        final T[] values;

        public Node(int i10) {
            this.values = new Object[i10];
        }
    }

    public FlowableCache(Flowable<T> flowable, int i10) {
        super(flowable);
        this.capacityHint = i10;
        Node<T> node = new Node<>(i10);
        this.head = node;
        this.tail = node;
        this.subscribers = new AtomicReference<>(EMPTY);
    }

    public void add(CacheSubscription<T> cacheSubscription) {
        CacheSubscription[] cacheSubscriptionArr;
        CacheSubscription[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = (CacheSubscription[]) this.subscribers.get();
            if (cacheSubscriptionArr != TERMINATED) {
                int length = cacheSubscriptionArr.length;
                cacheSubscriptionArr2 = new CacheSubscription[(length + 1)];
                System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr2, 0, length);
                cacheSubscriptionArr2[length] = cacheSubscription;
            } else {
                return;
            }
        } while (!b.a(this.subscribers, cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    public long cachedEventCount() {
        return this.size;
    }

    public boolean hasSubscribers() {
        if (((CacheSubscription[]) this.subscribers.get()).length != 0) {
            return true;
        }
        return false;
    }

    public boolean isConnected() {
        return this.once.get();
    }

    public void onComplete() {
        this.done = true;
        for (CacheSubscription replay : (CacheSubscription[]) this.subscribers.getAndSet(TERMINATED)) {
            replay(replay);
        }
    }

    public void onError(Throwable th) {
        if (this.done) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.error = th;
        this.done = true;
        for (CacheSubscription replay : (CacheSubscription[]) this.subscribers.getAndSet(TERMINATED)) {
            replay(replay);
        }
    }

    public void onNext(T t10) {
        int i10 = this.tailOffset;
        if (i10 == this.capacityHint) {
            Node<T> node = new Node<>(i10);
            node.values[0] = t10;
            this.tailOffset = 1;
            this.tail.next = node;
            this.tail = node;
        } else {
            this.tail.values[i10] = t10;
            this.tailOffset = i10 + 1;
        }
        this.size++;
        for (CacheSubscription replay : (CacheSubscription[]) this.subscribers.get()) {
            replay(replay);
        }
    }

    public void onSubscribe(d dVar) {
        dVar.request(Long.MAX_VALUE);
    }

    public void remove(CacheSubscription<T> cacheSubscription) {
        CacheSubscription<T>[] cacheSubscriptionArr;
        CacheSubscription[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = (CacheSubscription[]) this.subscribers.get();
            int length = cacheSubscriptionArr.length;
            if (length != 0) {
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        i10 = -1;
                        break;
                    } else if (cacheSubscriptionArr[i10] == cacheSubscription) {
                        break;
                    } else {
                        i10++;
                    }
                }
                if (i10 >= 0) {
                    if (length == 1) {
                        cacheSubscriptionArr2 = EMPTY;
                    } else {
                        CacheSubscription[] cacheSubscriptionArr3 = new CacheSubscription[(length - 1)];
                        System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr3, 0, i10);
                        System.arraycopy(cacheSubscriptionArr, i10 + 1, cacheSubscriptionArr3, i10, (length - i10) - 1);
                        cacheSubscriptionArr2 = cacheSubscriptionArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!b.a(this.subscribers, cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    public void replay(CacheSubscription<T> cacheSubscription) {
        boolean z10;
        CacheSubscription<T> cacheSubscription2 = cacheSubscription;
        if (cacheSubscription.getAndIncrement() == 0) {
            long j10 = cacheSubscription2.index;
            int i10 = cacheSubscription2.offset;
            Node<T> node = cacheSubscription2.node;
            AtomicLong atomicLong = cacheSubscription2.requested;
            c cVar = cacheSubscription2.downstream;
            int i11 = this.capacityHint;
            int i12 = 1;
            while (true) {
                boolean z11 = this.done;
                if (this.size == j10) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z11 || !z10) {
                    if (!z10) {
                        long j11 = atomicLong.get();
                        if (j11 == Long.MIN_VALUE) {
                            cacheSubscription2.node = null;
                            return;
                        } else if (j11 != j10) {
                            if (i10 == i11) {
                                node = node.next;
                                i10 = 0;
                            }
                            cVar.onNext(node.values[i10]);
                            i10++;
                            j10++;
                        }
                    }
                    cacheSubscription2.index = j10;
                    cacheSubscription2.offset = i10;
                    cacheSubscription2.node = node;
                    i12 = cacheSubscription2.addAndGet(-i12);
                    if (i12 == 0) {
                        return;
                    }
                } else {
                    cacheSubscription2.node = null;
                    Throwable th = this.error;
                    if (th != null) {
                        cVar.onError(th);
                        return;
                    } else {
                        cVar.onComplete();
                        return;
                    }
                }
            }
        }
    }

    public void subscribeActual(c cVar) {
        CacheSubscription cacheSubscription = new CacheSubscription(cVar, this);
        cVar.onSubscribe(cacheSubscription);
        add(cacheSubscription);
        if (this.once.get() || !this.once.compareAndSet(false, true)) {
            replay(cacheSubscription);
        } else {
            this.source.subscribe(this);
        }
    }
}
