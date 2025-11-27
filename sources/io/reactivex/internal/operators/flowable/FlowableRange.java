package io.reactivex.internal.operators.flowable;

import fb.c;
import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;

public final class FlowableRange extends Flowable<Integer> {
    final int end;
    final int start;

    public static abstract class BaseRangeSubscription extends BasicQueueSubscription<Integer> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final int end;
        int index;

        public BaseRangeSubscription(int i10, int i11) {
            this.index = i10;
            this.end = i11;
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
        public final Integer poll() {
            int i10 = this.index;
            if (i10 == this.end) {
                return null;
            }
            this.index = i10 + 1;
            return Integer.valueOf(i10);
        }
    }

    public static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final ConditionalSubscriber<? super Integer> downstream;

        public RangeConditionalSubscription(ConditionalSubscriber<? super Integer> conditionalSubscriber, int i10, int i11) {
            super(i10, i11);
            this.downstream = conditionalSubscriber;
        }

        public void fastPath() {
            int i10 = this.end;
            ConditionalSubscriber<? super Integer> conditionalSubscriber = this.downstream;
            int i11 = this.index;
            while (i11 != i10) {
                if (!this.cancelled) {
                    conditionalSubscriber.tryOnNext(Integer.valueOf(i11));
                    i11++;
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                conditionalSubscriber.onComplete();
            }
        }

        public void slowPath(long j10) {
            int i10 = this.end;
            int i11 = this.index;
            ConditionalSubscriber<? super Integer> conditionalSubscriber = this.downstream;
            do {
                long j11 = 0;
                while (true) {
                    if (j11 == j10 || i11 == i10) {
                        if (i11 != i10) {
                            j10 = get();
                            if (j11 == j10) {
                                this.index = i11;
                                j10 = addAndGet(-j11);
                            }
                        } else if (!this.cancelled) {
                            conditionalSubscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.cancelled) {
                        if (conditionalSubscriber.tryOnNext(Integer.valueOf(i11))) {
                            j11++;
                        }
                        i11++;
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

        public RangeSubscription(c cVar, int i10, int i11) {
            super(i10, i11);
            this.downstream = cVar;
        }

        public void fastPath() {
            int i10 = this.end;
            c cVar = this.downstream;
            int i11 = this.index;
            while (i11 != i10) {
                if (!this.cancelled) {
                    cVar.onNext(Integer.valueOf(i11));
                    i11++;
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                cVar.onComplete();
            }
        }

        public void slowPath(long j10) {
            int i10 = this.end;
            int i11 = this.index;
            c cVar = this.downstream;
            do {
                long j11 = 0;
                while (true) {
                    if (j11 == j10 || i11 == i10) {
                        if (i11 != i10) {
                            j10 = get();
                            if (j11 == j10) {
                                this.index = i11;
                                j10 = addAndGet(-j11);
                            }
                        } else if (!this.cancelled) {
                            cVar.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.cancelled) {
                        cVar.onNext(Integer.valueOf(i11));
                        j11++;
                        i11++;
                    } else {
                        return;
                    }
                }
            } while (j10 != 0);
        }
    }

    public FlowableRange(int i10, int i11) {
        this.start = i10;
        this.end = i10 + i11;
    }

    public void subscribeActual(c cVar) {
        if (cVar instanceof ConditionalSubscriber) {
            cVar.onSubscribe(new RangeConditionalSubscription((ConditionalSubscriber) cVar, this.start, this.end));
        } else {
            cVar.onSubscribe(new RangeSubscription(cVar, this.start, this.end));
        }
    }
}
