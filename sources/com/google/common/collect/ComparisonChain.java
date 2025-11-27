package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.Comparator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ComparisonChain {
    /* access modifiers changed from: private */
    public static final ComparisonChain ACTIVE = new ComparisonChain() {
        public ComparisonChain classify(int i10) {
            if (i10 < 0) {
                return ComparisonChain.LESS;
            }
            if (i10 > 0) {
                return ComparisonChain.GREATER;
            }
            return ComparisonChain.ACTIVE;
        }

        public ComparisonChain compare(Comparable<?> comparable, Comparable<?> comparable2) {
            return classify(comparable.compareTo(comparable2));
        }

        public ComparisonChain compareFalseFirst(boolean z10, boolean z11) {
            return classify(Booleans.compare(z10, z11));
        }

        public ComparisonChain compareTrueFirst(boolean z10, boolean z11) {
            return classify(Booleans.compare(z11, z10));
        }

        public int result() {
            return 0;
        }

        public <T> ComparisonChain compare(@ParametricNullness T t10, @ParametricNullness T t11, Comparator<T> comparator) {
            return classify(comparator.compare(t10, t11));
        }

        public ComparisonChain compare(int i10, int i11) {
            return classify(Ints.compare(i10, i11));
        }

        public ComparisonChain compare(long j10, long j11) {
            return classify(Longs.compare(j10, j11));
        }

        public ComparisonChain compare(float f10, float f11) {
            return classify(Float.compare(f10, f11));
        }

        public ComparisonChain compare(double d10, double d11) {
            return classify(Double.compare(d10, d11));
        }
    };
    /* access modifiers changed from: private */
    public static final ComparisonChain GREATER = new InactiveComparisonChain(1);
    /* access modifiers changed from: private */
    public static final ComparisonChain LESS = new InactiveComparisonChain(-1);

    public static final class InactiveComparisonChain extends ComparisonChain {
        final int result;

        public InactiveComparisonChain(int i10) {
            super();
            this.result = i10;
        }

        public ComparisonChain compare(double d10, double d11) {
            return this;
        }

        public ComparisonChain compareFalseFirst(boolean z10, boolean z11) {
            return this;
        }

        public ComparisonChain compareTrueFirst(boolean z10, boolean z11) {
            return this;
        }

        public int result() {
            return this.result;
        }

        public ComparisonChain compare(float f10, float f11) {
            return this;
        }

        public ComparisonChain compare(int i10, int i11) {
            return this;
        }

        public ComparisonChain compare(long j10, long j11) {
            return this;
        }

        public ComparisonChain compare(Comparable<?> comparable, Comparable<?> comparable2) {
            return this;
        }

        public <T> ComparisonChain compare(@ParametricNullness T t10, @ParametricNullness T t11, Comparator<T> comparator) {
            return this;
        }
    }

    private ComparisonChain() {
    }

    public static ComparisonChain start() {
        return ACTIVE;
    }

    public abstract ComparisonChain compare(double d10, double d11);

    public abstract ComparisonChain compare(float f10, float f11);

    public abstract ComparisonChain compare(int i10, int i11);

    public abstract ComparisonChain compare(long j10, long j11);

    @Deprecated
    public final ComparisonChain compare(Boolean bool, Boolean bool2) {
        return compareFalseFirst(bool.booleanValue(), bool2.booleanValue());
    }

    public abstract ComparisonChain compare(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract <T> ComparisonChain compare(@ParametricNullness T t10, @ParametricNullness T t11, Comparator<T> comparator);

    public abstract ComparisonChain compareFalseFirst(boolean z10, boolean z11);

    public abstract ComparisonChain compareTrueFirst(boolean z10, boolean z11);

    public abstract int result();
}
