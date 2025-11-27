package io.reactivex.internal.operators.flowable;

import fb.b;
import fb.c;
import fb.d;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableSwitchMap<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends b> mapper;

    public static final class SwitchMapInnerSubscriber<T, R> extends AtomicReference<d> implements FlowableSubscriber<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long index;
        final SwitchMapSubscriber<T, R> parent;
        volatile SimpleQueue<R> queue;

        public SwitchMapInnerSubscriber(SwitchMapSubscriber<T, R> switchMapSubscriber, long j10, int i10) {
            this.parent = switchMapSubscriber;
            this.index = j10;
            this.bufferSize = i10;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
            if (this.index == switchMapSubscriber.unique) {
                this.done = true;
                switchMapSubscriber.drain();
            }
        }

        public void onError(Throwable th) {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
            if (this.index != switchMapSubscriber.unique || !switchMapSubscriber.error.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!switchMapSubscriber.delayErrors) {
                switchMapSubscriber.upstream.cancel();
                switchMapSubscriber.done = true;
            }
            this.done = true;
            switchMapSubscriber.drain();
        }

        public void onNext(R r10) {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
            if (this.index != switchMapSubscriber.unique) {
                return;
            }
            if (this.fusionMode != 0 || this.queue.offer(r10)) {
                switchMapSubscriber.drain();
            } else {
                onError(new MissingBackpressureException("Queue full?!"));
            }
        }

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                if (dVar instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) dVar;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        dVar.request((long) this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                dVar.request((long) this.bufferSize);
            }
        }

        public void request(long j10) {
            if (this.fusionMode != 1) {
                ((d) get()).request(j10);
            }
        }
    }

    public static final class SwitchMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, d {
        static final SwitchMapInnerSubscriber<Object, Object> CANCELLED;
        private static final long serialVersionUID = -3491074160481096299L;
        final AtomicReference<SwitchMapInnerSubscriber<T, R>> active = new AtomicReference<>();
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final c downstream;
        final AtomicThrowable error;
        final Function<? super T, ? extends b> mapper;
        final AtomicLong requested = new AtomicLong();
        volatile long unique;
        d upstream;

        static {
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber = new SwitchMapInnerSubscriber<>((SwitchMapSubscriber) null, -1, 1);
            CANCELLED = switchMapInnerSubscriber;
            switchMapInnerSubscriber.cancel();
        }

        public SwitchMapSubscriber(c cVar, Function<? super T, ? extends b> function, int i10, boolean z10) {
            this.downstream = cVar;
            this.mapper = function;
            this.bufferSize = i10;
            this.delayErrors = z10;
            this.error = new AtomicThrowable();
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                disposeInner();
            }
        }

        public void disposeInner() {
            SwitchMapInnerSubscriber<Object, Object> andSet;
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber = this.active.get();
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber2 = CANCELLED;
            if (switchMapInnerSubscriber != switchMapInnerSubscriber2 && (andSet = this.active.getAndSet(switchMapInnerSubscriber2)) != switchMapInnerSubscriber2 && andSet != null) {
                andSet.cancel();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:61:0x00e5, code lost:
            r14 = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drain() {
            /*
                r17 = this;
                r1 = r17
                int r0 = r17.getAndIncrement()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                fb.c r2 = r1.downstream
                r4 = 1
            L_0x000c:
                boolean r0 = r1.cancelled
                r5 = 0
                if (r0 == 0) goto L_0x0017
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
                r0.lazySet(r5)
                return
            L_0x0017:
                boolean r0 = r1.done
                if (r0 == 0) goto L_0x0062
                boolean r0 = r1.delayErrors
                if (r0 == 0) goto L_0x003f
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
                java.lang.Object r0 = r0.get()
                if (r0 != 0) goto L_0x0062
                io.reactivex.internal.util.AtomicThrowable r0 = r1.error
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 == 0) goto L_0x003b
                io.reactivex.internal.util.AtomicThrowable r0 = r1.error
                java.lang.Throwable r0 = r0.terminate()
                r2.onError(r0)
                goto L_0x003e
            L_0x003b:
                r2.onComplete()
            L_0x003e:
                return
            L_0x003f:
                io.reactivex.internal.util.AtomicThrowable r0 = r1.error
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 == 0) goto L_0x0056
                r17.disposeInner()
                io.reactivex.internal.util.AtomicThrowable r0 = r1.error
                java.lang.Throwable r0 = r0.terminate()
                r2.onError(r0)
                return
            L_0x0056:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
                java.lang.Object r0 = r0.get()
                if (r0 != 0) goto L_0x0062
                r2.onComplete()
                return
            L_0x0062:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
                java.lang.Object r0 = r0.get()
                r6 = r0
                io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber r6 = (io.reactivex.internal.operators.flowable.FlowableSwitchMap.SwitchMapInnerSubscriber) r6
                if (r6 == 0) goto L_0x0071
                io.reactivex.internal.fuseable.SimpleQueue<R> r0 = r6.queue
                r7 = r0
                goto L_0x0072
            L_0x0071:
                r7 = r5
            L_0x0072:
                if (r7 == 0) goto L_0x0139
                boolean r0 = r6.done
                if (r0 == 0) goto L_0x00ad
                boolean r0 = r1.delayErrors
                if (r0 != 0) goto L_0x00a0
                io.reactivex.internal.util.AtomicThrowable r0 = r1.error
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 == 0) goto L_0x0093
                r17.disposeInner()
                io.reactivex.internal.util.AtomicThrowable r0 = r1.error
                java.lang.Throwable r0 = r0.terminate()
                r2.onError(r0)
                return
            L_0x0093:
                boolean r0 = r7.isEmpty()
                if (r0 == 0) goto L_0x00ad
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
                h3.b.a(r0, r6, r5)
                goto L_0x000c
            L_0x00a0:
                boolean r0 = r7.isEmpty()
                if (r0 == 0) goto L_0x00ad
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
                h3.b.a(r0, r6, r5)
                goto L_0x000c
            L_0x00ad:
                java.util.concurrent.atomic.AtomicLong r0 = r1.requested
                long r8 = r0.get()
                r10 = 0
                r12 = r10
            L_0x00b6:
                r14 = 0
                int r0 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
                if (r0 == 0) goto L_0x011b
                boolean r0 = r1.cancelled
                if (r0 == 0) goto L_0x00c0
                return
            L_0x00c0:
                boolean r0 = r6.done
                java.lang.Object r15 = r7.poll()     // Catch:{ all -> 0x00c7 }
                goto L_0x00d6
            L_0x00c7:
                r0 = move-exception
                r15 = r0
                io.reactivex.exceptions.Exceptions.throwIfFatal(r15)
                r6.cancel()
                io.reactivex.internal.util.AtomicThrowable r0 = r1.error
                r0.addThrowable(r15)
                r15 = r5
                r0 = 1
            L_0x00d6:
                if (r15 != 0) goto L_0x00db
                r16 = 1
                goto L_0x00dd
            L_0x00db:
                r16 = 0
            L_0x00dd:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r3 = r1.active
                java.lang.Object r3 = r3.get()
                if (r6 == r3) goto L_0x00e7
            L_0x00e5:
                r14 = 1
                goto L_0x011b
            L_0x00e7:
                if (r0 == 0) goto L_0x0111
                boolean r0 = r1.delayErrors
                if (r0 != 0) goto L_0x0109
                io.reactivex.internal.util.AtomicThrowable r0 = r1.error
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 == 0) goto L_0x0101
                io.reactivex.internal.util.AtomicThrowable r0 = r1.error
                java.lang.Throwable r0 = r0.terminate()
                r2.onError(r0)
                return
            L_0x0101:
                if (r16 == 0) goto L_0x0111
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
                h3.b.a(r0, r6, r5)
                goto L_0x00e5
            L_0x0109:
                if (r16 == 0) goto L_0x0111
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
                h3.b.a(r0, r6, r5)
                goto L_0x00e5
            L_0x0111:
                if (r16 == 0) goto L_0x0114
                goto L_0x011b
            L_0x0114:
                r2.onNext(r15)
                r14 = 1
                long r12 = r12 + r14
                goto L_0x00b6
            L_0x011b:
                int r0 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
                if (r0 == 0) goto L_0x0135
                boolean r0 = r1.cancelled
                if (r0 != 0) goto L_0x0135
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r0 == 0) goto L_0x0132
                java.util.concurrent.atomic.AtomicLong r0 = r1.requested
                long r7 = -r12
                r0.addAndGet(r7)
            L_0x0132:
                r6.request(r12)
            L_0x0135:
                if (r14 == 0) goto L_0x0139
                goto L_0x000c
            L_0x0139:
                int r0 = -r4
                int r4 = r1.addAndGet(r0)
                if (r4 != 0) goto L_0x000c
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableSwitchMap.SwitchMapSubscriber.drain():void");
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        public void onError(Throwable th) {
            if (this.done || !this.error.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!this.delayErrors) {
                disposeInner();
            }
            this.done = true;
            drain();
        }

        public void onNext(T t10) {
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber;
            if (!this.done) {
                long j10 = this.unique + 1;
                this.unique = j10;
                SwitchMapInnerSubscriber switchMapInnerSubscriber2 = this.active.get();
                if (switchMapInnerSubscriber2 != null) {
                    switchMapInnerSubscriber2.cancel();
                }
                try {
                    b bVar = (b) ObjectHelper.requireNonNull(this.mapper.apply(t10), "The publisher returned is null");
                    SwitchMapInnerSubscriber switchMapInnerSubscriber3 = new SwitchMapInnerSubscriber(this, j10, this.bufferSize);
                    do {
                        switchMapInnerSubscriber = this.active.get();
                        if (switchMapInnerSubscriber == CANCELLED) {
                            return;
                        }
                    } while (!h3.b.a(this.active, switchMapInnerSubscriber, switchMapInnerSubscriber3));
                    bVar.subscribe(switchMapInnerSubscriber3);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.upstream.cancel();
                    onError(th);
                }
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
                BackpressureHelper.add(this.requested, j10);
                if (this.unique == 0) {
                    this.upstream.request(Long.MAX_VALUE);
                } else {
                    drain();
                }
            }
        }
    }

    public FlowableSwitchMap(Flowable<T> flowable, Function<? super T, ? extends b> function, int i10, boolean z10) {
        super(flowable);
        this.mapper = function;
        this.bufferSize = i10;
        this.delayErrors = z10;
    }

    public void subscribeActual(c cVar) {
        if (!FlowableScalarXMap.tryScalarXMapSubscribe(this.source, cVar, this.mapper)) {
            this.source.subscribe(new SwitchMapSubscriber(cVar, this.mapper, this.bufferSize, this.delayErrors));
        }
    }
}
