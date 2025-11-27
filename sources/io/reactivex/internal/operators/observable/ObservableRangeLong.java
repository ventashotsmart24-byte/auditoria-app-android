package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

public final class ObservableRangeLong extends Observable<Long> {
    private final long count;
    private final long start;

    public static final class RangeDisposable extends BasicIntQueueDisposable<Long> {
        private static final long serialVersionUID = 396518478098735504L;
        final Observer<? super Long> downstream;
        final long end;
        boolean fused;
        long index;

        public RangeDisposable(Observer<? super Long> observer, long j10, long j11) {
            this.downstream = observer;
            this.index = j10;
            this.end = j11;
        }

        public void clear() {
            this.index = this.end;
            lazySet(1);
        }

        public void dispose() {
            set(1);
        }

        public boolean isDisposed() {
            if (get() != 0) {
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            if (this.index == this.end) {
                return true;
            }
            return false;
        }

        public int requestFusion(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            this.fused = true;
            return 1;
        }

        public void run() {
            if (!this.fused) {
                Observer<? super Long> observer = this.downstream;
                long j10 = this.end;
                for (long j11 = this.index; j11 != j10 && get() == 0; j11++) {
                    observer.onNext(Long.valueOf(j11));
                }
                if (get() == 0) {
                    lazySet(1);
                    observer.onComplete();
                }
            }
        }

        @Nullable
        public Long poll() {
            long j10 = this.index;
            if (j10 != this.end) {
                this.index = 1 + j10;
                return Long.valueOf(j10);
            }
            lazySet(1);
            return null;
        }
    }

    public ObservableRangeLong(long j10, long j11) {
        this.start = j10;
        this.count = j11;
    }

    public void subscribeActual(Observer<? super Long> observer) {
        long j10 = this.start;
        RangeDisposable rangeDisposable = new RangeDisposable(observer, j10, j10 + this.count);
        observer.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }
}
