package io.reactivex.internal.operators.flowable;

import fb.b;
import fb.c;
import fb.d;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableZip<T, R> extends Flowable<R> {
    final int bufferSize;
    final boolean delayError;
    final b[] sources;
    final Iterable<? extends b> sourcesIterable;
    final Function<? super Object[], ? extends R> zipper;

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements d {
        private static final long serialVersionUID = -2434867452883857743L;
        volatile boolean cancelled;
        final Object[] current;
        final boolean delayErrors;
        final c downstream;
        final AtomicThrowable errors;
        final AtomicLong requested;
        final ZipSubscriber<T, R>[] subscribers;
        final Function<? super Object[], ? extends R> zipper;

        public ZipCoordinator(c cVar, Function<? super Object[], ? extends R> function, int i10, int i11, boolean z10) {
            this.downstream = cVar;
            this.zipper = function;
            this.delayErrors = z10;
            ZipSubscriber<T, R>[] zipSubscriberArr = new ZipSubscriber[i10];
            for (int i12 = 0; i12 < i10; i12++) {
                zipSubscriberArr[i12] = new ZipSubscriber<>(this, i11);
            }
            this.current = new Object[i10];
            this.subscribers = zipSubscriberArr;
            this.requested = new AtomicLong();
            this.errors = new AtomicThrowable();
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
            }
        }

        public void cancelAll() {
            for (ZipSubscriber<T, R> cancel : this.subscribers) {
                cancel.cancel();
            }
        }

        public void drain() {
            T t10;
            boolean z10;
            T t11;
            boolean z11;
            if (getAndIncrement() == 0) {
                c cVar = this.downstream;
                ZipSubscriber<T, R>[] zipSubscriberArr = this.subscribers;
                int length = zipSubscriberArr.length;
                Object[] objArr = this.current;
                int i10 = 1;
                do {
                    long j10 = this.requested.get();
                    long j11 = 0;
                    while (j10 != j11) {
                        if (!this.cancelled) {
                            if (this.delayErrors || this.errors.get() == null) {
                                boolean z12 = false;
                                for (int i11 = 0; i11 < length; i11++) {
                                    ZipSubscriber<T, R> zipSubscriber = zipSubscriberArr[i11];
                                    if (objArr[i11] == null) {
                                        try {
                                            boolean z13 = zipSubscriber.done;
                                            SimpleQueue<T> simpleQueue = zipSubscriber.queue;
                                            if (simpleQueue != null) {
                                                t11 = simpleQueue.poll();
                                            } else {
                                                t11 = null;
                                            }
                                            if (t11 == null) {
                                                z11 = true;
                                            } else {
                                                z11 = false;
                                            }
                                            if (!z13 || !z11) {
                                                if (!z11) {
                                                    objArr[i11] = t11;
                                                }
                                                z12 = true;
                                            } else {
                                                cancelAll();
                                                if (((Throwable) this.errors.get()) != null) {
                                                    cVar.onError(this.errors.terminate());
                                                    return;
                                                } else {
                                                    cVar.onComplete();
                                                    return;
                                                }
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.throwIfFatal(th);
                                            this.errors.addThrowable(th);
                                            if (!this.delayErrors) {
                                                cancelAll();
                                                cVar.onError(this.errors.terminate());
                                                return;
                                            }
                                        }
                                    }
                                }
                                if (z12) {
                                    break;
                                }
                                try {
                                    cVar.onNext(ObjectHelper.requireNonNull(this.zipper.apply(objArr.clone()), "The zipper returned a null value"));
                                    j11++;
                                    Arrays.fill(objArr, (Object) null);
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    cancelAll();
                                    this.errors.addThrowable(th2);
                                    cVar.onError(this.errors.terminate());
                                    return;
                                }
                            } else {
                                cancelAll();
                                cVar.onError(this.errors.terminate());
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (j10 == j11) {
                        if (!this.cancelled) {
                            if (this.delayErrors || this.errors.get() == null) {
                                for (int i12 = 0; i12 < length; i12++) {
                                    ZipSubscriber<T, R> zipSubscriber2 = zipSubscriberArr[i12];
                                    if (objArr[i12] == null) {
                                        try {
                                            boolean z14 = zipSubscriber2.done;
                                            SimpleQueue<T> simpleQueue2 = zipSubscriber2.queue;
                                            if (simpleQueue2 != null) {
                                                t10 = simpleQueue2.poll();
                                            } else {
                                                t10 = null;
                                            }
                                            if (t10 == null) {
                                                z10 = true;
                                            } else {
                                                z10 = false;
                                            }
                                            if (z14 && z10) {
                                                cancelAll();
                                                if (((Throwable) this.errors.get()) != null) {
                                                    cVar.onError(this.errors.terminate());
                                                    return;
                                                } else {
                                                    cVar.onComplete();
                                                    return;
                                                }
                                            } else if (!z10) {
                                                objArr[i12] = t10;
                                            }
                                        } catch (Throwable th3) {
                                            Exceptions.throwIfFatal(th3);
                                            this.errors.addThrowable(th3);
                                            if (!this.delayErrors) {
                                                cancelAll();
                                                cVar.onError(this.errors.terminate());
                                                return;
                                            }
                                        }
                                    }
                                }
                            } else {
                                cancelAll();
                                cVar.onError(this.errors.terminate());
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (j11 != 0) {
                        for (ZipSubscriber<T, R> request : zipSubscriberArr) {
                            request.request(j11);
                        }
                        if (j10 != Long.MAX_VALUE) {
                            this.requested.addAndGet(-j11);
                        }
                    }
                    i10 = addAndGet(-i10);
                } while (i10 != 0);
            }
        }

        public void error(ZipSubscriber<T, R> zipSubscriber, Throwable th) {
            if (this.errors.addThrowable(th)) {
                zipSubscriber.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                BackpressureHelper.add(this.requested, j10);
                drain();
            }
        }

        public void subscribe(b[] bVarArr, int i10) {
            ZipSubscriber<T, R>[] zipSubscriberArr = this.subscribers;
            int i11 = 0;
            while (i11 < i10 && !this.cancelled) {
                if (this.delayErrors || this.errors.get() == null) {
                    bVarArr[i11].subscribe(zipSubscriberArr[i11]);
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    public static final class ZipSubscriber<T, R> extends AtomicReference<d> implements FlowableSubscriber<T>, d {
        private static final long serialVersionUID = -4627193790118206028L;
        volatile boolean done;
        final int limit;
        final ZipCoordinator<T, R> parent;
        final int prefetch;
        long produced;
        SimpleQueue<T> queue;
        int sourceMode;

        public ZipSubscriber(ZipCoordinator<T, R> zipCoordinator, int i10) {
            this.parent = zipCoordinator;
            this.prefetch = i10;
            this.limit = i10 - (i10 >> 2);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        public void onError(Throwable th) {
            this.parent.error(this, th);
        }

        public void onNext(T t10) {
            if (this.sourceMode != 2) {
                this.queue.offer(t10);
            }
            this.parent.drain();
        }

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                if (dVar instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) dVar;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        dVar.request((long) this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                dVar.request((long) this.prefetch);
            }
        }

        public void request(long j10) {
            if (this.sourceMode != 1) {
                long j11 = this.produced + j10;
                if (j11 >= ((long) this.limit)) {
                    this.produced = 0;
                    ((d) get()).request(j11);
                    return;
                }
                this.produced = j11;
            }
        }
    }

    public FlowableZip(b[] bVarArr, Iterable<? extends b> iterable, Function<? super Object[], ? extends R> function, int i10, boolean z10) {
        this.sources = bVarArr;
        this.sourcesIterable = iterable;
        this.zipper = function;
        this.bufferSize = i10;
        this.delayError = z10;
    }

    public void subscribeActual(c cVar) {
        int i10;
        b[] bVarArr = this.sources;
        if (bVarArr == null) {
            bVarArr = new b[8];
            i10 = 0;
            for (b bVar : this.sourcesIterable) {
                if (i10 == bVarArr.length) {
                    b[] bVarArr2 = new b[((i10 >> 2) + i10)];
                    System.arraycopy(bVarArr, 0, bVarArr2, 0, i10);
                    bVarArr = bVarArr2;
                }
                bVarArr[i10] = bVar;
                i10++;
            }
        } else {
            i10 = bVarArr.length;
        }
        int i11 = i10;
        if (i11 == 0) {
            EmptySubscription.complete(cVar);
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(cVar, this.zipper, i11, this.bufferSize, this.delayError);
        cVar.onSubscribe(zipCoordinator);
        zipCoordinator.subscribe(bVarArr, i11);
    }
}
