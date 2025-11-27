package io.reactivex.internal.operators.flowable;

import fb.c;
import fb.d;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableBuffer<T, C extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, C> {
    final Callable<C> bufferSupplier;
    final int size;
    final int skip;

    public static final class PublisherBufferExactSubscriber<T, C extends Collection<? super T>> implements FlowableSubscriber<T>, d {
        C buffer;
        final Callable<C> bufferSupplier;
        boolean done;
        final c downstream;
        int index;
        final int size;
        d upstream;

        public PublisherBufferExactSubscriber(c cVar, int i10, Callable<C> callable) {
            this.downstream = cVar;
            this.size = i10;
            this.bufferSupplier = callable;
        }

        public void cancel() {
            this.upstream.cancel();
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                C c10 = this.buffer;
                if (c10 != null && !c10.isEmpty()) {
                    this.downstream.onNext(c10);
                }
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
        }

        public void onNext(T t10) {
            if (!this.done) {
                C c10 = this.buffer;
                if (c10 == null) {
                    try {
                        c10 = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
                        this.buffer = c10;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        cancel();
                        onError(th);
                        return;
                    }
                }
                c10.add(t10);
                int i10 = this.index + 1;
                if (i10 == this.size) {
                    this.index = 0;
                    this.buffer = null;
                    this.downstream.onNext(c10);
                    return;
                }
                this.index = i10;
            }
        }

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
            }
        }

        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                this.upstream.request(BackpressureHelper.multiplyCap(j10, (long) this.size));
            }
        }
    }

    public static final class PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements FlowableSubscriber<T>, d, BooleanSupplier {
        private static final long serialVersionUID = -7370244972039324525L;
        final Callable<C> bufferSupplier;
        final ArrayDeque<C> buffers = new ArrayDeque<>();
        volatile boolean cancelled;
        boolean done;
        final c downstream;
        int index;
        final AtomicBoolean once = new AtomicBoolean();
        long produced;
        final int size;
        final int skip;
        d upstream;

        public PublisherBufferOverlappingSubscriber(c cVar, int i10, int i11, Callable<C> callable) {
            this.downstream = cVar;
            this.size = i10;
            this.skip = i11;
            this.bufferSupplier = callable;
        }

        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
        }

        public boolean getAsBoolean() {
            return this.cancelled;
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                long j10 = this.produced;
                if (j10 != 0) {
                    BackpressureHelper.produced(this, j10);
                }
                QueueDrainHelper.postComplete(this.downstream, this.buffers, this, this);
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.buffers.clear();
            this.downstream.onError(th);
        }

        public void onNext(T t10) {
            if (!this.done) {
                ArrayDeque<C> arrayDeque = this.buffers;
                int i10 = this.index;
                int i11 = i10 + 1;
                if (i10 == 0) {
                    try {
                        arrayDeque.offer((Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer"));
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        cancel();
                        onError(th);
                        return;
                    }
                }
                Collection collection = (Collection) arrayDeque.peek();
                if (collection != null && collection.size() + 1 == this.size) {
                    arrayDeque.poll();
                    collection.add(t10);
                    this.produced++;
                    this.downstream.onNext(collection);
                }
                Iterator<C> it = arrayDeque.iterator();
                while (it.hasNext()) {
                    ((Collection) it.next()).add(t10);
                }
                if (i11 == this.skip) {
                    i11 = 0;
                }
                this.index = i11;
            }
        }

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
            }
        }

        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                if (!QueueDrainHelper.postCompleteRequest(j10, this.downstream, this.buffers, this, this)) {
                    if (this.once.get() || !this.once.compareAndSet(false, true)) {
                        this.upstream.request(BackpressureHelper.multiplyCap((long) this.skip, j10));
                        return;
                    }
                    this.upstream.request(BackpressureHelper.addCap((long) this.size, BackpressureHelper.multiplyCap((long) this.skip, j10 - 1)));
                }
            }
        }
    }

    public static final class PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements FlowableSubscriber<T>, d {
        private static final long serialVersionUID = -5616169793639412593L;
        C buffer;
        final Callable<C> bufferSupplier;
        boolean done;
        final c downstream;
        int index;
        final int size;
        final int skip;
        d upstream;

        public PublisherBufferSkipSubscriber(c cVar, int i10, int i11, Callable<C> callable) {
            this.downstream = cVar;
            this.size = i10;
            this.skip = i11;
            this.bufferSupplier = callable;
        }

        public void cancel() {
            this.upstream.cancel();
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                C c10 = this.buffer;
                this.buffer = null;
                if (c10 != null) {
                    this.downstream.onNext(c10);
                }
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.buffer = null;
            this.downstream.onError(th);
        }

        public void onNext(T t10) {
            if (!this.done) {
                C c10 = this.buffer;
                int i10 = this.index;
                int i11 = i10 + 1;
                if (i10 == 0) {
                    try {
                        c10 = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
                        this.buffer = c10;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        cancel();
                        onError(th);
                        return;
                    }
                }
                if (c10 != null) {
                    c10.add(t10);
                    if (c10.size() == this.size) {
                        this.buffer = null;
                        this.downstream.onNext(c10);
                    }
                }
                if (i11 == this.skip) {
                    i11 = 0;
                }
                this.index = i11;
            }
        }

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
            }
        }

        public void request(long j10) {
            if (!SubscriptionHelper.validate(j10)) {
                return;
            }
            if (get() != 0 || !compareAndSet(0, 1)) {
                this.upstream.request(BackpressureHelper.multiplyCap((long) this.skip, j10));
                return;
            }
            this.upstream.request(BackpressureHelper.addCap(BackpressureHelper.multiplyCap(j10, (long) this.size), BackpressureHelper.multiplyCap((long) (this.skip - this.size), j10 - 1)));
        }
    }

    public FlowableBuffer(Flowable<T> flowable, int i10, int i11, Callable<C> callable) {
        super(flowable);
        this.size = i10;
        this.skip = i11;
        this.bufferSupplier = callable;
    }

    public void subscribeActual(c cVar) {
        int i10 = this.size;
        int i11 = this.skip;
        if (i10 == i11) {
            this.source.subscribe(new PublisherBufferExactSubscriber(cVar, i10, this.bufferSupplier));
        } else if (i11 > i10) {
            this.source.subscribe(new PublisherBufferSkipSubscriber(cVar, this.size, this.skip, this.bufferSupplier));
        } else {
            this.source.subscribe(new PublisherBufferOverlappingSubscriber(cVar, this.size, this.skip, this.bufferSupplier));
        }
    }
}
