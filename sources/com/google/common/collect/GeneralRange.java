package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.soap.SOAP;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.CheckForNull;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
final class GeneralRange<T> implements Serializable {
    private final Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final BoundType lowerBoundType;
    @CheckForNull
    private final T lowerEndpoint;
    @CheckForNull
    private transient GeneralRange<T> reverse;
    private final BoundType upperBoundType;
    @CheckForNull
    private final T upperEndpoint;

    private GeneralRange(Comparator<? super T> comparator2, boolean z10, @CheckForNull T t10, BoundType boundType, boolean z11, @CheckForNull T t11, BoundType boundType2) {
        boolean z12;
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator2);
        this.hasLowerBound = z10;
        this.hasUpperBound = z11;
        this.lowerEndpoint = t10;
        this.lowerBoundType = (BoundType) Preconditions.checkNotNull(boundType);
        this.upperEndpoint = t11;
        this.upperBoundType = (BoundType) Preconditions.checkNotNull(boundType2);
        if (z10) {
            comparator2.compare(NullnessCasts.uncheckedCastNullableTToT(t10), NullnessCasts.uncheckedCastNullableTToT(t10));
        }
        if (z11) {
            comparator2.compare(NullnessCasts.uncheckedCastNullableTToT(t11), NullnessCasts.uncheckedCastNullableTToT(t11));
        }
        if (z10 && z11) {
            int compare = comparator2.compare(NullnessCasts.uncheckedCastNullableTToT(t10), NullnessCasts.uncheckedCastNullableTToT(t11));
            boolean z13 = true;
            if (compare <= 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            Preconditions.checkArgument(z12, "lowerEndpoint (%s) > upperEndpoint (%s)", (Object) t10, (Object) t11);
            if (compare == 0) {
                BoundType boundType3 = BoundType.OPEN;
                if (boundType == boundType3 && boundType2 == boundType3) {
                    z13 = false;
                }
                Preconditions.checkArgument(z13);
            }
        }
    }

    public static <T> GeneralRange<T> all(Comparator<? super T> comparator2) {
        BoundType boundType = BoundType.OPEN;
        return new GeneralRange(comparator2, false, (Object) null, boundType, false, (Object) null, boundType);
    }

    public static <T> GeneralRange<T> downTo(Comparator<? super T> comparator2, @ParametricNullness T t10, BoundType boundType) {
        return new GeneralRange(comparator2, true, t10, boundType, false, (T) null, BoundType.OPEN);
    }

    public static <T extends Comparable> GeneralRange<T> from(Range<T> range) {
        T t10;
        BoundType boundType;
        BoundType boundType2;
        T t11 = null;
        if (range.hasLowerBound()) {
            t10 = range.lowerEndpoint();
        } else {
            t10 = null;
        }
        if (range.hasLowerBound()) {
            boundType = range.lowerBoundType();
        } else {
            boundType = BoundType.OPEN;
        }
        BoundType boundType3 = boundType;
        if (range.hasUpperBound()) {
            t11 = range.upperEndpoint();
        }
        T t12 = t11;
        if (range.hasUpperBound()) {
            boundType2 = range.upperBoundType();
        } else {
            boundType2 = BoundType.OPEN;
        }
        return new GeneralRange(Ordering.natural(), range.hasLowerBound(), t10, boundType3, range.hasUpperBound(), t12, boundType2);
    }

    public static <T> GeneralRange<T> range(Comparator<? super T> comparator2, @ParametricNullness T t10, BoundType boundType, @ParametricNullness T t11, BoundType boundType2) {
        return new GeneralRange(comparator2, true, t10, boundType, true, t11, boundType2);
    }

    public static <T> GeneralRange<T> upTo(Comparator<? super T> comparator2, @ParametricNullness T t10, BoundType boundType) {
        return new GeneralRange(comparator2, false, (Object) null, BoundType.OPEN, true, t10, boundType);
    }

    public Comparator<? super T> comparator() {
        return this.comparator;
    }

