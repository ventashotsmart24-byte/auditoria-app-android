package io.reactivex.internal.operators.parallel;

import fb.b;
import fb.c;
import fb.d;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;

public final class ParallelFromPublisher<T> extends ParallelFlowable<T> {
    final int parallelism;
    final int prefetch;
    final b source;

    public static final class ParallelDispatcher<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4470634016609963609L;
        volatile boolean cancelled;
        volatile boolean done;
        final long[] emissions;
        Throwable error;
        int index;
        final int limit;
        final int prefetch;
        int produced;
        SimpleQueue<T> queue;
        final AtomicLongArray requests;
        int sourceMode;
        final AtomicInteger subscriberCount = new AtomicInteger();
        final c[] subscribers;
        d upstream;

        public final class RailSubscription implements d {

            /* renamed from: j  reason: collision with root package name */
            final int f17524j;

            /* renamed from: m  reason: collision with root package name */
            final int f17525m;

            public RailSubscription(int i10, int i11) {
                this.f17524j = i10;
                this.f17525m = i11;
            }

            public void cancel() {
                if (ParallelDispatcher.this.requests.compareAndSet(this.f17524j + this.f17525m, 0, 1)) {
                    ParallelDispatcher parallelDispatcher = ParallelDispatcher.this;
                    int i10 = this.f17525m;
                    parallelDispatcher.cancel(i10 + i10);
                }
            }

            public void request(long j10) {
                long j11;
                if (SubscriptionHelper.validate(j10)) {
                    AtomicLongArray atomicLongArray = ParallelDispatcher.this.requests;
                    do {
                        j11 = atomicLongArray.get(this.f17524j);
                        if (j11 != Long.MAX_VALUE) {
                        } else {
                            return;
                        }
                    } while (!atomicLongArray.compareAndSet(this.f17524j, j11, BackpressureHelper.addCap(j11, j10)));
                    if (ParallelDispatcher.this.subscriberCount.get() == this.f17525m) {
                        ParallelDispatcher.this.drain();
                    }
                }
            }
        }

        public ParallelDispatcher(c[] cVarArr, int i10) {
            this.subscribers = cVarArr;
            this.prefetch = i10;
            this.limit = i10 - (i10 >> 2);
            int length = cVarArr.length;
            int i11 = length + length;
            AtomicLongArray atomicLongArray = new AtomicLongArray(i11 + 1);
            this.requests = atomicLongArray;
            atomicLongArray.lazySet(i11, (long) length);
            this.emissions = new long[length];
        }

