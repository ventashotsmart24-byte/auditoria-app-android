package io.reactivex.internal.operators.flowable;

import fb.c;
import fb.d;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableOnBackpressureLatest<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class BackpressureLatestSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, d {
        private static final long serialVersionUID = 163080509307634843L;
        volatile boolean cancelled;
        final AtomicReference<T> current = new AtomicReference<>();
        volatile boolean done;
        final c downstream;
        Throwable error;
        final AtomicLong requested = new AtomicLong();
        d upstream;

        public BackpressureLatestSubscriber(c cVar) {
            this.downstream = cVar;
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.current.lazySet((Object) null);
                }
            }
        }

        public boolean checkTerminated(boolean z10, boolean z11, c cVar, AtomicReference<T> atomicReference) {
            if (this.cancelled) {
                atomicReference.lazySet((Object) null);
                return true;
            } else if (!z10) {
                return false;
            } else {
                Throwable th = this.error;
                if (th != null) {
                    atomicReference.lazySet((Object) null);
                    cVar.onError(th);
                    return true;
                } else if (!z11) {
                    return false;
                } else {
                    cVar.onComplete();
                    return true;
                }
            }
        }

        public void drain() {
            boolean z10;
            boolean z11;
            if (getAndIncrement() == 0) {
                c cVar = this.downstream;
                AtomicLong atomicLong = this.requested;
                AtomicReference<T> atomicReference = this.current;
                int i10 = 1;
                do {
                    long j10 = 0;
                    while (true) {
                        z10 = false;
                        if (j10 == atomicLong.get()) {
                            break;
                        }
                        boolean z12 = this.done;
                        T andSet = atomicReference.getAndSet((Object) null);
                        if (andSet == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (!checkTerminated(z12, z11, cVar, atomicReference)) {
                            if (z11) {
                                break;
                            }
                            cVar.onNext(andSet);
                            j10++;
                        } else {
                            return;
                        }
                    }
                    if (j10 == atomicLong.get()) {
                        boolean z13 = this.done;
                        if (atomicReference.get() == null) {
                            z10 = true;
                        }
                        if (checkTerminated(z13, z10, cVar, atomicReference)) {
                            return;
                        }
                    }
                    if (j10 != 0) {
                        BackpressureHelper.produced(atomicLong, j10);
                    }
                    i10 = addAndGet(-i10);
                } while (i10 != 0);
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
            this.current.lazySet(t10);
            drain();
        }

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                BackpressureHelper.add(this.requested, j10);
                drain();
            }
        }
    }

    public FlowableOnBackpressureLatest(Flowable<T> flowable) {
        super(flowable);
    }

    public void subscribeActual(c cVar) {
        this.source.subscribe(new BackpressureLatestSubscriber(cVar));
    }
}
