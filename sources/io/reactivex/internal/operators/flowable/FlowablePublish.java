package io.reactivex.internal.operators.flowable;

import fb.b;
import fb.c;
import fb.d;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowablePublish<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T>, FlowablePublishClassic<T> {
    static final long CANCELLED = Long.MIN_VALUE;
    final int bufferSize;
    final AtomicReference<PublishSubscriber<T>> current;
    final b onSubscribe;
    final Flowable<T> source;

    public static final class FlowablePublisher<T> implements b {
        private final int bufferSize;
        private final AtomicReference<PublishSubscriber<T>> curr;

        public FlowablePublisher(AtomicReference<PublishSubscriber<T>> atomicReference, int i10) {
            this.curr = atomicReference;
            this.bufferSize = i10;
        }

        public void subscribe(c cVar) {
            PublishSubscriber<T> publishSubscriber;
            InnerSubscriber innerSubscriber = new InnerSubscriber(cVar);
            cVar.onSubscribe(innerSubscriber);
            while (true) {
                publishSubscriber = this.curr.get();
                if (publishSubscriber == null || publishSubscriber.isDisposed()) {
                    PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(this.curr, this.bufferSize);
                    if (!h3.b.a(this.curr, publishSubscriber, publishSubscriber2)) {
                        continue;
                    } else {
                        publishSubscriber = publishSubscriber2;
                    }
                }
                if (publishSubscriber.add(innerSubscriber)) {
                    break;
                }
            }
            if (innerSubscriber.get() == FlowablePublish.CANCELLED) {
                publishSubscriber.remove(innerSubscriber);
            } else {
                innerSubscriber.parent = publishSubscriber;
            }
            publishSubscriber.dispatch();
        }
    }

    public static final class InnerSubscriber<T> extends AtomicLong implements d {
        private static final long serialVersionUID = -4453897557930727610L;
        final c child;
        long emitted;
        volatile PublishSubscriber<T> parent;

        public InnerSubscriber(c cVar) {
            this.child = cVar;
        }

        public void cancel() {
            PublishSubscriber<T> publishSubscriber;
            if (get() != FlowablePublish.CANCELLED && getAndSet(FlowablePublish.CANCELLED) != FlowablePublish.CANCELLED && (publishSubscriber = this.parent) != null) {
                publishSubscriber.remove(this);
                publishSubscriber.dispatch();
            }
        }

        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                BackpressureHelper.addCancel(this, j10);
                PublishSubscriber<T> publishSubscriber = this.parent;
                if (publishSubscriber != null) {
                    publishSubscriber.dispatch();
                }
            }
        }
    }

    public static final class PublishSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        static final InnerSubscriber[] EMPTY = new InnerSubscriber[0];
        static final InnerSubscriber[] TERMINATED = new InnerSubscriber[0];
        private static final long serialVersionUID = -202316842419149694L;
        final int bufferSize;
        final AtomicReference<PublishSubscriber<T>> current;
        volatile SimpleQueue<T> queue;
        final AtomicBoolean shouldConnect;
        int sourceMode;
        final AtomicReference<InnerSubscriber<T>[]> subscribers = new AtomicReference<>(EMPTY);
        volatile Object terminalEvent;
        final AtomicReference<d> upstream = new AtomicReference<>();

        public PublishSubscriber(AtomicReference<PublishSubscriber<T>> atomicReference, int i10) {
            this.current = atomicReference;
            this.shouldConnect = new AtomicBoolean();
            this.bufferSize = i10;
        }

        public boolean add(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.subscribers.get();
                if (innerSubscriberArr == TERMINATED) {
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[(length + 1)];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!h3.b.a(this.subscribers, innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        public boolean checkTerminated(Object obj, boolean z10) {
            int i10 = 0;
            if (obj != null) {
                if (!NotificationLite.isComplete(obj)) {
                    Throwable error = NotificationLite.getError(obj);
                    h3.b.a(this.current, this, (Object) null);
                    InnerSubscriber[] innerSubscriberArr = (InnerSubscriber[]) this.subscribers.getAndSet(TERMINATED);
                    if (innerSubscriberArr.length != 0) {
                        int length = innerSubscriberArr.length;
                        while (i10 < length) {
                            innerSubscriberArr[i10].child.onError(error);
                            i10++;
                        }
                    } else {
                        RxJavaPlugins.onError(error);
                    }
                    return true;
                } else if (z10) {
                    h3.b.a(this.current, this, (Object) null);
                    InnerSubscriber[] innerSubscriberArr2 = (InnerSubscriber[]) this.subscribers.getAndSet(TERMINATED);
                    int length2 = innerSubscriberArr2.length;
                    while (i10 < length2) {
                        innerSubscriberArr2[i10].child.onComplete();
                        i10++;
                    }
                    return true;
                }
            }
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:73:0x0136, code lost:
            if (r11 == 0) goto L_0x0149;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0138, code lost:
            r3 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x013b, code lost:
            if (r1.sourceMode == 1) goto L_0x014a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x013d, code lost:
            r1.upstream.get().request(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0149, code lost:
            r3 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x014e, code lost:
            if (r14 == 0) goto L_0x0154;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0150, code lost:
            if (r8 != false) goto L_0x0154;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x0014, code lost:
            continue;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void dispatch() {
            /*
                r25 = this;
                r1 = r25
                int r0 = r25.getAndIncrement()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish$InnerSubscriber<T>[]> r2 = r1.subscribers
                java.lang.Object r0 = r2.get()
                io.reactivex.internal.operators.flowable.FlowablePublish$InnerSubscriber[] r0 = (io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber[]) r0
                r3 = 1
                r4 = r0
                r5 = 1
            L_0x0014:
                java.lang.Object r0 = r1.terminalEvent
                io.reactivex.internal.fuseable.SimpleQueue<T> r6 = r1.queue
                if (r6 == 0) goto L_0x0023
                boolean r8 = r6.isEmpty()
                if (r8 == 0) goto L_0x0021
                goto L_0x0023
            L_0x0021:
                r8 = 0
                goto L_0x0024
            L_0x0023:
                r8 = 1
            L_0x0024:
                boolean r0 = r1.checkTerminated(r0, r8)
                if (r0 == 0) goto L_0x002b
                return
            L_0x002b:
                if (r8 != 0) goto L_0x0154
                int r0 = r4.length
                int r9 = r4.length
                r12 = 0
                r13 = 0
                r14 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            L_0x0036:
                r16 = -9223372036854775808
                if (r12 >= r9) goto L_0x0052
                r7 = r4[r12]
                long r18 = r7.get()
                int r20 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
                if (r20 == 0) goto L_0x004d
                long r10 = r7.emitted
                long r10 = r18 - r10
                long r14 = java.lang.Math.min(r14, r10)
                goto L_0x004f
            L_0x004d:
                int r13 = r13 + 1
            L_0x004f:
                int r12 = r12 + 1
                goto L_0x0036
            L_0x0052:
                r9 = 1
                if (r0 != r13) goto L_0x0090
                java.lang.Object r0 = r1.terminalEvent
                java.lang.Object r7 = r6.poll()     // Catch:{ all -> 0x005d }
                goto L_0x0074
            L_0x005d:
                r0 = move-exception
                r6 = r0
                io.reactivex.exceptions.Exceptions.throwIfFatal(r6)
                java.util.concurrent.atomic.AtomicReference<fb.d> r0 = r1.upstream
                java.lang.Object r0 = r0.get()
                fb.d r0 = (fb.d) r0
                r0.cancel()
                java.lang.Object r0 = io.reactivex.internal.util.NotificationLite.error(r6)
                r1.terminalEvent = r0
                r7 = 0
            L_0x0074:
                if (r7 != 0) goto L_0x0078
                r7 = 1
                goto L_0x0079
            L_0x0078:
                r7 = 0
            L_0x0079:
                boolean r0 = r1.checkTerminated(r0, r7)
                if (r0 == 0) goto L_0x0080
                return
            L_0x0080:
                int r0 = r1.sourceMode
                if (r0 == r3) goto L_0x0014
                java.util.concurrent.atomic.AtomicReference<fb.d> r0 = r1.upstream
                java.lang.Object r0 = r0.get()
                fb.d r0 = (fb.d) r0
                r0.request(r9)
                goto L_0x0014
            L_0x0090:
                r11 = 0
            L_0x0091:
                long r12 = (long) r11
                int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r0 >= 0) goto L_0x0136
                java.lang.Object r0 = r1.terminalEvent
                java.lang.Object r8 = r6.poll()     // Catch:{ all -> 0x009d }
                goto L_0x00b4
            L_0x009d:
                r0 = move-exception
                r8 = r0
                io.reactivex.exceptions.Exceptions.throwIfFatal(r8)
                java.util.concurrent.atomic.AtomicReference<fb.d> r0 = r1.upstream
                java.lang.Object r0 = r0.get()
                fb.d r0 = (fb.d) r0
                r0.cancel()
                java.lang.Object r0 = io.reactivex.internal.util.NotificationLite.error(r8)
                r1.terminalEvent = r0
                r8 = 0
            L_0x00b4:
                if (r8 != 0) goto L_0x00b8
                r7 = 1
                goto L_0x00b9
            L_0x00b8:
                r7 = 0
            L_0x00b9:
                boolean r0 = r1.checkTerminated(r0, r7)
                if (r0 == 0) goto L_0x00c0
                return
            L_0x00c0:
                if (r7 == 0) goto L_0x00c5
                r8 = r7
                goto L_0x0136
            L_0x00c5:
                java.lang.Object r0 = io.reactivex.internal.util.NotificationLite.getValue(r8)
                int r8 = r4.length
                r12 = 0
                r13 = 0
            L_0x00cc:
                if (r12 >= r8) goto L_0x0102
                r3 = r4[r12]
                long r22 = r3.get()
                int r24 = (r22 > r16 ? 1 : (r22 == r16 ? 0 : -1))
                if (r24 == 0) goto L_0x00f0
                r20 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r24 = (r22 > r20 ? 1 : (r22 == r20 ? 0 : -1))
                r22 = r6
                r23 = r7
                if (r24 == 0) goto L_0x00ea
                long r6 = r3.emitted
                long r6 = r6 + r9
                r3.emitted = r6
            L_0x00ea:
                fb.c r3 = r3.child
                r3.onNext(r0)
                goto L_0x00fa
            L_0x00f0:
                r22 = r6
                r23 = r7
                r20 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r13 = 1
            L_0x00fa:
                int r12 = r12 + 1
                r6 = r22
                r7 = r23
                r3 = 1
                goto L_0x00cc
            L_0x0102:
                r22 = r6
                r23 = r7
                r20 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r11 = r11 + 1
                java.lang.Object r0 = r2.get()
                io.reactivex.internal.operators.flowable.FlowablePublish$InnerSubscriber[] r0 = (io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber[]) r0
                if (r13 != 0) goto L_0x011f
                if (r0 == r4) goto L_0x0118
                goto L_0x011f
            L_0x0118:
                r6 = r22
                r8 = r23
                r3 = 1
                goto L_0x0091
            L_0x011f:
                if (r11 == 0) goto L_0x0132
                int r3 = r1.sourceMode
                r4 = 1
                if (r3 == r4) goto L_0x0132
                java.util.concurrent.atomic.AtomicReference<fb.d> r3 = r1.upstream
                java.lang.Object r3 = r3.get()
                fb.d r3 = (fb.d) r3
                long r6 = (long) r11
                r3.request(r6)
            L_0x0132:
                r4 = r0
                r3 = 1
                goto L_0x0014
            L_0x0136:
                if (r11 == 0) goto L_0x0149
                int r0 = r1.sourceMode
                r3 = 1
                if (r0 == r3) goto L_0x014a
                java.util.concurrent.atomic.AtomicReference<fb.d> r0 = r1.upstream
                java.lang.Object r0 = r0.get()
                fb.d r0 = (fb.d) r0
                r0.request(r12)
                goto L_0x014a
            L_0x0149:
                r3 = 1
            L_0x014a:
                r6 = 0
                int r0 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
                if (r0 == 0) goto L_0x0154
                if (r8 != 0) goto L_0x0154
                goto L_0x0014
            L_0x0154:
                int r0 = -r5
                int r5 = r1.addAndGet(r0)
                if (r5 != 0) goto L_0x015c
                return
            L_0x015c:
                java.lang.Object r0 = r2.get()
                r4 = r0
                io.reactivex.internal.operators.flowable.FlowablePublish$InnerSubscriber[] r4 = (io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber[]) r4
                goto L_0x0014
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber.dispatch():void");
        }

        public void dispose() {
            InnerSubscriber<T>[] innerSubscriberArr = this.subscribers.get();
            InnerSubscriber<T>[] innerSubscriberArr2 = TERMINATED;
            if (innerSubscriberArr != innerSubscriberArr2 && ((InnerSubscriber[]) this.subscribers.getAndSet(innerSubscriberArr2)) != innerSubscriberArr2) {
                h3.b.a(this.current, this, (Object) null);
                SubscriptionHelper.cancel(this.upstream);
            }
        }

        public boolean isDisposed() {
            if (this.subscribers.get() == TERMINATED) {
                return true;
            }
            return false;
        }

        public void onComplete() {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.complete();
                dispatch();
            }
        }

        public void onError(Throwable th) {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.error(th);
                dispatch();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onNext(T t10) {
            if (this.sourceMode != 0 || this.queue.offer(t10)) {
                dispatch();
            } else {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            }
        }

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.setOnce(this.upstream, dVar)) {
                if (dVar instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) dVar;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.terminalEvent = NotificationLite.complete();
                        dispatch();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        dVar.request((long) this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                dVar.request((long) this.bufferSize);
            }
        }

        public void remove(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (length != 0) {
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length) {
                            i10 = -1;
                            break;
                        } else if (innerSubscriberArr[i10].equals(innerSubscriber)) {
                            break;
                        } else {
                            i10++;
                        }
                    }
                    if (i10 >= 0) {
                        if (length == 1) {
                            innerSubscriberArr2 = EMPTY;
                        } else {
                            InnerSubscriber[] innerSubscriberArr3 = new InnerSubscriber[(length - 1)];
                            System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i10);
                            System.arraycopy(innerSubscriberArr, i10 + 1, innerSubscriberArr3, i10, (length - i10) - 1);
                            innerSubscriberArr2 = innerSubscriberArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!h3.b.a(this.subscribers, innerSubscriberArr, innerSubscriberArr2));
        }
    }

    private FlowablePublish(b bVar, Flowable<T> flowable, AtomicReference<PublishSubscriber<T>> atomicReference, int i10) {
        this.onSubscribe = bVar;
        this.source = flowable;
        this.current = atomicReference;
        this.bufferSize = i10;
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, int i10) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly(new FlowablePublish(new FlowablePublisher(atomicReference, i10), flowable, atomicReference, i10));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish$PublishSubscriber<T>> r0 = r4.current
            java.lang.Object r0 = r0.get()
            io.reactivex.internal.operators.flowable.FlowablePublish$PublishSubscriber r0 = (io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.isDisposed()
            if (r1 == 0) goto L_0x0023
        L_0x0010:
            io.reactivex.internal.operators.flowable.FlowablePublish$PublishSubscriber r1 = new io.reactivex.internal.operators.flowable.FlowablePublish$PublishSubscriber
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish$PublishSubscriber<T>> r2 = r4.current
            int r3 = r4.bufferSize
            r1.<init>(r2, r3)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish$PublishSubscriber<T>> r2 = r4.current
            boolean r0 = h3.b.a(r2, r0, r1)
            if (r0 != 0) goto L_0x0022
            goto L_0x0000
        L_0x0022:
            r0 = r1
        L_0x0023:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.shouldConnect
            boolean r1 = r1.get()
            r2 = 0
            if (r1 != 0) goto L_0x0036
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.shouldConnect
            r3 = 1
            boolean r1 = r1.compareAndSet(r2, r3)
            if (r1 == 0) goto L_0x0036
            r2 = 1
        L_0x0036:
            r5.accept(r0)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0040
            io.reactivex.Flowable<T> r5 = r4.source
            r5.subscribe(r0)
        L_0x0040:
            return
        L_0x0041:
            r5 = move-exception
            io.reactivex.exceptions.Exceptions.throwIfFatal(r5)
            java.lang.RuntimeException r5 = io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(r5)
            goto L_0x004b
        L_0x004a:
            throw r5
        L_0x004b:
            goto L_0x004a
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublish.connect(io.reactivex.functions.Consumer):void");
    }

    public int publishBufferSize() {
        return this.bufferSize;
    }

    public b publishSource() {
        return this.source;
    }

    public b source() {
        return this.source;
    }

    public void subscribeActual(c cVar) {
        this.onSubscribe.subscribe(cVar);
    }
}