    public boolean contains(@ParametricNullness T t10) {
        if (tooLow(t10) || tooHigh(t10)) {
            return false;
        }
        return true;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof GeneralRange)) {
            return false;
        }
        GeneralRange generalRange = (GeneralRange) obj;
        if (!this.comparator.equals(generalRange.comparator) || this.hasLowerBound != generalRange.hasLowerBound || this.hasUpperBound != generalRange.hasUpperBound || !getLowerBoundType().equals(generalRange.getLowerBoundType()) || !getUpperBoundType().equals(generalRange.getUpperBoundType()) || !Objects.equal(getLowerEndpoint(), generalRange.getLowerEndpoint()) || !Objects.equal(getUpperEndpoint(), generalRange.getUpperEndpoint())) {
            return false;
        }
        return true;
    }

    public BoundType getLowerBoundType() {
        return this.lowerBoundType;
    }

    @CheckForNull
    public T getLowerEndpoint() {
        return this.lowerEndpoint;
    }

    public BoundType getUpperBoundType() {
        return this.upperBoundType;
    }

    @CheckForNull
    public T getUpperEndpoint() {
        return this.upperEndpoint;
    }

    public boolean hasLowerBound() {
        return this.hasLowerBound;
    }

    public boolean hasUpperBound() {
        return this.hasUpperBound;
    }

    public int hashCode() {
        return Objects.hashCode(this.comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType());
    }

    public GeneralRange<T> intersect(GeneralRange<T> generalRange) {
        BoundType boundType;
        BoundType boundType2;
        T t10;
        int compare;
        BoundType boundType3;
        int compare2;
        int compare3;
        Preconditions.checkNotNull(generalRange);
        Preconditions.checkArgument(this.comparator.equals(generalRange.comparator));
        boolean z10 = this.hasLowerBound;
        T lowerEndpoint2 = getLowerEndpoint();
        BoundType lowerBoundType2 = getLowerBoundType();
        if (!hasLowerBound()) {
            z10 = generalRange.hasLowerBound;
            lowerEndpoint2 = generalRange.getLowerEndpoint();
            lowerBoundType2 = generalRange.getLowerBoundType();
        } else if (generalRange.hasLowerBound() && ((compare3 = this.comparator.compare(getLowerEndpoint(), generalRange.getLowerEndpoint())) < 0 || (compare3 == 0 && generalRange.getLowerBoundType() == BoundType.OPEN))) {
            lowerEndpoint2 = generalRange.getLowerEndpoint();
            lowerBoundType2 = generalRange.getLowerBoundType();
        }
        boolean z11 = z10;
        boolean z12 = this.hasUpperBound;
        T upperEndpoint2 = getUpperEndpoint();
        BoundType upperBoundType2 = getUpperBoundType();
        if (!hasUpperBound()) {
            z12 = generalRange.hasUpperBound;
            upperEndpoint2 = generalRange.getUpperEndpoint();
            upperBoundType2 = generalRange.getUpperBoundType();
        } else if (generalRange.hasUpperBound() && ((compare2 = this.comparator.compare(getUpperEndpoint(), generalRange.getUpperEndpoint())) > 0 || (compare2 == 0 && generalRange.getUpperBoundType() == BoundType.OPEN))) {
            upperEndpoint2 = generalRange.getUpperEndpoint();
            upperBoundType2 = generalRange.getUpperBoundType();
        }
        boolean z13 = z12;
        T t11 = upperEndpoint2;
        if (!z11 || !z13 || ((compare = this.comparator.compare(lowerEndpoint2, t11)) <= 0 && !(compare == 0 && lowerBoundType2 == (boundType3 = BoundType.OPEN) && upperBoundType2 == boundType3))) {
            t10 = lowerEndpoint2;
            boundType2 = lowerBoundType2;
            boundType = upperBoundType2;
        } else {
            boundType2 = BoundType.OPEN;
            boundType = BoundType.CLOSED;
            t10 = t11;
        }
        return new GeneralRange(this.comparator, z11, t10, boundType2, z13, t11, boundType);
    }

    public boolean isEmpty() {
        if ((!hasUpperBound() || !tooLow(NullnessCasts.uncheckedCastNullableTToT(getUpperEndpoint()))) && (!hasLowerBound() || !tooHigh(NullnessCasts.uncheckedCastNullableTToT(getLowerEndpoint())))) {
            return false;
        }
        return true;
    }

    public GeneralRange<T> reverse() {
        GeneralRange<T> generalRange = this.reverse;
        if (generalRange != null) {
            return generalRange;
        }
        GeneralRange generalRange2 = new GeneralRange(Ordering.from(this.comparator).reverse(), this.hasUpperBound, getUpperEndpoint(), getUpperBoundType(), this.hasLowerBound, getLowerEndpoint(), getLowerBoundType());
        generalRange2.reverse = this;
        this.reverse = generalRange2;
        return generalRange2;
    }

    public String toString() {
        char c10;
        T t10;
        T t11;
        char c11;
        String valueOf = String.valueOf(this.comparator);
        BoundType boundType = this.lowerBoundType;
        BoundType boundType2 = BoundType.CLOSED;
        if (boundType == boundType2) {
            c10 = '[';
        } else {
            c10 = ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN;
        }
        if (this.hasLowerBound) {
            t10 = this.lowerEndpoint;
        } else {
            t10 = "-∞";
        }
        String valueOf2 = String.valueOf(t10);
        if (this.hasUpperBound) {
            t11 = this.upperEndpoint;
        } else {
            t11 = "∞";
        }
        String valueOf3 = String.valueOf(t11);
        if (this.upperBoundType == boundType2) {
            c11 = ']';
        } else {
            c11 = ASCIIPropertyListParser.ARRAY_END_TOKEN;
        }
        StringBuilder sb = new StringBuilder(valueOf.length() + 4 + valueOf2.length() + valueOf3.length());
        sb.append(valueOf);
        sb.append(SOAP.DELIM);
        sb.append(c10);
        sb.append(valueOf2);
        sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
        sb.append(valueOf3);
        sb.append(c11);
        return sb.toString();
    }

    public boolean tooHigh(@ParametricNullness T t10) {
        boolean z10;
        boolean z11;
        boolean z12 = false;
        if (!hasUpperBound()) {
            return false;
        }
        int compare = this.comparator.compare(t10, NullnessCasts.uncheckedCastNullableTToT(getUpperEndpoint()));
        if (compare > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (compare == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (getUpperBoundType() == BoundType.OPEN) {
            z12 = true;
        }
        return (z11 & z12) | z10;
    }

    public boolean tooLow(@ParametricNullness T t10) {
        boolean z10;
        boolean z11;
        boolean z12 = false;
        if (!hasLowerBound()) {
            return false;
        }
        int compare = this.comparator.compare(t10, NullnessCasts.uncheckedCastNullableTToT(getLowerEndpoint()));
        if (compare < 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (compare == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (getLowerBoundType() == BoundType.OPEN) {
            z12 = true;
        }
        return (z11 & z12) | z10;
    }
}
