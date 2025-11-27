package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@Beta
public abstract class LinearTransformation {

    public static final class LinearTransformationBuilder {

        /* renamed from: x1  reason: collision with root package name */
        private final double f10111x1;

        /* renamed from: y1  reason: collision with root package name */
        private final double f10112y1;

        public LinearTransformation and(double d10, double d11) {
            boolean z10;
            boolean z11 = true;
            if (!DoubleUtils.isFinite(d10) || !DoubleUtils.isFinite(d11)) {
                z10 = false;
            } else {
                z10 = true;
            }
            Preconditions.checkArgument(z10);
            double d12 = this.f10111x1;
            if (d10 != d12) {
                return withSlope((d11 - this.f10112y1) / (d10 - d12));
            }
            if (d11 == this.f10112y1) {
                z11 = false;
            }
            Preconditions.checkArgument(z11);
            return new VerticalLinearTransformation(this.f10111x1);
        }

        public LinearTransformation withSlope(double d10) {
            Preconditions.checkArgument(!Double.isNaN(d10));
            if (DoubleUtils.isFinite(d10)) {
                return new RegularLinearTransformation(d10, this.f10112y1 - (this.f10111x1 * d10));
            }
            return new VerticalLinearTransformation(this.f10111x1);
        }

        private LinearTransformationBuilder(double d10, double d11) {
            this.f10111x1 = d10;
            this.f10112y1 = d11;
        }
    }

    public static final class NaNLinearTransformation extends LinearTransformation {
        static final NaNLinearTransformation INSTANCE = new NaNLinearTransformation();

        private NaNLinearTransformation() {
        }

        public LinearTransformation inverse() {
            return this;
        }

        public boolean isHorizontal() {
            return false;
        }

        public boolean isVertical() {
            return false;
        }

        public double slope() {
            return Double.NaN;
        }

        public String toString() {
            return "NaN";
        }

        public double transform(double d10) {
            return Double.NaN;
        }
    }

    public static LinearTransformation forNaN() {
        return NaNLinearTransformation.INSTANCE;
    }

    public static LinearTransformation horizontal(double d10) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d10));
        return new RegularLinearTransformation(0.0d, d10);
    }

    public static LinearTransformationBuilder mapping(double d10, double d11) {
        boolean z10;
        if (!DoubleUtils.isFinite(d10) || !DoubleUtils.isFinite(d11)) {
            z10 = false;
        } else {
            z10 = true;
        }
        Preconditions.checkArgument(z10);
        return new LinearTransformationBuilder(d10, d11);
    }

    public static LinearTransformation vertical(double d10) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d10));
        return new VerticalLinearTransformation(d10);
    }

    public abstract LinearTransformation inverse();

    public abstract boolean isHorizontal();

    public abstract boolean isVertical();

    public abstract double slope();

    public abstract double transform(double d10);

    public static final class VerticalLinearTransformation extends LinearTransformation {
        @CheckForNull
        @LazyInit
        LinearTransformation inverse;

        /* renamed from: x  reason: collision with root package name */
        final double f10113x;

        public VerticalLinearTransformation(double d10) {
            this.f10113x = d10;
            this.inverse = null;
        }

        private LinearTransformation createInverse() {
            return new RegularLinearTransformation(0.0d, this.f10113x, this);
        }

        public LinearTransformation inverse() {
            LinearTransformation linearTransformation = this.inverse;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            LinearTransformation createInverse = createInverse();
            this.inverse = createInverse;
            return createInverse;
        }

        public boolean isHorizontal() {
            return false;
        }

        public boolean isVertical() {
            return true;
        }

        public double slope() {
            throw new IllegalStateException();
        }

        public String toString() {
            return String.format("x = %g", new Object[]{Double.valueOf(this.f10113x)});
        }

        public double transform(double d10) {
            throw new IllegalStateException();
        }

        public VerticalLinearTransformation(double d10, LinearTransformation linearTransformation) {
            this.f10113x = d10;
            this.inverse = linearTransformation;
        }
    }

    public static final class RegularLinearTransformation extends LinearTransformation {
        @CheckForNull
        @LazyInit
        LinearTransformation inverse;
        final double slope;
        final double yIntercept;

        public RegularLinearTransformation(double d10, double d11) {
            this.slope = d10;
            this.yIntercept = d11;
            this.inverse = null;
        }

        private LinearTransformation createInverse() {
            double d10 = this.slope;
            if (d10 != 0.0d) {
                return new RegularLinearTransformation(1.0d / d10, (this.yIntercept * -1.0d) / d10, this);
            }
            return new VerticalLinearTransformation(this.yIntercept, this);
        }

        public LinearTransformation inverse() {
            LinearTransformation linearTransformation = this.inverse;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            LinearTransformation createInverse = createInverse();
            this.inverse = createInverse;
            return createInverse;
        }

        public boolean isHorizontal() {
            if (this.slope == 0.0d) {
                return true;
            }
            return false;
        }

        public boolean isVertical() {
            return false;
        }

        public double slope() {
            return this.slope;
        }

        public String toString() {
            return String.format("y = %g * x + %g", new Object[]{Double.valueOf(this.slope), Double.valueOf(this.yIntercept)});
        }

        public double transform(double d10) {
            return (d10 * this.slope) + this.yIntercept;
        }

        public RegularLinearTransformation(double d10, double d11, LinearTransformation linearTransformation) {
            this.slope = d10;
            this.yIntercept = d11;
            this.inverse = linearTransformation;
        }
    }
}
