package io.reactivex.internal.operators.mixed;

import fb.b;
import fb.c;
import fb.d;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableAndThenPublisher<R> extends Flowable<R> {
    final b other;
    final CompletableSource source;

    public CompletableAndThenPublisher(CompletableSource completableSource, b bVar) {
        this.source = completableSource;
        this.other = bVar;
    }

    public void subscribeActual(c cVar) {
        this.source.subscribe(new AndThenPublisherSubscriber(cVar, this.other));
    }

    public static final class AndThenPublisherSubscriber<R> extends AtomicReference<d> implements FlowableSubscriber<R>, CompletableObserver, d {
        private static final long serialVersionUID = -8948264376121066672L;
        final c downstream;
        b other;
        final AtomicLong requested = new AtomicLong();
        Disposable upstream;

        public AndThenPublisherSubscriber(c cVar, b bVar) {
            this.downstream = cVar;
            this.other = bVar;
        }

        public void cancel() {
            this.upstream.dispose();
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            b bVar = this.other;
            if (bVar == null) {
                this.downstream.onComplete();
                return;
            }
            this.other = null;
            bVar.subscribe(this);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onNext(R r10) {
            this.downstream.onNext(r10);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void request(long j10) {
            SubscriptionHelper.deferredRequest(this, this.requested, j10);
        }

        public void onSubscribe(d dVar) {
            SubscriptionHelper.deferredSetOnce(this, this.requested, dVar);
        }
    }
}