        public void cancel(int i10) {
            if (this.requests.decrementAndGet(i10) == 0) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                if (this.sourceMode == 1) {
                    drainSync();
                } else {
                    drainAsync();
                }
            }
        }

        public void drainAsync() {
            Throwable th;
            SimpleQueue<T> simpleQueue = this.queue;
            c[] cVarArr = this.subscribers;
            AtomicLongArray atomicLongArray = this.requests;
            long[] jArr = this.emissions;
            int length = jArr.length;
            int i10 = this.index;
            int i11 = this.produced;
            int i12 = 1;
            while (true) {
                int i13 = 0;
                int i14 = 0;
                while (!this.cancelled) {
                    boolean z10 = this.done;
                    if (!z10 || (th = this.error) == null) {
                        boolean isEmpty = simpleQueue.isEmpty();
                        if (!z10 || !isEmpty) {
                            if (!isEmpty) {
                                long j10 = atomicLongArray.get(i10);
                                long j11 = jArr[i10];
                                if (j10 == j11 || atomicLongArray.get(length + i10) != 0) {
                                    i14++;
                                } else {
                                    try {
                                        T poll = simpleQueue.poll();
                                        if (poll != null) {
                                            cVarArr[i10].onNext(poll);
                                            jArr[i10] = j11 + 1;
                                            i11++;
                                            if (i11 == this.limit) {
                                                this.upstream.request((long) i11);
                                                i11 = 0;
                                            }
                                            i14 = 0;
                                        }
                                    } catch (Throwable th2) {
                                        Throwable th3 = th2;
                                        Exceptions.throwIfFatal(th3);
                                        this.upstream.cancel();
                                        int length2 = cVarArr.length;
                                        while (i13 < length2) {
                                            cVarArr[i13].onError(th3);
                                            i13++;
                                        }
                                        return;
                                    }
                                }
                                i10++;
                                if (i10 == length) {
                                    i10 = 0;
                                    continue;
                                }
                                if (i14 == length) {
                                }
                            }
                            int i15 = get();
                            if (i15 == i12) {
                                this.index = i10;
                                this.produced = i11;
                                i12 = addAndGet(-i12);
                                if (i12 == 0) {
                                    return;
                                }
                            } else {
                                i12 = i15;
                            }
                        } else {
                            int length3 = cVarArr.length;
                            while (i13 < length3) {
                                cVarArr[i13].onComplete();
                                i13++;
                            }
                            return;
                        }
                    } else {
                        simpleQueue.clear();
                        int length4 = cVarArr.length;
                        while (i13 < length4) {
                            cVarArr[i13].onError(th);
                            i13++;
                        }
                        return;
                    }
                }
                simpleQueue.clear();
                return;
            }
        }

        public void drainSync() {
            SimpleQueue<T> simpleQueue = this.queue;
            c[] cVarArr = this.subscribers;
            AtomicLongArray atomicLongArray = this.requests;
            long[] jArr = this.emissions;
            int length = jArr.length;
            int i10 = this.index;
            int i11 = 1;
            while (true) {
                int i12 = 0;
                int i13 = 0;
                while (!this.cancelled) {
                    if (simpleQueue.isEmpty()) {
                        int length2 = cVarArr.length;
                        while (i12 < length2) {
                            cVarArr[i12].onComplete();
                            i12++;
                        }
                        return;
                    }
                    long j10 = atomicLongArray.get(i10);
                    long j11 = jArr[i10];
                    if (j10 == j11 || atomicLongArray.get(length + i10) != 0) {
                        i13++;
                    } else {
                        try {
                            T poll = simpleQueue.poll();
                            if (poll == null) {
                                int length3 = cVarArr.length;
                                while (i12 < length3) {
                                    cVarArr[i12].onComplete();
                                    i12++;
                                }
                                return;
                            }
                            cVarArr[i10].onNext(poll);
                            jArr[i10] = j11 + 1;
                            i13 = 0;
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            Exceptions.throwIfFatal(th2);
                            this.upstream.cancel();
                            int length4 = cVarArr.length;
                            while (i12 < length4) {
                                cVarArr[i12].onError(th2);
                                i12++;
                            }
                            return;
                        }
                    }
                    i10++;
                    if (i10 == length) {
                        i10 = 0;
                        continue;
                    }
                    if (i13 == length) {
                        int i14 = get();
                        if (i14 == i11) {
                            this.index = i10;
                            i11 = addAndGet(-i11);
                            if (i11 == 0) {
                                return;
                            }
                        } else {
                            i11 = i14;
                        }
                    }
                }
                simpleQueue.clear();
                return;
            }
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onNext(T t10) {
            if (this.sourceMode != 0 || this.queue.offer(t10)) {
                drain();
                return;
            }
            this.upstream.cancel();
            onError(new MissingBackpressureException("Queue is full?"));
        }

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                if (dVar instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) dVar;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        setupSubscribers();
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        setupSubscribers();
                        dVar.request((long) this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                setupSubscribers();
                dVar.request((long) this.prefetch);
            }
        }

        public void setupSubscribers() {
            c[] cVarArr = this.subscribers;
            int length = cVarArr.length;
            int i10 = 0;
            while (i10 < length && !this.cancelled) {
                int i11 = i10 + 1;
                this.subscriberCount.lazySet(i11);
                cVarArr[i10].onSubscribe(new RailSubscription(i10, length));
                i10 = i11;
            }
        }
    }

    public ParallelFromPublisher(b bVar, int i10, int i11) {
        this.source = bVar;
        this.parallelism = i10;
        this.prefetch = i11;
    }

    public int parallelism() {
        return this.parallelism;
    }

    public void subscribe(c[] cVarArr) {
        if (validate(cVarArr)) {
            this.source.subscribe(new ParallelDispatcher(cVarArr, this.prefetch));
        }
    }
}
