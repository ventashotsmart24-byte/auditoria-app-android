package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableDelay extends Completable {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final CompletableSource source;
    final TimeUnit unit;

    public static final class Delay extends AtomicReference<Disposable> implements CompletableObserver, Runnable, Disposable {
        private static final long serialVersionUID = 465972761105851022L;
        final long delay;
        final boolean delayError;
        final CompletableObserver downstream;
        Throwable error;
        final Scheduler scheduler;
        final TimeUnit unit;

        public Delay(CompletableObserver completableObserver, long j10, TimeUnit timeUnit, Scheduler scheduler2, boolean z10) {
            this.downstream = completableObserver;
            this.delay = j10;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
            this.delayError = z10;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            DisposableHelper.replace(this, this.scheduler.scheduleDirect(this, this.delay, this.unit));
        }

        public void onError(Throwable th) {
            long j10;
            this.error = th;
            Scheduler scheduler2 = this.scheduler;
            if (this.delayError) {
                j10 = this.delay;
            } else {
                j10 = 0;
            }
            DisposableHelper.replace(this, scheduler2.scheduleDirect(this, j10, this.unit));
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.downstream.onSubscribe(this);
            }
        }

        public void run() {
            Throwable th = this.error;
            this.error = null;
            if (th != null) {
                this.downstream.onError(th);
            } else {
                this.downstream.onComplete();
            }
        }
    }

    public CompletableDelay(CompletableSource completableSource, long j10, TimeUnit timeUnit, Scheduler scheduler2, boolean z10) {
        this.source = completableSource;
        this.delay = j10;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.delayError = z10;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new Delay(completableObserver, this.delay, this.unit, this.scheduler, this.delayError));
    }
}
