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
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableConcatMapEager<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends b> mapper;
    final int maxConcurrency;
    final int prefetch;

    public static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, d, InnerQueuedSubscriberSupport<R> {
        private static final long serialVersionUID = -4255299542215038287L;
        volatile boolean cancelled;
        volatile InnerQueuedSubscriber<R> current;
        volatile boolean done;
        final c downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors = new AtomicThrowable();
        final Function<? super T, ? extends b> mapper;
        final int maxConcurrency;
        final int prefetch;
        final AtomicLong requested = new AtomicLong();
        final SpscLinkedArrayQueue<InnerQueuedSubscriber<R>> subscribers;
        d upstream;

        public ConcatMapEagerDelayErrorSubscriber(c cVar, Function<? super T, ? extends b> function, int i10, int i11, ErrorMode errorMode2) {
            this.downstream = cVar;
            this.mapper = function;
            this.maxConcurrency = i10;
            this.prefetch = i11;
            this.errorMode = errorMode2;
            this.subscribers = new SpscLinkedArrayQueue<>(Math.min(i11, i10));
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                drainAndCancel();
            }
        }

        public void cancelAll() {
            InnerQueuedSubscriber<R> innerQueuedSubscriber = this.current;
            this.current = null;
            if (innerQueuedSubscriber != null) {
                innerQueuedSubscriber.cancel();
            }
            while (true) {
                InnerQueuedSubscriber poll = this.subscribers.poll();
                if (poll != null) {
                    poll.cancel();
                } else {
                    return;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c7, code lost:
            r0 = false;
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
                io.reactivex.internal.subscribers.InnerQueuedSubscriber<R> r0 = r1.current
                fb.c r2 = r1.downstream
                io.reactivex.internal.util.ErrorMode r3 = r1.errorMode
                r5 = 1
            L_0x0010:
                java.util.concurrent.atomic.AtomicLong r6 = r1.requested
                long r6 = r6.get()
                if (r0 != 0) goto L_0x0056
                io.reactivex.internal.util.ErrorMode r0 = io.reactivex.internal.util.ErrorMode.END
                if (r3 == r0) goto L_0x0033
                io.reactivex.internal.util.AtomicThrowable r0 = r1.errors
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 == 0) goto L_0x0033
                r17.cancelAll()
                io.reactivex.internal.util.AtomicThrowable r0 = r1.errors
                java.lang.Throwable r0 = r0.terminate()
                r2.onError(r0)
                return
            L_0x0033:
                boolean r0 = r1.done
                io.reactivex.internal.queue.SpscLinkedArrayQueue<io.reactivex.internal.subscribers.InnerQueuedSubscriber<R>> r8 = r1.subscribers
                java.lang.Object r8 = r8.poll()
                io.reactivex.internal.subscribers.InnerQueuedSubscriber r8 = (io.reactivex.internal.subscribers.InnerQueuedSubscriber) r8
                if (r0 == 0) goto L_0x0051
                if (r8 != 0) goto L_0x0051
                io.reactivex.internal.util.AtomicThrowable r0 = r1.errors
                java.lang.Throwable r0 = r0.terminate()
                if (r0 == 0) goto L_0x004d
                r2.onError(r0)
                goto L_0x0050
            L_0x004d:
                r2.onComplete()
            L_0x0050:
                return
            L_0x0051:
                if (r8 == 0) goto L_0x0057
                r1.current = r8
                goto L_0x0057
            L_0x0056:
                r8 = r0
            L_0x0057:
                if (r8 == 0) goto L_0x010c
                io.reactivex.internal.fuseable.SimpleQueue r11 = r8.queue()
                if (r11 == 0) goto L_0x010c
                r12 = 0
            L_0x0061:
                r14 = 1
                r4 = 0
                int r16 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
                if (r16 == 0) goto L_0x00c7
                boolean r0 = r1.cancelled
                if (r0 == 0) goto L_0x0070
                r17.cancelAll()
                return
            L_0x0070:
                io.reactivex.internal.util.ErrorMode r0 = io.reactivex.internal.util.ErrorMode.IMMEDIATE
                if (r3 != r0) goto L_0x0090
                io.reactivex.internal.util.AtomicThrowable r0 = r1.errors
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 == 0) goto L_0x0090
                r1.current = r4
                r8.cancel()
                r17.cancelAll()
                io.reactivex.internal.util.AtomicThrowable r0 = r1.errors
                java.lang.Throwable r0 = r0.terminate()
                r2.onError(r0)
                return
            L_0x0090:
                boolean r0 = r8.isDone()
                java.lang.Object r9 = r11.poll()     // Catch:{ all -> 0x00b6 }
                if (r9 != 0) goto L_0x009c
                r10 = 1
                goto L_0x009d
            L_0x009c:
                r10 = 0
            L_0x009d:
                if (r0 == 0) goto L_0x00ab
                if (r10 == 0) goto L_0x00ab
                r1.current = r4
                fb.d r0 = r1.upstream
                r0.request(r14)
                r8 = r4
                r0 = 1
                goto L_0x00c8
            L_0x00ab:
                if (r10 == 0) goto L_0x00ae
                goto L_0x00c7
            L_0x00ae:
                r2.onNext(r9)
                long r12 = r12 + r14
                r8.requestOne()
                goto L_0x0061
            L_0x00b6:
                r0 = move-exception
                r3 = r0
                io.reactivex.exceptions.Exceptions.throwIfFatal(r3)
                r1.current = r4
                r8.cancel()
                r17.cancelAll()
                r2.onError(r3)
                return
            L_0x00c7:
                r0 = 0
            L_0x00c8:
                int r9 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
                if (r9 != 0) goto L_0x0109
                boolean r9 = r1.cancelled
                if (r9 == 0) goto L_0x00d4
                r17.cancelAll()
                return
            L_0x00d4:
                io.reactivex.internal.util.ErrorMode r9 = io.reactivex.internal.util.ErrorMode.IMMEDIATE
                if (r3 != r9) goto L_0x00f4
                io.reactivex.internal.util.AtomicThrowable r9 = r1.errors
                java.lang.Object r9 = r9.get()
                java.lang.Throwable r9 = (java.lang.Throwable) r9
                if (r9 == 0) goto L_0x00f4
                r1.current = r4
                r8.cancel()
                r17.cancelAll()
                io.reactivex.internal.util.AtomicThrowable r0 = r1.errors
                java.lang.Throwable r0 = r0.terminate()
                r2.onError(r0)
                return
            L_0x00f4:
                boolean r9 = r8.isDone()
                boolean r10 = r11.isEmpty()
                if (r9 == 0) goto L_0x0109
                if (r10 == 0) goto L_0x0109
                r1.current = r4
                fb.d r0 = r1.upstream
                r0.request(r14)
                r8 = r4
                r0 = 1
            L_0x0109:
                r9 = 0
                goto L_0x0111
            L_0x010c:
                r0 = 0
                r9 = 0
                r12 = 0
            L_0x0111:
                int r4 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
                if (r4 == 0) goto L_0x0124
                r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r4 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
                if (r4 == 0) goto L_0x0124
                java.util.concurrent.atomic.AtomicLong r4 = r1.requested
                long r6 = -r12
                r4.addAndGet(r6)
            L_0x0124:
                if (r0 == 0) goto L_0x0129
            L_0x0126:
                r0 = r8
                goto L_0x0010
            L_0x0129:
                int r0 = -r5
                int r5 = r1.addAndGet(r0)
                if (r5 != 0) goto L_0x0126
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber.drain():void");
        }

        public void drainAndCancel() {
            if (getAndIncrement() == 0) {
                do {
                    cancelAll();
                } while (decrementAndGet() != 0);
            }
        }

        public void innerComplete(InnerQueuedSubscriber<R> innerQueuedSubscriber) {
            innerQueuedSubscriber.setDone();
            drain();
        }

        public void innerError(InnerQueuedSubscriber<R> innerQueuedSubscriber, Throwable th) {
            if (this.errors.addThrowable(th)) {
                innerQueuedSubscriber.setDone();
                if (this.errorMode != ErrorMode.END) {
                    this.upstream.cancel();
                }
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void innerNext(InnerQueuedSubscriber<R> innerQueuedSubscriber, R r10) {
            if (innerQueuedSubscriber.queue().offer(r10)) {
                drain();
                return;
            }
            innerQueuedSubscriber.cancel();
            innerError(innerQueuedSubscriber, new MissingBackpressureException());
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onNext(T t10) {
            try {
                b bVar = (b) ObjectHelper.requireNonNull(this.mapper.apply(t10), "The mapper returned a null Publisher");
                InnerQueuedSubscriber innerQueuedSubscriber = new InnerQueuedSubscriber(this, this.prefetch);
                if (!this.cancelled) {
                    this.subscribers.offer(innerQueuedSubscriber);
                    bVar.subscribe(innerQueuedSubscriber);
                    if (this.cancelled) {
                        innerQueuedSubscriber.cancel();
                        drainAndCancel();
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.upstream.cancel();
                onError(th);
            }
        }

        public void onSubscribe(d dVar) {
            long j10;
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
                int i10 = this.maxConcurrency;
                if (i10 == Integer.MAX_VALUE) {
                    j10 = Long.MAX_VALUE;
                } else {
                    j10 = (long) i10;
                }
                dVar.request(j10);
            }
        }

        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                BackpressureHelper.add(this.requested, j10);
                drain();
            }
        }
    }

    public FlowableConcatMapEager(Flowable<T> flowable, Function<? super T, ? extends b> function, int i10, int i11, ErrorMode errorMode2) {
        super(flowable);
        this.mapper = function;
        this.maxConcurrency = i10;
        this.prefetch = i11;
        this.errorMode = errorMode2;
    }

    public void subscribeActual(c cVar) {
        this.source.subscribe(new ConcatMapEagerDelayErrorSubscriber(cVar, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode));
    }
}
