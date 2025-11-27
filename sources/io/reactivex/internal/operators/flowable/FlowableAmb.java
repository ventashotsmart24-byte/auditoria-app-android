package io.reactivex.internal.operators.flowable;

import fb.b;
import fb.c;
import fb.d;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableAmb<T> extends Flowable<T> {
    final b[] sources;
    final Iterable<? extends b> sourcesIterable;

    public static final class AmbCoordinator<T> implements d {
        final c downstream;
        final AmbInnerSubscriber<T>[] subscribers;
        final AtomicInteger winner = new AtomicInteger();

        public AmbCoordinator(c cVar, int i10) {
            this.downstream = cVar;
            this.subscribers = new AmbInnerSubscriber[i10];
        }

        public void cancel() {
            if (this.winner.get() != -1) {
                this.winner.lazySet(-1);
                for (AmbInnerSubscriber<T> cancel : this.subscribers) {
                    cancel.cancel();
                }
            }
        }

        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                int i10 = this.winner.get();
                if (i10 > 0) {
                    this.subscribers[i10 - 1].request(j10);
                } else if (i10 == 0) {
                    for (AmbInnerSubscriber<T> request : this.subscribers) {
                        request.request(j10);
                    }
                }
            }
        }

        public void subscribe(b[] bVarArr) {
            AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.subscribers;
            int length = ambInnerSubscriberArr.length;
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 1;
                ambInnerSubscriberArr[i10] = new AmbInnerSubscriber<>(this, i11, this.downstream);
                i10 = i11;
            }
            this.winner.lazySet(0);
            this.downstream.onSubscribe(this);
            for (int i12 = 0; i12 < length && this.winner.get() == 0; i12++) {
                bVarArr[i12].subscribe(ambInnerSubscriberArr[i12]);
            }
        }

        public boolean win(int i10) {
            int i11 = 0;
            if (this.winner.get() != 0 || !this.winner.compareAndSet(0, i10)) {
                return false;
            }
            AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.subscribers;
            int length = ambInnerSubscriberArr.length;
            while (i11 < length) {
                int i12 = i11 + 1;
                if (i12 != i10) {
                    ambInnerSubscriberArr[i11].cancel();
                }
                i11 = i12;
            }
            return true;
        }
    }

    public static final class AmbInnerSubscriber<T> extends AtomicReference<d> implements FlowableSubscriber<T>, d {
        private static final long serialVersionUID = -1185974347409665484L;
        final c downstream;
        final int index;
        final AtomicLong missedRequested = new AtomicLong();
        final AmbCoordinator<T> parent;
        boolean won;

        public AmbInnerSubscriber(AmbCoordinator<T> ambCoordinator, int i10, c cVar) {
            this.parent = ambCoordinator;
            this.index = i10;
            this.downstream = cVar;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            if (this.won) {
                this.downstream.onComplete();
            } else if (this.parent.win(this.index)) {
                this.won = true;
                this.downstream.onComplete();
            } else {
                ((d) get()).cancel();
            }
        }

        public void onError(Throwable th) {
            if (this.won) {
                this.downstream.onError(th);
            } else if (this.parent.win(this.index)) {
                this.won = true;
                this.downstream.onError(th);
            } else {
                ((d) get()).cancel();
                RxJavaPlugins.onError(th);
            }
        }

        public void onNext(T t10) {
            if (this.won) {
                this.downstream.onNext(t10);
            } else if (this.parent.win(this.index)) {
                this.won = true;
                this.downstream.onNext(t10);
            } else {
                ((d) get()).cancel();
            }
        }

        public void onSubscribe(d dVar) {
            SubscriptionHelper.deferredSetOnce(this, this.missedRequested, dVar);
        }

        public void request(long j10) {
            SubscriptionHelper.deferredRequest(this, this.missedRequested, j10);
        }
    }

    public FlowableAmb(b[] bVarArr, Iterable<? extends b> iterable) {
        this.sources = bVarArr;
        this.sourcesIterable = iterable;
    }

    public void subscribeActual(c cVar) {
        int i10;
        b[] bVarArr = this.sources;
        if (bVarArr == null) {
            bVarArr = new b[8];
            try {
                i10 = 0;
                for (b bVar : this.sourcesIterable) {
                    if (bVar == null) {
                        EmptySubscription.error(new NullPointerException("One of the sources is null"), cVar);
                        return;
                    }
                    if (i10 == bVarArr.length) {
                        b[] bVarArr2 = new b[((i10 >> 2) + i10)];
                        System.arraycopy(bVarArr, 0, bVarArr2, 0, i10);
                        bVarArr = bVarArr2;
                    }
                    int i11 = i10 + 1;
                    bVarArr[i10] = bVar;
                    i10 = i11;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, cVar);
                return;
            }
        } else {
            i10 = bVarArr.length;
        }
        if (i10 == 0) {
            EmptySubscription.complete(cVar);
        } else if (i10 == 1) {
            bVarArr[0].subscribe(cVar);
        } else {
            new AmbCoordinator(cVar, i10).subscribe(bVarArr);
        }
    }
}
