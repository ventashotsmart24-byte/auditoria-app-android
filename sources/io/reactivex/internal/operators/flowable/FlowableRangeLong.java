package io.reactivex.internal.operators.flowable;

import fb.c;
import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;

public final class FlowableRangeLong extends Flowable<Long> {
    final long end;
    final long start;

    public static abstract class BaseRangeSubscription extends BasicQueueSubscription<Long> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final long end;
        long index;

        public BaseRangeSubscription(long j10, long j11) {
            this.index = j10;
            this.end = j11;
        }

        public final void cancel() {
            this.cancelled = true;
        }

        public final void clear() {
            this.index = this.end;
        }

        public abstract void fastPath();

        public final boolean isEmpty() {
            if (this.index == this.end) {
                return true;
            }
            return false;
        }

        public final void request(long j10) {
            if (SubscriptionHelper.validate(j10) && BackpressureHelper.add(this, j10) == 0) {
                if (j10 == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j10);
                }
            }
        }

        public final int requestFusion(int i10) {
            return i10 & 1;
        }

        public abstract void slowPath(long j10);

        @Nullable
        public final Long poll() {
            long j10 = this.index;
            if (j10 == this.end) {
                return null;
            }
            this.index = 1 + j10;
            return Long.valueOf(j10);
        }
    }

    public static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final ConditionalSubscriber<? super Long> downstream;

        public RangeConditionalSubscription(ConditionalSubscriber<? super Long> conditionalSubscriber, long j10, long j11) {
            super(j10, j11);
            this.downstream = conditionalSubscriber;
        }

        public void fastPath() {
            long j10 = this.end;
            ConditionalSubscriber<? super Long> conditionalSubscriber = this.downstream;
            long j11 = this.index;
            while (j11 != j10) {
                if (!this.cancelled) {
                    conditionalSubscriber.tryOnNext(Long.valueOf(j11));
                    j11++;
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                conditionalSubscriber.onComplete();
            }
        }

        public void slowPath(long j10) {
            long j11 = this.end;
            long j12 = this.index;
            ConditionalSubscriber<? super Long> conditionalSubscriber = this.downstream;
            do {
                long j13 = 0;
                while (true) {
                    if (j13 == j10 || j12 == j11) {
                        if (j12 != j11) {
                            j10 = get();
                            if (j13 == j10) {
                                this.index = j12;
                                j10 = addAndGet(-j13);
                            }
                        } else if (!this.cancelled) {
                            conditionalSubscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.cancelled) {
                        if (conditionalSubscriber.tryOnNext(Long.valueOf(j12))) {
                            j13++;
                        }
                        j12++;
                    } else {
                        return;
                    }
                }
            } while (j10 != 0);
        }
    }

    public static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final c downstream;

        public RangeSubscription(c cVar, long j10, long j11) {
            super(j10, j11);
            this.downstream = cVar;
        }

        public void fastPath() {
            long j10 = this.end;
            c cVar = this.downstream;
            long j11 = this.index;
            while (j11 != j10) {
                if (!this.cancelled) {
                    cVar.onNext(Long.valueOf(j11));
                    j11++;
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                cVar.onComplete();
            }
        }

        public void slowPath(long j10) {
            long j11 = this.end;
            long j12 = this.index;
            c cVar = this.downstream;
            do {
                long j13 = 0;
                while (true) {
                    if (j13 == j10 || j12 == j11) {
                        if (j12 != j11) {
                            j10 = get();
                            if (j13 == j10) {
                                this.index = j12;
                                j10 = addAndGet(-j13);
                            }
                        } else if (!this.cancelled) {
                            cVar.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.cancelled) {
                        cVar.onNext(Long.valueOf(j12));
                        j13++;
                        j12++;
                    } else {
                        return;
                    }
                }
            } while (j10 != 0);
        }
    }

    public FlowableRangeLong(long j10, long j11) {
        this.start = j10;
        this.end = j10 + j11;
    }

    public void subscribeActual(c cVar) {
        if (cVar instanceof ConditionalSubscriber) {
            cVar.onSubscribe(new RangeConditionalSubscription((ConditionalSubscriber) cVar, this.start, this.end));
            return;
        }
        cVar.onSubscribe(new RangeSubscription(cVar, this.start, this.end));
    }
}
